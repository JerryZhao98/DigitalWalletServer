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
public class WalletController {
	
	@RequestMapping(value = "/retrieveW", method = RequestMethod.POST)
	public ResponseEntity<ArrayList<Card>> retrieveW (@RequestBody String custID){
		WalletService tempSrvice = new WalletServiceImpl();
		Wallet tempWallet = tempSrvice.retrieveWallet(Integer.parseInt(custID));
		/*
		if (tempWallet == null) {
			System.out.println("Wallet of " + custID + " not found. Unable to retrieve wallet");
			return new ResponseEntity<Wallet>(tempWallet, HttpStatus.NOT_FOUND);
		}
		*/
		ArrayList<Card> tempList = new ArrayList<Card>();
		if (tempWallet == null) {

		} else {
			tempList = tempWallet.getCardList();
		}
		return new ResponseEntity<ArrayList<Card>>(tempList, HttpStatus.OK);
	}

	@RequestMapping(value = "/retrieveWT", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArrayList<Card>> retrieveWTest (){
		WalletService tempSrvice = new WalletServiceImpl();
		Wallet tempWallet = tempSrvice.retrieveWallet(1001);
		/*
		if (tempWallet == null) {
			System.out.println("Wallet of " + custID + " not found. Unable to retrieve wallet");
			return new ResponseEntity<Wallet>(tempWallet, HttpStatus.NOT_FOUND);
		}
		*/
		ArrayList<Card> tempList = new ArrayList<Card>();
		if (tempWallet == null) {

		} else {
			tempList = tempWallet.getCardList();
		}
		return new ResponseEntity<ArrayList<Card>>(tempList, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/addCard", method = RequestMethod.POST)
	public ResponseEntity<String> addCard (@RequestBody Card tempCard){
		WalletService tempSrvice = new WalletServiceImpl();
		int response = tempSrvice.addCard(tempCard);
		String strResponse = Integer.toString(response);
		/*
		if (tempWallet == null) {
			System.out.println("Wallet of " + custID + " not found. Unable to retrieve wallet");
			return new ResponseEntity<Wallet>(tempWallet, HttpStatus.NOT_FOUND);
		}
		*/
		if (response == 0) {

		} else {
		}
		return new ResponseEntity<String>(strResponse, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/deleteCard", method = RequestMethod.POST)
	public ResponseEntity<String> deleteCard (@RequestBody String serial){
		WalletService tempSrvice = new WalletServiceImpl();
		int response = tempSrvice.deleteCard(Integer.parseInt(serial));
		/*
		if (tempWallet == null) {
			System.out.println("Wallet of " + custID + " not found. Unable to retrieve wallet");
			return new ResponseEntity<Wallet>(tempWallet, HttpStatus.NOT_FOUND);
		}
		*/
		if (response == 0) {
			System.out.println("Card does not exist");
			return new ResponseEntity<String>("0", HttpStatus.NOT_FOUND);
		} else {
		}
		return new ResponseEntity<String>("1", HttpStatus.OK);
	}
}
