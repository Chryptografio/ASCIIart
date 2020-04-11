import java.awt.*;
import java.awt.image.ColorModel;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("No file provided.");
            System.exit(-1);
        }

        Path path = Paths.get(args[0]);
        System.out.format("characters' length: %s%n", Constants.CHARACTERS.length());
        try  {
            Image img = new Image(path);
            System.out.format("Width: %s; Height: %s%n", img.getWidth(), img.getHeight());
            int[][] brightnessMatrix = Controller.getAverageBrightnessMatrix(img);
            char[][] chars = Controller.getCharMatrix(brightnessMatrix);
//            for (int i = 0; i < img.getHeight(); i++) {
//                for(int j = 0; j < img.getWidth(); j++) {
//                    for (int k = 0; k < 3; k++) {
//                        System.out.format("%s", chars[j][i]);
//                    }
//                }
//                System.out.format("%n");
//            }
            Image newImg = new Image(path, chars);

        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(-1);
        }


    }
}
