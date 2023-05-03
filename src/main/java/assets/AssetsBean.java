package assets;

import java.util.HashMap;
import java.util.Map;

import assets.color.Color;
import assets.color.ColorFactory;
import assets.font.Font;
import assets.font.FontFactory;

public class AssetsBean implements Assets {

    private static AssetsBean assets;
    private final ColorFactory colorFactory;
    private final FontFactory fontFactory;
    private final Map<String, Color> colors;
    private final Map<String, Font> fonts;

    private AssetsBean() {
        this.colorFactory = new ColorFactory();
        this.fontFactory = new FontFactory();
        this.colors = new HashMap<>();
        this.fonts = new HashMap<>();
    }

    public static Assets getAssets() {
        if (assets == null) {
            assets = new AssetsBean();
        }
        return assets;
    }

    @Override
    public Color getColor(String name) {
        return this.colors.get(name);
    }

    @Override
    public void addColor(String name, int value) {
        Color color = this.colorFactory.makeArgbColor(value);
        this.colors.put(name, color);
    }

    @Override
    public Font getFont(String name) {
        return this.fonts.get(name);
    }

    @Override
    public void addFont(String name, String path, String symbols) {
        Font font = this.fontFactory.makeRasterFont(path, symbols);
        this.fonts.put(name, font);
    }
}
