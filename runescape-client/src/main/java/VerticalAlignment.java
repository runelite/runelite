import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("if")
@Implements("VerticalAlignment")
public enum VerticalAlignment implements Enumerated {
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lif;"
	)
	field3195(1, 0),
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lif;"
	)
	@Export("VerticalAlignment_centered")
	VerticalAlignment_centered(0, 1),
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lif;"
	)
	field3194(2, 2);

	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -899877695
	)
	static int field3192;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -513284045
	)
	@Export("value")
	public final int value;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -404264531
	)
	@Export("id")
	final int id;

	VerticalAlignment(int var3, int var4) {
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
