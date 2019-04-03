package zuoye.java.assetManagement.test;

import  java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

import zuoye.java.assetManagement.entity.*;
import zuoye.java.assetManagement.service.*;
import zuoye.java.assetManagement.service.impl.*;

public class Main {
		Scanner input = new Scanner(System.in);
		
		public static void main(String[] args) {
			Main.mainMenu();
			System.out.println("ллʹ��");
		}
	    
		/**
		 * ������
		 */
		public static void mainMenu() {
			do{ 
				int menuChoose = 0;
				System.out.println("*************��ӭʹ�ù̶��ʲ�ϵͳ***************");
				System.out.println("1.����Ա��¼   2.��ͨ�û�ע��  3.��ͨ�û���¼  4.ʱ���  5.�˳�ϵͳ");
				System.out.print("��ѡ��");
				Scanner input = new Scanner(System.in);
				menuChoose = input.nextInt(); 
				// ��֧��䣺���ݹ��ܱ��ִ����Ӧ����
				switch (menuChoose) {
				case 1:
				//����Ա��¼
					Main.mgrLogin();
				    mgrMenu();
					  continue;
				case 2:
				//�û�ע��
					  register();
					  continue;
				case 3:
				//�û���¼
					User user=Main.userLogin();
				    userMenu(user);
					  continue;				
				case 4:
				    timeMachine();
					  continue;
				case 5:
					//�˳�ϵͳ
						  break;
				default:
				//ѡ�����������˳�ϵͳ
					  break;
			}
				break;
			}while(true);
		}
		
		
		/**
		 * ����Ա����ҳ��
		 */
		public static void mgrMenu(){
			 int menuChoose=0;
			 do{
				 System.out.println("����Ա�ɲ���ѡ��");
				 System.out.println("1.�����ʲ�  2.ȥ���ʲ�  3.��ѯ�ʲ�   4.�޸��ʲ�   5.�ʲ�����   6.�˳�ϵͳ");
				 System.out.print("��ѡ��(����1~6ѡ���ܣ�������������һ��)��");
				 Scanner input = new Scanner(System.in);
				 menuChoose=input.nextInt();
				 switch (menuChoose) {
					 case 1:
						 addAsset();
						 continue;
	                 case 2:
						 deleteAsset();
						 continue;
	                 case 3:
	 					 getAllInAsset();
						 continue;
	                 case 4:
	                	 modifyAsset();
						 continue;
	                 case 5:
	                	 deleteUsedAsset();
						 continue;
	                 case 6:
	                	 System.out.println("ллʹ�ã�");
	     				System.exit(1);	 //�˳�ϵͳ	
				 }
				 break;
			 } while (true);
		}
		
		
		/**
		 * �û�����ҳ��
		 */
		public static void userMenu(User user){
			 int menuChoose=0;
			 do{
				 System.out.println("�û��ɲ���ѡ��");
				 System.out.println("1.�ʲ�����  2.�ʲ��黹  3.�ѽ��ʲ��鿴  4.�޸����� 5.�˳�ϵͳ");
				 System.out.print("��ѡ��(�����������ַ���������)��");
				 Scanner input = new Scanner(System.in);
				 menuChoose=input.nextInt();
				 switch (menuChoose) {
					 case 1:
						 applyAsset(user);
						 continue;
	                 case 2:
	                	 returnAsset(user);
						 continue;
	                 case 3:
	 					 queryAsset(user);
						 continue;
                     case 4:
                    	 changePassword(user);
						 continue;
	                 case 5:
	                	System.out.println("ллʹ�ã�");
	     				System.exit(1);	 //�˳�ϵͳ	
				 }
				 break;
			 } while (true);
		}
		/**
		 * �û���½ʵ��
		 */
		public static User userLogin() {
			UserService userservice = new UserServiceImpl();
	    	User user = userservice.login();
			return user;
		}
		/**
		 * ����Ա��½ʵ��
		 */
		public static Manager mgrLogin() {
			ManagerService manager = new ManagerServiceImpl();
	    	Manager mgr = manager.login();
			return mgr;
		}
		/**
		 * �û�ע��
		 */
		public static void register() {
			UserService userservice = new UserServiceImpl();
	    	userservice.register();
		}
		/**
		 * �����ʲ�ʵ��
		 */
		public static void addAsset() {
			ManagerService mgr= new ManagerServiceImpl();
			mgr.addAsset();
		}
		/**
		 * ɾ���ʲ�ʵ��
		 */
		public static void deleteAsset() {
			ManagerService mgr= new ManagerServiceImpl();
			mgr.deleteAsset();
		}
		/**
		 * �����ʲ���Ϣʵ��
		 */
		public static void modifyAsset() {
			ManagerService mgr= new ManagerServiceImpl();
			mgr.modifyAsset();
		}
		/**
		 * ����ʲ�ʵ��
		 */
		public static void getAllInAsset() {
			ManagerService mgr= new ManagerServiceImpl();
			mgr.getAllInAsset();
		}
		/**
		 * �û������ʲ�ʵ��
		 */
		public static User applyAsset(User user) {
			ManagerService mgr= new ManagerServiceImpl();
			mgr.getAllInAsset();
			UserService userservice = new UserServiceImpl();
            userservice.applyAsset(user);
			return user;
		}
		/**
		 * �û��黹�ʲ�ʵ��
		 */
		public static User returnAsset(User user) {
			UserService userservice = new UserServiceImpl();
            userservice.returnAsset(user);
			return user;
		}
		/**
		 * �û���ѯ�ѽ��ʲ�ʵ��
		 */
		public static void queryAsset(User user) {
			UserService userservice = new UserServiceImpl();
            List<Account> list = userservice.queryAsset(user.getId());
            if(list != null){
            System.out.println("���\t" + "���ʱ��\t"+""+ "ʹ����Id\t"+""+ "�ʲ�Id\t" );
    		for (int i=0;i<list.size();i++) {
    			Account account = list.get(i);
    			System.out.println((i + 1) +"\t"+ account.getTime()+"\t"+ account.getUserId()+"\t"+ account.getAssetId()+"\t");
    		}	
            }
            else 
            	System.out.println("û���ѽ�����ʲ�");
		}
		/**
		 * �û�������ʵ��
		 */
		public static void changePassword(User user) {
			UserService userservice = new UserServiceImpl();
            userservice. changePassword(user);
		}
		/**
		 * �ʲ�����ʵ��
		 */
		public static void deleteUsedAsset() {
			ManagerServiceImpl mgr= new ManagerServiceImpl();
			mgr.deleteUsedAsset();
		}
		/**
		 * ʱ���ʵ��
		 */
		public static void timeMachine(){
			Scanner input= new Scanner(System.in);
			System.out.println("��������˶೤ʱ��(��λ����)");
			int number=input.nextInt();
			ManagerServiceImpl mgr= new ManagerServiceImpl();
			mgr.timeMachine(number);
		}
	}