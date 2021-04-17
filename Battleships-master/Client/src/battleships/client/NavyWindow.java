package battleships.client;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JPanel;


public class NavyWindow implements Window {
    
    private ClientUI cu;
    
    public NavyWindow(ClientUI cu) {
        this.cu = cu;
    }

    @Override
    public void show() {
        // Rensa f�nstret p� f�reg�ende komponenter
		cu.getWindow().getContentPane().removeAll();
		
		// S�tt cu.getState() till buildnavy
		cu.setState(ClientUI.states.buildnavy.ordinal());
		
		// Skapa 100 rutor med GridLayout d�r man kan placera ut sina fartyg.
		GridLayout layout = new GridLayout(10, 10);
		JPanel panel = new JPanel(layout);
		panel.setMaximumSize(new Dimension(300,300));
		panel.setMinimumSize(new Dimension(300,300));
		panel.setPreferredSize(new Dimension(300,300));
		panel.setBorder(BorderFactory.createLineBorder(Color.black, 5));
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++)
			{
				// L�gg till ny ruta i vector och panel
				Square aSquare = new Square(j, i, true);
				aSquare.addActionListener(cu);
				cu.getPlaceSquares().add(aSquare);
				panel.add(aSquare);
			}
		}
		
		// linePanel
		JPanel linePanel = new JPanel();
		linePanel.setMaximumSize(new Dimension(400,2));
		linePanel.setMinimumSize(new Dimension(400,2));
		linePanel.setPreferredSize(new Dimension(400,2));
		linePanel.setBackground(Color.black);
		
		// buttonPanel - Inneh�ller knappar och linePanel
		JPanel buttonPanel = new JPanel();
		buttonPanel.setMaximumSize(new Dimension(450,100));
		buttonPanel.setMinimumSize(new Dimension(450,100));
		buttonPanel.setPreferredSize(new Dimension(450,100));		
		buttonPanel.add(cu.getAddSubmarineButton());
		buttonPanel.add(cu.getAddDestroyerButton());
		buttonPanel.add(cu.getAddAircraftCarrierButton());
		buttonPanel.add(linePanel);
		buttonPanel.add(cu.getReadyButton());
		buttonPanel.add(cu.getClearButton());
		cu.getAddSubmarineButton().addActionListener(cu);
		cu.getAddDestroyerButton().addActionListener(cu);
		cu.getAddAircraftCarrierButton().addActionListener(cu);
		cu.getReadyButton().addActionListener(cu);
		cu.getClearButton().addActionListener(cu);
		cu.getReadyButton().setEnabled(false);
		
		// GridBagLayout
		GridBagLayout theLayout = new GridBagLayout();
		GridBagConstraints con = new GridBagConstraints();
		cu.getWindow().setLayout(theLayout);
		
		// �verskift i placeShips
		JLabel placeShipsLabel = new JLabel("Place your ships!");
		placeShipsLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
		
		// H�r l�ggs komponenterna in i GridBagLayouten	
		con.gridx = 3;
		con.gridy = 0;
		theLayout.setConstraints(placeShipsLabel, con);
		cu.getWindow().add(placeShipsLabel);
		
		con.gridx = 3;
		con.gridy = 1;
		theLayout.setConstraints(panel, con);
		cu.getWindow().add(panel);
		
		con.gridx = 3;
		con.gridy = 2;
		theLayout.setConstraints(buttonPanel, con);
		cu.getWindow().add(buttonPanel);
				
		// Visa f�nster
		cu.getWindow().validate();
		cu.getWindow().repaint();
		cu.getWindow().setVisible(true);
    }

}
