import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cs")
public class class96 {
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "Ljm;"
	)
	@Export("reflectionChecks")
	public static IterableNodeDeque reflectionChecks;
	@ObfuscatedName("o")
	static byte[][][] field1300;
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Ler;"
	)
	@Export("World_request")
	static UrlRequest World_request;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lhi;"
	)
	static Widget field1301;
	@ObfuscatedName("z")
	public static String field1299;

	static {
		reflectionChecks = new IterableNodeDeque();
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(IZIZI)V",
		garbageValue = "422781217"
	)
	@Export("sortWorldList")
	static void sortWorldList(int var0, boolean var1, int var2, boolean var3) {
		if (Username.World_worlds != null) {
			ModelData0.doWorldSorting(0, Username.World_worlds.length - 1, var0, var1, var2, var3);
		}

	}
}
