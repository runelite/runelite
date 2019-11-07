import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ec")
@Implements("UserComparator4")
public class UserComparator4 implements Comparator {
	@ObfuscatedName("sj")
	@Export("foundItemIds")
	static short[] foundItemIds;
	@ObfuscatedName("a")
	@Export("reversed")
	final boolean reversed;

	public UserComparator4(boolean var1) {
		this.reversed = var1;
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(Ljx;Ljx;I)I",
		garbageValue = "1036024151"
	)
	@Export("compare_bridged")
	int compare_bridged(Buddy var1, Buddy var2) {
		return this.reversed ? var1.int2 - var2.int2 : var2.int2 - var1.int2;
	}

	public int compare(Object var1, Object var2) {
		return this.compare_bridged((Buddy)var1, (Buddy)var2);
	}

	public boolean equals(Object var1) {
		return super.equals(var1);
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-616459830"
	)
	public static int method3502() {
		return ++MouseHandler.MouseHandler_idleCycles - 1;
	}

	@ObfuscatedName("fe")
	@ObfuscatedSignature(
		signature = "(I)Llo;",
		garbageValue = "1928339538"
	)
	@Export("getWorldMap")
	static WorldMap getWorldMap() {
		return Login.worldMap;
	}
}
