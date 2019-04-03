package zuoye.java.assetManagement.dao.impl;
import zuoye.java.assetManagement.dao.*;
import zuoye.java.assetManagement.entity.Asset;
import zuoye.java.assetManagement.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 使用者数据库操作类
 * @author Administrator
 *
 */
public class UserDaoImpl extends BaseDao implements UserDao {
	private Connection conn = null; // 保存数据库连接

	private PreparedStatement pstmt = null; // 用于执行SQL语句

	private ResultSet rs = null; // 用户保存查询结果集

	/* (non-Javadoc)
	 * @see cn.jbit.epetShop.dao.impl.PetDao#getAllPet()
	 */
	public List<User> getAllUser(){
		List<User> userList = new ArrayList<User>();
		try {
			String preparedSql = "select id,password,name from User";
			conn = getConn(); // 得到数据库连接
			pstmt = conn.prepareStatement(preparedSql); // 得到PreparedStatement对象
			rs = pstmt.executeQuery(); // 执行SQL语句
			while (rs.next()) {
				User user=new User();
				user.setId(rs.getString(1));
				user.setPassword(rs.getString(2));
				user.setName(rs.getString(3));
				userList.add(user);
				}
			}catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} finally {
				super.closeAll(conn, pstmt, rs);
			}
			return userList;
	}
	public User getUser(String sql, String[] param) {
		User user=null;
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
			user=new User();
			user.setId(rs.getString(1));
			user.setPassword(rs.getString(2));
			user.setName(rs.getString(3));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			super.closeAll(conn, pstmt, rs);
		}
		return user;
	}
	public int updateUser(String sql, Object[] param) {
		int count = super.executeSQL(sql, param);
		return count;
	}

}
