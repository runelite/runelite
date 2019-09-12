import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ie")
@Implements("HorizontalAlignment")
public enum HorizontalAlignment implements Enumerated {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lie;"
	)
	field3428(2, 0),
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lie;"
	)
	@Export("HorizontalAlignment_centered")
	HorizontalAlignment_centered(1, 1),
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lie;"
	)
	field3430(0, 2);

	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -490726387
	)
	@Export("value")
	public final int value;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 501971729
	)
	@Export("id")
	final int id;

	HorizontalAlignment(int var3, int var4) {
		this.value = var3;
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
