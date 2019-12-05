import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("bt")
@Implements("Actor")
public abstract class Actor extends Entity {
	@ObfuscatedName("el")
	@ObfuscatedSignature(
		signature = "Lku;"
	)
	@Export("spriteIds")
	static GraphicsDefaults spriteIds;
	@ObfuscatedName("mh")
	@ObfuscatedGetter(
		intValue = 1998357535
	)
	@Export("selectedSpellFlags")
	static int selectedSpellFlags;
	@ObfuscatedName("ai")
	@ObfuscatedGetter(
		intValue = 1951571129
	)
	@Export("x")
	int x;
	@ObfuscatedName("ag")
	@ObfuscatedGetter(
		intValue = -1702454117
	)
	@Export("y")
	int y;
	@ObfuscatedName("ao")
	@ObfuscatedGetter(
		intValue = -1278261801
	)
	@Export("rotation")
	int rotation;
	@ObfuscatedName("aw")
	@Export("isWalking")
	boolean isWalking;
	@ObfuscatedName("ak")
	@ObfuscatedGetter(
		intValue = 401053777
	)
	int field938;
	@ObfuscatedName("aa")
	@ObfuscatedGetter(
		intValue = 1537825747
	)
	@Export("playerCycle")
	int playerCycle;
	@ObfuscatedName("ab")
	@ObfuscatedGetter(
		intValue = 1548693687
	)
	@Export("readySequence")
	int readySequence;
	@ObfuscatedName("ar")
	@ObfuscatedGetter(
		intValue = 2043182385
	)
	@Export("turnLeftSequence")
	int turnLeftSequence;
	@ObfuscatedName("av")
	@ObfuscatedGetter(
		intValue = -1529323687
	)
	@Export("turnRightSequence")
	int turnRightSequence;
	@ObfuscatedName("aq")
	@ObfuscatedGetter(
		intValue = -1702834689
	)
	@Export("walkSequence")
	int walkSequence;
	@ObfuscatedName("ac")
	@ObfuscatedGetter(
		intValue = -1195328729
	)
	@Export("walkBackSequence")
	int walkBackSequence;
	@ObfuscatedName("az")
	@ObfuscatedGetter(
		intValue = -551716323
	)
	@Export("walkLeftSequence")
	int walkLeftSequence;
	@ObfuscatedName("at")
	@ObfuscatedGetter(
		intValue = -588172397
	)
	@Export("walkRightSequence")
	int walkRightSequence;
	@ObfuscatedName("ae")
	@ObfuscatedGetter(
		intValue = 1934964713
	)
	@Export("runSequence")
	int runSequence;
	@ObfuscatedName("aj")
	@Export("overheadText")
	String overheadText;
	@ObfuscatedName("ap")
	@Export("isAutoChatting")
	boolean isAutoChatting;
	@ObfuscatedName("an")
	boolean field950;
	@ObfuscatedName("al")
	@ObfuscatedGetter(
		intValue = -2071391287
	)
	@Export("overheadTextCyclesRemaining")
	int overheadTextCyclesRemaining;
	@ObfuscatedName("ay")
	@ObfuscatedGetter(
		intValue = -1854297981
	)
	@Export("overheadTextColor")
	int overheadTextColor;
	@ObfuscatedName("ax")
	@ObfuscatedGetter(
		intValue = -2046431957
	)
	@Export("overheadTextEffect")
	int overheadTextEffect;
	@ObfuscatedName("as")
	@Export("hitSplatCount")
	byte hitSplatCount;
	@ObfuscatedName("ah")
	@Export("hitSplatTypes")
	int[] hitSplatTypes;
	@ObfuscatedName("bi")
	@Export("hitSplatValues")
	int[] hitSplatValues;
	@ObfuscatedName("bo")
	@Export("hitSplatCycles")
	int[] hitSplatCycles;
	@ObfuscatedName("bx")
	@Export("hitSplatTypes2")
	int[] hitSplatTypes2;
	@ObfuscatedName("bu")
	@Export("hitSplatValues2")
	int[] hitSplatValues2;
	@ObfuscatedName("bd")
	@ObfuscatedSignature(
		signature = "Ljm;"
	)
	@Export("healthBars")
	IterableNodeDeque healthBars;
	@ObfuscatedName("bn")
	@ObfuscatedGetter(
		intValue = 2135432751
	)
	@Export("targetIndex")
	int targetIndex;
	@ObfuscatedName("bj")
	@Export("false0")
	boolean false0;
	@ObfuscatedName("bm")
	@ObfuscatedGetter(
		intValue = 1522685125
	)
	int field965;
	@ObfuscatedName("bq")
	@ObfuscatedGetter(
		intValue = -1971794141
	)
	@Export("movementSequence")
	int movementSequence;
	@ObfuscatedName("bf")
	@ObfuscatedGetter(
		intValue = -1163192511
	)
	@Export("movementFrame")
	int movementFrame;
	@ObfuscatedName("by")
	@ObfuscatedGetter(
		intValue = -705488337
	)
	@Export("movementFrameCycle")
	int movementFrameCycle;
	@ObfuscatedName("br")
	@ObfuscatedGetter(
		intValue = 980221
	)
	@Export("sequence")
	int sequence;
	@ObfuscatedName("ba")
	@ObfuscatedGetter(
		intValue = 1531052871
	)
	@Export("sequenceFrame")
	int sequenceFrame;
	@ObfuscatedName("bb")
	@ObfuscatedGetter(
		intValue = 2086339795
	)
	@Export("sequenceFrameCycle")
	int sequenceFrameCycle;
	@ObfuscatedName("bg")
	@ObfuscatedGetter(
		intValue = 863905413
	)
	@Export("sequenceDelay")
	int sequenceDelay;
	@ObfuscatedName("bw")
	@ObfuscatedGetter(
		intValue = -217068217
	)
	int field971;
	@ObfuscatedName("be")
	@ObfuscatedGetter(
		intValue = -1431332559
	)
	@Export("spotAnimation")
	int spotAnimation;
	@ObfuscatedName("bt")
	@ObfuscatedGetter(
		intValue = -446541561
	)
	@Export("spotAnimationFrame")
	int spotAnimationFrame;
	@ObfuscatedName("bl")
	@ObfuscatedGetter(
		intValue = -1428986091
	)
	@Export("spotAnimationFrameCycle")
	int spotAnimationFrameCycle;
	@ObfuscatedName("bp")
	@ObfuscatedGetter(
		intValue = 1351668501
	)
	int field975;
	@ObfuscatedName("bv")
	@ObfuscatedGetter(
		intValue = 639610433
	)
	int field996;
	@ObfuscatedName("bs")
	@ObfuscatedGetter(
		intValue = 817107681
	)
	int field946;
	@ObfuscatedName("bz")
	@ObfuscatedGetter(
		intValue = 810384445
	)
	int field978;
	@ObfuscatedName("bc")
	@ObfuscatedGetter(
		intValue = 40503997
	)
	int field979;
	@ObfuscatedName("bh")
	@ObfuscatedGetter(
		intValue = 1623463931
	)
	int field980;
	@ObfuscatedName("bk")
	@ObfuscatedGetter(
		intValue = -950690973
	)
	int field934;
	@ObfuscatedName("cm")
	@ObfuscatedGetter(
		intValue = 1712532071
	)
	int field982;
	@ObfuscatedName("cd")
	@ObfuscatedGetter(
		intValue = 1620214811
	)
	int field983;
	@ObfuscatedName("cv")
	@ObfuscatedGetter(
		intValue = 1481734065
	)
	@Export("npcCycle")
	int npcCycle;
	@ObfuscatedName("cl")
	@ObfuscatedGetter(
		intValue = 1455392247
	)
	@Export("defaultHeight")
	int defaultHeight;
	@ObfuscatedName("cg")
	@ObfuscatedGetter(
		intValue = -27617279
	)
	@Export("orientation")
	int orientation;
	@ObfuscatedName("ch")
	@ObfuscatedGetter(
		intValue = 1781093081
	)
	int field987;
	@ObfuscatedName("co")
	@ObfuscatedGetter(
		intValue = 860658493
	)
	int field988;
	@ObfuscatedName("cr")
	@ObfuscatedGetter(
		intValue = 469579589
	)
	@Export("pathLength")
	int pathLength;
	@ObfuscatedName("ck")
	@Export("pathX")
	int[] pathX;
	@ObfuscatedName("cb")
	@Export("pathY")
	int[] pathY;
	@ObfuscatedName("cy")
	@Export("pathTraversed")
	byte[] pathTraversed;
	@ObfuscatedName("cn")
	@ObfuscatedGetter(
		intValue = 1598784809
	)
	int field976;
	@ObfuscatedName("cj")
	@ObfuscatedGetter(
		intValue = 559009223
	)
	int field994;

	Actor() {
		this.isWalking = false;
		this.field938 = 1;
		this.readySequence = -1;
		this.turnLeftSequence = -1;
		this.turnRightSequence = -1;
		this.walkSequence = -1;
		this.walkBackSequence = -1;
		this.walkLeftSequence = -1;
		this.walkRightSequence = -1;
		this.runSequence = -1;
		this.overheadText = null;
		this.field950 = false;
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
		this.field965 = -1;
		this.movementSequence = -1;
		this.movementFrame = 0;
		this.movementFrameCycle = 0;
		this.sequence = -1;
		this.sequenceFrame = 0;
		this.sequenceFrameCycle = 0;
		this.sequenceDelay = 0;
		this.field971 = 0;
		this.spotAnimation = -1;
		this.spotAnimationFrame = 0;
		this.spotAnimationFrameCycle = 0;
		this.npcCycle = 0;
		this.defaultHeight = 200;
		this.field987 = 0;
		this.field988 = 32;
		this.pathLength = 0;
		this.pathX = new int[10];
		this.pathY = new int[10];
		this.pathTraversed = new byte[10];
		this.field976 = 0;
		this.field994 = 0;
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-968027489"
	)
	@Export("isVisible")
	boolean isVisible() {
		return false;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-2082426618"
	)
	final void method1759() {
		this.pathLength = 0;
		this.field994 = 0;
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		signature = "(IIIIIII)V",
		garbageValue = "-666824571"
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
			HitSplatDefinition var12 = class42.method811(var1);
			var10 = var12.field3347;
			var11 = var12.field3338;
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

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		signature = "(IIIIIII)V",
		garbageValue = "1706369606"
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
			if (var13.definition.field3294 == var8.field3294) {
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
		garbageValue = "-1031768324"
	)
	@Export("removeHealthBar")
	final void removeHealthBar(int var1) {
		HealthBarDefinition var2 = class42.method810(var1);

		for (HealthBar var3 = (HealthBar)this.healthBars.last(); var3 != null; var3 = (HealthBar)this.healthBars.previous()) {
			if (var2 == var3.definition) {
				var3.remove();
				return;
			}
		}

	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/CharSequence;I)J",
		garbageValue = "1807317311"
	)
	static long method1773(CharSequence var0) {
		long var1 = 0L;
		int var3 = var0.length();

		for (int var4 = 0; var4 < var3; ++var4) {
			var1 *= 37L;
			char var5 = var0.charAt(var4);
			if (var5 >= 'A' && var5 <= 'Z') {
				var1 += (long)(var5 + 1 - 65);
			} else if (var5 >= 'a' && var5 <= 'z') {
				var1 += (long)(var5 + 1 - 97);
			} else if (var5 >= '0' && var5 <= '9') {
				var1 += (long)(var5 + 27 - 48);
			}

			if (var1 >= 177917621779460413L) {
				break;
			}
		}

		while (0L == var1 % 37L && 0L != var1) {
			var1 /= 37L;
		}

		return var1;
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(ILci;ZB)I",
		garbageValue = "-13"
	)
	static int method1774(int var0, Script var1, boolean var2) {
		Widget var3;
		if (var0 >= 2000) {
			var0 -= 1000;
			var3 = Language.getWidget(Interpreter.Interpreter_intStack[--GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize]);
		} else {
			var3 = var2 ? Interpreter.field1090 : class188.field2352;
		}

		if (var0 == ScriptOpcodes.CC_CALLONRESIZE) {
			if (Interpreter.field1095 >= 10) {
				throw new RuntimeException();
			} else if (var3.onResize == null) {
				return 0;
			} else {
				ScriptEvent var4 = new ScriptEvent();
				var4.widget = var3;
				var4.args = var3.onResize;
				var4.field577 = Interpreter.field1095 + 1;
				Client.scriptEvents.addFirst(var4);
				return 1;
			}
		} else {
			return 2;
		}
	}

	@ObfuscatedName("hs")
	@ObfuscatedSignature(
		signature = "(IIIIIIIB)V",
		garbageValue = "-99"
	)
	@Export("addPendingSpawnToScene")
	static final void addPendingSpawnToScene(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
		if (var2 >= 1 && var3 >= 1 && var2 <= 102 && var3 <= 102) {
			if (Client.isLowDetail && var0 != ClientPacket.Client_plane) {
				return;
			}

			long var7 = 0L;
			boolean var9 = true;
			boolean var10 = false;
			boolean var11 = false;
			if (var1 == 0) {
				var7 = class2.scene.getBoundaryObjectTag(var0, var2, var3);
			}

			if (var1 == 1) {
				var7 = class2.scene.getWallDecorationTag(var0, var2, var3);
			}

			if (var1 == 2) {
				var7 = class2.scene.getGameObjectTag(var0, var2, var3);
			}

			if (var1 == 3) {
				var7 = class2.scene.getFloorDecorationTag(var0, var2, var3);
			}

			int var12;
			if (var7 != 0L) {
				var12 = class2.scene.getObjectFlags(var0, var2, var3, var7);
				int var14 = ItemContainer.Entity_unpackID(var7);
				int var15 = var12 & 31;
				int var16 = var12 >> 6 & 3;
				ObjectDefinition var13;
				if (var1 == 0) {
					class2.scene.removeBoundaryObject(var0, var2, var3);
					var13 = Occluder.getObjectDefinition(var14);
					if (var13.interactType != 0) {
						Client.collisionMaps[var0].method3598(var2, var3, var15, var16, var13.boolean1);
					}
				}

				if (var1 == 1) {
					class2.scene.removeWallDecoration(var0, var2, var3);
				}

				if (var1 == 2) {
					class2.scene.removeGameObject(var0, var2, var3);
					var13 = Occluder.getObjectDefinition(var14);
					if (var2 + var13.sizeX > 103 || var3 + var13.sizeX > 103 || var2 + var13.sizeY > 103 || var3 + var13.sizeY > 103) {
						return;
					}

					if (var13.interactType != 0) {
						Client.collisionMaps[var0].setFlagOffNonSquare(var2, var3, var13.sizeX, var13.sizeY, var16, var13.boolean1);
					}
				}

				if (var1 == 3) {
					class2.scene.removeFloorDecoration(var0, var2, var3);
					var13 = Occluder.getObjectDefinition(var14);
					if (var13.interactType == 1) {
						Client.collisionMaps[var0].method3601(var2, var3);
					}
				}
			}

			if (var4 >= 0) {
				var12 = var0;
				if (var0 < 3 && (Tiles.Tiles_renderFlags[1][var2][var3] & 2) == 2) {
					var12 = var0 + 1;
				}

				MenuAction.method2088(var0, var12, var2, var3, var4, var5, var6, class2.scene, Client.collisionMaps[var0]);
			}
		}

	}

	@ObfuscatedName("im")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "0"
	)
	@Export("Widget_runOnTargetLeave")
	static void Widget_runOnTargetLeave() {
		if (Client.isSpellSelected) {
			Widget var0 = UserComparator3.getWidgetChild(WorldMapAreaData.selectedSpellWidget, Client.selectedSpellChildIndex);
			if (var0 != null && var0.onTargetLeave != null) {
				ScriptEvent var1 = new ScriptEvent();
				var1.widget = var0;
				var1.args = var0.onTargetLeave;
				WorldMapLabel.runScriptEvent(var1);
			}

			Client.isSpellSelected = false;
			ScriptEvent.invalidateWidget(var0);
		}
	}

	@ObfuscatedName("jg")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "3"
	)
	static final void method1756() {
		PacketBufferNode var0 = ModelData0.getPacketBufferNode(ClientPacket.field2311, Client.packetWriter.isaacCipher);
		Client.packetWriter.addNode(var0);

		for (InterfaceParent var1 = (InterfaceParent)Client.interfaceParents.first(); var1 != null; var1 = (InterfaceParent)Client.interfaceParents.next()) {
			if (var1.type == 0 || var1.type == 3) {
				class43.closeInterface(var1, true);
			}
		}

		if (Client.meslayerContinueWidget != null) {
			ScriptEvent.invalidateWidget(Client.meslayerContinueWidget);
			Client.meslayerContinueWidget = null;
		}

	}
}
