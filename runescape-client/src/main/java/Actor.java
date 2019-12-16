import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bv")
@Implements("Actor")
public abstract class Actor extends Entity {
	@ObfuscatedName("as")
	@ObfuscatedGetter(
		intValue = 274195699
	)
	@Export("x")
	int x;
	@ObfuscatedName("ak")
	@ObfuscatedGetter(
		intValue = 1601699261
	)
	@Export("y")
	int y;
	@ObfuscatedName("au")
	@ObfuscatedGetter(
		intValue = -1309373011
	)
	@Export("rotation")
	int rotation;
	@ObfuscatedName("ah")
	@Export("isWalking")
	boolean isWalking;
	@ObfuscatedName("aq")
	@ObfuscatedGetter(
		intValue = 511883639
	)
	int field925;
	@ObfuscatedName("ao")
	@ObfuscatedGetter(
		intValue = -1397421297
	)
	@Export("playerCycle")
	int playerCycle;
	@ObfuscatedName("an")
	@ObfuscatedGetter(
		intValue = -218556909
	)
	@Export("readySequence")
	int readySequence;
	@ObfuscatedName("ar")
	@ObfuscatedGetter(
		intValue = -1204927265
	)
	@Export("turnLeftSequence")
	int turnLeftSequence;
	@ObfuscatedName("az")
	@ObfuscatedGetter(
		intValue = -824766843
	)
	@Export("turnRightSequence")
	int turnRightSequence;
	@ObfuscatedName("ay")
	@ObfuscatedGetter(
		intValue = -1263337971
	)
	@Export("walkSequence")
	int walkSequence;
	@ObfuscatedName("ag")
	@ObfuscatedGetter(
		intValue = -1033895093
	)
	@Export("walkBackSequence")
	int walkBackSequence;
	@ObfuscatedName("ac")
	@ObfuscatedGetter(
		intValue = 1049050611
	)
	@Export("walkLeftSequence")
	int walkLeftSequence;
	@ObfuscatedName("al")
	@ObfuscatedGetter(
		intValue = -1372236963
	)
	@Export("walkRightSequence")
	int walkRightSequence;
	@ObfuscatedName("ae")
	@ObfuscatedGetter(
		intValue = -1324653627
	)
	@Export("runSequence")
	int runSequence;
	@ObfuscatedName("ad")
	@Export("overheadText")
	String overheadText;
	@ObfuscatedName("aj")
	@Export("isAutoChatting")
	boolean isAutoChatting;
	@ObfuscatedName("ax")
	boolean field937;
	@ObfuscatedName("at")
	@ObfuscatedGetter(
		intValue = -171465493
	)
	@Export("overheadTextCyclesRemaining")
	int overheadTextCyclesRemaining;
	@ObfuscatedName("af")
	@ObfuscatedGetter(
		intValue = -1280129029
	)
	@Export("overheadTextColor")
	int overheadTextColor;
	@ObfuscatedName("ap")
	@ObfuscatedGetter(
		intValue = -373599431
	)
	@Export("overheadTextEffect")
	int overheadTextEffect;
	@ObfuscatedName("am")
	@Export("hitSplatCount")
	byte hitSplatCount;
	@ObfuscatedName("ab")
	@Export("hitSplatTypes")
	int[] hitSplatTypes;
	@ObfuscatedName("bj")
	@Export("hitSplatValues")
	int[] hitSplatValues;
	@ObfuscatedName("bg")
	@Export("hitSplatCycles")
	int[] hitSplatCycles;
	@ObfuscatedName("bw")
	@Export("hitSplatTypes2")
	int[] hitSplatTypes2;
	@ObfuscatedName("bk")
	@Export("hitSplatValues2")
	int[] hitSplatValues2;
	@ObfuscatedName("bl")
	@ObfuscatedSignature(
		signature = "Ljl;"
	)
	@Export("healthBars")
	IterableNodeDeque healthBars;
	@ObfuscatedName("bq")
	@ObfuscatedGetter(
		intValue = -842697287
	)
	@Export("targetIndex")
	int targetIndex;
	@ObfuscatedName("bx")
	@Export("false0")
	boolean false0;
	@ObfuscatedName("bc")
	@ObfuscatedGetter(
		intValue = -2004895213
	)
	int field960;
	@ObfuscatedName("by")
	@ObfuscatedGetter(
		intValue = -1753452087
	)
	@Export("movementSequence")
	int movementSequence;
	@ObfuscatedName("bz")
	@ObfuscatedGetter(
		intValue = 25834883
	)
	@Export("movementFrame")
	int movementFrame;
	@ObfuscatedName("bm")
	@ObfuscatedGetter(
		intValue = -143174307
	)
	@Export("movementFrameCycle")
	int movementFrameCycle;
	@ObfuscatedName("bo")
	@ObfuscatedGetter(
		intValue = 382239063
	)
	@Export("sequence")
	int sequence;
	@ObfuscatedName("bs")
	@ObfuscatedGetter(
		intValue = -226786267
	)
	@Export("sequenceFrame")
	int sequenceFrame;
	@ObfuscatedName("ba")
	@ObfuscatedGetter(
		intValue = 175494277
	)
	@Export("sequenceFrameCycle")
	int sequenceFrameCycle;
	@ObfuscatedName("bn")
	@ObfuscatedGetter(
		intValue = 62784213
	)
	@Export("sequenceDelay")
	int sequenceDelay;
	@ObfuscatedName("bb")
	@ObfuscatedGetter(
		intValue = 1890920221
	)
	int field958;
	@ObfuscatedName("bh")
	@ObfuscatedGetter(
		intValue = 185005207
	)
	@Export("spotAnimation")
	int spotAnimation;
	@ObfuscatedName("bv")
	@ObfuscatedGetter(
		intValue = 1786856989
	)
	@Export("spotAnimationFrame")
	int spotAnimationFrame;
	@ObfuscatedName("bu")
	@ObfuscatedGetter(
		intValue = -327769151
	)
	@Export("spotAnimationFrameCycle")
	int spotAnimationFrameCycle;
	@ObfuscatedName("be")
	@ObfuscatedGetter(
		intValue = -1796469609
	)
	int field943;
	@ObfuscatedName("bd")
	@ObfuscatedGetter(
		intValue = 1623110031
	)
	int field963;
	@ObfuscatedName("bf")
	@ObfuscatedGetter(
		intValue = -909355861
	)
	int field921;
	@ObfuscatedName("bi")
	@ObfuscatedGetter(
		intValue = -1912574851
	)
	int field965;
	@ObfuscatedName("br")
	@ObfuscatedGetter(
		intValue = 503419835
	)
	int field966;
	@ObfuscatedName("bt")
	@ObfuscatedGetter(
		intValue = 625634807
	)
	int field929;
	@ObfuscatedName("bp")
	@ObfuscatedGetter(
		intValue = -202999541
	)
	int field950;
	@ObfuscatedName("co")
	@ObfuscatedGetter(
		intValue = 1681195499
	)
	int field969;
	@ObfuscatedName("cp")
	@ObfuscatedGetter(
		intValue = 819823007
	)
	int field970;
	@ObfuscatedName("cd")
	@ObfuscatedGetter(
		intValue = 1293515615
	)
	@Export("npcCycle")
	int npcCycle;
	@ObfuscatedName("cj")
	@ObfuscatedGetter(
		intValue = -958995757
	)
	@Export("defaultHeight")
	int defaultHeight;
	@ObfuscatedName("cq")
	@ObfuscatedGetter(
		intValue = -839837513
	)
	@Export("orientation")
	int orientation;
	@ObfuscatedName("cb")
	@ObfuscatedGetter(
		intValue = -1474803963
	)
	int field974;
	@ObfuscatedName("cf")
	@ObfuscatedGetter(
		intValue = 1709100513
	)
	int field968;
	@ObfuscatedName("cs")
	@ObfuscatedGetter(
		intValue = 905332161
	)
	@Export("pathLength")
	int pathLength;
	@ObfuscatedName("ch")
	@Export("pathX")
	int[] pathX;
	@ObfuscatedName("ca")
	@Export("pathY")
	int[] pathY;
	@ObfuscatedName("cn")
	@Export("pathTraversed")
	byte[] pathTraversed;
	@ObfuscatedName("cx")
	@ObfuscatedGetter(
		intValue = 426432369
	)
	int field980;
	@ObfuscatedName("ck")
	@ObfuscatedGetter(
		intValue = -1929716187
	)
	int field926;

	Actor() {
		this.isWalking = false;
		this.field925 = 1;
		this.readySequence = -1;
		this.turnLeftSequence = -1;
		this.turnRightSequence = -1;
		this.walkSequence = -1;
		this.walkBackSequence = -1;
		this.walkLeftSequence = -1;
		this.walkRightSequence = -1;
		this.runSequence = -1;
		this.overheadText = null;
		this.field937 = false;
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
		this.field960 = -1;
		this.movementSequence = -1;
		this.movementFrame = 0;
		this.movementFrameCycle = 0;
		this.sequence = -1;
		this.sequenceFrame = 0;
		this.sequenceFrameCycle = 0;
		this.sequenceDelay = 0;
		this.field958 = 0;
		this.spotAnimation = -1;
		this.spotAnimationFrame = 0;
		this.spotAnimationFrameCycle = 0;
		this.npcCycle = 0;
		this.defaultHeight = 200;
		this.field974 = 0;
		this.field968 = 32;
		this.pathLength = 0;
		this.pathX = new int[10];
		this.pathY = new int[10];
		this.pathTraversed = new byte[10];
		this.field980 = 0;
		this.field926 = 0;
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(S)Z",
		garbageValue = "3163"
	)
	@Export("isVisible")
	boolean isVisible() {
		return false;
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-52"
	)
	final void method1742() {
		this.pathLength = 0;
		this.field926 = 0;
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		signature = "(IIIIIII)V",
		garbageValue = "2136221861"
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
			HitSplatDefinition var12 = MusicPatchNode.method3815(var1);
			var10 = var12.field3299;
			var11 = var12.field3298;
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

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		signature = "(IIIIIII)V",
		garbageValue = "1083208214"
	)
	@Export("addHealthBar")
	final void addHealthBar(int var1, int var2, int var3, int var4, int var5, int var6) {
		HealthBarDefinition var7 = class32.method548(var1);
		HealthBar var8 = null;
		HealthBar var9 = null;
		int var10 = var7.int2;
		int var11 = 0;

		HealthBar var12;
		for (var12 = (HealthBar)this.healthBars.last(); var12 != null; var12 = (HealthBar)this.healthBars.previous()) {
			++var11;
			if (var12.definition.field3249 == var7.field3249) {
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

	@ObfuscatedName("bj")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-982043878"
	)
	@Export("removeHealthBar")
	final void removeHealthBar(int var1) {
		HealthBarDefinition var2 = class32.method548(var1);

		for (HealthBar var3 = (HealthBar)this.healthBars.last(); var3 != null; var3 = (HealthBar)this.healthBars.previous()) {
			if (var2 == var3.definition) {
				var3.remove();
				return;
			}
		}

	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(S)V",
		garbageValue = "277"
	)
	public static void method1755() {
		GZipDecompressor.midiPcmStream.clear();
		class197.field2392 = 1;
		Coord.musicTrackArchive = null;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "540632011"
	)
	public static void method1756() {
		VarpDefinition.VarpDefinition_cached.clear();
	}

	@ObfuscatedName("ih")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "276036566"
	)
	@Export("addCancelMenuEntry")
	static void addCancelMenuEntry() {
		WorldMapData_1.method708();
		Client.menuActions[0] = "Cancel";
		Client.menuTargets[0] = "";
		Client.menuOpcodes[0] = 1006;
		Client.menuShiftClick[0] = false;
		Client.menuOptionsCount = 1;
	}
}
