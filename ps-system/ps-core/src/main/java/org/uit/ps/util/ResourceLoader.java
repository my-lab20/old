package org.uit.ps.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ResourceLoader {
	
	public static byte[] getFileContent(ClassLoader classLoader, String fileName) throws IOException{
		int len;
	    int size = 1024;
	    byte[] buf;
	    
	    InputStream is = new BufferedInputStream(classLoader.getResourceAsStream(fileName));
	    try {
	    	ByteArrayOutputStream bos = new ByteArrayOutputStream();
	    	buf = new byte[size];
	    	while ((len = is.read(buf, 0, size)) != -1)
	    		bos.write(buf, 0, len);
	    	buf = bos.toByteArray();
	    }
	    finally {
	    	try {
	    		is.close();
	    	}
	    	catch(Exception e) {
	    		
	    	}
	    }
	    
	    return buf;
    }

	public static String getTextFileContent(ClassLoader classLoader, String fileName) throws IOException{
        BufferedReader reader = null;
        try {
            StringBuffer res = new StringBuffer();
            reader = new BufferedReader(new InputStreamReader(
            		classLoader.getResourceAsStream(fileName), 
                    "UTF-8"));
            String text = null;
            while ((text = reader.readLine()) != null) {
                res.append(text).append(System.getProperty("line.separator"));
            }
            return res.toString();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
