import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hd")
@Implements("PlayerAppearance")
public class PlayerAppearance {
	@ObfuscatedName("h")
	public static short[] field2548;
	@ObfuscatedName("w")
	public static short[] field2542;
	@ObfuscatedName("k")
	@Export("equipmentIndices")
	static final int[] equipmentIndices;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lef;"
	)
	@Export("PlayerAppearance_cachedModels")
	static EvictingDualNodeHashTable PlayerAppearance_cachedModels;
	@ObfuscatedName("eo")
	static int[] field2552;
	@ObfuscatedName("u")
	@Export("equipment")
	int[] equipment;
	@ObfuscatedName("f")
	@Export("bodyColors")
	int[] bodyColors;
	@ObfuscatedName("b")
	@Export("isFemale")
	public boolean isFemale;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -1659743431
	)
	@Export("npcTransformId")
	public int npcTransformId;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		longValue = 8570520165784208047L
	)
	@Export("hash")
	long hash;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		longValue = -3088053679670010611L
	)
	long field2546;

	static {
		equipmentIndices = new int[]{8, 11, 4, 6, 9, 7, 10};
		PlayerAppearance_cachedModels = new EvictingDualNodeHashTable(260);
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "([I[IZII)V",
		garbageValue = "-1744492323"
	)
	@Export("update")
	public void update(int[] var1, int[] var2, boolean var3, int var4) {
		if (var1 == null) {
			var1 = new int[12];

			for (int var5 = 0; var5 < 7; ++var5) {
				for (int var6 = 0; var6 < KitDefinition.KitDefinition_fileCount; ++var6) {
					KitDefinition var7 = Players.KitDefinition_get(var6);
					if (var7 != null && !var7.nonSelectable && var7.bodypartID == (var3 ? 7 : 0) + var5) {
						var1[equipmentIndices[var5]] = var6 + 256;
						break;
					}
				}
			}
		}

		this.equipment = var1;
		this.bodyColors = var2;
		this.isFemale = var3;
		this.npcTransformId = var4;
		this.setHash();
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(IZB)V",
		garbageValue = "7"
	)
	@Export("changeAppearance")
	public void changeAppearance(int var1, boolean var2) {
		if (var1 != 1 || !this.isFemale) {
			int var3 = this.equipment[equipmentIndices[var1]];
			if (var3 != 0) {
				var3 -= 256;

				KitDefinition var4;
				do {
					if (!var2) {
						--var3;
						if (var3 < 0) {
							var3 = KitDefinition.KitDefinition_fileCount - 1;
						}
					} else {
						++var3;
						if (var3 >= KitDefinition.KitDefinition_fileCount) {
							var3 = 0;
						}
					}

					var4 = Players.KitDefinition_get(var3);
				} while(var4 == null || var4.nonSelectable || var4.bodypartID != var1 + (this.isFemale ? 7 : 0));

				this.equipment[equipmentIndices[var1]] = var3 + 256;
				this.setHash();
			}
		}
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(IZI)V",
		garbageValue = "1401975523"
	)
	public void method4068(int var1, boolean var2) {
		int var3 = this.bodyColors[var1];
		if (!var2) {
			do {
				--var3;
				if (var3 < 0) {
					var3 = ArchiveLoader.field533[var1].length - 1;
				}
			} while(!RouteStrategy.method3638(var1, var3));
		} else {
			do {
				++var3;
				if (var3 >= ArchiveLoader.field533[var1].length) {
					var3 = 0;
				}
			} while(!RouteStrategy.method3638(var1, var3));
		}

		this.bodyColors[var1] = var3;
		this.setHash();
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(ZB)V",
		garbageValue = "18"
	)
	@Export("changeSex")
	public void changeSex(boolean var1) {
		if (this.isFemale != var1) {
			this.update((int[])null, this.bodyColors, var1, -1);
		}
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Lkg;B)V",
		garbageValue = "-112"
	)
	@Export("write")
	public void write(Buffer var1) {
		var1.writeByte(this.isFemale ? 1 : 0);

		int var2;
		for (var2 = 0; var2 < 7; ++var2) {
			int var3 = this.equipment[equipmentIndices[var2]];
			if (var3 == 0) {
				var1.writeByte(-1);
			} else {
				var1.writeByte(var3 - 256);
			}
		}

		for (var2 = 0; var2 < 5; ++var2) {
			var1.writeByte(this.bodyColors[var2]);
		}

	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1306042907"
	)
	@Export("setHash")
	void setHash()
	{
		long var1 = this.hash;
		int var3 = this.equipment[5];
		int var4 = this.equipment[9];
		this.equipment[5] = var4;
		this.equipment[9] = var3;
		this.hash = 0L;

		int var5;
		for (var5 = 0; var5 < 12; ++var5)
		{
			this.hash <<= 4;
			if (this.equipment[var5] >= 256)
			{
				this.hash += (long) (this.equipment[var5] - 256);
			}
		}

		if (this.equipment[0] >= 256)
		{
			this.hash += (long) (this.equipment[0] - 256 >> 4);
		}

		if (this.equipment[1] >= 256)
		{
			this.hash += (long) (this.equipment[1] - 256 >> 8);
		}

		for (var5 = 0; var5 < 5; ++var5)
		{
			this.hash <<= 3;
			this.hash += (long) this.bodyColors[var5];
		}

		this.hash <<= 1;
		this.hash += (long) (this.isFemale ? 1 : 0);
		this.equipment[5] = var3;
		this.equipment[9] = var4;
		if (0L != var1 && this.hash != var1)
		{
			PlayerAppearance_cachedModels.remove(var1);
		}

	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(Liy;ILiy;IB)Ldf;",
		garbageValue = "20"
	)
	@Export("getModel")
	public Model getModel(SequenceDefinition var1, int var2, SequenceDefinition var3, int var4) {
		if (this.npcTransformId != -1) {
			return VarcInt.getNpcDefinition(this.npcTransformId).getModel(var1, var2, var3, var4);
		} else
		{
			long var5 = this.hash;
			int[] var7 = this.equipment;
			if (var1 != null && (var1.shield >= 0 || var1.weapon >= 0))
			{
				var7 = new int[12];

				for (int var15 = 0; var15 < 12; ++var15)
				{
					var7[var15] = this.equipment[var15];
				}

				if (var1.shield >= 0)
				{
					var5 += (long) (var1.shield - this.equipment[5] << 40);
					var7[5] = var1.shield;
				}

				if (var1.weapon >= 0) {
					var5 += (long)(var1.weapon - this.equipment[3] << 48);
					var7[3] = var1.weapon;
				}
			}

			Model var8 = (Model)PlayerAppearance_cachedModels.get(var5);
			if (var8 == null) {
				boolean var9 = false;

				int var11;
				for (int var10 = 0; var10 < 12; ++var10) {
					var11 = var7[var10];
					if (var11 >= 256 && var11 < 512 && !Players.KitDefinition_get(var11 - 256).ready()) {
						var9 = true;
					}

					if (var11 >= 512 && !Interpreter.ItemDefinition_get(var11 - 512).hasNoValidModel(this.isFemale)) {
						var9 = true;
					}
				}

				if (var9) {
					if (this.field2546 != -1L) {
						var8 = (Model)PlayerAppearance_cachedModels.get(this.field2546);
					}

					if (var8 == null) {
						return null;
					}
				}

				if (var8 == null) {
					ModelData[] var16 = new ModelData[12];
					var11 = 0;

					int var13;
					for (int var12 = 0; var12 < 12; ++var12) {
						var13 = var7[var12];
						ModelData var14;
						if (var13 >= 256 && var13 < 512) {
							var14 = Players.KitDefinition_get(var13 - 256).getModelData();
							if (var14 != null) {
								var16[var11++] = var14;
							}
						}

						if (var13 >= 512) {
							var14 = Interpreter.ItemDefinition_get(var13 - 512).method4746(this.isFemale);
							if (var14 != null) {
								var16[var11++] = var14;
							}
						}
					}

					ModelData var18 = new ModelData(var16, var11);

					for (var13 = 0; var13 < 5; ++var13) {
						if (this.bodyColors[var13] < ArchiveLoader.field533[var13].length) {
							var18.recolor(field2548[var13], ArchiveLoader.field533[var13][this.bodyColors[var13]]);
						}

						if (this.bodyColors[var13] < TileItemPile.field1537[var13].length) {
							var18.recolor(field2542[var13], TileItemPile.field1537[var13][this.bodyColors[var13]]);
						}
					}

					var8 = var18.toModel(64, 850, -30, -50, -30);
					PlayerAppearance_cachedModels.put(var8, var5);
					this.field2546 = var5;
				}
			}

			if (var1 == null && var3 == null) {
				return var8;
			} else {
				Model var17;
				if (var1 != null && var3 != null) {
					var17 = var1.applyTransformations(var8, var2, var3, var4);
				} else if (var1 != null) {
					var17 = var1.transformActorModel(var8, var2);
				} else {
					var17 = var3.transformActorModel(var8, var4);
				}

				return var17;
			}
		}
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(I)Ldq;",
		garbageValue = "1920849023"
	)
	@Export("getModelData")
	ModelData getModelData() {
		if (this.npcTransformId != -1) {
			return VarcInt.getNpcDefinition(this.npcTransformId).getModelData();
		} else {
			boolean var1 = false;

			int var3;
			for (int var2 = 0; var2 < 12; ++var2) {
				var3 = this.equipment[var2];
				if (var3 >= 256 && var3 < 512 && !Players.KitDefinition_get(var3 - 256).method4535()) {
					var1 = true;
				}

				if (var3 >= 512 && !Interpreter.ItemDefinition_get(var3 - 512).method4754(this.isFemale)) {
					var1 = true;
				}
			}

			if (var1) {
				return null;
			} else {
				ModelData[] var7 = new ModelData[12];
				var3 = 0;

				int var5;
				for (int var4 = 0; var4 < 12; ++var4) {
					var5 = this.equipment[var4];
					ModelData var6;
					if (var5 >= 256 && var5 < 512) {
						var6 = Players.KitDefinition_get(var5 - 256).getKitDefinitionModels();
						if (var6 != null) {
							var7[var3++] = var6;
						}
					}

					if (var5 >= 512) {
						var6 = Interpreter.ItemDefinition_get(var5 - 512).method4755(this.isFemale);
						if (var6 != null) {
							var7[var3++] = var6;
						}
					}
				}

				ModelData var8 = new ModelData(var7, var3);

				for (var5 = 0; var5 < 5; ++var5) {
					if (this.bodyColors[var5] < ArchiveLoader.field533[var5].length) {
						var8.recolor(field2548[var5], ArchiveLoader.field533[var5][this.bodyColors[var5]]);
					}

					if (this.bodyColors[var5] < TileItemPile.field1537[var5].length) {
						var8.recolor(field2542[var5], TileItemPile.field1537[var5][this.bodyColors[var5]]);
					}
				}

				return var8;
			}
		}
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "-123"
	)
	@Export("getChatHeadId")
	public int getChatHeadId() {
		return this.npcTransformId == -1 ? (this.equipment[0] << 15) + this.equipment[1] + (this.equipment[11] << 5) + (this.equipment[8] << 10) + (this.bodyColors[0] << 25) + (this.bodyColors[4] << 20) : 305419896 + VarcInt.getNpcDefinition(this.npcTransformId).id;
	}

	@ObfuscatedName("jz")
	@ObfuscatedSignature(
		signature = "(Lhl;III)V",
		garbageValue = "1826770393"
	)
	static final void method4079(Widget var0, int var1, int var2) {
		if (var0.buttonType == 1) {
			WorldMapSprite.insertMenuItemNoShift(var0.buttonText, "", 24, 0, 0, var0.id);
		}

		String var3;
		if (var0.buttonType == 2 && !Client.isSpellSelected) {
			var3 = LoginPacket.method3662(var0);
			if (var3 != null) {
				WorldMapSprite.insertMenuItemNoShift(var3, class222.colorStartTag(65280) + var0.spellName, 25, 0, -1, var0.id);
			}
		}

		if (var0.buttonType == 3) {
			WorldMapSprite.insertMenuItemNoShift("Close", "", 26, 0, 0, var0.id);
		}

		if (var0.buttonType == 4) {
			WorldMapSprite.insertMenuItemNoShift(var0.buttonText, "", 28, 0, 0, var0.id);
		}

		if (var0.buttonType == 5) {
			WorldMapSprite.insertMenuItemNoShift(var0.buttonText, "", 29, 0, 0, var0.id);
		}

		if (var0.buttonType == 6 && Client.meslayerContinueWidget == null) {
			WorldMapSprite.insertMenuItemNoShift(var0.buttonText, "", 30, 0, -1, var0.id);
		}

		int var4;
		int var17;
		if (var0.type == 2) {
			var17 = 0;

			for (var4 = 0; var4 < var0.height; ++var4) {
				for (int var5 = 0; var5 < var0.width; ++var5) {
					int var6 = (var0.paddingX + 32) * var5;
					int var7 = (var0.paddingY + 32) * var4;
					if (var17 < 20) {
						var6 += var0.inventoryXOffsets[var17];
						var7 += var0.inventoryYOffsets[var17];
					}

					if (var1 >= var6 && var2 >= var7 && var1 < var6 + 32 && var2 < var7 + 32) {
						Client.dragItemSlotDestination = var17;
						FloorOverlayDefinition.field3507 = var0;
						if (var0.itemIds[var17] > 0) {
							label318: {
								ItemDefinition var8 = Interpreter.ItemDefinition_get(var0.itemIds[var17] - 1);
								boolean var9;
								int var10;
								if (Client.isItemSelected == 1) {
									var10 = MenuAction.getWidgetClickMask(var0);
									var9 = (var10 >> 30 & 1) != 0;
									if (var9) {
										if (var0.id != class1.selectedItemWidget || var17 != class43.selectedItemSlot) {
											WorldMapSprite.insertMenuItemNoShift("Use", Client.selectedItemName + " " + "->" + " " + class222.colorStartTag(16748608) + var8.name, 31, var8.id, var17, var0.id);
										}
										break label318;
									}
								}

								if (Client.isSpellSelected) {
									var10 = MenuAction.getWidgetClickMask(var0);
									var9 = (var10 >> 30 & 1) != 0;
									if (var9) {
										if ((Actor.selectedSpellFlags & 16) == 16) {
											WorldMapSprite.insertMenuItemNoShift(Client.selectedSpellActionName, Client.selectedSpellName + " " + "->" + " " + class222.colorStartTag(16748608) + var8.name, 32, var8.id, var17, var0.id);
										}
										break label318;
									}
								}

								String[] var18 = var8.inventoryActions;
								var10 = -1;
								if (Client.shiftClickDrop && PendingSpawn.method1751()) {
									var10 = var8.getShiftClickIndex();
								}

								int var12 = MenuAction.getWidgetClickMask(var0);
								boolean var11 = (var12 >> 30 & 1) != 0;
								if (var11) {
									for (int var13 = 4; var13 >= 3; --var13) {
										if (var13 != var10) {
											WorldMapRegion.addWidgetItemMenuItem(var0, var8, var17, var13, false);
										}
									}
								}

								Object var10000 = null;
								if (class189.method3699(MenuAction.getWidgetClickMask(var0))) {
									WorldMapSprite.insertMenuItemNoShift("Use", class222.colorStartTag(16748608) + var8.name, 38, var8.id, var17, var0.id);
								}

								int var14 = MenuAction.getWidgetClickMask(var0);
								boolean var21 = (var14 >> 30 & 1) != 0;
								int var15;
								if (var21) {
									for (var15 = 2; var15 >= 0; --var15) {
										if (var10 != var15) {
											WorldMapRegion.addWidgetItemMenuItem(var0, var8, var17, var15, false);
										}
									}

									if (var10 >= 0) {
										WorldMapRegion.addWidgetItemMenuItem(var0, var8, var17, var10, true);
									}
								}

								var18 = var0.itemActions;
								if (var18 != null) {
									for (var15 = 4; var15 >= 0; --var15) {
										if (var18[var15] != null) {
											byte var16 = 0;
											if (var15 == 0) {
												var16 = 39;
											}

											if (var15 == 1) {
												var16 = 40;
											}

											if (var15 == 2) {
												var16 = 41;
											}

											if (var15 == 3) {
												var16 = 42;
											}

											if (var15 == 4) {
												var16 = 43;
											}

											WorldMapSprite.insertMenuItemNoShift(var18[var15], class222.colorStartTag(16748608) + var8.name, var16, var8.id, var17, var0.id);
										}
									}
								}

								WorldMapSprite.insertMenuItemNoShift("Examine", class222.colorStartTag(16748608) + var8.name, 1005, var8.id, var17, var0.id);
							}
						}
					}

					++var17;
				}
			}
		}

		if (var0.isIf3) {
			if (Client.isSpellSelected) {
				var4 = MenuAction.getWidgetClickMask(var0);
				boolean var22 = (var4 >> 21 & 1) != 0;
				if (var22 && (Actor.selectedSpellFlags & 32) == 32) {
					WorldMapSprite.insertMenuItemNoShift(Client.selectedSpellActionName, Client.selectedSpellName + " " + "->" + " " + var0.dataText, 58, 0, var0.childIndex, var0.id);
				}
			} else {
				for (var17 = 9; var17 >= 5; --var17) {
					String var19 = UrlRequest.method3361(var0, var17);
					if (var19 != null) {
						WorldMapSprite.insertMenuItemNoShift(var19, var0.dataText, 1007, var17 + 1, var0.childIndex, var0.id);
					}
				}

				var3 = LoginPacket.method3662(var0);
				if (var3 != null) {
					WorldMapSprite.insertMenuItemNoShift(var3, var0.dataText, 25, 0, var0.childIndex, var0.id);
				}

				for (var4 = 4; var4 >= 0; --var4) {
					String var20 = UrlRequest.method3361(var0, var4);
					if (var20 != null) {
						class14.insertMenuItem(var20, var0.dataText, 57, var4 + 1, var0.childIndex, var0.id, var0.field2719);
					}
				}

				if (SoundCache.method2544(MenuAction.getWidgetClickMask(var0))) {
					WorldMapSprite.insertMenuItemNoShift("Continue", "", 30, 0, var0.childIndex, var0.id);
				}
			}
		}

	}
}
