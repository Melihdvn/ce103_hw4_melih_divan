package ce103_hw4_library_lib;

import java.nio.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.IntStream;

public class ConversionUtility 
{
	public static Byte[] toByte(String hexString) 
	{
	    return IntStream
	        .range(0, hexString.length())
	        .filter(x -> x % 2 == 0)
	        .map(x -> Integer.parseInt(hexString.substring(x, x + 2), 16))
	        .mapToObj(x -> (byte) x)
	        .toArray(Byte[]::new);
	  }
	
	
	public static String toHex(byte[] arr) 
	{
	    StringBuilder sb = new StringBuilder(arr.length * 2);
	    for (byte b : arr) 
	    {
	        sb.append(String.format("%02X", b));
	    }
	    return sb.toString();
	}
	
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

	  public static Byte[] toByteArray(String hexString)
	  {
	    return IntStream
	        .range(0, hexString.length())
	        .filter(x -> x % 2 == 0)
	        .map(x -> Integer.parseInt(hexString.substring(x, x + 2), 16))
	        .mapToObj(x -> (byte) x)
	        .toArray(Byte[]::new);
	  }
	
	public static int getInt(byte[] data, int offset, int length)
	{
	    int result = 0;
	    for (int i = 0; i < length; i++) 
	    {
	        result = (result << 8) | data[offset + i];
	    }
	    return result;
	}
	
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
	
	public static byte[] stringToByteArray(String data) 
	{
	    return data.getBytes(StandardCharsets.US_ASCII);
	}
	
	public static String byteArrayToString(byte[] byteArray) 
	{
	    return new String(byteArray, StandardCharsets.UTF_8).trim();
	}
}
