import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jt")
@Implements("Buddy")
public class Buddy extends User {
	@ObfuscatedName("c")
	@Export("Tiles_lightness")
	static int[] Tiles_lightness;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 453016847
	)
	@Export("world")
	public int world;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 1487463363
	)
	@Export("int2")
	public int int2;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -838100941
	)
	@Export("rank")
	public int rank;

	Buddy() {
		this.world = -1;
	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "-1748427179"
	)
	@Export("set")
	void set(int var1, int var2) {
		this.world = var1;
		this.int2 = var2;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1469335924"
	)
	@Export("getWorld")
	public int getWorld() {
		return this.world;
	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-1595892037"
	)
	@Export("hasWorld")
	public boolean hasWorld() {
		return this.world > 0;
	}

	@ObfuscatedName("bk")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)I",
		garbageValue = "1544989297"
	)
	@Export("stringCp1252NullTerminatedByteSize")
	public static int stringCp1252NullTerminatedByteSize(String var0) {
		return var0.length() + 1;
	}
}
