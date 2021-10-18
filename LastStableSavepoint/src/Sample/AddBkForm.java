package Sample;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddBkForm extends JPanel{

	JPanel picturebox;
	JPanel form;
	
	JLabel lbltitle;
	JLabel lblauthor;
	JLabel lblwriter;
	JLabel lblpublisher;
	JLabel lblgenre;
	JLabel lblquantity;
	
	JTextField txttitle;
	JTextField txtauthor;
	JTextField txtwriter;
	JTextField txtpublisher;
	JComboBox cbxgenre;
	JTextField txtquantity;
	
	String[] testGenreData = {"Horror","Technology","Novel","Science"}; // combobox data here
	
	
	public AddBkForm(){
		picturebox = new JPanel();
		//picturebox.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		
		//Image icon code here (to be replaced)
		ImageIcon image = new ImageIcon("E:\\Eclipse-workspace\\Library Management System\\src\\Book.png");
		JLabel imagelabel = new JLabel(image);
		picturebox.add(imagelabel);
		
		form = new JPanel(new GridLayout(10,2));
		//form.setBorder(BorderFactory.createLineBorder(Color.RED));
		this.setLayout(new GridLayout(0,2));
		
		lbltitle = new JLabel("Title: ");
		lblauthor = new JLabel("Author: ");
		lblwriter = new JLabel("Writer: ");
		lblpublisher = new JLabel("Publisher: ");
		lblgenre = new JLabel("Genre: ");
		lblquantity = new JLabel("Quantity: ");
		
		txttitle = new JTextField("",50);
		txtauthor = new JTextField("",50);
		txtwriter = new JTextField("",50);
		txtpublisher = new JTextField("",50);
		cbxgenre = new JComboBox(testGenreData);
		txtquantity = new JTextField("",50);
		
		
		form.add(lbltitle);
		
		form.add(txttitle);
		
		form.add(lblauthor);
		
		form.add(txtauthor);
		
		form.add(lblwriter);
		
		form.add(txtwriter);
		
		form.add(lblpublisher);
		
		form.add(txtauthor);
		
		form.add(lblwriter);
		
		form.add(txtwriter);
		
		form.add(lblpublisher);
		
		form.add(txtpublisher);
		
		form.add(lblgenre);
		
		form.add(cbxgenre);
		
		form.add(lblquantity);
		
		form.add(txtquantity);
		
		//picturebox part
		//picturebox.add(Box.createRigidArea(new Dimension(30,20)));
		
		this.add(picturebox);
		this.add(form);
		
		
	}
	
}
