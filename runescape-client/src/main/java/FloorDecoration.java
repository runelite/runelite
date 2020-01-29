import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("du")
@Implements("FloorDecoration")
public final class FloorDecoration {
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Lli;"
	)
	@Export("logoSprite")
	static IndexedSprite logoSprite;
	@ObfuscatedName("ja")
	@ObfuscatedSignature(
		signature = "Lhn;"
	)
	static Widget field1604;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -340818917
	)
	@Export("tileHeight")
	int tileHeight;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 2029727385
	)
	@Export("x")
	int x;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = -588436191
	)
	@Export("y")
	int y;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Leq;"
	)
	@Export("entity")
	public Entity entity;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		longValue = -1449564120774695343L
	)
	@Export("tag")
	public long tag;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -1732648277
	)
	@Export("flags")
	int flags;

	FloorDecoration() {
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(Llp;ILjava/lang/String;I)Ljava/lang/String;",
		garbageValue = "1267809906"
	)
	static String method2914(IterableNodeHashTable var0, int var1, String var2) {
		if (var0 == null) {
			return var2;
		} else {
			ObjectNode var3 = (ObjectNode)var0.get((long)var1);
			return var3 == null ? var2 : (String)var3.obj;
		}
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(IIIIIIB)I",
		garbageValue = "94"
	)
	public static int method2913(int var0, int var1, int var2, int var3, int var4, int var5) {
		if ((var5 & 1) == 1) {
			int var6 = var3;
			var3 = var4;
			var4 = var6;
		}

		var2 &= 3;
		if (var2 == 0) {
			return var0;
		} else if (var2 == 1) {
			return var1;
		} else {
			return var2 == 2 ? 7 - var0 - (var3 - 1) : 7 - var1 - (var4 - 1);
		}
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "-2102248580"
	)
	static final void method2912(String var0) {
		class60.method1188("Please remove " + var0 + " from your friend list first");
	}
}
