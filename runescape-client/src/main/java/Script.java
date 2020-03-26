import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ce")
@Implements("Script")
public class Script extends DualNode {
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Leg;"
	)
	@Export("Script_cached")
	static EvictingDualNodeHashTable Script_cached;
	@ObfuscatedName("ej")
	@Export("worldHost")
	static String worldHost;
	@ObfuscatedName("fs")
	@ObfuscatedSignature(
		signature = "Lkx;"
	)
	@Export("fontPlain11")
	static Font fontPlain11;
	@ObfuscatedName("m")
	@Export("opcodes")
	int[] opcodes;
	@ObfuscatedName("k")
	@Export("intOperands")
	int[] intOperands;
	@ObfuscatedName("d")
	@Export("stringOperands")
	String[] stringOperands;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -1902344849
	)
	@Export("localIntCount")
	int localIntCount;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -1904164233
	)
	@Export("localStringCount")
	int localStringCount;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -335811903
	)
	@Export("intArgumentCount")
	int intArgumentCount;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 931655197
	)
	@Export("stringArgumentCount")
	int stringArgumentCount;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "[Lln;"
	)
	@Export("switches")
	IterableNodeHashTable[] switches;

	static {
		Script_cached = new EvictingDualNodeHashTable(128);
	}

	Script() {
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(II)[Lln;",
		garbageValue = "-1946257941"
	)
	@Export("newIterableNodeHashTable")
	IterableNodeHashTable[] newIterableNodeHashTable(int var1) {
		return new IterableNodeHashTable[var1];
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;ZZI)V",
		garbageValue = "1255823265"
	)
	@Export("openURL")
	public static void openURL(String var0, boolean var1, boolean var2) {
		class224.method4125(var0, var1, "openjs", var2);
	}
}
