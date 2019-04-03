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
			System.out.println("���ȵ�¼��������Id��");
			String userName = input.nextLine().trim();
			System.out.println("�������û����룺");
			String userPassword = input.nextLine().trim();
			UserDao userDao = new UserDaoImpl();
			String sql = "select * from shiyongzhe where id=? and password=?";
			String[] param = { userName, userPassword };
			user = userDao.getUser(sql, param);
			if (null != user) {
				System.out.println("-------��ϲ�ɹ���¼-------");
				type = false;
			} else {
				System.out.println("��¼ʧ�ܣ���ȷ�������û����������Ƿ���ȷ,���µ�¼");
				type = true;
			}
		}
		return user;
	}
	
	public void register() {
		Scanner input = new Scanner(System.in);
		System.out.println("������ע���û�ID��");
		String userID = input.nextLine();
		System.out.println("������ע�����룺");
		String password = input.nextLine();
		System.out.println("������ע��������");
		String name = input.nextLine();
		String sql = "insert into shiyongzhe(id,password,name)values(?,?,?)";
		Object[] param = { userID, password, name };
		UserDao userDao = new UserDaoImpl();
		int count = userDao.updateUser(sql, param);
		if (count > 0) {
			System.out.println("�ɹ�������һ���û�" );
		}
		else
			System.out.println("ע���û�ʧ��");
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
		System.out.println("������Ҫ������ʲ�id");
		String assetId=input.next();
		System.out.println("������Ҫ�����ʱ��");
		String atime=input.next();
		AssetDao assetDaoo= new AssetDaoImpl();
		String sqlll = "select * from Asset where id=? ";
		String[] parammm = { assetId };
		List<Asset> list = assetDaoo.selectAsset(sqlll, parammm);
		for(int i=0;i<1;i++) {
			Asset asset= list.get(i);
			if(asset.getState().equals("�ѽ��"))
			{
				System.out.println("���豸�ѱ����");
			}
			else {
				String sql = "insert into Account(time,useId,assetId) values(?,?,?)";
				Object[] param = { atime,user.getId(),assetId };
				AccountDao accountDao = new AccountDaoImpl();
				int count = accountDao.updateAccount(sql, param);
				if (count > 0) {
					System.out.println("�ɹ������˹̶��ʲ�" );
					String sqll = "update Asset set state=? where id=? ";
					Object[] paramm = { "�ѽ��",assetId };
					AssetDao assetDao = new AssetDaoImpl();
					int countt = assetDao.updateAsset(sqll, paramm);
					if (countt > 0) {
						System.out.println("�ɹ�����" );
					}
				}
				else
					System.out.println("����̶��ʲ�ʧ��");
			}
		}
		
		return user;
	}
	
	public User returnAsset(User user) {
		Scanner input = new Scanner(System.in);
		System.out.println("������Ҫ�黹���ʲ�Id");
		String assetId=input.next();
		
		String sql = "delete from Account where useId=? and assetId=?";
		Object[] param = { user.getId(), assetId};
		AccountDao accountDao = new AccountDaoImpl();
		int count = accountDao.updateAccount(sql, param);
		if (count > 0) {
			System.out.println("�ɹ��黹�˹̶��ʲ�" );
			
		}
		else
			System.out.println("�黹�̶��Ʋ�ʧ��");
		return user;
	}
	
	public void changePassword(User user) {
		Scanner input = new Scanner(System.in);
		boolean reg=true;
		while(reg) {
		System.out.println("����������������");
		String newpassword=input.next();
		System.out.println("���ٴ�����ȷ������");
		String newpasswordd=input.next();
		if(newpassword.equals(newpasswordd)) {
		String sql = "update shiyongzhe set password=? where id=?";
		Object[] param = { newpassword, user.getId()};
		UserDao userDao = new UserDaoImpl();
		int count = userDao.updateUser(sql, param);
		if (count > 0) {
			System.out.println("�ɹ��޸�������" );
		}
		else
			System.out.println("�޸�����ʧ��");
		reg=false;
		}
		else {
			System.out.println("�����������벻ͬ������������");
			reg=true;
		}
		}	
	}
	
}

