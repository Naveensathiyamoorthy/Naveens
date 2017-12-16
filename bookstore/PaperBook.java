package com.bookstore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class PaperBook extends Book {
	@Column
	private float shippingWeight;
	@Column
	private int instock;

	public float getShippingWeight() {
		return shippingWeight;
	}

	public void setShippingWeight(float shippingWeight) {
		this.shippingWeight = shippingWeight;
	}

	public int getInstock() {
		return instock;
	}

	public void setInstock(int instock) {
		this.instock = instock;
	}

}
