package net.runelite.cache.definitions;

import net.runelite.cache.io.InputStream;

/**
 * Created by Allen Kinzalow on 3/15/2015.
 */
public class SpriteDefinition extends Definition {

    int offsetX;
    int offsetY;
    int width;
    int height;
    int[] palette;
    byte[] pixels;
    int maxWidth;
    int maxHeight;

    public static int paletteChildCount;
    public static int[] loadedSpriteOffsetX;
    public static int[] loadedSpriteOffsetY;
    public static int[] loadedSpriteWidth;
    public static int[] loadedSpriteHeight;
    public static byte[][] loadedSpritePixels;
    public static int[] loadedPalette;
    public static int loadedSpriteMaxWidth;
    public static int loadedSpriteMaxHeight;

    public SpriteDefinition(int definitionID) {
        super(definitionID);
    }

    @Override
    public void decode(InputStream stream) {
        stream.setOffset(stream.getLength() - 2);
        paletteChildCount = stream.readUnsignedShort();
        loadedSpriteOffsetX = new int[paletteChildCount ];
        loadedSpriteOffsetY = new int[paletteChildCount];
        loadedSpriteWidth = new int[paletteChildCount];
        loadedSpriteHeight = new int[paletteChildCount];
        loadedSpritePixels = new byte[paletteChildCount][];
        stream.setOffset(stream.getLength() - 7 - paletteChildCount * 8);
        loadedSpriteMaxWidth = stream.readUnsignedShort();
        loadedSpriteMaxHeight = stream.readUnsignedShort();
        int var3 = (stream.readUnsignedByte() & 255) + 1;

        int spriteIndex;
        for(spriteIndex = 0; spriteIndex < paletteChildCount; ++spriteIndex) {
            loadedSpriteOffsetX[spriteIndex] = stream.readUnsignedShort();
        }

        for(spriteIndex = 0; spriteIndex < paletteChildCount; ++spriteIndex) {
            loadedSpriteOffsetY[spriteIndex] = stream.readUnsignedShort();
        }

        for(spriteIndex = 0; spriteIndex < paletteChildCount; ++spriteIndex) {
            loadedSpriteWidth[spriteIndex] = stream.readUnsignedShort();
        }

        for(spriteIndex = 0; spriteIndex < paletteChildCount; ++spriteIndex) {
            loadedSpriteHeight[spriteIndex] = stream.readUnsignedShort();
        }

        stream.setOffset(stream.getLength() - 7 - paletteChildCount * 8 - (var3 - 1) * 3);
        loadedPalette = new int[var3];

        for(spriteIndex = 1; spriteIndex < var3; ++spriteIndex) {
            loadedPalette[spriteIndex] = stream.read24BitInt();
            if(0 == loadedPalette[spriteIndex]) {
                loadedPalette[spriteIndex] = 1;
            }
        }

        stream.setOffset(0);

        for(spriteIndex = 0; spriteIndex < paletteChildCount; ++spriteIndex) {
            int width = loadedSpriteWidth[spriteIndex];
            int height = loadedSpriteHeight[spriteIndex];
            int dimmension = width * height;
            byte[] loadPixels = new byte[dimmension];
            loadedSpritePixels[spriteIndex] = loadPixels;
            int var4 = stream.readUnsignedByte();
            int var5;
            if(var4 == 0) {
                for(var5 = 0; var5 < dimmension; ++var5) {
                    loadPixels[var5] = (byte)stream.readByte();
                }
            } else if(1 == var4) {
                for(var5 = 0; var5 < width; ++var5) {
                    for(int var8 = 0; var8 < height; ++var8) {
                        loadPixels[width * var8 + var5] = (byte)stream.readByte();
                    }
                }
            }
        }
    }

    public static SpriteDefinition getLastLoadedPaletteSprite() {
        SpriteDefinition paletteSprite = new SpriteDefinition(0);
        paletteSprite.maxWidth = loadedSpriteMaxWidth;
        paletteSprite.maxHeight = loadedSpriteMaxHeight;
        paletteSprite.offsetX = loadedSpriteOffsetX[0];
        paletteSprite.offsetY = loadedSpriteOffsetY[0];
        paletteSprite.width = loadedSpriteWidth[0];
        paletteSprite.height = loadedSpriteHeight[0];
        paletteSprite.palette = loadedPalette;
        paletteSprite.pixels = loadedSpritePixels[0];
        resetLastPaletteValues();
        return paletteSprite;
    }

    public static void resetLastPaletteValues() {
        loadedSpriteOffsetX = null;
        loadedSpriteOffsetY = null;
        loadedSpriteWidth = null;
        loadedSpriteHeight = null;
        loadedPalette = null;
        loadedSpritePixels = null;
    }

    public static SpriteDefinition[] loadPaletteSpriteSet() {
        SpriteDefinition[] palettes = new SpriteDefinition[paletteChildCount];
        for (int paletteIndex = 0; paletteIndex < paletteChildCount; ++paletteIndex) {
            SpriteDefinition palette = palettes[paletteIndex] = new SpriteDefinition(0);
            palette.maxWidth = loadedSpriteMaxWidth;
            palette.maxHeight = loadedSpriteMaxHeight;
            palette.offsetX = loadedSpriteOffsetX[paletteIndex];
            palette.offsetY = loadedSpriteOffsetY[paletteIndex];
            palette.width = loadedSpriteWidth[paletteIndex];
            palette.height = loadedSpriteHeight[paletteIndex];
            palette.palette = loadedPalette;
            palette.pixels = loadedSpritePixels[paletteIndex];
        }

        resetLastPaletteValues();
        return palettes;
    }
    
    @Override
    void decodeValues(int opcode, InputStream stream) { }
}
