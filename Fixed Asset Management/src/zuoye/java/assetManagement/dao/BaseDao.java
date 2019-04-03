package zuoye.java.assetManagement.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

import zuoye.java.assetManagement.dao.BaseDao;

/**
 * 数据库操作基类
 */
public class BaseDao {

	
	Connection conn = null;// 数据连接对象
	
	

	/**
	 * 得到数据库连接
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @return 数据库连接
	 */
	public Connection getConn() throws ClassNotFoundException, SQLException {
		String DRIVER="com.mysql.jdbc.Driver"; // 数据库驱动

		Connection conn = null;
		try {
			Class.forName(DRIVER); // 注册驱动
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sss;DatabaseName=Manager","root","123456"
); // 获得数据库连接
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn; // 返回连接
	}

	/**
	 * 释放资源
	 * 
	 * @param conn
	 *            数据库连接
	 * @param pstmt
	 *            PreparedStatement对象
	 * @param rs
	 *            结果集
	 */
	public void closeAll(Connection conn, PreparedStatement pstmt, ResultSet rs) {

		/* 如果rs不空，关闭rs */
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		/* 如果pstmt不空，关闭pstmt */
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		/* 如果conn不空，关闭conn */
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}


	/**
	 * 执行SQL语句，可以进行增、删、改的操作，不能执行查询
	 * 
	 * @param sql
	 *            预编译的 SQL 语句
	 * @param param
	 *            预编译的 SQL 语句中的‘？’参数的字符串数组
	 * @return 影响的条数
	 */
	public int executeSQL(String preparedSql, Object[] param) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int num = 0;

		/* 处理SQL,执行SQL */
		try {
			conn = getConn(); // 得到数据库连接
			pstmt = conn.prepareStatement(preparedSql); // 得到PreparedStatement对象
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					pstmt.setObject(i + 1, param[i]); // 为预编译sql设置参数
				}
			}
			// System.out.println(preparedSql);
			num = pstmt.executeUpdate(); // 执行SQL语句
		} catch (ClassNotFoundException e) {
			e.printStackTrace(); // 处理ClassNotFoundException异常
		} catch (SQLException e) {
			e.printStackTrace(); // 处理SQLException异常
		} finally {
			this.closeAll(conn, pstmt, null);
		}
		return num;
	}
}