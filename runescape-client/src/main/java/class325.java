import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lo")
public class class325 {
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 2036297741
	)
	@Export("SpriteBuffer_spriteCount")
	static int SpriteBuffer_spriteCount;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -850597869
	)
	@Export("SpriteBuffer_spriteWidth")
	public static int SpriteBuffer_spriteWidth;
	@ObfuscatedName("u")
	@Export("SpriteBuffer_xOffsets")
	public static int[] SpriteBuffer_xOffsets;
	@ObfuscatedName("p")
	@Export("SpriteBuffer_spriteWidths")
	public static int[] SpriteBuffer_spriteWidths;
	@ObfuscatedName("m")
	@Export("SpriteBuffer_spritePalette")
	public static int[] SpriteBuffer_spritePalette;

	@ObfuscatedName("fu")
	@ObfuscatedSignature(
		signature = "(Lby;II)V",
		garbageValue = "771292121"
	)
	@Export("calculateActorPosition")
	static final void calculateActorPosition(Actor var0, int var1) {
		SequenceDefinition var2;
		int var4;
		int var11;
		int var12;
		if (var0.field948 > Client.cycle) {
			class191.method3639(var0);
		} else if (var0.field976 >= Client.cycle) {
			HealthBar.method2032(var0);
		} else {
			var0.movementSequence = var0.readySequence;
			if (var0.pathLength == 0) {
				var0.field949 = 0;
			} else {
				label548: {
					if (var0.sequence != -1 && var0.sequenceDelay == 0) {
						var2 = GrandExchangeOfferUnitPriceComparator.SequenceDefinition_get(var0.sequence);
						if (var0.field988 > 0 && var2.field3515 == 0) {
							++var0.field949;
							break label548;
						}

						if (var0.field988 <= 0 && var2.field3510 == 0) {
							++var0.field949;
							break label548;
						}
					}

					var11 = var0.x;
					var12 = var0.y;
					var4 = var0.pathX[var0.pathLength - 1] * 128 + var0.size * -527978816;
					int var5 = var0.size * -527978816 + var0.pathY[var0.pathLength - 1] * 128;
					if (var11 < var4) {
						if (var12 < var5) {
							var0.orientation = 1280;
						} else if (var12 > var5) {
							var0.orientation = 1792;
						} else {
							var0.orientation = 1536;
						}
					} else if (var11 > var4) {
						if (var12 < var5) {
							var0.orientation = 768;
						} else if (var12 > var5) {
							var0.orientation = 256;
						} else {
							var0.orientation = 512;
						}
					} else if (var12 < var5) {
						var0.orientation = 1024;
					} else if (var12 > var5) {
						var0.orientation = 0;
					}

					byte var6 = var0.pathTraversed[var0.pathLength - 1];
					if (var4 - var11 <= 256 && var4 - var11 >= -256 && var5 - var12 <= 256 && var5 - var12 >= -256) {
						int var7 = var0.orientation - var0.rotation & 2047;
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
							if (var0.rotation != var0.orientation && var0.targetIndex == -1 && var0.field982 != 0) {
								var9 = 2;
							}

							if (var0.pathLength > 2) {
								var9 = 6;
							}

							if (var0.pathLength > 3) {
								var9 = 8;
							}

							if (var0.field949 > 0 && var0.pathLength > 1) {
								var9 = 8;
								--var0.field949;
							}
						} else {
							if (var0.pathLength > 1) {
								var9 = 6;
							}

							if (var0.pathLength > 2) {
								var9 = 8;
							}

							if (var0.field949 > 0 && var0.pathLength > 1) {
								var9 = 8;
								--var0.field949;
							}
						}

						if (var6 == 2) {
							var9 <<= 1;
						}

						if (var9 >= 8 && var0.walkSequence == var0.movementSequence && var0.runSequence != -1) {
							var0.movementSequence = var0.runSequence;
						}

						if (var11 != var4 || var12 != var5) {
							if (var11 < var4) {
								var0.x += var9;
								if (var0.x > var4) {
									var0.x = var4;
								}
							} else if (var11 > var4) {
								var0.x -= var9;
								if (var0.x < var4) {
									var0.x = var4;
								}
							}

							if (var12 < var5) {
								var0.y += var9;
								if (var0.y > var5) {
									var0.y = var5;
								}
							} else if (var12 > var5) {
								var0.y -= var9;
								if (var0.y < var5) {
									var0.y = var5;
								}
							}
						}

						if (var4 == var0.x && var5 == var0.y) {
							--var0.pathLength;
							if (var0.field988 > 0) {
								--var0.field988;
							}
						}
					} else {
						var0.x = var4;
						var0.y = var5;
						--var0.pathLength;
						if (var0.field988 > 0) {
							--var0.field988;
						}
					}
				}
			}
		}

		if (var0.x < 128 || var0.y < 128 || var0.x >= 13184 || var0.y >= 13184) {
			var0.sequence = -1;
			var0.spotAnimation = -1;
			var0.field948 = 0;
			var0.field976 = 0;
			var0.x = var0.pathX[0] * 128 + var0.size * -527978816;
			var0.y = var0.size * -527978816 + var0.pathY[0] * 128;
			var0.method1765();
		}

		if (class223.localPlayer == var0 && (var0.x < 1536 || var0.y < 1536 || var0.x >= 11776 || var0.y >= 11776)) {
			var0.sequence = -1;
			var0.spotAnimation = -1;
			var0.field948 = 0;
			var0.field976 = 0;
			var0.x = var0.size * -527978816 + var0.pathX[0] * 128;
			var0.y = var0.size * -527978816 + var0.pathY[0] * 128;
			var0.method1765();
		}

		if (var0.field982 != 0) {
			if (var0.targetIndex != -1) {
				Object var13 = null;
				if (var0.targetIndex < 32768) {
					var13 = Client.npcs[var0.targetIndex];
				} else if (var0.targetIndex >= 32768) {
					var13 = Client.players[var0.targetIndex - 32768];
				}

				if (var13 != null) {
					var12 = var0.x - ((Actor)var13).x;
					var4 = var0.y - ((Actor)var13).y;
					if (var12 != 0 || var4 != 0) {
						var0.orientation = (int)(Math.atan2((double)var12, (double)var4) * 325.949D) & 2047;
					}
				} else if (var0.false0) {
					var0.targetIndex = -1;
					var0.false0 = false;
				}
			}

			if (var0.field957 != -1 && (var0.pathLength == 0 || var0.field949 > 0)) {
				var0.orientation = var0.field957;
				var0.field957 = -1;
			}

			var11 = var0.orientation - var0.rotation & 2047;
			if (var11 == 0 && var0.false0) {
				var0.targetIndex = -1;
				var0.false0 = false;
			}

			if (var11 != 0) {
				++var0.field981;
				boolean var14;
				if (var11 > 1024) {
					var0.rotation -= var0.field982;
					var14 = true;
					if (var11 < var0.field982 || var11 > 2048 - var0.field982) {
						var0.rotation = var0.orientation;
						var14 = false;
					}

					if (var0.readySequence == var0.movementSequence && (var0.field981 > 25 || var14)) {
						if (var0.turnLeftSequence != -1) {
							var0.movementSequence = var0.turnLeftSequence;
						} else {
							var0.movementSequence = var0.walkSequence;
						}
					}
				} else {
					var0.rotation += var0.field982;
					var14 = true;
					if (var11 < var0.field982 || var11 > 2048 - var0.field982) {
						var0.rotation = var0.orientation;
						var14 = false;
					}

					if (var0.movementSequence == var0.readySequence && (var0.field981 > 25 || var14)) {
						if (var0.turnRightSequence != -1) {
							var0.movementSequence = var0.turnRightSequence;
						} else {
							var0.movementSequence = var0.walkSequence;
						}
					}
				}

				var0.rotation &= 2047;
			} else {
				var0.field981 = 0;
			}
		}

		var0.isWalking = false;
		if (var0.movementSequence != -1) {
			var2 = GrandExchangeOfferUnitPriceComparator.SequenceDefinition_get(var0.movementSequence);
			if (var2 != null && var2.frameIds != null) {
				++var0.movementFrameCycle;
				if (var0.movementFrame < var2.frameIds.length && var0.movementFrameCycle > var2.frameLengths[var0.movementFrame]) {
					var0.movementFrameCycle = 1;
					++var0.movementFrame;
					class30.addSequenceSoundEffect(var2, var0.movementFrame, var0.x, var0.y);
				}

				if (var0.movementFrame >= var2.frameIds.length) {
					var0.movementFrameCycle = 0;
					var0.movementFrame = 0;
					class30.addSequenceSoundEffect(var2, var0.movementFrame, var0.x, var0.y);
				}
			} else {
				var0.movementSequence = -1;
			}
		}

		if (var0.spotAnimation != -1 && Client.cycle >= var0.field969) {
			if (var0.spotAnimationFrame < 0) {
				var0.spotAnimationFrame = 0;
			}

			var11 = InterfaceParent.SpotAnimationDefinition_get(var0.spotAnimation).sequence;
			if (var11 != -1) {
				SequenceDefinition var3 = GrandExchangeOfferUnitPriceComparator.SequenceDefinition_get(var11);
				if (var3 != null && var3.frameIds != null) {
					++var0.spotAnimationFrameCycle;
					if (var0.spotAnimationFrame < var3.frameIds.length && var0.spotAnimationFrameCycle > var3.frameLengths[var0.spotAnimationFrame]) {
						var0.spotAnimationFrameCycle = 1;
						++var0.spotAnimationFrame;
						class30.addSequenceSoundEffect(var3, var0.spotAnimationFrame, var0.x, var0.y);
					}

					if (var0.spotAnimationFrame >= var3.frameIds.length && (var0.spotAnimationFrame < 0 || var0.spotAnimationFrame >= var3.frameIds.length)) {
						var0.spotAnimation = -1;
					}
				} else {
					var0.spotAnimation = -1;
				}
			} else {
				var0.spotAnimation = -1;
			}
		}

		if (var0.sequence != -1 && var0.sequenceDelay <= 1) {
			var2 = GrandExchangeOfferUnitPriceComparator.SequenceDefinition_get(var0.sequence);
			if (var2.field3515 == 1 && var0.field988 > 0 && var0.field948 <= Client.cycle && var0.field976 < Client.cycle) {
				var0.sequenceDelay = 1;
				return;
			}
		}

		if (var0.sequence != -1 && var0.sequenceDelay == 0) {
			var2 = GrandExchangeOfferUnitPriceComparator.SequenceDefinition_get(var0.sequence);
			if (var2 != null && var2.frameIds != null) {
				++var0.sequenceFrameCycle;
				if (var0.sequenceFrame < var2.frameIds.length && var0.sequenceFrameCycle > var2.frameLengths[var0.sequenceFrame]) {
					var0.sequenceFrameCycle = 1;
					++var0.sequenceFrame;
					class30.addSequenceSoundEffect(var2, var0.sequenceFrame, var0.x, var0.y);
				}

				if (var0.sequenceFrame >= var2.frameIds.length) {
					var0.sequenceFrame -= var2.frameCount;
					++var0.field965;
					if (var0.field965 >= var2.field3503) {
						var0.sequence = -1;
					} else if (var0.sequenceFrame >= 0 && var0.sequenceFrame < var2.frameIds.length) {
						class30.addSequenceSoundEffect(var2, var0.sequenceFrame, var0.x, var0.y);
					} else {
						var0.sequence = -1;
					}
				}

				var0.isWalking = var2.field3504;
			} else {
				var0.sequence = -1;
			}
		}

		if (var0.sequenceDelay > 0) {
			--var0.sequenceDelay;
		}

	}

	@ObfuscatedName("jc")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-761836956"
	)
	static void method6190() {
		for (InterfaceParent var0 = (InterfaceParent)Client.interfaceParents.first(); var0 != null; var0 = (InterfaceParent)Client.interfaceParents.next()) {
			int var1 = var0.group;
			if (WorldMapData_0.loadInterface(var1)) {
				boolean var2 = true;
				Widget[] var3 = UserComparator5.Widget_interfaceComponents[var1];

				int var4;
				for (var4 = 0; var4 < var3.length; ++var4) {
					if (var3[var4] != null) {
						var2 = var3[var4].isIf3;
						break;
					}
				}

				if (!var2) {
					var4 = (int)var0.key;
					Widget var5 = Canvas.getWidget(var4);
					if (var5 != null) {
						WorldMapSectionType.invalidateWidget(var5);
					}
				}
			}
		}

	}
}
