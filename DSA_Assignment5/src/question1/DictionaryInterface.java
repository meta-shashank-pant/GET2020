package question1;

public interface DictionaryInterface {

	public Node add(Node data, Node root);

	public Node delete(int key, Node root);

	public String getValue(int Key, Node root);

	public void sortedList(Node root);

	public void sortedListRange(Node root, int k1, int k2);
}
