import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("g")
public class class3 implements Enumerated {
	@ObfuscatedName("nn")
	@ObfuscatedGetter(
		intValue = -1636147863
	)
	@Export("widgetDragDuration")
	static int widgetDragDuration;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lg;"
	)
	static final class3 field11;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lg;"
	)
	static final class3 field15;
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Lg;"
	)
	static final class3 field13;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 902958513
	)
	final int field14;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -1999157545
	)
	public final int field19;
	@ObfuscatedName("p")
	public final Class field16;
	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "Lu;"
	)
	final class0 field17;

	static {
		field11 = new class3(0, 0, Integer.class, new class1());
		field15 = new class3(2, 1, Long.class, new class2());
		field13 = new class3(1, 2, String.class, new class4());
	}

	@ObfuscatedSignature(
		signature = "(IILjava/lang/Class;Lu;)V"
	)
	class3(int var1, int var2, Class var3, class0 var4) {
		this.field14 = var1;
		this.field19 = var2;
		this.field16 = var3;
		this.field17 = var4;
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "7"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.field19;
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Lkg;I)Ljava/lang/Object;",
		garbageValue = "-1145343659"
	)
	public Object method40(Buffer var1) {
		return this.field17.vmethod65(var1);
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(I)[Lg;",
		garbageValue = "1593931350"
	)
	public static class3[] method45() {
		return new class3[]{field15, field11, field13};
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "([Ljava/lang/String;[SB)V",
		garbageValue = "94"
	)
	public static void method42(String[] var0, short[] var1) {
		Fonts.sortItemsByName(var0, var1, 0, var0.length - 1);
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/Object;Lkg;B)V",
		garbageValue = "-56"
	)
	public static void method37(Object var0, Buffer var1) {
		class0 var2 = method38(var0.getClass());
		var2.vmethod57(var0, var1);
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/Class;I)Lu;",
		garbageValue = "-1298257159"
	)
	static class0 method38(Class var0) {
		class3[] var2 = method45();
		int var3 = 0;

		class3 var1;
		while (true) {
			if (var3 >= var2.length) {
				var1 = null;
				break;
			}

			class3 var4 = var2[var3];
			if (var4.field16 == var0) {
				var1 = var4;
				break;
			}

			++var3;
		}

		if (var1 == null) {
			throw new IllegalArgumentException();
		} else {
			return var1.field17;
		}
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "56484455"
	)
	public static void method35() {
		ParamDefinition.ParamDefinition_cached.clear();
	}

	@ObfuscatedName("ft")
	@ObfuscatedSignature(
		signature = "(Lbt;II)V",
		garbageValue = "-1136770233"
	)
	@Export("updateActorSequence")
	static final void updateActorSequence(Actor var0, int var1) {
		SequenceDefinition var2;
		int var3;
		int var4;
		int var11;
		if (var0.field934 > Client.cycle) {
			UserComparator5.method3461(var0);
		} else if (var0.field982 >= Client.cycle) {
			WorldMapAreaData.method707(var0);
		} else {
			var0.movementSequence = var0.readySequence;
			if (var0.pathLength == 0) {
				var0.field976 = 0;
			} else {
				label545: {
					if (var0.sequence != -1 && var0.sequenceDelay == 0) {
						var2 = GrandExchangeOfferAgeComparator.SequenceDefinition_get(var0.sequence);
						if (var0.field994 > 0 && var2.field3531 == 0) {
							++var0.field976;
							break label545;
						}

						if (var0.field994 <= 0 && var2.field3515 == 0) {
							++var0.field976;
							break label545;
						}
					}

					var11 = var0.x;
					var3 = var0.y;
					var4 = var0.pathX[var0.pathLength - 1] * 128 + var0.field938 * 64;
					int var5 = var0.pathY[var0.pathLength - 1] * 128 + var0.field938 * 64;
					if (var11 < var4) {
						if (var3 < var5) {
							var0.orientation = 1280;
						} else if (var3 > var5) {
							var0.orientation = 1792;
						} else {
							var0.orientation = 1536;
						}
					} else if (var11 > var4) {
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

					byte var6 = var0.pathTraversed[var0.pathLength - 1];
					if (var4 - var11 <= 256 && var4 - var11 >= -256 && var5 - var3 <= 256 && var5 - var3 >= -256) {
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
							if (var0.orientation != var0.rotation && var0.targetIndex == -1 && var0.field988 != 0) {
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

						if (var6 == 2) {
							var9 <<= 1;
						}

						if (var9 >= 8 && var0.movementSequence == var0.walkSequence && var0.runSequence != -1) {
							var0.movementSequence = var0.runSequence;
						}

						if (var4 != var11 || var3 != var5) {
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
							if (var0.field994 > 0) {
								--var0.field994;
							}
						}
					} else {
						var0.x = var4;
						var0.y = var5;
						--var0.pathLength;
						if (var0.field994 > 0) {
							--var0.field994;
						}
					}
				}
			}
		}

		if (var0.x < 128 || var0.y < 128 || var0.x >= 13184 || var0.y >= 13184) {
			var0.sequence = -1;
			var0.spotAnimation = -1;
			var0.field934 = 0;
			var0.field982 = 0;
			var0.x = var0.pathX[0] * 128 + var0.field938 * 64;
			var0.y = var0.pathY[0] * 128 + var0.field938 * 64;
			var0.method1759();
		}

		if (class215.localPlayer == var0 && (var0.x < 1536 || var0.y < 1536 || var0.x >= 11776 || var0.y >= 11776)) {
			var0.sequence = -1;
			var0.spotAnimation = -1;
			var0.field934 = 0;
			var0.field982 = 0;
			var0.x = var0.pathX[0] * 128 + var0.field938 * 64;
			var0.y = var0.pathY[0] * 128 + var0.field938 * 64;
			var0.method1759();
		}

		if (var0.field988 != 0) {
			if (var0.targetIndex != -1) {
				Object var13 = null;
				if (var0.targetIndex < 32768) {
					var13 = Client.npcs[var0.targetIndex];
				} else if (var0.targetIndex >= 32768) {
					var13 = Client.players[var0.targetIndex - 32768];
				}

				if (var13 != null) {
					var3 = var0.x - ((Actor)var13).x;
					var4 = var0.y - ((Actor)var13).y;
					if (var3 != 0 || var4 != 0) {
						var0.orientation = (int)(Math.atan2((double)var3, (double)var4) * 325.949D) & 2047;
					}
				} else if (var0.false0) {
					var0.targetIndex = -1;
					var0.false0 = false;
				}
			}

			if (var0.field965 != -1 && (var0.pathLength == 0 || var0.field976 > 0)) {
				var0.orientation = var0.field965;
				var0.field965 = -1;
			}

			var11 = var0.orientation - var0.rotation & 2047;
			if (var11 == 0 && var0.false0) {
				var0.targetIndex = -1;
				var0.false0 = false;
			}

			if (var11 != 0) {
				++var0.field987;
				boolean var14;
				if (var11 > 1024) {
					var0.rotation -= var0.field988;
					var14 = true;
					if (var11 < var0.field988 || var11 > 2048 - var0.field988) {
						var0.rotation = var0.orientation;
						var14 = false;
					}

					if (var0.readySequence == var0.movementSequence && (var0.field987 > 25 || var14)) {
						if (var0.turnLeftSequence != -1) {
							var0.movementSequence = var0.turnLeftSequence;
						} else {
							var0.movementSequence = var0.walkSequence;
						}
					}
				} else {
					var0.rotation += var0.field988;
					var14 = true;
					if (var11 < var0.field988 || var11 > 2048 - var0.field988) {
						var0.rotation = var0.orientation;
						var14 = false;
					}

					if (var0.movementSequence == var0.readySequence && (var0.field987 > 25 || var14)) {
						if (var0.turnRightSequence != -1) {
							var0.movementSequence = var0.turnRightSequence;
						} else {
							var0.movementSequence = var0.walkSequence;
						}
					}
				}

				var0.rotation &= 2047;
			} else {
				var0.field987 = 0;
			}
		}

		var0.isWalking = false;
		if (var0.movementSequence != -1) {
			var2 = GrandExchangeOfferAgeComparator.SequenceDefinition_get(var0.movementSequence);
			if (var2 != null && var2.frameIds != null) {
				++var0.movementFrameCycle;
				if (var0.movementFrame < var2.frameIds.length && var0.movementFrameCycle > var2.frameLengths[var0.movementFrame]) {
					var0.movementFrameCycle = 1;
					++var0.movementFrame;
					InterfaceParent.addSequenceSoundEffect(var2, var0.movementFrame, var0.x, var0.y);
				}

				if (var0.movementFrame >= var2.frameIds.length) {
					var0.movementFrameCycle = 0;
					var0.movementFrame = 0;
					InterfaceParent.addSequenceSoundEffect(var2, var0.movementFrame, var0.x, var0.y);
				}
			} else {
				var0.movementSequence = -1;
			}
		}

		if (var0.spotAnimation != -1 && Client.cycle >= var0.field975) {
			if (var0.spotAnimationFrame < 0) {
				var0.spotAnimationFrame = 0;
			}

			var11 = WorldMapRegion.SpotAnimationDefinition_get(var0.spotAnimation).sequence;
			if (var11 != -1) {
				SequenceDefinition var12 = GrandExchangeOfferAgeComparator.SequenceDefinition_get(var11);
				if (var12 != null && var12.frameIds != null) {
					++var0.spotAnimationFrameCycle;
					if (var0.spotAnimationFrame < var12.frameIds.length && var0.spotAnimationFrameCycle > var12.frameLengths[var0.spotAnimationFrame]) {
						var0.spotAnimationFrameCycle = 1;
						++var0.spotAnimationFrame;
						InterfaceParent.addSequenceSoundEffect(var12, var0.spotAnimationFrame, var0.x, var0.y);
					}

					if (var0.spotAnimationFrame >= var12.frameIds.length && (var0.spotAnimationFrame < 0 || var0.spotAnimationFrame >= var12.frameIds.length)) {
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
			var2 = GrandExchangeOfferAgeComparator.SequenceDefinition_get(var0.sequence);
			if (var2.field3531 == 1 && var0.field994 > 0 && var0.field934 <= Client.cycle && var0.field982 < Client.cycle) {
				var0.sequenceDelay = 1;
				return;
			}
		}

		if (var0.sequence != -1 && var0.sequenceDelay == 0) {
			var2 = GrandExchangeOfferAgeComparator.SequenceDefinition_get(var0.sequence);
			if (var2 != null && var2.frameIds != null) {
				++var0.sequenceFrameCycle;
				if (var0.sequenceFrame < var2.frameIds.length && var0.sequenceFrameCycle > var2.frameLengths[var0.sequenceFrame]) {
					var0.sequenceFrameCycle = 1;
					++var0.sequenceFrame;
					InterfaceParent.addSequenceSoundEffect(var2, var0.sequenceFrame, var0.x, var0.y);
				}

				if (var0.sequenceFrame >= var2.frameIds.length) {
					var0.sequenceFrame -= var2.frameCount;
					++var0.field971;
					if (var0.field971 >= var2.field3516) {
						var0.sequence = -1;
					} else if (var0.sequenceFrame >= 0 && var0.sequenceFrame < var2.frameIds.length) {
						InterfaceParent.addSequenceSoundEffect(var2, var0.sequenceFrame, var0.x, var0.y);
					} else {
						var0.sequence = -1;
					}
				}

				var0.isWalking = var2.field3523;
			} else {
				var0.sequence = -1;
			}
		}

		if (var0.sequenceDelay > 0) {
			--var0.sequenceDelay;
		}

	}

	@ObfuscatedName("lu")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-31"
	)
	static void method41() {
		if (Client.oculusOrbState == 1) {
			Client.field826 = true;
		}

	}
}
