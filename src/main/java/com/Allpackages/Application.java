package com.Allpackages;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.Allpackages.OrdersRepo.OrdersRepository;
import com.Allpackages.entity.Orders;

@SpringBootApplication
public class Application implements CommandLineRunner {
	

	
	@Autowired
	OrdersRepository orp;
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		//here we cannot use ord and orp objects because it is non static type and this is static field.
		//so i am using run method of CommandLineRunner interface by implementing.
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		Orders ord1=new Orders();
		ord1.setOrder_name("Book");
		ord1.setOrder_cost(45);
		
		//insert 1 record
//		orp.save(ord1);
		
		Orders ord2=new Orders();
		ord2.setOrder_name("pens");
		ord2.setOrder_cost(20);
		
		Orders ord3=new Orders();
		ord3.setOrder_name("mouse");
		ord3.setOrder_cost(250);
		
		Orders ord4=new Orders();
		ord4.setOrder_name("keyboard");
		ord4.setOrder_cost(400);
		
		Orders ord5=new Orders();
		ord5.setOrder_name("keyboard");
		ord5.setOrder_cost(500);
		
		List<Orders> lst=Arrays.asList(ord1,ord2,ord3,ord4,ord5);
		
		//insert multiple records
		orp.saveAll(lst);
		
		//to read or retrieve data
	    Optional<Orders> od=orp.findById(2);
	    System.out.println(od.get());
	    
	    
	    //To update data
	    //first we need to find which record we have to update.we can find record by using findById() method.
	    
//	     Optional<Orders> od1=orp.findById(5);
	    Orders od1=orp.findById(5).get();
	    
	    od1.setOrder_name("keyboard&mouse");
	    od1.setOrder_cost(800);
		
	    orp.save(od1);
	    
	    
	    //To delete data
	    //first we need to find which record we have to delete.we can find record by using findById() method.
	    
	    Orders od2=orp.findById(3).get();
	    orp.delete(od2);
		
		
	}

}
