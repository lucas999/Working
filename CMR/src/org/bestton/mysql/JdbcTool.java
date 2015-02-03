package org.bestton.mysql;

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

public final class JdbcTool {

//	��¼����
	private static String url="jdbc:mysql://localhost:3306/userfeedback"; 
	private static String user="root";
	private static String password="123456";
	
//	��������ʵ��
	private JdbcTool(){}
	
//	ע������
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new ExceptionInInitializerError(e);
		}
	}
//  ��������
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url, user, password);
	}
//	�ͷ���Դ
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

/*
//��ֹSQLע��ʽ���� ��ѯ ģ��һ
public static  void read(String name) throws Exception{
	Connection conn=null;
	//��ֹSQLע��ʽ����,����Ԥ����
	PreparedStatement ps=null;
	ResultSet rs=null;

	try{
//		2.��������
		conn = JdbcTool.getConnection();
//		3.����ִ�о��
		String sql="select id,name,content,info from ufb where name=?";
		//��Ҫ��ƴ�յ�+
		ps=conn.prepareStatement(sql);
		ps.setString(1, name);//1�����һ���ʺ�
//		4.ִ�����
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

*/



/*
//���� ģ���
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
*/


