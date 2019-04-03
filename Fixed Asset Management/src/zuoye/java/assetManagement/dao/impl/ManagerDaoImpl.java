package zuoye.java.assetManagement.dao.impl;
import zuoye.java.assetManagement.entity.*;
import zuoye.java.assetManagement.dao.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class ManagerDaoImpl extends BaseDao implements ManagerDao {
	private Connection conn = null; // 保存数据库连接

	private PreparedStatement pstmt = null; // 用于执行SQL语句

	private ResultSet rs = null; // 用户保存查询结果集

	/* (non-Javadoc)
	 * @see cn.jbit.epetShop.dao.impl.PetOwnerDao#getAllOwner()
	 */
	public  List<Manager> getAllManager(){
		List<Manager> managerList = new ArrayList<Manager>();
		try {
		String preparedSql = "select id,password,name from Manager";
		conn =getConn(); // 得到数据库连接
		pstmt = conn.prepareStatement(preparedSql); // 得到PreparedStatement对象
		rs = pstmt.executeQuery(); // 执行SQL语句
			while (rs.next()) {
				Manager manager = new Manager();
				manager.setId(rs.getString(1));
				manager.setPassword(rs.getString(2));
				manager.setName(rs.getString(3));
				managerList.add(manager);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			super.closeAll(conn, pstmt, rs);
		}
		return managerList;	
	}
	public Manager selectManager(String sql, String[] param) {
		Manager manager = null;
		try {
		conn = getConn(); // 得到数据库连接
		pstmt = conn.prepareStatement(sql); // 得到PreparedStatement对象
		if (param != null) {
			for (int i = 0; i < param.length; i++) {
				pstmt.setString(i + 1, param[i]); // 为预编译sql设置参数
			}
		}
		rs = pstmt.executeQuery(); // 执行SQL语句
			while (rs.next()) {
			    manager = new Manager();
				manager.setId(rs.getString(1));
				manager.setPassword(rs.getString(2));
				manager.setName(rs.getString(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			super.closeAll(conn, pstmt, rs);
		}
		return manager;
	}
	public  int updateManager(String sql, Object[] param) {
		int count = super.executeSQL(sql, param);
		return count;
	}
	
}
