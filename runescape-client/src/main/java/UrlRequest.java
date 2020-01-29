import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("eg")
@Implements("UrlRequest")
public class UrlRequest {
	@ObfuscatedName("x")
	static int[][][] field1940;
	@ObfuscatedName("c")
	@Export("url")
	final URL url;
	@ObfuscatedName("t")
	@Export("isDone0")
	volatile boolean isDone0;
	@ObfuscatedName("o")
	@Export("response0")
	volatile byte[] response0;

	UrlRequest(URL var1) {
		this.url = var1;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "41"
	)
	@Export("isDone")
	public boolean isDone() {
		return this.isDone0;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(B)[B",
		garbageValue = "0"
	)
	@Export("getResponse")
	public byte[] getResponse() {
		return this.response0;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "72"
	)
	static void method3375() {
		for (ObjectSound var0 = (ObjectSound)ObjectSound.objectSounds.last(); var0 != null; var0 = (ObjectSound)ObjectSound.objectSounds.previous()) {
			if (var0.stream1 != null) {
				class2.pcmStreamMixer.removeSubStream(var0.stream1);
				var0.stream1 = null;
			}

			if (var0.stream2 != null) {
				class2.pcmStreamMixer.removeSubStream(var0.stream2);
				var0.stream2 = null;
			}
		}

		ObjectSound.objectSounds.clear();
	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		signature = "(ILce;ZI)I",
		garbageValue = "416833363"
	)
	static int method3382(int var0, Script var1, boolean var2) {
		int var3;
		if (var0 == 6600) {
			var3 = Clock.Client_plane;
			int var9 = Messages.baseX * 64 + (class192.localPlayer.x >> 7);
			int var5 = Language.baseY * 64 + (class192.localPlayer.y >> 7);
			GrandExchangeOfferUnitPriceComparator.getWorldMap().method6371(var3, var9, var5, true);
			return 1;
		} else {
			WorldMapArea var11;
			if (var0 == ScriptOpcodes.WORLDMAP_GETMAPNAME) {
				var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
				String var16 = "";
				var11 = GrandExchangeOfferUnitPriceComparator.getWorldMap().getMapArea(var3);
				if (var11 != null) {
					var16 = var11.getExternalName();
				}

				Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = var16;
				return 1;
			} else if (var0 == ScriptOpcodes.WORLDMAP_SETMAP) {
				var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
				GrandExchangeOfferUnitPriceComparator.getWorldMap().setCurrentMapAreaId(var3);
				return 1;
			} else if (var0 == ScriptOpcodes.WORLDMAP_GETZOOM) {
				Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = GrandExchangeOfferUnitPriceComparator.getWorldMap().getZoomLevel();
				return 1;
			} else if (var0 == ScriptOpcodes.WORLDMAP_SETZOOM) {
				var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
				GrandExchangeOfferUnitPriceComparator.getWorldMap().setZoomPercentage(var3);
				return 1;
			} else if (var0 == ScriptOpcodes.WORLDMAP_ISLOADED) {
				Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = GrandExchangeOfferUnitPriceComparator.getWorldMap().isCacheLoaded() ? 1 : 0;
				return 1;
			} else {
				Coord var15;
				if (var0 == ScriptOpcodes.WORLDMAP_JUMPTODISPLAYCOORD) {
					var15 = new Coord(Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize]);
					GrandExchangeOfferUnitPriceComparator.getWorldMap().setWorldMapPositionTarget(var15.x, var15.y);
					return 1;
				} else if (var0 == ScriptOpcodes.WORLDMAP_JUMPTODISPLAYCOORD_INSTANT) {
					var15 = new Coord(Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize]);
					GrandExchangeOfferUnitPriceComparator.getWorldMap().setWorldMapPositionTargetInstant(var15.x, var15.y);
					return 1;
				} else if (var0 == ScriptOpcodes.WORLDMAP_JUMPTOSOURCECOORD) {
					var15 = new Coord(Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize]);
					GrandExchangeOfferUnitPriceComparator.getWorldMap().jumpToSourceCoord(var15.plane, var15.x, var15.y);
					return 1;
				} else if (var0 == ScriptOpcodes.WORLDMAP_JUMPTOSOURCECOORD_INSTANT) {
					var15 = new Coord(Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize]);
					GrandExchangeOfferUnitPriceComparator.getWorldMap().jumpToSourceCoordInstant(var15.plane, var15.x, var15.y);
					return 1;
				} else if (var0 == ScriptOpcodes.WORLDMAP_GETDISPLAYPOSITION) {
					Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = GrandExchangeOfferUnitPriceComparator.getWorldMap().getDisplayX();
					Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = GrandExchangeOfferUnitPriceComparator.getWorldMap().getDisplayY();
					return 1;
				} else {
					WorldMapArea var13;
					if (var0 == ScriptOpcodes.WORLDMAP_GETCONFIGORIGIN) {
						var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
						var13 = GrandExchangeOfferUnitPriceComparator.getWorldMap().getMapArea(var3);
						if (var13 == null) {
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 0;
						} else {
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var13.getOrigin().packed();
						}

						return 1;
					} else if (var0 == ScriptOpcodes.WORLDMAP_GETCONFIGSIZE) {
						var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
						var13 = GrandExchangeOfferUnitPriceComparator.getWorldMap().getMapArea(var3);
						if (var13 == null) {
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 0;
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 0;
						} else {
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = (var13.getRegionHighX() - var13.getRegionLowX() + 1) * 64;
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = (var13.getRegionHighY() - var13.getRegionLowY() + 1) * 64;
						}

						return 1;
					} else if (var0 == ScriptOpcodes.WORLDMAP_GETCONFIGBOUNDS) {
						var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
						var13 = GrandExchangeOfferUnitPriceComparator.getWorldMap().getMapArea(var3);
						if (var13 == null) {
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 0;
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 0;
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 0;
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 0;
						} else {
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var13.getRegionLowX() * 64;
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var13.getRegionLowY() * 64;
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var13.getRegionHighX() * 64 + 64 - 1;
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var13.getRegionHighY() * 64 + 64 - 1;
						}

						return 1;
					} else if (var0 == ScriptOpcodes.WORLDMAP_GETCONFIGZOOM) {
						var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
						var13 = GrandExchangeOfferUnitPriceComparator.getWorldMap().getMapArea(var3);
						if (var13 == null) {
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = -1;
						} else {
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var13.getZoom();
						}

						return 1;
					} else if (var0 == 6615) {
						var15 = GrandExchangeOfferUnitPriceComparator.getWorldMap().getDisplayCoord();
						if (var15 == null) {
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = -1;
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = -1;
						} else {
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var15.x;
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var15.y;
						}

						return 1;
					} else if (var0 == ScriptOpcodes.WORLDMAP_GETCURRENTMAP) {
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = GrandExchangeOfferUnitPriceComparator.getWorldMap().currentMapAreaId();
						return 1;
					} else if (var0 == ScriptOpcodes.WORLDMAP_GETDISPLAYCOORD) {
						var15 = new Coord(Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize]);
						var13 = GrandExchangeOfferUnitPriceComparator.getWorldMap().getCurrentMapArea();
						if (var13 == null) {
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = -1;
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = -1;
							return 1;
						} else {
							int[] var14 = var13.position(var15.plane, var15.x, var15.y);
							if (var14 == null) {
								Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = -1;
								Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = -1;
							} else {
								Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var14[0];
								Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var14[1];
							}

							return 1;
						}
					} else {
						Coord var7;
						if (var0 == 6618) {
							var15 = new Coord(Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize]);
							var13 = GrandExchangeOfferUnitPriceComparator.getWorldMap().getCurrentMapArea();
							if (var13 == null) {
								Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = -1;
								Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = -1;
								return 1;
							} else {
								var7 = var13.coord(var15.x, var15.y);
								if (var7 == null) {
									Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = -1;
								} else {
									Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var7.packed();
								}

								return 1;
							}
						} else {
							Coord var12;
							if (var0 == 6619) {
								class320.Interpreter_intStackSize -= 2;
								var3 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize];
								var12 = new Coord(Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1]);
								WorldMapData_1.method731(var3, var12, false);
								return 1;
							} else if (var0 == 6620) {
								class320.Interpreter_intStackSize -= 2;
								var3 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize];
								var12 = new Coord(Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1]);
								WorldMapData_1.method731(var3, var12, true);
								return 1;
							} else if (var0 == ScriptOpcodes.WORLDMAP_COORDINMAP) {
								class320.Interpreter_intStackSize -= 2;
								var3 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize];
								var12 = new Coord(Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1]);
								var11 = GrandExchangeOfferUnitPriceComparator.getWorldMap().getMapArea(var3);
								if (var11 == null) {
									Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 0;
									return 1;
								} else {
									Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var11.containsCoord(var12.plane, var12.x, var12.y) ? 1 : 0;
									return 1;
								}
							} else if (var0 == ScriptOpcodes.WORLDMAP_GETSIZE) {
								Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = GrandExchangeOfferUnitPriceComparator.getWorldMap().getDisplayWith();
								Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = GrandExchangeOfferUnitPriceComparator.getWorldMap().getDisplayHeight();
								return 1;
							} else if (var0 == 6623) {
								var15 = new Coord(Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize]);
								var13 = GrandExchangeOfferUnitPriceComparator.getWorldMap().mapAreaAtCoord(var15.plane, var15.x, var15.y);
								if (var13 == null) {
									Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = -1;
								} else {
									Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var13.getId();
								}

								return 1;
							} else if (var0 == 6624) {
								GrandExchangeOfferUnitPriceComparator.getWorldMap().setMaxFlashCount(Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize]);
								return 1;
							} else if (var0 == 6625) {
								GrandExchangeOfferUnitPriceComparator.getWorldMap().resetMaxFlashCount();
								return 1;
							} else if (var0 == 6626) {
								GrandExchangeOfferUnitPriceComparator.getWorldMap().setCyclesPerFlash(Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize]);
								return 1;
							} else if (var0 == 6627) {
								GrandExchangeOfferUnitPriceComparator.getWorldMap().resetCyclesPerFlash();
								return 1;
							} else {
								boolean var10;
								if (var0 == ScriptOpcodes.WORLDMAP_PERPETUALFLASH) {
									var10 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
									GrandExchangeOfferUnitPriceComparator.getWorldMap().setPerpetualFlash(var10);
									return 1;
								} else if (var0 == ScriptOpcodes.WORLDMAP_FLASHELEMENT) {
									var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
									GrandExchangeOfferUnitPriceComparator.getWorldMap().flashElement(var3);
									return 1;
								} else if (var0 == ScriptOpcodes.WORLDMAP_FLASHELEMENTCATEGORY) {
									var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
									GrandExchangeOfferUnitPriceComparator.getWorldMap().flashCategory(var3);
									return 1;
								} else if (var0 == ScriptOpcodes.WORLDMAP_STOPCURRENTFLASHES) {
									GrandExchangeOfferUnitPriceComparator.getWorldMap().stopCurrentFlashes();
									return 1;
								} else if (var0 == ScriptOpcodes.WORLDMAP_DISABLEELEMENTS) {
									var10 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
									GrandExchangeOfferUnitPriceComparator.getWorldMap().setElementsDisabled(var10);
									return 1;
								} else {
									boolean var4;
									if (var0 == ScriptOpcodes.WORLDMAP_DISABLEELEMENT) {
										class320.Interpreter_intStackSize -= 2;
										var3 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize];
										var4 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1] == 1;
										GrandExchangeOfferUnitPriceComparator.getWorldMap().disableElement(var3, var4);
										return 1;
									} else if (var0 == ScriptOpcodes.WORLDMAP_DISABLEELEMENTCATEGORY) {
										class320.Interpreter_intStackSize -= 2;
										var3 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize];
										var4 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1] == 1;
										GrandExchangeOfferUnitPriceComparator.getWorldMap().setCategoryDisabled(var3, var4);
										return 1;
									} else if (var0 == ScriptOpcodes.WORLDMAP_GETDISABLEELEMENTS) {
										Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = GrandExchangeOfferUnitPriceComparator.getWorldMap().getElementsDisabled() ? 1 : 0;
										return 1;
									} else if (var0 == ScriptOpcodes.WORLDMAP_GETDISABLEELEMENT) {
										var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
										Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = GrandExchangeOfferUnitPriceComparator.getWorldMap().isElementDisabled(var3) ? 1 : 0;
										return 1;
									} else if (var0 == ScriptOpcodes.WORLDMAP_GETDISABLEELEMENTCATEGORY) {
										var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
										Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = GrandExchangeOfferUnitPriceComparator.getWorldMap().isCategoryDisabled(var3) ? 1 : 0;
										return 1;
									} else if (var0 == 6638) {
										class320.Interpreter_intStackSize -= 2;
										var3 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize];
										var12 = new Coord(Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1]);
										var7 = GrandExchangeOfferUnitPriceComparator.getWorldMap().method6411(var3, var12);
										if (var7 == null) {
											Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = -1;
										} else {
											Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var7.packed();
										}

										return 1;
									} else {
										AbstractWorldMapIcon var8;
										if (var0 == ScriptOpcodes.WORLDMAP_LISTELEMENT_START) {
											var8 = GrandExchangeOfferUnitPriceComparator.getWorldMap().iconStart();
											if (var8 == null) {
												Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = -1;
												Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = -1;
											} else {
												Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var8.getElement();
												Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var8.coord2.packed();
											}

											return 1;
										} else if (var0 == ScriptOpcodes.WORLDMAP_LISTELEMENT_NEXT) {
											var8 = GrandExchangeOfferUnitPriceComparator.getWorldMap().iconNext();
											if (var8 == null) {
												Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = -1;
												Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = -1;
											} else {
												Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var8.getElement();
												Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var8.coord2.packed();
											}

											return 1;
										} else {
											WorldMapElement var6;
											if (var0 == ScriptOpcodes.MEC_TEXT) {
												var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
												var6 = PacketBufferNode.WorldMapElement_get(var3);
												if (var6.name == null) {
													Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = "";
												} else {
													Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = var6.name;
												}

												return 1;
											} else if (var0 == ScriptOpcodes.MEC_TEXTSIZE) {
												var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
												var6 = PacketBufferNode.WorldMapElement_get(var3);
												Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var6.textSize;
												return 1;
											} else if (var0 == ScriptOpcodes.MEC_CATEGORY) {
												var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
												var6 = PacketBufferNode.WorldMapElement_get(var3);
												if (var6 == null) {
													Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = -1;
												} else {
													Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var6.category;
												}

												return 1;
											} else if (var0 == ScriptOpcodes.MEC_SPRITE) {
												var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
												var6 = PacketBufferNode.WorldMapElement_get(var3);
												if (var6 == null) {
													Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = -1;
												} else {
													Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var6.sprite1;
												}

												return 1;
											} else if (var0 == ScriptOpcodes.WORLDMAP_ELEMENT) {
												Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = WorldMapLabelSize.worldMapEvent.mapElement;
												return 1;
											} else if (var0 == 6698) {
												Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = WorldMapLabelSize.worldMapEvent.coord1.packed();
												return 1;
											} else if (var0 == ScriptOpcodes.WORLDMAP_ELEMENTCOORD) {
												Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = WorldMapLabelSize.worldMapEvent.coord2.packed();
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

	@ObfuscatedName("hx")
	@ObfuscatedSignature(
		signature = "(IB)Z",
		garbageValue = "124"
	)
	static final boolean method3383(int var0) {
		if (var0 < 0) {
			return false;
		} else {
			int var1 = Client.menuOpcodes[var0];
			if (var1 >= 2000) {
				var1 -= 2000;
			}

			return var1 == 1007;
		}
	}
}
