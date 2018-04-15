package com.qh.cloud.test.netty.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @Description Handles a server-side channel.
 * @Date 2017年7月12日 下午5:48:30
 * @author QingHang
 * @version 1.0.0
 */
public class EchoServerHandler extends ChannelInboundHandlerAdapter {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) { // (2)
		logger.info("server channel read...");

		ByteBuf buf = (ByteBuf) msg;
		byte[] req = new byte[buf.readableBytes()];
		buf.readBytes(req);
		try {
			String body = new String(req, "UTF-8");
			logger.info("server channel read msg:{}", body);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("这个客户端 断开了连接");
		}

		String response = "你好，欢迎来访。。。";
		ByteBuf resp = Unpooled.copiedBuffer(response.getBytes());
		ctx.write(resp);
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		logger.info("server channel read complete");
		ctx.flush();
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) { // (4)
		// Close the connection when an exception is raised.
		logger.error("server caught exception", cause);
		ctx.close();
	}
}
