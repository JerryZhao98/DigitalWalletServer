package DW.api;

public class Customer {
	private int custID;
	private String fName;
	private String lName;
	private String email;
	private int phoneNum;
	private int addrID;
	private String password;
	
	Customer() {
		this.custID = 0;
		this.fName = null;
		this.lName = null;
		this.email = null;
		this.phoneNum = 0;
		this.addrID = 0;
		this.password = null;
	}
	
	Customer(String fName, String lName, String email, int phoneNum, int addrID, String password){
		this.custID = 0;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.phoneNum = phoneNum;
		this.addrID = addrID;
		this.password = password;
		
	}
	
	Customer(int custID, String fName, String lName, String email, int phoneNum, int addrID, String password){
		this.custID = custID;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.phoneNum = phoneNum;
		this.addrID = addrID;
		this.password = password;
		
	}
	
	
	public int getCustID() {
		return custID;
	}
	public void setCustID(int custID) {
		this.custID = custID;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(int phoneNum) {
		this.phoneNum = phoneNum;
	}
	public int getAddrID() {
		return addrID;
	}
	public void setAddrID(int addrID) {
		this.addrID = addrID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
