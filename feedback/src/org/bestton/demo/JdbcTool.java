package org.bestton.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * 
 * @author Lucas
 *
 */
/*
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
*/
public final class JdbcTool {

//	登录数据
	private static String url="jdbc:mysql://localhost:3306/userfeedback"; 
	private static String user="root";
	private static String password="123456";
	
//	不允许构造实例
	private JdbcTool(){}
	
//	注册驱动
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new ExceptionInInitializerError(e);
		}
	}
//  建立连接
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url, user, password);
	}
//	释放资源
	public static void free(ResultSet rs,Statement st, Connection conn){
		try{
			if(rs!=null)
			rs.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			try{
				if(st!=null)
					st.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
			finally
			{
				if(conn!=null)
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
			}
		}
	}
}












