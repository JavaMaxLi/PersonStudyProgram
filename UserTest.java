package com.tasoft.syb.test;

import java.awt.image.BufferedImage;
import java.io.*;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import com.alibaba.druid.sql.visitor.functions.Char;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.menghu.jyxy.persistent.U1090Recharge.U1090RechargeDBO;
import com.menghu.jyxy.persistent.U1180UserLimit.U1180UserLimitDBO;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.apache.poi.ss.formula.functions.Count;
import org.apache.poi.ss.usermodel.DataValidationHelper;
import org.eclipse.jetty.util.BlockingArrayQueue;
import org.isotope.jfp.common.oss.OSSOperateHelper;
import org.isotope.jfp.common.pay.wx.pc.WxPcOrderQrcodeBean;
import org.isotope.jfp.framework.security.value.MD5SecurityHelper;
import org.isotope.jfp.framework.utils.*;
import org.springframework.web.multipart.MultipartFile;

import static org.isotope.jfp.common.ICustomSystemConstants.appID;
import static org.isotope.jfp.common.ICustomSystemConstants.customid;
import static org.isotope.jfp.common.pay.wx.WeixinPayConstants.*;
import static org.isotope.jfp.framework.constants.ISFrameworkConstants.*;
import static org.isotope.jfp.framework.utils.HttpServiceHelper.ENCODE_DEFAULT;

public class UserTest {
	static String sb = "";
	static AtomicLong atomicLong = new AtomicLong(0);

	public static void main(String[] args) throws Exception {
		//HttpServiceHelper.doHttpPOST("https://www.tourzj.edu.cn/search.aspx?keyword=%22%E7%94%B3%E6%8A%A5%22&x=12&y=12", "");

		//System.out.println(MD5SecurityHelper.encrypt("10001" + "150405792349110010" + "1" + "" + "9628a68a6062b03e"));
		//System.out.println(13&17);
		//System.out.println(DateHelper.currentTimeMillisCN7(-30));
		//aliPay();
		//循环打印1，2，3，4
	/*	ThreadPoolExecutor executor = new ThreadPoolExecutor(6,10,10, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
		//ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,new ArrayBlockingQueue<Runnable>(5));
		//for(int i=0;i<10;i++) {
		CountDownLatch latch = new CountDownLatch(1000000);
		try{
			System.out.println("StringBuffer-start:"+DateHelper.currentTimeMillisCN1());
			for(int i=0;i<150000;i++) {
				executor.execute(()->{
					sb += "Hello JAVA!";
					atomicLong.incrementAndGet();

					if (executor.getQueue().size()==145000) {
						System.out.println("队列存储超过145000");
					} else if (executor.getQueue().size()==140000){
						System.out.println("队列存储超过140000");
					} else if (executor.getQueue().size()==130000) {
						System.out.println("队列存储超过130000");
					} else if (executor.getQueue().size()==120000) {
						System.out.println("队列存储超过120000");
					} else if (executor.getQueue().size()==110000) {
						System.out.println("队列存储超过110000");
					}
					//latch.countDown();
				});

			}

			//latch.await();
			System.out.println("指定时间完成:" +DateHelper.currentTimeMillisCN1() + "："+ atomicLong);
			executor.shutdown();
			if (executor.awaitTermination(10,TimeUnit.SECONDS)== false){
				System.out.println("完成:" +DateHelper.currentTimeMillisCN1() + "："+ atomicLong);
				System.out.println("线程未在指定时间完成强制退出");
				executor.shutdownNow();
			} else {

				System.out.println("正常退出："+DateHelper.currentTimeMillisCN1());
			}
			System.out.println("完成:" +DateHelper.currentTimeMillisCN1() + "："+ atomicLong);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			executor.shutdown();
		}*/
		//}
		//ThreadPoolExecutor tpe = new ThreadPoolExecutor(5,8,2000,TimeUnit.MILLISECONDS,new BlockingArrayQueue<>());
		//返回值为1的话  为周日
		//返回值为7的话  为周六
/*		SumNumber sumNumber = new SumNumber();//3,2,1  5,6,4

		ListNode l3 = new ListNode(3);
		ListNode l2 = new ListNode(4,l3);
		ListNode l1 = new ListNode(2,l2);

		//ListNode l4 = new ListNode(4);
		ListNode l6 = new ListNode(4);
		ListNode l5 = new ListNode(6,l6);
		ListNode l4 = new ListNode(5,l5);*/
/*
		int[] array = new int[]{1,1,1,8,9,7,6,3,2};
		sort(array,0,array.length-1);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+" ");
		}*/
		//System.out.println(recursion(5));
		//HttpServiceHelper.doHttpGET("https://api.mch.weixin.qq.com/v3/certificates",param);
		/*int[] array = new int[]{5,4,6,3,2,1,7};
		selectSort(array);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+" ");
		}*/
		MyStack<Integer> myStack = new MyStack<Integer>(10);
		myStack.push(1);
		myStack.push(2);
		myStack.push(3);
		myStack.push(4);
		myStack.push(5);
		myStack.push(6);
		myStack.push(7);
		myStack.push(8);
		myStack.push(9);
		myStack.push(10);
		myStack.push(11);
		myStack.push(12);
		myStack.push(13);
		myStack.push(14);

		while (myStack.size()>0) {
			System.out.println(myStack.pop());
		}

		/*	ListNode result = sumNumber.addTwoNumbers(l1, l4);
		while(result != null) {
			System.out.println(result.val);
			result = result.next;
		}*/
		/*while(l1 != null) {
			System.out.println(l1.val);
			l1 = l1.next;
		}*/
	/*	Class cache = Integer.class.getDeclaredClasses()[0];
		Field field = cache.getDeclaredField("cache");
		field.setAccessible(true);
		Integer[] array = (Integer[]) field.get(cache);
		//array[129] = 1;
		array[130] = array[129];
		array[131] = array[129];
		Integer a = 1;
		if (a==1 && a == (Integer) 2 && a==(Integer) 3) {
			System.out.println("Success");
		}*/

	}


/*	class MyStack<E>{
		//存储元素的数组
		private Object[] values;
		//元素数量
		private int count;
		//元素初始容量默认为8
		private int capacity;
		//增长因子
		private static final int grop=2;

		private MyStack() {
			count = 0;
			capacity = 8;
			values = new Object[capacity];
		}

		private MyStack(int initCapacity) {
			if (initCapacity < 1) {
				throw new IllegalArgumentException("初始容量不能小于1");
			}
			capacity = initCapacity;
			count = 0;
			values = new Object[initCapacity];
		}

		//入栈
		public void push(int val) {
			if (count == capacity) {
				ensureCapacity();
			}
			values[count++] = val;
		}

		//扩容
		public void ensureCapacity() {
			int newCapacity = capacity * grop;
			//返回新建的扩容数组里面包含元素组的值
			values = Arrays.copyOf(values,newCapacity);
			capacity = newCapacity;
		}

		//出栈
		public void pop() {
			if (count == 0) {
				throw new IllegalArgumentException("MyStack is empty.");
			}
			values[count--] = 0;
			count--;
		}

		public int size() {
			return count;
		}

		public boolean isEmpty() {
			return count > 0 ? false : true;
		}
	}*/

	public static void sort1(int[] arr){
		for(int i = 0; i < arr.length - 1 ; i++){
			int min = i; // 遍历的区间最小的值
			for (int j = i + 1; j < arr.length ;j++){
				if(arr[j] < arr[min]){
					// 找到当前遍历区间最小的值的索引
					min = j;
				}
			}
			if(min != i){
				// 发生了调换
				int temp =  arr[min];
				arr[min] = arr[i];
				arr[i] = temp;
			}
		}
	}
	/**[5,4,6,3,2,1,7]
	 * 1,4,6,3,2,5,7
	 * 1,2,6,3,4,5,7
	 * 1,2,5,3,4,6,7
	 * 1,2,5,3,4,6,7
	 * 选择排序
	 */
	private static void selectSort(int[] array) {
		for(int i=0;i<array.length-1;i++) {
			int index = i;
			for (int j=i+1;j<array.length;j++) {
				if (array[index]>array[j]) {
					//if (array[j]<array[index]) {
						index = j;

					//}
				}
			}
			if (index != i) {//位置发生改变
				int temp = array[i];
				array[i] = array[index];
				array[index] = temp;
			}
		}
	}

	/**
	 * 递归算法计算n的阶乘
	 */
	private static int recursion(int n) {
		if (n <1) {
			throw new IllegalArgumentException("参数必须大于0");
		} else if (n == 1) {
			return 1;
		} else {
			return n * recursion(n - 1);
		}
	}

	/**[5,4,6,3,2,1,7]
	 * 冒泡排序
	 * i=0 j=0-5 0:1 1:2 2:3 3:4 4:5 5:6
	 * i=1 j=0-4 0:1 1:2 2:3 3:4 4:5
	 * i=2 j=0-3 0:1 1:2 2:3 3:4
	 * i=3 j=0-2 0:1 1:2 2:3
	 * i=4 j=0-1 0:1 1:2
	 * i=5 j=0 0:1
	 */
	private static void sort(int[] array) {
		for(int i=0;i<array.length-1;i++) {//i=6 j<7-1-6=0
			for(int j=0;j<array.length-1-i;j++) {
				if (array[j]>array[j+1]) {
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
	}


	/**快速排序
	 * left：数组第一位  {15,14,16,17,12,11,18,19,10,8}
	 * right：数组最后一位
	 * 取数组的第一个作为基准数用来比较，取左边就从右边开始比较，取右边就从左边开始比较
	 * 从right开始右往左取如果当前值不满足就把right-1，直到取到第一个小于基准数的值，然后从left开始左往右取如果当前值不满足就把left+1，直到取到第一个大于基准数的值，
	 * 把这两个值进行交换temp = array[left], array[left] = array[right], array[right] = array[temp];
	 * @param array
	 * @param left
	 * @param right
	 */
	public static void sort(int[] array,int left,int right) {
		int i=left,j=right,base=array[left];
		//
		while(i!=j) {
			//如果大于基准数，则不动下标减1，直到找到小于基准数的值
			while(array[j]>=base && i<j) {
				j--;
			}


			//如果左边的数小于基准数，则不动下标加1，直到找到大于基准数的值
			while(array[i]<=base && i<j){
				i++;
			}
			int temp = array[i];
			array[i] = array[j];
			array[j] = temp;

		}
		//当i=j,第一轮排序完成，把基准数让到当前i的下标
		array[left] = array[i];
		array[i] = base;

		if (i>left) {
			//分别递归两边的数
			sort(array,left,i-1);
		}
		if(i<right) {
			sort(array,i+1,right);
		}
	}

	public static int lengthOfLongestSubstring(String s) {
			List<Integer> list = new ArrayList<Integer>();
			StringBuffer sb = new StringBuffer();
			Map<Integer,String> map = new HashMap<Integer,String>();
			for(int i=0;i<s.length();i++) {
				if (sb.indexOf(s.substring(i,i+1))!=-1) {
					list.add(sb.length());
					map.put(sb.length(),String.valueOf(sb));
					sb = new StringBuffer();
				}
				sb.append(s.substring(i,i+1));
				if (i==s.length()-1) {
					list.add(sb.length());
					map.put(sb.length(),String.valueOf(sb));
				}
			}
		System.out.println(map.entrySet());
			return Collections.max(list);
	}


	static class StringTest implements Runnable{

		String sb = "";
		@Override
		public void run() {
			System.out.println("CurrentThread:" + Thread.currentThread().getName());
			System.out.println("StringBuffer-start:"+DateHelper.currentTimeMillisCN1());
			for(int i=0;i<50000;i++) {
				sb += "Hello JAVA!";
			}
			System.out.println("StringBuffer-end:"+DateHelper.currentTimeMillisCN1());
			//System.out.println(sb);
		}
	}

	static class StringBufferTest implements Runnable{

		StringBuffer sb = new StringBuffer();
		@Override
		public void run() {
			System.out.println("CurrentThread:" + Thread.currentThread().getName());
			System.out.println("StringBuffer-start:"+DateHelper.currentTimeMillisCN1());
			for(int i=0;i<100000;i++) {
				sb.append("Hello JAVA!");
			}
			System.out.println("StringBuffer-end:"+DateHelper.currentTimeMillisCN1());
			//System.out.println(sb);
		}
	}




	public static JSONObject returnLogistics(String no, String type) throws Exception {//【5】参数，具体参照api接口参数
        String host = "https://courierpro.market.alicloudapi.com";       //【1】请求地址  支持http 和 https 及 WEBSOCKET
        String path = "/courier";                                     //【2】后缀
        String appcode = "0edd3b94a27e416795976fb90c49ab55";                             //【3】AppCode  你自己的AppCode 在买家中心查看
        String urlSend = host + path + "?no=" + no + "&type=" + type;   //【6】拼接请求链接
        URL url = new URL(urlSend);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestProperty("Authorization", "APPCODE " + appcode);//格式Authorization:APPCODE (中间是英文空格)
        int httpCode = httpURLConnection.getResponseCode();
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
        String line = null;
        while ((line = br.readLine()) != null) {
            line = new String(line.getBytes(), StandardCharsets.UTF_8);
            sb.append(line);
        }
        br.close();
        JSONObject json = new JSONObject();
        //String json = sb.toString();
        json = JSONObject.parseObject(sb.toString());
        return json;
    }

	/*
        读取返回结果
     */
/*	private static String read(InputStream is) throws IOException {
		StringBuffer sb = new StringBuffer();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String line = null;
		while ((line = br.readLine()) != null) {
			line = new String(line.getBytes(), "utf-8");
			sb.append(line);
		}
		br.close();
		return sb.toString();
	}*/

	public static String getDateAdd(Date date, int field, int amount) throws Exception {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(field, amount);
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		return format.format(cal.getTime());
	}


	/**
	 * 微信支付
	 * @throws Exception
	 */
	public static void weixinPay() throws Exception {
		String serviceURL;
		{
			serviceURL = "http://127.0.0.1:8080/99996666?orderNumber=54ec384084634ae49516f103c3f4877a";

			System.out.println(HttpServiceHelper.doHttpGET(serviceURL));
		}

	}

	public static void aliPay() throws Exception {
		HashMap<String, String> param;
	//	String serviceURL;
		{
			param = new HashMap<String, String>();
			//param.put("token", "a1991231262800a15050433941f580528137701664d19199005_2_3_a_1_a_8_");
			//	param.put("triviaId", "153198303609910010");
		//	param.put("activityId", "1531710529766100110");
		/*	param.put("criticRealPhone", "15869057790");
			param.put("criticHeadUrl", "http://jyxy.oss-cn-shanghai.aliyuncs.com/20180719/1138b53dcf7d4f37a69363e6034e1a83.jpg");
			param.put("criticNickName", "测试帐号");
			param.put("courseId","[\"154711208123510010\", \"154711208635510010\", \"154711512123430010\"]");
			param.put("affiliatedCommunity", "下沙街道白杨社区");
			param.put("subType", "1");
			param.put("courseId", "155566587807210010");
			param.put("courseTime", "[\"2019-04-11 10:10:00\",\"2019-04-22 10:20:00\"]");
			param.put("puk", "155566587807210010");
			param.put("albumTitle", "今天4月19号");
			//param.put("type", "3");
			param.put("userName", "123");
			param.put("activityId", "154858518338210010");
			param.put("userPhone", "15869057790");
			param.put("userId", "154743032568910022");
			param.put("fromType", "1");
			param.put("userPicture", "1237378768e7q8e7r8qwesafdasdfasdfaxss111");*/
			//serviceURL = "http://192.168.18.186:8080/11202035";
		//	serviceURL = "http://60.191.111.6:29086/99996052/17092011315910010";
			String url1 = "http://u.2jiayou.cn/blindDate/blindDateList?token=71E2378.90B.20B.61E1F52537137974C3A9475252E5D_5_F_8_1_5_4_7_A_C_";
			HttpServiceHelper.doHttpPOST(url1, param);
		}

	}
	static int num = 1;

}

class Atest{
	public void show(){
		show2();
	}
	public void show2(){
		System.out.println("A");
		System.out.println(UserTest.num);
	}
}
class Btest extends Atest{
	public void show2(){
		System.out.println("B");
	}
	public void show1(){
		System.out.println("C");
	}
}
