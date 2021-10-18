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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import controller.ReturnBkTransactController;
import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.MatteBorder;

public class ReturnBkTransactCard extends JPanel{
	
	//parent properties
	JPanel parentPanel;
	CardLayout parentLayout; 
	
	//header
	HeaderPanel header;
	
	//content
	JPanel content;
	
	JPanel picturebox;
	JPanel formBook;
	JPanel formMember;
	
	//book form
	JLabel lblborrower;
	JLabel lbltitle;
	JLabel lblauthor;
	JLabel lblwriter;
	JLabel lblpublisher;
	JLabel lblisbn;
	JLabel lbltype;
	JLabel lblgenre;
	JLabel lblquantity;
	
	JLabel txtborrower;
	JLabel txttitle;
	JLabel txtauthor;
	JLabel txtwriter;
	JLabel txtpublisher;
	JLabel txtisbn;
	JLabel cbxtype;
	Img pic;
	JLabel cbxgenre;
	QuantityTextField txtquantity;
	
	//member form
	JLabel lblfirstname;
	JLabel lblmiddlename;
	JLabel lbllastname;
	JLabel lblbirthdate;
	JLabel lbladdress;
	JLabel lblemail;
	JLabel lblcontactno;
	
	JLabel txtfirstname;
	JLabel txtmiddlename;
	JLabel txtlastname;
	JLabel txtbirthdate;
	JLabel txtaddress;
	JLabel txtemail;
	JLabel txtcontactno;
	
	// footer buttons
	JPanel buttons;
	JButton btnReturn;
	JButton btnCancel;
	
	
	private ReturnBkTransactController controller;
	private LinkedHashMap<String, String> formBookValues;
	private LinkedHashMap<String, String> formMemberValues;
	private LinkedHashMap<String,Object> cellValues;
	private Component verticalStrut;
	private Component verticalStrut_1;
	private Component horizontalStrut;
	private Component horizontalStrut_1;
	private Component verticalStrut_2;
	private Component verticalStrut_3;
	private Component horizontalStrut_2;
	private Component horizontalStrut_3;
	private Component verticalStrut_4;
	private Component rigidArea;
	private Component rigidArea_1;
	private Component rigidArea_2;
	private Component rigidArea_3;
	
	public ReturnBkTransactCard(JPanel parentPnl, LinkedHashMap<String, Object> cellValues) {
		this.parentPanel = parentPnl;
		this.parentLayout = (CardLayout)parentPnl.getLayout();
		this.controller = new ReturnBkTransactController();
		this.setLayout(new BorderLayout());
		this.cellValues = cellValues;

		loadHeader();
		loadContentForm();
		loadFooterButtons();
		
	}
	
	private void loadHeader() {
		
		header = new HeaderPanel("Return Book",true);
		
		header.setBackActionListener(new ReturnBkTransactFormPopUpHandler());
		
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
		
		pic = new Img("Book");
		//pic.setImg(prmName);
		picturebox.add(pic);
		//form.setBorder(BorderFactory.createLineBorder(Color.RED));
		content.setLayout(new GridLayout(0,2));
		
		content.add(picturebox);
		
		verticalStrut = Box.createVerticalStrut(20);
		picturebox.add(verticalStrut, BorderLayout.NORTH);
		
		verticalStrut_1 = Box.createVerticalStrut(20);
		picturebox.add(verticalStrut_1, BorderLayout.SOUTH);
		
		horizontalStrut = Box.createHorizontalStrut(20);
		picturebox.add(horizontalStrut, BorderLayout.WEST);
		
		horizontalStrut_1 = Box.createHorizontalStrut(20);
		picturebox.add(horizontalStrut_1, BorderLayout.EAST);
		GridBagLayout gbl_formOuterPanel = new GridBagLayout();
		gbl_formOuterPanel.columnWidths = new int[]{0, 407, 0, 0};
		gbl_formOuterPanel.rowHeights = new int[]{0, 274, 0, 1, 0, 0};
		gbl_formOuterPanel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_formOuterPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		formOuterPanel.setLayout(gbl_formOuterPanel);
		
		verticalStrut_2 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_2 = new GridBagConstraints();
		gbc_verticalStrut_2.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_2.gridx = 1;
		gbc_verticalStrut_2.gridy = 0;
		formOuterPanel.add(verticalStrut_2, gbc_verticalStrut_2);
		
		horizontalStrut_2 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_2 = new GridBagConstraints();
		gbc_horizontalStrut_2.gridheight = 3;
		gbc_horizontalStrut_2.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_2.gridx = 0;
		gbc_horizontalStrut_2.gridy = 1;
		formOuterPanel.add(horizontalStrut_2, gbc_horizontalStrut_2);
		
		formBook = new JPanel();
		formBook.setOpaque(false);
		formBook.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 1),"Book"));
		TitledBorder border1 = (TitledBorder) formBook.getBorder();
		border1.setTitleFont(new Font("Lucida Sans", Font.BOLD, 13));
				GridBagLayout gbl_formBook = new GridBagLayout();
				gbl_formBook.columnWidths = new int[]{0, 196, 196, 0, 0};
				gbl_formBook.rowHeights = new int[]{0, 27, 27, 27, 27, 27, 27, 27, 27, 0, 0};
				gbl_formBook.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
				gbl_formBook.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
				formBook.setLayout(gbl_formBook);
				
				rigidArea = Box.createRigidArea(new Dimension(20, 20));
				GridBagConstraints gbc_rigidArea = new GridBagConstraints();
				gbc_rigidArea.insets = new Insets(0, 0, 5, 5);
				gbc_rigidArea.gridx = 0;
				gbc_rigidArea.gridy = 0;
				formBook.add(rigidArea, gbc_rigidArea);
				
				//form book
				lbltitle = new JLabel("Title: ");
				lbltitle.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
				
						
						//r1.setBackground(Color.YELLOW);
						//r1.setOpaque(false);
						
						GridBagConstraints gbc_lbltitle = new GridBagConstraints();
						gbc_lbltitle.fill = GridBagConstraints.BOTH;
						gbc_lbltitle.insets = new Insets(0, 0, 5, 5);
						gbc_lbltitle.gridx = 1;
						gbc_lbltitle.gridy = 1;
						formBook.add(lbltitle, gbc_lbltitle); 
				
				txttitle = new JLabel("	N/A");
				txttitle.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
				GridBagConstraints gbc_txttitle = new GridBagConstraints();
				gbc_txttitle.fill = GridBagConstraints.BOTH;
				gbc_txttitle.insets = new Insets(0, 0, 5, 5);
				gbc_txttitle.gridx = 2;
				gbc_txttitle.gridy = 1;
				formBook.add(txttitle, gbc_txttitle);
				lblauthor = new JLabel("Author: ");
				lblauthor.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
				GridBagConstraints gbc_lblauthor = new GridBagConstraints();
				gbc_lblauthor.fill = GridBagConstraints.BOTH;
				gbc_lblauthor.insets = new Insets(0, 0, 5, 5);
				gbc_lblauthor.gridx = 1;
				gbc_lblauthor.gridy = 2;
				formBook.add(lblauthor, gbc_lblauthor); 
				txtauthor = new JLabel("	N/A");
				txtauthor.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
				GridBagConstraints gbc_txtauthor = new GridBagConstraints();
				gbc_txtauthor.fill = GridBagConstraints.BOTH;
				gbc_txtauthor.insets = new Insets(0, 0, 5, 5);
				gbc_txtauthor.gridx = 2;
				gbc_txtauthor.gridy = 2;
				formBook.add(txtauthor, gbc_txtauthor);
				lblwriter = new JLabel("Writer: ");
				lblwriter.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
				GridBagConstraints gbc_lblwriter = new GridBagConstraints();
				gbc_lblwriter.fill = GridBagConstraints.BOTH;
				gbc_lblwriter.insets = new Insets(0, 0, 5, 5);
				gbc_lblwriter.gridx = 1;
				gbc_lblwriter.gridy = 3;
				formBook.add(lblwriter, gbc_lblwriter); 
				txtwriter = new JLabel("	N/A");
				txtwriter.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
				GridBagConstraints gbc_txtwriter = new GridBagConstraints();
				gbc_txtwriter.fill = GridBagConstraints.BOTH;
				gbc_txtwriter.insets = new Insets(0, 0, 5, 5);
				gbc_txtwriter.gridx = 2;
				gbc_txtwriter.gridy = 3;
				formBook.add(txtwriter, gbc_txtwriter);
				lblpublisher = new JLabel("Publisher: ");
				lblpublisher.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
				GridBagConstraints gbc_lblpublisher = new GridBagConstraints();
				gbc_lblpublisher.fill = GridBagConstraints.BOTH;
				gbc_lblpublisher.insets = new Insets(0, 0, 5, 5);
				gbc_lblpublisher.gridx = 1;
				gbc_lblpublisher.gridy = 4;
				formBook.add(lblpublisher, gbc_lblpublisher); 
				txtpublisher = new JLabel("	N/A");
				txtpublisher.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
				GridBagConstraints gbc_txtpublisher = new GridBagConstraints();
				gbc_txtpublisher.fill = GridBagConstraints.BOTH;
				gbc_txtpublisher.insets = new Insets(0, 0, 5, 5);
				gbc_txtpublisher.gridx = 2;
				gbc_txtpublisher.gridy = 4;
				formBook.add(txtpublisher, gbc_txtpublisher);
				lblisbn = new JLabel("ISBN: ");
				lblisbn.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
				GridBagConstraints gbc_lblisbn = new GridBagConstraints();
				gbc_lblisbn.fill = GridBagConstraints.BOTH;
				gbc_lblisbn.insets = new Insets(0, 0, 5, 5);
				gbc_lblisbn.gridx = 1;
				gbc_lblisbn.gridy = 5;
				formBook.add(lblisbn, gbc_lblisbn); 
				txtisbn = new JLabel("	N/A");
				txtisbn.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
				GridBagConstraints gbc_txtisbn = new GridBagConstraints();
				gbc_txtisbn.fill = GridBagConstraints.BOTH;
				gbc_txtisbn.insets = new Insets(0, 0, 5, 5);
				gbc_txtisbn.gridx = 2;
				gbc_txtisbn.gridy = 5;
				formBook.add(txtisbn, gbc_txtisbn);
				lbltype = new JLabel("Type: ");
				lbltype.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
				GridBagConstraints gbc_lbltype = new GridBagConstraints();
				gbc_lbltype.fill = GridBagConstraints.BOTH;
				gbc_lbltype.insets = new Insets(0, 0, 5, 5);
				gbc_lbltype.gridx = 1;
				gbc_lbltype.gridy = 6;
				formBook.add(lbltype, gbc_lbltype); 
				cbxtype = new JLabel(" N/A");
				cbxtype.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
				GridBagConstraints gbc_cbxtype = new GridBagConstraints();
				gbc_cbxtype.fill = GridBagConstraints.BOTH;
				gbc_cbxtype.insets = new Insets(0, 0, 5, 5);
				gbc_cbxtype.gridx = 2;
				gbc_cbxtype.gridy = 6;
				formBook.add(cbxtype, gbc_cbxtype);
				lblgenre = new JLabel("Genre: ");
				lblgenre.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
				GridBagConstraints gbc_lblgenre = new GridBagConstraints();
				gbc_lblgenre.fill = GridBagConstraints.BOTH;
				gbc_lblgenre.insets = new Insets(0, 0, 5, 5);
				gbc_lblgenre.gridx = 1;
				gbc_lblgenre.gridy = 7;
				formBook.add(lblgenre, gbc_lblgenre); 
				cbxgenre = new JLabel("	N/A");
				cbxgenre.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
				GridBagConstraints gbc_cbxgenre = new GridBagConstraints();
				gbc_cbxgenre.fill = GridBagConstraints.BOTH;
				gbc_cbxgenre.insets = new Insets(0, 0, 5, 5);
				gbc_cbxgenre.gridx = 2;
				gbc_cbxgenre.gridy = 7;
				formBook.add(cbxgenre, gbc_cbxgenre);
				lblquantity = new JLabel("Quantity: ");
				lblquantity.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
				GridBagConstraints gbc_lblquantity = new GridBagConstraints();
				gbc_lblquantity.fill = GridBagConstraints.BOTH;
				gbc_lblquantity.insets = new Insets(0, 0, 5, 5);
				gbc_lblquantity.gridx = 1;
				gbc_lblquantity.gridy = 8;
				formBook.add(lblquantity, gbc_lblquantity); 
				txtquantity = new QuantityTextField("",2);
				GridBagConstraints gbc_txtquantity = new GridBagConstraints();
				gbc_txtquantity.insets = new Insets(0, 0, 5, 5);
				gbc_txtquantity.fill = GridBagConstraints.BOTH;
				gbc_txtquantity.gridx = 2;
				gbc_txtquantity.gridy = 8;
				formBook.add(txtquantity, gbc_txtquantity);
				GridBagConstraints gbc_formBook = new GridBagConstraints();
				gbc_formBook.fill = GridBagConstraints.BOTH;
				gbc_formBook.insets = new Insets(0, 0, 5, 5);
				gbc_formBook.gridx = 1;
				gbc_formBook.gridy = 1;
				formOuterPanel.add(formBook, gbc_formBook);
				
				rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
				GridBagConstraints gbc_rigidArea_1 = new GridBagConstraints();
				gbc_rigidArea_1.gridx = 3;
				gbc_rigidArea_1.gridy = 9;
				formBook.add(rigidArea_1, gbc_rigidArea_1);
		
		horizontalStrut_3 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_3 = new GridBagConstraints();
		gbc_horizontalStrut_3.gridheight = 3;
		gbc_horizontalStrut_3.insets = new Insets(0, 0, 5, 0);
		gbc_horizontalStrut_3.gridx = 2;
		gbc_horizontalStrut_3.gridy = 1;
		formOuterPanel.add(horizontalStrut_3, gbc_horizontalStrut_3);
		
		verticalStrut_4 = Box.createVerticalStrut(5);
		GridBagConstraints gbc_verticalStrut_4 = new GridBagConstraints();
		gbc_verticalStrut_4.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_4.gridx = 1;
		gbc_verticalStrut_4.gridy = 2;
		formOuterPanel.add(verticalStrut_4, gbc_verticalStrut_4);
		
		formMember = new JPanel();
		formMember.setOpaque(false);
		formMember.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 1),"Member"));
		TitledBorder border2 = (TitledBorder) formMember.getBorder();
		border2.setTitleFont(new Font("Lucida Sans", Font.BOLD, 13));
				GridBagLayout gbl_formMember = new GridBagLayout();
				gbl_formMember.columnWidths = new int[]{0, 218, 218, 0, 0};
				gbl_formMember.rowHeights = new int[]{0, 27, 27, 27, 27, 27, 27, 27, 27, 0};
				gbl_formMember.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
				gbl_formMember.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
				formMember.setLayout(gbl_formMember);
						
						rigidArea_2 = Box.createRigidArea(new Dimension(20, 20));
						GridBagConstraints gbc_rigidArea_2 = new GridBagConstraints();
						gbc_rigidArea_2.insets = new Insets(0, 0, 5, 5);
						gbc_rigidArea_2.gridx = 0;
						gbc_rigidArea_2.gridy = 0;
						formMember.add(rigidArea_2, gbc_rigidArea_2);
				
						
						//form member
						lblfirstname = new JLabel("First Name: ");
						lblfirstname.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
						
						GridBagConstraints gbc_lblfirstname = new GridBagConstraints();
						gbc_lblfirstname.fill = GridBagConstraints.BOTH;
						gbc_lblfirstname.insets = new Insets(0, 0, 5, 5);
						gbc_lblfirstname.gridx = 1;
						gbc_lblfirstname.gridy = 1;
						formMember.add(lblfirstname, gbc_lblfirstname); 
				
				txtfirstname = new JLabel("N/A");
				txtfirstname.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
				GridBagConstraints gbc_txtfirstname = new GridBagConstraints();
				gbc_txtfirstname.fill = GridBagConstraints.BOTH;
				gbc_txtfirstname.insets = new Insets(0, 0, 5, 5);
				gbc_txtfirstname.gridx = 2;
				gbc_txtfirstname.gridy = 1;
				formMember.add(txtfirstname, gbc_txtfirstname);
				lblmiddlename = new JLabel("Middle Name: ");
				lblmiddlename.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
				GridBagConstraints gbc_lblmiddlename = new GridBagConstraints();
				gbc_lblmiddlename.fill = GridBagConstraints.BOTH;
				gbc_lblmiddlename.insets = new Insets(0, 0, 5, 5);
				gbc_lblmiddlename.gridx = 1;
				gbc_lblmiddlename.gridy = 2;
				formMember.add(lblmiddlename, gbc_lblmiddlename); 
				txtmiddlename = new JLabel("N/A");
				txtmiddlename.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
				GridBagConstraints gbc_txtmiddlename = new GridBagConstraints();
				gbc_txtmiddlename.fill = GridBagConstraints.BOTH;
				gbc_txtmiddlename.insets = new Insets(0, 0, 5, 5);
				gbc_txtmiddlename.gridx = 2;
				gbc_txtmiddlename.gridy = 2;
				formMember.add(txtmiddlename, gbc_txtmiddlename);
				lbllastname = new JLabel("Last Name: ");
				lbllastname.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
				GridBagConstraints gbc_lbllastname = new GridBagConstraints();
				gbc_lbllastname.fill = GridBagConstraints.BOTH;
				gbc_lbllastname.insets = new Insets(0, 0, 5, 5);
				gbc_lbllastname.gridx = 1;
				gbc_lbllastname.gridy = 3;
				formMember.add(lbllastname, gbc_lbllastname); 
				txtlastname = new JLabel("N/A");
				txtlastname.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
				GridBagConstraints gbc_txtlastname = new GridBagConstraints();
				gbc_txtlastname.fill = GridBagConstraints.BOTH;
				gbc_txtlastname.insets = new Insets(0, 0, 5, 5);
				gbc_txtlastname.gridx = 2;
				gbc_txtlastname.gridy = 3;
				formMember.add(txtlastname, gbc_txtlastname);
				lblbirthdate = new JLabel("Birthdate: ");
				lblbirthdate.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
				GridBagConstraints gbc_lblbirthdate = new GridBagConstraints();
				gbc_lblbirthdate.fill = GridBagConstraints.BOTH;
				gbc_lblbirthdate.insets = new Insets(0, 0, 5, 5);
				gbc_lblbirthdate.gridx = 1;
				gbc_lblbirthdate.gridy = 4;
				formMember.add(lblbirthdate, gbc_lblbirthdate); 
				txtbirthdate = new JLabel("N/A");
				txtbirthdate.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
				GridBagConstraints gbc_txtbirthdate = new GridBagConstraints();
				gbc_txtbirthdate.fill = GridBagConstraints.BOTH;
				gbc_txtbirthdate.insets = new Insets(0, 0, 5, 5);
				gbc_txtbirthdate.gridx = 2;
				gbc_txtbirthdate.gridy = 4;
				formMember.add(txtbirthdate, gbc_txtbirthdate);
				lbladdress = new JLabel("Address: ");
				lbladdress.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
				GridBagConstraints gbc_lbladdress = new GridBagConstraints();
				gbc_lbladdress.fill = GridBagConstraints.BOTH;
				gbc_lbladdress.insets = new Insets(0, 0, 5, 5);
				gbc_lbladdress.gridx = 1;
				gbc_lbladdress.gridy = 5;
				formMember.add(lbladdress, gbc_lbladdress); 
				txtaddress = new JLabel("N/A");
				txtaddress.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
				GridBagConstraints gbc_txtaddress = new GridBagConstraints();
				gbc_txtaddress.fill = GridBagConstraints.BOTH;
				gbc_txtaddress.insets = new Insets(0, 0, 5, 5);
				gbc_txtaddress.gridx = 2;
				gbc_txtaddress.gridy = 5;
				formMember.add(txtaddress, gbc_txtaddress);
				lblemail = new JLabel("Email: ");
				lblemail.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
				GridBagConstraints gbc_lblemail = new GridBagConstraints();
				gbc_lblemail.fill = GridBagConstraints.BOTH;
				gbc_lblemail.insets = new Insets(0, 0, 5, 5);
				gbc_lblemail.gridx = 1;
				gbc_lblemail.gridy = 6;
				formMember.add(lblemail, gbc_lblemail); 
				txtemail = new JLabel("N/A");
				txtemail.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
				GridBagConstraints gbc_txtemail = new GridBagConstraints();
				gbc_txtemail.fill = GridBagConstraints.BOTH;
				gbc_txtemail.insets = new Insets(0, 0, 5, 5);
				gbc_txtemail.gridx = 2;
				gbc_txtemail.gridy = 6;
				formMember.add(txtemail, gbc_txtemail);
				lblcontactno = new JLabel("Contact No: ");
				lblcontactno.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
				GridBagConstraints gbc_lblcontactno = new GridBagConstraints();
				gbc_lblcontactno.fill = GridBagConstraints.BOTH;
				gbc_lblcontactno.insets = new Insets(0, 0, 5, 5);
				gbc_lblcontactno.gridx = 1;
				gbc_lblcontactno.gridy = 7;
				formMember.add(lblcontactno, gbc_lblcontactno); 
				txtcontactno = new JLabel("N/A");
				txtcontactno.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
				GridBagConstraints gbc_txtcontactno = new GridBagConstraints();
				gbc_txtcontactno.insets = new Insets(0, 0, 5, 5);
				gbc_txtcontactno.fill = GridBagConstraints.BOTH;
				gbc_txtcontactno.gridx = 2;
				gbc_txtcontactno.gridy = 7;
				formMember.add(txtcontactno, gbc_txtcontactno);
				GridBagConstraints gbc_formMember = new GridBagConstraints();
				gbc_formMember.insets = new Insets(0, 0, 5, 5);
				gbc_formMember.fill = GridBagConstraints.BOTH;
				gbc_formMember.gridx = 1;
				gbc_formMember.gridy = 3;
				formOuterPanel.add(formMember, gbc_formMember);
				
				rigidArea_3 = Box.createRigidArea(new Dimension(20, 20));
				GridBagConstraints gbc_rigidArea_3 = new GridBagConstraints();
				gbc_rigidArea_3.gridx = 3;
				gbc_rigidArea_3.gridy = 8;
				formMember.add(rigidArea_3, gbc_rigidArea_3);
		content.add(formOuterPanel);
		
		verticalStrut_3 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_3 = new GridBagConstraints();
		gbc_verticalStrut_3.insets = new Insets(0, 0, 0, 5);
		gbc_verticalStrut_3.gridx = 1;
		gbc_verticalStrut_3.gridy = 4;
		formOuterPanel.add(verticalStrut_3, gbc_verticalStrut_3);
		this.add(content,BorderLayout.CENTER);
		this.loadFormValues();
	}
	
	private void loadFooterButtons() {
		
		buttons = new JPanel();
		buttons.setBackground(new Color(100, 149, 237));
		
		buttons.setLayout(new FlowLayout(FlowLayout.TRAILING));
		//this.setBorder(new LineBorder(Color.BLACK));
		btnReturn = new JButton("Return");
		btnReturn.setBorder(null);
		btnReturn.setBackground(new Color(255, 250, 250));
		btnCancel = new JButton("Cancel");
		btnCancel.setBorder(null);
		btnCancel.setBackground(new Color(255, 250, 250));
		
		btnReturn.setPreferredSize(new Dimension(100,30)); // button size here
		btnReturn.setFont(new Font("Lucida Sans", Font.PLAIN, 15));
		
		btnCancel.setPreferredSize(new Dimension(80,30)); // button size here
		btnCancel.setFont(new Font("Lucida Sans", Font.PLAIN, 15));
		
		btnReturn.addActionListener(new ReturnBkTransactFormPopUpHandler());
		btnCancel.addActionListener(new ReturnBkTransactFormPopUpHandler());
		btnReturn.addMouseListener(new MouseHandler());
		btnCancel.addMouseListener(new MouseHandler());
		
		buttons.add(btnReturn);
		buttons.add(Box.createRigidArea(new Dimension(20,0)));
		buttons.add(btnCancel);
		buttons.add(Box.createRigidArea(new Dimension(10,0)));
		
		this.add(buttons,BorderLayout.PAGE_END);
	}
	
	private void loadFormValues() {
		this.formBookValues = this.controller.getBookFormValues(cellValues);
		
		txttitle.setText("<html><p style=\"width:200px\">"+(String) formBookValues.get("BookTitle")+"</p></html>");
		txtauthor.setText(formBookValues.get("BookAuthor"));
		txtwriter.setText(formBookValues.get("BookWriter"));
		txtpublisher.setText(formBookValues.get("BookPublisher"));
		txtisbn.setText(formBookValues.get("BookISBN"));
		cbxtype.setText(formBookValues.get("BookType"));
		pic.setImg(formBookValues.get("BookImg").toString());
		cbxgenre.setText(formBookValues.get("BookGenre"));
		txtquantity.setText((String)cellValues.get("OrderCount").toString());
		
		this.formMemberValues = this.controller.getMemberFormValues(cellValues);
		
		txtfirstname.setText(formMemberValues.get("FirstName"));
		txtmiddlename.setText(formMemberValues.get("MiddleName"));
		txtlastname.setText(formMemberValues.get("LastName"));
		txtbirthdate.setText(formMemberValues.get("BirthDate"));
		txtaddress.setText(formMemberValues.get("Address"));
		txtemail.setText(formMemberValues.get("Email"));
		txtcontactno.setText(formMemberValues.get("ContactNo"));
		
	}
	
	
	private class ReturnBkTransactFormPopUpHandler implements ActionListener{
		JFrame parent = (JFrame) SwingUtilities.getWindowAncestor(parentPanel);
		@Override
		public void actionPerformed(ActionEvent evt) {
			ReturnBkTableCard returnBookTablePane = new ReturnBkTableCard(parentPanel);
			parentPanel.add(returnBookTablePane, "RETURNBOOK");
			
			switch (evt.getActionCommand()) {
			case "<":
				parentLayout.show(parentPanel, "RETURNBOOK");
				break;
			case "Cancel":
				parentLayout.show(parentPanel, "RETURNBOOK");
				break;
			case "Return":
				
				if (ConfirmDialog.getResult(parent, "Return Book:<br>Confirm book quantity?")) {
					cellValues.put("ReturnCount", txtquantity.getText());
					if(controller.returnBook(cellValues, txtquantity)) {
						MessageDialog.showDialog(parent, "Book returned successfully!", "Success");
						header.btnBack.doClick();
					}else {
						ErrorDialog.showErrorDialog(parent, controller.getErrorMsg());
					}
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
