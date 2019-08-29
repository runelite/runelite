import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iq")
@Implements("WorldMapElement")
public class WorldMapElement extends DualNode {
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "Lhz;"
	)
	@Export("WorldMapElement_archive")
	public static AbstractArchive WorldMapElement_archive;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "[Liq;"
	)
	@Export("WorldMapElement_cached")
	public static WorldMapElement[] WorldMapElement_cached;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -855102923
	)
	@Export("WorldMapElement_count")
	public static int WorldMapElement_count;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lep;"
	)
	@Export("WorldMapElement_cachedSprites")
	static EvictingDualNodeHashTable WorldMapElement_cachedSprites;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 1739070481
	)
	@Export("objectId")
	public final int objectId;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 1614113825
	)
	@Export("sprite1")
	public int sprite1;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -1422179555
	)
	@Export("sprite2")
	int sprite2;
	@ObfuscatedName("q")
	@Export("name")
	public String name;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -662975939
	)
	public int field3200;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -885213857
	)
	@Export("textSize")
	public int textSize;
	@ObfuscatedName("c")
	@Export("menuActions")
	public String[] menuActions;
	@ObfuscatedName("r")
	@Export("menuTargetName")
	public String menuTargetName;
	@ObfuscatedName("y")
	int[] field3201;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -614594231
	)
	int field3204;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -1806876145
	)
	int field3206;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -1042672469
	)
	int field3207;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -566631507
	)
	int field3208;
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Lib;"
	)
	@Export("horizontalAlignment")
	public HorizontalAlignment horizontalAlignment;
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "Lia;"
	)
	@Export("verticalAlignment")
	public VerticalAlignment verticalAlignment;
	@ObfuscatedName("w")
	int[] field3211;
	@ObfuscatedName("l")
	byte[] field3192;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = -481850779
	)
	@Export("category")
	public int category;

	static {
		WorldMapElement_cachedSprites = new EvictingDualNodeHashTable(256);
	}

	public WorldMapElement(int var1) {
		this.sprite1 = -1;
		this.sprite2 = -1;
		this.textSize = 0;
		this.menuActions = new String[5];
		this.field3204 = Integer.MAX_VALUE;
		this.field3206 = Integer.MAX_VALUE;
		this.field3207 = Integer.MIN_VALUE;
		this.field3208 = Integer.MIN_VALUE;
		this.horizontalAlignment = HorizontalAlignment.HorizontalAlignment_centered;
		this.verticalAlignment = VerticalAlignment.VerticalAlignment_centered;
		this.category = -1;
		this.objectId = var1;
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(Lky;I)V",
		garbageValue = "-46357468"
	)
	@Export("decode")
	public void decode(Buffer var1) {
		while (true) {
			int var2 = var1.readUnsignedByte();
			if (var2 == 0) {
				return;
			}

			this.decodeNext(var1, var2);
		}
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(Lky;II)V",
		garbageValue = "-1426592379"
	)
	@Export("decodeNext")
	void decodeNext(Buffer var1, int var2) {
		if (var2 == 1) {
			this.sprite1 = var1.method5602();
		} else if (var2 == 2) {
			this.sprite2 = var1.method5602();
		} else if (var2 == 3) {
			this.name = var1.readStringCp1252NullTerminated();
		} else if (var2 == 4) {
			this.field3200 = var1.readMedium();
		} else if (var2 == 5) {
			var1.readMedium();
		} else if (var2 == 6) {
			this.textSize = var1.readUnsignedByte();
		} else {
			int var3;
			if (var2 == 7) {
				var3 = var1.readUnsignedByte();
				if ((var3 & 1) == 0) {
				}

				if ((var3 & 2) == 2) {
				}
			} else if (var2 == 8) {
				var1.readUnsignedByte();
			} else if (var2 >= 10 && var2 <= 14) {
				this.menuActions[var2 - 10] = var1.readStringCp1252NullTerminated();
			} else if (var2 == 15) {
				var3 = var1.readUnsignedByte();
				this.field3201 = new int[var3 * 2];

				int var4;
				for (var4 = 0; var4 < var3 * 2; ++var4) {
					this.field3201[var4] = var1.readShort();
				}

				var1.readInt();
				var4 = var1.readUnsignedByte();
				this.field3211 = new int[var4];

				int var5;
				for (var5 = 0; var5 < this.field3211.length; ++var5) {
					this.field3211[var5] = var1.readInt();
				}

				this.field3192 = new byte[var3];

				for (var5 = 0; var5 < var3; ++var5) {
					this.field3192[var5] = var1.readByte();
				}
			} else if (var2 != 16) {
				if (var2 == 17) {
					this.menuTargetName = var1.readStringCp1252NullTerminated();
				} else if (var2 == 18) {
					var1.method5602();
				} else if (var2 == 19) {
					this.category = var1.readUnsignedShort();
				} else if (var2 == 21) {
					var1.readInt();
				} else if (var2 == 22) {
					var1.readInt();
				} else if (var2 == 23) {
					var1.readUnsignedByte();
					var1.readUnsignedByte();
					var1.readUnsignedByte();
				} else if (var2 == 24) {
					var1.readShort();
					var1.readShort();
				} else if (var2 == 25) {
					var1.method5602();
				} else if (var2 == 28) {
					var1.readUnsignedByte();
				} else if (var2 == 29) {
					HorizontalAlignment[] var6 = new HorizontalAlignment[]{HorizontalAlignment.field3435, HorizontalAlignment.HorizontalAlignment_centered, HorizontalAlignment.field3436};
					this.horizontalAlignment = (HorizontalAlignment)FriendSystem.findEnumerated(var6, var1.readUnsignedByte());
				} else if (var2 == 30) {
					this.verticalAlignment = (VerticalAlignment)FriendSystem.findEnumerated(FriendSystem.method1830(), var1.readUnsignedByte());
				}
			}
		}

	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "89"
	)
	public void method4290() {
		if (this.field3201 != null) {
			for (int var1 = 0; var1 < this.field3201.length; var1 += 2) {
				if (this.field3201[var1] < this.field3204) {
					this.field3204 = this.field3201[var1];
				} else if (this.field3201[var1] > this.field3207) {
					this.field3207 = this.field3201[var1];
				}

				if (this.field3201[var1 + 1] < this.field3206) {
					this.field3206 = this.field3201[var1 + 1];
				} else if (this.field3201[var1 + 1] > this.field3208) {
					this.field3208 = this.field3201[var1 + 1];
				}
			}
		}

	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(ZI)Lls;",
		garbageValue = "-944749033"
	)
	@Export("getSpriteBool")
	public Sprite getSpriteBool(boolean var1) {
		int var2 = this.sprite1;
		return this.getSprite(var2);
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(II)Lls;",
		garbageValue = "-995868610"
	)
	@Export("getSprite")
	Sprite getSprite(int var1) {
		if (var1 < 0) {
			return null;
		} else {
			Sprite var2 = (Sprite)WorldMapElement_cachedSprites.get((long)var1);
			if (var2 != null) {
				return var2;
			} else {
				var2 = TilePaint.SpriteBuffer_getSprite(WorldMapElement_archive, var1, 0);
				if (var2 != null) {
					WorldMapElement_cachedSprites.put(var2, (long)var1);
				}

				return var2;
			}
		}
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-2089637637"
	)
	@Export("getObjectId")
	public int getObjectId() {
		return this.objectId;
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(IB)Lhp;",
		garbageValue = "-72"
	)
	@Export("getWidget")
	public static Widget getWidget(int var0) {
		int var1 = var0 >> 16;
		int var2 = var0 & 65535;
		if (Widget.Widget_interfaceComponents[var1] == null || Widget.Widget_interfaceComponents[var1][var2] == null) {
			boolean var3 = Projectile.loadInterface(var1);
			if (!var3) {
				return null;
			}
		}

		return Widget.Widget_interfaceComponents[var1][var2];
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "([BB)V",
		garbageValue = "41"
	)
	@Export("ByteArrayPool_release")
	public static synchronized void ByteArrayPool_release(byte[] var0) {
		if (var0.length == 100 && ByteArrayPool.ByteArrayPool_smallCount < 1000) {
			ByteArrayPool.ByteArrayPool_small[++ByteArrayPool.ByteArrayPool_smallCount - 1] = var0;
		} else if (var0.length == 5000 && ByteArrayPool.ByteArrayPool_mediumCount < 250) {
			ByteArrayPool.ByteArrayPool_medium[++ByteArrayPool.ByteArrayPool_mediumCount - 1] = var0;
		} else if (var0.length == 30000 && ByteArrayPool.ByteArrayPool_largeCount < 50) {
			ByteArrayPool.ByteArrayPool_large[++ByteArrayPool.ByteArrayPool_largeCount - 1] = var0;
		} else {
			if (FaceNormal.ByteArrayPool_arrays != null) {
				for (int var1 = 0; var1 < UserComparator4.ByteArrayPool_alternativeSizes.length; ++var1) {
					if (var0.length == UserComparator4.ByteArrayPool_alternativeSizes[var1] && ByteArrayPool.ByteArrayPool_altSizeArrayCounts[var1] < FaceNormal.ByteArrayPool_arrays[var1].length) {
						FaceNormal.ByteArrayPool_arrays[var1][ByteArrayPool.ByteArrayPool_altSizeArrayCounts[var1]++] = var0;
						return;
					}
				}
			}

		}
	}

	@ObfuscatedName("gt")
	@ObfuscatedSignature(
		signature = "(IIIII)V",
		garbageValue = "-1612596971"
	)
	@Export("drawEntities")
	static final void drawEntities(int var0, int var1, int var2, int var3) {
		++Client.viewportDrawCount;
		if (WorldMapIcon_1.localPlayer.x >> 7 == Client.destinationX && WorldMapIcon_1.localPlayer.y >> 7 == Client.destinationY) {
			Client.destinationX = 0;
		}

		if (Client.renderSelf) {
			class80.addPlayerToScene(WorldMapIcon_1.localPlayer, false);
		}

		AbstractByteArrayCopier.method3878();
		KeyHandler.addNpcsToScene(true);
		InvDefinition.method4273();
		KeyHandler.addNpcsToScene(false);
		ModelData0.drawProjectiles();
		ServerPacket.method3555();
		LoginScreenAnimation.setViewportShape(var0, var1, var2, var3, true);
		var0 = Client.viewportOffsetX;
		var1 = Client.viewportOffsetY;
		var2 = Client.viewportWidth;
		var3 = Client.viewportHeight;
		Rasterizer2D.Rasterizer2D_setClip(var0, var1, var0 + var2, var3 + var1);
		Rasterizer3D.Rasterizer3D_setClipFromRasterizer2D();
		int var4;
		int var5;
		int var6;
		int var7;
		int var8;
		int var9;
		int var10;
		int var11;
		int var12;
		int var13;
		int var14;
		if (!Client.isCameraLocked) {
			var4 = Client.camAngleX;
			if (Client.field635 / 256 > var4) {
				var4 = Client.field635 / 256;
			}

			if (Client.field897[4] && Client.field694[4] + 128 > var4) {
				var4 = Client.field694[4] + 128;
			}

			var5 = Client.camAngleY & 2047;
			var6 = DynamicObject.oculusOrbFocalPointX;
			var7 = ScriptEvent.field559;
			var8 = FriendSystem.oculusOrbFocalPointY;
			var9 = var4 * 3 + 600;
			var10 = ArchiveLoader.method1100(var9, var3);
			var11 = 2048 - var4 & 2047;
			var12 = 2048 - var5 & 2047;
			var13 = 0;
			var14 = 0;
			int var15 = var10;
			int var16;
			int var17;
			int var18;
			if (var11 != 0) {
				var16 = Rasterizer3D.Rasterizer3D_sine[var11];
				var17 = Rasterizer3D.Rasterizer3D_cosine[var11];
				var18 = var17 * var14 - var10 * var16 >> 16;
				var15 = var17 * var10 + var16 * var14 >> 16;
				var14 = var18;
			}

			if (var12 != 0) {
				var16 = Rasterizer3D.Rasterizer3D_sine[var12];
				var17 = Rasterizer3D.Rasterizer3D_cosine[var12];
				var18 = var15 * var16 + var17 * var13 >> 16;
				var15 = var17 * var15 - var13 * var16 >> 16;
				var13 = var18;
			}

			WallDecoration.cameraX = var6 - var13;
			Coord.cameraY = var7 - var14;
			UserComparator7.cameraZ = var8 - var15;
			class43.cameraPitch = var4;
			class40.cameraYaw = var5;
			if (Client.oculusOrbState == 1 && Client.staffModLevel >= 2 && Client.cycle % 50 == 0 && (DynamicObject.oculusOrbFocalPointX >> 7 != WorldMapIcon_1.localPlayer.x >> 7 || FriendSystem.oculusOrbFocalPointY >> 7 != WorldMapIcon_1.localPlayer.y >> 7)) {
				var16 = WorldMapIcon_1.localPlayer.plane;
				var17 = PacketWriter.baseX * 64 + (DynamicObject.oculusOrbFocalPointX >> 7);
				var18 = RouteStrategy.baseY * 64 + (FriendSystem.oculusOrbFocalPointY >> 7);
				BoundaryObject.method3215(var17, var18, var16, true);
			}
		}

		if (!Client.isCameraLocked) {
			if (GrandExchangeOffer.clientPreferences.roofsHidden) {
				var5 = ItemContainer.plane;
			} else {
				label391: {
					var6 = 3;
					if (class43.cameraPitch < 310) {
						label389: {
							if (Client.oculusOrbState == 1) {
								var7 = DynamicObject.oculusOrbFocalPointX >> 7;
								var8 = FriendSystem.oculusOrbFocalPointY >> 7;
							} else {
								var7 = WorldMapIcon_1.localPlayer.x >> 7;
								var8 = WorldMapIcon_1.localPlayer.y >> 7;
							}

							var9 = WallDecoration.cameraX >> 7;
							var10 = UserComparator7.cameraZ >> 7;
							if (var9 >= 0 && var10 >= 0 && var9 < 104 && var10 < 104) {
								if (var7 >= 0 && var8 >= 0 && var7 < 104 && var8 < 104) {
									if ((Tiles.Tiles_renderFlags[ItemContainer.plane][var9][var10] & 4) != 0) {
										var6 = ItemContainer.plane;
									}

									if (var7 > var9) {
										var11 = var7 - var9;
									} else {
										var11 = var9 - var7;
									}

									if (var8 > var10) {
										var12 = var8 - var10;
									} else {
										var12 = var10 - var8;
									}

									if (var11 > var12) {
										var13 = var12 * 65536 / var11;
										var14 = 32768;

										while (true) {
											if (var9 == var7) {
												break label389;
											}

											if (var9 < var7) {
												++var9;
											} else if (var9 > var7) {
												--var9;
											}

											if ((Tiles.Tiles_renderFlags[ItemContainer.plane][var9][var10] & 4) != 0) {
												var6 = ItemContainer.plane;
											}

											var14 += var13;
											if (var14 >= 65536) {
												var14 -= 65536;
												if (var10 < var8) {
													++var10;
												} else if (var10 > var8) {
													--var10;
												}

												if ((Tiles.Tiles_renderFlags[ItemContainer.plane][var9][var10] & 4) != 0) {
													var6 = ItemContainer.plane;
												}
											}
										}
									} else {
										if (var12 > 0) {
											var13 = var11 * 65536 / var12;
											var14 = 32768;

											while (var10 != var8) {
												if (var10 < var8) {
													++var10;
												} else if (var10 > var8) {
													--var10;
												}

												if ((Tiles.Tiles_renderFlags[ItemContainer.plane][var9][var10] & 4) != 0) {
													var6 = ItemContainer.plane;
												}

												var14 += var13;
												if (var14 >= 65536) {
													var14 -= 65536;
													if (var9 < var7) {
														++var9;
													} else if (var9 > var7) {
														--var9;
													}

													if ((Tiles.Tiles_renderFlags[ItemContainer.plane][var9][var10] & 4) != 0) {
														var6 = ItemContainer.plane;
													}
												}
											}
										}
										break label389;
									}
								}

								var5 = ItemContainer.plane;
								break label391;
							}

							var5 = ItemContainer.plane;
							break label391;
						}
					}

					if (WorldMapIcon_1.localPlayer.x >= 0 && WorldMapIcon_1.localPlayer.y >= 0 && WorldMapIcon_1.localPlayer.x < 13312 && WorldMapIcon_1.localPlayer.y < 13312) {
						if ((Tiles.Tiles_renderFlags[ItemContainer.plane][WorldMapIcon_1.localPlayer.x >> 7][WorldMapIcon_1.localPlayer.y >> 7] & 4) != 0) {
							var6 = ItemContainer.plane;
						}

						var5 = var6;
					} else {
						var5 = ItemContainer.plane;
					}
				}
			}

			var4 = var5;
		} else {
			var4 = WorldMapData_0.getHighestVisiblePlane();
		}

		var5 = WallDecoration.cameraX;
		var6 = Coord.cameraY;
		var7 = UserComparator7.cameraZ;
		var8 = class43.cameraPitch;
		var9 = class40.cameraYaw;

		for (var10 = 0; var10 < 5; ++var10) {
			if (Client.field897[var10]) {
				var11 = (int)(Math.random() * (double)(Client.field869[var10] * 2 + 1) - (double)Client.field869[var10] + Math.sin((double)Client.field872[var10] * ((double)Client.field758[var10] / 100.0D)) * (double)Client.field694[var10]);
				if (var10 == 0) {
					WallDecoration.cameraX += var11;
				}

				if (var10 == 1) {
					Coord.cameraY += var11;
				}

				if (var10 == 2) {
					UserComparator7.cameraZ += var11;
				}

				if (var10 == 3) {
					class40.cameraYaw = var11 + class40.cameraYaw & 2047;
				}

				if (var10 == 4) {
					class43.cameraPitch += var11;
					if (class43.cameraPitch < 128) {
						class43.cameraPitch = 128;
					}

					if (class43.cameraPitch > 383) {
						class43.cameraPitch = 383;
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
			ItemDefinition.method4629(var10 - var0, var11 - var1);
		} else {
			ViewportMouse.ViewportMouse_isInViewport = false;
			ViewportMouse.ViewportMouse_entityCount = 0;
		}

		WorldMapSectionType.playPcmPlayers();
		Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var2, var3, 0);
		WorldMapSectionType.playPcmPlayers();
		var12 = Rasterizer3D.Rasterizer3D_zoom;
		Rasterizer3D.Rasterizer3D_zoom = Client.viewportZoom;
		Player.scene.draw(WallDecoration.cameraX, Coord.cameraY, UserComparator7.cameraZ, class43.cameraPitch, class40.cameraYaw, var4);
		Rasterizer3D.Rasterizer3D_zoom = var12;
		WorldMapSectionType.playPcmPlayers();
		Player.scene.clearTempGameObjects();
		ItemContainer.method1119(var0, var1, var2, var3);
		if (Client.hintArrowType == 2) {
			WorldMapAreaData.worldToScreen(Client.hintArrowSubX * 64 + (Client.hintArrowX - PacketWriter.baseX * 64 << 7), (Client.hintArrowY - RouteStrategy.baseY * 64 << 7) + Client.hintArrowSubY * 4096, Client.hintArrowHeight * 2);
			if (Client.viewportTempX > -1 && Client.cycle % 20 < 10) {
				WorldMapData_1.headIconHintSprites[0].drawTransBgAt(var0 + Client.viewportTempX - 12, Client.viewportTempY + var1 - 28);
			}
		}

		((TextureProvider)Rasterizer3D.Rasterizer3D_textureLoader).animate(Client.field879);
		MusicPatchNode.method3771(var0, var1, var2, var3);
		WallDecoration.cameraX = var5;
		Coord.cameraY = var6;
		UserComparator7.cameraZ = var7;
		class43.cameraPitch = var8;
		class40.cameraYaw = var9;
		if (Client.isLoading && class222.method4035(true, false) == 0) {
			Client.isLoading = false;
		}

		if (Client.isLoading) {
			Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var2, var3, 0);
			MusicPatch.drawLoadingMessage("Loading - please wait.", false);
		}

	}
}
