package org.bestton.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class Demo2 {
	public void demo() throws ClassNotFoundException, SQLException{
		//注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		//建立连接
		String url="jdbc:mysql://localhost:3306/userfeedback"; 
		String user="root";
		String password="123456";
		Connection connection = DriverManager.getConnection(url, user, password);
		//创建执行句柄
		Statement statement = connection.createStatement();
		//执行sql语句
		ResultSet set = statement.executeQuery("select * from ufb");
		while(set.next()){
			System.out.println(set.getInt(1)+"|"+set.getString(2)+"|"+set.getString(3)+"|"+set.getString(4));
		}
		//释放资源
		set.close();
		statement.close();
		connection.close();
	}
	@Test
	//样板
	public void demo1()throws Exception{
		Connection conn=null;
		Statement st=null;
		ResultSet rs=null;
	
		try{
//			2.建立连接
			conn = JdbcTool.getConnection();
//			3.创建执行句柄
			st=conn.createStatement();
//			4.执行语句
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

















