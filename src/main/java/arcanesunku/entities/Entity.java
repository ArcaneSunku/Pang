package arcanesunku.entities;

import java.awt.*;

public abstract class Entity {

    protected Rectangle bounds;
    protected String name;

    public Entity(String name, int x, int y, int width, int height) {
        this.name = name;
        bounds = new Rectangle(x, y, width, height);
    }

    public Entity(String name) {
        this(name, 0, 0, 32, 32);
    }

    public abstract void update();

    public abstract void render(Graphics g);

    public Rectangle getBounds() {
        return bounds;
    }

    public boolean hasCollided(Rectangle other) {
        return this.bounds.intersects(other);
    }

}
