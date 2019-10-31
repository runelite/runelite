import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bz")
@Implements("Actor")
public abstract class Actor extends Entity {
	@ObfuscatedName("eu")
	@ObfuscatedSignature(
		signature = "Lij;"
	)
	@Export("archive20")
	static Archive archive20;
	@ObfuscatedName("aq")
	@ObfuscatedGetter(
		intValue = 1673440105
	)
	@Export("x")
	int x;
	@ObfuscatedName("ad")
	@ObfuscatedGetter(
		intValue = -86496457
	)
	@Export("y")
	int y;
	@ObfuscatedName("ag")
	@ObfuscatedGetter(
		intValue = -1022004991
	)
	@Export("rotation")
	int rotation;
	@ObfuscatedName("ak")
	@Export("isWalking")
	boolean isWalking;
	@ObfuscatedName("av")
	@ObfuscatedGetter(
		intValue = 1414687121
	)
	int field927;
	@ObfuscatedName("am")
	@ObfuscatedGetter(
		intValue = 222387089
	)
	@Export("playerCycle")
	int playerCycle;
	@ObfuscatedName("ab")
	@ObfuscatedGetter(
		intValue = -1677804381
	)
	@Export("readySequence")
	int readySequence;
	@ObfuscatedName("ax")
	@ObfuscatedGetter(
		intValue = 594336323
	)
	@Export("turnLeftSequence")
	int turnLeftSequence;
	@ObfuscatedName("al")
	@ObfuscatedGetter(
		intValue = 1154441065
	)
	@Export("turnRightSequence")
	int turnRightSequence;
	@ObfuscatedName("ap")
	@ObfuscatedGetter(
		intValue = 83349541
	)
	@Export("walkSequence")
	int walkSequence;
	@ObfuscatedName("aj")
	@ObfuscatedGetter(
		intValue = 1700088935
	)
	@Export("walkBackSequence")
	int walkBackSequence;
	@ObfuscatedName("ae")
	@ObfuscatedGetter(
		intValue = -781057529
	)
	@Export("walkLeftSequence")
	int walkLeftSequence;
	@ObfuscatedName("au")
	@ObfuscatedGetter(
		intValue = -1829521957
	)
	@Export("walkRightSequence")
	int walkRightSequence;
	@ObfuscatedName("ah")
	@ObfuscatedGetter(
		intValue = -2016822393
	)
	@Export("runSequence")
	int runSequence;
	@ObfuscatedName("an")
	@Export("overheadText")
	String overheadText;
	@ObfuscatedName("af")
	@Export("isAutoChatting")
	boolean isAutoChatting;
	@ObfuscatedName("ay")
	boolean field939;
	@ObfuscatedName("az")
	@ObfuscatedGetter(
		intValue = 1235378121
	)
	@Export("overheadTextCyclesRemaining")
	int overheadTextCyclesRemaining;
	@ObfuscatedName("ao")
	@ObfuscatedGetter(
		intValue = -696280171
	)
	@Export("overheadTextColor")
	int overheadTextColor;
	@ObfuscatedName("ai")
	@ObfuscatedGetter(
		intValue = -1688504189
	)
	@Export("overheadTextEffect")
	int overheadTextEffect;
	@ObfuscatedName("at")
	@Export("hitSplatCount")
	byte hitSplatCount;
	@ObfuscatedName("as")
	@Export("hitSplatTypes")
	int[] hitSplatTypes;
	@ObfuscatedName("ba")
	@Export("hitSplatValues")
	int[] hitSplatValues;
	@ObfuscatedName("bg")
	@Export("hitSplatCycles")
	int[] hitSplatCycles;
	@ObfuscatedName("bc")
	@Export("hitSplatTypes2")
	int[] hitSplatTypes2;
	@ObfuscatedName("bd")
	@Export("hitSplatValues2")
	int[] hitSplatValues2;
	@ObfuscatedName("bx")
	@ObfuscatedSignature(
		signature = "Ljm;"
	)
	@Export("healthBars")
	IterableNodeDeque healthBars;
	@ObfuscatedName("bl")
	@ObfuscatedGetter(
		intValue = -2097579951
	)
	@Export("targetIndex")
	int targetIndex;
	@ObfuscatedName("bh")
	@Export("false0")
	boolean false0;
	@ObfuscatedName("bu")
	@ObfuscatedGetter(
		intValue = -1107390821
	)
	int field934;
	@ObfuscatedName("br")
	@ObfuscatedGetter(
		intValue = -1581860297
	)
	@Export("movementSequence")
	int movementSequence;
	@ObfuscatedName("bq")
	@ObfuscatedGetter(
		intValue = 1528888905
	)
	@Export("movementFrame")
	int movementFrame;
	@ObfuscatedName("bi")
	@ObfuscatedGetter(
		intValue = -687202097
	)
	@Export("movementFrameCycle")
	int movementFrameCycle;
	@ObfuscatedName("be")
	@ObfuscatedGetter(
		intValue = 805247977
	)
	@Export("sequence")
	int sequence;
	@ObfuscatedName("bt")
	@ObfuscatedGetter(
		intValue = 736502107
	)
	@Export("sequenceFrame")
	int sequenceFrame;
	@ObfuscatedName("bs")
	@ObfuscatedGetter(
		intValue = -420296753
	)
	@Export("sequenceFrameCycle")
	int sequenceFrameCycle;
	@ObfuscatedName("bj")
	@ObfuscatedGetter(
		intValue = 336768917
	)
	@Export("sequenceDelay")
	int sequenceDelay;
	@ObfuscatedName("bm")
	@ObfuscatedGetter(
		intValue = -1410322499
	)
	int field960;
	@ObfuscatedName("bn")
	@ObfuscatedGetter(
		intValue = 1228903613
	)
	@Export("spotAnimation")
	int spotAnimation;
	@ObfuscatedName("bz")
	@ObfuscatedGetter(
		intValue = 1265033073
	)
	@Export("spotAnimationFrame")
	int spotAnimationFrame;
	@ObfuscatedName("bo")
	@ObfuscatedGetter(
		intValue = -663316133
	)
	@Export("spotAnimationFrameCycle")
	int spotAnimationFrameCycle;
	@ObfuscatedName("bk")
	@ObfuscatedGetter(
		intValue = -1273295849
	)
	int field973;
	@ObfuscatedName("bv")
	@ObfuscatedGetter(
		intValue = 528591249
	)
	int field965;
	@ObfuscatedName("bw")
	@ObfuscatedGetter(
		intValue = 1608804509
	)
	int field966;
	@ObfuscatedName("bb")
	@ObfuscatedGetter(
		intValue = -164988469
	)
	int field967;
	@ObfuscatedName("bf")
	@ObfuscatedGetter(
		intValue = -1333983147
	)
	int field979;
	@ObfuscatedName("by")
	@ObfuscatedGetter(
		intValue = 105474701
	)
	int field969;
	@ObfuscatedName("bp")
	@ObfuscatedGetter(
		intValue = 1769569101
	)
	int field925;
	@ObfuscatedName("cx")
	@ObfuscatedGetter(
		intValue = 1506809691
	)
	int field971;
	@ObfuscatedName("cv")
	@ObfuscatedGetter(
		intValue = 1295543135
	)
	int field972;
	@ObfuscatedName("ce")
	@ObfuscatedGetter(
		intValue = 1559943605
	)
	@Export("npcCycle")
	int npcCycle;
	@ObfuscatedName("cw")
	@ObfuscatedGetter(
		intValue = 320863757
	)
	@Export("defaultHeight")
	int defaultHeight;
	@ObfuscatedName("cd")
	@ObfuscatedGetter(
		intValue = -1451956301
	)
	@Export("orientation")
	int orientation;
	@ObfuscatedName("cn")
	@ObfuscatedGetter(
		intValue = 477550871
	)
	int field948;
	@ObfuscatedName("cr")
	@ObfuscatedGetter(
		intValue = 1785171989
	)
	int field977;
	@ObfuscatedName("ci")
	@ObfuscatedGetter(
		intValue = 2075263543
	)
	@Export("pathLength")
	int pathLength;
	@ObfuscatedName("cy")
	@Export("pathX")
	int[] pathX;
	@ObfuscatedName("cl")
	@Export("pathY")
	int[] pathY;
	@ObfuscatedName("co")
	@Export("pathTraversed")
	byte[] pathTraversed;
	@ObfuscatedName("cu")
	@ObfuscatedGetter(
		intValue = -2083065961
	)
	int field982;
	@ObfuscatedName("cz")
	@ObfuscatedGetter(
		intValue = 1810694977
	)
	int field983;

	Actor() {
		this.isWalking = false;
		this.field927 = 1;
		this.readySequence = -1;
		this.turnLeftSequence = -1;
		this.turnRightSequence = -1;
		this.walkSequence = -1;
		this.walkBackSequence = -1;
		this.walkLeftSequence = -1;
		this.walkRightSequence = -1;
		this.runSequence = -1;
		this.overheadText = null;
		this.field939 = false;
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
		this.field934 = -1;
		this.movementSequence = -1;
		this.movementFrame = 0;
		this.movementFrameCycle = 0;
		this.sequence = -1;
		this.sequenceFrame = 0;
		this.sequenceFrameCycle = 0;
		this.sequenceDelay = 0;
		this.field960 = 0;
		this.spotAnimation = -1;
		this.spotAnimationFrame = 0;
		this.spotAnimationFrameCycle = 0;
		this.npcCycle = 0;
		this.defaultHeight = 200;
		this.field948 = 0;
		this.field977 = 32;
		this.pathLength = 0;
		this.pathX = new int[10];
		this.pathY = new int[10];
		this.pathTraversed = new byte[10];
		this.field982 = 0;
		this.field983 = 0;
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "-25"
	)
	@Export("isVisible")
	boolean isVisible() {
		return false;
	}

	@ObfuscatedName("bu")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "0"
	)
	final void method1862() {
		this.pathLength = 0;
		this.field983 = 0;
	}

	@ObfuscatedName("br")
	@ObfuscatedSignature(
		signature = "(IIIIIII)V",
		garbageValue = "-506913236"
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
			HitSplatDefinition var12 = NetFileRequest.method4298(var1);
			var10 = var12.field3313;
			var11 = var12.field3314;
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

	@ObfuscatedName("bq")
	@ObfuscatedSignature(
		signature = "(IIIIIIB)V",
		garbageValue = "-38"
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
			if (var13.definition.field3265 == var8.field3265) {
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

	@ObfuscatedName("bi")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-1507831115"
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

	@ObfuscatedName("gj")
	@ObfuscatedSignature(
		signature = "(Lbz;S)V",
		garbageValue = "16384"
	)
	static final void method1873(Actor var0) {
		if (var0.field977 != 0) {
			if (var0.targetIndex != -1) {
				Object var1 = null;
				if (var0.targetIndex < 32768) {
					var1 = Client.npcs[var0.targetIndex];
				} else if (var0.targetIndex >= 32768) {
					var1 = Client.players[var0.targetIndex - 32768];
				}

				if (var1 != null) {
					int var2 = var0.x - ((Actor)var1).x;
					int var3 = var0.y - ((Actor)var1).y;
					if (var2 != 0 || var3 != 0) {
						var0.orientation = (int)(Math.atan2((double)var2, (double)var3) * 325.949D) & 2047;
					}
				} else if (var0.false0) {
					var0.targetIndex = -1;
					var0.false0 = false;
				}
			}

			if (var0.field934 != -1 && (var0.pathLength == 0 || var0.field982 > 0)) {
				var0.orientation = var0.field934;
				var0.field934 = -1;
			}

			int var4 = var0.orientation - var0.rotation & 2047;
			if (var4 == 0 && var0.false0) {
				var0.targetIndex = -1;
				var0.false0 = false;
			}

			if (var4 != 0) {
				++var0.field948;
				boolean var6;
				if (var4 > 1024) {
					var0.rotation -= var0.field977;
					var6 = true;
					if (var4 < var0.field977 || var4 > 2048 - var0.field977) {
						var0.rotation = var0.orientation;
						var6 = false;
					}

					if (var0.readySequence == var0.movementSequence && (var0.field948 > 25 || var6)) {
						if (var0.turnLeftSequence != -1) {
							var0.movementSequence = var0.turnLeftSequence;
						} else {
							var0.movementSequence = var0.walkSequence;
						}
					}
				} else {
					var0.rotation += var0.field977;
					var6 = true;
					if (var4 < var0.field977 || var4 > 2048 - var0.field977) {
						var0.rotation = var0.orientation;
						var6 = false;
					}

					if (var0.readySequence == var0.movementSequence && (var0.field948 > 25 || var6)) {
						if (var0.turnRightSequence != -1) {
							var0.movementSequence = var0.turnRightSequence;
						} else {
							var0.movementSequence = var0.walkSequence;
						}
					}
				}

				var0.rotation &= 2047;
			} else {
				var0.field948 = 0;
			}

		}
	}
}
