package com.uil.filemanager;

import java.io.File;
import java.util.List;
import java.util.Properties;

import com.util.customexception.TaskException;

public class DirectoryAndFileManager {
	// getters
	public FileCreator getFileCreator() {
		FileCreator fileCreator = new FileCreator();
		return fileCreator;
	}
	
	public PropertiesManager getPropertiesManager() {
		PropertiesManager propertiesManager =new PropertiesManager();
		return propertiesManager;
	}
	
	public PropertiesReader getPropertiesReader() {
		PropertiesReader propertiesReader = new PropertiesReader();
		return propertiesReader ;
	}
	
	// Core method
    public void createDirectoryAndFiles(String dirPath, String sampleFilePath, List<String> sampleLines,
                                        String propsFilePath, Properties properties, String comments) throws TaskException {
        
    	File dir = new File(dirPath);
    	
        if (!dir.exists() && !dir.mkdirs())
        {
            throw new TaskException("Failed to create directory: " + dirPath);
        }

        FileCreator fileCreator = getFileCreator();
        fileCreator.createFile(sampleFilePath, sampleLines);

        PropertiesManager propertiesManager = getPropertiesManager();
        propertiesManager.storeProperties(propsFilePath, properties, comments);

        PropertiesReader propertiesReader = getPropertiesReader();
        Properties loadedProps = propertiesReader.loadProperties(propsFilePath);
      
    }
}