package arcanesunku.states;

import arcanesunku.Handler;
import arcanesunku.entities.CPU;
import arcanesunku.entities.Player;
import arcanesunku.utils.Fonts;

import java.awt.*;

public class GameState extends States {

    private Player player;
    private CPU cpu;

    private String strpScore = "00", strcScore = "00";
    private int pScore = 0, cScore = 0;

    public GameState(Handler handler) {
        super(handler);

        player = new Player();
        cpu = new CPU();
    }

    @Override
    public void update() {
        if (pScore < 10)
            strpScore = "0" + pScore;
        else {
            strpScore = "" + pScore;
        }

        if (cScore < 10)
            strcScore = "0" + cScore;
        else {
            strcScore = "" + cScore;
        }

        player.update();
        cpu.update();
    }

    @Override
    public void render(Graphics g) {
        g.setFont(Fonts.MONO.deriveFont(42f));
        g.setColor(Color.WHITE);

        g.drawLine(game.getWidth() / 2 - 1, 0, game.getWidth() / 2 - 1, game.getHeight());
        g.drawLine(game.getWidth() / 2, 0, game.getWidth() / 2, game.getHeight());
        g.drawLine(game.getWidth() / 2 + 1, 0, game.getWidth() / 2 + 1, game.getHeight());

        player.render(g);
        cpu.render(g);

        g.setColor(Color.WHITE);
        g.drawString(strpScore, 10, 42);
        g.drawString(strcScore, game.getWidth() - 56, 42);
    }
}
