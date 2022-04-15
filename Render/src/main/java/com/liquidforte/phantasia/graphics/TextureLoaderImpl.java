package com.liquidforte.phantasia.graphics;

import com.liquidforte.phantasia.tile.TileSetConfig;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class TextureLoaderImpl implements TextureLoader {
    private InputStream getInput(String fileName) {
        return getClass().getClassLoader().getResourceAsStream(fileName);
    }

    private BufferedImage loadSet(String fileName) {
        try {
            return ImageIO.read(getInput(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public BufferedImage loadSet(TileSetConfig set) {
        return loadSet(set.getFileName() + "." + set.getFileExtension());
    }
}
