import java.util.Date;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("bj")
public class class74 extends RouteStrategy {
	@ObfuscatedName("hp")
	@ObfuscatedGetter(
		intValue = 363395723
	)
	@Export("cameraPitch")
	static int cameraPitch;

	class74() {
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(IIILfm;B)Z",
		garbageValue = "-112"
	)
	@Export("hasArrived")
	public boolean hasArrived(int var1, int var2, int var3, CollisionMap var4) {
		return var2 == super.approxDestinationX && var3 == super.approxDestinationY;
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(Liy;IIIZI)V",
		garbageValue = "-1342711563"
	)
	public static void method1321(AbstractArchive var0, int var1, int var2, int var3, boolean var4) {
		class206.field2406 = 1;
		class206.musicTrackArchive = var0;
		class206.musicTrackGroupId = var1;
		class206.musicTrackFileId = var2;
		class219.musicTrackVolume = var3;
		GrandExchangeOfferUnitPriceComparator.musicTrackBoolean = var4;
		AttackOption.field1187 = 10000;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)Lfb;",
		garbageValue = "1735702864"
	)
	public static Clock method1326() {
		try {
			return new NanoClock();
		} catch (Throwable var1) {
			return new MilliClock();
		}
	}

	@ObfuscatedName("gt")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "2095073196"
	)
	@Export("getWindowedMode")
	static int getWindowedMode() {
		return Client.isResizable ? 2 : 1;
	}

	@ObfuscatedName("kp")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "-1966698976"
	)
	static void method1328(String var0) {
		WorldMapData_0.field137 = var0;

		try {
			String var1 = WorldMapSection1.client.getParameter(Integer.toString(18));
			String var2 = WorldMapSection1.client.getParameter(Integer.toString(13));
			String var3 = var1 + "settings=" + var0 + "; version=1; path=/; domain=" + var2;
			String var5;
			if (var0.length() == 0) {
				var3 = var3 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
			} else {
				String var4 = var3 + "; Expires=";
				long var6 = class217.currentTimeMillis() + 94608000000L;
				Calendar.Calendar_calendar.setTime(new Date(var6));
				int var8 = Calendar.Calendar_calendar.get(7);
				int var9 = Calendar.Calendar_calendar.get(5);
				int var10 = Calendar.Calendar_calendar.get(2);
				int var11 = Calendar.Calendar_calendar.get(1);
				int var12 = Calendar.Calendar_calendar.get(11);
				int var13 = Calendar.Calendar_calendar.get(12);
				int var14 = Calendar.Calendar_calendar.get(13);
				var5 = Calendar.DAYS_OF_THE_WEEK[var8 - 1] + ", " + var9 / 10 + var9 % 10 + "-" + Calendar.MONTH_NAMES_ENGLISH_GERMAN[0][var10] + "-" + var11 + " " + var12 / 10 + var12 % 10 + ":" + var13 / 10 + var13 % 10 + ":" + var14 / 10 + var14 % 10 + " GMT";
				var3 = var4 + var5 + "; Max-Age=" + 94608000L;
			}

			Client var16 = WorldMapSection1.client;
			var5 = "document.cookie=\"" + var3 + "\"";
			JSObject.getWindow(var16).eval(var5);
		} catch (Throwable var15) {
		}

	}
}
