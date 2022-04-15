package com.liquidforte.phantasia.inject.render;

import com.google.inject.AbstractModule;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import com.liquidforte.phantasia.api.grid.TileGrid;
import com.liquidforte.phantasia.engine.EngineWindow;
import com.liquidforte.phantasia.graphics.*;
import com.liquidforte.phantasia.render.LWJGLEngineWindowImpl;
import com.liquidforte.phantasia.render.grid.InternalTileGrid;
import com.liquidforte.phantasia.render.grid.TileGridImpl;
import com.liquidforte.phantasia.tile.*;

public class RenderModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(EngineWindow.class).to(LWJGLEngineWindowImpl.class).asEagerSingleton();
        bind(TileGrid.class).to(InternalTileGrid.class);
        bind(InternalTileGrid.class).to(TileGridImpl.class).asEagerSingleton();
        bind(Colorizer.class).to(ColorizerImpl.class);
        bind(TextureLoader.class).to(TextureLoaderImpl.class);
        bind(ConfigLoader.class).to(ConfigLoaderImpl.class);
        bind(TileSetLoader.class).to(TileSetLoaderImpl.class);

        bind(TileSetFactory.class).to(ColorableTileSetFactory.class);
        install(new FactoryModuleBuilder().implement(ColorableTileSet.class, ColorableTileSetImpl.class)
                .build(ColorableTileSetFactory.class));
    }
}
