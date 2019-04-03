package zuoye.java.assetManagement.service;

import zuoye.java.assetManagement.entity.*;
import java.util.List;


/**
 * 管理者接口
 * @author Administrator
 *
 */

public interface ManagerService {
	/**
	 * 管理员登录
	 */
	public Manager login();
	/**
	 * 查询所有资产
	 */
	public void getAllInAsset();
	/**
	 * 修改资产信息
	 */
	public int modifyAsset();
	/**
	 * 增加资产
	 * @return 
	 */
	public int addAsset();
	/**
	 * 删除资产信息
	 * @return
	 */
	public int deleteAsset();
}
