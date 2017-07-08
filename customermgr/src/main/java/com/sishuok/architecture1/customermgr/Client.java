package com.sishuok.architecture1.customermgr;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.sishuok.architecture1.customermgr.dao.CustomerDAO;
import com.sishuok.architecture1.customermgr.vo.CustomerModel;
import com.sishuok.architecture1.customermgr.vo.CustomerQueryModel;

@Service
//@Transactional
public class Client {
	
	@Autowired
    private CustomerDAO dao=null;
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Client t=(Client) ctx.getBean("client");
		CustomerModel cm1= new CustomerModel();
		cm1.setCustomerId("c1");
		cm1.setPwd("c1");
		SimpleDateFormat bartDateFormat =  
//			       new SimpleDateFormat("EEEE-MMMM-dd-yyyy");  
				  new SimpleDateFormat("yyyy-mm-dd-hh:ss:mm");  
		cm1.setRegisterTime(bartDateFormat.format(new Date()));
		cm1.setShowName("c21");
		cm1.setTrueName("王五");
//		t.dao.create(cm1);
//		List<CustomerModel> list=t.dao.getByCondition(new CustomerQueryModel());
		
		CustomerQueryModel cqm= new CustomerQueryModel();
		cqm.getPage().setNowPage(3);
		
		List<CustomerModel> list=t.dao.getByConditionPage(cqm);
		System.out.println("  ");
		System.out.println("page=="+cqm.getPage());
		System.out.println("list="+list);
	}

}
