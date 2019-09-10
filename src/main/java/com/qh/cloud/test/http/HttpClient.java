package com.qh.cloud.test.http;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentProducer;
import org.apache.http.entity.EntityTemplate;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HttpClient {
	/**
	 * 常量 log.
	 */
	private static org.slf4j.Logger log = LoggerFactory.getLogger(HttpClient.class);
	private HttpClient(){

	}

	public static String httpClientPost(String url) {
		DefaultHttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost(url);
		post.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 5000);//请求超时
		post.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 6000);//读取超时
		try {
			ContentProducer cp = new ContentProducer() {
				public void writeTo(OutputStream outstream) throws IOException {
					Writer writer = new OutputStreamWriter(outstream, "UTF-8");
					writer.write("");
					writer.flush();
				}
			};
			post.setEntity(new EntityTemplate(cp));
			HttpResponse response = client.execute(post);
			String ret = EntityUtils.toString(response.getEntity());
			return ret;
		} catch (Exception e) {
			log.error("异常", e);
			return null;
		}
	}
	public static String httpClientGet(String url) {
		DefaultHttpClient client = new DefaultHttpClient();
		HttpGet get = new HttpGet(url);
		get.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 5000);//请求超时
		get.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 6000);//读取超时
		try {
			HttpResponse response = client.execute(get);
			if (response.getStatusLine().getStatusCode() == 200) {// 如果状态码为200,就是正常返回
				String ret = EntityUtils.toString(response.getEntity());
				if (ret == null) {
					return "";
				}
				return ret;
			}
			return "";
		} catch (Exception e) {
			log.error("异常", e);
			return null;
		}

	}



	public static String httpClientPost(String url, Map<String, String> params) {
		String result = "";
		HttpPost httppost = new HttpPost(url);
		log.info("~~~~~~~~url=" + url + "~~~~~~~~");
		List<NameValuePair> paramsPair = new ArrayList<NameValuePair>();
		// 设置Http Post数据
		if (params != null) {

			for (Map.Entry<String, String> entry : params.entrySet()) {
				NameValuePair pair = new BasicNameValuePair(entry.getKey(), entry.getValue());
				log.info("~~~~~~~~" + entry.getKey() + "=" + entry.getValue() + "~~~~~~~~");
				paramsPair.add(pair);
			}
		}
		try {
			httppost.setEntity(new UrlEncodedFormEntity(paramsPair, HTTP.UTF_8));
			DefaultHttpClient httpclient = new DefaultHttpClient();
			//设置超时时间
			httpclient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 15000);
			httpclient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 15000);
			HttpResponse response = httpclient.execute(httppost);
			// 上面两行可以得到指定的Header
			if (response.getStatusLine().getStatusCode() == 200) {// 如果状态码为200,就是正常返回
				result = EntityUtils.toString(response.getEntity());
				//result = new String(result.getBytes("ISO-8859-1"),"UTF-8");
				log.info("httpClientPost: url=" + url + " ,result =" + result);
			} else {
				log.error("httpClientPost error! url=" + url + " ,=" + response.getStatusLine().getStatusCode());
			}
		} catch (Exception e) {
			log.error("httpClientPost error", e);
		}
		return result;
	}




}
