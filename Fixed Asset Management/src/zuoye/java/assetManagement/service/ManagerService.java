package zuoye.java.assetManagement.service;

import zuoye.java.assetManagement.entity.*;
import java.util.List;


/**
 * �����߽ӿ�
 * @author Administrator
 *
 */

public interface ManagerService {
	/**
	 * ����Ա��¼
	 */
	public Manager login();
	/**
	 * ��ѯ�����ʲ�
	 */
	public void getAllInAsset();
	/**
	 * �޸��ʲ���Ϣ
	 */
	public int modifyAsset();
	/**
	 * �����ʲ�
	 * @return 
	 */
	public int addAsset();
	/**
	 * ɾ���ʲ���Ϣ
	 * @return
	 */
	public int deleteAsset();
}
