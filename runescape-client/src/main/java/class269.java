import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jz")
public class class269 {
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Lhq;Lhq;III)Lks;",
		garbageValue = "1409785665"
	)
	public static Font method5114(AbstractArchive var0, AbstractArchive var1, int var2, int var3) {
		return !class32.method618(var0, var2, var3) ? null : RouteStrategy.method3738(var1.takeFile(var2, var3));
	}
}
