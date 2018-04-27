package DW.api;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerServiceImpl implements CustomerService {


	/**
	 * Creates Customer instance with given customer ID
	 */
	public Customer getByCustID(int custID) {
		// New instances
		Customer cust = new Customer();
   	 	CustomerData con = new CustomerData();
   	 	
   	 	// Result set
   	 	ResultSet rs = con.getByCustID(custID);
	   	try {
	   			// Add to Customer
	   			if (rs.next()) {
	   				cust = (new Customer(Integer.parseInt(rs.getString(1)), rs.getString(2), rs.getString(3), rs.getString(4), Integer.parseInt(rs.getString(5)), Integer.parseInt(rs.getString(6)), rs.getString(7)));
	   			}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	   	
	   	// Close CustomerData
	   	con.closeConnection();
	   	
	   	// Testing
	   	System.out.println(cust);
	   	System.out.println(cust.getCustID() + " " + cust.getfName() + " " + cust.getlName() + " " + cust.getEmail() + " " + cust.getPhoneNum() + " " + cust.getAddrID() + " " + cust.getPassword());
	   
	   	// Return
	   	return cust;
		
	
	}

	public Customer getByEmail(String email) {
		// New instances
		Customer cust = new Customer();
   	 	CustomerData con = new CustomerData();
   	 	
   	 	// Result set
   	 	ResultSet rs = con.getByEmail(email);
	   	try {
	   			// Add to Customer
	   			if (rs.next()) {
	   				cust = (new Customer(Integer.parseInt(rs.getString(1)), rs.getString(2), rs.getString(3), rs.getString(4), Integer.parseInt(rs.getString(5)), Integer.parseInt(rs.getString(6)), rs.getString(7)));
	   			} else {
	   				cust = null;
	   			}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	   	
	   	// Close CustomerData
	   	con.closeConnection();
	   	
	   	// Testing
	   	//System.out.println(cust);
	   	//System.out.println(cust.getCustID() + " " + cust.getfName() + " " + cust.getlName() + " " + cust.getEmail() + " " + cust.getPhoneNum() + " " + cust.getAddrID() + " " + cust.getPassword());
	   
	   	// Return
	   	return cust;
	}

	public int updateCust(Customer cust) {
		CustomerData con = new CustomerData();
		int rs = con.updateCust(cust);
		con.closeConnection();
		return rs;
	}

	public int saveCust(Customer cust) {
		CustomerData con = new CustomerData();
		
		int rs = con.saveCust(cust);
		con.closeConnection();
		return rs;
	}

	public int deleteCust(int custID) {
		CustomerData con = new CustomerData();
		int rs = con.deleteCust(custID);
		
		con.closeConnection();
		return rs;
	}
	
	public Customer login(String email, String password) {
	 	CustomerData con = new CustomerData();
	 	Customer cust = new Customer();
	 	
	 	ResultSet rs = con.login(email, password);
	   	try {
   			// Add to Customer
   			if (rs.next()) {
   				cust = (new Customer(Integer.parseInt(rs.getString(1)), rs.getString(2), rs.getString(3), rs.getString(4), Integer.parseInt(rs.getString(5)), Integer.parseInt(rs.getString(6)), rs.getString(7)));
   			} else {
   				cust = null;
   			}
   			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   	
   	
   	// Testing
   	System.out.println(cust);
   	System.out.println(cust.getCustID() + " " + cust.getfName() + " " + cust.getlName() + " " + cust.getEmail() + " " + cust.getPhoneNum() + " " + cust.getAddrID() + " " + cust.getPassword());
   	
	 	con.closeConnection();
	 	return cust;
		
		
	}

}
