import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("be")
@Implements("Actor")
public abstract class Actor extends Entity {
	@ObfuscatedName("sy")
	@ObfuscatedSignature(
		signature = "Lbz;"
	)
	@Export("clientPreferences")
	static ClientPreferences clientPreferences;
	@ObfuscatedName("av")
	@ObfuscatedGetter(
		intValue = -78439701
	)
	@Export("x")
	int x;
	@ObfuscatedName("an")
	@Export("isWalking")
	boolean isWalking;
	@ObfuscatedName("al")
	@ObfuscatedGetter(
		intValue = 2024233319
	)
	@Export("y")
	int y;
	@ObfuscatedName("as")
	@ObfuscatedGetter(
		intValue = -1344698339
	)
	@Export("rotation")
	int rotation;
	@ObfuscatedName("ad")
	@ObfuscatedGetter(
		intValue = 326208199
	)
	@Export("size")
	int size;
	@ObfuscatedName("ap")
	@ObfuscatedGetter(
		intValue = 1320061547
	)
	@Export("playerCycle")
	int playerCycle;
	@ObfuscatedName("ax")
	@ObfuscatedGetter(
		intValue = 1628814929
	)
	@Export("readySequence")
	int readySequence;
	@ObfuscatedName("aj")
	@ObfuscatedGetter(
		intValue = -1587131503
	)
	@Export("turnLeftSequence")
	int turnLeftSequence;
	@ObfuscatedName("ab")
	@ObfuscatedGetter(
		intValue = 38036755
	)
	@Export("turnRightSequence")
	int turnRightSequence;
	@ObfuscatedName("af")
	@ObfuscatedGetter(
		intValue = 195654645
	)
	@Export("walkSequence")
	int walkSequence;
	@ObfuscatedName("ak")
	@ObfuscatedGetter(
		intValue = 654548911
	)
	@Export("walkBackSequence")
	int walkBackSequence;
	@ObfuscatedName("ay")
	@ObfuscatedGetter(
		intValue = 2066786939
	)
	@Export("walkLeftSequence")
	int walkLeftSequence;
	@ObfuscatedName("ae")
	@ObfuscatedGetter(
		intValue = 1924266197
	)
	@Export("walkRightSequence")
	int walkRightSequence;
	@ObfuscatedName("ah")
	@ObfuscatedGetter(
		intValue = 146870157
	)
	@Export("runSequence")
	int runSequence;
	@ObfuscatedName("aa")
	@Export("overheadText")
	String overheadText;
	@ObfuscatedName("aq")
	@Export("isAutoChatting")
	boolean isAutoChatting;
	@ObfuscatedName("ar")
	boolean field956;
	@ObfuscatedName("ac")
	@ObfuscatedGetter(
		intValue = -1539638005
	)
	@Export("overheadTextCyclesRemaining")
	int overheadTextCyclesRemaining;
	@ObfuscatedName("az")
	@ObfuscatedGetter(
		intValue = 291511261
	)
	@Export("overheadTextColor")
	int overheadTextColor;
	@ObfuscatedName("ai")
	@ObfuscatedGetter(
		intValue = -2008458145
	)
	@Export("overheadTextEffect")
	int overheadTextEffect;
	@ObfuscatedName("aw")
	@Export("hitSplatCount")
	byte hitSplatCount;
	@ObfuscatedName("au")
	@Export("hitSplatTypes")
	int[] hitSplatTypes;
	@ObfuscatedName("bg")
	@Export("hitSplatValues")
	int[] hitSplatValues;
	@ObfuscatedName("bn")
	@Export("hitSplatCycles")
	int[] hitSplatCycles;
	@ObfuscatedName("bk")
	@Export("hitSplatTypes2")
	int[] hitSplatTypes2;
	@ObfuscatedName("bp")
	@Export("hitSplatValues2")
	int[] hitSplatValues2;
	@ObfuscatedName("bu")
	@ObfuscatedSignature(
		signature = "Ljd;"
	)
	@Export("healthBars")
	IterableNodeDeque healthBars;
	@ObfuscatedName("bi")
	@ObfuscatedGetter(
		intValue = 366180583
	)
	@Export("targetIndex")
	int targetIndex;
	@ObfuscatedName("bv")
	@Export("false0")
	boolean false0;
	@ObfuscatedName("bf")
	@ObfuscatedGetter(
		intValue = 1358121837
	)
	int field945;
	@ObfuscatedName("bm")
	@ObfuscatedGetter(
		intValue = 566824475
	)
	@Export("movementSequence")
	int movementSequence;
	@ObfuscatedName("bw")
	@ObfuscatedGetter(
		intValue = 1646709317
	)
	@Export("movementFrame")
	int movementFrame;
	@ObfuscatedName("bs")
	@ObfuscatedGetter(
		intValue = -2010447121
	)
	@Export("movementFrameCycle")
	int movementFrameCycle;
	@ObfuscatedName("bt")
	@ObfuscatedGetter(
		intValue = -836151055
	)
	@Export("sequence")
	int sequence;
	@ObfuscatedName("bj")
	@ObfuscatedGetter(
		intValue = -1593302173
	)
	@Export("sequenceFrame")
	int sequenceFrame;
	@ObfuscatedName("bd")
	@ObfuscatedGetter(
		intValue = -1376532773
	)
	@Export("sequenceFrameCycle")
	int sequenceFrameCycle;
	@ObfuscatedName("by")
	@ObfuscatedGetter(
		intValue = -63500945
	)
	@Export("sequenceDelay")
	int sequenceDelay;
	@ObfuscatedName("bh")
	@ObfuscatedGetter(
		intValue = -303610771
	)
	int field924;
	@ObfuscatedName("bo")
	@ObfuscatedGetter(
		intValue = -244355827
	)
	@Export("spotAnimation")
	int spotAnimation;
	@ObfuscatedName("be")
	@ObfuscatedGetter(
		intValue = -1682160085
	)
	@Export("spotAnimationFrame")
	int spotAnimationFrame;
	@ObfuscatedName("bl")
	@ObfuscatedGetter(
		intValue = 377223135
	)
	@Export("spotAnimationFrameCycle")
	int spotAnimationFrameCycle;
	@ObfuscatedName("bb")
	@ObfuscatedGetter(
		intValue = 249618635
	)
	int field957;
	@ObfuscatedName("ba")
	@ObfuscatedGetter(
		intValue = -324063411
	)
	@Export("heightOffset")
	int heightOffset;
	@ObfuscatedName("bz")
	@ObfuscatedGetter(
		intValue = -1424150703
	)
	int field959;
	@ObfuscatedName("bc")
	@ObfuscatedGetter(
		intValue = 1789167897
	)
	int field960;
	@ObfuscatedName("br")
	@ObfuscatedGetter(
		intValue = 1809872347
	)
	int field961;
	@ObfuscatedName("bx")
	@ObfuscatedGetter(
		intValue = -196012985
	)
	int field962;
	@ObfuscatedName("bq")
	@ObfuscatedGetter(
		intValue = -854056355
	)
	int field963;
	@ObfuscatedName("cb")
	@ObfuscatedGetter(
		intValue = 1429248265
	)
	int field964;
	@ObfuscatedName("ct")
	@ObfuscatedGetter(
		intValue = 152429931
	)
	int field965;
	@ObfuscatedName("ch")
	@ObfuscatedGetter(
		intValue = 766274575
	)
	@Export("npcCycle")
	int npcCycle;
	@ObfuscatedName("cc")
	@ObfuscatedGetter(
		intValue = -1552779633
	)
	@Export("defaultHeight")
	int defaultHeight;
	@ObfuscatedName("cv")
	@ObfuscatedGetter(
		intValue = -565463509
	)
	@Export("orientation")
	int orientation;
	@ObfuscatedName("cr")
	@ObfuscatedGetter(
		intValue = 715669973
	)
	int field976;
	@ObfuscatedName("cl")
	@ObfuscatedGetter(
		intValue = -1597126945
	)
	int field953;
	@ObfuscatedName("ca")
	@ObfuscatedGetter(
		intValue = 12984639
	)
	@Export("pathLength")
	int pathLength;
	@ObfuscatedName("ck")
	@Export("pathX")
	int[] pathX;
	@ObfuscatedName("cm")
	@Export("pathY")
	int[] pathY;
	@ObfuscatedName("ce")
	@Export("pathTraversed")
	byte[] pathTraversed;
	@ObfuscatedName("cn")
	@ObfuscatedGetter(
		intValue = 1459296501
	)
	int field975;
	@ObfuscatedName("cj")
	@ObfuscatedGetter(
		intValue = 1855180457
	)
	int field969;

	Actor() {
		this.isWalking = false;
		this.size = 1;
		this.readySequence = -1;
		this.turnLeftSequence = -1;
		this.turnRightSequence = -1;
		this.walkSequence = -1;
		this.walkBackSequence = -1;
		this.walkLeftSequence = -1;
		this.walkRightSequence = -1;
		this.runSequence = -1;
		this.overheadText = null;
		this.field956 = false;
		this.overheadTextCyclesRemaining = 100;
		this.overheadTextColor = 0;
		this.overheadTextEffect = 0;
		this.hitSplatCount = 0;
		this.hitSplatTypes = new int[4];
		this.hitSplatValues = new int[4];
		this.hitSplatCycles = new int[4];
		this.hitSplatTypes2 = new int[4];
		this.hitSplatValues2 = new int[4];
		this.healthBars = new IterableNodeDeque();
		this.targetIndex = -1;
		this.false0 = false;
		this.field945 = -1;
		this.movementSequence = -1;
		this.movementFrame = 0;
		this.movementFrameCycle = 0;
		this.sequence = -1;
		this.sequenceFrame = 0;
		this.sequenceFrameCycle = 0;
		this.sequenceDelay = 0;
		this.field924 = 0;
		this.spotAnimation = -1;
		this.spotAnimationFrame = 0;
		this.spotAnimationFrameCycle = 0;
		this.npcCycle = 0;
		this.defaultHeight = 200;
		this.field976 = 0;
		this.field953 = 32;
		this.pathLength = 0;
		this.pathX = new int[10];
		this.pathY = new int[10];
		this.pathTraversed = new byte[10];
		this.field975 = 0;
		this.field969 = 0;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "93"
	)
	@Export("isVisible")
	boolean isVisible() {
		return false;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "845208492"
	)
	final void method1699() {
		this.pathLength = 0;
		this.field969 = 0;
	}

	@ObfuscatedName("bg")
	@ObfuscatedSignature(
		signature = "(IIIIIII)V",
		garbageValue = "-2027410563"
	)
	@Export("addHitSplat")
	final void addHitSplat(int var1, int var2, int var3, int var4, int var5, int var6) {
		boolean var7 = true;
		boolean var8 = true;

		int var9;
		for (var9 = 0; var9 < 4; ++var9) {
			if (this.hitSplatCycles[var9] > var5) {
				var7 = false;
			} else {
				var8 = false;
			}
		}

		var9 = -1;
		int var10 = -1;
		int var11 = 0;
		if (var1 >= 0) {
			HitSplatDefinition var12 = Interpreter.HitSplatDefinition_get(var1);
			var10 = var12.field3315;
			var11 = var12.field3306;
		}

		int var14;
		if (var8) {
			if (var10 == -1) {
				return;
			}

			var9 = 0;
			var14 = 0;
			if (var10 == 0) {
				var14 = this.hitSplatCycles[0];
			} else if (var10 == 1) {
				var14 = this.hitSplatValues[0];
			}

			for (int var13 = 1; var13 < 4; ++var13) {
				if (var10 == 0) {
					if (this.hitSplatCycles[var13] < var14) {
						var9 = var13;
						var14 = this.hitSplatCycles[var13];
					}
				} else if (var10 == 1 && this.hitSplatValues[var13] < var14) {
					var9 = var13;
					var14 = this.hitSplatValues[var13];
				}
			}

			if (var10 == 1 && var14 >= var2) {
				return;
			}
		} else {
			if (var7) {
				this.hitSplatCount = 0;
			}

			for (var14 = 0; var14 < 4; ++var14) {
				byte var15 = this.hitSplatCount;
				this.hitSplatCount = (byte)((this.hitSplatCount + 1) % 4);
				if (this.hitSplatCycles[var15] <= var5) {
					var9 = var15;
					break;
				}
			}
		}

		if (var9 >= 0) {
			this.hitSplatTypes[var9] = var1;
			this.hitSplatValues[var9] = var2;
			this.hitSplatTypes2[var9] = var3;
			this.hitSplatValues2[var9] = var4;
			this.hitSplatCycles[var9] = var5 + var11 + var6;
		}
	}

	@ObfuscatedName("bn")
	@ObfuscatedSignature(
		signature = "(IIIIIIS)V",
		garbageValue = "199"
	)
	@Export("addHealthBar")
	final void addHealthBar(int var1, int var2, int var3, int var4, int var5, int var6) {
		HealthBarDefinition var8 = (HealthBarDefinition)HealthBarDefinition.HealthBarDefinition_cached.get((long)var1);
		HealthBarDefinition var7;
		if (var8 != null) {
			var7 = var8;
		} else {
			byte[] var9 = HealthBarDefinition.HealthBarDefinition_archive.takeFile(33, var1);
			var8 = new HealthBarDefinition();
			if (var9 != null) {
				var8.decode(new Buffer(var9));
			}

			HealthBarDefinition.HealthBarDefinition_cached.put(var8, (long)var1);
			var7 = var8;
		}

		var8 = var7;
		HealthBar var14 = null;
		HealthBar var10 = null;
		int var11 = var7.int2;
		int var12 = 0;

		HealthBar var13;
		for (var13 = (HealthBar)this.healthBars.last(); var13 != null; var13 = (HealthBar)this.healthBars.previous()) {
			++var12;
			if (var13.definition.field3253 == var8.field3253) {
				var13.put(var2 + var4, var5, var6, var3);
				return;
			}

			if (var13.definition.int1 <= var8.int1) {
				var14 = var13;
			}

			if (var13.definition.int2 > var11) {
				var10 = var13;
				var11 = var13.definition.int2;
			}
		}

		if (var10 != null || var12 < 4) {
			var13 = new HealthBar(var8);
			if (var14 == null) {
				this.healthBars.addLast(var13);
			} else {
				IterableNodeDeque.IterableNodeDeque_addBefore(var13, var14);
			}

			var13.put(var2 + var4, var5, var6, var3);
			if (var12 >= 4) {
				var10.remove();
			}

		}
	}

	@ObfuscatedName("bk")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "99"
	)
	@Export("removeHealthBar")
	final void removeHealthBar(int var1) {
		HealthBarDefinition var3 = (HealthBarDefinition)HealthBarDefinition.HealthBarDefinition_cached.get((long)var1);
		HealthBarDefinition var2;
		if (var3 != null) {
			var2 = var3;
		} else {
			byte[] var4 = HealthBarDefinition.HealthBarDefinition_archive.takeFile(33, var1);
			var3 = new HealthBarDefinition();
			if (var4 != null) {
				var3.decode(new Buffer(var4));
			}

			HealthBarDefinition.HealthBarDefinition_cached.put(var3, (long)var1);
			var2 = var3;
		}

		var3 = var2;

		for (HealthBar var5 = (HealthBar)this.healthBars.last(); var5 != null; var5 = (HealthBar)this.healthBars.previous()) {
			if (var3 == var5.definition) {
				var5.remove();
				return;
			}
		}

	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(CI)Z",
		garbageValue = "-599596211"
	)
	@Export("isDigit")
	public static boolean isDigit(char var0) {
		return var0 >= '0' && var0 <= '9';
	}

	@ObfuscatedName("gk")
	@ObfuscatedSignature(
		signature = "(IIIII)V",
		garbageValue = "1542615577"
	)
	static final void method1704(int var0, int var1, int var2, int var3) {
		Client.overheadTextCount = 0;
		boolean var4 = false;
		int var5 = -1;
		int var6 = -1;
		int var7 = Players.Players_count;
		int[] var8 = Players.Players_indices;

		int var9;
		for (var9 = 0; var9 < var7 + Client.npcCount; ++var9) {
			Object var10;
			if (var9 < var7) {
				var10 = Client.players[var8[var9]];
				if (var8[var9] == Client.combatTargetPlayerIndex) {
					var4 = true;
					var5 = var9;
					continue;
				}

				if (var10 == Varps.localPlayer) {
					var6 = var9;
					continue;
				}
			} else {
				var10 = Client.npcs[Client.npcIndices[var9 - var7]];
			}

			VerticalAlignment.drawActor2d((Actor)var10, var9, var0, var1, var2, var3);
		}

		if (Client.renderSelf && var6 != -1) {
			VerticalAlignment.drawActor2d(Varps.localPlayer, var6, var0, var1, var2, var3);
		}

		if (var4) {
			VerticalAlignment.drawActor2d(Client.players[Client.combatTargetPlayerIndex], var5, var0, var1, var2, var3);
		}

		for (var9 = 0; var9 < Client.overheadTextCount; ++var9) {
			int var19 = Client.overheadTextXs[var9];
			int var11 = Client.overheadTextYs[var9];
			int var12 = Client.overheadTextXOffsets[var9];
			int var13 = Client.overheadTextAscents[var9];
			boolean var14 = true;

			while (var14) {
				var14 = false;

				for (int var15 = 0; var15 < var9; ++var15) {
					if (var11 + 2 > Client.overheadTextYs[var15] - Client.overheadTextAscents[var15] && var11 - var13 < Client.overheadTextYs[var15] + 2 && var19 - var12 < Client.overheadTextXs[var15] + Client.overheadTextXOffsets[var15] && var12 + var19 > Client.overheadTextXs[var15] - Client.overheadTextXOffsets[var15] && Client.overheadTextYs[var15] - Client.overheadTextAscents[var15] < var11) {
						var11 = Client.overheadTextYs[var15] - Client.overheadTextAscents[var15];
						var14 = true;
					}
				}
			}

			Client.viewportTempX = Client.overheadTextXs[var9];
			Client.viewportTempY = Client.overheadTextYs[var9] = var11;
			String var20 = Client.overheadText[var9];
			if (Client.chatEffects == 0) {
				int var16 = 16776960;
				if (Client.overheadTextColors[var9] < 6) {
					var16 = Client.field838[Client.overheadTextColors[var9]];
				}

				if (Client.overheadTextColors[var9] == 6) {
					var16 = Client.viewportDrawCount % 20 < 10 ? 16711680 : 16776960;
				}

				if (Client.overheadTextColors[var9] == 7) {
					var16 = Client.viewportDrawCount % 20 < 10 ? 255 : '\uffff';
				}

				if (Client.overheadTextColors[var9] == 8) {
					var16 = Client.viewportDrawCount % 20 < 10 ? '뀀' : 8454016;
				}

				int var17;
				if (Client.overheadTextColors[var9] == 9) {
					var17 = 150 - Client.overheadTextCyclesRemaining[var9];
					if (var17 < 50) {
						var16 = var17 * 1280 + 16711680;
					} else if (var17 < 100) {
						var16 = 16776960 - (var17 - 50) * 327680;
					} else if (var17 < 150) {
						var16 = (var17 - 100) * 5 + 65280;
					}
				}

				if (Client.overheadTextColors[var9] == 10) {
					var17 = 150 - Client.overheadTextCyclesRemaining[var9];
					if (var17 < 50) {
						var16 = var17 * 5 + 16711680;
					} else if (var17 < 100) {
						var16 = 16711935 - (var17 - 50) * 327680;
					} else if (var17 < 150) {
						var16 = (var17 - 100) * 327680 + 255 - (var17 - 100) * 5;
					}
				}

				if (Client.overheadTextColors[var9] == 11) {
					var17 = 150 - Client.overheadTextCyclesRemaining[var9];
					if (var17 < 50) {
						var16 = 16777215 - var17 * 327685;
					} else if (var17 < 100) {
						var16 = (var17 - 50) * 327685 + 65280;
					} else if (var17 < 150) {
						var16 = 16777215 - (var17 - 100) * 327680;
					}
				}

				if (Client.overheadTextEffects[var9] == 0) {
					HealthBar.fontBold12.drawCentered(var20, var0 + Client.viewportTempX, Client.viewportTempY + var1, var16, 0);
				}

				if (Client.overheadTextEffects[var9] == 1) {
					HealthBar.fontBold12.drawCenteredWave(var20, var0 + Client.viewportTempX, Client.viewportTempY + var1, var16, 0, Client.viewportDrawCount);
				}

				if (Client.overheadTextEffects[var9] == 2) {
					HealthBar.fontBold12.drawCenteredWave2(var20, var0 + Client.viewportTempX, Client.viewportTempY + var1, var16, 0, Client.viewportDrawCount);
				}

				if (Client.overheadTextEffects[var9] == 3) {
					HealthBar.fontBold12.drawCenteredShake(var20, var0 + Client.viewportTempX, Client.viewportTempY + var1, var16, 0, Client.viewportDrawCount, 150 - Client.overheadTextCyclesRemaining[var9]);
				}

				if (Client.overheadTextEffects[var9] == 4) {
					var17 = (150 - Client.overheadTextCyclesRemaining[var9]) * (HealthBar.fontBold12.stringWidth(var20) + 100) / 150;
					Rasterizer2D.Rasterizer2D_expandClip(var0 + Client.viewportTempX - 50, var1, var0 + Client.viewportTempX + 50, var3 + var1);
					HealthBar.fontBold12.draw(var20, var0 + Client.viewportTempX + 50 - var17, Client.viewportTempY + var1, var16, 0);
					Rasterizer2D.Rasterizer2D_setClip(var0, var1, var0 + var2, var3 + var1);
				}

				if (Client.overheadTextEffects[var9] == 5) {
					var17 = 150 - Client.overheadTextCyclesRemaining[var9];
					int var18 = 0;
					if (var17 < 25) {
						var18 = var17 - 25;
					} else if (var17 > 125) {
						var18 = var17 - 125;
					}

					Rasterizer2D.Rasterizer2D_expandClip(var0, Client.viewportTempY + var1 - HealthBar.fontBold12.ascent - 1, var0 + var2, Client.viewportTempY + var1 + 5);
					HealthBar.fontBold12.drawCentered(var20, var0 + Client.viewportTempX, var18 + Client.viewportTempY + var1, var16, 0);
					Rasterizer2D.Rasterizer2D_setClip(var0, var1, var0 + var2, var3 + var1);
				}
			} else {
				HealthBar.fontBold12.drawCentered(var20, var0 + Client.viewportTempX, Client.viewportTempY + var1, 16776960, 0);
			}
		}

	}
}
