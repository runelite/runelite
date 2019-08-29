import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ia")
@Implements("VerticalAlignment")
public enum VerticalAlignment implements Enumerated {
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "Lia;"
	)
	field3172(1, 0),
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Lia;"
	)
	@Export("VerticalAlignment_centered")
	VerticalAlignment_centered(0, 1),
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lia;"
	)
	field3174(2, 2);

	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -1694558565
	)
	@Export("value")
	public final int value;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 817798203
	)
	@Export("id")
	final int id;

	VerticalAlignment(int var3, int var4) {
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
