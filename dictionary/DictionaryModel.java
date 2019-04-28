package dictionary;

public class DictionaryModel{
	private String[] strArray = new String[4];
	private String[] meaning = new String[4];
	public DictionaryModel(){
		strArray[0] = "dog";
		strArray[1] = "cat";
		strArray[2] = "horse";
		strArray[3] = "captain";

		meaning[0] = "cho";
		meaning[1] = "meo";
		meaning[2] = "ngua";
		meaning[3] = "steve rogers";
	}

	protected String searchForWord(String word){
		// System.out.println(word+word.length()+strArray[0].length());
		// if(word.equals(strArray[0])){
		// 	System.out.println("hell yeah");
		// }
		for (int i = 0; i<strArray.length; i++){
			if (strArray[i].equals(word)){
				return meaning[i];
			}
		}
		return "none";
	}

	public static void main(String args[]){
		DictionaryModel model = new DictionaryModel();
		System.out.println(model.strArray[0]);
	}
}