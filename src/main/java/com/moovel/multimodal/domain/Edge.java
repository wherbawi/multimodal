package com.moovel.multimodal.domain;

public class Edge {
	private int destinationId;
	private int distance;
	private boolean carAllowed;
	private boolean footAllowed;
	private boolean bicycleAllowed;

	public Edge(int destinationId, int distance) {
		this.destinationId = destinationId;
		this.distance = distance;
	}

	public int getDestinationId() {
		return destinationId;
	}

	public void setDestinationId(int destinationId) {
		this.destinationId = destinationId;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int duration) {
		this.distance = duration;
	}

	public boolean isCarAllowed() {
		return carAllowed;
	}

	public void setCarAllowed(boolean carAllowed) {
		this.carAllowed = carAllowed;
	}

	public boolean isFootAllowed() {
		return footAllowed;
	}

	public void setFootAllowed(boolean footAllowed) {
		this.footAllowed = footAllowed;
	}

	public boolean isBicycleAllowed() {
		return bicycleAllowed;
	}

	public void setBicycleAllowed(boolean bicycleAllowed) {
		this.bicycleAllowed = bicycleAllowed;
	}
}
