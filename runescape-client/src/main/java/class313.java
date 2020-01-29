import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ld")
public enum class313 implements Enumerated {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lld;"
	)
	field3815(5, 0),
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lld;"
	)
	field3812(4, 2),
	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "Lld;"
	)
	field3809(1, 5),
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lld;"
	)
	field3808(3, 6),
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lld;"
	)
	field3811(2, 7),
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Lld;"
	)
	field3810(0, 8);

	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -2058457901
	)
	final int field3813;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -695700033
	)
	@Export("id")
	final int id;

	class313(int var3, int var4) {
		this.field3813 = var3;
		this.id = var4;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "1"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(I)Lli;",
		garbageValue = "-432973503"
	)
	public static IndexedSprite method5962() {
		IndexedSprite var0 = new IndexedSprite();
		var0.width = GZipDecompressor.SpriteBuffer_spriteWidth;
		var0.height = class326.SpriteBuffer_spriteHeight;
		var0.xOffset = Huffman.SpriteBuffer_xOffsets[0];
		var0.yOffset = NPC.SpriteBuffer_yOffsets[0];
		var0.subWidth = class326.SpriteBuffer_spriteWidths[0];
		var0.subHeight = class326.SpriteBuffer_spriteHeights[0];
		var0.palette = class326.SpriteBuffer_spritePalette;
		var0.pixels = class326.SpriteBuffer_pixels[0];
		DynamicObject.method2292();
		return var0;
	}
}
