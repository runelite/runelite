import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("et")
@Implements("FaceNormal")
public class FaceNormal {
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 1677646269
	)
	@Export("x")
	int x;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 531566341
	)
	@Export("y")
	int y;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = 1439819501
	)
	@Export("z")
	int z;

	FaceNormal() {
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Lii;Lii;III)Lko;",
		garbageValue = "1973799897"
	)
	public static Font method3335(AbstractArchive var0, AbstractArchive var1, int var2, int var3) {
		if (!class228.method4199(var0, var2, var3)) {
			return null;
		} else {
			byte[] var5 = var1.takeFile(var2, var3);
			Font var4;
			if (var5 == null) {
				var4 = null;
			} else {
				Font var6 = new Font(var5, Huffman.SpriteBuffer_xOffsets, NPC.SpriteBuffer_yOffsets, class326.SpriteBuffer_spriteWidths, class326.SpriteBuffer_spriteHeights, class326.SpriteBuffer_spritePalette, class326.SpriteBuffer_pixels);
				DynamicObject.method2292();
				var4 = var6;
			}

			return var4;
		}
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "2042389443"
	)
	public static boolean method3334() {
		ReflectionCheck var0 = (ReflectionCheck)class96.reflectionChecks.last();
		return var0 != null;
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(Lii;Ljava/lang/String;Ljava/lang/String;I)[Lli;",
		garbageValue = "326479912"
	)
	public static IndexedSprite[] method3336(AbstractArchive var0, String var1, String var2) {
		int var3 = var0.getGroupId(var1);
		int var4 = var0.getFileId(var3, var2);
		IndexedSprite[] var5;
		if (!class228.method4199(var0, var3, var4)) {
			var5 = null;
		} else {
			IndexedSprite[] var7 = new IndexedSprite[class326.SpriteBuffer_spriteCount];

			for (int var8 = 0; var8 < class326.SpriteBuffer_spriteCount; ++var8) {
				IndexedSprite var9 = var7[var8] = new IndexedSprite();
				var9.width = GZipDecompressor.SpriteBuffer_spriteWidth;
				var9.height = class326.SpriteBuffer_spriteHeight;
				var9.xOffset = Huffman.SpriteBuffer_xOffsets[var8];
				var9.yOffset = NPC.SpriteBuffer_yOffsets[var8];
				var9.subWidth = class326.SpriteBuffer_spriteWidths[var8];
				var9.subHeight = class326.SpriteBuffer_spriteHeights[var8];
				var9.palette = class326.SpriteBuffer_spritePalette;
				var9.pixels = class326.SpriteBuffer_pixels[var8];
			}

			DynamicObject.method2292();
			var5 = var7;
		}

		return var5;
	}
}
