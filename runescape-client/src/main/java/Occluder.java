import java.util.Date;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("es")
@Implements("Occluder")
public final class Occluder {
	@ObfuscatedName("ns")
	@ObfuscatedGetter(
		intValue = 1790718175
	)
	static int field1889;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 1195661333
	)
	@Export("minTileX")
	int minTileX;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -1045185805
	)
	@Export("maxTileX")
	int maxTileX;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 1813082719
	)
	@Export("minTileY")
	int minTileY;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 2061838755
	)
	@Export("maxTileY")
	int maxTileY;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = 1843610955
	)
	@Export("type")
	int type;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -629573769
	)
	@Export("minX")
	int minX;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 1170068749
	)
	@Export("maxX")
	int maxX;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 1998915961
	)
	@Export("minZ")
	int minZ;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = 88556865
	)
	@Export("maxZ")
	int maxZ;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 1146642601
	)
	@Export("minY")
	int minY;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -486759885
	)
	@Export("maxY")
	int maxY;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -1230823835
	)
	int field1882;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = -1799381643
	)
	int field1884;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = -269756741
	)
	int field1871;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 1633183437
	)
	int field1885;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 265274287
	)
	int field1886;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -1265477601
	)
	int field1879;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -163200097
	)
	int field1887;

	Occluder() {
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(II)Lit;",
		garbageValue = "1430884212"
	)
	@Export("ItemDefinition_get")
	public static ItemDefinition ItemDefinition_get(int var0) {
		ItemDefinition var1 = (ItemDefinition)ItemDefinition.ItemDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = ItemDefinition.ItemDefinition_archive.takeFile(10, var0);
			var1 = new ItemDefinition();
			var1.id = var0;
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			var1.post();
			if (var1.noteTemplate != -1) {
				var1.genCert(ItemDefinition_get(var1.noteTemplate), ItemDefinition_get(var1.note));
			}

			if (var1.notedId != -1) {
				var1.genBought(ItemDefinition_get(var1.notedId), ItemDefinition_get(var1.unnotedId));
			}

			if (var1.placeholderTemplate != -1) {
				var1.genPlaceholder(ItemDefinition_get(var1.placeholderTemplate), ItemDefinition_get(var1.placeholder));
			}

			if (!class162.ItemDefinition_inMembersWorld && var1.isMembersOnly) {
				var1.name = "Members object";
				var1.isTradable = false;
				var1.groundActions = null;
				var1.inventoryActions = null;
				var1.shiftClickIndex = -1;
				var1.team = 0;
				if (var1.params != null) {
					boolean var3 = false;

					for (Node var4 = var1.params.first(); var4 != null; var4 = var1.params.next()) {
						ParamDefinition var5 = WallDecoration.getParamDefinition((int)var4.key);
						if (var5.autoDisable) {
							var4.remove();
						} else {
							var3 = true;
						}
					}

					if (!var3) {
						var1.params = null;
					}
				}
			}

			ItemDefinition.ItemDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-37"
	)
	public static void method3252() {
		try {
			JagexCache.JagexCache_dat2File.close();

			for (int var0 = 0; var0 < JagexCache.idxCount; ++var0) {
				class189.JagexCache_idxFiles[var0].close();
			}

			JagexCache.JagexCache_idx255File.close();
			JagexCache.JagexCache_randomDat.close();
		} catch (Exception var2) {
		}

	}

	@ObfuscatedName("ku")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "-1221499190"
	)
	static void method3251(String var0) {
		class197.field2390 = var0;

		try {
			String var1 = ViewportMouse.client.getParameter(Integer.toString(18));
			String var2 = ViewportMouse.client.getParameter(Integer.toString(13));
			String var3 = var1 + "settings=" + var0 + "; version=1; path=/; domain=" + var2;
			if (var0.length() == 0) {
				var3 = var3 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
			} else {
				String var4 = var3 + "; Expires=";
				long var6 = class30.currentTimeMillis() + 94608000000L;
				Calendar.Calendar_calendar.setTime(new Date(var6));
				int var8 = Calendar.Calendar_calendar.get(7);
				int var9 = Calendar.Calendar_calendar.get(5);
				int var10 = Calendar.Calendar_calendar.get(2);
				int var11 = Calendar.Calendar_calendar.get(1);
				int var12 = Calendar.Calendar_calendar.get(11);
				int var13 = Calendar.Calendar_calendar.get(12);
				int var14 = Calendar.Calendar_calendar.get(13);
				String var5 = Calendar.DAYS_OF_THE_WEEK[var8 - 1] + ", " + var9 / 10 + var9 % 10 + "-" + Calendar.MONTH_NAMES_ENGLISH_GERMAN[0][var10] + "-" + var11 + " " + var12 / 10 + var12 % 10 + ":" + var13 / 10 + var13 % 10 + ":" + var14 / 10 + var14 % 10 + " GMT";
				var3 = var4 + var5 + "; Max-Age=" + 94608000L;
			}

			class47.method880(ViewportMouse.client, "document.cookie=\"" + var3 + "\"");
		} catch (Throwable var15) {
		}

	}
}
