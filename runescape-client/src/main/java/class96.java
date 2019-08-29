import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cz")
public class class96 {
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "Ljp;"
	)
	@Export("reflectionChecks")
	public static IterableNodeDeque reflectionChecks;
	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "Llq;"
	)
	static IndexedSprite field1303;
	@ObfuscatedName("kk")
	@ObfuscatedGetter(
		intValue = -894552657
	)
	@Export("menuY")
	static int menuY;

	static {
		reflectionChecks = new IterableNodeDeque();
	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(II)Ljava/lang/String;",
		garbageValue = "-1331218775"
	)
	static final String method2201(int var0) {
		if (var0 < 100000) {
			return "<col=ffff00>" + var0 + "</col>";
		} else {
			return var0 < 10000000 ? "<col=ffffff>" + var0 / 1000 + "K" + "</col>" : "<col=00ff80>" + var0 / 1000000 + "M" + "</col>";
		}
	}
}
