import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class R_BookCatalogPanel extends JPanel{
	
	JPanel headerTitle;
	JLabel title;
	
	JPanel contentButtons;
	GridBagConstraints c;
	
	JButton btnAddBk;
	JButton btnEditBk;
	JButton btnDeleteBk;
	JButton btnSearchBk;
	JButton btnBorrowBk;
	JButton btnReturnBk;
	JButton btnViewBk;
	JPanel parentPanel;
	CardLayout parentLayout;
	
	public R_BookCatalogPanel(JPanel parentPnl){
		this.parentPanel = parentPnl;
		this.parentLayout = (CardLayout)parentPnl.getLayout();
		this.setLayout(new BorderLayout());
		
		initializeHeader();
		
		initializeContent();
		
		
	}
	
	private void initializeHeader() {
		headerTitle = new JPanel(new FlowLayout(FlowLayout.LEADING));
		title = new JLabel("Book Cataloging");
		title.setFont(new Font("Arial", 1, 30)); // header title font here
		
		headerTitle.add(Box.createRigidArea(new Dimension(5,75)));
		headerTitle.add(title);
		headerTitle.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, Color.BLACK)); // border color here
		this.add(headerTitle, BorderLayout.PAGE_START);
	}
	
	private void initializeContent() {
		contentButtons = new JPanel(new GridBagLayout());
		c = new GridBagConstraints();
		
		JPanel transactPanel = new JPanel(new GridLayout(2,0));
		
		btnAddBk = new JButton("Add Books");
		btnEditBk = new JButton("Edit Books");
		btnDeleteBk = new JButton("Delete Books");
		btnSearchBk = new JButton("Search Books");
		btnBorrowBk = new JButton("Borrow Books");
		btnReturnBk = new JButton("Return Books");
		btnViewBk = new JButton("View Books");
		
		btnAddBk.addActionListener(new R_BkCatalogHandler());
		btnEditBk.addActionListener(new R_BkCatalogHandler());
		btnSearchBk.addActionListener(new R_BkCatalogHandler());
		btnDeleteBk.addActionListener(new R_BkCatalogHandler());
		btnBorrowBk.addActionListener(new R_BkCatalogHandler());
		btnReturnBk.addActionListener(new R_BkCatalogHandler());
		btnViewBk.addActionListener(new R_BkCatalogHandler());
		
		transactPanel.add(btnBorrowBk);
		transactPanel.add(btnReturnBk);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0; // column
		c.gridy = 0; // row
		c.weighty = 0.5;
		c.weightx = 0.5;
		c.insets = new Insets(20,20,10,10);
		contentButtons.add(btnAddBk,c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1; // column
		c.gridy = 0; // row
		//c.insets = new Insets(10,10,10,10);
		contentButtons.add(btnEditBk,c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0; // column
		c.gridy = 1; // row
		//c.insets = new Insets(10,10,10,10);
		contentButtons.add(btnDeleteBk,c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1; // column
		c.gridy = 1; // row
		//c.insets = new Insets(10,10,10,10);
		contentButtons.add(btnSearchBk,c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0; // column
		c.gridy = 2; // row
		//c.insets = new Insets(10,10,10,10);
		contentButtons.add(transactPanel,c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1; // column
		c.gridy = 2; // row
		//c.insets = new Insets(10,10,10,10);
		contentButtons.add(btnViewBk,c);
		
		
		this.add(contentButtons, BorderLayout.CENTER);
	}
	
	private class R_BkCatalogHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent evt) {
			
			switch (evt.getActionCommand()) {
			case "Add Books":
				parentLayout.show(parentPanel,"ADDBOOK");
				break;
			case "Edit Books":
				parentLayout.show(parentPanel,"EDITVIEWBOOK");
				break;
			case "Delete Books":
				parentLayout.show(parentPanel, "DELETEBOOK");
				break;
			case "Search Books":
				parentLayout.show(parentPanel,"SEARCHBOOK");
				break;
			case "Borrow Books":
				parentLayout.show(parentPanel, "BORROWBOOK");
				break;
			case "Return Books":
				parentLayout.show(parentPanel, "RETURNBOOK");
				break;
			case "View Books":
				parentLayout.show(parentPanel,"VIEWBOOK");
				break;

			default:
				System.exit(0);
				break;
			}
			
			
		}
		
	}

}
