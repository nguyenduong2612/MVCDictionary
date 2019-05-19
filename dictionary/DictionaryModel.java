package dictionary;

import java.util.*;
import java.io.*; 
public class DictionaryModel{
	
	TreeMap<String, String> treeMap = new TreeMap<>();
	String line, word, translation;
	BufferedReader inBr;
	File file = new File("/home/son/Downloads/oop/MVCDictionary/dictionary/dictionary.txt");

	DictionaryModel(){
		this.translation = "";
		try{
			this.inBr = new BufferedReader(new FileReader(this.file));
			}
		catch(IOException e){
			e.getMessage();
		}
	}

	String word_handle(String word){
		String str;
		String[] strCopy, strCopy2;
		strCopy = word.split("@");
		strCopy2 = strCopy[1].split("/");
		str = strCopy2[0].substring(0, strCopy2[0].length() - 1);
		return str;
	}

	void createTreeMap(){	  
	    int i;
	    int first_word_flag = 1;
	    int word_count = 0;

	    try{
			do{
				line = (inBr.readLine());
				if(line == null){
					treeMap.put(word, translation);
					translation = "";
				}
				else if(!line.equals("")){
					if(line.charAt(0) == '@')
			        {
			        	// System.out.println(this.line+"************************");
			            if(first_word_flag == 0)
			            {
			            	// System.out.println(this.word + "======" + this.translation);
			                treeMap.put(word, translation);
			                translation = "";
			            }
			            word = word_handle(line);
			            first_word_flag = 0;
			            word_count++;
			        }
			        else{
			        	if(!translation.equals(""))
			        		translation += "\n";
			            translation += line;
			        }
       				// System.out.println(this.translation+"&&&&&&&&&&&&&&&&&&&&&&&&&");
				}
			} while(line != null);
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
	   
	    System.out.printf("Inserted %d words into TreeMap dictionary!\n", word_count);
	}

	void viewTreeMap(){
		this.treeMap.forEach((key, value) -> System.out.println(
        "Key = " + key + "\nvalue = " + value));

	}

	public <V> SortedMap<String, V> filterPrefix(TreeMap<String,V> baseMap, String prefix) {
	    if(prefix.length() > 0) {
	        char nextLetter = (char)((int)prefix.charAt(prefix.length() -1) + 1);
	        String end = prefix.substring(0, prefix.length()-1) + nextLetter;
	        return baseMap.subMap(prefix, end);
	    }
	    return baseMap;
	}

	Set<String> getPartial(String prefix){
		// String[] wordList;
		// for(Map.Entry<String,String> entry : filterPrefix(treeMap, prefix).entrySet()) {
		//     System.out.println(entry.getKey());
		// }
		return(filterPrefix(treeMap, prefix).keySet());

	}

	String searchForWord(String word){
		return treeMap.get(word);
	}

	// public static void main(String args[]){
	// 	DictionaryModel obj = new DictionaryModel();
	// 	System.out.println("shit");
	// 	obj.createTreeMap();
	// 	obj.getPartial();
	// }
}