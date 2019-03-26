package cn.com.taiji.demo.bean;

public class ChildBeanTwo {
	private String beanTwo;

	public String getBeanTwo() {
		return beanTwo;
	}

	public void setBeanTwo(String beanTwo) {
		this.beanTwo = beanTwo;
	}

	public ChildBeanTwo() {
		super();
	}
	public void start() {
		System.out.println("life start");
	}
	public void stop() {
		System.out.println("life stop");
	}
	

}
