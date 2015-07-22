package herbawi.wesam.multimodal.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Graph {
	HashMap<Integer, ArrayList<Edge>> nodes;

	public Graph() {
		nodes = new HashMap<Integer, ArrayList<Edge>>();
	}

	public void addEdge(int sourceNode, Edge edge) {
		if (nodes.get(sourceNode) == null) {
			nodes.put(sourceNode, new ArrayList<Edge>());
		}
		if (nodes.get(edge.getDestinationId()) == null) {
			nodes.put(edge.getDestinationId(), new ArrayList<Edge>());
		}
		nodes.get(sourceNode).add(edge);
	}

	public ArrayList<Edge> getEdges(int NodeId) {
		ArrayList<Edge> edges = nodes.get(NodeId);
		return edges != null ? edges : new ArrayList<Edge>();
	}

	public int getNumberOfNodes() {
		return nodes.size();
	}
}
