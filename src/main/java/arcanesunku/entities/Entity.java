package arcanesunku.entities;

import java.awt.*;

public abstract class Entity {

    protected Rectangle bounds;
    protected String name;
    protected boolean boundsCollide = false;

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

    public boolean hasCollided(Entity other) {
        return getBounds().intersects(other.getX(), other.getY(), other.getWidth(), other.getHeight());
    }

    public boolean hasCollided(Rectangle other) {
        return getBounds().intersects(other);
    }

    public String getName() {
        return name;
    }

    public int getX() {
        return bounds.x;
    }

    public int getY() {
        return bounds.y;
    }

    public int getWidth() {
        return bounds.width;
    }

    public int getHeight() {
        return bounds.height;
    }
}
