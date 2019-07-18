import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iz")
@Implements("HorizontalAlignment")
public enum HorizontalAlignment implements Enumerated {
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Liz;"
	)
	field3461(0, 0),
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Liz;"
	)
	@Export("HorizontalAlignment_centered")
	HorizontalAlignment_centered(2, 1),
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Liz;"
	)
	field3460(1, 2);

	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 1984645021
	)
	@Export("value")
	public final int value;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -2141408149
	)
	@Export("id")
	final int id;

	HorizontalAlignment(int var3, int var4) {
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

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-71692752"
	)
	static int method4701() {
		return ++Messages.Messages_count - 1;
	}
}
