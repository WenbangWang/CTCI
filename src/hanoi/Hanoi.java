package hanoi;

public class Hanoi {

  public static void main(String[] args) throws Exception{
    int numberOfPlates = 4;
    Tower[] towers = new Tower[3];

    towers[0] = new Tower(numberOfPlates, 1);
    towers[1] = new Tower(2);
    towers[2] = new Tower(3);

//    towers[0].movePlates(numberOfPlates, towers[2], towers[1]);
    towers[0].movePlatesTo(towers[2], towers[1]);
  }

}
