package HashMap;

public class dictComp{
	String word;
	String Meaning;
	int height;
	dictComp left = null;
	dictComp right = null;
	public dictComp(String word, String Meaning)
	{
		this.word = word;
		this.Meaning = Meaning;
		height = 1;
	}
	@Override
	public String toString() {
		return word + ": " + Meaning;
	}
	
}