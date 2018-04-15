package com.qh.cloud.test.socket.server;

/**
 * @Description 要处理客户端发来的对象
 * @Date 2017年7月12日 下午1:59:44
 * @author QingHang
 * @version 1.0.0
 */
public interface ObjectAction {

	Object doAction(Object rev);
}
