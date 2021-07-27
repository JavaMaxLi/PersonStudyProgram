package com.tasoft.syb.test;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.Charset;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.isotope.jfp.framework.security.value.MD5SecurityHelper;
import org.isotope.jfp.framework.utils.DateHelper;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class GameTest {
	private String apiURL = "http://192.168.11.191/rcq?m=THREEAUTH_NAME&key=0000000";
	private Log logger = LogFactory.getLog(this.getClass());
	private CloseableHttpClient httpClient = null;
	private HttpPost method = null;
	private long startTime = 0L;
	private long endTime = 0L;
	private int status = 0;
	
	/**
	 * 接口地址
	 * 
	 * @param url
	 */
	public GameTest(String url) {

		if (url != null) {
			this.apiURL = url;
		}
		if (apiURL != null) {
			httpClient = HttpClientBuilder.create().build();
			method = new HttpPost(apiURL);

		}
	}
	
	/**
	 * 调用 API
	 * 
	 * @param parameters
	 * @return
	 */
	public String post(String parameters) {
		String body = null;
		logger.info("parameters:" + parameters);

		if (method != null & parameters != null && !"".equals(parameters.trim())) {
			try {

				// 建立一个NameValuePair数组，用于存储欲传送的参数
				method.addHeader("Content-type", "application/json; charset=utf-8");
				method.setHeader("Accept", "application/json");
				method.setEntity(new StringEntity(parameters, Charset.forName("UTF-8")));
				startTime = System.currentTimeMillis();

				HttpResponse response = httpClient.execute(method);

				endTime = System.currentTimeMillis();
				int statusCode = response.getStatusLine().getStatusCode();

				logger.info("statusCode:" + statusCode);
				logger.info("调用API 花费时间(单位：毫秒)：" + (endTime - startTime));
				if (statusCode != HttpStatus.SC_OK) {
					logger.error("Method failed:" + response.getStatusLine());
					status = 1;
				}

				// Read the response body
				body = EntityUtils.toString(response.getEntity());

			} catch (IOException e) {
				// 网络错误
				status = 3;
			} finally {
				logger.info("调用接口状态：" + status);
			}

		}
		return body;
	}
	static String key="{B1D1A75B-E8BF-491B-904B-EABD78D0CB0E}";
	public static void main(String[] args) throws Exception {

		System.out.println((new BigDecimal("5.00")).intValue());
		
		JSONObject order = new JSONObject();
		order.put("callId", 1503241);//用户ID
		order.put("cmd", 10901);
		order.put("hdp", "10001");
		order.put("orderNumber", "17091510161510010");
		order.put("userName", "fcy");
		order.put("gameId", "101");
		order.put("gameName", "新棋牌");
		order.put("serverId", "1");
		order.put("serverName", "双线1区");
		order.put("payType", "0401");
		order.put("rechargeMoney", "1");
		
		order.put("sign", loadSign(order));
		
		GameTest ac = new GameTest("http://192.168.11.191/rcq?m=THREEAUTH_NAME&KEY="+DateHelper.currentTimeMillis0());

		//System.out.println(ac.post(JSON.toJSONString(order)));
	}

	private static String loadSign(JSONObject order) throws Exception {
		//sign=md5(orderNumber+rechargeMoney+callId+key)
		//sign=md5(orderNumber+payState+callId+key)
		return MD5SecurityHelper.encrypt(order.getString("orderNumber")+order.getString("rechargeMoney")+order.getString("callId")+key);
	}
}
