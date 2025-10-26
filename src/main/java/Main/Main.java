package Main;

import algorithms.Kruskal;
import algorithms.Prim;
import InputOutput.InputReader;
import MST.MSTResult;
import InputOutput.OutputWriter;
import graph.Graph;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Graph> graphs = InputReader.readGraphs("input.json");

        if (graphs.isEmpty()) {
            System.err.println("There are no graphs to process. Check input.json!");
            return;
        }

        List<OutputWriter.MSTResultJSON> results = new ArrayList<>();

        for (Graph g : graphs) {
            Prim prim = new Prim();
            Kruskal kruskal = new Kruskal();

            MSTResult mstPrim = prim.findMST(g);
            MSTResult mstKruskal = kruskal.findMST(g);

            OutputWriter.MSTResultJSON res = new OutputWriter.MSTResultJSON();
            res.graph_id = g.id;
            res.prim = mstPrim.mstEdges;
            res.kruskal = mstKruskal.mstEdges;
            res.primTotalCost = mstPrim.totalCost;
            res.kruskalTotalCost = mstKruskal.totalCost;
            res.primExecutionTimeMs = mstPrim.executionTimeMs;
            res.kruskalExecutionTimeMs = mstKruskal.executionTimeMs;
            res.primOperations = mstPrim.operationsCount;
            res.kruskalOperations = mstKruskal.operationsCount;

            results.add(res);
        }

        OutputWriter.writeResults("output.json", results);

        System.out.println("The graphs have been processed. The results have been saved in output.json.");
    }
}
