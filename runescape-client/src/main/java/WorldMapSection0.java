import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("y")
@Implements("WorldMapSection0")
public class WorldMapSection0 implements WorldMapSection {
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -2146402029
	)
	@Export("oldZ")
	int oldZ;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -2085039341
	)
	@Export("newZ")
	int newZ;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = 555505141
	)
	@Export("oldX")
	int oldX;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -1856751623
	)
	@Export("oldY")
	int oldY;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -2086851217
	)
	@Export("newX")
	int newX;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 1346820565
	)
	@Export("newY")
	int newY;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -1459523587
	)
	@Export("oldChunkXLow")
	int oldChunkXLow;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -954702965
	)
	@Export("oldChunkYLow")
	int oldChunkYLow;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -1622063887
	)
	@Export("oldChunkXHigh")
	int oldChunkXHigh;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -2070491231
	)
	@Export("oldChunkYHigh")
	int oldChunkYHigh;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 1112408651
	)
	@Export("newChunkXLow")
	int newChunkXLow;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = -749966597
	)
	@Export("newChunkYLow")
	int newChunkYLow;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -1079927535
	)
	@Export("newChunkXHigh")
	int newChunkXHigh;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 524547303
	)
	@Export("newChunkYHigh")
	int newChunkYHigh;

	WorldMapSection0() {
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Lae;I)V",
		garbageValue = "-1034100543"
	)
	@Export("expandBounds")
	public void expandBounds(WorldMapArea var1) {
		if (var1.regionLowX > this.newX) {
			var1.regionLowX = this.newX;
		}

		if (var1.regionHighX < this.newX) {
			var1.regionHighX = this.newX;
		}

		if (var1.regionLowY > this.newY) {
			var1.regionLowY = this.newY;
		}

		if (var1.regionHighY < this.newY) {
			var1.regionHighY = this.newY;
		}

	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(IIIB)Z",
		garbageValue = "-110"
	)
	@Export("containsCoord")
	public boolean containsCoord(int var1, int var2, int var3) {
		if (var1 >= this.oldZ && var1 < this.oldZ + this.newZ) {
			return var2 >= (this.oldX << 6) + (this.oldChunkXLow << 3) && var2 <= (this.oldX << 6) + (this.oldChunkXHigh << 3) + 7 && var3 >= (this.oldY << 6) + (this.oldChunkYLow << 3) && var3 <= (this.oldY << 6) + (this.oldChunkYHigh << 3) + 7;
		} else {
			return false;
		}
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(IIB)Z",
		garbageValue = "37"
	)
	@Export("containsPosition")
	public boolean containsPosition(int var1, int var2) {
		return var1 >= (this.newX << 6) + (this.newChunkXLow << 3) && var1 <= (this.newX << 6) + (this.newChunkXHigh << 3) + 7 && var2 >= (this.newY << 6) + (this.newChunkYLow << 3) && var2 <= (this.newY << 6) + (this.newChunkYHigh << 3) + 7;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(IIII)[I",
		garbageValue = "-96920779"
	)
	@Export("getBorderTileLengths")
	public int[] getBorderTileLengths(int var1, int var2, int var3) {
		if (!this.containsCoord(var1, var2, var3)) {
			return null;
		} else {
			int[] var4 = new int[]{this.newX * 64 - this.oldX * 64 + var2 + (this.newChunkXLow * 8 - this.oldChunkXLow * 8), var3 + (this.newY * 64 - this.oldY * 64) + (this.newChunkYLow * 8 - this.oldChunkYLow * 8)};
			return var4;
		}
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(III)Lhj;",
		garbageValue = "911083222"
	)
	@Export("coord")
	public Coord coord(int var1, int var2) {
		if (!this.containsPosition(var1, var2)) {
			return null;
		} else {
			int var3 = this.oldX * 64 - this.newX * 64 + (this.oldChunkXLow * 8 - this.newChunkXLow * 8) + var1;
			int var4 = this.oldY * 64 - this.newY * 64 + var2 + (this.oldChunkYLow * 8 - this.newChunkYLow * 8);
			return new Coord(this.oldZ, var3, var4);
		}
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(Lkp;B)V",
		garbageValue = "76"
	)
	@Export("read")
	public void read(Buffer var1) {
		this.oldZ = var1.readUnsignedByte();
		this.newZ = var1.readUnsignedByte();
		this.oldX = var1.readUnsignedShort();
		this.oldChunkXLow = var1.readUnsignedByte();
		this.oldChunkXHigh = var1.readUnsignedByte();
		this.oldY = var1.readUnsignedShort();
		this.oldChunkYLow = var1.readUnsignedByte();
		this.oldChunkYHigh = var1.readUnsignedByte();
		this.newX = var1.readUnsignedShort();
		this.newChunkXLow = var1.readUnsignedByte();
		this.newChunkXHigh = var1.readUnsignedByte();
		this.newY = var1.readUnsignedShort();
		this.newChunkYLow = var1.readUnsignedByte();
		this.newChunkYHigh = var1.readUnsignedByte();
		this.postRead();
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-127"
	)
	@Export("postRead")
	void postRead() {
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "([Lgq;IB)Lgq;",
		garbageValue = "-32"
	)
	@Export("findEnumerated")
	public static Enumerated findEnumerated(Enumerated[] var0, int var1) {
		Enumerated[] var2 = var0;

		for (int var3 = 0; var3 < var2.length; ++var3) {
			Enumerated var4 = var2[var3];
			if (var1 == var4.rsOrdinal()) {
				return var4;
			}
		}

		return null;
	}

	@ObfuscatedName("ha")
	@ObfuscatedSignature(
		signature = "(IIIIIIIS)V",
		garbageValue = "6328"
	)
	@Export("addPendingSpawnToScene")
	static final void addPendingSpawnToScene(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
		if (var2 >= 1 && var3 >= 1 && var2 <= 102 && var3 <= 102) {
			if (Client.isLowDetail && var0 != Clock.Client_plane) {
				return;
			}

			long var7 = 0L;
			boolean var9 = true;
			boolean var10 = false;
			boolean var11 = false;
			if (var1 == 0) {
				var7 = ServerBuild.scene.getBoundaryObjectTag(var0, var2, var3);
			}

			if (var1 == 1) {
				var7 = ServerBuild.scene.getWallDecorationTag(var0, var2, var3);
			}

			if (var1 == 2) {
				var7 = ServerBuild.scene.getGameObjectTag(var0, var2, var3);
			}

			if (var1 == 3) {
				var7 = ServerBuild.scene.getFloorDecorationTag(var0, var2, var3);
			}

			int var12;
			if (var7 != 0L) {
				var12 = ServerBuild.scene.getObjectFlags(var0, var2, var3, var7);
				int var14 = GrandExchangeEvents.Entity_unpackID(var7);
				int var15 = var12 & 31;
				int var16 = var12 >> 6 & 3;
				ObjectDefinition var13;
				if (var1 == 0) {
					ServerBuild.scene.removeBoundaryObject(var0, var2, var3);
					var13 = Occluder.getObjectDefinition(var14);
					if (var13.interactType != 0) {
						Client.collisionMaps[var0].method3621(var2, var3, var15, var16, var13.boolean1);
					}
				}

				if (var1 == 1) {
					ServerBuild.scene.removeWallDecoration(var0, var2, var3);
				}

				if (var1 == 2) {
					ServerBuild.scene.removeGameObject(var0, var2, var3);
					var13 = Occluder.getObjectDefinition(var14);
					if (var2 + var13.sizeX > 103 || var3 + var13.sizeX > 103 || var2 + var13.sizeY > 103 || var3 + var13.sizeY > 103) {
						return;
					}

					if (var13.interactType != 0) {
						Client.collisionMaps[var0].setFlagOffNonSquare(var2, var3, var13.sizeX, var13.sizeY, var16, var13.boolean1);
					}
				}

				if (var1 == 3) {
					ServerBuild.scene.removeFloorDecoration(var0, var2, var3);
					var13 = Occluder.getObjectDefinition(var14);
					if (var13.interactType == 1) {
						Client.collisionMaps[var0].method3624(var2, var3);
					}
				}
			}

			if (var4 >= 0) {
				var12 = var0;
				if (var0 < 3 && (Tiles.Tiles_renderFlags[1][var2][var3] & 2) == 2) {
					var12 = var0 + 1;
				}

				ArchiveLoader.method1168(var0, var12, var2, var3, var4, var5, var6, ServerBuild.scene, Client.collisionMaps[var0]);
			}
		}

	}

	@ObfuscatedName("ie")
	@ObfuscatedSignature(
		signature = "(IIIII)V",
		garbageValue = "683461450"
	)
	@Export("addSceneMenuOptions")
	static final void addSceneMenuOptions(int var0, int var1, int var2, int var3) {
		if (Client.isItemSelected == 0 && !Client.isSpellSelected) {
			GraphicsObject.insertMenuItemNoShift("Walk here", "", 23, 0, var0 - var2, var1 - var3);
		}

		long var4 = -1L;
		long var6 = -1L;
		int var8 = 0;

		while (true) {
			int var10 = ViewportMouse.ViewportMouse_entityCount;
			if (var8 >= var10) {
				if (var4 != -1L) {
					var8 = GrandExchangeEvent.method96(var4);
					int var9 = class14.method169(var4);
					Player var25 = Client.players[Client.combatTargetPlayerIndex];
					class191.addPlayerToMenu(var25, Client.combatTargetPlayerIndex, var8, var9);
				}

				return;
			}

			long var11 = VertexNormal.method3063(var8);
			if (var11 != var6) {
				label324: {
					var6 = var11;
					int var13 = GrandExchangeOffer.method128(var8);
					int var14 = class43.method816(var8);
					int var15 = Tile.method2926(ViewportMouse.ViewportMouse_entityTags[var8]);
					int var17 = GrandExchangeEvents.Entity_unpackID(ViewportMouse.ViewportMouse_entityTags[var8]);
					int var18 = var17;
					if (var15 == 2 && ServerBuild.scene.getObjectFlags(Clock.Client_plane, var13, var14, var11) >= 0) {
						ObjectDefinition var19 = Occluder.getObjectDefinition(var17);
						if (var19.transforms != null) {
							var19 = var19.transform();
						}

						if (var19 == null) {
							break label324;
						}

						if (Client.isItemSelected == 1) {
							GraphicsObject.insertMenuItemNoShift("Use", Client.selectedItemName + " " + "->" + " " + PacketWriter.colorStartTag(65535) + var19.name, 1, var17, var13, var14);
						} else if (Client.isSpellSelected) {
							if ((NetSocket.selectedSpellFlags & 4) == 4) {
								GraphicsObject.insertMenuItemNoShift(Client.selectedSpellActionName, Client.selectedSpellName + " " + "->" + " " + PacketWriter.colorStartTag(65535) + var19.name, 2, var17, var13, var14);
							}
						} else {
							String[] var20 = var19.actions;
							if (var20 != null) {
								for (int var21 = 4; var21 >= 0; --var21) {
									if (var20[var21] != null) {
										short var22 = 0;
										if (var21 == 0) {
											var22 = 3;
										}

										if (var21 == 1) {
											var22 = 4;
										}

										if (var21 == 2) {
											var22 = 5;
										}

										if (var21 == 3) {
											var22 = 6;
										}

										if (var21 == 4) {
											var22 = 1001;
										}

										GraphicsObject.insertMenuItemNoShift(var20[var21], PacketWriter.colorStartTag(65535) + var19.name, var22, var18, var13, var14);
									}
								}
							}

							GraphicsObject.insertMenuItemNoShift("Examine", PacketWriter.colorStartTag(65535) + var19.name, 1002, var19.id, var13, var14);
						}
					}

					Player var23;
					NPC var26;
					int var27;
					int var34;
					int[] var35;
					if (var15 == 1) {
						NPC var30 = Client.npcs[var18];
						if (var30 == null) {
							break label324;
						}

						if (var30.definition.size == 1 && (var30.x & 127) == 64 && (var30.y & 127) == 64) {
							for (var27 = 0; var27 < Client.npcCount; ++var27) {
								var26 = Client.npcs[Client.npcIndices[var27]];
								if (var26 != null && var26 != var30 && var26.definition.size == 1 && var26.x == var30.x && var30.y == var26.y) {
									HorizontalAlignment.addNpcToMenu(var26.definition, Client.npcIndices[var27], var13, var14);
								}
							}

							var27 = Players.Players_count;
							var35 = Players.Players_indices;

							for (var34 = 0; var34 < var27; ++var34) {
								var23 = Client.players[var35[var34]];
								if (var23 != null && var23.x == var30.x && var23.y == var30.y) {
									class191.addPlayerToMenu(var23, var35[var34], var13, var14);
								}
							}
						}

						HorizontalAlignment.addNpcToMenu(var30.definition, var18, var13, var14);
					}

					if (var15 == 0) {
						Player var31 = Client.players[var18];
						if (var31 == null) {
							break label324;
						}

						if ((var31.x & 127) == 64 && (var31.y & 127) == 64) {
							for (var27 = 0; var27 < Client.npcCount; ++var27) {
								var26 = Client.npcs[Client.npcIndices[var27]];
								if (var26 != null && var26.definition.size == 1 && var26.x == var31.x && var26.y == var31.y) {
									HorizontalAlignment.addNpcToMenu(var26.definition, Client.npcIndices[var27], var13, var14);
								}
							}

							var27 = Players.Players_count;
							var35 = Players.Players_indices;

							for (var34 = 0; var34 < var27; ++var34) {
								var23 = Client.players[var35[var34]];
								if (var23 != null && var31 != var23 && var23.x == var31.x && var31.y == var23.y) {
									class191.addPlayerToMenu(var23, var35[var34], var13, var14);
								}
							}
						}

						if (var18 != Client.combatTargetPlayerIndex) {
							class191.addPlayerToMenu(var31, var18, var13, var14);
						} else {
							var4 = var11;
						}
					}

					if (var15 == 3) {
						NodeDeque var33 = Client.groundItems[Clock.Client_plane][var13][var14];
						if (var33 != null) {
							for (TileItem var32 = (TileItem)var33.first(); var32 != null; var32 = (TileItem)var33.next()) {
								ItemDefinition var36 = HealthBarDefinition.ItemDefinition_get(var32.id);
								if (Client.isItemSelected == 1) {
									GraphicsObject.insertMenuItemNoShift("Use", Client.selectedItemName + " " + "->" + " " + PacketWriter.colorStartTag(16748608) + var36.name, 16, var32.id, var13, var14);
								} else if (Client.isSpellSelected) {
									if ((NetSocket.selectedSpellFlags & 1) == 1) {
										GraphicsObject.insertMenuItemNoShift(Client.selectedSpellActionName, Client.selectedSpellName + " " + "->" + " " + PacketWriter.colorStartTag(16748608) + var36.name, 17, var32.id, var13, var14);
									}
								} else {
									String[] var28 = var36.groundActions;

									for (int var29 = 4; var29 >= 0; --var29) {
										if (var28 != null && var28[var29] != null) {
											byte var24 = 0;
											if (var29 == 0) {
												var24 = 18;
											}

											if (var29 == 1) {
												var24 = 19;
											}

											if (var29 == 2) {
												var24 = 20;
											}

											if (var29 == 3) {
												var24 = 21;
											}

											if (var29 == 4) {
												var24 = 22;
											}

											GraphicsObject.insertMenuItemNoShift(var28[var29], PacketWriter.colorStartTag(16748608) + var36.name, var24, var32.id, var13, var14);
										} else if (var29 == 2) {
											GraphicsObject.insertMenuItemNoShift("Take", PacketWriter.colorStartTag(16748608) + var36.name, 20, var32.id, var13, var14);
										}
									}

									GraphicsObject.insertMenuItemNoShift("Examine", PacketWriter.colorStartTag(16748608) + var36.name, 1004, var32.id, var13, var14);
								}
							}
						}
					}
				}
			}

			++var8;
		}
	}

	@ObfuscatedName("jn")
	@ObfuscatedSignature(
		signature = "([Lhn;IB)V",
		garbageValue = "2"
	)
	@Export("runComponentCloseListeners")
	static final void runComponentCloseListeners(Widget[] var0, int var1) {
		for (int var2 = 0; var2 < var0.length; ++var2) {
			Widget var3 = var0[var2];
			if (var3 != null) {
				if (var3.type == 0) {
					if (var3.children != null) {
						runComponentCloseListeners(var3.children, var1);
					}

					InterfaceParent var4 = (InterfaceParent)Client.interfaceParents.get((long)var3.id);
					if (var4 != null) {
						class226.runIntfCloseListeners(var4.group, var1);
					}
				}

				ScriptEvent var5;
				if (var1 == 0 && var3.onDialogAbort != null) {
					var5 = new ScriptEvent();
					var5.widget = var3;
					var5.args = var3.onDialogAbort;
					class4.runScriptEvent(var5);
				}

				if (var1 == 1 && var3.onSubChange != null) {
					if (var3.childIndex >= 0) {
						Widget var6 = Varps.getWidget(var3.id);
						if (var6 == null || var6.children == null || var3.childIndex >= var6.children.length || var3 != var6.children[var3.childIndex]) {
							continue;
						}
					}

					var5 = new ScriptEvent();
					var5.widget = var3;
					var5.args = var3.onSubChange;
					class4.runScriptEvent(var5);
				}
			}
		}

	}
}
