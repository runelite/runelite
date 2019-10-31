import java.security.SecureRandom;
import java.util.Locale;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gw")
@Implements("Language")
public class Language implements Enumerated {
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "Lgw;"
	)
	@Export("Language_EN")
	public static final Language Language_EN;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lgw;"
	)
	@Export("Language_DE")
	static final Language Language_DE;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lgw;"
	)
	@Export("Language_FR")
	public static final Language Language_FR;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lgw;"
	)
	@Export("Language_PT")
	static final Language Language_PT;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lgw;"
	)
	@Export("Language_NL")
	static final Language Language_NL;
	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "Lgw;"
	)
	@Export("Language_ES")
	public static final Language Language_ES;
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lgw;"
	)
	@Export("Language_ES_MX")
	static final Language Language_ES_MX;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "[Lgw;"
	)
	@Export("Language_valuesOrdered")
	public static final Language[] Language_valuesOrdered;
	@ObfuscatedName("ai")
	@ObfuscatedGetter(
		intValue = -252727609
	)
	static int field2328;
	@ObfuscatedName("dp")
	@ObfuscatedSignature(
		signature = "Lij;"
	)
	@Export("archive7")
	static Archive archive7;
	@ObfuscatedName("o")
	final String field2325;
	@ObfuscatedName("i")
	@Export("language")
	final String language;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -367223779
	)
	@Export("id")
	final int id;

	static {
		Language_EN = new Language("EN", "en", "English", class192.field2345, 0, "GB");
		Language_DE = new Language("DE", "de", "German", class192.field2345, 1, "DE");
		Language_FR = new Language("FR", "fr", "French", class192.field2345, 2, "FR");
		Language_PT = new Language("PT", "pt", "Portuguese", class192.field2345, 3, "BR");
		Language_NL = new Language("NL", "nl", "Dutch", class192.field2341, 4, "NL");
		Language_ES = new Language("ES", "es", "Spanish", class192.field2341, 5, "ES");
		Language_ES_MX = new Language("ES_MX", "es-mx", "Spanish (Latin American)", class192.field2345, 6, "MX");
		Language[] var0 = method3808();
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
		signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lgm;ILjava/lang/String;)V"
	)
	Language(String var1, String var2, String var3, class192 var4, int var5, String var6) {
		this.field2325 = var1;
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
		signature = "(I)Ljava/lang/String;",
		garbageValue = "-2063741998"
	)
	@Export("getLanguage")
	String getLanguage() {
		return this.language;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1993081102"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}

	public String toString() {
		return this.getLanguage().toLowerCase(Locale.ENGLISH);
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(I)Ljava/security/SecureRandom;",
		garbageValue = "810839825"
	)
	static SecureRandom method3800() {
		SecureRandom var0 = new SecureRandom();
		var0.nextInt();
		return var0;
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(I)[Lgw;",
		garbageValue = "165302960"
	)
	static Language[] method3808() {
		return new Language[]{Language_NL, Language_ES, Language_PT, Language_DE, Language_ES_MX, Language_FR, Language_EN};
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		signature = "(ILhf;ZI)V",
		garbageValue = "-294923905"
	)
	static void method3810(int var0, Coord var1, boolean var2) {
		WorldMapArea var3 = UserComparator4.getWorldMap().getMapArea(var0);
		int var4 = class215.localPlayer.Client_plane;
		int var5 = UserComparator8.baseX * 64 + (class215.localPlayer.x >> 7);
		int var6 = HealthBar.baseY * 64 + (class215.localPlayer.y >> 7);
		Coord var7 = new Coord(var4, var5, var6);
		UserComparator4.getWorldMap().method6443(var3, var7, var1, var2);
	}
}
