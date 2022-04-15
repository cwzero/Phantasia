package com.liquidforte.phantasia.api.game;

public interface GameSettings {
    default String getWindowTitle() {
        return null;
    }

    default int getWindowWidth() {
        return -1;
    }

    default int getWindowHeight() {
        return -1;
    }
}
