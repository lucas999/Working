package demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import net.sf.json.JSONObject;

import org.junit.Test;

public class demo1 {
	@Test
	public void demo1() throws IOException{
		// �����ַ

        URL url = new URL("http://192.168.30.42:8080/userfb/servlet/Accept");



        // �趨���ӵ���ز���

        HttpURLConnection connection= (HttpURLConnection) url.openConnection();

        connection.setDoOutput(true);

        connection.setRequestMethod("POST");

        OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");

       

        //String name="�ܹ�";
	    String feedback=URLEncoder.encode("n������o no","UTF-8");
		String tel="18817337585";
		String time="2015-02-03 16:34:59";
		String phoneInfo="lllllllluuuuuuuccccc";
		String name =URLEncoder.encode("�й�11����","UTF-8");
		JSONObject json=new JSONObject();
		json.put("feedback", feedback);
		json.put("name", name);
		json.put("tel", tel);
		json.put("time", time);
		json.put("phoneInfo", phoneInfo);
        // �����˷���key = value��
		//String value=URLEncoder.encode(json.toString(),"UTF-8");
		String value=json.toString();
        out.write(value);

        out.flush();

        out.close();

       

        // ��ȡ����˵ķ���

        String strLine="";

        //String strResponse ="";

        InputStream in =connection.getInputStream();

        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        strLine =reader.readLine();


        System.out.print(strLine);
}
}
