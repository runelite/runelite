import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ei")
@Implements("WallDecoration")
public final class WallDecoration {
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 1872492475
	)
	@Export("tileHeight")
	int tileHeight;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -185034131
	)
	@Export("x")
	int x;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -1951564087
	)
	@Export("y")
	int y;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 1472564709
	)
	@Export("orientation")
	int orientation;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 909597607
	)
	@Export("orientation2")
	int orientation2;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 1726678055
	)
	@Export("xOffset")
	int xOffset;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -1895972445
	)
	@Export("yOffset")
	int yOffset;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Leo;"
	)
	@Export("entity1")
	public Entity entity1;
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Leo;"
	)
	@Export("entity2")
	public Entity entity2;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		longValue = -3118431343692928767L
	)
	@Export("tag")
	public long tag;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -359663539
	)
	@Export("flags")
	int flags;

	WallDecoration() {
		this.tag = 0L;
		this.flags = 0;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "([BI)Lke;",
		garbageValue = "107452813"
	)
	@Export("getWorldMapSprite")
	public static Font getWorldMapSprite(byte[] var0) {
		if (var0 == null) {
			return null;
		} else {
			Font var1 = new Font(var0, Varps.SpriteBuffer_xOffsets, class326.SpriteBuffer_yOffsets, class326.SpriteBuffer_spriteWidths, class216.SpriteBuffer_spriteHeights, Frames.SpriteBuffer_spritePalette, class326.SpriteBuffer_pixels);
			class16.method174();
			return var1;
		}
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "-2066331179"
	)
	public static int method3292(int var0) {
		if (var0 > 0) {
			return 1;
		} else {
			return var0 < 0 ? -1 : 0;
		}
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "2093071208"
	)
	protected static final void method3291() {
		GameShell.clock.mark();

		int var0;
		for (var0 = 0; var0 < 32; ++var0) {
			GameShell.field452[var0] = 0L;
		}

		for (var0 = 0; var0 < 32; ++var0) {
			GameShell.field453[var0] = 0L;
		}

		GameShell.field449 = 0;
	}
}
