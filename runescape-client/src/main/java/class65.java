import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ba")
public class class65 extends RouteStrategy {
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -248026877
	)
	@Export("Interpreter_stringStackSize")
	static int Interpreter_stringStackSize;
	@ObfuscatedName("fs")
	@ObfuscatedSignature(
		signature = "Lki;"
	)
	@Export("WorldMapElement_fonts")
	static Fonts WorldMapElement_fonts;

	class65() {
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(IIILfp;I)Z",
		garbageValue = "1339159810"
	)
	@Export("hasArrived")
	public boolean hasArrived(int var1, int var2, int var3, CollisionMap var4) {
		return var2 == super.approxDestinationX && var3 == super.approxDestinationY;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(Lhz;Lhz;ZLko;I)V",
		garbageValue = "1687966211"
	)
	public static void method1232(AbstractArchive var0, AbstractArchive var1, boolean var2, Font var3) {
		UserComparator10.ItemDefinition_archive = var0;
		ItemDefinition.ItemDefinition_modelArchive = var1;
		ItemDefinition.ItemDefinition_inMembersWorld = var2;
		ItemDefinition.ItemDefinition_fileCount = UserComparator10.ItemDefinition_archive.getGroupFileCount(10);
		ReflectionCheck.ItemDefinition_fontPlain11 = var3;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(Lkl;IB)V",
		garbageValue = "-16"
	)
	@Export("updatePlayers")
	static final void updatePlayers(PacketBuffer var0, int var1) {
		int var2 = var0.offset;
		Players.Players_pendingUpdateCount = 0;
		int var3 = 0;
		var0.importIndex();

		int var4;
		int var5;
		int var6;
		int var8;
		int var9;
		byte[] var10000;
		for (var4 = 0; var4 < Players.Players_count; ++var4) {
			var5 = Players.Players_indices[var4];
			if ((Players.field1230[var5] & 1) == 0) {
				if (var3 > 0) {
					--var3;
					var10000 = Players.field1230;
					var10000[var5] = (byte)(var10000[var5] | 2);
				} else {
					var6 = var0.readBits(1);
					if (var6 == 0) {
						var8 = var0.readBits(2);
						if (var8 == 0) {
							var9 = 0;
						} else if (var8 == 1) {
							var9 = var0.readBits(5);
						} else if (var8 == 2) {
							var9 = var0.readBits(8);
						} else {
							var9 = var0.readBits(11);
						}

						var3 = var9;
						var10000 = Players.field1230;
						var10000[var5] = (byte)(var10000[var5] | 2);
					} else {
						WorldMapAreaData.readPlayerUpdate(var0, var5);
					}
				}
			}
		}

		var0.exportIndex();
		if (var3 != 0) {
			throw new RuntimeException();
		} else {
			var0.importIndex();

			for (var4 = 0; var4 < Players.Players_count; ++var4) {
				var5 = Players.Players_indices[var4];
				if ((Players.field1230[var5] & 1) != 0) {
					if (var3 > 0) {
						--var3;
						var10000 = Players.field1230;
						var10000[var5] = (byte)(var10000[var5] | 2);
					} else {
						var6 = var0.readBits(1);
						if (var6 == 0) {
							var8 = var0.readBits(2);
							if (var8 == 0) {
								var9 = 0;
							} else if (var8 == 1) {
								var9 = var0.readBits(5);
							} else if (var8 == 2) {
								var9 = var0.readBits(8);
							} else {
								var9 = var0.readBits(11);
							}

							var3 = var9;
							var10000 = Players.field1230;
							var10000[var5] = (byte)(var10000[var5] | 2);
						} else {
							WorldMapAreaData.readPlayerUpdate(var0, var5);
						}
					}
				}
			}

			var0.exportIndex();
			if (var3 != 0) {
				throw new RuntimeException();
			} else {
				var0.importIndex();

				for (var4 = 0; var4 < Players.Players_emptyIdxCount; ++var4) {
					var5 = Players.Players_emptyIndices[var4];
					if ((Players.field1230[var5] & 1) != 0) {
						if (var3 > 0) {
							--var3;
							var10000 = Players.field1230;
							var10000[var5] = (byte)(var10000[var5] | 2);
						} else {
							var6 = var0.readBits(1);
							if (var6 == 0) {
								var8 = var0.readBits(2);
								if (var8 == 0) {
									var9 = 0;
								} else if (var8 == 1) {
									var9 = var0.readBits(5);
								} else if (var8 == 2) {
									var9 = var0.readBits(8);
								} else {
									var9 = var0.readBits(11);
								}

								var3 = var9;
								var10000 = Players.field1230;
								var10000[var5] = (byte)(var10000[var5] | 2);
							} else if (WorldMapDecorationType.updateExternalPlayer(var0, var5)) {
								var10000 = Players.field1230;
								var10000[var5] = (byte)(var10000[var5] | 2);
							}
						}
					}
				}

				var0.exportIndex();
				if (var3 != 0) {
					throw new RuntimeException();
				} else {
					var0.importIndex();

					for (var4 = 0; var4 < Players.Players_emptyIdxCount; ++var4) {
						var5 = Players.Players_emptyIndices[var4];
						if ((Players.field1230[var5] & 1) == 0) {
							if (var3 > 0) {
								--var3;
								var10000 = Players.field1230;
								var10000[var5] = (byte)(var10000[var5] | 2);
							} else {
								var6 = var0.readBits(1);
								if (var6 == 0) {
									var8 = var0.readBits(2);
									if (var8 == 0) {
										var9 = 0;
									} else if (var8 == 1) {
										var9 = var0.readBits(5);
									} else if (var8 == 2) {
										var9 = var0.readBits(8);
									} else {
										var9 = var0.readBits(11);
									}

									var3 = var9;
									var10000 = Players.field1230;
									var10000[var5] = (byte)(var10000[var5] | 2);
								} else if (WorldMapDecorationType.updateExternalPlayer(var0, var5)) {
									var10000 = Players.field1230;
									var10000[var5] = (byte)(var10000[var5] | 2);
								}
							}
						}
					}

					var0.exportIndex();
					if (var3 != 0) {
						throw new RuntimeException();
					} else {
						Players.Players_count = 0;
						Players.Players_emptyIdxCount = 0;

						Player var16;
						for (var4 = 1; var4 < 2048; ++var4) {
							var10000 = Players.field1230;
							var10000[var4] = (byte)(var10000[var4] >> 1);
							var16 = Client.players[var4];
							if (var16 != null) {
								Players.Players_indices[++Players.Players_count - 1] = var4;
							} else {
								Players.Players_emptyIndices[++Players.Players_emptyIdxCount - 1] = var4;
							}
						}

						for (var3 = 0; var3 < Players.Players_pendingUpdateCount; ++var3) {
							var4 = Players.Players_pendingUpdateIndices[var3];
							var16 = Client.players[var4];
							var6 = var0.readUnsignedByte();
							if ((var6 & 128) != 0) {
								var6 += var0.readUnsignedByte() << 8;
							}

							byte var7 = -1;
							int var11;
							int var12;
							int var15;
							if ((var6 & 4) != 0) {
								var8 = var0.readUnsignedByte();
								int var10;
								int var13;
								int var14;
								if (var8 > 0) {
									for (var9 = 0; var9 < var8; ++var9) {
										var11 = -1;
										var12 = -1;
										var13 = -1;
										var10 = var0.readUShortSmart();
										if (var10 == 32767) {
											var10 = var0.readUShortSmart();
											var12 = var0.readUShortSmart();
											var11 = var0.readUShortSmart();
											var13 = var0.readUShortSmart();
										} else if (var10 != 32766) {
											var12 = var0.readUShortSmart();
										} else {
											var10 = -1;
										}

										var14 = var0.readUShortSmart();
										var16.addHitSplat(var10, var12, var11, var13, Client.cycle, var14);
									}
								}

								var9 = var0.method5572();
								if (var9 > 0) {
									for (var10 = 0; var10 < var9; ++var10) {
										var11 = var0.readUShortSmart();
										var12 = var0.readUShortSmart();
										if (var12 != 32767) {
											var13 = var0.readUShortSmart();
											var14 = var0.method5572();
											var15 = var12 > 0 ? var0.method5628() : var14;
											var16.addHealthBar(var11, Client.cycle, var12, var13, var14, var15);
										} else {
											var16.removeHealthBar(var11);
										}
									}
								}
							}

							if ((var6 & 512) != 0) {
								Players.field1231[var4] = var0.method5577();
							}

							if ((var6 & 4096) != 0) {
								var16.spotAnimation = var0.readUnsignedShort();
								var8 = var0.method5591();
								var16.field963 = var8 >> 16;
								var16.field943 = (var8 & 65535) + Client.cycle;
								var16.spotAnimationFrame = 0;
								var16.spotAnimationFrameCycle = 0;
								if (var16.field943 > Client.cycle) {
									var16.spotAnimationFrame = -1;
								}

								if (var16.spotAnimation == 65535) {
									var16.spotAnimation = -1;
								}
							}

							if ((var6 & 32) != 0) {
								var16.targetIndex = var0.method5583();
								if (var16.targetIndex == 65535) {
									var16.targetIndex = -1;
								}
							}

							if ((var6 & 64) != 0) {
								var8 = var0.method5583();
								PlayerType var17 = (PlayerType)DynamicObject.findEnumerated(MusicPatchPcmStream.PlayerType_values(), var0.method5572());
								boolean var20 = var0.method5572() == 1;
								var11 = var0.method5628();
								var12 = var0.offset;
								if (var16.username != null && var16.appearance != null) {
									boolean var22 = false;
									if (var17.isUser && Message.friendSystem.isIgnored(var16.username)) {
										var22 = true;
									}

									if (!var22 && Client.field678 == 0 && !var16.isHidden) {
										Players.field1242.offset = 0;
										var0.method5740(Players.field1242.array, 0, var11);
										Players.field1242.offset = 0;
										String var18 = AbstractFont.escapeBrackets(Buddy.method5214(GraphicsObject.method2028(Players.field1242)));
										var16.overheadText = var18.trim();
										var16.overheadTextColor = var8 >> 8;
										var16.overheadTextEffect = var8 & 255;
										var16.overheadTextCyclesRemaining = 150;
										var16.isAutoChatting = var20;
										var16.field937 = var16 != Message.localPlayer && var17.isUser && "" != Client.field846 && var18.toLowerCase().indexOf(Client.field846) == -1;
										if (var17.isPrivileged) {
											var15 = var20 ? 91 : 1;
										} else {
											var15 = var20 ? 90 : 2;
										}

										if (var17.modIcon != -1) {
											class83.addGameMessage(var15, ChatChannel.method2269(var17.modIcon) + var16.username.getName(), var18);
										} else {
											class83.addGameMessage(var15, var16.username.getName(), var18);
										}
									}
								}

								var0.offset = var12 + var11;
							}

							if ((var6 & 1) != 0) {
								var16.field960 = var0.readUnsignedShort();
								if (var16.pathLength == 0) {
									var16.orientation = var16.field960;
									var16.field960 = -1;
								}
							}

							if ((var6 & 2048) != 0) {
								var7 = var0.readByte();
							}

							if ((var6 & 8) != 0) {
								var8 = var0.method5572();
								byte[] var23 = new byte[var8];
								Buffer var19 = new Buffer(var23);
								var0.method5593(var23, 0, var8);
								Players.field1228[var4] = var19;
								var16.read(var19);
							}

							if ((var6 & 2) != 0) {
								var8 = var0.method5582();
								if (var8 == 65535) {
									var8 = -1;
								}

								var9 = var0.method5675();
								BuddyRankComparator.performPlayerAnimation(var16, var8, var9);
							}

							if ((var6 & 256) != 0) {
								var16.field921 = var0.method5577();
								var16.field966 = var0.method5577();
								var16.field965 = var0.method5577();
								var16.field929 = var0.readByte();
								var16.field950 = var0.readUnsignedShort() + Client.cycle;
								var16.field969 = var0.method5723() + Client.cycle;
								var16.field970 = var0.method5583();
								if (var16.field616) {
									var16.field921 += var16.tileX;
									var16.field966 += var16.tileY;
									var16.field965 += var16.tileX;
									var16.field929 += var16.tileY;
									var16.pathLength = 0;
								} else {
									var16.field921 += var16.pathX[0];
									var16.field966 += var16.pathY[0];
									var16.field965 += var16.pathX[0];
									var16.field929 += var16.pathY[0];
									var16.pathLength = 1;
								}

								var16.field926 = 0;
							}

							if ((var6 & 16) != 0) {
								var16.overheadText = var0.readStringCp1252NullTerminated();
								if (var16.overheadText.charAt(0) == '~') {
									var16.overheadText = var16.overheadText.substring(1);
									class83.addGameMessage(2, var16.username.getName(), var16.overheadText);
								} else if (var16 == Message.localPlayer) {
									class83.addGameMessage(2, var16.username.getName(), var16.overheadText);
								}

								var16.isAutoChatting = false;
								var16.overheadTextColor = 0;
								var16.overheadTextEffect = 0;
								var16.overheadTextCyclesRemaining = 150;
							}

							if ((var6 & 1024) != 0) {
								for (var8 = 0; var8 < 3; ++var8) {
									var16.actions[var8] = var0.readStringCp1252NullTerminated();
								}
							}

							if (var16.field616) {
								if (var7 == 127) {
									var16.resetPath(var16.tileX, var16.tileY);
								} else {
									byte var21;
									if (var7 != -1) {
										var21 = var7;
									} else {
										var21 = Players.field1231[var4];
									}

									var16.method1261(var16.tileX, var16.tileY, var21);
								}
							}
						}

						if (var0.offset - var2 != var1) {
							throw new RuntimeException(var0.offset - var2 + " " + var1);
						}
					}
				}
			}
		}
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(IZI)Ljava/lang/String;",
		garbageValue = "2010255581"
	)
	@Export("intToString")
	public static String intToString(int var0, boolean var1) {
		return var1 && var0 >= 0 ? WorldMapData_0.method163(var0, 10, var1) : Integer.toString(var0);
	}

	@ObfuscatedName("hm")
	@ObfuscatedSignature(
		signature = "(IIIIIIIIIB)V",
		garbageValue = "104"
	)
	@Export("updatePendingSpawn")
	static final void updatePendingSpawn(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
		PendingSpawn var9 = null;

		for (PendingSpawn var10 = (PendingSpawn)Client.pendingSpawns.last(); var10 != null; var10 = (PendingSpawn)Client.pendingSpawns.previous()) {
			if (var0 == var10.plane && var10.x == var1 && var2 == var10.y && var3 == var10.type) {
				var9 = var10;
				break;
			}
		}

		if (var9 == null) {
			var9 = new PendingSpawn();
			var9.plane = var0;
			var9.type = var3;
			var9.x = var1;
			var9.y = var2;
			SequenceDefinition.method4821(var9);
			Client.pendingSpawns.addFirst(var9);
		}

		var9.id = var4;
		var9.field918 = var5;
		var9.orientation = var6;
		var9.delay = var7;
		var9.hitpoints = var8;
	}

	@ObfuscatedName("ho")
	@ObfuscatedSignature(
		signature = "(Lkl;I)V",
		garbageValue = "-1944443649"
	)
	static final void method1228(PacketBuffer var0) {
		for (int var1 = 0; var1 < Client.field673; ++var1) {
			int var2 = Client.field720[var1];
			NPC var3 = Client.npcs[var2];
			int var4 = var0.readUnsignedByte();
			int var5;
			int var6;
			int var7;
			if ((var4 & 64) != 0) {
				var5 = var0.method5582();
				if (var5 == 65535) {
					var5 = -1;
				}

				var6 = var0.method5675();
				if (var5 == var3.sequence && var5 != -1) {
					var7 = WorldMapSection0.SequenceDefinition_get(var5).field3495;
					if (var7 == 1) {
						var3.sequenceFrame = 0;
						var3.sequenceFrameCycle = 0;
						var3.sequenceDelay = var6;
						var3.field958 = 0;
					}

					if (var7 == 2) {
						var3.field958 = 0;
					}
				} else if (var5 == -1 || var3.sequence == -1 || WorldMapSection0.SequenceDefinition_get(var5).field3492 >= WorldMapSection0.SequenceDefinition_get(var3.sequence).field3492) {
					var3.sequence = var5;
					var3.sequenceFrame = 0;
					var3.sequenceFrameCycle = 0;
					var3.sequenceDelay = var6;
					var3.field958 = 0;
					var3.field926 = var3.pathLength;
				}
			}

			if ((var4 & 8) != 0) {
				var3.targetIndex = var0.method5723();
				if (var3.targetIndex == 65535) {
					var3.targetIndex = -1;
				}
			}

			if ((var4 & 1) != 0) {
				var3.overheadText = var0.readStringCp1252NullTerminated();
				var3.overheadTextCyclesRemaining = 100;
			}

			if ((var4 & 4) != 0) {
				var3.definition = AbstractUserComparator.getNpcDefinition(var0.method5582());
				var3.field925 = var3.definition.size;
				var3.field968 = var3.definition.rotation;
				var3.walkSequence = var3.definition.walkSequence;
				var3.walkBackSequence = var3.definition.walkBackSequence;
				var3.walkLeftSequence = var3.definition.walkLeftSequence;
				var3.walkRightSequence = var3.definition.walkRightSequence;
				var3.readySequence = var3.definition.readySequence;
				var3.turnLeftSequence = var3.definition.turnLeftSequence;
				var3.turnRightSequence = var3.definition.turnRightSequence;
			}

			int var8;
			if ((var4 & 2) != 0) {
				var5 = var0.method5628();
				int var9;
				int var10;
				int var11;
				if (var5 > 0) {
					for (var6 = 0; var6 < var5; ++var6) {
						var8 = -1;
						var9 = -1;
						var10 = -1;
						var7 = var0.readUShortSmart();
						if (var7 == 32767) {
							var7 = var0.readUShortSmart();
							var9 = var0.readUShortSmart();
							var8 = var0.readUShortSmart();
							var10 = var0.readUShortSmart();
						} else if (var7 != 32766) {
							var9 = var0.readUShortSmart();
						} else {
							var7 = -1;
						}

						var11 = var0.readUShortSmart();
						var3.addHitSplat(var7, var9, var8, var10, Client.cycle, var11);
					}
				}

				var6 = var0.readUnsignedByte();
				if (var6 > 0) {
					for (var7 = 0; var7 < var6; ++var7) {
						var8 = var0.readUShortSmart();
						var9 = var0.readUShortSmart();
						if (var9 != 32767) {
							var10 = var0.readUShortSmart();
							var11 = var0.method5675();
							int var12 = var9 > 0 ? var0.method5675() : var11;
							var3.addHealthBar(var8, Client.cycle, var9, var10, var11, var12);
						} else {
							var3.removeHealthBar(var8);
						}
					}
				}
			}

			if ((var4 & 16) != 0) {
				var5 = var0.readUnsignedShort();
				var6 = var0.method5723();
				var7 = var3.x - (var5 - MusicPatchPcmStream.baseX * 64 - MusicPatchPcmStream.baseX * 64) * 64;
				var8 = var3.y - (var6 - ScriptEvent.baseY * 64 - ScriptEvent.baseY * 64) * 64;
				if (var7 != 0 || var8 != 0) {
					var3.field960 = (int)(Math.atan2((double)var7, (double)var8) * 325.949D) & 2047;
				}
			}

			if ((var4 & 32) != 0) {
				var3.spotAnimation = var0.method5582();
				var5 = var0.method5592();
				var3.field963 = var5 >> 16;
				var3.field943 = (var5 & 65535) + Client.cycle;
				var3.spotAnimationFrame = 0;
				var3.spotAnimationFrameCycle = 0;
				if (var3.field943 > Client.cycle) {
					var3.spotAnimationFrame = -1;
				}

				if (var3.spotAnimation == 65535) {
					var3.spotAnimation = -1;
				}
			}
		}

	}
}
