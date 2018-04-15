package com.qh.cloud.utils;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;
import org.apache.axis.types.Schema;

public class SoapUtil {
	private static String username = "38057";

	private static String password = "3966255";

	private static String startTime = "2001/01/01";

	private static String entTime = "2016/01/01";

	public static String getEMRHtml(String patientId, String eventNo, String catalogId) {
		String html = null;
		try {
			Service service = new Service();
			Call call = (Call) service.createCall();
			call.setSOAPActionURI("#BrowseEMR");
			call.setUseSOAPAction(true);
			call.setTransport(null);
			call.setTargetEndpointAddress("http://193.193.193.1:80/wszemr/wsZEMR.dll?Handler=PatientEMRService");
			call.setOperationName(new QName("http://www.zysoft.com.cn", "BrowseEMR"));
			call.addParameter("bstrUser", XMLType.SOAP_STRING, ParameterMode.IN);
			call.addParameter("bstrPwd", XMLType.SOAP_STRING, ParameterMode.IN);
			call.addParameter("bstrPatientID", XMLType.SOAP_STRING, ParameterMode.IN);
			call.addParameter("bstrEventNo", XMLType.SOAP_STRING, ParameterMode.IN);
			call.addParameter("lngCatalogID", XMLType.SOAP_INT, ParameterMode.IN);
			call.addParameter("bstrStartTime", XMLType.SOAP_STRING, ParameterMode.IN);
			call.addParameter("bstrEndTime", XMLType.SOAP_STRING, ParameterMode.IN);
			call.setReturnType(XMLType.SOAP_STRING);
			html = (String) call
					.invoke(new Object[] { username, password, patientId, eventNo, catalogId, startTime, entTime });
		} catch (Exception e) {
			e.printStackTrace();
		}
		return html;
	}

	// public static void main(String[] args) {
	// System.out.println("==========================================");
	// String html = getEMRHtml("0000206090", "20703203003", "4");
	// System.out.println(html);
	//
	// System.out.println("==========================================");
	//
	// }
	// public static void main(String[] args) throws Exception{
	// 1.jws
	// String targetEendPoint = "http://localhost:8080/axis/HelloAXIS.jws" ;
	// Service service = new Service();
	// Call call = (Call) service.createCall();
	// call.setOperationName( new QName(targetEendPoint, "Hello" ));
	// call.setTargetEndpointAddress( new URL(targetEendPoint));
	// String result = (String) call.invoke( new Object[]{ "Robert" });
	// System.out.println(result);
	// 2.String参数
	// String targetEendPoint = "http://localhost:8080/axis/services/HelloWorld" ;
	// Service service = new Service();
	// Call call = (Call) service.createCall();
	// call.setTargetEndpointAddress( new URL(targetEendPoint));
	// call.setOperationName( new QName(targetEendPoint, "hello" ));
	// String result = (String) call.invoke( new Object[]{ "Robert" });
	// System.out.println(result);
	// 3.int参数
	// String targetEendPoint = "http://localhost:8080/axis/services/HelloWorld" ;
	// Service service = new Service();
	// Call call = (Call) service.createCall();
	// call.setTargetEndpointAddress( new URL(targetEendPoint));
	// call.setOperationName( new QName(targetEendPoint, "add" ));
	// call.addParameter("a", XMLType.SOAP_INT, ParameterMode.IN);
	// call.addParameter("b", XMLType.SOAP_INT, ParameterMode.IN);
	// call.setReturnType(XMLType.SOAP_INT);
	// Integer res = (Integer) call.invoke( new Object[]{ new Integer( 4 ), new Integer( 2 )});
	// System.out.println( "The result is: " + res);
	// }
	/**
	 * 测试
	 * @param args public static void main(String[] args) throws Exception { String targetEendPoint
	 *            = "http://127.0.0.1:8080/Has/ws/soapService?wsdl" ; Service service = new
	 *            Service(); Call call = (Call) service.createCall(); //
	 *            call.setSOAPActionURI("http://webservice.has.gdkj.com/retXml");
	 *            call.setUseSOAPAction(true); call.setTransport(null);
	 *            call.setTargetEndpointAddress( targetEendPoint); call.setOperationName( new
	 *            QName("http://webservice.has.gdkj.com/", "retXml" )); call.addParameter("arg0",
	 *            XMLType.SOAP_INT, ParameterMode.IN); call.addParameter("arg1",
	 *            XMLType.SOAP_STRING, ParameterMode.IN); String result = (String) call.invoke( new
	 *            Object[]{"111","qwe"}); System.out.println(result); }
	 */
	/**
	 * 天气预报1
	 * @param args public static void main(String[] args) { try { String theRegionCode = "31124";
	 *            String endpoint = "http://www.webxml.com.cn/WebServices/WeatherWS.asmx";// Service
	 *            service = new Service(); Call call = (Call) service.createCall();
	 *            call.setTargetEndpointAddress(new java.net.URL(endpoint));
	 *            call.setOperationName(new QName("http://WebXml.com.cn/",
	 *            "getSupportCityDataset")); // call.addParameter(new
	 *            QName("http://WebXml.com.cn/","theRegionCode"),XMLType.XSD_STRING,
	 *            ParameterMode.IN); // call.addParameter("theRegionCode", XMLType.XSD_STRING,
	 *            ParameterMode.IN); call.setReturnType(XMLType.XSD_SCHEMA);
	 *            call.setUseSOAPAction(true);
	 *            call.setSOAPActionURI("http://WebXml.com.cn/getSupportCityDataset");// Schema
	 *            result = (Schema)call.invoke(new Object[]{"31128"}); for (int i = 0; i <
	 *            result.get_any().length; i++) { System.out.println(result.get_any()[i]);
	 *            System.out.println(); } } catch (Exception e) { e.printStackTrace(); } }
	 */
	/**
	 * 天气预报2
	 * @param args public static void main(String[] args) { try { String theRegionCode = "31124";
	 *            String endpoint = "http://www.webxml.com.cn/WebServices/WeatherWS.asmx";// Service
	 *            service = new Service(); Call call = (Call) service.createCall();
	 *            call.setTargetEndpointAddress(new java.net.URL(endpoint));
	 *            call.setOperationName(new QName("http://WebXml.com.cn/", "getRegionProvince")); //
	 *            call.setReturnType(XMLType.XSD_SCHEMA); call.setUseSOAPAction(true);
	 *            call.setSOAPActionURI("http://WebXml.com.cn/getRegionProvince");// Schema result =
	 *            (Schema)call.invoke(new Object[]{}); for (int i = 0; i < result.get_any().length;
	 *            i++) { System.out.println(result.get_any()[i]); } } catch (Exception e) {
	 *            e.printStackTrace(); } }
	 */
	/**
	 * ip查询测试
	 * @param args
	 */
	// public static void main(String[] args) {
	// try {
	// String theRegionCode = "101.201.145.87";
	//
	// String endpoint = "http://www.webxml.com.cn/WebServices/IpAddressSearchWebService.asmx";//
	//
	// Service service = new Service();
	//
	// Call call = (Call) service.createCall();
	// call.setTargetEndpointAddress(new java.net.URL(endpoint));
	//
	// call.setOperationName(new QName("http://WebXml.com.cn/",
	// "getCountryCityByIp")); //
	// call.addParameter(new QName("http://WebXml.com.cn/","theIpAddress"),XMLType.XSD_STRING,
	// ParameterMode.IN);
	// call.setReturnType(XMLType.XSD_SCHEMA);
	//
	// call.setUseSOAPAction(true);
	// call.setSOAPActionURI("http://WebXml.com.cn/getCountryCityByIp");//
	//
	// Schema result = (Schema)call.invoke(new Object[]{theRegionCode});
	//
	// for (int i = 0; i < result.get_any().length; i++) {
	// System.out.println(result.get_any()[i]);
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }

	/**
	 * 中国电视节目预告
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			String theRegionCode = "123";

			String endpoint = "http://www.webxml.com.cn/webservices/ChinaTVprogramWebService.asmx";//

			Service service = new Service();

			Call call = (Call) service.createCall();
			call.setTargetEndpointAddress(new java.net.URL(endpoint));

			call.setOperationName(new QName("http://WebXml.com.cn/", "getTVchannelDataSet")); //
			call.addParameter(new QName("http://WebXml.com.cn/", "theTVstationID"), XMLType.XSD_STRING,
					ParameterMode.IN);
			call.setReturnType(XMLType.XSD_SCHEMA);

			call.setUseSOAPAction(true);
			call.setSOAPActionURI("http://WebXml.com.cn/getAreaDataSet");//

			Schema result = (Schema) call.invoke(new Object[] { theRegionCode });

			for (int i = 0; i < result.get_any().length; i++) {
				System.out.println(result.get_any()[i]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
