package DW.api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
		try{  
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
			//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con=DriverManager.getConnection(  
					"jdbc:sqlserver://DESKTOP-2R4U5AR;databaseName=DbVirtualWallet;integratedSecurity=true;"); 
			//		"jdbc:sqlserver://DESKTOP-2R4U5AR;databaseName=myemail;integratedSecurity=true;");
			
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from tblCustomer");  
			while(rs.next()) 
				/*
				System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)
				+"  "+rs.getString(5)+"  "+rs.getString(6)+"  "+rs.getString(7)+"  "+rs.getString(8)
				+"  "+rs.getString(9));
				*/

			con.close();  
		}catch(Exception e){ 
			
			System.out.println(e);
		}  
		/*
		CustomerServiceImpl asdf = new CustomerServiceImpl();
		asdf.getByCustID(1000);
		asdf.getByEmail("fdsa@gmail.com");
	  
		Customer cust = new Customer("Joe", " Brown", "email@mail.ca", 904, 56, "ezpz");
		System.out.println(asdf.saveCust(cust));
	   	System.out.println(cust);
	   	System.out.println(cust.getCustID() + " " + cust.getfName() + " " + cust.getlName() + " " + cust.getEmail() + " " + cust.getPhoneNum() + " " + cust.getAddrID() + " " + cust.getPassword());
	   	asdf.getByEmail("email@mail.ca");
	   	cust = new Customer(1007, "Jerry3", " fwea2", "Jerry999@mail.ca", 666, 99, "ezpz");
		System.out.println(asdf.updateCust(cust));
	   	System.out.println(cust);
	   	System.out.println(cust.getCustID() + " " + cust.getfName() + " " + cust.getlName() + " " + cust.getEmail() + " " + cust.getPhoneNum() + " " + cust.getAddrID() + " " + cust.getPassword());
	   System.out.println(asdf.deleteCust(1003));
	   asdf.getByCustID(1003);
		*/
		
		/*
		ArrayList<Card> asdf45 = new ArrayList<Card>();
		Card tempCard = new Card(123, 421, "152", "asdf", "asdf", 522, "243", "253", "52", "14");

		asdf45.add(tempCard);
		tempCard = new Card(123, 42532, "152", "asdf", "asdf", 522, "243", "253", "52", "14");

		asdf45.add(tempCard);
		System.out.println(asdf45.toString());
		tempCard = new Card(123, 421, "152", "asdf", "asdf", 522, "02/01/1999", "253", "52", "14");
		System.out.println(tempCard);
		asdf45.remove(tempCard);
		System.out.println(asdf45.toString());
		System.out.println("test");
		
		WalletServiceImpl fdsa = new WalletServiceImpl();
		fdsa.retrieveWallet(1002);
		fdsa.addCard(tempCard);
		
		*/
		
		Customer cust = new Customer("Joe", " Brown", "test@mail.ca", 904, 56, "ezpz");
		CustomerService tempSrvice = new CustomerServiceImpl();
		int result = tempSrvice.saveCust(cust);
		System.out.println(result);
    }
}
