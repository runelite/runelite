import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("id")
@Implements("StructDefinition")
public class StructDefinition extends DualNode {
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lhf;"
	)
	@Export("StructDefinition_archive")
	static AbstractArchive StructDefinition_archive;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lef;"
	)
	@Export("StructDefinition_cached")
	static EvictingDualNodeHashTable StructDefinition_cached;
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "[Llm;"
	)
	@Export("runesSprite")
	static IndexedSprite[] runesSprite;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Llm;"
	)
	static IndexedSprite field3315;
	@ObfuscatedName("b")
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

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "592046740"
	)
	@Export("postDecode")
	void postDecode() {
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(Lkg;I)V",
		garbageValue = "-303940438"
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

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Lkg;II)V",
		garbageValue = "1709382073"
	)
	@Export("decodeNext")
	void decodeNext(Buffer var1, int var2) {
		if (var2 == 249) {
			this.params = ModelData0.readStringIntParameters(var1, this.params);
		}

	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(IIB)I",
		garbageValue = "48"
	)
	@Export("getIntParam")
	public int getIntParam(int var1, int var2) {
		IterableNodeHashTable var4 = this.params;
		int var3;
		if (var4 == null) {
			var3 = var2;
		} else {
			IntegerNode var5 = (IntegerNode)var4.get((long)var1);
			if (var5 == null) {
				var3 = var2;
			} else {
				var3 = var5.integer;
			}
		}

		return var3;
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;I)Ljava/lang/String;",
		garbageValue = "1804535212"
	)
	@Export("getStringParam")
	public String getStringParam(int var1, String var2) {
		return ServerBuild.method4214(this.params, var1, var2);
	}
}
