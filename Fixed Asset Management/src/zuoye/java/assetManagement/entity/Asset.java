 package zuoye.java.assetManagement.entity;
import java.util.Date;
/**
 * 固定资产实体类
 * 
 */
public class Asset {
	/**
	 * 资产名称
	 */
	private String name;
	/**
	 * 资产类型
	 * 
	 */
	private String type;
	/**
	 * 资产买入时间
	 * 
	 */
	private String buytime;
	/**
	 * 资产价格
	 * 
	 */
	private String price;
	/**
	 * 资产目前状态；
	 * 
	 */
	private String state;
	/**
	 * 资产寿命(单位：月)
	 */
	private int life;
	/**
	 * 资产Id
	 */
	private int id;
	/**
	 * 获取资产名称
	 * @return name
	 */
	public String getName() {
		return name;
	}
    /**
     * 设置资产名称
     * @param name
     */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取资产类型
	 * @return type
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置资产类型
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取买入时间
	 * @return buytime
	 */
	public String getBuytime() {
		return buytime;
	}
	/**
	 * 设置买入时间
	 * @param buytime
	 */
	public void setBuytime(String buytime) {
		this.buytime = buytime;
	}
	/**
	 * 获取资产价格
	 * @return price
	 */
	public String getPrice() {
		return price;
	}
	/**
	 * 设置资产价格
	 * @param price
	 */
	public void setPrice(String price) {
		this.price = price;
	}
	/**
	 * 获取资产状态
	 * @return
	 */
	public String getState() {
		return state;
	}
	/**
	 * 设置资产状态
	 * @param state
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * 获得资产寿命
	 * @return
	 */
	public int getLife() {
		return life;
	}
	/**
	 * 设置资产寿命
	 * @param life
	 */
	public void setLife(int life) {
		this.life = life;
	}
	/**
	 * 获得资产Id
	 * @return number
	 */
	public int getId() {
		return id;
	}
	/**
	 * 设置资产Id
	 * @param number
	 */
	public void setId(int id) {
		this.id = id;
	}
}
