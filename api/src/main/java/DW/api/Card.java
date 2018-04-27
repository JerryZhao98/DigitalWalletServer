package DW.api;

public class Card {
	private int serial;
	private int custID;
	private String cardNum;
	private String name;
	private String cardTyp;
	private int instID;
	private String expDt;
	private String secCode;
	private String createDt;
	private String updateDt;

	Card() {
		this.serial = 0;
		this.custID = 0;
		this.cardNum = "";
		this.name = "";
		this.cardTyp = "";
		this.instID = 0;
		this.expDt = "";
		this.secCode = "";
		this.createDt = "";
		this.updateDt = "";

	}
	
	Card(int serial, int custID, String cardNum, String name, String cardTyp,
			int instID, String expDt, String secCode, String createDt, String updateDt) {
		this.serial = serial;
		this.custID = custID;
		this.cardNum = cardNum;
		this.name = name;
		this.cardTyp = cardTyp;
		this.instID = instID;
		this.expDt = expDt;
		this.secCode = secCode;
		this.createDt = createDt;
		this.updateDt = updateDt;
	}

	public int getSerial() {
		return serial;
	}

	public void setSerial(int serial) {
		this.serial = serial;
	}

	public int getCustID() {
		return custID;
	}

	public void setCustID(int custID) {
		this.custID = custID;
	}

	public String getCardNum() {
		return cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCardTyp() {
		return cardTyp;
	}

	public void setCardTyp(String cardTyp) {
		this.cardTyp = cardTyp;
	}

	public int getInstID() {
		return instID;
	}

	public void setInstID(int instID) {
		this.instID = instID;
	}

	public String getExpDt() {
		return expDt;
	}

	public void setExpDt(String expDt) {
		this.expDt = expDt;
	}

	public String getSecCode() {
		return secCode;
	}

	public void setSecCode(String secCode) {
		this.secCode = secCode;
	}

	public String getCreateDt() {
		return createDt;
	}

	public void setCreateDt(String createDt) {
		this.createDt = createDt;
	}

	public String getUpdateDt() {
		return updateDt;
	}

	public void setUpdateDt(String updateDt) {
		this.updateDt = updateDt;
	}

	
}
