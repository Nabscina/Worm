package worm.domain;

import java.util.ArrayList;
import wgame.Direction;

public class Worm {

    private int xs;
    private int ys;
    private Direction direction;
    private ArrayList<Piece> pieces;

    private boolean grew;

    public Worm(int xs, int ys, Direction d) {

        this.xs = xs;
        this.ys = ys;
        this.direction = d;
        this.pieces = new ArrayList<>();
        pieces.add(new Piece(xs, ys));

        this.grew = false;
    }

    public Direction getDirection() {

        return this.direction;
    }

    public void setDirection(Direction d) {

        this.direction = d;
    }

    public int getSize() {

        return pieces.size();
    }

    public ArrayList<Piece> getPieces() {

        return pieces;
    }

//    public void move() {

//        if (this.direction.equals(Direction.LEFT)) {
//            pieces.add(new Piece(pieces.get(getSize() - 1).getX() - 1, pieces.get(getSize() - 1).getY()));
 //       } else if (this.direction.equals(Direction.RIGHT)) {
 //           pieces.add(new Piece(pieces.get(getSize() - 1).getX() + 1, pieces.get(getSize() - 1).getY()));
//        } else if (this.direction.equals(Direction.UP)) {
 //           pieces.add(new Piece(pieces.get(getSize() - 1).getX(), pieces.get(getSize() - 1).getY() - 1));
 //       } else if (this.direction.equals(Direction.DOWN)) {
 //           pieces.add(new Piece(pieces.get(getSize() - 1).getX(), pieces.get(getSize() - 1).getY() + 1));
 //       }
        
  //      if (getSize() < 3) {
  //          return;
   //     }

   //     if (!grew) {
   //         pieces.remove(0);
    //    }
 //   }

    public void grow() {

        if (getSize() < 3) {
            return;
        }

        grew = true;
        move();
        grew = false;
    }

}
