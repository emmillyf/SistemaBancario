package br.com.poo.g3.util;

import java.util.Comparator;

public class Comparador implements Comparator<String> {

	public int compare(String um, String dois) {
		if (um.compareTo(dois) > 0) {
			return 1;
		}
		return -1;
	}
}