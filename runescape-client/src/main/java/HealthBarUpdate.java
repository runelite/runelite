import java.util.Date;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("bh")
@Implements("HealthBarUpdate")
public class HealthBarUpdate extends Node {
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 2058375931
	)
	@Export("cycle")
	int cycle;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -309904715
	)
	@Export("health")
	int health;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = 362852511
	)
	@Export("health2")
	int health2;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 1829739139
	)
	@Export("cycleOffset")
	int cycleOffset;

	HealthBarUpdate(int var1, int var2, int var3, int var4) {
		this.cycle = var1;
		this.health = var2;
		this.health2 = var3;
		this.cycleOffset = var4;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(IIIIB)V",
		garbageValue = "-75"
	)
	@Export("set")
	void set(int var1, int var2, int var3, int var4) {
		this.cycle = var1;
		this.health = var2;
		this.health2 = var3;
		this.cycleOffset = var4;
	}

	@ObfuscatedName("c")
	static boolean method1757(long var0) {
		return Tile.method2926(var0) == 2;
	}

	@ObfuscatedName("c")
	public static String method1758(long var0) {
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

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		signature = "(ILce;ZI)I",
		garbageValue = "-601302979"
	)
	static int method1759(int var0, Script var1, boolean var2) {
		if (var0 == ScriptOpcodes.GETWINDOWMODE) {
			Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = Friend.getWindowedMode();
			return 1;
		} else {
			int var3;
			if (var0 == ScriptOpcodes.SETWINDOWMODE) {
				var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
				if (var3 == 1 || var3 == 2) {
					VertexNormal.setWindowedMode(var3);
				}

				return 1;
			} else if (var0 == ScriptOpcodes.GETDEFAULTWINDOWMODE) {
				Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = WorldMapSection2.clientPreferences.windowMode;
				return 1;
			} else if (var0 != ScriptOpcodes.SETDEFAULTWINDOWMODE) {
				if (var0 == 5310) {
					--class320.Interpreter_intStackSize;
					return 1;
				} else {
					return 2;
				}
			} else {
				var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
				if (var3 == 1 || var3 == 2) {
					WorldMapSection2.clientPreferences.windowMode = var3;
					WorldMapData_1.savePreferences();
				}

				return 1;
			}
		}
	}
}
