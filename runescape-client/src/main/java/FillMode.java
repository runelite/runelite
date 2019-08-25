import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ll")
@Implements("FillMode")
public enum FillMode implements Enumerated {
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
	@Export("GRADIENT")
	GRADIENT(1, 1),
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lll;"
	)
	@Export("GRADIENTALPHA")
	GRADIENTALPHA(2, 2);

	@ObfuscatedName("ex")
	@ObfuscatedGetter(
		intValue = 1628488091
	)
	static int field3884;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 215627811
	)
	@Export("value")
	public final int value;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 198667019
	)
	@Export("id")
	final int id;

	FillMode(int var3, int var4) {
		this.value = var3;
		this.id = var4;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "320353268"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}
}
