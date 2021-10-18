import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InfoViewBkFormPopUp extends JPanel{
	
	//parent properties
	JPanel parentPanel;
	CardLayout parentLayout;
	
	//header
	JPanel headerPanel;
	JButton btnBack;
	JLabel headertitle;
	
	//content
	JPanel content;
	
	JPanel picturebox;
	JPanel form;
	
	JLabel lbltitle;
	JLabel lblauthor;
	JLabel lblwriter;
	JLabel lblpublisher;
	JLabel lblisbn;
	JLabel lblgenre;
	JLabel lblquantity;
	JLabel lblcondition;
	JLabel lblrating;
	JLabel lblparentalrating;
	
	JLabel txttitle;
	JLabel txtauthor;
	JLabel txtwriter;
	JLabel txtpublisher;
	JLabel txtisbn;
	JLabel cbxgenre;
	JLabel txtquantity;
	JLabel cbxcondition;
	JPanel starRating;
	JLabel lblratingcount;
	int rating;
	JLabel cbxparentalrating;
	
	
	String[] testGenreData = {"Novel","Technology","Horror","Science"}; // combobox data here
	String[] testConditionData = {"New","Good","Fair","Old","Damaged"}; // combobox data here
	String[] testParentalRatingData = {"All ages","Age 2+","Age 5+","Age 8+","Age 10+","Age 13+"};// combobox data here
	
	// footer buttons
	JPanel buttons;
	JButton btnEdit;
	JButton btnCancel;
	
	public InfoViewBkFormPopUp(JPanel parentPnl) {
		this.parentPanel = parentPnl;
		this.parentLayout = (CardLayout)parentPnl.getLayout();
		
		this.setLayout(new BorderLayout());
		
		loadHeader();
		loadContentForm();
		loadFooterButtons();
		
	}
	
	private void loadHeader() {
		
		headerPanel = new JPanel();
		
		btnBack = new JButton("<");
		btnBack.setPreferredSize(new Dimension(100,60)); // button size here
		btnBack.setFont(new Font("Arial", Font.BOLD, 50)); // set font here
		btnBack.setContentAreaFilled(false);
		headertitle = new JLabel("Book Info"); // title here
		headertitle.setFont(new Font("Arial", Font.BOLD, 30));
		headerPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
		headerPanel.add(btnBack);
		headerPanel.add(Box.createRigidArea(new Dimension(50,0)));
		headerPanel.add(headertitle);
		
		btnBack.addActionListener(new InfoViewBkFormHandler());
		
		this.add(headerPanel,BorderLayout.PAGE_START);
		
	}
	
	private void loadContentForm() {
		
		
		JPanel formOuterPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		content = new JPanel();
		
		picturebox = new JPanel();
		//picturebox.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		
		//Image icon code here (to be replaced)
		ImageIcon image = new ImageIcon("E:\\Eclipse-workspace\\Library Management System\\src\\Book.png");
		JLabel imagelabel = new JLabel(image);
		picturebox.add(imagelabel);
		
		form = new JPanel(new GridLayout(10,2));
		//form.setBorder(BorderFactory.createLineBorder(Color.RED));
		content.setLayout(new GridLayout(0,2));
		
		lbltitle = new JLabel("Title: ");
		lblauthor = new JLabel("Author: ");
		lblwriter = new JLabel("Writer: ");
		lblpublisher = new JLabel("Publisher: ");
		lblisbn = new JLabel("ISBN: ");
		lblgenre = new JLabel("Genre: ");
		lblquantity = new JLabel("Quantity: ");
		lblcondition = new JLabel("Condition: ");
		lblrating = new JLabel("Rating: ");
		lblparentalrating = new JLabel("Parental Rating: ");
		
		txttitle = new JLabel("	N/A");
		txtauthor = new JLabel("	N/A");
		txtwriter = new JLabel("	N/A");
		txtpublisher = new JLabel("	N/A");
		txtisbn = new JLabel("	N/A");
		cbxgenre = new JLabel("	N/A");
		txtquantity = new JLabel("	N/A");
		cbxcondition = new JLabel("	N/A");
		starRating = new JPanel(new FlowLayout(FlowLayout.LEADING)); // inquiry: you can change the radio Icon selected/unselected
		lblratingcount = new JLabel("	N/A");
		cbxparentalrating = new JLabel("	N/A");
		
		//r1.setBackground(Color.YELLOW);
		//r1.setOpaque(false);
		
		starRating.add(lblratingcount);
		
		form.add(lbltitle); form.add(txttitle);
		form.add(lblauthor); form.add(txtauthor);
		form.add(lblwriter); form.add(txtwriter);
		form.add(lblpublisher); form.add(txtpublisher);
		form.add(lblisbn); form.add(txtisbn);
		form.add(lblgenre); form.add(cbxgenre);
		form.add(lblquantity); form.add(txtquantity);
		form.add(lblcondition); form.add(cbxcondition);
		form.add(lblrating); form.add(starRating);
		form.add(lblparentalrating); form.add(cbxparentalrating);
		
		content.add(picturebox);
		formOuterPanel.add(form);
		content.add(formOuterPanel);
		this.add(content,BorderLayout.CENTER);
	}
	
	private void loadFooterButtons() {
		
		buttons = new JPanel();
		
		buttons.setLayout(new FlowLayout(FlowLayout.TRAILING));
		//this.setBorder(new LineBorder(Color.BLACK));
		btnEdit = new JButton("Edit");
		btnCancel = new JButton("Cancel");
		
		btnEdit.setPreferredSize(new Dimension(80,30)); // button size here
		btnEdit.setFont(new Font("Arial", Font.PLAIN, 15)); // set font here
		btnEdit.setContentAreaFilled(false);
		
		btnCancel.setPreferredSize(new Dimension(80,30)); // button size here
		btnCancel.setFont(new Font("Arial", Font.PLAIN, 15)); // set font here
		btnCancel.setContentAreaFilled(false);
		
		btnEdit.addActionListener(new InfoViewBkFormHandler());
		btnCancel.addActionListener(new InfoViewBkFormHandler());
		
		buttons.add(btnEdit);
		buttons.add(Box.createRigidArea(new Dimension(20,0)));
		buttons.add(btnCancel);
		buttons.add(Box.createRigidArea(new Dimension(10,0)));
		
		this.add(buttons,BorderLayout.PAGE_END);
	}
	
	
	private class InfoViewBkFormHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent evt) {

			switch (evt.getActionCommand()) {
			case "<":
				parentLayout.show(parentPanel, "VIEWBOOK");
				break;
			case "Cancel":
				parentLayout.show(parentPanel, "VIEWBOOK");
				break;
			case "Edit":
				parentLayout.show(parentPanel, "EDITBOOK");
				break;

			default:
				break;
			}
			
		}
		
	}

}
