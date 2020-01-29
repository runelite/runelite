import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bs")
@Implements("PendingSpawn")
public final class PendingSpawn extends Node {
	@ObfuscatedName("sx")
	@ObfuscatedSignature(
		signature = "Ld;"
	)
	@Export("grandExchangeEvents")
	static GrandExchangeEvents grandExchangeEvents;
	@ObfuscatedName("hu")
	@ObfuscatedGetter(
		intValue = -1923954935
	)
	@Export("oculusOrbFocalPointX")
	static int oculusOrbFocalPointX;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -1349370787
	)
	@Export("plane")
	int plane;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 304063961
	)
	@Export("type")
	int type;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = -340804777
	)
	@Export("x")
	int x;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 1612075495
	)
	@Export("y")
	int y;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 1762819513
	)
	@Export("objectId")
	int objectId;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 51558137
	)
	int field935;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 1078181875
	)
	int field924;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 869281397
	)
	@Export("id")
	int id;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -186510347
	)
	@Export("orientation")
	int orientation;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 1858623199
	)
	int field933;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -260343907
	)
	@Export("delay")
	int delay;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = 1816335395
	)
	@Export("hitpoints")
	int hitpoints;

	PendingSpawn() {
		this.delay = 0;
		this.hitpoints = -1;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(I)Llt;",
		garbageValue = "-728987489"
	)
	static Sprite method1738() {
		Sprite var0 = new Sprite();
		var0.width = GZipDecompressor.SpriteBuffer_spriteWidth;
		var0.height = class326.SpriteBuffer_spriteHeight;
		var0.xOffset = Huffman.SpriteBuffer_xOffsets[0];
		var0.yOffset = NPC.SpriteBuffer_yOffsets[0];
		var0.subWidth = class326.SpriteBuffer_spriteWidths[0];
		var0.subHeight = class326.SpriteBuffer_spriteHeights[0];
		int var1 = var0.subWidth * var0.subHeight;
		byte[] var2 = class326.SpriteBuffer_pixels[0];
		var0.pixels = new int[var1];

		for (int var3 = 0; var3 < var1; ++var3) {
			var0.pixels[var3] = class326.SpriteBuffer_spritePalette[var2[var3] & 255];
		}

		DynamicObject.method2292();
		return var0;
	}
}
