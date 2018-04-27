package DW.api;

public interface WalletService {
	Wallet retrieveWallet (int custID);
	int addCard (Card card);
	int deleteCard (int serial);
}
