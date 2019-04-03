package zuoye.java.assetManagement.dao;

import java.util.List;

import zuoye.java.assetManagement.entity.*;

public interface UserDao {

	/**
	 * ��ѯ������ʹ����
	 */
	public abstract List<User> getAllUser();

	/**
	 * ���ݲ�ѯ������ѯ��ʹ����
	 */
	public abstract User getUser(String sql, String[] param);

	/**
	 * ����ʹ������Ϣ
	 */
	public abstract int updateUser(String sql, Object[] param);


}