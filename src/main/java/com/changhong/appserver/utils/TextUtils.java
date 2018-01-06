package com.changhong.appserver.utils;

public class TextUtils {

	public  static boolean isEmpty(Object obj) {
		if(null==obj) {
			return true;
		}else {
			if("".equals(obj.toString())) {
				return true;
			}else {
				return false;
			}
		}
	}
}
