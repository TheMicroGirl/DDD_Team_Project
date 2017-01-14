import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

/**
 * Main GUI class to display initial start scree
 * and listen for events
 */

public class TopTrumpsGUI extends JFrame implements ActionListener{

	/** Instance variable and class constants */

	private JButton newGame, reportButton, exitButton;
	

	/**
	 * Contructor to add all the components to the frame
	 */
	public TopTrumpsGUI(){

		this.setSize(300, 150);
		this.setLocation(100,100);
		this.setTitle ("Top Trumps!");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		// call layout method
		this.layOut();

	}
	/**
	 * Lay out the components
	 */
	public void layOut(){

		JPanel pan = new JPanel();
		JPanel pan2 = new JPanel();
		JPanel pan3 = new JPanel();

		newGame = new JButton("NEW GAME");
		newGame.addActionListener(this);
		reportButton = new JButton("REPORT");
		reportButton.addActionListener(this);
		exitButton = new JButton("EXIT");
		exitButton.addActionListener(this);

		this.add(pan, "North");
		pan.setBackground(Color.magenta);
		this.add(pan2, "Center");
		pan2.setBackground(Color.magenta);
		this.add(pan3, "South");
		pan3.setBackground(Color.magenta);

		pan.add(newGame);
		pan2.add(reportButton);
		pan3.add(exitButton);

		this.setVisible(true);

	}
	/**
	 * Method to start the main game
	 * ?? read in input file and instantiate deck
	 * ?? or put file input in the Gameplay Class??
	 */
	public void startGame(){

	}
	/**
	 * Listen and act on button press events
	 * @param e the event
	 */
	public void actionPerformed(ActionEvent e){

		if (e.getSource()==newGame){
			//start new Game
			System.out.println("New Game Begins");
		}

		else if (e.getSource()==reportButton){
			System.out.println("Generate report");		}

		else if (e.getSource()==exitButton){
			System.exit(0);
		}


	}

}