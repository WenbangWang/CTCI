package chapter_1;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Write an algorithm such that if an element in an M*N matrix is 0, its entire row and column are set to 0.
 */
public class C1_7 {

  public static void main(String[] args) throws CloneNotSupportedException{
    int x = 5;
    int y = 6;
    Matrix matrix = new Matrix(x, y);

    System.out.println(matrix);

//    matrix.setZeros();
    matrix.setZerosWithHashMap();

    System.out.println(matrix);
  }

  private static class Matrix{

    private int[][] matrix;
    private int x, y;
    private int zeros;
    private int max, min;

    public Matrix(int x, int y) {
      this.x = x;
      this.y = y;
      this.matrix = new int[this.x][this.y];
      this.zeros = Math.min(this.x, this.y) / 2;
      this.max = 9;
      this.min = 1;

      generateRandomMatrix();
    }

    public void setZeros() {
      boolean[] row = new boolean[this.x];
      boolean[] column = new boolean[this.y];

      for(int i = 0; i < this.x; i++) {
        for(int j = 0; j < this.y; j++) {
          if(this.matrix[i][j] == 0) {
            row[i] = true;
            column[j] = true;
          }
        }
      }

      for(int i = 0; i < this.x; i++) {
        for(int j = 0; j < this.y; j++) {
          if(row[i] || column[j]) {
            this.matrix[i][j] = 0;
          }
        }
      }
    }

    public void setZerosWithHashMap() {
      HashMap<Point, Boolean> map = new HashMap<>();

      for(int i = 0; i < this.x; i++) {
        for(int j = 0; j < this.y; j++) {
          if(this.matrix[i][j] == 0) {
            map.put(new Point(i, j), true);
          }
        }
      }

      for(Map.Entry entry : map.entrySet()) {
        Point point = (Point) entry.getKey();

        this.setZeros(point);
      }
    }

    @Override
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();

      for(int i = 0; i < this.x; i++) {
        for(int j = 0; j < this.y; j++) {
          stringBuilder.append(this.matrix[i][j] + "  ");
        }

        stringBuilder.append("\r\n");
      }

      return stringBuilder.toString();
    }

    private void setZeros(int x, int y) {
      for(int i = 0; i < this.x; i++) {
        this.setZero(i, y);
      }

      for(int i = 0; i < this.y; i++) {
        this.setZero(x, i);
      }
    }

    private void setZeros(Point point) {
      this.setZeros(point.x, point.y);
    }

    private void setZero(int x, int y) {
      this.matrix[x][y] = 0;
    }

    private void generateRandomMatrix() {
      Random generator = new Random();

      for(int i = 0; i < this.x; i++) {
        for(int j = 0; j < this.y; j++) {
          matrix[i][j] = generator.nextInt((max - min) + 1) + min;
        }
      }

      generateZeros(generator, this.zeros);
    }

    private void generateZeros(Random generator, int numberOfZeros) {
      for (int i = 0; i < numberOfZeros; i++) {
        int x = generator.nextInt(this.x);
        int y = generator.nextInt(this.y);

        while(matrix[x][y] == 0) {
          x = generator.nextInt(this.x);
          y = generator.nextInt(this.y);
        }

        matrix[x][y] = 0;
      }
    }
  }
}
