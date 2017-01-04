package worm.domain;

public class Counter extends Piece {

    private int apples;

    public Counter(int x, int y) {

        super(x, y);
    }

    public void grow() {

        apples++;
    }

    public int numberOfApples() {

        return apples;
    }
}
