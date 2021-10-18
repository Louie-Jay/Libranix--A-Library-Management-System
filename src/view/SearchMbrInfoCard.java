package view;
import java.awt.BorderLayout;
import java.awt.CardLayout;
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
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;

import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class SearchMbrInfoCard extends JPanel{
	
	//parent properties
	JPanel parentPanel;
	CardLayout parentLayout;
	
	//header
	HeaderPanel header;
	
	//content
	JPanel content;
	
	JPanel picturebox;
	JPanel form;
	
	JLabel lblId;
	JLabel lblFName;
	JLabel lblMName;
	JLabel lblLName;
	JLabel lblSex;
	JLabel lblBDate;
	JLabel lblAddr;
	JLabel lblEmail;
	Img pic;
	JLabel lblCNo;
	
	JLabel txtId;
	JLabel txtFName;
	JLabel txtMName;
	JLabel txtLName;
	JLabel cbxSex;
	JLabel txtBDate;
	JLabel txtAddr;
	JLabel txtEmail;
	JLabel txtCNo;
	
	// footer buttons
	JPanel buttons;
	JButton btnOk;
	
	private LinkedHashMap<String, Object> cellValues;
	private Component verticalStrut;
	private Component verticalStrut_1;
	private Component horizontalStrut;
	private Component horizontalStrut_1;
	private Component verticalStrut_2;
	private Component verticalStrut_3;
	private Component horizontalStrut_2;
	private Component horizontalStrut_3;
	private Component rigidArea;
	private Component rigidArea_1;
	private Component verticalStrut_4;
	private Component verticalStrut_5;
	private Component verticalStrut_6;
	private Component verticalStrut_7;
	private Component verticalStrut_8;
	private Component verticalStrut_9;
	private Component verticalStrut_10;
	private Component verticalStrut_11;
	
	public SearchMbrInfoCard(JPanel parentPnl, LinkedHashMap<String,Object> paramValues) {
		setBackground(new Color(255, 250, 250));
		this.parentPanel = parentPnl;
		this.parentLayout = (CardLayout)parentPnl.getLayout();
		
		this.setLayout(new BorderLayout());
		
		this.cellValues = paramValues;
		loadHeader();
		loadContentForm();
		loadFooterButtons();
		
	}
	
	private void loadHeader() {
		
		header = new HeaderPanel("Member Info", true);
		
		header.setBackActionListener(new InfoViewMemFormPopUpHandler());
		
		this.add(header,BorderLayout.PAGE_START);
		
	}
	
	private void loadContentForm() {
		
		
		JPanel formOuterPanel = new JPanel();
		formOuterPanel.setBackground(new Color(255, 250, 250));
		
		content = new JPanel();
		content.setBackground(new Color(255, 250, 250));
		
		picturebox = new JPanel();
		picturebox.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(0, 0, 0)));
		picturebox.setBackground(new Color(255, 250, 250));
		picturebox.setLayout(new BorderLayout(0, 0));
		//picturebox.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		
		
		pic = new Img("Member");
		picturebox.add(pic);
		
		form = new JPanel();
		form.setBorder(new LineBorder(new Color(100, 149, 237)));
		form.setOpaque(false);
		content.setLayout(new GridLayout(0,2));
		GridBagLayout gbl_form = new GridBagLayout();
		gbl_form.columnWidths = new int[]{0, 183, 183, 0, 0};
		gbl_form.rowHeights = new int[]{0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0};
		gbl_form.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_form.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		form.setLayout(gbl_form);
		
		rigidArea = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea = new GridBagConstraints();
		gbc_rigidArea.insets = new Insets(0, 0, 5, 5);
		gbc_rigidArea.gridx = 0;
		gbc_rigidArea.gridy = 0;
		form.add(rigidArea, gbc_rigidArea);
		
		lblId = new JLabel("ID: ");
		lblId.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
		
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.fill = GridBagConstraints.BOTH;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 1;
		gbc_lblId.gridy = 1;
		form.add(lblId, gbc_lblId);
		
		txtId = new JLabel("N/A");
		txtId.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
		GridBagConstraints gbc_txtId = new GridBagConstraints();
		gbc_txtId.fill = GridBagConstraints.BOTH;
		gbc_txtId.insets = new Insets(0, 0, 5, 5);
		gbc_txtId.gridx = 2;
		gbc_txtId.gridy = 1;
		form.add(txtId, gbc_txtId);
		
		verticalStrut_4 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_4 = new GridBagConstraints();
		gbc_verticalStrut_4.gridwidth = 2;
		gbc_verticalStrut_4.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_4.gridx = 1;
		gbc_verticalStrut_4.gridy = 2;
		form.add(verticalStrut_4, gbc_verticalStrut_4);
		lblFName = new JLabel("First Name: ");
		lblFName.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
		GridBagConstraints gbc_lblFName = new GridBagConstraints();
		gbc_lblFName.fill = GridBagConstraints.BOTH;
		gbc_lblFName.insets = new Insets(0, 0, 5, 5);
		gbc_lblFName.gridx = 1;
		gbc_lblFName.gridy = 3;
		form.add(lblFName, gbc_lblFName);
		txtFName = new JLabel("N/A");
		txtFName.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
		GridBagConstraints gbc_txtFName = new GridBagConstraints();
		gbc_txtFName.fill = GridBagConstraints.BOTH;
		gbc_txtFName.insets = new Insets(0, 0, 5, 5);
		gbc_txtFName.gridx = 2;
		gbc_txtFName.gridy = 3;
		form.add(txtFName, gbc_txtFName);
		
		verticalStrut_5 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_5 = new GridBagConstraints();
		gbc_verticalStrut_5.gridwidth = 2;
		gbc_verticalStrut_5.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_5.gridx = 1;
		gbc_verticalStrut_5.gridy = 4;
		form.add(verticalStrut_5, gbc_verticalStrut_5);
		lblMName = new JLabel("Middle Name: ");
		lblMName.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
		GridBagConstraints gbc_lblMName = new GridBagConstraints();
		gbc_lblMName.fill = GridBagConstraints.BOTH;
		gbc_lblMName.insets = new Insets(0, 0, 5, 5);
		gbc_lblMName.gridx = 1;
		gbc_lblMName.gridy = 5;
		form.add(lblMName, gbc_lblMName);
		txtMName = new JLabel("N/A");
		txtMName.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
		GridBagConstraints gbc_txtMName = new GridBagConstraints();
		gbc_txtMName.fill = GridBagConstraints.BOTH;
		gbc_txtMName.insets = new Insets(0, 0, 5, 5);
		gbc_txtMName.gridx = 2;
		gbc_txtMName.gridy = 5;
		form.add(txtMName, gbc_txtMName);
		
		verticalStrut_6 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_6 = new GridBagConstraints();
		gbc_verticalStrut_6.gridwidth = 2;
		gbc_verticalStrut_6.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_6.gridx = 1;
		gbc_verticalStrut_6.gridy = 6;
		form.add(verticalStrut_6, gbc_verticalStrut_6);
		lblLName = new JLabel("Last Name: ");
		lblLName.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
		GridBagConstraints gbc_lblLName = new GridBagConstraints();
		gbc_lblLName.fill = GridBagConstraints.BOTH;
		gbc_lblLName.insets = new Insets(0, 0, 5, 5);
		gbc_lblLName.gridx = 1;
		gbc_lblLName.gridy = 7;
		form.add(lblLName, gbc_lblLName);
		txtLName = new JLabel("N/A");
		txtLName.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
		GridBagConstraints gbc_txtLName = new GridBagConstraints();
		gbc_txtLName.fill = GridBagConstraints.BOTH;
		gbc_txtLName.insets = new Insets(0, 0, 5, 5);
		gbc_txtLName.gridx = 2;
		gbc_txtLName.gridy = 7;
		form.add(txtLName, gbc_txtLName);
		
		verticalStrut_7 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_7 = new GridBagConstraints();
		gbc_verticalStrut_7.gridwidth = 2;
		gbc_verticalStrut_7.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_7.gridx = 1;
		gbc_verticalStrut_7.gridy = 8;
		form.add(verticalStrut_7, gbc_verticalStrut_7);
		lblSex = new JLabel("Sex: ");
		lblSex.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
		GridBagConstraints gbc_lblSex = new GridBagConstraints();
		gbc_lblSex.fill = GridBagConstraints.BOTH;
		gbc_lblSex.insets = new Insets(0, 0, 5, 5);
		gbc_lblSex.gridx = 1;
		gbc_lblSex.gridy = 9;
		form.add(lblSex, gbc_lblSex);
		cbxSex = new JLabel("N/A");
		cbxSex.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
		GridBagConstraints gbc_cbxSex = new GridBagConstraints();
		gbc_cbxSex.fill = GridBagConstraints.BOTH;
		gbc_cbxSex.insets = new Insets(0, 0, 5, 5);
		gbc_cbxSex.gridx = 2;
		gbc_cbxSex.gridy = 9;
		form.add(cbxSex, gbc_cbxSex);
		
		verticalStrut_8 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_8 = new GridBagConstraints();
		gbc_verticalStrut_8.gridwidth = 2;
		gbc_verticalStrut_8.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_8.gridx = 1;
		gbc_verticalStrut_8.gridy = 10;
		form.add(verticalStrut_8, gbc_verticalStrut_8);
		lblBDate = new JLabel("BirthDate: ");
		lblBDate.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
		GridBagConstraints gbc_lblBDate = new GridBagConstraints();
		gbc_lblBDate.fill = GridBagConstraints.BOTH;
		gbc_lblBDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblBDate.gridx = 1;
		gbc_lblBDate.gridy = 11;
		form.add(lblBDate, gbc_lblBDate);
		txtBDate = new JLabel("N/A");
		txtBDate.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
		GridBagConstraints gbc_txtBDate = new GridBagConstraints();
		gbc_txtBDate.fill = GridBagConstraints.BOTH;
		gbc_txtBDate.insets = new Insets(0, 0, 5, 5);
		gbc_txtBDate.gridx = 2;
		gbc_txtBDate.gridy = 11;
		form.add(txtBDate, gbc_txtBDate);
		
		verticalStrut_9 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_9 = new GridBagConstraints();
		gbc_verticalStrut_9.gridwidth = 2;
		gbc_verticalStrut_9.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_9.gridx = 1;
		gbc_verticalStrut_9.gridy = 12;
		form.add(verticalStrut_9, gbc_verticalStrut_9);
		lblAddr = new JLabel("Address: ");
		lblAddr.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
		GridBagConstraints gbc_lblAddr = new GridBagConstraints();
		gbc_lblAddr.fill = GridBagConstraints.BOTH;
		gbc_lblAddr.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddr.gridx = 1;
		gbc_lblAddr.gridy = 13;
		form.add(lblAddr, gbc_lblAddr);
		txtAddr = new JLabel("N/A");
		txtAddr.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
		GridBagConstraints gbc_txtAddr = new GridBagConstraints();
		gbc_txtAddr.fill = GridBagConstraints.BOTH;
		gbc_txtAddr.insets = new Insets(0, 0, 5, 5);
		gbc_txtAddr.gridx = 2;
		gbc_txtAddr.gridy = 13;
		form.add(txtAddr, gbc_txtAddr);
		
		verticalStrut_10 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_10 = new GridBagConstraints();
		gbc_verticalStrut_10.gridwidth = 2;
		gbc_verticalStrut_10.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_10.gridx = 1;
		gbc_verticalStrut_10.gridy = 14;
		form.add(verticalStrut_10, gbc_verticalStrut_10);
		lblEmail = new JLabel("Email: ");
		lblEmail.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.fill = GridBagConstraints.BOTH;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 1;
		gbc_lblEmail.gridy = 15;
		form.add(lblEmail, gbc_lblEmail); 
		txtEmail = new JLabel("N/A");
		txtEmail.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
		GridBagConstraints gbc_txtEmail = new GridBagConstraints();
		gbc_txtEmail.fill = GridBagConstraints.BOTH;
		gbc_txtEmail.insets = new Insets(0, 0, 5, 5);
		gbc_txtEmail.gridx = 2;
		gbc_txtEmail.gridy = 15;
		form.add(txtEmail, gbc_txtEmail);
		
		verticalStrut_11 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_11 = new GridBagConstraints();
		gbc_verticalStrut_11.gridwidth = 2;
		gbc_verticalStrut_11.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_11.gridx = 1;
		gbc_verticalStrut_11.gridy = 16;
		form.add(verticalStrut_11, gbc_verticalStrut_11);
		lblCNo = new JLabel("Contact Number: ");
		lblCNo.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
		GridBagConstraints gbc_lblCNo = new GridBagConstraints();
		gbc_lblCNo.fill = GridBagConstraints.BOTH;
		gbc_lblCNo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCNo.gridx = 1;
		gbc_lblCNo.gridy = 17;
		form.add(lblCNo, gbc_lblCNo);
		txtCNo = new JLabel("N/A");
		txtCNo.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
		GridBagConstraints gbc_txtCNo = new GridBagConstraints();
		gbc_txtCNo.insets = new Insets(0, 0, 5, 5);
		gbc_txtCNo.fill = GridBagConstraints.BOTH;
		gbc_txtCNo.gridx = 2;
		gbc_txtCNo.gridy = 17;
		form.add(txtCNo, gbc_txtCNo);
		
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
		
		rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_1 = new GridBagConstraints();
		gbc_rigidArea_1.gridx = 3;
		gbc_rigidArea_1.gridy = 18;
		form.add(rigidArea_1, gbc_rigidArea_1);
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
	
	private void loadValues() {
		txtId.setText((String)cellValues.get("ID").toString());
		txtFName.setText((String)cellValues.get("FName").toString());
		txtMName.setText((String)cellValues.get("MName").toString());
		txtLName.setText((String)cellValues.get("LName").toString());
		cbxSex.setText((String)cellValues.get("Sex").toString());
		txtBDate.setText((String)cellValues.get("BDate").toString());
		txtAddr.setText((String)cellValues.get("Address").toString());
		txtEmail.setText((String)cellValues.get("Email").toString());
		pic.setImg(cellValues.get("Img").toString());
		txtCNo.setText((String)cellValues.get("ContactNo").toString());
	}
	
	private void loadFooterButtons() {
		
		buttons = new JPanel();
		buttons.setBackground(new Color(100, 149, 237));
		
		buttons.setLayout(new FlowLayout(FlowLayout.TRAILING));
		//this.setBorder(new LineBorder(Color.BLACK));
		btnOk = new JButton("Ok");
		btnOk.setBackground(new Color(255, 250, 250));
		
		
		btnOk.setPreferredSize(new Dimension(80,30)); // button size here
		btnOk.setFont(new Font("Lucida Sans", Font.PLAIN, 15));
		
		
		btnOk.addActionListener(new InfoViewMemFormPopUpHandler());
		btnOk.addMouseListener(new MouseHandler());
		
		buttons.add(btnOk);
		
		this.add(buttons,BorderLayout.PAGE_END);
	}
	
	
	private class InfoViewMemFormPopUpHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent evt) {

			switch (evt.getActionCommand()) {
			case "<":
				parentLayout.show(parentPanel, "SEARCHMEMBER");
				break;
			case "Cancel":
				parentLayout.show(parentPanel, "SEARCHMEMBER");
				break;
			case "Ok":
				parentLayout.show(parentPanel, "SEARCHMEMBER");
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
			
		}
		
	}

}
