package com.library.model.domain;

import java.io.Serializable;
import java.util.ArrayList;

public class RentalItem implements Serializable{

	/**
	 * @author Veeral Patel
	 */
	
	//Here we need Serializable to be able to write to the output files
	private static final long serialVersionUID = 1L;
	
	//the allAvailableItems is used to add every object in the library that is available
		ArrayList<Object> allAvailableItems = new ArrayList<Object>();
		
	
	public static boolean rentItem(ArrayList<Object> allAvailableItems, Long rentCatalogNum){
		
		
		for(int i = 0; i< allAvailableItems.size(); i++) {
			
			if(allAvailableItems.get(i) instanceof Book)
				{
				if(((Book) allAvailableItems.get(i)).getCatalogNum() == (rentCatalogNum)) {
					
					if(((Book) allAvailableItems.get(i)).isAvailibility() == false) {
						System.out.println("Book Is Not Available");
						return false;
					}
					else {
						((Book) allAvailableItems.get(i)).setAvailibility(false);	
						return true;
						}				
					}
				}
			else if(allAvailableItems.get(i) instanceof Movie)
			{
				if(((Movie) allAvailableItems.get(i)).getCatalogNumber() == (rentCatalogNum)) {
					
					if(((Movie) allAvailableItems.get(i)).isAvailibility() == false) {
						System.out.println("Movie Is Not Available");
						return false;
					}
					else {
						((Movie) allAvailableItems.get(i)).setAvailibility(false);	
						return true;
					}	
				}				
			}
			else if(allAvailableItems.get(i) instanceof CD)
			{
				if(((CD) allAvailableItems.get(i)).getCatalogNumber() == (rentCatalogNum)) {
					if(((CD) allAvailableItems.get(i)).isAvailibility() == false) {
						System.out.println("CD Is Not Available");
						return false;
					}
					else {
						((CD) allAvailableItems.get(i)).setAvailibility(false);		
						return true;
					}					
				}
			}
			else {
				System.out.println("Invalid Catalog Number, There Are No Matches");
				return false;
			}
			
			}
		
		return false;
		
	
	}
	
}
