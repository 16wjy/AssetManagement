package zuoye.java.assetManagement.service;

import java.util.List;

import zuoye.java.assetManagement.entity.*;
import zuoye.java.assetManagement.entity.*;
/**
 * 记录接口
 * @author Administrator
 *
 */
public interface Accountable {
	/**
	 * 查询借出信息
	 */
	public List<Account> account(String userId);

	/**
	 * 修改借出信息
	 */
	public int modifyAccount(String userId);

}
