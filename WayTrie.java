package ex;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

public class WayTrie<V> implements TrieADT<V> {
	  private static final int R = 256; // extended ASCII

	  private Node root;

	  private static class Node {
	    private Object value;
	    private Node[] next = new Node[R];
	  }

	  @Override
	  public void clear() {
	    root = null;
	  }

	  @Override
	  public boolean isEmpty() {
	    return root == null;
	  }

	  @Override
	  public V search(String key) {
	    Node node = search(root, key, 0);
	    if (node == null)
	      return null;
	    return (V) node.value;
	  }

	  private Node search(Node node, String key, int index) {
		  if (node == null)
		     return null;
		  if (index == key.length())
		     return node;
		  char c = key.charAt(index);
		  return search(node.next[c], key, index + 1);
	  }
	  
	  @Override
	  public void insert(String key, V value) {
	    root = insert(root, key, value, 0);
	  }

	  private Node insert(Node node, String key, V value, int index) {
	    if (node == null)
	      node = new Node();
	    if (index == key.length()) {
	      node.value = value;
	      return node;
	    }
	    char c = key.charAt(index);
	    node.next[c] = insert(node.next[c], key, value, index + 1);
	    return node;
	  }
	  
	  @Override
	  public void delete(String key) {
	    root = delete(root, key, 0);
	  }

	  private Node delete(Node node, String key, int index) {
	    if (node == null)
	       return null;
	    if (index == key.length()) {
	       node.value = null;
	    } else {
	       char c = key.charAt(index);
	       node.next[c] = delete(node.next[c], key, index + 1);
	    }

	    if (node.value != null)
	      return node;
	    for (int c = 0; c < R; c++)
	      if (node.next[c] != null)
	         return node;
	    return null;
	  }

	  @Override
	  public Iterable<String> keysWithPrefix(String prefix) {
	    Queue<String> results = new LinkedList<>();
	    Node node = search(root, prefix, 0);
	    collect(node, new StringBuilder(prefix), results);
	    return results;
	  }

	  private void collect(Node node, StringBuilder prefix, Queue<String> results) {
	    if (node == null)
	        return;
	    if (node.value != null)
	        results.add(prefix.toString());
	    for (char c = 0; c < R; c++) {
	        prefix.append(c);
	        collect(node.next[c], prefix, results);
	        prefix.deleteCharAt(prefix.length() - 1);
	    }
	  }

	  
	  public int countKeysWithPrefix(String prefix) {
		  
		return ((Collection<?>)keysWithPrefix(prefix)).size();
		  
	  }
	  
	  
	  public String longestPrefixOf(String key) {
		  StringBuilder k = new StringBuilder(key);
		  k = k.deleteCharAt(k.length() - 1);
		  return longest(k);
	  }

	  private String longest(StringBuilder prefix) {
		  if(prefix.length() == 1)
			  return prefix.toString();
		  
		  String s = prefix.toString();
		  
		  V r = search(s);
		  
		  if(r != null) {
			  return r.toString();
		  }
		  
		  return longest(prefix.deleteCharAt(prefix.length() - 1));
	  }
	  


}
