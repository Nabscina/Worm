package wgame.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;
import wgame.Direction;
import wgame.gui.Refreshable;
import worm.domain.Apple;
import worm.domain.Piece;
import worm.domain.Worm;
import worm.domain.Counter;

public class Wgame extends Timer implements ActionListener {

    private int width;
    private int height;
    private boolean cont;
    private Refreshable refreshable;
    private Worm worm;
    private Apple apple;
    private Random random;
    private Counter counter;

    public Wgame(int w, int h) {

        super(1000, null);

        this.width = w;
        this.height = h;
        this.cont = true;

        if (w < 10) {
            this.width = 10;
        }

        if (h < 10) {
            this.height = 10;
        }

        addActionListener(this);
        setInitialDelay(2000);

        this.worm = new Worm((this.width / 2), (this.height / 2), Direction.DOWN);
        this.random = new Random();
        this.counter = new Counter(5, 25);

        randomApple();

    }

    public boolean goesOn() {

        return cont;
    }

    public void setRefreshable(Refreshable paivitettava) {

        this.refreshable = paivitettava;
    }

    public int getHeight() {

        return height;
    }

    public int getWidth() {

        return width;
    }

    public Worm getWorm() {

        return this.worm;
    }

    public void setWorm(Worm worm) {

        this.worm = worm;
    }

    public Apple getApple() {

        return this.apple;
    }

    public void setApple(Apple apple) {

        this.apple = apple;
    }

    public Counter getCounter() {

        return this.counter;
    }

    public void setCounter(Counter counter) {

        this.counter = counter;
    }

    public void randomApple() {

        while (true) {
            int[] crd = {random.nextInt(this.width - 1) + 1, random.nextInt(this.height - 1) + 1};
            this.apple = new Apple(crd[0], crd[1]);
            Piece piece = new Piece(crd[0], crd[1]);
            if (!this.worm.overlaps(piece)) {
                break;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (!cont) {
            return;
        }

        worm.move();
        Piece piece = new Piece(apple.getX(), apple.getY());

        if (worm.overlaps(piece)) {
            worm.grow();
            counter.grow();
            randomApple();
        }

        if (worm.overlapsItself() || touchesWall()) {
            cont = false;
        }

        refreshable.refresh();

        super.setDelay(1000 / worm.getPieces().size());
    }

    public boolean touchesWall() {

        for (Piece piece : worm.getPieces()) {
            if (piece.getX() == 0 || piece.getX() == this.width || piece.getY() == 0 || piece.getY() == this.height) {
                return true;
            }
        }
        return false;
    }

}
