package com.liquidforte.phantasia.tile;

import java.awt.*;
import java.awt.image.BufferedImage;

public interface ColorableTileSet extends TileSet {
    ColorableTileSet getColor(Color color);

    BufferedImage getTile(Color color, int x, int y);

    BufferedImage getTile(Color color, int tile);

    BufferedImage getTile(Color color, char tile);
}
