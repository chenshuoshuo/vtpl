package com.you07.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;


/**
 * 
 * 短信发送工具类
 * @since 2016-5-4 16:37:00
 * @author RenYong
 *
 */
public class SMSSend {
	private static SMSSend sMSSend;
	
	private static final String mMsgTail = Configuration.getInstance().getValue("mMsgTail");
	
	private SMSSend(){}
	public synchronized static SMSSend getDefaultInstance(){
		if(sMSSend==null){
			sMSSend = new SMSSend();
		}
		return sMSSend;
		
	}
	/**
	 * 发送短信
	 * @param phonelist 要发送的电话号码；
            （电话号码间用半角英’,’分开）。
	 * @param content 提交的短信内容
	 * @return -1 发送失败，否则返回发送成功的短信条数
	 */
	public int sendSMS(String phonelist, String content) {
		//将电话列表分成200个一组
		ArrayList<String> phonelists=getPhoneLists(phonelist, 200);
		int ret=-1;
		//创建时间格式化对象
		SimpleDateFormat  sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//Date  time=new Date();
		for(int i=0;i<phonelists.size();i++)
		{
			String str =sendSMS("lqkj","000111",content,phonelists.get(i),5000);
			System.out.println("短信返回结果："+str);
			ArrayList<Integer> is = getInts(str.toCharArray());
			if (is.size()>0&&is.get(0) == 0) {
				if(ret==-1)
					ret=is.get(1);
				else
					ret+=is.get(1);
			}
		}
		return -1;
	}
	/**
	 * 获取剩余短信条数
	 * @return 返回剩余短信条数  
	 */
	public int getSMSLeft()
	{
		Integer left = -1;
		String url = "http://115.29.194.198/api/http?act=getbalance&user=lqkj&passwd=000111";
		HttpClient client = new HttpClient();
		// 设置连接超时时间
		client.getHttpConnectionManager().getParams()
				.setConnectionTimeout(2000);
		PostMethod post = new PostMethod(url);
		try {
			client.executeMethod(post);

			InputStream ins = post.getResponseBodyAsStream();
			// 按指定的字符集构建文件流
			BufferedReader br = new BufferedReader(new InputStreamReader(ins,
					"utf-8"));
			StringBuffer sbf = new StringBuffer();
			String line = null;
			while ((line = br.readLine()) != null) {
				sbf.append(line);
			}

			br.close();
			left = Integer.parseInt(sbf.toString());
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		post.releaseConnection();
		
		return left;
	}
	/**
	 * 将输入的手机号列表分为每count个一组
	 * @param phonelist
	 * @param count
	 * @return 所有的分组
	 */
	private ArrayList<String> getPhoneLists(String phonelist,int count)
	{
		ArrayList<String> ret=new ArrayList<String>();
		int lastindex=0;
		int currentindex=0;
		int phonecount=0;
		while((currentindex=phonelist.indexOf(',',currentindex)+1)!=0)
		{
			phonecount++;
			if(phonecount==count)
			{
				ret.add(phonelist.substring(lastindex, currentindex-1));
				lastindex=currentindex;
				phonecount=0;
			}
		}
//		if(phonecount!=0)
		{
			ret.add(phonelist.substring(lastindex));
		}
		return ret;
	}
	/**
	 * 提取字符数组s中的合法整形数
	 * @param s
	 * @return
	 */
	private ArrayList<Integer> getInts(char[] s) {
		ArrayList<Integer> ret = new ArrayList<Integer>();
		String ints = "";
		for (int i = 0; i < s.length; i++) {
			if (s[i] >= '0' && s[i] <= '9' || (s[i] == '-' && ints == "")) {
				ints += s[i];
			} else {
				if (ints != "") {
					try {

						ret.add(Integer.parseInt(ints));
					} catch (Exception e) {
					}
				}

				ints = "";
			}
		}
		if (ints != "") {
			ret.add(Integer.parseInt(ints));
		}
		return ret;
	}
    /**
     * 发送短信的主方法
     * @param account 
     * @param user 用户
     * @param password 密码
     * @param msg  消息
     * @param phone 手机
     * @param sendtime 延迟时间
     * @return 
     * @throws IOException 
     */
	private String sendSMS(String user,String password,String msg,String phone,int timeOut) {
		SimpleDateFormat sft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String time = sft.format(date);
		msg += mMsgTail;
		/*// 批次编号——格式为：用户账号_当前时间(年月日时分秒)_http_n(n>=5)位随机数
		String taskId = account + "_" + sft.format(date) + "_http_"
				+ Math.round((Math.random()) * 100000);*/
		// url地址 http://115.29.194.198/message/sendMsg/http
		try {
			//account = URLEncoder.encode(account, "utf-8");
			password = URLEncoder.encode(password, "utf-8");
			msg = URLEncoder.encode(msg, "utf-8");
			/*taskId = URLEncoder.encode(taskId, "utf-8");*/
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String url = "http://115.29.194.198/api/http?act=sendmsg&user=lqkj&passwd=000111&msg="+msg+"&phone="+phone;

		
		//http://115.29.194.198/api/http?act=sendmsg&user=test&passwd=test&msg=测试&sendtime=2012-01-01 00:00:00&phone=13911111111
        //设置默认用户名和密码
		/*user="lqkj";password="000111";
		String  info="act="="&user=" + password+"&passwd="+password+"&msg="+ msg+"&sendtime="+time+"&phone="+phone;*/
		/*
		String  str="act=sendmsg&user=lqkj&passwd=000111&msg="+msg+"&sendtime="+time+"&phone="+phone;
		System.out.println("str:"+str);
		String methodUrl="http://115.29.194.198/api/http";
		String jsonObject = HttpRequest.sendPost(methodUrl, str);*/
		String ret = "";
		String inputLine;
		URL url1;
		try {
			url1 = new URL(url);
			HttpURLConnection connection = (HttpURLConnection) url1
					.openConnection();
			connection.setConnectTimeout(timeOut);
			connection.setReadTimeout(timeOut);
			BufferedReader in = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
			while ((inputLine = in.readLine()) != null) {
				ret = ret + inputLine;
			}
			in.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return "-100";
		} catch (IOException e) {
			return "-100";
		}
		return ret;
		
	}
	public static void main(String[] args) {
//		SMSSend sMSSend   = new SMSSend();
		//sMSSend.sendSMS("15680673685","sdfsdfs");
//		int len=sMSSend.sendSMS("13983729224", "短信测试");
//		System.out.println(len);
//		System.out.println(sMSSend.getSMSLeft());
//		String get_user_url = "http://115.29.194.198/api/http";
//		String param = "act=getbalance&user=lqkj&passwd=000111";
//		String sendGet = HttpRequest.sendGet(get_user_url, param);
		String url = "http://115.29.194.198/api/http?act=getbalance&user=lqkj&passwd=000111";
		HttpClient client = new HttpClient();
		// 设置连接超时时间
		client.getHttpConnectionManager().getParams()
				.setConnectionTimeout(2000);
		PostMethod post = new PostMethod(url);
		try {
			client.executeMethod(post);

			InputStream ins = post.getResponseBodyAsStream();
			// 按指定的字符集构建文件流
			BufferedReader br = new BufferedReader(new InputStreamReader(ins,
					"utf-8"));
			StringBuffer sbf = new StringBuffer();
			String line = null;
			while ((line = br.readLine()) != null) {
				sbf.append(line);
			}

			br.close();
			System.out.println("access_return:" + sbf.toString());
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		post.releaseConnection();
//		System.out.println(sendGet);
	}
}
