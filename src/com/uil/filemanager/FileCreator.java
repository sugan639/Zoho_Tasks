package com.uil.filemanager;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.util.customexception.TaskException;
import com.util.helpers.Helper;

public class FileCreator {
	
	
	
	
	
	//method 2
    public void createFile(String fileName, List<String> lines) 
    										throws TaskException {
    	// Create a File object for the given file name
    		String currDir = System.getProperty("user.dir");
    		createFile(fileName, currDir, lines); 
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    // method 3
    public void createFile(String filePath,  String fileName,
    		List<String> lines) throws TaskException {
    	
    	
        File directory = new File(filePath);
        
        if (!directory.exists() && !directory.mkdirs()) {
                throw new TaskException("Failed to create directory: " + filePath);
            
        }

        File file = new File(directory, fileName);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new TaskException("Error writing to file: " + file.getAbsolutePath(), e);
        }
    
}
    
}










    