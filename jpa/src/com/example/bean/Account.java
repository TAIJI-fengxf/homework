package com.example.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 一对多的顾客
 * @author zhd
 *
 */
@Entity
@Table(name="account")
public class Account {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable=false,length=20)
	private String name;
	@Column
	private String pwd;
	@OneToMany(mappedBy = "account",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private List<Orders> ordersList;
	
	
	public Account(String name, String pwd, List<Orders> ordersList) {
		super();
		this.name = name;
		this.pwd = pwd;
		this.ordersList = ordersList;
	}
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public List<Orders> getOrdersList() {
		return ordersList;
	}
	public void setOrdersList(List<Orders> ordersList) {
		this.ordersList = ordersList;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", pwd=" + pwd + ", ordersList=" + ordersList + "]";
	}
	
	
}
