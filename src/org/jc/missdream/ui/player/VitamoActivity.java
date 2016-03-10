package org.jc.missdream.ui.player;

import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.MediaPlayer.OnInfoListener;
import io.vov.vitamio.Vitamio;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

import org.jc.missdream.R;
import org.jc.missdream.framework.BaseActivity;

import android.content.res.Configuration;
import android.view.Window;
import android.view.WindowManager;

/**
 * ��Ƶ���Ų���
 * @author jincai
 *
 */
public class VitamoActivity extends BaseActivity{
	VideoView mVideoView;
	
	@Override
	public void initView() {
		if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
			//����
			this.requestWindowFeature(Window.FEATURE_NO_TITLE);//ȥ��������
			this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//ȥ����Ϣ��
		}
		Vitamio.isInitialized(this);
		setContentView(R.layout.activity_player);
		playfunction();
	}
	
	void playfunction(){
		 String path = "";
		 
		 mVideoView = (VideoView) findViewById(R.id.vv_player);
		path="http://218.205.75.180/ws.acgvideo.com/3/12/6463559-1.mp4?wsTime=1457632584&wsSecret2=8b096e4199f800d2357064e128277ade&oi=2015061642&appkey=8e9fc618fbd41e28&or=2061576138&wshc_tag=0&wsts_tag=56e17d9a&wsid_tag=6f028b99&wsiphost=ipdbm";
     if (path == "") {
			// Tell the user to provide a media file URL/path.
			return;
		} else {
			/*
			 * Alternatively,for streaming media you can use
			 * mVideoView.setVideoURI(Uri.parse(URLstring));
			 */
			mVideoView.setVideoPath(path);
			mVideoView.setBufferSize(512*1024*2);
			if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
				//mVideoView.setMediaController(new MediaController(this),false);
				mVideoView.setMediaController(new MediaController(this));
			 }else {
				 mVideoView.setMediaController(new MediaController(this));
				// mVideoView.setVideoLayout(1, 1);
				// mVideoView.getHolder().setFixedSize(getWindow().getWindowManager()., height);
			}
			
			
			mVideoView.requestFocus();
			//��ƵԤ������ɺ����
			mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
				@Override
				public void onPrepared(MediaPlayer mediaPlayer) {
					// optional need Vitamio 4.0
					mediaPlayer.setPlaybackSpeed(1.0f);
				}
			});
			
			
			//������Ƶ����״̬��ʾ���ڼ��ؽ���
			mVideoView.setOnInfoListener(new OnInfoListener() {
				// �Ƿ���Ҫ�Զ��ָ����ţ������Զ���ͣ���ָ����� 
			    boolean needResume;
				@Override
				public boolean onInfo(MediaPlayer mp, int what, int extra) {
					switch (what) {
			        case MediaPlayer.MEDIA_INFO_BUFFERING_START:
			            //��ʼ���棬��ͣ����
			        	ShowToast("��ʼ����");
			            if (mVideoView.isPlaying()) {
			            	mVideoView.pause();
			                needResume = true;
			            }
			            //mLoadingView.setVisibility(View.VISIBLE);
			            break;
			        case MediaPlayer.MEDIA_INFO_BUFFERING_END:
			            //������ɣ���������
			        	ShowToast("�������");
			            if (needResume){
			            	mVideoView.resume();
			            	needResume = false;
			            }
			            //mLoadingView.setVisibility(View.GONE);
			            break;
			        case MediaPlayer.MEDIA_INFO_DOWNLOAD_RATE_CHANGED:
			            //��ʾ �����ٶ�
			            //Logger.e("download rate:" + arg2);
			            break;
			        }
			        return true;
				}
			});
		}
	}

}
