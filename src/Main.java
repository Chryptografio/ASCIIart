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
        try  {
            Image img = new Image(path);
            System.out.format("Width: %s; Height: %s%n", img.getWidth(), img.getHeight());
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(-1);
        }


    }
}
