package arcanesunku.states;

import arcanesunku.Handler;

import java.awt.*;

public abstract class States {

    private static States currentState = null;

    public static States getState() {
        return currentState;
    }

    public static void setState(States state) {
        currentState = state;
    }

    protected Handler game;

    public States(Handler handler) {
        this.game = handler;
    }

    public abstract void update();

    public abstract void render(Graphics g);

}
