package Sample;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class PanelD extends JPanel{
	
	Color panelColor = Color.decode("#B7D124");
	
	public PanelD() {
		this.setBackground(panelColor);
		Font lineborderColor = new Font("Serif", Font.BOLD, 24);
		this.setBorder(new TitledBorder(new LineBorder(Color.BLACK),"DDDD", TitledBorder.DEFAULT_POSITION, TitledBorder.DEFAULT_JUSTIFICATION, lineborderColor));
	}
}
