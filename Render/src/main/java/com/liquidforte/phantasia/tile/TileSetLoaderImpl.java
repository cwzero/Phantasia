package com.liquidforte.phantasia.tile;

import com.google.inject.Inject;
import com.liquidforte.phantasia.graphics.ConfigLoader;
import com.liquidforte.phantasia.inject.render.TileSetFactory;

public class TileSetLoaderImpl implements TileSetLoader {
    private final ConfigLoader configLoader;
    private final TileSetFactory tileSetFactory;

    @Inject
    public TileSetLoaderImpl(ConfigLoader configLoader, TileSetFactory tileSetFactory) {
        this.configLoader = configLoader;
        this.tileSetFactory = tileSetFactory;
    }

    @Override
    public TileSet loadTileSet(String name) {
        return tileSetFactory.create(configLoader.getConfig(name));
    }
}
