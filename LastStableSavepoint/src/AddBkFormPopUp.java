import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class AddBkFormPopUp extends JPanel{
	
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
	
	JTextField txttitle;
	JTextField txtauthor;
	JTextField txtwriter;
	JTextField txtpublisher;
	JTextField txtisbn;
	JComboBox cbxgenre;
	JTextField txtquantity;
	JComboBox cbxcondition;
	JPanel starRating; 
	RatingButton r1;
	RatingButton r2;
	RatingButton r3;
	RatingButton r4;
	RatingButton r5;
	JLabel lblratingcount;
	int rating;
	JComboBox cbxparentalrating;
	
	
	String[] testGenreData = {"Novel","Technology","Horror","Science"}; // combobox data here
	String[] testConditionData = {"New","Good","Fair","Old","Damaged"}; // combobox data here
	String[] testParentalRatingData = {"All ages","Age 2+","Age 5+","Age 8+","Age 10+","Age 13+"};// combobox data here
	
	// footer buttons
	JPanel buttons;
	JButton btnAdd;
	JButton btnCancel;
	
	public AddBkFormPopUp(JPanel parentPnl) {
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
		headertitle = new JLabel("Add Books"); // title here
		headertitle.setFont(new Font("Arial", Font.BOLD, 30));
		headerPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
		headerPanel.add(btnBack);
		headerPanel.add(Box.createRigidArea(new Dimension(50,0)));
		headerPanel.add(headertitle);
		
		btnBack.addActionListener(new AddBkFormHandler());
		
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
		lblparentalrating = new JLabel("P-Rating: ");
		
		txttitle = new JTextField("",20);
		txtauthor = new JTextField("",20);
		txtwriter = new JTextField("",20);
		txtpublisher = new JTextField("",20);
		txtisbn = new JTextField("",20);
		cbxgenre = new JComboBox(testGenreData);
		txtquantity = new JTextField("",20);
		cbxcondition = new JComboBox(testConditionData);
		starRating = new JPanel(new FlowLayout(FlowLayout.LEADING)); // inquiry: you can change the radio Icon selected/unselected
		r1 = new RatingButton("1");
		r2 = new RatingButton("2");
		r3 = new RatingButton("3");
		r4 = new RatingButton("4");
		r5 = new RatingButton("5");
		lblratingcount = new JLabel("0/5");
		cbxparentalrating = new JComboBox(testParentalRatingData);
		
		//r1.setBackground(Color.YELLOW);
		//r1.setOpaque(false);
		
		r1.addActionListener(new RatingButtonListener());
		r2.addActionListener(new RatingButtonListener());
		r3.addActionListener(new RatingButtonListener());
		r4.addActionListener(new RatingButtonListener());
		r5.addActionListener(new RatingButtonListener());
		
		starRating.add(r1);
		starRating.add(r2);
		starRating.add(r3);
		starRating.add(r4);
		starRating.add(r5);
		r1.doClick(); // programmatically clicked here
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
		btnAdd = new JButton("Add");
		btnCancel = new JButton("Cancel");
		
		btnAdd.setPreferredSize(new Dimension(80,30)); // button size here
		btnAdd.setFont(new Font("Arial", Font.PLAIN, 15)); // set font here
		btnAdd.setContentAreaFilled(false);
		
		btnCancel.setPreferredSize(new Dimension(80,30)); // button size here
		btnCancel.setFont(new Font("Arial", Font.PLAIN, 15)); // set font here
		btnCancel.setContentAreaFilled(false);
		
		btnAdd.addActionListener(new AddBkFormHandler());
		btnCancel.addActionListener(new AddBkFormHandler());
		
		buttons.add(btnAdd);
		buttons.add(Box.createRigidArea(new Dimension(20,0)));
		buttons.add(btnCancel);
		buttons.add(Box.createRigidArea(new Dimension(10,0)));
		
		this.add(buttons,BorderLayout.PAGE_END);
	}
	
	private class RatingButtonListener implements ActionListener{
		
		RatingButton source;
		@Override
		public void actionPerformed(ActionEvent evt) {
			source = (RatingButton)evt.getSource();
			
			
			switch (source.getComponentID()) {
			case "1":
				r1.select();
				r2.deselect();
				r3.deselect();
				r4.deselect();
				r5.deselect();
				rating = 1;
				break;
			case "2":
				r1.select();
				r2.select();
				r3.deselect();
				r4.deselect();
				r5.deselect();
				rating = 2;
				break;
			case "3":
				r1.select();
				r2.select();
				r3.select();
				r4.deselect();
				r5.deselect();
				rating = 3;
				break;
			case "4":
				r1.select();
				r2.select();
				r3.select();
				r4.select();
				r5.deselect();
				rating = 4;
				break;
			case "5":
				r1.select();
				r2.select();
				r3.select();
				r4.select();
				r5.select();
				rating = 5;
				break;
			}
			
			lblratingcount.setText(rating+"/5");
			
		}
		
		
	}
	
	private class AddBkFormHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent evt) {

			switch (evt.getActionCommand()) {
			case "<":
				parentLayout.show(parentPanel, "MAIN");
				break;
			case "Cancel":
				parentLayout.show(parentPanel, "MAIN");
				break;
			case "Add":
				System.out.println("Nothing for now...");
				break;

			default:
				break;
			}
			
		}
		
	}

}
