package zuoye.java.assetManagement.dao;
import java.util.List;

import zuoye.java.assetManagement.entity.*;

public interface AccountDao {

	/**
	 * ����̨����Ϣ
	 */
	public abstract int updateAccount(String sql, Object[] param);

	/**
	 * ����ʹ����ID����ѽ����ʲ�
	 */
	public abstract List<Account> getAccount(String sql, String[] param);
	/**
	 * ��������ѽ���ʲ�
	 * @return
	 */
	//public abstract List<Account> getAllAccount();
}