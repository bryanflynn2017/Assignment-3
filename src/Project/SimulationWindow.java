package Project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JInternalFrame;
import javax.swing.JToolBar;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;
import javax.swing.JToggleButton;

public class SimulationWindow {
	
	static int playerHP = 250;
	static int playerMP = 70;
	static int enemyHP;
	
	private JFrame frmHi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimulationWindow window = new SimulationWindow();
					window.frmHi.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SimulationWindow() {
		enemyGenerator.generate();
		enemyHP = enemyGenerator.getHP();
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHi = new JFrame();
		frmHi.setTitle("Battle Simulator");
		frmHi.setResizable(false);
		frmHi.getContentPane().setBackground(Color.BLACK);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		
		JPanel panel_1 = new JPanel();
		panel_1.setVisible(false);
		
		JProgressBar enemyHPBar = new JProgressBar();
		enemyHPBar.setMaximum(enemyGenerator.getHP());
		enemyHPBar.setValue(enemyGenerator.getHP());
		enemyHPBar.setForeground(Color.RED);
		enemyHPBar.setBackground(new Color(102, 0, 0));
		
		JLabel enemyDisplayName = new JLabel("");
		enemyDisplayName.setText(enemyGenerator.getName());
		enemyDisplayName.setHorizontalAlignment(SwingConstants.CENTER);
		enemyDisplayName.setForeground(Color.WHITE);
		enemyDisplayName.setFont(new Font("MS UI Gothic", Font.PLAIN, 22));
		
		JLabel enemyImage = new JLabel("");
		enemyImage.setHorizontalAlignment(SwingConstants.CENTER);
		enemyImage.setIcon(new ImageIcon("C:\\Users\\bryan\\eclipse-workspace\\BattleSimulator\\assets\\"+enemyGenerator.getName()+".PNG"));
		
		JLabel damageUpdate = new JLabel("");
		damageUpdate.setFont(new Font("MS Gothic", Font.BOLD, 29));
		damageUpdate.setHorizontalAlignment(SwingConstants.CENTER);
		damageUpdate.setForeground(new Color(255, 255, 153));
		
		JLabel playerHitText = new JLabel("");
		playerHitText.setFont(new Font("MS Gothic", Font.BOLD, 24));
		playerHitText.setHorizontalAlignment(SwingConstants.CENTER);
		playerHitText.setForeground(Color.RED);
		
		GroupLayout groupLayout = new GroupLayout(frmHi.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(98)
					.addComponent(playerHitText, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(enemyImage, GroupLayout.PREFERRED_SIZE, 472, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(enemyDisplayName, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(enemyHPBar, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)))
					.addGap(43))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(damageUpdate, GroupLayout.DEFAULT_SIZE, 872, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(16, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(28, Short.MAX_VALUE)
					.addComponent(enemyHPBar, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(enemyDisplayName, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(34)
					.addComponent(damageUpdate, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(playerHitText, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(enemyImage, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
									.addGap(19)))
							.addGap(18))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
							.addGap(10)))
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		JButton btnHeal = new JButton(" HEAL \u2665 (20MP)");
		btnHeal.setBackground(new Color(127, 255, 0));
		btnHeal.setFont(new Font("MS PGothic", Font.BOLD, 15));
		
		JButton btnFire = new JButton(" FIRE \u2668 (30MP)");
		btnFire.setBackground(new Color(255, 51, 51));
		btnFire.setFont(new Font("MS PGothic", Font.BOLD, 15));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(btnHeal, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
						.addComponent(btnFire, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnHeal, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnFire, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addGap(14))
		);
		panel_1.setLayout(gl_panel_1);
		
		JProgressBar playerHPBar = new JProgressBar();
		playerHPBar.setForeground(Color.GREEN);
		playerHPBar.setBackground(new Color(102, 0, 0));
		playerHPBar.setMaximum(250);
		playerHPBar.setValue(playerHP);
		
		JProgressBar playerMagicBar = new JProgressBar();
		playerMagicBar.setMaximum(70);
		playerMagicBar.setValue(playerMP);
		playerMagicBar.setForeground(new Color(0, 0, 255));
		playerMagicBar.setBackground(new Color(102, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Health:");
		lblNewLabel.setFont(new Font("MS UI Gothic", Font.PLAIN, 16));
		lblNewLabel.setForeground(Color.WHITE);
		
		JLabel lblMagic = new JLabel("Magic:");
		lblMagic.setForeground(Color.WHITE);
		lblMagic.setFont(new Font("MS UI Gothic", Font.PLAIN, 16));
		
		JLabel healthRatio = new JLabel(playerHPBar.getValue()+"/"+playerHPBar.getMaximum());
		healthRatio.setHorizontalAlignment(SwingConstants.RIGHT);
		healthRatio.setForeground(Color.WHITE);
		healthRatio.setFont(new Font("MS Gothic", Font.PLAIN, 16));
		
		JLabel magicRatio = new JLabel(playerMagicBar.getValue()+"/"+playerMagicBar.getMaximum());
		magicRatio.setHorizontalAlignment(SwingConstants.RIGHT);
		magicRatio.setForeground(Color.WHITE);
		magicRatio.setFont(new Font("MS Gothic", Font.PLAIN, 16));
		
		JButton btnAttack = new JButton("ATTACK");
		btnAttack.setFont(new Font("MS Gothic", Font.PLAIN, 19));
		
		JButton btnSpells = new JButton("SPELLS");
		btnSpells.setFont(new Font("MS Gothic", Font.PLAIN, 19));
		
		JButton btnCharge = new JButton("CHARGE");
		btnCharge.setSelectedIcon(null);
		btnCharge.setFont(new Font("MS Gothic", Font.PLAIN, 17));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(lblMagic, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(magicRatio, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(healthRatio, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE))
							.addComponent(playerHPBar, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE))
						.addComponent(playerMagicBar, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
					.addComponent(btnCharge, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addComponent(btnAttack, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addComponent(btnSpells, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
					.addGap(31))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(healthRatio, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(playerHPBar, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblMagic, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
								.addComponent(magicRatio, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(playerMagicBar, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnAttack, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnCharge, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnSpells, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(28, Short.MAX_VALUE))
		);
		
		
		btnSpells.addActionListener(new ActionListener( ) {
			public void actionPerformed(ActionEvent arg0) {
				if (panel_1.isVisible() == false) {
					panel_1.setVisible(true);
				}
				else {
					panel_1.setVisible(false);
				}
			}
		});
		
		btnAttack.addActionListener(new ActionListener( ) {
			public void actionPerformed(ActionEvent arg0) {
				if (panel_1.isVisible()) {
					panel_1.setVisible(false);
				}
				btnAttack.setEnabled(false);
				btnSpells.setEnabled(false);
				btnCharge.setEnabled(false);
				
				TurnMaking.process("Attack");
				enemyHPBar.setValue(enemyHP);
				damageUpdate.setText("-"+TurnMaking.getAttackRNG());
				new Thread() {
			        int counter = 2;
			        public void run() {
			            while(counter >= 1) {
			                System.out.println((counter--));
			                try{
			                    Thread.sleep(1000);
			                    damageUpdate.setText("");
			                } catch(Exception e) {}
			            }
			            counter = 2;
			            if (enemyHP <= 0) {
			            	MenuWindow.setFirstText("YOU");
			            	MenuWindow.setSecondText("WIN!");
			            	MenuWindow.setDescText("<html>Congratulations!<br>You defeated your foe. Fight a new enemy?</html>");
			            	MenuWindow.setButtonMessage("NEW GAME");
			            	frmHi.dispose();
							MenuWindow.main(null);
			            }
			            damageUpdate.setForeground(Color.RED);
			            damageUpdate.setText(TurnMaking.enemyTurnMessage());
			            while(counter >= 1) {
			                System.out.println((counter--));
			                try{
			                    Thread.sleep(1000);
			                } catch(Exception e) {}
			            }
			            counter = 1;
			            if (TurnMaking.isSpecialAttack()) {
			            	counter++;
			            	String spc = TurnMaking.generateSpecial();
			            	damageUpdate.setText(enemyGenerator.getName() + " " + spc + "!");
			            	if (spc == "healed") {
			        			enemyHPBar.setValue(enemyHP + 30);
			        		}
			        		if (spc == "grew stronger") {
			        			TurnMaking.enemyBoost = TurnMaking.enemyBoost + 10;
			        		}
			        		if (spc == "stole MP") {
			        			TurnMaking.absorb();
			        			playerMagicBar.setValue(playerMP);
			        			playerHitText.setForeground(Color.BLUE);
			        			playerHitText.setText("-15");
			        			if (playerMagicBar.getValue() < 0) {
			        				magicRatio.setText("0/70");
			        			}
			        			else {
			        			magicRatio.setText(playerMagicBar.getValue()+"/70");
			        			}
			        		}
			            }
			            else {
				            int hit = TurnMaking.enemyTurn();
				            playerHitText.setText("-"+String.valueOf(hit));
				            damageUpdate.setText("");
			            }
			            damageUpdate.setForeground(new Color(255, 255, 153));
			            if (playerHP <= 0) {
			            	MenuWindow.setFirstText("Game");
			            	MenuWindow.setSecondText("Over!");
			            	MenuWindow.setDescText("<html>You died!<br>But you still have another chance. Fight a new enemy?</html>");
			            	MenuWindow.setButtonMessage("RETRY");
			            	frmHi.dispose();
							MenuWindow.main(null);
			            }
			            healthRatio.setText(String.valueOf(playerHP)+"/250");
			            playerHPBar.setValue(playerHP);
			            while(counter >= 1) {
			                System.out.println((counter--));
			                try{
			                    Thread.sleep(1000);
			                } catch(Exception e) {}
			            }
			            playerHitText.setForeground(Color.RED);
			            playerHitText.setText("");
			            damageUpdate.setText("");
			            btnAttack.setEnabled(true);
						btnSpells.setEnabled(true);
						btnCharge.setEnabled(true);
			        }
			    }.start();
			}
		});
		
		btnCharge.addActionListener(new ActionListener( ) {
			public void actionPerformed(ActionEvent arg0) {
				if (panel_1.isVisible()) {
					panel_1.setVisible(false);
				}
				btnAttack.setEnabled(false);
				btnSpells.setEnabled(false);
				btnCharge.setEnabled(false);
				TurnMaking.process("Charge");
				playerMagicBar.setValue(playerMP);
				magicRatio.setText(playerMagicBar.getValue()+"/70");
				damageUpdate.setForeground(Color.MAGENTA);
				damageUpdate.setText("Gained Strength + Magic!");
				playerHitText.setForeground(Color.BLUE);
    			playerHitText.setText("+15");
    			new Thread() {
			        int counter = 2;
			        public void run() {
			            while(counter >= 1) {
			                System.out.println((counter--));
			                try{
			                    Thread.sleep(1000);
			                } catch(Exception e) {}
			            }
			            damageUpdate.setText("");
			            counter = 2;
			            playerHitText.setText("");
			            playerHitText.setForeground(Color.RED);
			            damageUpdate.setForeground(Color.RED);
			            damageUpdate.setText(TurnMaking.enemyTurnMessage());
			            while(counter >= 1) {
			                System.out.println((counter--));
			                try{
			                    Thread.sleep(1000);
			                } catch(Exception e) {}
			            }
			            counter = 1;
			            if (TurnMaking.isSpecialAttack()) {
			            	counter++;
			            	String spc = TurnMaking.generateSpecial();
			            	damageUpdate.setText(enemyGenerator.getName() + " " + spc + "!");
			            	if (spc == "healed") {
			        			enemyHPBar.setValue(enemyHP + 30);
			        		}
			        		if (spc == "grew stronger") {
			        			TurnMaking.enemyBoost = TurnMaking.enemyBoost + 10;
			        		}
			        		if (spc == "stole MP") {
			        			TurnMaking.absorb();
			        			playerMagicBar.setValue(playerMP);
			        			playerHitText.setForeground(Color.BLUE);
			        			playerHitText.setText("-15");
			        			if (playerMagicBar.getValue() < 0) {
			        				magicRatio.setText("0/70");
			        			}
			        			else {
			        			magicRatio.setText(playerMagicBar.getValue()+"/70");
			        			}
			        		}
			            }
			            else {
				            int hit = TurnMaking.enemyTurn();
				            playerHitText.setText("-"+String.valueOf(hit));
				            damageUpdate.setText("");
			            }
			            damageUpdate.setForeground(new Color(255, 255, 153));
			            if (playerHP <= 0) {
			            	MenuWindow.setFirstText("Game");
			            	MenuWindow.setSecondText("Over!");
			            	MenuWindow.setDescText("<html>You died!<br>But you still have another chance. Fight a new enemy?</html>");
			            	MenuWindow.setButtonMessage("RETRY");
			            	frmHi.dispose();
							MenuWindow.main(null);
			            }
			            healthRatio.setText(String.valueOf(playerHP)+"/250");
			            playerHPBar.setValue(playerHP);
			            while(counter >= 1) {
			                System.out.println((counter--));
			                try{
			                    Thread.sleep(1000);
			                } catch(Exception e) {}
			            }
			            playerHitText.setForeground(Color.RED);
			            playerHitText.setText("");
			            damageUpdate.setText("");
			            btnAttack.setEnabled(true);
						btnSpells.setEnabled(true);
						btnCharge.setEnabled(true);
			        }
			    }.start();
    			
			}
		});
		
		btnHeal.addActionListener(new ActionListener( ) {
			public void actionPerformed(ActionEvent arg0) {
				if (playerMP < 20) {
					return;
				}
				if (playerHP == 250) {
					return;
				}
				if (panel_1.isVisible() == false) {
					panel_1.setVisible(true);
				}
				else {
					panel_1.setVisible(false);
				}
				btnAttack.setEnabled(false);
				btnSpells.setEnabled(false);
				btnCharge.setEnabled(false);
				TurnMaking.process("Heal");
				playerHPBar.setValue(playerHP);
				healthRatio.setText(playerHPBar.getValue()+"/250");
				playerMagicBar.setValue(playerMP);
				magicRatio.setText(playerMP+"/70");
				damageUpdate.setForeground(Color.BLUE);
				damageUpdate.setText("Consumed 20 Magic");
				playerHitText.setForeground(Color.GREEN);
    			playerHitText.setText("+"+TurnMaking.getHealRNG());
    			new Thread() {
			        int counter = 2;
			        public void run() {
			            while(counter >= 1) {
			                System.out.println((counter--));
			                try{
			                    Thread.sleep(1000);
			                } catch(Exception e) {}
			            }
			            damageUpdate.setText("");
			            counter = 2;
			            playerHitText.setText("");
			            playerHitText.setForeground(Color.RED);
			            damageUpdate.setForeground(Color.RED);
			            damageUpdate.setText(TurnMaking.enemyTurnMessage());
			            while(counter >= 1) {
			                System.out.println((counter--));
			                try{
			                    Thread.sleep(1000);
			                } catch(Exception e) {}
			            }
			            counter = 1;
			            if (TurnMaking.isSpecialAttack()) {
			            	counter++;
			            	String spc = TurnMaking.generateSpecial();
			            	damageUpdate.setText(enemyGenerator.getName() + " " + spc + "!");
			            	if (spc == "healed") {
			        			enemyHPBar.setValue(enemyHP + 30);
			        		}
			        		if (spc == "grew stronger") {
			        			TurnMaking.enemyBoost = TurnMaking.enemyBoost + 10;
			        		}
			        		if (spc == "stole MP") {
			        			TurnMaking.absorb();
			        			playerMagicBar.setValue(playerMP);
			        			playerHitText.setForeground(Color.BLUE);
			        			playerHitText.setText("-15");
			        			if (playerMagicBar.getValue() < 0) {
			        				magicRatio.setText("0/70");
			        			}
			        			else {
			        			magicRatio.setText(playerMagicBar.getValue()+"/70");
			        			}
			        		}
			            }
			            else {
				            int hit = TurnMaking.enemyTurn();
				            playerHitText.setText("-"+String.valueOf(hit));
				            damageUpdate.setText("");
			            }
			            damageUpdate.setForeground(new Color(255, 255, 153));
			            if (playerHP <= 0) {
			            	MenuWindow.setFirstText("Game");
			            	MenuWindow.setSecondText("Over!");
			            	MenuWindow.setDescText("<html>You died!<br>But you still have another chance. Fight a new enemy?</html>");
			            	MenuWindow.setButtonMessage("RETRY");
			            	frmHi.dispose();
							MenuWindow.main(null);
			            }
			            healthRatio.setText(String.valueOf(playerHP)+"/250");
			            playerHPBar.setValue(playerHP);
			            while(counter >= 1) {
			                System.out.println((counter--));
			                try{
			                    Thread.sleep(1000);
			                } catch(Exception e) {}
			            }
			            playerHitText.setForeground(Color.RED);
			            playerHitText.setText("");
			            damageUpdate.setText("");
			            btnAttack.setEnabled(true);
						btnSpells.setEnabled(true);
						btnCharge.setEnabled(true);
			        }
			    }.start();
			}
		});
		
		btnFire.addActionListener(new ActionListener( ) {
			public void actionPerformed(ActionEvent arg0) {
				if (playerMP < 30) {
					return;
				}
				if (panel_1.isVisible() == false) {
					panel_1.setVisible(true);
				}
				else {
					panel_1.setVisible(false);
				}
				btnAttack.setEnabled(false);
				btnSpells.setEnabled(false);
				btnCharge.setEnabled(false);
				TurnMaking.process("Fire");
				enemyHPBar.setValue(enemyHP);
				playerMagicBar.setValue(playerMP);
				magicRatio.setText(playerMP+"/70");
				damageUpdate.setText("-"+TurnMaking.getFireRNG());
				playerHitText.setForeground(Color.BLUE);
    			playerHitText.setText("-30");
    			new Thread() {
			        int counter = 2;
			        public void run() {
			            while(counter >= 1) {
			                System.out.println((counter--));
			                try{
			                    Thread.sleep(1000);
			                } catch(Exception e) {}
			            }
			            damageUpdate.setText("");
			            if (enemyHP <= 0) {
			            	MenuWindow.setFirstText("YOU");
			            	MenuWindow.setSecondText("WIN!");
			            	MenuWindow.setDescText("<html>Congratulations!<br>You defeated your foe. Fight a new enemy?</html>");
			            	MenuWindow.setButtonMessage("NEW GAME");
			            	frmHi.dispose();
							MenuWindow.main(null);
			            }
			            counter = 2;
			            playerHitText.setText("");
			            playerHitText.setForeground(Color.RED);
			            damageUpdate.setForeground(Color.RED);
			            damageUpdate.setText(TurnMaking.enemyTurnMessage());
			            while(counter >= 1) {
			                System.out.println((counter--));
			                try{
			                    Thread.sleep(1000);
			                } catch(Exception e) {}
			            }
			            counter = 1;
			            if (TurnMaking.isSpecialAttack()) {
			            	counter++;
			            	String spc = TurnMaking.generateSpecial();
			            	damageUpdate.setText(enemyGenerator.getName() + " " + spc + "!");
			            	if (spc == "healed") {
			        			enemyHPBar.setValue(enemyHP + 30);
			        		}
			        		if (spc == "grew stronger") {
			        			TurnMaking.enemyBoost = TurnMaking.enemyBoost + 10;
			        		}
			        		if (spc == "stole MP") {
			        			TurnMaking.absorb();
			        			playerMagicBar.setValue(playerMP);
			        			playerHitText.setForeground(Color.BLUE);
			        			playerHitText.setText("-15");
			        			if (playerMagicBar.getValue() < 0) {
			        				magicRatio.setText("0/70");
			        			}
			        			else {
			        			magicRatio.setText(playerMagicBar.getValue()+"/70");
			        			}
			        		}
			            }
			            else {
				            int hit = TurnMaking.enemyTurn();
				            playerHitText.setText("-"+String.valueOf(hit));
				            damageUpdate.setText("");
			            }
			            damageUpdate.setForeground(new Color(255, 255, 153));
			            if (playerHP <= 0) {
			            	MenuWindow.setFirstText("Game");
			            	MenuWindow.setSecondText("Over!");
			            	MenuWindow.setDescText("<html>You died!<br>But you still have another chance. Fight a new enemy?</html>");
			            	MenuWindow.setButtonMessage("RETRY");
			            	frmHi.dispose();
							MenuWindow.main(null);
			            }
			            healthRatio.setText(String.valueOf(playerHP)+"/250");
			            playerHPBar.setValue(playerHP);
			            while(counter >= 1) {
			                System.out.println((counter--));
			                try{
			                    Thread.sleep(1000);
			                } catch(Exception e) {}
			            }
			            playerHitText.setForeground(Color.RED);
			            playerHitText.setText("");
			            damageUpdate.setText("");
			            btnAttack.setEnabled(true);
						btnSpells.setEnabled(true);
						btnCharge.setEnabled(true);
			        }
			    }.start();
			}
		});
		
		panel.setLayout(gl_panel);
		frmHi.getContentPane().setLayout(groupLayout);
		frmHi.setBounds(100, 100, 900, 600);
		frmHi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	

	public static int getPlayerHP() {
		return playerHP;
	}

	public static void setPlayerHP(int playerHP) {
		SimulationWindow.playerHP = playerHP;
	}

	public static int getPlayerMP() {
		return playerMP;
	}

	public static void setPlayerMP(int playerMP) {
		SimulationWindow.playerMP = playerMP;
	}

	public static int getEnemyHP() {
		return enemyHP;
	}

	public static void setEnemyHP(int enemyHP) {
		SimulationWindow.enemyHP = enemyHP;
	}
}
