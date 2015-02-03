package org.bestton.mysqlTool;

import org.bestton.mysql.CRUD;

public class CRUDTool {
private CRUDTool(){}
/**
 * ������ѯ���
 * @param con ��ѯĿ��
 * @param str ��ѯ����
 * @return �Ƿ��ѯ�ɹ�
 */
	public static boolean query(String where,String wCon)  {
		boolean flag=false;//�ж��Ƿ��ȡ������
		flag=CRUD.que(where,wCon, null, null);
		return flag;
	}
	/**
	 * �����ѯ���
	 * @param order ��������Ĳ���
	 * @param Ocon ���������
	 * @return �Ƿ��ѯ�ɹ�
	 */
	public static boolean order(String order,String Ocon ){
		boolean flag=false;
		flag=CRUD.que(null,null,order,Ocon);
		return flag;
	}
	/**
	 * ��ѯ����
	 * @param where
	 * @param wCon
	 * @param order
	 * @param Ocon
	 * @return
	 */
	public static boolean queryOrder(String where,String wCon,String order,String Ocon){
		boolean flag=false;//�ж��Ƿ��ȡ������
		flag=CRUD.que(where,wCon, order, Ocon);
		return flag;
	}
	/**
	 * ������������ͳ��
	 * @return
	 */
	public static boolean count(){
		boolean flag=false;//�ж��Ƿ��ȡ������
		flag=CRUD.que(null, null, null, null);
		return flag;
	}
}
