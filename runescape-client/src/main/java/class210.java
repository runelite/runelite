import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hj")
public class class210 {
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-1841265610"
	)
	public static boolean method3947() {
		ReflectionCheck var0 = (ReflectionCheck)class117.reflectionChecks.last();
		return var0 != null;
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(III)Lbs;",
		garbageValue = "-453941581"
	)
	@Export("Messages_getByChannelAndID")
	static Message Messages_getByChannelAndID(int var0, int var1) {
		ChatChannel var2 = (ChatChannel)Messages.Messages_channels.get(var0);
		return var2.getMessage(var1);
	}
}
