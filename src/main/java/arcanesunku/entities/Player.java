package arcanesunku.entities;

import arcanesunku.utils.Images;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Entity {

    private BufferedImage texture;

    public Player() {
        super("Player");

        bounds.x = 32;
        bounds.y = 480 / 2 - 64;

        texture = Images.loadImage("paddle.png").getSubimage(0, 0, 16, 32);
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(texture, bounds.x, bounds.y, bounds.width * 2, bounds.y * 2, null);
    }
}
