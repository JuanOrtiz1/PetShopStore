package com.sac.pet.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sac_tb_product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long product;
	
	@Column(name = "NAME_PRODUCT")
	private String nameProduct;
	
	@Column(name = "CATEGORY")
	private String category;
	
	@Column(name = "PRESENTATION")
	private String presentation;
	
	@Column(name = "PARAM_SUPPLIER")
	private String paramSupplier;
	
	@Column(name = "PRODUCT_WEIGHT")
	private String productWeight;
	
	@Column(name = "PRODUCT_WEIGTH_TYPE")
	private String productWeightType;
	
	@Column(name = "PURCHASE_PRICE")
	private String purchasePrice;
	
	@Column(name = "SALE_PRICE")
	private String salePrice;
	
	@Column(name = "REVENUE")
	private String revenue;
	
	@Column(name = "STATUS")
	private String status;

	public Long getProduct() {
		return product;
	}

	public void setProduct(Long product) {
		this.product = product;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPresentation() {
		return presentation;
	}

	public void setPresentation(String presentation) {
		this.presentation = presentation;
	}

	public String getParamSupplier() {
		return paramSupplier;
	}

	public void setParamSupplier(String paramSupplier) {
		this.paramSupplier = paramSupplier;
	}

	public String getProductWeight() {
		return productWeight;
	}

	public void setProductWeight(String productWeight) {
		this.productWeight = productWeight;
	}

	public String getProductWeightType() {
		return productWeightType;
	}

	public void setProductWeightType(String productWeightType) {
		this.productWeightType = productWeightType;
	}

	public String getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(String purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public String getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(String salePrice) {
		this.salePrice = salePrice;
	}

	public String getRevenue() {
		return revenue;
	}

	public void setRevenue(String revenue) {
		this.revenue = revenue;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
