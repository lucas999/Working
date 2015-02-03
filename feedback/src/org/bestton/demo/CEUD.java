package org.bestton.demo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

public class CEUD {
	
//�� �������
	public void create()throws Exception{
		Connection conn=null;
		Statement st=null;
		ResultSet rs=null;
	
		try{
//			2.��������
			conn = JdbcTool.getConnection();
//			3.����ִ�о��
			st=conn.createStatement();
//			4.ִ�����
			String sql="insert into ufb(name,info,content)values('����','swdw','��ϲ����˵��')"; 
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
//ɾ 
	public void delete()throws Exception{
			Connection conn=null;
			Statement st=null;
			ResultSet rs=null;
		
			try{
//				2.��������
				conn = JdbcTool.getConnection();
//				3.����ִ�о��
				st=conn.createStatement();
//				4.ִ�����
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

//�� ����
public void update()throws Exception{
	Connection conn=null;
	Statement st=null;
	ResultSet rs=null;

	try{
//		2.��������
		conn = JdbcTool.getConnection();
//		3.����ִ�о��
		st=conn.createStatement();
//		4.ִ�����
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

//�� ��ȡ
	public void read()throws Exception{
		Connection conn=null;
		Statement st=null;
		ResultSet rs=null;
	
		try{
//			2.��������
			conn = JdbcTool.getConnection();
//			3.����ִ�о��
			st=conn.createStatement();
//			4.ִ�����
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


