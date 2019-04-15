/** 
 * @ClassName:     Dictionary.java 
 * @author         MengJinyue
 * @Date           2016年6月1日 下午1:41:33 
 */

package com.lc.util;

public class Season{
	private final String seasonName;
	private final String seasonDesc;
	
	private Season(String seasonName,String seasonDesc){
		this.seasonName = seasonName;
		this.seasonDesc = seasonDesc;
	}

	public String getSeasonName() {
		return seasonName;
	}

	public String getSeasonDesc() {
		return seasonDesc;
	}
	
	public static final Season NOT_USERID = new Season("not_userid","未获取到用户ID");
	public static final Season NOT_PASSWORDANDUSERNAME = new Season("not_passwordandusername", "用户名与密码不匹配");
	public static final Season LOGIN_SUCCESS = new Season("login_success", "登录成功");
	public static final Season NOT_USERNAME = new Season("not_username", "未获取到用户名");
	public static final Season NOT_PASSWORD = new Season("not_password", "原密码错误");
	public static final Season NOT_REGISTER = new Season("not_register", "用户名未注册");
	public static final Season ALEARDY_REGISTER = new Season("aleardy_register", "用户名已注册");
	public static final Season NOT_VALIDATE = new Season("not_validate", "验证码错误");
	
	public static final Season ADD_SUCCESS = new Season("add_success", "添加成功");
	public static final Season NOT_ADD = new Season("not_add", "添加失败");
	
	public static final Season DEL_SUCCESS = new Season("del_success", "删除成功");
	public static final Season NOT_DEL = new Season("not_del", "删除失败");
	
	public static final Season EDIT_SUCCESS = new Season("edit_success", "修改成功");
	public static final Season NOT_EDIT = new Season("not_edit", "修改失败");
	
	public static final Season SUBMIT_SUCCESS = new Season("submit_success", "提交成功");
	public static final Season NOT_SUBMIT = new Season("not_submit", "提交失败");
	
	public static final Season ATTENTION_SUCCESS = new Season("attention_success", "关注成功");
	public static final Season NOT_ATTENTION = new Season("not_attention", "关注失败");
	
	public static final Season CANCEL_SUCCESS = new Season("cancel_success", "取消成功");
	public static final Season NOT_CANCEL = new Season("not_cancel", "取消失败");
	
	public static final Season COLLECT_SUCCESS = new Season("collect_success", "收藏成功");
	public static final Season NOT_COLLECT = new Season("not_collect", "收藏失败");
	
	public static final Season PRAISE_SUCCESS = new Season("praise_success", "点赞成功");
	public static final Season NOT_PRAISE = new Season("not_praise", "点赞失败");
	
	@Override
	public String toString() {
		return "Season [seasonName=" + seasonName + ", seasonDesc=" + seasonDesc + ", getSeasonName()="
				+ getSeasonName() + ", getSeasonDesc()=" + getSeasonDesc() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}
