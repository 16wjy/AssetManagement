package zuoye.java.assetManagement.service.impl;

import java.util.List;
import java.util.Scanner;


import zuoye.java.assetManagement.dao.*;
import zuoye.java.assetManagement.dao.impl.*;
import zuoye.java.assetManagement.entity.*;
import zuoye.java.assetManagement.service.*;
//import zuoye.java.assetManagement.service.impl.*;

public class UserServiceImpl implements UserService{
        
	public User login() {
		Scanner input = new Scanner(System.in);
		User user = null;
		boolean type = true;
		while (type) {
			System.out.println("请先登录，请输入Id：");
			String userName = input.nextLine().trim();
			System.out.println("请输入用户密码：");
			String userPassword = input.nextLine().trim();
			UserDao userDao = new UserDaoImpl();
			String sql = "select * from shiyongzhe where id=? and password=?";
			String[] param = { userName, userPassword };
			user = userDao.getUser(sql, param);
			if (null != user) {
				System.out.println("-------恭喜成功登录-------");
				type = false;
			} else {
				System.out.println("登录失败，请确认您的用户名和密码是否正确,重新登录");
				type = true;
			}
		}
		return user;
	}
	
	public void register() {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入注册用户ID：");
		String userID = input.nextLine();
		System.out.println("请输入注册密码：");
		String password = input.nextLine();
		System.out.println("请输入注册姓名：");
		String name = input.nextLine();
		String sql = "insert into shiyongzhe(id,password,name)values(?,?,?)";
		Object[] param = { userID, password, name };
		UserDao userDao = new UserDaoImpl();
		int count = userDao.updateUser(sql, param);
		if (count > 0) {
			System.out.println("成功创建了一个用户" );
		}
		else
			System.out.println("注册用户失败");
	}
	
	public List<Account> queryAsset(String userId) {
		String sql = "select * from Account where useId=? ";
		String[] param = { userId };
		AccountDao accountDao = new AccountDaoImpl();
		List<Account> list = accountDao.getAccount(sql, param);
		return list;
	}
	
	public User applyAsset(User user) {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入要申领的资产id");
		String assetId=input.next();
		System.out.println("请输入要申领的时间");
		String atime=input.next();
		AssetDao assetDaoo= new AssetDaoImpl();
		String sqlll = "select * from Asset where id=? ";
		String[] parammm = { assetId };
		List<Asset> list = assetDaoo.selectAsset(sqlll, parammm);
		for(int i=0;i<1;i++) {
			Asset asset= list.get(i);
			if(asset.getState().equals("已借出"))
			{
				System.out.println("该设备已被借出");
			}
			else {
				String sql = "insert into Account(time,useId,assetId) values(?,?,?)";
				Object[] param = { atime,user.getId(),assetId };
				AccountDao accountDao = new AccountDaoImpl();
				int count = accountDao.updateAccount(sql, param);
				if (count > 0) {
					System.out.println("成功申领了固定资产" );
					String sqll = "update Asset set state=? where id=? ";
					Object[] paramm = { "已借出",assetId };
					AssetDao assetDao = new AssetDaoImpl();
					int countt = assetDao.updateAsset(sqll, paramm);
					if (countt > 0) {
						System.out.println("成功更改" );
					}
				}
				else
					System.out.println("申领固定资产失败");
			}
		}
		
		return user;
	}
	
	public User returnAsset(User user) {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入要归还的资产Id");
		String assetId=input.next();
		
		String sql = "delete from Account where useId=? and assetId=?";
		Object[] param = { user.getId(), assetId};
		AccountDao accountDao = new AccountDaoImpl();
		int count = accountDao.updateAccount(sql, param);
		if (count > 0) {
			System.out.println("成功归还了固定资产" );
			
		}
		else
			System.out.println("归还固定财产失败");
		return user;
	}
	
	public void changePassword(User user) {
		Scanner input = new Scanner(System.in);
		boolean reg=true;
		while(reg) {
		System.out.println("请输入您的新密码");
		String newpassword=input.next();
		System.out.println("请再次输入确认密码");
		String newpasswordd=input.next();
		if(newpassword.equals(newpasswordd)) {
		String sql = "update shiyongzhe set password=? where id=?";
		Object[] param = { newpassword, user.getId()};
		UserDao userDao = new UserDaoImpl();
		int count = userDao.updateUser(sql, param);
		if (count > 0) {
			System.out.println("成功修改了密码" );
		}
		else
			System.out.println("修改密码失败");
		reg=false;
		}
		else {
			System.out.println("两次输入密码不同，请重新输入");
			reg=true;
		}
		}	
	}
	
}

