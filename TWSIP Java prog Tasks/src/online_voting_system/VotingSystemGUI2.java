package online_voting_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

public class VotingSystemGUI2 {
	static HashMap<String, String> map = new HashMap<>();
	static int A = 0;
	static int B = 0;
	static int C = 0;
	static String out;

	public static void main(String[] args) {
		JFrame f = new JFrame("Online Voting System");
		JPanel p = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		JLabel head = new JLabel("<html><u><font color='blue'>ONLINE VOTING SYSTEM</font></u></html>");
		head.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 54));

		JLabel l1 = new JLabel("Enter name:");
		JLabel l2 = new JLabel("Enter phone no:");
		
		 l1.setFont(new Font("Arial", Font.PLAIN, 30)); 
	        l2.setFont(new Font("Arial", Font.PLAIN, 30)); 

		
		JLabel l3 = new JLabel("<html><u> Vote Here </u></html>");
		l3.setFont(new Font("Arial", Font.BOLD, 24));
		
		JTextField tf1 = new JTextField(40); 
		JTextField tf2 = new JTextField(20); 
		JRadioButton r1 = new JRadioButton("Party A");
		JRadioButton r2 = new JRadioButton("Party B");
		JRadioButton r3 = new JRadioButton("Party C");
		JButton b1 = new JButton("Submit Your Vote");
		JButton b2 = new JButton("Check Results");
		ButtonGroup bg = new ButtonGroup();

		p.add(head, gbc);
		gbc.gridy = 1;
		gbc.insets = new Insets(10, 0, 0, 0);
		p.add(l1, gbc);
		gbc.gridy = 2;
		p.add(tf1, gbc);
		gbc.gridy = 3;
		p.add(l2, gbc);
		gbc.gridy = 4;
		p.add(tf2, gbc);
		gbc.gridy = 5;
		p.add(l3, gbc);

		JPanel radioPanel = new JPanel(new GridLayout(3, 1));
		radioPanel.add(r1);
		radioPanel.add(r2);
		radioPanel.add(r3);

		gbc.gridy = 6;
		p.add(radioPanel, gbc);

		gbc.gridy = 7;
		gbc.insets = new Insets(20, 0, 0, 0);
		p.add(b1, gbc);
		gbc.gridy = 8;
		p.add(b2, gbc);

		bg.add(r1);
		bg.add(r2);
		bg.add(r3);

		b1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String s1 = tf1.getText();
				String s2 = tf2.getText();
				if (s1.isEmpty()) {
					JOptionPane.showMessageDialog(f, "Please Enter name");
				} else if (s2.isEmpty()) {
					JOptionPane.showMessageDialog(f, "Please Enter phone no");
				} else if (map.containsKey(s1) || map.containsValue(s2)) {
					JOptionPane.showMessageDialog(f, "You have already voted!!");
				} else {
					int i = JOptionPane.showConfirmDialog(f, "Do you want to confirm your vote?");
					if (i == 0) {
						if (r1.isSelected()) {
							A += 1;
						} else if (r2.isSelected()) {
							B += 1;
						} else if (r3.isSelected()) {
							C += 1;
						}
						map.put(s1, s2);
						tf1.setText("");
						tf2.setText("");
						bg.clearSelection();
					}
				}
			}
		});

		b2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (A > B && A > C) {
					out = "Party A wins";
				} else if (B > A && B > C) {
					out = "Party B wins";
				} else if (C > A && C > B) {
					out = "Party C wins";
				} else {
					out = "No party wins";
				}
				JOptionPane.showMessageDialog(f, "Party A gets " + A + " votes\nParty B gets " + B
						+ " votes\nParty C gets " + C + "votes\n\n" + out);
			}
		});

		f.add(p);
		f.setPreferredSize(new Dimension(800, 600));
		f.pack();
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
