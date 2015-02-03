package org.bestton.demo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

public class Demo3 {
	@Test
	//����
		public void demo1()throws Exception{
			Connection conn=null;
			Statement st=null;
			ResultSet rs=null;
		
			try{
//				2.��������
				conn = JdbcTool.getConnection();
//				3.����ִ�о��
				st=conn.createStatement();
//				4.ִ�����
				rs=st.executeQuery("select * from ufb");
				while (rs.next()){
					System.out.println(rs.getInt(1)+"-"+rs.getString(2)+"-"
				              +rs.getString(3)+"-"+rs.getString(4));
				}
			}
			finally{
				JdbcTool.free(rs, st, conn);
			}
		}

	}


