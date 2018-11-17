package arcanesunku;

import arcanesunku.states.MenuState;
import arcanesunku.states.States;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Pong extends Canvas implements Runnable {

    private BufferStrategy bufferStrat;
    private Graphics graphics;
    private JFrame frame;
    private Thread thread;

    private Handler handler;
    private InputHandler input;

    private String title;
    private int width, height;
    private boolean running = false;

    public Pong(int width, int height) {
        this.title = "Pang";
        this.width = width;
        this.height = height;

        Dimension dim = new Dimension(width, height);

        setMinimumSize(dim);
        setMaximumSize(dim);
        setPreferredSize(dim);

        System.out.println();
    }

    public synchronized void start() {
        if (running) return;

        thread = new Thread(this, "Pong_Thread");
        running = true;
        thread.start();
    }

    public synchronized void stop() {

    }

    @Override
    public void run() {
        // FPS Limiter Variables
        long lastTime = System.nanoTime();
        double nsPerTick = 1000000000D / 60D;

        @SuppressWarnings("unused")
        int updates = 0;
        int frames = 0;

        long lastTimer = System.currentTimeMillis();
        double delta = 0; // unprocessed ns that have gone by
        // FPS Limiter Variables End

        init();

        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / nsPerTick;
            lastTime = now;
            boolean shouldRender = false;

            while (delta >= 1) {
                updates++;
                update(frames + 1);
                delta -= 1;
                shouldRender = true;
            }

            try {
                // makes sure the thread sleeps for 2 milliseconds
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (shouldRender) {
                frames++;
                render();
            }
            if (System.currentTimeMillis() - lastTimer >= 1000) {
                lastTimer += 1000;
                frames = 0;
                updates = 0;
            }
        }
        stop();
    }

    public int WindowWidth() {
        return width;
    }

    public int WindowHeight() {
        return height;
    }

    private void init() {
        frame = new JFrame("Pong Clone");
        input = new InputHandler();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(this, BorderLayout.CENTER);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setFocusable(false);

        addKeyListener(input);
        addMouseListener(input);
        addMouseMotionListener(input);

        handler = new Handler(this);

        States.setState(new MenuState(handler));
    }

    private void update(double dt) {
        Timer.gameTime = dt;
        Handler.setSeed(System.nanoTime());

        input.update();

        if (States.getState() != null)
            States.getState().update();
    }

    private void render() {
        bufferStrat = getBufferStrategy();

        if (bufferStrat == null) {
            createBufferStrategy(2);
            return;
        }

        graphics = bufferStrat.getDrawGraphics();
        graphics.setColor(new Color(0, 0, 0));
        graphics.fillRect(0, 0, getWidth(), getHeight());

        if (States.getState() != null)
            States.getState().render(graphics);

        graphics.dispose();
        bufferStrat.show();
    }

    public String getTitle() {
        return title;
    }

    public static void main(String[] args) {
        new Pong(640, 480).start();
    }
}