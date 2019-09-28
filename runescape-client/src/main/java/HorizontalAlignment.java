import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("in")
@Implements("HorizontalAlignment")
public enum HorizontalAlignment implements Enumerated {
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Lin;"
	)
	field3444(1, 0),
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lin;"
	)
	@Export("HorizontalAlignment_centered")
	HorizontalAlignment_centered(2, 1),
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lin;"
	)
	field3442(0, 2);

	@ObfuscatedName("q")
	public static short[] field3447;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 87636045
	)
	@Export("value")
	public final int value;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = 1916297519
	)
	@Export("id")
	final int id;

	HorizontalAlignment(int var3, int var4) {
		this.value = var3;
		this.id = var4;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(S)I",
		garbageValue = "221"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}
}
