package demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;




import net.sf.json.JSONObject;

import org.junit.Test;

public class demo {
	@Test
	public void demo1() throws IOException{
		String url="http://192.168.30.42:8080/userfb/servlet/Accept";
		URL servletURL = new URL(url);
		HttpURLConnection  urlConnection = (HttpURLConnection) servletURL.openConnection();
		urlConnection.setDoOutput(true);
		urlConnection.setRequestMethod("POST");
//		urlConnection.setDoInput(true);
//		urlConnection.setDoOutput(true);
		OutputStreamWriter out = new OutputStreamWriter(urlConnection.getOutputStream(), "UTF-8");
		
    	InputStream in = urlConnection.getInputStream();
    	BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		
		String name="liu";
	    String feedback="no no no";
		String tel="18817337585";
		String time="2015-02-01 15:23:59";
		String phoneInfo="lllllllluuuuuuuccccc";
		
		JSONObject json=new JSONObject();
		json.put("feedback", feedback);
		json.put("name", name);
		json.put("tel", tel);
		json.put("time", time);
		json.put("phoneInfo", phoneInfo);
		System.out.println(json);
		String jsonStr=json.toString();
		out.write(jsonStr);
		out.flush();
		out.close();
		
		int len=0;
		byte buffer[]=new byte[1024];
		String str="";
		str=reader.readLine();
		//	String temp=new String(buffer,0,len);
			//str+=temp;
		
	}
}

