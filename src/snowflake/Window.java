package snowflake;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Window {
	public static void createWindow() {
		JFrame frame = new JFrame("Snowflakes");
		frame.setPreferredSize(new Dimension(800, 800));
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - 800) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - 800) / 2);
		frame.setVisible(true);

		
		JPanel content = new JPanel();
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc= new GridBagConstraints();
		frame.setLayout(gbl);
		
		JTextField spokesin = new JTextField(3);
		JLabel label = new JLabel("Number of Spokes:");
		JButton submit = new JButton("submit");
		
		submit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				SnowflakeDrawer.drawSnowflake(Integer.parseInt(spokesin.getText()));
				
			}
		});
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		content.add(label);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		content.add(spokesin);
		
		gbc.gridx = 2;
		gbc.gridy = 1;
		content.add(submit);
		
		frame.add(content);
		
		frame.pack();
		
	}
	
	
	
}
