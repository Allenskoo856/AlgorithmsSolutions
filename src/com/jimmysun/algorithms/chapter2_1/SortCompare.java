package com.jimmysun.algorithms.chapter2_1;

import com.jimmysun.algorithms.chapter1_4.Stopwatch;
import com.jimmysun.algorithms.chapter2_2.Merge;
import com.jimmysun.algorithms.chapter2_3.Quick;
import com.jimmysun.algorithms.chapter2_4.Heap;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class SortCompare {
	public static double time(String alg, Double[] a) {
		Stopwatch timer = new Stopwatch();
		if (alg.equals("Insertion")) {
			Insertion.sort(a);
		}
		if (alg.equals("Selection")) {
			Selection.sort(a);
		}
		if (alg.equals("Shell")) {
			Shell.sort(a);
		}
		if (alg.equals("Merge")) {
			Merge.sort(a);
		}
		if (alg.equals("Quick")) {
			Quick.sort(a);
		}
		if (alg.equals("Heap")) {
			Heap.sort(a);
		}
		// Exercise 2.1.24
		if (alg.equals("Ex24")) {
			Ex24.sort(a);
		}
		// Exercise 2.1.25
		if (alg.equals("Ex25")) {
			Ex25.sort(a);
		}
		return timer.elapsedTime();
	}

	public static double timeRandomInput(String alg, int N, int T) {
		double total = 0.0;
		Double[] a = new Double[N];
		for (int t = 0; t < T; t++) {
			for (int i = 0; i < N; i++) {
				a[i] = StdRandom.uniform();
			}
			total += time(alg, a);
		}
		return total;
	}

	public static void main(String[] args) {
		String alg1 = args[0];
		String alg2 = args[1];
		int N = Integer.parseInt(args[2]);
		int T = Integer.parseInt(args[3]);
		double t1 = timeRandomInput(alg1, N, T);
		double t2 = timeRandomInput(alg2, N, T);
		StdOut.printf("For %d random Doubles\n  %s is", N, alg1);
		StdOut.printf(" %.1f times faster than %s\n", t2 / t1, alg2);
	}
}
