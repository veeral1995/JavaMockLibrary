package com.library.model.business.manager;

import junit.framework.TestCase;

import java.io.IOException;
import java.util.ArrayList;

import com.library.model.domain.AvailableItems;
import com.library.model.domain.Book;
import com.library.model.domain.CD;
import com.library.model.domain.Movie;
import com.library.model.services.exception.AvailibilityException;
import com.library.model.services.exception.RetreivalException;

/**
 * This unit test tests the FleetRentalManager class. Only does positive/happy path testing.
 * Realistic test would be more comprehensive including all negative testing!
 * 
 * @author Veeral Patel
 * 
 *
 */
public class SearchItemsManagerTest extends TestCase {

	private SearchItemsManager searchItemsManager;
	private AvailableItems availableItems;
	
	protected void setUp() throws Exception {
		super.setUp();
	
		searchItemsManager = SearchItemsManager.getInstance();
		
		Book newBook = new Book("Becoming", "Michelle Obama", 2018, 32232);
		Book newBook1 = new Book("48 Laws of Power", "Sun Tsie", 2000, 004546345);
		CD newCD = new CD("Rings", "Ariana Grande", 2019, 767456456);
		CD newCD1 = new CD("Views", "Drake", 2016, 0435345);
		Movie newMovie = new Movie("A Simple Favor", 2018, 322456432);
		
		availableItems = new AvailableItems();
		availableItems.addBook(newBook);
		availableItems.addBook(newBook1);
		availableItems.addCD(newCD);
		availableItems.addCD(newCD1);
		availableItems.addMovie(newMovie);
	}

	
	/**
	 * Test performAction method for RegisterCustomer
	 * @throws RetreivalException 
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * @throws AvailibilityException 
	 */
	public final void testPerformActionOnSearchAll() throws ClassNotFoundException, IOException, RetreivalException, AvailibilityException
	{
		ArrayList<?> results = searchItemsManager.performAction("SearchAllItems", availableItems);
		assertTrue(!results.isEmpty());
	}
	
	/**
	 * Test performAction method for LoginCustomer
	 * @throws RetreivalException 
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public final void testPerformActionOnSearchString() throws ClassNotFoundException, IOException, RetreivalException
	{
		ArrayList<?> results = searchItemsManager.performAction("SearchItems", availableItems, "Becoming");
		assertTrue(!results.isEmpty());
	}
	

} 
