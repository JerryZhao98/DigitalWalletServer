package DW.api;

import java.util.ArrayList;

public class Wallet {
	private ArrayList<Card> cardList;
	
	Wallet() {
		this.cardList = new ArrayList<Card>();
	}
	
	Wallet(ArrayList<Card> cardList) {
		this.cardList = cardList;
	}
	
	public void addCardToList(Card tempCard) {
		this.cardList.add(tempCard);
	}

	public void removeCardFromList(int serial) {
		for(int i = 0; i < cardList.size(); i++) {
			if (this.cardList.get(i).getSerial() == serial) {
				this.cardList.remove(i);
			}
		}

	}
	
	public ArrayList<Card> getCardList() {
		return cardList;
	}

	public void setCardList(ArrayList<Card> cardList) {
		this.cardList = cardList;
	}
	
	
}
