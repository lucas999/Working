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
	//防止SQL注入式攻击,进行预处理
	private static PreparedStatement ps=null;
	private static ResultSet rs=null;
	private CRUD(){}
/**
 * 查询后的输出语句
 * @param rs
 * @return 输出是否成功
 * @throws SQLException 输出失败
 */
	private static boolean print(ResultSet rs) throws SQLException{
		boolean flag=false;
		while (rs.next()){
			flag=true;
			System.out.println("id     : "+rs.getInt(1)+"\r\n"
						+"名字       : "+rs.getString(2)+"\r\n"
						+"反馈信息："+rs.getString(3)+"\r\n"
						+"电话       ："+rs.getString(4)+"\r\n"
						+"时间       ："+rs.getString(5)+"\r\n"
						+"硬件信息："+rs.getString(6)+"\r\n"
						+"回馈信息："+rs.getString(7)+"\r\n"
						);
			System.out.println("-----------------------------------------");
	}
		return flag;
}
	/**查询统计后的输出语句
	 * 
	 * @param rs
	 * @return
	 * @throws SQLException 
	 */
	private static boolean printCount(ResultSet rs) throws SQLException{
		boolean flag=false;
		while(rs.next()){
			flag=true;
			System.out.println("日期："+rs.getString(1)+"  "+
						"反馈数量："+rs.getString(2)+"\r\n");
		}
		System.out.println("-----------------------------------------");
		return flag;
	}
/**
 * 查询读取语句
 * @param where
 * @param wCon
 * @param order
 * @param oCon
 * @return 查询是否成功
 */
	public static boolean que(String where,String wCon,String order,String oCon){
		boolean flag=false;
		boolean ifCount=false;
		try{//2.建立连接
			conn = JdbcTool.getConnection();
//		3.创建执行句柄//select id,name,info,tel,time,pinfo,fbinfo from user_ufb
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
				System.out.println("输入格式错误");
			}
//		4.执行语句
				rs=ps.executeQuery();
				if(ifCount){	
					flag=printCount(rs);
				}
				else
				flag=print(rs);
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("CRUD.que读取出现异常");
		} 
		finally{
			JdbcTool.free(rs, ps, conn);
			return flag;	
		}
		
	}
	
	
/**
 * 更新数据库内容		
 * @param content 反馈内容
 * @param num 更新的id
 * @return
 */
public static boolean update(String content,String num){
	 boolean flag=false;//判断是否读取到数据
	try {//2.建立连接
	conn = JdbcTool.getConnection();
    //3.创建执行句柄
	String sql="update user_ufb set fbinfo='"+content+"' where id='"+num+"'";
	//System.out.println(sql);
	st=conn.createStatement();
		st.executeUpdate(sql);
		flag=true;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println("更新出现异常");
	}
	finally{
		JdbcTool.free(rs, ps, conn);
		//System.out.println(flag);
		return flag;	
	}
}
/**
 * 插入新数据
 * @param name
 * @param info
 * @param tel
 * @param time
 * @param pinfo
 * @return 插入的数据的id
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
		System.out.println("添加出现异常");
	}
	finally{
		JdbcTool.free(rs, ps, conn);
		//System.out.println(flag);
		return ID;	
	}
	
}
////////////////////////////删除(Delete)/////////////////////////////////////
}
