package MST;

import graph.Edge;

import java.util.List;

public class MSTResult {
    public List<Edge> mstEdges;
    public int totalCost;
    public long executionTimeMs;
    public int operationsCount;

    public MSTResult(List<Edge> mstEdges, int totalCost, long executionTimeMs, int operationsCount) {
        this.mstEdges = mstEdges;
        this.totalCost = totalCost;
        this.executionTimeMs = executionTimeMs;
        this.operationsCount = operationsCount;
    }
}
