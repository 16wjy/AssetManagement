package zuoye.java.assetManagement.dao;

import java.util.List;

import zuoye.java.assetManagement.entity.*;

public interface ManagerDao {

	/**
	 * ��ѯ�����й���Ա
	 */
	public abstract List<Manager> getAllManager();

	/**
	 * ���ݲ�ѯ������ѯ������Ա
	 */
	public abstract Manager selectManager(String sql, String[] param);

	/**
	 * ���¹���Ա��Ϣ
	 */
	public abstract int updateManager(String sql, Object[] param);

}