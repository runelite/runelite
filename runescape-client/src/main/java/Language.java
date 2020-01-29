import java.util.Locale;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gl")
@Implements("Language")
public class Language implements Enumerated {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lgl;"
	)
	@Export("Language_EN")
	public static final Language Language_EN;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lgl;"
	)
	@Export("Language_DE")
	static final Language Language_DE;
	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "Lgl;"
	)
	@Export("Language_FR")
	public static final Language Language_FR;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lgl;"
	)
	@Export("Language_PT")
	static final Language Language_PT;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lgl;"
	)
	@Export("Language_NL")
	static final Language Language_NL;
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Lgl;"
	)
	@Export("Language_ES")
	public static final Language Language_ES;
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Lgl;"
	)
	@Export("Language_ES_MX")
	static final Language Language_ES_MX;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "[Lgl;"
	)
	@Export("Language_valuesOrdered")
	static final Language[] Language_valuesOrdered;
	@ObfuscatedName("fy")
	@ObfuscatedGetter(
		intValue = -175340917
	)
	@Export("baseY")
	static int baseY;
	@ObfuscatedName("fq")
	@ObfuscatedGetter(
		intValue = 714439481
	)
	static int field2359;
	@ObfuscatedName("jm")
	@ObfuscatedSignature(
		signature = "Ldr;"
	)
	@Export("textureProvider")
	static TextureProvider textureProvider;
	@ObfuscatedName("l")
	final String field2361;
	@ObfuscatedName("j")
	@Export("language")
	final String language;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 1330726969
	)
	@Export("id")
	final int id;

	static {
		Language_EN = new Language("EN", "en", "English", class192.field2380, 0, "GB");
		Language_DE = new Language("DE", "de", "German", class192.field2380, 1, "DE");
		Language_FR = new Language("FR", "fr", "French", class192.field2380, 2, "FR");
		Language_PT = new Language("PT", "pt", "Portuguese", class192.field2380, 3, "BR");
		Language_NL = new Language("NL", "nl", "Dutch", class192.field2382, 4, "NL");
		Language_ES = new Language("ES", "es", "Spanish", class192.field2382, 5, "ES");
		Language_ES_MX = new Language("ES_MX", "es-mx", "Spanish (Latin American)", class192.field2380, 6, "MX");
		Language[] var0 = method3716();
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
		signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lgp;ILjava/lang/String;)V"
	)
	Language(String var1, String var2, String var3, class192 var4, int var5, String var6) {
		this.field2361 = var1;
		this.language = var2;
		this.id = var5;
		if (var6 != null) {
			new Locale(var2.substring(0, 2), var6);
		} else {
			new Locale(var2.substring(0, 2));
		}

	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(B)Ljava/lang/String;",
		garbageValue = "-101"
	)
	@Export("getLanguage")
	String getLanguage() {
		return this.language;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "1"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}

	public String toString() {
		return this.getLanguage().toLowerCase(Locale.ENGLISH);
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(II)Ljava/lang/String;",
		garbageValue = "1944388851"
	)
	static String method3728(int var0) {
		return "<img=" + var0 + ">";
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)[Lgl;",
		garbageValue = "-78751663"
	)
	static Language[] method3716() {
		return new Language[]{Language_PT, Language_NL, Language_DE, Language_EN, Language_ES_MX, Language_ES, Language_FR};
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(II)Lgl;",
		garbageValue = "523180108"
	)
	public static Language method3711(int var0) {
		return var0 >= 0 && var0 < Language_valuesOrdered.length ? Language_valuesOrdered[var0] : null;
	}
}
