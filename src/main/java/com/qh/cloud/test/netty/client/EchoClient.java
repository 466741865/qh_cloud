package com.qh.cloud.test.netty.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qh.cloud.utils.Constants;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @Description netty 客户端
 * @Date 2017年7月12日 下午5:59:26
 * @author QingHang
 * @version 1.0.0
 */
public class EchoClient {
	private Logger logger = LoggerFactory.getLogger(getClass());

	private String host;

	private int port;

	public EchoClient(String host, int port) {
		this.host = host;
		this.port = port;
	}

	public void send(String content) throws InterruptedException {
		EventLoopGroup group = new NioEventLoopGroup();

		try {
			Bootstrap b = new Bootstrap();
			b.group(group).channel(NioSocketChannel.class).option(ChannelOption.TCP_NODELAY, true)
					.handler(new ChannelInitializer<SocketChannel>() {
						@Override
						protected void initChannel(SocketChannel ch) throws Exception {

							ChannelPipeline p = ch.pipeline();
							p.addLast(new EchoClientHandler(content));
						}
					});
			// Start the client.
			ChannelFuture f = b.connect(host, port).sync();

			logger.info("client connect to host:{}, port:{}", host, port);

			// Wait until the connection is closed.
			f.channel().closeFuture().sync();
		} finally {
			// Shut down the event loop to terminate all threads.
			group.shutdownGracefully();
		}

	}

	public static void main(String[] args) throws Exception {

		// 创建一个 缓存线程池，大小没有限制
		for (int i = 0; i < 10; i++) {
			new Thread() {
				public void run() {
					try {
						new EchoClient(Constants.HOST, Constants.PORT).send(",这是第" + "11" + "个客户端");
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}.start();// 开启线程
		}
	}
}
