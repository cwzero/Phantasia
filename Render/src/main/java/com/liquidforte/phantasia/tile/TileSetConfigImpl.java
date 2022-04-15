package com.liquidforte.phantasia.tile;

public class TileSetConfigImpl implements TileSetConfig {
    private String name;
    private String fileName;
    private String fileExtension;
    private int setWidth, setHeight;
    private int tileWidth, tileHeight;

    public void setName(String name) {
        this.name = name;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    public void setSetWidth(int setWidth) {
        this.setWidth = setWidth;
    }

    public void setSetHeight(int setHeight) {
        this.setHeight = setHeight;
    }

    public void setTileWidth(int tileWidth) {
        this.tileWidth = tileWidth;
    }

    public void setTileHeight(int tileHeight) {
        this.tileHeight = tileHeight;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getFileName() {
        return fileName;
    }

    @Override
    public String getFileExtension() {
        return fileExtension;
    }

    @Override
    public int getSetWidth() {
        return setWidth;
    }

    @Override
    public int getSetHeight() {
        return setHeight;
    }

    @Override
    public int getTileWidth() {
        return tileWidth;
    }

    @Override
    public int getTileHeight() {
        return tileHeight;
    }
}
