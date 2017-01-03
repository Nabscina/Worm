package wgame.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import wgame.Direction;
import worm.domain.Worm;

public class KListener implements KeyListener {

    private Worm worm;

    public KListener(Worm worm) {

        this.worm = worm;
    }

    @Override
    public void keyTyped(KeyEvent ke) {

    }

    @Override
    public void keyPressed(KeyEvent ke) {

        if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
            worm.setDirection(Direction.LEFT);
        } else if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
            worm.setDirection(Direction.RIGHT);
        } else if (ke.getKeyCode() == KeyEvent.VK_UP) {
            worm.setDirection(Direction.UP);
        } else if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
            worm.setDirection(Direction.DOWN);
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }

}
