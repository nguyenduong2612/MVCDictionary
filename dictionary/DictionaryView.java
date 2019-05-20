// This is the View
// Its only job is to display what the user sees
// It performs no calculations, but instead passes
// information entered by the user to whomever needs
// it. 
package dictionary;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.*;

public class DictionaryView extends JFrame{

	protected JTextField searchWord  = new JTextField(15);		// get user input word
	protected JButton searchButton = new JButton("Search");		// search button
	protected JTextArea meaning = new JTextArea(10, 10);		// translation field
	JPanel dicPanel = new JPanel();
	GridBagConstraints gbc = new GridBagConstraints();
	String[] blankArr = {""};	// blank array to reset suggestion list when no word is typed
	JList<String> wordList = new JList<String>(blankArr);	// word suggestion list
	JScrollPane list, translation;	// scroll pane of suggestion list and translation field
	DictionaryView(){	
		this.setSize(600,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setTitle("Dictionary");
		this.getContentPane().setForeground(Color.YELLOW);
		JPanel searchPanel = new JPanel();
		// searchPanel.add(searchButton);

		//**********************************SETUP VIEW**************************************8
		
		/* text field to type word into */
		dicPanel.setLayout(new GridBagLayout());
		gbc.insets = new Insets(5,5,5,5);		
		gbc.weightx = 250;
		gbc.weighty = 1;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 20;
		gbc.gridheight = 1;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.anchor = GridBagConstraints.WEST;
		// searchWord.setBorderPainted(false);
		searchWord.setBorder(null);
		dicPanel.add(searchWord, gbc);


		/* search button */
		gbc.fill = GridBagConstraints.VERTICAL;
		// gbc.anchor = GridBagConstraints.EAST;
		gbc.weightx = 3000;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.gridx = 20;
		gbc.gridy = 0;
		// JPanel blankPanel = new JPanel();
		// blankPanel.add(searchButton);
		// dicPanel.add(blankPanel, gbc);
		// gbc.fill = GridBagConstraints.NONE;
		dicPanel.add(searchButton, gbc);


		/*word list for suggestion*/
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 250;
		gbc.weighty = 500;
		gbc.fill = GridBagConstraints.BOTH;
		list = new JScrollPane(wordList);
		dicPanel.add(list, gbc);

		/*translation*/
		meaning.setEditable(false);
		meaning.setLineWrap(true);				
		meaning.setWrapStyleWord(true);

		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.weightx = 500;
		gbc.weighty = 500;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridheight = 1;
		translation = new JScrollPane(meaning);
		dicPanel.add(translation, gbc);


		this.add(dicPanel);
		this.setVisible(true);
	}
	
	/*function to get current word in search box to send to model via controller*/
	public String getSearchWord(){
		
		return (searchWord.getText());
		
	}
	
	/*function to set translation received from model via controller*/
	public void setMeaning(String meaning){
		
		this.meaning.setText(meaning);
		
	}
	
	/*function to update suggestion list when user type a new character*/
	public void updateList(Set<String> wordList){
		// Object[] array = wordList.toArray();
		String[] words = new String[wordList.size()];
		words = wordList.toArray(words);
		// this.wordList.setListData(Arrays.copyOfRange(words, 0, 10));
		this.wordList.setListData(words);		
	}


	/*function to reset list to blank when there is no character in search box*/
	public void resetList(){
		this.wordList.setListData(blankArr);		
	}
	
	/*function to add listener to search button, listen to search button being pressed*/
	public void addSearchListener(ActionListener listenForSearchButton){
		
		this.searchButton.addActionListener(listenForSearchButton);
		
	}

	/*function to add listener to search box, listen to a key being pressed and update suggestion list*/
	public void addPartialListener(KeyListener listenForPartial){
		
		this.searchWord.addKeyListener(listenForPartial);
		
	}

	/*function to add listener to suggestion list, listen to an item being selected => update search box and set meaning*/
	public void addListListener(ListSelectionListener listener){
		this.wordList.addListSelectionListener(listener);
	}
	
	// Open a popup that contains the error message passed
	
	// void displayErrorMessage(String errorMessage){
		
	// 	JOptionPane.showMessageDialog(this, errorMessage);
		
	// }
	// public static void main(String args[]){
	// 	new DictionaryView();
	// }
}