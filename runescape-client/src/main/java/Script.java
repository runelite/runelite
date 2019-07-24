import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cx")
@Implements("Script")
public class Script extends DualNode {
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lel;"
	)
	@Export("Script_cached")
	static EvictingDualNodeHashTable Script_cached;
	@ObfuscatedName("w")
	@Export("opcodes")
	int[] opcodes;
	@ObfuscatedName("e")
	@Export("intOperands")
	int[] intOperands;
	@ObfuscatedName("p")
	@Export("stringOperands")
	String[] stringOperands;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -1512547181
	)
	@Export("localIntCount")
	int localIntCount;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -461479353
	)
	@Export("localStringCount")
	int localStringCount;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -1738324737
	)
	@Export("intArgumentCount")
	int intArgumentCount;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -826878645
	)
	@Export("stringArgumentCount")
	int stringArgumentCount;
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "[Lla;"
	)
	@Export("switches")
	IterableNodeHashTable[] switches;

	static {
		Script_cached = new EvictingDualNodeHashTable(128);
	}

	Script() {
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(IB)[Lla;",
		garbageValue = "45"
	)
	IterableNodeHashTable[] method2182(int var1) {
		return new IterableNodeHashTable[var1];
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(IB)Z",
		garbageValue = "-58"
	)
	public static boolean method2185(int var0) {
		return (var0 >> 30 & 1) != 0;
	}
}
