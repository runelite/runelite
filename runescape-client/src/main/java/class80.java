import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cj")
public class class80 {
	@ObfuscatedName("nd")
	@ObfuscatedGetter(
		intValue = -1004570869
	)
	@Export("widgetDragDuration")
	static int widgetDragDuration;
	@ObfuscatedName("ql")
	@ObfuscatedSignature(
		signature = "Ldn;"
	)
	@Export("pcmPlayer0")
	static PcmPlayer pcmPlayer0;
	@ObfuscatedName("k")
	static final BigInteger field1140;
	@ObfuscatedName("l")
	static final BigInteger field1141;
	@ObfuscatedName("ge")
	@Export("regionMapArchives")
	static byte[][] regionMapArchives;

	static {
		field1140 = new BigInteger("80782894952180643741752986186714059433953886149239752893425047584684715842049");
		field1141 = new BigInteger("7237300117305667488707183861728052766358166655052137727439795191253340127955075499635575104901523446809299097934591732635674173519120047404024393881551683");
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "([BILjava/lang/CharSequence;B)I",
		garbageValue = "0"
	)
	public static int method1979(byte[] var0, int var1, CharSequence var2) {
		int var3 = var2.length();
		int var4 = var1;

		for (int var5 = 0; var5 < var3; ++var5) {
			char var6 = var2.charAt(var5);
			if (var6 <= 127) {
				var0[var4++] = (byte)var6;
			} else if (var6 <= 2047) {
				var0[var4++] = (byte)(192 | var6 >> 6);
				var0[var4++] = (byte)(128 | var6 & '?');
			} else {
				var0[var4++] = (byte)(224 | var6 >> '\f');
				var0[var4++] = (byte)(128 | var6 >> 6 & 63);
				var0[var4++] = (byte)(128 | var6 & '?');
			}
		}

		return var4 - var1;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(II)Lhj;",
		garbageValue = "-1951654524"
	)
	@Export("getWidget")
	public static Widget getWidget(int var0) {
		int var1 = var0 >> 16;
		int var2 = var0 & 65535;
		if (Widget.Widget_interfaceComponents[var1] == null || Widget.Widget_interfaceComponents[var1][var2] == null) {
			boolean var3 = class162.loadInterface(var1);
			if (!var3) {
				return null;
			}
		}

		return Widget.Widget_interfaceComponents[var1][var2];
	}

	@ObfuscatedName("fy")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-817904551"
	)
	static final void method1982() {
		int var0;
		int var1;
		int var2;
		int var3;
		int var4;
		int var5;
		if (Client.oculusOrbState == 0) {
			var0 = Client.localPlayer.x;
			var1 = Client.localPlayer.y;
			if (MouseHandler.oculusOrbFocalPointX - var0 < -500 || MouseHandler.oculusOrbFocalPointX - var0 > 500 || WorldMapArea.oculusOrbFocalPointY - var1 < -500 || WorldMapArea.oculusOrbFocalPointY - var1 > 500) {
				MouseHandler.oculusOrbFocalPointX = var0;
				WorldMapArea.oculusOrbFocalPointY = var1;
			}

			if (var0 != MouseHandler.oculusOrbFocalPointX) {
				MouseHandler.oculusOrbFocalPointX += (var0 - MouseHandler.oculusOrbFocalPointX) / 16;
			}

			if (var1 != WorldMapArea.oculusOrbFocalPointY) {
				WorldMapArea.oculusOrbFocalPointY += (var1 - WorldMapArea.oculusOrbFocalPointY) / 16;
			}

			var2 = MouseHandler.oculusOrbFocalPointX >> 7;
			var3 = WorldMapArea.oculusOrbFocalPointY >> 7;
			var4 = ScriptEvent.getTileHeight(MouseHandler.oculusOrbFocalPointX, WorldMapArea.oculusOrbFocalPointY, class42.plane);
			var5 = 0;
			int var6;
			if (var2 > 3 && var3 > 3 && var2 < 100 && var3 < 100) {
				for (var6 = var2 - 4; var6 <= var2 + 4; ++var6) {
					for (int var7 = var3 - 4; var7 <= var3 + 4; ++var7) {
						int var8 = class42.plane;
						if (var8 < 3 && (Tiles.Tiles_renderFlags[1][var6][var7] & 2) == 2) {
							++var8;
						}

						int var9 = var4 - Tiles.Tiles_heights[var8][var6][var7];
						if (var9 > var5) {
							var5 = var9;
						}
					}
				}
			}

			var6 = var5 * 192;
			if (var6 > 98048) {
				var6 = 98048;
			}

			if (var6 < 32768) {
				var6 = 32768;
			}

			if (var6 > Client.field739) {
				Client.field739 += (var6 - Client.field739) / 24;
			} else if (var6 < Client.field739) {
				Client.field739 += (var6 - Client.field739) / 80;
			}

			Client.field729 = ScriptEvent.getTileHeight(Client.localPlayer.x, Client.localPlayer.y, class42.plane) - Client.camFollowHeight;
		} else if (Client.oculusOrbState == 1) {
			Widget.method4090();
			short var10 = -1;
			if (KeyHandler.KeyHandler_pressedKeys[33]) {
				var10 = 0;
			} else if (KeyHandler.KeyHandler_pressedKeys[49]) {
				var10 = 1024;
			}

			if (KeyHandler.KeyHandler_pressedKeys[48]) {
				if (var10 == 0) {
					var10 = 1792;
				} else if (var10 == 1024) {
					var10 = 1280;
				} else {
					var10 = 1536;
				}
			} else if (KeyHandler.KeyHandler_pressedKeys[50]) {
				if (var10 == 0) {
					var10 = 256;
				} else if (var10 == 1024) {
					var10 = 768;
				} else {
					var10 = 512;
				}
			}

			byte var11 = 0;
			if (KeyHandler.KeyHandler_pressedKeys[35]) {
				var11 = -1;
			} else if (KeyHandler.KeyHandler_pressedKeys[51]) {
				var11 = 1;
			}

			var2 = 0;
			if (var10 >= 0 || var11 != 0) {
				var2 = KeyHandler.KeyHandler_pressedKeys[81] ? Client.oculusOrbSlowedSpeed : Client.oculusOrbNormalSpeed;
				var2 *= 16;
				Client.field731 = var10;
				Client.field871 = var11;
			}

			if (Client.field928 < var2) {
				Client.field928 += var2 / 8;
				if (Client.field928 > var2) {
					Client.field928 = var2;
				}
			} else if (Client.field928 > var2) {
				Client.field928 = Client.field928 * 9 / 10;
			}

			if (Client.field928 > 0) {
				var3 = Client.field928 / 16;
				if (Client.field731 >= 0) {
					var0 = Client.field731 - Interpreter.cameraYaw & 2047;
					var4 = Rasterizer3D.Rasterizer3D_sine[var0];
					var5 = Rasterizer3D.Rasterizer3D_cosine[var0];
					MouseHandler.oculusOrbFocalPointX += var3 * var4 / 65536;
					WorldMapArea.oculusOrbFocalPointY += var5 * var3 / 65536;
				}

				if (Client.field871 != 0) {
					Client.field729 += var3 * Client.field871;
					if (Client.field729 > 0) {
						Client.field729 = 0;
					}
				}
			} else {
				Client.field731 = -1;
				Client.field871 = -1;
			}

			if (KeyHandler.KeyHandler_pressedKeys[13]) {
				DevicePcmPlayerProvider.method805();
			}
		}

		if (MouseHandler.MouseHandler_currentButton == 4 && DevicePcmPlayerProvider.mouseCam) {
			var0 = MouseHandler.MouseHandler_y - Client.mouseCamClickedY;
			Client.camAngleDX = var0 * 2;
			Client.mouseCamClickedY = var0 != -1 && var0 != 1 ? (MouseHandler.MouseHandler_y + Client.mouseCamClickedY) / 2 : MouseHandler.MouseHandler_y;
			var1 = Client.mouseCamClickedX - MouseHandler.MouseHandler_x;
			Client.camAngleDY = var1 * 2;
			Client.mouseCamClickedX = var1 != -1 && var1 != 1 ? (Client.mouseCamClickedX + MouseHandler.MouseHandler_x) / 2 : MouseHandler.MouseHandler_x;
		} else {
			if (KeyHandler.KeyHandler_pressedKeys[96]) {
				Client.camAngleDY += (-24 - Client.camAngleDY) / 2;
			} else if (KeyHandler.KeyHandler_pressedKeys[97]) {
				Client.camAngleDY += (24 - Client.camAngleDY) / 2;
			} else {
				Client.camAngleDY /= 2;
			}

			if (KeyHandler.KeyHandler_pressedKeys[98]) {
				Client.camAngleDX += (12 - Client.camAngleDX) / 2;
			} else if (KeyHandler.KeyHandler_pressedKeys[99]) {
				Client.camAngleDX += (-12 - Client.camAngleDX) / 2;
			} else {
				Client.camAngleDX /= 2;
			}

			Client.mouseCamClickedY = MouseHandler.MouseHandler_y;
			Client.mouseCamClickedX = MouseHandler.MouseHandler_x;
		}

		Client.camAngleY = Client.camAngleDY / 2 + Client.camAngleY & 2047;
		Client.camAngleX += Client.camAngleDX / 2;
		if (Client.camAngleX < 128) {
			Client.camAngleX = 128;
		}

		if (Client.camAngleX > 383) {
			Client.camAngleX = 383;
		}

	}
}
