package org.bestton.client;

import java.io.IOException;
import java.sql.SQLException;

import org.bestton.mysql.CRUD;
import org.bestton.mysqlTool.CRUDTool;

public class Source {
	//������
	public static void welcome() {
		boolean quit=false;
	//	boolean flag=true;
			while (true){
			Tool.welcome();
			 String num=Tool.io();
			// System.out.println(num);
			 String regex="[1-2]{1}";//����ƥ��
				boolean matches = num.matches(regex);
			if(matches)
			{
			 int sel=Integer.parseInt(num);
			 //int sel=0;	
			 		switch(sel){
			 		case 1:welQuery();break;
			 		case 2:quit=true;break;
			 		}
			 		if(quit)
			 		{
			 			System.out.println("-----------���Ѿ��ɹ��˳�----------");
			 			break;
			 		}
			}
			 	else
			 	{
			 		System.out.println(" welcome()����������������룡");
			 	}
			 }
	}
	private static void welQuery(){
		boolean quit=false;
		 while (true){
			 Tool.welQuery();
		 String num=Tool.io();	
		 String regex="[1-4]{1}";//����ƥ��
			boolean matches = num.matches(regex);
			if(matches)
			{
				int sel=Integer.parseInt(num);
		 		switch(sel){
		 		case 1:welQuery1();break;
		 		case 2:welQuery2();break;
		 		case 3:welQuery3();break;
		 		case 4: quit=true;break;
		 
		 		}
		 		if(quit)
		 			break;
		 	}
		 	else
		 	{
		 		System.out.println("welQuery()����������������룡");
		 	}
		 }
	}
	private static void welQuery1(){
		if(CRUDTool.query("fbinfo", "��л���Ľ��飡")){
			welQuery3();
		}
		else{
			System.out.println("���Ѿ�ȫ���ظ����~");
		}
	}
	private static void welQuery2(){
		if(CRUDTool.count()){
			
		}
		else{
			System.out.println("Source��ѯʧ��");
		}
	}
	private static void welQuery3() {
		boolean quit=false;
		 while (true){
			 Tool.welQuery3();
			 String num=Tool.io();
			 String regex="[1-2]{1}";//����ƥ��
				boolean matches = num.matches(regex);
			 if(matches){
				 int sel=Integer.parseInt(num);	
			 		switch(sel){
			 		case 1:reply();break;
			 		case 2:quit=true;break;
		
			 		}
			 		if(quit)
			 			break;
			 	}
			 	else
			 	{
			 		System.out.println(" Source.welQuery3()����������������룡");
			 	}
			 }
		
	}
//	�ظ���������
	private static void reply() {
		System.out.println("������Ҫ�ظ���ID:");
		String num=Tool.io();
		String regex="[1-9][0-9]*";//����ƥ��
		boolean matches = num.matches(regex);
		if(matches){
			//int numint=Integer.parseInt(num);
				if(CRUDTool.query("id",num))
				{
					System.out.println("������Ҫ�ظ������ݣ�");
					String content=Tool.io();
					if(CRUD.update(content, num)){
						System.out.println("���³ɹ���");
						Tool.dline();
					}
					else{
						System.out.println("ע�⣺����ʧ�ܣ���");
						Tool.dline();
					}
				}
				else System.out.println("��ȡ��������");
			
		}
		else {
			System.out.println("���벻�Ϸ�!");
		}
	}
}