import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bf")
public class class65 extends RouteStrategy {
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lhz;"
	)
	@Export("ItemDefinition_archive")
	static AbstractArchive ItemDefinition_archive;
	@ObfuscatedName("ff")
	@ObfuscatedGetter(
		longValue = 1031701328747955581L
	)
	static long field586;
	@ObfuscatedName("lw")
	@ObfuscatedSignature(
		signature = "Lhp;"
	)
	@Export("mousedOverWidgetIf1")
	static Widget mousedOverWidgetIf1;

	class65() {
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(IIILfm;I)Z",
		garbageValue = "1325675955"
	)
	@Export("hasArrived")
	public boolean hasArrived(int var1, int var2, int var3, CollisionMap var4) {
		return var2 == super.approxDestinationX && var3 == super.approxDestinationY;
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "1096051399"
	)
	@Export("changeWorldSelectSorting")
	static void changeWorldSelectSorting(int var0, int var1) {
		int[] var2 = new int[4];
		int[] var3 = new int[4];
		var2[0] = var0;
		var3[0] = var1;
		int var4 = 1;

		for (int var5 = 0; var5 < 4; ++var5) {
			if (World.World_sortOption1[var5] != var0) {
				var2[var4] = World.World_sortOption1[var5];
				var3[var4] = World.World_sortOption2[var5];
				++var4;
			}
		}

		World.World_sortOption1 = var2;
		World.World_sortOption2 = var3;
		Tile.sortWorlds(ChatChannel.World_worlds, 0, ChatChannel.World_worlds.length - 1, World.World_sortOption1, World.World_sortOption2);
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "29"
	)
	static final int method1180() {
		return ViewportMouse.ViewportMouse_x;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Lbl;I)V",
		garbageValue = "-138729150"
	)
	@Export("changeWorld")
	static void changeWorld(World var0) {
		if (var0.isMembersOnly() != Client.isMembersWorld) {
			Client.isMembersWorld = var0.isMembersOnly();
			boolean var1 = var0.isMembersOnly();
			if (var1 != UrlRequester.ItemDefinition_inMembersWorld) {
				TileItemPile.method2700();
				UrlRequester.ItemDefinition_inMembersWorld = var1;
			}
		}

		NetFileRequest.worldHost = var0.host;
		Client.worldId = var0.id;
		Client.worldProperties = var0.properties;
		WorldMapRectangle.port1 = Client.gameBuild == 0 ? 43594 : var0.id + 40000;
		FloorDecoration.port2 = Client.gameBuild == 0 ? 443 : var0.id + 50000;
		SecureRandomCallable.port3 = WorldMapRectangle.port1;
	}

	@ObfuscatedName("fz")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-87"
	)
	static final void method1182() {
		Client.packetWriter.close();
		class1.method18();
		Player.scene.clear();

		for (int var0 = 0; var0 < 4; ++var0) {
			Client.collisionMaps[var0].clear();
		}

		System.gc();
		DevicePcmPlayerProvider.method793(2);
		Client.field857 = -1;
		Client.field858 = false;

		for (ObjectSound var1 = (ObjectSound)ObjectSound.objectSounds.last(); var1 != null; var1 = (ObjectSound)ObjectSound.objectSounds.previous()) {
			if (var1.stream1 != null) {
				IgnoreList.pcmStreamMixer.removeSubStream(var1.stream1);
				var1.stream1 = null;
			}

			if (var1.stream2 != null) {
				IgnoreList.pcmStreamMixer.removeSubStream(var1.stream2);
				var1.stream2 = null;
			}
		}

		ObjectSound.objectSounds.clear();
		FloorDecoration.updateGameState(10);
	}

	@ObfuscatedName("fa")
	@ObfuscatedSignature(
		signature = "(Lbu;I)V",
		garbageValue = "-554160740"
	)
	static final void method1178(Actor var0) {
		if (var0.field971 != 0) {
			if (var0.targetIndex != -1) {
				Object var1 = null;
				if (var0.targetIndex < 32768) {
					var1 = Client.npcs[var0.targetIndex];
				} else if (var0.targetIndex >= 32768) {
					var1 = Client.players[var0.targetIndex - 32768];
				}

				if (var1 != null) {
					int var2 = var0.x - ((Actor)var1).x;
					int var3 = var0.y - ((Actor)var1).y;
					if (var2 != 0 || var3 != 0) {
						var0.orientation = (int)(Math.atan2((double)var2, (double)var3) * 325.949D) & 2047;
					}
				} else if (var0.false0) {
					var0.targetIndex = -1;
					var0.false0 = false;
				}
			}

			if (var0.field946 != -1 && (var0.pathLength == 0 || var0.field976 > 0)) {
				var0.orientation = var0.field946;
				var0.field946 = -1;
			}

			int var4 = var0.orientation - var0.rotation & 2047;
			if (var4 == 0 && var0.false0) {
				var0.targetIndex = -1;
				var0.false0 = false;
			}

			if (var4 != 0) {
				++var0.field970;
				boolean var6;
				if (var4 > 1024) {
					var0.rotation -= var0.field971;
					var6 = true;
					if (var4 < var0.field971 || var4 > 2048 - var0.field971) {
						var0.rotation = var0.orientation;
						var6 = false;
					}

					if (var0.movementSequence == var0.readySequence && (var0.field970 > 25 || var6)) {
						if (var0.turnLeftSequence != -1) {
							var0.movementSequence = var0.turnLeftSequence;
						} else {
							var0.movementSequence = var0.walkSequence;
						}
					}
				} else {
					var0.rotation += var0.field971;
					var6 = true;
					if (var4 < var0.field971 || var4 > 2048 - var0.field971) {
						var0.rotation = var0.orientation;
						var6 = false;
					}

					if (var0.readySequence == var0.movementSequence && (var0.field970 > 25 || var6)) {
						if (var0.turnRightSequence != -1) {
							var0.movementSequence = var0.turnRightSequence;
						} else {
							var0.movementSequence = var0.walkSequence;
						}
					}
				}

				var0.rotation &= 2047;
			} else {
				var0.field970 = 0;
			}

		}
	}

	@ObfuscatedName("il")
	@ObfuscatedSignature(
		signature = "(Lii;IIII)V",
		garbageValue = "-973844145"
	)
	@Export("addNpcToMenu")
	static final void addNpcToMenu(NPCDefinition var0, int var1, int var2, int var3) {
		if (Client.menuOptionsCount < 400) {
			if (var0.transforms != null) {
				var0 = var0.transform();
			}

			if (var0 != null) {
				if (var0.isInteractable) {
					if (!var0.isFollower || Client.followerIndex == var1) {
						String var4 = var0.name;
						if (var0.combatLevel != 0) {
							var4 = var4 + class225.method4037(var0.combatLevel, WorldMapIcon_1.localPlayer.combatLevel) + " " + " (" + "level-" + var0.combatLevel + ")";
						}

						if (var0.isFollower && Client.followerOpsLowPriority) {
							WorldMapData_0.insertMenuItemNoShift("Examine", class16.colorStartTag(16776960) + var4, 1003, var1, var2, var3);
						}

						if (Client.isItemSelected == 1) {
							WorldMapData_0.insertMenuItemNoShift("Use", Client.selectedItemName + " " + "->" + " " + class16.colorStartTag(16776960) + var4, 7, var1, var2, var3);
						} else if (Client.isSpellSelected) {
							if ((WorldMapSectionType.selectedSpellFlags & 2) == 2) {
								WorldMapData_0.insertMenuItemNoShift(Client.selectedSpellActionName, Client.selectedSpellName + " " + "->" + " " + class16.colorStartTag(16776960) + var4, 8, var1, var2, var3);
							}
						} else {
							int var5 = var0.isFollower && Client.followerOpsLowPriority ? 2000 : 0;
							String[] var6 = var0.actions;
							int var7;
							int var8;
							if (var6 != null) {
								for (var7 = 4; var7 >= 0; --var7) {
									if (var6[var7] != null && !var6[var7].equalsIgnoreCase("Attack")) {
										var8 = 0;
										if (var7 == 0) {
											var8 = var5 + 9;
										}

										if (var7 == 1) {
											var8 = var5 + 10;
										}

										if (var7 == 2) {
											var8 = var5 + 11;
										}

										if (var7 == 3) {
											var8 = var5 + 12;
										}

										if (var7 == 4) {
											var8 = var5 + 13;
										}

										WorldMapData_0.insertMenuItemNoShift(var6[var7], class16.colorStartTag(16776960) + var4, var8, var1, var2, var3);
									}
								}
							}

							if (var6 != null) {
								for (var7 = 4; var7 >= 0; --var7) {
									if (var6[var7] != null && var6[var7].equalsIgnoreCase("Attack")) {
										short var9 = 0;
										if (AttackOption.AttackOption_hidden != Client.npcAttackOption) {
											if (AttackOption.AttackOption_alwaysRightClick == Client.npcAttackOption || Client.npcAttackOption == AttackOption.AttackOption_dependsOnCombatLevels && var0.combatLevel > WorldMapIcon_1.localPlayer.combatLevel) {
												var9 = 2000;
											}

											var8 = 0;
											if (var7 == 0) {
												var8 = var9 + 9;
											}

											if (var7 == 1) {
												var8 = var9 + 10;
											}

											if (var7 == 2) {
												var8 = var9 + 11;
											}

											if (var7 == 3) {
												var8 = var9 + 12;
											}

											if (var7 == 4) {
												var8 = var9 + 13;
											}

											WorldMapData_0.insertMenuItemNoShift(var6[var7], class16.colorStartTag(16776960) + var4, var8, var1, var2, var3);
										}
									}
								}
							}

							if (!var0.isFollower || !Client.followerOpsLowPriority) {
								WorldMapData_0.insertMenuItemNoShift("Examine", class16.colorStartTag(16776960) + var4, 1003, var1, var2, var3);
							}
						}

					}
				}
			}
		}
	}
}
