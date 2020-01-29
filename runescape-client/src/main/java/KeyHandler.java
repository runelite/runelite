import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("at")
@Implements("KeyHandler")
public final class KeyHandler implements KeyListener, FocusListener {
	@ObfuscatedName("rm")
	@ObfuscatedSignature(
		signature = "Lbu;"
	)
	@Export("friendSystem")
	public static FriendSystem friendSystem;
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lat;"
	)
	@Export("KeyHandler_instance")
	static KeyHandler KeyHandler_instance;
	@ObfuscatedName("p")
	@Export("musicTrackBoolean")
	public static boolean musicTrackBoolean;
	@ObfuscatedName("cf")
	@Export("KeyHandler_pressedKeys")
	public static boolean[] KeyHandler_pressedKeys;
	@ObfuscatedName("cu")
	static int[] field399;
	@ObfuscatedName("cy")
	@ObfuscatedGetter(
		intValue = 703429313
	)
	static int field400;
	@ObfuscatedName("ce")
	@ObfuscatedGetter(
		intValue = -1486976357
	)
	static int field387;
	@ObfuscatedName("cw")
	static char[] field410;
	@ObfuscatedName("cq")
	static int[] field403;
	@ObfuscatedName("ci")
	public static int[] field404;
	@ObfuscatedName("ca")
	@ObfuscatedGetter(
		intValue = -617516983
	)
	public static int field405;
	@ObfuscatedName("cc")
	@ObfuscatedGetter(
		intValue = 1714214597
	)
	static int field406;
	@ObfuscatedName("ch")
	@ObfuscatedGetter(
		intValue = -168140991
	)
	static int field407;
	@ObfuscatedName("cx")
	@ObfuscatedGetter(
		intValue = 1711084141
	)
	static int field408;
	@ObfuscatedName("cl")
	@ObfuscatedGetter(
		intValue = -1956753403
	)
	@Export("KeyHandler_idleCycles")
	static volatile int KeyHandler_idleCycles;
	@ObfuscatedName("cs")
	@Export("KeyHandler_keyCodes")
	static int[] KeyHandler_keyCodes;

	static {
		KeyHandler_instance = new KeyHandler();
		KeyHandler_pressedKeys = new boolean[112];
		field399 = new int[128];
		field400 = 0;
		field387 = 0;
		field410 = new char[128];
		field403 = new int[128];
		field404 = new int[128];
		field405 = 0;
		field406 = 0;
		field407 = 0;
		field408 = 0;
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

			if (field387 >= 0 && var2 >= 0) {
				field399[field387] = var2;
				field387 = field387 + 1 & 127;
				if (field387 == field400) {
					field387 = -1;
				}
			}

			int var3;
			if (var2 >= 0) {
				var3 = field407 + 1 & 127;
				if (var3 != field406) {
					field403[field407] = var2;
					field410[field407] = 0;
					field407 = var3;
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
							char[] var7 = class288.cp1252AsciiExtension;

							for (int var5 = 0; var5 < var7.length; ++var5) {
								char var6 = var7[var5];
								if (var2 == var6) {
									var3 = true;
									break label59;
								}
							}
						}

						var3 = false;
					}
				}

				if (var3) {
					int var4 = field407 + 1 & 127;
					if (var4 != field406) {
						field403[field407] = -1;
						field410[field407] = var2;
						field407 = var4;
					}
				}
			}
		}

		var1.consume();
	}

	public final synchronized void focusLost(FocusEvent var1) {
		if (KeyHandler_instance != null) {
			field387 = -1;
		}

	}

	public final void focusGained(FocusEvent var1) {
	}

	public final synchronized void keyReleased(KeyEvent var1) {
		if (KeyHandler_instance != null) {
			int var2 = var1.getKeyCode();
			if (var2 >= 0 && var2 < KeyHandler_keyCodes.length) {
				var2 = KeyHandler_keyCodes[var2] & -129;
			} else {
				var2 = -1;
			}

			if (field387 >= 0 && var2 >= 0) {
				field399[field387] = ~var2;
				field387 = field387 + 1 & 127;
				if (field387 == field400) {
					field387 = -1;
				}
			}
		}

		var1.consume();
	}

	@ObfuscatedName("t")
	public static boolean method850(long var0) {
		return var0 != 0L && !WorldMapData_1.method732(var0);
	}

	@ObfuscatedName("hg")
	@ObfuscatedSignature(
		signature = "(ZLks;B)V",
		garbageValue = "77"
	)
	@Export("updateNpcs")
	static final void updateNpcs(boolean var0, PacketBuffer var1) {
		Client.field766 = 0;
		Client.field690 = 0;
		ClientPreferences.method1852();

		int var2;
		while (var1.bitsRemaining(Client.packetWriter.serverPacketLength) >= 27) {
			var2 = var1.readBits(15);
			if (var2 == 32767) {
				break;
			}

			boolean var3 = false;
			if (Client.npcs[var2] == null) {
				Client.npcs[var2] = new NPC();
				var3 = true;
			}

			NPC var4 = Client.npcs[var2];
			Client.npcIndices[++Client.npcCount - 1] = var2;
			var4.npcCycle = Client.cycle;
			int var5;
			if (var0) {
				var5 = var1.readBits(8);
				if (var5 > 127) {
					var5 -= 256;
				}
			} else {
				var5 = var1.readBits(5);
				if (var5 > 15) {
					var5 -= 32;
				}
			}

			var4.definition = NetCache.getNpcDefinition(var1.readBits(14));
			int var6 = Client.defaultRotations[var1.readBits(3)];
			if (var3) {
				var4.orientation = var4.rotation = var6;
			}

			int var7 = var1.readBits(1);
			int var8 = var1.readBits(1);
			if (var8 == 1) {
				Client.field867[++Client.field690 - 1] = var2;
			}

			int var9;
			if (var0) {
				var9 = var1.readBits(8);
				if (var9 > 127) {
					var9 -= 256;
				}
			} else {
				var9 = var1.readBits(5);
				if (var9 > 15) {
					var9 -= 32;
				}
			}

			var4.field942 = var4.definition.size * 64;
			var4.field975 = var4.definition.rotation;
			if (var4.field975 == 0) {
				var4.rotation = 0;
			}

			var4.walkSequence = var4.definition.walkSequence;
			var4.walkBackSequence = var4.definition.walkBackSequence;
			var4.walkLeftSequence = var4.definition.walkLeftSequence;
			var4.walkRightSequence = var4.definition.walkRightSequence;
			var4.readySequence = var4.definition.readySequence;
			var4.turnLeftSequence = var4.definition.turnLeftSequence;
			var4.turnRightSequence = var4.definition.turnRightSequence;
			var4.method2077(class192.localPlayer.pathX[0] + var9, class192.localPlayer.pathY[0] + var5, var7 == 1);
		}

		var1.exportIndex();
		class49.method866(var1);

		for (var2 = 0; var2 < Client.field766; ++var2) {
			int var10 = Client.field828[var2];
			if (Client.npcs[var10].npcCycle != Client.cycle) {
				Client.npcs[var10].definition = null;
				Client.npcs[var10] = null;
			}
		}

		if (var1.offset != Client.packetWriter.serverPacketLength) {
			throw new RuntimeException(var1.offset + "," + Client.packetWriter.serverPacketLength);
		} else {
			for (var2 = 0; var2 < Client.npcCount; ++var2) {
				if (Client.npcs[Client.npcIndices[var2]] == null) {
					throw new RuntimeException(var2 + "," + Client.npcCount);
				}
			}

		}
	}

	@ObfuscatedName("jz")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1886684971"
	)
	static final void method848() {
		PacketBufferNode var0 = TilePaint.getPacketBufferNode(ClientPacket.field2298, Client.packetWriter.isaacCipher);
		Client.packetWriter.addNode(var0);

		for (InterfaceParent var1 = (InterfaceParent)Client.interfaceParents.first(); var1 != null; var1 = (InterfaceParent)Client.interfaceParents.next()) {
			if (var1.type == 0 || var1.type == 3) {
				class185.closeInterface(var1, true);
			}
		}

		if (Client.meslayerContinueWidget != null) {
			NPCDefinition.invalidateWidget(Client.meslayerContinueWidget);
			Client.meslayerContinueWidget = null;
		}

	}

	@ObfuscatedName("kl")
	@ObfuscatedSignature(
		signature = "(IIIILlt;Lhf;S)V",
		garbageValue = "19802"
	)
	@Export("worldToMinimap")
	static final void worldToMinimap(int var0, int var1, int var2, int var3, Sprite var4, SpriteMask var5) {
		int var6 = var3 * var3 + var2 * var2;
		if (var6 > 4225 && var6 < 90000) {
			int var7 = Client.camAngleY & 2047;
			int var8 = Rasterizer3D.Rasterizer3D_sine[var7];
			int var9 = Rasterizer3D.Rasterizer3D_cosine[var7];
			int var10 = var9 * var2 + var3 * var8 >> 16;
			int var11 = var3 * var9 - var8 * var2 >> 16;
			double var12 = Math.atan2((double)var10, (double)var11);
			int var14 = var5.width / 2 - 25;
			int var15 = (int)(Math.sin(var12) * (double)var14);
			int var16 = (int)(Math.cos(var12) * (double)var14);
			byte var17 = 20;
			ArchiveLoader.redHintArrowSprite.method6242(var15 + (var0 + var5.width / 2 - var17 / 2), var5.height / 2 + var1 - var17 / 2 - var16 - 10, var17, var17, 15, 15, var12, 256);
		} else {
			Script.drawSpriteOnMinimap(var0, var1, var2, var3, var4, var5);
		}

	}
}
