package org.bestton.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tool {
	private Tool(){}
	//��ӭ����
	public static void welcome(){
		uline();
		System.out.println("******************��ӭʹ��****************");
		System.out.println("1.��ѯ");
		System.out.println("2.�˳�");
		dline();
	}
	//��ѯ����
		public static void welQuery(){
			uline();
			System.out.println("*******************��ѯ******************");
			//System.out.println("0.�����ظ�δ�ظ�����");
			System.out.println("1.�鿴δ�ظ�����");
			System.out.println("2.�鿴����ͳ��");
			System.out.println("3.�ظ�����");
			System.out.println("4.����");
			dline();
		}
	//��ѯ1.�鿴δ��Ӧ����
		public static void welQuery1(){
			uline();
			System.out.println("*****************δ�ظ�����***************");
		}
	//��ѯ2.����������ѯ
		public static void welQuery2(){
			
		}
	//��ѯ3.�ظ�����
		public static void welQuery3(){
			uline();
			System.out.println("******************�ظ�����***************");
			System.out.println("1.����ID���лظ�");
			System.out.println("2.����");
			dline();
		}
		
		
	//����ָ���
		public static void uline(){
			System.out.println("****************�û�����ϵͳ**************");
		}
	//����ָ���
		public static void dline(){
			System.out.println("*****************************************");
		}
/////////////////////////ͼ�ν���////////////////////////////////////////////		
	//�������� �س�����
	public static String io() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line="-1";
		try {
			line=reader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Tool.IO��д����");
		}
		return line;
	}
}
