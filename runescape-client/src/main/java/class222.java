import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hm")
public class class222 {
	@ObfuscatedName("jg")
	@ObfuscatedSignature(
		signature = "Lhp;"
	)
	static Widget field2730;

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(ZZI)I",
		garbageValue = "49519186"
	)
	public static int method4035(boolean var0, boolean var1) {
		byte var2 = 0;
		int var3 = var2 + NetCache.NetCache_pendingPriorityWritesCount + NetCache.NetCache_pendingPriorityResponsesCount;
		return var3;
	}
}
