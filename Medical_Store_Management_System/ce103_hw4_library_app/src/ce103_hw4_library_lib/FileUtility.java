package ce103_hw4_library_lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileOutputStream;

public class FileUtility 
{
	
	/**
	 * Deletes the file at the specified path.
	 *
	 * @param path the path to the file to delete
	 * @return true if the file was successfully deleted, false otherwise
	 */
	public static boolean deleteFile(String path) 
	{
        if (new File(path).exists()) 
        {
            new File(path).delete();
        }

        return true;
    }
	
	
	/**
	 * Reads a block of data from the file at the specified path.
	 *
	 * @param count the block number to read (1-based)
	 * @param blockSize the size of each block in bytes
	 * @param path the path to the file to read from
	 * @return a byte array containing the data read from the file
	 * @throws IOException if an error occurs while reading the file
	 */
	public static byte[] readBlock(int count, int blockSize, String path) throws IOException 
	{
        byte[] buffer = new byte[blockSize];

        try (FileInputStream fileInputStream = new FileInputStream(path)) 
        {
            fileInputStream.skip((count - 1) * blockSize);
            fileInputStream.read(buffer, 0, buffer.length);
        }

        return buffer;
    }
	
	
	/**
	 * Appends a block of data to the file at the specified path.
	 *
	 * @param data the data to append to the file
	 * @param path the path to the file to append to
	 * @return true if the data was successfully appended to the file, false otherwise
	 * @throws IOException if an error occurs while writing to the file
	 */
	public static boolean appendBlock(byte[] data, String path) throws IOException 
	{
        try (FileOutputStream fileOutputStream = new FileOutputStream(path, true)) 
        {
            fileOutputStream.write(data);
        }

        return true;
    }
	
	
	/**
	 * Updates a block of data in the file at the specified path.
	 *
	 * @param data the data to update in the file
	 * @param count the block number to update (1-based)
	 * @param blockSize the size of each block in bytes
	 * @param path the path to the file to update
	 * @return true if the data was successfully updated in the file, false otherwise
	 * @throws IOException if an error occurs while writing to the file
	 */
	public static boolean updateBlock(byte[] data, int count, int blockSize, String path) throws IOException
	{
        try (FileOutputStream fileOutputStream = new FileOutputStream(path)) 
        {
            fileOutputStream.getChannel().position((count - 1) * blockSize);
            fileOutputStream.write(data);
        }

        return true;
    }
	
	
	/**
	 * Deletes a block of data in the file at the specified path.
	 *
	 * @param count the block number to delete (1-based)
	 * @param blockSize the size of each block in bytes
	 * @param path the path to the file to delete from
	 * @return true if the data was successfully deleted from the file, false otherwise
	 * @throws IOException if an error occurs while writing to the file
	 */
	public static boolean deleteBlock(int count, int blockSize, String path) throws IOException 
	{
        byte[] data = new byte[blockSize];

        try (FileOutputStream fileOutputStream = new FileOutputStream(path)) 
        {
            fileOutputStream.getChannel().position((count - 1) * blockSize);
            fileOutputStream.write(data);
        }

        return true;
    }
}
