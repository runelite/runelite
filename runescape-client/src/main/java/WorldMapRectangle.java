import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("m")
@Implements("WorldMapRectangle")
public final class WorldMapRectangle {
	@ObfuscatedName("sh")
	@ObfuscatedSignature(
		signature = "Lkg;"
	)
	@Export("masterDisk")
	static ArchiveDisk masterDisk;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -2130750927
	)
	@Export("width")
	int width;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -2077652257
	)
	@Export("height")
	int height;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = -1828733085
	)
	@Export("x")
	int x;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 1246600449
	)
	@Export("y")
	int y;
	// $FF: synthetic field
	@ObfuscatedSignature(
		signature = "Lar;"
	)
	final WorldMapManager this$0;

	@ObfuscatedSignature(
		signature = "(Lar;)V"
	)
	WorldMapRectangle(WorldMapManager var1) {
		this.this$0 = var1;
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		signature = "(ILcu;ZI)I",
		garbageValue = "-1751394483"
	)
	static int method273(int var0, Script var1, boolean var2) {
		int var3;
		if (var0 == 6600) {
			var3 = UrlRequest.Client_plane;
			int var9 = MusicPatchPcmStream.baseX * 64 + (Message.localPlayer.x >> 7);
			int var5 = ScriptEvent.baseY * 64 + (Message.localPlayer.y >> 7);
			Canvas.getWorldMap().method6367(var3, var9, var5, true);
			return 1;
		} else {
			WorldMapArea var11;
			if (var0 == ScriptOpcodes.WORLDMAP_GETMAPNAME) {
				var3 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
				String var16 = "";
				var11 = Canvas.getWorldMap().getMapArea(var3);
				if (var11 != null) {
					var16 = var11.getExternalName();
				}

				Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = var16;
				return 1;
			} else if (var0 == ScriptOpcodes.WORLDMAP_SETMAP) {
				var3 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
				Canvas.getWorldMap().setCurrentMapAreaId(var3);
				return 1;
			} else if (var0 == ScriptOpcodes.WORLDMAP_GETZOOM) {
				Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = Canvas.getWorldMap().getZoomLevel();
				return 1;
			} else if (var0 == ScriptOpcodes.WORLDMAP_SETZOOM) {
				var3 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
				Canvas.getWorldMap().setZoomPercentage(var3);
				return 1;
			} else if (var0 == ScriptOpcodes.WORLDMAP_ISLOADED) {
				Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = Canvas.getWorldMap().isCacheLoaded() ? 1 : 0;
				return 1;
			} else {
				Coord var15;
				if (var0 == ScriptOpcodes.WORLDMAP_JUMPTODISPLAYCOORD) {
					var15 = new Coord(Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize]);
					Canvas.getWorldMap().setWorldMapPositionTarget(var15.x, var15.y);
					return 1;
				} else if (var0 == ScriptOpcodes.WORLDMAP_JUMPTODISPLAYCOORD_INSTANT) {
					var15 = new Coord(Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize]);
					Canvas.getWorldMap().setWorldMapPositionTargetInstant(var15.x, var15.y);
					return 1;
				} else if (var0 == ScriptOpcodes.WORLDMAP_JUMPTOSOURCECOORD) {
					var15 = new Coord(Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize]);
					Canvas.getWorldMap().jumpToSourceCoord(var15.plane, var15.x, var15.y);
					return 1;
				} else if (var0 == ScriptOpcodes.WORLDMAP_JUMPTOSOURCECOORD_INSTANT) {
					var15 = new Coord(Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize]);
					Canvas.getWorldMap().jumpToSourceCoordInstant(var15.plane, var15.x, var15.y);
					return 1;
				} else if (var0 == ScriptOpcodes.WORLDMAP_GETDISPLAYPOSITION) {
					Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = Canvas.getWorldMap().getDisplayX();
					Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = Canvas.getWorldMap().getDisplayY();
					return 1;
				} else {
					WorldMapArea var13;
					if (var0 == ScriptOpcodes.WORLDMAP_GETCONFIGORIGIN) {
						var3 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
						var13 = Canvas.getWorldMap().getMapArea(var3);
						if (var13 == null) {
							Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = 0;
						} else {
							Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var13.getOrigin().packed();
						}

						return 1;
					} else if (var0 == ScriptOpcodes.WORLDMAP_GETCONFIGSIZE) {
						var3 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
						var13 = Canvas.getWorldMap().getMapArea(var3);
						if (var13 == null) {
							Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = 0;
							Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = 0;
						} else {
							Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = (var13.getRegionHighX() - var13.getRegionLowX() + 1) * 64;
							Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = (var13.getRegionHighY() - var13.getRegionLowY() + 1) * 64;
						}

						return 1;
					} else if (var0 == ScriptOpcodes.WORLDMAP_GETCONFIGBOUNDS) {
						var3 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
						var13 = Canvas.getWorldMap().getMapArea(var3);
						if (var13 == null) {
							Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = 0;
							Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = 0;
							Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = 0;
							Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = 0;
						} else {
							Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var13.getRegionLowX() * 64;
							Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var13.getRegionLowY() * 64;
							Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var13.getRegionHighX() * 64 + 64 - 1;
							Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var13.getRegionHighY() * 64 + 64 - 1;
						}

						return 1;
					} else if (var0 == ScriptOpcodes.WORLDMAP_GETCONFIGZOOM) {
						var3 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
						var13 = Canvas.getWorldMap().getMapArea(var3);
						if (var13 == null) {
							Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = -1;
						} else {
							Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var13.getZoom();
						}

						return 1;
					} else if (var0 == 6615) {
						var15 = Canvas.getWorldMap().getDisplayCoord();
						if (var15 == null) {
							Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = -1;
							Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = -1;
						} else {
							Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var15.x;
							Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var15.y;
						}

						return 1;
					} else if (var0 == ScriptOpcodes.WORLDMAP_GETCURRENTMAP) {
						Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = Canvas.getWorldMap().currentMapAreaId();
						return 1;
					} else if (var0 == ScriptOpcodes.WORLDMAP_GETDISPLAYCOORD) {
						var15 = new Coord(Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize]);
						var13 = Canvas.getWorldMap().getCurrentMapArea();
						if (var13 == null) {
							Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = -1;
							Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = -1;
							return 1;
						} else {
							int[] var14 = var13.position(var15.plane, var15.x, var15.y);
							if (var14 == null) {
								Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = -1;
								Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = -1;
							} else {
								Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var14[0];
								Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var14[1];
							}

							return 1;
						}
					} else {
						Coord var7;
						if (var0 == 6618) {
							var15 = new Coord(Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize]);
							var13 = Canvas.getWorldMap().getCurrentMapArea();
							if (var13 == null) {
								Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = -1;
								Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = -1;
								return 1;
							} else {
								var7 = var13.coord(var15.x, var15.y);
								if (var7 == null) {
									Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = -1;
								} else {
									Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var7.packed();
								}

								return 1;
							}
						} else {
							Coord var12;
							if (var0 == 6619) {
								class188.Interpreter_intStackSize -= 2;
								var3 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize];
								var12 = new Coord(Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 1]);
								GrandExchangeEvent.method80(var3, var12, false);
								return 1;
							} else if (var0 == 6620) {
								class188.Interpreter_intStackSize -= 2;
								var3 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize];
								var12 = new Coord(Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 1]);
								GrandExchangeEvent.method80(var3, var12, true);
								return 1;
							} else if (var0 == ScriptOpcodes.WORLDMAP_COORDINMAP) {
								class188.Interpreter_intStackSize -= 2;
								var3 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize];
								var12 = new Coord(Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 1]);
								var11 = Canvas.getWorldMap().getMapArea(var3);
								if (var11 == null) {
									Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = 0;
									return 1;
								} else {
									Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var11.containsCoord(var12.plane, var12.x, var12.y) ? 1 : 0;
									return 1;
								}
							} else if (var0 == ScriptOpcodes.WORLDMAP_GETSIZE) {
								Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = Canvas.getWorldMap().getDisplayWith();
								Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = Canvas.getWorldMap().getDisplayHeight();
								return 1;
							} else if (var0 == 6623) {
								var15 = new Coord(Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize]);
								var13 = Canvas.getWorldMap().mapAreaAtCoord(var15.plane, var15.x, var15.y);
								if (var13 == null) {
									Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = -1;
								} else {
									Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var13.getId();
								}

								return 1;
							} else if (var0 == 6624) {
								Canvas.getWorldMap().setMaxFlashCount(Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize]);
								return 1;
							} else if (var0 == 6625) {
								Canvas.getWorldMap().resetMaxFlashCount();
								return 1;
							} else if (var0 == 6626) {
								Canvas.getWorldMap().setCyclesPerFlash(Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize]);
								return 1;
							} else if (var0 == 6627) {
								Canvas.getWorldMap().resetCyclesPerFlash();
								return 1;
							} else {
								boolean var10;
								if (var0 == ScriptOpcodes.WORLDMAP_PERPETUALFLASH) {
									var10 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize] == 1;
									Canvas.getWorldMap().setPerpetualFlash(var10);
									return 1;
								} else if (var0 == ScriptOpcodes.WORLDMAP_FLASHELEMENT) {
									var3 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
									Canvas.getWorldMap().flashElement(var3);
									return 1;
								} else if (var0 == ScriptOpcodes.WORLDMAP_FLASHELEMENTCATEGORY) {
									var3 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
									Canvas.getWorldMap().flashCategory(var3);
									return 1;
								} else if (var0 == ScriptOpcodes.WORLDMAP_STOPCURRENTFLASHES) {
									Canvas.getWorldMap().stopCurrentFlashes();
									return 1;
								} else if (var0 == ScriptOpcodes.WORLDMAP_DISABLEELEMENTS) {
									var10 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize] == 1;
									Canvas.getWorldMap().setElementsDisabled(var10);
									return 1;
								} else {
									boolean var4;
									if (var0 == ScriptOpcodes.WORLDMAP_DISABLEELEMENT) {
										class188.Interpreter_intStackSize -= 2;
										var3 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize];
										var4 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 1] == 1;
										Canvas.getWorldMap().disableElement(var3, var4);
										return 1;
									} else if (var0 == ScriptOpcodes.WORLDMAP_DISABLEELEMENTCATEGORY) {
										class188.Interpreter_intStackSize -= 2;
										var3 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize];
										var4 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 1] == 1;
										Canvas.getWorldMap().setCategoryDisabled(var3, var4);
										return 1;
									} else if (var0 == ScriptOpcodes.WORLDMAP_GETDISABLEELEMENTS) {
										Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = Canvas.getWorldMap().getElementsDisabled() ? 1 : 0;
										return 1;
									} else if (var0 == ScriptOpcodes.WORLDMAP_GETDISABLEELEMENT) {
										var3 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
										Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = Canvas.getWorldMap().isElementDisabled(var3) ? 1 : 0;
										return 1;
									} else if (var0 == ScriptOpcodes.WORLDMAP_GETDISABLEELEMENTCATEGORY) {
										var3 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
										Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = Canvas.getWorldMap().isCategoryDisabled(var3) ? 1 : 0;
										return 1;
									} else if (var0 == 6638) {
										class188.Interpreter_intStackSize -= 2;
										var3 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize];
										var12 = new Coord(Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 1]);
										var7 = Canvas.getWorldMap().method6416(var3, var12);
										if (var7 == null) {
											Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = -1;
										} else {
											Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var7.packed();
										}

										return 1;
									} else {
										AbstractWorldMapIcon var8;
										if (var0 == ScriptOpcodes.WORLDMAP_LISTELEMENT_START) {
											var8 = Canvas.getWorldMap().iconStart();
											if (var8 == null) {
												Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = -1;
												Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = -1;
											} else {
												Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var8.getElement();
												Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var8.coord2.packed();
											}

											return 1;
										} else if (var0 == ScriptOpcodes.WORLDMAP_LISTELEMENT_NEXT) {
											var8 = Canvas.getWorldMap().iconNext();
											if (var8 == null) {
												Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = -1;
												Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = -1;
											} else {
												Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var8.getElement();
												Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var8.coord2.packed();
											}

											return 1;
										} else {
											WorldMapElement var6;
											if (var0 == ScriptOpcodes.MEC_TEXT) {
												var3 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
												var6 = GrandExchangeOfferUnitPriceComparator.WorldMapElement_get(var3);
												if (var6.name == null) {
													Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = "";
												} else {
													Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = var6.name;
												}

												return 1;
											} else if (var0 == ScriptOpcodes.MEC_TEXTSIZE) {
												var3 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
												var6 = GrandExchangeOfferUnitPriceComparator.WorldMapElement_get(var3);
												Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var6.textSize;
												return 1;
											} else if (var0 == ScriptOpcodes.MEC_CATEGORY) {
												var3 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
												var6 = GrandExchangeOfferUnitPriceComparator.WorldMapElement_get(var3);
												if (var6 == null) {
													Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = -1;
												} else {
													Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var6.category;
												}

												return 1;
											} else if (var0 == ScriptOpcodes.MEC_SPRITE) {
												var3 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
												var6 = GrandExchangeOfferUnitPriceComparator.WorldMapElement_get(var3);
												if (var6 == null) {
													Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = -1;
												} else {
													Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var6.sprite1;
												}

												return 1;
											} else if (var0 == ScriptOpcodes.WORLDMAP_ELEMENT) {
												Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = WorldMapLabel.worldMapEvent.mapElement;
												return 1;
											} else if (var0 == 6698) {
												Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = WorldMapLabel.worldMapEvent.coord1.packed();
												return 1;
											} else if (var0 == ScriptOpcodes.WORLDMAP_ELEMENTCOORD) {
												Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = WorldMapLabel.worldMapEvent.coord2.packed();
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

	@ObfuscatedName("go")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "66"
	)
	static final int method275() {
		if (Interpreter.clientPreferences.roofsHidden) {
			return UrlRequest.Client_plane;
		} else {
			int var0 = 3;
			if (ViewportMouse.cameraPitch < 310) {
				int var1;
				int var2;
				if (Client.oculusOrbState == 1) {
					var1 = WorldMapSectionType.oculusOrbFocalPointX >> 7;
					var2 = Language.oculusOrbFocalPointY >> 7;
				} else {
					var1 = Message.localPlayer.x >> 7;
					var2 = Message.localPlayer.y >> 7;
				}

				int var3 = MusicPatchNode2.cameraX >> 7;
				int var4 = UserComparator9.cameraZ >> 7;
				if (var3 < 0 || var4 < 0 || var3 >= 104 || var4 >= 104) {
					return UrlRequest.Client_plane;
				}

				if (var1 < 0 || var2 < 0 || var1 >= 104 || var2 >= 104) {
					return UrlRequest.Client_plane;
				}

				if ((Tiles.Tiles_renderFlags[UrlRequest.Client_plane][var3][var4] & 4) != 0) {
					var0 = UrlRequest.Client_plane;
				}

				int var5;
				if (var1 > var3) {
					var5 = var1 - var3;
				} else {
					var5 = var3 - var1;
				}

				int var6;
				if (var2 > var4) {
					var6 = var2 - var4;
				} else {
					var6 = var4 - var2;
				}

				int var7;
				int var8;
				if (var5 > var6) {
					var7 = var6 * 65536 / var5;
					var8 = 32768;

					while (var3 != var1) {
						if (var3 < var1) {
							++var3;
						} else if (var3 > var1) {
							--var3;
						}

						if ((Tiles.Tiles_renderFlags[UrlRequest.Client_plane][var3][var4] & 4) != 0) {
							var0 = UrlRequest.Client_plane;
						}

						var8 += var7;
						if (var8 >= 65536) {
							var8 -= 65536;
							if (var4 < var2) {
								++var4;
							} else if (var4 > var2) {
								--var4;
							}

							if ((Tiles.Tiles_renderFlags[UrlRequest.Client_plane][var3][var4] & 4) != 0) {
								var0 = UrlRequest.Client_plane;
							}
						}
					}
				} else if (var6 > 0) {
					var7 = var5 * 65536 / var6;
					var8 = 32768;

					while (var4 != var2) {
						if (var4 < var2) {
							++var4;
						} else if (var4 > var2) {
							--var4;
						}

						if ((Tiles.Tiles_renderFlags[UrlRequest.Client_plane][var3][var4] & 4) != 0) {
							var0 = UrlRequest.Client_plane;
						}

						var8 += var7;
						if (var8 >= 65536) {
							var8 -= 65536;
							if (var3 < var1) {
								++var3;
							} else if (var3 > var1) {
								--var3;
							}

							if ((Tiles.Tiles_renderFlags[UrlRequest.Client_plane][var3][var4] & 4) != 0) {
								var0 = UrlRequest.Client_plane;
							}
						}
					}
				}
			}

			if (Message.localPlayer.x >= 0 && Message.localPlayer.y >= 0 && Message.localPlayer.x < 13312 && Message.localPlayer.y < 13312) {
				if ((Tiles.Tiles_renderFlags[UrlRequest.Client_plane][Message.localPlayer.x >> 7][Message.localPlayer.y >> 7] & 4) != 0) {
					var0 = UrlRequest.Client_plane;
				}

				return var0;
			} else {
				return UrlRequest.Client_plane;
			}
		}
	}

	@ObfuscatedName("hi")
	@ObfuscatedSignature(
		signature = "(ZLkl;I)V",
		garbageValue = "-1139721015"
	)
	@Export("updateNpcs")
	static final void updateNpcs(boolean var0, PacketBuffer var1) {
		Client.field815 = 0;
		Client.field673 = 0;
		HitSplatDefinition.method4612();
		GrandExchangeOfferWorldComparator.method71(var0, var1);
		class65.method1228(var1);

		int var2;
		for (var2 = 0; var2 < Client.field815; ++var2) {
			int var3 = Client.field745[var2];
			if (Client.npcs[var3].npcCycle != Client.cycle) {
				Client.npcs[var3].definition = null;
				Client.npcs[var3] = null;
			}
		}

		if (var1.offset != Client.packetWriter.serverPacketLength) {
			throw new RuntimeException(var1.offset + "," + Client.packetWriter.serverPacketLength);
		} else {
			for (var2 = 0; var2 < Client.npcCount; ++var2) {
				if (Client.npcs[Client.npcIndices[var2]] == null) {
					throw new RuntimeException(var2 + "," + Client.npcCount);
				}
			}

		}
	}

	@ObfuscatedName("io")
	@ObfuscatedSignature(
		signature = "(IIS)V",
		garbageValue = "-26305"
	)
	@Export("resumePauseWidget")
	static void resumePauseWidget(int var0, int var1) {
		PacketBufferNode var2 = class2.getPacketBufferNode(ClientPacket.field2246, Client.packetWriter.isaacCipher);
		var2.packetBuffer.writeInt(var0);
		var2.packetBuffer.method5746(var1);
		Client.packetWriter.addNode(var2);
	}
}
