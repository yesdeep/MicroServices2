package com.example.ansh.beans;

import io.swagger.annotations.ApiModelProperty;

public class Payment {

	@ApiModelProperty("The database generated payment ID")
	private String paymentId;
	@ApiModelProperty("The payment mode")
	private String paymentMode;
	@ApiModelProperty("The status of the payment")
	private Boolean paymentStatus;


	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public Boolean getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(Boolean paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
}
