import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ip")
@Implements("HorizontalAlignment")
public enum HorizontalAlignment implements Enumerated {
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lip;"
	)
	field3462(1, 0),
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lip;"
	)
	@Export("HorizontalAlignment_centered")
	HorizontalAlignment_centered(2, 1),
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Lip;"
	)
	field3458(0, 2);

	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -1180720231
	)
	@Export("value")
	public final int value;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 1019628395
	)
	@Export("id")
	final int id;

	HorizontalAlignment(int var3, int var4) {
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
