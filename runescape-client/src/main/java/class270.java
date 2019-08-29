import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ji")
public class class270 {
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(II)Lkk;",
		garbageValue = "-1980425423"
	)
	public static PrivateChatMode method4895(int var0) {
		PrivateChatMode[] var1 = AbstractSocket.ChatMode_values();

		for (int var2 = 0; var2 < var1.length; ++var2) {
			PrivateChatMode var3 = var1[var2];
			if (var0 == var3.field3791) {
				return var3;
			}
		}

		return null;
	}
}
