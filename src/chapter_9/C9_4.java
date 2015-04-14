package chapter_9;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Write a method to return all subsets of a set.
 */
public class C9_4 {

  public static void main(String[] args) {
    ArrayList<Integer> arrayList = new ArrayList<>();
    int size = 15;
    long startTime, endTime;

    for(int i = 0; i < size; i++) {
      arrayList.add(i);
    }

    startTime = System.nanoTime();

    getSubsets(arrayList, 0);

    endTime = System.nanoTime();

    System.out.println("Recursive takes " + (endTime - startTime) / 1000 + " milliseconds");

    startTime = System.nanoTime();

    getSubsetsIterate(arrayList);

    endTime = System.nanoTime();

    System.out.println("Iterate takes " + (endTime - startTime) / 1000 + " milliseconds");
  }

  private static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> list, int index) {
    ArrayList<ArrayList<Integer>> subsets;

    if(list.size() == index) {
      ArrayList<Integer> subset = new ArrayList<>();
      subsets = new ArrayList<>();
      subsets.add(subset);
    } else {
      int item;
      ArrayList<ArrayList<Integer>> currentSubsets;

      subsets = getSubsets(list, index + 1);
      item = list.get(index);
      currentSubsets = new ArrayList<>();

      for(ArrayList<Integer> subset : subsets) {
        ArrayList<Integer> currentSubset = new ArrayList<>();

        currentSubset.add(item);
        currentSubset.addAll(subset);
        currentSubsets.add(currentSubset);
      }

      subsets.addAll(currentSubsets);
    }

    return subsets;
  }

  private static ArrayList<ArrayList<Integer>> getSubsetsIterate(ArrayList<Integer> list) {
    ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();
    int totalNumber = 1 << list.size();

    for(int i = 0; i < totalNumber; i++) {
      ArrayList<Integer> subset = getSubsetsIterateHelper(list, i);

      subsets.add(subset);
    }

    return subsets;
  }

  private static ArrayList<Integer> getSubsetsIterateHelper(ArrayList<Integer> list, int n) {
    ArrayList<Integer> subset = new ArrayList<>();
    int index = 0;

    for(int i = n; i > 0; i >>= 1) {
      if((i & 1) == 1) {
        subset.add(list.get(index));
      }

      index++;
    }

    return subset;
  }
}