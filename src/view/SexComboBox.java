package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

import controller.SexController;

public class SexComboBox<String> extends JComboBox {
	
	private SexController controller;
	private Border matteBorder;
	
	public SexComboBox(Object[] paramItems) {
		super(paramItems);
		controller = new SexController(this);
		this.initDesign();
		
	}
	
	public SexComboBox() {
		controller = new SexController(this);
		this.initDesign();
	}
	
	private void initDesign() {
		super.setUI(new CustomComboBoxScroller(this));
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
		BasicComboBoxRenderer renderer = (BasicComboBoxRenderer) this.getRenderer();
		renderer.setToolTipText((java.lang.String) paramTxt);
	}
	
	public void setEnable(boolean paramB) {
		this.setEnable(paramB);
	}
	
	public boolean valid() {
		return controller.isValid();
	}
	
	
}


