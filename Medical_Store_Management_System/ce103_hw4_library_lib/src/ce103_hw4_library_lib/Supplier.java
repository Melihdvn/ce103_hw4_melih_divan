package ce103_hw4_library_lib;

public class Supplier {
	
	public static final int ID_LENGTH = 4;
	public static final int NAME_MAX_LENGTH = 50;
	public static final int CITY_MAX_LENGTH = 30;
	public static final int PHONE_MAX_LENGTH = 20;
	public static final int EMAIL_MAX_LENGTH = 50;
	public static final int SUPPLIER_DATA_BLOCK_SIZE = ID_LENGTH + NAME_MAX_LENGTH + CITY_MAX_LENGTH + PHONE_MAX_LENGTH + EMAIL_MAX_LENGTH;

	private int id;
	private String name;
	private String city;
	private String phone;
	private String email;
	
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

	public static byte[] supplierToByteArrayBlock(Supplier supplier) {
		int index = 0;

		byte[] dataBuffer = new byte[Supplier.SUPPLIER_DATA_BLOCK_SIZE];

		// copy supplier id
		byte[] idBytes = ConversionUtility.integerToByteArray(supplier.getId());
		System.arraycopy(idBytes, 0, dataBuffer, index, idBytes.length);
		index += Supplier.ID_LENGTH;

		// copy supplier name
		byte[] nameBytes = ConversionUtility.stringToByteArray(supplier.getName());
		System.arraycopy(nameBytes, 0, dataBuffer, index, nameBytes.length);
		index += Supplier.NAME_MAX_LENGTH;

		// copy supplier city
		byte[] cityBytes = ConversionUtility.stringToByteArray(supplier.getCity());
		System.arraycopy(cityBytes, 0, dataBuffer, index, cityBytes.length);
		index += Supplier.CITY_MAX_LENGTH;

		// copy supplier phone
		byte[] phoneBytes = ConversionUtility.stringToByteArray(supplier.getPhone());
		System.arraycopy(phoneBytes, 0, dataBuffer, index, phoneBytes.length);
		index += Supplier.PHONE_MAX_LENGTH;

		// copy supplier email
		byte[] emailBytes = ConversionUtility.stringToByteArray(supplier.getEmail());
		System.arraycopy(emailBytes, 0, dataBuffer,		index, emailBytes.length);
		index += Supplier.EMAIL_MAX_LENGTH;

		if (index != dataBuffer.length) {
			throw new IllegalArgumentException("Index and DataBuffer Size Not Matched");
		}

		return dataBuffer;
	}

	public static Supplier byteArrayBlockToSupplier(byte[] byteArray) {

		Supplier supplier = new Supplier();

		if (byteArray.length != Supplier.SUPPLIER_DATA_BLOCK_SIZE) {
			throw new IllegalArgumentException("Byte Array Size Not Match with Constant Data Block Size");
		}
		int index = 0;

		// copy supplier id
		byte[] idBytes = new byte[Supplier.ID_LENGTH];
		System.arraycopy(byteArray, index, idBytes, 0, idBytes.length);
		supplier.setId(ConversionUtility.byteArrayToInteger(idBytes));

		index += Supplier.ID_LENGTH;

		// copy supplier name
		byte[] nameBytes = new byte[Supplier.NAME_MAX_LENGTH];
		System.arraycopy(byteArray, index, nameBytes, 0, nameBytes.length);
		supplier.setName(ConversionUtility.byteArrayToString(nameBytes));

		index += Supplier.NAME_MAX_LENGTH;

		// copy supplier city
		byte[] cityBytes = new byte[Supplier.CITY_MAX_LENGTH];
		System.arraycopy(byteArray, index, cityBytes, 0, cityBytes.length);
		supplier.setCity(ConversionUtility.byteArrayToString(cityBytes));

		index += Supplier.CITY_MAX_LENGTH;
		
		// copy supplier phone
		byte[] phoneBytes = new byte[Supplier.PHONE_MAX_LENGTH];
		System.arraycopy(byteArray, index, phoneBytes, 0, phoneBytes.length);
		supplier.setPhone(ConversionUtility.byteArrayToString(phoneBytes));

		index += Supplier.PHONE_MAX_LENGTH;

		// copy supplier email
		byte[] emailBytes = new byte[Supplier.EMAIL_MAX_LENGTH];
		System.arraycopy(byteArray, index, emailBytes, 0, emailBytes.length);
		supplier.setEmail(ConversionUtility.byteArrayToString(emailBytes));

		index += Supplier.EMAIL_MAX_LENGTH;

		return supplier;
	}

}

