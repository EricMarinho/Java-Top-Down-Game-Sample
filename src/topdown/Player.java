package topdown;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Player extends Rectangle {

    public int spd = 4;
    public boolean right, left, up, down;

    public boolean shoot = false;

    public int dir = 1;

    public static List<Bullet> bullets = new ArrayList<Bullet>();

    public Player(int x, int y) {
        super(x, y, 32, 32);
    }

    public void tick() {
        if (right && !World.isColisionWithBlocks(x + spd, y)) {
            x += spd;
            dir = 1;
        } else if (left && !World.isColisionWithBlocks(x - spd, y)) {
            x -= spd;
            dir = -1;
        }
        if (up && !World.isColisionWithBlocks(x, y - spd)) {
            y -= spd;
        } else if (down && !World.isColisionWithBlocks(x, y + spd)) {
            y += spd;
        }

        if (shoot) {
            bullets.add(new Bullet(x, y, dir));
            shoot = false;
        }
        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).tick();
        }
    }

    public void render(Graphics g) {
        g.setColor(new Color(0x8B4513));
        g.fillRect(x, y, width, height);
        // g.drawImage(Spritesheet.player_front, x, y, 32, 32, null);
        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).render(g);
            ;
        }
    }

}
