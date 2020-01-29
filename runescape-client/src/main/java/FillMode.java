import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lf")
@Implements("FillMode")
public enum FillMode implements Enumerated {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Llf;"
	)
	@Export("SOLID")
	SOLID(0, 0),
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Llf;"
	)
	field3858(1, 1),
	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "Llf;"
	)
	field3854(2, 2);

	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -999027833
	)
	@Export("value")
	public final int value;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 2109460743
	)
	@Export("id")
	final int id;

	FillMode(int var3, int var4) {
		this.value = var3;
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
}
