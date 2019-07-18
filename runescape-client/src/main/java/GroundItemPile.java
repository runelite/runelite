import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dc")
@Implements("GroundItemPile")
public final class GroundItemPile {
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -706647707
	)
	@Export("tileHeight")
	int tileHeight;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -1749434399
	)
	@Export("x")
	int x;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 1687183849
	)
	@Export("y")
	int y;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Leo;"
	)
	@Export("first")
	Entity first;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Leo;"
	)
	@Export("second")
	Entity second;
	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "Leo;"
	)
	@Export("third")
	Entity third;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		longValue = -6836359089398778317L
	)
	@Export("tag")
	long tag;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -1167512637
	)
	@Export("height")
	int height;

	GroundItemPile() {
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "-989207473"
	)
	public static int method2767(int var0, int var1) {
		int var2 = var0 >>> 31;
		return (var0 + var2) / var1 - var2;
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "-23"
	)
	static void method2764(int var0) {
		ItemContainer var1 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
		if (var1 != null) {
			var1.remove();
		}
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "1314012151"
	)
	static final int method2765(int var0, int var1) {
		int var2 = MouseHandler.method1021(var0 - 1, var1 - 1) + MouseHandler.method1021(1 + var0, var1 - 1) + MouseHandler.method1021(var0 - 1, 1 + var1) + MouseHandler.method1021(1 + var0, 1 + var1);
		int var3 = MouseHandler.method1021(var0 - 1, var1) + MouseHandler.method1021(var0 + 1, var1) + MouseHandler.method1021(var0, var1 - 1) + MouseHandler.method1021(var0, var1 + 1);
		int var4 = MouseHandler.method1021(var0, var1);
		return var2 / 16 + var3 / 8 + var4 / 4;
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "76"
	)
	@Export("ObjectDefinition_clearCached")
	public static void ObjectDefinition_clearCached() {
		ObjectDefinition.ObjectDefinition_cached.clear();
		ObjectDefinition.ObjectDefinition_cachedModelData.clear();
		ObjectDefinition.ObjectDefinition_cachedEntities.clear();
		ObjectDefinition.ObjectDefinition_cachedModels.clear();
	}
}
