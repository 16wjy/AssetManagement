package zuoye.java.assetManagement.entity;
import java.util.Date;
public class Account {
	/**
	 * �ʲ����ʱ��
	 */
	private String time;
	/**
	 * ʹ���߱�ʶ��
	 */
	private String userId;
	/**
	 * �ʲ���ʶ��
	 */
	private String assetId;
	
	/**
	 * �õ��ʲ����ʱ��
	 * @return time
	 */
	public String getTime() {
		return time;
	}
	
	/**
	 * �����ʲ����ʱ��
	 * @param time
	 */
	public void setTime(String time) {
		this.time = time;
	}
	/**
	 * �õ�ʹ���߱�ʶ��
	 * @return userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * ����ʹ���߱�ʶ��
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * �õ��ʲ���ʶ��
	 * @return assetId
	 */
	public String getAssetId() {
		return assetId;
	}
	/**
	 * �����ʲ���ʶ��
	 * @param assetId
	 */
	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}
}
