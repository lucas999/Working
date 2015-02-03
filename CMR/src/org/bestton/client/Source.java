package org.bestton.client;

import java.io.IOException;
import java.sql.SQLException;

import org.bestton.mysql.CRUD;
import org.bestton.mysqlTool.CRUDTool;

public class Source {
	//主界面
	public static void welcome() {
		boolean quit=false;
	//	boolean flag=true;
			while (true){
			Tool.welcome();
			 String num=Tool.io();
			// System.out.println(num);
			 String regex="[1-2]{1}";//正则匹配
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
			 			System.out.println("-----------您已经成功退出----------");
			 			break;
			 		}
			}
			 	else
			 	{
			 		System.out.println(" welcome()输入错误！请重新输入！");
			 	}
			 }
	}
	private static void welQuery(){
		boolean quit=false;
		 while (true){
			 Tool.welQuery();
		 String num=Tool.io();	
		 String regex="[1-4]{1}";//正则匹配
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
		 		System.out.println("welQuery()输入错误！请重新输入！");
		 	}
		 }
	}
	private static void welQuery1(){
		if(CRUDTool.query("fbinfo", "感谢您的建议！")){
			welQuery3();
		}
		else{
			System.out.println("您已经全部回复完成~");
		}
	}
	private static void welQuery2(){
		if(CRUDTool.count()){
			
		}
		else{
			System.out.println("Source查询失败");
		}
	}
	private static void welQuery3() {
		boolean quit=false;
		 while (true){
			 Tool.welQuery3();
			 String num=Tool.io();
			 String regex="[1-2]{1}";//正则匹配
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
			 		System.out.println(" Source.welQuery3()输入错误！请重新输入！");
			 	}
			 }
		
	}
//	回复反馈程序
	private static void reply() {
		System.out.println("输入需要回复的ID:");
		String num=Tool.io();
		String regex="[1-9][0-9]*";//正则匹配
		boolean matches = num.matches(regex);
		if(matches){
			//int numint=Integer.parseInt(num);
				if(CRUDTool.query("id",num))
				{
					System.out.println("输入需要回复的内容：");
					String content=Tool.io();
					if(CRUD.update(content, num)){
						System.out.println("更新成功！");
						Tool.dline();
					}
					else{
						System.out.println("注意：更新失败！！");
						Tool.dline();
					}
				}
				else System.out.println("读取不到数据");
			
		}
		else {
			System.out.println("输入不合法!");
		}
	}
}