import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("j")
@Implements("GrandExchangeEvents")
public class GrandExchangeEvents {
	@ObfuscatedName("x")
	@Export("GrandExchangeEvents_ageComparator")
	public static Comparator GrandExchangeEvents_ageComparator;
	@ObfuscatedName("t")
	@Export("GrandExchangeEvents_priceComparator")
	public static Comparator GrandExchangeEvents_priceComparator;
	@ObfuscatedName("g")
	@Export("GrandExchangeEvents_nameComparator")
	public static Comparator GrandExchangeEvents_nameComparator;
	@ObfuscatedName("l")
	@Export("GrandExchangeEvents_quantityComparator")
	public static Comparator GrandExchangeEvents_quantityComparator;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 1066542769
	)
	@Export("PcmPlayer_count")
	static int PcmPlayer_count;
	@ObfuscatedName("gd")
	@ObfuscatedSignature(
		signature = "[Lli;"
	)
	@Export("headIconHintSprites")
	static Sprite[] headIconHintSprites;
	@ObfuscatedName("c")
	@Export("events")
	public final List events;

	static {
		GrandExchangeEvents_ageComparator = new GrandExchangeOfferAgeComparator();
		new GrandExchangeOfferWorldComparator();
		GrandExchangeEvents_priceComparator = new GrandExchangeOfferUnitPriceComparator();
		GrandExchangeEvents_nameComparator = new GrandExchangeOfferNameComparator();
		GrandExchangeEvents_quantityComparator = new GrandExchangeOfferTotalQuantityComparator();
	}

	@ObfuscatedSignature(
		signature = "(Lkz;Z)V",
		garbageValue = "1"
	)
	public GrandExchangeEvents(Buffer var1, boolean var2) {
		int var3 = var1.readUnsignedShort();
		boolean var4 = var1.readUnsignedByte() == 1;
		byte var5;
		if (var4) {
			var5 = 1;
		} else {
			var5 = 0;
		}

		int var6 = var1.readUnsignedShort();
		this.events = new ArrayList(var6);

		for (int var7 = 0; var7 < var6; ++var7) {
			this.events.add(new GrandExchangeEvent(var1, var5, var3));
		}

	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Ljava/util/Comparator;ZB)V",
		garbageValue = "0"
	)
	@Export("sort")
	public void sort(Comparator var1, boolean var2) {
		if (var2) {
			Collections.sort(this.events, var1);
		} else {
			Collections.sort(this.events, Collections.reverseOrder(var1));
		}

	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Lhz;Lhz;ZLkf;B)V",
		garbageValue = "118"
	)
	public static void method69(AbstractArchive var0, AbstractArchive var1, boolean var2, Font var3) {
		class65.ItemDefinition_archive = var0;
		ItemDefinition.ItemDefinition_modelArchive = var1;
		ItemDefinition.ItemDefinition_inMembersWorld = var2;
		ItemDefinition.ItemDefinition_fileCount = class65.ItemDefinition_archive.getGroupFileCount(10);
		class215.ItemDefinition_fontPlain11 = var3;
	}

	@ObfuscatedName("jp")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "2004785230"
	)
	static final void method66() {
		Client.field815 = Client.cycleCntr;
	}

	@ObfuscatedName("ko")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;ZB)Ljava/lang/String;",
		garbageValue = "59"
	)
	static String method67(String var0, boolean var1) {
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
		if (WorldMapArea.field217 != null) {
			var3 = "/p=" + WorldMapArea.field217;
		}

		String var4 = "runescape.com";
		return var2 + var0 + "." + var4 + "/l=" + class43.clientLanguage + "/a=" + MouseRecorder.field565 + var3 + "/";
	}

	@ObfuscatedName("kq")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)Ljava/lang/String;",
		garbageValue = "-1862958560"
	)
	static String method68(String var0) {
		PlayerType[] var1 = PlayerAppearance.PlayerType_values();

		for (int var2 = 0; var2 < var1.length; ++var2) {
			PlayerType var3 = var1[var2];
			if (var3.modIcon != -1 && var0.startsWith(ArchiveDiskAction.method4133(var3.modIcon))) {
				var0 = var0.substring(6 + Integer.toString(var3.modIcon).length());
				break;
			}
		}

		return var0;
	}
}
