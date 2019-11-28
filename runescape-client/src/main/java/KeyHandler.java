import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("an")
@Implements("KeyHandler")
public final class KeyHandler implements KeyListener, FocusListener {
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lan;"
	)
	@Export("KeyHandler_instance")
	public static KeyHandler KeyHandler_instance;
	@ObfuscatedName("cb")
	@Export("KeyHandler_pressedKeys")
	public static boolean[] KeyHandler_pressedKeys;
	@ObfuscatedName("cj")
	public static int[] field394;
	@ObfuscatedName("cq")
	@ObfuscatedGetter(
		intValue = -1692685617
	)
	public static int field393;
	@ObfuscatedName("ci")
	@ObfuscatedGetter(
		intValue = 1179821355
	)
	public static int field397;
	@ObfuscatedName("cu")
	static char[] field395;
	@ObfuscatedName("cs")
	static int[] field396;
	@ObfuscatedName("cc")
	public static int[] field378;
	@ObfuscatedName("cp")
	@ObfuscatedGetter(
		intValue = -157249247
	)
	public static int field398;
	@ObfuscatedName("ce")
	@ObfuscatedGetter(
		intValue = -1356974525
	)
	public static int field399;
	@ObfuscatedName("ca")
	@ObfuscatedGetter(
		intValue = -632301517
	)
	public static int field400;
	@ObfuscatedName("cf")
	@ObfuscatedGetter(
		intValue = 731449573
	)
	public static int field384;
	@ObfuscatedName("cx")
	@ObfuscatedGetter(
		intValue = -1978604411
	)
	@Export("KeyHandler_idleCycles")
	public static volatile int KeyHandler_idleCycles;
	@ObfuscatedName("cz")
	@Export("KeyHandler_keyCodes")
	static int[] KeyHandler_keyCodes;
	@ObfuscatedName("dc")
	@ObfuscatedSignature(
		signature = "Lfo;"
	)
	@Export("js5SocketTask")
	static Task js5SocketTask;
	@ObfuscatedName("gi")
	@ObfuscatedSignature(
		signature = "[Lln;"
	)
	@Export("crossSprites")
	static Sprite[] crossSprites;

	static {
		KeyHandler_instance = new KeyHandler();
		KeyHandler_pressedKeys = new boolean[112];
		field394 = new int[128];
		field393 = 0;
		field397 = 0;
		field395 = new char[128];
		field396 = new int[128];
		field378 = new int[128];
		field398 = 0;
		field399 = 0;
		field400 = 0;
		field384 = 0;
		KeyHandler_idleCycles = 0;
		KeyHandler_keyCodes = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, 85, 80, 84, -1, 91, -1, -1, -1, 81, 82, 86, -1, -1, -1, -1, -1, -1, -1, -1, 13, -1, -1, -1, -1, 83, 104, 105, 103, 102, 96, 98, 97, 99, -1, -1, -1, -1, -1, -1, -1, 25, 16, 17, 18, 19, 20, 21, 22, 23, 24, -1, -1, -1, -1, -1, -1, -1, 48, 68, 66, 50, 34, 51, 52, 53, 39, 54, 55, 56, 70, 69, 40, 41, 32, 35, 49, 36, 38, 67, 33, 65, 37, 64, -1, -1, -1, -1, -1, 228, 231, 227, 233, 224, 219, 225, 230, 226, 232, 89, 87, -1, 88, 229, 90, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, -1, -1, -1, 101, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, -1, 87, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
	}

	KeyHandler() {
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

			if (field397 >= 0 && var2 >= 0) {
				field394[field397] = var2;
				field397 = field397 + 1 & 127;
				if (field397 == field393) {
					field397 = -1;
				}
			}

			int var3;
			if (var2 >= 0) {
				var3 = field400 + 1 & 127;
				if (var3 != field399) {
					field396[field400] = var2;
					field395[field400] = 0;
					field400 = var3;
				}
			}

			var3 = var1.getModifiers();
			if ((var3 & 10) != 0 || var2 == 85 || var2 == 10) {
				var1.consume();
			}
		}

	}

	public final synchronized void keyReleased(KeyEvent var1) {
		if (KeyHandler_instance != null) {
			int var2 = var1.getKeyCode();
			if (var2 >= 0 && var2 < KeyHandler_keyCodes.length) {
				var2 = KeyHandler_keyCodes[var2] & -129;
			} else {
				var2 = -1;
			}

			if (field397 >= 0 && var2 >= 0) {
				field394[field397] = ~var2;
				field397 = field397 + 1 & 127;
				if (field393 == field397) {
					field397 = -1;
				}
			}
		}

		var1.consume();
	}

	public final void keyTyped(KeyEvent var1) {
		if (KeyHandler_instance != null) {
			char var2 = var1.getKeyChar();
			if (var2 != 0 && var2 != '\uffff') {
				boolean var3;
				if (var2 > 0 && var2 < 128 || var2 >= 160 && var2 <= 255) {
					var3 = true;
				} else {
					label63: {
						if (var2 != 0) {
							char[] var7 = class287.cp1252AsciiExtension;

							for (int var5 = 0; var5 < var7.length; ++var5) {
								char var6 = var7[var5];
								if (var6 == var2) {
									var3 = true;
									break label63;
								}
							}
						}

						var3 = false;
					}
				}

				if (var3) {
					int var4 = field400 + 1 & 127;
					if (var4 != field399) {
						field396[field400] = -1;
						field395[field400] = var2;
						field400 = var4;
					}
				}
			}
		}

		var1.consume();
	}

	public final synchronized void focusLost(FocusEvent var1) {
		if (KeyHandler_instance != null) {
			field397 = -1;
		}

	}

	public final void focusGained(FocusEvent var1) {
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "-1842902018"
	)
	public static int method843(int var0, int var1) {
		int var2;
		for (var2 = 0; var1 > 0; --var1) {
			var2 = var2 << 1 | var0 & 1;
			var0 >>>= 1;
		}

		return var2;
	}

	@ObfuscatedName("gi")
	@ObfuscatedSignature(
		signature = "(IIIII)V",
		garbageValue = "1035079634"
	)
	static final void method837(int var0, int var1, int var2, int var3) {
		class2.method31();
	}
}
