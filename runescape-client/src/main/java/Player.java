import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bi")
@Implements("Player")
public final class Player extends Actor {
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Ljq;"
	)
	@Export("username")
	Username username;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lhr;"
	)
	@Export("appearance")
	PlayerAppearance appearance;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 1858482709
	)
	@Export("headIconPk")
	int headIconPk;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 1159540227
	)
	@Export("headIconPrayer")
	int headIconPrayer;
	@ObfuscatedName("p")
	@Export("actions")
	String[] actions;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -1877190243
	)
	@Export("combatLevel")
	int combatLevel;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 637335031
	)
	@Export("skillLevel")
	int skillLevel;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = -1771866445
	)
	@Export("tileHeight")
	int tileHeight;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -635760975
	)
	@Export("animationCycleStart")
	int animationCycleStart;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -417952037
	)
	@Export("animationCycleEnd")
	int animationCycleEnd;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -160406725
	)
	int field606;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = 259205349
	)
	@Export("tileHeight2")
	int tileHeight2;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = -115769627
	)
	int field608;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Ldh;"
	)
	@Export("model0")
	Model model0;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 1991225207
	)
	int field622;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -650011663
	)
	int field611;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 1516041903
	)
	int field612;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -1977928131
	)
	int field613;
	@ObfuscatedName("h")
	@Export("isUnanimated")
	boolean isUnanimated;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = 14620165
	)
	@Export("team")
	int team;
	@ObfuscatedName("f")
	@Export("isHidden")
	boolean isHidden;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = 574179385
	)
	@Export("plane")
	int plane;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -1078544769
	)
	@Export("index")
	int index;
	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "Ljm;"
	)
	@Export("isFriendTriBool")
	TriBool isFriendTriBool;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Ljm;"
	)
	@Export("isInClanChat")
	TriBool isInClanChat;
	@ObfuscatedName("ac")
	boolean field621;
	@ObfuscatedName("az")
	@ObfuscatedGetter(
		intValue = -1966699347
	)
	@Export("tileX")
	int tileX;
	@ObfuscatedName("aw")
	@ObfuscatedGetter(
		intValue = -150727859
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
		this.field621 = false;
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Lkl;B)V",
		garbageValue = "-16"
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
					int var8 = Occluder.ItemDefinition_get(var4[var5] - 512).team;
					if (var8 != 0) {
						this.team = var8;
					}
				}
			}
		}

		int[] var9 = new int[5];

		for (var6 = 0; var6 < 5; ++var6) {
			var7 = var1.readUnsignedByte();
			if (var7 < 0 || var7 >= PlayerAppearance.field2519[var6].length) {
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

		this.username = new Username(var1.readStringCp1252NullTerminated(), WorldMapSection1.loginType);
		this.clearIsFriend();
		this.clearIsInClanChat();
		if (this == class223.localPlayer) {
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

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-2145672884"
	)
	@Export("isFriend")
	boolean isFriend() {
		if (this.isFriendTriBool == TriBool.TriBool_unknown) {
			this.checkIsFriend();
		}

		return this.isFriendTriBool == TriBool.TriBool_true;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "77"
	)
	@Export("clearIsFriend")
	void clearIsFriend() {
		this.isFriendTriBool = TriBool.TriBool_unknown;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "79"
	)
	@Export("checkIsFriend")
	void checkIsFriend() {
		this.isFriendTriBool = Tiles.friendSystem.isFriendAndHasWorld(this.username) ? TriBool.TriBool_true : TriBool.TriBool_false;
	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-408684042"
	)
	@Export("isClanMember")
	boolean isClanMember() {
		if (this.isInClanChat == TriBool.TriBool_unknown) {
			this.updateIsInClanChat();
		}

		return this.isInClanChat == TriBool.TriBool_true;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-2050482015"
	)
	@Export("clearIsInClanChat")
	void clearIsInClanChat() {
		this.isInClanChat = TriBool.TriBool_unknown;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "108"
	)
	@Export("updateIsInClanChat")
	void updateIsInClanChat() {
		this.isInClanChat = Varps.clanChat != null && Varps.clanChat.contains(this.username) ? TriBool.TriBool_true : TriBool.TriBool_false;
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "20"
	)
	@Export("transformedSize")
	int transformedSize() {
		return this.appearance != null && this.appearance.npcTransformId != -1 ? PacketBufferNode.getNpcDefinition(this.appearance.npcTransformId).size : 1;
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(I)Ldh;",
		garbageValue = "-62237472"
	)
	@Export("getModel")
	protected final Model getModel() {
		if (this.appearance == null) {
			return null;
		} else {
			SequenceDefinition var1 = super.sequence != -1 && super.sequenceDelay == 0 ? GrandExchangeOfferUnitPriceComparator.SequenceDefinition_get(super.sequence) : null;
			SequenceDefinition var2 = super.movementSequence != -1 && !this.isUnanimated && (super.movementSequence != super.readySequence || var1 == null) ? GrandExchangeOfferUnitPriceComparator.SequenceDefinition_get(super.movementSequence) : null;
			Model var3 = this.appearance.getModel(var1, super.sequenceFrame, var2, super.movementFrame);
			if (var3 == null) {
				return null;
			} else {
				var3.calculateBoundsCylinder();
				super.defaultHeight = var3.height;
				Model var4;
				Model[] var5;
				if (!this.isUnanimated && super.spotAnimation != -1 && super.spotAnimationFrame != -1) {
					var4 = InterfaceParent.SpotAnimationDefinition_get(super.spotAnimation).getModel(super.spotAnimationFrame);
					if (var4 != null) {
						var4.offsetBy(0, -super.heightOffset, 0);
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
						var4.offsetBy(this.field606 * 4096 - super.x, this.tileHeight2 - this.tileHeight, this.field608 * 4096 - super.y);
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

						var4.offsetBy(super.x - this.field606 * 4096, this.tileHeight - this.tileHeight2, super.y - this.field608 * 4096);
					}
				}

				var3.isSingleTile = true;
				return var3;
			}
		}
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(IIBB)V",
		garbageValue = "37"
	)
	final void method1274(int var1, int var2, byte var3) {
		if (super.sequence != -1 && GrandExchangeOfferUnitPriceComparator.SequenceDefinition_get(super.sequence).field3510 == 1) {
			super.sequence = -1;
		}

		super.field957 = -1;
		if (var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
			if (super.pathX[0] >= 0 && super.pathX[0] < 104 && super.pathY[0] >= 0 && super.pathY[0] < 104) {
				if (var3 == 2) {
					class1.method14(this, var1, var2, (byte)2);
				}

				this.method1263(var1, var2, var3);
			} else {
				this.resetPath(var1, var2);
			}
		} else {
			this.resetPath(var1, var2);
		}

	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(IIB)V",
		garbageValue = "-23"
	)
	@Export("resetPath")
	void resetPath(int var1, int var2) {
		super.pathLength = 0;
		super.field988 = 0;
		super.field949 = 0;
		super.pathX[0] = var1;
		super.pathY[0] = var2;
		int var3 = this.transformedSize();
		super.x = var3 * 64 + super.pathX[0] * 128;
		super.y = var3 * 64 + super.pathY[0] * 128;
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(IIBI)V",
		garbageValue = "-1343044637"
	)
	final void method1263(int var1, int var2, byte var3) {
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

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(S)Z",
		garbageValue = "180"
	)
	@Export("isVisible")
	final boolean isVisible() {
		return this.appearance != null;
	}
}
