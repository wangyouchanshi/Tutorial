package com.bwie.utils;

import org.apache.http.client.methods.HttpPost;

public class Firfox {

	public static void fire(HttpPost post){
		
		post.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8	");
		post.addHeader("Accept-Encoding", "gzip, deflate, br");
		post.addHeader("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
		post.addHeader("Connection", "keep-alive");
		post.addHeader("Host", "openapi.baidu.com");
		post.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.3; WOW64; rv:53.0) Gecko/20100101 Firefox/53.0");
	}
	
}
