package com.library.view.rentitemsjframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JTextField;

import com.library.model.business.manager.RentItemsManager;
import com.library.model.business.manager.SearchItemsManager;
import com.library.model.domain.AvailableItems;
import com.library.model.domain.Book;
import com.library.model.domain.CD;
import com.library.model.domain.Movie;
import com.library.model.services.exception.AvailibilityException;
import com.library.model.services.exception.RetreivalException;
import com.library.view.Utils;
import com.library.view.mainjframe.MainJFrame;

public class RentItemsJFrameController {

	public MainJFrame libraryJFrame;
	public RentItemsJFrame rentalJFrame;
	
    /** Creates a new instance of RentItemsJFrameController */
    public RentItemsJFrameController() {
    }
	

  /*
   * Copy constructor
   */
    
  public RentItemsJFrameController (RentItemsJFrame rentalJFrame, MainJFrame libraryJFrame) 
  {
	  this.rentalJFrame = rentalJFrame;

        //add all the action listeners here
    	libraryJFrame.getButtonRent().addActionListener((ActionListener) this);
    	rentalJFrame.getCatalogNumberText().addActionListener((ActionListener) this); 
    	rentalJFrame.getButtonRentScreen().addActionListener((ActionListener) this);
        Utils.centerWindow(libraryJFrame);
        libraryJFrame.setVisible(true);
      }

  /*
   *  (non-Javadoc)
   * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
   */
  public void actionPerformed(ActionEvent event) throws FileNotFoundException, ClassNotFoundException, IOException, AvailibilityException, RetreivalException 
  {

	 
    System.out.println ("Inside RentalJFrameController::actionPerformed");
    if (event.getSource().equals(libraryJFrame.getButtonRent()))
    {
    	getRentalStatus_actionPerformed(event, rentalJFrame.getCatalogNumberText().getText(), rentalJFrame.getResultsTextField());
    
    }
    else if (event.getSource().equals(rentalJFrame.getButtonBackToSearch()))
    {
    	getSearchPage_actionPerformed(event);
    }
    else if (event.getSource().equals(rentalJFrame.getButtonRentScreen()))
    {
    	getRentalStatus_actionPerformed(event, rentalJFrame.getCatalogNumberText().getText(), rentalJFrame.getResultsTextField());
    }
  }

  
 public void getRentalStatus_actionPerformed(ActionEvent event, String text, JTextField jResultsTextField) throws FileNotFoundException, ClassNotFoundException, IOException, AvailibilityException, RetreivalException {

	 //jResultsTextField.setText("Clicked Rent");
	 System.out.println("Inside getRentalStatus_actionPerformed");
	 
	 performRentOperation(text, jResultsTextField);
	
}


private void performRentOperation(String text, JTextField jResultsTextField) throws FileNotFoundException, IOException, AvailibilityException, ClassNotFoundException, RetreivalException {
	
	SearchItemsManager searchItemsManager;
	RentItemsManager rentItemsManager;
	AvailableItems availableItems;
	boolean rentSuccess = false;
	long catNum = Long.parseLong(text);
	searchItemsManager = SearchItemsManager.getInstance();
	rentItemsManager = RentItemsManager.getInstance();
	
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
	
	
	rentSuccess = rentItemsManager.performActionRent(availableItems, catNum);
	
	if (rentSuccess == true) {
		jResultsTextField.setText("Rent Successful, Catalog Number: " + text);
	}
	else {
		jResultsTextField.setText("Rent Unsuccessful, Item may be invalid or not available");
	}
	
}


public void getRentalPage_actionPerformed(ActionEvent actionEvent, String string, JTextField jResultsTextField) throws FileNotFoundException, IOException, AvailibilityException, ClassNotFoundException, RetreivalException 
  {     
	     new RentItemsJFrame().setVisible(true);

  } //end getSearchItems_actionPerformed

 public void getSearchPage_actionPerformed(ActionEvent actionEvent) {
	 
	 	System.out.println("Back to Search Page");
	     new MainJFrame().setVisible(true);
 }
  
}
