import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ek")
@Implements("Occluder")
public final class Occluder {
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 362641763
	)
	@Export("minTileX")
	int minTileX;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 1829777649
	)
	@Export("maxTileX")
	int maxTileX;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -990403321
	)
	@Export("minTileY")
	int minTileY;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 2788625
	)
	@Export("maxTileY")
	int maxTileY;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 2035384345
	)
	@Export("type")
	int type;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -37921347
	)
	@Export("minX")
	int minX;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -774956393
	)
	@Export("maxX")
	int maxX;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -1495961471
	)
	@Export("minZ")
	int minZ;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -1326985595
	)
	@Export("maxZ")
	int maxZ;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -790456829
	)
	@Export("minY")
	int minY;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -1754197059
	)
	@Export("maxY")
	int maxY;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = 1722833995
	)
	int field1872;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -112821165
	)
	int field1873;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = -226733423
	)
	int field1861;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 387341237
	)
	int field1879;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 1097243593
	)
	int field1876;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 1639828993
	)
	int field1871;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 218753559
	)
	int field1878;

	Occluder() {
	}

	@ObfuscatedName("go")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "8"
	)
	static final void method3253() {
		Client.field735 = 0;
		int var0 = class4.baseX * 64 + (Varps.localPlayer.x * -78439701 >> 7);
		int var1 = (Varps.localPlayer.y >> 7) + ScriptEvent.baseY;
		if (var0 >= 3053 && var0 <= 3156 && var1 >= 3056 && var1 <= 3136) {
			Client.field735 = 1;
		}

		if (var0 >= 3072 && var0 <= 3118 && var1 >= 9492 && var1 <= 9535) {
			Client.field735 = 1;
		}

		if (Client.field735 == 1 && var0 >= 3139 && var0 <= 3199 && var1 >= 3008 && var1 <= 3062) {
			Client.field735 = 0;
		}

	}

	@ObfuscatedName("ix")
	@ObfuscatedSignature(
		signature = "(IIIZB)V",
		garbageValue = "48"
	)
	@Export("resizeComponents")
	static final void resizeComponents(int var0, int var1, int var2, boolean var3) {
		if (TaskHandler.loadInterface(var0)) {
			class80.resizeInterface(class289.Widget_interfaceComponents[var0], -1, var1, var2, var3);
		}
	}
}
