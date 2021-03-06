package DW.api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AddressData {
	private Connection con;
	private Statement stmt;

	public AddressData() {
		// Microsoft SQL Server
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			// Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(
					"jdbc:sqlserver://DESKTOP-2R4U5AR;databaseName=DbVirtualWallet;integratedSecurity=true;");
			// "jdbc:sqlserver://DESKTOP-2R4U5AR;databaseName=myemail;integratedSecurity=true;");

			stmt = con.createStatement();

		} catch (Exception e) {

			System.out.println(e);
		}

	}
	
	public int getAddrID(Address addr) {

		ResultSet rs = null;
		int addrID = 0;
		String street = addr.getStreet();
		String postCd = addr.getPostCd();
		String state = addr.getState();
		String country = addr.getCountry();
		System.out.println("select * from tblAddress where fldStreet='"+street+ 
					"',fldPostCode='"+postCd+"',fldState='"+state+"',fldCountry='"+country+
					"';");
		try {
			rs = stmt.executeQuery("select * from tblAddress where fldStreet='"+street+ 
					"'and fldPostCode='"+postCd+"'and fldState='"+state+"'and fldCountry='"+country+
					"';");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if (rs.next()) {
				addrID = Integer.parseInt(rs.getString(1));
			} else {
				stmt.execute("Insert into tbladdress values ('"+
						street+"','"+postCd+"','"+state+"','"+country+"',getdate());");
				rs = stmt.executeQuery("select * from tblAddress where fldStreet='"+street+ 
						"'and fldPostCode='"+postCd+"'and fldState='"+state+"'and fldCountry='"+country+
						"';");
				rs.next();
				addrID = Integer.parseInt(rs.getString(1));
			}
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return addrID;
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
