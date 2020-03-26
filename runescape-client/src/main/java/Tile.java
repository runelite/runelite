import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eq")
@Implements("Tile")
public final class Tile extends Node {
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 1748623045
	)
	@Export("y")
	int y;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 1599333141
	)
	@Export("plane")
	int plane;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 109834917
	)
	@Export("x")
	int x;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 1556991301
	)
	@Export("originalPlane")
	int originalPlane;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lev;"
	)
	@Export("paint")
	TilePaint paint;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lex;"
	)
	@Export("model")
	TileModel model;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lep;"
	)
	@Export("boundaryObject")
	BoundaryObject boundaryObject;
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Lez;"
	)
	@Export("wallDecoration")
	WallDecoration wallDecoration;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Leo;"
	)
	@Export("floorDecoration")
	FloorDecoration floorDecoration;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Ldn;"
	)
	@Export("tileItemPile")
	TileItemPile tileItemPile;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = -540738689
	)
	@Export("gameObjectsCount")
	int gameObjectsCount;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "[Lek;"
	)
	@Export("gameObjects")
	GameObject[] gameObjects;
	@ObfuscatedName("n")
	@Export("gameObjectEdgeMasks")
	int[] gameObjectEdgeMasks;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 1811636757
	)
	@Export("gameObjectsEdgeMask")
	int gameObjectsEdgeMask;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = 1955523497
	)
	@Export("minPlane")
	int minPlane;
	@ObfuscatedName("g")
	@Export("drawPrimary")
	boolean drawPrimary;
	@ObfuscatedName("i")
	@Export("drawSecondary")
	boolean drawSecondary;
	@ObfuscatedName("a")
	@Export("drawGameObjects")
	boolean drawGameObjects;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -566961841
	)
	@Export("drawGameObjectEdges")
	int drawGameObjectEdges;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 1786439481
	)
	int field1678;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = 340621657
	)
	int field1679;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = -596765939
	)
	int field1680;
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Leq;"
	)
	@Export("linkedBelowTile")
	Tile linkedBelowTile;

	Tile(int var1, int var2, int var3) {
		this.gameObjects = new GameObject[5];
		this.gameObjectEdgeMasks = new int[5];
		this.gameObjectsEdgeMask = 0;
		this.originalPlane = this.plane = var1;
		this.x = var2;
		this.y = var3;
	}

	@ObfuscatedName("gg")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-628211228"
	)
	static final void method2961() {
		int var0;
		int var1;
		int var2;
		int var3;
		int var4;
		int var5;
		if (Client.oculusOrbState == 0) {
			var0 = ByteArrayPool.localPlayer.x;
			var1 = ByteArrayPool.localPlayer.y;
			if (SoundSystem.oculusOrbFocalPointX - var0 < -500 || SoundSystem.oculusOrbFocalPointX - var0 > 500 || ServerPacket.oculusOrbFocalPointY - var1 < -500 || ServerPacket.oculusOrbFocalPointY - var1 > 500) {
				SoundSystem.oculusOrbFocalPointX = var0;
				ServerPacket.oculusOrbFocalPointY = var1;
			}

			if (var0 != SoundSystem.oculusOrbFocalPointX) {
				SoundSystem.oculusOrbFocalPointX += (var0 - SoundSystem.oculusOrbFocalPointX) / 16;
			}

			if (var1 != ServerPacket.oculusOrbFocalPointY) {
				ServerPacket.oculusOrbFocalPointY += (var1 - ServerPacket.oculusOrbFocalPointY) / 16;
			}

			var2 = SoundSystem.oculusOrbFocalPointX >> 7;
			var3 = ServerPacket.oculusOrbFocalPointY >> 7;
			var4 = class277.getTileHeight(SoundSystem.oculusOrbFocalPointX, ServerPacket.oculusOrbFocalPointY, ScriptEvent.Client_plane);
			var5 = 0;
			int var6;
			if (var2 > 3 && var3 > 3 && var2 < 100 && var3 < 100) {
				for (var6 = var2 - 4; var6 <= var2 + 4; ++var6) {
					for (int var7 = var3 - 4; var7 <= var3 + 4; ++var7) {
						int var8 = ScriptEvent.Client_plane;
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

			if (var6 > Client.field941) {
				Client.field941 += (var6 - Client.field941) / 24;
			} else if (var6 < Client.field941) {
				Client.field941 += (var6 - Client.field941) / 80;
			}

			Client.field756 = class277.getTileHeight(ByteArrayPool.localPlayer.x, ByteArrayPool.localPlayer.y, ScriptEvent.Client_plane) - Client.camFollowHeight;
		} else if (Client.oculusOrbState == 1) {
			if (Client.field770 && ByteArrayPool.localPlayer != null) {
				var0 = ByteArrayPool.localPlayer.pathX[0];
				var1 = ByteArrayPool.localPlayer.pathY[0];
				if (var0 >= 0 && var1 >= 0 && var0 < 104 && var1 < 104) {
					SoundSystem.oculusOrbFocalPointX = ByteArrayPool.localPlayer.x;
					var2 = class277.getTileHeight(ByteArrayPool.localPlayer.x, ByteArrayPool.localPlayer.y, ScriptEvent.Client_plane) - Client.camFollowHeight;
					if (var2 < Client.field756) {
						Client.field756 = var2;
					}

					ServerPacket.oculusOrbFocalPointY = ByteArrayPool.localPlayer.y;
					Client.field770 = false;
				}
			}

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
				var2 = KeyHandler.KeyHandler_pressedKeys[81] ? Client.oculusOrbSlowedSpeed * -493333163 * 145031165 : Client.oculusOrbNormalSpeed * -720897331 * -412319227;
				var2 *= 16;
				Client.field724 = var10;
				Client.field759 = var11;
			}

			if (Client.field757 < var2) {
				Client.field757 += var2 / 8;
				if (Client.field757 > var2) {
					Client.field757 = var2;
				}
			} else if (Client.field757 > var2) {
				Client.field757 = Client.field757 * 9 / 10;
			}

			if (Client.field757 > 0) {
				var3 = Client.field757 / 16;
				if (Client.field724 >= 0) {
					var0 = Client.field724 - WorldMapIcon_1.cameraYaw & 2047;
					var4 = Rasterizer3D.Rasterizer3D_sine[var0];
					var5 = Rasterizer3D.Rasterizer3D_cosine[var0];
					SoundSystem.oculusOrbFocalPointX += var4 * var3 / 65536;
					ServerPacket.oculusOrbFocalPointY += var5 * var3 / 65536;
				}

				if (Client.field759 != 0) {
					Client.field756 += var3 * Client.field759;
					if (Client.field756 > 0) {
						Client.field756 = 0;
					}
				}
			} else {
				Client.field724 = -1;
				Client.field759 = -1;
			}

			if (KeyHandler.KeyHandler_pressedKeys[13]) {
				Client.packetWriter.addNode(FaceNormal.getPacketBufferNode(ClientPacket.field2306, Client.packetWriter.isaacCipher));
				Client.oculusOrbState = 0;
			}
		}

		if (MouseHandler.MouseHandler_currentButton == 4 && class217.mouseCam) {
			var0 = MouseHandler.MouseHandler_y - Client.mouseCamClickedY;
			Client.camAngleDX = var0 * 2;
			Client.mouseCamClickedY = var0 != -1 && var0 != 1 ? (Client.mouseCamClickedY + MouseHandler.MouseHandler_y) / 2 : MouseHandler.MouseHandler_y * -1802673633 * 1852676575;
			var1 = Client.mouseCamClickedX - MouseHandler.MouseHandler_x;
			Client.camAngleDY = var1 * 2;
			Client.mouseCamClickedX = var1 != -1 && var1 != 1 ? (MouseHandler.MouseHandler_x + Client.mouseCamClickedX) / 2 : MouseHandler.MouseHandler_x * 9279483 * 178641715;
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

	@ObfuscatedName("hu")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "109"
	)
	@Export("addCancelMenuEntry")
	static void addCancelMenuEntry() {
		AbstractByteArrayCopier.method4023();
		Client.menuActions[0] = "Cancel";
		Client.menuTargets[0] = "";
		Client.menuOpcodes[0] = 1006;
		Client.menuShiftClick[0] = false;
		Client.menuOptionsCount = 1;
	}
}
