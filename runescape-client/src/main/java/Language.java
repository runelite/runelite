import java.util.Locale;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gf")
@Implements("Language")
public class Language implements Enumerated {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lgf;"
	)
	@Export("Language_EN")
	public static final Language Language_EN;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lgf;"
	)
	@Export("Language_DE")
	static final Language Language_DE;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lgf;"
	)
	@Export("Language_FR")
	public static final Language Language_FR;
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Lgf;"
	)
	@Export("Language_PT")
	static final Language Language_PT;
	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "Lgf;"
	)
	@Export("Language_NL")
	static final Language Language_NL;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lgf;"
	)
	@Export("Language_ES")
	public static final Language Language_ES;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Lgf;"
	)
	@Export("Language_ES_MX")
	static final Language Language_ES_MX;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "[Lgf;"
	)
	@Export("Language_valuesOrdered")
	public static final Language[] Language_valuesOrdered;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Ldy;"
	)
	@Export("soundCache")
	public static SoundCache soundCache;
	@ObfuscatedName("v")
	final String field2325;
	@ObfuscatedName("d")
	@Export("language")
	final String language;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 1512457825
	)
	@Export("id")
	final int id;

	static {
		Language_EN = new Language("EN", "en", "English", class192.field2345, 0, "GB");
		Language_DE = new Language("DE", "de", "German", class192.field2345, 1, "DE");
		Language_FR = new Language("FR", "fr", "French", class192.field2345, 2, "FR");
		Language_PT = new Language("PT", "pt", "Portuguese", class192.field2345, 3, "BR");
		Language_NL = new Language("NL", "nl", "Dutch", class192.field2340, 4, "NL");
		Language_ES = new Language("ES", "es", "Spanish", class192.field2340, 5, "ES");
		Language_ES_MX = new Language("ES_MX", "es-mx", "Spanish (Latin American)", class192.field2345, 6, "MX");
		Language[] var0 = new Language[]{Language_ES_MX, Language_PT, Language_NL, Language_EN, Language_FR, Language_DE, Language_ES};
		Language_valuesOrdered = new Language[var0.length];
		Language[] var2 = var0;

		for (int var3 = 0; var3 < var2.length; ++var3) {
			Language var4 = var2[var3];
			if (Language_valuesOrdered[var4.id] != null) {
				throw new IllegalStateException();
			}

			Language_valuesOrdered[var4.id] = var4;
		}

	}

	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lgh;ILjava/lang/String;)V"
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

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1410702910"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(B)Ljava/lang/String;",
		garbageValue = "109"
	)
	@Export("getLanguage")
	String getLanguage() {
		return this.language;
	}

	public String toString() {
		return this.getLanguage().toLowerCase(Locale.ENGLISH);
	}

	public String aai() {
		return this.getLanguage().toLowerCase(Locale.ENGLISH);
	}

	public String aan() {
		return this.getLanguage().toLowerCase(Locale.ENGLISH);
	}

	public String aar() {
		return this.getLanguage().toLowerCase(Locale.ENGLISH);
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(II)Lit;",
		garbageValue = "120634659"
	)
	public static VarbitDefinition method3627(int var0) {
		VarbitDefinition var1 = (VarbitDefinition)VarbitDefinition.VarbitDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = VarbitDefinition.VarbitDefinition_archive.takeFile(14, var0);
			var1 = new VarbitDefinition();
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			VarbitDefinition.VarbitDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("x")
	@Export("ViewportMouse_unpackX")
	public static int ViewportMouse_unpackX(long var0) {
		return (int)(var0 >>> 7 & 127L);
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(IIII)I",
		garbageValue = "1883889552"
	)
	static int method3634(int var0, int var1, int var2) {
		if ((Tiles.Tiles_renderFlags[var0][var1][var2] & 8) != 0) {
			return 0;
		} else {
			return var0 > 0 && (Tiles.Tiles_renderFlags[1][var1][var2] & 2) != 0 ? var0 - 1 : var0;
		}
	}
}
