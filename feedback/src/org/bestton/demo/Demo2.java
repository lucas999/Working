package org.bestton.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class Demo2 {
	public void demo() throws ClassNotFoundException, SQLException{
		//ע������
		Class.forName("com.mysql.jdbc.Driver");
		//��������
		String url="jdbc:mysql://localhost:3306/userfeedback"; 
		String user="root";
		String password="123456";
		Connection connection = DriverManager.getConnection(url, user, password);
		//����ִ�о��
		Statement statement = connection.createStatement();
		//ִ��sql���
		ResultSet set = statement.executeQuery("select * from ufb");
		while(set.next()){
			System.out.println(set.getInt(1)+"|"+set.getString(2)+"|"+set.getString(3)+"|"+set.getString(4));
		}
		//�ͷ���Դ
		set.close();
		statement.close();
		connection.close();
	}
	@Test
	//����
	public void demo1()throws Exception{
		Connection conn=null;
		Statement st=null;
		ResultSet rs=null;
	
		try{
//			2.��������
			conn = JdbcTool.getConnection();
//			3.����ִ�о��
			st=conn.createStatement();
//			4.ִ�����
			rs=st.executeQuery("select * from ufb");
			while (rs.next()){
				System.out.println(rs.getInt(1)+"|"+rs.getString(2)+"|"
			              +rs.getString(3)+"|"+rs.getString(4));
			}
		}
		finally{
			JdbcTool.free(rs, st, conn);
		}
	}

}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

















