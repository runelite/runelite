import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("by")
@Implements("Interpreter")
public class Interpreter {
	@ObfuscatedName("qg")
	@ObfuscatedGetter(
		intValue = 596908915
	)
	static int field1068;
	@ObfuscatedName("q")
	@Export("Interpreter_stringLocals")
	static String[] Interpreter_stringLocals;
	@ObfuscatedName("v")
	@Export("Interpreter_arrayLengths")
	static int[] Interpreter_arrayLengths;
	@ObfuscatedName("l")
	@Export("Interpreter_arrays")
	static int[][] Interpreter_arrays;
	@ObfuscatedName("c")
	@Export("Interpreter_intStack")
	static int[] Interpreter_intStack;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = -548793337
	)
	@Export("Interpreter_intStackSize")
	static int Interpreter_intStackSize;
	@ObfuscatedName("i")
	@Export("Interpreter_stringStack")
	static String[] Interpreter_stringStack;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -36200349
	)
	static int field1063;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -1766816567
	)
	@Export("Interpreter_frameDepth")
	static int Interpreter_frameDepth;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "[Lbx;"
	)
	@Export("Interpreter_frames")
	static ScriptFrame[] Interpreter_frames;
	@ObfuscatedName("x")
	@Export("Interpreter_calendar")
	static java.util.Calendar Interpreter_calendar;
	@ObfuscatedName("j")
	@Export("Interpreter_MONTHS")
	static final String[] Interpreter_MONTHS;
	@ObfuscatedName("e")
	static boolean field1075;
	@ObfuscatedName("s")
	static boolean field1076;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = 1096350801
	)
	static int field1080;
	@ObfuscatedName("w")
	static final double field1078;
	@ObfuscatedName("bi")
	@ObfuscatedSignature(
		signature = "[Llw;"
	)
	@Export("worldSelectStars")
	static IndexedSprite[] worldSelectStars;

	static {
		Interpreter_arrayLengths = new int[5];
		Interpreter_arrays = new int[5][5000];
		Interpreter_intStack = new int[1000];
		Interpreter_stringStack = new String[1000];
		Interpreter_frameDepth = 0;
		Interpreter_frames = new ScriptFrame[50];
		Interpreter_calendar = java.util.Calendar.getInstance();
		Interpreter_MONTHS = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
		field1075 = false;
		field1076 = false;
		field1080 = 0;
		field1078 = Math.log(2.0D);
	}
}
