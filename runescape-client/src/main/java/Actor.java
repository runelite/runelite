import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bq")
@Implements("Actor")
public abstract class Actor extends Entity {
	@ObfuscatedName("aw")
	@ObfuscatedGetter(
		intValue = 1528091447
	)
	@Export("x")
	int x;
	@ObfuscatedName("ad")
	@ObfuscatedGetter(
		intValue = -390280385
	)
	@Export("y")
	int y;
	@ObfuscatedName("ag")
	@ObfuscatedGetter(
		intValue = 1236559867
	)
	int field950;
	@ObfuscatedName("ar")
	boolean field967;
	@ObfuscatedName("ax")
	@Export("size")
	int size;
	@ObfuscatedName("az")
	@ObfuscatedGetter(
		intValue = 990710297
	)
	@Export("playerCycle")
	int playerCycle;
	@ObfuscatedName("ae")
	@ObfuscatedGetter(
		intValue = 2081393933
	)
	@Export("readySequence")
	int readySequence;
	@ObfuscatedName("ao")
	@ObfuscatedGetter(
		intValue = 1431486431
	)
	@Export("turnLeftSequence")
	int turnLeftSequence;
	@ObfuscatedName("aj")
	@ObfuscatedGetter(
		intValue = 2143634015
	)
	@Export("turnRightSequence")
	int turnRightSequence;
	@ObfuscatedName("at")
	@ObfuscatedGetter(
		intValue = -1300778473
	)
	@Export("walkSequence")
	int walkSequence;
	@ObfuscatedName("ac")
	@ObfuscatedGetter(
		intValue = 415761655
	)
	@Export("walkBackSequence")
	int walkBackSequence;
	@ObfuscatedName("ap")
	@ObfuscatedGetter(
		intValue = -1586227603
	)
	@Export("walkLeftSequence")
	int walkLeftSequence;
	@ObfuscatedName("aq")
	@ObfuscatedGetter(
		intValue = -510900587
	)
	@Export("walkRightSequence")
	int walkRightSequence;
	@ObfuscatedName("aa")
	@ObfuscatedGetter(
		intValue = 1475013463
	)
	@Export("runSequence")
	int runSequence;
	@ObfuscatedName("an")
	@Export("overheadText")
	String overheadText;
	@ObfuscatedName("au")
	@Export("isAutoChatting")
	boolean isAutoChatting;
	@ObfuscatedName("ai")
	boolean field998;
	@ObfuscatedName("ak")
	@ObfuscatedGetter(
		intValue = 1272238473
	)
	@Export("overheadTextCyclesRemaining")
	int overheadTextCyclesRemaining;
	@ObfuscatedName("ah")
	@ObfuscatedGetter(
		intValue = 22112303
	)
	@Export("overheadTextColor")
	int overheadTextColor;
	@ObfuscatedName("am")
	@ObfuscatedGetter(
		intValue = 1107006481
	)
	@Export("overheadTextEffect")
	int overheadTextEffect;
	@ObfuscatedName("af")
	@Export("hitSplatCount")
	byte hitSplatCount;
	@ObfuscatedName("ab")
	@Export("hitSplatTypes")
	int[] hitSplatTypes;
	@ObfuscatedName("bp")
	@Export("hitSplatValues")
	int[] hitSplatValues;
	@ObfuscatedName("bz")
	@Export("hitSplatCycles")
	int[] hitSplatCycles;
	@ObfuscatedName("bi")
	@Export("hitSplatTypes2")
	int[] hitSplatTypes2;
	@ObfuscatedName("bg")
	@Export("hitSplatValues2")
	int[] hitSplatValues2;
	@ObfuscatedName("bh")
	@ObfuscatedSignature(
		signature = "Lju;"
	)
	@Export("healthBars")
	IterableNodeDeque healthBars;
	@ObfuscatedName("bm")
	@ObfuscatedGetter(
		intValue = 1587933085
	)
	@Export("targetIndex")
	int targetIndex;
	@ObfuscatedName("bn")
	@Export("false0")
	boolean false0;
	@ObfuscatedName("bc")
	@ObfuscatedGetter(
		intValue = -2012515929
	)
	int field976;
	@ObfuscatedName("bx")
	@ObfuscatedGetter(
		intValue = 1552753251
	)
	@Export("movementSequence")
	int movementSequence;
	@ObfuscatedName("bo")
	@ObfuscatedGetter(
		intValue = 1656230573
	)
	@Export("movementFrame")
	int movementFrame;
	@ObfuscatedName("bb")
	@ObfuscatedGetter(
		intValue = 789237355
	)
	@Export("movementFrameCycle")
	int movementFrameCycle;
	@ObfuscatedName("bs")
	@ObfuscatedGetter(
		intValue = -1029202699
	)
	@Export("sequence")
	int sequence;
	@ObfuscatedName("bj")
	@ObfuscatedGetter(
		intValue = 1698363493
	)
	@Export("sequenceFrame")
	int sequenceFrame;
	@ObfuscatedName("bl")
	@ObfuscatedGetter(
		intValue = -1057767495
	)
	@Export("sequenceFrameCycle")
	int sequenceFrameCycle;
	@ObfuscatedName("bd")
	@ObfuscatedGetter(
		intValue = -1679741685
	)
	@Export("sequenceDelay")
	int sequenceDelay;
	@ObfuscatedName("by")
	@ObfuscatedGetter(
		intValue = 1192767673
	)
	int field985;
	@ObfuscatedName("bt")
	@ObfuscatedGetter(
		intValue = 606261849
	)
	@Export("spotAnimation")
	int spotAnimation;
	@ObfuscatedName("bq")
	@ObfuscatedGetter(
		intValue = 47256047
	)
	@Export("spotAnimationFrame")
	int spotAnimationFrame;
	@ObfuscatedName("bu")
	@ObfuscatedGetter(
		intValue = -50887377
	)
	@Export("spotAnimationFrameCycle")
	int spotAnimationFrameCycle;
	@ObfuscatedName("bw")
	@ObfuscatedGetter(
		intValue = -2008312019
	)
	int field989;
	@ObfuscatedName("br")
	@ObfuscatedGetter(
		intValue = -21231063
	)
	@Export("heightOffset")
	int heightOffset;
	@ObfuscatedName("bk")
	@ObfuscatedGetter(
		intValue = 67427601
	)
	int field991;
	@ObfuscatedName("bf")
	@ObfuscatedGetter(
		intValue = 1057554273
	)
	int field992;
	@ObfuscatedName("bv")
	@ObfuscatedGetter(
		intValue = 1321176455
	)
	int field993;
	@ObfuscatedName("be")
	@ObfuscatedGetter(
		intValue = -1276485965
	)
	int field983;
	@ObfuscatedName("ba")
	@ObfuscatedGetter(
		intValue = -851079763
	)
	int field995;
	@ObfuscatedName("cr")
	@ObfuscatedGetter(
		intValue = -352767789
	)
	int field996;
	@ObfuscatedName("cf")
	@ObfuscatedGetter(
		intValue = -342620369
	)
	int field997;
	@ObfuscatedName("cj")
	@ObfuscatedGetter(
		intValue = 1247160827
	)
	@Export("npcCycle")
	int npcCycle;
	@ObfuscatedName("cl")
	@ObfuscatedGetter(
		intValue = 1753110543
	)
	@Export("defaultHeight")
	int defaultHeight;
	@ObfuscatedName("cn")
	@ObfuscatedGetter(
		intValue = 1217852897
	)
	@Export("orientation")
	int orientation;
	@ObfuscatedName("cy")
	@ObfuscatedGetter(
		intValue = -146454839
	)
	int field1009;
	@ObfuscatedName("ct")
	@ObfuscatedGetter(
		intValue = 1670871863
	)
	int field948;
	@ObfuscatedName("cq")
	@ObfuscatedGetter(
		intValue = 1967067825
	)
	@Export("pathLength")
	int pathLength;
	@ObfuscatedName("cp")
	@Export("pathX")
	int[] pathX;
	@ObfuscatedName("ch")
	@Export("pathY")
	int[] pathY;
	@ObfuscatedName("co")
	@Export("pathTraversed")
	byte[] pathTraversed;
	@ObfuscatedName("cw")
	@ObfuscatedGetter(
		intValue = -615012941
	)
	int field1007;
	@ObfuscatedName("ca")
	@ObfuscatedGetter(
		intValue = 829354671
	)
	int field1008;

	Actor() {
		this.field967 = false;
		this.size = 78073455;
		this.readySequence = -1;
		this.turnLeftSequence = -1;
		this.turnRightSequence = -1;
		this.walkSequence = -1;
		this.walkBackSequence = -1;
		this.walkLeftSequence = -1;
		this.walkRightSequence = -1;
		this.runSequence = -1;
		this.overheadText = null;
		this.field998 = false;
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
		this.field976 = -1;
		this.movementSequence = -1;
		this.movementFrame = 0;
		this.movementFrameCycle = 0;
		this.sequence = -1;
		this.sequenceFrame = 0;
		this.sequenceFrameCycle = 0;
		this.sequenceDelay = 0;
		this.field985 = 0;
		this.spotAnimation = -1;
		this.spotAnimationFrame = 0;
		this.spotAnimationFrameCycle = 0;
		this.npcCycle = 0;
		this.defaultHeight = 200;
		this.field1009 = 0;
		this.field948 = 32;
		this.pathLength = 0;
		this.pathX = new int[10];
		this.pathY = new int[10];
		this.pathTraversed = new byte[10];
		this.field1007 = 0;
		this.field1008 = 0;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-1461786701"
	)
	@Export("isVisible")
	boolean isVisible() {
		return false;
	}

	@ObfuscatedName("bp")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1575805976"
	)
	final void method1658() {
		this.pathLength = 0;
		this.field1008 = 0;
	}

	@ObfuscatedName("bz")
	@ObfuscatedSignature(
		signature = "(IIIIIII)V",
		garbageValue = "295125263"
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
			HitSplatDefinition var12 = Projectile.getHitSplatDefinition(var1);
			var10 = var12.field3348;
			var11 = var12.field3344;
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

	@ObfuscatedName("bi")
	@ObfuscatedSignature(
		signature = "(IIIIIIB)V",
		garbageValue = "15"
	)
	@Export("addHealthBar")
	final void addHealthBar(int var1, int var2, int var3, int var4, int var5, int var6) {
		HealthBarDefinition var7 = class51.method854(var1);
		HealthBar var8 = null;
		HealthBar var9 = null;
		int var10 = var7.int2;
		int var11 = 0;

		HealthBar var12;
		for (var12 = (HealthBar)this.healthBars.last(); var12 != null; var12 = (HealthBar)this.healthBars.previous()) {
			++var11;
			if (var12.definition.field3279 == var7.field3279) {
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

	@ObfuscatedName("bg")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "1541896355"
	)
	@Export("removeHealthBar")
	final void removeHealthBar(int var1) {
		HealthBarDefinition var2 = class51.method854(var1);

		for (HealthBar var3 = (HealthBar)this.healthBars.last(); var3 != null; var3 = (HealthBar)this.healthBars.previous()) {
			if (var2 == var3.definition) {
				var3.remove();
				return;
			}
		}

	}

	@ObfuscatedName("kh")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-105"
	)
	static void method1670() {
		if (Client.oculusOrbState == 1) {
			Client.field736 = true;
		}

	}
}
