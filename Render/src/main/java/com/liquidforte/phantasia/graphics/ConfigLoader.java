package com.liquidforte.phantasia.graphics;

import com.liquidforte.phantasia.tile.TileSetConfig;

public interface ConfigLoader {
    TileSetConfig getConfig(String name);
}
