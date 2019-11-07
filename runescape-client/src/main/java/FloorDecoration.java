import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dx")
@Implements("FloorDecoration")
public final class FloorDecoration {
	@ObfuscatedName("na")
	@ObfuscatedGetter(
		intValue = 379430595
	)
	@Export("widgetDragDuration")
	static int widgetDragDuration;
	@ObfuscatedName("pe")
	@ObfuscatedSignature(
		signature = "Llx;"
	)
	@Export("sceneMinimapSprite")
	static Sprite sceneMinimapSprite;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = 1575825247
	)
	@Export("tileHeight")
	int tileHeight;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -455882757
	)
	@Export("x")
	int x;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 733154095
	)
	@Export("y")
	int y;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lep;"
	)
	@Export("entity")
	public Entity entity;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		longValue = -4694647978187683379L
	)
	@Export("tag")
	public long tag;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -984240523
	)
	@Export("flags")
	int flags;

	FloorDecoration() {
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(IIIIIIB)I",
		garbageValue = "30"
	)
	public static int method3010(int var0, int var1, int var2, int var3, int var4, int var5) {
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
}
