/*
 * Copyright 2010-2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.lhfei.monitor.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @version 0.1
 *
 * @author Hefei Li
 *
 * @created on Oct 22, 2019
 */
public class YellowTripdata implements Serializable {
	private static final long serialVersionUID = 829003563490328165L;
	
	public Integer getVendorID() {
		return VendorID;
	}
	public void setVendorID(Integer vendorID) {
		VendorID = vendorID;
	}
	public Date getTpep_pickup_datetime() {
		return tpep_pickup_datetime;
	}
	public void setTpep_pickup_datetime(Date tpep_pickup_datetime) {
		this.tpep_pickup_datetime = tpep_pickup_datetime;
	}
	public Date getTpep_dropoff_datetime() {
		return tpep_dropoff_datetime;
	}
	public void setTpep_dropoff_datetime(Date tpep_dropoff_datetime) {
		this.tpep_dropoff_datetime = tpep_dropoff_datetime;
	}
	public double getPassenger_count() {
		return passenger_count;
	}
	public void setPassenger_count(double passenger_count) {
		this.passenger_count = passenger_count;
	}
	public double getTrip_distance() {
		return trip_distance;
	}
	public void setTrip_distance(double trip_distance) {
		this.trip_distance = trip_distance;
	}
	public Integer getRatecodeID() {
		return RatecodeID;
	}
	public void setRatecodeID(Integer ratecodeID) {
		RatecodeID = ratecodeID;
	}
	public String getStore_and_fwd_flag() {
		return store_and_fwd_flag;
	}
	public void setStore_and_fwd_flag(String store_and_fwd_flag) {
		this.store_and_fwd_flag = store_and_fwd_flag;
	}
	public Integer getPULocationID() {
		return PULocationID;
	}
	public void setPULocationID(Integer pULocationID) {
		PULocationID = pULocationID;
	}
	public Integer getDOLocationID() {
		return DOLocationID;
	}
	public void setDOLocationID(Integer dOLocationID) {
		DOLocationID = dOLocationID;
	}
	public Integer getPayment_type() {
		return payment_type;
	}
	public void setPayment_type(Integer payment_type) {
		this.payment_type = payment_type;
	}
	public double getFare_amount() {
		return fare_amount;
	}
	public void setFare_amount(double fare_amount) {
		this.fare_amount = fare_amount;
	}
	public double getExtra() {
		return extra;
	}
	public void setExtra(double extra) {
		this.extra = extra;
	}
	public double getMta_tax() {
		return mta_tax;
	}
	public void setMta_tax(double mta_tax) {
		this.mta_tax = mta_tax;
	}
	public double getTip_amount() {
		return tip_amount;
	}
	public void setTip_amount(double tip_amount) {
		this.tip_amount = tip_amount;
	}
	public double getTolls_amount() {
		return tolls_amount;
	}
	public void setTolls_amount(double tolls_amount) {
		this.tolls_amount = tolls_amount;
	}
	public double getImprovement_surcharge() {
		return improvement_surcharge;
	}
	public void setImprovement_surcharge(double improvement_surcharge) {
		this.improvement_surcharge = improvement_surcharge;
	}
	public double getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(double total_amount) {
		this.total_amount = total_amount;
	}
	
	private Integer VendorID		     ;
	private Date tpep_pickup_datetime  ;
	private Date tpep_dropoff_datetime ;
	private double passenger_count	     ;
	private double trip_distance	     ;
	private Integer RatecodeID	     ;
	private String store_and_fwd_flag    ;
	private Integer PULocationID	     ;
	private Integer DOLocationID	     ;
	private Integer payment_type	     ;
	private double fare_amount	     ;
	private double extra		     ;
	private double mta_tax		     ;
	private double tip_amount	     ;
	private double tolls_amount	     ;
	private double improvement_surcharge ;
	private double total_amount	     ;
}
