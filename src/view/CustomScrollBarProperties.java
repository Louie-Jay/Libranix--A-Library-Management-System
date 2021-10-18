package view;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class CustomScrollBarProperties extends BasicScrollBarUI{
	@Override
	protected JButton createDecreaseButton(int orientation) {
		JButton button = new JButton(""); //super.createDecreaseButton(orientation);
		button.setBackground(new Color(30, 144, 255));
		button.setForeground(new Color(255, 250, 250));
		button.setIcon(new ImageIcon(CustomScrollBarProperties.class.getResource("/res/arrowup_fix.png")));
		return button;
	}

	@Override
	protected JButton createIncreaseButton(int orientation) {
		JButton button = new JButton(""); //super.createIncreaseButton(orientation);
		button.setBackground(new Color(30, 144, 255));
		button.setForeground(new Color(255, 250, 250));
		button.setIcon(new ImageIcon(CustomScrollBarProperties.class.getResource("/res/arrowdown_fix.png")));
		return button;
	}

	@Override
	protected void configureScrollBarColors() {
		this.thumbColor = new Color(30, 144, 255);
		this.trackColor = new Color(255, 250, 250);
		this.thumbDarkShadowColor = new Color(255, 250, 250);
		this.thumbLightShadowColor = new Color(255, 250, 250);
		this.thumbHighlightColor = new Color(255, 250, 250);
	}
	
}
