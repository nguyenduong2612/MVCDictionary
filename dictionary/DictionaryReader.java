package dictionary;
import java.util.*;

class Reader{
	Map Dictionary = new TreeMap();
	String outStr = "";
	OutputStream out = null;
	// InputStream in = null;
	BufferedReader inBr = null;
	String inStr = "";
	Reader(){
		try{
			out = new FileOutputStream("test.txt");
		}catch(IOException e){
			e.printStackTrace();
		}		
	}

	void readFromFile(String filename){
		int c;
		File file = new File(filename);
		try{
			this.inBr = new BufferedReader(new FileReader(file));
			while((c = (inBr.read())) != -1){
				inStr += (char)c;
			}
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	void writeToFile(String outStr){
		this.outStr = outStr;
		try{
			out.write(this.outStr.getBytes());			
			out.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	void word_handle(String word, int length){
		int i, j;
	    for(i = 0; i < length; i ++) // remove phonetic //
	    {
	        if(word.atChar(i) == '/')
	        {
	            word.atChar(i) = '\0';
	            break;
	        }
	    }
	    for(j = 0; j < i; j ++) // remove '@' //
	        word.atChar(j) = word.atChar(j+1);
	    // remove space at the end // abcde
	    word.atChar(j - 2) = '\0';
	}

	void createTreeMap(){
		String line;
	    String word;
	    String translation;
	    translation.atChar(0) = '\0';
	    File file = new File("dictionary");
	  
	    int i;
	    int first_word_flag = 1;
	    int word_count = 0;
	    try{
			this.inBr = new BufferedReader(new FileReader(file));
			while((line = (inBr.readLine())) != null){
				// inStr += (char)c;
				if(line[0] == '@')
		        {
		            if(first_word_flag == 0)
		            {
		                btins(root, word, translation, strlen(translation));
		                translation[0] = '\0';
		            }
		            word_handle(line, strlen(line));
		            strcpy(word, line);
		            first_word_flag = 0;
		            word_count ++;
		        }
		        else
		            strcat(translation, line);
				}
		}
		catch(IOException e){
			e.printStackTrace();
		}
	   
	    printf("Inserted %d words into btree dictionary!\n", word_count);
	    fclose(fp);
}
	
}

class DictionaryReader{
	Map Dictionary = new TreeMap();

	protected DictionaryReader(){
		Reader reader = new Reader();
		// reader.word_handle(reader.inStr);

	}	
}