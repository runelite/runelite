import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("br")
@Implements("ObjectSound")
public final class ObjectSound extends Node {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Ljv;"
	)
	@Export("objectSounds")
	static NodeDeque objectSounds;
	@ObfuscatedName("fm")
	@ObfuscatedGetter(
		longValue = 3707891332291918019L
	)
	static long field1055;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -131681461
	)
	@Export("y")
	int y;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -847535653
	)
	@Export("plane")
	int plane;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -296755339
	)
	@Export("x")
	int x;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 433341051
	)
	int field1043;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -558893015
	)
	int field1051;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = 1563858607
	)
	int field1039;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -1387482755
	)
	@Export("soundEffectId")
	int soundEffectId;
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Lda;"
	)
	@Export("stream1")
	RawPcmStream stream1;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -1081184403
	)
	int field1048;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 348352431
	)
	int field1049;
	@ObfuscatedName("h")
	@Export("soundEffectIds")
	int[] soundEffectIds;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -1879322163
	)
	int field1042;
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "Lda;"
	)
	@Export("stream2")
	RawPcmStream stream2;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Liy;"
	)
	@Export("obj")
	ObjectDefinition obj;

	static {
		objectSounds = new NodeDeque();
	}

	ObjectSound() {
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "43406199"
	)
	@Export("set")
	void set() {
		int var1 = this.soundEffectId;
		ObjectDefinition var2 = this.obj.transform();
		if (var2 != null) {
			this.soundEffectId = var2.ambientSoundId;
			this.field1039 = var2.int4 * 128;
			this.field1048 = var2.int5;
			this.field1049 = var2.int6;
			this.soundEffectIds = var2.soundEffectIds;
		} else {
			this.soundEffectId = -1;
			this.field1039 = 0;
			this.field1048 = 0;
			this.field1049 = 0;
			this.soundEffectIds = null;
		}

		if (var1 != this.soundEffectId && this.stream1 != null) {
			class51.pcmStreamMixer.removeSubStream(this.stream1);
			this.stream1 = null;
		}

	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		signature = "(ILcu;ZI)I",
		garbageValue = "-1423312068"
	)
	static int method1884(int var0, Script var1, boolean var2) {
		int var3;
		if (var0 == 6600) {
			var3 = MouseRecorder.plane;
			int var9 = class4.baseX * 64 + (Varps.localPlayer.x * -78439701 >> 7);
			int var5 = ScriptEvent.baseY + (Varps.localPlayer.y >> 7);
			class1.getWorldMap().method6275(var3, var9, var5, true);
			return 1;
		} else {
			WorldMapArea var11;
			if (var0 == ScriptOpcodes.WORLDMAP_GETMAPNAME) {
				var3 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
				String var16 = "";
				var11 = class1.getWorldMap().getMapArea(var3);
				if (var11 != null) {
					var16 = var11.getExternalName();
				}

				Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = var16;
				return 1;
			} else if (var0 == ScriptOpcodes.WORLDMAP_SETMAP) {
				var3 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
				class1.getWorldMap().setCurrentMapAreaId(var3);
				return 1;
			} else if (var0 == ScriptOpcodes.WORLDMAP_GETZOOM) {
				Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = class1.getWorldMap().getZoomLevel();
				return 1;
			} else if (var0 == ScriptOpcodes.WORLDMAP_SETZOOM) {
				var3 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
				class1.getWorldMap().setZoomPercentage(var3);
				return 1;
			} else if (var0 == ScriptOpcodes.WORLDMAP_ISLOADED) {
				Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = class1.getWorldMap().isCacheLoaded() ? 1 : 0;
				return 1;
			} else {
				Coord var15;
				if (var0 == ScriptOpcodes.WORLDMAP_JUMPTODISPLAYCOORD) {
					var15 = new Coord(Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize]);
					class1.getWorldMap().setWorldMapPositionTarget(var15.x, var15.y);
					return 1;
				} else if (var0 == ScriptOpcodes.WORLDMAP_JUMPTODISPLAYCOORD_INSTANT) {
					var15 = new Coord(Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize]);
					class1.getWorldMap().setWorldMapPositionTargetInstant(var15.x, var15.y);
					return 1;
				} else if (var0 == ScriptOpcodes.WORLDMAP_JUMPTOSOURCECOORD) {
					var15 = new Coord(Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize]);
					class1.getWorldMap().jumpToSourceCoord(var15.plane, var15.x, var15.y);
					return 1;
				} else if (var0 == ScriptOpcodes.WORLDMAP_JUMPTOSOURCECOORD_INSTANT) {
					var15 = new Coord(Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize]);
					class1.getWorldMap().jumpToSourceCoordInstant(var15.plane, var15.x, var15.y);
					return 1;
				} else if (var0 == ScriptOpcodes.WORLDMAP_GETDISPLAYPOSITION) {
					Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = class1.getWorldMap().getDisplayX();
					Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = class1.getWorldMap().getDisplayY();
					return 1;
				} else {
					WorldMapArea var13;
					if (var0 == ScriptOpcodes.WORLDMAP_GETCONFIGORIGIN) {
						var3 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
						var13 = class1.getWorldMap().getMapArea(var3);
						if (var13 == null) {
							Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = 0;
						} else {
							Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var13.getOrigin().packed();
						}

						return 1;
					} else if (var0 == ScriptOpcodes.WORLDMAP_GETCONFIGSIZE) {
						var3 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
						var13 = class1.getWorldMap().getMapArea(var3);
						if (var13 == null) {
							Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = 0;
							Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = 0;
						} else {
							Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = (var13.getRegionHighX() - var13.getRegionLowX() + 1) * 64;
							Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = (var13.getRegionHighY() - var13.getRegionLowY() + 1) * 64;
						}

						return 1;
					} else if (var0 == ScriptOpcodes.WORLDMAP_GETCONFIGBOUNDS) {
						var3 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
						var13 = class1.getWorldMap().getMapArea(var3);
						if (var13 == null) {
							Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = 0;
							Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = 0;
							Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = 0;
							Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = 0;
						} else {
							Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var13.getRegionLowX() * 64;
							Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var13.getRegionLowY() * 64;
							Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var13.getRegionHighX() * 64 + 64 - 1;
							Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var13.getRegionHighY() * 64 + 64 - 1;
						}

						return 1;
					} else if (var0 == ScriptOpcodes.WORLDMAP_GETCONFIGZOOM) {
						var3 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
						var13 = class1.getWorldMap().getMapArea(var3);
						if (var13 == null) {
							Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = -1;
						} else {
							Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var13.getZoom();
						}

						return 1;
					} else if (var0 == 6615) {
						var15 = class1.getWorldMap().getDisplayCoord();
						if (var15 == null) {
							Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = -1;
							Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = -1;
						} else {
							Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var15.x;
							Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var15.y;
						}

						return 1;
					} else if (var0 == ScriptOpcodes.WORLDMAP_GETCURRENTMAP) {
						Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = class1.getWorldMap().currentMapAreaId();
						return 1;
					} else if (var0 == ScriptOpcodes.WORLDMAP_GETDISPLAYCOORD) {
						var15 = new Coord(Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize]);
						var13 = class1.getWorldMap().getCurrentMapArea();
						if (var13 == null) {
							Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = -1;
							Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = -1;
							return 1;
						} else {
							int[] var14 = var13.position(var15.plane, var15.x, var15.y);
							if (var14 == null) {
								Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = -1;
								Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = -1;
							} else {
								Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var14[0];
								Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var14[1];
							}

							return 1;
						}
					} else {
						Coord var7;
						if (var0 == 6618) {
							var15 = new Coord(Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize]);
							var13 = class1.getWorldMap().getCurrentMapArea();
							if (var13 == null) {
								Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = -1;
								Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = -1;
								return 1;
							} else {
								var7 = var13.coord(var15.x, var15.y);
								if (var7 == null) {
									Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = -1;
								} else {
									Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var7.packed();
								}

								return 1;
							}
						} else {
							Coord var12;
							if (var0 == 6619) {
								class160.Interpreter_intStackSize -= 2;
								var3 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize];
								var12 = new Coord(Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 1]);
								WorldMapSprite.method380(var3, var12, false);
								return 1;
							} else if (var0 == 6620) {
								class160.Interpreter_intStackSize -= 2;
								var3 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize];
								var12 = new Coord(Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 1]);
								WorldMapSprite.method380(var3, var12, true);
								return 1;
							} else if (var0 == ScriptOpcodes.WORLDMAP_COORDINMAP) {
								class160.Interpreter_intStackSize -= 2;
								var3 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize];
								var12 = new Coord(Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 1]);
								var11 = class1.getWorldMap().getMapArea(var3);
								if (var11 == null) {
									Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = 0;
									return 1;
								} else {
									Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var11.containsCoord(var12.plane, var12.x, var12.y) ? 1 : 0;
									return 1;
								}
							} else if (var0 == ScriptOpcodes.WORLDMAP_GETSIZE) {
								Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = class1.getWorldMap().getDisplayWith();
								Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = class1.getWorldMap().getDisplayHeight();
								return 1;
							} else if (var0 == 6623) {
								var15 = new Coord(Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize]);
								var13 = class1.getWorldMap().mapAreaAtCoord(var15.plane, var15.x, var15.y);
								if (var13 == null) {
									Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = -1;
								} else {
									Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var13.getId();
								}

								return 1;
							} else if (var0 == 6624) {
								class1.getWorldMap().setMaxFlashCount(Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize]);
								return 1;
							} else if (var0 == 6625) {
								class1.getWorldMap().resetMaxFlashCount();
								return 1;
							} else if (var0 == 6626) {
								class1.getWorldMap().setCyclesPerFlash(Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize]);
								return 1;
							} else if (var0 == 6627) {
								class1.getWorldMap().resetCyclesPerFlash();
								return 1;
							} else {
								boolean var10;
								if (var0 == ScriptOpcodes.WORLDMAP_PERPETUALFLASH) {
									var10 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize] == 1;
									class1.getWorldMap().setPerpetualFlash(var10);
									return 1;
								} else if (var0 == ScriptOpcodes.WORLDMAP_FLASHELEMENT) {
									var3 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
									class1.getWorldMap().flashElement(var3);
									return 1;
								} else if (var0 == ScriptOpcodes.WORLDMAP_FLASHELEMENTCATEGORY) {
									var3 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
									class1.getWorldMap().flashCategory(var3);
									return 1;
								} else if (var0 == ScriptOpcodes.WORLDMAP_STOPCURRENTFLASHES) {
									class1.getWorldMap().stopCurrentFlashes();
									return 1;
								} else if (var0 == ScriptOpcodes.WORLDMAP_DISABLEELEMENTS) {
									var10 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize] == 1;
									class1.getWorldMap().setElementsDisabled(var10);
									return 1;
								} else {
									boolean var4;
									if (var0 == ScriptOpcodes.WORLDMAP_DISABLEELEMENT) {
										class160.Interpreter_intStackSize -= 2;
										var3 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize];
										var4 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 1] == 1;
										class1.getWorldMap().disableElement(var3, var4);
										return 1;
									} else if (var0 == ScriptOpcodes.WORLDMAP_DISABLEELEMENTCATEGORY) {
										class160.Interpreter_intStackSize -= 2;
										var3 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize];
										var4 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 1] == 1;
										class1.getWorldMap().setCategoryDisabled(var3, var4);
										return 1;
									} else if (var0 == ScriptOpcodes.WORLDMAP_GETDISABLEELEMENTS) {
										Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = class1.getWorldMap().getElementsDisabled() ? 1 : 0;
										return 1;
									} else if (var0 == ScriptOpcodes.WORLDMAP_GETDISABLEELEMENT) {
										var3 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
										Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = class1.getWorldMap().isElementDisabled(var3) ? 1 : 0;
										return 1;
									} else if (var0 == ScriptOpcodes.WORLDMAP_GETDISABLEELEMENTCATEGORY) {
										var3 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
										Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = class1.getWorldMap().isCategoryDisabled(var3) ? 1 : 0;
										return 1;
									} else if (var0 == 6638) {
										class160.Interpreter_intStackSize -= 2;
										var3 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize];
										var12 = new Coord(Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 1]);
										var7 = class1.getWorldMap().method6319(var3, var12);
										if (var7 == null) {
											Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = -1;
										} else {
											Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var7.packed();
										}

										return 1;
									} else {
										AbstractWorldMapIcon var8;
										if (var0 == ScriptOpcodes.WORLDMAP_LISTELEMENT_START) {
											var8 = class1.getWorldMap().iconStart();
											if (var8 == null) {
												Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = -1;
												Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = -1;
											} else {
												Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var8.getElement();
												Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var8.coord2.packed();
											}

											return 1;
										} else if (var0 == ScriptOpcodes.WORLDMAP_LISTELEMENT_NEXT) {
											var8 = class1.getWorldMap().iconNext();
											if (var8 == null) {
												Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = -1;
												Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = -1;
											} else {
												Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var8.getElement();
												Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var8.coord2.packed();
											}

											return 1;
										} else {
											WorldMapElement var6;
											if (var0 == ScriptOpcodes.MEC_TEXT) {
												var3 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
												var6 = WorldMapSection1.WorldMapElement_get(var3);
												if (var6.name == null) {
													Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = "";
												} else {
													Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = var6.name;
												}

												return 1;
											} else if (var0 == ScriptOpcodes.MEC_TEXTSIZE) {
												var3 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
												var6 = WorldMapSection1.WorldMapElement_get(var3);
												Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var6.textSize;
												return 1;
											} else if (var0 == ScriptOpcodes.MEC_CATEGORY) {
												var3 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
												var6 = WorldMapSection1.WorldMapElement_get(var3);
												if (var6 == null) {
													Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = -1;
												} else {
													Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var6.category;
												}

												return 1;
											} else if (var0 == ScriptOpcodes.MEC_SPRITE) {
												var3 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
												var6 = WorldMapSection1.WorldMapElement_get(var3);
												if (var6 == null) {
													Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = -1;
												} else {
													Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var6.sprite1;
												}

												return 1;
											} else if (var0 == ScriptOpcodes.WORLDMAP_ELEMENT) {
												Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = class32.worldMapEvent.mapElement;
												return 1;
											} else if (var0 == 6698) {
												Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = class32.worldMapEvent.coord1.packed();
												return 1;
											} else if (var0 == ScriptOpcodes.WORLDMAP_ELEMENTCOORD) {
												Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = class32.worldMapEvent.coord2.packed();
												return 1;
											} else {
												return 2;
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}

	@ObfuscatedName("hj")
	@ObfuscatedSignature(
		signature = "(Lkt;I)V",
		garbageValue = "-1146990373"
	)
	static final void method1888(PacketBuffer var0) {
		for (int var1 = 0; var1 < Client.field666; ++var1) {
			int var2 = Client.field881[var1];
			NPC var3 = Client.npcs[var2];
			int var4 = var0.readUnsignedByte();
			int var5;
			if ((var4 & 4) != 0) {
				var3.spotAnimation = var0.method5459();
				var5 = var0.method5587();
				var3.heightOffset = var5 >> 16;
				var3.field957 = (var5 & 65535) + Client.cycle;
				var3.spotAnimationFrame = 0;
				var3.spotAnimationFrameCycle = 0;
				if (var3.field957 > Client.cycle) {
					var3.spotAnimationFrame = -1;
				}

				if (var3.spotAnimation == 65535) {
					var3.spotAnimation = -1;
				}
			}

			int var6;
			int var7;
			int var8;
			if ((var4 & 1) != 0) {
				var5 = var0.method5503();
				var6 = var0.method5503();
				var7 = var3.x * -78439701 - (var5 - class4.baseX * 64 - class4.baseX * 64) * 64;
				var8 = var3.y - (var6 - ScriptEvent.baseY - ScriptEvent.baseY) * 64;
				if (var7 != 0 || var8 != 0) {
					var3.field945 = (int)(Math.atan2((double)var7, (double)var8) * 325.949D) & 2047;
				}
			}

			if ((var4 & 64) != 0) {
				var3.overheadText = var0.readStringCp1252NullTerminated();
				var3.overheadTextCyclesRemaining = 100;
			}

			if ((var4 & 8) != 0) {
				var3.targetIndex = var0.method5459();
				if (var3.targetIndex == 65535) {
					var3.targetIndex = -1;
				}
			}

			if ((var4 & 2) != 0) {
				var5 = var0.method5547();
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

				var6 = var0.method5494();
				if (var6 > 0) {
					for (var7 = 0; var7 < var6; ++var7) {
						var8 = var0.readUShortSmart();
						var9 = var0.readUShortSmart();
						if (var9 != 32767) {
							var10 = var0.readUShortSmart();
							var11 = var0.readUnsignedByte();
							int var12 = var9 > 0 ? var0.method5547() : var11;
							var3.addHealthBar(var8, Client.cycle, var9, var10, var11, var12);
						} else {
							var3.removeHealthBar(var8);
						}
					}
				}
			}

			if ((var4 & 32) != 0) {
				var5 = var0.method5514();
				if (var5 == 65535) {
					var5 = -1;
				}

				var6 = var0.readUnsignedByteNegate();
				if (var5 == var3.sequence && var5 != -1) {
					var7 = class83.SequenceDefinition_get(var5).field3502;
					if (var7 == 1) {
						var3.sequenceFrame = 0;
						var3.sequenceFrameCycle = 0;
						var3.sequenceDelay = var6;
						var3.field924 = 0;
					}

					if (var7 == 2) {
						var3.field924 = 0;
					}
				} else if (var5 == -1 || var3.sequence == -1 || class83.SequenceDefinition_get(var5).field3504 >= class83.SequenceDefinition_get(var3.sequence).field3504) {
					var3.sequence = var5;
					var3.sequenceFrame = 0;
					var3.sequenceFrameCycle = 0;
					var3.sequenceDelay = var6;
					var3.field924 = 0;
					var3.field969 = var3.pathLength;
				}
			}

			if ((var4 & 16) != 0) {
				var3.definition = FontName.getNpcDefinition(var0.method5514());
				var3.size = var3.definition.size;
				var3.field953 = var3.definition.rotation;
				var3.walkSequence = var3.definition.walkSequence;
				var3.walkBackSequence = var3.definition.walkBackSequence;
				var3.walkLeftSequence = var3.definition.walkLeftSequence;
				var3.walkRightSequence = var3.definition.walkRightSequence;
				var3.readySequence = var3.definition.readySequence;
				var3.turnLeftSequence = var3.definition.turnLeftSequence;
				var3.turnRightSequence = var3.definition.turnRightSequence;
			}
		}

	}
}
