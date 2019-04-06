package ex;

public class TestaWay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TrieADT<String> t = new WayTrie<>();
		
		t.insert("PICOLE", "PICOLE");
		t.insert("PICOLO", "PICOLO");
		t.insert("PICOLE DE MANGA", "PICOLE DE MANGA");
		t.insert("PICOLINO", "PICOLINO");
		t.insert("PICO", "PICO");
		t.insert("PINO", "PINO");
		
		//System.out.println(t.countKeysWithPrefix("pico"));
		
		System.out.println(t.longestPrefixOf("PICOLO"));

	}

}
