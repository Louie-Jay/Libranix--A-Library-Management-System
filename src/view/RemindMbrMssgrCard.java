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
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import controller.RemindMbrMssgrController;
import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.MatteBorder;
import javax.swing.BoxLayout;

public class RemindMbrMssgrCard extends JPanel{
	
	//parent properties
	JPanel parentPanel;
	CardLayout parentLayout;
	
	//header
	HeaderPanel header;
	
	//content
	JPanel content;
	
	JPanel picturebox;
	JPanel form;
	JEditorPane txtAreaMessage;
	
	JLabel lblFName;
	JLabel lblMName;
	JLabel lblLName;
	JLabel lblSex;
	JLabel lblBDate;
	JLabel lblAddr;
	JLabel lblEmail;
	Img pic;
	JLabel lblCNo;
	JLabel lblBook;
	JLabel lblQuantity;
	
	JLabel txtFName;
	JLabel txtMName;
	JLabel txtLName;
	JLabel cbxSex;
	JLabel txtBDate;
	JLabel txtAddr;
	JLabel txtEmail;
	JLabel txtCNo;
	JLabel txtBook;
	JLabel txtQuantity;
	
	// footer buttons
	JPanel buttons;
	JCheckBox chkSMS;
	JCheckBox chkEmail;
	JButton btnSend;
	JButton btnCancel;
	
	
	private LinkedHashMap<String, Object> cellValues;
	private RemindMbrMssgrController controller;
	private LinkedHashMap<String, JComponent> sendComponents;
	private Component verticalStrut;
	private Component verticalStrut_1;
	private Component horizontalStrut;
	private Component horizontalStrut_1;
	private Component rigidArea;
	private Component rigidArea_1;
	private Component verticalStrut_2;
	private Component verticalStrut_3;
	private Component verticalStrut_4;
	private Component verticalStrut_5;
	private Component verticalStrut_6;
	private Component verticalStrut_7;
	private Component verticalStrut_8;
	private Component verticalStrut_9;
	private Component verticalStrut_10;
	
	public RemindMbrMssgrCard(JPanel parentPnl, LinkedHashMap<String, Object> paramValues) {
		setBackground(new Color(255, 250, 250));
		this.parentPanel = parentPnl;
		this.parentLayout = (CardLayout)parentPnl.getLayout();
		this.setLayout(new BorderLayout());
		this.cellValues = paramValues;
		this.controller = new RemindMbrMssgrController();
		this.sendComponents = new LinkedHashMap<String, JComponent>();
		
		loadHeader();
		loadContentForm();
		loadFooterButtons();
		
	}
	
	private void loadHeader() {
		
		header = new HeaderPanel("Remind Member",true);
		
		header.setBackActionListener(new RemindMemFormCardHandler());
		
		this.add(header,BorderLayout.PAGE_START);
		
	}
	
	private void loadContentForm() {
		
		
		JPanel formOuterPanel = new JPanel();
		formOuterPanel.setBorder(null);
		formOuterPanel.setBackground(new Color(255, 250, 250));
		
		content = new JPanel();
		content.setBackground(new Color(255, 250, 250));
		
		picturebox = new JPanel();
		picturebox.setBackground(new Color(255, 250, 250));
		picturebox.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(0, 0, 0)));
		picturebox.setLayout(new BorderLayout(0, 0));
		//picturebox.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		
		//Image icon code here (to be replaced)
		pic = new Img("Member");
		picturebox.add(pic);
		
		form = new JPanel();
		form.setBackground(new Color(255, 250, 250));
		form.setBorder(new LineBorder(new Color(100, 149, 237)));
		form.setPreferredSize(new Dimension(10, 350));
		form.setMinimumSize(new Dimension(10, 350));
		form.setMaximumSize(new Dimension(32767, 350));
		//form.setBorder(BorderFactory.createLineBorder(Color.RED));
		GridLayout gl_content = new GridLayout(0,2);
		gl_content.setHgap(5);
		content.setLayout(gl_content);
		GridBagLayout gbl_form = new GridBagLayout();
		gbl_form.columnWidths = new int[]{0, 1, 253, 0, 0};
		gbl_form.rowHeights = new int[]{0, 1, 0, 1, 0, 1, 0, 1, 0, 1, -222, 1, 0, 1, 0, 1, 0, 1, 0, 1, -317, 0};
		gbl_form.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_form.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		form.setLayout(gbl_form);
				
				rigidArea = Box.createRigidArea(new Dimension(20, 10));
				GridBagConstraints gbc_rigidArea = new GridBagConstraints();
				gbc_rigidArea.insets = new Insets(0, 0, 5, 5);
				gbc_rigidArea.gridx = 0;
				gbc_rigidArea.gridy = 0;
				form.add(rigidArea, gbc_rigidArea);
		
				lblFName = new JLabel("First Name: ");
				lblFName.setFont(new Font("Lucida Sans", Font.BOLD, 11));
				
				GridBagConstraints gbc_lblFName = new GridBagConstraints();
				gbc_lblFName.fill = GridBagConstraints.BOTH;
				gbc_lblFName.insets = new Insets(0, 0, 5, 5);
				gbc_lblFName.gridx = 1;
				gbc_lblFName.gridy = 1;
				form.add(lblFName, gbc_lblFName);
		
		txtFName = new JLabel("N/A");
		txtFName.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		GridBagConstraints gbc_txtFName = new GridBagConstraints();
		gbc_txtFName.fill = GridBagConstraints.BOTH;
		gbc_txtFName.insets = new Insets(0, 0, 5, 5);
		gbc_txtFName.gridx = 2;
		gbc_txtFName.gridy = 1;
		form.add(txtFName, gbc_txtFName);
		
		verticalStrut_2 = Box.createVerticalStrut(10);
		GridBagConstraints gbc_verticalStrut_2 = new GridBagConstraints();
		gbc_verticalStrut_2.gridwidth = 2;
		gbc_verticalStrut_2.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_2.gridx = 1;
		gbc_verticalStrut_2.gridy = 2;
		form.add(verticalStrut_2, gbc_verticalStrut_2);
		lblMName = new JLabel("Middle Name: ");
		lblMName.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		GridBagConstraints gbc_lblMName = new GridBagConstraints();
		gbc_lblMName.fill = GridBagConstraints.BOTH;
		gbc_lblMName.insets = new Insets(0, 0, 5, 5);
		gbc_lblMName.gridx = 1;
		gbc_lblMName.gridy = 3;
		form.add(lblMName, gbc_lblMName);
		txtMName = new JLabel("N/A");
		txtMName.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		GridBagConstraints gbc_txtMName = new GridBagConstraints();
		gbc_txtMName.fill = GridBagConstraints.BOTH;
		gbc_txtMName.insets = new Insets(0, 0, 5, 5);
		gbc_txtMName.gridx = 2;
		gbc_txtMName.gridy = 3;
		form.add(txtMName, gbc_txtMName);
		
		verticalStrut_3 = Box.createVerticalStrut(10);
		GridBagConstraints gbc_verticalStrut_3 = new GridBagConstraints();
		gbc_verticalStrut_3.gridwidth = 2;
		gbc_verticalStrut_3.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_3.gridx = 1;
		gbc_verticalStrut_3.gridy = 4;
		form.add(verticalStrut_3, gbc_verticalStrut_3);
		lblLName = new JLabel("Last Name: ");
		lblLName.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		GridBagConstraints gbc_lblLName = new GridBagConstraints();
		gbc_lblLName.fill = GridBagConstraints.BOTH;
		gbc_lblLName.insets = new Insets(0, 0, 5, 5);
		gbc_lblLName.gridx = 1;
		gbc_lblLName.gridy = 5;
		form.add(lblLName, gbc_lblLName);
		txtLName = new JLabel("N/A");
		txtLName.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		GridBagConstraints gbc_txtLName = new GridBagConstraints();
		gbc_txtLName.fill = GridBagConstraints.BOTH;
		gbc_txtLName.insets = new Insets(0, 0, 5, 5);
		gbc_txtLName.gridx = 2;
		gbc_txtLName.gridy = 5;
		form.add(txtLName, gbc_txtLName);
		
		verticalStrut_4 = Box.createVerticalStrut(10);
		GridBagConstraints gbc_verticalStrut_4 = new GridBagConstraints();
		gbc_verticalStrut_4.gridwidth = 2;
		gbc_verticalStrut_4.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_4.gridx = 1;
		gbc_verticalStrut_4.gridy = 6;
		form.add(verticalStrut_4, gbc_verticalStrut_4);
		lblAddr = new JLabel("Address: ");
		lblAddr.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		GridBagConstraints gbc_lblAddr = new GridBagConstraints();
		gbc_lblAddr.fill = GridBagConstraints.BOTH;
		gbc_lblAddr.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddr.gridx = 1;
		gbc_lblAddr.gridy = 7;
		form.add(lblAddr, gbc_lblAddr);
		txtAddr = new JLabel("N/A");
		txtAddr.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		GridBagConstraints gbc_txtAddr = new GridBagConstraints();
		gbc_txtAddr.fill = GridBagConstraints.BOTH;
		gbc_txtAddr.insets = new Insets(0, 0, 5, 5);
		gbc_txtAddr.gridx = 2;
		gbc_txtAddr.gridy = 7;
		form.add(txtAddr, gbc_txtAddr);
		
		verticalStrut_5 = Box.createVerticalStrut(10);
		GridBagConstraints gbc_verticalStrut_5 = new GridBagConstraints();
		gbc_verticalStrut_5.gridwidth = 2;
		gbc_verticalStrut_5.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_5.gridx = 1;
		gbc_verticalStrut_5.gridy = 8;
		form.add(verticalStrut_5, gbc_verticalStrut_5);
		lblSex = new JLabel("Sex: ");
		lblSex.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		GridBagConstraints gbc_lblSex = new GridBagConstraints();
		gbc_lblSex.fill = GridBagConstraints.BOTH;
		gbc_lblSex.insets = new Insets(0, 0, 5, 5);
		gbc_lblSex.gridx = 1;
		gbc_lblSex.gridy = 9;
		form.add(lblSex, gbc_lblSex); 
		cbxSex = new JLabel("N/A");
		cbxSex.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		GridBagConstraints gbc_cbxSex = new GridBagConstraints();
		gbc_cbxSex.fill = GridBagConstraints.BOTH;
		gbc_cbxSex.insets = new Insets(0, 0, 5, 5);
		gbc_cbxSex.gridx = 2;
		gbc_cbxSex.gridy = 9;
		form.add(cbxSex, gbc_cbxSex);
		
		verticalStrut_6 = Box.createVerticalStrut(10);
		GridBagConstraints gbc_verticalStrut_6 = new GridBagConstraints();
		gbc_verticalStrut_6.gridwidth = 2;
		gbc_verticalStrut_6.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_6.gridx = 1;
		gbc_verticalStrut_6.gridy = 10;
		form.add(verticalStrut_6, gbc_verticalStrut_6);
		lblBDate = new JLabel("BirthDate: ");
		lblBDate.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		GridBagConstraints gbc_lblBDate = new GridBagConstraints();
		gbc_lblBDate.fill = GridBagConstraints.BOTH;
		gbc_lblBDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblBDate.gridx = 1;
		gbc_lblBDate.gridy = 11;
		form.add(lblBDate, gbc_lblBDate);
		txtBDate = new JLabel("N/A");
		txtBDate.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		GridBagConstraints gbc_txtBDate = new GridBagConstraints();
		gbc_txtBDate.fill = GridBagConstraints.BOTH;
		gbc_txtBDate.insets = new Insets(0, 0, 5, 5);
		gbc_txtBDate.gridx = 2;
		gbc_txtBDate.gridy = 11;
		form.add(txtBDate, gbc_txtBDate);
		
		verticalStrut_7 = Box.createVerticalStrut(10);
		GridBagConstraints gbc_verticalStrut_7 = new GridBagConstraints();
		gbc_verticalStrut_7.gridwidth = 2;
		gbc_verticalStrut_7.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_7.gridx = 1;
		gbc_verticalStrut_7.gridy = 12;
		form.add(verticalStrut_7, gbc_verticalStrut_7);
		lblCNo = new JLabel("Contact Number: ");
		lblCNo.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		GridBagConstraints gbc_lblCNo = new GridBagConstraints();
		gbc_lblCNo.fill = GridBagConstraints.BOTH;
		gbc_lblCNo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCNo.gridx = 1;
		gbc_lblCNo.gridy = 13;
		form.add(lblCNo, gbc_lblCNo); 
		txtCNo = new JLabel("N/A");
		txtCNo.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		GridBagConstraints gbc_txtCNo = new GridBagConstraints();
		gbc_txtCNo.fill = GridBagConstraints.BOTH;
		gbc_txtCNo.insets = new Insets(0, 0, 5, 5);
		gbc_txtCNo.gridx = 2;
		gbc_txtCNo.gridy = 13;
		form.add(txtCNo, gbc_txtCNo);
		
		verticalStrut_8 = Box.createVerticalStrut(10);
		GridBagConstraints gbc_verticalStrut_8 = new GridBagConstraints();
		gbc_verticalStrut_8.gridwidth = 2;
		gbc_verticalStrut_8.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_8.gridx = 1;
		gbc_verticalStrut_8.gridy = 14;
		form.add(verticalStrut_8, gbc_verticalStrut_8);
		lblEmail = new JLabel("Email: ");
		lblEmail.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.fill = GridBagConstraints.BOTH;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 1;
		gbc_lblEmail.gridy = 15;
		form.add(lblEmail, gbc_lblEmail); 
		txtEmail = new JLabel("N/A");
		txtEmail.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		GridBagConstraints gbc_txtEmail = new GridBagConstraints();
		gbc_txtEmail.fill = GridBagConstraints.BOTH;
		gbc_txtEmail.insets = new Insets(0, 0, 5, 5);
		gbc_txtEmail.gridx = 2;
		gbc_txtEmail.gridy = 15;
		form.add(txtEmail, gbc_txtEmail);
		
		verticalStrut_9 = Box.createVerticalStrut(10);
		GridBagConstraints gbc_verticalStrut_9 = new GridBagConstraints();
		gbc_verticalStrut_9.gridwidth = 2;
		gbc_verticalStrut_9.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_9.gridx = 1;
		gbc_verticalStrut_9.gridy = 16;
		form.add(verticalStrut_9, gbc_verticalStrut_9);
		lblBook = new JLabel("Borrowed Book: ");
		lblBook.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		GridBagConstraints gbc_lblBook = new GridBagConstraints();
		gbc_lblBook.fill = GridBagConstraints.BOTH;
		gbc_lblBook.insets = new Insets(0, 0, 5, 5);
		gbc_lblBook.gridx = 1;
		gbc_lblBook.gridy = 17;
		form.add(lblBook, gbc_lblBook); 
		txtBook = new JLabel("N/A");
		txtBook.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		GridBagConstraints gbc_txtBook = new GridBagConstraints();
		gbc_txtBook.fill = GridBagConstraints.BOTH;
		gbc_txtBook.insets = new Insets(0, 0, 5, 5);
		gbc_txtBook.gridx = 2;
		gbc_txtBook.gridy = 17;
		form.add(txtBook, gbc_txtBook);
		
		verticalStrut_10 = Box.createVerticalStrut(10);
		GridBagConstraints gbc_verticalStrut_10 = new GridBagConstraints();
		gbc_verticalStrut_10.gridwidth = 2;
		gbc_verticalStrut_10.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_10.gridx = 1;
		gbc_verticalStrut_10.gridy = 18;
		form.add(verticalStrut_10, gbc_verticalStrut_10);
		lblQuantity = new JLabel("Quantity: ");
		lblQuantity.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		GridBagConstraints gbc_lblQuantity = new GridBagConstraints();
		gbc_lblQuantity.fill = GridBagConstraints.BOTH;
		gbc_lblQuantity.insets = new Insets(0, 0, 5, 5);
		gbc_lblQuantity.gridx = 1;
		gbc_lblQuantity.gridy = 19;
		form.add(lblQuantity, gbc_lblQuantity); 
		txtQuantity = new JLabel("N/A");
		txtQuantity.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		GridBagConstraints gbc_txtQuantity = new GridBagConstraints();
		gbc_txtQuantity.insets = new Insets(0, 0, 5, 5);
		gbc_txtQuantity.fill = GridBagConstraints.BOTH;
		gbc_txtQuantity.gridx = 2;
		gbc_txtQuantity.gridy = 19;
		form.add(txtQuantity, gbc_txtQuantity);
		
		txtAreaMessage = new JEditorPane();
		txtAreaMessage.setPreferredSize(new Dimension(107, 45));
		txtAreaMessage.setMinimumSize(new Dimension(7, 45));
		txtAreaMessage.setMaximumSize(new Dimension(2147483647, 45));
		
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
		formOuterPanel.setLayout(new BoxLayout(formOuterPanel, BoxLayout.Y_AXIS));
		formOuterPanel.add(form);
		
		rigidArea_1 = Box.createRigidArea(new Dimension(20, 10));
		GridBagConstraints gbc_rigidArea_1 = new GridBagConstraints();
		gbc_rigidArea_1.gridx = 3;
		gbc_rigidArea_1.gridy = 20;
		form.add(rigidArea_1, gbc_rigidArea_1);
		formOuterPanel.add(this.loadAreaMessage());
		content.add(formOuterPanel);
		this.add(content,BorderLayout.CENTER);
	}
	
	private void loadValues() {
		int mbrId = (int) cellValues.get("Member ID");
		HashMap<Integer, String> memberValue = controller.getMemberValues(mbrId);
		
		txtFName.setText(memberValue.get(1));
		txtMName.setText(memberValue.get(2));
		txtLName.setText(memberValue.get(3));
		cbxSex.setText(memberValue.get(4));
		txtBDate.setText(memberValue.get(5));
		txtAddr.setText(memberValue.get(6));
		txtEmail.setText(memberValue.get(7));
		pic.setImg(memberValue.get(8));
		txtCNo.setText(memberValue.get(9));
		
		txtBook.setText((String)cellValues.get("Book Title"));
		txtQuantity.setText(String.valueOf(cellValues.get("Quantity")));
	}
	
	private JScrollPane loadAreaMessage() {
		JScrollPane spMessage = new JScrollPane(txtAreaMessage);
		spMessage.setBackground(new Color(255, 250, 250));
		spMessage.setPreferredSize(new Dimension(111, 220));
		spMessage.setMinimumSize(new Dimension(24, 220));
		spMessage.setMaximumSize(new Dimension(32767, 220));
		spMessage.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		txtAreaMessage.setText("Hello "+txtFName.getText()+",\nSorry to interrupt but its time"
				+ " to return the book ("+txtBook.getText()+"). \nPlease return the book to the library thank you.");
		spMessage.setBorder(new TitledBorder(new LineBorder(new Color(100, 149, 237)), "Message:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		return spMessage;
	}
	
	private void loadFooterButtons() {
		
		buttons = new JPanel();
		buttons.setBackground(new Color(100, 149, 237));
		
		buttons.setLayout(new FlowLayout(FlowLayout.TRAILING));
		//this.setBorder(new LineBorder(Color.BLACK));
		chkSMS = new JCheckBox("SMS");
		chkSMS.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		chkSMS.setOpaque(false);
		chkEmail = new JCheckBox("Email");
		chkEmail.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		chkEmail.setOpaque(false);
		btnSend = new JButton("Send");
		btnSend.setBackground(new Color(255, 250, 250));
		btnCancel = new JButton("Cancel");
		btnCancel.setBackground(new Color(255, 250, 250));
		
		sendComponents.put("chkSMS", chkSMS);
		sendComponents.put("chkEmail", chkEmail);
		sendComponents.put("txtMessage", txtAreaMessage);
		sendComponents.put("txtEmail", txtEmail);
		sendComponents.put("txtCNo", txtCNo);
		
		btnSend.setPreferredSize(new Dimension(80,30)); // button size here
		btnSend.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		
		btnCancel.setPreferredSize(new Dimension(80,30)); // button size here
		btnCancel.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		
		btnSend.addActionListener(new RemindMemFormCardHandler());
		btnCancel.addActionListener(new RemindMemFormCardHandler());
		btnSend.addMouseListener(new MouseHandler());
		btnCancel.addMouseListener(new MouseHandler());
		buttons.add(chkSMS);
		buttons.add(chkEmail);
		buttons.add(btnSend);
		buttons.add(btnCancel);
		
		this.add(buttons,BorderLayout.PAGE_END);
	}
	
	
	private class RemindMemFormCardHandler implements ActionListener{
		JFrame parent = (JFrame) SwingUtilities.getWindowAncestor(parentPanel);
		@Override
		public void actionPerformed(ActionEvent evt) {

			switch (evt.getActionCommand()) {
			case "<":
				parentLayout.show(parentPanel, "REMINDVIEWMEMBER");
				break;
			case "Cancel":
				parentLayout.show(parentPanel, "REMINDVIEWMEMBER");
				break;
			case "Send":
				if(ConfirmDialog.getResult(parent, "Send this message?")) {
					if(controller.remindMember(sendComponents)) {
						MessageDialog.showDialog(parent, "Message sent successfully!", "Success");
					}else {
						ErrorDialog.showErrorDialog(parent, "Message sending failed:<br>"+controller.getErrorMsg());
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
			btnSource.setBorder(new LineBorder(new Color(30, 144, 255)));
		}
		
	}

}
