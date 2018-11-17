package arcanesunku;

import java.util.Random;

public class Handler {

    private static Random rand;
    private static Pong game;

    public Handler(Pong game) {
        this.game = game;
        rand = new Random();
    }

    public static String getTitle() {
        return game.getTitle();
    }

    public static void setSeed(long seed) {
        rand.setSeed(seed);
    }

    public static double nextDouble() {
        return rand.nextDouble();
    }

    public static int nextInt(int bounds) {
        return rand.nextInt(bounds);
    }

    public static int nextInt() {
        return rand.nextInt();
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
