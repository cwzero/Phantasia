package com.liquidforte.phantasia.inject.render;

import com.liquidforte.phantasia.tile.TileSet;
import com.liquidforte.phantasia.tile.TileSetConfig;

public interface TileSetFactory {
    TileSet create(TileSetConfig config);
}
