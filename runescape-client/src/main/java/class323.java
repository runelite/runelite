import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ll")
public enum class323 implements Enumerated {
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lll;"
	)
	@Export("SOLID")
	SOLID(0, 0),
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lll;"
	)
	field3887(1, 1),
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lll;"
	)
	field3885(2, 2);

	@ObfuscatedName("ex")
	@ObfuscatedGetter(
		intValue = 1628488091
	)
	static int field3884;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 215627811
	)
	public final int field3886;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 198667019
	)
	final int field3889;

	class323(int var3, int var4) {
		this.field3886 = var3;
		this.field3889 = var4;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "320353268"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.field3889;
	}
}
