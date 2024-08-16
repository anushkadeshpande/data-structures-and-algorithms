import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class DepthFirstSearchNonRecursive {
    public static Map<String, List<String>> graph;
  public static Set<String> visited;

  public static void depthFirstSearch(String node) {
    Stack<String> stack = new Stack<>();
    stack.push(node);
    
    while(!stack.empty()) {
      node = stack.pop();
      visited.add(node);
      System.out.println(node);
      List<String> nodes = graph.get(node);

      for(String n: nodes) {
        if(!visited.contains(n))
          stack.push(n);
      }
  
    }

  }

  public static void main(String[] args) {
    graph = new HashMap<>();
    graph.put("a", Arrays.asList("b", "c"));
    graph.put("b", Arrays.asList("d"));
    graph.put("c", Arrays.asList("e"));
    graph.put("d", Arrays.asList("f"));
    graph.put("e", Arrays.asList());
    graph.put("f", Arrays.asList());

    visited = new HashSet<>();
    // System.out.println(graph);
    depthFirstSearch("a");
  }
}
