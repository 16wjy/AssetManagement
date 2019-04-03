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
 * ʹ�������ݿ������
 * @author Administrator
 *
 */
public class UserDaoImpl extends BaseDao implements UserDao {
	private Connection conn = null; // �������ݿ�����

	private PreparedStatement pstmt = null; // ����ִ��SQL���

	private ResultSet rs = null; // �û������ѯ�����

	/* (non-Javadoc)
	 * @see cn.jbit.epetShop.dao.impl.PetDao#getAllPet()
	 */
	public List<User> getAllUser(){
		List<User> userList = new ArrayList<User>();
		try {
			String preparedSql = "select id,password,name from User";
			conn = getConn(); // �õ����ݿ�����
			pstmt = conn.prepareStatement(preparedSql); // �õ�PreparedStatement����
			rs = pstmt.executeQuery(); // ִ��SQL���
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
		conn = getConn(); // �õ����ݿ�����
		pstmt = conn.prepareStatement(sql); // �õ�PreparedStatement����
		if (param != null) {
			for (int i = 0; i < param.length; i++) {
				pstmt.setString(i + 1, param[i]); // ΪԤ����sql���ò���
				}
			}
		rs = pstmt.executeQuery(); // ִ��SQL���
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
