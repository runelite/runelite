import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cw")
@Implements("Actor")
public abstract class Actor extends Entity {
	@ObfuscatedName("an")
	@Export("isWalking")
	boolean isWalking;
	@ObfuscatedName("ab")
	@ObfuscatedGetter(
		intValue = -1730088457
	)
	@Export("x")
	int x;
	@ObfuscatedName("ar")
	@ObfuscatedGetter(
		intValue = 58548893
	)
	@Export("y")
	int y;
	@ObfuscatedName("af")
	@ObfuscatedGetter(
		intValue = 2047396387
	)
	@Export("rotation")
	int rotation;
	@ObfuscatedName("at")
	@ObfuscatedGetter(
		intValue = 747650361
	)
	int field976;
	@ObfuscatedName("al")
	@ObfuscatedGetter(
		intValue = 1154559573
	)
	@Export("playerCycle")
	int playerCycle;
	@ObfuscatedName("as")
	@ObfuscatedGetter(
		intValue = 399800473
	)
	@Export("readySequence")
	int readySequence;
	@ObfuscatedName("am")
	@ObfuscatedGetter(
		intValue = -684262003
	)
	@Export("turnLeftSequence")
	int turnLeftSequence;
	@ObfuscatedName("au")
	@ObfuscatedGetter(
		intValue = -1952661919
	)
	@Export("turnRightSequence")
	int turnRightSequence;
	@ObfuscatedName("ao")
	@ObfuscatedGetter(
		intValue = 2064847885
	)
	@Export("walkSequence")
	int walkSequence;
	@ObfuscatedName("aq")
	@ObfuscatedGetter(
		intValue = 1807346449
	)
	@Export("walkBackSequence")
	int walkBackSequence;
	@ObfuscatedName("av")
	@ObfuscatedGetter(
		intValue = -598231963
	)
	@Export("walkLeftSequence")
	int walkLeftSequence;
	@ObfuscatedName("ak")
	@ObfuscatedGetter(
		intValue = -1622741341
	)
	@Export("walkRightSequence")
	int walkRightSequence;
	@ObfuscatedName("aa")
	@ObfuscatedGetter(
		intValue = 1458798213
	)
	@Export("runSequence")
	int runSequence;
	@ObfuscatedName("ax")
	@Export("overheadText")
	String overheadText;
	@ObfuscatedName("az")
	@Export("isAutoChatting")
	boolean isAutoChatting;
	@ObfuscatedName("aj")
	boolean field988;
	@ObfuscatedName("ay")
	@ObfuscatedGetter(
		intValue = -1807093205
	)
	@Export("overheadTextCyclesRemaining")
	int overheadTextCyclesRemaining;
	@ObfuscatedName("ad")
	@ObfuscatedGetter(
		intValue = -1168789031
	)
	@Export("overheadTextColor")
	int overheadTextColor;
	@ObfuscatedName("ac")
	@ObfuscatedGetter(
		intValue = -54296883
	)
	@Export("overheadTextEffect")
	int overheadTextEffect;
	@ObfuscatedName("ag")
	@Export("hitSplatCount")
	byte hitSplatCount;
	@ObfuscatedName("aw")
	@Export("hitSplatTypes")
	int[] hitSplatTypes;
	@ObfuscatedName("bf")
	@Export("hitSplatValues")
	int[] hitSplatValues;
	@ObfuscatedName("bc")
	@Export("hitSplatCycles")
	int[] hitSplatCycles;
	@ObfuscatedName("bo")
	@Export("hitSplatTypes2")
	int[] hitSplatTypes2;
	@ObfuscatedName("bd")
	@Export("hitSplatValues2")
	int[] hitSplatValues2;
	@ObfuscatedName("bk")
	@ObfuscatedSignature(
		signature = "Ljm;"
	)
	@Export("healthBars")
	IterableNodeDeque healthBars;
	@ObfuscatedName("bu")
	@ObfuscatedGetter(
		intValue = 1906218843
	)
	@Export("targetIndex")
	int targetIndex;
	@ObfuscatedName("be")
	@Export("false0")
	boolean false0;
	@ObfuscatedName("bg")
	@ObfuscatedGetter(
		intValue = -1444761415
	)
	int field1015;
	@ObfuscatedName("bt")
	@ObfuscatedGetter(
		intValue = 1296285639
	)
	@Export("movementSequence")
	int movementSequence;
	@ObfuscatedName("bh")
	@ObfuscatedGetter(
		intValue = -1097128947
	)
	@Export("movementFrame")
	int movementFrame;
	@ObfuscatedName("br")
	@ObfuscatedGetter(
		intValue = 1112091343
	)
	@Export("movementFrameCycle")
	int movementFrameCycle;
	@ObfuscatedName("bq")
	@ObfuscatedGetter(
		intValue = -20846645
	)
	@Export("sequence")
	int sequence;
	@ObfuscatedName("ba")
	@ObfuscatedGetter(
		intValue = 1620009483
	)
	@Export("sequenceFrame")
	int sequenceFrame;
	@ObfuscatedName("bv")
	@ObfuscatedGetter(
		intValue = 1370333627
	)
	@Export("sequenceFrameCycle")
	int sequenceFrameCycle;
	@ObfuscatedName("bx")
	@ObfuscatedGetter(
		intValue = -1532646011
	)
	@Export("sequenceDelay")
	int sequenceDelay;
	@ObfuscatedName("bz")
	@ObfuscatedGetter(
		intValue = 743745547
	)
	int field1011;
	@ObfuscatedName("bs")
	@ObfuscatedGetter(
		intValue = -1600718851
	)
	@Export("spotAnimation")
	int spotAnimation;
	@ObfuscatedName("bp")
	@ObfuscatedGetter(
		intValue = -595193051
	)
	@Export("spotAnimationFrame")
	int spotAnimationFrame;
	@ObfuscatedName("bm")
	@ObfuscatedGetter(
		intValue = -1426517203
	)
	@Export("spotAnimationFrameCycle")
	int spotAnimationFrameCycle;
	@ObfuscatedName("bb")
	@ObfuscatedGetter(
		intValue = 1048299633
	)
	int field1013;
	@ObfuscatedName("bn")
	@ObfuscatedGetter(
		intValue = 1503080001
	)
	int field1033;
	@ObfuscatedName("by")
	@ObfuscatedGetter(
		intValue = 1317270699
	)
	int field990;
	@ObfuscatedName("bj")
	@ObfuscatedGetter(
		intValue = 1667801647
	)
	int field972;
	@ObfuscatedName("bi")
	@ObfuscatedGetter(
		intValue = 441172781
	)
	int field1017;
	@ObfuscatedName("bl")
	@ObfuscatedGetter(
		intValue = -1550774947
	)
	int field1018;
	@ObfuscatedName("bw")
	@ObfuscatedGetter(
		intValue = -625975993
	)
	int field1019;
	@ObfuscatedName("cw")
	@ObfuscatedGetter(
		intValue = 1067146179
	)
	int field1020;
	@ObfuscatedName("cc")
	@ObfuscatedGetter(
		intValue = 1247809135
	)
	int field1021;
	@ObfuscatedName("ch")
	@ObfuscatedGetter(
		intValue = 1215799343
	)
	@Export("npcCycle")
	int npcCycle;
	@ObfuscatedName("cr")
	@ObfuscatedGetter(
		intValue = 1881116621
	)
	@Export("defaultHeight")
	int defaultHeight;
	@ObfuscatedName("cq")
	@ObfuscatedGetter(
		intValue = 616594567
	)
	@Export("orientation")
	int orientation;
	@ObfuscatedName("co")
	@ObfuscatedGetter(
		intValue = 230967505
	)
	int field1025;
	@ObfuscatedName("cm")
	@ObfuscatedGetter(
		intValue = 2061571405
	)
	int field1026;
	@ObfuscatedName("cu")
	@ObfuscatedGetter(
		intValue = -525774551
	)
	@Export("pathLength")
	int pathLength;
	@ObfuscatedName("cs")
	@Export("pathX")
	int[] pathX;
	@ObfuscatedName("cg")
	@Export("pathY")
	int[] pathY;
	@ObfuscatedName("cd")
	@Export("pathTraversed")
	byte[] pathTraversed;
	@ObfuscatedName("cx")
	@ObfuscatedGetter(
		intValue = -1741747755
	)
	int field1031;
	@ObfuscatedName("cn")
	@ObfuscatedGetter(
		intValue = -932937077
	)
	int field1032;

	Actor() {
		this.isWalking = false;
		this.field976 = 1;
		this.readySequence = -1;
		this.turnLeftSequence = -1;
		this.turnRightSequence = -1;
		this.walkSequence = -1;
		this.walkBackSequence = -1;
		this.walkLeftSequence = -1;
		this.walkRightSequence = -1;
		this.runSequence = -1;
		this.overheadText = null;
		this.field988 = false;
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
		this.field1015 = -1;
		this.movementSequence = -1;
		this.movementFrame = 0;
		this.movementFrameCycle = 0;
		this.sequence = -1;
		this.sequenceFrame = 0;
		this.sequenceFrameCycle = 0;
		this.sequenceDelay = 0;
		this.field1011 = 0;
		this.spotAnimation = -1;
		this.spotAnimationFrame = 0;
		this.spotAnimationFrameCycle = 0;
		this.npcCycle = 0;
		this.defaultHeight = 200;
		this.field1025 = 0;
		this.field1026 = 32;
		this.pathLength = 0;
		this.pathX = new int[10];
		this.pathY = new int[10];
		this.pathTraversed = new byte[10];
		this.field1031 = 0;
		this.field1032 = 0;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "116176402"
	)
	@Export("isVisible")
	boolean isVisible() {
		return false;
	}

	@ObfuscatedName("bu")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1960813077"
	)
	final void method1842() {
		this.pathLength = 0;
		this.field1032 = 0;
	}

	@ObfuscatedName("be")
	@ObfuscatedSignature(
		signature = "(IIIIIII)V",
		garbageValue = "-1774762927"
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
			HitSplatDefinition var12 = GrandExchangeOfferUnitPriceComparator.method213(var1);
			var10 = var12.field3327;
			var11 = var12.field3329;
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

	@ObfuscatedName("bg")
	@ObfuscatedSignature(
		signature = "(IIIIIIB)V",
		garbageValue = "-58"
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
			if (var13.definition.field3276 == var8.field3276) {
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

	@ObfuscatedName("bt")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "671360815"
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

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "-2086656267"
	)
	static int method1860(int var0) {
		return (int)((Math.log((double)var0) / Interpreter.field1128 - 7.0D) * 256.0D);
	}
}
