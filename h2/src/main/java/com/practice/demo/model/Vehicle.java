package com.practice.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Vehicle {
	@Id
	@Column(name="vehicleId")
	private int id;
	
	@Column(name = "vehicleName")
	private String name;
	
	@Column(name = "vehicleprice")
	private int price;
}
