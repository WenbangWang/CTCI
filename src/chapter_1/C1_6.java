package chapter_1;

/**
 * Given an image represented by an N*N matrix. Rotate the image by 90 degrees.
 */
public class C1_6 {

  public static void main(String[] args) {
    int size = 7;
    Image image = new Image(size);

    image.rotate();

    System.out.println(image);
  }

  private static class Image {

    private int[][] matrix;

    public Image(int size) {
      generateMatrix(size);
    }

    public Image(int[][] matrix) {
      this.matrix = matrix;
      generateMatrix(matrix.length);
    }

    public void rotate() {
      int size = this.matrix.length;

      for(int layer = 0; layer < size / 2; layer++) {
        int first = layer;
        int last = size - 1 - first;

        for(int i = first; i < last; i++) {
          int offset = i - first;
          int top = this.matrix[first][i];

          this.matrix[first][i] = this.matrix[last - offset][first];  //Left -> Top
          this.matrix[last - offset][first] = this.matrix[last][last - offset]; //Bottom -> Left
          this.matrix[last][last - offset] = this.matrix[i][last];  //Right -> Bottom
          this.matrix[i][last] = top;  //Top -> Right
        }
      }
    }

    private void generateMatrix(int size) {
      if(this.matrix == null) {
        this.matrix = new int[size][size];
      }

      for(int i = 0; i < size; i++) {
        for(int j = 0; j < size; j++) {
          matrix[i][j] = i;
        }
      }
    }

    @Override
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      for(int i = 0; i < this.matrix.length; i++) {
        for(int j = 0; j < this.matrix.length; j++) {
          stringBuilder.append(this.matrix[i][j] + "  ");
        }

        stringBuilder.append("\r\n");
      }

      return stringBuilder.toString();
    }
  }
}
