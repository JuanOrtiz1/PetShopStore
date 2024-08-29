package com.sac.pet.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sac_tb_stock")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stock;

    @ManyToOne
    @JoinColumn(name = "PRODUCT", nullable = false)
    private Product product;

    @Column(name = "AMOUNT", nullable = false)
    private Double amount;

    @Column(name = "CONTAINER_TYPE")
    private String containerType;

    @Column(name = "UNIT_OF_MASS")
    private String unitOfMass;

    @Column(name = "STATUS_STOCK", nullable = false)
    private String statusStock;

    @Column(name = "CONTAINER_WEIGHT")
    private String containerWeight;

    @Column(name = "DATE_ADMISSION")
    private Date dateAdmission;

    @Column(name = "DUE_DATE")
    private Date dueDate;

	public Long getStock() {
		return stock;
	}

	public void setStock(Long stock) {
		this.stock = stock;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getContainerType() {
		return containerType;
	}

	public void setContainerType(String containerType) {
		this.containerType = containerType;
	}

	public String getUnitOfMass() {
		return unitOfMass;
	}

	public void setUnitOfMass(String unitOfMass) {
		this.unitOfMass = unitOfMass;
	}

	public String getStatusStock() {
		return statusStock;
	}

	public void setStatusStock(String statusStock) {
		this.statusStock = statusStock;
	}

	public String getContainerWeight() {
		return containerWeight;
	}

	public void setContainerWeight(String containerWeight) {
		this.containerWeight = containerWeight;
	}

	public Date getDateAdmission() {
		return dateAdmission;
	}

	public void setDateAdmission(Date dateAdmission) {
		this.dateAdmission = dateAdmission;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
}
