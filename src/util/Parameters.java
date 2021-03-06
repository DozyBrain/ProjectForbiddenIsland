/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;



/**
 *
 * @author Eric
 */
public class Parameters {
    
    // ====================================================================================
    // Paramètres NF
    public static final Boolean LOGS      = true;   // Afficher des traces par System.out.println()
    public static final boolean SHORT_LOG = true;
    public static final Boolean ALEAS     = true;   // Attribuer les aventuriers aléatoirement ou non, mélanger les défausses et les pioches
    public static Lang          LANG      = Lang.EN;
    // Fonts
    public static Font DEFAULT_FONT = initFont();
    // screen
    public static Dimension appSize    = Toolkit.getDefaultToolkit().getScreenSize();
    public static Boolean   fullscreen = true;
    // path
    public static final String RESOURCES  = "./resources/";
    public static final String CARDS      = RESOURCES + "cards/";
    public static final String LOGO       = RESOURCES + "logo/";
    public static final String TILES      = RESOURCES + "tiles/";
    public static final String TREASURES  = RESOURCES + "treasures/";
    public static final String ADVENTURER = RESOURCES + "adventurer/";
    
    
    /**
     * @author nihil
     *
     */
    private static Font initFont() {
        GraphicsEnvironment genv = GraphicsEnvironment.getLocalGraphicsEnvironment();
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, new File("./resources/Treamd.ttf"));
            printLog(font.getFontName() + "is set for the default font", LogType.INFO);
            genv.registerFont(font);
            return font;
        } catch (FontFormatException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    
    
    /**
     * this function allow the log printing management
     * 
     * @author nihil
     *
     */
    public static void printLog(Object text, LogType type) {
        if (LOGS) {
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            if (!SHORT_LOG) {
                System.out.println(
                        type.getColor() + format1.format(cal.getTime()) + " : " + text.toString() + type.getReset());
                
            } else {
                if (type.equals(LogType.INFO)) {
                    System.out.println(type.getColor() + format1.format(cal.getTime()) + " : " + text.toString()
                            + type.getReset());
                } // end if
            } // end if
        } // end if
    }
}
