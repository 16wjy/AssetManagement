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
	private Connection conn = null; // �������ݿ�����

	private PreparedStatement pstmt = null; // ����ִ��SQL���

	private ResultSet rs = null; // �û������ѯ�����

	/* (non-Javadoc)
	 * @see cn.jbit.epetShop.dao.impl.PetOwnerDao#getAllOwner()
	 */
	public  List<Manager> getAllManager(){
		List<Manager> managerList = new ArrayList<Manager>();
		try {
		String preparedSql = "select id,password,name from Manager";
		conn =getConn(); // �õ����ݿ�����
		pstmt = conn.prepareStatement(preparedSql); // �õ�PreparedStatement����
		rs = pstmt.executeQuery(); // ִ��SQL���
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
		conn = getConn(); // �õ����ݿ�����
		pstmt = conn.prepareStatement(sql); // �õ�PreparedStatement����
		if (param != null) {
			for (int i = 0; i < param.length; i++) {
				pstmt.setString(i + 1, param[i]); // ΪԤ����sql���ò���
			}
		}
		rs = pstmt.executeQuery(); // ִ��SQL���
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
