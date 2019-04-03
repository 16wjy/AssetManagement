package zuoye.java.assetManagement.entity;
/**
 * 管理员实体类
 * @author Administrator
 *
 */
public class Manager {
	/**
	 * 管理员Id
	 */
	private String id;
	/**
	 * 登陆密码
	 */
	private String password;
	/**
	 * 管理员姓名
	 */
	private String name;
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
	 * 获取管理员姓名
	 * @return
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置管理员姓名
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
}
