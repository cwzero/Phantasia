package com.liquidforte.phantasia.graphics;

import java.awt.*;
import java.awt.image.*;

public class ColorizerImpl implements Colorizer {
    private static final int backIn = -65281;

    private RGBImageFilter transparent() {
        return new RGBImageFilter() {
            @Override
            public int filterRGB(int x, int y, int rgb) {
                return rgb == backIn ? 0 : rgb;
            }
        };
    }

    private RGBImageFilter colorize(Color color) {
        int cRgb = color.getRGB();
        RGBImageFilter transparent = transparent();
        return new RGBImageFilter() {
            @Override
            public int filterRGB(int x, int y, int rgb) {
                return rgb == -1 ? cRgb : transparent.filterRGB(x, y, rgb);
            }
        };
    }

    private BufferedImage toBufferedImage(Image img) {
        if (img instanceof BufferedImage) {
            return (BufferedImage) img;
        }

        // Create a buffered image with transparency
        BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

        // Draw the image on to the buffered image
        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();

        // Return the buffered image
        return bimage;
    }

    private Image filter(Image input, ImageFilter filter) {
        ImageProducer producer = new FilteredImageSource(input.getSource(), filter);
        return Toolkit.getDefaultToolkit().createImage(producer);
    }

    @Override
    public BufferedImage colorize(Image input, Color color) {
        return toBufferedImage(filter(input, colorize(color)));
    }
}
