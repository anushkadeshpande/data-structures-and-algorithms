import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class BreadthFirstSearch {
  public static Map<String, List<String>> graph;
  public static Set<String> visited;

  public static Queue<String> queue = new LinkedList<>();

  public static void depthFirstSearch(String node) {
    queue.add(node);

    while(!queue.isEmpty()) {
      node = queue.poll();
      System.out.println(node);

      visited.add(node);
      for(String n: graph.get(node)) {
        queue.add(n);
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
