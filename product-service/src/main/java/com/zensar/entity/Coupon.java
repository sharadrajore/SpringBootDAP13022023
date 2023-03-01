package com.zensar.entity;

import java.math.BigDecimal;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Coupon {

	private int couponId;
	private String couponCode;
	private BigDecimal discount;
	private String expDate;

}
