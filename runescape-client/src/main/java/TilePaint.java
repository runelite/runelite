import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ef")
@Implements("TilePaint")
public final class TilePaint {
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 968490533
	)
	@Export("swColor")
	int swColor;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -721233201
	)
	@Export("seColor")
	int seColor;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -1592287523
	)
	@Export("neColor")
	int neColor;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -100726041
	)
	@Export("nwColor")
	int nwColor;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = 2026223793
	)
	@Export("texture")
	int texture;
	@ObfuscatedName("p")
	@Export("isFlat")
	boolean isFlat;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 1661774659
	)
	@Export("rgb")
	int rgb;

	TilePaint(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
		this.isFlat = true;
		this.swColor = var1;
		this.seColor = var2;
		this.neColor = var3;
		this.nwColor = var4;
		this.texture = var5;
		this.rgb = var6;
		this.isFlat = var7;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(Lkl;II)Ljava/lang/String;",
		garbageValue = "-964205547"
	)
	static String method3042(Buffer var0, int var1) {
		try {
			int var2 = var0.readUShortSmart();
			if (var2 > var1) {
				var2 = var1;
			}

			byte[] var3 = new byte[var2];
			var0.offset += class210.huffman.decompress(var0.array, var0.offset, var3, 0, var2);
			String var4 = ArchiveLoader.decodeStringCp1252(var3, 0, var2);
			return var4;
		} catch (Exception var6) {
			return "Cabbage";
		}
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/CharSequence;I)I",
		garbageValue = "800355488"
	)
	@Export("parseInt")
	public static int parseInt(CharSequence var0) {
		return SoundCache.parseIntCustomRadix(var0, 10, true);
	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(ZI)V",
		garbageValue = "-2065502658"
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

		InterfaceParent.method1197();
		if (Client.Login_isUsernameRemembered && Login.Login_username != null && Login.Login_username.length() > 0) {
			Login.currentLoginField = 1;
		} else {
			Login.currentLoginField = 0;
		}

	}
}
