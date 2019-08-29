import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ib")
@Implements("HorizontalAlignment")
public enum HorizontalAlignment implements Enumerated {
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "Lib;"
	)
	field3436(2, 0),
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Lib;"
	)
	@Export("HorizontalAlignment_centered")
	HorizontalAlignment_centered(1, 1),
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lib;"
	)
	field3435(0, 2);

	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -1418723399
	)
	@Export("value")
	public final int value;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 1581275369
	)
	@Export("id")
	final int id;

	HorizontalAlignment(int var3, int var4) {
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
