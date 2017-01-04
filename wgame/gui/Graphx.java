package wgame.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;
import worm.domain.Piece;
import wgame.game.Wgame;

public class Graphx extends JPanel implements Refreshable {

    private Wgame wgame;
    private final int side;

    public Graphx(Wgame wg, int side) {

        this.wgame = wg;
        this.side = side;
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        g.setColor(Color.BLACK);
        for (Piece piece : wgame.getWorm().getPieces()) {
            g.fill3DRect(piece.getX() * side, piece.getY() * side, side, side, true);
        }

        g.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
        g.drawString(wgame.getCounter().numberOfApples() + "", wgame.getCounter().getX(), wgame.getCounter().getY());

        g.setColor(Color.RED);
        g.fillOval(wgame.getApple().getX() * side, wgame.getApple().getY() * side, side, side);

        refresh();
    }

    @Override
    public void refresh() {

        super.repaint();
    }
}
