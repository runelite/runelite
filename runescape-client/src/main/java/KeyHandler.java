import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aj")
@Implements("KeyHandler")
public final class KeyHandler implements KeyListener, FocusListener {
	@ObfuscatedName("sz")
	@ObfuscatedGetter(
		intValue = 1848557625
	)
	@Export("foundItemIdCount")
	static int foundItemIdCount;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Laj;"
	)
	@Export("KeyHandler_instance")
	public static KeyHandler KeyHandler_instance;
	@ObfuscatedName("ca")
	@Export("KeyHandler_pressedKeys")
	public static boolean[] KeyHandler_pressedKeys;
	@ObfuscatedName("ck")
	public static int[] field371;
	@ObfuscatedName("ce")
	@ObfuscatedGetter(
		intValue = 2031779971
	)
	public static int field372;
	@ObfuscatedName("cu")
	@ObfuscatedGetter(
		intValue = 1093649123
	)
	public static int field373;
	@ObfuscatedName("cg")
	static char[] field385;
	@ObfuscatedName("ct")
	static int[] field375;
	@ObfuscatedName("cr")
	public static int[] field376;
	@ObfuscatedName("cy")
	@ObfuscatedGetter(
		intValue = -805709065
	)
	public static int field377;
	@ObfuscatedName("cz")
	@ObfuscatedGetter(
		intValue = -924316299
	)
	public static int field378;
	@ObfuscatedName("cm")
	@ObfuscatedGetter(
		intValue = -1721204763
	)
	public static int field386;
	@ObfuscatedName("cl")
	@ObfuscatedGetter(
		intValue = 485156941
	)
	public static int field380;
	@ObfuscatedName("ci")
	@ObfuscatedGetter(
		intValue = 1979458191
	)
	@Export("KeyHandler_idleCycles")
	public static volatile int KeyHandler_idleCycles;
	@ObfuscatedName("cc")
	@Export("KeyHandler_keyCodes")
	static int[] KeyHandler_keyCodes;
	@ObfuscatedName("kz")
	@ObfuscatedGetter(
		intValue = -1228958525
	)
	@Export("menuWidth")
	static int menuWidth;
	@ObfuscatedName("lq")
	@ObfuscatedGetter(
		intValue = -1751180227
	)
	@Export("selectedItemSlot")
	static int selectedItemSlot;

	static {
		KeyHandler_instance = new KeyHandler();
		KeyHandler_pressedKeys = new boolean[112];
		field371 = new int[128];
		field372 = 0;
		field373 = 0;
		field385 = new char[128];
		field375 = new int[128];
		field376 = new int[128];
		field377 = 0;
		field378 = 0;
		field386 = 0;
		field380 = 0;
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

			if (field373 >= 0 && var2 >= 0) {
				field371[field373] = var2;
				field373 = field373 + 1 & 127;
				if (field372 == field373) {
					field373 = -1;
				}
			}

			int var3;
			if (var2 >= 0) {
				var3 = field386 + 1 & 127;
				if (var3 != field378) {
					field375[field386] = var2;
					field385[field386] = 0;
					field386 = var3;
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

			if (field373 >= 0 && var2 >= 0) {
				field371[field373] = ~var2;
				field373 = field373 + 1 & 127;
				if (field372 == field373) {
					field373 = -1;
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
					int var4 = field386 + 1 & 127;
					if (var4 != field378) {
						field375[field386] = -1;
						field385[field386] = var2;
						field386 = var4;
					}
				}
			}
		}

		var1.consume();
	}

	public final synchronized void focusLost(FocusEvent var1) {
		if (KeyHandler_instance != null) {
			field373 = -1;
		}

	}

	public final void focusGained(FocusEvent var1) {
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-1237064123"
	)
	@Export("isKeyDown")
	public static final boolean isKeyDown() {
		synchronized(KeyHandler_instance) {
			if (field380 == field378) {
				return false;
			} else {
				VertexNormal.field1732 = field375[field378];
				TileItemPile.field1521 = field385[field378];
				field378 = field378 + 1 & 127;
				return true;
			}
		}
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(IIIZII)J",
		garbageValue = "2043386608"
	)
	@Export("calculateTag")
	public static long calculateTag(int var0, int var1, int var2, boolean var3, int var4) {
		long var5 = (long)((var0 & 127) << 0 | (var1 & 127) << 7 | (var2 & 3) << 14) | ((long)var4 & 4294967295L) << 17;
		if (var3) {
			var5 |= 65536L;
		}

		return var5;
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(Lbe;I)V",
		garbageValue = "1892265582"
	)
	@Export("changeWorld")
	static void changeWorld(World var0) {
		if (var0.isMembersOnly() != Client.isMembersWorld) {
			Client.isMembersWorld = var0.isMembersOnly();
			class32.method557(var0.isMembersOnly());
		}

		CollisionMap.worldHost = var0.host;
		Client.worldId = var0.id;
		Client.worldProperties = var0.properties;
		class197.port1 = Client.gameBuild == 0 ? 43594 : var0.id + 40000;
		MouseRecorder.port2 = Client.gameBuild == 0 ? 443 : var0.id + 50000;
		WorldMapData_1.port3 = class197.port1;
	}

	@ObfuscatedName("hn")
	@ObfuscatedSignature(
		signature = "(IIII)V",
		garbageValue = "-616372241"
	)
	@Export("worldToScreen")
	static final void worldToScreen(int var0, int var1, int var2) {
		if (var0 >= 128 && var1 >= 128 && var0 <= 13056 && var1 <= 13056) {
			int var3 = ScriptEvent.getTileHeight(var0, var1, UrlRequest.Client_plane) - var2;
			var0 -= MusicPatchNode2.cameraX;
			var3 -= class60.cameraY;
			var1 -= UserComparator9.cameraZ;
			int var4 = Rasterizer3D.Rasterizer3D_sine[ViewportMouse.cameraPitch];
			int var5 = Rasterizer3D.Rasterizer3D_cosine[ViewportMouse.cameraPitch];
			int var6 = Rasterizer3D.Rasterizer3D_sine[WorldMapLabelSize.cameraYaw];
			int var7 = Rasterizer3D.Rasterizer3D_cosine[WorldMapLabelSize.cameraYaw];
			int var8 = var6 * var1 + var0 * var7 >> 16;
			var1 = var7 * var1 - var0 * var6 >> 16;
			var0 = var8;
			var8 = var3 * var5 - var4 * var1 >> 16;
			var1 = var3 * var4 + var5 * var1 >> 16;
			if (var1 >= 50) {
				Client.viewportTempX = var0 * Client.viewportZoom / var1 + Client.viewportWidth / 2;
				Client.viewportTempY = var8 * Client.viewportZoom / var1 + Client.viewportHeight / 2;
			} else {
				Client.viewportTempX = -1;
				Client.viewportTempY = -1;
			}

		} else {
			Client.viewportTempX = -1;
			Client.viewportTempY = -1;
		}
	}

	@ObfuscatedName("iu")
	@ObfuscatedSignature(
		signature = "(IIIILjava/lang/String;I)V",
		garbageValue = "2129619749"
	)
	@Export("widgetDefaultMenuAction")
	static void widgetDefaultMenuAction(int var0, int var1, int var2, int var3, String var4) {
		Widget var5 = BZip2State.getWidgetChild(var1, var2);
		if (var5 != null) {
			if (var5.onOp != null) {
				ScriptEvent var6 = new ScriptEvent();
				var6.widget = var5;
				var6.opIndex = var0;
				var6.targetName = var4;
				var6.args = var5.onOp;
				Client.runScriptEvent(var6);
			}

			boolean var11 = true;
			if (var5.contentType > 0) {
				var11 = GrandExchangeOfferNameComparator.method136(var5);
			}

			if (var11) {
				int var8 = WorldMapSection0.getWidgetClickMask(var5);
				int var9 = var0 - 1;
				boolean var7 = (var8 >> var9 + 1 & 1) != 0;
				if (var7) {
					PacketBufferNode var10;
					if (var0 == 1) {
						var10 = class2.getPacketBufferNode(ClientPacket.field2279, Client.packetWriter.isaacCipher);
						var10.packetBuffer.writeInt(var1);
						var10.packetBuffer.writeShort(var2);
						var10.packetBuffer.writeShort(var3);
						Client.packetWriter.addNode(var10);
					}

					if (var0 == 2) {
						var10 = class2.getPacketBufferNode(ClientPacket.field2254, Client.packetWriter.isaacCipher);
						var10.packetBuffer.writeInt(var1);
						var10.packetBuffer.writeShort(var2);
						var10.packetBuffer.writeShort(var3);
						Client.packetWriter.addNode(var10);
					}

					if (var0 == 3) {
						var10 = class2.getPacketBufferNode(ClientPacket.field2240, Client.packetWriter.isaacCipher);
						var10.packetBuffer.writeInt(var1);
						var10.packetBuffer.writeShort(var2);
						var10.packetBuffer.writeShort(var3);
						Client.packetWriter.addNode(var10);
					}

					if (var0 == 4) {
						var10 = class2.getPacketBufferNode(ClientPacket.field2205, Client.packetWriter.isaacCipher);
						var10.packetBuffer.writeInt(var1);
						var10.packetBuffer.writeShort(var2);
						var10.packetBuffer.writeShort(var3);
						Client.packetWriter.addNode(var10);
					}

					if (var0 == 5) {
						var10 = class2.getPacketBufferNode(ClientPacket.field2262, Client.packetWriter.isaacCipher);
						var10.packetBuffer.writeInt(var1);
						var10.packetBuffer.writeShort(var2);
						var10.packetBuffer.writeShort(var3);
						Client.packetWriter.addNode(var10);
					}

					if (var0 == 6) {
						var10 = class2.getPacketBufferNode(ClientPacket.field2204, Client.packetWriter.isaacCipher);
						var10.packetBuffer.writeInt(var1);
						var10.packetBuffer.writeShort(var2);
						var10.packetBuffer.writeShort(var3);
						Client.packetWriter.addNode(var10);
					}

					if (var0 == 7) {
						var10 = class2.getPacketBufferNode(ClientPacket.field2186, Client.packetWriter.isaacCipher);
						var10.packetBuffer.writeInt(var1);
						var10.packetBuffer.writeShort(var2);
						var10.packetBuffer.writeShort(var3);
						Client.packetWriter.addNode(var10);
					}

					if (var0 == 8) {
						var10 = class2.getPacketBufferNode(ClientPacket.field2242, Client.packetWriter.isaacCipher);
						var10.packetBuffer.writeInt(var1);
						var10.packetBuffer.writeShort(var2);
						var10.packetBuffer.writeShort(var3);
						Client.packetWriter.addNode(var10);
					}

					if (var0 == 9) {
						var10 = class2.getPacketBufferNode(ClientPacket.field2255, Client.packetWriter.isaacCipher);
						var10.packetBuffer.writeInt(var1);
						var10.packetBuffer.writeShort(var2);
						var10.packetBuffer.writeShort(var3);
						Client.packetWriter.addNode(var10);
					}

					if (var0 == 10) {
						var10 = class2.getPacketBufferNode(ClientPacket.field2200, Client.packetWriter.isaacCipher);
						var10.packetBuffer.writeInt(var1);
						var10.packetBuffer.writeShort(var2);
						var10.packetBuffer.writeShort(var3);
						Client.packetWriter.addNode(var10);
					}

				}
			}
		}
	}

	@ObfuscatedName("le")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1409617805"
	)
	static void method835() {
		if (Client.oculusOrbState == 1) {
			Client.field751 = true;
		}

	}
}
