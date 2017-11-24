package com.nagarro.adminPortal.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.nagarro.adminPortal.model.Customer;
import com.nagarro.adminPortal.service.CustomerService;

/**
 * @author archanabanga
 *
 * This controller performs all administrators operations to deal with customer like
 * recharge, search, display, get Customer details
 */

@Controller
public class CustomerController{

	private static final String INDEX = "index";
	private static final String REGISTER = "register";
	private static final String DISPLAY = "display";
	private static final String IMAGE_PATH= "/images/";
	
	private CustomerService customerService;
	
	
	@Autowired
	public CustomerController(CustomerService customerService){
		this.customerService = customerService;
	}
	
	/**
	 * 
	 * @return INDEX Page
	 */
	@GetMapping("/")
	public String homePage(){
		return INDEX;
	}
	
	/**
	 * 
	 * @return INDEX Page
	 */
	@GetMapping("/index")
	public String homePageReturn(){
		return INDEX;
	}
	
	/**
	 *
	 * @return REGISTER Page
	 */
	@GetMapping("/register")
	public String registerPage(){
		return REGISTER;
	}
	
	/**
	 * 
	 * @param model
	 * @return DISPLAY Page with customer Record
	 */
	@GetMapping("/display")
	public String displayPage(Map<String, Object> model){
		List<Customer> list = customerService.getRecords();
		 model.put("customers",list);
		 return DISPLAY;
	}


	/**
	 * Search Customers based on customer name, email, and contact Number
	 * @param requestParams
	 * @param model
	 * @return customer record based on search condition
	 */
	@GetMapping("/search")
	public String search(@RequestParam Map<String,String> requestParams,Map<String, Object> model){
		String name = requestParams.get("name");
		String email = requestParams.get("email");
		String contact = requestParams.get("contact");
		
		List<Customer> list = null;
		if(!name.trim().isEmpty() && contact.trim().isEmpty() && email.trim().isEmpty()){
			list = customerService.getRecordsByName(name);			
		}
		else if(name.trim().isEmpty() && !contact.trim().isEmpty() && email.trim().isEmpty()){
			list = customerService.getRecordsByContact(contact);
		}
		else if(name.trim().isEmpty() && contact.trim().isEmpty() && !email.trim().isEmpty()){
			list = customerService.getRecordsByEmail(email);
		}
		else if(!name.trim().isEmpty() && !contact.trim().isEmpty() && email.trim().isEmpty()){
			list = customerService.getRecordsByNameOrContact(name, contact);
		}
		else if(!name.trim().isEmpty() && contact.trim().isEmpty() && !email.trim().isEmpty()){
			list = customerService.getRecordsByNameOrEmail(name, email);
		}
		else if(name.trim().isEmpty() && !contact.trim().isEmpty() && !email.trim().isEmpty()){
			list = customerService.getRecordsByContactOrEmail(contact, email);
		}
		else if(name.trim().isEmpty() && contact.trim().isEmpty() && email.trim().isEmpty()){
			list = customerService.getRecords();
		}
		 model.put("customers",list);
		 return DISPLAY;
	}
	
	/**
	 * Registers customer
	 * @param file
	 * @param customer
	 * @return DISPLAY Page and show customers record
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@PostMapping("/register")
	public String register(@RequestParam("file") MultipartFile file,@ModelAttribute("model") Customer customer,Map<String, Object> model) throws 	IllegalStateException, IOException{
		
		String id = UUID.randomUUID().toString();
		
		String path = IMAGE_PATH+id+".jpg";
		 /*File convFile = new File(path);
		 convFile.createNewFile(); 
		 FileOutputStream fos = new FileOutputStream(convFile); 
		 fos.write(file.getBytes());
		 fos.close(); */
		customer.setUniqueId(id);
		customer.setImageUrl(path);
		customer.setBlockedAmount(0);
		customer.setBalance(500);
		customerService.register(customer);
		List<Customer> list = customerService.getRecords();
		model.put("customers",list);
		return DISPLAY;
	}
	
	/**
	 * Recharge Customers Balance
	 * @param customer
	 * @return DISPLAY Page showning customers record
	 */
	@PostMapping("/recharge")
	public String recharge(@ModelAttribute("model") Customer customer,Map<String, Object> model){
		customerService.recharge(customer.getUniqueId(), customer.getBalance());
		List<Customer> list = customerService.getRecords();
		 model.put("customers",list);
		return DISPLAY;
	}
	
}
