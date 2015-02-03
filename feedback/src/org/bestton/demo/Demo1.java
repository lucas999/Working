package org.bestton.demo;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




import org.junit.Test;

import com.mysql.jdbc.Connection;

public class Demo1 {
		@Test
	public void test() throws SQLException{
		//注册驱动
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		//建立连接
		Connection conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/MySQL","root","123456");
		//创建语句
		Statement statement = conn.createStatement();
		//执行语句
		ResultSet set = statement.executeQuery("select * from users");
		while(set.next()){
			System.out.println(set.getObject(1)+"\t"+set.getObject(2)+"\t"+set.getObject(3));
		}
		//释放资源
		set.close();
		statement.close();
		conn.close();
	}

}