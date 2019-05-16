// This is the View
// Its only job is to display what the user sees
// It performs no calculations, but instead passes
// information entered by the user to whomever needs
// it. 
package dictionary;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DictionaryView extends JFrame{

	private JTextField searchWord  = new JTextField(15);
	protected JButton searchButton = new JButton("Search");
	protected JTextArea meaning = new JTextArea(10, 10);

	DictionaryView(){	

		JPanel dicPanel = new JPanel();
		this.add(dicPanel);
		this.setSize(600,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dicPanel.add(searchWord);
		searchButton.addSearchListener();
		dicPanel.add(searchButton);
		meaning.setEditable(false);
		dicPanel.add(meaning);
		this.setVisible(true);
		
	}
	
	public String getSearchWord(){
		
		return (searchhWord.getText());
		
	}
	
	
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