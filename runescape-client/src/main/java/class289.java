import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ko")
public final class class289 {
	@ObfuscatedName("q")
	@Export("base37Table")
	static final char[] base37Table;
	@ObfuscatedName("w")
	static long[] field3669;

	static {
		base37Table = new char[]{'_', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		field3669 = new long[12];

		for (int var0 = 0; var0 < field3669.length; ++var0) {
			field3669[var0] = (long)Math.pow(37.0D, (double)var0);
		}

	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Lhp;III)[Llx;",
		garbageValue = "1777014825"
	)
	public static IndexedSprite[] method5281(AbstractArchive var0, int var1, int var2) {
		if (!Friend.SpriteBuffer_loadSprite(var0, var1, var2)) {
			return null;
		} else {
			IndexedSprite[] var4 = new IndexedSprite[class326.SpriteBuffer_spriteCount];

			for (int var5 = 0; var5 < class326.SpriteBuffer_spriteCount; ++var5) {
				IndexedSprite var6 = var4[var5] = new IndexedSprite();
				var6.width = class326.SpriteBuffer_spriteWidth;
				var6.height = class326.SpriteBuffer_spriteHeight;
				var6.xOffset = Varps.SpriteBuffer_xOffsets[var5];
				var6.yOffset = class326.SpriteBuffer_yOffsets[var5];
				var6.subWidth = class326.SpriteBuffer_spriteWidths[var5];
				var6.subHeight = class216.SpriteBuffer_spriteHeights[var5];
				var6.palette = Frames.SpriteBuffer_spritePalette;
				var6.pixels = class326.SpriteBuffer_pixels[var5];
			}

			class16.method174();
			return var4;
		}
	}
}
