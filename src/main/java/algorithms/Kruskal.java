package algorithms;

import graph.Edge;
import graph.Graph;
import MST.MSTResult;

import java.util.*;

public class Kruskal {

    private Map<String, String> parent = new HashMap<>();

    private String find(String node, int[] operations) {
        operations[0]++;
        if (parent.get(node).equals(node)) {
            return node;
        }
        return find(parent.get(node), operations);
    }

    private void union(String a, String b, int[] operations) {
        String rootA = find(a, operations);
        String rootB = find(b, operations);
        parent.put(rootA, rootB);
        operations[0]++;
    }

    public MSTResult findMST(Graph graph) {
        List<Edge> mst = new ArrayList<>();
        int[] operations = {0};

        long startTime = System.nanoTime();

        for (String node : graph.nodes) {
            parent.put(node, node);
            operations[0]++;
        }

        List<Edge> sortedEdges = new ArrayList<>(graph.edges);
        Collections.sort(sortedEdges);
        operations[0] += sortedEdges.size();

        for (Edge edge : sortedEdges) {
            String rootA = find(edge.from, operations);
            String rootB = find(edge.to, operations);

            if (!rootA.equals(rootB)) {
                mst.add(edge);
                union(edge.from, edge.to, operations);
            }
        }

        long endTime = System.nanoTime();
        long executionTimeMs = (endTime - startTime) / 1_000_000;
        int totalCost = mst.stream().mapToInt(e -> e.weight).sum();

        return new MSTResult(mst, totalCost, executionTimeMs, operations[0]);
    }
}
