package DW.api;

public class AddressServiceImpl implements AddressService{

	
	public int getAddressID(Address addr) {
		AddressData con = new AddressData();
		int addrID = con.getAddrID(addr);
		con.closeConnection();
		return addrID;
	}


}
