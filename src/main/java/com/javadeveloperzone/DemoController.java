package com.javadeveloperzone;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javadeveloperzone.repo.CustomerRepo;
import com.javadeveloperzone.vo.Customer;

@RestController
public class DemoController {
    
	@Autowired
	CustomerRepo customerRepo;
	
	@RequestMapping(value = "hello")
    public String hello(){
        return "Spring boot Gradle Example. Current Date & Time : " + new Date();
    }
	
	@RequestMapping(value = "insertCustomers")
    public String inserCustomers(){
		Date start = new Date();
		Executor exe = Executors.newFixedThreadPool(10);
		for(int i=1;i<=5;i++) {
			int[] t = {i};
			exe.execute(() -> {
				long time = new Date().getTime()+new Random().ints(100, 100000).findAny().getAsInt()+t[0];
				Customer customer = new Customer(time+"", time+"" );
				customerRepo.save(customer);
				System.out.println("Customer Save " + new Date());
			});
		}
		Date end = new Date();
        return "Customer inserted : " + (end.getTime() -  start.getTime());
    }
	
	@RequestMapping(value = "customers")
    public List<Customer> getCustomers(){
        return customerRepo.findAll();
    }
    
    @GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}
}
