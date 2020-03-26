import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("jb")
@Implements("IgnoreList")
public class IgnoreList extends UserList {
	@ObfuscatedName("bt")
	@ObfuscatedSignature(
		signature = "Lgl;"
	)
	@Export("clientLanguage")
	static Language clientLanguage;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lmx;"
	)
	@Export("loginType")
	final LoginType loginType;

	@ObfuscatedSignature(
		signature = "(Lmx;)V"
	)
	public IgnoreList(LoginType var1) {
		super(400);
		this.loginType = var1;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)Ljd;",
		garbageValue = "-1332552421"
	)
	@Export("newInstance")
	User newInstance() {
		return new Ignored();
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(II)[Ljd;",
		garbageValue = "-667029686"
	)
	@Export("newTypedArray")
	User[] newTypedArray(int var1) {
		return new Ignored[var1];
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(Lkb;II)V",
		garbageValue = "1156120193"
	)
	@Export("read")
	public void read(Buffer var1, int var2) {
		while (true) {
			if (var1.offset < var2) {
				int var3 = var1.readUnsignedByte();
				boolean var4 = (var3 & 1) == 1;
				Username var5 = new Username(var1.readStringCp1252NullTerminated(), this.loginType);
				Username var6 = new Username(var1.readStringCp1252NullTerminated(), this.loginType);
				var1.readStringCp1252NullTerminated();
				if (var5 != null && var5.hasCleanName()) {
					Ignored var7 = (Ignored)this.getByCurrentUsername(var5);
					if (var4) {
						Ignored var8 = (Ignored)this.getByCurrentUsername(var6);
						if (var8 != null && var8 != var7) {
							if (var7 != null) {
								this.remove(var8);
							} else {
								var7 = var8;
							}
						}
					}

					if (var7 != null) {
						this.changeName(var7, var5, var6);
						continue;
					}

					if (this.getSize() < 400) {
						int var9 = this.getSize();
						var7 = (Ignored)this.addLast(var5, var6);
						var7.id = var9;
					}
					continue;
				}

				throw new IllegalStateException();
			}

			return;
		}
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(IB)Lis;",
		garbageValue = "44"
	)
	@Export("getParamDefinition")
	public static ParamDefinition getParamDefinition(int var0) {
		ParamDefinition var1 = (ParamDefinition)ParamDefinition.ParamDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = ParamDefinition.ParamDefinition_archive.takeFile(11, var0);
			var1 = new ParamDefinition();
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			var1.postDecode();
			ParamDefinition.ParamDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		signature = "(ILce;ZI)I",
		garbageValue = "-372062346"
	)
	static int method5130(int var0, Script var1, boolean var2) {
		int var3;
		if (var0 == 6600) {
			var3 = ScriptEvent.Client_plane;
			int var9 = (ByteArrayPool.localPlayer.x >> 7) + class69.baseX;
			int var5 = (ByteArrayPool.localPlayer.y >> 7) + class89.baseY;
			class13.getWorldMap().method6524(var3, var9, var5, true);
			return 1;
		} else {
			WorldMapArea var11;
			if (var0 == ScriptOpcodes.WORLDMAP_GETMAPNAME) {
				var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				String var16 = "";
				var11 = class13.getWorldMap().getMapArea(var3);
				if (var11 != null) {
					var16 = var11.getExternalName();
				}

				Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var16;
				return 1;
			} else if (var0 == ScriptOpcodes.WORLDMAP_SETMAP) {
				var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				class13.getWorldMap().setCurrentMapAreaId(var3);
				return 1;
			} else if (var0 == ScriptOpcodes.WORLDMAP_GETZOOM) {
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class13.getWorldMap().getZoomLevel();
				return 1;
			} else if (var0 == ScriptOpcodes.WORLDMAP_SETZOOM) {
				var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				class13.getWorldMap().setZoomPercentage(var3);
				return 1;
			} else if (var0 == ScriptOpcodes.WORLDMAP_ISLOADED) {
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class13.getWorldMap().isCacheLoaded() ? 1 : 0;
				return 1;
			} else {
				Coord var15;
				if (var0 == ScriptOpcodes.WORLDMAP_JUMPTODISPLAYCOORD) {
					var15 = new Coord(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
					class13.getWorldMap().setWorldMapPositionTarget(var15.x, var15.y);
					return 1;
				} else if (var0 == ScriptOpcodes.WORLDMAP_JUMPTODISPLAYCOORD_INSTANT) {
					var15 = new Coord(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
					class13.getWorldMap().setWorldMapPositionTargetInstant(var15.x, var15.y);
					return 1;
				} else if (var0 == ScriptOpcodes.WORLDMAP_JUMPTOSOURCECOORD) {
					var15 = new Coord(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
					class13.getWorldMap().jumpToSourceCoord(var15.plane, var15.x, var15.y);
					return 1;
				} else if (var0 == ScriptOpcodes.WORLDMAP_JUMPTOSOURCECOORD_INSTANT) {
					var15 = new Coord(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
					class13.getWorldMap().jumpToSourceCoordInstant(var15.plane, var15.x, var15.y);
					return 1;
				} else if (var0 == ScriptOpcodes.WORLDMAP_GETDISPLAYPOSITION) {
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class13.getWorldMap().getDisplayX();
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class13.getWorldMap().getDisplayY();
					return 1;
				} else {
					WorldMapArea var13;
					if (var0 == ScriptOpcodes.WORLDMAP_GETCONFIGORIGIN) {
						var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
						var13 = class13.getWorldMap().getMapArea(var3);
						if (var13 == null) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
						} else {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var13.getOrigin().packed();
						}

						return 1;
					} else if (var0 == ScriptOpcodes.WORLDMAP_GETCONFIGSIZE) {
						var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
						var13 = class13.getWorldMap().getMapArea(var3);
						if (var13 == null) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
						} else {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = (var13.getRegionHighX() - var13.getRegionLowX() + 1) * 64;
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = (var13.getRegionHighY() - var13.getRegionLowY() + 1) * 64;
						}

						return 1;
					} else if (var0 == ScriptOpcodes.WORLDMAP_GETCONFIGBOUNDS) {
						var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
						var13 = class13.getWorldMap().getMapArea(var3);
						if (var13 == null) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
						} else {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var13.getRegionLowX() * 64;
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var13.getRegionLowY() * 64;
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var13.getRegionHighX() * 64 + 64 - 1;
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var13.getRegionHighY() * 64 + 64 - 1;
						}

						return 1;
					} else if (var0 == ScriptOpcodes.WORLDMAP_GETCONFIGZOOM) {
						var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
						var13 = class13.getWorldMap().getMapArea(var3);
						if (var13 == null) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
						} else {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var13.getZoom();
						}

						return 1;
					} else if (var0 == 6615) {
						var15 = class13.getWorldMap().getDisplayCoord();
						if (var15 == null) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
						} else {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var15.x;
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var15.y;
						}

						return 1;
					} else if (var0 == ScriptOpcodes.WORLDMAP_GETCURRENTMAP) {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class13.getWorldMap().currentMapAreaId();
						return 1;
					} else if (var0 == ScriptOpcodes.WORLDMAP_GETDISPLAYCOORD) {
						var15 = new Coord(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
						var13 = class13.getWorldMap().getCurrentMapArea();
						if (var13 == null) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
							return 1;
						} else {
							int[] var14 = var13.position(var15.plane, var15.x, var15.y);
							if (var14 == null) {
								Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
								Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
							} else {
								Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var14[0];
								Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var14[1];
							}

							return 1;
						}
					} else {
						Coord var7;
						if (var0 == 6618) {
							var15 = new Coord(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
							var13 = class13.getWorldMap().getCurrentMapArea();
							if (var13 == null) {
								Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
								Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
								return 1;
							} else {
								var7 = var13.coord(var15.x, var15.y);
								if (var7 == null) {
									Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
								} else {
									Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var7.packed();
								}

								return 1;
							}
						} else {
							Coord var12;
							if (var0 == 6619) {
								Interpreter.Interpreter_intStackSize -= 2;
								var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
								var12 = new Coord(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]);
								class3.method57(var3, var12, false);
								return 1;
							} else if (var0 == 6620) {
								Interpreter.Interpreter_intStackSize -= 2;
								var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
								var12 = new Coord(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]);
								class3.method57(var3, var12, true);
								return 1;
							} else if (var0 == ScriptOpcodes.WORLDMAP_COORDINMAP) {
								Interpreter.Interpreter_intStackSize -= 2;
								var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
								var12 = new Coord(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]);
								var11 = class13.getWorldMap().getMapArea(var3);
								if (var11 == null) {
									Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
									return 1;
								} else {
									Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var11.containsCoord(var12.plane, var12.x, var12.y) ? 1 : 0;
									return 1;
								}
							} else if (var0 == ScriptOpcodes.WORLDMAP_GETSIZE) {
								Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class13.getWorldMap().getDisplayWith();
								Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class13.getWorldMap().getDisplayHeight();
								return 1;
							} else if (var0 == 6623) {
								var15 = new Coord(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
								var13 = class13.getWorldMap().mapAreaAtCoord(var15.plane, var15.x, var15.y);
								if (var13 == null) {
									Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
								} else {
									Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var13.getId();
								}

								return 1;
							} else if (var0 == 6624) {
								class13.getWorldMap().setMaxFlashCount(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
								return 1;
							} else if (var0 == 6625) {
								class13.getWorldMap().resetMaxFlashCount();
								return 1;
							} else if (var0 == 6626) {
								class13.getWorldMap().setCyclesPerFlash(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
								return 1;
							} else if (var0 == 6627) {
								class13.getWorldMap().resetCyclesPerFlash();
								return 1;
							} else {
								boolean var10;
								if (var0 == ScriptOpcodes.WORLDMAP_PERPETUALFLASH) {
									var10 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
									class13.getWorldMap().setPerpetualFlash(var10);
									return 1;
								} else if (var0 == ScriptOpcodes.WORLDMAP_FLASHELEMENT) {
									var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
									class13.getWorldMap().flashElement(var3);
									return 1;
								} else if (var0 == ScriptOpcodes.WORLDMAP_FLASHELEMENTCATEGORY) {
									var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
									class13.getWorldMap().flashCategory(var3);
									return 1;
								} else if (var0 == ScriptOpcodes.WORLDMAP_STOPCURRENTFLASHES) {
									class13.getWorldMap().stopCurrentFlashes();
									return 1;
								} else if (var0 == ScriptOpcodes.WORLDMAP_DISABLEELEMENTS) {
									var10 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
									class13.getWorldMap().setElementsDisabled(var10);
									return 1;
								} else {
									boolean var4;
									if (var0 == ScriptOpcodes.WORLDMAP_DISABLEELEMENT) {
										Interpreter.Interpreter_intStackSize -= 2;
										var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
										var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1] == 1;
										class13.getWorldMap().disableElement(var3, var4);
										return 1;
									} else if (var0 == ScriptOpcodes.WORLDMAP_DISABLEELEMENTCATEGORY) {
										Interpreter.Interpreter_intStackSize -= 2;
										var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
										var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1] == 1;
										class13.getWorldMap().setCategoryDisabled(var3, var4);
										return 1;
									} else if (var0 == ScriptOpcodes.WORLDMAP_GETDISABLEELEMENTS) {
										Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class13.getWorldMap().getElementsDisabled() ? 1 : 0;
										return 1;
									} else if (var0 == ScriptOpcodes.WORLDMAP_GETDISABLEELEMENT) {
										var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
										Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class13.getWorldMap().isElementDisabled(var3) ? 1 : 0;
										return 1;
									} else if (var0 == ScriptOpcodes.WORLDMAP_GETDISABLEELEMENTCATEGORY) {
										var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
										Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class13.getWorldMap().isCategoryDisabled(var3) ? 1 : 0;
										return 1;
									} else if (var0 == 6638) {
										Interpreter.Interpreter_intStackSize -= 2;
										var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
										var12 = new Coord(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]);
										var7 = class13.getWorldMap().method6470(var3, var12);
										if (var7 == null) {
											Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
										} else {
											Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var7.packed();
										}

										return 1;
									} else {
										AbstractWorldMapIcon var8;
										if (var0 == ScriptOpcodes.WORLDMAP_LISTELEMENT_START) {
											var8 = class13.getWorldMap().iconStart();
											if (var8 == null) {
												Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
												Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
											} else {
												Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var8.getElement();
												Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var8.coord2.packed();
											}

											return 1;
										} else if (var0 == ScriptOpcodes.WORLDMAP_LISTELEMENT_NEXT) {
											var8 = class13.getWorldMap().iconNext();
											if (var8 == null) {
												Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
												Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
											} else {
												Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var8.getElement();
												Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var8.coord2.packed();
											}

											return 1;
										} else {
											WorldMapElement var6;
											if (var0 == ScriptOpcodes.MEC_TEXT) {
												var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
												var6 = class25.WorldMapElement_get(var3);
												if (var6.name == null) {
													Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
												} else {
													Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var6.name;
												}

												return 1;
											} else if (var0 == ScriptOpcodes.MEC_TEXTSIZE) {
												var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
												var6 = class25.WorldMapElement_get(var3);
												Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var6.textSize;
												return 1;
											} else if (var0 == ScriptOpcodes.MEC_CATEGORY) {
												var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
												var6 = class25.WorldMapElement_get(var3);
												if (var6 == null) {
													Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
												} else {
													Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var6.category;
												}

												return 1;
											} else if (var0 == ScriptOpcodes.MEC_SPRITE) {
												var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
												var6 = class25.WorldMapElement_get(var3);
												if (var6 == null) {
													Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
												} else {
													Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var6.sprite1;
												}

												return 1;
											} else if (var0 == ScriptOpcodes.WORLDMAP_ELEMENT) {
												Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = TileItem.worldMapEvent.mapElement;
												return 1;
											} else if (var0 == 6698) {
												Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = TileItem.worldMapEvent.coord1.packed();
												return 1;
											} else if (var0 == ScriptOpcodes.WORLDMAP_ELEMENTCOORD) {
												Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = TileItem.worldMapEvent.coord2.packed();
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

	@ObfuscatedName("ix")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Ljava/lang/String;IIIIB)V",
		garbageValue = "114"
	)
	@Export("insertMenuItemNoShift")
	public static final void insertMenuItemNoShift(String var0, String var1, int var2, int var3, int var4, int var5) {
		ScriptFrame.insertMenuItem(var0, var1, var2, var3, var4, var5, false);
	}
}
