package zuoye.java.assetManagement.dao.impl;
import zuoye.java.assetManagement.dao.*;
import zuoye.java.assetManagement.entity.Asset;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;




/**
 * 资产数据库操作类
 *
 */
public class AssetDaoImpl extends BaseDao implements AssetDao {
	private Connection conn = null; // 保存数据库连接

	private PreparedStatement pstmt = null; // 用于执行SQL语句

	private ResultSet rs = null; // 用户保存查询结果集

	/* (non-Javadoc)
	 * @see cn.jbit.epetShop.dao.impl.PetDao#getAllPet()
	 */
	public  List<Asset> getAllAsset(){
		List<Asset> assetList = new ArrayList<Asset>();
		try {
			String preparedSql = "select name,type,buytime,price,state,life,id from Asset";
			conn = getConn(); // 得到数据库连接
			pstmt = conn.prepareStatement(preparedSql); // 得到PreparedStatement对象
			rs = pstmt.executeQuery(); // 执行SQL语句
			while (rs.next()) {

				Asset asset=new Asset();
				asset.setName(rs.getString(1));
				asset.setType(rs.getString(2));
				asset.setBuytime(rs.getString(3));
				asset.setPrice(rs.getString(4));
				asset.setState(rs.getString(5));
				asset.setLife(rs.getInt(6));
				asset.setId(rs.getInt(7));
				assetList.add(asset);
				}
			}catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} finally {
				super.closeAll(conn, pstmt, rs);
			}
			return assetList;
	}
	public  List<Asset> selectAsset(String sql, String[] param){
		List<Asset> assetList = new ArrayList<Asset>();
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
			Asset asset=new Asset();
			asset.setName(rs.getString(1));
			asset.setType(rs.getString(2));
			asset.setBuytime(rs.getString(3));
			asset.setPrice(rs.getString(4));
			asset.setState(rs.getString(5));
			asset.setLife(rs.getInt(6));
			asset.setId(rs.getInt(7));
			assetList.add(asset);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			super.closeAll(conn, pstmt, rs);
		}
		return assetList;
	}
	public  int updateAsset(String sql, Object[] param) {
		int count = super.executeSQL(sql, param);
		return count;
	}
}
