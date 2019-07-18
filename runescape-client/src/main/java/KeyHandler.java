import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ai")
@Implements("KeyHandler")
public final class KeyHandler implements KeyListener, FocusListener {
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lai;"
	)
	@Export("KeyHandler_instance")
	public static KeyHandler KeyHandler_instance;
	@ObfuscatedName("cp")
	@Export("KeyHandler_pressedKeys")
	public static boolean[] KeyHandler_pressedKeys;
	@ObfuscatedName("cw")
	public static int[] field391;
	@ObfuscatedName("ca")
	@ObfuscatedGetter(
		intValue = 1600715529
	)
	public static int field388;
	@ObfuscatedName("cb")
	@ObfuscatedGetter(
		intValue = -957146255
	)
	public static int field398;
	@ObfuscatedName("cx")
	static char[] field399;
	@ObfuscatedName("cu")
	static int[] field400;
	@ObfuscatedName("cs")
	public static int[] field401;
	@ObfuscatedName("cg")
	@ObfuscatedGetter(
		intValue = 1304098679
	)
	public static int field386;
	@ObfuscatedName("cv")
	@ObfuscatedGetter(
		intValue = -1704948479
	)
	public static int field396;
	@ObfuscatedName("ce")
	@ObfuscatedGetter(
		intValue = 1813513045
	)
	public static int field404;
	@ObfuscatedName("cz")
	@ObfuscatedGetter(
		intValue = 1799937551
	)
	public static int field385;
	@ObfuscatedName("cm")
	@ObfuscatedGetter(
		intValue = -1118160033
	)
	@Export("KeyHandler_idleCycles")
	public static volatile int KeyHandler_idleCycles;
	@ObfuscatedName("ck")
	@Export("KeyHandler_keyCodes")
	static int[] KeyHandler_keyCodes;

	static {
		KeyHandler_instance = new KeyHandler();
		KeyHandler_pressedKeys = new boolean[112];
		field391 = new int[128];
		field388 = 0;
		field398 = 0;
		field399 = new char[128];
		field400 = new int[128];
		field401 = new int[128];
		field386 = 0;
		field396 = 0;
		field404 = 0;
		field385 = 0;
		KeyHandler_idleCycles = 0;
		KeyHandler_keyCodes = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, 85, 80, 84, -1, 91, -1, -1, -1, 81, 82, 86, -1, -1, -1, -1, -1, -1, -1, -1, 13, -1, -1, -1, -1, 83, 104, 105, 103, 102, 96, 98, 97, 99, -1, -1, -1, -1, -1, -1, -1, 25, 16, 17, 18, 19, 20, 21, 22, 23, 24, -1, -1, -1, -1, -1, -1, -1, 48, 68, 66, 50, 34, 51, 52, 53, 39, 54, 55, 56, 70, 69, 40, 41, 32, 35, 49, 36, 38, 67, 33, 65, 37, 64, -1, -1, -1, -1, -1, 228, 231, 227, 233, 224, 219, 225, 230, 226, 232, 89, 87, -1, 88, 229, 90, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, -1, -1, -1, 101, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
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

			if (field398 >= 0 && var2 >= 0) {
				field391[field398] = var2;
				field398 = field398 + 1 & 127;
				if (field398 == field388) {
					field398 = -1;
				}
			}

			int var3;
			if (var2 >= 0) {
				var3 = field404 + 1 & 127;
				if (var3 != field396) {
					field400[field404] = var2;
					field399[field404] = 0;
					field404 = var3;
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

			if (field398 >= 0 && var2 >= 0) {
				field391[field398] = ~var2;
				field398 = field398 + 1 & 127;
				if (field388 == field398) {
					field398 = -1;
				}
			}
		}

		var1.consume();
	}

	public final void focusGained(FocusEvent var1) {
	}

	public final synchronized void focusLost(FocusEvent var1) {
		if (KeyHandler_instance != null) {
			field398 = -1;
		}

	}

	public final void keyTyped(KeyEvent var1) {
		if (KeyHandler_instance != null) {
			char var2 = var1.getKeyChar();
			if (var2 != 0 && var2 != '\uffff' && VarpDefinition.method4366(var2)) {
				int var3 = field404 + 1 & 127;
				if (var3 != field396) {
					field400[field404] = -1;
					field399[field404] = var2;
					field404 = var3;
				}
			}
		}

		var1.consume();
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Lhp;I)V",
		garbageValue = "-939658474"
	)
	public static void method794(AbstractArchive var0) {
		ParamDefinition.ParamDefinition_archive = var0;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "337917094"
	)
	static void method787() {
		Tiles.field504 = null;
		Tiles.field505 = null;
		Tiles.field506 = null;
		class268.field3561 = null;
		FaceNormal.field1887 = null;
		class32.field282 = null;
		Tiles.field515 = null;
		ServerBuild.field3103 = null;
		Tiles.field508 = null;
		Tiles.field507 = null;
		DynamicObject.field1301 = null;
		Fonts.field3689 = null;
	}

	@ObfuscatedName("fa")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-2003037366"
	)
	static final void method801() {
		if (GrandExchangeEvent.field49) {
			if (DevicePcmPlayerProvider.clanChat != null) {
				DevicePcmPlayerProvider.clanChat.sort();
			}

			for (int var0 = 0; var0 < Players.Players_count; ++var0) {
				Player var1 = Client.players[Players.Players_indices[var0]];
				var1.clearIsInClanChat();
			}

			GrandExchangeEvent.field49 = false;
		}

	}
}
