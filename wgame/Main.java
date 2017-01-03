package wgame;

import javax.swing.SwingUtilities;
import wgame.game.Wgame;
import wgame.gui.UI;

public class Main {

    public static void main(String[] args) {

        Wgame wgame = new Wgame(20, 20);

        UI kali = new UI(wgame, 20);
        SwingUtilities.invokeLater(kali);

        while (kali.getRefreshable() == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {

            }
        }

        wgame.setRefreshable(kali.getRefreshable());
        wgame.start();

    }
}
