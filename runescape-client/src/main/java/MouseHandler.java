import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bi")
@Implements("MouseHandler")
public class MouseHandler implements MouseListener, MouseMotionListener, FocusListener {
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lbi;"
	)
	@Export("MouseHandler_instance")
	public static MouseHandler MouseHandler_instance;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -1010010923
	)
	@Export("MouseHandler_x")
	public static int MouseHandler_x;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 224194115
	)
	@Export("MouseHandler_idleCycles")
	public static volatile int MouseHandler_idleCycles;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = 1710921911
	)
	@Export("MouseHandler_currentButton0")
	public static volatile int MouseHandler_currentButton0;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 1256133149
	)
	@Export("MouseHandler_x0")
	public static volatile int MouseHandler_x0;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 1661434067
	)
	@Export("MouseHandler_y0")
	public static volatile int MouseHandler_y0;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		longValue = -8614064843857647631L
	)
	@Export("MouseHandler_millis0")
	public static volatile long MouseHandler_millis0;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 1270652981
	)
	@Export("MouseHandler_currentButton")
	public static int MouseHandler_currentButton;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -1776792987
	)
	@Export("MouseHandler_y")
	public static int MouseHandler_y;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		longValue = 5241023896637855779L
	)
	@Export("MouseHandler_millis")
	public static long MouseHandler_millis;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = -1163235529
	)
	@Export("MouseHandler_lastButton0")
	public static volatile int MouseHandler_lastButton0;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -1839013683
	)
	@Export("MouseHandler_lastPressedX0")
	public static volatile int MouseHandler_lastPressedX0;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = -62123151
	)
	@Export("MouseHandler_lastPressedY0")
	public static volatile int MouseHandler_lastPressedY0;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		longValue = -4691083224527858071L
	)
	@Export("MouseHandler_lastPressedTimeMillis0")
	public static volatile long MouseHandler_lastPressedTimeMillis0;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = 1647189949
	)
	@Export("MouseHandler_lastButton")
	public static int MouseHandler_lastButton;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -836499887
	)
	@Export("MouseHandler_lastPressedX")
	public static int MouseHandler_lastPressedX;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 201376633
	)
	@Export("MouseHandler_lastPressedY")
	public static int MouseHandler_lastPressedY;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		longValue = -687699044042245685L
	)
	@Export("MouseHandler_lastPressedTimeMillis")
	public static long MouseHandler_lastPressedTimeMillis;
	@ObfuscatedName("ht")
	@ObfuscatedGetter(
		intValue = -400570657
	)
	@Export("oculusOrbFocalPointX")
	static int oculusOrbFocalPointX;

	static {
		MouseHandler_instance = new MouseHandler();
		MouseHandler_idleCycles = 0;
		MouseHandler_currentButton0 = 0;
		MouseHandler_x0 = -1;
		MouseHandler_y0 = -1;
		MouseHandler_millis0 = -1L;
		MouseHandler_currentButton = 0;
		MouseHandler_x = 0;
		MouseHandler_y = 0;
		MouseHandler_millis = 0L;
		MouseHandler_lastButton0 = 0;
		MouseHandler_lastPressedX0 = 0;
		MouseHandler_lastPressedY0 = 0;
		MouseHandler_lastPressedTimeMillis0 = 0L;
		MouseHandler_lastButton = 0;
		MouseHandler_lastPressedX = 0;
		MouseHandler_lastPressedY = 0;
		MouseHandler_lastPressedTimeMillis = 0L;
	}

	MouseHandler() {
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(Ljava/awt/event/MouseEvent;I)I",
		garbageValue = "-1900631244"
	)
	@Export("getButton")
	final int getButton(MouseEvent var1) {
		int var2 = var1.getButton();
		if (!var1.isAltDown() && var2 != 2) {
			return !var1.isMetaDown() && var2 != 3 ? 1 : 2;
		} else {
			return 4;
		}
	}

	public final synchronized void mouseMoved(MouseEvent var1) {
		if (MouseHandler_instance != null) {
			MouseHandler_idleCycles = 0;
			MouseHandler_x0 = var1.getX();
			MouseHandler_y0 = var1.getY();
			MouseHandler_millis0 = var1.getWhen();
		}

	}

	public final synchronized void mousePressed(MouseEvent var1) {
		if (MouseHandler_instance != null) {
			MouseHandler_idleCycles = 0;
			MouseHandler_lastPressedX0 = var1.getX();
			MouseHandler_lastPressedY0 = var1.getY();
			MouseHandler_lastPressedTimeMillis0 = DirectByteArrayCopier.currentTimeMs();
			MouseHandler_lastButton0 = this.getButton(var1);
			if (MouseHandler_lastButton0 != 0) {
				MouseHandler_currentButton0 = MouseHandler_lastButton0;
			}
		}

		if (var1.isPopupTrigger()) {
			var1.consume();
		}

	}

	public final synchronized void mouseReleased(MouseEvent var1) {
		if (MouseHandler_instance != null) {
			MouseHandler_idleCycles = 0;
			MouseHandler_currentButton0 = 0;
		}

		if (var1.isPopupTrigger()) {
			var1.consume();
		}

	}

	public final void mouseClicked(MouseEvent var1) {
		if (var1.isPopupTrigger()) {
			var1.consume();
		}

	}

	public final synchronized void mouseDragged(MouseEvent var1) {
		this.mouseMoved(var1);
	}

	public final synchronized void focusLost(FocusEvent var1) {
		if (MouseHandler_instance != null) {
			MouseHandler_currentButton0 = 0;
		}

	}

	public final synchronized void mouseExited(MouseEvent var1) {
		if (MouseHandler_instance != null) {
			MouseHandler_idleCycles = 0;
			MouseHandler_x0 = -1;
			MouseHandler_y0 = -1;
			MouseHandler_millis0 = var1.getWhen();
		}

	}

	public final void focusGained(FocusEvent var1) {
	}

	public final synchronized void mouseEntered(MouseEvent var1) {
		this.mouseMoved(var1);
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "-102731253"
	)
	public static int method1009(int var0, int var1) {
		int var2;
		for (var2 = 1; var1 > 1; var1 >>= 1) {
			if ((var1 & 1) != 0) {
				var2 = var0 * var2;
			}

			var0 *= var0;
		}

		if (var1 == 1) {
			return var0 * var2;
		} else {
			return var2;
		}
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(Lkx;I)V",
		garbageValue = "-685707928"
	)
	static final void method1037(PacketBuffer var0) {
		int var1 = 0;
		var0.importIndex();

		byte[] var10000;
		int var2;
		int var3;
		int var4;
		for (var2 = 0; var2 < Players.Players_count; ++var2) {
			var3 = Players.Players_indices[var2];
			if ((Players.field1252[var3] & 1) == 0) {
				if (var1 > 0) {
					--var1;
					var10000 = Players.field1252;
					var10000[var3] = (byte)(var10000[var3] | 2);
				} else {
					var4 = var0.readBits(1);
					if (var4 == 0) {
						var1 = World.method1686(var0);
						var10000 = Players.field1252;
						var10000[var3] = (byte)(var10000[var3] | 2);
					} else {
						WorldMapIcon_0.method210(var0, var3);
					}
				}
			}
		}

		var0.exportIndex();
		if (var1 != 0) {
			throw new RuntimeException();
		} else {
			var0.importIndex();

			for (var2 = 0; var2 < Players.Players_count; ++var2) {
				var3 = Players.Players_indices[var2];
				if ((Players.field1252[var3] & 1) != 0) {
					if (var1 > 0) {
						--var1;
						var10000 = Players.field1252;
						var10000[var3] = (byte)(var10000[var3] | 2);
					} else {
						var4 = var0.readBits(1);
						if (var4 == 0) {
							var1 = World.method1686(var0);
							var10000 = Players.field1252;
							var10000[var3] = (byte)(var10000[var3] | 2);
						} else {
							WorldMapIcon_0.method210(var0, var3);
						}
					}
				}
			}

			var0.exportIndex();
			if (var1 != 0) {
				throw new RuntimeException();
			} else {
				var0.importIndex();

				for (var2 = 0; var2 < Players.Players_emptyIdxCount; ++var2) {
					var3 = Players.Players_emptyIndices[var2];
					if ((Players.field1252[var3] & 1) != 0) {
						if (var1 > 0) {
							--var1;
							var10000 = Players.field1252;
							var10000[var3] = (byte)(var10000[var3] | 2);
						} else {
							var4 = var0.readBits(1);
							if (var4 == 0) {
								var1 = World.method1686(var0);
								var10000 = Players.field1252;
								var10000[var3] = (byte)(var10000[var3] | 2);
							} else if (class226.updateExternalPlayer(var0, var3)) {
								var10000 = Players.field1252;
								var10000[var3] = (byte)(var10000[var3] | 2);
							}
						}
					}
				}

				var0.exportIndex();
				if (var1 != 0) {
					throw new RuntimeException();
				} else {
					var0.importIndex();

					for (var2 = 0; var2 < Players.Players_emptyIdxCount; ++var2) {
						var3 = Players.Players_emptyIndices[var2];
						if ((Players.field1252[var3] & 1) == 0) {
							if (var1 > 0) {
								--var1;
								var10000 = Players.field1252;
								var10000[var3] = (byte)(var10000[var3] | 2);
							} else {
								var4 = var0.readBits(1);
								if (var4 == 0) {
									var1 = World.method1686(var0);
									var10000 = Players.field1252;
									var10000[var3] = (byte)(var10000[var3] | 2);
								} else if (class226.updateExternalPlayer(var0, var3)) {
									var10000 = Players.field1252;
									var10000[var3] = (byte)(var10000[var3] | 2);
								}
							}
						}
					}

					var0.exportIndex();
					if (var1 != 0) {
						throw new RuntimeException();
					} else {
						Players.Players_count = 0;
						Players.Players_emptyIdxCount = 0;

						for (var2 = 1; var2 < 2048; ++var2) {
							var10000 = Players.field1252;
							var10000[var2] = (byte)(var10000[var2] >> 1);
							Player var5 = Client.players[var2];
							if (var5 != null) {
								Players.Players_indices[++Players.Players_count - 1] = var2;
							} else {
								Players.Players_emptyIndices[++Players.Players_emptyIdxCount - 1] = var2;
							}
						}

					}
				}
			}
		}
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-37"
	)
	static void method1039() {
		Login.loginIndex = 24;
		class268.setLoginResponseString("The game servers are currently being updated.", "Please wait a few minutes and try again.", "");
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "1793626495"
	)
	static final int method1021(int var0, int var1) {
		int var2 = var0 + var1 * 57;
		var2 ^= var2 << 13;
		int var3 = (var2 * var2 * 15731 + 789221) * var2 + 1376312589 & Integer.MAX_VALUE;
		return var3 >> 19 & 255;
	}
}
