package com.library.model.business.manager;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import com.library.model.business.exception.PropertyFileNotFoundException;
import com.library.model.domain.AvailableItems;
import com.library.model.services.exception.AvailibilityException;
import com.library.model.services.exception.RetreivalException;
import com.library.model.services.manager.PropertyManager;

/**
*
* @author Veeral Patel
*
*This abstract class calls the PropertyManager to load the application.properties file, as well as gives the abstract method of performAction to call out services
*/

//this is an abstract Manager Super Type Class. This call is in charge of finding the properties file, and performing the services
public abstract class ManagerSuperType {

	static
	{
    	try
		{
    		//This is calling the load properties file (application.properties)
    		ManagerSuperType.loadProperties();  
		}
    	catch (PropertyFileNotFoundException propertyFileNotFoundException)
		{
    	   //Throws the Property File Not Found Exception is the file is not located
    	   System.out.println ("Application Properties failed to be loaded - Application exiting...");
    	   System.exit(1); 
		}				
	} 


	@SuppressWarnings("rawtypes") //This Supress Warnings will supress the warning for ArrayList being unspecified, It can be <?> to make this go away.
	// This is another abstract class, it is referred to in the SearchItemsManager.java class
	public abstract ArrayList performAction(String commandString, AvailableItems availableItems, String searchString) throws IOException, RetreivalException, ClassNotFoundException; 
	
	public abstract boolean performActionRent(AvailableItems availableItems, Long catalogNumber) throws FileNotFoundException, ClassNotFoundException, RetreivalException, IOException, AvailibilityException;
	
	//This method is called above to load the properties file
    public static void loadProperties () throws PropertyFileNotFoundException
	{
		

		String propertyFileLocation = System.getProperty("prop_location");
		
        if (propertyFileLocation != null)
        { 
          PropertyManager.loadProperties(propertyFileLocation);
        }
        else
        {
          System.out.println("Property file location not set. Passed in value is: " + propertyFileLocation + ".");
          throw new PropertyFileNotFoundException ("Property file location not set", null);         
        }
    	
	}

	public ArrayList<?> performActionRent(String commandString, AvailableItems availableItems, String searchString)
			throws IOException, RetreivalException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
    
}
