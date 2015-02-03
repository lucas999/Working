package org.bestton.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tool {
	private Tool(){}
	//欢迎界面
	public static void welcome(){
		uline();
		System.out.println("******************欢迎使用****************");
		System.out.println("1.查询");
		System.out.println("2.退出");
		dline();
	}
	//查询界面
		public static void welQuery(){
			uline();
			System.out.println("*******************查询******************");
			//System.out.println("0.逐条回复未回复反馈");
			System.out.println("1.查看未回复反馈");
			System.out.println("2.查看反馈统计");
			System.out.println("3.回复反馈");
			System.out.println("4.返回");
			dline();
		}
	//查询1.查看未回应反馈
		public static void welQuery1(){
			uline();
			System.out.println("*****************未回复反馈***************");
		}
	//查询2.根据条件查询
		public static void welQuery2(){
			
		}
	//查询3.回复反馈
		public static void welQuery3(){
			uline();
			System.out.println("******************回复反馈***************");
			System.out.println("1.根据ID进行回复");
			System.out.println("2.返回");
			dline();
		}
		
		
	//上面分割线
		public static void uline(){
			System.out.println("****************用户反馈系统**************");
		}
	//下面分割线
		public static void dline(){
			System.out.println("*****************************************");
		}
/////////////////////////图形界面////////////////////////////////////////////		
	//键盘输入 回车结束
	public static String io() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line="-1";
		try {
			line=reader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Tool.IO读写问题");
		}
		return line;
	}
}
