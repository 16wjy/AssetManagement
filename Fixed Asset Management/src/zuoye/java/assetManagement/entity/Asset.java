 package zuoye.java.assetManagement.entity;
import java.util.Date;
/**
 * �̶��ʲ�ʵ����
 * 
 */
public class Asset {
	/**
	 * �ʲ�����
	 */
	private String name;
	/**
	 * �ʲ�����
	 * 
	 */
	private String type;
	/**
	 * �ʲ�����ʱ��
	 * 
	 */
	private String buytime;
	/**
	 * �ʲ��۸�
	 * 
	 */
	private String price;
	/**
	 * �ʲ�Ŀǰ״̬��
	 * 
	 */
	private String state;
	/**
	 * �ʲ�����(��λ����)
	 */
	private int life;
	/**
	 * �ʲ�Id
	 */
	private int id;
	/**
	 * ��ȡ�ʲ�����
	 * @return name
	 */
	public String getName() {
		return name;
	}
    /**
     * �����ʲ�����
     * @param name
     */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * ��ȡ�ʲ�����
	 * @return type
	 */
	public String getType() {
		return type;
	}
	/**
	 * �����ʲ�����
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * ��ȡ����ʱ��
	 * @return buytime
	 */
	public String getBuytime() {
		return buytime;
	}
	/**
	 * ��������ʱ��
	 * @param buytime
	 */
	public void setBuytime(String buytime) {
		this.buytime = buytime;
	}
	/**
	 * ��ȡ�ʲ��۸�
	 * @return price
	 */
	public String getPrice() {
		return price;
	}
	/**
	 * �����ʲ��۸�
	 * @param price
	 */
	public void setPrice(String price) {
		this.price = price;
	}
	/**
	 * ��ȡ�ʲ�״̬
	 * @return
	 */
	public String getState() {
		return state;
	}
	/**
	 * �����ʲ�״̬
	 * @param state
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * ����ʲ�����
	 * @return
	 */
	public int getLife() {
		return life;
	}
	/**
	 * �����ʲ�����
	 * @param life
	 */
	public void setLife(int life) {
		this.life = life;
	}
	/**
	 * ����ʲ�Id
	 * @return number
	 */
	public int getId() {
		return id;
	}
	/**
	 * �����ʲ�Id
	 * @param number
	 */
	public void setId(int id) {
		this.id = id;
	}
}
