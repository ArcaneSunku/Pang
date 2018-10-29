package arcanesunku.utils;

import java.awt.*;
import java.io.IOException;

public class Fonts {

    public static Font CUBIC = Fonts.loadFont("cubic").deriveFont(32f); // 32pt
    public static Font MONO = Fonts.loadFont("MonoVCRosd").deriveFont(20f); // 20pt

    public static Font loadFont(String fontName) {
        try {
            return Font.createFont(Font.TRUETYPE_FONT, Fonts.class.getResourceAsStream("/assets/fnts/" + fontName + ".ttf"));
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
            System.err.println("Couldn't load font!");
            return null;
        }
    }

}
