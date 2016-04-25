import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class PlafExample extends JFrame {

	private void addComponents() {
		JPanel panel = new JPanel();
		
		UIManager.LookAndFeelInfo[] laf = UIManager.getInstalledLookAndFeels();
		
		for (UIManager.LookAndFeelInfo info : laf) {
			String name = info.getName();
			final String className = info.getClassName();
			
			JButton button = new JButton(name);
			
			class LookAndFeelListener implements ActionListener {
				public void actionPerformed(ActionEvent e) {
					try {
						UIManager.setLookAndFeel(className);
						SwingUtilities.updateComponentTreeUI(getContentPane());
						pack();
					}
					catch (Exception ex) {
						System.err.println(ex);
					}
				}
			}
			button.addActionListener(new LookAndFeelListener());
			panel.add(button);
		}
		
		this.add(panel, BorderLayout.CENTER);
		
		 
	}
}
