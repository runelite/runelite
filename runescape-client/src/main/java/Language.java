import java.util.Locale;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gu")
@Implements("Language")
public class Language implements Enumerated {
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
	@Export("Language_EN")
	public static final Language Language_EN;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lgu;"
	)
	@Export("Language_DE")
	static final Language Language_DE;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lgu;"
	)
	@Export("Language_FR")
	public static final Language Language_FR;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lgu;"
	)
	@Export("Language_PT")
	static final Language Language_PT;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lgu;"
	)
	@Export("Language_NL")
	static final Language Language_NL;
	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "Lgu;"
	)
	@Export("Language_ES")
	public static final Language Language_ES;
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Lgu;"
	)
	@Export("Language_ES_MX")
	static final Language Language_ES_MX;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "[Lgu;"
	)
	@Export("Language_valuesOrdered")
	public static final Language[] Language_valuesOrdered;
	@ObfuscatedName("eg")
	@ObfuscatedGetter(
		intValue = -1179519055
	)
	@Export("port1")
	static int port1;
	@ObfuscatedName("i")
	final String field2346;
	@ObfuscatedName("c")
	@Export("language")
	final String language;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = 1003386863
	)
	@Export("id")
	final int id;

	static {
		Language_EN = new Language("EN", "en", "English", class192.field2375, 0, "GB");
		Language_DE = new Language("DE", "de", "German", class192.field2375, 1, "DE");
		Language_FR = new Language("FR", "fr", "French", class192.field2375, 2, "FR");
		Language_PT = new Language("PT", "pt", "Portuguese", class192.field2375, 3, "BR");
		Language_NL = new Language("NL", "nl", "Dutch", class192.field2381, 4, "NL");
		Language_ES = new Language("ES", "es", "Spanish", class192.field2381, 5, "ES");
		Language_ES_MX = new Language("ES_MX", "es-mx", "Spanish (Latin American)", class192.field2375, 6, "MX");
		Language[] var0 = Language_values();
		Language_valuesOrdered = new Language[var0.length];
		Language[] var1 = var0;

		for (int var2 = 0; var2 < var1.length; ++var2) {
			Language var3 = var1[var2];
			if (Language_valuesOrdered[var3.id] != null) {
				throw new IllegalStateException();
			}

			Language_valuesOrdered[var3.id] = var3;
		}

	}

	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lgd;ILjava/lang/String;)V"
	)
	Language(String var1, String language, String var3, class192 var4, int var5, String country) {
		this.field2346 = var1;
		this.language = language;
		this.id = var5;
		if (country != null) {
			new Locale(language.substring(0, 2), country);
		} else {
			new Locale(language.substring(0, 2));
		}

	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(I)Ljava/lang/String;",
		garbageValue = "1097353533"
	)
	@Export("getLanguage")
	String getLanguage() {
		return this.language;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "320353268"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}

	public String toString() {
		return this.getLanguage().toLowerCase(Locale.ENGLISH);
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(B)[Lgu;",
		garbageValue = "99"
	)
	@Export("Language_values")
	static Language[] Language_values() {
		return new Language[]{Language_DE, Language_NL, Language_FR, Language_ES, Language_EN, Language_ES_MX, Language_PT};
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1942171448"
	)
	@Export("ViewportMouse_clear")
	public static final void ViewportMouse_clear() {
		ViewportMouse.ViewportMouse_isInViewport = false;
		ViewportMouse.ViewportMouse_entityCount = 0;
	}

	@ObfuscatedName("ep")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "1477910272"
	)
	static boolean method3667() {
		if (Client.archiveLoaders == null || Client.archiveLoaderArchive >= Client.archiveLoaders.size()) {
			return true;
		}
		while (Client.archiveLoaderArchive < Client.archiveLoaders.size()) {
			ArchiveLoader var0 = (ArchiveLoader)Client.archiveLoaders.get(Client.archiveLoaderArchive);
			if (!var0.isLoaded()) {
				return false;
			}

			++Client.archiveLoaderArchive;
		}

		return true;
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
		return var2 + var0 + "." + var4 + "/l=" + ScriptFrame.clientLanguage + "/a=" + InvDefinition.field3199 + var3 + "/";
	}
}
