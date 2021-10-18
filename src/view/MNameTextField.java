package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.border.Border;

import controller.MNameController;

public class MNameTextField extends JTextField {
	
	private MNameController controller;
	private Border matteBorder;
	
	public MNameTextField(String txt, int length) {
		super(txt,length);
		controller = new MNameController(this);
		this.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 13));
	}
	
	public void setValidBorder() {
		this.matteBorder = BorderFactory.createMatteBorder(1, 5, 1, 1, Color.green);
		this.setBorder(matteBorder);
	}
	
	public void setInvalidBorder() {
		this.matteBorder = BorderFactory.createMatteBorder(1, 5, 1, 1, Color.RED);
		this.setBorder(matteBorder);
	}
	
	public void setDefaultBorder() {
		this.matteBorder = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK);
		this.setBorder(matteBorder);
	}
	
	public void setHoverText(String paramTxt) {
		this.setToolTipText(paramTxt);
	}
	
	public boolean valid() {
		return controller.isValid();
	}
	
}


