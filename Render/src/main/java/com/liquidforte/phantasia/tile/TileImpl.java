package com.liquidforte.phantasia.tile;

import com.google.common.base.Objects;
import com.liquidforte.phantasia.api.tile.Tile;

import java.awt.*;

public class TileImpl implements Tile {
    private final Color color;
    private final int x, y;

    public TileImpl(Color color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tile tile)) return false;
        return getX() == tile.getX() && getY() == tile.getY() && Objects.equal(getColor(), tile.getColor());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getColor(), getX(), getY());
    }
}
