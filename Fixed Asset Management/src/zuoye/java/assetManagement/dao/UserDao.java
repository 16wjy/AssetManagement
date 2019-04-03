package zuoye.java.assetManagement.dao;

import java.util.List;

import zuoye.java.assetManagement.entity.*;

public interface UserDao {

	/**
	 * 查询出所有使用者
	 */
	public abstract List<User> getAllUser();

	/**
	 * 根据查询条件查询出使用者
	 */
	public abstract User getUser(String sql, String[] param);

	/**
	 * 更新使用者信息
	 */
	public abstract int updateUser(String sql, Object[] param);


}