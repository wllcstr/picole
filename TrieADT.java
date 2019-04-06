package ex;

public interface TrieADT<V> {
	   public void clear();
	   public boolean isEmpty();
	   public V search(String key);
	   public void insert(String key, V value);
	   public void delete(String key);
	   public Iterable<String> keysWithPrefix(String prefix);
	   public int countKeysWithPrefix(String prefix);
	   public String longestPrefixOf(String key);
}
