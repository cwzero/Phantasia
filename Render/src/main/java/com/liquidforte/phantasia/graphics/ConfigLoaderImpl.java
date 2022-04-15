package com.liquidforte.phantasia.graphics;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;
import com.liquidforte.phantasia.tile.TileSetConfig;
import com.liquidforte.phantasia.tile.TileSetConfigImpl;

import java.io.IOException;
import java.io.InputStream;

public class ConfigLoaderImpl implements ConfigLoader {
    private final ObjectMapper mapper;

    @Inject
    public ConfigLoaderImpl(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    private InputStream getInput(String fileName) {
        return getClass().getClassLoader().getResourceAsStream(fileName);
    }

    @Override
    public TileSetConfig getConfig(String name) {
        try {
            return mapper.readValue(getInput(name + ".json"), TileSetConfigImpl.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
