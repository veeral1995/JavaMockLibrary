package com.library.view.mainjframe;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTextField;

import com.library.view.mainjframe.MainJFrame;
import com.library.model.business.manager.SearchItemsManager;
import com.library.model.domain.AvailableItems;
import com.library.model.domain.Book;
import com.library.model.domain.CD;
import com.library.model.domain.Movie;
import com.library.model.services.exception.AvailibilityException;
import com.library.model.services.exception.RetreivalException;
import com.library.view.Dialog;
import com.library.view.Utils;


/**
 * availableitemsJFrameController.java
 *
 * Listens and handles actions generated from availableitemsJFrame.java
 * 
 * @author Veeral Patel
 */

public class MainJFrameController extends JFrame implements ActionListener 
{
	
	public MainJFrame libraryJFrame;
	
    /** Creates a new instance of ItineraryJFrameController */
    public MainJFrameController() {
    }
	

  /*
   * Copy constructor
   */
    
  public MainJFrameController (MainJFrame libraryJFrame) 
  {
	  this.libraryJFrame = libraryJFrame;

        //add all the action listeners here
    	libraryJFrame.getSearchStringButton().addActionListener(this);
    	libraryJFrame.getSearchAllButton().addActionListener(this);
    	libraryJFrame.getSearchText().addActionListener(this);   
        // center the frame
        Utils.centerWindow(libraryJFrame);
        libraryJFrame.setVisible(true);
      }

  /*
   *  (non-Javadoc)
   * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
   */
  public void actionPerformed(ActionEvent event) 
  {

	 
    System.out.println ("Inside availableitemsJFrameController::actionPerformed");
    if (event.getSource().equals(libraryJFrame.getSearchStringButton()))
		try {
			getSearchItems_actionPerformed(event, libraryJFrame.getSearchText().getText(), libraryJFrame.jResultsTextField);
		} catch (ClassNotFoundException | IOException | AvailibilityException | RetreivalException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	else if (event.getSource().equals(libraryJFrame.getSearchAllButton()))
		try {
			getAllItems_actionPerformed(event, libraryJFrame.jResultsTextField);
		} catch (ClassNotFoundException | IOException | RetreivalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AvailibilityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  }

  
  @SuppressWarnings("deprecation")
void getSearchItems_actionPerformed(ActionEvent actionEvent, String searchString, javax.swing.JTextField jResultsTextField) throws FileNotFoundException, IOException, AvailibilityException, ClassNotFoundException, RetreivalException 
  {
	     System.out.println("Inside availableitemsJFrameController; All Items was Clicked");
	     System.out.println("Search String Is: " + searchString);
	 	 SearchItemsManager searchItemsManager;
	 	 AvailableItems availableItems;	
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
		 ArrayList<Object> results = (ArrayList<Object>) searchItemsManager.performAction("SearchItems", availableItems, searchString);	

	 	 System.out.println("Here are the results: " + results);
	 	jResultsTextField.setText(results.toString());    
  } //end getSearchItems_actionPerformed

  
/**
   * Processes Get Available Library Items action
   *
   * @param actionEvent ActionEvent
 * @throws RetreivalException 
 * @throws IOException 
 * @throws ClassNotFoundException 
 * @throws AvailibilityException 
   */
  
  @SuppressWarnings("deprecation")
void getAllItems_actionPerformed(ActionEvent actionEvent, javax.swing.JTextField jResultsTextField) throws ClassNotFoundException, IOException, RetreivalException, AvailibilityException 
  {
     System.out.println("Inside availableitemsJFrameController; All Items was Clicked");
 	 SearchItemsManager searchItemsManager;
 	 AvailableItems availableItems;	
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
	 ArrayList<Object> results = (ArrayList<Object>) searchItemsManager.performAction("SearchAllItems", availableItems);	

 	 System.out.println("Here are the results: " + results);
 	 jResultsTextField.setText(results.toString());       
  }


  
} //end class   