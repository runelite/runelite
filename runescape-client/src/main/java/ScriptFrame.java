import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bb")
@Implements("ScriptFrame")
public class ScriptFrame {
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lli;"
	)
	@Export("titleboxSprite")
	static IndexedSprite titleboxSprite;
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lce;"
	)
	@Export("script")
	Script script;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -424456735
	)
	@Export("pc")
	int pc;
	@ObfuscatedName("o")
	@Export("intLocals")
	int[] intLocals;
	@ObfuscatedName("e")
	@Export("stringLocals")
	String[] stringLocals;

	ScriptFrame() {
		this.pc = -1;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "1752318627"
	)
	@Export("loadInterface")
	public static boolean loadInterface(int var0) {
		if (class197.Widget_loadedInterfaces[var0]) {
			return true;
		} else if (!class197.Widget_archive.tryLoadGroup(var0)) {
			return false;
		} else {
			int var1 = class197.Widget_archive.getGroupFileCount(var0);
			if (var1 == 0) {
				class197.Widget_loadedInterfaces[var0] = true;
				return true;
			} else {
				if (WorldMapLabel.Widget_interfaceComponents[var0] == null) {
					WorldMapLabel.Widget_interfaceComponents[var0] = new Widget[var1];
				}

				for (int var2 = 0; var2 < var1; ++var2) {
					if (WorldMapLabel.Widget_interfaceComponents[var0][var2] == null) {
						byte[] var3 = class197.Widget_archive.takeFile(var0, var2);
						if (var3 != null) {
							WorldMapLabel.Widget_interfaceComponents[var0][var2] = new Widget();
							WorldMapLabel.Widget_interfaceComponents[var0][var2].id = var2 + (var0 << 16);
							if (var3[0] == -1) {
								WorldMapLabel.Widget_interfaceComponents[var0][var2].decode(new Buffer(var3));
							} else {
								WorldMapLabel.Widget_interfaceComponents[var0][var2].decodeLegacy(new Buffer(var3));
							}
						}
					}
				}

				class197.Widget_loadedInterfaces[var0] = true;
				return true;
			}
		}
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "([BIII)Ljava/lang/String;",
		garbageValue = "-1282364496"
	)
	@Export("decodeStringCp1252")
	public static String decodeStringCp1252(byte[] var0, int var1, int var2) {
		char[] var3 = new char[var2];
		int var4 = 0;

		for (int var5 = 0; var5 < var2; ++var5) {
			int var6 = var0[var5 + var1] & 255;
			if (var6 != 0) {
				if (var6 >= 128 && var6 < 160) {
					char var7 = class288.cp1252AsciiExtension[var6 - 128];
					if (var7 == 0) {
						var7 = '?';
					}

					var6 = var7;
				}

				var3[var4++] = (char)var6;
			}
		}

		return new String(var3, 0, var4);
	}

	@ObfuscatedName("gi")
	@ObfuscatedSignature(
		signature = "(Lbx;II)V",
		garbageValue = "1584696624"
	)
	@Export("updateActorSequence")
	static final void updateActorSequence(Actor var0, int var1) {
		if (var0.field985 >= Client.cycle) {
			class185.method3685(var0);
		} else if (var0.field986 >= Client.cycle) {
			GrandExchangeEvent.method88(var0);
		} else {
			WorldMapRegion.method565(var0);
		}

		if (var0.x < 128 || var0.y < 128 || var0.x >= 13184 || var0.y >= 13184) {
			var0.sequence = -1;
			var0.spotAnimation = -1;
			var0.field985 = 0;
			var0.field986 = 0;
			var0.x = var0.pathX[0] * 128 + var0.field942 * 2013925376;
			var0.y = var0.pathY[0] * 128 + var0.field942 * 2013925376;
			var0.method1740();
		}

		if (class192.localPlayer == var0 && (var0.x < 1536 || var0.y < 1536 || var0.x >= 11776 || var0.y >= 11776)) {
			var0.sequence = -1;
			var0.spotAnimation = -1;
			var0.field985 = 0;
			var0.field986 = 0;
			var0.x = var0.pathX[0] * 128 + var0.field942 * 2013925376;
			var0.y = var0.pathY[0] * 128 + var0.field942 * 2013925376;
			var0.method1740();
		}

		int var5;
		if (var0.field975 != 0) {
			if (var0.targetIndex != -1) {
				Object var2 = null;
				if (var0.targetIndex < 32768) {
					var2 = Client.npcs[var0.targetIndex];
				} else if (var0.targetIndex >= 32768) {
					var2 = Client.players[var0.targetIndex - 32768];
				}

				if (var2 != null) {
					int var6 = var0.x - ((Actor)var2).x;
					int var4 = var0.y - ((Actor)var2).y;
					if (var6 != 0 || var4 != 0) {
						var0.orientation = (int)(Math.atan2((double)var6, (double)var4) * 325.949D) & 2047;
					}
				} else if (var0.false0) {
					var0.targetIndex = -1;
					var0.false0 = false;
				}
			}

			if (var0.field967 != -1 && (var0.pathLength == 0 || var0.field997 > 0)) {
				var0.orientation = var0.field967;
				var0.field967 = -1;
			}

			var5 = var0.orientation - var0.rotation & 2047;
			if (var5 == 0 && var0.false0) {
				var0.targetIndex = -1;
				var0.false0 = false;
			}

			if (var5 != 0) {
				++var0.field956;
				boolean var8;
				if (var5 > 1024) {
					var0.rotation -= var0.field975;
					var8 = true;
					if (var5 < var0.field975 || var5 > 2048 - var0.field975) {
						var0.rotation = var0.orientation;
						var8 = false;
					}

					if (var0.movementSequence == var0.readySequence && (var0.field956 > 25 || var8)) {
						if (var0.turnLeftSequence != -1) {
							var0.movementSequence = var0.turnLeftSequence;
						} else {
							var0.movementSequence = var0.walkSequence;
						}
					}
				} else {
					var0.rotation += var0.field975;
					var8 = true;
					if (var5 < var0.field975 || var5 > 2048 - var0.field975) {
						var0.rotation = var0.orientation;
						var8 = false;
					}

					if (var0.movementSequence == var0.readySequence && (var0.field956 > 25 || var8)) {
						if (var0.turnRightSequence != -1) {
							var0.movementSequence = var0.turnRightSequence;
						} else {
							var0.movementSequence = var0.walkSequence;
						}
					}
				}

				var0.rotation &= 2047;
			} else {
				var0.field956 = 0;
			}
		}

		var0.isWalking = false;
		SequenceDefinition var7;
		if (var0.movementSequence != -1) {
			var7 = GraphicsDefaults.SequenceDefinition_get(var0.movementSequence);
			if (var7 != null && var7.frameIds != null) {
				++var0.movementFrameCycle;
				if (var0.movementFrame < var7.frameIds.length && var0.movementFrameCycle > var7.frameLengths[var0.movementFrame]) {
					var0.movementFrameCycle = 1;
					++var0.movementFrame;
					GameObject.addSequenceSoundEffect(var7, var0.movementFrame, var0.x, var0.y);
				}

				if (var0.movementFrame >= var7.frameIds.length) {
					var0.movementFrameCycle = 0;
					var0.movementFrame = 0;
					GameObject.addSequenceSoundEffect(var7, var0.movementFrame, var0.x, var0.y);
				}
			} else {
				var0.movementSequence = -1;
			}
		}

		if (var0.spotAnimation != -1 && Client.cycle >= var0.field979) {
			if (var0.spotAnimationFrame < 0) {
				var0.spotAnimationFrame = 0;
			}

			var5 = class65.SpotAnimationDefinition_get(var0.spotAnimation).sequence;
			if (var5 != -1) {
				SequenceDefinition var3 = GraphicsDefaults.SequenceDefinition_get(var5);
				if (var3 != null && var3.frameIds != null) {
					++var0.spotAnimationFrameCycle;
					if (var0.spotAnimationFrame < var3.frameIds.length && var0.spotAnimationFrameCycle > var3.frameLengths[var0.spotAnimationFrame]) {
						var0.spotAnimationFrameCycle = 1;
						++var0.spotAnimationFrame;
						GameObject.addSequenceSoundEffect(var3, var0.spotAnimationFrame, var0.x, var0.y);
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
			var7 = GraphicsDefaults.SequenceDefinition_get(var0.sequence);
			if (var7.field3523 == 1 && var0.field998 > 0 && var0.field985 <= Client.cycle && var0.field986 < Client.cycle) {
				var0.sequenceDelay = 1;
				return;
			}
		}

		if (var0.sequence != -1 && var0.sequenceDelay == 0) {
			var7 = GraphicsDefaults.SequenceDefinition_get(var0.sequence);
			if (var7 != null && var7.frameIds != null) {
				++var0.sequenceFrameCycle;
				if (var0.sequenceFrame < var7.frameIds.length && var0.sequenceFrameCycle > var7.frameLengths[var0.sequenceFrame]) {
					var0.sequenceFrameCycle = 1;
					++var0.sequenceFrame;
					GameObject.addSequenceSoundEffect(var7, var0.sequenceFrame, var0.x, var0.y);
				}

				if (var0.sequenceFrame >= var7.frameIds.length) {
					var0.sequenceFrame -= var7.frameCount;
					++var0.field983;
					if (var0.field983 >= var7.field3522) {
						var0.sequence = -1;
					} else if (var0.sequenceFrame >= 0 && var0.sequenceFrame < var7.frameIds.length) {
						GameObject.addSequenceSoundEffect(var7, var0.sequenceFrame, var0.x, var0.y);
					} else {
						var0.sequence = -1;
					}
				}

				var0.isWalking = var7.field3518;
			} else {
				var0.sequence = -1;
			}
		}

		if (var0.sequenceDelay > 0) {
			--var0.sequenceDelay;
		}

	}

	@ObfuscatedName("jj")
	@ObfuscatedSignature(
		signature = "(Lhn;B)Z",
		garbageValue = "-53"
	)
	@Export("runCs1")
	static final boolean runCs1(Widget var0) {
		if (var0.cs1Comparisons == null) {
			return false;
		} else {
			for (int var1 = 0; var1 < var0.cs1Comparisons.length; ++var1) {
				int var2 = GrandExchangeOfferTotalQuantityComparator.method106(var0, var1);
				int var3 = var0.cs1ComparisonValues[var1];
				if (var0.cs1Comparisons[var1] == 2) {
					if (var2 >= var3) {
						return false;
					}
				} else if (var0.cs1Comparisons[var1] == 3) {
					if (var2 <= var3) {
						return false;
					}
				} else if (var0.cs1Comparisons[var1] == 4) {
					if (var3 == var2) {
						return false;
					}
				} else if (var2 != var3) {
					return false;
				}
			}

			return true;
		}
	}
}
