package topdown;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.awt.Rectangle;

public class World {

    public static List<Blocks> blocks = new ArrayList<Blocks>();

    public World() {
        for (int i = 0; i < 15; i++) {
            blocks.add(new Blocks(i * 32, 0));
        }

        for (int i = 0; i < 15; i++) {
            blocks.add(new Blocks(i * 32, 480 - 32));
        }

        for (int i = 0; i < 15; i++) {
            blocks.add(new Blocks(0, i * 32));
        }

        for (int i = 0; i < 15; i++) {
            blocks.add(new Blocks(480 - 32, i * 32));
        }

    }

    public static boolean isColisionWithBlocks(int xnext, int ynext) {
        for (int i = 0; i < blocks.size(); i++) {
            Blocks block = blocks.get(i);
            if (block.intersects(new Rectangle(xnext, ynext, 32, 32))) {
                return true;
            }
        }
        return false;
    }

    public void render(Graphics g) {
        for (int i = 0; i < blocks.size(); i++) {
            blocks.get(i).render(g);
        }
    }

}
