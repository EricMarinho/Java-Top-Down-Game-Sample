package topdown;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Spritesheet {

    public static BufferedImage spritesheet;

    public static BufferedImage player_front;

    public static BufferedImage tileWall;

    public Spritesheet() {
        try {
            spritesheet = ImageIO.read(getClass().getResource("/spritesheet.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        player_front = Spritesheet.getSprite(0, 11, 16, 16);
        tileWall = Spritesheet.getSprite(280, 221, 16, 16);
    }

    public static BufferedImage getSprite(int x, int y, int width, int height) {
        return spritesheet.getSubimage(x, y, width, height);
    }

}
