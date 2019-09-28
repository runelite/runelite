import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cu")
@Implements("Script")
public class Script extends DualNode {
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Lem;"
	)
	@Export("Script_cached")
	static EvictingDualNodeHashTable Script_cached;
	@ObfuscatedName("dh")
	@ObfuscatedSignature(
		signature = "Lie;"
	)
	@Export("archive15")
	static Archive archive15;
	@ObfuscatedName("n")
	@Export("opcodes")
	int[] opcodes;
	@ObfuscatedName("v")
	@Export("intOperands")
	int[] intOperands;
	@ObfuscatedName("u")
	@Export("stringOperands")
	String[] stringOperands;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = 1534316869
	)
	@Export("localIntCount")
	int localIntCount;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -473600855
	)
	@Export("localStringCount")
	int localStringCount;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -171399011
	)
	@Export("intArgumentCount")
	int intArgumentCount;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -1063868631
	)
	@Export("stringArgumentCount")
	int stringArgumentCount;
	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "[Llb;"
	)
	@Export("switches")
	IterableNodeHashTable[] switches;

	static {
		Script_cached = new EvictingDualNodeHashTable(128);
	}

	Script() {
	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(II)[Llb;",
		garbageValue = "1885034841"
	)
	@Export("newIterableNodeHashTable")
	IterableNodeHashTable[] newIterableNodeHashTable(int var1) {
		return new IterableNodeHashTable[var1];
	}
}
