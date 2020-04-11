import java.awt.*;

public class Controller {
    private static Color[][] getPixelMatrix(Image img) {
        int width = img.getWidth();
        int height = img.getHeight();
        Color[][] pixelMatrix = new Color[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                pixelMatrix[i][j] = new Color(img.getImg().getRGB(i, j));
            }
        }
        return  pixelMatrix;
    }

    public static int[][] getAverageBrightnessMatrix(Image img) {
        int width = img.getWidth();
        int height = img.getHeight();
        Color[][] colorMatrix = getPixelMatrix(img);
        int[][] brightnessMatrix = new int[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                brightnessMatrix[i][j] = new RGB(colorMatrix[i][j].getRed(), colorMatrix[i][j].getGreen(), colorMatrix[i][j].getBlue()).avgBrightness();
            }
        }

        return brightnessMatrix;
    }

    public static int[][] getLightnessMatrix(Image img) {
        // max(R, G, B) + min(R, G, B) / 2
        int width = img.getWidth();
        int height = img.getHeight();
        Color[][] colorMatrix = getPixelMatrix(img);
        int[][] lightnesMatrix = new int[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                lightnesMatrix[i][j] = new RGB(colorMatrix[i][j].getRed(), colorMatrix[i][j].getGreen(), colorMatrix[i][j].getBlue()).lightness();
            }
        }
        return lightnesMatrix;
    }

    public static int[][] getLuminosityMatrix (Image img) {
        int width = img.getWidth();
        int height = img.getHeight();
        Color[][] colorMatrix = getPixelMatrix(img);
        int[][] luminosityMatrix = new int[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                luminosityMatrix[i][j] = new RGB(colorMatrix[i][j].getRed(), colorMatrix[i][j].getGreen(), colorMatrix[i][j].getBlue()).luminosity();
            }
        }
        return luminosityMatrix;
    }

    public static void invertMatrix (int[][] matrix) {
        for (int[] i : matrix) {
            for (int j : i) {
                j = 255 - j;
            }
        }
    }

    public static char[][] getCharMatrix(int[][] matrix) {
        int width = matrix.length;
        int height = matrix[0].length;
        char[][] chars = new char[width][height];
        for (int i = 0; i < width; i++) {
            //chars[i][j] = brightnessMatrix[i][j]
            // 255 - characters.length
            // brightness - math.round;
            for (int j = 0; j < height; j++) {
                chars[i][j] = Constants.CHARACTERS.charAt((int) Math.floor((double) matrix[i][j] * (double) Constants.CHARACTERS.length() / 256.0));
            }
        }
        return chars;
    }

}
