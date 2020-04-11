public class RGB {
    private int r;
    private int g;
    private int b;

    public RGB (int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public int luminosity () {
        // 0.21 R + 0.72 G + 0.07 B
        return (int) Math.round(0.21 * r + 0.72 * g + 0.07 * b);
    }

    public int lightness () {
        // max(R, G, B) + min(R, G, B) / 2
        return Math.round(
                Math.max(Math.max(r, g), b) + Math.min(Math.max(r, g), b)
        );
    }

    public int avgBrightness () {
        // (R + G + B) / 3
        return (int) Math.round(
                ((double) r + (double) g + (double) b) / 3
        );
    }
}
