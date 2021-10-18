package model;

import java.awt.Component;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ImgModel {
	
	private ImageIcon image;
	private Image scaledImg;
	private JFileChooser chooser;
	private FileNameExtensionFilter filter;
	private JLabel viewLabel;
	private Component parent;
	private File inputFile;
	private InputStream is;
	private OutputStream os;
	private String srcName = "";
	
	public ImgModel(JLabel prmParent, String name) {
		this.loadChooser();
		
		this.viewLabel = prmParent;
		this.parent = (JLabel) prmParent.getParent();
		this.inputFile = new File("resource/"+name+".png");
		try {
			if(inputFile.exists()) {
				image = new ImageIcon(inputFile.getPath());
			}else {
				this.inputFile = new File("resource/error.png");
				image = new ImageIcon(inputFile.getPath());
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		srcName = name;
		viewLabel.setIcon(image);
	}
	
	private void loadChooser() {
		this.chooser = new JFileChooser();
		this.filter = new FileNameExtensionFilter("Image files", ".jpg", ".svg", ".png");
		this.chooser.setFileFilter(filter);
	}
	
	public String getImgName() {
		return srcName;
	}
	
	public void setImg(String prmName) {
		image = new ImageIcon("images/"+prmName+"");
		scaledImg = (image.getImage()).getScaledInstance(460, 544, Image.SCALE_DEFAULT);
		image = new ImageIcon(scaledImg);
		viewLabel.setIcon(image);
		srcName = prmName;
	}
	
	public void setTransactImg(String prmName) {
		image = new ImageIcon("images/"+prmName+"");
		scaledImg = (image.getImage()).getScaledInstance(100, 119, Image.SCALE_DEFAULT);
		image = new ImageIcon(scaledImg);
		
		viewLabel.setIcon(image);
		srcName = prmName;
	}
	
	public void showFileChooser() throws IOException {
		int returnVal = chooser.showOpenDialog(parent);
		String srcPath = "";
		String srcName = "";
		
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			srcPath = (chooser.getSelectedFile().getPath());
			srcName = chooser.getSelectedFile().getName();
			
			while(srcName.length() > 45) {
				System.out.println("Filename too long.");
				returnVal = chooser.showOpenDialog(parent);
				srcPath = (chooser.getSelectedFile().getPath());
				srcName = chooser.getSelectedFile().getName();
			}
			
			this.inputFile = new File(srcPath);
			srcName = inputFile.getName();
			
			this.copyImageFile(inputFile, (new File("images/"+srcName+"")));
			this.setImg(srcName);
		}else {
			// causes performance drop when chooser is canceled
			// fixed with System.gc();
			System.gc();
		}
		
	}
	
	private void copyImageFile(File src, File dst) {
		try {
			is = new FileInputStream(src);
			os = new FileOutputStream(dst);
			byte[] buffer = new byte[250];
			int length;
			while ((length = is.read(buffer)) > 0) {
				os.write(buffer, 0, length);
			}
			is.close();
			os.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
