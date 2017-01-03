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

public class Wgame extends Timer implements ActionListener {

    private int width;
    private int height;
    private boolean cont;
    private Refreshable refreshable;
    private Worm worm;
    private Apple apple;
    private Random random;

    public Wgame(int w, int h) {
        
        super(1000, null);

        this.width = w;
        this.height = h;
        this.cont = true;

        addActionListener(this);
        setInitialDelay(2000);

        this.worm = new Worm((this.width / 2), (this.height / 2), Direction.DOWN);
        this.random = new Random();

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

    public void randomApple() {

        while (true) {
            int[] crd = {random.nextInt(this.width), random.nextInt(this.height)};
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
