package com.liquidforte.phantasia.inject.engine;

import com.google.inject.AbstractModule;
import com.liquidforte.phantasia.api.engine.Engine;
import com.liquidforte.phantasia.api.engine.EngineSettings;
import com.liquidforte.phantasia.engine.EngineImpl;
import com.liquidforte.phantasia.engine.EngineSettingsImpl;

public class EngineModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Engine.class).to(EngineImpl.class).asEagerSingleton();
        bind(EngineSettings.class).to(EngineSettingsImpl.class).asEagerSingleton();
    }
}
