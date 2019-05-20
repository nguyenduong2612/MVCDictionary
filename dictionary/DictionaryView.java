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

	protected JTextField searchWord  = new JTextField(15);
	protected JButton searchButton = new JButton("Search");
	protected JTextArea meaning = new JTextArea(10, 10);
	JPanel dicPanel = new JPanel();
	GridBagConstraints gbc = new GridBagConstraints();
	String[] blankArr = {""};
	JList<String> wordList = new JList<String>(blankArr);
	JScrollPane list, translation;
	DictionaryView(){	
		this.setSize(600,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setTitle("Dictionary");
		this.getContentPane().setForeground(Color.YELLOW);
		JPanel searchPanel = new JPanel();
		// searchPanel.add(searchButton);
		
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

		// gbc.anchor = GridBagConstraints.EAST;
		gbc.fill = GridBagConstraints.VERTICAL;
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

		// JScrollPane scrollbar1 = new JScrollPane(meaning, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		// meaning.add(scrollbar1);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 250;
		gbc.weighty = 500;
		gbc.fill = GridBagConstraints.BOTH;
		list = new JScrollPane(wordList);
		dicPanel.add(list, gbc);

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
	

	public String getSearchWord(){
		
		return (searchWord.getText());
		
	}
	
	
	public void setMeaning(String meaning){
		
		this.meaning.setText(meaning);
		
	}
	
	public void updateList(Set<String> wordList){
		// Object[] array = wordList.toArray();
		String[] words = new String[wordList.size()];
		words = wordList.toArray(words);
		// this.wordList.setListData(Arrays.copyOfRange(words, 0, 10));
		this.wordList.setListData(words);		
	}

	public void resetList(){
		this.wordList.setListData(blankArr);		
	}
	// If the calculateButton is clicked execute a method
	// in the Controller named actionPerformed
	
	public void addSearchListener(ActionListener listenForSearchButton){
		
		this.searchButton.addActionListener(listenForSearchButton);
		
	}

	public void addPartialListener(KeyListener listenForPartial){
		
		this.searchWord.addKeyListener(listenForPartial);
		
	}

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