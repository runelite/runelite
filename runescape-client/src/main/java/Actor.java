import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("by")
@Implements("Actor")
public abstract class Actor extends Entity {
	@ObfuscatedName("aa")
	@ObfuscatedGetter(
		intValue = -1124819045
	)
	@Export("x")
	int x;
	@ObfuscatedName("ap")
	@ObfuscatedGetter(
		intValue = 682054857
	)
	@Export("y")
	int y;
	@ObfuscatedName("ar")
	@ObfuscatedGetter(
		intValue = -1546716831
	)
	@Export("rotation")
	int rotation;
	@ObfuscatedName("ab")
	@Export("isWalking")
	boolean isWalking;
	@ObfuscatedName("ax")
	@Export("size")
	int size;
	@ObfuscatedName("as")
	@ObfuscatedGetter(
		intValue = -334562759
	)
	@Export("playerCycle")
	int playerCycle;
	@ObfuscatedName("ao")
	@ObfuscatedGetter(
		intValue = 1344678569
	)
	@Export("readySequence")
	int readySequence;
	@ObfuscatedName("al")
	@ObfuscatedGetter(
		intValue = 1716804711
	)
	@Export("turnLeftSequence")
	int turnLeftSequence;
	@ObfuscatedName("ad")
	@ObfuscatedGetter(
		intValue = 1564906087
	)
	@Export("turnRightSequence")
	int turnRightSequence;
	@ObfuscatedName("an")
	@ObfuscatedGetter(
		intValue = 1786260681
	)
	@Export("walkSequence")
	int walkSequence;
	@ObfuscatedName("ai")
	@ObfuscatedGetter(
		intValue = 864493635
	)
	@Export("walkBackSequence")
	int walkBackSequence;
	@ObfuscatedName("ak")
	@ObfuscatedGetter(
		intValue = 632813703
	)
	@Export("walkLeftSequence")
	int walkLeftSequence;
	@ObfuscatedName("aq")
	@ObfuscatedGetter(
		intValue = -67215047
	)
	@Export("walkRightSequence")
	int walkRightSequence;
	@ObfuscatedName("am")
	@ObfuscatedGetter(
		intValue = 1501032191
	)
	@Export("runSequence")
	int runSequence;
	@ObfuscatedName("ae")
	@Export("overheadText")
	String overheadText;
	@ObfuscatedName("av")
	@Export("isAutoChatting")
	boolean isAutoChatting;
	@ObfuscatedName("ah")
	boolean field944;
	@ObfuscatedName("ag")
	@ObfuscatedGetter(
		intValue = -1435944093
	)
	@Export("overheadTextCyclesRemaining")
	int overheadTextCyclesRemaining;
	@ObfuscatedName("aj")
	@ObfuscatedGetter(
		intValue = 402893763
	)
	@Export("overheadTextColor")
	int overheadTextColor;
	@ObfuscatedName("ay")
	@ObfuscatedGetter(
		intValue = 2008647289
	)
	@Export("overheadTextEffect")
	int overheadTextEffect;
	@ObfuscatedName("af")
	@Export("hitSplatCount")
	byte hitSplatCount;
	@ObfuscatedName("at")
	@Export("hitSplatTypes")
	int[] hitSplatTypes;
	@ObfuscatedName("bx")
	@Export("hitSplatValues")
	int[] hitSplatValues;
	@ObfuscatedName("bh")
	@Export("hitSplatCycles")
	int[] hitSplatCycles;
	@ObfuscatedName("bd")
	@Export("hitSplatTypes2")
	int[] hitSplatTypes2;
	@ObfuscatedName("bm")
	@Export("hitSplatValues2")
	int[] hitSplatValues2;
	@ObfuscatedName("bv")
	@ObfuscatedSignature(
		signature = "Ljs;"
	)
	@Export("healthBars")
	IterableNodeDeque healthBars;
	@ObfuscatedName("bj")
	@ObfuscatedGetter(
		intValue = -173770189
	)
	@Export("targetIndex")
	int targetIndex;
	@ObfuscatedName("bs")
	@Export("false0")
	boolean false0;
	@ObfuscatedName("bz")
	@ObfuscatedGetter(
		intValue = -708767615
	)
	int field957;
	@ObfuscatedName("bc")
	@ObfuscatedGetter(
		intValue = 592854061
	)
	@Export("movementSequence")
	int movementSequence;
	@ObfuscatedName("bk")
	@ObfuscatedGetter(
		intValue = 1334696243
	)
	@Export("movementFrame")
	int movementFrame;
	@ObfuscatedName("ba")
	@ObfuscatedGetter(
		intValue = -1979514767
	)
	@Export("movementFrameCycle")
	int movementFrameCycle;
	@ObfuscatedName("bn")
	@ObfuscatedGetter(
		intValue = -1879648645
	)
	@Export("sequence")
	int sequence;
	@ObfuscatedName("be")
	@ObfuscatedGetter(
		intValue = -1726927213
	)
	@Export("sequenceFrame")
	int sequenceFrame;
	@ObfuscatedName("bu")
	@ObfuscatedGetter(
		intValue = 1584241957
	)
	@Export("sequenceFrameCycle")
	int sequenceFrameCycle;
	@ObfuscatedName("bi")
	@ObfuscatedGetter(
		intValue = 1536092043
	)
	@Export("sequenceDelay")
	int sequenceDelay;
	@ObfuscatedName("bb")
	@ObfuscatedGetter(
		intValue = -807055771
	)
	int field965;
	@ObfuscatedName("bt")
	@ObfuscatedGetter(
		intValue = -759724979
	)
	@Export("spotAnimation")
	int spotAnimation;
	@ObfuscatedName("by")
	@ObfuscatedGetter(
		intValue = 1088352163
	)
	@Export("spotAnimationFrame")
	int spotAnimationFrame;
	@ObfuscatedName("bq")
	@ObfuscatedGetter(
		intValue = -340493791
	)
	@Export("spotAnimationFrameCycle")
	int spotAnimationFrameCycle;
	@ObfuscatedName("bo")
	@ObfuscatedGetter(
		intValue = 2083696993
	)
	int field969;
	@ObfuscatedName("br")
	@ObfuscatedGetter(
		intValue = 2099588065
	)
	@Export("heightOffset")
	int heightOffset;
	@ObfuscatedName("bl")
	@ObfuscatedGetter(
		intValue = 337038295
	)
	int field971;
	@ObfuscatedName("bf")
	@ObfuscatedGetter(
		intValue = -1218021367
	)
	int field972;
	@ObfuscatedName("bg")
	@ObfuscatedGetter(
		intValue = -1028826911
	)
	int field973;
	@ObfuscatedName("bw")
	@ObfuscatedGetter(
		intValue = 682547279
	)
	int field974;
	@ObfuscatedName("bp")
	@ObfuscatedGetter(
		intValue = 647023113
	)
	int field948;
	@ObfuscatedName("cz")
	@ObfuscatedGetter(
		intValue = -521720929
	)
	int field976;
	@ObfuscatedName("ck")
	@ObfuscatedGetter(
		intValue = 2050032535
	)
	int field977;
	@ObfuscatedName("cv")
	@ObfuscatedGetter(
		intValue = 1347834439
	)
	@Export("npcCycle")
	int npcCycle;
	@ObfuscatedName("co")
	@ObfuscatedGetter(
		intValue = -1864995671
	)
	@Export("defaultHeight")
	int defaultHeight;
	@ObfuscatedName("cs")
	@ObfuscatedGetter(
		intValue = -459931913
	)
	@Export("orientation")
	int orientation;
	@ObfuscatedName("cg")
	@ObfuscatedGetter(
		intValue = -1988821201
	)
	int field981;
	@ObfuscatedName("cn")
	@ObfuscatedGetter(
		intValue = -1277282795
	)
	int field982;
	@ObfuscatedName("cd")
	@ObfuscatedGetter(
		intValue = -948674291
	)
	@Export("pathLength")
	int pathLength;
	@ObfuscatedName("cy")
	@Export("pathX")
	int[] pathX;
	@ObfuscatedName("cj")
	@Export("pathY")
	int[] pathY;
	@ObfuscatedName("cb")
	@Export("pathTraversed")
	byte[] pathTraversed;
	@ObfuscatedName("cr")
	@ObfuscatedGetter(
		intValue = 2121676837
	)
	int field949;
	@ObfuscatedName("ct")
	@ObfuscatedGetter(
		intValue = -207338457
	)
	int field988;

	Actor() {
		this.isWalking = false;
		this.size = 772175475;
		this.readySequence = -1;
		this.turnLeftSequence = -1;
		this.turnRightSequence = -1;
		this.walkSequence = -1;
		this.walkBackSequence = -1;
		this.walkLeftSequence = -1;
		this.walkRightSequence = -1;
		this.runSequence = -1;
		this.overheadText = null;
		this.field944 = false;
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
		this.field957 = -1;
		this.movementSequence = -1;
		this.movementFrame = 0;
		this.movementFrameCycle = 0;
		this.sequence = -1;
		this.sequenceFrame = 0;
		this.sequenceFrameCycle = 0;
		this.sequenceDelay = 0;
		this.field965 = 0;
		this.spotAnimation = -1;
		this.spotAnimationFrame = 0;
		this.spotAnimationFrameCycle = 0;
		this.npcCycle = 0;
		this.defaultHeight = 200;
		this.field981 = 0;
		this.field982 = 32;
		this.pathLength = 0;
		this.pathX = new int[10];
		this.pathY = new int[10];
		this.pathTraversed = new byte[10];
		this.field949 = 0;
		this.field988 = 0;
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(S)Z",
		garbageValue = "180"
	)
	@Export("isVisible")
	boolean isVisible() {
		return false;
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "4"
	)
	final void method1765() {
		this.pathLength = 0;
		this.field988 = 0;
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		signature = "(IIIIIII)V",
		garbageValue = "341931021"
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
				byte[] var14 = HitSplatDefinition.HitSplatDefinition_archive.takeFile(32, var1);
				var13 = new HitSplatDefinition();
				if (var14 != null) {
					var13.decode(new Buffer(var14));
				}

				HitSplatDefinition.HitSplatDefinition_cached.put(var13, (long)var1);
				var12 = var13;
			}

			var10 = var12.field3327;
			var11 = var12.field3318;
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

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		signature = "(IIIIIIB)V",
		garbageValue = "31"
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
			if (var13.definition.field3258 == var8.field3258) {
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

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "1895868902"
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
}
