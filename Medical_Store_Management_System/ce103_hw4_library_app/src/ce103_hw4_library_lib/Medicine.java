package ce103_hw4_library_lib;

public class Medicine {
	
	/*These constants represent the maximum length of a customer's
	 *ID, name, rack, cab, company name, supplier name, unit cost, sale cost, quantity, manufacture date, expire date respectively.*/
	public static final int ID_LENGTH = 4;
	public static final int NAME_MAX_LENGTH = 50;
	public static final int RACK_MAX_LENGTH = 10;
	public static final int CABINET_MAX_LENGTH = 10;
	public static final int COMPANY_NAME_MAX_LENGTH = 50;
	public static final int SUPPLIER_NAME_MAX_LENGTH = 50;
	public static final int UNIT_COST_LENGTH = 8;
	public static final int SALE_COST_LENGTH = 8;
	public static final int QUANTITY_LENGTH = 8;
	public static final int MAN_DATE_LENGTH = 15;
	public static final int EXP_DATE_LENGTH = 15;
	
	/*This constant represents the total size of the data block for a medicine.*/
	public static final int MEDICINE_DATA_BLOCK_SIZE = ID_LENGTH + NAME_MAX_LENGTH + RACK_MAX_LENGTH + CABINET_MAX_LENGTH 
														+ COMPANY_NAME_MAX_LENGTH + SUPPLIER_NAME_MAX_LENGTH 
														+ UNIT_COST_LENGTH + SALE_COST_LENGTH 
														+ QUANTITY_LENGTH + MAN_DATE_LENGTH + EXP_DATE_LENGTH;

	//private fields
	private int id;
	private String name;
	private String rack;
	private String cabinet;
	private String companyName;
	private String supplierName;
	private String unitCost;
	private String saleCost;
	private String quantity;
	private String manDate;
	private String expDate;
	
	
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

	public String getRack() {
		return rack;
	}

	public void setRack(String rack) {
		this.rack = rack;
	}

	public String getCabinet() {
		return cabinet;
	}

	public void setCabinet(String cabinet) {
		this.cabinet = cabinet;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(String unitCost) {
		this.unitCost = unitCost;
	}

	public String getSaleCost() {
		return saleCost;
	}

	public void setSaleCost(String saleCost) {
		this.saleCost = saleCost;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getManDate() {
		return manDate;
	}

	public void setManDate(String manDate) {
		this.manDate = manDate;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	
	/**

	Converts a Medicine object into a byte array.

	@param customer The Medicine object to be converted.

	@return A byte array representation of the medicine.

	@throws IllegalArgumentException If the size of the resulting byte array does not match the expected size.
	*/
	public static byte[] medicineToByteArrayBlock(Medicine medicine) {
		int index = 0;

		byte[] dataBuffer = new byte[Medicine.MEDICINE_DATA_BLOCK_SIZE];

		// copy medicine id
		byte[] idBytes = ConversionUtility.integerToByteArray(medicine.getId());
		System.arraycopy(idBytes, 0, dataBuffer, index, idBytes.length);
		index += Medicine.ID_LENGTH;

		// copy medicine name
		byte[] nameBytes = ConversionUtility.stringToByteArray(medicine.getName());
		System.arraycopy(nameBytes, 0, dataBuffer, index, nameBytes.length);
		index += Medicine.NAME_MAX_LENGTH;

		// copy medicine rack
		byte[] rackBytes = ConversionUtility.stringToByteArray(medicine.getRack());
		System.arraycopy(rackBytes, 0, dataBuffer, index, rackBytes.length);
		index += Medicine.RACK_MAX_LENGTH;

		// copy medicine cabinet
		byte[] cabinetBytes = ConversionUtility.stringToByteArray(medicine.getCabinet());
		System.arraycopy(cabinetBytes, 0, dataBuffer, index, cabinetBytes.length);
		index += Medicine.CABINET_MAX_LENGTH;

		// copy medicine company name
		byte[] companyNameBytes = ConversionUtility.stringToByteArray(medicine.getCompanyName());
		System.arraycopy(companyNameBytes, 0, dataBuffer, index, companyNameBytes.length);
		index += Medicine.COMPANY_NAME_MAX_LENGTH;

		// copy medicine supplier name
		byte[] supplierNameBytes = ConversionUtility.stringToByteArray(medicine.getSupplierName());
		System.arraycopy(supplierNameBytes, 0, dataBuffer, index, supplierNameBytes.length);
		index += Medicine.SUPPLIER_NAME_MAX_LENGTH;

		// copy medicine unit cost
		byte[] unitCostBytes = ConversionUtility.stringToByteArray(medicine.getUnitCost());
		System.arraycopy(unitCostBytes, 0, dataBuffer, index, unitCostBytes.length);
		index += Medicine.UNIT_COST_LENGTH;
		// copy medicine sale cost
		byte[] saleCostBytes = ConversionUtility.stringToByteArray(medicine.getSaleCost());
		System.arraycopy(saleCostBytes, 0, dataBuffer, index, saleCostBytes.length);
		index += Medicine.SALE_COST_LENGTH;

		// copy medicine quantity
		byte[] quantityBytes = ConversionUtility.stringToByteArray(medicine.getQuantity());
		System.arraycopy(quantityBytes, 0, dataBuffer, index, quantityBytes.length);
		index += Medicine.QUANTITY_LENGTH;

		// copy medicine manufacture date
		byte[] manDateBytes = ConversionUtility.stringToByteArray(medicine.getManDate());
		System.arraycopy(manDateBytes, 0, dataBuffer, index, manDateBytes.length);
		index += Medicine.MAN_DATE_LENGTH;

		// copy medicine expiry date
		byte[] expDateBytes = ConversionUtility.stringToByteArray(medicine.getExpDate());
		System.arraycopy(expDateBytes, 0, dataBuffer, index, expDateBytes.length);
		index += Medicine.EXP_DATE_LENGTH;

		if (index != dataBuffer.length) {
			throw new IllegalArgumentException("Index and DataBuffer Size Not Matched");
		}

				return dataBuffer;
			}

	
	/**
	 * Converts a byte array to a Medicine object.
	 *
	 * @param byteArray the byte array to convert
	 * @return the Medicine object represented by the byte array
	 * @throws IllegalArgumentException if the size of the byte array does not match the expected size
	 */
		public static Medicine byteArrayBlockToMedicine(byte[] byteArray) {

			Medicine medicine = new Medicine();

			if (byteArray.length != Medicine.MEDICINE_DATA_BLOCK_SIZE) {
				throw new IllegalArgumentException("Byte Array Size Not Match with Constant Data Block Size");
			}
			int index = 0;

			// copy medicine id
			byte[] idBytes = new byte[Medicine.ID_LENGTH];
			System.arraycopy(byteArray, index, idBytes, 0, idBytes.length);
			medicine.setId(ConversionUtility.byteArrayToInteger(idBytes));

			index += Medicine.ID_LENGTH;

			// copy medicine name
			byte[] nameBytes = new byte[Medicine.NAME_MAX_LENGTH];
			System.arraycopy(byteArray, index, nameBytes, 0, nameBytes.length);
			medicine.setName(ConversionUtility.byteArrayToString(nameBytes));

			index += Medicine.NAME_MAX_LENGTH;
			// copy medicine rack
			byte[] rackBytes = new byte[Medicine.RACK_MAX_LENGTH];
			System.arraycopy(byteArray, index, rackBytes, 0, rackBytes.length);
			medicine.setRack(ConversionUtility.byteArrayToString(rackBytes));

			index += Medicine.RACK_MAX_LENGTH;

			// copy medicine cabinet
			byte[] cabinetBytes = new byte[Medicine.CABINET_MAX_LENGTH];
			System.arraycopy(byteArray, index, cabinetBytes, 0, cabinetBytes.length);
			medicine.setCabinet(ConversionUtility.byteArrayToString(cabinetBytes));

			index += Medicine.CABINET_MAX_LENGTH;

			// copy medicine company name
			byte[] companyNameBytes = new byte[Medicine.COMPANY_NAME_MAX_LENGTH];
			System.arraycopy(byteArray, index, companyNameBytes, 0, companyNameBytes.length);
			medicine.setCompanyName(ConversionUtility.byteArrayToString(companyNameBytes));

			index += Medicine.COMPANY_NAME_MAX_LENGTH;

			// copy medicine supplier name
			byte[] supplierNameBytes = new byte[Medicine.SUPPLIER_NAME_MAX_LENGTH];
			System.arraycopy(byteArray, index, supplierNameBytes, 0, supplierNameBytes.length);
			medicine.setSupplierName(ConversionUtility.byteArrayToString(supplierNameBytes));

			index += Medicine.SUPPLIER_NAME_MAX_LENGTH;

			// copy medicine unit cost
			byte[] unitCostBytes = new byte[Medicine.UNIT_COST_LENGTH];
			System.arraycopy(byteArray, index, unitCostBytes, 0, unitCostBytes.length);
			medicine.setUnitCost(ConversionUtility.byteArrayToString(unitCostBytes));

			index += Medicine.UNIT_COST_LENGTH;

			// copy medicine sale cost
			byte[] saleCostBytes = new byte[Medicine.SALE_COST_LENGTH];
			System.arraycopy(byteArray, index, saleCostBytes, 0, saleCostBytes.length);
			medicine.setSaleCost(ConversionUtility.byteArrayToString(saleCostBytes));

			index += Medicine.SALE_COST_LENGTH;

			// copy medicine quantity
			byte[] quantityBytes = new byte[Medicine.QUANTITY_LENGTH];
			System.arraycopy(byteArray, index, quantityBytes, 0, quantityBytes.length);
			medicine.setQuantity(ConversionUtility.byteArrayToString(quantityBytes));

			index += Medicine.QUANTITY_LENGTH;

			// copy medicine manufacture date
			byte[] manDateBytes = new byte[Medicine.MAN_DATE_LENGTH];
			System.arraycopy(byteArray, index, manDateBytes, 0, manDateBytes.length);
			medicine.setExpDate(ConversionUtility.byteArrayToString(manDateBytes));

			index += Medicine.MAN_DATE_LENGTH;
			// copy medicine expiry date
			byte[] expDateBytes = new byte[Medicine.EXP_DATE_LENGTH];
			System.arraycopy(byteArray, index, expDateBytes, 0, expDateBytes.length);
			medicine.setExpDate(ConversionUtility.byteArrayToString(expDateBytes));

			index += Medicine.EXP_DATE_LENGTH;

			if (index != byteArray.length) {
				throw new IllegalArgumentException("Index and Byte Array Size Not Matched");
			}

			return medicine;
		}
		}


