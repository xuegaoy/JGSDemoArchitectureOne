package com.sishuok.architecture1.customermgr;



import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sishuok.architecture1.customermgr.service.ICustomerService;
import com.sishuok.architecture1.customermgr.vo.CustomerModel;
import com.sishuok.architecture1.customermgr.vo.CustomerQueryModel;
import com.sishuok.pageutil.Page;

@Service
@Transactional
public class Client {
	
	@Autowired
//    private CustomerDAO dao=null;
	private ICustomerService s = null;
	
	public ICustomerService getS() {
		return s;
	}




	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Client t=(Client) ctx.getBean("client");
		CustomerModel cm1= new CustomerModel();
		cm1.setCustomerId("c1");
		cm1.setPwd("c1");
		SimpleDateFormat bartDateFormat =   
				  new SimpleDateFormat("yyyy-mm-dd-hh:ss:mm");  
		cm1.setRegisterTime(bartDateFormat.format(new Date()));
		cm1.setShowName("c21");
		cm1.setTrueName("王五");

		
		CustomerQueryModel cqm= new CustomerQueryModel();
		cqm.getPage().setNowPage(2);
		cqm.getPage().setPageShow(3);

		Page<CustomerModel> p=t.getS().getByConditionPage(cqm);

		System.out.println("list ppp="+p);
		
		
		Page<CustomerModel> p2=t.getS().getByConditionPage(cqm);
		System.out.println("  ");
		System.out.println("list ppp222="+p2);
	}

}
