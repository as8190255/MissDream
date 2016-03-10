package org.jc.missdream.ui.player;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;

import master.flame.danmaku.controller.IDanmakuView;
import master.flame.danmaku.danmaku.loader.ILoader;
import master.flame.danmaku.danmaku.loader.IllegalDataException;
import master.flame.danmaku.danmaku.loader.android.DanmakuLoaderFactory;
import master.flame.danmaku.danmaku.model.BaseDanmaku;
import master.flame.danmaku.danmaku.model.DanmakuTimer;
import master.flame.danmaku.danmaku.model.IDanmakus;
import master.flame.danmaku.danmaku.model.IDisplayer;
import master.flame.danmaku.danmaku.model.android.BaseCacheStuffer;
import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.danmaku.model.android.Danmakus;
import master.flame.danmaku.danmaku.model.android.SpannedCacheStuffer;
import master.flame.danmaku.danmaku.parser.BaseDanmakuParser;
import master.flame.danmaku.danmaku.parser.IDataSource;
import master.flame.danmaku.danmaku.parser.android.BiliDanmukuParser;

import org.apache.http.client.entity.DeflateInputStream;
import org.jc.missdream.R;
import org.jc.missdream.framework.BaseActivity;

import android.R.integer;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Environment;
import android.text.Spanned;
import android.util.Log;
import android.view.View;

/**
 * 弹幕测试
 * @author jincai
 */
public class DanMuActivity extends BaseActivity{
	private DanmakuContext mContext;
	private IDanmakuView mDanmakuView;
	 private BaseDanmakuParser mParser;
	
	@Override
	public void initView() {
		setContentView(R.layout.activity_danmu);
		
		new AsyncTask<Void, Void, Boolean>() {

			@Override
			protected Boolean doInBackground(Void... params) {
				
				return getComment("http://comment.bilibili.tv/6519784.xml",Environment.getExternalStorageDirectory().getPath()+"/1111.xml");
			}
			@Override
			protected void onPostExecute(Boolean result) {
				super.onPostExecute(result);
				startDanmu(Environment.getExternalStorageDirectory().getPath()+"/1111.xml");
			}
		}.execute();
	}
	
	
	
	/**
	 * 服务器获取弹幕
	 * @param url
	 * @return
	 */
	public boolean getComment(String url,String path){
		URL realUrl;
		try {
			realUrl = new URL(url);
			URLConnection connection = realUrl.openConnection();
			connection.connect();
			InputStream urlStream = connection.getInputStream();  
			InputStream in= new DeflateInputStream(urlStream);
			// 1K的数据缓冲   
	         byte[] bs = new byte[1024];   
	         // 读取到的数据长度   
	         int len;   
	      // 输出的文件流   
	         OutputStream os = new FileOutputStream(path); 
	      // 开始读取   
	         while ((len = in.read(bs)) != -1) {   
	             os.write(bs, 0, len);   
	         }  
	      // 完毕，关闭所有链接   
	         os.close();  
	         in.close();
	         return true;
		} catch (MalformedURLException e) {
			return false;
		} catch (IOException e) {
			return false;
		}
	}
	
	/**
	 * 开始加载弹幕
	 */
	public void startDanmu(String path) {
		 // 设置最大显示行数
        HashMap<Integer, Integer> maxLinesPair = new HashMap<Integer, Integer>();
        maxLinesPair.put(BaseDanmaku.TYPE_SCROLL_RL, 5); // 滚动弹幕最大显示3行
     // 设置是否禁止重叠
        HashMap<Integer, Boolean> overlappingEnablePair = new HashMap<Integer, Boolean>();
        overlappingEnablePair.put(BaseDanmaku.TYPE_SCROLL_RL, true);
        overlappingEnablePair.put(BaseDanmaku.TYPE_FIX_TOP, true);
        mDanmakuView = (IDanmakuView) findViewById(R.id.sv_danmaku);
        mContext = DanmakuContext.create();
        mContext.setDanmakuStyle(IDisplayer.DANMAKU_STYLE_STROKEN, 3).setDuplicateMergingEnabled(false).setScrollSpeedFactor(1.2f).setScaleTextSize(1.2f)
       // .setCacheStuffer(new SpannedCacheStuffer(), mCacheStufferAdapter) // 图文混排使用SpannedCacheStuffer
//        .setCacheStuffer(new BackgroundCacheStuffer())  // 绘制背景使用BackgroundCacheStuffer
        .setMaximumLines(maxLinesPair)
        .preventOverlapping(overlappingEnablePair);

        if (mDanmakuView != null) {
        	//此处加载本地的xml流文件
        	try {
				mParser = createParser(new FileInputStream(path));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
            mDanmakuView.setCallback(new master.flame.danmaku.controller.DrawHandler.Callback() {
                @Override
                public void updateTimer(DanmakuTimer timer) {
                }

                @Override
                public void drawingFinished() {

                }

                @Override
                public void danmakuShown(BaseDanmaku danmaku) {
//                    Log.d("DFM", "danmakuShown(): text=" + danmaku.text);
                }

                @Override
                public void prepared() {
                    mDanmakuView.start();
                }
            });
            mDanmakuView.setOnDanmakuClickListener(new IDanmakuView.OnDanmakuClickListener() {
                @Override
                public void onDanmakuClick(BaseDanmaku latest) {
                    Log.d("DFM", "onDanmakuClick text:" + latest.text);
                }

                @Override
                public void onDanmakuClick(IDanmakus danmakus) {
                    Log.d("DFM", "onDanmakuClick danmakus size:" + danmakus.size());
                }
            });
            mDanmakuView.prepare(mParser, mContext);
           // mDanmakuView.showFPS(true);
           // mDanmakuView.enableDanmakuDrawingCache(true);
            ((View) mDanmakuView).setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                   // mMediaController.setVisibility(View.VISIBLE);
                }
            });
        }
	}
	
	
	
	
	@Deprecated
	static String sendGet(String url) {
        String result = "";
          BufferedReader in = null ;
        try {
            URL realUrl = new URL(url);
            URLConnection connection = realUrl.openConnection();
            connection.connect();
            InputStream urlStream = connection.getInputStream();  
             in = new BufferedReader(new InputStreamReader(new DeflateInputStream(urlStream),"UTF-8")); 
            String line = "";  
            while ((line = in.readLine()) != null) {
                System.out.println(line);
                result += line;
            }
 
        } catch (MalformedURLException e) {
            System.out.print("发送GET请求出现异常！" + e);
            e.printStackTrace();
        } catch (IOException e) {
			e.printStackTrace();
		} finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }
	
	
	private BaseDanmakuParser createParser(InputStream stream) {

        if (stream == null) {
            return new BaseDanmakuParser() {
                @Override
                protected Danmakus parse() {
                    return new Danmakus();
                }
            };
        }

        ILoader loader = DanmakuLoaderFactory.create(DanmakuLoaderFactory.TAG_BILI);

        try {
            loader.load(stream);
        } catch (IllegalDataException e) {
            e.printStackTrace();
        }
        BaseDanmakuParser parser = new BiliDanmukuParser();
        IDataSource<?> dataSource = loader.getDataSource();
        parser.load(dataSource);
        return parser;

    }
	
}
