package view;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedHashMap;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;
import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class BorrowBkInfoCard extends JPanel{
	
	//parent properties
	JPanel parentPanel;
	CardLayout parentLayout; /* All of these needs custom work*/
	
	//header
	HeaderPanel header;

	
	//content
	JPanel content;
	
	JPanel picturebox;
	JPanel form;
	
	JLabel lbltitle;
	JLabel lblauthor;
	JLabel lblwriter;
	JLabel lblpublisher;
	JLabel lblisbn;
	JLabel lbltype;
	JLabel lblgenre;
	JLabel lblquantity;

	
	JLabel txttitle;
	JLabel txtauthor;
	JLabel txtwriter;
	JLabel txtpublisher;
	JLabel cbxtype;
	JLabel txtisbn;
	JLabel cbxgenre;
	JLabel txtquantity;
	
	// footer buttons
	JPanel buttons;
	JButton btnBorrow;
	JButton btnCancel;
	
	private BorrowBkTransactCard borrowBookTransactPane;
	
	LinkedHashMap<String, Object> cellValues;
	private Component verticalStrut;
	private Component verticalStrut_1;
	private Component horizontalStrut;
	private Component horizontalStrut_1;
	private Component verticalStrut_2;
	private Component verticalStrut_3;
	private Component horizontalStrut_2;
	private Component horizontalStrut_3;
	private Component horizontalStrut_4;
	private Component verticalStrut_4;
	private Component horizontalStrut_5;
	private Component verticalStrut_5;
	private Component verticalStrut_6;
	private Component verticalStrut_7;
	private Component verticalStrut_8;
	private Component verticalStrut_9;
	private Component verticalStrut_10;
	private Component verticalStrut_11;
	private Component verticalStrut_12;
	public BorrowBkInfoCard(JPanel parentPnl, LinkedHashMap<String, Object> cellValues) {
		this.parentPanel = parentPnl;
		this.parentLayout = (CardLayout)parentPnl.getLayout();
		this.cellValues = cellValues;
		this.setLayout(new BorderLayout());
		
		loadHeader();
		loadContentForm();
		loadFooterButtons();
		
	}
	
	private void loadHeader() {
		
		header = new HeaderPanel("Book Info",true);
		
		header.setBackActionListener(new InfoBorrowBkFormHandler());
		
		this.add(header,BorderLayout.PAGE_START);
		
	}
	
	private void loadContentForm() {
		
		
		JPanel formOuterPanel = new JPanel();
		formOuterPanel.setBackground(new Color(255, 250, 250));
		
		content = new JPanel();
		
		picturebox = new JPanel();
		picturebox.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(0, 0, 0)));
		picturebox.setBackground(new Color(255, 250, 250));
		picturebox.setLayout(new BorderLayout(0, 0));
		//picturebox.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		
		//Image icon code here (to be replaced)
		Img pic = new Img("Book");
		pic.setImg(cellValues.get("Img").toString());
		picturebox.add(pic);
		
		form = new JPanel();
		form.setOpaque(false);
		form.setBackground(new Color(255, 250, 250));
		form.setBorder(new LineBorder(new Color(100, 149, 237)));
		//form.setBorder(BorderFactory.createLineBorder(Color.RED));
		content.setLayout(new GridLayout(0,2));
		GridBagLayout gbl_form = new GridBagLayout();
		gbl_form.columnWidths = new int[]{24, 187, 266, 20, 0};
		gbl_form.rowHeights = new int[]{0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0};
		gbl_form.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_form.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		form.setLayout(gbl_form);
				
				verticalStrut_4 = Box.createVerticalStrut(20);
				GridBagConstraints gbc_verticalStrut_4 = new GridBagConstraints();
				gbc_verticalStrut_4.gridwidth = 2;
				gbc_verticalStrut_4.insets = new Insets(0, 0, 5, 5);
				gbc_verticalStrut_4.gridx = 1;
				gbc_verticalStrut_4.gridy = 0;
				form.add(verticalStrut_4, gbc_verticalStrut_4);
				
				horizontalStrut_4 = Box.createHorizontalStrut(20);
				GridBagConstraints gbc_horizontalStrut_4 = new GridBagConstraints();
				gbc_horizontalStrut_4.gridheight = 15;
				gbc_horizontalStrut_4.insets = new Insets(0, 0, 5, 5);
				gbc_horizontalStrut_4.gridx = 0;
				gbc_horizontalStrut_4.gridy = 1;
				form.add(horizontalStrut_4, gbc_horizontalStrut_4);
				
				lbltitle = new JLabel("Title: ");
				lbltitle.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
				lbltitle.setAlignmentX(Component.CENTER_ALIGNMENT);
				
				GridBagConstraints gbc_lbltitle = new GridBagConstraints();
				gbc_lbltitle.fill = GridBagConstraints.BOTH;
				gbc_lbltitle.insets = new Insets(0, 0, 5, 5);
				gbc_lbltitle.gridx = 1;
				gbc_lbltitle.gridy = 1;
				form.add(lbltitle, gbc_lbltitle);
		
				
				txttitle = new JLabel("	N/A");
				txttitle.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
				GridBagConstraints gbc_txttitle = new GridBagConstraints();
				gbc_txttitle.fill = GridBagConstraints.BOTH;
				gbc_txttitle.insets = new Insets(0, 0, 5, 5);
				gbc_txttitle.gridx = 2;
				gbc_txttitle.gridy = 1;
				form.add(txttitle, gbc_txttitle);
		
		horizontalStrut_5 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_5 = new GridBagConstraints();
		gbc_horizontalStrut_5.insets = new Insets(0, 0, 5, 0);
		gbc_horizontalStrut_5.gridheight = 15;
		gbc_horizontalStrut_5.gridx = 3;
		gbc_horizontalStrut_5.gridy = 1;
		form.add(horizontalStrut_5, gbc_horizontalStrut_5);
		
		verticalStrut_5 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_5 = new GridBagConstraints();
		gbc_verticalStrut_5.gridwidth = 2;
		gbc_verticalStrut_5.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_5.gridx = 1;
		gbc_verticalStrut_5.gridy = 2;
		form.add(verticalStrut_5, gbc_verticalStrut_5);
		lblauthor = new JLabel("Author: ");
		lblauthor.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
		lblauthor.setAlignmentX(Component.CENTER_ALIGNMENT);
		GridBagConstraints gbc_lblauthor = new GridBagConstraints();
		gbc_lblauthor.fill = GridBagConstraints.BOTH;
		gbc_lblauthor.insets = new Insets(0, 0, 5, 5);
		gbc_lblauthor.gridx = 1;
		gbc_lblauthor.gridy = 3;
		form.add(lblauthor, gbc_lblauthor);
		txtauthor = new JLabel("	N/A");
		txtauthor.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
		GridBagConstraints gbc_txtauthor = new GridBagConstraints();
		gbc_txtauthor.fill = GridBagConstraints.BOTH;
		gbc_txtauthor.insets = new Insets(0, 0, 5, 5);
		gbc_txtauthor.gridx = 2;
		gbc_txtauthor.gridy = 3;
		form.add(txtauthor, gbc_txtauthor);
		
		verticalStrut_6 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_6 = new GridBagConstraints();
		gbc_verticalStrut_6.gridwidth = 2;
		gbc_verticalStrut_6.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_6.gridx = 1;
		gbc_verticalStrut_6.gridy = 4;
		form.add(verticalStrut_6, gbc_verticalStrut_6);
		lblwriter = new JLabel("Writer: ");
		lblwriter.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
		lblwriter.setAlignmentX(Component.CENTER_ALIGNMENT);
		GridBagConstraints gbc_lblwriter = new GridBagConstraints();
		gbc_lblwriter.fill = GridBagConstraints.BOTH;
		gbc_lblwriter.insets = new Insets(0, 0, 5, 5);
		gbc_lblwriter.gridx = 1;
		gbc_lblwriter.gridy = 5;
		form.add(lblwriter, gbc_lblwriter); 
		txtwriter = new JLabel("	N/A");
		txtwriter.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
		GridBagConstraints gbc_txtwriter = new GridBagConstraints();
		gbc_txtwriter.fill = GridBagConstraints.BOTH;
		gbc_txtwriter.insets = new Insets(0, 0, 5, 5);
		gbc_txtwriter.gridx = 2;
		gbc_txtwriter.gridy = 5;
		form.add(txtwriter, gbc_txtwriter);
		
		verticalStrut_7 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_7 = new GridBagConstraints();
		gbc_verticalStrut_7.gridwidth = 2;
		gbc_verticalStrut_7.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_7.gridx = 1;
		gbc_verticalStrut_7.gridy = 6;
		form.add(verticalStrut_7, gbc_verticalStrut_7);
		lblpublisher = new JLabel("Publisher: ");
		lblpublisher.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
		lblpublisher.setAlignmentX(Component.CENTER_ALIGNMENT);
		GridBagConstraints gbc_lblpublisher = new GridBagConstraints();
		gbc_lblpublisher.fill = GridBagConstraints.BOTH;
		gbc_lblpublisher.insets = new Insets(0, 0, 5, 5);
		gbc_lblpublisher.gridx = 1;
		gbc_lblpublisher.gridy = 7;
		form.add(lblpublisher, gbc_lblpublisher);
		txtpublisher = new JLabel("	N/A");
		txtpublisher.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
		GridBagConstraints gbc_txtpublisher = new GridBagConstraints();
		gbc_txtpublisher.fill = GridBagConstraints.BOTH;
		gbc_txtpublisher.insets = new Insets(0, 0, 5, 5);
		gbc_txtpublisher.gridx = 2;
		gbc_txtpublisher.gridy = 7;
		form.add(txtpublisher, gbc_txtpublisher);
		
		verticalStrut_8 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_8 = new GridBagConstraints();
		gbc_verticalStrut_8.gridwidth = 2;
		gbc_verticalStrut_8.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_8.gridx = 1;
		gbc_verticalStrut_8.gridy = 8;
		form.add(verticalStrut_8, gbc_verticalStrut_8);
		lblisbn = new JLabel("ISBN: ");
		lblisbn.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
		lblisbn.setAlignmentX(Component.CENTER_ALIGNMENT);
		GridBagConstraints gbc_lblisbn = new GridBagConstraints();
		gbc_lblisbn.fill = GridBagConstraints.BOTH;
		gbc_lblisbn.insets = new Insets(0, 0, 5, 5);
		gbc_lblisbn.gridx = 1;
		gbc_lblisbn.gridy = 9;
		form.add(lblisbn, gbc_lblisbn); 
		txtisbn = new JLabel("	N/A");
		txtisbn.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
		GridBagConstraints gbc_txtisbn = new GridBagConstraints();
		gbc_txtisbn.fill = GridBagConstraints.BOTH;
		gbc_txtisbn.insets = new Insets(0, 0, 5, 5);
		gbc_txtisbn.gridx = 2;
		gbc_txtisbn.gridy = 9;
		form.add(txtisbn, gbc_txtisbn);
		
		verticalStrut_9 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_9 = new GridBagConstraints();
		gbc_verticalStrut_9.gridwidth = 2;
		gbc_verticalStrut_9.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_9.gridx = 1;
		gbc_verticalStrut_9.gridy = 10;
		form.add(verticalStrut_9, gbc_verticalStrut_9);
		lbltype = new JLabel("Type: ");
		lbltype.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
		lbltype.setAlignmentX(Component.CENTER_ALIGNMENT);
		GridBagConstraints gbc_lbltype = new GridBagConstraints();
		gbc_lbltype.fill = GridBagConstraints.BOTH;
		gbc_lbltype.insets = new Insets(0, 0, 5, 5);
		gbc_lbltype.gridx = 1;
		gbc_lbltype.gridy = 11;
		form.add(lbltype, gbc_lbltype); 
		cbxtype = new JLabel(" N/A");
		cbxtype.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
		GridBagConstraints gbc_cbxtype = new GridBagConstraints();
		gbc_cbxtype.fill = GridBagConstraints.BOTH;
		gbc_cbxtype.insets = new Insets(0, 0, 5, 5);
		gbc_cbxtype.gridx = 2;
		gbc_cbxtype.gridy = 11;
		form.add(cbxtype, gbc_cbxtype);
		
		verticalStrut_10 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_10 = new GridBagConstraints();
		gbc_verticalStrut_10.gridwidth = 2;
		gbc_verticalStrut_10.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_10.gridx = 1;
		gbc_verticalStrut_10.gridy = 12;
		form.add(verticalStrut_10, gbc_verticalStrut_10);
		lblgenre = new JLabel("Genre: ");
		lblgenre.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
		lblgenre.setAlignmentX(Component.CENTER_ALIGNMENT);
		GridBagConstraints gbc_lblgenre = new GridBagConstraints();
		gbc_lblgenre.fill = GridBagConstraints.BOTH;
		gbc_lblgenre.insets = new Insets(0, 0, 5, 5);
		gbc_lblgenre.gridx = 1;
		gbc_lblgenre.gridy = 13;
		form.add(lblgenre, gbc_lblgenre); 
		cbxgenre = new JLabel("	N/A");
		cbxgenre.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
		GridBagConstraints gbc_cbxgenre = new GridBagConstraints();
		gbc_cbxgenre.fill = GridBagConstraints.BOTH;
		gbc_cbxgenre.insets = new Insets(0, 0, 5, 5);
		gbc_cbxgenre.gridx = 2;
		gbc_cbxgenre.gridy = 13;
		form.add(cbxgenre, gbc_cbxgenre);
		
		verticalStrut_11 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_11 = new GridBagConstraints();
		gbc_verticalStrut_11.gridwidth = 2;
		gbc_verticalStrut_11.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_11.gridx = 1;
		gbc_verticalStrut_11.gridy = 14;
		form.add(verticalStrut_11, gbc_verticalStrut_11);
		lblquantity = new JLabel("Quantity: ");
		lblquantity.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
		lblquantity.setAlignmentX(Component.CENTER_ALIGNMENT);
		GridBagConstraints gbc_lblquantity = new GridBagConstraints();
		gbc_lblquantity.fill = GridBagConstraints.BOTH;
		gbc_lblquantity.insets = new Insets(0, 0, 5, 5);
		gbc_lblquantity.gridx = 1;
		gbc_lblquantity.gridy = 15;
		form.add(lblquantity, gbc_lblquantity);
		txtquantity = new JLabel("	N/A");
		txtquantity.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
		GridBagConstraints gbc_txtquantity = new GridBagConstraints();
		gbc_txtquantity.insets = new Insets(0, 0, 5, 5);
		gbc_txtquantity.fill = GridBagConstraints.BOTH;
		gbc_txtquantity.gridx = 2;
		gbc_txtquantity.gridy = 15;
		form.add(txtquantity, gbc_txtquantity);
		
		this.loadValues();
		
		content.add(picturebox);
		
		verticalStrut = Box.createVerticalStrut(20);
		picturebox.add(verticalStrut, BorderLayout.NORTH);
		
		verticalStrut_1 = Box.createVerticalStrut(20);
		picturebox.add(verticalStrut_1, BorderLayout.SOUTH);
		
		horizontalStrut = Box.createHorizontalStrut(20);
		picturebox.add(horizontalStrut, BorderLayout.WEST);
		
		horizontalStrut_1 = Box.createHorizontalStrut(20);
		picturebox.add(horizontalStrut_1, BorderLayout.EAST);
		formOuterPanel.setLayout(new BorderLayout(0, 0));
		formOuterPanel.add(form);
		
		verticalStrut_12 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_12 = new GridBagConstraints();
		gbc_verticalStrut_12.gridwidth = 2;
		gbc_verticalStrut_12.insets = new Insets(0, 0, 0, 5);
		gbc_verticalStrut_12.gridx = 1;
		gbc_verticalStrut_12.gridy = 16;
		form.add(verticalStrut_12, gbc_verticalStrut_12);
		content.add(formOuterPanel);
		
		verticalStrut_2 = Box.createVerticalStrut(20);
		formOuterPanel.add(verticalStrut_2, BorderLayout.NORTH);
		
		verticalStrut_3 = Box.createVerticalStrut(20);
		formOuterPanel.add(verticalStrut_3, BorderLayout.SOUTH);
		
		horizontalStrut_2 = Box.createHorizontalStrut(20);
		formOuterPanel.add(horizontalStrut_2, BorderLayout.WEST);
		
		horizontalStrut_3 = Box.createHorizontalStrut(20);
		formOuterPanel.add(horizontalStrut_3, BorderLayout.EAST);
		this.add(content,BorderLayout.CENTER);
	}
	
	private void loadFooterButtons() {
		
		buttons = new JPanel();
		buttons.setBackground(new Color(100, 149, 237));
		
		buttons.setLayout(new FlowLayout(FlowLayout.TRAILING));
		//this.setBorder(new LineBorder(Color.BLACK));
		btnBorrow = new JButton("Borrow");
		btnBorrow.setBorder(null);
		btnBorrow.setBackground(new Color(255, 250, 250));
		btnCancel = new JButton("Cancel");
		btnCancel.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnCancel.setBackground(new Color(255, 250, 250));
		
		btnBorrow.setPreferredSize(new Dimension(100,30)); // button size here
		btnBorrow.setFont(new Font("Arial", Font.PLAIN, 15));
		
		btnCancel.setPreferredSize(new Dimension(80,30)); // button size here
		btnCancel.setFont(new Font("Arial", Font.PLAIN, 15));
		
		btnBorrow.addActionListener(new InfoBorrowBkFormHandler());
		btnCancel.addActionListener(new InfoBorrowBkFormHandler());
		btnBorrow.addMouseListener(new MouseHandler());
		btnCancel.addMouseListener(new MouseHandler());
		
		buttons.add(btnBorrow);
		buttons.add(Box.createRigidArea(new Dimension(20,0)));
		buttons.add(btnCancel);
		buttons.add(Box.createRigidArea(new Dimension(10,0)));
		
		this.add(buttons,BorderLayout.PAGE_END);
	}
	
	public void loadValues() {
		
		txttitle.setText("<html><p style=\"width:200px\">"+(String) cellValues.get("Title")+"</p></html>");
		txtauthor.setText((String) cellValues.get("Author"));
		txtwriter.setText((String) cellValues.get("Writer"));
		txtpublisher.setText((String) cellValues.get("Publisher"));
		txtisbn.setText((String) cellValues.get("ISBN"));
		cbxtype.setText((String) cellValues.get("Type"));
		cbxgenre.setText((String) cellValues.get("Genre"));
		txtquantity.setText((String) cellValues.get("Quantity").toString());
		
		
	}
	
	
	private class InfoBorrowBkFormHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent evt) {

			switch (evt.getActionCommand()) {
			case "<":
				parentLayout.show(parentPanel, "BORROWBOOK");
				break;
			case "Cancel":
				parentLayout.show(parentPanel, "BORROWBOOK");
				break;
			case "Borrow":
				borrowBookTransactPane = new BorrowBkTransactCard(parentPanel, cellValues);
				parentPanel.add(borrowBookTransactPane, "BOOKTRANSACT");
				parentLayout.show(parentPanel, "BOOKTRANSACT");
				break;

			default:
				break;
			}
			
		}
		
	}
	
	private class MouseHandler extends MouseAdapter{
		JButton btnSource;
		@Override
		public void mouseEntered(MouseEvent e) {
			btnSource = (JButton) e.getSource();
			btnSource.setBackground(new Color(30, 144, 255));
			btnSource.setOpaque(true);
			btnSource.setForeground(new Color(255, 250, 250));
			btnSource.setBorder(new LineBorder((Color)new Color(255, 250, 250)));
		}

		@Override
		public void mouseExited(MouseEvent e) {
			btnSource = (JButton) e.getSource();
			btnSource.setBackground(new Color(255, 250, 250));
			btnSource.setOpaque(true);
			btnSource.setForeground(new Color(0, 0, 0));
			btnSource.setBorder(new LineBorder(new Color(255, 250, 250)));
		}
		
	}

}
