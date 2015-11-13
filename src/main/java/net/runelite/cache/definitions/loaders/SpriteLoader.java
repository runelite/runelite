package net.runelite.cache.definitions.loaders;

import java.util.HashSet;
import java.util.List;
import net.runelite.cache.definitions.SpriteDefinition;
import net.runelite.cache.io.InputStream;

public class SpriteLoader
{
	private SpriteDefinition[] sprites;
	//private List<SpriteDefinition> sprites = new HashSet<>();
//    public int paletteChildCount;
//    public int[] loadedSpriteOffsetX;
//    public int[] loadedSpriteOffsetY;
//    public int[] loadedSpriteWidth;
//    public int[] loadedSpriteHeight;
//    public byte[][] loadedSpritePixels;
    public int[] loadedPalette;
    public int loadedSpriteMaxWidth;
    public int loadedSpriteMaxHeight;

    //@Override
    public void decode(InputStream stream)
    {
        stream.setOffset(stream.getLength() - 2);
        int paletteChildCount = stream.readUnsignedShort();
	sprites = new SpriteDefinition[paletteChildCount];
	for (int i = 0; i < paletteChildCount; ++i)
		sprites[i] = new SpriteDefinition(this);
        //loadedSpriteOffsetX = new int[paletteChildCount ];
        //loadedSpriteOffsetY = new int[paletteChildCount];
        //loadedSpriteWidth = new int[paletteChildCount];
        //loadedSpriteHeight = new int[paletteChildCount];
        //loadedSpritePixels = new byte[paletteChildCount][];
        stream.setOffset(stream.getLength() - 7 - paletteChildCount * 8);
        loadedSpriteMaxWidth = stream.readUnsignedShort();
        loadedSpriteMaxHeight = stream.readUnsignedShort();
        int var3 = (stream.readUnsignedByte() & 255) + 1;

        int spriteIndex;
        for(spriteIndex = 0; spriteIndex < paletteChildCount; ++spriteIndex) {
		sprites[spriteIndex].setOffsetX(stream.readUnsignedShort());
        }

        for(spriteIndex = 0; spriteIndex < paletteChildCount; ++spriteIndex) {
		sprites[spriteIndex].setOffsetY(stream.readUnsignedShort());
        }

        for(spriteIndex = 0; spriteIndex < paletteChildCount; ++spriteIndex) {
		sprites[spriteIndex].setWidth(stream.readUnsignedShort());
        }

        for(spriteIndex = 0; spriteIndex < paletteChildCount; ++spriteIndex) {
		sprites[spriteIndex].setHeight(stream.readUnsignedShort());
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
		SpriteDefinition def = sprites[spriteIndex];
            int width = def.getWidth();
            int height = def.getHeight();
            int dimmension = width * height;
            byte[] loadPixels = new byte[dimmension];
            //loadedSpritePixels[spriteIndex] = loadPixels;
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
	    def.setPixels(loadPixels);
        }
    }
    
    

//    public static SpriteDefinition getLastLoadedPaletteSprite() {
//        SpriteDefinition paletteSprite = new SpriteDefinition(0);
//        paletteSprite.maxWidth = loadedSpriteMaxWidth;
//        paletteSprite.maxHeight = loadedSpriteMaxHeight;
//        paletteSprite.offsetX = loadedSpriteOffsetX[0];
//        paletteSprite.offsetY = loadedSpriteOffsetY[0];
//        paletteSprite.width = loadedSpriteWidth[0];
//        paletteSprite.height = loadedSpriteHeight[0];
//        paletteSprite.palette = loadedPalette;
//        paletteSprite.pixels = loadedSpritePixels[0];
//        resetLastPaletteValues();
//        return paletteSprite;
//    }
//
//    public static void resetLastPaletteValues() {
//        loadedSpriteOffsetX = null;
//        loadedSpriteOffsetY = null;
//        loadedSpriteWidth = null;
//        loadedSpriteHeight = null;
//        loadedPalette = null;
//        loadedSpritePixels = null;
//    }
//
//    public static SpriteDefinition[] loadPaletteSpriteSet() {
//        SpriteDefinition[] palettes = new SpriteDefinition[paletteChildCount];
//        for (int paletteIndex = 0; paletteIndex < paletteChildCount; ++paletteIndex) {
//            SpriteDefinition palette = palettes[paletteIndex] = new SpriteDefinition(0);
//            palette.maxWidth = loadedSpriteMaxWidth;
//            palette.maxHeight = loadedSpriteMaxHeight;
//            palette.offsetX = loadedSpriteOffsetX[paletteIndex];
//            palette.offsetY = loadedSpriteOffsetY[paletteIndex];
//            palette.width = loadedSpriteWidth[paletteIndex];
//            palette.height = loadedSpriteHeight[paletteIndex];
//            palette.palette = loadedPalette;
//            palette.pixels = loadedSpritePixels[paletteIndex];
//        }
//
//        resetLastPaletteValues();
//        return palettes;
//    }
    

	public SpriteDefinition[] getSprites()
	{
		return sprites;
	}
}
