package com.lc.bean;


/**
 * @描述：案例-全景图
 ** @author MengJinyue   
 *  创建时间：2017-12-6 下午01:22:40 
 */
public class CasePanoramaBean{
	/**
	 * 注：缺一个擅长风格字段，暂时待定
	 */
	private Long cp_id;					//案例id
	private String au_id;				//用户id
	private String d_id;				//订单号
	private String title;				//标题
	private String city;				//城市
    private String address;			    //小区名称
	private String house_type;			//户型
	private String static_picture;		//静态全景图
	private String dynamic_picture; 	//动态全景图
	private Integer r_id;				//装修类型（多个之间“，”拼接）
	private String create_time;			//创建时间
	private String s_name;			//店铺名称
	private String s_logo;			//店铺头像
	private String s_type;			//店铺类型
	private int bid_num;			//中标次数
	private String work_year;		//参加工作年份
	private String s_province;		//店铺所在省
	private String s_city;			//店铺所在城市
	private String applause_rate;		//店铺的好评率
	private String expert_type;			//擅长风格
	
	public Long getCp_id() {
		return cp_id;
	}
	public void setCp_id(Long cp_id) {
		this.cp_id = cp_id;
	}
	public String getAu_id() {
		return au_id;
	}
	public void setAu_id(String au_id) {
		this.au_id = au_id;
	}
	public String getD_id() {
		return d_id;
	}
	public void setD_id(String d_id) {
		this.d_id = d_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getHouse_type() {
		return house_type;
	}
	public void setHouse_type(String house_type) {
		this.house_type = house_type;
	}
	public String getStatic_picture() {
		return static_picture;
	}
	public void setStatic_picture(String static_picture) {
		this.static_picture = static_picture;
	}
	public String getDynamic_picture() {
		return dynamic_picture;
	}
	public void setDynamic_picture(String dynamic_picture) {
		this.dynamic_picture = dynamic_picture;
	}
	public Integer getR_id() {
		return r_id;
	}
	public void setR_id(Integer r_id) {
		this.r_id = r_id;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public String getS_logo() {
		return s_logo;
	}
	public void setS_logo(String s_logo) {
		this.s_logo = s_logo;
	}
	public int getBid_num() {
		return bid_num;
	}
	public void setBid_num(int bid_num) {
		this.bid_num = bid_num;
	}
	public String getWork_year() {
		if (work_year == null) {
			work_year = "";
		}
		return work_year;
	}
	public void setWork_year(String work_year) {
		this.work_year = work_year;
	}
	public String getS_province() {
		return s_province;
	}
	public void setS_province(String s_province) {
		this.s_province = s_province;
	}
	public String getS_city() {
		return s_city;
	}
	public void setS_city(String s_city) {
		this.s_city = s_city;
	}
	public String getApplause_rate() {
		if (applause_rate == null) {
			applause_rate = "100";
		}
		return applause_rate;
	}
	public void setApplause_rate(String applause_rate) {
		this.applause_rate = applause_rate;
	}
	public String getExpert_type() {
		return expert_type;
	}
	public void setExpert_type(String expert_type) {
		this.expert_type = expert_type;
	}
	public String getS_type() {
		return s_type;
	}
	public void setS_type(String s_type) {
		this.s_type = s_type;
	}
}
