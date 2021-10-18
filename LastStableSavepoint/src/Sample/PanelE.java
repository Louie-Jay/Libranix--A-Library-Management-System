package Sample;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class PanelE extends JPanel implements CustomDesign{
	
	Color panelColor = Color.decode("#E4E4E4");
	JLabel label;
	
	public PanelE() {
		this.setBackground(panelColor);
		Font lineborderColor = new Font("Serif", Font.BOLD, 24);
		this.setBorder(new TitledBorder(new LineBorder(Color.BLACK),"EEEE", TitledBorder.DEFAULT_POSITION, TitledBorder.DEFAULT_JUSTIFICATION, lineborderColor));
		
		
	}
}
