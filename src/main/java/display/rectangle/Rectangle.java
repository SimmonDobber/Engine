package display.rectangle;

import java.util.Arrays;

import assets.color.Color;
import display.Drawable;
import lombok.Getter;
import lombok.Setter;

public class Rectangle implements Drawable {

    @Getter
    protected final int[] p;
    @Getter
    @Setter
    protected int x;
    @Getter
    @Setter
    protected int y;
    @Getter
    protected final int w;
    @Getter
    protected final int h;
    protected final Color color;

    Rectangle(int x, int y, int w, int h, Color color) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.color = color;
        this.p = new int[w * h];
        Arrays.fill(p, color.getValue());
    }

}
