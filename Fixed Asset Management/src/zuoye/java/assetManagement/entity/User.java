package zuoye.java.assetManagement.entity;
import java.util.ArrayList;
import java.util.List;
/**
 * ʹ����ʵ����
 * @author Administrator
 *
 */
public class User {
	/**
	 * ʹ����Id
	 */
	private String id;
	/**
	 * ��½����
	 */
	private String password;
	/**
	 * ʹ��������
	 */
	private String name;
	/**
	 * ʹ���豸
	 */
	List<Asset> Assetlist = new ArrayList<Asset>();

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
	 * ��ȡ����
	 * @return
	 */
	public String getName() {
		return name;
	}
	/**
	 * ��������
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
}