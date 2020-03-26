import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("am")
@Implements("WorldMapSprite")
public final class WorldMapSprite {
	@ObfuscatedName("da")
	@ObfuscatedSignature(
		signature = "Lih;"
	)
	@Export("archive3")
	static Archive archive3;
	@ObfuscatedName("m")
	@Export("tileColors")
	final int[] tileColors;

	WorldMapSprite() {
		this.tileColors = new int[4096];
	}

	WorldMapSprite(int[] var1) {
		this.tileColors = var1;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "1469556779"
	)
	@Export("getTileColor")
	final int getTileColor(int var1, int var2) {
		return this.tileColors[var1 + var2 * 64];
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(II)Lce;",
		garbageValue = "1891668899"
	)
	@Export("getScript")
	static Script getScript(int var0) {
		Script var1 = (Script)Script.Script_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = class41.archive12.takeFile(var0, 0);
			if (var2 == null) {
				return null;
			} else {
				var1 = SecureRandomCallable.newScript(var2);
				Script.Script_cached.put(var1, (long)var0);
				return var1;
			}
		}
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(IIIII)V",
		garbageValue = "-173221436"
	)
	static final void method514(int var0, int var1, int var2, int var3) {
		for (int var4 = var1; var4 <= var3 + var1; ++var4) {
			for (int var5 = var0; var5 <= var0 + var2; ++var5) {
				if (var5 >= 0 && var5 < 104 && var4 >= 0 && var4 < 104) {
					SoundCache.field1462[0][var5][var4] = 127;
					if (var0 == var5 && var5 > 0) {
						Tiles.Tiles_heights[0][var5][var4] = Tiles.Tiles_heights[0][var5 - 1][var4];
					}

					if (var0 + var2 == var5 && var5 < 103) {
						Tiles.Tiles_heights[0][var5][var4] = Tiles.Tiles_heights[0][var5 + 1][var4];
					}

					if (var4 == var1 && var4 > 0) {
						Tiles.Tiles_heights[0][var5][var4] = Tiles.Tiles_heights[0][var5][var4 - 1];
					}

					if (var3 + var1 == var4 && var4 < 103) {
						Tiles.Tiles_heights[0][var5][var4] = Tiles.Tiles_heights[0][var5][var4 + 1];
					}
				}
			}
		}

	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(Lkb;II)V",
		garbageValue = "-1583850141"
	)
	public static void method510(Buffer var0, int var1) {
		if (JagexCache.JagexCache_randomDat != null) {
			try {
				JagexCache.JagexCache_randomDat.seek(0L);
				JagexCache.JagexCache_randomDat.write(var0.array, var1, 24);
			} catch (Exception var3) {
			}
		}

	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(B)[Lla;",
		garbageValue = "10"
	)
	static Sprite[] method516() {
		Sprite[] var0 = new Sprite[class335.SpriteBuffer_spriteCount];

		for (int var1 = 0; var1 < class335.SpriteBuffer_spriteCount; ++var1) {
			Sprite var2 = var0[var1] = new Sprite();
			var2.width = class335.SpriteBuffer_spriteWidth;
			var2.height = class335.SpriteBuffer_spriteHeight;
			var2.xOffset = class335.SpriteBuffer_xOffsets[var1];
			var2.yOffset = StructDefinition.SpriteBuffer_yOffsets[var1];
			var2.subWidth = class335.SpriteBuffer_spriteWidths[var1];
			var2.subHeight = class335.SpriteBuffer_spriteHeights[var1];
			int var3 = var2.subHeight * var2.subWidth;
			byte[] var4 = class4.SpriteBuffer_pixels[var1];
			var2.pixels = new int[var3];

			for (int var5 = 0; var5 < var3; ++var5) {
				var2.pixels[var5] = DefaultsGroup.SpriteBuffer_spritePalette[var4[var5] & 255];
			}
		}

		class335.SpriteBuffer_xOffsets = null;
		StructDefinition.SpriteBuffer_yOffsets = null;
		class335.SpriteBuffer_spriteWidths = null;
		class335.SpriteBuffer_spriteHeights = null;
		DefaultsGroup.SpriteBuffer_spritePalette = null;
		class4.SpriteBuffer_pixels = null;
		return var0;
	}
}
