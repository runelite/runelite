import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lt")
@Implements("FillMode")
public enum FillMode implements Enumerated {
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "Llt;"
	)
	@Export("SOLID")
	SOLID(0, 0),
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Llt;"
	)
	field3847(1, 1),
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Llt;"
	)
	field3849(2, 2);

	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -626837763
	)
	@Export("value")
	public final int value;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -1570105459
	)
	@Export("id")
	final int id;

	FillMode(int var3, int var4) {
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
