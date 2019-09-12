import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bs")
@Implements("ScriptEvent")
public class ScriptEvent extends Node {
	@ObfuscatedName("de")
	@ObfuscatedSignature(
		signature = "Lio;"
	)
	@Export("archive0")
	static Archive archive0;
	@ObfuscatedName("fl")
	@ObfuscatedGetter(
		intValue = 1594394289
	)
	@Export("baseY")
	static int baseY;
	@ObfuscatedName("c")
	@Export("args")
	Object[] args;
	@ObfuscatedName("x")
	@Export("isMouseInputEvent")
	boolean isMouseInputEvent;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lhy;"
	)
	@Export("widget")
	Widget widget;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 268953475
	)
	@Export("mouseX")
	int mouseX;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -2080678737
	)
	@Export("mouseY")
	int mouseY;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -2067393571
	)
	@Export("opIndex")
	int opIndex;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Lhy;"
	)
	@Export("dragTarget")
	Widget dragTarget;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 459538491
	)
	@Export("keyTyped")
	int keyTyped;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 464546499
	)
	@Export("keyPressed")
	int keyPressed;
	@ObfuscatedName("z")
	@Export("targetName")
	String targetName;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 1112328999
	)
	int field550;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = -1497234369
	)
	@Export("type")
	int type;

	public ScriptEvent() {
		this.type = 76;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "([Ljava/lang/Object;I)V",
		garbageValue = "1827430499"
	)
	@Export("setArgs")
	public void setArgs(Object[] var1) {
		this.args = var1;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "-8"
	)
	@Export("setType")
	public void setType(int var1) {
		this.type = var1;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(CLgf;I)C",
		garbageValue = "-1157356777"
	)
	@Export("standardizeChar")
	static char standardizeChar(char var0, Language var1) {
		if (var0 >= 192 && var0 <= 255) {
			if (var0 >= 192 && var0 <= 198) {
				return 'A';
			}

			if (var0 == 199) {
				return 'C';
			}

			if (var0 >= 200 && var0 <= 203) {
				return 'E';
			}

			if (var0 >= 204 && var0 <= 207) {
				return 'I';
			}

			if (var0 == 209 && var1 != Language.Language_ES) {
				return 'N';
			}

			if (var0 >= 210 && var0 <= 214) {
				return 'O';
			}

			if (var0 >= 217 && var0 <= 220) {
				return 'U';
			}

			if (var0 == 221) {
				return 'Y';
			}

			if (var0 == 223) {
				return 's';
			}

			if (var0 >= 224 && var0 <= 230) {
				return 'a';
			}

			if (var0 == 231) {
				return 'c';
			}

			if (var0 >= 232 && var0 <= 235) {
				return 'e';
			}

			if (var0 >= 236 && var0 <= 239) {
				return 'i';
			}

			if (var0 == 241 && var1 != Language.Language_ES) {
				return 'n';
			}

			if (var0 >= 242 && var0 <= 246) {
				return 'o';
			}

			if (var0 >= 249 && var0 <= 252) {
				return 'u';
			}

			if (var0 == 253 || var0 == 255) {
				return 'y';
			}
		}

		if (var0 == 338) {
			return 'O';
		} else if (var0 == 339) {
			return 'o';
		} else if (var0 == 376) {
			return 'Y';
		} else {
			return var0;
		}
	}

	@ObfuscatedName("fn")
	@ObfuscatedSignature(
		signature = "(IIIII)V",
		garbageValue = "-1198922162"
	)
	@Export("drawEntities")
	static final void drawEntities(int var0, int var1, int var2, int var3) {
		++Client.viewportDrawCount;
		if (Varps.localPlayer.x * -78439701 >> 7 == Client.destinationX && Varps.localPlayer.y >> 7 == Client.destinationY) {
			Client.destinationX = 0;
		}

		HealthBarUpdate.method1708();
		if (Client.combatTargetPlayerIndex >= 0 && Client.players[Client.combatTargetPlayerIndex] != null) {
			GameObject.addPlayerToScene(Client.players[Client.combatTargetPlayerIndex], false);
		}

		class2.addNpcsToScene(true);
		Projectile.method2083();
		class2.addNpcsToScene(false);

		int var6;
		for (Projectile var4 = (Projectile)Client.projectiles.last(); var4 != null; var4 = (Projectile)Client.projectiles.previous()) {
			if (var4.plane == MouseRecorder.plane && Client.cycle <= var4.cycleEnd) {
				if (Client.cycle >= var4.cycleStart) {
					if (var4.targetIndex > 0) {
						NPC var22 = Client.npcs[var4.targetIndex - 1];
						if (var22 != null && var22.x * -78439701 >= 0 && var22.x * -78439701 < 13312 && var22.y >= 0 && var22.y < 13312) {
							var4.setDestination(var22.x * -78439701, var22.y, WorldMapAreaData.getTileHeight(var22.x * -78439701, var22.y, var4.plane) - var4.endHeight, Client.cycle);
						}
					}

					if (var4.targetIndex < 0) {
						var6 = -var4.targetIndex - 1;
						Player var24;
						if (var6 == Client.localPlayerIndex) {
							var24 = Varps.localPlayer;
						} else {
							var24 = Client.players[var6];
						}

						if (var24 != null && var24.x * -78439701 >= 0 && var24.x * -78439701 < 13312 && var24.y >= 0 && var24.y < 13312) {
							var4.setDestination(var24.x * -78439701, var24.y, WorldMapAreaData.getTileHeight(var24.x * -78439701, var24.y, var4.plane) - var4.endHeight, Client.cycle);
						}
					}

					var4.advance(Client.field683);
					WorldMapIcon_1.scene.drawEntity(MouseRecorder.plane, (int)var4.x, (int)var4.y, (int)var4.z, 60, var4, var4.yaw, -1L, false);
				}
			} else {
				var4.remove();
			}
		}

		Script.method2201();
		DesktopPlatformInfoProvider.setViewportShape(var0, var1, var2, var3, true);
		var0 = Client.viewportOffsetX;
		var1 = Client.viewportOffsetY;
		var2 = Client.viewportWidth;
		var3 = Client.viewportHeight;
		Rasterizer2D.Rasterizer2D_setClip(var0, var1, var0 + var2, var3 + var1);
		Rasterizer3D.Rasterizer3D_setClipFromRasterizer2D();
		int var5;
		int var7;
		int var8;
		int var9;
		int var11;
		int var12;
		int var14;
		int var21;
		if (!Client.isCameraLocked) {
			var21 = Client.camAngleX;
			if (Client.field707 / 256 > var21) {
				var21 = Client.field707 / 256;
			}

			if (Client.field749[4] && Client.field887[4] + 128 > var21) {
				var21 = Client.field887[4] + 128;
			}

			var5 = Client.camAngleY & 2047;
			var6 = SecureRandomFuture.oculusOrbFocalPointX;
			var7 = class65.field580 * 1615694975;
			var8 = AbstractByteArrayCopier.oculusOrbFocalPointY;
			var9 = var21 * 3 + 600;
			var12 = var3 - 334;
			if (var12 < 0) {
				var12 = 0;
			} else if (var12 > 100) {
				var12 = 100;
			}

			int var13 = (Client.zoomWidth - Client.zoomHeight) * var12 / 100 + Client.zoomHeight;
			var11 = var13 * var9 / 256;
			var12 = 2048 - var21 & 2047;
			var13 = 2048 - var5 & 2047;
			var14 = 0;
			int var15 = 0;
			int var16 = var11;
			int var17;
			int var18;
			int var19;
			if (var12 != 0) {
				var17 = Rasterizer3D.Rasterizer3D_sine[var12];
				var18 = Rasterizer3D.Rasterizer3D_cosine[var12];
				var19 = var18 * var15 - var11 * var17 >> 16;
				var16 = var17 * var15 + var18 * var11 >> 16;
				var15 = var19;
			}

			if (var13 != 0) {
				var17 = Rasterizer3D.Rasterizer3D_sine[var13];
				var18 = Rasterizer3D.Rasterizer3D_cosine[var13];
				var19 = var18 * var14 + var17 * var16 >> 16;
				var16 = var18 * var16 - var17 * var14 >> 16;
				var14 = var19;
			}

			ScriptFrame.cameraX = var6 - var14;
			GrandExchangeOfferTotalQuantityComparator.cameraY = var7 - var15;
			class14.cameraZ = var8 - var16;
			class319.cameraPitch = var21;
			Tile.cameraYaw = var5;
			if (Client.oculusOrbState == 1 && Client.staffModLevel >= 2 && Client.cycle % 50 == 0 && (Varps.localPlayer.x * -78439701 >> 7 != SecureRandomFuture.oculusOrbFocalPointX >> 7 || AbstractByteArrayCopier.oculusOrbFocalPointY >> 7 != Varps.localPlayer.y >> 7)) {
				var17 = Varps.localPlayer.plane;
				var18 = class4.baseX * 64 + (SecureRandomFuture.oculusOrbFocalPointX >> 7);
				var19 = (AbstractByteArrayCopier.oculusOrbFocalPointY >> 7) + baseY;
				PacketBufferNode var20 = MenuAction.getPacketBufferNode(ClientPacket.field2187, Client.packetWriter.isaacCipher);
				var20.packetBuffer.method5500(var18);
				var20.packetBuffer.writeShort(var19);
				var20.packetBuffer.method5491(var17);
				var20.packetBuffer.writeIntLE16(Client.field688);
				Client.packetWriter.addNode(var20);
			}
		}

		if (!Client.isCameraLocked) {
			var21 = Client.method1679();
		} else {
			var21 = SecureRandomCallable.getHighestVisiblePlane();
		}

		var5 = ScriptFrame.cameraX;
		var6 = GrandExchangeOfferTotalQuantityComparator.cameraY;
		var7 = class14.cameraZ;
		var8 = class319.cameraPitch;
		var9 = Tile.cameraYaw;

		int var10;
		for (var10 = 0; var10 < 5; ++var10) {
			if (Client.field749[var10]) {
				var11 = (int)(Math.random() * (double)(Client.field779[var10] * 2 + 1) - (double)Client.field779[var10] + Math.sin((double)Client.field871[var10] / 100.0D * (double)Client.field799[var10]) * (double)Client.field887[var10]);
				if (var10 == 0) {
					ScriptFrame.cameraX += var11;
				}

				if (var10 == 1) {
					GrandExchangeOfferTotalQuantityComparator.cameraY += var11;
				}

				if (var10 == 2) {
					class14.cameraZ += var11;
				}

				if (var10 == 3) {
					Tile.cameraYaw = var11 + Tile.cameraYaw & 2047;
				}

				if (var10 == 4) {
					class319.cameraPitch += var11;
					if (class319.cameraPitch < 128) {
						class319.cameraPitch = 128;
					}

					if (class319.cameraPitch > 383) {
						class319.cameraPitch = 383;
					}
				}
			}
		}

		var10 = MouseHandler.MouseHandler_x;
		var11 = MouseHandler.MouseHandler_y;
		if (MouseHandler.MouseHandler_lastButton != 0) {
			var10 = MouseHandler.MouseHandler_lastPressedX;
			var11 = MouseHandler.MouseHandler_lastPressedY;
		}

		if (var10 >= var0 && var10 < var0 + var2 && var11 >= var1 && var11 < var3 + var1) {
			WorldMapIcon_0.method174(var10 - var0, var11 - var1);
		} else {
			PendingSpawn.method1682();
		}

		ModelData0.playPcmPlayers();
		Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var2, var3, 0);
		ModelData0.playPcmPlayers();
		var12 = Rasterizer3D.Rasterizer3D_zoom;
		Rasterizer3D.Rasterizer3D_zoom = Client.viewportZoom;
		WorldMapIcon_1.scene.draw(ScriptFrame.cameraX, GrandExchangeOfferTotalQuantityComparator.cameraY, class14.cameraZ, class319.cameraPitch, Tile.cameraYaw, var21);
		Rasterizer3D.Rasterizer3D_zoom = var12;
		ModelData0.playPcmPlayers();
		WorldMapIcon_1.scene.clearTempGameObjects();
		Actor.method1704(var0, var1, var2, var3);
		if (Client.hintArrowType == 2) {
			NPC.worldToScreen(Client.hintArrowSubX * 64 + (Client.hintArrowX - class4.baseX * 64 << 7), Client.hintArrowSubY * 64 + (Client.hintArrowY - baseY << 7), Client.hintArrowHeight * 2);
			if (Client.viewportTempX > -1 && Client.cycle % 20 < 10) {
				GrandExchangeEvents.headIconHintSprites[0].drawTransBgAt(var0 + Client.viewportTempX - 12, Client.viewportTempY + var1 - 28);
			}
		}

		((TextureProvider)Rasterizer3D.Rasterizer3D_textureLoader).animate(Client.field683);
		Occluder.method3253();
		ScriptFrame.cameraX = var5;
		GrandExchangeOfferTotalQuantityComparator.cameraY = var6;
		class14.cameraZ = var7;
		class319.cameraPitch = var8;
		Tile.cameraYaw = var9;
		if (Client.isLoading) {
			byte var23 = 0;
			var14 = var23 + NetCache.NetCache_pendingPriorityResponsesCount + NetCache.NetCache_pendingPriorityWritesCount;
			if (var14 == 0) {
				Client.isLoading = false;
			}
		}

		if (Client.isLoading) {
			Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var2, var3, 0);
			GZipDecompressor.drawLoadingMessage("Loading - please wait.", false);
		}

	}

	@ObfuscatedName("hr")
	@ObfuscatedSignature(
		signature = "(IIS)V",
		garbageValue = "128"
	)
	@Export("calculateMenuBounds")
	static void calculateMenuBounds(int var0, int var1) {
		int var2 = HealthBar.fontBold12.stringWidth("Choose Option");

		int var3;
		int var4;
		for (var3 = 0; var3 < Client.menuOptionsCount; ++var3) {
			var4 = HealthBar.fontBold12.stringWidth(class188.method3620(var3));
			if (var4 > var2) {
				var2 = var4;
			}
		}

		var2 += 8;
		var3 = Client.menuOptionsCount * 15 + 22;
		var4 = var0 - var2 / 2;
		if (var2 + var4 > GraphicsDefaults.canvasWidth) {
			var4 = GraphicsDefaults.canvasWidth - var2;
		}

		if (var4 < 0) {
			var4 = 0;
		}

		int var5 = var1;
		if (var3 + var1 > GameShell.canvasHeight) {
			var5 = GameShell.canvasHeight - var3;
		}

		if (var5 < 0) {
			var5 = 0;
		}

		FileSystem.menuX = var4;
		class83.menuY = var5;
		class173.menuWidth = var2;
		FaceNormal.menuHeight = Client.menuOptionsCount * 15 + 22;
	}

	@ObfuscatedName("ie")
	@ObfuscatedSignature(
		signature = "(Lhy;Lid;IIZI)V",
		garbageValue = "-2103292132"
	)
	@Export("addWidgetItemMenuItem")
	static final void addWidgetItemMenuItem(Widget var0, ItemDefinition var1, int var2, int var3, boolean var4) {
		String[] var5 = var1.inventoryActions;
		byte var6 = -1;
		String var7 = null;
		if (var5 != null && var5[var3] != null) {
			if (var3 == 0) {
				var6 = 33;
			} else if (var3 == 1) {
				var6 = 34;
			} else if (var3 == 2) {
				var6 = 35;
			} else if (var3 == 3) {
				var6 = 36;
			} else {
				var6 = 37;
			}

			var7 = var5[var3];
		} else if (var3 == 4) {
			var6 = 37;
			var7 = "Drop";
		}

		if (var6 != -1 && var7 != null) {
			Decimator.insertMenuItem(var7, UserComparator7.colorStartTag(16748608) + var1.name, var6, var1.id, var2, var0.id, var4);
		}

	}

	@ObfuscatedName("jj")
	@ObfuscatedSignature(
		signature = "(Lhy;IIII)V",
		garbageValue = "458533569"
	)
	@Export("drawCompass")
	static final void drawCompass(Widget var0, int var1, int var2, int var3) {
		SpriteMask var4 = var0.getSpriteMask(false);
		if (var4 != null) {
			if (Client.minimapState < 3) {
				UrlRequest.compass.drawRotatedMaskedCenteredAround(var1, var2, var4.width, var4.height, 25, 25, Client.camAngleY, 256, var4.xStarts, var4.xWidths);
			} else {
				Rasterizer2D.Rasterizer2D_fillMaskedRectangle(var1, var2, 0, var4.xStarts, var4.xWidths);
			}

		}
	}
}
