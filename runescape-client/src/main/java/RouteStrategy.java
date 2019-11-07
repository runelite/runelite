import java.util.Date;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fc")
@Implements("RouteStrategy")
public abstract class RouteStrategy {
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = -1359594725
	)
	@Export("approxDestinationX")
	public int approxDestinationX;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 1078998847
	)
	@Export("approxDestinationY")
	public int approxDestinationY;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 1265963087
	)
	@Export("approxDestinationSizeX")
	public int approxDestinationSizeX;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 1331790243
	)
	@Export("approxDestinationSizeY")
	public int approxDestinationSizeY;

	protected RouteStrategy() {
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(IIILfm;B)Z",
		garbageValue = "16"
	)
	@Export("hasArrived")
	protected abstract boolean hasArrived(int var1, int var2, int var3, CollisionMap var4);

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "([Ljava/lang/String;[SIII)V",
		garbageValue = "1742711992"
	)
	@Export("sortItemsByName")
	public static void sortItemsByName(String[] var0, short[] var1, int var2, int var3) {
		if (var2 < var3) {
			int var4 = (var3 + var2) / 2;
			int var5 = var2;
			String var6 = var0[var4];
			var0[var4] = var0[var3];
			var0[var3] = var6;
			short var7 = var1[var4];
			var1[var4] = var1[var3];
			var1[var3] = var7;

			for (int var8 = var2; var8 < var3; ++var8) {
				if (var6 == null || var0[var8] != null && var0[var8].compareTo(var6) < (var8 & 1)) {
					String var9 = var0[var8];
					var0[var8] = var0[var5];
					var0[var5] = var9;
					short var10 = var1[var8];
					var1[var8] = var1[var5];
					var1[var5++] = var10;
				}
			}

			var0[var3] = var0[var5];
			var0[var5] = var6;
			var1[var3] = var1[var5];
			var1[var5] = var7;
			sortItemsByName(var0, var1, var2, var5 - 1);
			sortItemsByName(var0, var1, var5 + 1, var3);
		}

	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "([BI)Lks;",
		garbageValue = "-794293590"
	)
	static Font method3738(byte[] var0) {
		if (var0 == null) {
			return null;
		} else {
			Font var1 = new Font(var0, SecureRandomFuture.SpriteBuffer_xOffsets, HealthBar.SpriteBuffer_yOffsets, SecureRandomCallable.SpriteBuffer_spriteWidths, AttackOption.SpriteBuffer_spriteHeights, class325.SpriteBuffer_spritePalette, class325.SpriteBuffer_pixels);
			WorldMapData_1.method787();
			return var1;
		}
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "-1542036969"
	)
	static final int method3736(int var0, int var1) {
		int var2 = DevicePcmPlayerProvider.method918(var0 - 1, var1 - 1) + DevicePcmPlayerProvider.method918(1 + var0, var1 - 1) + DevicePcmPlayerProvider.method918(var0 - 1, 1 + var1) + DevicePcmPlayerProvider.method918(1 + var0, 1 + var1);
		int var3 = DevicePcmPlayerProvider.method918(var0 - 1, var1) + DevicePcmPlayerProvider.method918(var0 + 1, var1) + DevicePcmPlayerProvider.method918(var0, var1 - 1) + DevicePcmPlayerProvider.method918(var0, 1 + var1);
		int var4 = DevicePcmPlayerProvider.method918(var0, var1);
		return var2 / 16 + var3 / 8 + var4 / 4;
	}

	@ObfuscatedName("he")
	@ObfuscatedSignature(
		signature = "(IIIIB)V",
		garbageValue = "-39"
	)
	static final void method3734(int var0, int var1, int var2, int var3) {
		WorldMapSection1.method622();
	}

	@ObfuscatedName("lt")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;S)V",
		garbageValue = "-1363"
	)
	static void method3735(String var0) {
		MilliClock.field1994 = var0;

		try {
			String var1 = WorldMapID.client.getParameter(Integer.toString(18));
			String var2 = WorldMapID.client.getParameter(Integer.toString(13));
			String var3 = var1 + "settings=" + var0 + "; version=1; path=/; domain=" + var2;
			if (var0.length() == 0) {
				var3 = var3 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
			} else {
				String var4 = var3 + "; Expires=";
				long var6 = PlayerAppearance.currentTimeMillis() + 94608000000L;
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

			class47.method922(WorldMapID.client, "document.cookie=\"" + var3 + "\"");
		} catch (Throwable var15) {
		}

	}
}
