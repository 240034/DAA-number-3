package InputOutput;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import graph.Edge;

import java.io.FileWriter;
import java.util.List;

public class OutputWriter {

    public static void writeResults(String filename, List<MSTResultJSON> results) {
        try (FileWriter writer = new FileWriter(filename)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(new ResultsContainer(results), writer);
        } catch (Exception e) {
            System.err.println("Error reading file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static class MSTResultJSON {
        public int graph_id;
        public List<Edge> prim;
        public List<Edge> kruskal;
        public int primTotalCost;
        public int kruskalTotalCost;
        public long primExecutionTimeMs;
        public long kruskalExecutionTimeMs;
        public int primOperations;
        public int kruskalOperations;
    }

    private static class ResultsContainer {
        List<MSTResultJSON> results;
        ResultsContainer(List<MSTResultJSON> results) {
            this.results = results;
        }
    }
}
