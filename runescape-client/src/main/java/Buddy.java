import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("je")
@Implements("Buddy")
public class Buddy extends User {
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -1462953665
	)
	@Export("world")
	public int world;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 179134735
	)
	@Export("int2")
	public int int2;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -1349530221
	)
	@Export("rank")
	public int rank;

	Buddy() {
		this.world = -1;
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "1991575010"
	)
	@Export("set")
	void set(int var1, int var2) {
		this.world = var1;
		this.int2 = var2;
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1822334974"
	)
	@Export("getWorld")
	public int getWorld() {
		return this.world;
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "-101"
	)
	@Export("hasWorld")
	public boolean hasWorld() {
		return this.world > 0;
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/CharSequence;I)I",
		garbageValue = "631809601"
	)
	public static int method5234(CharSequence var0) {
		int var1 = var0.length();
		int var2 = 0;

		for (int var3 = 0; var3 < var1; ++var3) {
			var2 = (var2 << 5) - var2 + var0.charAt(var3);
		}

		return var2;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)I",
		garbageValue = "-2002208158"
	)
	@Export("stringCp1252NullTerminatedByteSize")
	public static int stringCp1252NullTerminatedByteSize(String var0) {
		return var0.length() + 1;
	}
}
