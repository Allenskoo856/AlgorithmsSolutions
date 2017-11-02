package com.jimmysun.algorithms.chapter4_3;

import com.jimmysun.algorithms.chapter1_3.Queue;

import edu.princeton.cs.algs4.IndexMinPQ;

public class Ex22PrimMST {
	private Edge[] edgeTo;
	private double[] distTo;
	private boolean[] marked;
	private IndexMinPQ<Double> pq;

	public Ex22PrimMST(EdgeWeightedGraph G) {
		edgeTo = new Edge[G.V()];
		distTo = new double[G.V()];
		marked = new boolean[G.V()];
		for (int v = 0; v < G.V(); v++) {
			distTo[v] = Double.POSITIVE_INFINITY;
		}
		pq = new IndexMinPQ<Double>(G.V());

		for (int v = 0; v < G.V(); v++) {
			if (!marked[v]) {
				distTo[v] = 0.0;
				pq.insert(v, 0.0);
				while (!pq.isEmpty()) {
					visit(G, pq.delMin());
				}
			}
		}
	}

	private void visit(EdgeWeightedGraph G, int v) {
		marked[v] = true;
		for (Edge e : G.adj(v)) {
			int w = e.other(v);

			if (marked[w]) {
				continue;
			}
			if (e.weight() < distTo[w]) {
				edgeTo[w] = e;

				distTo[w] = e.weight();
				if (pq.contains(w)) {
					pq.changeKey(w, distTo[w]);
				} else {
					pq.insert(w, distTo[w]);
				}
			}
		}
	}

	public Iterable<Edge> edges() {
		Queue<Edge> mst = new Queue<>();
		for (Edge edge : edgeTo) {
			if (edge != null) {
				mst.enqueue(edge);
			}
		}
		return mst;
	}
}
