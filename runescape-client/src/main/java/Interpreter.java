import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("be")
@Implements("Interpreter")
public class Interpreter {
	@ObfuscatedName("e")
	@Export("Interpreter_intLocals")
	static int[] Interpreter_intLocals;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lga;"
	)
	@Export("midiPcmStream")
	public static MidiPcmStream midiPcmStream;
	@ObfuscatedName("k")
	@Export("Interpreter_arrayLengths")
	static int[] Interpreter_arrayLengths;
	@ObfuscatedName("l")
	@Export("Interpreter_arrays")
	static int[][] Interpreter_arrays;
	@ObfuscatedName("b")
	@Export("Interpreter_intStack")
	static int[] Interpreter_intStack;
	@ObfuscatedName("c")
	@Export("Interpreter_stringStack")
	static String[] Interpreter_stringStack;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -340268151
	)
	@Export("Interpreter_frameDepth")
	static int Interpreter_frameDepth;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "[Lbh;"
	)
	@Export("Interpreter_frames")
	static ScriptFrame[] Interpreter_frames;
	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "Lhj;"
	)
	static Widget field1111;
	@ObfuscatedName("v")
	@Export("Interpreter_calendar")
	static java.util.Calendar Interpreter_calendar;
	@ObfuscatedName("y")
	@Export("Interpreter_MONTHS")
	static final String[] Interpreter_MONTHS;
	@ObfuscatedName("a")
	static boolean field1104;
	@ObfuscatedName("j")
	static boolean field1105;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -662324053
	)
	static int field1106;
	@ObfuscatedName("d")
	static final double field1110;
	@ObfuscatedName("hr")
	@ObfuscatedGetter(
		intValue = 973734975
	)
	@Export("cameraYaw")
	static int cameraYaw;

	static {
		Interpreter_arrayLengths = new int[5];
		Interpreter_arrays = new int[5][5000];
		Interpreter_intStack = new int[1000];
		Interpreter_stringStack = new String[1000];
		Interpreter_frameDepth = 0;
		Interpreter_frames = new ScriptFrame[50];
		Interpreter_calendar = java.util.Calendar.getInstance();
		Interpreter_MONTHS = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
		field1104 = false;
		field1105 = false;
		field1106 = 0;
		field1110 = Math.log(2.0D);
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)[Lgc;",
		garbageValue = "-23272757"
	)
	@Export("ServerPacket_values")
	public static ServerPacket[] ServerPacket_values() {
		return new ServerPacket[]{ServerPacket.field2160, ServerPacket.field2116, ServerPacket.field2117, ServerPacket.field2152, ServerPacket.field2119, ServerPacket.field2165, ServerPacket.field2178, ServerPacket.field2122, ServerPacket.field2190, ServerPacket.field2176, ServerPacket.field2141, ServerPacket.field2126, ServerPacket.field2127, ServerPacket.field2128, ServerPacket.field2129, ServerPacket.field2130, ServerPacket.field2131, ServerPacket.field2120, ServerPacket.field2133, ServerPacket.field2134, ServerPacket.field2125, ServerPacket.field2136, ServerPacket.field2191, ServerPacket.field2138, ServerPacket.field2139, ServerPacket.field2140, ServerPacket.field2137, ServerPacket.field2135, ServerPacket.field2143, ServerPacket.field2144, ServerPacket.field2181, ServerPacket.field2175, ServerPacket.field2147, ServerPacket.field2148, ServerPacket.field2149, ServerPacket.field2118, ServerPacket.field2151, ServerPacket.field2202, ServerPacket.field2180, ServerPacket.field2154, ServerPacket.field2155, ServerPacket.field2156, ServerPacket.field2157, ServerPacket.field2162, ServerPacket.field2159, ServerPacket.field2189, ServerPacket.field2161, ServerPacket.field2150, ServerPacket.field2163, ServerPacket.field2164, ServerPacket.field2123, ServerPacket.field2166, ServerPacket.field2167, ServerPacket.field2153, ServerPacket.field2142, ServerPacket.field2170, ServerPacket.field2171, ServerPacket.field2172, ServerPacket.field2132, ServerPacket.field2174, ServerPacket.field2169, ServerPacket.field2124, ServerPacket.field2177, ServerPacket.field2168, ServerPacket.field2179, ServerPacket.field2158, ServerPacket.field2173, ServerPacket.field2182, ServerPacket.field2183, ServerPacket.field2184, ServerPacket.field2185, ServerPacket.field2186, ServerPacket.field2187, ServerPacket.field2188, ServerPacket.field2115, ServerPacket.field2121, ServerPacket.field2145, ServerPacket.field2192, ServerPacket.field2193, ServerPacket.field2194, ServerPacket.field2195, ServerPacket.field2196, ServerPacket.field2197, ServerPacket.field2198, ServerPacket.field2199, ServerPacket.field2200};
	}

	@ObfuscatedName("hr")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "1044045879"
	)
	static final boolean method1936(int var0) {
		if (var0 < 0) {
			return false;
		} else {
			int var1 = Client.menuOpcodes[var0];
			if (var1 >= 2000) {
				var1 -= 2000;
			}

			return var1 == 1007;
		}
	}

	@ObfuscatedName("jo")
	@ObfuscatedSignature(
		signature = "(IIIILly;Lhg;B)V",
		garbageValue = "73"
	)
	@Export("drawSpriteOnMinimap")
	static final void drawSpriteOnMinimap(int var0, int var1, int var2, int var3, Sprite var4, SpriteMask var5) {
		if (var4 != null) {
			int var6 = Client.camAngleY & 2047;
			int var7 = var3 * var3 + var2 * var2;
			if (var7 <= 6400) {
				int var8 = Rasterizer3D.Rasterizer3D_sine[var6];
				int var9 = Rasterizer3D.Rasterizer3D_cosine[var6];
				int var10 = var9 * var2 + var3 * var8 >> 16;
				int var11 = var3 * var9 - var8 * var2 >> 16;
				if (var7 > 2500) {
					var4.method6146(var10 + var5.width / 2 - var4.width / 2, var5.height / 2 - var11 - var4.height / 2, var0, var1, var5.width, var5.height, var5.xStarts, var5.xWidths);
				} else {
					var4.drawAt2(var0 + var10 + var5.width / 2 - var4.width / 2, var5.height / 2 + var1 - var11 - var4.height / 2);
				}

			}
		}
	}
}
