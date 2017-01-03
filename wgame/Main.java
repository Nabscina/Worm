package wgame;

import worm.domain.Worm;

public class Main {

    public static void main(String[] args) {

        Worm w = new Worm(5, 5, Direction.RIGHT);

        System.out.println(w.getPieces());
        w.move();
        System.out.println(w.getPieces());
        w.move();
        System.out.println(w.getPieces());
        w.move();
        System.out.println(w.getPieces());

        w.grow();
        System.out.println(w.getPieces());
        w.move();
        System.out.println(w.getPieces());

        w.setDirection(Direction.LEFT);
        System.out.println(w.overlapsItself());
        w.move();
        System.out.println(w.overlapsItself());

    }
}
