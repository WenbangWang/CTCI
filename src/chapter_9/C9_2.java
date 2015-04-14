package chapter_9;

import java.awt.*;
import java.util.HashMap;

/**
 * Imagine a robot sitting on the upper left corner of an X by Y grid.
 * The robot can only move in two directions: right and down.
 * How many possible paths are there for the robot to go from (0, 0) to (X, y).
 *
 * Follow Up:
 * Imagine certain spots are "off limits", such that the robot cannot step on them.
 * Design an algorithm to find a path for the robot from the top left to the bottom right.
 */
public class C9_2 {

  public static void main(String[] args) {
    int x = 15;
    int y = 15;
    HashMap<Point, Integer> hashMapBuffer = new HashMap<>();
    int[][] arrayBuffer = new int[x + 1][y + 1];
    long startTime, endTime;

    startTime = System.nanoTime();

    System.out.println(countPathsDPHashMap(x, y, hashMapBuffer));

    endTime = System.nanoTime();

    System.out.println("DP with HashMap takes " + (endTime - startTime) / 1000 + " milliseconds");

    startTime = System.nanoTime();

    System.out.println(countPathsDPArray(x, y, arrayBuffer));

    endTime = System.nanoTime();

    System.out.println("DP with array takes " + (endTime - startTime) / 1000 + " milliseconds");

    startTime = System.nanoTime();

    System.out.println(countPaths(x, y));

    endTime = System.nanoTime();

    System.out.println("Recursive takes " + (endTime - startTime) / 1000 + " milliseconds");
  }

  public static int countPaths(int x, int y) {
    if(x < 0 || y < 0) {
      return 0;
    }

    if(x == 0 && y == 0) {
      return 1;
    } else {
      return countPaths(x - 1, y) + countPaths(x, y - 1);
    }
  }

  public static int countPathsDPArray(int x, int y, int[][] buffer) {
    if(x < 0 || y < 0) {
      return 0;
    }

    if(x == 0 && y == 0) {
      buffer[x][y] = 1;
      return buffer[x][y];
    }

    if(buffer[x][y] != 0) {
      return buffer[x][y];
    }

    buffer[x][y] = countPathsDPArray(x - 1, y, buffer) + countPathsDPArray(x, y - 1, buffer);

    return buffer[x][y];
  }

  public static int countPathsDPHashMap(int x, int y, HashMap<Point, Integer> buffer) {
    if(x < 0 || y < 0) {
      return 0;
    }

    Point point = new Point(x, y);

    if(x == 0 && y == 0) {
      buffer.put(point, 1);
      return 1;
    }

    if(buffer.containsKey(point)) {
      return buffer.get(point);
    }

    buffer.put(point, countPathsDPHashMap(x - 1, y, buffer) + countPathsDPHashMap(x, y - 1, buffer));

    return buffer.get(point);
  }
}