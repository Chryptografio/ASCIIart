import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class Image {
    private BufferedImage img;
    private int width;
    private int height;

    Image (Path path) throws IOException {
        img = ImageIO.read(new File(path.toString()));
        width = img.getWidth();
        height = img.getHeight();
    }

    Image (Path path, char[][] chars) throws IOException {
        img = new BufferedImage(chars.length, chars[0].length, 1);
        Graphics2D g = (Graphics2D) img.getGraphics();
        g.drawString("h", 10, 10);
        JLabel picLabel = new JLabel(new ImageIcon(img));
        JPanel jPanel = new JPanel();
        jPanel.add(picLabel);
        JFrame f = new JFrame();
        f.setSize(new Dimension(img.getWidth(), img.getHeight()));
        f.add(jPanel);
        f.setVisible(true);
    }

    public int getHeight () {
        return height;
    }

    public int getWidth () {
        return width;
    }

    public BufferedImage getImg () {
        return img;
    }
}
