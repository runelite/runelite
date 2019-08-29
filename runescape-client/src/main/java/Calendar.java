import java.util.TimeZone;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gz")
@Implements("Calendar")
public class Calendar {
	@ObfuscatedName("s")
	@Export("MONTH_NAMES_ENGLISH_GERMAN")
	static final String[][] MONTH_NAMES_ENGLISH_GERMAN;
	@ObfuscatedName("j")
	@Export("DAYS_OF_THE_WEEK")
	static final String[] DAYS_OF_THE_WEEK;
	@ObfuscatedName("i")
	@Export("Calendar_calendar")
	static java.util.Calendar Calendar_calendar;

	static {
		MONTH_NAMES_ENGLISH_GERMAN = new String[][]{{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}, {"Jan", "Feb", "Mär", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez"}, {"jan", "fév", "mars", "avr", "mai", "juin", "juil", "août", "sept", "oct", "nov", "déc"}, {"jan", "fev", "mar", "abr", "mai", "jun", "jul", "ago", "set", "out", "nov", "dez"}, {"jan", "feb", "mrt", "apr", "mei", "jun", "jul", "aug", "sep", "okt", "nov", "dec"}, {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}, {"ene", "feb", "mar", "abr", "may", "jun", "jul", "ago", "sep", "oct", "nov", "dic"}};
		DAYS_OF_THE_WEEK = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
		java.util.Calendar.getInstance();
		Calendar_calendar = java.util.Calendar.getInstance(TimeZone.getTimeZone("GMT"));
	}

	@ObfuscatedName("ip")
	@ObfuscatedSignature(
		signature = "(IIIII)V",
		garbageValue = "516952450"
	)
	@Export("addSceneMenuOptions")
	static final void addSceneMenuOptions(int var0, int var1, int var2, int var3) {
		if (Client.isItemSelected == 0 && !Client.isSpellSelected) {
			WorldMapData_0.insertMenuItemNoShift("Walk here", "", 23, 0, var0 - var2, var1 - var3);
		}

		long var4 = -1L;
		long var6 = -1L;
		int var8 = 0;

		while (true) {
			int var10 = ViewportMouse.ViewportMouse_entityCount;
			if (var8 >= var10) {
				if (-1L != var4) {
					var8 = (int)(var4 >>> 0 & 127L);
					var10 = (int)(var4 >>> 7 & 127L);
					Player var12 = Client.players[Client.combatTargetPlayerIndex];
					class51.addPlayerToMenu(var12, Client.combatTargetPlayerIndex, var8, var10);
				}

				return;
			}

			long var27 = ViewportMouse.ViewportMouse_entityTags[var8];
			if (var27 != var6) {
				label319: {
					var6 = var27;
					int var15 = class218.ViewportMouse_unpackX(var8);
					int var16 = GameObject.ViewportMouse_unpackY(var8);
					int var17 = class40.method729(ViewportMouse.ViewportMouse_entityTags[var8]);
					int var19 = BoundaryObject.Entity_unpackID(ViewportMouse.ViewportMouse_entityTags[var8]);
					int var20 = var19;
					if (var17 == 2 && Player.scene.getObjectFlags(ItemContainer.plane, var15, var16, var27) >= 0) {
						ObjectDefinition var21 = class215.getObjectDefinition(var19);
						if (var21.transforms != null) {
							var21 = var21.transform();
						}

						if (var21 == null) {
							break label319;
						}

						if (Client.isItemSelected == 1) {
							WorldMapData_0.insertMenuItemNoShift("Use", Client.selectedItemName + " " + "->" + " " + class16.colorStartTag(65535) + var21.name, 1, var19, var15, var16);
						} else if (Client.isSpellSelected) {
							if ((WorldMapSectionType.selectedSpellFlags & 4) == 4) {
								WorldMapData_0.insertMenuItemNoShift(Client.selectedSpellActionName, Client.selectedSpellName + " " + "->" + " " + class16.colorStartTag(65535) + var21.name, 2, var19, var15, var16);
							}
						} else {
							String[] var29 = var21.actions;
							if (var29 != null) {
								for (int var32 = 4; var32 >= 0; --var32) {
									if (var29[var32] != null) {
										short var24 = 0;
										if (var32 == 0) {
											var24 = 3;
										}

										if (var32 == 1) {
											var24 = 4;
										}

										if (var32 == 2) {
											var24 = 5;
										}

										if (var32 == 3) {
											var24 = 6;
										}

										if (var32 == 4) {
											var24 = 1001;
										}

										WorldMapData_0.insertMenuItemNoShift(var29[var32], class16.colorStartTag(65535) + var21.name, var24, var20, var15, var16);
									}
								}
							}

							WorldMapData_0.insertMenuItemNoShift("Examine", class16.colorStartTag(65535) + var21.name, 1002, var21.id, var15, var16);
						}
					}

					int var22;
					NPC var23;
					Player var25;
					int[] var36;
					int var38;
					if (var17 == 1) {
						NPC var33 = Client.npcs[var20];
						if (var33 == null) {
							break label319;
						}

						if (var33.definition.size == 1 && (var33.x & 127) == 64 && (var33.y & 127) == 64) {
							for (var22 = 0; var22 < Client.npcCount; ++var22) {
								var23 = Client.npcs[Client.npcIndices[var22]];
								if (var23 != null && var33 != var23 && var23.definition.size == 1 && var23.x == var33.x && var23.y == var33.y) {
									class65.addNpcToMenu(var23.definition, Client.npcIndices[var22], var15, var16);
								}
							}

							var22 = Players.Players_count;
							var36 = Players.Players_indices;

							for (var38 = 0; var38 < var22; ++var38) {
								var25 = Client.players[var36[var38]];
								if (var25 != null && var33.x == var25.x && var25.y == var33.y) {
									class51.addPlayerToMenu(var25, var36[var38], var15, var16);
								}
							}
						}

						class65.addNpcToMenu(var33.definition, var20, var15, var16);
					}

					if (var17 == 0) {
						Player var34 = Client.players[var20];
						if (var34 == null) {
							break label319;
						}

						if ((var34.x & 127) == 64 && (var34.y & 127) == 64) {
							for (var22 = 0; var22 < Client.npcCount; ++var22) {
								var23 = Client.npcs[Client.npcIndices[var22]];
								if (var23 != null && var23.definition.size == 1 && var34.x == var23.x && var34.y == var23.y) {
									class65.addNpcToMenu(var23.definition, Client.npcIndices[var22], var15, var16);
								}
							}

							var22 = Players.Players_count;
							var36 = Players.Players_indices;

							for (var38 = 0; var38 < var22; ++var38) {
								var25 = Client.players[var36[var38]];
								if (var25 != null && var25 != var34 && var25.x == var34.x && var34.y == var25.y) {
									class51.addPlayerToMenu(var25, var36[var38], var15, var16);
								}
							}
						}

						if (var20 != Client.combatTargetPlayerIndex) {
							class51.addPlayerToMenu(var34, var20, var15, var16);
						} else {
							var4 = var27;
						}
					}

					if (var17 == 3) {
						NodeDeque var35 = Client.groundItems[ItemContainer.plane][var15][var16];
						if (var35 != null) {
							for (TileItem var39 = (TileItem)var35.first(); var39 != null; var39 = (TileItem)var35.next()) {
								ItemDefinition var37 = WorldMapData_0.ItemDefinition_get(var39.id);
								if (Client.isItemSelected == 1) {
									WorldMapData_0.insertMenuItemNoShift("Use", Client.selectedItemName + " " + "->" + " " + class16.colorStartTag(16748608) + var37.name, 16, var39.id, var15, var16);
								} else if (Client.isSpellSelected) {
									if ((WorldMapSectionType.selectedSpellFlags & 1) == 1) {
										WorldMapData_0.insertMenuItemNoShift(Client.selectedSpellActionName, Client.selectedSpellName + " " + "->" + " " + class16.colorStartTag(16748608) + var37.name, 17, var39.id, var15, var16);
									}
								} else {
									String[] var30 = var37.groundActions;

									for (int var31 = 4; var31 >= 0; --var31) {
										if (var30 != null && var30[var31] != null) {
											byte var26 = 0;
											if (var31 == 0) {
												var26 = 18;
											}

											if (var31 == 1) {
												var26 = 19;
											}

											if (var31 == 2) {
												var26 = 20;
											}

											if (var31 == 3) {
												var26 = 21;
											}

											if (var31 == 4) {
												var26 = 22;
											}

											WorldMapData_0.insertMenuItemNoShift(var30[var31], class16.colorStartTag(16748608) + var37.name, var26, var39.id, var15, var16);
										} else if (var31 == 2) {
											WorldMapData_0.insertMenuItemNoShift("Take", class16.colorStartTag(16748608) + var37.name, 20, var39.id, var15, var16);
										}
									}

									WorldMapData_0.insertMenuItemNoShift("Examine", class16.colorStartTag(16748608) + var37.name, 1004, var39.id, var15, var16);
								}
							}
						}
					}
				}
			}

			++var8;
		}
	}
}
