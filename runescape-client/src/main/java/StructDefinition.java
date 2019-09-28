import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ir")
@Implements("StructDefinition")
public class StructDefinition extends DualNode {
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Lhp;"
	)
	@Export("StructDefinition_archive")
	public static AbstractArchive StructDefinition_archive;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lem;"
	)
	@Export("StructDefinition_cached")
	public static EvictingDualNodeHashTable StructDefinition_cached;
	@ObfuscatedName("gc")
	@ObfuscatedSignature(
		signature = "[Llf;"
	)
	@Export("headIconPkSprites")
	static Sprite[] headIconPkSprites;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Llb;"
	)
	@Export("params")
	IterableNodeHashTable params;

	static {
		StructDefinition_cached = new EvictingDualNodeHashTable(64);
	}

	StructDefinition() {
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "37"
	)
	@Export("postDecode")
	void postDecode() {
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(Lkl;I)V",
		garbageValue = "-593456946"
	)
	@Export("decode")
	void decode(Buffer var1) {
		while (true) {
			int var2 = var1.readUnsignedByte();
			if (var2 == 0) {
				return;
			}

			this.decodeNext(var1, var2);
		}
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Lkl;II)V",
		garbageValue = "-464396075"
	)
	@Export("decodeNext")
	void decodeNext(Buffer var1, int var2) {
		if (var2 == 249) {
			this.params = UserComparator5.readStringIntParameters(var1, this.params);
		}

	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "-1632755305"
	)
	@Export("getIntParam")
	public int getIntParam(int var1, int var2) {
		return HealthBar.method2034(this.params, var1, var2);
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;I)Ljava/lang/String;",
		garbageValue = "127947396"
	)
	@Export("getStringParam")
	public String getStringParam(int var1, String var2) {
		return class96.method2263(this.params, var1, var2);
	}
}
