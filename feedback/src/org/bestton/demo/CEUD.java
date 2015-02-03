package org.bestton.demo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

public class CEUD {
	
//增 插入语句
	public void create()throws Exception{
		Connection conn=null;
		Statement st=null;
		ResultSet rs=null;
	
		try{
//			2.建立连接
			conn = JdbcTool.getConnection();
//			3.创建执行句柄
			st=conn.createStatement();
//			4.执行语句
			String sql="insert into ufb(name,info,content)values('试试','swdw','不喜书上说欢')"; 
			st.executeUpdate(sql);
			rs=st.executeQuery("select id,name,info,content from ufb");
			while (rs.next()){
				System.out.println(rs.getObject("id")+"  "
									+rs.getString("name")+"  "
									+rs.getString("content")+"  "
									+rs.getString("info"));
			}
		}
		finally{
			JdbcTool.free(rs, st, conn);
		}
	}
	@Test
//删 
	public void delete()throws Exception{
			Connection conn=null;
			Statement st=null;
			ResultSet rs=null;
		
			try{
//				2.建立连接
				conn = JdbcTool.getConnection();
//				3.创建执行句柄
				st=conn.createStatement();
//				4.执行语句
				String sql="delete from ufb where id>5";
				st.executeUpdate(sql);
				rs=st.executeQuery("select id,name,info,content from ufb");
				while (rs.next()){
					System.out.println(rs.getObject("id")+"  "
										+rs.getString("name")+"  "
										+rs.getString("content")+"  "
										+rs.getString("info"));
				}
			}
			finally{
				JdbcTool.free(rs, st, conn);
			}
		}

//改 更新
public void update()throws Exception{
	Connection conn=null;
	Statement st=null;
	ResultSet rs=null;

	try{
//		2.建立连接
		conn = JdbcTool.getConnection();
//		3.创建执行句柄
		st=conn.createStatement();
//		4.执行语句
		String sql="update ufb set name='*' where name='null' ";
		st.executeUpdate(sql);
		rs=st.executeQuery("select id,name,info,content from user_ufb");
		while (rs.next()){
			System.out.println(rs.getObject("id")+"  "
								+rs.getString("name")+"  "
								+rs.getString("content")+"  "
								+rs.getString("info"));
		}
	}
	finally{
		JdbcTool.free(rs, st, conn);
	}
}

//查 读取
	public void read()throws Exception{
		Connection conn=null;
		Statement st=null;
		ResultSet rs=null;
	
		try{
//			2.建立连接
			conn = JdbcTool.getConnection();
//			3.创建执行句柄
			st=conn.createStatement();
//			4.执行语句
			rs=st.executeQuery("select id,name,info,content from ufb");
			while (rs.next()){
				System.out.println(rs.getObject("id")+"  "
									+rs.getString("name")+"  "
									+rs.getString("content")+"  "
									+rs.getString("info"));
			}
		}
		finally{
			JdbcTool.free(rs, st, conn);
		}
	}

}


