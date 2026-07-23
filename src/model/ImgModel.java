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
	private String srcName = "";
	
	public ImgModel(JLabel prmParent, String name) {
		this.loadChooser();
		
		this.viewLabel = prmParent;
		this.parent = (JLabel) prmParent.getParent();
		this.inputFile = new File("resource", name+".png");
		try {
			if(inputFile.exists()) {
				image = new ImageIcon(inputFile.getPath());
			}else {
				this.inputFile = new File("resource", "error.png");
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
		// Extensions must NOT have a leading dot — that was the bug preventing images from appearing
		this.filter = new FileNameExtensionFilter("Image files", "jpg", "jpeg", "png", "gif", "bmp");
		this.chooser.setFileFilter(filter);
		// Also allow "All Files" as a fallback
		this.chooser.setAcceptAllFileFilterUsed(true);
	}
	
	public String getImgName() {
		return srcName;
	}
	
	public void setImg(String prmName) {
		File imgFile = new File("images", prmName);
		if (!imgFile.exists()) {
			System.out.println("Image not found: " + imgFile.getAbsolutePath());
			imgFile = new File("resource/error.png");
		}
		image = new ImageIcon(imgFile.getAbsolutePath());
		int w = image.getIconWidth();
		int h = image.getIconHeight();
		if (w > 0 && h > 0) {
			scaledImg = image.getImage().getScaledInstance(460, 544, Image.SCALE_SMOOTH);
			image = new ImageIcon(scaledImg);
		}
		viewLabel.setIcon(image);
		srcName = prmName;
	}
	
	public void setTransactImg(String prmName) {
		File imgFile = new File("images", prmName);
		if (!imgFile.exists()) {
			System.out.println("Image not found: " + imgFile.getAbsolutePath());
			imgFile = new File("resource/error(100px,119px).png");
		}
		image = new ImageIcon(imgFile.getAbsolutePath());
		int w = image.getIconWidth();
		int h = image.getIconHeight();
		if (w > 0 && h > 0) {
			scaledImg = image.getImage().getScaledInstance(100, 119, Image.SCALE_SMOOTH);
			image = new ImageIcon(scaledImg);
		}
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
			
			File destFile = new File("images", srcName);
			this.copyImageFile(inputFile, destFile);
			this.setImg(srcName);
		}else {
			// causes performance drop when chooser is canceled
			// fixed with System.gc();
			System.gc();
		}
		
	}
	
	private void copyImageFile(File src, File dst) {
		try {
			// Resolve canonical paths to detect if src and dst are the same file
			String srcPath = src.getCanonicalPath();
			String dstPath = dst.getCanonicalPath();
			
			if (srcPath.equals(dstPath)) {
				System.out.println("Source and destination are the same file — skipping copy: " + srcPath);
				return;
			}
			
			// Ensure the images directory exists
			dst.getParentFile().mkdirs();
			
			// Use try-with-resources for guaranteed cleanup
			try (InputStream in = new FileInputStream(src);
			     OutputStream out = new FileOutputStream(dst)) {
				byte[] buffer = new byte[4096];
				int length;
				while ((length = in.read(buffer)) > 0) {
					out.write(buffer, 0, length);
				}
				out.flush();
			}
			System.out.println("Image copied to: " + dst.getAbsolutePath());
		} catch (Exception e) {
			System.err.println("Failed to copy image: " + e.getMessage());
			e.printStackTrace();
		}
	}

}
