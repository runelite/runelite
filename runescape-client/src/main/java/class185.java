import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gw")
public class class185 {
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lgw;"
	)
	public static final class185 field2322;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lgw;"
	)
	public static final class185 field2316;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lgw;"
	)
	public static final class185 field2318;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lgw;"
	)
	public static final class185 field2317;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lgw;"
	)
	public static final class185 field2324;
	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "Lgw;"
	)
	public static final class185 field2319;
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Lgw;"
	)
	public static final class185 field2320;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lgw;"
	)
	public static final class185 field2321;
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lgw;"
	)
	public static final class185 field2315;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lgw;"
	)
	public static final class185 field2323;

	static {
		field2322 = new class185(7);
		field2316 = new class185(15);
		field2318 = new class185(14);
		field2317 = new class185(6);
		field2324 = new class185(4);
		field2319 = new class185(5);
		field2320 = new class185(2);
		field2321 = new class185(3);
		field2315 = new class185(5);
		field2323 = new class185(4);
	}

	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "7"
	)
	class185(int var1) {
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(CI)Z",
		garbageValue = "2012637233"
	)
	@Export("isCharAlphabetic")
	public static boolean isCharAlphabetic(char var0) {
		return var0 >= 'A' && var0 <= 'Z' || var0 >= 'a' && var0 <= 'z';
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "([BB)V",
		garbageValue = "-41"
	)
	@Export("SpriteBuffer_decode")
	static void SpriteBuffer_decode(byte[] var0) {
		Buffer var1 = new Buffer(var0);
		var1.offset = var0.length - 2;
		class326.SpriteBuffer_spriteCount = var1.readUnsignedShort();
		Varps.SpriteBuffer_xOffsets = new int[class326.SpriteBuffer_spriteCount];
		class326.SpriteBuffer_yOffsets = new int[class326.SpriteBuffer_spriteCount];
		class326.SpriteBuffer_spriteWidths = new int[class326.SpriteBuffer_spriteCount];
		class216.SpriteBuffer_spriteHeights = new int[class326.SpriteBuffer_spriteCount];
		class326.SpriteBuffer_pixels = new byte[class326.SpriteBuffer_spriteCount][];
		var1.offset = var0.length - 7 - class326.SpriteBuffer_spriteCount * 8;
		class326.SpriteBuffer_spriteWidth = var1.readUnsignedShort();
		class326.SpriteBuffer_spriteHeight = var1.readUnsignedShort();
		int var2 = (var1.readUnsignedByte() & 255) + 1;

		int var3;
		for (var3 = 0; var3 < class326.SpriteBuffer_spriteCount; ++var3) {
			Varps.SpriteBuffer_xOffsets[var3] = var1.readUnsignedShort();
		}

		for (var3 = 0; var3 < class326.SpriteBuffer_spriteCount; ++var3) {
			class326.SpriteBuffer_yOffsets[var3] = var1.readUnsignedShort();
		}

		for (var3 = 0; var3 < class326.SpriteBuffer_spriteCount; ++var3) {
			class326.SpriteBuffer_spriteWidths[var3] = var1.readUnsignedShort();
		}

		for (var3 = 0; var3 < class326.SpriteBuffer_spriteCount; ++var3) {
			class216.SpriteBuffer_spriteHeights[var3] = var1.readUnsignedShort();
		}

		var1.offset = var0.length - 7 - class326.SpriteBuffer_spriteCount * 8 - (var2 - 1) * 3;
		Frames.SpriteBuffer_spritePalette = new int[var2];

		for (var3 = 1; var3 < var2; ++var3) {
			Frames.SpriteBuffer_spritePalette[var3] = var1.readMedium();
			if (Frames.SpriteBuffer_spritePalette[var3] == 0) {
				Frames.SpriteBuffer_spritePalette[var3] = 1;
			}
		}

		var1.offset = 0;

		for (var3 = 0; var3 < class326.SpriteBuffer_spriteCount; ++var3) {
			int var4 = class326.SpriteBuffer_spriteWidths[var3];
			int var5 = class216.SpriteBuffer_spriteHeights[var3];
			int var6 = var5 * var4;
			byte[] var7 = new byte[var6];
			class326.SpriteBuffer_pixels[var3] = var7;
			int var8 = var1.readUnsignedByte();
			int var9;
			if (var8 == 0) {
				for (var9 = 0; var9 < var6; ++var9) {
					var7[var9] = var1.readByte();
				}
			} else if (var8 == 1) {
				for (var9 = 0; var9 < var4; ++var9) {
					for (int var10 = 0; var10 < var5; ++var10) {
						var7[var9 + var10 * var4] = var1.readByte();
					}
				}
			}
		}

	}
}
