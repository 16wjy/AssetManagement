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
			System.out.println("谢谢使用");
		}
	    
		/**
		 * 主界面
		 */
		public static void mainMenu() {
			do{ 
				int menuChoose = 0;
				System.out.println("*************欢迎使用固定资产系统***************");
				System.out.println("1.管理员登录   2.普通用户注册  3.普通用户登录  4.时光机  5.退出系统");
				System.out.print("请选择：");
				Scanner input = new Scanner(System.in);
				menuChoose = input.nextInt(); 
				// 分支语句：根据功能编号执行相应功能
				switch (menuChoose) {
				case 1:
				//管理员登录
					Main.mgrLogin();
				    mgrMenu();
					  continue;
				case 2:
				//用户注册
					  register();
					  continue;
				case 3:
				//用户登录
					User user=Main.userLogin();
				    userMenu(user);
					  continue;				
				case 4:
				    timeMachine();
					  continue;
				case 5:
					//退出系统
						  break;
				default:
				//选择其他数字退出系统
					  break;
			}
				break;
			}while(true);
		}
		
		
		/**
		 * 管理员管理页面
		 */
		public static void mgrMenu(){
			 int menuChoose=0;
			 do{
				 System.out.println("管理员可操作选项");
				 System.out.println("1.增加资产  2.去除资产  3.查询资产   4.修改资产   5.资产报废   6.退出系统");
				 System.out.print("请选择(输入1~6选择功能，其他键返回上一级)：");
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
	                	 System.out.println("谢谢使用！");
	     				System.exit(1);	 //退出系统	
				 }
				 break;
			 } while (true);
		}
		
		
		/**
		 * 用户管理页面
		 */
		public static void userMenu(User user){
			 int menuChoose=0;
			 do{
				 System.out.println("用户可操作选项");
				 System.out.println("1.资产领用  2.资产归还  3.已借资产查看  4.修改密码 5.退出系统");
				 System.out.print("请选择(输入其它数字返回主界面)：");
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
	                	System.out.println("谢谢使用！");
	     				System.exit(1);	 //退出系统	
				 }
				 break;
			 } while (true);
		}
		/**
		 * 用户登陆实现
		 */
		public static User userLogin() {
			UserService userservice = new UserServiceImpl();
	    	User user = userservice.login();
			return user;
		}
		/**
		 * 管理员登陆实现
		 */
		public static Manager mgrLogin() {
			ManagerService manager = new ManagerServiceImpl();
	    	Manager mgr = manager.login();
			return mgr;
		}
		/**
		 * 用户注册
		 */
		public static void register() {
			UserService userservice = new UserServiceImpl();
	    	userservice.register();
		}
		/**
		 * 增加资产实现
		 */
		public static void addAsset() {
			ManagerService mgr= new ManagerServiceImpl();
			mgr.addAsset();
		}
		/**
		 * 删除资产实现
		 */
		public static void deleteAsset() {
			ManagerService mgr= new ManagerServiceImpl();
			mgr.deleteAsset();
		}
		/**
		 * 更改资产信息实现
		 */
		public static void modifyAsset() {
			ManagerService mgr= new ManagerServiceImpl();
			mgr.modifyAsset();
		}
		/**
		 * 输出资产实现
		 */
		public static void getAllInAsset() {
			ManagerService mgr= new ManagerServiceImpl();
			mgr.getAllInAsset();
		}
		/**
		 * 用户申请资产实现
		 */
		public static User applyAsset(User user) {
			ManagerService mgr= new ManagerServiceImpl();
			mgr.getAllInAsset();
			UserService userservice = new UserServiceImpl();
            userservice.applyAsset(user);
			return user;
		}
		/**
		 * 用户归还资产实现
		 */
		public static User returnAsset(User user) {
			UserService userservice = new UserServiceImpl();
            userservice.returnAsset(user);
			return user;
		}
		/**
		 * 用户查询已借资产实现
		 */
		public static void queryAsset(User user) {
			UserService userservice = new UserServiceImpl();
            List<Account> list = userservice.queryAsset(user.getId());
            if(list != null){
            System.out.println("序号\t" + "借出时间\t"+""+ "使用者Id\t"+""+ "资产Id\t" );
    		for (int i=0;i<list.size();i++) {
    			Account account = list.get(i);
    			System.out.println((i + 1) +"\t"+ account.getTime()+"\t"+ account.getUserId()+"\t"+ account.getAssetId()+"\t");
    		}	
            }
            else 
            	System.out.println("没有已借出的资产");
		}
		/**
		 * 用户改密码实现
		 */
		public static void changePassword(User user) {
			UserService userservice = new UserServiceImpl();
            userservice. changePassword(user);
		}
		/**
		 * 资产报废实现
		 */
		public static void deleteUsedAsset() {
			ManagerServiceImpl mgr= new ManagerServiceImpl();
			mgr.deleteUsedAsset();
		}
		/**
		 * 时光机实现
		 */
		public static void timeMachine(){
			Scanner input= new Scanner(System.in);
			System.out.println("请输入过了多长时间(单位：月)");
			int number=input.nextInt();
			ManagerServiceImpl mgr= new ManagerServiceImpl();
			mgr.timeMachine(number);
		}
	}