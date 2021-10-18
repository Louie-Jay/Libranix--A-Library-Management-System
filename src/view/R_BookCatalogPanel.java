package view;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.Dimension;

public class R_BookCatalogPanel extends JPanel{
	
	HeaderPanel header;
	
	JPanel contentButtons;
	GridBagLayout gridbag;
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
	
	AddBkFormCard addBookPane;
	EditBkTableCard editBookTablePane;
	DeleteBkTableCard deleteBookTablePane;
	SearchBkTableCard srchBookTablePane;
	BorrowBkTableCard borrowBookTablePane;
	ReturnBkTableCard returnBookTablePane;
	ViewBkTableCard viewBookTablePane;
	
	public R_BookCatalogPanel(JPanel parentPnl){
		this.parentPanel = parentPnl;
		this.parentLayout = (CardLayout)parentPnl.getLayout();
		this.setLayout(new BorderLayout());
		
		initializeHeader();
		
		initializeContent();

	}
	
	private void initializeHeader() {
		header = new HeaderPanel("Book Cataloging",false);
		this.add(header, BorderLayout.PAGE_START);
	}
	
	private void initializeContent() {
		gridbag = new GridBagLayout();
		contentButtons = new JPanel(gridbag);
		contentButtons.setBackground(new Color(255, 250, 250));
		c = new GridBagConstraints();
		
		JPanel transactPanel = new JPanel(new GridLayout(2,0));
		transactPanel.setMaximumSize(new Dimension(0, 0));
		transactPanel.setOpaque(false);
		
		btnAddBk = new JButton("Add Books");
		btnAddBk.setMinimumSize(new Dimension(0, 0));
		btnAddBk.setMaximumSize(new Dimension(0, 0));
		btnAddBk.setPreferredSize(new Dimension(0, 0));
		btnAddBk.setFocusPainted(false);
		btnAddBk.setFont(new Font("Lucida Sans", Font.BOLD, 15));
		btnAddBk.setIcon(new ImageIcon(R_BookCatalogPanel.class.getResource("/res/addbook_fix.png")));
		btnAddBk.setBackground(new Color(255, 250, 250));
		btnAddBk.setOpaque(false);
		btnAddBk.setBorder(new LineBorder(new Color(100, 149, 237)));
		btnEditBk = new JButton("Edit Books");
		btnEditBk.setMinimumSize(new Dimension(0, 0));
		btnEditBk.setMaximumSize(new Dimension(0, 0));
		btnEditBk.setPreferredSize(new Dimension(0, 0));
		btnEditBk.setFocusPainted(false);
		btnEditBk.setIcon(new ImageIcon(R_BookCatalogPanel.class.getResource("/res/editbook_fix.png")));
		btnEditBk.setFont(new Font("Lucida Sans", Font.BOLD, 15));
		btnEditBk.setBackground(new Color(255, 250, 250));
		btnEditBk.setOpaque(false);
		btnEditBk.setBorder(new LineBorder(new Color(100, 149, 237)));
		btnDeleteBk = new JButton("Delete Books");
		btnDeleteBk.setMinimumSize(new Dimension(0, 0));
		btnDeleteBk.setMaximumSize(new Dimension(0, 0));
		btnDeleteBk.setPreferredSize(new Dimension(0, 0));
		btnDeleteBk.setFocusPainted(false);
		btnDeleteBk.setIcon(new ImageIcon(R_BookCatalogPanel.class.getResource("/res/deletebook_fix1.png")));
		btnDeleteBk.setFont(new Font("Lucida Sans", Font.BOLD, 15));
		btnDeleteBk.setBackground(new Color(255, 250, 250));
		btnDeleteBk.setOpaque(false);
		btnDeleteBk.setBorder(new LineBorder(new Color(100, 149, 237)));
		btnSearchBk = new JButton("Search Books");
		btnSearchBk.setMinimumSize(new Dimension(0, 0));
		btnSearchBk.setMaximumSize(new Dimension(0, 0));
		btnSearchBk.setPreferredSize(new Dimension(0, 0));
		btnSearchBk.setFocusPainted(false);
		btnSearchBk.setIcon(new ImageIcon(R_BookCatalogPanel.class.getResource("/res/searchbook_fix.png")));
		btnSearchBk.setFont(new Font("Lucida Sans", Font.BOLD, 15));
		btnSearchBk.setBackground(new Color(255, 250, 250));
		btnSearchBk.setOpaque(false);
		btnSearchBk.setBorder(new LineBorder(new Color(100, 149, 237)));
		btnBorrowBk = new JButton("Borrow Books");
		btnBorrowBk.setMinimumSize(new Dimension(0, 0));
		btnBorrowBk.setMaximumSize(new Dimension(0, 0));
		btnBorrowBk.setPreferredSize(new Dimension(0, 0));
		btnBorrowBk.setFocusPainted(false);
		btnBorrowBk.setIcon(new ImageIcon(R_BookCatalogPanel.class.getResource("/res/borrowbook_fix.png")));
		btnBorrowBk.setFont(new Font("Lucida Sans", Font.BOLD, 15));
		btnBorrowBk.setBackground(new Color(255, 250, 250));
		btnBorrowBk.setOpaque(false);
		btnBorrowBk.setBorder(new LineBorder(new Color(100, 149, 237)));
		btnReturnBk = new JButton("Return Books");
		btnReturnBk.setMinimumSize(new Dimension(0, 0));
		btnReturnBk.setMaximumSize(new Dimension(0, 0));
		btnReturnBk.setPreferredSize(new Dimension(0, 0));
		btnReturnBk.setFocusPainted(false);
		btnReturnBk.setIcon(new ImageIcon(R_BookCatalogPanel.class.getResource("/res/returnbook_fix.png")));
		btnReturnBk.setFont(new Font("Lucida Sans", Font.BOLD, 15));
		btnReturnBk.setBackground(new Color(255, 250, 250));
		btnReturnBk.setOpaque(false);
		btnReturnBk.setBorder(new LineBorder(new Color(100, 149, 237)));
		btnViewBk = new JButton("View Books");
		btnViewBk.setMinimumSize(new Dimension(0, 0));
		btnViewBk.setMaximumSize(new Dimension(0, 0));
		btnViewBk.setPreferredSize(new Dimension(0, 0));
		btnViewBk.setFocusPainted(false);
		btnViewBk.setIcon(new ImageIcon(R_BookCatalogPanel.class.getResource("/res/viewbooks_fix.png")));
		btnViewBk.setFont(new Font("Lucida Sans", Font.BOLD, 15));
		btnViewBk.setBackground(new Color(255, 250, 250));
		btnViewBk.setOpaque(false);
		btnViewBk.setBorder(new LineBorder(new Color(100, 149, 237)));
		
		btnAddBk.addMouseListener(new R_BkCatalogHandler());
		btnEditBk.addMouseListener(new R_BkCatalogHandler());
		btnSearchBk.addMouseListener(new R_BkCatalogHandler());
		btnDeleteBk.addMouseListener(new R_BkCatalogHandler());
		btnBorrowBk.addMouseListener(new R_BkCatalogHandler());
		btnReturnBk.addMouseListener(new R_BkCatalogHandler());
		btnViewBk.addMouseListener(new R_BkCatalogHandler());
		
		transactPanel.add(btnBorrowBk);
		transactPanel.add(btnReturnBk);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0; // column
		c.gridy = 0; // row
		c.weighty = 0.5;
		c.weightx = 0.5;
		c.insets = new Insets(20,20,10,10);
		gridbag.setConstraints(btnAddBk, c);
		contentButtons.add(btnAddBk);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1; // column
		c.gridy = 0; // row
		//c.insets = new Insets(10,10,10,10);
		gridbag.setConstraints(btnEditBk, c);
		contentButtons.add(btnEditBk);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0; // column
		c.gridy = 1; // row
		//c.insets = new Insets(10,10,10,10);
		gridbag.setConstraints(btnDeleteBk, c);
		contentButtons.add(btnDeleteBk);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1; // column
		c.gridy = 1; // row
		//c.insets = new Insets(10,10,10,10);
		gridbag.setConstraints(btnSearchBk, c);
		contentButtons.add(btnSearchBk);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0; // column
		c.gridy = 2; // row
		//c.insets = new Insets(10,10,10,10);
		gridbag.setConstraints(transactPanel, c);
		contentButtons.add(transactPanel);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1; // column
		c.gridy = 2; // row
		//c.insets = new Insets(10,10,10,10);
		gridbag.setConstraints(btnViewBk, c);
		contentButtons.add(btnViewBk);
		
		
		this.add(contentButtons, BorderLayout.CENTER);
		
	}
	
	private class R_BkCatalogHandler extends MouseAdapter{
		JButton btnSource;
		
		@Override
		public void mouseClicked(MouseEvent e) {
			btnSource = (JButton)e.getSource();
			
			switch (btnSource.getActionCommand()) {
			case "Add Books":
				addBookPane = new AddBkFormCard(parentPanel);
				parentPanel.add(addBookPane, "ADDBOOK");
				parentLayout.show(parentPanel,"ADDBOOK");
				break;
			case "Edit Books":
				editBookTablePane = new EditBkTableCard(parentPanel);
				parentPanel.add(editBookTablePane, "EDITVIEWBOOK");
				parentLayout.show(parentPanel,"EDITVIEWBOOK");
				break;
			case "Delete Books":
				deleteBookTablePane = new DeleteBkTableCard(parentPanel);
				parentPanel.add(deleteBookTablePane, "DELETEBOOK");
				parentLayout.show(parentPanel, "DELETEBOOK");
				break;
			case "Search Books":
				srchBookTablePane = new SearchBkTableCard(parentPanel);
				parentPanel.add(srchBookTablePane, "SEARCHBOOK");
				parentLayout.show(parentPanel,"SEARCHBOOK");
				break;
			case "Borrow Books":
				borrowBookTablePane = new BorrowBkTableCard(parentPanel);
				parentPanel.add(borrowBookTablePane, "BORROWBOOK");
				parentLayout.show(parentPanel, "BORROWBOOK");
				break;
			case "Return Books":
				returnBookTablePane = new ReturnBkTableCard(parentPanel);
				parentPanel.add(returnBookTablePane, "RETURNBOOK");
				parentLayout.show(parentPanel, "RETURNBOOK");
				break;
			case "View Books":
				viewBookTablePane = new ViewBkTableCard(parentPanel);
				parentPanel.add(viewBookTablePane, "VIEWBOOK");
				parentLayout.show(parentPanel,"VIEWBOOK");
				break;

			default:
				System.exit(0);
				break;
			}
			
			
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			btnSource = (JButton) e.getSource();
			btnSource.setBackground(new Color(100, 149, 237));
			btnSource.setOpaque(true);
			btnSource.setForeground(new Color(255, 250, 250));
			//btnSource.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(255, 250, 250)));
		}

		@Override
		public void mouseExited(MouseEvent e) {
			btnSource = (JButton) e.getSource();
			btnSource.setBackground(new Color(100, 149, 237));
			btnSource.setOpaque(false);
			btnSource.setForeground(new Color(0, 0, 0));
			//btnSource.setBorder(new LineBorder(new Color(100, 149, 237)));
		}
		
	}

}
