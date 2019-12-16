import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ao")
@Implements("AbstractWorldMapIcon")
public abstract class AbstractWorldMapIcon {
	@ObfuscatedName("bl")
	@ObfuscatedSignature(
		signature = "Lhq;"
	)
	static StudioGame field284;
	@ObfuscatedName("by")
	@ObfuscatedSignature(
		signature = "[Lli;"
	)
	@Export("worldSelectFlagSprites")
	static IndexedSprite[] worldSelectFlagSprites;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lht;"
	)
	@Export("coord2")
	public final Coord coord2;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lht;"
	)
	@Export("coord1")
	public final Coord coord1;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = 130683095
	)
	@Export("screenX")
	int screenX;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -170696787
	)
	@Export("screenY")
	int screenY;

	@ObfuscatedSignature(
		signature = "(Lht;Lht;)V"
	)
	AbstractWorldMapIcon(Coord var1, Coord var2) {
		this.coord1 = var1;
		this.coord2 = var2;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "63"
	)
	@Export("getElement")
	public abstract int getElement();

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(I)Law;",
		garbageValue = "-1801186977"
	)
	@Export("getLabel")
	abstract WorldMapLabel getLabel();

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-2033351231"
	)
	@Export("getSubWidth")
	abstract int getSubWidth();

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "1873129621"
	)
	@Export("getSubHeight")
	abstract int getSubHeight();

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(III)Z",
		garbageValue = "-1038278508"
	)
	@Export("fitsScreen")
	boolean fitsScreen(int var1, int var2) {
		if (this.elementFitsScreen(var1, var2)) {
			return true;
		} else {
			return this.labelFitsScreen(var1, var2);
		}
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "3"
	)
	@Export("hasValidElement")
	boolean hasValidElement() {
		return this.getElement() >= 0;
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		signature = "(III)Z",
		garbageValue = "-2033564740"
	)
	@Export("elementFitsScreen")
	boolean elementFitsScreen(int var1, int var2) {
		if (!this.hasValidElement()) {
			return false;
		} else {
			WorldMapElement var3 = GrandExchangeOfferUnitPriceComparator.WorldMapElement_get(this.getElement());
			int var4 = this.getSubWidth();
			int var5 = this.getSubHeight();
			switch(var3.horizontalAlignment.value) {
			case 0:
				if (var1 <= this.screenX - var4 || var1 > this.screenX) {
					return false;
				}
				break;
			case 1:
				if (var1 >= this.screenX && var1 < var4 + this.screenX) {
					break;
				}

				return false;
			case 2:
				if (var1 < this.screenX - var4 / 2 || var1 > var4 / 2 + this.screenX) {
					return false;
				}
			}

			switch(var3.verticalAlignment.value) {
			case 0:
				if (var2 <= this.screenY - var5 || var2 > this.screenY) {
					return false;
				}
				break;
			case 1:
				if (var2 < this.screenY - var5 / 2 || var2 > var5 / 2 + this.screenY) {
					return false;
				}
				break;
			case 2:
				if (var2 < this.screenY || var2 >= var5 + this.screenY) {
					return false;
				}
			}

			return true;
		}
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		signature = "(III)Z",
		garbageValue = "501002350"
	)
	@Export("labelFitsScreen")
	boolean labelFitsScreen(int var1, int var2) {
		WorldMapLabel var3 = this.getLabel();
		if (var3 == null) {
			return false;
		} else if (var1 >= this.screenX - var3.width / 2 && var1 <= var3.width / 2 + this.screenX) {
			return var2 >= this.screenY && var2 <= this.screenY + var3.height;
		} else {
			return false;
		}
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "([BI)V",
		garbageValue = "-1395894499"
	)
	@Export("SpriteBuffer_decode")
	static void SpriteBuffer_decode(byte[] var0) {
		Buffer var1 = new Buffer(var0);
		var1.offset = var0.length - 2;
		class325.SpriteBuffer_spriteCount = var1.readUnsignedShort();
		class325.SpriteBuffer_xOffsets = new int[class325.SpriteBuffer_spriteCount];
		class325.SpriteBuffer_yOffsets = new int[class325.SpriteBuffer_spriteCount];
		UserComparator1.SpriteBuffer_spriteWidths = new int[class325.SpriteBuffer_spriteCount];
		class325.SpriteBuffer_spriteHeights = new int[class325.SpriteBuffer_spriteCount];
		class290.SpriteBuffer_pixels = new byte[class325.SpriteBuffer_spriteCount][];
		var1.offset = var0.length - 7 - class325.SpriteBuffer_spriteCount * 8;
		class325.SpriteBuffer_spriteWidth = var1.readUnsignedShort();
		class325.SpriteBuffer_spriteHeight = var1.readUnsignedShort();
		int var2 = (var1.readUnsignedByte() & 255) + 1;

		int var3;
		for (var3 = 0; var3 < class325.SpriteBuffer_spriteCount; ++var3) {
			class325.SpriteBuffer_xOffsets[var3] = var1.readUnsignedShort();
		}

		for (var3 = 0; var3 < class325.SpriteBuffer_spriteCount; ++var3) {
			class325.SpriteBuffer_yOffsets[var3] = var1.readUnsignedShort();
		}

		for (var3 = 0; var3 < class325.SpriteBuffer_spriteCount; ++var3) {
			UserComparator1.SpriteBuffer_spriteWidths[var3] = var1.readUnsignedShort();
		}

		for (var3 = 0; var3 < class325.SpriteBuffer_spriteCount; ++var3) {
			class325.SpriteBuffer_spriteHeights[var3] = var1.readUnsignedShort();
		}

		var1.offset = var0.length - 7 - class325.SpriteBuffer_spriteCount * 8 - (var2 - 1) * 3;
		class268.SpriteBuffer_spritePalette = new int[var2];

		for (var3 = 1; var3 < var2; ++var3) {
			class268.SpriteBuffer_spritePalette[var3] = var1.readMedium();
			if (class268.SpriteBuffer_spritePalette[var3] == 0) {
				class268.SpriteBuffer_spritePalette[var3] = 1;
			}
		}

		var1.offset = 0;

		for (var3 = 0; var3 < class325.SpriteBuffer_spriteCount; ++var3) {
			int var4 = UserComparator1.SpriteBuffer_spriteWidths[var3];
			int var5 = class325.SpriteBuffer_spriteHeights[var3];
			int var6 = var4 * var5;
			byte[] var7 = new byte[var6];
			class290.SpriteBuffer_pixels[var3] = var7;
			int var8 = var1.readUnsignedByte();
			int var9;
			if (var8 == 0) {
				for (var9 = 0; var9 < var6; ++var9) {
					var7[var9] = var1.readByte();
				}
			} else if (var8 == 1) {
				for (var9 = 0; var9 < var4; ++var9) {
					for (int var10 = 0; var10 < var5; ++var10) {
						var7[var9 + var10 * var4] = var1.readByte();
					}
				}
			}
		}

	}

	@ObfuscatedName("fp")
	@ObfuscatedSignature(
		signature = "(ZI)V",
		garbageValue = "294564457"
	)
	static final void method612(boolean var0) {
		if (var0) {
			Client.field743 = Login.field1178 ? class160.field1984 : class160.field1986;
		} else {
			Client.field743 = Interpreter.clientPreferences.parameters.containsKey(UrlRequester.method3299(Login.Login_username)) ? class160.field1988 : class160.field1985;
		}

	}

	@ObfuscatedName("hw")
	@ObfuscatedSignature(
		signature = "(Lfi;I)V",
		garbageValue = "-432214243"
	)
	static final void method614(class179 var0) {
		PacketBuffer var1 = Client.packetWriter.packetBuffer;
		int var2;
		int var3;
		int var4;
		int var5;
		int var6;
		int var7;
		int var8;
		int var9;
		if (class179.field2293 == var0) {
			var2 = var1.method5628();
			var3 = (var2 >> 4 & 7) + class3.field7;
			var4 = (var2 & 7) + PlayerAppearance.field2520;
			var5 = var1.method5723();
			var6 = var1.readUnsignedByte();
			var7 = var6 >> 2;
			var8 = var6 & 3;
			var9 = Client.field689[var7];
			if (var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104) {
				class65.updatePendingSpawn(UrlRequest.Client_plane, var3, var4, var9, var5, var7, var8, 0, -1);
			}

		} else if (class179.field2290 == var0) {
			var2 = var1.method5582();
			var3 = var1.method5723();
			var4 = var1.readUnsignedByte();
			var5 = (var4 >> 4 & 7) + class3.field7;
			var6 = (var4 & 7) + PlayerAppearance.field2520;
			var7 = var1.method5675();
			if (var5 >= 0 && var6 >= 0 && var5 < 104 && var6 < 104) {
				var5 = var5 * 128 + 64;
				var6 = var6 * 128 + 64;
				GraphicsObject var43 = new GraphicsObject(var2, UrlRequest.Client_plane, var5, var6, ScriptEvent.getTileHeight(var5, var6, UrlRequest.Client_plane) - var7, var3, Client.cycle);
				Client.graphicsObjects.addFirst(var43);
			}

		} else {
			TileItem var32;
			if (class179.field2295 == var0) {
				var2 = var1.method5582();
				var3 = var1.method5583();
				var4 = var1.readUnsignedByte();
				var5 = (var4 >> 4 & 7) + class3.field7;
				var6 = (var4 & 7) + PlayerAppearance.field2520;
				if (var5 >= 0 && var6 >= 0 && var5 < 104 && var6 < 104) {
					var32 = new TileItem();
					var32.id = var2;
					var32.quantity = var3;
					if (Client.groundItems[UrlRequest.Client_plane][var5][var6] == null) {
						Client.groundItems[UrlRequest.Client_plane][var5][var6] = new NodeDeque();
					}

					Client.groundItems[UrlRequest.Client_plane][var5][var6].addFirst(var32);
					Skills.updateItemPile(var5, var6);
				}

			} else {
				int var10;
				if (class179.field2297 == var0) {
					var2 = var1.method5723();
					var3 = var1.method5675();
					var4 = var1.method5572();
					var5 = (var4 >> 4 & 7) + class3.field7;
					var6 = (var4 & 7) + PlayerAppearance.field2520;
					var7 = var1.method5675();
					var8 = var7 >> 4 & 15;
					var9 = var7 & 7;
					if (var5 >= 0 && var6 >= 0 && var5 < 104 && var6 < 104) {
						var10 = var8 + 1;
						if (Message.localPlayer.pathX[0] >= var5 - var10 && Message.localPlayer.pathX[0] <= var5 + var10 && Message.localPlayer.pathY[0] >= var6 - var10 && Message.localPlayer.pathY[0] <= var10 + var6 && Client.areaSoundEffectVolume != 0 && var9 > 0 && Client.soundEffectCount < 50) {
							Client.soundEffectIds[Client.soundEffectCount] = var2;
							Client.queuedSoundEffectLoops[Client.soundEffectCount] = var9;
							Client.queuedSoundEffectDelays[Client.soundEffectCount] = var3;
							Client.soundEffects[Client.soundEffectCount] = null;
							Client.soundLocations[Client.soundEffectCount] = var8 + (var6 << 8) + (var5 << 16);
							++Client.soundEffectCount;
						}
					}
				}

				int var14;
				int var39;
				if (class179.field2289 == var0) {
					var2 = var1.readUnsignedByte();
					var3 = var1.method5675() * 4;
					var4 = var1.method5723();
					byte var38 = var1.method5577();
					var6 = var1.method5723();
					var7 = var1.method5572();
					var8 = (var7 >> 4 & 7) + class3.field7;
					var9 = (var7 & 7) + PlayerAppearance.field2520;
					var10 = var1.method5584();
					var39 = var1.method5675();
					int var40 = var1.method5583();
					int var41 = var1.method5572() * 4;
					byte var42 = var1.method5577();
					var14 = var42 + var8;
					var5 = var38 + var9;
					if (var8 >= 0 && var9 >= 0 && var8 < 104 && var9 < 104 && var14 >= 0 && var5 >= 0 && var14 < 104 && var5 < 104 && var6 != 65535) {
						var8 = var8 * 128 + 64;
						var9 = var9 * 128 + 64;
						var14 = var14 * 128 + 64;
						var5 = var5 * 128 + 64;
						Projectile var15 = new Projectile(var6, UrlRequest.Client_plane, var8, var9, ScriptEvent.getTileHeight(var8, var9, UrlRequest.Client_plane) - var3, var40 + Client.cycle, var4 + Client.cycle, var2, var39, var10, var41);
						var15.setDestination(var14, var5, ScriptEvent.getTileHeight(var14, var5, UrlRequest.Client_plane) - var41, var40 + Client.cycle);
						Client.projectiles.addFirst(var15);
					}

				} else if (class179.field2296 == var0) {
					var2 = var1.method5572();
					var3 = var2 >> 2;
					var4 = var2 & 3;
					var5 = Client.field689[var3];
					var6 = var1.readUnsignedByte();
					var7 = (var6 >> 4 & 7) + class3.field7;
					var8 = (var6 & 7) + PlayerAppearance.field2520;
					if (var7 >= 0 && var8 >= 0 && var7 < 104 && var8 < 104) {
						class65.updatePendingSpawn(UrlRequest.Client_plane, var7, var8, var5, -1, var3, var4, 0, -1);
					}

				} else if (class179.field2294 == var0) {
					var2 = var1.method5583();
					var3 = var1.method5582();
					var4 = var1.method5723();
					var5 = var1.method5675();
					var6 = (var5 >> 4 & 7) + class3.field7;
					var7 = (var5 & 7) + PlayerAppearance.field2520;
					if (var6 >= 0 && var7 >= 0 && var6 < 104 && var7 < 104) {
						NodeDeque var31 = Client.groundItems[UrlRequest.Client_plane][var6][var7];
						if (var31 != null) {
							for (TileItem var33 = (TileItem)var31.last(); var33 != null; var33 = (TileItem)var31.previous()) {
								if ((var3 & 32767) == var33.id && var4 == var33.quantity) {
									var33.quantity = var2;
									break;
								}
							}

							Skills.updateItemPile(var6, var7);
						}
					}

				} else if (class179.field2291 == var0) {
					var2 = var1.method5628();
					var3 = (var2 >> 4 & 7) + class3.field7;
					var4 = (var2 & 7) + PlayerAppearance.field2520;
					var5 = var1.method5582();
					if (var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104) {
						NodeDeque var34 = Client.groundItems[UrlRequest.Client_plane][var3][var4];
						if (var34 != null) {
							for (var32 = (TileItem)var34.last(); var32 != null; var32 = (TileItem)var34.previous()) {
								if ((var5 & 32767) == var32.id) {
									var32.remove();
									break;
								}
							}

							if (var34.last() == null) {
								Client.groundItems[UrlRequest.Client_plane][var3][var4] = null;
							}

							Skills.updateItemPile(var3, var4);
						}
					}

				} else if (class179.field2292 == var0) {
					var2 = var1.method5675();
					var3 = (var2 >> 4 & 7) + class3.field7;
					var4 = (var2 & 7) + PlayerAppearance.field2520;
					var5 = var1.method5572();
					var6 = var5 >> 2;
					var7 = var5 & 3;
					var8 = Client.field689[var6];
					var9 = var1.method5582();
					if (var3 >= 0 && var4 >= 0 && var3 < 103 && var4 < 103) {
						if (var8 == 0) {
							BoundaryObject var35 = class14.scene.method3112(UrlRequest.Client_plane, var3, var4);
							if (var35 != null) {
								var39 = class2.Entity_unpackID(var35.tag);
								if (var6 == 2) {
									var35.entity1 = new DynamicObject(var39, 2, var7 + 4, UrlRequest.Client_plane, var3, var4, var9, false, var35.entity1);
									var35.entity2 = new DynamicObject(var39, 2, var7 + 1 & 3, UrlRequest.Client_plane, var3, var4, var9, false, var35.entity2);
								} else {
									var35.entity1 = new DynamicObject(var39, var6, var7, UrlRequest.Client_plane, var3, var4, var9, false, var35.entity1);
								}
							}
						}

						if (var8 == 1) {
							WallDecoration var44 = class14.scene.method3113(UrlRequest.Client_plane, var3, var4);
							if (var44 != null) {
								var39 = class2.Entity_unpackID(var44.tag);
								if (var6 != 4 && var6 != 5) {
									if (var6 == 6) {
										var44.entity1 = new DynamicObject(var39, 4, var7 + 4, UrlRequest.Client_plane, var3, var4, var9, false, var44.entity1);
									} else if (var6 == 7) {
										var44.entity1 = new DynamicObject(var39, 4, (var7 + 2 & 3) + 4, UrlRequest.Client_plane, var3, var4, var9, false, var44.entity1);
									} else if (var6 == 8) {
										var44.entity1 = new DynamicObject(var39, 4, var7 + 4, UrlRequest.Client_plane, var3, var4, var9, false, var44.entity1);
										var44.entity2 = new DynamicObject(var39, 4, (var7 + 2 & 3) + 4, UrlRequest.Client_plane, var3, var4, var9, false, var44.entity2);
									}
								} else {
									var44.entity1 = new DynamicObject(var39, 4, var7, UrlRequest.Client_plane, var3, var4, var9, false, var44.entity1);
								}
							}
						}

						if (var8 == 2) {
							GameObject var45 = class14.scene.method3114(UrlRequest.Client_plane, var3, var4);
							if (var6 == 11) {
								var6 = 10;
							}

							if (var45 != null) {
								var45.entity = new DynamicObject(class2.Entity_unpackID(var45.tag), var6, var7, UrlRequest.Client_plane, var3, var4, var9, false, var45.entity);
							}
						}

						if (var8 == 3) {
							FloorDecoration var46 = class14.scene.getFloorDecoration(UrlRequest.Client_plane, var3, var4);
							if (var46 != null) {
								var46.entity = new DynamicObject(class2.Entity_unpackID(var46.tag), 22, var7, UrlRequest.Client_plane, var3, var4, var9, false, var46.entity);
							}
						}
					}

				} else {
					if (class179.field2298 == var0) {
						byte var37 = var1.readByte();
						var3 = var1.method5583();
						var4 = var1.method5675();
						var5 = (var4 >> 4 & 7) + class3.field7;
						var6 = (var4 & 7) + PlayerAppearance.field2520;
						var7 = var1.method5572();
						var8 = var7 >> 2;
						var9 = var7 & 3;
						var10 = Client.field689[var8];
						byte var11 = var1.readByte();
						byte var12 = var1.method5576();
						byte var13 = var1.method5575();
						var14 = var1.readUnsignedShort();
						int var36 = var1.method5582();
						int var16 = var1.readUnsignedShort();
						Player var17;
						if (var36 == Client.localPlayerIndex) {
							var17 = Message.localPlayer;
						} else {
							var17 = Client.players[var36];
						}

						if (var17 != null) {
							ObjectDefinition var18 = Coord.getObjectDefinition(var16);
							int var19;
							int var20;
							if (var9 != 1 && var9 != 3) {
								var19 = var18.sizeX;
								var20 = var18.sizeY;
							} else {
								var19 = var18.sizeY;
								var20 = var18.sizeX;
							}

							int var21 = var5 + (var19 >> 1);
							int var22 = var5 + (var19 + 1 >> 1);
							int var23 = var6 + (var20 >> 1);
							int var24 = var6 + (var20 + 1 >> 1);
							int[][] var25 = Tiles.Tiles_heights[UrlRequest.Client_plane];
							int var26 = var25[var22][var24] + var25[var21][var23] + var25[var22][var23] + var25[var21][var24] >> 2;
							int var27 = (var5 << 7) + (var19 << 6);
							int var28 = (var6 << 7) + (var20 << 6);
							Model var29 = var18.getModel(var8, var9, var25, var27, var26, var28);
							if (var29 != null) {
								class65.updatePendingSpawn(UrlRequest.Client_plane, var5, var6, var10, -1, 0, 0, var3 + 1, var14 + 1);
								var17.animationCycleStart = var3 + Client.cycle;
								var17.animationCycleEnd = var14 + Client.cycle;
								var17.model0 = var29;
								var17.field601 = var5 * 128 + var19 * 64;
								var17.field603 = var6 * 128 + var20 * 64;
								var17.tileHeight2 = var26;
								byte var30;
								if (var13 > var11) {
									var30 = var13;
									var13 = var11;
									var11 = var30;
								}

								if (var37 > var12) {
									var30 = var37;
									var37 = var12;
									var12 = var30;
								}

								var17.field605 = var13 + var5;
								var17.field607 = var5 + var11;
								var17.field606 = var37 + var6;
								var17.field608 = var6 + var12;
							}
						}
					}

				}
			}
		}
	}

	@ObfuscatedName("is")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Ljava/lang/String;IIIIZI)V",
		garbageValue = "-1072362060"
	)
	@Export("insertMenuItem")
	static final void insertMenuItem(String var0, String var1, int var2, int var3, int var4, int var5, boolean var6) {
		if (!Client.isMenuOpen) {
			if (Client.menuOptionsCount < 500) {
				Client.menuActions[Client.menuOptionsCount] = var0;
				Client.menuTargets[Client.menuOptionsCount] = var1;
				Client.menuOpcodes[Client.menuOptionsCount] = var2;
				Client.menuIdentifiers[Client.menuOptionsCount] = var3;
				Client.menuArguments1[Client.menuOptionsCount] = var4;
				Client.menuArguments2[Client.menuOptionsCount] = var5;
				Client.menuShiftClick[Client.menuOptionsCount] = var6;
				++Client.menuOptionsCount;
			}

		}
	}
}
