package sample;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class PanelC extends JPanel{
	
	Color panelColor = Color.decode("#FF8DABF");
	
	public PanelC() {
		this.setBackground(panelColor);
		Font lineborderColor = new Font("Serif", Font.BOLD, 24);
		this.setBorder(new TitledBorder(new LineBorder(Color.BLACK),"CCCC", TitledBorder.DEFAULT_POSITION, TitledBorder.DEFAULT_JUSTIFICATION, lineborderColor));
	}
}
