package DW.api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class WalletData {
	
	private Connection con;
	private Statement stmt;
	
	public WalletData() {
		// Microsoft SQL Server
		try{  
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
			//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con=DriverManager.getConnection(  
					"jdbc:sqlserver://DESKTOP-2R4U5AR;databaseName=DbVirtualWallet;integratedSecurity=true;"); 
			//		"jdbc:sqlserver://DESKTOP-2R4U5AR;databaseName=myemail;integratedSecurity=true;");
			
			stmt=con.createStatement();  

		}catch(Exception e){ 
			
			System.out.println(e);
		}  

	}
	
    public ResultSet retrieveWallet(int custID) {
    	// Find Customer
    	ResultSet rs = null;
    	System.out.println("This custID is: " + custID);
		try {
			rs = stmt.executeQuery("select * from tblCard where fldCustomerID=" + custID + ";");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        return rs;
    }
    
    public int addCard(Card tempCard) {
    	int rs = 0;
    	
    	int custID = tempCard.getCustID();
    	String cardNum = tempCard.getCardNum();
    	String name = tempCard.getName();
    	String cardTyp = tempCard.getCardTyp();
    	int instID = tempCard.getInstID();
    	String expDt = tempCard.getExpDt();
    	String secCode = tempCard.getSecCode();
    	
    	try {
    		/*
			rs = stmt.executeUpdate("UPDATE tblCustomer SET fldFirstName='"
    	+fName+"',fldLastName='"+lName+"',fldEmail='"+email+"',fldPhone="
					+phoneNum+",fldAddressID="+addrID+",fldPassword='"+password
					+"' WHERE fldCustomerID="+custID+";");
			*/
			rs = stmt.executeUpdate("EXEC AddCard "
			+custID+",'"+cardNum+"','"+name+"','"+cardTyp+"',"+instID+",'"+expDt+"','"+secCode+"';");
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
    	
    	
    	return rs;
    }
    
    public int deleteCard(int serial) {
    	int rs = 0;
    	
    	try {
    		rs = stmt.executeUpdate("DELETE FROM tblCard WHERE fldSerial="+serial);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    	return rs;
    }
    
    /**
     * Close instance
     */
    public void closeConnection() {
    	try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    

}
