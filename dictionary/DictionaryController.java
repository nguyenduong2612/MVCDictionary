package dictionary;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class DictionaryController{
	private DictionaryView dicView;
	private DictionaryModel dicModel;

	public DictionaryController(DictionaryView view, DictionaryModel model){
		this.dicView = view;
		this.dicModel = model;

		/*add necessary listener to element in the view*/
		this.dicView.addSearchListener(new searchListener());
		this.dicView.addPartialListener(new partialListener());
		this.dicView.addListListener(new listSelectionListener());
		// dicView.addButton.addAddListener(new addListener());
		// dicView.deleteButton.addDeleteListener(new deleteListener());
	}

	// public class partialListener implements ActionListener{
	// 	private Set<String> wordList;
	// 	public void actionPerformed(ActionEvent event){
	// 		String partial = dicView.getSearchWord();
	// 		wordList = dicModel.getPartial(partial);
	// 		dicView.updateList(wordList);
	// 	}
	// }
	/*check whether a character pressed is a valid one and add to the current word in search box*/
	private boolean isAccepted(char c){
		if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c == '-') || c == '_' || c == '.' || c == ',' || c == '\'' || c == ' '){
			return (true);
		}
		return (false);
	}

	/*handle action when a key is pressed*/
	public class partialListener extends KeyAdapter{
		private Set<String> wordList;
		private String meaning;
		public void keyPressed(KeyEvent event){
			char c = event.getKeyChar();
			String partial = dicView.getSearchWord();
			
			if(isAccepted(c)){
				wordList = dicModel.getPartial(partial+c);
				dicView.updateList(wordList);
			}else if(c == 8){
				if(partial.length() == 1){
					dicView.resetList();
				}else{
					wordList = dicModel.getPartial(partial.substring(0, partial.length() - 1));
					dicView.updateList(wordList);
				}
			}else if(c == event.VK_ENTER){
				meaning = dicModel.searchForWord(partial);
				dicView.setMeaning(meaning);
			}
			
			
		}
	}

	/*action when search button is pressed*/
	public class searchListener implements ActionListener{
		private String meaning;
		public void actionPerformed(ActionEvent event){
			String word = dicView.getSearchWord();
			meaning = dicModel.searchForWord(word);
			dicView.setMeaning(meaning);
			// try{
			// 	String word = dicView.getSearchWord();
			// 	meaning = dicModel.searchForWord(word);
			// 	dicView.setMeaning(meaning);
			// }
			// catch(/* need some error*/){
			// 	// handle the error
			// }
		}
	}
	/*action when an item of list is selected*/
	public class listSelectionListener implements ListSelectionListener{
		private String meaning;
		public void valueChanged(ListSelectionEvent le) {
		    String word = dicView.wordList.getSelectedValue();
		    if (word != null) {
		    	// String word = name[idx];
		      System.out.println("Current selection: " + word);
		      // search for word, set text to jtext
		      dicView.searchWord.setText(word);
		      meaning = dicModel.searchForWord(word);
			  dicView.setMeaning(meaning);
		    } else {
		      System.out.println("Please choose a name");
		    }
		  }
	}
	
	// private class addListener implements ActionListener{
	// 	public void actionPerformed(ActionEvent event){
	// 		try{
	// 			String word = dicView.getAddWord();
	// 			String meaning = dicView.getMeaning();
	// 			dicModel.addWord(word, meaning);
	// 			// dicView.setNoti(dicModel.getNoti()); // noti if adding word succeeded or not 
	// 		}
	// 		catch(/* need some error*/){
	// 			// handle the error
	// 		}
	// 	}
	// }

	// private class deleteListener implements ActionListener{
	// 	public void actionPerformed(ActionEvent event){
	// 		try{
	// 			String word = dicView.getDeletehWord();
	// 			// dicModel.deleteWord(word);
	// 			// dicView.setNoti(dicModel.getNoti()); // noti the deleting process
	// 		}
	// 		catch(/* need some error*/){
	// 			// handle the error
	// 		}
	// 	}
	// }
}