package DW.api;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
	
	
	// Test
	@RequestMapping(value = "/testing", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> testList() {
		CustomerService tempSrvice = new CustomerServiceImpl();
		System.out.println("asdf2");
		Customer tempCust = tempSrvice.getByEmail("jerryzhao@gmail.com");
		System.out.println("asdf");
		
		if(tempCust == null) {
			 return new ResponseEntity<Customer>(HttpStatus.NO_CONTENT);
		}
		System.out.println("Returning customer: " + tempCust);
		return new ResponseEntity<Customer>(tempCust, HttpStatus.OK);
	}
	
	
	
	
	@RequestMapping(value = "/verify", method = RequestMethod.POST)
	public ResponseEntity<String> verify (@RequestBody Customer cust){
		System.out.println("asdfdsasdfdsasdfdsas42342");
		CustomerService tempSrvice = new CustomerServiceImpl();
		
		Customer tempCust = tempSrvice.login(cust.getEmail(), cust.getPassword());
		String verified = "false";
		System.out.println("1232123asdfdsasdfdsasdfdsas");
		if (tempCust == null) {
			System.out.println(cust.getEmail() + " not found. Unable to verify");
			return new ResponseEntity<String>(verified, HttpStatus.NOT_FOUND);
		}
		System.out.println("asdfdsasdfdsasdfdsas");
		verified = "true";
		return new ResponseEntity<String>(verified, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<Customer> login (@RequestBody Customer cust){
		CustomerService tempSrvice = new CustomerServiceImpl();
		
		Customer tempCust = tempSrvice.login(cust.getEmail(), cust.getPassword());
		if (tempCust == null) {
			System.out.println(cust.getEmail() + " not found. Unable to login");
			return new ResponseEntity<Customer>(tempCust, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Customer>(tempCust, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<String> register (@RequestBody Customer cust) {
		CustomerService tempSrvice = new CustomerServiceImpl();
		int result = tempSrvice.saveCust(cust);
		if (result == 0) {
			System.out.println("Error (Email exists)");
			return new ResponseEntity<String>("0", HttpStatus.PRECONDITION_FAILED);
		}
		return new ResponseEntity<String>("1", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/checkEmail", method = RequestMethod.POST)
	public ResponseEntity<String> checkEmail (@RequestBody String email) {
		CustomerService tempSrvice = new CustomerServiceImpl();
		Customer tempCust = tempSrvice.getByEmail(email);
		if (tempCust != null) {
			System.out.println("Email '" + email + "' already exists");
			return new ResponseEntity<String>("0", HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<String>("1", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/addCust", method = RequestMethod.POST)
	public ResponseEntity<String> addCust (@RequestBody Customer cust) {
		CustomerService tempSrvice = new CustomerServiceImpl();
		int response = tempSrvice.saveCust(cust);
		if (response == 0) {
			System.out.println("Registering customer failed");
			return new ResponseEntity<String>("0", HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<String>("1", HttpStatus.OK);
	}
	
	
	
	
	/*
	@RequestMapping(value = "/wallet", method = RequesetMethod.POST)
	public ResponseEntity<Wallet> 
	
	*/
	


}
