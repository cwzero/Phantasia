package com.liquidforte.phantasia.render.grid;

import com.google.inject.Inject;
import com.liquidforte.phantasia.api.engine.EngineSettings;
import com.liquidforte.phantasia.graphics.GLTextureLoader;
import com.liquidforte.phantasia.tile.ColorableTileSet;
import com.liquidforte.phantasia.tile.TileSetLoader;

import java.awt.*;

import static org.lwjgl.opengl.GL11.*;

public class TileGridImpl implements InternalTileGrid {
    public static final float D = 32.0f;
    private final EngineSettings engineSettings;
    private final TileSetLoader loader;
    private ColorableTileSet tileSet = null;
    private int texture = -1;

    @Inject
    public TileGridImpl(EngineSettings engineSettings, TileSetLoader loader) {
        this.engineSettings = engineSettings;
        this.loader = loader;
    }

    protected float getTileWidth() {
        return D / engineSettings.getWindowWidth();
    }

    protected float getTileHeight() {
        return D / engineSettings.getWindowHeight();
    }

    public void drawGrid() {
        if (tileSet == null) {
            tileSet = (ColorableTileSet) loader.loadTileSet("agm");
        }

        if (texture == -1) {
            texture = GLTextureLoader.loadTexture(tileSet.getTile(Color.GREEN, '@'));
        }

        glEnable(GL_TEXTURE_2D); //Enable texturing

        //Enable blending so the green background can be seen through the texture
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);

        glPushMatrix();
        //glTranslatef(100, 100, 0);
        glBindTexture(GL_TEXTURE_2D, texture);
        glBegin(GL_QUADS);
        {
            glTexCoord2f(0, 0);
            glVertex2f(0, 0);

            glTexCoord2f(1, 0);
            glVertex2f(getTileWidth(), 0);

            glTexCoord2f(1, 1);
            glVertex2f(getTileWidth(), getTileHeight());

            glTexCoord2f(0, 1);
            glVertex2f(0, getTileHeight());
        }
        glEnd();
        glPopMatrix();
    }

    @Override
    public void draw() {
        drawGrid();
    }
}
