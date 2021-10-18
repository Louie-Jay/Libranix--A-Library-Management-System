package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.plaf.basic.ComboPopup;

public class CustomComboBoxScroller extends BasicComboBoxUI {
	private JComboBox<Object> comboBox;

	public CustomComboBoxScroller(JComboBox<Object> prmComboBox) {
		comboBox = prmComboBox;
	}
	
	@Override 
	protected JButton createArrowButton() {
        return new BasicArrowButton(
            BasicArrowButton.SOUTH,
            new Color(30, 144, 255), new Color(255, 250, 250),
            new Color(255, 250, 250), new Color(255, 250, 250));
    }

	@Override
	protected ComboPopup createPopup() {
		return new BasicComboPopup(comboBox) {
			@Override
			protected JScrollPane createScroller() {
				JScrollPane scroller = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
						JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
				scroller.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
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

					@Override
					public Dimension getPreferredSize(JComponent c) {
						return new Dimension(10, super.getPreferredSize(c).height);
					}
					
					

					private JButton createZeroButton() {
						return new JButton() {
							@Override
							public Dimension getMinimumSize() {
								return new Dimension(new Dimension(0, 0));
							}

							@Override
							public Dimension getPreferredSize() {
								return new Dimension(new Dimension(0, 0));
							}

							@Override
							public Dimension getMaximumSize() {
								return new Dimension(new Dimension(0, 0));
							}
						};
					}
				});
				return scroller;
			}
		};
	}

}
