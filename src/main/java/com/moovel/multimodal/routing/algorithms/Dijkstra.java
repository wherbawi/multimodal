package com.moovel.multimodal.routing.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

import com.moovel.multimodal.domain.Edge;
import com.moovel.multimodal.domain.Graph;
import com.moovel.multimodal.domain.VehicleStreetEdge;

public class Dijkstra {
	private static final int DRIVE_SPEED = 12;
	private static final double WALK_SPEED = 1.2;
	private PriorityQueue<QueueNode> pq;
	private HashMap<Integer, Integer> bestCost;

	public Dijkstra() {
		pq = new PriorityQueue<QueueNode>();
		bestCost = new HashMap<Integer, Integer>();
	}

	public int shortestPath(int sourceId, int destinationId, Graph graph) {
		int numberOfNodes = graph.getNumberOfNodes();
		bestCost.put(sourceId, 0);
		QueueNode qnode = new QueueNode();
		qnode.setCost(0);
		qnode.setNodeId(sourceId);
		pq.add(qnode);

		while (!pq.isEmpty()) {
			QueueNode settledNode = pq.remove();
			if (isDestination(settledNode.getNodeId(), destinationId,
					numberOfNodes)) {
				return settledNode.getCost();
			}
			if (alreadySettled(settledNode)) {
				continue;
			}
			ArrayList<Edge> edges = graph.getEdges(settledNode.getNodeId()
					% numberOfNodes);
			for (Edge edge : edges) {
				if (edge.isFootAllowed()) {
					int edgeDstId = edge.getDestinationId();
					int newCost = (int) (settledNode.getCost() + edge
							.getDistance() / WALK_SPEED);
					if (improvedCost(newCost, edgeDstId)) {
						addNode2Queue(edgeDstId, newCost);
					}
				}

				if (edge.isCarAllowed()
						&& (settledNode.getNodeId() > numberOfNodes || edge instanceof VehicleStreetEdge)) {
					int edgeDstId = edge.getDestinationId() + numberOfNodes;
					int newCost = settledNode.getCost() + edge.getDistance()
							/ DRIVE_SPEED;
					if (improvedCost(newCost, edgeDstId)) {
						addNode2Queue(edgeDstId, newCost);
					}
				}
			}

		}
		return -1;
	}

	private void addNode2Queue(int nodeId, int cost) {
		QueueNode queueNode = new QueueNode();
		queueNode.setNodeId(nodeId);
		queueNode.setCost(cost);
		pq.add(queueNode);
		bestCost.put(nodeId, cost);
	}

	private boolean alreadySettled(QueueNode settledNode) {
		return bestCost.get(settledNode) != null
				&& settledNode.getCost() > bestCost
						.get(settledNode.getNodeId());
	}

	private boolean improvedCost(int newCost, int nodeId) {
		return bestCost.get(nodeId) == null || newCost < bestCost.get(nodeId);
	}

	private boolean isDestination(int node, int destinationId, int numberOfNodes) {

		return node % numberOfNodes == destinationId;
	}
}
