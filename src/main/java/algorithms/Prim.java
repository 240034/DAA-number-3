package algorithms;

import graph.Edge;
import graph.Graph;
import MST.MSTResult;

import java.util.*;

public class Prim {

    public MSTResult findMST(Graph graph) {
        List<Edge> mst = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        int operations = 0;

        long startTime = System.nanoTime();

        String startNode = graph.nodes.get(0);
        visited.add(startNode);

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (Edge edge : graph.edges) {
            if (edge.from.equals(startNode) || edge.to.equals(startNode)) {
                pq.add(edge);
                operations++;
            }
        }

        while (!pq.isEmpty() && visited.size() < graph.nodes.size()) {
            Edge smallest = pq.poll();
            operations++;

            String nextNode = null;
            if (visited.contains(smallest.from) && !visited.contains(smallest.to)) {
                nextNode = smallest.to;
            } else if (visited.contains(smallest.to) && !visited.contains(smallest.from)) {
                nextNode = smallest.from;
            }

            if (nextNode != null) {
                visited.add(nextNode);
                mst.add(smallest);
                operations++;

                for (Edge edge : graph.edges) {
                    if ((edge.from.equals(nextNode) && !visited.contains(edge.to)) ||
                            (edge.to.equals(nextNode) && !visited.contains(edge.from))) {
                        pq.add(edge);
                        operations++;
                    }
                }
            }
        }

        long endTime = System.nanoTime();
        long executionTimeMs = (endTime - startTime) / 1_000_000;
        int totalCost = mst.stream().mapToInt(e -> e.weight).sum();

        return new MSTResult(mst, totalCost, executionTimeMs, operations);
    }
}
