import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bi")
@Implements("Player")
public final class Player extends Actor {
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lku;"
	)
	@Export("username")
	Username username;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Lhk;"
	)
	@Export("appearance")
	PlayerAppearance appearance;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -955452579
	)
	@Export("headIconPk")
	int headIconPk;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -1682761079
	)
	@Export("headIconPrayer")
	int headIconPrayer;
	@ObfuscatedName("v")
	@Export("actions")
	String[] actions;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -1517162387
	)
	@Export("combatLevel")
	int combatLevel;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 614146335
	)
	@Export("skillLevel")
	int skillLevel;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -550900363
	)
	@Export("tileHeight")
	int tileHeight;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 1364374011
	)
	@Export("animationCycleStart")
	int animationCycleStart;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = -1470813775
	)
	@Export("animationCycleEnd")
	int animationCycleEnd;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 168679087
	)
	int field662;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 620810729
	)
	@Export("tileHeight2")
	int tileHeight2;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -2027049547
	)
	int field657;
	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "Lel;"
	)
	@Export("model0")
	Model model0;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 1127396435
	)
	int field659;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 240208849
	)
	int field660;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = -2013432115
	)
	int field661;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -971151235
	)
	int field664;
	@ObfuscatedName("l")
	@Export("isUnanimated")
	boolean isUnanimated;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = -1431900799
	)
	@Export("team")
	int team;
	@ObfuscatedName("o")
	@Export("isHidden")
	boolean isHidden;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -777722891
	)
	@Export("plane")
	int plane;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -1532250791
	)
	@Export("index")
	int index;
	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "Lkv;"
	)
	@Export("isFriendTriBool")
	TriBool isFriendTriBool;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lkv;"
	)
	@Export("isInClanChat")
	TriBool isInClanChat;
	@ObfuscatedName("ae")
	boolean field670;
	@ObfuscatedName("ai")
	@ObfuscatedGetter(
		intValue = 1349885547
	)
	@Export("tileX")
	int tileX;
	@ObfuscatedName("ap")
	@ObfuscatedGetter(
		intValue = -1671422285
	)
	@Export("tileY")
	int tileY;

	Player() {
		this.headIconPk = -1;
		this.headIconPrayer = -1;
		this.actions = new String[3];

		for (int var1 = 0; var1 < 3; ++var1) {
			this.actions[var1] = "";
		}

		this.combatLevel = 0;
		this.skillLevel = 0;
		this.animationCycleStart = 0;
		this.animationCycleEnd = 0;
		this.isUnanimated = false;
		this.team = 0;
		this.isHidden = false;
		this.isFriendTriBool = TriBool.TriBool_unknown;
		this.isInClanChat = TriBool.TriBool_unknown;
		this.field670 = false;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Lkb;I)V",
		garbageValue = "-2042142749"
	)
	@Export("read")
	final void read(Buffer var1) {
		var1.offset = 0;
		int var2 = var1.readUnsignedByte();
		this.headIconPk = var1.readByte();
		this.headIconPrayer = var1.readByte();
		int var3 = -1;
		this.team = 0;
		int[] var4 = new int[12];

		int var6;
		int var7;
		for (int var5 = 0; var5 < 12; ++var5) {
			var6 = var1.readUnsignedByte();
			if (var6 == 0) {
				var4[var5] = 0;
			} else {
				var7 = var1.readUnsignedByte();
				var4[var5] = var7 + (var6 << 8);
				if (var5 == 0 && var4[0] == 65535) {
					var3 = var1.readUnsignedShort();
					break;
				}

				if (var4[var5] >= 512) {
					int var8 = AbstractWorldMapData.ItemDefinition_get(var4[var5] - 512).team;
					if (var8 != 0) {
						this.team = var8;
					}
				}
			}
		}

		int[] var9 = new int[5];

		for (var6 = 0; var6 < 5; ++var6) {
			var7 = var1.readUnsignedByte();
			if (var7 < 0 || var7 >= VertexNormal.field1764[var6].length) {
				var7 = 0;
			}

			var9[var6] = var7;
		}

		super.readySequence = var1.readUnsignedShort();
		if (super.readySequence == 65535) {
			super.readySequence = -1;
		}

		super.turnLeftSequence = var1.readUnsignedShort();
		if (super.turnLeftSequence == 65535) {
			super.turnLeftSequence = -1;
		}

		super.turnRightSequence = super.turnLeftSequence;
		super.walkSequence = var1.readUnsignedShort();
		if (super.walkSequence == 65535) {
			super.walkSequence = -1;
		}

		super.walkBackSequence = var1.readUnsignedShort();
		if (super.walkBackSequence == 65535) {
			super.walkBackSequence = -1;
		}

		super.walkLeftSequence = var1.readUnsignedShort();
		if (super.walkLeftSequence == 65535) {
			super.walkLeftSequence = -1;
		}

		super.walkRightSequence = var1.readUnsignedShort();
		if (super.walkRightSequence == 65535) {
			super.walkRightSequence = -1;
		}

		super.runSequence = var1.readUnsignedShort();
		if (super.runSequence == 65535) {
			super.runSequence = -1;
		}

		this.username = new Username(var1.readStringCp1252NullTerminated(), WorldMapIcon_0.loginType);
		this.clearIsFriend();
		this.clearIsInClanChat();
		if (this == ByteArrayPool.localPlayer) {
			RunException.localPlayerName = this.username.getName();
		}

		this.combatLevel = var1.readUnsignedByte();
		this.skillLevel = var1.readUnsignedShort();
		this.isHidden = var1.readUnsignedByte() == 1;
		if (Client.gameBuild == 0 && Client.staffModLevel >= 2) {
			this.isHidden = false;
		}

		if (this.appearance == null) {
			this.appearance = new PlayerAppearance();
		}

		this.appearance.update(var4, var9, var2 == 1, var3);
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "990067508"
	)
	@Export("isFriend")
	boolean isFriend() {
		if (this.isFriendTriBool == TriBool.TriBool_unknown) {
			this.checkIsFriend();
		}

		return this.isFriendTriBool == TriBool.TriBool_true;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "77261851"
	)
	@Export("clearIsFriend")
	void clearIsFriend() {
		this.isFriendTriBool = TriBool.TriBool_unknown;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1863320246"
	)
	@Export("checkIsFriend")
	void checkIsFriend() {
		this.isFriendTriBool = Projectile.friendSystem.isFriendAndHasWorld(this.username) ? TriBool.TriBool_true : TriBool.TriBool_false;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "1535464163"
	)
	@Export("isClanMember")
	boolean isClanMember() {
		if (this.isInClanChat == TriBool.TriBool_unknown) {
			this.updateIsInClanChat();
		}

		return this.isInClanChat == TriBool.TriBool_true;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "81"
	)
	@Export("clearIsInClanChat")
	void clearIsInClanChat() {
		this.isInClanChat = TriBool.TriBool_unknown;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "101"
	)
	@Export("updateIsInClanChat")
	void updateIsInClanChat() {
		this.isInClanChat = InterfaceParent.clanChat != null && InterfaceParent.clanChat.contains(this.username) ? TriBool.TriBool_true : TriBool.TriBool_false;
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "52"
	)
	@Export("transformedSize")
	int transformedSize() {
		return this.appearance != null && this.appearance.npcTransformId != -1 ? class237.getNpcDefinition(this.appearance.npcTransformId).size : 1;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I)Lel;",
		garbageValue = "480835067"
	)
	@Export("getModel")
	protected final Model getModel() {
		if (this.appearance == null) {
			return null;
		} else {
			SequenceDefinition var1 = super.sequence != -1 && super.sequenceDelay == 0 ? SpotAnimationDefinition.SequenceDefinition_get(super.sequence) : null;
			SequenceDefinition var2 = super.movementSequence == -1 || this.isUnanimated || super.readySequence == super.movementSequence && var1 != null ? null : SpotAnimationDefinition.SequenceDefinition_get(super.movementSequence);
			Model var3 = this.appearance.getModel(var1, super.sequenceFrame, var2, super.movementFrame);
			if (var3 == null) {
				return null;
			} else {
				var3.calculateBoundsCylinder();
				super.defaultHeight = var3.height;
				Model var4;
				Model[] var5;
				if (!this.isUnanimated && super.spotAnimation != -1 && super.spotAnimationFrame != -1) {
					var4 = MouseHandler.SpotAnimationDefinition_get(super.spotAnimation).getModel(super.spotAnimationFrame);
					if (var4 != null) {
						var4.offsetBy(0, -super.field1033, 0);
						var5 = new Model[]{var3, var4};
						var3 = new Model(var5, 2);
					}
				}

				if (!this.isUnanimated && this.model0 != null) {
					if (Client.cycle >= this.animationCycleEnd) {
						this.model0 = null;
					}

					if (Client.cycle >= this.animationCycleStart && Client.cycle < this.animationCycleEnd) {
						var4 = this.model0;
						var4.offsetBy(this.field662 - super.x, this.tileHeight2 - this.tileHeight, this.field657 - super.y);
						if (super.orientation == 512) {
							var4.rotateY90Ccw();
							var4.rotateY90Ccw();
							var4.rotateY90Ccw();
						} else if (super.orientation == 1024) {
							var4.rotateY90Ccw();
							var4.rotateY90Ccw();
						} else if (super.orientation == 1536) {
							var4.rotateY90Ccw();
						}

						var5 = new Model[]{var3, var4};
						var3 = new Model(var5, 2);
						if (super.orientation == 512) {
							var4.rotateY90Ccw();
						} else if (super.orientation == 1024) {
							var4.rotateY90Ccw();
							var4.rotateY90Ccw();
						} else if (super.orientation == 1536) {
							var4.rotateY90Ccw();
							var4.rotateY90Ccw();
							var4.rotateY90Ccw();
						}

						var4.offsetBy(super.x - this.field662, this.tileHeight - this.tileHeight2, super.y - this.field657);
					}
				}

				var3.isSingleTile = true;
				return var3;
			}
		}
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(IIBI)V",
		garbageValue = "-618087503"
	)
	final void method1339(int var1, int var2, byte var3) {
		if (super.sequence != -1 && SpotAnimationDefinition.SequenceDefinition_get(super.sequence).field3524 == 1) {
			super.sequence = -1;
		}

		super.field1015 = -1;
		if (var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
			if (super.pathX[0] >= 0 && super.pathX[0] < 104 && super.pathY[0] >= 0 && super.pathY[0] < 104) {
				if (var3 == 2) {
					SoundCache.method2609(this, var1, var2, (byte)2);
				}

				this.method1341(var1, var2, var3);
			} else {
				this.resetPath(var1, var2);
			}
		} else {
			this.resetPath(var1, var2);
		}

	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "-2118599552"
	)
	@Export("resetPath")
	void resetPath(int var1, int var2) {
		super.pathLength = 0;
		super.field1032 = 0;
		super.field1031 = 0;
		super.pathX[0] = var1;
		super.pathY[0] = var2;
		int var3 = this.transformedSize();
		super.x = super.pathX[0] * 128 + var3 * 64;
		super.y = super.pathY[0] * 128 + var3 * 64;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(IIBI)V",
		garbageValue = "1447911882"
	)
	final void method1341(int var1, int var2, byte var3) {
		if (super.pathLength < 9) {
			++super.pathLength;
		}

		for (int var4 = super.pathLength; var4 > 0; --var4) {
			super.pathX[var4] = super.pathX[var4 - 1];
			super.pathY[var4] = super.pathY[var4 - 1];
			super.pathTraversed[var4] = super.pathTraversed[var4 - 1];
		}

		super.pathX[0] = var1;
		super.pathY[0] = var2;
		super.pathTraversed[0] = var3;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "116176402"
	)
	@Export("isVisible")
	final boolean isVisible() {
		return this.appearance != null;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "556074954"
	)
	static int method1342() {
		return ++Messages.Messages_count - 1;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(IZIZI)V",
		garbageValue = "1788243043"
	)
	@Export("sortWorldList")
	static void sortWorldList(int var0, boolean var1, int var2, boolean var3) {
		if (UserComparator2.World_worlds != null) {
			ModelData0.doWorldSorting(0, UserComparator2.World_worlds.length - 1, var0, var1, var2, var3);
		}

	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-389992863"
	)
	static void method1383() {
		Players.Players_count = 0;

		for (int var0 = 0; var0 < 2048; ++var0) {
			Players.field1269[var0] = null;
			Players.field1273[var0] = 1;
		}

	}

	@ObfuscatedName("fg")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-357843101"
	)
	@Export("forceDisconnect")
	static final void forceDisconnect(int var0) {
		Huffman.logOut();
		switch(var0) {
		case 1:
			ReflectionCheck.method2396();
			break;
		case 2:
			Login.loginIndex = 24;
			HealthBarUpdate.setLoginResponseString("The game servers are currently being updated.", "Please wait a few minutes and try again.", "");
		}

	}

	@ObfuscatedName("ju")
	@ObfuscatedSignature(
		signature = "(Lhe;IIB)V",
		garbageValue = "2"
	)
	@Export("clickWidget")
	static final void clickWidget(Widget var0, int var1, int var2) {
		if (Client.clickedWidget == null && !Client.isMenuOpen) {
			if (var0 != null && KitDefinition.method4538(var0) != null) {
				Client.clickedWidget = var0;
				Client.clickedWidgetParent = KitDefinition.method4538(var0);
				Client.widgetClickX = var1;
				Client.widgetClickY = var2;
				MilliClock.widgetDragDuration = 0;
				Client.isDraggingWidget = false;
				int var3 = AbstractWorldMapData.method381();
				if (var3 != -1) {
					AbstractWorldMapIcon.tempMenuAction = new MenuAction();
					AbstractWorldMapIcon.tempMenuAction.param0 = Client.menuArguments1[var3];
					AbstractWorldMapIcon.tempMenuAction.param1 = Client.menuArguments2[var3];
					AbstractWorldMapIcon.tempMenuAction.opcode = Client.menuOpcodes[var3];
					AbstractWorldMapIcon.tempMenuAction.identifier = Client.menuIdentifiers[var3];
					AbstractWorldMapIcon.tempMenuAction.action = Client.menuActions[var3];
				}

			}
		}
	}
}
