package topdown;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Enemy extends Rectangle {

    public int spd = 2;

    public boolean shoot = false;

    public int dir = 1;

    public Enemy(int x, int y) {
        super(x, y, 32, 32);
    }

    public void FollowPlayer() {
        Player p = Game.player;
        if (p.x > x && !World.isColisionWithBlocks(x + spd, y)) {
            x += spd;
        } else if (p.x < x && !World.isColisionWithBlocks(x + spd, y)) {
            x -= spd;

        }
        if (p.y > y && !World.isColisionWithBlocks(x + spd, y)) {
            y += spd;
        } else if (p.y < y && !World.isColisionWithBlocks(x + spd, y)) {
            y -= spd;
        }
    }

    public void tick() {
        FollowPlayer();
    }

    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, width, height);
    }

}