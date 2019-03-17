package com.library.model.services.rentalservice;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import com.library.model.domain.AvailableItems;
import com.library.model.domain.RentalItem;
import com.library.model.services.exception.AvailibilityException;

/**
*
* @author Veeral Patel
*
*/

public class RentalServiceImpl implements IRentalService {

	
	
	public boolean rentItem(AvailableItems availableItems, Long catalogNumber) throws FileNotFoundException, IOException, AvailibilityException  {
		
		ArrayList<Object> allItems = new ArrayList<>();			
		allItems = availableItems.returnAllAvailibleItems();
		boolean rentSuccess;
		rentSuccess = RentalItem.rentItem(allItems, catalogNumber);
		
		
		return rentSuccess;
	}	
	


}
