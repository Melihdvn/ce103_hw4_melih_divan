package ce103_hw4_library_lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileOutputStream;

public class FileUtility 
{
	public static boolean deleteFile(String path) 
	{
        if (new File(path).exists()) 
        {
            new File(path).delete();
        }

        return true;
    }
	
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
	
	public static boolean appendBlock(byte[] data, String path) throws IOException 
	{
        try (FileOutputStream fileOutputStream = new FileOutputStream(path, true)) 
        {
            fileOutputStream.write(data);
        }

        return true;
    }
	
	public static boolean updateBlock(byte[] data, int count, int blockSize, String path) throws IOException
	{
        try (FileOutputStream fileOutputStream = new FileOutputStream(path)) 
        {
            fileOutputStream.getChannel().position((count - 1) * blockSize);
            fileOutputStream.write(data);
        }

        return true;
    }
	
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
