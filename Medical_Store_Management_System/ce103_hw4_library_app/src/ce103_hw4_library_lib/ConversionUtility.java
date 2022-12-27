package ce103_hw4_library_lib;

import java.nio.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.IntStream;

public class ConversionUtility 
{
	/**
	 * Converts a hex string to a byte array.
	 * @param hexString the hex string to be converted.
	 * @return the byte array resulting from the conversion.
	 */
	public static Byte[] toByte(String hexString) 
	{
	    return IntStream
	        .range(0, hexString.length())
	        .filter(x -> x % 2 == 0)
	        .map(x -> Integer.parseInt(hexString.substring(x, x + 2), 16))
	        .mapToObj(x -> (byte) x)
	        .toArray(Byte[]::new);
	  }
	
	/**
	 * Converts a byte array to a hex string.
	 * @param arr the byte array to be converted.
	 * @return the hex string resulting from the conversion.
	 */
	public static String toHex(byte[] arr) 
	{
	    StringBuilder sb = new StringBuilder(arr.length * 2);
	    for (byte b : arr) 
	    {
	        sb.append(String.format("%02X", b));
	    }
	    return sb.toString();
	}
	
	/**
	 * Determines if a given string is a hex string.
	 * @param str the string to be checked.
	 * @return true if the string is a hex string, false otherwise.
	 */
	public static boolean isHex(String str) 
	{
	    try {
	      toByteArray(str);
	    } catch (Exception e) 
	    {
	      return false;
	    }

	    return true;
	 }
	 
	/**
	 * Converts a hex string to a byte array.
	 * @param hexString the hex string to be converted.
	 * @return the byte array resulting from the conversion.
	 */
	  public static Byte[] toByteArray(String hexString)
	  {
	    return IntStream
	        .range(0, hexString.length())
	        .filter(x -> x % 2 == 0)
	        .map(x -> Integer.parseInt(hexString.substring(x, x + 2), 16))
	        .mapToObj(x -> (byte) x)
	        .toArray(Byte[]::new);
	  }
	
	  
	  /**
	   * Extracts an integer from a byte array at a given offset and with a given length.
	   * @param data the byte array from which to extract the integer.
	   * @param offset the offset at which to start extracting the integer.
	   * @param length the number of bytes to use for the integer.
	   * @return the extracted integer.
	   */  
	public static int getInt(byte[] data, int offset, int length)
	{
	    int result = 0;
	    for (int i = 0; i < length; i++) 
	    {
	        result = (result << 8) | data[offset + i];
	    }
	    return result;
	}
	
	/**
	 * Converts a hex string to an ASCII string.
	 * @param hexString the hex string to be converted.
	 * @return the ASCII string resulting from the conversion.
	 */
	public static String toAscii(String hexString) 
	{
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i <= hexString.length() - 2; i += 2) 
	    {
	        String hexByte = hexString.substring(i, i + 2);
	        sb.append((char) Integer.parseInt(hexByte, 16));
	    }
	    return sb.toString();
	}
	
	/**

	Converts a byte array to an integer.
	@param byteArray the byte array to be converted.
	@return the integer resulting from the conversion.
	*/
	public static int byteArrayToInteger(byte[] byteArray) 
	{
	    if (ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN) 
	    {
	        // reverse byte array
	        for (int i = 0; i < byteArray.length / 2; i++) 
	        {
	            byte temp = byteArray[i];
	            byteArray[i] = byteArray[byteArray.length - i - 1];
	            byteArray[byteArray.length - i - 1] = temp;
	        }
	    }
	    return ByteBuffer.wrap(byteArray).getInt();
	}
	
	/**
	 * Converts an integer to a byte array.
	 * @param value the integer to be converted.
	 * @return the byte array resulting from the conversion.
	 */
	public static byte[] integerToByteArray(int value) 
	{
	    byte[] intBytes = ByteBuffer.allocate(4).putInt(value).array();
	    if (ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN) 
	    {
	        // reverse byte array
	        for (int i = 0; i < intBytes.length / 2; i++) 
	        {
	            byte temp = intBytes[i];
	            intBytes[i] = intBytes[intBytes.length - i - 1];
	            intBytes[intBytes.length - i - 1] = temp;
	        }
	    }
	    return intBytes;
	}
	
	/**
	 * Converts a list of strings to a byte array.
	 * @param array the list of strings to be converted.
	 * @param itemMaxCount the maximum number of items in the list.
	 * @param itemMaxLength the maximum length of each item in the list.
	 * @return the byte array resulting from the conversion.
	 */
	public static byte[] stringListToByteArray(List<String> array, int itemMaxCount, int itemMaxLength) 
	{
	    byte[] outputBytes = new byte[itemMaxCount * itemMaxLength];
	    int index = 0;
	    for (String val : array) 
	    {
	        byte[] valBytes = val.getBytes();
	        System.arraycopy(valBytes, 0, outputBytes, index, valBytes.length);
	        index += itemMaxLength;
	    }
	    return outputBytes;
	}
	
	/**
	 * Converts a byte array to a list of strings.
	 * @param byteArray the byte array to be converted.
	 * @param itemMaxCount the maximum number of items in the list.
	 * @param itemMaxLength the maximum length of each item in the list.
	 * @return the list of strings resulting from the conversion.
	 */
	public static List<String> byteArrayToStringList(byte[] byteArray, int itemMaxCount, int itemMaxLength) 
	{
	    List<String> list = new ArrayList<String>();
	    for (int i = 0; i < itemMaxCount; i++) 
	    {
	        byte[] itemBytes = new byte[itemMaxLength];
	        System.arraycopy(byteArray, i * itemMaxLength, itemBytes, 0, itemMaxLength);
	        String val = new String(itemBytes);
	        if (val != null && !val.isEmpty()) 
	        {
	            list.add(val);
	        }
	    }
	    return list;
	}
	
	/**
	 * Converts a string to a byte array.
	 * @param data the string to be converted.
	 * @return the byte array resulting from the conversion.
	 */
	public static byte[] stringToByteArray(String data) 
	{
	    return data.getBytes(StandardCharsets.US_ASCII);
	}
	
	/**

	Converts a byte array to a string.
	@param byteArray the byte array to be converted.
	@return the string resulting from the conversion.
	*/
	public static String byteArrayToString(byte[] byteArray) 
	{
	    return new String(byteArray, StandardCharsets.UTF_8).trim();
	}
}
