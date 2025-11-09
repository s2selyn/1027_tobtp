package com.kh.spring.product.model.vo;

import java.util.Objects;

public class Product {
	private int productNo;
	private String productName;
	private int price;
	private int categoryNo;
	private int memberNo;
	private String detailContent;
	private String fileOriginName;
	private String changeName;
	private int count;
	public Product() {
		super();
	}
	public Product(int productNo, String productName, int price, int categoryNo, int memberNo, String detailContent,
			String fileOriginName, String changeName, int count) {
		super();
		this.productNo = productNo;
		this.productName = productName;
		this.price = price;
		this.categoryNo = categoryNo;
		this.memberNo = memberNo;
		this.detailContent = detailContent;
		this.fileOriginName = fileOriginName;
		this.changeName = changeName;
		this.count = count;
	}
	public int getProductNo() {
		return productNo;
	}
	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getDetailContent() {
		return detailContent;
	}
	public void setDetailContent(String detailContent) {
		this.detailContent = detailContent;
	}
	public String getFileOriginName() {
		return fileOriginName;
	}
	public void setFileOriginName(String fileOriginName) {
		this.fileOriginName = fileOriginName;
	}
	public String getChangeName() {
		return changeName;
	}
	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public int hashCode() {
		return Objects.hash(categoryNo, changeName, count, detailContent, fileOriginName, memberNo, price, productName,
				productNo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return categoryNo == other.categoryNo && Objects.equals(changeName, other.changeName) && count == other.count
				&& Objects.equals(detailContent, other.detailContent)
				&& Objects.equals(fileOriginName, other.fileOriginName) && memberNo == other.memberNo
				&& price == other.price && Objects.equals(productName, other.productName)
				&& productNo == other.productNo;
	}
	@Override
	public String toString() {
		return "Product [productNo=" + productNo + ", productName=" + productName + ", price=" + price + ", categoryNo="
				+ categoryNo + ", memberNo=" + memberNo + ", detailContent=" + detailContent + ", fileOriginName="
				+ fileOriginName + ", changeName=" + changeName + ", count=" + count + "]";
	}
	
}
