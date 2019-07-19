import java.util.Locale;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gu")
public class class190 implements Enumerated {
	@ObfuscatedName("qk")
	@ObfuscatedSignature(
		signature = "Ldn;"
	)
	@Export("pcmPlayer1")
	static PcmPlayer pcmPlayer1;
	@ObfuscatedName("qb")
	@ObfuscatedGetter(
		intValue = -429347521
	)
	static int field2345;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lgu;"
	)
	public static final class190 field2348;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lgu;"
	)
	static final class190 field2351;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lgu;"
	)
	public static final class190 field2347;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lgu;"
	)
	static final class190 field2352;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lgu;"
	)
	static final class190 field2349;
	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "Lgu;"
	)
	public static final class190 field2350;
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Lgu;"
	)
	static final class190 field2360;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "[Lgu;"
	)
	public static final class190[] field2355;
	@ObfuscatedName("eg")
	@ObfuscatedGetter(
		intValue = -1179519055
	)
	@Export("port1")
	static int port1;
	@ObfuscatedName("i")
	final String field2346;
	@ObfuscatedName("c")
	final String field2353;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = 1003386863
	)
	final int field2354;

	static {
		field2348 = new class190("EN", "en", "English", class192.field2375, 0, "GB");
		field2351 = new class190("DE", "de", "German", class192.field2375, 1, "DE");
		field2347 = new class190("FR", "fr", "French", class192.field2375, 2, "FR");
		field2352 = new class190("PT", "pt", "Portuguese", class192.field2375, 3, "BR");
		field2349 = new class190("NL", "nl", "Dutch", class192.field2381, 4, "NL");
		field2350 = new class190("ES", "es", "Spanish", class192.field2381, 5, "ES");
		field2360 = new class190("ES_MX", "es-mx", "Spanish (Latin American)", class192.field2375, 6, "MX");
		class190[] var0 = method3664();
		field2355 = new class190[var0.length];
		class190[] var1 = var0;

		for (int var2 = 0; var2 < var1.length; ++var2) {
			class190 var3 = var1[var2];
			if (field2355[var3.field2354] != null) {
				throw new IllegalStateException();
			}

			field2355[var3.field2354] = var3;
		}

	}

	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lgd;ILjava/lang/String;)V"
	)
	class190(String var1, String var2, String var3, class192 var4, int var5, String var6) {
		this.field2346 = var1;
		this.field2353 = var2;
		this.field2354 = var5;
		if (var6 != null) {
			new Locale(var2.substring(0, 2), var6);
		} else {
			new Locale(var2.substring(0, 2));
		}

	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(I)Ljava/lang/String;",
		garbageValue = "1097353533"
	)
	String method3656() {
		return this.field2353;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "320353268"
	)
	public int rsOrdinal() {
		return this.field2354;
	}

	public String toString() {
		return this.method3656().toLowerCase(Locale.ENGLISH);
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(B)[Lgu;",
		garbageValue = "99"
	)
	static class190[] method3664() {
		return new class190[]{field2351, field2349, field2347, field2350, field2348, field2360, field2352};
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1942171448"
	)
	public static final void method3665() {
		ViewportMouse.ViewportMouse_isInViewport = false;
		ViewportMouse.ViewportMouse_entityCount = 0;
	}

	@ObfuscatedName("ep")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "1477910272"
	)
	static boolean method3667() {
		if (Client.archiveLoaders != null && Client.archiveLoaderArchive < Client.archiveLoaders.size()) {
			while (Client.archiveLoaderArchive < Client.archiveLoaders.size()) {
				ArchiveLoader var0 = (ArchiveLoader)Client.archiveLoaders.get(Client.archiveLoaderArchive);
				if (!var0.isLoaded()) {
					return false;
				}

				++Client.archiveLoaderArchive;
			}

			return true;
		} else {
			return true;
		}
	}

	@ObfuscatedName("ko")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;ZI)Ljava/lang/String;",
		garbageValue = "-1044311329"
	)
	static String method3666(String var0, boolean var1) {
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
		if (class294.field3695 != null) {
			var3 = "/p=" + class294.field3695;
		}

		String var4 = "runescape.com";
		return var2 + var0 + "." + var4 + "/l=" + ScriptFrame.field528 + "/a=" + InvDefinition.field3199 + var3 + "/";
	}
}
