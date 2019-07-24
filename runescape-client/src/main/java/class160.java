import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fn")
public enum class160 implements Enumerated {
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lfn;"
	)
	field2005(0, 0),
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lfn;"
	)
	field2004(1, 1),
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lfn;"
	)
	field2001(3, 2),
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lfn;"
	)
	field2002(2, 3);

	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 1749572197
	)
	public final int field2003;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 962065171
	)
	@Export("id")
	final int id;

	class160(int var3, int var4) {
		this.field2003 = var3;
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
