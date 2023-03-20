package topdown;

import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Graphics;

public class Blocks extends Rectangle {

    public Blocks(int x, int y) {
        setBounds(x, y, 32, 32);
    }

    public void render(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect(x, y, width, height);
        // g.drawImage(Spritesheet.tileWall, x, y, 32, 32, null);
    }

}
