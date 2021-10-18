package view;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedHashMap;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import controller.AddBkFormController;

public class AddBkFormCard extends JPanel{
	
	//parent properties
	JPanel parentPanel;
	CardLayout parentLayout;
	private AddBkFormController controller;
	
	//content
	JPanel content;
	
	Img pic;
	JPanel picturebox;
	JPanel form;
	
	LinkedHashMap<String,JComponent> compContainer;
	JLabel lbltitle;
	JLabel lblauthor;
	JLabel lblwriter;
	JLabel lblpublisher;
	JLabel lblisbn;
	JLabel lbltype;
	JLabel lblgenre;
	JLabel lblquantity;
	
	TitleTextField txttitle;
	AuthorTextField txtauthor;
	WriterTextField txtwriter;
	PublisherTextField txtpublisher;
	ISBNTextField txtisbn;
	TypeComboBox<String> cbxtype;
	GenreComboBox<String> cbxgenre;
	QuantityTextField txtquantity;
	
	// footer buttons
	JPanel buttons;
	JButton btnAdd;
	JButton btnCancel;
	private Component rigidArea;
	private Component rigidArea_1;
	private Component rigidArea_2;
	private Component rigidArea_3;
	private Component verticalStrut;
	private Component verticalStrut_1;
	private Component verticalStrut_2;
	private Component verticalStrut_3;
	private Component verticalStrut_4;
	private Component verticalStrut_5;
	private Component verticalStrut_6;
	private Component verticalStrut_7;
	private Component horizontalStrut;
	private Component horizontalStrut_1;
	private Component verticalStrut_8;
	private Component verticalStrut_9;
	private Component verticalStrut_10;
	private Component horizontalStrut_2;
	private Component horizontalStrut_3;
	private Component verticalStrut_11;
	private Component verticalStrut_12;
	
	public AddBkFormCard(JPanel parentPnl) {
		this.parentPanel = parentPnl;
		this.parentLayout = (CardLayout)parentPnl.getLayout();
		this.setLayout(new BorderLayout());
		this.controller = new AddBkFormController();
		loadHeader();
		loadContentForm();
		loadFooterButtons();
		
	}
	
	private void loadHeader() {
		
		HeaderPanel heading = new HeaderPanel("Add Books",true);
		heading.setBackActionListener(new AddBkFormHandler());
		this.add(heading, BorderLayout.PAGE_START);
		
	}
	
	private void loadContentForm() {
		
		
		JPanel formOuterPanel = new JPanel();
		formOuterPanel.setBackground(new Color(255, 250, 250));
		
		content = new JPanel();
		
		picturebox = new JPanel();
		picturebox.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		picturebox.setBackground(new Color(255, 250, 250));
		picturebox.setLayout(new BorderLayout(0, 0));
		//picturebox.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		pic = new Img("Book");
		pic.setEditable(true);
		picturebox.add(pic);
		
		form = new JPanel();
		form.setBorder(new LineBorder(new Color(100, 149, 237), 1, true));
		form.setBackground(new Color(255, 250, 250));
		//form.setBorder(BorderFactory.createLineBorder(Color.RED));
		content.setLayout(new GridLayout(0,2));
		compContainer = new LinkedHashMap<>();
		GridBagLayout gbl_form = new GridBagLayout();
		gbl_form.columnWidths = new int[]{30, 88, 295, 30, 0};
		gbl_form.rowHeights = new int[]{0, 0, 0, 22, 22, 0, 22, 0, 22, 0, 22, 0, 22, 0, 22, 0, 20, 0, 0, 0};
		gbl_form.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_form.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		form.setLayout(gbl_form);
		
		rigidArea = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea = new GridBagConstraints();
		gbc_rigidArea.insets = new Insets(0, 0, 5, 5);
		gbc_rigidArea.gridx = 0;
		gbc_rigidArea.gridy = 0;
		form.add(rigidArea, gbc_rigidArea);
		
		rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_1 = new GridBagConstraints();
		gbc_rigidArea_1.insets = new Insets(0, 0, 5, 0);
		gbc_rigidArea_1.gridx = 3;
		gbc_rigidArea_1.gridy = 0;
		form.add(rigidArea_1, gbc_rigidArea_1);
		
		verticalStrut_12 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_12 = new GridBagConstraints();
		gbc_verticalStrut_12.gridwidth = 2;
		gbc_verticalStrut_12.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_12.gridx = 1;
		gbc_verticalStrut_12.gridy = 1;
		form.add(verticalStrut_12, gbc_verticalStrut_12);
		
		verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.gridwidth = 2;
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 1;
		gbc_verticalStrut.gridy = 3;
		form.add(verticalStrut, gbc_verticalStrut);
		
		verticalStrut_1 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.gridwidth = 2;
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_1.gridx = 1;
		gbc_verticalStrut_1.gridy = 5;
		form.add(verticalStrut_1, gbc_verticalStrut_1);
		
		verticalStrut_2 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_2 = new GridBagConstraints();
		gbc_verticalStrut_2.gridwidth = 2;
		gbc_verticalStrut_2.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_2.gridx = 1;
		gbc_verticalStrut_2.gridy = 7;
		form.add(verticalStrut_2, gbc_verticalStrut_2);
		
		verticalStrut_3 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_3 = new GridBagConstraints();
		gbc_verticalStrut_3.gridwidth = 2;
		gbc_verticalStrut_3.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_3.gridx = 1;
		gbc_verticalStrut_3.gridy = 9;
		form.add(verticalStrut_3, gbc_verticalStrut_3);
		
		verticalStrut_4 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_4 = new GridBagConstraints();
		gbc_verticalStrut_4.gridwidth = 2;
		gbc_verticalStrut_4.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_4.gridx = 1;
		gbc_verticalStrut_4.gridy = 11;
		form.add(verticalStrut_4, gbc_verticalStrut_4);
		
		verticalStrut_5 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_5 = new GridBagConstraints();
		gbc_verticalStrut_5.gridwidth = 2;
		gbc_verticalStrut_5.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_5.gridx = 1;
		gbc_verticalStrut_5.gridy = 13;
		form.add(verticalStrut_5, gbc_verticalStrut_5);
		
		verticalStrut_6 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_6 = new GridBagConstraints();
		gbc_verticalStrut_6.gridwidth = 2;
		gbc_verticalStrut_6.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_6.gridx = 1;
		gbc_verticalStrut_6.gridy = 15;
		form.add(verticalStrut_6, gbc_verticalStrut_6);
		
		verticalStrut_11 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_11 = new GridBagConstraints();
		gbc_verticalStrut_11.gridwidth = 2;
		gbc_verticalStrut_11.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_11.gridx = 1;
		gbc_verticalStrut_11.gridy = 17;
		form.add(verticalStrut_11, gbc_verticalStrut_11);
		
		rigidArea_2 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_2 = new GridBagConstraints();
		gbc_rigidArea_2.insets = new Insets(0, 0, 0, 5);
		gbc_rigidArea_2.gridx = 0;
		gbc_rigidArea_2.gridy = 18;
		form.add(rigidArea_2, gbc_rigidArea_2);
		
		lbltitle = new JLabel("Title: ");
		lbltitle.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
		
		GridBagConstraints gbc_lbltitle = new GridBagConstraints();
		gbc_lbltitle.fill = GridBagConstraints.BOTH;
		gbc_lbltitle.insets = new Insets(0, 0, 5, 5);
		gbc_lbltitle.gridx = 1;
		gbc_lbltitle.gridy = 2;
		form.add(lbltitle, gbc_lbltitle); 
		
		txttitle = new TitleTextField("",70);
		lbltitle.setLabelFor(txttitle);
		GridBagConstraints gbc_txttitle = new GridBagConstraints();
		gbc_txttitle.insets = new Insets(0, 0, 5, 5);
		gbc_txttitle.fill = GridBagConstraints.BOTH;
		gbc_txttitle.gridx = 2;
		gbc_txttitle.gridy = 2;
		form.add(txttitle, gbc_txttitle);
		
		compContainer.put("Title", txttitle);
		lblauthor = new JLabel("Author: ");
		lblauthor.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
		GridBagConstraints gbc_lblauthor = new GridBagConstraints();
		gbc_lblauthor.fill = GridBagConstraints.BOTH;
		gbc_lblauthor.insets = new Insets(0, 0, 5, 5);
		gbc_lblauthor.gridx = 1;
		gbc_lblauthor.gridy = 4;
		form.add(lblauthor, gbc_lblauthor);
		txtauthor = new AuthorTextField("",20);
		lblauthor.setLabelFor(txtauthor);
		GridBagConstraints gbc_txtauthor = new GridBagConstraints();
		gbc_txtauthor.insets = new Insets(0, 0, 5, 5);
		gbc_txtauthor.fill = GridBagConstraints.BOTH;
		gbc_txtauthor.gridx = 2;
		gbc_txtauthor.gridy = 4;
		form.add(txtauthor, gbc_txtauthor);
		compContainer.put("Author", txtauthor);
		lblwriter = new JLabel("Writer: ");
		lblwriter.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
		GridBagConstraints gbc_lblwriter = new GridBagConstraints();
		gbc_lblwriter.fill = GridBagConstraints.BOTH;
		gbc_lblwriter.insets = new Insets(0, 0, 5, 5);
		gbc_lblwriter.gridx = 1;
		gbc_lblwriter.gridy = 6;
		form.add(lblwriter, gbc_lblwriter); 
		txtwriter = new WriterTextField("",20);
		lblwriter.setLabelFor(txtwriter);
		GridBagConstraints gbc_txtwriter = new GridBagConstraints();
		gbc_txtwriter.insets = new Insets(0, 0, 5, 5);
		gbc_txtwriter.fill = GridBagConstraints.BOTH;
		gbc_txtwriter.gridx = 2;
		gbc_txtwriter.gridy = 6;
		form.add(txtwriter, gbc_txtwriter);
		compContainer.put("Writer", txtwriter);
		lblpublisher = new JLabel("Publisher: ");
		lblpublisher.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
		GridBagConstraints gbc_lblpublisher = new GridBagConstraints();
		gbc_lblpublisher.fill = GridBagConstraints.BOTH;
		gbc_lblpublisher.insets = new Insets(0, 0, 5, 5);
		gbc_lblpublisher.gridx = 1;
		gbc_lblpublisher.gridy = 8;
		form.add(lblpublisher, gbc_lblpublisher);
		txtpublisher = new PublisherTextField("",20);
		lblpublisher.setLabelFor(txtpublisher);
		GridBagConstraints gbc_txtpublisher = new GridBagConstraints();
		gbc_txtpublisher.insets = new Insets(0, 0, 5, 5);
		gbc_txtpublisher.fill = GridBagConstraints.BOTH;
		gbc_txtpublisher.gridx = 2;
		gbc_txtpublisher.gridy = 8;
		form.add(txtpublisher, gbc_txtpublisher);
		compContainer.put("Publisher", txtpublisher);
		lblisbn = new JLabel("ISBN: ");
		lblisbn.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
		GridBagConstraints gbc_lblisbn = new GridBagConstraints();
		gbc_lblisbn.fill = GridBagConstraints.BOTH;
		gbc_lblisbn.insets = new Insets(0, 0, 5, 5);
		gbc_lblisbn.gridx = 1;
		gbc_lblisbn.gridy = 10;
		form.add(lblisbn, gbc_lblisbn); 
		txtisbn = new ISBNTextField("",12);
		lblisbn.setLabelFor(txtisbn);
		GridBagConstraints gbc_txtisbn = new GridBagConstraints();
		gbc_txtisbn.insets = new Insets(0, 0, 5, 5);
		gbc_txtisbn.fill = GridBagConstraints.BOTH;
		gbc_txtisbn.gridx = 2;
		gbc_txtisbn.gridy = 10;
		form.add(txtisbn, gbc_txtisbn);
		compContainer.put("ISBN", txtisbn);
		lbltype = new JLabel("Type: ");
		lbltype.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
		GridBagConstraints gbc_lbltype = new GridBagConstraints();
		gbc_lbltype.fill = GridBagConstraints.BOTH;
		gbc_lbltype.insets = new Insets(0, 0, 5, 5);
		gbc_lbltype.gridx = 1;
		gbc_lbltype.gridy = 12;
		form.add(lbltype, gbc_lbltype); 
		cbxtype = new TypeComboBox<String>(controller.getGenreData());
		lbltype.setLabelFor(cbxtype);
		GridBagConstraints gbc_cbxtype = new GridBagConstraints();
		gbc_cbxtype.insets = new Insets(0, 0, 5, 5);
		gbc_cbxtype.fill = GridBagConstraints.BOTH;
		gbc_cbxtype.gridx = 2;
		gbc_cbxtype.gridy = 12;
		form.add(cbxtype, gbc_cbxtype);
		compContainer.put("Type", cbxtype);
		
		cbxtype.addActionListener(new CbxBookTypeHandler());
		lblgenre = new JLabel("Genre: ");
		lblgenre.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
		GridBagConstraints gbc_lblgenre = new GridBagConstraints();
		gbc_lblgenre.fill = GridBagConstraints.BOTH;
		gbc_lblgenre.insets = new Insets(0, 0, 5, 5);
		gbc_lblgenre.gridx = 1;
		gbc_lblgenre.gridy = 14;
		form.add(lblgenre, gbc_lblgenre); 
		cbxgenre = new GenreComboBox<String>();
		lblgenre.setLabelFor(cbxgenre);
		GridBagConstraints gbc_cbxgenre = new GridBagConstraints();
		gbc_cbxgenre.insets = new Insets(0, 0, 5, 5);
		gbc_cbxgenre.fill = GridBagConstraints.BOTH;
		gbc_cbxgenre.gridx = 2;
		gbc_cbxgenre.gridy = 14;
		form.add(cbxgenre, gbc_cbxgenre);
		compContainer.put("Genre", cbxgenre);
		lblquantity = new JLabel("Quantity: ");
		lblquantity.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
		GridBagConstraints gbc_lblquantity = new GridBagConstraints();
		gbc_lblquantity.fill = GridBagConstraints.BOTH;
		gbc_lblquantity.insets = new Insets(0, 0, 5, 5);
		gbc_lblquantity.gridx = 1;
		gbc_lblquantity.gridy = 16;
		form.add(lblquantity, gbc_lblquantity);
		compContainer.put("Img", pic);
		
		content.add(picturebox);
		
		verticalStrut_7 = Box.createVerticalStrut(20);
		picturebox.add(verticalStrut_7, BorderLayout.NORTH);
		
		horizontalStrut = Box.createHorizontalStrut(20);
		picturebox.add(horizontalStrut, BorderLayout.WEST);
		
		horizontalStrut_1 = Box.createHorizontalStrut(20);
		picturebox.add(horizontalStrut_1, BorderLayout.EAST);
		
		verticalStrut_8 = Box.createVerticalStrut(20);
		picturebox.add(verticalStrut_8, BorderLayout.SOUTH);
		formOuterPanel.setLayout(new BorderLayout(0, 0));
		formOuterPanel.add(form);
		txtquantity = new QuantityTextField("",20);
		lblquantity.setLabelFor(txtquantity);
		GridBagConstraints gbc_txtquantity = new GridBagConstraints();
		gbc_txtquantity.insets = new Insets(0, 0, 5, 5);
		gbc_txtquantity.fill = GridBagConstraints.BOTH;
		gbc_txtquantity.gridx = 2;
		gbc_txtquantity.gridy = 16;
		form.add(txtquantity, gbc_txtquantity);
		compContainer.put("Quantity", txtquantity);
		
		rigidArea_3 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_3 = new GridBagConstraints();
		gbc_rigidArea_3.gridx = 3;
		gbc_rigidArea_3.gridy = 18;
		form.add(rigidArea_3, gbc_rigidArea_3);
		content.add(formOuterPanel);
		
		verticalStrut_9 = Box.createVerticalStrut(20);
		formOuterPanel.add(verticalStrut_9, BorderLayout.NORTH);
		
		verticalStrut_10 = Box.createVerticalStrut(20);
		formOuterPanel.add(verticalStrut_10, BorderLayout.SOUTH);
		
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
		btnAdd = new JButton("Add");
		btnAdd.setBorder(null);
		btnAdd.setBackground(new Color(255, 250, 250));
		btnCancel = new JButton("Cancel");
		btnCancel.setBorder(null);
		btnCancel.setBackground(new Color(255, 250, 250));
		
		btnAdd.setPreferredSize(new Dimension(80,30)); // button size here
		btnAdd.setFont(new Font("Lucida Sans", Font.PLAIN, 15));
		
		btnCancel.setPreferredSize(new Dimension(80,30)); // button size here
		btnCancel.setFont(new Font("Lucida Sans", Font.PLAIN, 15));
		
		btnAdd.addActionListener(new AddBkFormHandler());
		btnCancel.addActionListener(new AddBkFormHandler());
		
		btnAdd.addMouseListener(new MouseHandler());
		btnCancel.addMouseListener(new MouseHandler());
		
		buttons.add(btnAdd);
		buttons.add(Box.createRigidArea(new Dimension(20,0)));
		buttons.add(btnCancel);
		buttons.add(Box.createRigidArea(new Dimension(10,0)));
		
		this.add(buttons,BorderLayout.PAGE_END);
	}
	
	private void resetTextAlerts() {
		
		pic.setImg("Member");
		txttitle.setText("");
		txtauthor.setText("");
		txtwriter.setText("");
		txtpublisher.setText("");
		cbxtype.setSelectedIndex(0);
		cbxgenre.setEnabled(false);
		txtisbn.setText("");
		txtquantity.setText("");
		
		txttitle.setDefaultBorder();
		txtauthor.setDefaultBorder();
		txtwriter.setDefaultBorder();
		txtpublisher.setDefaultBorder();
		cbxtype.setDefaultBorder();
		cbxgenre.setDefaultBorder();
		txtisbn.setDefaultBorder();
		txtquantity.setDefaultBorder();
		
	}
	
	private class CbxBookTypeHandler implements ActionListener{
		JComboBox<String> source;
		
		@Override
		public void actionPerformed(ActionEvent cbxEvt) {
			source = (JComboBox<String>) cbxEvt.getSource();
			cbxgenre.removeAllItems();
			switch ((String)source.getSelectedItem()) {
			case "Fiction":
				controller.loadCbxData("Fiction", cbxgenre);
				break;
			case "Non-fiction":
				controller.loadCbxData("Non-fiction", cbxgenre);
				break;
			default:
				break;
			}
			cbxgenre.setSelectedIndex(0);
			cbxgenre.setEnabled(true);
		}
	}
	
	private class AddBkFormHandler implements ActionListener{
		JFrame parent = (JFrame) SwingUtilities.getWindowAncestor(parentPanel);
		JButton btnSource;
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			btnSource = (JButton) e.getSource();
			switch (btnSource.getActionCommand()) {
			case "<":
				parentLayout.show(parentPanel, "MAIN");
				break;
			case "Cancel":
				parentLayout.show(parentPanel, "MAIN");
				break;
			case "Add":
				if(controller.processInput(compContainer)) {
					MessageDialog.showDialog(parent, "Book successfully added!", "Success");
					resetTextAlerts();
				}else {
					ErrorDialog.showErrorDialog(parent, controller.getErrorMsg());
				}
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
