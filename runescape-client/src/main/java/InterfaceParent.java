import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bw")
@Implements("InterfaceParent")
public class InterfaceParent extends Node {
	@ObfuscatedName("pe")
	@Export("ClanChat_inClanChat")
	static boolean ClanChat_inClanChat;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 1880295191
	)
	@Export("group")
	int group;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 386890951
	)
	@Export("type")
	int type;
	@ObfuscatedName("t")
	boolean field538;

	InterfaceParent() {
		this.field538 = false;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Lkt;I)V",
		garbageValue = "-1718038251"
	)
	static final void method1123(PacketBuffer var0) {
		for (int var1 = 0; var1 < Players.Players_pendingUpdateCount; ++var1) {
			int var2 = Players.Players_pendingUpdateIndices[var1];
			Player var3 = Client.players[var2];
			int var4 = var0.readUnsignedByte();
			if ((var4 & 16) != 0) {
				var4 += var0.readUnsignedByte() << 8;
			}

			byte var5 = -1;
			int var6;
			if ((var4 & 512) != 0) {
				for (var6 = 0; var6 < 3; ++var6) {
					var3.actions[var6] = var0.readStringCp1252NullTerminated();
				}
			}

			if ((var4 & 2048) != 0) {
				var3.spotAnimation = var0.readUnsignedShort();
				var6 = var0.method5587();
				var3.heightOffset = var6 >> 16;
				var3.field957 = (var6 & 65535) + Client.cycle;
				var3.spotAnimationFrame = 0;
				var3.spotAnimationFrameCycle = 0;
				if (var3.field957 > Client.cycle) {
					var3.spotAnimationFrame = -1;
				}

				if (var3.spotAnimation == 65535) {
					var3.spotAnimation = -1;
				}
			}

			if ((var4 & 8) != 0) {
				var6 = var0.method5547();
				byte[] var7 = new byte[var6];
				Buffer var8 = new Buffer(var7);
				var0.readBytes(var7, 0, var6);
				Players.field1221[var2] = var8;
				var3.read(var8);
			}

			if ((var4 & 256) != 0) {
				var5 = var0.method5497();
			}

			if ((var4 & 1024) != 0) {
				Players.field1220[var2] = var0.readByte();
			}

			if ((var4 & 4096) != 0) {
				var3.field959 = var0.method5634();
				var3.field961 = var0.method5497();
				var3.field960 = var0.method5634();
				var3.field962 = var0.method5498();
				var3.field963 = var0.method5514() + Client.cycle;
				var3.field964 = var0.method5459() + Client.cycle;
				var3.field965 = var0.method5514();
				if (var3.field607) {
					var3.field959 += var3.tileX;
					var3.field961 += var3.tileY;
					var3.field960 += var3.tileX;
					var3.field962 += var3.tileY;
					var3.pathLength = 0;
				} else {
					var3.field959 += var3.pathX[0];
					var3.field961 += var3.pathY[0];
					var3.field960 += var3.pathX[0];
					var3.field962 += var3.pathY[0];
					var3.pathLength = 1;
				}

				var3.field969 = 0;
			}

			if ((var4 & 32) != 0) {
				var3.targetIndex = var0.method5514();
				if (var3.targetIndex == 65535) {
					var3.targetIndex = -1;
				}
			}

			int var14;
			if ((var4 & 64) != 0) {
				var6 = var0.method5459();
				if (var6 == 65535) {
					var6 = -1;
				}

				var14 = var0.method5494();
				FloorUnderlayDefinition.performPlayerAnimation(var3, var6, var14);
			}

			if ((var4 & 4) != 0) {
				var3.overheadText = var0.readStringCp1252NullTerminated();
				if (var3.overheadText.charAt(0) == '~') {
					var3.overheadText = var3.overheadText.substring(1);
					WorldMapCacheName.addGameMessage(2, var3.username.getName(), var3.overheadText);
				} else if (var3 == Varps.localPlayer) {
					WorldMapCacheName.addGameMessage(2, var3.username.getName(), var3.overheadText);
				}

				var3.isAutoChatting = false;
				var3.overheadTextColor = 0;
				var3.overheadTextEffect = 0;
				var3.overheadTextCyclesRemaining = 150;
			}

			if ((var4 & 2) != 0) {
				var3.field945 = var0.method5503();
				if (var3.pathLength == 0) {
					var3.orientation = var3.field945;
					var3.field945 = -1;
				}
			}

			int var9;
			int var10;
			int var13;
			if ((var4 & 128) != 0) {
				var6 = var0.readUnsignedByte();
				int var11;
				int var12;
				int var15;
				if (var6 > 0) {
					for (var14 = 0; var14 < var6; ++var14) {
						var9 = -1;
						var10 = -1;
						var11 = -1;
						var15 = var0.readUShortSmart();
						if (var15 == 32767) {
							var15 = var0.readUShortSmart();
							var10 = var0.readUShortSmart();
							var9 = var0.readUShortSmart();
							var11 = var0.readUShortSmart();
						} else if (var15 != 32766) {
							var10 = var0.readUShortSmart();
						} else {
							var15 = -1;
						}

						var12 = var0.readUShortSmart();
						var3.addHitSplat(var15, var10, var9, var11, Client.cycle, var12);
					}
				}

				var14 = var0.method5494();
				if (var14 > 0) {
					for (var15 = 0; var15 < var14; ++var15) {
						var9 = var0.readUShortSmart();
						var10 = var0.readUShortSmart();
						if (var10 != 32767) {
							var11 = var0.readUShortSmart();
							var12 = var0.readUnsignedByteNegate();
							var13 = var10 > 0 ? var0.readUnsignedByteNegate() : var12;
							var3.addHealthBar(var9, Client.cycle, var10, var11, var12, var13);
						} else {
							var3.removeHealthBar(var9);
						}
					}
				}
			}

			if ((var4 & 1) != 0) {
				var6 = var0.readUnsignedShort();
				PlayerType var17 = (PlayerType)ServerPacket.findEnumerated(PlayerAppearance.PlayerType_values(), var0.method5494());
				boolean var20 = var0.readUnsignedByteNegate() == 1;
				var9 = var0.method5547();
				var10 = var0.offset;
				if (var3.username != null && var3.appearance != null) {
					boolean var19 = false;
					if (var17.isUser && class218.friendSystem.isIgnored(var3.username)) {
						var19 = true;
					}

					if (!var19 && Client.field735 == 0 && !var3.isHidden) {
						Players.field1231.offset = 0;
						var0.readBytes(Players.field1231.array, 0, var9);
						Players.field1231.offset = 0;
						String var16 = AbstractFont.escapeBrackets(PacketBufferNode.method3616(GrandExchangeOfferWorldComparator.method60(Players.field1231)));
						var3.overheadText = var16.trim();
						var3.overheadTextColor = var6 >> 8;
						var3.overheadTextEffect = var6 & 255;
						var3.overheadTextCyclesRemaining = 150;
						var3.isAutoChatting = var20;
						var3.field956 = var3 != Varps.localPlayer && var17.isUser && "" != Client.field778 && var16.toLowerCase().indexOf(Client.field778) == -1;
						if (var17.isPrivileged) {
							var13 = var20 ? 91 : 1;
						} else {
							var13 = var20 ? 90 : 2;
						}

						if (var17.modIcon != -1) {
							WorldMapCacheName.addGameMessage(var13, ArchiveDiskAction.method4133(var17.modIcon) + var3.username.getName(), var16);
						} else {
							WorldMapCacheName.addGameMessage(var13, var3.username.getName(), var16);
						}
					}
				}

				var0.offset = var10 + var9;
			}

			if (var3.field607) {
				if (var5 == 127) {
					var3.resetPath(var3.tileX, var3.tileY);
				} else {
					byte var18;
					if (var5 != -1) {
						var18 = var5;
					} else {
						var18 = Players.field1220[var2];
					}

					var3.method1189(var3.tileX, var3.tileY, var18);
				}
			}
		}

	}

	@ObfuscatedName("in")
	@ObfuscatedSignature(
		signature = "(Lia;IIII)V",
		garbageValue = "-861885358"
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
						int var7;
						int var8;
						if (var0.combatLevel != 0) {
							var7 = var0.combatLevel;
							var8 = Varps.localPlayer.combatLevel;
							int var9 = var8 - var7;
							String var6;
							if (var9 < -9) {
								var6 = UserComparator7.colorStartTag(16711680);
							} else if (var9 < -6) {
								var6 = UserComparator7.colorStartTag(16723968);
							} else if (var9 < -3) {
								var6 = UserComparator7.colorStartTag(16740352);
							} else if (var9 < 0) {
								var6 = UserComparator7.colorStartTag(16756736);
							} else if (var9 > 9) {
								var6 = UserComparator7.colorStartTag(65280);
							} else if (var9 > 6) {
								var6 = UserComparator7.colorStartTag(4259584);
							} else if (var9 > 3) {
								var6 = UserComparator7.colorStartTag(8453888);
							} else if (var9 > 0) {
								var6 = UserComparator7.colorStartTag(12648192);
							} else {
								var6 = UserComparator7.colorStartTag(16776960);
							}

							var4 = var4 + var6 + " " + " (" + "level-" + var0.combatLevel + ")";
						}

						if (var0.isFollower && Client.followerOpsLowPriority) {
							FontName.insertMenuItemNoShift("Examine", UserComparator7.colorStartTag(16776960) + var4, 1003, var1, var2, var3);
						}

						if (Client.isItemSelected == 1) {
							FontName.insertMenuItemNoShift("Use", Client.selectedItemName + " " + "->" + " " + UserComparator7.colorStartTag(16776960) + var4, 7, var1, var2, var3);
						} else if (Client.isSpellSelected) {
							if ((BuddyRankComparator.selectedSpellFlags & 2) == 2) {
								FontName.insertMenuItemNoShift(Client.selectedSpellActionName, Client.selectedSpellName + " " + "->" + " " + UserComparator7.colorStartTag(16776960) + var4, 8, var1, var2, var3);
							}
						} else {
							int var10 = var0.isFollower && Client.followerOpsLowPriority ? 2000 : 0;
							String[] var11 = var0.actions;
							if (var11 != null) {
								for (var7 = 4; var7 >= 0; --var7) {
									if (var11[var7] != null && !var11[var7].equalsIgnoreCase("Attack")) {
										var8 = 0;
										if (var7 == 0) {
											var8 = var10 + 9;
										}

										if (var7 == 1) {
											var8 = var10 + 10;
										}

										if (var7 == 2) {
											var8 = var10 + 11;
										}

										if (var7 == 3) {
											var8 = var10 + 12;
										}

										if (var7 == 4) {
											var8 = var10 + 13;
										}

										FontName.insertMenuItemNoShift(var11[var7], UserComparator7.colorStartTag(16776960) + var4, var8, var1, var2, var3);
									}
								}
							}

							if (var11 != null) {
								for (var7 = 4; var7 >= 0; --var7) {
									if (var11[var7] != null && var11[var7].equalsIgnoreCase("Attack")) {
										short var12 = 0;
										if (AttackOption.AttackOption_hidden != Client.npcAttackOption) {
											if (AttackOption.AttackOption_alwaysRightClick == Client.npcAttackOption || AttackOption.AttackOption_dependsOnCombatLevels == Client.npcAttackOption && var0.combatLevel > Varps.localPlayer.combatLevel) {
												var12 = 2000;
											}

											var8 = 0;
											if (var7 == 0) {
												var8 = var12 + 9;
											}

											if (var7 == 1) {
												var8 = var12 + 10;
											}

											if (var7 == 2) {
												var8 = var12 + 11;
											}

											if (var7 == 3) {
												var8 = var12 + 12;
											}

											if (var7 == 4) {
												var8 = var12 + 13;
											}

											FontName.insertMenuItemNoShift(var11[var7], UserComparator7.colorStartTag(16776960) + var4, var8, var1, var2, var3);
										}
									}
								}
							}

							if (!var0.isFollower || !Client.followerOpsLowPriority) {
								FontName.insertMenuItemNoShift("Examine", UserComparator7.colorStartTag(16776960) + var4, 1003, var1, var2, var3);
							}
						}

					}
				}
			}
		}
	}
}
