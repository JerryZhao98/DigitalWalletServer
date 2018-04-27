package DW.api;

public interface CustomerService {
	
	Customer getByCustID (int custID);
	Customer getByEmail (String email);
	int updateCust (Customer cust);
	int saveCust (Customer cust);
	int deleteCust (int custID);
	Customer login (String email, String password);
	

}
