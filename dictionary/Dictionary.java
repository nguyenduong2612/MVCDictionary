package dictionary;

class Dictionary{
	public static void main(String args[]){
		DictionaryView theView = new DictionaryView();
		DictionaryModel theModel = new DictionaryModel();
		DictionaryController theController = new DictionaryController(theView, theModel);

		theView.setVisible(true);
	}
}