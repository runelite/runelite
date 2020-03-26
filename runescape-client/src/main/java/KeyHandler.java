import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bo")
@Implements("KeyHandler")
public final class KeyHandler implements KeyListener, FocusListener {
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lbo;"
	)
	@Export("KeyHandler_instance")
	public static KeyHandler KeyHandler_instance;
	@ObfuscatedName("cg")
	@Export("KeyHandler_pressedKeys")
	public static boolean[] KeyHandler_pressedKeys;
	@ObfuscatedName("cn")
	public static int[] field427;
	@ObfuscatedName("ci")
	@ObfuscatedGetter(
		intValue = 2127581229
	)
	public static int field439;
	@ObfuscatedName("cz")
	@ObfuscatedGetter(
		intValue = -462249185
	)
	public static int field429;
	@ObfuscatedName("cb")
	static char[] field424;
	@ObfuscatedName("cy")
	static int[] field414;
	@ObfuscatedName("ct")
	public static int[] field432;
	@ObfuscatedName("cf")
	@ObfuscatedGetter(
		intValue = 1915642037
	)
	public static int field417;
	@ObfuscatedName("ca")
	@ObfuscatedGetter(
		intValue = 664645249
	)
	public static int field434;
	@ObfuscatedName("cj")
	@ObfuscatedGetter(
		intValue = -1397351623
	)
	public static int field433;
	@ObfuscatedName("cp")
	@ObfuscatedGetter(
		intValue = 1677444807
	)
	public static int field436;
	@ObfuscatedName("ck")
	@ObfuscatedGetter(
		intValue = 301071653
	)
	@Export("KeyHandler_idleCycles")
	public static volatile int KeyHandler_idleCycles;
	@ObfuscatedName("ce")
	@Export("KeyHandler_keyCodes")
	static int[] KeyHandler_keyCodes;
	@ObfuscatedName("gv")
	@Export("regionMapArchiveIds")
	static int[] regionMapArchiveIds;

	static {
		KeyHandler_instance = new KeyHandler();
		KeyHandler_pressedKeys = new boolean[112];
		field427 = new int[128];
		field439 = 0;
		field429 = 0;
		field424 = new char[128];
		field414 = new int[128];
		field432 = new int[128];
		field417 = 0;
		field434 = 0;
		field433 = 0;
		field436 = 0;
		KeyHandler_idleCycles = 0;
		KeyHandler_keyCodes = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, 85, 80, 84, -1, 91, -1, -1, -1, 81, 82, 86, -1, -1, -1, -1, -1, -1, -1, -1, 13, -1, -1, -1, -1, 83, 104, 105, 103, 102, 96, 98, 97, 99, -1, -1, -1, -1, -1, -1, -1, 25, 16, 17, 18, 19, 20, 21, 22, 23, 24, -1, -1, -1, -1, -1, -1, -1, 48, 68, 66, 50, 34, 51, 52, 53, 39, 54, 55, 56, 70, 69, 40, 41, 32, 35, 49, 36, 38, 67, 33, 65, 37, 64, -1, -1, -1, -1, -1, 228, 231, 227, 233, 224, 219, 225, 230, 226, 232, 89, 87, -1, 88, 229, 90, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, -1, -1, -1, 101, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, -1, 87, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
	}

	KeyHandler() {
	}

	public final synchronized void keyReleased(KeyEvent var1) {
		if (KeyHandler_instance != null) {
			int var2 = var1.getKeyCode();
			if (var2 >= 0 && var2 < KeyHandler_keyCodes.length) {
				var2 = KeyHandler_keyCodes[var2] & -129;
			} else {
				var2 = -1;
			}

			if (field429 >= 0 && var2 >= 0) {
				field427[field429] = ~var2;
				field429 = field429 + 1 & 127;
				if (field439 == field429) {
					field429 = -1;
				}
			}
		}

		var1.consume();
	}

	public final void focusGained(FocusEvent var1) {
	}

	public final synchronized void keyPressed(KeyEvent var1) {
		if (KeyHandler_instance != null) {
			int var2 = var1.getKeyCode();
			if (var2 >= 0 && var2 < KeyHandler_keyCodes.length) {
				var2 = KeyHandler_keyCodes[var2];
				if ((var2 & 128) != 0) {
					var2 = -1;
				}
			} else {
				var2 = -1;
			}

			if (field429 >= 0 && var2 >= 0) {
				field427[field429] = var2;
				field429 = field429 + 1 & 127;
				if (field429 == field439) {
					field429 = -1;
				}
			}

			int var3;
			if (var2 >= 0) {
				var3 = field433 + 1 & 127;
				if (var3 != field434) {
					field414[field433] = var2;
					field424[field433] = 0;
					field433 = var3;
				}
			}

			var3 = var1.getModifiers();
			if ((var3 & 10) != 0 || var2 == 85 || var2 == 10) {
				var1.consume();
			}
		}

	}

	public final void keyTyped(KeyEvent var1) {
		if (KeyHandler_instance != null) {
			char var2 = var1.getKeyChar();
			if (var2 != 0 && var2 != '\uffff') {
				boolean var3;
				if (var2 > 0 && var2 < 128 || var2 >= 160 && var2 <= 255) {
					var3 = true;
				} else {
					label59: {
						if (var2 != 0) {
							char[] var7 = class297.cp1252AsciiExtension;

							for (int var5 = 0; var5 < var7.length; ++var5) {
								char var6 = var7[var5];
								if (var6 == var2) {
									var3 = true;
									break label59;
								}
							}
						}

						var3 = false;
					}
				}

				if (var3) {
					int var4 = field433 + 1 & 127;
					if (var4 != field434) {
						field414[field433] = -1;
						field424[field433] = var2;
						field433 = var4;
					}
				}
			}
		}

		var1.consume();
	}

	public final synchronized void focusLost(FocusEvent var1) {
		if (KeyHandler_instance != null) {
			field429 = -1;
		}

	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(B)[Lgv;",
		garbageValue = "34"
	)
	@Export("ServerPacket_values")
	public static ServerPacket[] ServerPacket_values() {
		return new ServerPacket[]{ServerPacket.field2131, ServerPacket.field2119, ServerPacket.field2149, ServerPacket.field2121, ServerPacket.field2122, ServerPacket.field2123, ServerPacket.field2124, ServerPacket.field2169, ServerPacket.field2126, ServerPacket.field2127, ServerPacket.field2197, ServerPacket.field2186, ServerPacket.field2128, ServerPacket.field2132, ServerPacket.field2125, ServerPacket.field2133, ServerPacket.field2134, ServerPacket.field2139, ServerPacket.field2204, ServerPacket.field2137, ServerPacket.field2172, ServerPacket.field2163, ServerPacket.field2140, ServerPacket.field2118, ServerPacket.field2142, ServerPacket.field2143, ServerPacket.field2144, ServerPacket.field2145, ServerPacket.field2151, ServerPacket.field2147, ServerPacket.field2148, ServerPacket.field2136, ServerPacket.field2150, ServerPacket.field2141, ServerPacket.field2129, ServerPacket.field2153, ServerPacket.field2154, ServerPacket.field2155, ServerPacket.field2159, ServerPacket.field2157, ServerPacket.field2158, ServerPacket.field2178, ServerPacket.field2160, ServerPacket.field2161, ServerPacket.field2192, ServerPacket.field2168, ServerPacket.field2164, ServerPacket.field2165, ServerPacket.field2166, ServerPacket.field2167, ServerPacket.field2203, ServerPacket.field2162, ServerPacket.field2170, ServerPacket.field2171, ServerPacket.field2138, ServerPacket.field2173, ServerPacket.field2179, ServerPacket.field2175, ServerPacket.field2176, ServerPacket.field2194, ServerPacket.field2146, ServerPacket.field2152, ServerPacket.field2180, ServerPacket.field2181, ServerPacket.field2182, ServerPacket.field2183, ServerPacket.field2184, ServerPacket.field2120, ServerPacket.field2185, ServerPacket.field2187, ServerPacket.field2188, ServerPacket.field2177, ServerPacket.field2190, ServerPacket.field2191, ServerPacket.field2189, ServerPacket.field2193, ServerPacket.field2130, ServerPacket.field2195, ServerPacket.field2196, ServerPacket.field2174, ServerPacket.field2198, ServerPacket.field2199, ServerPacket.field2200, ServerPacket.field2201, ServerPacket.field2202, ServerPacket.field2156};
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Liy;I)V",
		garbageValue = "-689678627"
	)
	public static void method940(AbstractArchive var0) {
		StructDefinition.StructDefinition_archive = var0;
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Ljava/lang/String;ZI)Lmb;",
		garbageValue = "1960314155"
	)
	@Export("getPreferencesFile")
	public static AccessFile getPreferencesFile(String var0, String var1, boolean var2) {
		File var3 = new File(class92.cacheDir, "preferences" + var0 + ".dat");
		if (var3.exists()) {
			try {
				AccessFile var10 = new AccessFile(var3, "rw", 10000L);
				return var10;
			} catch (IOException var9) {
			}
		}

		String var4 = "";
		if (class8.cacheGamebuild == 33) {
			var4 = "_rc";
		} else if (class8.cacheGamebuild == 34) {
			var4 = "_wip";
		}

		File var5 = new File(AbstractWorldMapData.userHomeDirectory, "jagex_" + var1 + "_preferences" + var0 + var4 + ".dat");
		AccessFile var6;
		if (!var2 && var5.exists()) {
			try {
				var6 = new AccessFile(var5, "rw", 10000L);
				return var6;
			} catch (IOException var8) {
			}
		}

		try {
			var6 = new AccessFile(var3, "rw", 10000L);
			return var6;
		} catch (IOException var7) {
			throw new RuntimeException();
		}
	}

	@ObfuscatedName("gr")
	@ObfuscatedSignature(
		signature = "(Lcw;IB)V",
		garbageValue = "3"
	)
	static final void method939(Actor var0, int var1) {
		WorldMapSection0.worldToScreen(var0.x, var0.y, var1);
	}
}
