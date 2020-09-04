package edu.eci.arep.logic.SortAlgorithm;

import java.util.List;

public class BubbleSort {

    public BubbleSort() {
    }
    public static List<Double> sort(List<Double> arr){
        int n = arr.size();
        Double temp = 0.0;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arr.get(j - 1) > arr.get(j)) {
                    temp = arr.get(j - 1);
                    arr.set(j - 1, arr.get(j));
                    arr.set(j, temp);
                }
            }
        }
        return arr;
    }
}