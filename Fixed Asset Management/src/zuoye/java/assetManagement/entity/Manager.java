package zuoye.java.assetManagement.entity;
/**
 * ����Աʵ����
 * @author Administrator
 *
 */
public class Manager {
	/**
	 * ����ԱId
	 */
	private String id;
	/**
	 * ��½����
	 */
	private String password;
	/**
	 * ����Ա����
	 */
	private String name;
	/**
	 * ��ȡid
	 * @return
	 */
	public String getId() {
		return id;
	}
	/**
	 * ����id
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * ��ȡ��½����
	 * @return
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * ���õ�½����
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * ��ȡ����Ա����
	 * @return
	 */
	public String getName() {
		return name;
	}
	/**
	 * ���ù���Ա����
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
}
