package com.liquidforte.phantasia.tile;

import com.google.inject.assistedinject.Assisted;
import com.liquidforte.phantasia.graphics.TextureLoader;

import javax.inject.Inject;
import java.awt.image.BufferedImage;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

public class TileSetImpl implements TileSet {
    public static final Charset CONVERSION = Charset.forName("Cp437");
    protected final TileSetConfig config;
    protected final BufferedImage set;

    @Inject
    public TileSetImpl(TextureLoader loader, @Assisted TileSetConfig config) {
        this(config, loader.loadSet(config));
    }

    public TileSetImpl(TileSetConfig config, BufferedImage set) {
        this.config = config;
        this.set = set;
    }

    @Override
    public int getTileWidth() {
        return config.getTileWidth();
    }

    @Override
    public int getTileHeight() {
        return config.getTileHeight();
    }

    @Override
    public BufferedImage getTile(int x, int y) {
        return set.getSubimage(x * config.getTileWidth(), y * config.getTileHeight(), config.getTileWidth(), config.getTileHeight());
    }

    @Override
    public BufferedImage getTile(int tile) {
        if (tile < 0) {
            tile += 256;
        }
        return getTile(tile % 16, tile / 16);
    }

    @Override
    public BufferedImage getTile(char tile) {
        return getTile(CONVERSION.encode(CharBuffer.wrap(new char[]{tile})).get());
    }
}

