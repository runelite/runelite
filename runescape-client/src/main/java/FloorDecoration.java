import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("du")
@Implements("FloorDecoration")
public final class FloorDecoration {
	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "[[Lhl;"
	)
	@Export("Widget_interfaceComponents")
	public static Widget[][] Widget_interfaceComponents;
	@ObfuscatedName("hj")
	@ObfuscatedGetter(
		intValue = -787534095
	)
	@Export("cameraZ")
	static int cameraZ;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 1000348855
	)
	@Export("tileHeight")
	int tileHeight;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -2093523795
	)
	@Export("x")
	int x;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -512662577
	)
	@Export("y")
	int y;
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Lee;"
	)
	@Export("entity")
	public Entity entity;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		longValue = -2591467341780492125L
	)
	@Export("tag")
	public long tag;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 424120209
	)
	@Export("flags")
	int flags;

	FloorDecoration() {
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(CI)Z",
		garbageValue = "-345109095"
	)
	@Export("isCharPrintable")
	public static boolean isCharPrintable(char var0) {
		if (var0 >= ' ' && var0 <= '~') {
			return true;
		} else if (var0 >= 160 && var0 <= 255) {
			return true;
		} else {
			return var0 == 8364 || var0 == 338 || var0 == 8212 || var0 == 339 || var0 == 376;
		}
	}

	@ObfuscatedName("fe")
	@ObfuscatedSignature(
		signature = "(IB)I",
		garbageValue = "3"
	)
	static int method2888(int var0) {
		return var0 * 3 + 600;
	}
}
