import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ka")
public final class class296 {
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		longValue = 2084337511336446697L
	)
	static long field3684;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		longValue = 1232556563702335995L
	)
	static long field3683;

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(IIB)Z",
		garbageValue = "1"
	)
	static final boolean method5547(int var0, int var1) {
		ObjectDefinition var2 = WorldMapDecorationType.getObjectDefinition(var0);
		if (var1 == 11) {
			var1 = 10;
		}

		if (var1 >= 5 && var1 <= 8) {
			var1 = 4;
		}

		return var2.method4737(var1);
	}
}
