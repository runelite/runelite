import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ik")
@Implements("VerticalAlignment")
public enum VerticalAlignment implements Enumerated {
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lik;"
	)
	field3201(2, 0),
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lik;"
	)
	@Export("VerticalAlignment_centered")
	VerticalAlignment_centered(1, 1),
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Lik;"
	)
	field3200(0, 2);

	@ObfuscatedName("gh")
	@Export("regionLandArchives")
	static byte[][] regionLandArchives;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 445419169
	)
	@Export("value")
	public final int value;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -1195481175
	)
	@Export("id")
	final int id;

	VerticalAlignment(int var3, int var4) {
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
