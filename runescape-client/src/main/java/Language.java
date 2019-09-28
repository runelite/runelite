import java.util.Locale;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gt")
@Implements("Language")
public class Language implements Enumerated {
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Lgt;"
	)
	@Export("Language_EN")
	public static final Language Language_EN;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lgt;"
	)
	@Export("Language_DE")
	static final Language Language_DE;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lgt;"
	)
	@Export("Language_FR")
	public static final Language Language_FR;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lgt;"
	)
	@Export("Language_PT")
	static final Language Language_PT;
	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "Lgt;"
	)
	@Export("Language_NL")
	static final Language Language_NL;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lgt;"
	)
	@Export("Language_ES")
	public static final Language Language_ES;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lgt;"
	)
	@Export("Language_ES_MX")
	static final Language Language_ES_MX;
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "[Lgt;"
	)
	@Export("Language_valuesOrdered")
	static final Language[] Language_valuesOrdered;
	@ObfuscatedName("bc")
	@ObfuscatedSignature(
		signature = "[Llp;"
	)
	@Export("worldSelectFlagSprites")
	static IndexedSprite[] worldSelectFlagSprites;
	@ObfuscatedName("dz")
	@ObfuscatedSignature(
		signature = "Lie;"
	)
	@Export("archive7")
	static Archive archive7;
	@ObfuscatedName("m")
	final String field2338;
	@ObfuscatedName("y")
	@Export("language")
	final String language;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 1051697599
	)
	@Export("id")
	final int id;

	static {
		Language_EN = new Language("EN", "en", "English", class192.field2362, 0, "GB");
		Language_DE = new Language("DE", "de", "German", class192.field2362, 1, "DE");
		Language_FR = new Language("FR", "fr", "French", class192.field2362, 2, "FR");
		Language_PT = new Language("PT", "pt", "Portuguese", class192.field2362, 3, "BR");
		Language_NL = new Language("NL", "nl", "Dutch", class192.field2353, 4, "NL");
		Language_ES = new Language("ES", "es", "Spanish", class192.field2353, 5, "ES");
		Language_ES_MX = new Language("ES_MX", "es-mx", "Spanish (Latin American)", class192.field2362, 6, "MX");
		Language[] var0 = method3638();
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
		signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lgs;ILjava/lang/String;)V"
	)
	Language(String var1, String var2, String var3, class192 var4, int var5, String var6) {
		this.field2338 = var1;
		this.language = var2;
		this.id = var5;
		if (var6 != null) {
			new Locale(var2.substring(0, 2), var6);
		} else {
			new Locale(var2.substring(0, 2));
		}

	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(I)Ljava/lang/String;",
		garbageValue = "-1300604357"
	)
	@Export("getLanguage")
	String getLanguage() {
		return this.language;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(S)I",
		garbageValue = "221"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}

	public String toString() {
		return this.getLanguage().toLowerCase(Locale.ENGLISH);
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(I)[Lgt;",
		garbageValue = "1567762755"
	)
	static Language[] method3638() {
		return new Language[]{Language_PT, Language_EN, Language_NL, Language_ES, Language_FR, Language_ES_MX, Language_DE};
	}

	@ObfuscatedName("n")
	public static boolean method3635(long var0) {
		boolean var2 = 0L != var0;
		if (var2) {
			boolean var3 = (int)(var0 >>> 16 & 1L) == 1;
			var2 = !var3;
		}

		return var2;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(II)Lgt;",
		garbageValue = "-1627784008"
	)
	public static Language method3618(int var0) {
		return var0 >= 0 && var0 < Language_valuesOrdered.length ? Language_valuesOrdered[var0] : null;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(S)V",
		garbageValue = "6522"
	)
	@Export("savePreferences")
	static void savePreferences() {
		AccessFile var0 = null;

		try {
			var0 = class185.getPreferencesFile("", class16.field101.name, true);
			Buffer var1 = AbstractArchive.clientPreferences.toBuffer();
			var0.write(var1.array, 0, var1.offset);
		} catch (Exception var3) {
		}

		try {
			if (var0 != null) {
				var0.closeSync(true);
			}
		} catch (Exception var2) {
		}

	}
}
