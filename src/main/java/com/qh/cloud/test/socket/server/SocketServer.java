package com.qh.cloud.test.socket.server;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description 服务端
 * @Date 2017年7月12日 下午2:01:47
 * @author QingHang
 * @version 1.0.0
 */
public class SocketServer {

	private int port;

	private volatile boolean running = false;

	private long receiveTimeDelay = 3000;

	private ConcurrentHashMap<Class, ObjectAction> actionMapping = new ConcurrentHashMap<Class, ObjectAction>();

	private Thread connWatchDog;

}
