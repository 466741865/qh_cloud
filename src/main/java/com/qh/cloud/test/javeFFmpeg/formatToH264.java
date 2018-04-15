package com.qh.cloud.test.javeFFmpeg;

import java.io.File;

import it.sauronsoftware.jave.AudioAttributes;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.EncodingAttributes;
import it.sauronsoftware.jave.InputFormatException;
import it.sauronsoftware.jave.VideoAttributes;
import it.sauronsoftware.jave.VideoSize;

/**
 * @Description 转视频编解码格式
 * @Date 2017年11月17日 下午2:22:46
 * @author QingHang
 * @version 1.0.0
 */
public class formatToH264 {

	public static void main(String[] args) throws IllegalArgumentException, InputFormatException, EncoderException {
		toH264();
		// Encoder encoder = new Encoder();
		// String[] strings = encoder.getSupportedEncodingFormats();
		// System.out.println();
	}

	public static void toH264() throws IllegalArgumentException, InputFormatException, EncoderException {
		File source = new File("D:\\新年好呀新年.mp4");
		File target = new File("D:\\mp4\\1234.mp4");
		AudioAttributes audio = new AudioAttributes();
		audio.setCodec("libmp3lame");
		audio.setBitRate(new Integer(64000));
		audio.setChannels(new Integer(1));
		audio.setSamplingRate(new Integer(22050));
		VideoAttributes video = new VideoAttributes();
		video.setCodec("libx264");
		video.setBitRate(new Integer(160000));
		video.setFrameRate(new Integer(15));
		video.setSize(new VideoSize(400, 300));
		EncodingAttributes attrs = new EncodingAttributes();
		attrs.setFormat("mp4");
		attrs.setAudioAttributes(audio);
		attrs.setVideoAttributes(video);
		Encoder encoder = new Encoder();
		encoder.encode(source, target, attrs);
	}

}
