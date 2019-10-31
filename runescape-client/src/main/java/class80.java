import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ce")
public class class80 {
	@ObfuscatedName("qh")
	@ObfuscatedSignature(
		signature = "Ldq;"
	)
	@Export("pcmPlayer0")
	static PcmPlayer pcmPlayer0;
	@ObfuscatedName("v")
	static final BigInteger field1119;
	@ObfuscatedName("l")
	static final BigInteger field1120;

	static {
		field1119 = new BigInteger("80782894952180643741752986186714059433953886149239752893425047584684715842049");
		field1120 = new BigInteger("7237300117305667488707183861728052766358166655052137727439795191253340127955075499635575104901523446809299097934591732635674173519120047404024393881551683");
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1194202893"
	)
	public static void method2198() {
		class96.reflectionChecks = new IterableNodeDeque();
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(CLgw;I)C",
		garbageValue = "307690319"
	)
	@Export("standardizeChar")
	static char standardizeChar(char var0, Language var1) {
		if (var0 >= 192 && var0 <= 255) {
			if (var0 >= 192 && var0 <= 198) {
				return 'A';
			}

			if (var0 == 199) {
				return 'C';
			}

			if (var0 >= 200 && var0 <= 203) {
				return 'E';
			}

			if (var0 >= 204 && var0 <= 207) {
				return 'I';
			}

			if (var0 == 209 && var1 != Language.Language_ES) {
				return 'N';
			}

			if (var0 >= 210 && var0 <= 214) {
				return 'O';
			}

			if (var0 >= 217 && var0 <= 220) {
				return 'U';
			}

			if (var0 == 221) {
				return 'Y';
			}

			if (var0 == 223) {
				return 's';
			}

			if (var0 >= 224 && var0 <= 230) {
				return 'a';
			}

			if (var0 == 231) {
				return 'c';
			}

			if (var0 >= 232 && var0 <= 235) {
				return 'e';
			}

			if (var0 >= 236 && var0 <= 239) {
				return 'i';
			}

			if (var0 == 241 && var1 != Language.Language_ES) {
				return 'n';
			}

			if (var0 >= 242 && var0 <= 246) {
				return 'o';
			}

			if (var0 >= 249 && var0 <= 252) {
				return 'u';
			}

			if (var0 == 253 || var0 == 255) {
				return 'y';
			}
		}

		if (var0 == 338) {
			return 'O';
		} else if (var0 == 339) {
			return 'o';
		} else {
			return var0 == 376 ? 'Y' : var0;
		}
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "571659543"
	)
	public static void method2194(int var0) {
		class197.field2377 = 1;
		class247.musicTrackArchive = null;
		class189.musicTrackGroupId = -1;
		class197.musicTrackFileId = -1;
		class197.musicTrackVolume = 0;
		ScriptFrame.musicTrackBoolean = false;
		class197.field2384 = var0;
	}

	@ObfuscatedName("jx")
	@ObfuscatedSignature(
		signature = "(Lhi;IIB)V",
		garbageValue = "-53"
	)
	static final void method2197(Widget var0, int var1, int var2) {
		if (var0.buttonType == 1) {
			GameObject.insertMenuItemNoShift(var0.buttonText, "", 24, 0, 0, var0.id);
		}

		String var3;
		if (var0.buttonType == 2 && !Client.isSpellSelected) {
			var3 = SoundCache.method2666(var0);
			if (var3 != null) {
				GameObject.insertMenuItemNoShift(var3, AbstractArchive.colorStartTag(65280) + var0.spellName, 25, 0, -1, var0.id);
			}
		}

		if (var0.buttonType == 3) {
			GameObject.insertMenuItemNoShift("Close", "", 26, 0, 0, var0.id);
		}

		if (var0.buttonType == 4) {
			GameObject.insertMenuItemNoShift(var0.buttonText, "", 28, 0, 0, var0.id);
		}

		if (var0.buttonType == 5) {
			GameObject.insertMenuItemNoShift(var0.buttonText, "", 29, 0, 0, var0.id);
		}

		if (var0.buttonType == 6 && Client.meslayerContinueWidget == null) {
			GameObject.insertMenuItemNoShift(var0.buttonText, "", 30, 0, -1, var0.id);
		}

		int var4;
		int var5;
		int var19;
		if (var0.type == 2) {
			var19 = 0;

			for (var4 = 0; var4 < var0.height; ++var4) {
				for (var5 = 0; var5 < var0.width; ++var5) {
					int var6 = (var0.paddingX + 32) * var5;
					int var7 = (var0.paddingY + 32) * var4;
					if (var19 < 20) {
						var6 += var0.inventoryXOffsets[var19];
						var7 += var0.inventoryYOffsets[var19];
					}

					if (var1 >= var6 && var2 >= var7 && var1 < var6 + 32 && var2 < var7 + 32) {
						Client.dragItemSlotDestination = var19;
						DirectByteArrayCopier.field2476 = var0;
						if (var0.itemIds[var19] > 0) {
							label325: {
								ItemDefinition var8 = class222.ItemDefinition_get(var0.itemIds[var19] - 1);
								boolean var9;
								int var10;
								if (Client.isItemSelected == 1) {
									var10 = class195.getWidgetClickMask(var0);
									var9 = (var10 >> 30 & 1) != 0;
									if (var9) {
										if (var0.id != MidiPcmStream.selectedItemWidget || var19 != MouseRecorder.selectedItemSlot) {
											GameObject.insertMenuItemNoShift("Use", Client.selectedItemName + " " + "->" + " " + AbstractArchive.colorStartTag(16748608) + var8.name, 31, var8.id, var19, var0.id);
										}
										break label325;
									}
								}

								if (Client.isSpellSelected) {
									var10 = class195.getWidgetClickMask(var0);
									var9 = (var10 >> 30 & 1) != 0;
									if (var9) {
										if ((class81.selectedSpellFlags & 16) == 16) {
											GameObject.insertMenuItemNoShift(Client.selectedSpellActionName, Client.selectedSpellName + " " + "->" + " " + AbstractArchive.colorStartTag(16748608) + var8.name, 32, var8.id, var19, var0.id);
										}
										break label325;
									}
								}

								String[] var20 = var8.inventoryActions;
								var10 = -1;
								if (Client.shiftClickDrop && class222.method4272()) {
									var10 = var8.getShiftClickIndex();
								}

								int var12 = class195.getWidgetClickMask(var0);
								boolean var11 = (var12 >> 30 & 1) != 0;
								if (var11) {
									for (int var13 = 4; var13 >= 3; --var13) {
										if (var13 != var10) {
											Message.addWidgetItemMenuItem(var0, var8, var19, var13, false);
										}
									}
								}

								int var14 = class195.getWidgetClickMask(var0);
								boolean var24 = (var14 >> 31 & 1) != 0;
								if (var24) {
									GameObject.insertMenuItemNoShift("Use", AbstractArchive.colorStartTag(16748608) + var8.name, 38, var8.id, var19, var0.id);
								}

								int var16 = class195.getWidgetClickMask(var0);
								boolean var15 = (var16 >> 30 & 1) != 0;
								int var17;
								if (var15) {
									for (var17 = 2; var17 >= 0; --var17) {
										if (var17 != var10) {
											Message.addWidgetItemMenuItem(var0, var8, var19, var17, false);
										}
									}

									if (var10 >= 0) {
										Message.addWidgetItemMenuItem(var0, var8, var19, var10, true);
									}
								}

								var20 = var0.itemActions;
								if (var20 != null) {
									for (var17 = 4; var17 >= 0; --var17) {
										if (var20[var17] != null) {
											byte var18 = 0;
											if (var17 == 0) {
												var18 = 39;
											}

											if (var17 == 1) {
												var18 = 40;
											}

											if (var17 == 2) {
												var18 = 41;
											}

											if (var17 == 3) {
												var18 = 42;
											}

											if (var17 == 4) {
												var18 = 43;
											}

											GameObject.insertMenuItemNoShift(var20[var17], AbstractArchive.colorStartTag(16748608) + var8.name, var18, var8.id, var19, var0.id);
										}
									}
								}

								GameObject.insertMenuItemNoShift("Examine", AbstractArchive.colorStartTag(16748608) + var8.name, 1005, var8.id, var19, var0.id);
							}
						}
					}

					++var19;
				}
			}
		}

		if (var0.isIf3) {
			if (Client.isSpellSelected) {
				if (AbstractWorldMapData.method327(class195.getWidgetClickMask(var0)) && (class81.selectedSpellFlags & 32) == 32) {
					GameObject.insertMenuItemNoShift(Client.selectedSpellActionName, Client.selectedSpellName + " " + "->" + " " + var0.dataText, 58, 0, var0.childIndex, var0.id);
				}
			} else {
				for (var19 = 9; var19 >= 5; --var19) {
					String var21 = WorldMapData_0.method210(var0, var19);
					if (var21 != null) {
						GameObject.insertMenuItemNoShift(var21, var0.dataText, 1007, var19 + 1, var0.childIndex, var0.id);
					}
				}

				var3 = SoundCache.method2666(var0);
				if (var3 != null) {
					GameObject.insertMenuItemNoShift(var3, var0.dataText, 25, 0, var0.childIndex, var0.id);
				}

				for (var4 = 4; var4 >= 0; --var4) {
					String var22 = WorldMapData_0.method210(var0, var4);
					if (var22 != null) {
						ArchiveDiskAction.insertMenuItem(var22, var0.dataText, 57, var4 + 1, var0.childIndex, var0.id, var0.field2690);
					}
				}

				var5 = class195.getWidgetClickMask(var0);
				boolean var23 = (var5 & 1) != 0;
				if (var23) {
					GameObject.insertMenuItemNoShift("Continue", "", 30, 0, var0.childIndex, var0.id);
				}
			}
		}

	}
}
