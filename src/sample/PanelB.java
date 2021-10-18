package sample;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class PanelB extends JPanel{
	
	Color panelColor = Color.decode("#FFB55A");
	
	public PanelB() {
		this.setBackground(panelColor);
		Font lineborderColor = new Font("Serif", Font.BOLD, 24);
		this.setBorder(new TitledBorder(new LineBorder(Color.BLACK),"BBBB", TitledBorder.DEFAULT_POSITION, TitledBorder.DEFAULT_JUSTIFICATION, lineborderColor));
	}
}
