package dictionary;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class DictionaryController{
	private DictionaryView dicView;
	private DictionaryModel dicModel;

	public DictionaryController(DictionaryView view, DictionaryModel model){
		this.dicView = view;
		this.dicModel = model;

		// add action listener to each button, the parameter is and object of a action handler class
		// the class has one method that will be called automatically when the action occurs

		dicView.searchButton.addSearchListener(new searchListener());
		dicView.addButton.addAddListener(new addListener());
		dicView.deleteButton.addDeleteListener(new deleteListener());
	}

	private class searchListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			try{
				String word = dicView.getSearchWord();
				dicModel.searchForWord(word);
				dicView.setMeaning(dicModel.getMeaning());
			}
			catch(/* need some error*/){
				// handle the error
			}
		}
	}

	private class addListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			try{
				String word = dicView.getAddWord();
				String meaning = dicView.getMeaning();
				dicModel.addWord(word, meaning);
				dicView.setNoti(dicModel.getNoti()); // noti if adding word succeeded or not 
			}
			catch(/* need some error*/){
				// handle the error
			}
		}
	}

	private class deleteListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			try{
				String word = dicView.getDeletehWord();
				dicModel.deleteWord(word);
				dicView.setNoti(dicModel.getNoti()); // noti the deleting process
			}
			catch(/* need some error*/){
				// handle the error
			}
		}
	}
}