import javax.swing.SwingUtilities;

import view.MainWindow;
import view.LoginFrame;

public class MainClass {
	
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				LoginFrame frame = new LoginFrame();
				
				frame.setVisible(true);
			}
		});
		
		
		long endTime = System.nanoTime();
		long totalTime = endTime - startTime;
		double seconds = (double)totalTime / 1_000_000_000.0;
		System.out.println("Took "+(endTime - startTime)+ "ns" + " (" +seconds+ " seconds)");
		 
	}
}
