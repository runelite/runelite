import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kl")
public final class class289 {
	@ObfuscatedName("c")
	@Export("base37Table")
	public static final char[] base37Table;
	@ObfuscatedName("t")
	static long[] field3642;

	static {
		base37Table = new char[]{'_', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		field3642 = new long[12];

		for (int var0 = 0; var0 < field3642.length; ++var0) {
			field3642[var0] = (long)Math.pow(37.0D, (double)var0);
		}

	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)[Lkx;",
		garbageValue = "822610735"
	)
	static PrivateChatMode[] method5359() {
		return new PrivateChatMode[]{PrivateChatMode.field3789, PrivateChatMode.field3790, PrivateChatMode.field3788};
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "-1942089973"
	)
	static final int method5358(int var0, int var1) {
		int var2 = var0 + var1 * 57;
		var2 ^= var2 << 13;
		int var3 = (var2 * var2 * 15731 + 789221) * var2 + 1376312589 & Integer.MAX_VALUE;
		return var3 >> 19 & 255;
	}
}
