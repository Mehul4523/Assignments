package tree;

public class CheckPrefixInTree {

	private TreeNodes root;
	
	public CheckPrefixInTree() {
		root = new TreeNodes();
	}
	
	public void insert(String word) {
		TreeNodes node = root;
		for (char c : word.toCharArray()) {
			node = node.children.computeIfAbsent(c, k -> new TreeNodes());
		}
		node.isEndOfWord = true;
	}
	
	public boolean isPrefix(String prefix) {
		TreeNodes node = root;
		for (char c : prefix.toCharArray()) {
			node = node.children.get(c);
			if (node == null) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		CheckPrefixInTree tree = new CheckPrefixInTree();
			
		tree.insert("apple");
		tree.insert("app");
		tree.insert("apricot");
	
		System.out.println("Is 'app' a prefix? " + tree.isPrefix("app"));
	
		System.out.println("Is 'apl' a prefix? " + tree.isPrefix("apl"));
	}

}
