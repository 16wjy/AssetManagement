package zuoye.java.assetManagement.dao;

import java.util.List;

import zuoye.java.assetManagement.entity.*;

public interface ManagerDao {

	/**
	 * 查询出所有管理员
	 */
	public abstract List<Manager> getAllManager();

	/**
	 * 根据查询条件查询出管理员
	 */
	public abstract Manager selectManager(String sql, String[] param);

	/**
	 * 更新管理员信息
	 */
	public abstract int updateManager(String sql, Object[] param);

}