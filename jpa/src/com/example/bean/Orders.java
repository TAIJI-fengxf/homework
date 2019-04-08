package com.example.bean;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 多对一的订单
 * @author zhd
 *
 */
@Entity
@Table(name="orders")
public class Orders {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="number")
	private String number;

	private Date date;
	
	@ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
	@JoinColumn(name="account_id")
	private Account account;

	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Orders(String number, Date date, Account account) {
		super();
		this.number = number;
		this.date = date;
		this.account = account;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", number=" + number + ", date=" + date + ", account=" + account + "]";
	}
	
	
}
