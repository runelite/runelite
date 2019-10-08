import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eq")
@Implements("ModelData0")
public class ModelData0 {
	@ObfuscatedName("ha")
	@ObfuscatedGetter(
		intValue = -1351160427
	)
	static int field1840;

	ModelData0() {
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "1264128253"
	)
	public static boolean method3215(int var0) {
		return (var0 >> 28 & 1) != 0;
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(B)Lbo;",
		garbageValue = "0"
	)
	@Export("worldListStart")
	static World worldListStart() {
		World.World_listCount = 0;
		return AbstractByteArrayCopier.getNextWorldListWorld();
	}

	@ObfuscatedName("hn")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "1738289394"
	)
	@Export("clickMenuIndex")
	static final void clickMenuIndex(int var0) {
		if (var0 >= 0) {
			int var1 = Client.menuArguments1[var0];
			int var2 = Client.menuArguments2[var0];
			int var3 = Client.menuOpcodes[var0];
			int var4 = Client.menuIdentifiers[var0];
			String var5 = Client.menuActions[var0];
			String var6 = Client.menuTargets[var0];
			InvDefinition.menuAction(var1, var2, var3, var4, var5, var6, MouseHandler.MouseHandler_lastPressedX, MouseHandler.MouseHandler_lastPressedY);
		}
	}
}
