package com.lc.bean;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;


/**
 *  @描述:编辑商品（即：材料）
 ** @author MengJinyue   
 *  创建时间：2017-12-7 下午02:26:12 
 */
public class CommodityBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cm_id;
	private String s_id;				//店铺id
	private String r_id;				//材料类型id
	private String cm_name;				//商品名称
	private String cm_price;			//商品价格
	private String remark;				//详情描述
	private String paramterSpec[];		//产品参数key
	private String paramterSpecValue[];	//产品参数value
	private String saleSpec;			//第一个销售属性ke
	private String saleSpecValue[];		//第一个销售属性value
	private String saleSpecTwo;			//第二个销售属性key
	private String saleSpecValueTwo[];	//第二个销售属性value
	private MultipartFile cover_picture[];//封面图片
	private MultipartFile detail_picture[];//详情图片
	private String sku_id[];				//库存id
	private String cmc_price[];				//商品价格
	private String stock_num[];				//库存量
	private MultipartFile cmc_picture[];	//商品图片
	
	public String getCm_id() {
		return cm_id;
	}
	public void setCm_id(String cm_id) {
		this.cm_id = cm_id;
	}
	public String getS_id() {
		return s_id;
	}
	public void setS_id(String s_id) {
		this.s_id = s_id;
	}
	public String getR_id() {
		return r_id;
	}
	public void setR_id(String r_id) {
		this.r_id = r_id;
	}
	public String getCm_name() {
		return cm_name;
	}
	public void setCm_name(String cm_name) {
		this.cm_name = cm_name;
	}
	public String getCm_price() {
		return cm_price;
	}
	public void setCm_price(String cm_price) {
		this.cm_price = cm_price;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String[] getParamterSpec() {
		return paramterSpec;
	}
	public void setParamterSpec(String[] paramterSpec) {
		this.paramterSpec = paramterSpec;
	}
	public String[] getParamterSpecValue() {
		return paramterSpecValue;
	}
	public void setParamterSpecValue(String[] paramterSpecValue) {
		this.paramterSpecValue = paramterSpecValue;
	}
	public String getSaleSpec() {
		return saleSpec;
	}
	public void setSaleSpec(String saleSpec) {
		this.saleSpec = saleSpec;
	}
	public String[] getSaleSpecValue() {
		return saleSpecValue;
	}
	public void setSaleSpecValue(String[] saleSpecValue) {
		this.saleSpecValue = saleSpecValue;
	}
	public String getSaleSpecTwo() {
		return saleSpecTwo;
	}
	public void setSaleSpecTwo(String saleSpecTwo) {
		this.saleSpecTwo = saleSpecTwo;
	}
	public String[] getSaleSpecValueTwo() {
		return saleSpecValueTwo;
	}
	public void setSaleSpecValueTwo(String[] saleSpecValueTwo) {
		this.saleSpecValueTwo = saleSpecValueTwo;
	}
	public MultipartFile[] getCover_picture() {
		return cover_picture;
	}
	public void setCover_picture(MultipartFile[] cover_picture) {
		this.cover_picture = cover_picture;
	}
	public MultipartFile[] getDetail_picture() {
		return detail_picture;
	}
	public void setDetail_picture(MultipartFile[] detail_picture) {
		this.detail_picture = detail_picture;
	}
	public String[] getSku_id() {
		return sku_id;
	}
	public void setSku_id(String[] sku_id) {
		this.sku_id = sku_id;
	}
	public String[] getCmc_price() {
		return cmc_price;
	}
	public void setCmc_price(String[] cmc_price) {
		this.cmc_price = cmc_price;
	}
	public String[] getStock_num() {
		return stock_num;
	}
	public void setStock_num(String[] stock_num) {
		this.stock_num = stock_num;
	}
	public MultipartFile[] getCmc_picture() {
		return cmc_picture;
	}
	public void setCmc_picture(MultipartFile[] cmc_picture) {
		this.cmc_picture = cmc_picture;
	}
}
