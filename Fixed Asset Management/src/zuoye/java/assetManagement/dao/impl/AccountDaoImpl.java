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
 * 宠物商店台账信息数据库操作类
 */
public class AccountDaoImpl extends BaseDao implements AccountDao {
	private Connection conn = null; // 保存数据库连接

	private PreparedStatement pstmt = null; // 用于执行SQL语句

	private ResultSet rs = null; // 用户保存查询结果集

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
			conn = getConn(); // 得到数据库连接
			pstmt = conn.prepareStatement(sql); // 得到PreparedStatement对象
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					pstmt.setString(i + 1, param[i]); // 为预编译sql设置参数
				}
			}
			rs = pstmt.executeQuery(); // 执行SQL语句
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
			conn = getConn(); // 得到数据库连接
			pstmt = conn.prepareStatement(preparedSql); // 得到PreparedStatement对象
			rs = pstmt.executeQuery(); // 执行SQL语句
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
