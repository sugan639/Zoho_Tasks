package com.uil.filemanager;

import com.util.customexception.TaskException;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesManager {
	
    public void storeProperties(String filePath, Properties properties, String comments) throws TaskException {
    	
        try (FileOutputStream output = new FileOutputStream(filePath)) {
            properties.store(output, comments);
        } 
        catch (IOException e) {
            throw new TaskException("Error storing properties: " + filePath, e);
        }
    }
}