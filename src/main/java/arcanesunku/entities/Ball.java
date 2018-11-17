package arcanesunku.entities;

import arcanesunku.Handler;
import arcanesunku.Timer;
import arcanesunku.states.GameState;
import arcanesunku.utils.Images;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Ball extends Entity {

    private BufferedImage texture;
    private int xMomen, yMomen;
    private boolean isMoving = false;

    public Ball() {
        super("Ball");

        bounds.x = Handler.getWidth() / 2 - (int) (bounds.getWidth() / 2);
        bounds.y = Handler.getHeight() / 2 - (int) (bounds.getHeight() / 2);

        texture = Images.loadImage("ball.png").getSubimage(0, 0, 16, 16);
        Images.tint(texture, new Color(15, 255, 180));
    }

    @Override
    public void update() {
        if (bounds.x <= 0 || bounds.x >= Handler.getWidth() - bounds.width)
            xMomen = -xMomen;
        else if (bounds.y <= 0 || bounds.y >= Handler.getHeight() - bounds.height)
            yMomen = -yMomen;

        if (Timer.getSeconds() >= 1 && !isMoving) {
            xMomen = Handler.nextInt(4 + 1 + 4) - 4;
            yMomen = Handler.nextInt(4 + 1 + 4) - 4;

            if (xMomen == 0) {
                xMomen = Handler.nextInt(4 + 1 + 4) - 4;
                return;
            }

            if (yMomen == 0) {
                yMomen = Handler.nextInt(4 + 1 + 4) - 4;
            }

            bounds.x += xMomen;
            bounds.y += yMomen;
            isMoving = true;
        }

        for (Entity e : GameState.gameEntities) {
            if (hasCollided(e) && !e.equals(this)) {
                xMomen = -xMomen;
            }
        }

        bounds.x += xMomen;
        bounds.y += yMomen;
    }

    @Override
    public void render(Graphics g) {
//        g.setColor(Color.RED);
//        g.drawRect(bounds.x, bounds.y, bounds.width, bounds.height);
        g.drawImage(texture, bounds.x, bounds.y, bounds.width, bounds.height, null);
    }
}
