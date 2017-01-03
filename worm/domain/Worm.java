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

    public void move() {

        if (pieces.size() <= 2 || this.grew == true) {
            xs = xs;
        } else {
            pieces.remove(0);
        }

        if (this.direction == Direction.DOWN) {
            this.ys++;
            pieces.add(new Piece(this.xs, this.ys));
        } else if (this.direction == Direction.RIGHT) {
            this.xs++;
            pieces.add(new Piece(this.xs, this.ys));
        } else if (this.direction == Direction.LEFT) {
            this.xs--;
            pieces.add(new Piece(this.xs, this.ys));
        } else if (this.direction == Direction.UP) {
            this.ys--;
            pieces.add(new Piece(this.xs, this.ys));
        }

        this.grew = false;
    }

    public void grow() {

        this.grew = true;
    }

    public boolean overlaps(Piece piece) {

        for (Piece piece1 : pieces) {
            if (piece1.overlaps(piece)) {
                return true;
            }
        }

        return false;
    }

    public boolean overlapsItself() {

        for (Piece piece : pieces) {
            for (Piece piece1 : pieces) {
                if ((!piece.equals(piece1)) && piece.overlaps(piece1)) {
                    return true;
                }
            }
        }

        return false;
    }

}
