import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jo")
public class class276 {
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "-894385088"
	)
	public static int method5036(int var0) {
		long var2 = ViewportMouse.ViewportMouse_entityTags[var0];
		int var1 = (int)(var2 >>> 14 & 3L);
		return var1;
	}
}
