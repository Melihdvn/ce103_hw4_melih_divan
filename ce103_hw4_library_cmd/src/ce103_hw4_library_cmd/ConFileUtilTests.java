package ce103_hw4_library_cmd;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


import static ce103_hw4_library_lib.ConversionUtility.toByteArray;
import static ce103_hw4_library_lib.ConversionUtility.getInt;
import static ce103_hw4_library_lib.ConversionUtility.toAscii;
import static ce103_hw4_library_lib.ConversionUtility.byteArrayToInteger;
import static ce103_hw4_library_lib.ConversionUtility.integerToByteArray;
import static ce103_hw4_library_lib.ConversionUtility.stringListToByteArray;
import static ce103_hw4_library_lib.ConversionUtility.byteArrayToStringList;
import static ce103_hw4_library_lib.ConversionUtility.stringToByteArray;
import static ce103_hw4_library_lib.ConversionUtility.byteArrayToString;
import static ce103_hw4_library_lib.ConversionUtility.toByte;
import static ce103_hw4_library_lib.ConversionUtility.toHex;
import static ce103_hw4_library_lib.ConversionUtility.isHex;

import static ce103_hw4_library_lib.FileUtility.deleteFile;
import static ce103_hw4_library_lib.FileUtility.appendBlock;
import static ce103_hw4_library_lib.FileUtility.updateBlock;
import static ce103_hw4_library_lib.FileUtility.deleteBlock;


import org.junit.jupiter.api.Test;

class ConFileUtilTests {

	@Test
	  public void testToByteArray() {
	    String hexString1 = "68656C6C6F20776F726C64";
	    Byte[] expected1 = {104, 101, 108, 108, 111, 32, 119, 111, 114, 108, 100};
	    assertArrayEquals(expected1, toByteArray(hexString1));

	    String hexString2 = "";
	    Byte[] expected2 = {};
	    assertArrayEquals(expected2, toByteArray(hexString2));

	    String hexString3 = "FF";
	    Byte[] expected3 = {-1};
	    assertArrayEquals(expected3, toByteArray(hexString3));

	    String hexString4 = "0123456789ABCDEF";
	    Byte[] expected4 = {1, 35, 69, 103, -119, -85, -51, -17};
	    assertArrayEquals(expected4, toByteArray(hexString4));

	    String hexString5 = "0102030405060708090A0B0C0D0E0F";
	    Byte[] expected5 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
	    assertArrayEquals(expected5, toByteArray(hexString5));
		}
	
	@Test
	public void testGetInt() {
	    byte[] data = {0, 0, 0, 1};
	    int offset = 0;
	    int length = 4;
	    int expected = 1;
	    assertEquals(expected, getInt(data, offset, length));

	    byte[] data3 = {-1, -1, -1, -1};
	    int offset3 = 0;
	    int length3 = 4;
	    int expected3 = -1;
	    assertEquals(expected3, getInt(data3, offset3, length3));
	  }
	
	 @Test 
	  public void testToAscii() {
	    String hexString1 = "68656C6C6F20776F726C64";
	    String expected1 = "hello world";
	    assertEquals(expected1, toAscii(hexString1));

	    String hexString2 = "";
	    String expected2 = "";
	    assertEquals(expected2, toAscii(hexString2));

	    String hexString3 = "48656C6C6F20776F726C64";
	    String expected3 = "Hello world";
	    assertEquals(expected3, toAscii(hexString3));

	    String hexString4 = "41";
	    String expected4 = "A";
	    assertEquals(expected4, toAscii(hexString4));
	  }
	 
	 @Test
	  public void testByteArrayToInteger() {
	    byte[] byteArray3 = {-1, -1, -1, -1};
	    int expected3 = -1;
	    assertEquals(expected3, byteArrayToInteger(byteArray3));

	    byte[] byteArray4 = {0, 0, 0, 0};
	    int expected4 = 0;
	    assertEquals(expected4, byteArrayToInteger(byteArray4));
	  }
	 
	 @Test
	 public void testIntegerToByteArray() {
		 	int value3 = -1;
		    byte[] expected3 = {-1, -1, -1, -1};
		    assertArrayEquals(expected3, integerToByteArray(value3));

		    int value4 = 0;
		    byte[] expected4 = {0, 0, 0, 0};
		    assertArrayEquals(expected4, integerToByteArray(value4));
		  }

	 @Test
	  public void testStringListToByteArray() {
	    List<String> array1 = Arrays.asList("hello", "world");
	    int itemMaxCount1 = 2;
	    int itemMaxLength1 = 5;
	    byte[] expected1 = {104, 101, 108, 108, 111, 119, 111, 114, 108, 100};
	    assertArrayEquals(expected1, stringListToByteArray(array1, itemMaxCount1, itemMaxLength1));

	    List<String> array2 = Arrays.asList("", "");
	    int itemMaxCount2 = 2;
	    int itemMaxLength2 = 0;
	    byte[] expected2 = {};
	    assertArrayEquals(expected2, stringListToByteArray(array2, itemMaxCount2, itemMaxLength2));

	    List<String> array3 = Arrays.asList("Hello", "world", "!");
	    int itemMaxCount3 = 3;
	    int itemMaxLength3 = 5;
	    byte[] expected3 = {72, 101, 108, 108, 111, 119, 111, 114, 108, 100, 33, 0, 0, 0, 0};
	    assertArrayEquals(expected3, stringListToByteArray(array3, itemMaxCount3, itemMaxLength3));

	    List<String> array4 = Arrays.asList("A");
	    int itemMaxCount4 = 1;
	    int itemMaxLength4 = 1;
	    byte[] expected4 = {65};
	    assertArrayEquals(expected4, stringListToByteArray(array4, itemMaxCount4, itemMaxLength4));
	  }
	 
	 @Test
	  public void testByteArrayToStringList() {
	    byte[] byteArray1 = {104, 101, 108, 108, 111, 119, 111, 114, 108, 100};
	    int itemMaxCount1 = 2;
	    int itemMaxLength1 = 5;
	    List<String> expected1 = Arrays.asList("hello", "world");
	    assertEquals(expected1, byteArrayToStringList(byteArray1, itemMaxCount1, itemMaxLength1));

	    byte[] byteArray4 = {65};
	    int itemMaxCount4 = 1;
	    int itemMaxLength4 = 1;
	    List<String> expected4 = Arrays.asList("A");
	    assertEquals(expected4, byteArrayToStringList(byteArray4, itemMaxCount4, itemMaxLength4));
	  }

	 @Test
	  public void testStringToByteArray() {
	    String data1 = "hello world";
	    byte[] expected1 = {104, 101, 108, 108, 111, 32, 119, 111, 114, 108, 100};
	    assertArrayEquals(expected1, stringToByteArray(data1));

	    String data2 = "";
	    byte[] expected2 = {};
	    assertArrayEquals(expected2, stringToByteArray(data2));

	    String data3 = "Hello world!";
	    byte[] expected3 = {72, 101, 108, 108, 111, 32, 119, 111, 114, 108, 100, 33};
	    assertArrayEquals(expected3, stringToByteArray(data3));

	    String data4 = "A";
	    byte[] expected4 = {65};
	    assertArrayEquals(expected4, stringToByteArray(data4));
	  }
	 
	 @Test
	  public void testByteArrayToString() {
	    byte[] byteArray1 = {104, 101, 108, 108, 111, 32, 119, 111, 114, 108, 100};
	    String expected1 = "hello world";
	    assertEquals(expected1, byteArrayToString(byteArray1));

	    byte[] byteArray2 = {};
	    String expected2 = "";
	    assertEquals(expected2, byteArrayToString(byteArray2));

	    byte[] byteArray3 = {72, 101, 108, 108, 111, 32, 119, 111, 114, 108, 100, 33};
	    String expected3 = "Hello world!";
	    assertEquals(expected3, byteArrayToString(byteArray3));

	    byte[] byteArray4 = {65};
	    String expected4 = "A";
	    assertEquals(expected4, byteArrayToString(byteArray4));
	  }

	 @Test
	  public void testToByte() {
	    String hexString1 = "68656C6C6F20776F726C64";
	    Byte[] expected1 = {104, 101, 108, 108, 111, 32, 119, 111, 114, 108, 100};
	    assertArrayEquals(expected1, toByte(hexString1));

	    String hexString2 = "";
	    Byte[] expected2 = {};
	    assertArrayEquals(expected2, toByte(hexString2));

	    String hexString3 = "48656C6C6F20776F726C6421";
	    Byte[] expected3 = {72, 101, 108, 108, 111, 32, 119, 111, 114, 108, 100, 33};
	    assertArrayEquals(expected3, toByte(hexString3));

	    String hexString4 = "41";
	    Byte[] expected4 = {65};
	    assertArrayEquals(expected4, toByte(hexString4));
	  }

	 @Test
	  public void testToHex() {
	    byte[] arr1 = {104, 101, 108, 108, 111, 32, 119, 111, 114, 108, 100};
	    String expected1 = "68656C6C6F20776F726C64";
	    assertEquals(expected1, toHex(arr1));

	    byte[] arr2 = {};
	    String expected2 = "";
	    assertEquals(expected2, toHex(arr2));

	    byte[] arr3 = {72, 101, 108, 108, 111, 32, 119, 111, 114, 108, 100, 33};
	    String expected3 = "48656C6C6F20776F726C6421";
	    assertEquals(expected3, toHex(arr3));

	    byte[] arr4 = {65};
	    String expected4 = "41";
	    assertEquals(expected4, toHex(arr4));
	  }
	 
	 @Test
	  public void testIsHex() {
	    String str1 = "68656C6C6F20776F726C64";
	    assertTrue(isHex(str1));

	    String str2 = "";
	    assertTrue(isHex(str2));

	    String str3 = "48656C6C6F20776F726C6421";
	    assertTrue(isHex(str3));

	    String str4 = "41";
	    assertTrue(isHex(str4));

	    String str5 = "not a hex string";
	    assertFalse(isHex(str5));

	    String str6 = "4G6C6C6F20776F726C6421";
	    assertFalse(isHex(str6));
	  }

	 @Test
	  public void testDeleteFile() {
	    String path1 = "test1.txt";
	    assertTrue(deleteFile(path1));

	    String path2 = "test2.txt";
	    assertTrue(deleteFile(path2));

	    String path3 = "test3.txt";
	    assertTrue(deleteFile(path3));
	  }
	
	 @Test
	  public void testAppendBlock() throws IOException {
	    byte[] data1 = {1, 2, 3, 4, 5};
	    String path1 = "test1.txt";
	    assertTrue(appendBlock(data1, path1));

	    byte[] data2 = {6, 7, 8, 9, 10};
	    String path2 = "test2.txt";
	    assertTrue(appendBlock(data2, path2));

	    byte[] data3 = {11, 12, 13};
	    String path3 = "test3.txt";
	    assertTrue(appendBlock(data3, path3));
	  }
	
	 @Test
	  public void testUpdateBlock() throws IOException {
	    byte[] data1 = {1, 2, 3, 4, 5};
	    int count1 = 1;
	    int blockSize1 = 10;
	    String path1 = "test1.txt";
	    assertTrue(updateBlock(data1, count1, blockSize1, path1));

	    byte[] data2 = {6, 7, 8, 9, 10};
	    int count2 = 2;
	    int blockSize2 = 5;
	    String path2 = "test2.txt";
	    assertTrue(updateBlock(data2, count2, blockSize2, path2));

	    byte[] data3 = {11, 12, 13};
	    int count3 = 3;
	    int blockSize3 = 3;
	    String path3 = "test3.txt";
	    assertTrue(updateBlock(data3, count3, blockSize3, path3));
	  }

	 @Test
	  public void testDeleteBlock() throws IOException {
	    int count1 = 1;
	    int blockSize1 = 10;
	    String path1 = "test1.txt";
	    assertTrue(deleteBlock(count1, blockSize1, path1));

	    int count2 = 2;
	    int blockSize2 = 5;
	    String path2 = "test2.txt";
	    assertTrue(deleteBlock(count2, blockSize2, path2));

	    int count3 = 3;
	    int blockSize3 = 3;
	    String path3 = "test3.txt";
	    assertTrue(deleteBlock(count3, blockSize3, path3));
	  }
	 	  
}
