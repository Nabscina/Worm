package wgame.gui;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import wgame.game.Wgame;

public class UI implements Runnable {

    private JFrame frame;
    private Wgame wgame;
    private int side;
    private Graphx graph;

    public UI(Wgame wgame, int side) {

        this.wgame = wgame;
        this.side = side;
    }

    @Override
    public void run() {

        frame = new JFrame("Slippery Slug");
        int width = (wgame.getWidth() + 1) * side + 10;
        int height = (wgame.getHeight() + 2) * side + 10;

        frame.setPreferredSize(new Dimension(width, height));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComps(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    public void createComps(Container container) {

        this.graph = new Graphx(wgame, side);
        container.add(graph);

        KListener kl = new KListener(wgame.getWorm());
        frame.addKeyListener(kl);

    }

    public JFrame getFrame() {

        return frame;
    }

    public Refreshable getRefreshable() {

        return this.graph;
    }

}
