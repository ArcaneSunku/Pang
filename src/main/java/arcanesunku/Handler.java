package arcanesunku;

public class Handler {

    private static Pong game;

    public Handler(Pong game) {
        this.game = game;
    }

    public static String getTitle() {
        return game.getTitle();
    }

    public static int WindowWidth() {
        return game.WindowWidth();
    }

    public static int WindowHeight() {
        return game.WindowHeight();
    }

    public static int getWidth() {
        return game.getWidth();
    }

    public static int getHeight() {
        return game.getHeight();
    }

}
