import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bx")
@Implements("Actor")
public abstract class Actor extends Entity {
	@ObfuscatedName("hw")
	@ObfuscatedGetter(
		intValue = -1081089529
	)
	@Export("cameraZ")
	static int cameraZ;
	@ObfuscatedName("ax")
	@ObfuscatedGetter(
		intValue = -892372587
	)
	@Export("x")
	int x;
	@ObfuscatedName("aj")
	@ObfuscatedGetter(
		intValue = -340039451
	)
	@Export("y")
	int y;
	@ObfuscatedName("au")
	@ObfuscatedGetter(
		intValue = 349053657
	)
	@Export("rotation")
	int rotation;
	@ObfuscatedName("ay")
	@Export("isWalking")
	boolean isWalking;
	@ObfuscatedName("aa")
	@ObfuscatedGetter(
		intValue = -697437632
	)
	int field942;
	@ObfuscatedName("aq")
	@ObfuscatedGetter(
		intValue = 1907492229
	)
	@Export("playerCycle")
	int playerCycle;
	@ObfuscatedName("as")
	@ObfuscatedGetter(
		intValue = -1598432795
	)
	@Export("readySequence")
	int readySequence;
	@ObfuscatedName("ak")
	@ObfuscatedGetter(
		intValue = -291727723
	)
	@Export("turnLeftSequence")
	int turnLeftSequence;
	@ObfuscatedName("ac")
	@ObfuscatedGetter(
		intValue = -1728008405
	)
	@Export("turnRightSequence")
	int turnRightSequence;
	@ObfuscatedName("aw")
	@ObfuscatedGetter(
		intValue = -1086097041
	)
	@Export("walkSequence")
	int walkSequence;
	@ObfuscatedName("ar")
	@ObfuscatedGetter(
		intValue = -1467237959
	)
	@Export("walkBackSequence")
	int walkBackSequence;
	@ObfuscatedName("av")
	@ObfuscatedGetter(
		intValue = 1983487081
	)
	@Export("walkLeftSequence")
	int walkLeftSequence;
	@ObfuscatedName("al")
	@ObfuscatedGetter(
		intValue = 849163825
	)
	@Export("walkRightSequence")
	int walkRightSequence;
	@ObfuscatedName("ad")
	@ObfuscatedGetter(
		intValue = 1212229631
	)
	@Export("runSequence")
	int runSequence;
	@ObfuscatedName("am")
	@Export("overheadText")
	String overheadText;
	@ObfuscatedName("ao")
	@Export("isAutoChatting")
	boolean isAutoChatting;
	@ObfuscatedName("at")
	boolean field954;
	@ObfuscatedName("an")
	@ObfuscatedGetter(
		intValue = 411062959
	)
	@Export("overheadTextCyclesRemaining")
	int overheadTextCyclesRemaining;
	@ObfuscatedName("ag")
	@ObfuscatedGetter(
		intValue = 303951077
	)
	@Export("overheadTextColor")
	int overheadTextColor;
	@ObfuscatedName("ai")
	@ObfuscatedGetter(
		intValue = -1337341867
	)
	@Export("overheadTextEffect")
	int overheadTextEffect;
	@ObfuscatedName("ap")
	@Export("hitSplatCount")
	byte hitSplatCount;
	@ObfuscatedName("ah")
	@Export("hitSplatTypes")
	int[] hitSplatTypes;
	@ObfuscatedName("bq")
	@Export("hitSplatValues")
	int[] hitSplatValues;
	@ObfuscatedName("bf")
	@Export("hitSplatCycles")
	int[] hitSplatCycles;
	@ObfuscatedName("bc")
	@Export("hitSplatTypes2")
	int[] hitSplatTypes2;
	@ObfuscatedName("bk")
	@Export("hitSplatValues2")
	int[] hitSplatValues2;
	@ObfuscatedName("bb")
	@ObfuscatedSignature(
		signature = "Ljj;"
	)
	@Export("healthBars")
	IterableNodeDeque healthBars;
	@ObfuscatedName("bi")
	@ObfuscatedGetter(
		intValue = -186074271
	)
	@Export("targetIndex")
	int targetIndex;
	@ObfuscatedName("bp")
	@Export("false0")
	boolean false0;
	@ObfuscatedName("bl")
	@ObfuscatedGetter(
		intValue = 49507657
	)
	int field967;
	@ObfuscatedName("by")
	@ObfuscatedGetter(
		intValue = 1446195429
	)
	@Export("movementSequence")
	int movementSequence;
	@ObfuscatedName("be")
	@ObfuscatedGetter(
		intValue = 707889715
	)
	@Export("movementFrame")
	int movementFrame;
	@ObfuscatedName("bw")
	@ObfuscatedGetter(
		intValue = -1510221367
	)
	@Export("movementFrameCycle")
	int movementFrameCycle;
	@ObfuscatedName("bt")
	@ObfuscatedGetter(
		intValue = 2138595105
	)
	@Export("sequence")
	int sequence;
	@ObfuscatedName("bn")
	@ObfuscatedGetter(
		intValue = -1231128891
	)
	@Export("sequenceFrame")
	int sequenceFrame;
	@ObfuscatedName("bm")
	@ObfuscatedGetter(
		intValue = -733211881
	)
	@Export("sequenceFrameCycle")
	int sequenceFrameCycle;
	@ObfuscatedName("ba")
	@ObfuscatedGetter(
		intValue = 825906927
	)
	@Export("sequenceDelay")
	int sequenceDelay;
	@ObfuscatedName("bd")
	@ObfuscatedGetter(
		intValue = -768397183
	)
	int field983;
	@ObfuscatedName("bs")
	@ObfuscatedGetter(
		intValue = 340005731
	)
	@Export("spotAnimation")
	int spotAnimation;
	@ObfuscatedName("bx")
	@ObfuscatedGetter(
		intValue = -1782758549
	)
	@Export("spotAnimationFrame")
	int spotAnimationFrame;
	@ObfuscatedName("bh")
	@ObfuscatedGetter(
		intValue = 794012987
	)
	@Export("spotAnimationFrameCycle")
	int spotAnimationFrameCycle;
	@ObfuscatedName("bg")
	@ObfuscatedGetter(
		intValue = 2005510657
	)
	int field979;
	@ObfuscatedName("bz")
	@ObfuscatedGetter(
		intValue = 1479778797
	)
	int field980;
	@ObfuscatedName("bj")
	@ObfuscatedGetter(
		intValue = 1805966651
	)
	int field981;
	@ObfuscatedName("bu")
	@ObfuscatedGetter(
		intValue = 491483643
	)
	int field961;
	@ObfuscatedName("bv")
	@ObfuscatedGetter(
		intValue = 479016033
	)
	int field957;
	@ObfuscatedName("bo")
	@ObfuscatedGetter(
		intValue = 1112662559
	)
	int field991;
	@ObfuscatedName("br")
	@ObfuscatedGetter(
		intValue = -71204417
	)
	int field985;
	@ObfuscatedName("cp")
	@ObfuscatedGetter(
		intValue = 78951405
	)
	int field986;
	@ObfuscatedName("cg")
	@ObfuscatedGetter(
		intValue = 179265201
	)
	int field987;
	@ObfuscatedName("cr")
	@ObfuscatedGetter(
		intValue = -787364139
	)
	@Export("npcCycle")
	int npcCycle;
	@ObfuscatedName("co")
	@ObfuscatedGetter(
		intValue = 1402601371
	)
	@Export("defaultHeight")
	int defaultHeight;
	@ObfuscatedName("ck")
	@ObfuscatedGetter(
		intValue = 186982923
	)
	@Export("orientation")
	int orientation;
	@ObfuscatedName("cn")
	@ObfuscatedGetter(
		intValue = 661505811
	)
	int field956;
	@ObfuscatedName("cd")
	@ObfuscatedGetter(
		intValue = 1778571567
	)
	int field975;
	@ObfuscatedName("ct")
	@ObfuscatedGetter(
		intValue = -1795737793
	)
	@Export("pathLength")
	int pathLength;
	@ObfuscatedName("cb")
	@Export("pathX")
	int[] pathX;
	@ObfuscatedName("cf")
	@Export("pathY")
	int[] pathY;
	@ObfuscatedName("cm")
	@Export("pathTraversed")
	byte[] pathTraversed;
	@ObfuscatedName("cz")
	@ObfuscatedGetter(
		intValue = -1512455111
	)
	int field997;
	@ObfuscatedName("cu")
	@ObfuscatedGetter(
		intValue = -737673093
	)
	int field998;

	Actor() {
		this.isWalking = false;
		this.field942 = 64;
		this.readySequence = -1;
		this.turnLeftSequence = -1;
		this.turnRightSequence = -1;
		this.walkSequence = -1;
		this.walkBackSequence = -1;
		this.walkLeftSequence = -1;
		this.walkRightSequence = -1;
		this.runSequence = -1;
		this.overheadText = null;
		this.field954 = false;
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
		this.field967 = -1;
		this.movementSequence = -1;
		this.movementFrame = 0;
		this.movementFrameCycle = 0;
		this.sequence = -1;
		this.sequenceFrame = 0;
		this.sequenceFrameCycle = 0;
		this.sequenceDelay = 0;
		this.field983 = 0;
		this.spotAnimation = -1;
		this.spotAnimationFrame = 0;
		this.spotAnimationFrameCycle = 0;
		this.npcCycle = 0;
		this.defaultHeight = 200;
		this.field956 = 0;
		this.field975 = 32;
		this.pathLength = 0;
		this.pathX = new int[10];
		this.pathY = new int[10];
		this.pathTraversed = new byte[10];
		this.field997 = 0;
		this.field998 = 0;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-515224238"
	)
	@Export("isVisible")
	boolean isVisible() {
		return false;
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-847107041"
	)
	final void method1740() {
		this.pathLength = 0;
		this.field998 = 0;
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		signature = "(IIIIIII)V",
		garbageValue = "-913342353"
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
			HitSplatDefinition var13 = (HitSplatDefinition)HitSplatDefinition.HitSplatDefinition_cached.get((long)var1);
			HitSplatDefinition var12;
			if (var13 != null) {
				var12 = var13;
			} else {
				byte[] var14 = class49.HitSplatDefinition_archive.takeFile(32, var1);
				var13 = new HitSplatDefinition();
				if (var14 != null) {
					var13.decode(new Buffer(var14));
				}

				HitSplatDefinition.HitSplatDefinition_cached.put(var13, (long)var1);
				var12 = var13;
			}

			var10 = var12.field3337;
			var11 = var12.field3328;
		}

		int var15;
		if (var8) {
			if (var10 == -1) {
				return;
			}

			var9 = 0;
			var15 = 0;
			if (var10 == 0) {
				var15 = this.hitSplatCycles[0];
			} else if (var10 == 1) {
				var15 = this.hitSplatValues[0];
			}

			for (int var16 = 1; var16 < 4; ++var16) {
				if (var10 == 0) {
					if (this.hitSplatCycles[var16] < var15) {
						var9 = var16;
						var15 = this.hitSplatCycles[var16];
					}
				} else if (var10 == 1 && this.hitSplatValues[var16] < var15) {
					var9 = var16;
					var15 = this.hitSplatValues[var16];
				}
			}

			if (var10 == 1 && var15 >= var2) {
				return;
			}
		} else {
			if (var7) {
				this.hitSplatCount = 0;
			}

			for (var15 = 0; var15 < 4; ++var15) {
				byte var17 = this.hitSplatCount;
				this.hitSplatCount = (byte)((this.hitSplatCount + 1) % 4);
				if (this.hitSplatCycles[var17] <= var5) {
					var9 = var17;
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

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		signature = "(IIIIIII)V",
		garbageValue = "1968439377"
	)
	@Export("addHealthBar")
	final void addHealthBar(int var1, int var2, int var3, int var4, int var5, int var6) {
		HealthBarDefinition var7 = PacketWriter.method2329(var1);
		HealthBar var8 = null;
		HealthBar var9 = null;
		int var10 = var7.int2;
		int var11 = 0;

		HealthBar var12;
		for (var12 = (HealthBar)this.healthBars.last(); var12 != null; var12 = (HealthBar)this.healthBars.previous()) {
			++var11;
			if (var12.definition.field3275 == var7.field3275) {
				var12.put(var2 + var4, var5, var6, var3);
				return;
			}

			if (var12.definition.int1 <= var7.int1) {
				var8 = var12;
			}

			if (var12.definition.int2 > var10) {
				var9 = var12;
				var10 = var12.definition.int2;
			}
		}

		if (var9 != null || var11 < 4) {
			var12 = new HealthBar(var7);
			if (var8 == null) {
				this.healthBars.addLast(var12);
			} else {
				IterableNodeDeque.IterableNodeDeque_addBefore(var12, var8);
			}

			var12.put(var2 + var4, var5, var6, var3);
			if (var11 >= 4) {
				var9.remove();
			}

		}
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "51"
	)
	@Export("removeHealthBar")
	final void removeHealthBar(int var1) {
		HealthBarDefinition var2 = PacketWriter.method2329(var1);

		for (HealthBar var3 = (HealthBar)this.healthBars.last(); var3 != null; var3 = (HealthBar)this.healthBars.previous()) {
			if (var2 == var3.definition) {
				var3.remove();
				return;
			}
		}

	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(IIZB)Ljava/lang/String;",
		garbageValue = "91"
	)
	static String method1741(int var0, int var1, boolean var2) {
		if (var1 >= 2 && var1 <= 36) {
			if (var2 && var0 >= 0) {
				int var3 = 2;

				for (int var4 = var0 / var1; var4 != 0; ++var3) {
					var4 /= var1;
				}

				char[] var5 = new char[var3];
				var5[0] = '+';

				for (int var6 = var3 - 1; var6 > 0; --var6) {
					int var7 = var0;
					var0 /= var1;
					int var8 = var7 - var0 * var1;
					if (var8 >= 10) {
						var5[var6] = (char)(var8 + 87);
					} else {
						var5[var6] = (char)(var8 + 48);
					}
				}

				return new String(var5);
			} else {
				return Integer.toString(var0, var1);
			}
		} else {
			throw new IllegalArgumentException("" + var1);
		}
	}
}
