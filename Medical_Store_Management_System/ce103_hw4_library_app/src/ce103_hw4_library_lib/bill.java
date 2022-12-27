package ce103_hw4_library_lib;

public class bill {

	
	/*These constants represent the maximum length of a customer's
	 *Bill no, ID, customer name, medicine name, quantity and rate respectively.*/
public static final int BILLNO_MAX_LENGTH = 4;
public static final int ID_MAX_LENGTH = 9;
public static final int CUSTOMERNAME_MAX_LENGTH = 25;
public static final int MEDICINENAME_MAX_LENGTH = 25;
public static final int QUANTITY_MAX_LENGTH = 9;
public static final int RATE_MAX_LENGTH = 9;

public static final int BOOK_DATA_BLOCK_SIZE = BILLNO_MAX_LENGTH +CUSTOMERNAME_MAX_LENGTH+MEDICINENAME_MAX_LENGTH+QUANTITY_MAX_LENGTH+RATE_MAX_LENGTH+ID_MAX_LENGTH;

//private fields
private int billno;
private int id;
private String medicinename;
private String customername;
private String quantity;
private String rate;


// These methods are getters and setters for the fields of the class.
public int getbillno() {
	return billno;
}

public void setbillno(int billno) {
	this.billno = billno;
}
public int getid() {
	return id;
}

public void setid(int id) {
	this.id = id;
}

public String getmedicinename() {
	return medicinename;
}

public void setmedicinename(String medicinename) {
	this.medicinename = medicinename;
}

public String getcustomername() {
	return customername;
}

public void setcustomername(String customername) {
	this.customername = customername;
}

public String getquantity() {
	return quantity;
}

public void setquantity(String quantity) {
	this.quantity = quantity;
}

public String getrate() {
	return rate;
}

public void setrate(String rate) {
	this.rate = rate;
}

public static byte[] billToByteArrayBlock(bill book) {
	int index = 0;
	byte[] dataBuffer = new byte[bill.BOOK_DATA_BLOCK_SIZE];

	// copy bill no
	byte[] billnoBytes = ConversionUtility.integerToByteArray(book.getbillno());
	System.arraycopy(billnoBytes, 0, dataBuffer, index, billnoBytes.length);
	index += bill.BILLNO_MAX_LENGTH;
	// copy id no
	byte[] idBytes = ConversionUtility.integerToByteArray(book.getid());
	System.arraycopy(idBytes, 0, dataBuffer, index, idBytes.length);
	index += bill.ID_MAX_LENGTH;
	// copy medicine name
	byte[] medicinenameBytes = ConversionUtility.stringToByteArray(book.getmedicinename());
	System.arraycopy(medicinenameBytes, 0, dataBuffer, index, medicinenameBytes.length);
	index += bill.MEDICINENAME_MAX_LENGTH;
	
	// copy  costumer name
	byte[] customernameBytes = ConversionUtility.stringToByteArray(book.getcustomername());
	System.arraycopy(customernameBytes, 0, dataBuffer, index, customernameBytes.length);
	index += bill.CUSTOMERNAME_MAX_LENGTH;
	
	// copy quantity
	byte[] quantityBytes = ConversionUtility.stringToByteArray(book.getquantity());
	System.arraycopy(quantityBytes, 0, dataBuffer, index, quantityBytes.length);
	index += bill.QUANTITY_MAX_LENGTH;
	
	// copy rate
	byte[] rateBytes = ConversionUtility.stringToByteArray(book.getrate());
	System.arraycopy(rateBytes, 0, dataBuffer, index, rateBytes.length);
	index += bill.RATE_MAX_LENGTH;
	if (index != dataBuffer.length) {
		throw new IllegalArgumentException("Index and DataBuffer Size Not Matched");
	}
	return dataBuffer;
}

public static bill byteArrayBlockToBill(byte[] byteArray) {
	bill Bill = new bill();

	if (byteArray.length != bill.BOOK_DATA_BLOCK_SIZE) {
		throw new IllegalArgumentException("Byte Array Size Not Match with Constant Data Block Size");
	}
	int index = 0;

	// copy bill no
	byte[] billnoBytes = new byte[bill.BILLNO_MAX_LENGTH];
	System.arraycopy(byteArray, index, billnoBytes, 0, billnoBytes.length);
	Bill.setbillno(ConversionUtility.byteArrayToInteger(billnoBytes));

	index += bill.BILLNO_MAX_LENGTH;
	
	// copy id no
		byte[] idBytes = new byte[bill.ID_MAX_LENGTH];
		System.arraycopy(byteArray, index, idBytes, 0, idBytes.length);
		Bill.setid(ConversionUtility.byteArrayToInteger(idBytes));

		index += bill.ID_MAX_LENGTH;
	
	// copy medicine name
	byte[] medicinenameBytes = new byte[bill.MEDICINENAME_MAX_LENGTH];
	System.arraycopy(byteArray, index, medicinenameBytes, 0, medicinenameBytes.length);
	Bill.setmedicinename(ConversionUtility.byteArrayToString(medicinenameBytes));
	
	index += bill.MEDICINENAME_MAX_LENGTH;
	
	// copy customer name
	byte[] customernameBytes = new byte[bill.CUSTOMERNAME_MAX_LENGTH];
	System.arraycopy(byteArray, index, customernameBytes, 0, customernameBytes.length);
	Bill.setcustomername(ConversionUtility.byteArrayToString(customernameBytes));

	index += bill.CUSTOMERNAME_MAX_LENGTH;
	
	// copy quantity
	byte[] quantityBytes = new byte[bill.QUANTITY_MAX_LENGTH];
	System.arraycopy(byteArray, index, quantityBytes, 0, quantityBytes.length);
	Bill.setquantity(ConversionUtility.byteArrayToString(quantityBytes));

	index += bill.QUANTITY_MAX_LENGTH;
	
	// copy rate
	byte[] rateBytes = new byte[bill.RATE_MAX_LENGTH];
	System.arraycopy(byteArray, index, rateBytes, 0, rateBytes.length);
	Bill.setrate(ConversionUtility.byteArrayToString(rateBytes));

	index += bill.RATE_MAX_LENGTH;
	return Bill;
}

}