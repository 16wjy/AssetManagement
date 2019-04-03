package zuoye.java.assetManagement.entity;
import java.util.ArrayList;
import java.util.List;
/**
 * 使用者实体类
 * @author Administrator
 *
 */
public class User {
	/**
	 * 使用者Id
	 */
	private String id;
	/**
	 * 登陆密码
	 */
	private String password;
	/**
	 * 使用者姓名
	 */
	private String name;
	/**
	 * 使用设备
	 */
	List<Asset> Assetlist = new ArrayList<Asset>();

	/**
	 * 获取id
	 * @return
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置id
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取登陆密码
	 * @return
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 设置登陆密码
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 获取姓名
	 * @return
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置姓名
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
}