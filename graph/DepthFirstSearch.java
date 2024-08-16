import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * DepthFirstSearch
 */
public class DepthFirstSearch {
  public static Map<String, List<String>> graph;
  public static Set<String> visited;

  public static void depthFirstSearch(String node) {
    System.out.println(node);
    visited.add(node);
    List<String> nodes = graph.get(node);

    for(String n: nodes) {
      if(!visited.contains(n))
        depthFirstSearch(n);
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