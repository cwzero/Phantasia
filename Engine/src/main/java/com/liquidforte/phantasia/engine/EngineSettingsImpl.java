package com.liquidforte.phantasia.engine;

import com.google.common.base.Strings;
import com.google.inject.Inject;
import com.liquidforte.phantasia.api.engine.EngineSettings;
import com.liquidforte.phantasia.api.game.GameSettings;

public class EngineSettingsImpl implements EngineSettings {
    private final GameSettings gameSettings;
    private final String windowTitle = "Phantasia";
    private final int windowWidth = 1616;
    private final int windowHeight = 912;

    @Inject
    public EngineSettingsImpl(GameSettings gameSettings) {
        this.gameSettings = gameSettings;
    }

    @Override
    public String getWindowTitle() {
        String gt = gameSettings.getWindowTitle();
        if (Strings.isNullOrEmpty(gt)) {
            return windowTitle;
        }
        return gt;
    }

    @Override
    public int getWindowWidth() {
        int gw = gameSettings.getWindowWidth();
        if (gw <= 0) {
            return windowWidth;
        }
        return gw;
    }

    @Override
    public int getWindowHeight() {
        int gh = gameSettings.getWindowHeight();
        if (gh <= 0) {
            return windowHeight;
        }
        return gh;
    }
}
