package herbawi.wesam.multimodal.routing.algorithms;

import herbawi.wesam.multimodal.domain.Edge;
import herbawi.wesam.multimodal.domain.Graph;
import herbawi.wesam.multimodal.domain.StreetVehicleEdge;
import herbawi.wesam.multimodal.domain.VehicleStreetEdge;

public class Test {
	public static void main(String[] arg) {
		
/**
           (node 3 is a car2go)
		            3 
		           / \
         w,0.06km /   \ d,0km
				  \   /
                   \ /		
		0---------->1-------------->2-------->4
		  w,d,4km       w,d,43km       w,4km 
*/	
		Graph graph = new Graph();
		Edge e0to1 = new Edge(1, 4000);
		Edge e1to2 = new Edge(2, 43000);
		Edge streetVehicleEdge = new StreetVehicleEdge(3, 60);
		Edge vehicleStreetEdge = new VehicleStreetEdge(1, 0);
		Edge e2to4 = new Edge(4, 4000);

		e0to1.setFootAllowed(true);
		e1to2.setCarAllowed(true);
		e1to2.setFootAllowed(true);
		e2to4.setFootAllowed(true);
		streetVehicleEdge.setFootAllowed(true);
		vehicleStreetEdge.setCarAllowed(true);

		graph.addEdge(0, e0to1);
		graph.addEdge(1, e1to2);
		graph.addEdge(1, streetVehicleEdge);
		graph.addEdge(3, vehicleStreetEdge);
		graph.addEdge(2, e2to4);

		Dijkstra dijkstra = new Dijkstra();
		int duration = dijkstra.shortestPath(0, 4, graph);
		System.out.println(String.format("duration is %f hours",duration/(60*60f)));
	}
}
