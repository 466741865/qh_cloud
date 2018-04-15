package com.qh.cloud.test.audiotime;

import java.io.File;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.InputFormatException;
import it.sauronsoftware.jave.MultimediaInfo;

/**
 * @Description 获取音频时长
 * @Date 2017年8月21日 下午3:11:35
 * @author QingHang
 * @version 1.0.0
 */
public class AudioTime {

	public static void main(String[] args) throws InputFormatException, EncoderException {

		File f = new File("D\\:123456.mp3");

		MultipartFile file = (MultipartFile) f;

		String fileOldName = file.getOriginalFilename();

		long duration = 0;// 音频长度，秒

		CommonsMultipartFile cf = (CommonsMultipartFile) file;
		DiskFileItem fi = (DiskFileItem) cf.getFileItem();
		File source = fi.getStoreLocation();
		Encoder encoder = new Encoder();
		MultimediaInfo m = encoder.getInfo(source);
		long ls = m.getDuration();
		duration = ls / 1000;
		System.out.println("此视频时长为:" + ls / 60000 + "分" + (ls / 1000 - ls / 60000 * 60) + "秒！");
	}
}
