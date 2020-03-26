import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jq")
@Implements("StructDefinition")
public class StructDefinition extends DualNode {
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Liy;"
	)
	@Export("StructDefinition_archive")
	static AbstractArchive StructDefinition_archive;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Leg;"
	)
	@Export("StructDefinition_cached")
	static EvictingDualNodeHashTable StructDefinition_cached;
	@ObfuscatedName("w")
	@Export("SpriteBuffer_yOffsets")
	static int[] SpriteBuffer_yOffsets;
	@ObfuscatedName("p")
	@Export("Tiles_lightness")
	static int[] Tiles_lightness;
	@ObfuscatedName("bv")
	@ObfuscatedSignature(
		signature = "Lle;"
	)
	@Export("worldSelectRightSprite")
	static IndexedSprite worldSelectRightSprite;
	@ObfuscatedName("gc")
	@Export("regions")
	static int[] regions;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lln;"
	)
	@Export("params")
	IterableNodeHashTable params;

	static {
		StructDefinition_cached = new EvictingDualNodeHashTable(64);
	}

	StructDefinition() {
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1990105365"
	)
	@Export("postDecode")
	void postDecode() {
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(Lkb;B)V",
		garbageValue = "-61"
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

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(Lkb;II)V",
		garbageValue = "675280031"
	)
	@Export("decodeNext")
	void decodeNext(Buffer var1, int var2) {
		if (var2 == 249) {
			this.params = NetCache.readStringIntParameters(var1, this.params);
		}

	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "1605132881"
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

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;I)Ljava/lang/String;",
		garbageValue = "-1577444936"
	)
	@Export("getStringParam")
	public String getStringParam(int var1, String var2) {
		return class9.method122(this.params, var1, var2);
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(CS)C",
		garbageValue = "255"
	)
	static char method4589(char var0) {
		return var0 != 181 && var0 != 402 ? Character.toTitleCase(var0) : var0;
	}
}
