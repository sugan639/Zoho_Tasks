	package com.uil.filemanager;

	import com.util.customexception.TaskException;

	import java.io.FileInputStream;
	import java.io.IOException;
	import java.util.Properties;
	
public class PropertiesReader {
	
	
	
	    public Properties loadProperties(String filePath) throws TaskException {
	    	
			Properties properties = new Properties();

	        
	        try (FileInputStream input = new FileInputStream(filePath)) {
	            properties.load(input);
	        }
	        catch (IOException e) {
	            throw new TaskException(filePath, e);
	        }
	        return properties;
	    }
	}