package cn.com.taiji.demo.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class LifeBean implements InitializingBean,DisposableBean{
	
	public void start() {
		System.out.println("start lifeBean");
	}
	public void end() {
		System.out.println("end lifeBean");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("destroy lifeBean");
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("init lifeBean");
		
	}

}
