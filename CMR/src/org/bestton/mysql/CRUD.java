package org.bestton.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public final class CRUD {
	private static Connection conn=null;
	private static Statement st=null; 
	//��ֹSQLע��ʽ����,����Ԥ����
	private static PreparedStatement ps=null;
	private static ResultSet rs=null;
	private CRUD(){}
/**
 * ��ѯ���������
 * @param rs
 * @return ����Ƿ�ɹ�
 * @throws SQLException ���ʧ��
 */
	private static boolean print(ResultSet rs) throws SQLException{
		boolean flag=false;
		while (rs.next()){
			flag=true;
			System.out.println("id     : "+rs.getInt(1)+"\r\n"
						+"����       : "+rs.getString(2)+"\r\n"
						+"������Ϣ��"+rs.getString(3)+"\r\n"
						+"�绰       ��"+rs.getString(4)+"\r\n"
						+"ʱ��       ��"+rs.getString(5)+"\r\n"
						+"Ӳ����Ϣ��"+rs.getString(6)+"\r\n"
						+"������Ϣ��"+rs.getString(7)+"\r\n"
						);
			System.out.println("-----------------------------------------");
	}
		return flag;
}
	/**��ѯͳ�ƺ��������
	 * 
	 * @param rs
	 * @return
	 * @throws SQLException 
	 */
	private static boolean printCount(ResultSet rs) throws SQLException{
		boolean flag=false;
		while(rs.next()){
			flag=true;
			System.out.println("���ڣ�"+rs.getString(1)+"  "+
						"����������"+rs.getString(2)+"\r\n");
		}
		System.out.println("-----------------------------------------");
		return flag;
	}
/**
 * ��ѯ��ȡ���
 * @param where
 * @param wCon
 * @param order
 * @param oCon
 * @return ��ѯ�Ƿ�ɹ�
 */
	public static boolean que(String where,String wCon,String order,String oCon){
		boolean flag=false;
		boolean ifCount=false;
		try{//2.��������
			conn = JdbcTool.getConnection();
//		3.����ִ�о��//select id,name,info,tel,time,pinfo,fbinfo from user_ufb
			String sql="-1";
			if(where==null&&wCon==null&&order==null&&oCon==null){
				ifCount=true;
				sql="select  DATE_FORMAT(time,'%Y %m %d'),count(*) from user_ufb group by DATE_FORMAT(time,'%Y %m %d')";
				ps=conn.prepareStatement(sql);	
			}
			else if (where!=null&&wCon!=null&&order==null&&oCon==null){
				sql="select * from user_ufb where "+where+"=?";
				ps=conn.prepareStatement(sql);			
				ps.setString(1, wCon);
			//	System.out.println(ps.toString());
			}
			else if(where==null&&wCon==null&&order!=null&&oCon!=null){
				sql="select * from user_ufb order by ? "+oCon;
				ps=conn.prepareStatement(sql);	
				ps.setString(1, order);
			}
			else if(where!=null&&wCon!=null&&order!=null&&oCon!=null){
				sql="select * from user_ufb where "+where+"=? order by ?"+oCon;
				ps=conn.prepareStatement(sql);	
				ps.setString(1, order);
				ps.setString(2, oCon);
			}
			else {
				System.out.println("�����ʽ����");
			}
//		4.ִ�����
				rs=ps.executeQuery();
				if(ifCount){	
					flag=printCount(rs);
				}
				else
				flag=print(rs);
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("CRUD.que��ȡ�����쳣");
		} 
		finally{
			JdbcTool.free(rs, ps, conn);
			return flag;	
		}
		
	}
	
	
/**
 * �������ݿ�����		
 * @param content ��������
 * @param num ���µ�id
 * @return
 */
public static boolean update(String content,String num){
	 boolean flag=false;//�ж��Ƿ��ȡ������
	try {//2.��������
	conn = JdbcTool.getConnection();
    //3.����ִ�о��
	String sql="update user_ufb set fbinfo='"+content+"' where id='"+num+"'";
	//System.out.println(sql);
	st=conn.createStatement();
		st.executeUpdate(sql);
		flag=true;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println("���³����쳣");
	}
	finally{
		JdbcTool.free(rs, ps, conn);
		//System.out.println(flag);
		return flag;	
	}
}
/**
 * ����������
 * @param name
 * @param info
 * @param tel
 * @param time
 * @param pinfo
 * @return ��������ݵ�id
 */
public static String create(String name,String info,String tel,String time,String pinfo){
	//boolean flag=false;
	String ID="0";
	try {
		conn = JdbcTool.getConnection();
		
		String getId="SELECT LAST_INSERT_ID()";
		String sql="insert into user_ufb(name,info,tel,time,pinfo) values ('"+name+"','"+info+"','"+tel+"','"+time+"','"+pinfo+"'";
		st=conn.createStatement();
		synchronized(CRUD.class){
			st.executeUpdate(sql);
			rs=st.executeQuery(getId);
			rs.next();
			rs.getString(1);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println("��ӳ����쳣");
	}
	finally{
		JdbcTool.free(rs, ps, conn);
		//System.out.println(flag);
		return ID;	
	}
	
}
////////////////////////////ɾ��(Delete)/////////////////////////////////////
}
