package com.qh.cloud.test.sshTest;

import java.io.IOException;

import ch.ethz.ssh2.ChannelCondition;
import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.ConnectionInfo;
import ch.ethz.ssh2.Session;

/**
 * @Description ssh 访问linux 服务器
 * @Date 2017年5月12日 下午10:31:15
 * @author QingHang
 * @version 1.0.0
 */
public class CommandRunner {

	public static String host = "192.168.6.40";

	public static String username = "root";

	public static String pwd = "gdkj2016";

	private static final int TIME_OUT = 1000 * 5 * 60;

	public static void main(String[] args) throws Exception {

		ssh();
	}

	public static void ssh() throws Exception {

		// 构造连接器
		Connection conn = new Connection(host);
		ConnectionInfo connect = conn.connect();// 获取链接
		boolean isAuth = conn.authenticateWithPassword(username, pwd);// 登录，返回boolean

		System.out.println("链接结果" + isAuth);

		if (!isAuth) {
			// 这里可做一些 相应的操作
			System.out.println("Linux 服务器验证失败！！");
			throw new Exception("Linux 服务器验证失败！！");
		} else {
			System.out.println("Linux 服务器验证成功！！");
		}
		copyFile(conn);

		// 验证成功
		// 开启会话
		// Session session = conn.openSession();
		// linux 命令

		// String cmd = "liqinghang -f /usr/local/nginx/logs/access.log -v 2";

		// session.execCommand(cmd);
		// 接收目标服务器上的控制台返回结果，读取br中的内容
		// InputStream in = new StreamGobbler(session.getStderr());
		// BufferedReader br = new BufferedReader(new InputStreamReader(in, "utf-8"));

		// StringBuffer sb = new StringBuffer();

		// String line = null;
		// while ((line = br.readLine()) != null) {
		// sb.append(line).append("\n");
		// }
		// 关闭会话
		// session.close();
		// System.out.println("结果：：" + line);

	}

	public static void copyFile(Connection conn) {
		Session session = null;
		try {
			session = conn.openSession();
			// 创建文件夹
			// String cmd = "cd /opt/sshTest/zipPackage ; mkdir lqh";
			// session.execCommand(cmd);

			String base_url = "/opt/mes_fan";
			String res_url1 = "/audio/1afb894ce9a34495b1a02adb85329db7.mp3";
			String res_url2 = "/picture/8be0b6ae4a8b4af2a8f6cae288a31dc8.jpg";
			String res_url3 = "/text/935db45045bd41a393abb40b65e44475.txt";
			String res_url4 = "/video/36ff57d5740f43e6a94022c1846e553a.mp4";
			// 复制文件
			StringBuffer cmd = new StringBuffer();
			cmd.append("zip -j  /opt/mes_fan/zipPackage/test1.zip ");
			cmd.append(base_url + res_url1 + " ");
			cmd.append(base_url + res_url2 + " ");
			cmd.append(base_url + res_url3 + " ");
			cmd.append(base_url + res_url4 + " ");
			System.out.println(cmd.toString());
			session.execCommand(cmd.toString());
			session.waitForCondition(ChannelCondition.EXIT_STATUS, TIME_OUT);
			System.out.println("outStr=" + session.getExitStatus());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if (session != null) {
				session.close();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

}
