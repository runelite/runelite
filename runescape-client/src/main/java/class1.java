import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("j")
final class class1 implements class0 {
	@ObfuscatedName("bj")
	@ObfuscatedSignature(
		signature = "[Llq;"
	)
	@Export("worldSelectFlagSprites")
	static IndexedSprite[] worldSelectFlagSprites;
	@ObfuscatedName("bq")
	static String field6;
	@ObfuscatedName("iz")
	@ObfuscatedGetter(
		intValue = 517474423
	)
	@Export("selectedItemId")
	static int selectedItemId;
	@ObfuscatedName("kp")
	@ObfuscatedGetter(
		intValue = -333767243
	)
	@Export("menuHeight")
	static int menuHeight;
	@ObfuscatedName("lk")
	@ObfuscatedSignature(
		signature = "Lcd;"
	)
	@Export("tempMenuAction")
	static MenuAction tempMenuAction;

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/Object;Lky;I)V",
		garbageValue = "254789492"
	)
	public void vmethod58(Object var1, Buffer var2) {
		this.method9((Integer)var1, var2);
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(Lky;I)Ljava/lang/Object;",
		garbageValue = "1267204541"
	)
	public Object vmethod70(Buffer var1) {
		return var1.readInt();
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/Integer;Lky;I)V",
		garbageValue = "-1964979998"
	)
	void method9(Integer var1, Buffer var2) {
		var2.writeInt(var1);
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "1888870541"
	)
	static void method21(int var0) {
		ItemContainer var1 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
		if (var1 != null) {
			var1.remove();
		}
	}

	@ObfuscatedName("fi")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "1"
	)
	static final void method18() {
		FloorOverlayDefinition.FloorOverlayDefinition_cached.clear();
		FloorUnderlayDefinition.FloorUnderlayDefinition_cached.clear();
		KitDefinition.KitDefinition_cached.clear();
		FontName.ObjectDefinition_clearCached();
		ArchiveLoader.NpcDefinition_clearCached();
		TileItemPile.method2700();
		SequenceDefinition.SequenceDefinition_cached.clear();
		SequenceDefinition.SequenceDefinition_cachedFrames.clear();
		TileItem.method2048();
		GrandExchangeOfferUnitPriceComparator.VarbitDefinition_clearCached();
		class51.method846();
		WorldMapData_0.method177();
		InvDefinition.HealthBarDefinition_clearCached();
		StructDefinition.StructDefinition_cached.clear();
		class13.ParamDefinition_clearCached();
		WorldMapSection2.WorldMapElement_clearCached();
		PlayerAppearance.PlayerAppearance_cachedModels.clear();
		GrandExchangeOfferAgeComparator.Widget_clearCached();
		((TextureProvider)Rasterizer3D.Rasterizer3D_textureLoader).clear();
		Script.Script_cached.clear();
		Client.archive0.clearFiles();
		class269.archive1.clearFiles();
		UserComparator8.archive3.clearFiles();
		WorldMapSprite.archive4.clearFiles();
		WorldMapDecoration.archive5.clearFiles();
		GrandExchangeEvent.archive6.clearFiles();
		class51.archive7.clearFiles();
		class2.archive8.clearFiles();
		WorldMapDecoration.archive9.clearFiles();
		GameObject.archive10.clearFiles();
		WorldMapRectangle.archive11.clearFiles();
		GameShell.archive12.clearFiles();
	}

	@ObfuscatedName("fq")
	@ObfuscatedSignature(
		signature = "(Lbu;II)V",
		garbageValue = "504714765"
	)
	@Export("calculateActorPosition")
	static final void calculateActorPosition(Actor var0, int var1) {
		if (var0.field941 > Client.cycle) {
			Tiles.method1075(var0);
		} else {
			int var2;
			int var3;
			int var4;
			int var5;
			int var7;
			if (var0.field965 >= Client.cycle) {
				if (var0.field965 == Client.cycle || var0.sequence == -1 || var0.sequenceDelay != 0 || var0.sequenceFrameCycle + 1 > Widget.SequenceDefinition_get(var0.sequence).frameLengths[var0.sequenceFrame]) {
					var2 = var0.field965 - var0.field941;
					var3 = Client.cycle - var0.field941;
					var4 = var0.field960 * 128 + var0.size * -178253824;
					var5 = var0.field954 * 128 + var0.size * -178253824;
					int var6 = var0.field961 * 128 + var0.size * -178253824;
					var7 = var0.field963 * 128 + var0.size * -178253824;
					var0.x = (var6 * var3 + var4 * (var2 - var3)) / var2;
					var0.y = (var3 * var7 + var5 * (var2 - var3)) / var2;
				}

				var0.field976 = 0;
				var0.orientation = var0.field966;
				var0.rotation = var0.orientation;
			} else {
				var0.movementSequence = var0.readySequence;
				if (var0.pathLength == 0) {
					var0.field976 = 0;
				} else {
					label301: {
						if (var0.sequence != -1 && var0.sequenceDelay == 0) {
							SequenceDefinition var11 = Widget.SequenceDefinition_get(var0.sequence);
							if (var0.field947 > 0 && var11.field3506 == 0) {
								++var0.field976;
								break label301;
							}

							if (var0.field947 <= 0 && var11.field3505 == 0) {
								++var0.field976;
								break label301;
							}
						}

						var2 = var0.x;
						var3 = var0.y;
						var4 = var0.pathX[var0.pathLength - 1] * 128 + var0.size * -178253824;
						var5 = var0.pathY[var0.pathLength - 1] * 128 + var0.size * -178253824;
						if (var2 < var4) {
							if (var3 < var5) {
								var0.orientation = 1280;
							} else if (var3 > var5) {
								var0.orientation = 1792;
							} else {
								var0.orientation = 1536;
							}
						} else if (var2 > var4) {
							if (var3 < var5) {
								var0.orientation = 768;
							} else if (var3 > var5) {
								var0.orientation = 256;
							} else {
								var0.orientation = 512;
							}
						} else if (var3 < var5) {
							var0.orientation = 1024;
						} else if (var3 > var5) {
							var0.orientation = 0;
						}

						byte var12 = var0.pathTraversed[var0.pathLength - 1];
						if (var4 - var2 <= 256 && var4 - var2 >= -256 && var5 - var3 <= 256 && var5 - var3 >= -256) {
							var7 = var0.orientation - var0.rotation & 2047;
							if (var7 > 1024) {
								var7 -= 2048;
							}

							int var8 = var0.walkBackSequence;
							if (var7 >= -256 && var7 <= 256) {
								var8 = var0.walkSequence;
							} else if (var7 >= 256 && var7 < 768) {
								var8 = var0.walkRightSequence;
							} else if (var7 >= -768 && var7 <= -256) {
								var8 = var0.walkLeftSequence;
							}

							if (var8 == -1) {
								var8 = var0.walkSequence;
							}

							var0.movementSequence = var8;
							int var9 = 4;
							boolean var10 = true;
							if (var0 instanceof NPC) {
								var10 = ((NPC)var0).definition.isClickable;
							}

							if (var10) {
								if (var0.rotation != var0.orientation && var0.targetIndex == -1 && var0.field971 != 0) {
									var9 = 2;
								}

								if (var0.pathLength > 2) {
									var9 = 6;
								}

								if (var0.pathLength > 3) {
									var9 = 8;
								}

								if (var0.field976 > 0 && var0.pathLength > 1) {
									var9 = 8;
									--var0.field976;
								}
							} else {
								if (var0.pathLength > 1) {
									var9 = 6;
								}

								if (var0.pathLength > 2) {
									var9 = 8;
								}

								if (var0.field976 > 0 && var0.pathLength > 1) {
									var9 = 8;
									--var0.field976;
								}
							}

							if (var12 == 2) {
								var9 <<= 1;
							}

							if (var9 >= 8 && var0.movementSequence == var0.walkSequence && var0.runSequence != -1) {
								var0.movementSequence = var0.runSequence;
							}

							if (var4 != var2 || var5 != var3) {
								if (var2 < var4) {
									var0.x += var9;
									if (var0.x > var4) {
										var0.x = var4;
									}
								} else if (var2 > var4) {
									var0.x -= var9;
									if (var0.x < var4) {
										var0.x = var4;
									}
								}

								if (var3 < var5) {
									var0.y += var9;
									if (var0.y > var5) {
										var0.y = var5;
									}
								} else if (var3 > var5) {
									var0.y -= var9;
									if (var0.y < var5) {
										var0.y = var5;
									}
								}
							}

							if (var4 == var0.x && var5 == var0.y) {
								--var0.pathLength;
								if (var0.field947 > 0) {
									--var0.field947;
								}
							}
						} else {
							var0.x = var4;
							var0.y = var5;
							--var0.pathLength;
							if (var0.field947 > 0) {
								--var0.field947;
							}
						}
					}
				}
			}
		}

		if (var0.x < 128 || var0.y < 128 || var0.x >= 13184 || var0.y >= 13184) {
			var0.sequence = -1;
			var0.spotAnimation = -1;
			var0.field941 = 0;
			var0.field965 = 0;
			var0.x = var0.pathX[0] * 128 + var0.size * -178253824;
			var0.y = var0.size * -178253824 + var0.pathY[0] * 128;
			var0.method1671();
		}

		if (WorldMapIcon_1.localPlayer == var0 && (var0.x < 1536 || var0.y < 1536 || var0.x >= 11776 || var0.y >= 11776)) {
			var0.sequence = -1;
			var0.spotAnimation = -1;
			var0.field941 = 0;
			var0.field965 = 0;
			var0.x = var0.size * -178253824 + var0.pathX[0] * 128;
			var0.y = var0.size * -178253824 + var0.pathY[0] * 128;
			var0.method1671();
		}

		class65.method1178(var0);
		GrandExchangeOfferNameComparator.method149(var0);
	}
}
