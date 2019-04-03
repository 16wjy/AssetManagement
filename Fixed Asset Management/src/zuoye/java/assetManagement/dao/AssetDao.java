package zuoye.java.assetManagement.dao;
import zuoye.java.assetManagement.entity.*;
import java.util.List;

public interface AssetDao {
	/**
	 * ��ѯ�ʲ���Ϣ
	 */
	public abstract List<Asset> getAllAsset();

	/**
	 * ������֪��Ϣ��ѯ�ʲ���Ϣ
	 * 
	 **/
	public abstract List<Asset> selectAsset(String sql, String[] param);

	/**
	 * �����ʲ���Ϣ
	 */
	public abstract int updateAsset(String sql, Object[] param);
}
