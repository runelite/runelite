import javax.imageio.ImageIO;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ay")
public class class49 {
	static {
		ImageIO.setUseCache(false);
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(S)V",
		garbageValue = "135"
	)
	static void method815() {
		if (Login.Login_username == null || Login.Login_username.length() <= 0) {
			if (WorldMapLabelSize.clientPreferences.rememberedUsername != null) {
				Login.Login_username = WorldMapLabelSize.clientPreferences.rememberedUsername;
				Client.Login_isUsernameRemembered = true;
			} else {
				Client.Login_isUsernameRemembered = false;
			}

		}
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(IIB)Lcx;",
		garbageValue = "3"
	)
	@Export("getWorldMapScript")
	static Script getWorldMapScript(int var0, int var1) {
		Script var2 = (Script)Script.Script_cached.get((long)(var0 << 16));
		if (var2 != null) {
			return var2;
		} else {
			String var3 = String.valueOf(var0);
			int var4 = UserComparator4.archive12.getGroupId(var3);
			if (var4 == -1) {
				return null;
			} else {
				byte[] var5 = UserComparator4.archive12.takeFileFlat(var4);
				if (var5 != null) {
					if (var5.length <= 1) {
						return null;
					}

					var2 = World.newScript(var5);
					if (var2 != null) {
						Script.Script_cached.put(var2, (long)(var0 << 16));
						return var2;
					}
				}

				return null;
			}
		}
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(CS)Z",
		garbageValue = "8230"
	)
	@Export("isCharDigit")
	public static boolean isCharDigit(char var0) {
		return var0 >= '0' && var0 <= '9';
	}
}
