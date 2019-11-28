import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gw")
public class class191 {
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lgw;"
	)
	static final class191 field2376;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lgw;"
	)
	static final class191 field2372;
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Lgw;"
	)
	static final class191 field2375;
	@ObfuscatedName("kc")
	@ObfuscatedGetter(
		intValue = 124291179
	)
	@Export("menuY")
	static int menuY;

	static {
		field2376 = new class191();
		field2372 = new class191();
		field2375 = new class191();
	}

	class191() {
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Ljava/lang/String;ZI)Lmd;",
		garbageValue = "-1138892268"
	)
	@Export("getPreferencesFile")
	public static AccessFile getPreferencesFile(String var0, String var1, boolean var2) {
		File var3 = new File(UserComparator2.cacheDir, "preferences" + var0 + ".dat");
		if (var3.exists()) {
			try {
				AccessFile var10 = new AccessFile(var3, "rw", 10000L);
				return var10;
			} catch (IOException var9) {
			}
		}

		String var4 = "";
		if (PendingSpawn.cacheGamebuild == 33) {
			var4 = "_rc";
		} else if (PendingSpawn.cacheGamebuild == 34) {
			var4 = "_wip";
		}

		File var5 = new File(JagexCache.userHomeDirectory, "jagex_" + var1 + "_preferences" + var0 + var4 + ".dat");
		AccessFile var6;
		if (!var2 && var5.exists()) {
			try {
				var6 = new AccessFile(var5, "rw", 10000L);
				return var6;
			} catch (IOException var8) {
			}
		}

		try {
			var6 = new AccessFile(var3, "rw", 10000L);
			return var6;
		} catch (IOException var7) {
			throw new RuntimeException();
		}
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;ZLjava/lang/String;ZB)V",
		garbageValue = "0"
	)
	static void method3721(String var0, boolean var1, String var2, boolean var3) {
		if (var1) {
			if (!var3 && Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
				try {
					Desktop.getDesktop().browse(new URI(var0));
					return;
				} catch (Exception var5) {
				}
			}

			if (class51.field424.startsWith("win") && !var3) {
				GraphicsObject.method2040(var0, 0);
				return;
			}

			if (class51.field424.startsWith("mac")) {
				class237.method4422(var0, 1, var2);
				return;
			}

			GraphicsObject.method2040(var0, 2);
		} else {
			GraphicsObject.method2040(var0, 3);
		}

	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;B)Ljava/lang/String;",
		garbageValue = "-1"
	)
	public static String method3720(String var0) {
		int var1 = var0.length();
		char[] var2 = new char[var1];
		byte var3 = 2;

		for (int var4 = 0; var4 < var1; ++var4) {
			char var5 = var0.charAt(var4);
			if (var3 == 0) {
				var5 = Character.toLowerCase(var5);
			} else if (var3 == 2 || Character.isUpperCase(var5)) {
				var5 = WorldMapElement.method4483(var5);
			}

			if (Character.isLetter(var5)) {
				var3 = 0;
			} else if (var5 != '.' && var5 != '?' && var5 != '!') {
				if (Character.isSpaceChar(var5)) {
					if (var3 != 2) {
						var3 = 1;
					}
				} else {
					var3 = 1;
				}
			} else {
				var3 = 2;
			}

			var2[var4] = var5;
		}

		return new String(var2);
	}
}
