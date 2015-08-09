import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.json.JSONException;


public class LeagueOfLegendsGUI {

//	Variables for Layout
	private static JFrame frame;
	private JPanel container, form, gameMode;
	private static JPanel statInfo;
	private JLabel sumName;
	private static JLabel gameType;
	private JTextField summonerName1, summonerName2;
	private JButton button;
	private JComboBox gameTypeBox;
	private String[] gameTypes = { "RankedSolo5x5", "Unranked" };
	
//	Initializes the GUI
	public LeagueOfLegendsGUI(){
		frame  = new JFrame("Summoner Comparison");
		frame.setSize(1000, 680);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon icon = new ImageIcon("leagueicon.png");
		frame.setIconImage(icon.getImage());
		
		
		container = new JPanel(new GridLayout(4,0));
		container.setBackground(Color.gray);
		
		sumName = new JLabel("Summoner Names: ");
		gameType = new JLabel();
		summonerName1 = new JTextField();
		summonerName2 = new JTextField();
		summonerName1.setPreferredSize(new Dimension(120, 20));
		summonerName2.setPreferredSize(new Dimension(120, 20));
		
		gameTypeBox = new JComboBox(gameTypes);
		gameTypeBox.setSelectedIndex(0);
		button = new JButton("Search");
		button.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if(!summonerName1.getText().isEmpty() && !summonerName2.getText().isEmpty()){
						CallApi.sumStats(summonerName1.getText(), summonerName2.getText(), gameTypeBox.getSelectedItem().toString());
					}	
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (JSONException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		
		
		frame.add(container);
		form = new JPanel();
		form.setBackground(Color.gray);
		form.add(sumName);
		form.add(summonerName1);
		form.add(summonerName2);
		form.add(gameTypeBox);
		form.add(button);
//		form.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		container.add(form);
		
		container.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		gameMode = new JPanel();
		gameMode.setBackground(Color.gray);
		gameMode.add(gameType);
		gameMode.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		container.add(gameTypeBox);
		container.setPreferredSize(new Dimension(300, 200));
		container.add(gameMode);
		statInfo = new JPanel(new GridLayout(3,3));
		statInfo.setBackground(Color.gray);
//		statInfo.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		container.add(statInfo);
		summonerName1.requestFocus();
		frame.setVisible(true);
		frame.getRootPane().setDefaultButton(button);
		
	}
	
	public static void setStats(SummonerStats stats1, SummonerStats stats2){
		statInfo.removeAll();
		JLabel champs1 = new JLabel(stats1.getSummonerName() + "'s Total Champions Killed: " + stats1.getTotalChampionKills(), JLabel.CENTER);
		JLabel minions1 = new JLabel(stats1.getSummonerName() + "'s Total Minions Killed: " + stats1.getTotalMinionkills(), JLabel.CENTER);
		JLabel assists1 = new JLabel(stats1.getSummonerName() + "'s Total Assists: " + stats1.getTotalAssists(), JLabel.CENTER);
		
		
		champs1.setForeground(new Color(119f/255,217f/255,187f/255));
		minions1.setForeground(new Color(119f/255,217f/255,187f/255));
		assists1.setForeground(new Color(119f/255,217f/255,187f/255));
		
		champs1.setHorizontalTextPosition(JLabel.CENTER);
		minions1.setHorizontalTextPosition(JLabel.CENTER);
		assists1.setHorizontalTextPosition(JLabel.CENTER);
		
		champs1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		minions1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		assists1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		
		JLabel champs2 = new JLabel(stats2.getSummonerName() + "'s Total Champions Killed: " + stats2.getTotalChampionKills(), JLabel.CENTER);
		JLabel minions2 = new JLabel(stats2.getSummonerName() + "'s Total Minions Killed: " + stats2.getTotalMinionkills(), JLabel.CENTER);
		JLabel assists2 = new JLabel(stats2.getSummonerName() + "'s Total Assists: " + stats2.getTotalAssists(), JLabel.CENTER);
		
		champs2.setForeground(new Color(119f/255,217f/255,187f/255));
		minions2.setForeground(new Color(119f/255,217f/255,187f/255));
		assists2.setForeground(new Color(119f/255,217f/255,187f/255));
		
		champs2.setHorizontalTextPosition(JLabel.CENTER);
		minions2.setHorizontalTextPosition(JLabel.CENTER);
		assists2.setHorizontalTextPosition(JLabel.CENTER);
		
		champs2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		minions2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		assists2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		
		JLabel champsWin = new JLabel(stats1.getTotalChampionKills() > stats2.getTotalChampionKills() ? stats1.getSummonerName() + " wins!" : stats2.getSummonerName() + " wins!", JLabel.CENTER);
		JLabel minionsWin = new JLabel(stats1.getTotalMinionkills() > stats2.getTotalMinionkills() ? stats1.getSummonerName() + " wins!" : stats2.getSummonerName() + " wins!", JLabel.CENTER);
		JLabel assistsWin = new JLabel(stats1.getTotalAssists() > stats2.getTotalAssists() ? stats1.getSummonerName() + " wins!" : stats2.getSummonerName() + " wins!", JLabel.CENTER);
		
		
		champsWin.setForeground(new Color(119f/255,217f/255,187f/255));
		minionsWin.setForeground(new Color(119f/255,217f/255,187f/255));
		assistsWin.setForeground(new Color(119f/255,217f/255,187f/255));
		
		champsWin.setHorizontalTextPosition(JLabel.CENTER);
		minionsWin.setHorizontalTextPosition(JLabel.CENTER);
		assistsWin.setHorizontalTextPosition(JLabel.CENTER);
		
		champsWin.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		minionsWin.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		assistsWin.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		
		gameType.setText("Game Mode: " + stats1.getGameType());
		
		
		statInfo.add(champs1);
		statInfo.add(champsWin);
		statInfo.add(champs2);
		statInfo.add(minions1);
		statInfo.add(minionsWin);
		statInfo.add(minions2);
		statInfo.add(assists1);
		statInfo.add(assistsWin);
		statInfo.add(assists2);
		
		frame.setVisible(true);
	}
	
}
