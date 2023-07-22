package HashMap;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;


public class Dictionary {
	private DictAVL Words[];
	public Dictionary() {
		Words = new DictAVL[27]; // As There are 25 Letters in English And Exceptions
	}
	public void initialize()
	{
		for(int i =0 ; i<27; i++)
		{
			Words[i] = new DictAVL();
		}
		this.loadData();
	}
	public void insert(String word, String meaning)
	{
		if(word == "" || meaning == "")
			return;
		char firstChar = word.toLowerCase().charAt(0);
		int index = (firstChar >= 'a' && firstChar <= 'z')?firstChar%97:26;
		Words[index].insert(word, meaning);
	}
	public void delete(String word)
	{
		char firstChar = word.toLowerCase().charAt(0);
		int index = firstChar%97;
		Words[index].deleteElement(word);
	}
	public String search(String word)
	{
		char firstChar = word.toLowerCase().charAt(0);
		int index = firstChar%97;
		dictComp wordData = Words[index].search(word);
		if(wordData == null)
			return "Meaning not found";
		else
			return wordData.Meaning;
	}
	private void loadData()
	{
		String line = "";
		try {
			BufferedReader in = new BufferedReader(new FileReader("src/dictionary.dat"));
		    while ((line = in.readLine()) != null) {
				/*if(line.length() <= 2)
					continue;
				String word = "";
				int i = 0;
				while(line.charAt(i) != ' ' && line.charAt(i) != '\t')
				{
					word+=line.charAt(i++);
				}
				String meaning = line.substring(word.length());
				
				this.insert(word, meaning);*/
		    	if(line.length() <= 2)
					continue;
				String word = "";
				String wordArray[] = line.split("  ");
				if(wordArray.length >= 2)
				{
					word = wordArray[0];
					int i = 1;
					String meaning = "";
					while(i<wordArray.length)
					{
						meaning+=" ";
						meaning += wordArray[i++];
					}
					this.insert(word, meaning);
				}
		    }
		    in.close();
		}
		catch(Exception e)
		{
			System.out.print(line);
			e.printStackTrace();
		}
	}
}
