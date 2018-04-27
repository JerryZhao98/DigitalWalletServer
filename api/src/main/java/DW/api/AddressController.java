package DW.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {
	

	@RequestMapping(value = "/addressID", method = RequestMethod.POST)
	public ResponseEntity<String> getAddrID(@RequestBody Address addr) {
		AddressService tempSrvice = new AddressServiceImpl();
		String addrID = Integer.toString(tempSrvice.getAddressID(addr));

		
		if(addrID == "0") {
			 return new ResponseEntity<String>(addrID, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<String>(addrID, HttpStatus.OK);
	}
	

}
