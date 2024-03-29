package com.library.view.searchitemsjframe;

import com.library.model.domain.AvailableItems;

/**
 * RegisterCustomerJFrame.java
 *
 * UI to capture customer registration information.
 *
 * @author  Mike.Prasad
 */
public class SearchItemsJFrame extends javax.swing.JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = -685641941903021280L;
	
	private SearchItemsJFrameController registerCustomerJFrameController;

    /** Creates new form ItineraryJFrame */
    public SearchItemsJFrame() {
        initComponents();

        registerCustomerJFrameController = new SearchItemsJFrameController(this);

        this.setSize(350,300);                
        this.setVisible(true); 
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
 // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
 @SuppressWarnings("deprecation")
private void initComponents() {
	 
  jMenuBar = new javax.swing.JMenuBar();
  setJMenuBar(jMenuBar);
  jPanel = new javax.swing.JPanel();
  jLabelTitle = new javax.swing.JLabel();
  jLabelAuthor = new javax.swing.JLabel();
  jLabelArtist = new javax.swing.JLabel();
  jLabelCatalogNumber = new javax.swing.JLabel();
  jLabelAlbum = new javax.swing.JLabel();
  jButtonBack = new javax.swing.JButton();
  jLabelReleaseDate = new javax.swing.JLabel();
  jLabelMediaType = new javax.swing.JLabel();
  jLabelRent = new javax.swing.JLabel();
  jButtonRent = new javax.swing.JButton();
  jCheckboxRent = new javax.swing.JCheckBox();

  jMenuBar.setOpaque(false);

  setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
  setTitle("Library Search Results");
  setFont(new java.awt.Font("Comic Sans MS", 0, 10)); // NOI18N
  getContentPane().setLayout(null);

  jPanel.setBackground(new java.awt.Color(153, 153, 255));
  jPanel.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
  jPanel.setLayout(null);

  jLabelTitle.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
  jLabelTitle.setText("Title:");
  jPanel.add(jLabelTitle);
  jLabelTitle.setBounds(40, 20, 170, 17);
  
  jLabelAuthor.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
  jLabelAuthor.setText("Author:");
  jPanel.add(jLabelAuthor);
  jLabelAuthor.setBounds(40, 35, 170, 17);

  jLabelArtist.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
  jLabelArtist.setText("Artist:");
  jPanel.add(jLabelArtist);
  jLabelArtist.setBounds(40, 50, 170, 17);
  
  jLabelCatalogNumber.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
  jLabelCatalogNumber.setText("Catalog Number:");
  jPanel.add(jLabelCatalogNumber);
  jLabelCatalogNumber.setBounds(40, 80, 170, 17);
  
  jLabelAlbum.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
  jLabelAlbum.setText("Album:");
  jPanel.add(jLabelAlbum);
  jLabelAlbum.setBounds(40, 65, 170, 17);
  
  jLabelReleaseDate.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
  jLabelReleaseDate.setText("Release Date:");
  jPanel.add(jLabelReleaseDate);
  jLabelReleaseDate.setBounds(40, 95, 170, 17);
  
  jLabelMediaType.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
  jLabelMediaType.setText("Media Type:");
  jPanel.add(jLabelMediaType);
  jLabelMediaType.setBounds(40, 110, 170, 17);

  jLabelRent.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
  jLabelRent.setText("Rent:");
  jPanel.add(jLabelRent);
  jLabelRent.setBounds(40, 135, 170, 17);
  
  jPanel.add(jCheckboxRent);
  jCheckboxRent.setBounds(80, 135, 20, 17);
  
  jButtonBack.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
  jButtonBack.setText("Back");
  jPanel.add(jButtonBack);
  jButtonBack.setBounds(60, 230, 80, 25);
  
  jButtonRent.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
  jButtonRent.setText("Rent");
  jPanel.add(jButtonRent);
  jButtonRent.setBounds(200, 230, 80, 25);

  getContentPane().add(jPanel);
  jPanel.setBounds(0, 0, 370, 300);

  pack();
 }// </editor-fold>//GEN-END:initComponents



/**
     * Returns an Available Items domain object populated with items that are available
     * data.
     */
    public AvailableItems getSelectedData()
    {

        AvailableItems items = new AvailableItems ( );
        return items;
    }
 public javax.swing.JButton getBackButton()
 {
     return jButtonBack;
 }

  public javax.swing.JButton getRentButton()
 {
     return jButtonRent;
 }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	SearchItemsJFrame availableItemsJFrame = new SearchItemsJFrame();
                
                //itineraryJFrame.setSize(350,300);                
                //itineraryJFrame.setVisible(true);                                
                //new ItineraryJFrame().setVisible(true);
            }
        });
    }
    
 // Variables declaration - do not modify//GEN-BEGIN:variables
 private javax.swing.JButton jButtonBack;
 private javax.swing.JButton jButtonRent;
 private javax.swing.JLabel jLabelTitle;
 private javax.swing.JLabel jLabelAuthor;
 private javax.swing.JLabel jLabelArtist;
 private javax.swing.JLabel jLabelCatalogNumber;
 private javax.swing.JLabel jLabelAlbum;
 private javax.swing.JLabel jLabelReleaseDate;
 private javax.swing.JLabel jLabelMediaType;
 private javax.swing.JLabel jLabelRent;
 private javax.swing.JMenuBar jMenuBar;
 private javax.swing.JPanel jPanel;
 private javax.swing.JCheckBox jCheckboxRent;
 // End of variables declaration//GEN-END:variables
    
}
