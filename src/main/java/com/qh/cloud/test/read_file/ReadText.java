package com.qh.cloud.test.read_file;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * @Description 读取text文本
 * @Date 2017年6月29日 上午11:27:54
 * @author QingHang
 * @version 1.0.0
 */
public class ReadText {

	public static void main(String[] args) {
		String url = "http://192.168.6.42:8088" + "/edu_res" + "/conversation" + "/audio" + "/oracle.txt";

		String txtFile = readTxtFile(url);
		System.out.println("文本内容：：  " + txtFile);
	}

	public static String readTxtFile(String filePath) {

		String content = "";
		try {
			String encoding = "GBK";
			// File file = new File(filePath);
			URL url = new URL(filePath);
			URLConnection connection = url.openConnection();
			InputStream is = connection.getInputStream();
			if (is != null) {// 判断文件是否存在
				InputStreamReader reader = new InputStreamReader(is, encoding);
				BufferedReader bufferedReader = new BufferedReader(reader);
				String lineText = null;
				StringBuffer sb = new StringBuffer();
				while ((lineText = bufferedReader.readLine()) != null) {
					System.out.println(lineText);
					sb.append(lineText);
				}
				reader.close();
				return sb.toString();
			} else {
				System.out.println("没有找到文件");
				content = "没有找到文件";
			}
		} catch (Exception e) {
			System.out.println("读取文件出错");
			e.printStackTrace();
		}
		return content;
	}

}
