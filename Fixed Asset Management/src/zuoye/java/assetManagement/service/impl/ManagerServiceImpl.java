package zuoye.java.assetManagement.service.impl;

import zuoye.java.assetManagement.service.*;
import zuoye.java.assetManagement.dao.*;
import zuoye.java.assetManagement.dao.impl.*;

import java.util.List;
import java.util.Scanner;


import zuoye.java.assetManagement.entity.Asset;
import zuoye.java.assetManagement.entity.Manager;

public class ManagerServiceImpl implements ManagerService {
	
	public Manager login() {
		Scanner input = new Scanner(System.in);
		Manager manager = null;
		boolean type = true;
		while (type) {
			System.out.println("请输入管理员姓名：");
			String mgrName = input.nextLine().trim();
			System.out.println("请输入管理员密码：");
			String mgrPassword = input.nextLine().trim();
			ManagerDao mgrDao = new ManagerDaoImpl();
			String sql = "select * from Manager where id=? and password=?";
			String[] param = { mgrName, mgrPassword };
			manager = mgrDao.selectManager(sql, param);
			if (null != manager) {
				System.out.println("-------恭喜成功登录-------");
				type = false;
			} else {
				System.out.println("登录失败，请确认您的用户名和密码是否正确,重新登录");
				type = true;
			}
		}
		return manager;
	}
	
	public void getAllInAsset(){
		AssetDao assetDao = new AssetDaoImpl();
		List<Asset> assetList = assetDao.getAllAsset();
		System.out.println("序号\t" + "资产名称\t"+""+ "资产型号\t"+""+ "资产买入时间\t"+ "资产价格\t"+""+ "资产目前状态    "+"资产寿命    "+"资产Id" );
		for (int i=0;i<assetList.size();i++) {
			Asset asset = assetList.get(i);
			System.out.println((i + 1) +"  \t"+ asset.getName()+"   \t"+ asset.getType()+"  "+ asset.getBuytime()+"      \t"+ asset.getPrice()+"   \t"+ asset.getState()+"               "+ asset.getLife()+"     "+ asset.getId());
		}
	}
	
	public int modifyAsset() {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入要更改的资产Id：");
		String assetName = input.nextLine();
		System.out.println("请输入要更改的资产价格：");
		String assetPrice = input.nextLine();
		String sql = "update Asset set price=? where id=?";
		Object[] param = { assetPrice, assetName};
		AssetDao assetDao = new AssetDaoImpl();
		int count = assetDao.updateAsset(sql, param);
		if (count > 0) {
			System.out.println("成功更改了一个固定资产" );
		}
		return count;
	}
	
	public int addAsset() {
		Scanner input = new Scanner(System.in);
		System.out.println("请在下面输入新资产属性：");
		System.out.println("请输入资产名称：");
		String assetName = input.nextLine();
		System.out.println("请输入资产型号：");
		String assetType = input.nextLine();
		System.out.println("请输入资产买入时间");
		String time=input.nextLine();
		System.out.println("请输入资产价格：");
		String assetPrice = input.nextLine();
		System.out.println("请输入资产目前状态：");
		String assetState = input.nextLine();
		System.out.println("请输入资产寿命：");
		String assetLife = input.nextLine();
		System.out.println("请输入资产Id：");
		String assetNumber = input.nextLine();
		String sql = "insert into Asset(name,type,buytime,price,state,life,id) values(?,?,?,?,?,?,?)";
		Object[] param = { assetName, assetType, time,assetPrice, assetState, assetLife, assetNumber };
		AssetDao assetDao = new AssetDaoImpl();
		int count = assetDao.updateAsset(sql, param);
		if (count > 0) {
			System.out.println("成功创建了一个固定资产" + assetName);
		}
		else
			System.out.println("创建固定资产失败");
		return count;
	}

	
	public int deleteAsset() {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入要删除的资产Id");
		String assetId=input.next();
		String sql = "delete from Asset where id=?";
		Object[] param = { assetId };
		AssetDao assetDao = new AssetDaoImpl();
		int count = assetDao.updateAsset(sql, param);
		if (count > 0) {
			System.out.println("成功删除了一个固定资产" );
		}
		else
			System.out.println("删除固定资产失败");
		return count;
	}
	
	public void deleteUsedAsset() {
		Scanner input = new Scanner(System.in);
		String state= "已报废";
		String sql = "select * from Asset where state=?";
		String[] param = { state };
		AssetDao assetDao = new AssetDaoImpl();
		List<Asset> list = assetDao.selectAsset(sql, param);
		if( list!= null) {
		System.out.println("以下是所有报废资产信息：");
		System.out.println("序号\t" + "资产名称\t"+""+ "资产型号\t"+""+ "资产买入时间\t"+ "资产价格\t"+""+ "资产目前状态    "+"资产寿命    "+"资产Id" );
		for (int i=0;i<list.size();i++) {
			Asset asset = list.get(i);
			System.out.println((i + 1) +"  \t"+ asset.getName()+"   \t"+ asset.getType()+"  "+ asset.getBuytime()+"      \t"+ asset.getPrice()+"   \t"+ asset.getState()+"               "+ asset.getLife()+"     "+ asset.getId());
		}
		System.out.println("是否删除已报废资产：");
		System.out.println("1.删除 2.不删除：");
		int choose=input.nextInt();
		if (choose== 1) {
			String sqll = "delete from Asset where state=?";
			String[] paramm = { state };
			int count= assetDao.updateAsset(sqll, paramm);
			if (count > 0) {
				System.out.println("成功删除了报废资产" );
			}
			else
				System.out.println("删除报废固定资产失败");
		}
		}	
		else
			System.out.println("没有要报废的资产");
	}
	/**
	 * 时光流逝对资产寿命的影响
	 * @param number
	 */
	    public void timeMachine(int number){
			AssetDao assetDao= new AssetDaoImpl();
	    	List<Asset> assetList = assetDao.getAllAsset();
	    	for (int i=0;i<assetList.size();i++) {
				Asset asset = assetList.get(i);
				int life=asset.getLife();
				asset.setLife(asset.getLife()-number);
				if(asset.getLife()<= 0)
				{
					String sql = "update Asset set state=? where life=?";
					Object[] param = {"已报废",asset.getLife() };
					int countt = assetDao.updateAsset(sql, param);
				}
		    	String sqll = "update Asset set life=? where life=?";
				Object[] paramm = {asset.getLife() , life};
				int count = assetDao.updateAsset(sqll, paramm);
			}
	    	
	    }
}
