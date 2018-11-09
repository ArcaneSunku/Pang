package arcanesunku.states;

import arcanesunku.Handler;
import arcanesunku.Timer;
import arcanesunku.entities.Ball;
import arcanesunku.entities.CPU;
import arcanesunku.entities.Entity;
import arcanesunku.entities.Player;
import arcanesunku.utils.Fonts;

import java.awt.*;

public class GameState extends States {

    private Entity[] entities = new Entity[3];

    private String strpScore = "00", strcScore = "00";
    private int pScore = 0, cScore = 0;

    public GameState(Handler handler) {
        super(handler);

        entities[0] = new Player();
        entities[1] = new CPU();
        entities[2] = new Ball();
    }

    @Override
    public void update() {
        Timer.update();
        
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

        for (int i = 0; i < entities.length; i++) {
            entities[i].update();
        }
    }

    @Override
    public void render(Graphics g) {
        g.setFont(Fonts.MONO.deriveFont(42f));
        g.setColor(Color.WHITE);

        g.drawLine(game.getWidth() / 2 - 1, 0, game.getWidth() / 2 - 1, game.getHeight());
        g.drawLine(game.getWidth() / 2, 0, game.getWidth() / 2, game.getHeight());
        g.drawLine(game.getWidth() / 2 + 1, 0, game.getWidth() / 2 + 1, game.getHeight());

        for (int i = 0; i < entities.length; i++) {
            entities[i].render(g);
        }

        g.setColor(Color.WHITE);
        g.drawString(strpScore, 10, 42);
        g.drawString(strcScore, game.getWidth() - 56, 42);
    }
}
