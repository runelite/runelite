import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("in")
@Implements("HorizontalAlignment")
public enum HorizontalAlignment implements Enumerated {
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "Lin;"
	)
	field3449(0, 0),
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lin;"
	)
	@Export("HorizontalAlignment_centered")
	HorizontalAlignment_centered(1, 1),
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lin;"
	)
	field3447(2, 2);

	@ObfuscatedName("i")
	@Export("ByteArrayPool_arrays")
	static byte[][][] ByteArrayPool_arrays;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 1143014811
	)
	@Export("value")
	public final int value;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -510132141
	)
	@Export("id")
	final int id;

	HorizontalAlignment(int var3, int var4) {
		this.value = var3;
		this.id = var4;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1993081102"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}
}
