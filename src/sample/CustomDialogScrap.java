package sample;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class CustomDialogScrap extends JDialog{
	
	private JPanel mainDialogPanel;
	private JPanel contentPanel;
	private JPanel footerPanel;
	private JFrame parentFrame;
	
	
	public boolean showConfirmDialog(JPanel paramPanel, String paramMsg) {
		parentFrame = (JFrame) SwingUtilities.getWindowAncestor(paramPanel);
		//this.
		
		
		return false;
	}

}
