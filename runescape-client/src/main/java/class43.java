import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("aj")
public final class class43 {
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 1757015417
	)
	@Export("Interpreter_stringStackSize")
	static int Interpreter_stringStackSize;
	@ObfuscatedName("ds")
	@ObfuscatedSignature(
		signature = "Lij;"
	)
	@Export("archive1")
	static Archive archive1;
	@ObfuscatedName("la")
	@ObfuscatedGetter(
		intValue = 714486745
	)
	@Export("selectedItemSlot")
	static int selectedItemSlot;

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Lln;IIIB)V",
		garbageValue = "86"
	)
	static void method822(Sprite var0, int var1, int var2, int var3) {
		DemotingHashTable var4 = WorldMapRegion.WorldMapRegion_cachedSprites;
		long var6 = (long)(var3 << 16 | var1 << 8 | var2);
		var4.put(var0, var6, var0.pixels.length * 4);
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "96"
	)
	public static boolean method820() {
		ReflectionCheck var0 = (ReflectionCheck)class96.reflectionChecks.last();
		return var0 != null;
	}

	@ObfuscatedName("gj")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "-58"
	)
	@Export("getWindowedMode")
	static int getWindowedMode() {
		return Client.isResizable ? 2 : 1;
	}

	@ObfuscatedName("gh")
	@ObfuscatedSignature(
		signature = "(IIIII)V",
		garbageValue = "-2123734164"
	)
	@Export("drawEntities")
	static final void drawEntities(int var0, int var1, int var2, int var3) {
		++Client.viewportDrawCount;
		if (class215.localPlayer.x >> 7 == Client.destinationX && class215.localPlayer.y >> 7 == Client.destinationY) {
			Client.destinationX = 0;
		}

		Tiles.method1161();
		FontName.method5427();
		WorldMapData_0.addNpcsToScene(true);
		Tiles.method1160();
		WorldMapData_0.addNpcsToScene(false);
		WorldMapSection0.method251();

		for (GraphicsObject var4 = (GraphicsObject)Client.graphicsObjects.last(); var4 != null; var4 = (GraphicsObject)Client.graphicsObjects.previous()) {
			if (var4.plane == ClientPacket.Client_plane && !var4.isFinished) {
				if (Client.cycle >= var4.cycleStart) {
					var4.advance(Client.field704);
					if (var4.isFinished) {
						var4.remove();
					} else {
						class2.scene.drawEntity(var4.plane, var4.x, var4.y, var4.height, 60, var4, 0, -1L, false);
					}
				}
			} else {
				var4.remove();
			}
		}

		FileSystem.setViewportShape(var0, var1, var2, var3, true);
		var0 = Client.viewportOffsetX;
		var1 = Client.viewportOffsetY;
		var2 = Client.viewportWidth;
		var3 = Client.viewportHeight;
		Rasterizer2D.Rasterizer2D_setClip(var0, var1, var0 + var2, var3 + var1);
		Rasterizer3D.Rasterizer3D_setClipFromRasterizer2D();
		int var5;
		int var6;
		int var7;
		int var8;
		int var9;
		int var10;
		int var11;
		int var12;
		int var18;
		if (!Client.isCameraLocked) {
			var18 = Client.camAngleX;
			if (Client.field728 / 256 > var18) {
				var18 = Client.field728 / 256;
			}

			if (Client.field835[4] && Client.field901[4] + 128 > var18) {
				var18 = Client.field901[4] + 128;
			}

			var5 = Client.camAngleY & 2047;
			var6 = class80.oculusOrbFocalPointX;
			var7 = GrandExchangeOfferAgeComparator.field78;
			var8 = class81.oculusOrbFocalPointY;
			var9 = FloorDecoration.method2888(var18);
			var9 = class14.method176(var9, var3);
			var10 = 2048 - var18 & 2047;
			var11 = 2048 - var5 & 2047;
			var12 = 0;
			int var13 = 0;
			int var14 = var9;
			int var15;
			int var16;
			int var17;
			if (var10 != 0) {
				var15 = Rasterizer3D.Rasterizer3D_sine[var10];
				var16 = Rasterizer3D.Rasterizer3D_cosine[var10];
				var17 = var16 * var13 - var15 * var9 >> 16;
				var14 = var15 * var13 + var16 * var9 >> 16;
				var13 = var17;
			}

			if (var11 != 0) {
				var15 = Rasterizer3D.Rasterizer3D_sine[var11];
				var16 = Rasterizer3D.Rasterizer3D_cosine[var11];
				var17 = var14 * var15 + var12 * var16 >> 16;
				var14 = var16 * var14 - var15 * var12 >> 16;
				var12 = var17;
			}

			class30.cameraX = var6 - var12;
			GameObject.cameraY = var7 - var13;
			FloorDecoration.cameraZ = var8 - var14;
			ItemContainer.cameraPitch = var18;
			Decimator.cameraYaw = var5;
			if (Client.oculusOrbState == 1 && Client.staffModLevel >= 2 && Client.cycle % 50 == 0 && (class80.oculusOrbFocalPointX >> 7 != class215.localPlayer.x >> 7 || class81.oculusOrbFocalPointY >> 7 != class215.localPlayer.y >> 7)) {
				var15 = class215.localPlayer.plane;
				var16 = class51.baseX * 64 + (class80.oculusOrbFocalPointX >> 7);
				var17 = VarcInt.baseY * 64 + (class81.oculusOrbFocalPointY >> 7);
				Clock.method3555(var16, var17, var15, true);
			}
		}

		if (!Client.isCameraLocked) {
			var18 = ClientPacket.method3660();
		} else {
			if (UserComparator10.clientPreferences.roofsHidden) {
				var5 = ClientPacket.Client_plane;
			} else {
				var6 = class195.getTileHeight(class30.cameraX, FloorDecoration.cameraZ, ClientPacket.Client_plane);
				if (var6 - GameObject.cameraY < 800 && (Tiles.Tiles_renderFlags[ClientPacket.Client_plane][class30.cameraX >> 7][FloorDecoration.cameraZ >> 7] & 4) != 0) {
					var5 = ClientPacket.Client_plane;
				} else {
					var5 = 3;
				}
			}

			var18 = var5;
		}

		var5 = class30.cameraX;
		var6 = GameObject.cameraY;
		var7 = FloorDecoration.cameraZ;
		var8 = ItemContainer.cameraPitch;
		var9 = Decimator.cameraYaw;

		for (var10 = 0; var10 < 5; ++var10) {
			if (Client.field835[var10]) {
				var11 = (int)(Math.random() * (double)(Client.field736[var10] * 2 + 1) - (double)Client.field736[var10] + Math.sin((double)Client.field890[var10] / 100.0D * (double)Client.field891[var10]) * (double)Client.field901[var10]);
				if (var10 == 0) {
					class30.cameraX += var11;
				}

				if (var10 == 1) {
					GameObject.cameraY += var11;
				}

				if (var10 == 2) {
					FloorDecoration.cameraZ += var11;
				}

				if (var10 == 3) {
					Decimator.cameraYaw = var11 + Decimator.cameraYaw & 2047;
				}

				if (var10 == 4) {
					ItemContainer.cameraPitch += var11;
					if (ItemContainer.cameraPitch < 128) {
						ItemContainer.cameraPitch = 128;
					}

					if (ItemContainer.cameraPitch > 383) {
						ItemContainer.cameraPitch = 383;
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
			CollisionMap.method3628(var10 - var0, var11 - var1);
		} else {
			ParamDefinition.method4611();
		}

		Tiles.playPcmPlayers();
		Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var2, var3, 0);
		Tiles.playPcmPlayers();
		var12 = Rasterizer3D.Rasterizer3D_zoom;
		Rasterizer3D.Rasterizer3D_zoom = Client.viewportZoom;
		class2.scene.draw(class30.cameraX, GameObject.cameraY, FloorDecoration.cameraZ, ItemContainer.cameraPitch, Decimator.cameraYaw, var18);
		Rasterizer3D.Rasterizer3D_zoom = var12;
		Tiles.playPcmPlayers();
		class2.scene.clearTempGameObjects();
		FontName.method5426(var0, var1, var2, var3);
		if (Client.hintArrowType == 2) {
			TextureProvider.worldToScreen(Client.hintArrowSubX * 64 + (Client.hintArrowX - class51.baseX * 64 << 7), Client.hintArrowSubY * 64 + (Client.hintArrowY - VarcInt.baseY * 64 << 7), Client.hintArrowHeight * 2);
			if (Client.viewportTempX > -1 && Client.cycle % 20 < 10) {
				SequenceDefinition.headIconHintSprites[0].drawTransBgAt(var0 + Client.viewportTempX - 12, Client.viewportTempY + var1 - 28);
			}
		}

		((TextureProvider)Rasterizer3D.Rasterizer3D_textureLoader).animate(Client.field704);
		KeyHandler.method837(var0, var1, var2, var3);
		class30.cameraX = var5;
		GameObject.cameraY = var6;
		FloorDecoration.cameraZ = var7;
		ItemContainer.cameraPitch = var8;
		Decimator.cameraYaw = var9;
		if (Client.isLoading && ViewportMouse.method3015(true, false) == 0) {
			Client.isLoading = false;
		}

		if (Client.isLoading) {
			Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var2, var3, 0);
			WorldMapIcon_1.drawLoadingMessage("Loading - please wait.", false);
		}

	}

	@ObfuscatedName("kx")
	@ObfuscatedSignature(
		signature = "(Lbf;ZI)V",
		garbageValue = "-854325632"
	)
	@Export("closeInterface")
	static final void closeInterface(InterfaceParent var0, boolean var1) {
		int var2 = var0.group;
		int var3 = (int)var0.key;
		var0.remove();
		if (var1) {
			DynamicObject.method2263(var2);
		}

		for (IntegerNode var4 = (IntegerNode)Client.widgetClickMasks.first(); var4 != null; var4 = (IntegerNode)Client.widgetClickMasks.next()) {
			if ((long)var2 == (var4.key >> 48 & 65535L)) {
				var4.remove();
			}
		}

		Widget var5 = Language.getWidget(var3);
		if (var5 != null) {
			ScriptEvent.invalidateWidget(var5);
		}

		Varps.method4043();
		if (Client.rootInterface != -1) {
			GrandExchangeEvents.runIntfCloseListeners(Client.rootInterface, 1);
		}

	}

	@ObfuscatedName("kq")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;B)V",
		garbageValue = "1"
	)
	static void method823(String var0) {
		WorldMapManager.field327 = var0;

		try {
			String var1 = AbstractWorldMapIcon.client.getParameter(Integer.toString(18));
			String var2 = AbstractWorldMapIcon.client.getParameter(Integer.toString(13));
			String var3 = var1 + "settings=" + var0 + "; version=1; path=/; domain=" + var2;
			if (var0.length() == 0) {
				var3 = var3 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
			} else {
				var3 = var3 + "; Expires=" + class215.method4107(TaskHandler.currentTimeMillis() + 94608000000L) + "; Max-Age=" + 94608000L;
			}

			Client var4 = AbstractWorldMapIcon.client;
			String var5 = "document.cookie=\"" + var3 + "\"";
			JSObject.getWindow(var4).eval(var5);
		} catch (Throwable var6) {
		}

	}
}
