# Minimum Spanning Tree Project (Prim and Kruskal Algorithms)

This project implements two classic algorithms for finding the **Minimum Spanning Tree (MST)** in a weighted undirected graph: **Prim's Algorithm** and **Kruskal's Algorithm**. The application reads graph data from a JSON input file, processes each graph to build MSTs using both algorithms, and writes detailed results to an output JSON file.

---

## Project Structure

```
src/main/java/com/assignment1
├── Edge.java
├── Graph.java
├── MSTResult.java
├── Prim.java
├── Kruskal.java
├── InputReader.java
├── OutputWriter.java
└── Main.java

input.json
output.json
pom.xml
```

---

## Main Classes Overview

### `Edge.java`

Represents a graph edge with fields `from`, `to`, and `weight`. Implements `Comparable` to sort edges by weight (used in Kruskal's algorithm).

### `Graph.java`

Represents a graph with:

* `id` – graph ID
* `nodes` – list of node names
* `edges` – list of edges

### `MSTResult.java`

Stores MST results for each algorithm:

* `mstEdges` – edges in MST
* `totalCost` – sum of weights
* `executionTimeMs` – execution time
* `operationsCount` – operation count

### `Prim.java`

Implements **Prim's algorithm** using a priority queue.

### `Kruskal.java`

Implements **Kruskal's algorithm** using union-find.

### `InputReader.java`

Reads graph data from `input.json` using Gson.

### `OutputWriter.java`

Writes MST results to `output.json`.

### `Main.java`

Main class that:
Reads graphs from input
Builds MST using Prim & Kruskal
Writes result to output JSON

---

## 📥 Input Format (input.json)

Example structure:

```json
{
  "graphs": [
    {
      "id": 1,
      "nodes": ["A", "B", "C", "D", "E"],
      "edges": [
        {"from": "A", "to": "B", "weight": 4},
        {"from": "A", "to": "C", "weight": 3},
        {"from": "B", "to": "C", "weight": 2},
        {"from": "B", "to": "D", "weight": 5},
        {"from": "C", "to": "D", "weight": 7},
        {"from": "C", "to": "E", "weight": 8},
        {"from": "D", "to": "E", "weight": 6}
      ]
    },
    {
      "id": 2,
      "nodes": ["A", "B", "C", "D"],
      "edges": [
        {"from": "A", "to": "B", "weight": 1},
        {"from": "A", "to": "C", "weight": 4},
        {"from": "B", "to": "C", "weight": 2},
        {"from": "C", "to": "D", "weight": 3},
        {"from": "B", "to": "D", "weight": 5}
      ]
    },
    {
      "id": 3,
      "nodes": ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J"],
      "edges": [
        {"from": "A", "to": "B", "weight": 5},
        {"from": "A", "to": "C", "weight": 9},
        {"from": "B", "to": "D", "weight": 7},
        {"from": "C", "to": "D", "weight": 3},
        {"from": "C", "to": "E", "weight": 6},
        {"from": "D", "to": "F", "weight": 4},
        {"from": "E", "to": "F", "weight": 2},
        {"from": "E", "to": "G", "weight": 8},
        {"from": "F", "to": "G", "weight": 10},
        {"from": "G", "to": "H", "weight": 11},
        {"from": "H", "to": "I", "weight": 3},
        {"from": "I", "to": "J", "weight": 4},
        {"from": "F", "to": "I", "weight": 12},
        {"from": "D", "to": "H", "weight": 9}
      ]
    },
    {
      "id": 4,
      "nodes": ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T"],
      "edges": [
        {"from": "A", "to": "B", "weight": 6},
        {"from": "A", "to": "C", "weight": 3},
        {"from": "B", "to": "D", "weight": 5},
        {"from": "C", "to": "E", "weight": 9},
        {"from": "D", "to": "F", "weight": 7},
        {"from": "E", "to": "G", "weight": 4},
        {"from": "F", "to": "H", "weight": 2},
        {"from": "G", "to": "I", "weight": 8},
        {"from": "H", "to": "J", "weight": 10},
        {"from": "I", "to": "K", "weight": 11},
        {"from": "J", "to": "L", "weight": 3},
        {"from": "K", "to": "M", "weight": 6},
        {"from": "L", "to": "N", "weight": 5},
        {"from": "M", "to": "O", "weight": 4},
        {"from": "N", "to": "P", "weight": 9},
        {"from": "O", "to": "Q", "weight": 7},
        {"from": "P", "to": "R", "weight": 2},
        {"from": "Q", "to": "S", "weight": 8},
        {"from": "R", "to": "T", "weight": 6},
        {"from": "C", "to": "H", "weight": 12},
        {"from": "D", "to": "I", "weight": 14},
        {"from": "E", "to": "J", "weight": 13},
        {"from": "F", "to": "K", "weight": 15},
        {"from": "G", "to": "L", "weight": 9},
        {"from": "H", "to": "M", "weight": 5},
        {"from": "I", "to": "N", "weight": 11},
        {"from": "J", "to": "O", "weight": 7},
        {"from": "K", "to": "P", "weight": 3},
        {"from": "L", "to": "Q", "weight": 8},
        {"from": "M", "to": "R", "weight": 10},
        {"from": "N", "to": "S", "weight": 6},
        {"from": "O", "to": "T", "weight": 4}
      ]
    }
  ]
}
{
  "graphs": [
    {
      "id": 1,
      "nodes": ["A", "B", "C", "D", "E"],
      "edges": [
        {"from": "A", "to": "B", "weight": 4},
        {"from": "A", "to": "C", "weight": 3},
        {"from": "B", "to": "C", "weight": 2},
        {"from": "B", "to": "D", "weight": 5},
        {"from": "C", "to": "D", "weight": 7},
        {"from": "C", "to": "E", "weight": 8},
        {"from": "D", "to": "E", "weight": 6}
      ]
    },
    {
      "id": 2,
      "nodes": ["A", "B", "C", "D"],
      "edges": [
        {"from": "A", "to": "B", "weight": 1},
        {"from": "A", "to": "C", "weight": 4},
        {"from": "B", "to": "C", "weight": 2},
        {"from": "C", "to": "D", "weight": 3},
        {"from": "B", "to": "D", "weight": 5}
      ]
    },
    {
      "id": 3,
      "nodes": ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J"],
      "edges": [
        {"from": "A", "to": "B", "weight": 5},
        {"from": "A", "to": "C", "weight": 9},
        {"from": "B", "to": "D", "weight": 7},
        {"from": "C", "to": "D", "weight": 3},
        {"from": "C", "to": "E", "weight": 6},
        {"from": "D", "to": "F", "weight": 4},
        {"from": "E", "to": "F", "weight": 2},
        {"from": "E", "to": "G", "weight": 8},
        {"from": "F", "to": "G", "weight": 10},
        {"from": "G", "to": "H", "weight": 11},
        {"from": "H", "to": "I", "weight": 3},
        {"from": "I", "to": "J", "weight": 4},
        {"from": "F", "to": "I", "weight": 12},
        {"from": "D", "to": "H", "weight": 9}
      ]
    },
    {
      "id": 4,
      "nodes": ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T"],
      "edges": [
        {"from": "A", "to": "B", "weight": 6},
        {"from": "A", "to": "C", "weight": 3},
        {"from": "B", "to": "D", "weight": 5},
        {"from": "C", "to": "E", "weight": 9},
        {"from": "D", "to": "F", "weight": 7},
        {"from": "E", "to": "G", "weight": 4},
        {"from": "F", "to": "H", "weight": 2},
        {"from": "G", "to": "I", "weight": 8},
        {"from": "H", "to": "J", "weight": 10},
        {"from": "I", "to": "K", "weight": 11},
        {"from": "J", "to": "L", "weight": 3},
        {"from": "K", "to": "M", "weight": 6},
        {"from": "L", "to": "N", "weight": 5},
        {"from": "M", "to": "O", "weight": 4},
        {"from": "N", "to": "P", "weight": 9},
        {"from": "O", "to": "Q", "weight": 7},
        {"from": "P", "to": "R", "weight": 2},
        {"from": "Q", "to": "S", "weight": 8},
        {"from": "R", "to": "T", "weight": 6},
        {"from": "C", "to": "H", "weight": 12},
        {"from": "D", "to": "I", "weight": 14},
        {"from": "E", "to": "J", "weight": 13},
        {"from": "F", "to": "K", "weight": 15},
        {"from": "G", "to": "L", "weight": 9},
        {"from": "H", "to": "M", "weight": 5},
        {"from": "I", "to": "N", "weight": 11},
        {"from": "J", "to": "O", "weight": 7},
        {"from": "K", "to": "P", "weight": 3},
        {"from": "L", "to": "Q", "weight": 8},
        {"from": "M", "to": "R", "weight": 10},
        {"from": "N", "to": "S", "weight": 6},
        {"from": "O", "to": "T", "weight": 4}
      ]
    }
  ]
}

```

---

## Output Format (output.json)

Example output:

```json
{
  "results": [
    {
      "graph_id": 1,
      "prim": [
        {
          "from": "A",
          "to": "C",
          "weight": 3
        },
        {
          "from": "B",
          "to": "C",
          "weight": 2
        },
        {
          "from": "B",
          "to": "D",
          "weight": 5
        },
        {
          "from": "D",
          "to": "E",
          "weight": 6
        }
      ],
      "kruskal": [
        {
          "from": "B",
          "to": "C",
          "weight": 2
        },
        {
          "from": "A",
          "to": "C",
          "weight": 3
        },
        {
          "from": "B",
          "to": "D",
          "weight": 5
        },
        {
          "from": "D",
          "to": "E",
          "weight": 6
        }
      ],
      "primTotalCost": 16,
      "kruskalTotalCost": 16,
      "primExecutionTimeMs": 0,
      "kruskalExecutionTimeMs": 0,
      "primOperations": 16,
      "kruskalOperations": 47
    },
    {
      "graph_id": 2,
      "prim": [
        {
          "from": "A",
          "to": "B",
          "weight": 1
        },
        {
          "from": "B",
          "to": "C",
          "weight": 2
        },
        {
          "from": "C",
          "to": "D",
          "weight": 3
        }
      ],
      "kruskal": [
        {
          "from": "A",
          "to": "B",
          "weight": 1
        },
        {
          "from": "B",
          "to": "C",
          "weight": 2
        },
        {
          "from": "C",
          "to": "D",
          "weight": 3
        }
      ],
      "primTotalCost": 6,
      "kruskalTotalCost": 6,
      "primExecutionTimeMs": 0,
      "kruskalExecutionTimeMs": 0,
      "primOperations": 11,
      "kruskalOperations": 34
    },
    {
      "graph_id": 3,
      "prim": [
        {
          "from": "A",
          "to": "B",
          "weight": 5
        },
        {
          "from": "B",
          "to": "D",
          "weight": 7
        },
        {
          "from": "C",
          "to": "D",
          "weight": 3
        },
        {
          "from": "D",
          "to": "F",
          "weight": 4
        },
        {
          "from": "E",
          "to": "F",
          "weight": 2
        },
        {
          "from": "E",
          "to": "G",
          "weight": 8
        },
        {
          "from": "D",
          "to": "H",
          "weight": 9
        },
        {
          "from": "H",
          "to": "I",
          "weight": 3
        },
        {
          "from": "I",
          "to": "J",
          "weight": 4
        }
      ],
      "kruskal": [
        {
          "from": "E",
          "to": "F",
          "weight": 2
        },
        {
          "from": "C",
          "to": "D",
          "weight": 3
        },
        {
          "from": "H",
          "to": "I",
          "weight": 3
        },
        {
          "from": "D",
          "to": "F",
          "weight": 4
        },
        {
          "from": "I",
          "to": "J",
          "weight": 4
        },
        {
          "from": "A",
          "to": "B",
          "weight": 5
        },
        {
          "from": "B",
          "to": "D",
          "weight": 7
        },
        {
          "from": "E",
          "to": "G",
          "weight": 8
        },
        {
          "from": "D",
          "to": "H",
          "weight": 9
        }
      ],
      "primTotalCost": 45,
      "kruskalTotalCost": 45,
      "primExecutionTimeMs": 0,
      "kruskalExecutionTimeMs": 0,
      "primOperations": 34,
      "kruskalOperations": 109
    },
    {
      "graph_id": 4,
      "prim": [
        {
          "from": "A",
          "to": "C",
          "weight": 3
        },
        {
          "from": "A",
          "to": "B",
          "weight": 6
        },
        {
          "from": "B",
          "to": "D",
          "weight": 5
        },
        {
          "from": "D",
          "to": "F",
          "weight": 7
        },
        {
          "from": "F",
          "to": "H",
          "weight": 2
        },
        {
          "from": "H",
          "to": "M",
          "weight": 5
        },
        {
          "from": "M",
          "to": "O",
          "weight": 4
        },
        {
          "from": "O",
          "to": "T",
          "weight": 4
        },
        {
          "from": "K",
          "to": "M",
          "weight": 6
        },
        {
          "from": "K",
          "to": "P",
          "weight": 3
        },
        {
          "from": "P",
          "to": "R",
          "weight": 2
        },
        {
          "from": "J",
          "to": "O",
          "weight": 7
        },
        {
          "from": "J",
          "to": "L",
          "weight": 3
        },
        {
          "from": "L",
          "to": "N",
          "weight": 5
        },
        {
          "from": "N",
          "to": "S",
          "weight": 6
        },
        {
          "from": "O",
          "to": "Q",
          "weight": 7
        },
        {
          "from": "G",
          "to": "L",
          "weight": 9
        },
        {
          "from": "E",
          "to": "G",
          "weight": 4
        },
        {
          "from": "G",
          "to": "I",
          "weight": 8
        }
      ],
      "kruskal": [
        {
          "from": "F",
          "to": "H",
          "weight": 2
        },
        {
          "from": "P",
          "to": "R",
          "weight": 2
        },
        {
          "from": "A",
          "to": "C",
          "weight": 3
        },
        {
          "from": "J",
          "to": "L",
          "weight": 3
        },
        {
          "from": "K",
          "to": "P",
          "weight": 3
        },
        {
          "from": "E",
          "to": "G",
          "weight": 4
        },
        {
          "from": "M",
          "to": "O",
          "weight": 4
        },
        {
          "from": "O",
          "to": "T",
          "weight": 4
        },
        {
          "from": "B",
          "to": "D",
          "weight": 5
        },
        {
          "from": "L",
          "to": "N",
          "weight": 5
        },
        {
          "from": "H",
          "to": "M",
          "weight": 5
        },
        {
          "from": "A",
          "to": "B",
          "weight": 6
        },
        {
          "from": "K",
          "to": "M",
          "weight": 6
        },
        {
          "from": "N",
          "to": "S",
          "weight": 6
        },
        {
          "from": "D",
          "to": "F",
          "weight": 7
        },
        {
          "from": "O",
          "to": "Q",
          "weight": 7
        },
        {
          "from": "J",
          "to": "O",
          "weight": 7
        },
        {
          "from": "G",
          "to": "I",
          "weight": 8
        },
        {
          "from": "C",
          "to": "E",
          "weight": 9
        }
      ],
      "primTotalCost": 96,
      "kruskalTotalCost": 96,
      "primExecutionTimeMs": 0,
      "kruskalExecutionTimeMs": 0,
      "primOperations": 73,
      "kruskalOperations": 279
    }
  ]
}
```

---

## Algorithms Summary

### Prim's Algorithm

* Greedy algorithm
* Grows MST node by node
* Uses PriorityQueue
* Time complexity: **O(E log V)**

### Kruskal's Algorithm

* Greedy algorithm
* Builds MST by picking smallest edges first
* Uses **disjoint set (union-find)**
* Time complexity: **O(E log E)**

---

## Features

Supports multiple graphs in one input file
Detailed execution metrics
Clean JSON output
Easy to extend
Well-structured OOP design

---

