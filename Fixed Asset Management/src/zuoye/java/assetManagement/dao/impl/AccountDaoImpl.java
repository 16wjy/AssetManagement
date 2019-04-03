/**
 * 
 */
package zuoye.java.assetManagement.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import zuoye.java.assetManagement.dao.*;
import zuoye.java.assetManagement.entity.*;

/**
 * �����̵�̨����Ϣ���ݿ������
 */
public class AccountDaoImpl extends BaseDao implements AccountDao {
	private Connection conn = null; // �������ݿ�����

	private PreparedStatement pstmt = null; // ����ִ��SQL���

	private ResultSet rs = null; // �û������ѯ�����

	/* (non-Javadoc)
	 * @see cn.jbit.epetShop.dao.impl.AccountDao#updateAccount(java.lang.String, java.lang.Object[])
	 */
	public int updateAccount(String sql, Object[] param) {
		int count = super.executeSQL(sql, param);
		return count;
	}

	/* (non-Javadoc)
	 * @see cn.jbit.epetShop.dao.impl.AccountDao#getPetStoreAccount(java.lang.String, java.lang.String[])
	 */
	public List<Account> getAccount(String sql, String[] param) {
		List<Account> accountList = new ArrayList<Account>();
		try {
			conn = getConn(); // �õ����ݿ�����
			pstmt = conn.prepareStatement(sql); // �õ�PreparedStatement����
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					pstmt.setString(i + 1, param[i]); // ΪԤ����sql���ò���
				}
			}
			rs = pstmt.executeQuery(); // ִ��SQL���
			Account account = null;
			while (rs.next()) {
				account = new Account();
				account.setTime(rs.getString(1));
				account.setUserId(rs.getString(2));
				account.setAssetId(rs.getString(3));
				accountList.add(account);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			super.closeAll(conn, pstmt, rs);
		}
		return accountList;
	}
	/*public List<Account> getAllAccount(){
		List<Account> accountList = new ArrayList<Account>();
		try {
			String preparedSql = "select time,userId,assetId,number ";
			conn = getConn(); // �õ����ݿ�����
			pstmt = conn.prepareStatement(preparedSql); // �õ�PreparedStatement����
			rs = pstmt.executeQuery(); // ִ��SQL���
			while (rs.next()) {
				Account account=new Account();
				account.setTime(rs.getString(1));
				account.setUserId(rs.getString(2));
				account.setAssetId(rs.getString(3));
				account.setNumber(rs.getInt(4));
				accountList.add(account);
				}
			}catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} finally {
				super.closeAll(conn, pstmt, rs);
			}
			return accountList;
	}*/
}
