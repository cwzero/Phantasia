package com.liquidforte.phantasia.graphics;

import com.liquidforte.phantasia.api.tile.Tile;
import com.liquidforte.phantasia.tile.ColorableTileSet;

import java.util.HashMap;
import java.util.Map;

public class TextureCacheImpl implements com.liquidforte.phantasia.api.graphics.TextureCache {
    private final Map<Tile, Long> textureMap = new HashMap<>();
    private final ColorableTileSet tileSet;

    public TextureCacheImpl(ColorableTileSet tileSet) {
        this.tileSet = tileSet;
    }

    @Override
    public long getTextureId(Tile tile) {
        if (!textureMap.containsKey(tile)) {
            textureMap.put(tile, (long)GLTextureLoader.loadTexture(tileSet.getTile(tile.getColor(), tile.getX(), tile.getY())));
        }
        return textureMap.get(tile);
    }
}
