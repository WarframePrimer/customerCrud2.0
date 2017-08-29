package com.warframe.utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class EncodingUtils {
	//解决乱码问题
	public static Map<String, String[]> codeHandle(Map<String, String[]> map) throws IOException{
		Map<String,String[]> props = new HashMap<>(map.size());
		for(String key:map.keySet()){
			String[] values = map.get(key);
			String[] newValues = new String[values.length];
			for(int i = 0;i<values.length;i++){
				newValues[i] = new String(values[i].getBytes("ISO8859-1"),"utf-8");
			}
			
			props.put(key, newValues);
		}
		
		return props;
	}

}
