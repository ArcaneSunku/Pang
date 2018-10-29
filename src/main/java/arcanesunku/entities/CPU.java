package arcanesunku.entities;

import arcanesunku.utils.Images;

import java.awt.*;
import java.awt.image.BufferedImage;

public class CPU extends Entity {

    private BufferedImage texture;

    public CPU() {
        super("CPU");

        bounds.x = (640 - 52) - bounds.width;
        bounds.y = 480 / 2 - 64;

        texture = Images.loadImage("paddle.png").getSubimage(16, 0, 16, 32);
        Images.tint(texture, new Color(5, 51, 18));
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(texture, bounds.x, bounds.y, bounds.width * 2, bounds.y, null);
    }
}
