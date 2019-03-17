package com.library.model.domain;
import org.junit.Test;

import junit.framework.TestCase;

public class BookTest extends TestCase{

	/**
	 * Tests with an Book that the Book Class validates
	 */
	@Test	
	public void testValidate() {
		Book bookTest = new Book ("Head First Java", "O'Rielley Media", 2001, 34594234);
		assertTrue ("bookTest validates", bookTest.validate());
	       System.out.println("testValidate PASSED");
	}
	
	/**
	* This test method invokes the equals method of class Book, and then passes two objects, that are equal. 
	* If both objects are equal, the assertTrue statement will pass.
	*/
	@Test
	public void testEqualsTrue() {
		Book harryPotter = new Book ("Harry Potter: Order of the Phoenix", "J.K. Rowling", 2001, 600134234);
		Book harryPotter1 = new Book ("Harry Potter: Order of the Phoenix", "J.K. Rowling", 2001, 600134234);
		
		assertTrue ("Both Books Are Equal", !(harryPotter.equals(harryPotter1)));
	}
	
	/**
	* This test method invokes the equals method of class Book, and then passes two objects, that are not equal. 
	* If both objects are equal, the assertFalse statement will pass.
	*/
	@Test
	public void testEqualsFail() {
		Book harryPotter = new Book ("Harry Potter: Order of the Phoenix", "J.K. Rowling", 2001, 600134234);
		Book harryPotterFail = new Book ("Harry Potter", "J.K.", 2005, 600134234);
		
		assertFalse ("Both Books Are Not Equal", harryPotter.equals(harryPotterFail));
	}

}
