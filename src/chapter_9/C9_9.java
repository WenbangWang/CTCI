package chapter_9;

import java.util.ArrayList;

/**
 * 8 Queens
 */
public class C9_9 {

  private static final int NUMBER_OF_QUEENS = 4;

  public static void main(String[] args) {
    Integer[] columns = new Integer[NUMBER_OF_QUEENS];
    ArrayList<Integer[]> results = new ArrayList<>();
    boolean[][] unavailableSlots = new boolean[NUMBER_OF_QUEENS][NUMBER_OF_QUEENS];

    placeQueens(0, 0, columns, results);
    print(results);
  }

  private static void placeQueens(int column, int row, Integer[] columns, ArrayList<Integer[]> results) {
    if (row == NUMBER_OF_QUEENS) {
      results.add(columns.clone());
    } else {
      for (int col = 0; col < NUMBER_OF_QUEENS; col++) {
        if (checkValid(col, row, columns)) {
          columns[row] = col;
          placeQueens(column, row + 1, columns, results);
        }
      }
    }
  }

  private static boolean checkValid(int currentColumn, int currentRow, Integer[] columns) {
    for (int row = 0; row < currentRow; row++) {
      if (currentColumn == columns[row]) {
        return false;
      }

      if ((currentRow - row) == Math.abs(currentColumn - columns[row])) {
        return false;
      }
    }


    return true;
  }

  private static void print(ArrayList<Integer[]> results) {
    for (int i = 0; i < results.size(); i++) {
      for (int j = 0; j < NUMBER_OF_QUEENS; j++) {
        System.out.print("{" + j + "," + results.get(i)[j] + "}");
      }
      System.out.println();
    }
  }
}