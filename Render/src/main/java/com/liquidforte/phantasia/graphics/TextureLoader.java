package com.liquidforte.phantasia.graphics;

import com.liquidforte.phantasia.tile.TileSetConfig;

import java.awt.image.BufferedImage;

public interface TextureLoader {
    BufferedImage loadSet(TileSetConfig config);
}
