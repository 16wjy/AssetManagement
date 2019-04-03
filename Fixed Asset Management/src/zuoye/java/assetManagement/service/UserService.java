package zuoye.java.assetManagement.service;
import zuoye.java.assetManagement.entity.*;
import java.util.List;
/**
 * ʹ���߽ӿ�
 * @author Administrator
 *
 */
public interface UserService {
	/**
	 * ʹ���ߵ�½
	 */
	public User login();
	/**
	 * �û�ע��
	 */
	public void register();
	/**
	 * �޸�����
	 */
	public void changePassword(User user);
	/**
	 * ��ѯ�ѽ����ʲ���Ϣ
	 */
	public List<Account> queryAsset(String userId);
	/**
	 * ���������ʲ�
	 */
	public User applyAsset(User user);
	/**
	 * �黹�ʲ�
	 */
	public User returnAsset(User user);
}
