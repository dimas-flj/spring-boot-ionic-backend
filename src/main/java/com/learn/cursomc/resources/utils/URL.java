package com.learn.cursomc.resources.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class URL {
	public static String decodeParam(String param) {
		try {
			return URLDecoder.decode(param, "UTF-8");
		}
		catch(UnsupportedEncodingException e1) {
			return "";
		}
	}
	
	public static List<Integer> decodeIntList(String ids) {
		return Arrays.asList(ids.split(",")).stream().map(x -> Integer.parseInt(x)).collect(Collectors.toList());
	}
}