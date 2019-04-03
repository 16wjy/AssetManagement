package zuoye.java.assetManagement.dao;
import java.util.List;

import zuoye.java.assetManagement.entity.*;

public interface AccountDao {

	/**
	 * 更新台帐信息
	 */
	public abstract int updateAccount(String sql, Object[] param);

	/**
	 * 根据使用者ID查出已借用资产
	 */
	public abstract List<Account> getAccount(String sql, String[] param);
	/**
	 * 输出所有已借出资产
	 * @return
	 */
	//public abstract List<Account> getAllAccount();
}