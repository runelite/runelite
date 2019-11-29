import java.util.Date;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hc")
public class class215 {
	@ObfuscatedName("u")
	public static final short[] field2553;
	@ObfuscatedName("f")
	public static final short[][] field2554;
	@ObfuscatedName("b")
	public static final short[] field2555;
	@ObfuscatedName("g")
	public static final short[][] field2556;
	@ObfuscatedName("jg")
	@ObfuscatedSignature(
		signature = "Lbg;"
	)
	@Export("localPlayer")
	static Player localPlayer;

	static {
		field2553 = new short[]{6798, 8741, 25238, 4626, 4550};
		field2554 = new short[][]{{6798, 107, 10283, 16, 4797, 7744, 5799, 4634, -31839, 22433, 2983, -11343, 8, 5281, 10438, 3650, -27322, -21845, 200, 571, 908, 21830, 28946, -15701, -14010}, {8741, 12, -1506, -22374, 7735, 8404, 1701, -27106, 24094, 10153, -8915, 4783, 1341, 16578, -30533, 25239, 8, 5281, 10438, 3650, -27322, -21845, 200, 571, 908, 21830, 28946, -15701, -14010}, {25238, 8742, 12, -1506, -22374, 7735, 8404, 1701, -27106, 24094, 10153, -8915, 4783, 1341, 16578, -30533, 8, 5281, 10438, 3650, -27322, -21845, 200, 571, 908, 21830, 28946, -15701, -14010}, {4626, 11146, 6439, 12, 4758, 10270}, {4550, 4537, 5681, 5673, 5790, 6806, 8076, 4574, 17050, 0, 127, -31821, -17991}};
		field2555 = new short[]{-10304, 9104, -1, -1, -1};
		field2556 = new short[][]{{6554, 115, 10304, 28, 5702, 7756, 5681, 4510, -31835, 22437, 2859, -11339, 16, 5157, 10446, 3658, -27314, -21965, 472, 580, 784, 21966, 28950, -15697, -14002}, {9104, 10275, 7595, 3610, 7975, 8526, 918, -26734, 24466, 10145, -6882, 5027, 1457, 16565, -30545, 25486, 24, 5392, 10429, 3673, -27335, -21957, 192, 687, 412, 21821, 28835, -15460, -14019}, new short[0], new short[0], new short[0]};
	}

	@ObfuscatedName("u")
	public static String method4107(long var0) {
		Calendar.Calendar_calendar.setTime(new Date(var0));
		int var2 = Calendar.Calendar_calendar.get(7);
		int var3 = Calendar.Calendar_calendar.get(5);
		int var4 = Calendar.Calendar_calendar.get(2);
		int var5 = Calendar.Calendar_calendar.get(1);
		int var6 = Calendar.Calendar_calendar.get(11);
		int var7 = Calendar.Calendar_calendar.get(12);
		int var8 = Calendar.Calendar_calendar.get(13);
		return Calendar.DAYS_OF_THE_WEEK[var2 - 1] + ", " + var3 / 10 + var3 % 10 + "-" + Calendar.MONTH_NAMES_ENGLISH_GERMAN[0][var4] + "-" + var5 + " " + var6 / 10 + var6 % 10 + ":" + var7 / 10 + var7 % 10 + ":" + var8 / 10 + var8 % 10 + " GMT";
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "-266411833"
	)
	public static boolean method4109(int var0) {
		return (var0 >> 28 & 1) != 0;
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(B)Lbp;",
		garbageValue = "11"
	)
	@Export("worldListStart")
	static World worldListStart() {
		World.World_listCount = 0;
		return class1.getNextWorldListWorld();
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(Lhl;II)V",
		garbageValue = "-533356925"
	)
	@Export("Widget_setKeyIgnoreHeld")
	static final void Widget_setKeyIgnoreHeld(Widget var0, int var1) {
		if (var0.field2592 == null) {
			throw new RuntimeException();
		} else {
			if (var0.field2695 == null) {
				var0.field2695 = new int[var0.field2592.length];
			}

			var0.field2695[var1] = Integer.MAX_VALUE;
		}
	}

	@ObfuscatedName("hj")
	@ObfuscatedSignature(
		signature = "(Lbe;I)V",
		garbageValue = "2102952401"
	)
	static final void method4108(PendingSpawn var0) {
		long var1 = 0L;
		int var3 = -1;
		int var4 = 0;
		int var5 = 0;
		if (var0.type == 0) {
			var1 = class2.scene.getBoundaryObjectTag(var0.plane, var0.x, var0.y);
		}

		if (var0.type == 1) {
			var1 = class2.scene.getWallDecorationTag(var0.plane, var0.x, var0.y);
		}

		if (var0.type == 2) {
			var1 = class2.scene.getGameObjectTag(var0.plane, var0.x, var0.y);
		}

		if (var0.type == 3) {
			var1 = class2.scene.getFloorDecorationTag(var0.plane, var0.x, var0.y);
		}

		if (var1 != 0L) {
			int var6 = class2.scene.getObjectFlags(var0.plane, var0.x, var0.y, var1);
			var3 = ItemContainer.Entity_unpackID(var1);
			var4 = var6 & 31;
			var5 = var6 >> 6 & 3;
		}

		var0.objectId = var3;
		var0.field924 = var4;
		var0.field929 = var5;
	}
}
