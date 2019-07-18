import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("et")
@Implements("TilePaint")
public final class TilePaint {
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 1202729845
	)
	@Export("swColor")
	int swColor;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -1835963633
	)
	@Export("seColor")
	int seColor;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 2057235411
	)
	@Export("neColor")
	int neColor;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -1305916277
	)
	@Export("nwColor")
	int nwColor;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -647321713
	)
	@Export("texture")
	int texture;
	@ObfuscatedName("l")
	@Export("isFlat")
	boolean isFlat;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = 205236161
	)
	@Export("rgb")
	int rgb;

	TilePaint(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
		this.isFlat = true;
		this.swColor = var1;
		this.seColor = var2;
		this.neColor = var3;
		this.nwColor = var4;
		this.texture = var5;
		this.rgb = var6;
		this.isFlat = var7;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(Lhp;III)[Lly;",
		garbageValue = "1591290793"
	)
	public static Sprite[] method3062(AbstractArchive var0, int var1, int var2) {
		if (!Friend.SpriteBuffer_loadSprite(var0, var1, var2)) {
			return null;
		} else {
			Sprite[] var4 = new Sprite[class326.SpriteBuffer_spriteCount];

			for (int var5 = 0; var5 < class326.SpriteBuffer_spriteCount; ++var5) {
				Sprite var6 = var4[var5] = new Sprite();
				var6.width = class326.SpriteBuffer_spriteWidth;
				var6.height = class326.SpriteBuffer_spriteHeight;
				var6.yOffset = Varps.SpriteBuffer_xOffsets[var5];
				var6.xOffset = class326.SpriteBuffer_yOffsets[var5];
				var6.subWidth = class326.SpriteBuffer_spriteWidths[var5];
				var6.subHeight = class216.SpriteBuffer_spriteHeights[var5];
				int var7 = var6.subHeight * var6.subWidth;
				byte[] var8 = class326.SpriteBuffer_pixels[var5];
				var6.pixels = new int[var7];

				for (int var9 = 0; var9 < var7; ++var9) {
					var6.pixels[var9] = Frames.SpriteBuffer_spritePalette[var8[var9] & 255];
				}
			}

			class16.method174();
			return var4;
		}
	}
}
