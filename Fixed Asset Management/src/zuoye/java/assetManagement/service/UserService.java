package zuoye.java.assetManagement.service;
import zuoye.java.assetManagement.entity.*;
import java.util.List;
/**
 * 使用者接口
 * @author Administrator
 *
 */
public interface UserService {
	/**
	 * 使用者登陆
	 */
	public User login();
	/**
	 * 用户注册
	 */
	public void register();
	/**
	 * 修改密码
	 */
	public void changePassword(User user);
	/**
	 * 查询已借用资产信息
	 */
	public List<Account> queryAsset(String userId);
	/**
	 * 申请领用资产
	 */
	public User applyAsset(User user);
	/**
	 * 归还资产
	 */
	public User returnAsset(User user);
}
