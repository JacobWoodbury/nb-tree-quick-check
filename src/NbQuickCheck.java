import java.util.List;
import java.util.Map;

public class NbQuickCheck {

  /**
   * Performs a pre-order traversal of the tree, printing each node on a separate line.
   * Does nothing if the root is not present in the tree.
   *
   * @param tree the tree represented as a map of parent nodes to child lists
   * @param root the root node to start traversal from
   */
  public static void preOrder(Map<Integer, List<Integer>> tree, int root) {
    
    if(!tree.containsKey(root)) return;
    
    //print root
    System.out.println(root);
    if(tree.get(root).size() == 0) return;
    //traverse children
    for(int child : tree.get(root)){
      preOrder(tree, child);
    }
  }

  /**
   * Returns the minimum value in the tree.
   * Returns Integer.MAX_VALUE if the root is null.
   *
   * @param root the root node of the tree
   * @return the minimum value in the tree or Integer.MAX_VALUE if root is null
   */
  public static int minVal(Node<Integer> root) {
    int min = Integer.MAX_VALUE;
    if(root == null) return min;
    return minVal(root, min);
  }
  public static int minVal(Node<Integer> root, int min){
    if(root.value < min) min = root.value;
    
    for(Node<Integer> child : root.children){
      int childMin = minVal(child, min);
      if(childMin < min) min = childMin;
    }
    return min;
  }

  
}
