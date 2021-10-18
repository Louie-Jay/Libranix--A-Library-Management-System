package Sample;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class PanelA extends JPanel{
	
	Color panelColor = Color.decode("#FF5345");
	
	public PanelA() {
		this.setBackground(panelColor);
		Font lineborderColor = new Font("Arial", Font.BOLD, 24);
		this.setBorder(new TitledBorder(new LineBorder(Color.BLACK),"AAAA", TitledBorder.DEFAULT_POSITION, TitledBorder.DEFAULT_JUSTIFICATION, lineborderColor));
	}
}
