import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ht")
public class class222 {
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(IB)Ljava/lang/String;",
		garbageValue = "0"
	)
	@Export("colorStartTag")
	static String colorStartTag(int var0) {
		return "<col=" + Integer.toHexString(var0) + ">";
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(ZI)V",
		garbageValue = "-649981056"
	)
	@Export("Login_promptCredentials")
	static void Login_promptCredentials(boolean var0) {
		Login.Login_response1 = "";
		Login.Login_response2 = "Enter your username/email & password.";
		Login.Login_response3 = "";
		Login.loginIndex = 2;
		if (var0) {
			Login.Login_password = "";
		}

		if (Login.Login_username == null || Login.Login_username.length() <= 0) {
			if (UserComparator10.clientPreferences.rememberedUsername != null) {
				Login.Login_username = UserComparator10.clientPreferences.rememberedUsername;
				Client.Login_isUsernameRemembered = true;
			} else {
				Client.Login_isUsernameRemembered = false;
			}
		}

		Buddy.method5251();
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-23"
	)
	public static void method4195() {
		NPCDefinition.NpcDefinition_cached.clear();
		NPCDefinition.NpcDefinition_cachedModels.clear();
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		signature = "([BII)I",
		garbageValue = "-2031476219"
	)
	public static int method4196(byte[] var0, int var1) {
		return UserComparator5.method3467(var0, 0, var1);
	}

	@ObfuscatedName("fy")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "11"
	)
	static final void method4198() {
		if (WorldMapID.ClanChat_inClanChat) {
			if (InterfaceParent.clanChat != null) {
				InterfaceParent.clanChat.sort();
			}

			for (int var0 = 0; var0 < Players.Players_count; ++var0) {
				Player var1 = Client.players[Players.Players_indices[var0]];
				var1.clearIsInClanChat();
			}

			WorldMapID.ClanChat_inClanChat = false;
		}

	}
}
