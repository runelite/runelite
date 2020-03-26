import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lu")
public enum class332 implements Enumerated {
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Llu;"
	)
	@Export("SOLID")
	SOLID(0, 0),
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Llu;"
	)
	field3874(1, 1),
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Llu;"
	)
	field3875(2, 2);

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Ldh;"
	)
	@Export("soundSystem")
	static SoundSystem soundSystem;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 1537098807
	)
	public final int field3873;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -92633923
	)
	@Export("id")
	final int id;

	class332(int var3, int var4) {
		this.field3873 = var3;
		this.id = var4;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "56"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}
}
