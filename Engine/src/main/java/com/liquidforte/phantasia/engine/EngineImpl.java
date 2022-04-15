package com.liquidforte.phantasia.engine;

import com.google.inject.Inject;
import com.liquidforte.phantasia.api.engine.Engine;

public class EngineImpl implements Engine {
    private final EngineWindow window;

    @Inject
    public EngineImpl(EngineWindow window) {
        this.window = window;
    }

    @Override
    public void start() {
        window.start();
    }

    @Override
    public void stop() {
        window.stop();
    }
}
