import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ej")
@Implements("Occluder")
public final class Occluder {
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -868680993
	)
	@Export("minTileX")
	int minTileX;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -78813791
	)
	@Export("maxTileX")
	int maxTileX;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -307237447
	)
	@Export("minTileY")
	int minTileY;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -772985783
	)
	@Export("maxTileY")
	int maxTileY;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 1542494109
	)
	@Export("type")
	int type;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -291894415
	)
	@Export("minX")
	int minX;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = -724655561
	)
	@Export("maxX")
	int maxX;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = 686060305
	)
	@Export("minZ")
	int minZ;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 2092987209
	)
	@Export("maxZ")
	int maxZ;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -264626047
	)
	@Export("minY")
	int minY;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -1980036159
	)
	@Export("maxY")
	int maxY;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -1409166921
	)
	int field1896;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = -307213361
	)
	int field1897;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -1941150605
	)
	int field1898;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 1179191271
	)
	int field1900;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = -1336984119
	)
	int field1890;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -863399609
	)
	int field1901;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = -1653375525
	)
	int field1902;

	Occluder() {
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(II)Lil;",
		garbageValue = "513049272"
	)
	@Export("getObjectDefinition")
	public static ObjectDefinition getObjectDefinition(int var0) {
		ObjectDefinition var1 = (ObjectDefinition)ObjectDefinition.ObjectDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = ObjectDefinition.ObjectDefinition_archive.takeFile(6, var0);
			var1 = new ObjectDefinition();
			var1.id = var0;
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			var1.postDecode();
			if (var1.isSolid) {
				var1.interactType = 0;
				var1.boolean1 = false;
			}

			ObjectDefinition.ObjectDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1792672505"
	)
	public static void method3336() {
		WorldMapElement.WorldMapElement_cachedSprites.clear();
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(B)Lln;",
		garbageValue = "0"
	)
	static Sprite method3338() {
		Sprite var0 = new Sprite();
		var0.width = class325.SpriteBuffer_spriteWidth;
		var0.height = UserComparator9.SpriteBuffer_spriteHeight;
		var0.xOffset = UrlRequester.SpriteBuffer_xOffsets[0];
		var0.yOffset = class216.SpriteBuffer_yOffsets[0];
		var0.subWidth = class325.SpriteBuffer_spriteWidths[0];
		var0.subHeight = VarcInt.SpriteBuffer_spriteHeights[0];
		int var1 = var0.subHeight * var0.subWidth;
		byte[] var2 = FillMode.SpriteBuffer_pixels[0];
		var0.pixels = new int[var1];

		for (int var3 = 0; var3 < var1; ++var3) {
			var0.pixels[var3] = class325.SpriteBuffer_spritePalette[var2[var3] & 255];
		}

		PcmPlayer.method2510();
		return var0;
	}
}
