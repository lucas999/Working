package org.bestton.servletDemo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bestton.demo.JdbcTool;

public class Demo1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, UnsupportedEncodingException{
        try {
			read("shang");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void read(String name) throws Exception{
		Connection conn=null;
		//��ֹSQLע��ʽ����,����Ԥ����
		PreparedStatement ps=null;
		ResultSet rs=null;
	
		try{
//			2.��������
			conn = JdbcTool.getConnection();
//			3.����ִ�о��
			String sql="select id,name,content,info from ufb where name=?";
			//��Ҫ��ƴ�յ�+
			ps=conn.prepareStatement(sql);
			ps.setString(1, name);//1�����һ���ʺ�
//			4.ִ�����
			rs=ps.executeQuery();
			while (rs.next()){
				System.out.println(rs.getInt(1)+"|"+rs.getString(2)+"|"
			              +rs.getString(3)+"|"+rs.getString(4));
			}
		}
		finally{
			JdbcTool.free(rs, ps, conn);
		}
	}
	private void ddemo(HttpServletResponse response)
			throws UnsupportedEncodingException {
		//��ȡ�ļ���
		//�����ļ������ģ��ļ�����Ҫ����url����
		String path = this.getServletContext().getRealPath("/download/��Ů.jpg");
		String filename=path.substring(path.lastIndexOf("\\")+1);
		
		response.setHeader("content-disposition", "attachment;filename="+URLEncoder.encode(filename, "UTF-8"));
		
		InputStream in=null;
		OutputStream out=null;
		try {
			in=new FileInputStream(path);
			int len=0;
			byte buffer[]=new byte[1024];
			out=response.getOutputStream();
			while ((len=in.read(buffer))>0){
				out.write(buffer,0,len);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(in!=null){
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(out!=null){
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				
			}
		}
	}

	//���
	private void pdemo(HttpServletResponse response) throws IOException {
		//		����response����Կ���response��ʲô����������д������
				response.setCharacterEncoding("UTF-8");
		//		�����������ʲô���򿪷�����
				response.setHeader("content-type", "text/html;charset=utf-8");
				String data="��s��";
				PrintWriter out=response.getWriter();
				out.write(data);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		doGet(request,response);
	}

}
