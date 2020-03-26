import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ar")
@Implements("WorldMapRectangle")
public final class WorldMapRectangle {
	@ObfuscatedName("sw")
	@ObfuscatedSignature(
		signature = "Lin;"
	)
	public static class247 field222;
	@ObfuscatedName("rt")
	@ObfuscatedGetter(
		intValue = 396400765
	)
	static int field217;
	@ObfuscatedName("hj")
	@ObfuscatedGetter(
		intValue = 1285501421
	)
	@Export("cameraX")
	static int cameraX;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 2118227677
	)
	@Export("width")
	int width;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -245816907
	)
	@Export("height")
	int height;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -1773088179
	)
	@Export("x")
	int x;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -409358263
	)
	@Export("y")
	int y;
	// $FF: synthetic field
	@ObfuscatedSignature(
		signature = "Laj;"
	)
	final WorldMapManager this$0;

	@ObfuscatedSignature(
		signature = "(Laj;)V"
	)
	WorldMapRectangle(WorldMapManager var1) {
		this.this$0 = var1;
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "-1866970355"
	)
	public static int method388(int var0) {
		return var0 >> 11 & 63;
	}

	@ObfuscatedName("e")
	@Export("Entity_unpackID")
	public static int Entity_unpackID(long var0) {
		return (int)(var0 >>> 17 & 4294967295L);
	}

	@ObfuscatedName("gd")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "767205713"
	)
	static boolean method386() {
		return (Client.drawPlayerNames & 1) != 0;
	}

	@ObfuscatedName("in")
	@ObfuscatedSignature(
		signature = "(IIIII)V",
		garbageValue = "-1807339500"
	)
	@Export("addSceneMenuOptions")
	static final void addSceneMenuOptions(int var0, int var1, int var2, int var3) {
		if (Client.isItemSelected == 0 && !Client.isSpellSelected) {
			IgnoreList.insertMenuItemNoShift("Walk here", "", 23, 0, var0 - var2, var1 - var3);
		}

		long var4 = -1L;
		long var6 = -1L;

		int var8;
		for (var8 = 0; var8 < SecureRandomCallable.method1250(); ++var8) {
			long var9 = WorldMapEvent.method868(var8);
			if (var9 != var6) {
				var6 = var9;
				int var22 = PacketWriter.method2376(var8);
				int var12 = WorldMapSectionType.method347(var8);
				int var13 = class276.method5036(var8);
				int var14 = WorldMapIcon_1.method407(var8);
				if (var13 == 2 && GrandExchangeOfferWorldComparator.scene.getObjectFlags(ScriptEvent.Client_plane, var22, var12, var9) >= 0) {
					ObjectDefinition var15 = WorldMapSection2.getObjectDefinition(var14);
					if (var15.transforms != null) {
						var15 = var15.transform();
					}

					if (var15 == null) {
						continue;
					}

					if (Client.isItemSelected == 1) {
						IgnoreList.insertMenuItemNoShift("Use", Client.selectedItemName + " " + "->" + " " + class297.colorStartTag(65535) + var15.name, 1, var14, var22, var12);
					} else if (Client.isSpellSelected) {
						if ((AbstractWorldMapIcon.selectedSpellFlags & 4) == 4) {
							IgnoreList.insertMenuItemNoShift(Client.selectedSpellActionName, Client.selectedSpellName + " " + "->" + " " + class297.colorStartTag(65535) + var15.name, 2, var14, var22, var12);
						}
					} else {
						String[] var23 = var15.actions;
						if (var23 != null) {
							for (int var24 = 4; var24 >= 0; --var24) {
								if (var23[var24] != null) {
									short var18 = 0;
									if (var24 == 0) {
										var18 = 3;
									}

									if (var24 == 1) {
										var18 = 4;
									}

									if (var24 == 2) {
										var18 = 5;
									}

									if (var24 == 3) {
										var18 = 6;
									}

									if (var24 == 4) {
										var18 = 1001;
									}

									IgnoreList.insertMenuItemNoShift(var23[var24], class297.colorStartTag(65535) + var15.name, var18, var14, var22, var12);
								}
							}
						}

						IgnoreList.insertMenuItemNoShift("Examine", class297.colorStartTag(65535) + var15.name, 1002, var15.id, var22, var12);
					}
				}

				int var16;
				NPC var17;
				Player var19;
				int[] var30;
				int var32;
				if (var13 == 1) {
					NPC var27 = Client.npcs[var14];
					if (var27 == null) {
						continue;
					}

					if (var27.definition.size == 1 && (var27.x & 127) == 64 && (var27.y & 127) == 64) {
						for (var16 = 0; var16 < Client.npcCount; ++var16) {
							var17 = Client.npcs[Client.npcIndices[var16]];
							if (var17 != null && var17 != var27 && var17.definition.size == 1 && var17.x == var27.x && var27.y == var17.y) {
								WorldMapRegion.addNpcToMenu(var17.definition, Client.npcIndices[var16], var22, var12);
							}
						}

						var16 = Players.Players_count;
						var30 = Players.Players_indices;

						for (var32 = 0; var32 < var16; ++var32) {
							var19 = Client.players[var30[var32]];
							if (var19 != null && var19.x == var27.x && var27.y == var19.y) {
								InterfaceParent.addPlayerToMenu(var19, var30[var32], var22, var12);
							}
						}
					}

					WorldMapRegion.addNpcToMenu(var27.definition, var14, var22, var12);
				}

				if (var13 == 0) {
					Player var28 = Client.players[var14];
					if (var28 == null) {
						continue;
					}

					if ((var28.x & 127) == 64 && (var28.y & 127) == 64) {
						for (var16 = 0; var16 < Client.npcCount; ++var16) {
							var17 = Client.npcs[Client.npcIndices[var16]];
							if (var17 != null && var17.definition.size == 1 && var17.x == var28.x && var28.y == var17.y) {
								WorldMapRegion.addNpcToMenu(var17.definition, Client.npcIndices[var16], var22, var12);
							}
						}

						var16 = Players.Players_count;
						var30 = Players.Players_indices;

						for (var32 = 0; var32 < var16; ++var32) {
							var19 = Client.players[var30[var32]];
							if (var19 != null && var28 != var19 && var19.x == var28.x && var19.y == var28.y) {
								InterfaceParent.addPlayerToMenu(var19, var30[var32], var22, var12);
							}
						}
					}

					if (var14 != Client.combatTargetPlayerIndex) {
						InterfaceParent.addPlayerToMenu(var28, var14, var22, var12);
					} else {
						var4 = var9;
					}
				}

				if (var13 == 3) {
					NodeDeque var29 = Client.groundItems[ScriptEvent.Client_plane][var22][var12];
					if (var29 != null) {
						for (TileItem var33 = (TileItem)var29.first(); var33 != null; var33 = (TileItem)var29.next()) {
							ItemDefinition var31 = AbstractWorldMapData.ItemDefinition_get(var33.id);
							if (Client.isItemSelected == 1) {
								IgnoreList.insertMenuItemNoShift("Use", Client.selectedItemName + " " + "->" + " " + class297.colorStartTag(16748608) + var31.name, 16, var33.id, var22, var12);
							} else if (Client.isSpellSelected) {
								if ((AbstractWorldMapIcon.selectedSpellFlags & 1) == 1) {
									IgnoreList.insertMenuItemNoShift(Client.selectedSpellActionName, Client.selectedSpellName + " " + "->" + " " + class297.colorStartTag(16748608) + var31.name, 17, var33.id, var22, var12);
								}
							} else {
								String[] var25 = var31.groundActions;

								for (int var26 = 4; var26 >= 0; --var26) {
									if (var25 != null && var25[var26] != null) {
										byte var20 = 0;
										if (var26 == 0) {
											var20 = 18;
										}

										if (var26 == 1) {
											var20 = 19;
										}

										if (var26 == 2) {
											var20 = 20;
										}

										if (var26 == 3) {
											var20 = 21;
										}

										if (var26 == 4) {
											var20 = 22;
										}

										IgnoreList.insertMenuItemNoShift(var25[var26], class297.colorStartTag(16748608) + var31.name, var20, var33.id, var22, var12);
									} else if (var26 == 2) {
										IgnoreList.insertMenuItemNoShift("Take", class297.colorStartTag(16748608) + var31.name, 20, var33.id, var22, var12);
									}
								}

								IgnoreList.insertMenuItemNoShift("Examine", class297.colorStartTag(16748608) + var31.name, 1004, var33.id, var22, var12);
							}
						}
					}
				}
			}
		}

		if (var4 != -1L) {
			var8 = (int)(var4 >>> 0 & 127L);
			int var10 = UserComparator9.method3500(var4);
			Player var11 = Client.players[Client.combatTargetPlayerIndex];
			InterfaceParent.addPlayerToMenu(var11, Client.combatTargetPlayerIndex, var8, var10);
		}

	}
}
