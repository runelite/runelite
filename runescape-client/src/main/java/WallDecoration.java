import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("et")
@Implements("WallDecoration")
public final class WallDecoration {
	@ObfuscatedName("bf")
	static String field1914;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 1205113251
	)
	@Export("tileHeight")
	int tileHeight;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -271474909
	)
	@Export("x")
	int x;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -1267605537
	)
	@Export("y")
	int y;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -1727501807
	)
	@Export("orientation")
	int orientation;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 1125268543
	)
	@Export("orientation2")
	int orientation2;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -1924743317
	)
	@Export("xOffset")
	int xOffset;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = -2072940953
	)
	@Export("yOffset")
	int yOffset;
	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "Lee;"
	)
	@Export("entity1")
	public Entity entity1;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lee;"
	)
	@Export("entity2")
	public Entity entity2;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		longValue = -1256134443736608047L
	)
	@Export("tag")
	public long tag;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 1975621391
	)
	@Export("flags")
	int flags;

	WallDecoration() {
		this.tag = 0L;
		this.flags = 0;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(IB)Lig;",
		garbageValue = "-81"
	)
	public static FloorUnderlayDefinition method3339(int var0) {
		FloorUnderlayDefinition var1 = (FloorUnderlayDefinition)FloorUnderlayDefinition.FloorUnderlayDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = FloorUnderlayDefinition.FloorUnderlayDefinition_archive.takeFile(1, var0);
			var1 = new FloorUnderlayDefinition();
			if (var2 != null) {
				var1.decode(new Buffer(var2), var0);
			}

			var1.postDecode();
			FloorUnderlayDefinition.FloorUnderlayDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("f")
	public static boolean method3340(long var0) {
		boolean var2 = var0 != 0L;
		if (var2) {
			boolean var3 = (int)(var0 >>> 16 & 1L) == 1;
			var2 = !var3;
		}

		return var2;
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(B)[Llm;",
		garbageValue = "-38"
	)
	public static IndexedSprite[] method3341() {
		IndexedSprite[] var0 = new IndexedSprite[class325.SpriteBuffer_spriteCount];

		for (int var1 = 0; var1 < class325.SpriteBuffer_spriteCount; ++var1) {
			IndexedSprite var2 = var0[var1] = new IndexedSprite();
			var2.width = class325.SpriteBuffer_spriteWidth;
			var2.height = UserComparator9.SpriteBuffer_spriteHeight;
			var2.xOffset = UrlRequester.SpriteBuffer_xOffsets[var1];
			var2.yOffset = class216.SpriteBuffer_yOffsets[var1];
			var2.subWidth = class325.SpriteBuffer_spriteWidths[var1];
			var2.subHeight = VarcInt.SpriteBuffer_spriteHeights[var1];
			var2.palette = class325.SpriteBuffer_spritePalette;
			var2.pixels = FillMode.SpriteBuffer_pixels[var1];
		}

		PcmPlayer.method2510();
		return var0;
	}
}
