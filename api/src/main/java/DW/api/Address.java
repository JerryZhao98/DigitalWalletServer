package DW.api;

public class Address {
	private int addrID;
	private String street;
	private String postCd;
	private String state;
	private String country;
	
	public Address() {
		this.addrID = 0;
		this.street = "";
		this.postCd = "";
		this.state = "";
		this.country = "";
	}
	
	public Address(int addrID, String street, String postCd, String state, String country) {
		this.addrID = addrID;
		this.street = street;
		this.postCd = postCd;
		this.state = state;
		this.country = country;
	}

	public int getAddrID() {
		return addrID;
	}

	public void setAddrID(int addrID) {
		this.addrID = addrID;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPostCd() {
		return postCd;
	}

	public void setPostCd(String postCd) {
		this.postCd = postCd;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}


}
