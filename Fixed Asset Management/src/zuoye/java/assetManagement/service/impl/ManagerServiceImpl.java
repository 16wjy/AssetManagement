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
			System.out.println("���������Ա������");
			String mgrName = input.nextLine().trim();
			System.out.println("���������Ա���룺");
			String mgrPassword = input.nextLine().trim();
			ManagerDao mgrDao = new ManagerDaoImpl();
			String sql = "select * from Manager where id=? and password=?";
			String[] param = { mgrName, mgrPassword };
			manager = mgrDao.selectManager(sql, param);
			if (null != manager) {
				System.out.println("-------��ϲ�ɹ���¼-------");
				type = false;
			} else {
				System.out.println("��¼ʧ�ܣ���ȷ�������û����������Ƿ���ȷ,���µ�¼");
				type = true;
			}
		}
		return manager;
	}
	
	public void getAllInAsset(){
		AssetDao assetDao = new AssetDaoImpl();
		List<Asset> assetList = assetDao.getAllAsset();
		System.out.println("���\t" + "�ʲ�����\t"+""+ "�ʲ��ͺ�\t"+""+ "�ʲ�����ʱ��\t"+ "�ʲ��۸�\t"+""+ "�ʲ�Ŀǰ״̬    "+"�ʲ�����    "+"�ʲ�Id" );
		for (int i=0;i<assetList.size();i++) {
			Asset asset = assetList.get(i);
			System.out.println((i + 1) +"  \t"+ asset.getName()+"   \t"+ asset.getType()+"  "+ asset.getBuytime()+"      \t"+ asset.getPrice()+"   \t"+ asset.getState()+"               "+ asset.getLife()+"     "+ asset.getId());
		}
	}
	
	public int modifyAsset() {
		Scanner input = new Scanner(System.in);
		System.out.println("������Ҫ���ĵ��ʲ�Id��");
		String assetName = input.nextLine();
		System.out.println("������Ҫ���ĵ��ʲ��۸�");
		String assetPrice = input.nextLine();
		String sql = "update Asset set price=? where id=?";
		Object[] param = { assetPrice, assetName};
		AssetDao assetDao = new AssetDaoImpl();
		int count = assetDao.updateAsset(sql, param);
		if (count > 0) {
			System.out.println("�ɹ�������һ���̶��ʲ�" );
		}
		return count;
	}
	
	public int addAsset() {
		Scanner input = new Scanner(System.in);
		System.out.println("���������������ʲ����ԣ�");
		System.out.println("�������ʲ����ƣ�");
		String assetName = input.nextLine();
		System.out.println("�������ʲ��ͺţ�");
		String assetType = input.nextLine();
		System.out.println("�������ʲ�����ʱ��");
		String time=input.nextLine();
		System.out.println("�������ʲ��۸�");
		String assetPrice = input.nextLine();
		System.out.println("�������ʲ�Ŀǰ״̬��");
		String assetState = input.nextLine();
		System.out.println("�������ʲ�������");
		String assetLife = input.nextLine();
		System.out.println("�������ʲ�Id��");
		String assetNumber = input.nextLine();
		String sql = "insert into Asset(name,type,buytime,price,state,life,id) values(?,?,?,?,?,?,?)";
		Object[] param = { assetName, assetType, time,assetPrice, assetState, assetLife, assetNumber };
		AssetDao assetDao = new AssetDaoImpl();
		int count = assetDao.updateAsset(sql, param);
		if (count > 0) {
			System.out.println("�ɹ�������һ���̶��ʲ�" + assetName);
		}
		else
			System.out.println("�����̶��ʲ�ʧ��");
		return count;
	}

	
	public int deleteAsset() {
		Scanner input = new Scanner(System.in);
		System.out.println("������Ҫɾ�����ʲ�Id");
		String assetId=input.next();
		String sql = "delete from Asset where id=?";
		Object[] param = { assetId };
		AssetDao assetDao = new AssetDaoImpl();
		int count = assetDao.updateAsset(sql, param);
		if (count > 0) {
			System.out.println("�ɹ�ɾ����һ���̶��ʲ�" );
		}
		else
			System.out.println("ɾ���̶��ʲ�ʧ��");
		return count;
	}
	
	public void deleteUsedAsset() {
		Scanner input = new Scanner(System.in);
		String state= "�ѱ���";
		String sql = "select * from Asset where state=?";
		String[] param = { state };
		AssetDao assetDao = new AssetDaoImpl();
		List<Asset> list = assetDao.selectAsset(sql, param);
		if( list!= null) {
		System.out.println("���������б����ʲ���Ϣ��");
		System.out.println("���\t" + "�ʲ�����\t"+""+ "�ʲ��ͺ�\t"+""+ "�ʲ�����ʱ��\t"+ "�ʲ��۸�\t"+""+ "�ʲ�Ŀǰ״̬    "+"�ʲ�����    "+"�ʲ�Id" );
		for (int i=0;i<list.size();i++) {
			Asset asset = list.get(i);
			System.out.println((i + 1) +"  \t"+ asset.getName()+"   \t"+ asset.getType()+"  "+ asset.getBuytime()+"      \t"+ asset.getPrice()+"   \t"+ asset.getState()+"               "+ asset.getLife()+"     "+ asset.getId());
		}
		System.out.println("�Ƿ�ɾ���ѱ����ʲ���");
		System.out.println("1.ɾ�� 2.��ɾ����");
		int choose=input.nextInt();
		if (choose== 1) {
			String sqll = "delete from Asset where state=?";
			String[] paramm = { state };
			int count= assetDao.updateAsset(sqll, paramm);
			if (count > 0) {
				System.out.println("�ɹ�ɾ���˱����ʲ�" );
			}
			else
				System.out.println("ɾ�����Ϲ̶��ʲ�ʧ��");
		}
		}	
		else
			System.out.println("û��Ҫ���ϵ��ʲ�");
	}
	/**
	 * ʱ�����Ŷ��ʲ�������Ӱ��
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
					Object[] param = {"�ѱ���",asset.getLife() };
					int countt = assetDao.updateAsset(sql, param);
				}
		    	String sqll = "update Asset set life=? where life=?";
				Object[] paramm = {asset.getLife() , life};
				int count = assetDao.updateAsset(sqll, paramm);
			}
	    	
	    }
}
