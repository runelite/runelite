import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fr")
public enum class160 implements Enumerated {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lfr;"
	)
	field1975(1, 0),
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lfr;"
	)
	field1972(2, 1),
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lfr;"
	)
	field1973(3, 2),
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Lfr;"
	)
	field1974(0, 3);

	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 361058639
	)
	@Export("Interpreter_intStackSize")
	static int Interpreter_intStackSize;
	@ObfuscatedName("d")
	static int[][] field1977;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -1405442637
	)
	public final int field1978;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 1965131589
	)
	@Export("id")
	final int id;

	class160(int var3, int var4) {
		this.field1978 = var3;
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

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(IB)I",
		garbageValue = "2"
	)
	@Export("Messages_getHistorySize")
	static int Messages_getHistorySize(int var0) {
		ChatChannel var1 = (ChatChannel)Messages.Messages_channels.get(var0);
		return var1 == null ? 0 : var1.size();
	}

	@ObfuscatedName("gr")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-744343031"
	)
	static boolean method3419() {
		return (Client.drawPlayerNames & 1) != 0;
	}
}
