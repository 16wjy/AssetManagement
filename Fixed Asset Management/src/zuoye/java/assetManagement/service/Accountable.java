package zuoye.java.assetManagement.service;

import java.util.List;

import zuoye.java.assetManagement.entity.*;
import zuoye.java.assetManagement.entity.*;
/**
 * ��¼�ӿ�
 * @author Administrator
 *
 */
public interface Accountable {
	/**
	 * ��ѯ�����Ϣ
	 */
	public List<Account> account(String userId);

	/**
	 * �޸Ľ����Ϣ
	 */
	public int modifyAccount(String userId);

}
