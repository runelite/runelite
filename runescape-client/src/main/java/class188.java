import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gq")
public class class188 {
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 1663251439
	)
	@Export("Interpreter_intStackSize")
	static int Interpreter_intStackSize;
	@ObfuscatedName("bq")
	@ObfuscatedSignature(
		signature = "Lll;"
	)
	@Export("loginType")
	static LoginType loginType;

	@ObfuscatedName("i")
	static final void method3604(long var0) {
		try {
			Thread.sleep(var0);
		} catch (InterruptedException var3) {
		}

	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(ZZB)I",
		garbageValue = "1"
	)
	public static int method3601(boolean var0, boolean var1) {
		byte var2 = 0;
		int var3 = var2 + NetCache.NetCache_pendingPriorityResponsesCount + NetCache.NetCache_pendingPriorityWritesCount;
		return var3;
	}
}
