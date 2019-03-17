package com.library.view.searchitemsjframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import com.library.model.business.manager.SearchItemsManager;
import com.library.model.domain.AvailableItems;
import com.library.model.services.exception.RetreivalException;
import com.library.view.Dialog;
import com.library.view.Utils;


/**
 * SearchItemsJFrameController.java
 *
 * Listens and handles actions generated from SearchItemsJFrame.java
 * 
 * @author Mike.Prasad
 */

public class SearchItemsJFrameController 
        implements ActionListener 
{

	private SearchItemsJFrame SearchItemsJFrame;
	
    /** Creates a new instance of ItineraryJFrameController */
    public SearchItemsJFrameController() {
    }
     

  /*
   * Copy constructor
   */
    
  public SearchItemsJFrameController (SearchItemsJFrame SearchItemsJFrame)
  {
    this.SearchItemsJFrame = SearchItemsJFrame;

    //add all the action listeners here
    SearchItemsJFrame.getRentButton().addActionListener(this);
    SearchItemsJFrame.getBackButton().addActionListener(this);
       
    // center the frame
    Utils.centerWindow(SearchItemsJFrame);
    SearchItemsJFrame.setVisible(true);
  }

  /*
   *  (non-Javadoc)
   * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
   */
  public void actionPerformed(ActionEvent event) 
  {

    System.out.println ("Inside SearchItemsJFrameController::actionPerformed");
    
    if (event.getSource().equals(SearchItemsJFrame.getBackButton()))
		try {
			ok_actionPerformed(event);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RetreivalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	else if (event.getSource().equals(SearchItemsJFrame.getRentButton()))
      cancel_actionPerformed(event);
  }

  void menuFileOpen_actionPerformed(ActionEvent actionEvent) 
  {
   
    Dialog dlg = new Dialog( "File Open", " Read comments in callback code");    
    Utils.centerWindow(dlg);
    dlg.setModal(true);
      return;  
  } 

  void menuReadDB_actionPerformed (ActionEvent actionEvent) 
  {
   
    Dialog dlg = new Dialog( "File Open", " Read comments in callback code");    
    Utils.centerWindow(dlg);
    dlg.setModal(true);

      return;  
  }
  
  

 private void cancel_actionPerformed(ActionEvent event) {
  SearchItemsJFrame.setVisible(false);
  SearchItemsJFrame.dispose();
 }


 private void ok_actionPerformed(ActionEvent event) throws ClassNotFoundException, IOException, RetreivalException {
    
     AvailableItems AvailableItems = new AvailableItems();
     
 	 SearchItemsManager libraryManager = SearchItemsManager.getInstance();
 	 if (libraryManager != null)
 	 {	 
	 	 ArrayList<?> action =  libraryManager.performAction("SearchAllItems", AvailableItems);
	
	     if (action != null)
	     {	 
	       Dialog dlg = new Dialog( "Item Search", "Here are the available Items");    
	       Utils.centerWindow(dlg);
	       dlg.setModal(true);
	       dlg.show();
	       
	       // tear down registration dialog
	       SearchItemsJFrame.setVisible(false);
	       SearchItemsJFrame.dispose();
	     } 
	     else
	     {
	         Dialog dlg = new Dialog( "Item Search" , "Search Failed");    
	         Utils.centerWindow(dlg);
	         dlg.setModal(true);
	         dlg.show();
	     }
 	 }
 	 
     else
     {
         Dialog dlg = new Dialog( "Internal Error" , "Registration Failed. Please try back later!");    
         Utils.centerWindow(dlg);
         dlg.setModal(true);
         dlg.show();
    	 
     }
 	 
 }

  
} //end class   