package com.liquidforte.phantasia.tile;

import java.awt.image.BufferedImage;

public interface TileSet {
    int getTileWidth();

    int getTileHeight();

    BufferedImage getTile(int x, int y);

    BufferedImage getTile(int tile);

    BufferedImage getTile(char tile);
}
