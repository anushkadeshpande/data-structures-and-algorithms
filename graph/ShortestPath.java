import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class ShortestPath {

  public static Map<String, List<String>> graph;
  public static Set<String> visited;
  public static Queue<QueueNode> queue;

  public static class QueueNode {
    String node;
    int distance;
  }

  public static int shortestPath(String src, String dest) {
    QueueNode queueNode = new QueueNode();

    queueNode.node = src;
    queueNode.distance = 0;

    queue.add(queueNode);

    while (!queue.isEmpty()) {
      queueNode = queue.poll();

      if (queueNode.node.equals(dest))
        return queueNode.distance;

      visited.add(queueNode.node);

      for (String n : graph.get(queueNode.node)) {
        if (!visited.contains(n)) {
          QueueNode qn = new QueueNode();
          qn.node = n;
          qn.distance = queueNode.distance + 1;

          queue.add(qn);
        }
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    graph = new HashMap<>();
    graph.put("w", Arrays.asList("x", "v"));
    graph.put("x", Arrays.asList("y", "w"));
    graph.put("z", Arrays.asList("y", "v"));
    graph.put("v", Arrays.asList("z", "w"));
    graph.put("y", Arrays.asList("x", "z"));

    visited = new HashSet<>();
    queue = new LinkedList<>();
    System.out.println(shortestPath("v", "y"));
  }
}
