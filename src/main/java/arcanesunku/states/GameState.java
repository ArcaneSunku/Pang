package arcanesunku.states;

import arcanesunku.Handler;
import arcanesunku.entities.CPU;
import arcanesunku.entities.Player;

import java.awt.*;

public class GameState extends States {

    private Player player;
    private CPU cpu;

    public GameState(Handler handler) {
        super(handler);

        player = new Player();
        cpu = new CPU();
    }

    @Override
    public void update() {
        player.update();
        cpu.update();
    }

    @Override
    public void render(Graphics g) {
        player.render(g);
        cpu.render(g);
    }
}
