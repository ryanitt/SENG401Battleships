package battleships.client;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import battleships.message.*;

public class LobbyWindow implements Window {
    
    private ClientUI cu;
    
    public LobbyWindow(ClientUI cu) {
        this.cu = cu;
    }

    @Override
    public void show() {
        // Rensa f�nstret p� f�reg�ende komponenter
		cu.getWindow().getContentPane().removeAll();
		
		// S�tt state till lobby
		cu.setState(ClientUI.states.lobby.ordinal());
				
		// GridBagLayout
		GridBagLayout theLayout = new GridBagLayout();
		GridBagConstraints con = new GridBagConstraints();
		cu.getWindow().setLayout(theLayout);
		
		// S�tt storlek p� cu.getLobbyList()an
		cu.getLobbyList().setMaximumSize(new Dimension(700,300));
		cu.getLobbyList().setMinimumSize(new Dimension(700,300));
		cu.getLobbyList().setPreferredSize(new Dimension(700,300));
		cu.getLobbyList().setBorder(BorderFactory.createLineBorder(Color.black, 5));
		cu.getLobbyList().setFont(new Font("SansSerif", Font.BOLD, 18));
		
		// �verskift
		JLabel lobbyText = new JLabel("Select and challenge your enemy!");
		lobbyText.setFont(new Font("SansSerif", Font.BOLD, 24));
		
		// L�gg i panel
		JPanel panel = new JPanel();
		panel.setMaximumSize(new Dimension(700,50));
		panel.setMinimumSize(new Dimension(700,50));
		panel.setPreferredSize(new Dimension(700,50));
		panel.add(lobbyText);
		
		// S�tt storlek p� knappar...
		cu.getChallengeButton().setMaximumSize(new Dimension(150,30));
		cu.getChallengeButton().setMinimumSize(new Dimension(150,30));
		cu.getChallengeButton().setPreferredSize(new Dimension(150,30));
		cu.getChallengeButton().addActionListener(cu);
		
		cu.getRefreshButton().setMaximumSize(new Dimension(150,30));
		cu.getRefreshButton().setMinimumSize(new Dimension(150,30));
		cu.getRefreshButton().setPreferredSize(new Dimension(150,30));
		cu.getRefreshButton().addActionListener(cu);
		
		// L�gg button i en panel
		JPanel panel2 = new JPanel();
		panel2.setMaximumSize(new Dimension(700,50));
		panel2.setMinimumSize(new Dimension(700,50));
		panel2.setPreferredSize(new Dimension(700,50));
		panel2.add(cu.getChallengeButton());
		panel2.add(cu.getRefreshButton());

		// H�r l�ggs komponenterna in i GridBagLayouten	
		con.gridx = 1;
		con.gridy = 0;
		theLayout.setConstraints(panel, con);
		cu.getWindow().add(panel);
		
		con.gridx = 1;
		con.gridy = 1;
		theLayout.setConstraints(cu.getLobbyList(), con);
		cu.getWindow().add(cu.getLobbyList());
		
		con.gridx = 1;
		con.gridy = 2;
		theLayout.setConstraints(panel2, con);
		cu.getWindow().add(panel2);		

		// L�gg till servern i spelarlistan per default
		cu.getPlayerList().add("Server");
		cu.getLobbyList().setListData(cu.getPlayerList());
		
		// Lyssnare som h�mtar v�rdet p� den sak i listan man klickat p�.
		cu.getLobbyList().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent evt) {
            	cu.setLobbySelected((String) cu.getLobbyList().getSelectedValue());
            	cu.getChallengeButton().setText("Challenge: " + cu.getLobbySelected());
            }
        });
		
		// Visa f�nster
		cu.getWindow().validate();
		cu.getWindow().repaint();
		cu.getWindow().setVisible(true);
				
		// Skicka namn
		NameMessage msg = new NameMessage();
		msg.setName("IAmAPlayerName");
		cu.getCNetwork().sendMessage(msg);
		
		// Uppdatera lobbyn
		cu.refreshLobby();
    }

}
