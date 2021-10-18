package view;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFileChooser;
import javax.swing.JLabel;

import controller.ImgController;

public class Img extends JLabel{
	
	private Component parent;
	private ImgController controller;
	private boolean editable;
	
	public Img(String name) {
		this.parent = this.getParent();
		controller = new ImgController(this,name);
		this.addMouseListener(new Img_Handler());
		this.editable = false;
	}
	
	public void setImg(String prmName) {
		controller.setImg(prmName);
	}
	
	public void setTransactImg(String prmName) {
		controller.setTransactImg(prmName);
	}
	
	public String getImg() {
		return controller.getImgName();
	}
	
	public void setEditable(boolean prmBool) {
		this.editable = prmBool;
	}
	
	private class Img_Handler extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent mEvt) {
			if(editable) {
				controller.showFileChooser();
			}
		}
	}

}
