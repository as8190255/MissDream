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
 * ������������
 * @author jincai
 */
public class BILIBILI {
	
	/**
	 * ���ݹؼ������������������� 
	 * @param html Դ��
	 * @return ģ��
	 */
	public static List<C_Search_Result> parseResultByKey(String html){
		List<C_Search_Result> results=null;
		Document doc=Jsoup.parse(html);
		Element element=doc.getElementById("episode");//�����������
		if (element==null) {//������
			return results;
		}
		Elements links=element.getElementsByClass("list");//����������
		results=new ArrayList<C_Search_Result>();
		C_Search_Result result=new C_Search_Result();
		for (Element ele : links) {
			//<ͼƬ>
			Element ele3=ele.select("div.img").first();
			//info ����û��
			if (ele3.select("span.info").size()>0) {
				result.setInfo(ele3.select("span.info").first().text());
			}
			//a��ǩ
			//Element ele_a=ele3.select("a").first();
			//�÷������ҳ��
			result.setUrl(ele3.select("a").first().attr("href"));
			//�÷����ͷ��
			result.setImg(ele3.select("a").first().select("img").first().attr("src"));
			//<���ֱ���>
			Element ele_h3=ele.select("h3").first();
			//�������
			result.setTitle(ele_h3.select("a").first().text());
			//���
			result.setYear(ele.select("span.year").first().text());
			//����
			result.setDetail(ele.select("p").first().text());
			//��������
			Element ele_li=ele.getElementsByClass("episode-list").first();
			Elements ele_lis=ele_li.select("a");
			if (ele_lis.size()<=0) {
				//�޸�������
			}else {
				//������
				result.setLists(new ArrayList<Search_Result_Item>());
				for (Element element2 : ele_lis) {
					System.out.println(" ��"+element2.attr("href")+"��"+element2.text());
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
