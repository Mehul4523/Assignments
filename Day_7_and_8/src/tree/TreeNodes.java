package tree;

import java.util.HashMap;
import java.util.Map;

public class TreeNodes {
	Map<Character, TreeNodes> children;
	boolean isEndOfWord;
	
	public TreeNodes() {
		children = new HashMap<>();
		isEndOfWord = false;
	}
}
