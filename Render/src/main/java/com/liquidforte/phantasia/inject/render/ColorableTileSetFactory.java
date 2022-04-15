package com.liquidforte.phantasia.inject.render;

import com.liquidforte.phantasia.tile.ColorableTileSet;
import com.liquidforte.phantasia.tile.TileSetConfig;

public interface ColorableTileSetFactory extends TileSetFactory {
    @Override
    ColorableTileSet create(TileSetConfig config);
}
