import java.applet.Applet;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("am")
public class class50 {
	@ObfuscatedName("f")
	@Export("applet")
	static Applet applet;
	@ObfuscatedName("i")
	static String field410;

	static {
		applet = null;
		field410 = "";
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(II)Lku;",
		garbageValue = "-1375036887"
	)
	public static PrivateChatMode method893(int var0) {
		PrivateChatMode[] var1 = new PrivateChatMode[]{PrivateChatMode.field3791, PrivateChatMode.field3790, PrivateChatMode.field3792};
		PrivateChatMode[] var2 = var1;

		for (int var3 = 0; var3 < var2.length; ++var3) {
			PrivateChatMode var4 = var2[var3];
			if (var0 == var4.field3793) {
				return var4;
			}
		}

		return null;
	}
}
