package cn.com.taiji.demo.bean;

public class ParentBean {
	private ChildBeanOne beanOne;
	private ChildBeanTwo beanTwo;
	private int i;
	public ChildBeanOne getBeanOne() {
		return beanOne;
	}
	public void setBeanOne(ChildBeanOne beanOne) {
		this.beanOne = beanOne;
	}
	public ChildBeanTwo getBeanTwo() {
		return beanTwo;
	}
	public void setBeanTwo(ChildBeanTwo beanTwo) {
		this.beanTwo = beanTwo;
	}
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public ParentBean() {
		super();
	}
	public ParentBean(ChildBeanOne beanOne, ChildBeanTwo beanTwo, int i) {
		super();
		this.beanOne = beanOne;
		this.beanTwo = beanTwo;
		this.i = i;
	}
	
	

}
