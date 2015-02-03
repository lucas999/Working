package org.bestton.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class Demo4 {
	@Test
	public  void demo4() throws Exception{
		for(int i=0;i<50;i++){
			System.out.println(i+":---------------");
				read1("shang");
				read("shang");
		    System.out.println("-------------------");
				
		}
	}
	
	public static  void read(String name) throws Exception{
		Connection conn=null;
		//��ֹSQLע��ʽ����,����Ԥ����
		PreparedStatement ps=null;
		ResultSet rs=null;
	
		try{
//			2.��������
			conn = JdbcTool.getConnection();
			long start = System.currentTimeMillis();
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
			long end = System.currentTimeMillis();
			System.out.println("read(prepare):"+(end-start));
		}
		finally{
			JdbcTool.free(rs, ps, conn);
		}
	}

public static void read1(String name)throws Exception{
	Connection conn=null;
	Statement st=null;
	ResultSet rs=null;

	try{
//		2.��������
		conn = JdbcTool.getConnection();
//		3.����ִ�о��
	    long start = System.currentTimeMillis();
		st=conn.createStatement();
//		4.ִ�����
		rs=st.executeQuery("select * from ufb where name='"+name+"'");
		while (rs.next()){
			System.out.println(rs.getInt(1)+"|"+rs.getString(2)+"|"
		              +rs.getString(3)+"|"+rs.getString(4));
		}
		long end = System.currentTimeMillis();
		System.out.println("read:"+(end-start));
	}
	finally{
		JdbcTool.free(rs, st, conn);

	}
}

}

