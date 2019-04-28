// This is the View
// Its only job is to display what the user sees
// It performs no calculations, but instead passes
// information entered by the user to whomever needs
// it. 
package dictionary;
import java.awt.event.ActionListener;

import javax.swing.*;

public class DictionaryView extends JFrame{

	private JTextField searchWord  = new JTextField(15);
	// private JLabel additionLabel = new JLabel("+");
	// private JTextField secondNumber = new JTextField(10);
	protected JButton searchButton = new JButton("Search");
	protected JTextField meaning = new JTextField(30);
	
	DictionaryView(){
		
		// Sets up the view and adds the components
		
		JPanel dicPanel = new JPanel();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000, 500);
		
		// calcPanel.add(firstNumber);
		// calcPanel.add(additionLabel);
		dicPanel.add(meaning);
		dicPanel.add(searchWord);
		dicPanel.add(searchButton);
		
		this.add(dicPanel);
		
		// End of setting up the components --------
		
	}
	
	public String getSearchWord(){
		
		return (searchWord.getText());
		
	}
	
	// public int getSecondNumber(){
		
	// 	return Integer.parseInt(secondNumber.getText());
		
	// }
	
	// public int getCalcSolution(){
		
	// 	return Integer.parseInt(calcSolution.getText());
		
	// }
	
	public void setMeaning(String meaning){
		
		this.meaning.setText(meaning);
		
	}
	
	// If the calculateButton is clicked execute a method
	// in the Controller named actionPerformed
	
	public void addSearchListener(ActionListener listenForSearchButton){
		
		this.searchButton.addActionListener(listenForSearchButton);
		
	}
	
	// Open a popup that contains the error message passed
	
	// void displayErrorMessage(String errorMessage){
		
	// 	JOptionPane.showMessageDialog(this, errorMessage);
		
	// }
	
}