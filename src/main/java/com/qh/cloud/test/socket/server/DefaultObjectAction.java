package com.qh.cloud.test.socket.server;

/**
 * @Description 处理客户端发来的对象
 * @Date 2017年7月12日 下午2:00:37
 * @author QingHang
 * @version 1.0.0
 */
public class DefaultObjectAction implements ObjectAction {

	@Override
	public Object doAction(Object rev) {
		System.out.println("处理，并返回" + rev);
		return null;
	}

}
