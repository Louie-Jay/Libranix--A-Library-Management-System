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

public class SearchBkInfoCard extends JPanel{
	
	//parent properties
	JPanel parentPanel;
	CardLayout parentLayout;
	
	//header
	HeaderPanel header;
	
	//content
	JPanel content;
	
	JPanel picturebox;
	JPanel form;
	
	JLabel lblid;
	JLabel lbltitle;
	JLabel lblauthor;
	JLabel lblwriter;
	JLabel lblpublisher;
	JLabel lblisbn;
	JLabel lbltype;
	JLabel lblgenre;
	JLabel lblquantity;
	
	JLabel txtid;
	JLabel txttitle;
	JLabel txtauthor;
	JLabel txtwriter;
	JLabel txtpublisher;
	JLabel txtisbn;
	JLabel cbxtype;
	JLabel cbxgenre;
	JLabel txtquantity;
	
	// footer buttons
	JPanel buttons;
	JButton btnOk;
	LinkedHashMap<String,Object> cellValues;
	private Component verticalStrut;
	private Component verticalStrut_1;
	private Component horizontalStrut;
	private Component horizontalStrut_1;
	private Component verticalStrut_2;
	private Component verticalStrut_3;
	private Component horizontalStrut_2;
	private Component horizontalStrut_3;
	private Component verticalStrut_4;
	private Component verticalStrut_5;
	private Component horizontalStrut_4;
	private Component horizontalStrut_5;
	private Component verticalStrut_6;
	private Component verticalStrut_7;
	private Component verticalStrut_8;
	private Component verticalStrut_9;
	private Component verticalStrut_10;
	private Component verticalStrut_11;
	private Component verticalStrut_12;
	private Component verticalStrut_13;
	
	public SearchBkInfoCard(JPanel parentPnl,LinkedHashMap<String, Object> paramValues) {
		this.parentPanel = parentPnl;
		this.parentLayout = (CardLayout)parentPnl.getLayout();
		this.cellValues = paramValues;
		this.setLayout(new BorderLayout());
		
		loadHeader();
		loadContentForm();
		loadFooterButtons();
		
	}
	
	private void loadHeader() {
		
		header = new HeaderPanel("Book Info",true);
		
		header.setBackActionListener(new AddBkFormHandler());
		
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
		form.setBorder(new LineBorder(new Color(100, 149, 237)));
		//form.setBorder(BorderFactory.createLineBorder(Color.RED));
		content.setLayout(new GridLayout(0,2));
		GridBagLayout gbl_form = new GridBagLayout();
		gbl_form.columnWidths = new int[]{0, 196, 196, 0, 0};
		gbl_form.rowHeights = new int[]{0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0};
		gbl_form.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_form.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		form.setLayout(gbl_form);
		
		verticalStrut_4 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_4 = new GridBagConstraints();
		gbc_verticalStrut_4.gridwidth = 2;
		gbc_verticalStrut_4.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_4.gridx = 1;
		gbc_verticalStrut_4.gridy = 0;
		form.add(verticalStrut_4, gbc_verticalStrut_4);
		
		lblid = new JLabel("ID: ");
		lblid.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
		
		GridBagConstraints gbc_lblid = new GridBagConstraints();
		gbc_lblid.fill = GridBagConstraints.BOTH;
		gbc_lblid.insets = new Insets(0, 0, 5, 5);
		gbc_lblid.gridx = 1;
		gbc_lblid.gridy = 1;
		form.add(lblid, gbc_lblid); 
		
		txtid = new JLabel("	N/A");
		txtid.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
		GridBagConstraints gbc_txtid = new GridBagConstraints();
		gbc_txtid.fill = GridBagConstraints.BOTH;
		gbc_txtid.insets = new Insets(0, 0, 5, 5);
		gbc_txtid.gridx = 2;
		gbc_txtid.gridy = 1;
		form.add(txtid, gbc_txtid);
		
		horizontalStrut_5 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_5 = new GridBagConstraints();
		gbc_horizontalStrut_5.gridheight = 17;
		gbc_horizontalStrut_5.insets = new Insets(0, 0, 5, 0);
		gbc_horizontalStrut_5.gridx = 3;
		gbc_horizontalStrut_5.gridy = 1;
		form.add(horizontalStrut_5, gbc_horizontalStrut_5);
		
		verticalStrut_13 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_13 = new GridBagConstraints();
		gbc_verticalStrut_13.gridwidth = 2;
		gbc_verticalStrut_13.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_13.gridx = 1;
		gbc_verticalStrut_13.gridy = 2;
		form.add(verticalStrut_13, gbc_verticalStrut_13);
		lbltitle = new JLabel("Title: ");
		lbltitle.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
		GridBagConstraints gbc_lbltitle = new GridBagConstraints();
		gbc_lbltitle.fill = GridBagConstraints.BOTH;
		gbc_lbltitle.insets = new Insets(0, 0, 5, 5);
		gbc_lbltitle.gridx = 1;
		gbc_lbltitle.gridy = 3;
		form.add(lbltitle, gbc_lbltitle); 
		txttitle = new JLabel("	N/A");
		txttitle.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
		GridBagConstraints gbc_txttitle = new GridBagConstraints();
		gbc_txttitle.fill = GridBagConstraints.BOTH;
		gbc_txttitle.insets = new Insets(0, 0, 5, 5);
		gbc_txttitle.gridx = 2;
		gbc_txttitle.gridy = 3;
		form.add(txttitle, gbc_txttitle);
		
		verticalStrut_12 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_12 = new GridBagConstraints();
		gbc_verticalStrut_12.gridwidth = 2;
		gbc_verticalStrut_12.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_12.gridx = 1;
		gbc_verticalStrut_12.gridy = 4;
		form.add(verticalStrut_12, gbc_verticalStrut_12);
		lblauthor = new JLabel("Author: ");
		lblauthor.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
		GridBagConstraints gbc_lblauthor = new GridBagConstraints();
		gbc_lblauthor.fill = GridBagConstraints.BOTH;
		gbc_lblauthor.insets = new Insets(0, 0, 5, 5);
		gbc_lblauthor.gridx = 1;
		gbc_lblauthor.gridy = 5;
		form.add(lblauthor, gbc_lblauthor);
		txtauthor = new JLabel("	N/A");
		txtauthor.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
		GridBagConstraints gbc_txtauthor = new GridBagConstraints();
		gbc_txtauthor.fill = GridBagConstraints.BOTH;
		gbc_txtauthor.insets = new Insets(0, 0, 5, 5);
		gbc_txtauthor.gridx = 2;
		gbc_txtauthor.gridy = 5;
		form.add(txtauthor, gbc_txtauthor);
		
		verticalStrut_11 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_11 = new GridBagConstraints();
		gbc_verticalStrut_11.gridwidth = 2;
		gbc_verticalStrut_11.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_11.gridx = 1;
		gbc_verticalStrut_11.gridy = 6;
		form.add(verticalStrut_11, gbc_verticalStrut_11);
		lblwriter = new JLabel("Writer: ");
		lblwriter.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
		GridBagConstraints gbc_lblwriter = new GridBagConstraints();
		gbc_lblwriter.fill = GridBagConstraints.BOTH;
		gbc_lblwriter.insets = new Insets(0, 0, 5, 5);
		gbc_lblwriter.gridx = 1;
		gbc_lblwriter.gridy = 7;
		form.add(lblwriter, gbc_lblwriter); 
		txtwriter = new JLabel("	N/A");
		txtwriter.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
		GridBagConstraints gbc_txtwriter = new GridBagConstraints();
		gbc_txtwriter.fill = GridBagConstraints.BOTH;
		gbc_txtwriter.insets = new Insets(0, 0, 5, 5);
		gbc_txtwriter.gridx = 2;
		gbc_txtwriter.gridy = 7;
		form.add(txtwriter, gbc_txtwriter);
		
		verticalStrut_10 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_10 = new GridBagConstraints();
		gbc_verticalStrut_10.gridwidth = 2;
		gbc_verticalStrut_10.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_10.gridx = 1;
		gbc_verticalStrut_10.gridy = 8;
		form.add(verticalStrut_10, gbc_verticalStrut_10);
		lblpublisher = new JLabel("Publisher: ");
		lblpublisher.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
		GridBagConstraints gbc_lblpublisher = new GridBagConstraints();
		gbc_lblpublisher.fill = GridBagConstraints.BOTH;
		gbc_lblpublisher.insets = new Insets(0, 0, 5, 5);
		gbc_lblpublisher.gridx = 1;
		gbc_lblpublisher.gridy = 9;
		form.add(lblpublisher, gbc_lblpublisher); txtpublisher = new JLabel("	N/A");
 txtpublisher.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
 GridBagConstraints gbc_txtpublisher = new GridBagConstraints();
 gbc_txtpublisher.fill = GridBagConstraints.BOTH;
 gbc_txtpublisher.insets = new Insets(0, 0, 5, 5);
 gbc_txtpublisher.gridx = 2;
 gbc_txtpublisher.gridy = 9;
 form.add(txtpublisher, gbc_txtpublisher);
 
 verticalStrut_9 = Box.createVerticalStrut(20);
 GridBagConstraints gbc_verticalStrut_9 = new GridBagConstraints();
 gbc_verticalStrut_9.gridwidth = 2;
 gbc_verticalStrut_9.insets = new Insets(0, 0, 5, 5);
 gbc_verticalStrut_9.gridx = 1;
 gbc_verticalStrut_9.gridy = 10;
 form.add(verticalStrut_9, gbc_verticalStrut_9);
 lblisbn = new JLabel("ISBN: ");
 lblisbn.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
 GridBagConstraints gbc_lblisbn = new GridBagConstraints();
 gbc_lblisbn.fill = GridBagConstraints.BOTH;
 gbc_lblisbn.insets = new Insets(0, 0, 5, 5);
 gbc_lblisbn.gridx = 1;
 gbc_lblisbn.gridy = 11;
 form.add(lblisbn, gbc_lblisbn);
 txtisbn = new JLabel("	N/A");
 txtisbn.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
 GridBagConstraints gbc_txtisbn = new GridBagConstraints();
 gbc_txtisbn.fill = GridBagConstraints.BOTH;
 gbc_txtisbn.insets = new Insets(0, 0, 5, 5);
 gbc_txtisbn.gridx = 2;
 gbc_txtisbn.gridy = 11;
 form.add(txtisbn, gbc_txtisbn);
 
 verticalStrut_8 = Box.createVerticalStrut(20);
 GridBagConstraints gbc_verticalStrut_8 = new GridBagConstraints();
 gbc_verticalStrut_8.gridwidth = 2;
 gbc_verticalStrut_8.insets = new Insets(0, 0, 5, 5);
 gbc_verticalStrut_8.gridx = 1;
 gbc_verticalStrut_8.gridy = 12;
 form.add(verticalStrut_8, gbc_verticalStrut_8);
 lbltype = new JLabel("Type: ");
 lbltype.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
 GridBagConstraints gbc_lbltype = new GridBagConstraints();
 gbc_lbltype.fill = GridBagConstraints.BOTH;
 gbc_lbltype.insets = new Insets(0, 0, 5, 5);
 gbc_lbltype.gridx = 1;
 gbc_lbltype.gridy = 13;
 form.add(lbltype, gbc_lbltype); 
 cbxtype = new JLabel("	N/A");
 cbxtype.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
 GridBagConstraints gbc_cbxtype = new GridBagConstraints();
 gbc_cbxtype.fill = GridBagConstraints.BOTH;
 gbc_cbxtype.insets = new Insets(0, 0, 5, 5);
 gbc_cbxtype.gridx = 2;
 gbc_cbxtype.gridy = 13;
 form.add(cbxtype, gbc_cbxtype);
 
 verticalStrut_7 = Box.createVerticalStrut(20);
 GridBagConstraints gbc_verticalStrut_7 = new GridBagConstraints();
 gbc_verticalStrut_7.gridwidth = 2;
 gbc_verticalStrut_7.insets = new Insets(0, 0, 5, 5);
 gbc_verticalStrut_7.gridx = 1;
 gbc_verticalStrut_7.gridy = 14;
 form.add(verticalStrut_7, gbc_verticalStrut_7);
 lblgenre = new JLabel("Genre: ");
 lblgenre.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
 GridBagConstraints gbc_lblgenre = new GridBagConstraints();
 gbc_lblgenre.fill = GridBagConstraints.BOTH;
 gbc_lblgenre.insets = new Insets(0, 0, 5, 5);
 gbc_lblgenre.gridx = 1;
 gbc_lblgenre.gridy = 15;
 form.add(lblgenre, gbc_lblgenre);
 cbxgenre = new JLabel("	N/A");
 cbxgenre.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
 GridBagConstraints gbc_cbxgenre = new GridBagConstraints();
 gbc_cbxgenre.fill = GridBagConstraints.BOTH;
 gbc_cbxgenre.insets = new Insets(0, 0, 5, 5);
 gbc_cbxgenre.gridx = 2;
 gbc_cbxgenre.gridy = 15;
 form.add(cbxgenre, gbc_cbxgenre);
 
 verticalStrut_6 = Box.createVerticalStrut(20);
 GridBagConstraints gbc_verticalStrut_6 = new GridBagConstraints();
 gbc_verticalStrut_6.gridwidth = 2;
 gbc_verticalStrut_6.insets = new Insets(0, 0, 5, 5);
 gbc_verticalStrut_6.gridx = 1;
 gbc_verticalStrut_6.gridy = 16;
 form.add(verticalStrut_6, gbc_verticalStrut_6);
 lblquantity = new JLabel("Quantity: ");
 lblquantity.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
 GridBagConstraints gbc_lblquantity = new GridBagConstraints();
 gbc_lblquantity.fill = GridBagConstraints.BOTH;
 gbc_lblquantity.insets = new Insets(0, 0, 5, 5);
 gbc_lblquantity.gridx = 1;
 gbc_lblquantity.gridy = 17;
 form.add(lblquantity, gbc_lblquantity); 
 txtquantity = new JLabel("	N/A");
 txtquantity.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
 GridBagConstraints gbc_txtquantity = new GridBagConstraints();
 gbc_txtquantity.insets = new Insets(0, 0, 5, 5);
 gbc_txtquantity.fill = GridBagConstraints.BOTH;
 gbc_txtquantity.gridx = 2;
 gbc_txtquantity.gridy = 17;
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
		
		horizontalStrut_4 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_4 = new GridBagConstraints();
		gbc_horizontalStrut_4.gridheight = 17;
		gbc_horizontalStrut_4.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_4.gridx = 0;
		gbc_horizontalStrut_4.gridy = 1;
		form.add(horizontalStrut_4, gbc_horizontalStrut_4);
		
		verticalStrut_5 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_5 = new GridBagConstraints();
		gbc_verticalStrut_5.insets = new Insets(0, 0, 0, 5);
		gbc_verticalStrut_5.gridwidth = 2;
		gbc_verticalStrut_5.gridx = 1;
		gbc_verticalStrut_5.gridy = 18;
		form.add(verticalStrut_5, gbc_verticalStrut_5);
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
	
	public void loadValues() {
		txtid.setText(String.valueOf(cellValues.get("ID")));
		txttitle.setText("<html><p style=\"width:200px\">"+(String) cellValues.get("Title")+"</p></html>");
		txtauthor.setText((String) cellValues.get("Author"));
		txtwriter.setText((String) cellValues.get("Writer"));
		txtpublisher.setText((String) cellValues.get("Publisher"));
		txtisbn.setText((String) cellValues.get("ISBN"));
		cbxtype.setText((String) cellValues.get("Type"));
		cbxgenre.setText((String) cellValues.get("Genre"));
		txtquantity.setText(String.valueOf(cellValues.get("Quantity")));
	}
	
	private void loadFooterButtons() {
		
		buttons = new JPanel();
		buttons.setBackground(new Color(100, 149, 237));
		
		buttons.setLayout(new FlowLayout(FlowLayout.TRAILING));
		//this.setBorder(new LineBorder(Color.BLACK));
		btnOk = new JButton("Ok");
		btnOk.setBorder(null);
		btnOk.setBackground(new Color(255, 250, 250));
		
		
		btnOk.setPreferredSize(new Dimension(80,30)); // button size here
		btnOk.setFont(new Font("Lucida Sans", Font.PLAIN, 15));
		
		btnOk.addActionListener(new AddBkFormHandler());
		btnOk.addMouseListener(new MouseHandler());
		
		buttons.add(Box.createRigidArea(new Dimension(20,0)));
		buttons.add(btnOk);
		buttons.add(Box.createRigidArea(new Dimension(10,0)));
		
		this.add(buttons,BorderLayout.PAGE_END);
	}
	
	
	private class AddBkFormHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent evt) {

			switch (evt.getActionCommand()) {
			case "<":
				parentLayout.show(parentPanel, "SEARCHBOOK");
				break;
			case "Ok":
				parentLayout.show(parentPanel, "SEARCHBOOK");
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
