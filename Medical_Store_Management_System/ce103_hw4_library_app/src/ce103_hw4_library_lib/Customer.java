package ce103_hw4_library_lib;

public class Customer {
	
	/*These constants represent the maximum length of a customer's
	 *ID, name, city, phone number, and email address, respectively.*/
	public static final int ID_LENGTH = 4;
	public static final int NAME_MAX_LENGTH = 50;
	public static final int CITY_MAX_LENGTH = 30;
	public static final int PHONE_MAX_LENGTH = 20;
	public static final int EMAIL_MAX_LENGTH = 50;
	
	
	/*This constant represents the total size of the data block for a customer,
	 *which includes their ID, name, city, phone number, and email address.*/
	public static final int CUSTOMER_DATA_BLOCK_SIZE = ID_LENGTH + NAME_MAX_LENGTH + CITY_MAX_LENGTH + PHONE_MAX_LENGTH + EMAIL_MAX_LENGTH;

	//private fields
	private int id;
	private String name;
	private String city;
	private String phone;
	private String email;
	
	
	// These methods are getters and setters for the fields of the class.
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	/**

	Converts a Customer object into a byte array.

	@param customer The Customer object to be converted.

	@return A byte array representation of the customer.

	@throws IllegalArgumentException If the size of the resulting byte array does not match the expected size.
	*/
	public static byte[] customerToByteArrayBlock(Customer customer) {
		int index = 0;

		byte[] dataBuffer = new byte[Customer.CUSTOMER_DATA_BLOCK_SIZE];

		// copy customer id
		byte[] idBytes = ConversionUtility.integerToByteArray(customer.getId());
		System.arraycopy(idBytes, 0, dataBuffer, index, idBytes.length);
		index += Customer.ID_LENGTH;

		// copy customer name
		byte[] nameBytes = ConversionUtility.stringToByteArray(customer.getName());
		System.arraycopy(nameBytes, 0, dataBuffer, index, nameBytes.length);
		index += Customer.NAME_MAX_LENGTH;

		// copy customer city
		byte[] cityBytes = ConversionUtility.stringToByteArray(customer.getCity());
		System.arraycopy(cityBytes, 0, dataBuffer, index, cityBytes.length);
		index += Customer.CITY_MAX_LENGTH;

		// copy customer phone
		byte[] phoneBytes = ConversionUtility.stringToByteArray(customer.getPhone());
		System.arraycopy(phoneBytes, 0, dataBuffer, index, phoneBytes.length);
		index += Customer.PHONE_MAX_LENGTH;

		// copy customer email
		byte[] emailBytes = ConversionUtility.stringToByteArray(customer.getEmail());
		System.arraycopy(emailBytes, 0, dataBuffer, index, emailBytes.length);
		index += Customer.EMAIL_MAX_LENGTH;

		if (index != dataBuffer.length) {
			throw new IllegalArgumentException("Index and DataBuffer Size Not Matched");
		}

		return dataBuffer;
	}

	/**
	 * Converts a byte array to a Customer object.
	 *
	 * @param byteArray the byte array to convert
	 * @return the Customer object represented by the byte array
	 * @throws IllegalArgumentException if the size of the byte array does not match the expected size
	 */
	public static Customer byteArrayBlockToCustomer(byte[] byteArray) {

		Customer customer = new Customer();

		if (byteArray.length != Customer.CUSTOMER_DATA_BLOCK_SIZE) {
			throw new IllegalArgumentException("Byte Array Size Not Match with Constant Data Block Size");
		}
		int index = 0;

		// copy customer id
		byte[] idBytes = new byte[Customer.ID_LENGTH];
		System.arraycopy(byteArray, index, idBytes, 0, idBytes.length);
		customer.setId(ConversionUtility.byteArrayToInteger(idBytes));

		index += Customer.ID_LENGTH;

		// copy customer name
		byte[] nameBytes = new byte[Customer.NAME_MAX_LENGTH];
		System.arraycopy(byteArray, index, nameBytes, 0, nameBytes.length);
		customer.setName(ConversionUtility.byteArrayToString(nameBytes));

		index += Customer.NAME_MAX_LENGTH;

		// copy customer city
		byte[] cityBytes = new byte[Customer.CITY_MAX_LENGTH];
		System.arraycopy(byteArray, index, cityBytes, 0, cityBytes.length);
		customer.setCity(ConversionUtility.byteArrayToString(cityBytes));

		index += Customer.CITY_MAX_LENGTH;

		// copy customer phone
		byte[] phoneBytes = new byte[Customer.PHONE_MAX_LENGTH];
		System.arraycopy(byteArray, index, phoneBytes, 0, phoneBytes.length);
		customer.setPhone(ConversionUtility.byteArrayToString(phoneBytes));

		index += Customer.PHONE_MAX_LENGTH;

		// copy customer email
		byte[] emailBytes = new byte[Customer.EMAIL_MAX_LENGTH];
		System.arraycopy(byteArray, index, emailBytes, 0, emailBytes.length);
		customer.setEmail(ConversionUtility.byteArrayToString(emailBytes));

		return customer;
	}
}


