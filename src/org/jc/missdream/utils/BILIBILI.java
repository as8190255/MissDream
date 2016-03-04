package org.jc.missdream.utils;

import java.util.ArrayList;
import java.util.List;

import org.jc.missdream.bean.C_Search_Result;
import org.jc.missdream.bean.Search_Result_Item;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * 哔哩哔哩公交
 * @author jincai
 */
public class BILIBILI {
	
	/**
	 * 根据关键词搜索哔哩哔哩番剧 
	 * @param html 源码
	 * @return 模型
	 */
	public static List<C_Search_Result> parseResultByKey(String html){
		List<C_Search_Result> results=null;
		Document doc=Jsoup.parse(html);
		Element element=doc.getElementById("episode");//整体搜索结果
		if (element==null) {//无数据
			return results;
		}
		Elements links=element.getElementsByClass("list");//各个番剧结果
		results=new ArrayList<C_Search_Result>();
		C_Search_Result result=new C_Search_Result();
		for (Element ele : links) {
			//<图片>
			Element ele3=ele.select("div.img").first();
			//info 可能没有
			if (ele3.select("span.info").size()>0) {
				result.setInfo(ele3.select("span.info").first().text());
			}
			//a标签
			//Element ele_a=ele3.select("a").first();
			//该番剧的主页面
			result.setUrl(ele3.select("a").first().attr("href"));
			//该番剧的头像
			result.setImg(ele3.select("a").first().select("img").first().attr("src"));
			//<文字标题>
			Element ele_h3=ele.select("h3").first();
			//番剧标题
			result.setTitle(ele_h3.select("a").first().text());
			//年份
			result.setYear(ele.select("span.year").first().text());
			//介绍
			result.setDetail(ele.select("p").first().text());
			//各集数据
			Element ele_li=ele.getElementsByClass("episode-list").first();
			Elements ele_lis=ele_li.select("a");
			if (ele_lis.size()<=0) {
				//无各集数据
			}else {
				//有数据
				result.setLists(new ArrayList<Search_Result_Item>());
				for (Element element2 : ele_lis) {
					System.out.println(" →"+element2.attr("href")+"→"+element2.text());
					Search_Result_Item item=new Search_Result_Item();
					item.setUrl(element2.attr("href"));
					item.setNumber(element2.text());
					result.getLists().add(item);
				}
			}
			results.add(result);
		}
		return results;
	}
}
