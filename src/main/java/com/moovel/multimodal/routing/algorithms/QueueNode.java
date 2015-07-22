package com.moovel.multimodal.routing.algorithms;

public class QueueNode implements Comparable<QueueNode> {
	private int nodeId;
	private int cost;

	public int compareTo(QueueNode arg0) {
		return cost - arg0.getCost();
	}

	public int getNodeId() {
		return nodeId;
	}

	public void setNodeId(int nodeId) {
		this.nodeId = nodeId;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int duration) {
		this.cost = duration;
	}

}
