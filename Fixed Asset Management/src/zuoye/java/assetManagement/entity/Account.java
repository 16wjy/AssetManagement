package zuoye.java.assetManagement.entity;
import java.util.Date;
public class Account {
	/**
	 * 资产借出时间
	 */
	private String time;
	/**
	 * 使用者标识符
	 */
	private String userId;
	/**
	 * 资产标识符
	 */
	private String assetId;
	
	/**
	 * 得到资产借出时间
	 * @return time
	 */
	public String getTime() {
		return time;
	}
	
	/**
	 * 设置资产借出时间
	 * @param time
	 */
	public void setTime(String time) {
		this.time = time;
	}
	/**
	 * 得到使用者标识符
	 * @return userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * 设置使用者标识符
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * 得到资产标识符
	 * @return assetId
	 */
	public String getAssetId() {
		return assetId;
	}
	/**
	 * 设置资产标识符
	 * @param assetId
	 */
	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}
}
