package Project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MenuWindow {
	static String firstText = "Battle";
	static String secondText = "Simulator";
	static String descText = "<html>Engage in a 1v1 battle with a strange foe<br>and prove you're really what it takes!</html>";
	static String buttonMessage = "START";

	private JFrame frmRpgBattleSimulator;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuWindow window = new MenuWindow();
					window.frmRpgBattleSimulator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenuWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		SimulationWindow.setPlayerHP(250);
		SimulationWindow.setPlayerMP(70);
		frmRpgBattleSimulator = new JFrame();
		frmRpgBattleSimulator.setTitle("Battle Simulator: Menu");
		frmRpgBattleSimulator.getContentPane().setBackground(Color.BLACK);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\bryan\\eclipse-workspace\\BattleSimulator\\assets\\Sword.PNG"));
		
		JLabel lblNewLabel_1 = new JLabel(firstText);
		lblNewLabel_1.setFont(new Font("Monotype Corsiva", Font.BOLD, 63));
		lblNewLabel_1.setForeground(new Color(255, 51, 102));
		
		JLabel lblNewLabel_1_1 = new JLabel(secondText);
		lblNewLabel_1_1.setForeground(new Color(255, 51, 102));
		lblNewLabel_1_1.setFont(new Font("Monotype Corsiva", Font.BOLD, 53));
		
		JLabel lblNewLabel_3 = new JLabel(descText, SwingConstants.CENTER);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("OCR A Extended", Font.PLAIN, 21));
		lblNewLabel_3.setForeground(SystemColor.menu);
		
		JButton btnNewButton = new JButton(buttonMessage);
		
		btnNewButton.addActionListener(new ActionListener( ) {
			public void actionPerformed(ActionEvent arg0) {
				frmRpgBattleSimulator.dispose();
				SimulationWindow.main(null);
			}
		});
		
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(102, 204, 255));
		btnNewButton.setFont(new Font("MS Gothic", Font.BOLD, 27));
		GroupLayout groupLayout = new GroupLayout(frmRpgBattleSimulator.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addContainerGap(40, Short.MAX_VALUE)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 327, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)
											.addGap(34))))
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addGap(51)
									.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
									.addGap(147)))
							.addGap(6))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
							.addGap(87)))
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
					.addGap(41))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(0, 0, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
							.addGap(26)
							.addComponent(lblNewLabel_3)
							.addGap(34)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
							.addGap(18))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(33)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 366, GroupLayout.PREFERRED_SIZE)))
					.addGap(37))
		);
		frmRpgBattleSimulator.getContentPane().setLayout(groupLayout);
		frmRpgBattleSimulator.setBounds(100, 100, 666, 476);
		frmRpgBattleSimulator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public String getFirstText() {
		return firstText;
	}

	public static void setFirstText(String firstText) {
		MenuWindow.firstText = firstText;
	}

	public String getSecondText() {
		return secondText;
	}

	public static void setSecondText(String secondText) {
		MenuWindow.secondText = secondText;
	}

	public String getDescText() {
		return descText;
	}

	public static void setDescText(String descText) {
		MenuWindow.descText = descText;
	}

	public String getButtonMessage() {
		return buttonMessage;
	}

	public static void setButtonMessage(String buttonMessage) {
		MenuWindow.buttonMessage = buttonMessage;
	}
	
}
