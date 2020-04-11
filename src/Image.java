import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class Image {
    private BufferedImage img = null;
    private Color[][] pixelMatrix;
    private int width;
    private int height;

    Image (Path path) throws IOException {
        img = ImageIO.read(new File(path.toString()));
        width = img.getWidth();
        height = img.getHeight();
        createPixelMatrix();
    }

    public int getHeight () {
        return height;
    }

    public int getWidth () {
        return width;
    }

    private void createPixelMatrix () {
        pixelMatrix = new Color[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                pixelMatrix[i][j] = new Color(img.getRGB(i, j));
            }
        }
    }

    public Color[][] getPixelMatrix() {
        return pixelMatrix;
    }
}
