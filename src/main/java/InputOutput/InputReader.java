package InputOutput;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import graph.Graph;

import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class InputReader {

    public static List<Graph> readGraphs(String filename) {
        List<Graph> graphs = new ArrayList<>();
        try (FileReader reader = new FileReader(filename)) {
            Gson gson = new Gson();
            Type containerType = new TypeToken<GraphsContainer>() {}.getType();
            GraphsContainer container = gson.fromJson(reader, containerType);

            if (container != null && container.graphs != null) {
                graphs = container.graphs;
            }

        } catch (Exception e) {
            System.err.println("Error reading file:" + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("Graphs read: " + graphs.size());
        return graphs;
    }

    private static class GraphsContainer {
        List<Graph> graphs;
    }
}
