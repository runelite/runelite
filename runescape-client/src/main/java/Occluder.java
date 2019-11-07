import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eh")
@Implements("Occluder")
public final class Occluder {
	@ObfuscatedName("dt")
	@ObfuscatedSignature(
		signature = "Lij;"
	)
	@Export("archive12")
	static Archive archive12;
	@ObfuscatedName("iz")
	@ObfuscatedGetter(
		intValue = 1014742579
	)
	@Export("selectedItemId")
	static int selectedItemId;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = 2096461427
	)
	@Export("minTileX")
	int minTileX;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 658025365
	)
	@Export("maxTileX")
	int maxTileX;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -423718345
	)
	@Export("minTileY")
	int minTileY;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 1740624753
	)
	@Export("maxTileY")
	int maxTileY;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 954528249
	)
	@Export("type")
	int type;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 1732339879
	)
	@Export("minX")
	int minX;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 1301635755
	)
	@Export("maxX")
	int maxX;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = -258867493
	)
	@Export("minZ")
	int minZ;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 1337393049
	)
	@Export("maxZ")
	int maxZ;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 1306653599
	)
	@Export("minY")
	int minY;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 1760102387
	)
	@Export("maxY")
	int maxY;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 1764224557
	)
	int field1869;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = -1705634243
	)
	int field1887;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -682629895
	)
	int field1880;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -1219807155
	)
	int field1883;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = 168844503
	)
	int field1884;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = -1533789259
	)
	int field1882;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 1431077503
	)
	int field1885;

	Occluder() {
	}

	@ObfuscatedName("ir")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "-1093183807"
	)
	static final boolean method3415(int var0) {
		if (var0 < 0) {
			return false;
		} else {
			int var1 = Client.menuOpcodes[var0];
			if (var1 >= 2000) {
				var1 -= 2000;
			}

			return var1 == 1007;
		}
	}

	@ObfuscatedName("ih")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "0"
	)
	static final void method3416() {
		boolean var0 = false;

		while (!var0) {
			var0 = true;

			for (int var1 = 0; var1 < Client.menuOptionsCount - 1; ++var1) {
				if (Client.menuOpcodes[var1] < 1000 && Client.menuOpcodes[var1 + 1] > 1000) {
					String var2 = Client.menuTargets[var1];
					Client.menuTargets[var1] = Client.menuTargets[var1 + 1];
					Client.menuTargets[var1 + 1] = var2;
					String var3 = Client.menuActions[var1];
					Client.menuActions[var1] = Client.menuActions[var1 + 1];
					Client.menuActions[var1 + 1] = var3;
					int var4 = Client.menuOpcodes[var1];
					Client.menuOpcodes[var1] = Client.menuOpcodes[var1 + 1];
					Client.menuOpcodes[var1 + 1] = var4;
					var4 = Client.menuArguments1[var1];
					Client.menuArguments1[var1] = Client.menuArguments1[var1 + 1];
					Client.menuArguments1[var1 + 1] = var4;
					var4 = Client.menuArguments2[var1];
					Client.menuArguments2[var1] = Client.menuArguments2[var1 + 1];
					Client.menuArguments2[var1 + 1] = var4;
					var4 = Client.menuIdentifiers[var1];
					Client.menuIdentifiers[var1] = Client.menuIdentifiers[var1 + 1];
					Client.menuIdentifiers[var1 + 1] = var4;
					boolean var5 = Client.menuShiftClick[var1];
					Client.menuShiftClick[var1] = Client.menuShiftClick[var1 + 1];
					Client.menuShiftClick[var1 + 1] = var5;
					var0 = false;
				}
			}
		}

	}
}
