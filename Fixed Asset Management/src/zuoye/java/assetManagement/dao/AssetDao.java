package zuoye.java.assetManagement.dao;
import zuoye.java.assetManagement.entity.*;
import java.util.List;

public interface AssetDao {
	/**
	 * 查询资产信息
	 */
	public abstract List<Asset> getAllAsset();

	/**
	 * 根据已知信息查询资产信息
	 * 
	 **/
	public abstract List<Asset> selectAsset(String sql, String[] param);

	/**
	 * 更新资产信息
	 */
	public abstract int updateAsset(String sql, Object[] param);
}
