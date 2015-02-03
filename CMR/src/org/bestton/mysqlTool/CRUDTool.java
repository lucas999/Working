package org.bestton.mysqlTool;

import org.bestton.mysql.CRUD;

public class CRUDTool {
private CRUDTool(){}
/**
 * 条件查询语句
 * @param con 查询目标
 * @param str 查询条件
 * @return 是否查询成功
 */
	public static boolean query(String where,String wCon)  {
		boolean flag=false;//判断是否读取到数据
		flag=CRUD.que(where,wCon, null, null);
		return flag;
	}
	/**
	 * 排序查询语句
	 * @param order 根据排序的参数
	 * @param Ocon 排序的升降
	 * @return 是否查询成功
	 */
	public static boolean order(String order,String Ocon ){
		boolean flag=false;
		flag=CRUD.que(null,null,order,Ocon);
		return flag;
	}
	/**
	 * 查询排序
	 * @param where
	 * @param wCon
	 * @param order
	 * @param Ocon
	 * @return
	 */
	public static boolean queryOrder(String where,String wCon,String order,String Ocon){
		boolean flag=false;//判断是否读取到数据
		flag=CRUD.que(where,wCon, order, Ocon);
		return flag;
	}
	/**
	 * 根据天数进行统计
	 * @return
	 */
	public static boolean count(){
		boolean flag=false;//判断是否读取到数据
		flag=CRUD.que(null, null, null, null);
		return flag;
	}
}
