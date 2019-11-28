import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lz")
@Implements("FillMode")
public enum FillMode implements Enumerated {
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Llz;"
	)
	@Export("SOLID")
	SOLID(0, 0),
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Llz;"
	)
	field3854(1, 1),
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Llz;"
	)
	field3855(2, 2);

	@ObfuscatedName("w")
	@Export("SpriteBuffer_pixels")
	static byte[][] SpriteBuffer_pixels;
	@ObfuscatedName("l")
	@Export("BZip2Decompressor_block")
	static int[] BZip2Decompressor_block;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 80643323
	)
	@Export("value")
	public final int value;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 1639591945
	)
	@Export("id")
	final int id;

	FillMode(int var3, int var4) {
		this.value = var3;
		this.id = var4;
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "7"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}
}
