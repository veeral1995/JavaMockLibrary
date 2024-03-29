package com.library.view.rentitemsjframe;

import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.AbstractButton;

import com.library.model.services.exception.AvailibilityException;
import com.library.model.services.exception.RetreivalException;
import com.library.view.mainjframe.MainJFrameController;
import com.library.view.rentitemsjframe.RentItemsJFrameController;

/**
 * ItineraryJFrame.java
 *
 * Build one of the GUIs (View) for the Library application.
 *
 * Note:
 * 
 * This class doesn't implement all the View classes
 * in its entirety. This is just a sample implementation. 
 * 
 * For example, customer's are allowed to enter their
 * search and try to find library items that match the search. Or 
 * they can also do a search all
 *
 *
 * @author  Veeral Patel
 */
public class RentItemsJFrame extends javax.swing.JFrame {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 3320197207777135961L;
	
	MainJFrameController mjc = new MainJFrameController();
	RentItemsJFrameController rjc = new RentItemsJFrameController();
	/** Creates new form ItineraryJFrame */
    public RentItemsJFrame() {
        initComponents();
        
        this.setSize(350,300);                
        this.setVisible(true); 
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */

 private void initComponents() {

  jMenuBar = new javax.swing.JMenuBar();
  setJMenuBar(jMenuBar);
  jPanel = new javax.swing.JPanel();
  jTextFieldCatalogNumber = new javax.swing.JTextField();
  jButtonRentScreen = new javax.swing.JButton();
  jResultsTextField = new javax.swing.JTextField();
  jCatalogLabel = new javax.swing.JLabel();;
  jMenuBar.setOpaque(false);
  jButtonBackToSearch = new javax.swing.JButton();


  setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
  setTitle("Library Search Application");
  setFont(new java.awt.Font("Comic Sans MS", 0, 10));
  getContentPane().setLayout(null);

  jPanel.setBackground(new java.awt.Color(153, 153, 255));
  jPanel.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
  jPanel.setLayout(null);

  jCatalogLabel.setFont(new java.awt.Font("Comic Sans MS", 1, 11));
  jCatalogLabel.setText("Catalog Num:");
  jPanel.add(jCatalogLabel);
  jCatalogLabel.setBounds(47, 10, 90, 17);
  
  jResultsTextField.setFont(new java.awt.Font("Comic Sans MS", 1, 11));
  jResultsTextField.setText("Rental Results..");
  jPanel.add(jResultsTextField);
  jResultsTextField.setBounds(50,50,260,90);
 

  jTextFieldCatalogNumber.setFont(new java.awt.Font("Comic Sans MS", 0, 11));
  jTextFieldCatalogNumber.setText("");
  jPanel.add(jTextFieldCatalogNumber);
  jTextFieldCatalogNumber.setBounds(130, 10, 90, 22);

  jButtonRentScreen.setFont(new java.awt.Font("Comic Sans MS", 1, 11));
  jButtonRentScreen.setText("Sumbit Rental");
  jPanel.add(jButtonRentScreen);
  jButtonRentScreen.setBounds(180, 200, 150, 25);
  jButtonRentScreen.addActionListener(new java.awt.event.ActionListener() {
  
	  	public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					jButtonRentActionPerformed(evt);
				} catch (ClassNotFoundException | IOException | AvailibilityException | RetreivalException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	  	}
  });
  
  jButtonBackToSearch.setFont(new java.awt.Font("Comic Sans MS", 1, 11));
  jButtonBackToSearch.setText("Back To Search");
  jPanel.add(jButtonBackToSearch);
  jButtonBackToSearch.setBounds(20, 200, 150, 25);
  jButtonBackToSearch.addActionListener(new java.awt.event.ActionListener() {
  
	  	public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					jButtonBackToSearchActionPerformed(evt);
				} catch (ClassNotFoundException | IOException | AvailibilityException | RetreivalException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	  	}
  });
  
  
  getContentPane().add(jPanel);
  jPanel.setBounds(0, 0, 450, 300);
 }

 private void jButtonRentActionPerformed(java.awt.event.ActionEvent evt) throws FileNotFoundException, ClassNotFoundException, IOException, AvailibilityException, RetreivalException {
	 rjc.getRentalStatus_actionPerformed(evt, jTextFieldCatalogNumber.getText(), jResultsTextField);
	}
 private void jButtonBackToSearchActionPerformed(java.awt.event.ActionEvent evt) throws FileNotFoundException, ClassNotFoundException, IOException, AvailibilityException, RetreivalException {
	 rjc.getSearchPage_actionPerformed(evt);
	}

	    /**
	     * Returns jButtonRent 
	     */    
	    public javax.swing.JButton getButtonRentScreen()
	    {
	        return jButtonRentScreen;
	    }   
	    
	    public javax.swing.JButton getButtonBackToSearch()
	    {
	        return jButtonBackToSearch;
	    }    
	    
	    public javax.swing.JTextField getResultsTextField(){
	    	
	    	return jResultsTextField;
	    }

	    public javax.swing.JTextField getCatalogNumberText(){
	    	
	    	return jTextFieldCatalogNumber;
	    }
	    /**
	     * Returns an Itinerary domain object populated with user entered
	     * data.
	     */


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                RentItemsJFrame rentalJFrame = new RentItemsJFrame();
                
                
            }
        });
    }
    
 // Variables declaration - do not modify//GEN-BEGIN:variables
 public javax.swing.JButton jButtonRentScreen;
 public javax.swing.JButton jButtonBackToSearch;
 private javax.swing.JMenuBar jMenuBar;
 public javax.swing.JTextField jResultsTextField;
 private javax.swing.JLabel jCatalogLabel;
 private javax.swing.JPanel jPanel;
 private javax.swing.JTextField jTextFieldCatalogNumber;
 // End of variables declaration//GEN-END:variables


}
