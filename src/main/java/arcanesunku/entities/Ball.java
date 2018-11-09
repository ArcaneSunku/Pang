package arcanesunku.entities;

import arcanesunku.Handler;
import arcanesunku.utils.Images;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Ball extends Entity {

    private BufferedImage texture;
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

    }

    @Override
    public void render(Graphics g) {
//        g.setColor(Color.RED);
//        g.drawRect(bounds.x, bounds.y, bounds.width, bounds.height);
        g.drawImage(texture, bounds.x, bounds.y, bounds.width, bounds.height, null);
    }
}
