import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bw")
@Implements("Interpreter")
public class Interpreter {
	@ObfuscatedName("qg")
	@ObfuscatedSignature(
		signature = "Ldr;"
	)
	@Export("decimator")
	static Decimator decimator;
	@ObfuscatedName("v")
	@Export("Interpreter_intLocals")
	static int[] Interpreter_intLocals;
	@ObfuscatedName("r")
	@Export("Interpreter_arrayLengths")
	static int[] Interpreter_arrayLengths;
	@ObfuscatedName("p")
	@Export("Interpreter_arrays")
	static int[][] Interpreter_arrays;
	@ObfuscatedName("q")
	@Export("Interpreter_intStack")
	static int[] Interpreter_intStack;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 313560965
	)
	@Export("Interpreter_intStackSize")
	static int Interpreter_intStackSize;
	@ObfuscatedName("y")
	@Export("Interpreter_stringStack")
	static String[] Interpreter_stringStack;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -133806221
	)
	@Export("Interpreter_stringStackSize")
	static int Interpreter_stringStackSize;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 1889538287
	)
	@Export("Interpreter_frameDepth")
	static int Interpreter_frameDepth;
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "[Lbv;"
	)
	@Export("Interpreter_frames")
	static ScriptFrame[] Interpreter_frames;
	@ObfuscatedName("e")
	@Export("Interpreter_calendar")
	static java.util.Calendar Interpreter_calendar;
	@ObfuscatedName("w")
	@Export("Interpreter_MONTHS")
	static final String[] Interpreter_MONTHS;
	@ObfuscatedName("g")
	static boolean field1074;
	@ObfuscatedName("x")
	static boolean field1075;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = -1964719699
	)
	static int field1089;
	@ObfuscatedName("d")
	static final double field1077;

	static {
		Interpreter_arrayLengths = new int[5];
		Interpreter_arrays = new int[5][5000];
		Interpreter_intStack = new int[1000];
		Interpreter_stringStack = new String[1000];
		Interpreter_frameDepth = 0;
		Interpreter_frames = new ScriptFrame[50];
		Interpreter_calendar = java.util.Calendar.getInstance();
		Interpreter_MONTHS = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
		field1074 = false;
		field1075 = false;
		field1089 = 0;
		field1077 = Math.log(2.0D);
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Lgt;I)I",
		garbageValue = "-1997764542"
	)
	@Export("compareStrings")
	public static int compareStrings(CharSequence var0, CharSequence var1, Language var2) {
		int var3 = var0.length();
		int var4 = var1.length();
		int var5 = 0;
		int var6 = 0;
		char var7 = 0;
		char var8 = 0;

		while (var5 - var7 < var3 || var6 - var8 < var4) {
			if (var5 - var7 >= var3) {
				return -1;
			}

			if (var6 - var8 >= var4) {
				return 1;
			}

			char var9;
			if (var7 != 0) {
				var9 = var7;
				boolean var14 = false;
			} else {
				var9 = var0.charAt(var5++);
			}

			char var10;
			if (var8 != 0) {
				var10 = var8;
				boolean var15 = false;
			} else {
				var10 = var1.charAt(var6++);
			}

			var7 = class14.method175(var9);
			var8 = class14.method175(var10);
			var9 = class13.standardizeChar(var9, var2);
			var10 = class13.standardizeChar(var10, var2);
			if (var10 != var9 && Character.toUpperCase(var9) != Character.toUpperCase(var10)) {
				var9 = Character.toLowerCase(var9);
				var10 = Character.toLowerCase(var10);
				if (var10 != var9) {
					return MusicPatchNode.lowercaseChar(var9, var2) - MusicPatchNode.lowercaseChar(var10, var2);
				}
			}
		}

		int var16 = Math.min(var3, var4);

		char var12;
		int var17;
		for (var17 = 0; var17 < var16; ++var17) {
			if (var2 == Language.Language_FR) {
				var5 = var3 - 1 - var17;
				var6 = var4 - 1 - var17;
			} else {
				var6 = var17;
				var5 = var17;
			}

			char var11 = var0.charAt(var5);
			var12 = var1.charAt(var6);
			if (var11 != var12 && Character.toUpperCase(var11) != Character.toUpperCase(var12)) {
				var11 = Character.toLowerCase(var11);
				var12 = Character.toLowerCase(var12);
				if (var12 != var11) {
					return MusicPatchNode.lowercaseChar(var11, var2) - MusicPatchNode.lowercaseChar(var12, var2);
				}
			}
		}

		var17 = var3 - var4;
		if (var17 != 0) {
			return var17;
		} else {
			for (int var18 = 0; var18 < var16; ++var18) {
				var12 = var0.charAt(var18);
				char var13 = var1.charAt(var18);
				if (var13 != var12) {
					return MusicPatchNode.lowercaseChar(var12, var2) - MusicPatchNode.lowercaseChar(var13, var2);
				}
			}

			return 0;
		}
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;IB)Z",
		garbageValue = "106"
	)
	static boolean method2025(String var0, int var1) {
		return WorldMapID.method567(var0, var1, "openjs");
	}
}
