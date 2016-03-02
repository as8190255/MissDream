package org.jc.missdream.common;

public class FusionAction {
	
	/**
	 * 哔哩哔哩动作 
	 */
	public interface BiliAction{
		int BASE = 0x20000000;
		/**
		 * 根据时间段获取番剧
		 */
		int BANGUMIBYMONTH=BASE+4;
	}
}
