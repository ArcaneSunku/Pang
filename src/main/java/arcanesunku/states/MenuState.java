package arcanesunku.states;

import arcanesunku.Handler;
import arcanesunku.InputHandler;
import arcanesunku.utils.Fonts;

import java.awt.*;
import java.awt.event.KeyEvent;

public class MenuState extends States {

    private int tX, tY;

    public MenuState(Handler handler) {
        super(handler);

        tX = game.getWidth() / 2 - (game.getTitle().length() / 2 * 36);
        tY = game.getHeight() / 2;
    }

    @Override
    public void update() {
        if (InputHandler.isKeyPressed(KeyEvent.VK_SPACE)) {
            States.setState(new GameState(game));
            game = null;
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(new Color(194, 125, 55));
        g.setFont(Fonts.MONO.deriveFont(80f));
        g.drawString(game.getTitle().toUpperCase(), tX - 30, tY);
        g.setColor(new Color(110, 70, 31));
        g.setFont(Fonts.MONO.deriveFont(32f));
        g.drawString("Press Space to Start!", tX / 2, tY + 32 * 4);
    }
}
