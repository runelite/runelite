import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ho")
@Implements("Skills")
public class Skills {
	@ObfuscatedName("m")
	@Export("Skills_enabled")
	public static final boolean[] Skills_enabled;
	@ObfuscatedName("k")
	@Export("Skills_experienceTable")
	public static int[] Skills_experienceTable;

	static {
		Skills_enabled = new boolean[]{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false};
		Skills_experienceTable = new int[99];
		int var0 = 0;

		for (int var1 = 0; var1 < 99; ++var1) {
			int var2 = var1 + 1;
			int var3 = (int)((double)var2 + 300.0D * Math.pow(2.0D, (double)var2 / 7.0D));
			var0 += var3;
			Skills_experienceTable[var1] = var0 / 4;
		}

	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(I)[Lle;",
		garbageValue = "1897656979"
	)
	public static IndexedSprite[] method4214() {
		IndexedSprite[] var0 = new IndexedSprite[class335.SpriteBuffer_spriteCount];

		for (int var1 = 0; var1 < class335.SpriteBuffer_spriteCount; ++var1) {
			IndexedSprite var2 = var0[var1] = new IndexedSprite();
			var2.width = class335.SpriteBuffer_spriteWidth;
			var2.height = class335.SpriteBuffer_spriteHeight;
			var2.xOffset = class335.SpriteBuffer_xOffsets[var1];
			var2.yOffset = StructDefinition.SpriteBuffer_yOffsets[var1];
			var2.subWidth = class335.SpriteBuffer_spriteWidths[var1];
			var2.subHeight = class335.SpriteBuffer_spriteHeights[var1];
			var2.palette = DefaultsGroup.SpriteBuffer_spritePalette;
			var2.pixels = class4.SpriteBuffer_pixels[var1];
		}

		Ignored.method5235();
		return var0;
	}
}
