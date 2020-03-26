import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("c")
public class class22 {
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "32517854"
	)
	@Export("isKeyDown")
	public static final boolean isKeyDown() {
		synchronized(KeyHandler.KeyHandler_instance) {
			if (KeyHandler.field434 == KeyHandler.field436) {
				return false;
			} else {
				class3.field16 = KeyHandler.field414[KeyHandler.field434];
				Coord.field2531 = KeyHandler.field424[KeyHandler.field434];
				KeyHandler.field434 = KeyHandler.field434 + 1 & 127;
				return true;
			}
		}
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(Lkj;IB)Z",
		garbageValue = "127"
	)
	@Export("updateExternalPlayer")
	static boolean updateExternalPlayer(PacketBuffer var0, int var1) {
		int var2 = var0.readBits(2);
		int var3;
		int var4;
		int var7;
		int var8;
		int var9;
		int var10;
		if (var2 == 0) {
			if (var0.readBits(1) != 0) {
				updateExternalPlayer(var0, var1);
			}

			var3 = var0.readBits(13);
			var4 = var0.readBits(13);
			boolean var12 = var0.readBits(1) == 1;
			if (var12) {
				Players.Players_pendingUpdateIndices[++Players.Players_pendingUpdateCount - 1] = var1;
			}

			if (Client.players[var1] != null) {
				throw new RuntimeException();
			} else {
				Player var6 = Client.players[var1] = new Player();
				var6.index = var1;
				if (Players.field1269[var1] != null) {
					var6.read(Players.field1269[var1]);
				}

				var6.orientation = Players.Players_orientations[var1];
				var6.targetIndex = Players.Players_targetIndices[var1];
				var7 = Players.Players_regions[var1];
				var8 = var7 >> 28;
				var9 = var7 >> 14 & 255;
				var10 = var7 & 255;
				var6.pathTraversed[0] = Players.field1273[var1];
				var6.plane = (byte)var8;
				var6.resetPath((var9 << 13) + var3 - class69.baseX, (var10 << 13) + var4 - class89.baseY);
				var6.field670 = false;
				return true;
			}
		} else if (var2 == 1) {
			var3 = var0.readBits(2);
			var4 = Players.Players_regions[var1];
			Players.Players_regions[var1] = (var4 & 268435455) + (((var4 >> 28) + var3 & 3) << 28);
			return false;
		} else {
			int var5;
			int var11;
			if (var2 == 2) {
				var3 = var0.readBits(5);
				var4 = var3 >> 3;
				var5 = var3 & 7;
				var11 = Players.Players_regions[var1];
				var7 = (var11 >> 28) + var4 & 3;
				var8 = var11 >> 14 & 255;
				var9 = var11 & 255;
				if (var5 == 0) {
					--var8;
					--var9;
				}

				if (var5 == 1) {
					--var9;
				}

				if (var5 == 2) {
					++var8;
					--var9;
				}

				if (var5 == 3) {
					--var8;
				}

				if (var5 == 4) {
					++var8;
				}

				if (var5 == 5) {
					--var8;
					++var9;
				}

				if (var5 == 6) {
					++var9;
				}

				if (var5 == 7) {
					++var8;
					++var9;
				}

				Players.Players_regions[var1] = (var8 << 14) + var9 + (var7 << 28);
				return false;
			} else {
				var3 = var0.readBits(18);
				var4 = var3 >> 16;
				var5 = var3 >> 8 & 255;
				var11 = var3 & 255;
				var7 = Players.Players_regions[var1];
				var8 = (var7 >> 28) + var4 & 3;
				var9 = var5 + (var7 >> 14) & 255;
				var10 = var7 + var11 & 255;
				Players.Players_regions[var1] = (var9 << 14) + var10 + (var8 << 28);
				return false;
			}
		}
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		signature = "(ILce;ZI)I",
		garbageValue = "257352924"
	)
	static int method258(int var0, Script var1, boolean var2) {
		int var3;
		if (var0 == ScriptOpcodes.OC_NAME) {
			var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = AbstractWorldMapData.ItemDefinition_get(var3).name;
			return 1;
		} else {
			int var4;
			ItemDefinition var5;
			if (var0 == ScriptOpcodes.OC_OP) {
				Interpreter.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
				var5 = AbstractWorldMapData.ItemDefinition_get(var3);
				if (var4 >= 1 && var4 <= 5 && var5.groundActions[var4 - 1] != null) {
					Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var5.groundActions[var4 - 1];
				} else {
					Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
				}

				return 1;
			} else if (var0 == ScriptOpcodes.OC_IOP) {
				Interpreter.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
				var5 = AbstractWorldMapData.ItemDefinition_get(var3);
				if (var4 >= 1 && var4 <= 5 && var5.inventoryActions[var4 - 1] != null) {
					Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var5.inventoryActions[var4 - 1];
				} else {
					Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
				}

				return 1;
			} else if (var0 == ScriptOpcodes.OC_COST) {
				var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = AbstractWorldMapData.ItemDefinition_get(var3).price;
				return 1;
			} else if (var0 == ScriptOpcodes.OC_STACKABLE) {
				var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = AbstractWorldMapData.ItemDefinition_get(var3).isStackable == 1 ? 1 : 0;
				return 1;
			} else {
				ItemDefinition var6;
				if (var0 == ScriptOpcodes.OC_CERT) {
					var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
					var6 = AbstractWorldMapData.ItemDefinition_get(var3);
					if (var6.noteTemplate == -1 && var6.note >= 0) {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var6.note;
					} else {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3;
					}

					return 1;
				} else if (var0 == ScriptOpcodes.OC_UNCERT) {
					var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
					var6 = AbstractWorldMapData.ItemDefinition_get(var3);
					if (var6.noteTemplate >= 0 && var6.note >= 0) {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var6.note;
					} else {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3;
					}

					return 1;
				} else if (var0 == ScriptOpcodes.OC_MEMBERS) {
					var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = AbstractWorldMapData.ItemDefinition_get(var3).isMembersOnly ? 1 : 0;
					return 1;
				} else if (var0 == ScriptOpcodes.OC_PLACEHOLDER) {
					var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
					var6 = AbstractWorldMapData.ItemDefinition_get(var3);
					if (var6.placeholderTemplate == -1 && var6.placeholder >= 0) {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var6.placeholder;
					} else {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3;
					}

					return 1;
				} else if (var0 == ScriptOpcodes.OC_UNPLACEHOLDER) {
					var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
					var6 = AbstractWorldMapData.ItemDefinition_get(var3);
					if (var6.placeholderTemplate >= 0 && var6.placeholder >= 0) {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var6.placeholder;
					} else {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3;
					}

					return 1;
				} else if (var0 == ScriptOpcodes.OC_FIND) {
					String var7 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
					var4 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
					class69.findItemDefinitions(var7, var4 == 1);
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = TextureProvider.foundItemIdCount;
					return 1;
				} else if (var0 != ScriptOpcodes.OC_FINDNEXT) {
					if (var0 == ScriptOpcodes.OC_FINDRESET) {
						AbstractWorldMapIcon.foundItemIndex = 0;
						return 1;
					} else {
						return 2;
					}
				} else {
					if (WorldMapEvent.foundItemIds != null && AbstractWorldMapIcon.foundItemIndex < TextureProvider.foundItemIdCount) {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = WorldMapEvent.foundItemIds[++AbstractWorldMapIcon.foundItemIndex - 1] & '\uffff';
					} else {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
					}

					return 1;
				}
			}
		}
	}

	@ObfuscatedName("fz")
	@ObfuscatedSignature(
		signature = "(S)V",
		garbageValue = "16256"
	)
	static final void method252() {
		for (int var0 = 0; var0 < Client.soundEffectCount; ++var0) {
			int var10002 = Client.queuedSoundEffectDelays[var0]--;
			if (Client.queuedSoundEffectDelays[var0] >= -10) {
				SoundEffect var9 = Client.soundEffects[var0];
				if (var9 == null) {
					Object var10000 = null;
					var9 = SoundEffect.readSoundEffect(FontName.archive4, Client.soundEffectIds[var0], 0);
					if (var9 == null) {
						continue;
					}

					int[] var13 = Client.queuedSoundEffectDelays;
					var13[var0] += var9.calculateDelay();
					Client.soundEffects[var0] = var9;
				}

				if (Client.queuedSoundEffectDelays[var0] < 0) {
					int var2;
					if (Client.soundLocations[var0] != 0) {
						int var3 = (Client.soundLocations[var0] & 255) * 128;
						int var4 = Client.soundLocations[var0] >> 16 & 255;
						int var5 = var4 * 128 + 64 - ByteArrayPool.localPlayer.x;
						if (var5 < 0) {
							var5 = -var5;
						}

						int var6 = Client.soundLocations[var0] >> 8 & 255;
						int var7 = var6 * 128 + 64 - ByteArrayPool.localPlayer.y;
						if (var7 < 0) {
							var7 = -var7;
						}

						int var8 = var7 + var5 - 128;
						if (var8 > var3) {
							Client.queuedSoundEffectDelays[var0] = -100;
							continue;
						}

						if (var8 < 0) {
							var8 = 0;
						}

						var2 = (var3 - var8) * Client.areaSoundEffectVolume / var3;
					} else {
						var2 = Client.soundEffectVolume;
					}

					if (var2 > 0) {
						RawSound var10 = var9.toRawSound().resample(class25.decimator);
						RawPcmStream var11 = RawPcmStream.createRawPcmStream(var10, 100, var2);
						var11.setNumLoops(Client.queuedSoundEffectLoops[var0] - 1);
						Tiles.pcmStreamMixer.addSubStream(var11);
					}

					Client.queuedSoundEffectDelays[var0] = -100;
				}
			} else {
				--Client.soundEffectCount;

				for (int var1 = var0; var1 < Client.soundEffectCount; ++var1) {
					Client.soundEffectIds[var1] = Client.soundEffectIds[var1 + 1];
					Client.soundEffects[var1] = Client.soundEffects[var1 + 1];
					Client.queuedSoundEffectLoops[var1] = Client.queuedSoundEffectLoops[var1 + 1];
					Client.queuedSoundEffectDelays[var1] = Client.queuedSoundEffectDelays[var1 + 1];
					Client.soundLocations[var1] = Client.soundLocations[var1 + 1];
				}

				--var0;
			}
		}

		if (Client.field915) {
			boolean var12;
			if (class206.field2406 != 0) {
				var12 = true;
			} else {
				var12 = class206.midiPcmStream.isReady();
			}

			if (!var12) {
				if (Client.musicVolume != 0 && Client.currentTrackGroupId != -1) {
					class74.method1321(AbstractWorldMapIcon.archive6, Client.currentTrackGroupId, 0, Client.musicVolume, false);
				}

				Client.field915 = false;
			}
		}

	}

	@ObfuscatedName("gm")
	@ObfuscatedSignature(
		signature = "(Lbi;ZI)V",
		garbageValue = "-591154231"
	)
	@Export("addPlayerToScene")
	static void addPlayerToScene(Player var0, boolean var1) {
		if (var0 != null && var0.isVisible() && !var0.isHidden) {
			var0.isUnanimated = false;
			if ((Client.isLowDetail && Players.Players_count > 50 || Players.Players_count > 200) && var1 && var0.movementSequence == var0.readySequence) {
				var0.isUnanimated = true;
			}

			int var2 = var0.x >> 7;
			int var3 = var0.y >> 7;
			if (var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
				long var4 = IsaacCipher.calculateTag(0, 0, 0, false, var0.index);
				if (var0.model0 != null && Client.cycle >= var0.animationCycleStart && Client.cycle < var0.animationCycleEnd) {
					var0.isUnanimated = false;
					var0.tileHeight = class277.getTileHeight(var0.x, var0.y, ScriptEvent.Client_plane);
					var0.playerCycle = Client.cycle;
					GrandExchangeOfferWorldComparator.scene.addNullableObject(ScriptEvent.Client_plane, var0.x, var0.y, var0.tileHeight, 60, var0, var0.rotation, var4, var0.field659, var0.field660, var0.field661, var0.field664);
				} else {
					if ((var0.x & 127) == 64 && (var0.y & 127) == 64) {
						if (Client.tileLastDrawnActor[var2][var3] == Client.viewportDrawCount) {
							return;
						}

						Client.tileLastDrawnActor[var2][var3] = Client.viewportDrawCount;
					}

					var0.tileHeight = class277.getTileHeight(var0.x, var0.y, ScriptEvent.Client_plane);
					var0.playerCycle = Client.cycle;
					GrandExchangeOfferWorldComparator.scene.drawEntity(ScriptEvent.Client_plane, var0.x, var0.y, var0.tileHeight, 60, var0, var0.rotation, var4, var0.isWalking);
				}
			}
		}

	}

	@ObfuscatedName("jr")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "-116"
	)
	@Export("changeGameOptions")
	static final void changeGameOptions(int var0) {
		class58.method966();

		for (ObjectSound var1 = (ObjectSound)ObjectSound.objectSounds.last(); var1 != null; var1 = (ObjectSound)ObjectSound.objectSounds.previous()) {
			if (var1.obj != null) {
				var1.set();
			}
		}

		int var4 = class228.VarpDefinition_get(var0).type;
		if (var4 != 0) {
			int var2 = Varps.Varps_main[var0];
			if (var4 == 1) {
				if (var2 == 1) {
					Rasterizer3D.Rasterizer3D_setBrightness(0.9D);
					((TextureProvider)Rasterizer3D.Rasterizer3D_textureLoader).setBrightness(0.9D);
				}

				if (var2 == 2) {
					Rasterizer3D.Rasterizer3D_setBrightness(0.8D);
					((TextureProvider)Rasterizer3D.Rasterizer3D_textureLoader).setBrightness(0.8D);
				}

				if (var2 == 3) {
					Rasterizer3D.Rasterizer3D_setBrightness(0.7D);
					((TextureProvider)Rasterizer3D.Rasterizer3D_textureLoader).setBrightness(0.7D);
				}

				if (var2 == 4) {
					Rasterizer3D.Rasterizer3D_setBrightness(0.6D);
					((TextureProvider)Rasterizer3D.Rasterizer3D_textureLoader).setBrightness(0.6D);
				}

				ItemDefinition.ItemDefinition_cachedSprites.clear();
			}

			if (var4 == 3) {
				short var3 = 0;
				if (var2 == 0) {
					var3 = 255;
				}

				if (var2 == 1) {
					var3 = 192;
				}

				if (var2 == 2) {
					var3 = 128;
				}

				if (var2 == 3) {
					var3 = 64;
				}

				if (var2 == 4) {
					var3 = 0;
				}

				if (var3 != Client.musicVolume) {
					if (Client.musicVolume == 0 && Client.currentTrackGroupId != -1) {
						class74.method1321(AbstractWorldMapIcon.archive6, Client.currentTrackGroupId, 0, var3, false);
						Client.field915 = false;
					} else if (var3 == 0) {
						Client.method1496();
						Client.field915 = false;
					} else {
						class219.method4057(var3);
					}

					Client.musicVolume = var3;
				}
			}

			if (var4 == 4) {
				if (var2 == 0) {
					Client.soundEffectVolume = 127;
				}

				if (var2 == 1) {
					Client.soundEffectVolume = 96;
				}

				if (var2 == 2) {
					Client.soundEffectVolume = 64;
				}

				if (var2 == 3) {
					Client.soundEffectVolume = 32;
				}

				if (var2 == 4) {
					Client.soundEffectVolume = 0;
				}
			}

			if (var4 == 5) {
				Client.leftClickOpensMenu = var2;
			}

			if (var4 == 6) {
				Client.chatEffects = var2;
			}

			if (var4 == 9) {
				Client.field845 = var2;
			}

			if (var4 == 10) {
				if (var2 == 0) {
					Client.areaSoundEffectVolume = 127;
				}

				if (var2 == 1) {
					Client.areaSoundEffectVolume = 96;
				}

				if (var2 == 2) {
					Client.areaSoundEffectVolume = 64;
				}

				if (var2 == 3) {
					Client.areaSoundEffectVolume = 32;
				}

				if (var2 == 4) {
					Client.areaSoundEffectVolume = 0;
				}
			}

			if (var4 == 17) {
				Client.followerIndex = var2 & 65535;
			}

			if (var4 == 18) {
				Client.playerAttackOption = (AttackOption)GrandExchangeEvent.findEnumerated(class39.method643(), var2);
				if (Client.playerAttackOption == null) {
					Client.playerAttackOption = AttackOption.AttackOption_dependsOnCombatLevels;
				}
			}

			if (var4 == 19) {
				if (var2 == -1) {
					Client.combatTargetPlayerIndex = -1;
				} else {
					Client.combatTargetPlayerIndex = var2 & 2047;
				}
			}

			if (var4 == 22) {
				Client.npcAttackOption = (AttackOption)GrandExchangeEvent.findEnumerated(class39.method643(), var2);
				if (Client.npcAttackOption == null) {
					Client.npcAttackOption = AttackOption.AttackOption_dependsOnCombatLevels;
				}
			}

		}
	}

	@ObfuscatedName("lb")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "2"
	)
	static void method256(int var0) {
		Client.oculusOrbState = var0;
	}
}
