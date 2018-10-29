package arcanesunku;

public class Handler {

    private Pong game;

    public Handler(Pong game) {
        this.game = game;
    }

    public String getTitle() {
        return game.getTitle();
    }

    public int WindowWidth() {
        return game.WindowWidth();
    }

    public int WindowHeight() {
        return game.WindowHeight();
    }

    public int getWidth() {
        return game.getWidth();
    }

    public int getHeight() {
        return game.getHeight();
    }

}
