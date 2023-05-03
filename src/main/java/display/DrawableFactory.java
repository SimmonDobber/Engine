package display;

import display.image.Image;
import display.image.ImageFactory;
import display.rectangle.Rectangle;
import display.rectangle.RectangleFactory;
import display.text.Text;
import display.text.TextFactory;

public class DrawableFactory {

    private final RectangleFactory rectangleFactory;
    private final TextFactory textFactory;
    private final ImageFactory imageFactory;

    DrawableFactory() {
        rectangleFactory = new RectangleFactory();
        textFactory = new TextFactory();
        imageFactory = new ImageFactory();
    }

    public Rectangle makeRectangle(int x, int y, int w, int h, String colorName) {
        return rectangleFactory.makeRectangle(x, y, w, h, colorName);
    }

    public Rectangle makeFramedRectangle(int x, int y, int w, int h, int frameThickness, String colorName, String frameColorName) {
        return rectangleFactory.makeFramedRectangle(x, y, w, h, frameThickness, colorName, frameColorName);
    }

    public Text makeText(String text, int x, int y, String fontName, String colorName) {
        return textFactory.makeText(text, x, y, fontName, colorName);
    }

    public Image makeImage(String path, int x, int y) {
        return imageFactory.makeImage(path, x, y);
    }

}
