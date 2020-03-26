import java.net.URL;
import java.util.Locale;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gl")
@Implements("Language")
public class Language implements Enumerated {
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lgl;"
	)
	@Export("Language_EN")
	public static final Language Language_EN;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Lgl;"
	)
	@Export("Language_DE")
	static final Language Language_DE;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lgl;"
	)
	@Export("Language_FR")
	public static final Language Language_FR;
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Lgl;"
	)
	@Export("Language_PT")
	static final Language Language_PT;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lgl;"
	)
	@Export("Language_NL")
	static final Language Language_NL;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lgl;"
	)
	@Export("Language_ES")
	public static final Language Language_ES;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lgl;"
	)
	@Export("Language_ES_MX")
	static final Language Language_ES_MX;
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "[Lgl;"
	)
	@Export("Language_valuesOrdered")
	static final Language[] Language_valuesOrdered;
	@ObfuscatedName("lr")
	@ObfuscatedSignature(
		signature = "Lhe;"
	)
	static Widget field2368;
	@ObfuscatedName("z")
	final String field2364;
	@ObfuscatedName("t")
	@Export("language")
	final String language;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 2085500911
	)
	@Export("id")
	final int id;

	static {
		Language_EN = new Language("EN", "en", "English", class201.field2375, 0, "GB");
		Language_DE = new Language("DE", "de", "German", class201.field2375, 1, "DE");
		Language_FR = new Language("FR", "fr", "French", class201.field2375, 2, "FR");
		Language_PT = new Language("PT", "pt", "Portuguese", class201.field2375, 3, "BR");
		Language_NL = new Language("NL", "nl", "Dutch", class201.field2376, 4, "NL");
		Language_ES = new Language("ES", "es", "Spanish", class201.field2376, 5, "ES");
		Language_ES_MX = new Language("ES_MX", "es-mx", "Spanish (Latin American)", class201.field2375, 6, "MX");
		Language[] var0 = method3733();
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
	Language(String var1, String var2, String var3, class201 var4, int var5, String var6) {
		this.field2364 = var1;
		this.language = var2;
		this.id = var5;
		if (var6 != null) {
			new Locale(var2.substring(0, 2), var6);
		} else {
			new Locale(var2.substring(0, 2));
		}

	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(I)Ljava/lang/String;",
		garbageValue = "-1528954067"
	)
	@Export("getLanguage")
	String getLanguage() {
		return this.language;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "56"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}

	public String toString() {
		return this.getLanguage().toLowerCase(Locale.ENGLISH);
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "75"
	)
	static void method3744() {
		if (TaskHandler.javaVendor.toLowerCase().indexOf("microsoft") != -1) {
			KeyHandler.KeyHandler_keyCodes[186] = 57;
			KeyHandler.KeyHandler_keyCodes[187] = 27;
			KeyHandler.KeyHandler_keyCodes[188] = 71;
			KeyHandler.KeyHandler_keyCodes[189] = 26;
			KeyHandler.KeyHandler_keyCodes[190] = 72;
			KeyHandler.KeyHandler_keyCodes[191] = 73;
			KeyHandler.KeyHandler_keyCodes[192] = 58;
			KeyHandler.KeyHandler_keyCodes[219] = 42;
			KeyHandler.KeyHandler_keyCodes[220] = 74;
			KeyHandler.KeyHandler_keyCodes[221] = 43;
			KeyHandler.KeyHandler_keyCodes[222] = 59;
			KeyHandler.KeyHandler_keyCodes[223] = 28;
		} else {
			KeyHandler.KeyHandler_keyCodes[44] = 71;
			KeyHandler.KeyHandler_keyCodes[45] = 26;
			KeyHandler.KeyHandler_keyCodes[46] = 72;
			KeyHandler.KeyHandler_keyCodes[47] = 73;
			KeyHandler.KeyHandler_keyCodes[59] = 57;
			KeyHandler.KeyHandler_keyCodes[61] = 27;
			KeyHandler.KeyHandler_keyCodes[91] = 42;
			KeyHandler.KeyHandler_keyCodes[92] = 74;
			KeyHandler.KeyHandler_keyCodes[93] = 43;
			KeyHandler.KeyHandler_keyCodes[192] = 28;
			KeyHandler.KeyHandler_keyCodes[222] = 58;
			KeyHandler.KeyHandler_keyCodes[520] = 59;
		}

	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)[Lii;",
		garbageValue = "806638344"
	)
	static ServerBuild[] method3751() {
		return new ServerBuild[]{ServerBuild.BUILDLIVE, ServerBuild.WIP, ServerBuild.RC, ServerBuild.LIVE};
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(B)[Lgl;",
		garbageValue = "-1"
	)
	static Language[] method3733() {
		return new Language[]{Language_FR, Language_EN, Language_ES, Language_NL, Language_PT, Language_DE, Language_ES_MX};
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-1084912738"
	)
	@Export("loadWorlds")
	static boolean loadWorlds() {
		try {
			if (LoginPacket.World_request == null) {
				LoginPacket.World_request = WorldMapLabel.urlRequester.request(new URL(class201.field2390));
			} else if (LoginPacket.World_request.isDone()) {
				byte[] var0 = LoginPacket.World_request.getResponse();
				Buffer var1 = new Buffer(var0);
				var1.readInt();
				World.World_count = var1.readUnsignedShort();
				UserComparator2.World_worlds = new World[World.World_count];

				World var3;
				for (int var2 = 0; var2 < World.World_count; var3.index = var2++) {
					var3 = UserComparator2.World_worlds[var2] = new World();
					var3.id = var1.readUnsignedShort();
					var3.properties = var1.readInt();
					var3.host = var1.readStringCp1252NullTerminated();
					var3.activity = var1.readStringCp1252NullTerminated();
					var3.location = var1.readUnsignedByte();
					var3.population = var1.readShort();
				}

				UserComparator9.sortWorlds(UserComparator2.World_worlds, 0, UserComparator2.World_worlds.length - 1, World.World_sortOption1, World.World_sortOption2);
				LoginPacket.World_request = null;
				return true;
			}
		} catch (Exception var4) {
			var4.printStackTrace();
			LoginPacket.World_request = null;
		}

		return false;
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(IIIIIII)I",
		garbageValue = "-583824694"
	)
	public static int method3749(int var0, int var1, int var2, int var3, int var4, int var5) {
		if ((var5 & 1) == 1) {
			int var6 = var3;
			var3 = var4;
			var4 = var6;
		}

		var2 &= 3;
		if (var2 == 0) {
			return var0;
		} else if (var2 == 1) {
			return var1;
		} else {
			return var2 == 2 ? 7 - var0 - (var3 - 1) : 7 - var1 - (var4 - 1);
		}
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(II)Lgl;",
		garbageValue = "-1926428299"
	)
	public static Language method3736(int var0) {
		return var0 >= 0 && var0 < Language_valuesOrdered.length ? Language_valuesOrdered[var0] : null;
	}
}
