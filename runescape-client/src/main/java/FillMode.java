import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lb")
@Implements("FillMode")
public enum FillMode implements Enumerated {
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "Llb;"
	)
	@Export("SOLID")
	SOLID(0, 0),
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Llb;"
	)
	field3858(1, 1),
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Llb;"
	)
	field3860(2, 2);

	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -375665689
	)
	@Export("value")
	public final int value;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -839626013
	)
	@Export("id")
	final int id;

	FillMode(int var3, int var4) {
		this.value = var3;
		this.id = var4;
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "-32"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}
}
