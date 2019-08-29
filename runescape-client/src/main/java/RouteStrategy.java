import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fq")
@Implements("RouteStrategy")
public abstract class RouteStrategy {
	@ObfuscatedName("da")
	@ObfuscatedSignature(
		signature = "Lft;"
	)
	@Export("js5SocketTask")
	static Task js5SocketTask;
	@ObfuscatedName("fa")
	@ObfuscatedGetter(
		intValue = 207475119
	)
	@Export("baseY")
	static int baseY;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = 663574439
	)
	@Export("approxDestinationX")
	public int approxDestinationX;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -148289361
	)
	@Export("approxDestinationY")
	public int approxDestinationY;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 2029951319
	)
	@Export("approxDestinationSizeX")
	public int approxDestinationSizeX;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 2116488485
	)
	@Export("approxDestinationSizeY")
	public int approxDestinationSizeY;

	protected RouteStrategy() {
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(IIILfm;I)Z",
		garbageValue = "1325675955"
	)
	@Export("hasArrived")
	public abstract boolean hasArrived(int var1, int var2, int var3, CollisionMap var4);

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(CB)Z",
		garbageValue = "-117"
	)
	@Export("isAlphaNumeric")
	public static boolean isAlphaNumeric(char var0) {
		return var0 >= '0' && var0 <= '9' || var0 >= 'A' && var0 <= 'Z' || var0 >= 'a' && var0 <= 'z';
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "-1827304570"
	)
	static final int method3533(int var0, int var1) {
		if (var0 == -2) {
			return 12345678;
		} else if (var0 == -1) {
			if (var1 < 2) {
				var1 = 2;
			} else if (var1 > 126) {
				var1 = 126;
			}

			return var1;
		} else {
			var1 = (var0 & 127) * var1 / 128;
			if (var1 < 2) {
				var1 = 2;
			} else if (var1 > 126) {
				var1 = 126;
			}

			return (var0 & 65408) + var1;
		}
	}

	@ObfuscatedName("ku")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;ZI)Ljava/lang/String;",
		garbageValue = "1938958003"
	)
	static String method3534(String var0, boolean var1) {
		String var2 = var1 ? "https://" : "http://";
		if (Client.gameBuild == 1) {
			var0 = var0 + "-wtrc";
		} else if (Client.gameBuild == 2) {
			var0 = var0 + "-wtqa";
		} else if (Client.gameBuild == 3) {
			var0 = var0 + "-wtwip";
		} else if (Client.gameBuild == 5) {
			var0 = var0 + "-wti";
		} else if (Client.gameBuild == 4) {
			var0 = "local";
		}

		String var3 = "";
		if (Clock.field2037 != null) {
			var3 = "/p=" + Clock.field2037;
		}

		String var4 = "runescape.com";
		return var2 + var0 + "." + var4 + "/l=" + class60.clientLanguage + "/a=" + SoundSystem.field1414 + var3 + "/";
	}
}
