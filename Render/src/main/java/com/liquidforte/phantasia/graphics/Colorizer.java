package com.liquidforte.phantasia.graphics;

import java.awt.*;
import java.awt.image.BufferedImage;

public interface Colorizer {
    BufferedImage colorize(Image input, Color color);
}
