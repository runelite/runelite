import java.util.Locale;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gk")
@Implements("Language")
public class Language implements Enumerated {
	@ObfuscatedName("sz")
	@ObfuscatedGetter(
		intValue = -16153155
	)
	@Export("foundItemIdCount")
	static int foundItemIdCount;
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "Lgk;"
	)
	@Export("Language_EN")
	public static final Language Language_EN;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Lgk;"
	)
	@Export("Language_DE")
	static final Language Language_DE;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lgk;"
	)
	@Export("Language_FR")
	public static final Language Language_FR;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lgk;"
	)
	@Export("Language_PT")
	static final Language Language_PT;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lgk;"
	)
	@Export("Language_NL")
	static final Language Language_NL;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lgk;"
	)
	@Export("Language_ES")
	public static final Language Language_ES;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lgk;"
	)
	@Export("Language_ES_MX")
	static final Language Language_ES_MX;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "[Lgk;"
	)
	@Export("Language_valuesOrdered")
	static final Language[] Language_valuesOrdered;
	@ObfuscatedName("cu")
	@ObfuscatedSignature(
		signature = "Lbs;"
	)
	@Export("mouseRecorder")
	static MouseRecorder mouseRecorder;
	@ObfuscatedName("q")
	final String field2330;
	@ObfuscatedName("x")
	@Export("language")
	final String language;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 327521065
	)
	@Export("id")
	final int id;

	static {
		Language_EN = new Language("EN", "en", "English", class192.field2360, 0, "GB");
		Language_DE = new Language("DE", "de", "German", class192.field2360, 1, "DE");
		Language_FR = new Language("FR", "fr", "French", class192.field2360, 2, "FR");
		Language_PT = new Language("PT", "pt", "Portuguese", class192.field2360, 3, "BR");
		Language_NL = new Language("NL", "nl", "Dutch", class192.field2361, 4, "NL");
		Language_ES = new Language("ES", "es", "Spanish", class192.field2361, 5, "ES");
		Language_ES_MX = new Language("ES_MX", "es-mx", "Spanish (Latin American)", class192.field2360, 6, "MX");
		Language[] var0 = new Language[]{Language_ES_MX, Language_DE, Language_FR, Language_EN, Language_PT, Language_ES, Language_NL};
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
		signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lgm;ILjava/lang/String;)V"
	)
	Language(String var1, String var2, String var3, class192 var4, int var5, String var6) {
		this.field2330 = var1;
		this.language = var2;
		this.id = var5;
		if (var6 != null) {
			new Locale(var2.substring(0, 2), var6);
		} else {
			new Locale(var2.substring(0, 2));
		}

	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(B)Ljava/lang/String;",
		garbageValue = "2"
	)
	@Export("getLanguage")
	String getLanguage() {
		return this.language;
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "-32"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}

	public String abb() {
		return this.getLanguage().toLowerCase(Locale.ENGLISH);
	}

	public String abd() {
		return this.getLanguage().toLowerCase(Locale.ENGLISH);
	}

	public String toString() {
		return this.getLanguage().toLowerCase(Locale.ENGLISH);
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(Lhz;Lhz;B)I",
		garbageValue = "7"
	)
	static int method3607(AbstractArchive var0, AbstractArchive var1) {
		int var2 = 0;
		if (var0.tryLoadFileByNames("title.jpg", "")) {
			++var2;
		}

		if (var1.tryLoadFileByNames("logo", "")) {
			++var2;
		}

		if (var1.tryLoadFileByNames("logo_deadman_mode", "")) {
			++var2;
		}

		if (var1.tryLoadFileByNames("titlebox", "")) {
			++var2;
		}

		if (var1.tryLoadFileByNames("titlebutton", "")) {
			++var2;
		}

		if (var1.tryLoadFileByNames("runes", "")) {
			++var2;
		}

		if (var1.tryLoadFileByNames("title_mute", "")) {
			++var2;
		}

		if (var1.tryLoadFileByNames("options_radio_buttons,0", "")) {
			++var2;
		}

		if (var1.tryLoadFileByNames("options_radio_buttons,2", "")) {
			++var2;
		}

		if (var1.tryLoadFileByNames("options_radio_buttons,4", "")) {
			++var2;
		}

		if (var1.tryLoadFileByNames("options_radio_buttons,6", "")) {
			++var2;
		}

		var1.tryLoadFileByNames("sl_back", "");
		var1.tryLoadFileByNames("sl_flags", "");
		var1.tryLoadFileByNames("sl_arrows", "");
		var1.tryLoadFileByNames("sl_stars", "");
		var1.tryLoadFileByNames("sl_button", "");
		return var2;
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "1963190030"
	)
	static int method3605(int var0, int var1) {
		ItemContainer var2 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
		if (var2 == null) {
			return -1;
		} else {
			return var1 >= 0 && var1 < var2.ids.length ? var2.ids[var1] : -1;
		}
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(II)Lgk;",
		garbageValue = "1747092797"
	)
	public static Language method3602(int var0) {
		return var0 >= 0 && var0 < Language_valuesOrdered.length ? Language_valuesOrdered[var0] : null;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(IIIZIZI)V",
		garbageValue = "1439063090"
	)
	@Export("doWorldSorting")
	static void doWorldSorting(int var0, int var1, int var2, boolean var3, int var4, boolean var5) {
		if (var0 < var1) {
			int var6 = (var0 + var1) / 2;
			int var7 = var0;
			World var8 = ChatChannel.World_worlds[var6];
			ChatChannel.World_worlds[var6] = ChatChannel.World_worlds[var1];
			ChatChannel.World_worlds[var1] = var8;

			for (int var9 = var0; var9 < var1; ++var9) {
				World var11 = ChatChannel.World_worlds[var9];
				int var12 = SoundSystem.compareWorlds(var11, var8, var2, var3);
				int var10;
				if (var12 != 0) {
					if (var3) {
						var10 = -var12;
					} else {
						var10 = var12;
					}
				} else if (var4 == -1) {
					var10 = 0;
				} else {
					int var13 = SoundSystem.compareWorlds(var11, var8, var4, var5);
					if (var5) {
						var10 = -var13;
					} else {
						var10 = var13;
					}
				}

				if (var10 <= 0) {
					World var14 = ChatChannel.World_worlds[var9];
					ChatChannel.World_worlds[var9] = ChatChannel.World_worlds[var7];
					ChatChannel.World_worlds[var7++] = var14;
				}
			}

			ChatChannel.World_worlds[var1] = ChatChannel.World_worlds[var7];
			ChatChannel.World_worlds[var7] = var8;
			doWorldSorting(var0, var7 - 1, var2, var3, var4, var5);
			doWorldSorting(var7 + 1, var1, var2, var3, var4, var5);
		}

	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "987428009"
	)
	@Export("Messages_getLastChatID")
	static int Messages_getLastChatID(int var0) {
		Message var1 = (Message)Messages.Messages_hashTable.get((long)var0);
		if (var1 == null) {
			return -1;
		} else {
			return var1.nextDual == Messages.Messages_queue.sentinel ? -1 : ((Message)var1.nextDual).count;
		}
	}
}
