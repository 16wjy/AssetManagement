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
 * �ʲ����ݿ������
 *
 */
public class AssetDaoImpl extends BaseDao implements AssetDao {
	private Connection conn = null; // �������ݿ�����

	private PreparedStatement pstmt = null; // ����ִ��SQL���

	private ResultSet rs = null; // �û������ѯ�����

	/* (non-Javadoc)
	 * @see cn.jbit.epetShop.dao.impl.PetDao#getAllPet()
	 */
	public  List<Asset> getAllAsset(){
		List<Asset> assetList = new ArrayList<Asset>();
		try {
			String preparedSql = "select name,type,buytime,price,state,life,id from Asset";
			conn = getConn(); // �õ����ݿ�����
			pstmt = conn.prepareStatement(preparedSql); // �õ�PreparedStatement����
			rs = pstmt.executeQuery(); // ִ��SQL���
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
		conn = getConn(); // �õ����ݿ�����
		pstmt = conn.prepareStatement(sql); // �õ�PreparedStatement����
		if (param != null) {
			for (int i = 0; i < param.length; i++) {
				pstmt.setString(i + 1, param[i]); // ΪԤ����sql���ò���
				}
			}
		rs = pstmt.executeQuery(); // ִ��SQL���
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
