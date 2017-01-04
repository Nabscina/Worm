package wgame;

import javax.swing.SwingUtilities;
import wgame.game.Wgame;
import wgame.gui.UI;

public class Main {

    public static void main(String[] args) {

        Wgame wgame = new Wgame(25, 25);

        UI ui = new UI(wgame, 20);
        SwingUtilities.invokeLater(ui);

        while (ui.getRefreshable() == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
            }
        }

        wgame.setRefreshable(ui.getRefreshable());
        wgame.start();

    }
}
