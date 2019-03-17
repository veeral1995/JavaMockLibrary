package com.library.model.business.manager;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import com.library.model.business.exception.ServiceLoadException;
import com.library.model.domain.AvailableItems;
import com.library.model.services.exception.AvailibilityException;
import com.library.model.services.exception.RetreivalException;
import com.library.model.services.factory.ServiceFactory;
import com.library.model.services.retreivalservice.IRetreivalService;

/**
 *
 * @author Veeral Patel
 *
 */

public class SearchItemsManager extends ManagerSuperType {

	private static SearchItemsManager _instance;

	private SearchItemsManager() {}


	public static synchronized SearchItemsManager getInstance() {
		if (_instance == null) {
			_instance = new SearchItemsManager();
		}
		return _instance;
	}

	/**
	 * @throws IOException 
	 * @throws RetreivalException 
	 * @throws ClassNotFoundException 
	 * @throws AvailibilityException 
	 * @throws FileNotFoundException 
	 * This performAction is being referred to from the ManagerSuperType abstract class. 
	 */
	@SuppressWarnings({ "unchecked" })
	public ArrayList<?> performAction (String commandString, AvailableItems availableItems) throws IOException, RetreivalException, ClassNotFoundException, AvailibilityException {
		ArrayList<Object> returnResults = new ArrayList<>();
		
		if (commandString.equals("SearchAllItems")) {
				returnResults = returnAllAvailableItems(IRetreivalService.NAME, availableItems);
			}	
		return returnResults;
	}
	
	//This performAction method is an example of overloading. Here, we are overloading the performAction method depending on the function in the service we want to use
	@SuppressWarnings("unchecked")
	public ArrayList<?> performAction (String commandString, AvailableItems availableItems, String searchString) throws IOException, RetreivalException, ClassNotFoundException {
		ArrayList<Object> returnResults = new ArrayList<>();
		
		if (commandString.equals("SearchItems")) {
				returnResults = returnSearchResult(IRetreivalService.NAME, availableItems, searchString);
			}
		
		return returnResults;
	}

	/**
	 * @throws IOException 
	 * @throws RetreivalException 
	 * @throws ClassNotFoundException 
	 * @throws FileNotFoundException 
	 * 
	 * This method, returnAllAvailableItems, returns all the items in the library that are available for rental
	 * @throws AvailibilityException 
	 */
		
	@SuppressWarnings({ "rawtypes" })
	public ArrayList returnAllAvailableItems (String commandString, AvailableItems availableItems) throws FileNotFoundException, ClassNotFoundException, RetreivalException, IOException, AvailibilityException {

		//This allAvailabelItems arrayList will be returned. It is filled with all available items
		ArrayList<?> allAvailableItems = new ArrayList<>();

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		IRetreivalService iRetreivalService;

		try {
			iRetreivalService = (IRetreivalService) serviceFactory
					.getService(commandString);
			allAvailableItems = iRetreivalService.getAllItems(availableItems);
		} 
		//This exception occurs when the service factory did not load correctly.
		catch (ServiceLoadException e1) {
			System.out.println("SearchLibraryManager::returnAllItems failed");
		}

		return allAvailableItems;

	}

	/**
	 * @throws IOException 
	 * @throws RetreivalException 
	 * @throws ClassNotFoundException 
	 * @throws FileNotFoundException 
	 * 
	 * This method, returnSearchResult, only returns the items whose titles, match the searchString that we pass to it
	 */
	@SuppressWarnings("rawtypes")
	public ArrayList returnSearchResult(String commandString, AvailableItems availableItems, String searchString) throws FileNotFoundException, ClassNotFoundException, RetreivalException, IOException {

		//This searchResult arrayList will be returned. It is filled with all matches of the search
		ArrayList<?> searchResult = new ArrayList<>();

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		IRetreivalService iRetreivalService;

		try {
			iRetreivalService = (IRetreivalService) serviceFactory
					.getService(commandString);
			searchResult = iRetreivalService.returnSearchResult(availableItems, searchString);
		} 
		//This exception occurs when the service factory did not load correctly.
		catch (ServiceLoadException e1) {
			System.out.println("SearchItemsManager::search failed"); 
		} 
		
		return searchResult;
	}


	@Override
	public boolean performActionRent(AvailableItems availableItems, Long catalogNumber)
			throws FileNotFoundException, ClassNotFoundException, RetreivalException, IOException {
		// TODO Auto-generated method stub
		return false;
	}

}