import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lo")
public enum class312 implements Enumerated {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Llo;"
	)
	field3805(0, 0),
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Llo;"
	)
	field3806(1, 1),
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Llo;"
	)
	field3807(4, 2),
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Llo;"
	)
	field3808(6, 3),
	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "Llo;"
	)
	field3809(3, 4),
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Llo;"
	)
	field3811(7, 5),
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Llo;"
	)
	field3810(2, 6),
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Llo;"
	)
	field3812(5, 7),
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Llo;"
	)
	field3813(8, 8);

	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 2054486073
	)
	final int field3814;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -625169807
	)
	@Export("id")
	final int id;

	class312(int var3, int var4) {
		this.field3814 = var3;
		this.id = var4;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1410702910"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}
}
