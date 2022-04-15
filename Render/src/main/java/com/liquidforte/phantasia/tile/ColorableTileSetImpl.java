package com.liquidforte.phantasia.tile;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import com.liquidforte.phantasia.graphics.Colorizer;
import com.liquidforte.phantasia.graphics.TextureLoader;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.CharBuffer;
import java.util.HashMap;
import java.util.Map;

public class ColorableTileSetImpl extends TileSetImpl implements ColorableTileSet {
    private final Colorizer colorizer;
    private ColorableTileSet root = null;
    private final Map<Color, ColorableTileSet> colors = new HashMap<>();

    public ColorableTileSetImpl(ColorableTileSet root, Colorizer colorizer, TextureLoader loader, @Assisted TileSetConfig config) {
        this(colorizer, config, loader.loadSet(config));
        this.root = root;
    }

    @Inject
    public ColorableTileSetImpl(Colorizer colorizer, TextureLoader loader, @Assisted TileSetConfig config) {
        this(colorizer, config, loader.loadSet(config));
    }

    public ColorableTileSetImpl(ColorableTileSet root, Colorizer colorizer, TileSetConfig config, BufferedImage set) {
        super(config, set);
        this.colorizer = colorizer;
        this.root = root;
    }

    public ColorableTileSetImpl(Colorizer colorizer, TileSetConfig config, BufferedImage set) {
        super(config, set);
        this.colorizer = colorizer;
    }

    @Override
    public ColorableTileSet getColor(Color color) {
        if (!colors.containsKey(color)) {
            ColorableTileSet r = root;
            if (r == null) {
                r = this;
            }
            colors.put(color, new ColorableTileSetImpl(r, colorizer, config, colorizer.colorize(set, color)));
        }
        return colors.get(color);
    }

    @Override
    public BufferedImage getTile(Color color, int x, int y) {
        return getColor(color).getTile(x, y);
    }

    @Override
    public BufferedImage getTile(Color color, int tile) {
        if (tile < 0) {
            tile += 256;
        }
        return getTile(color, tile % 16, tile / 16);
    }

    @Override
    public BufferedImage getTile(Color color, char tile) {
        return getTile(color, CONVERSION.encode(CharBuffer.wrap(new char[]{tile})).get());
    }
}
