import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bj")
@Implements("Player")
public final class Player extends Actor {
	@ObfuscatedName("jh")
	@ObfuscatedGetter(
		intValue = 302709599
	)
	@Export("Client_plane")
	static int Client_plane;
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "Lju;"
	)
	@Export("username")
	Username username;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lhe;"
	)
	@Export("appearance")
	PlayerAppearance appearance;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -1452773485
	)
	@Export("headIconPk")
	int headIconPk;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 543277395
	)
	@Export("headIconPrayer")
	int headIconPrayer;
	@ObfuscatedName("l")
	@Export("actions")
	String[] actions;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -1482937775
	)
	@Export("combatLevel")
	int combatLevel;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = -1894325429
	)
	@Export("skillLevel")
	int skillLevel;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -910871753
	)
	@Export("tileHeight")
	int tileHeight;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -1047722297
	)
	@Export("animationCycleStart")
	int animationCycleStart;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -1520700303
	)
	@Export("animationCycleEnd")
	int animationCycleEnd;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -1427757385
	)
	int field620;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = 1927324771
	)
	@Export("tileHeight2")
	int tileHeight2;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 1667324247
	)
	int field613;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Ldv;"
	)
	@Export("model0")
	Model model0;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -259291277
	)
	int field595;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = -1041408825
	)
	int field611;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 1183898211
	)
	int field612;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = 1592139531
	)
	int field604;
	@ObfuscatedName("b")
	@Export("isUnanimated")
	boolean isUnanimated;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -118673171
	)
	@Export("team")
	int team;
	@ObfuscatedName("f")
	@Export("isHidden")
	boolean isHidden;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -1409701989
	)
	@Export("plane")
	int plane;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -1262555149
	)
	@Export("index")
	int index;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Ljs;"
	)
	@Export("isFriendTriBool")
	TriBool isFriendTriBool;
	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "Ljs;"
	)
	@Export("isInClanChat")
	TriBool isInClanChat;
	@ObfuscatedName("aa")
	boolean field606;
	@ObfuscatedName("aw")
	@ObfuscatedGetter(
		intValue = -655940439
	)
	@Export("tileX")
	int tileX;
	@ObfuscatedName("ar")
	@ObfuscatedGetter(
		intValue = 2119390623
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
		this.field606 = false;
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(Lkc;B)V",
		garbageValue = "-1"
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
					int var8 = class222.ItemDefinition_get(var4[var5] - 512).team;
					if (var8 != 0) {
						this.team = var8;
					}
				}
			}
		}

		int[] var9 = new int[5];

		for (var6 = 0; var6 < 5; ++var6) {
			var7 = var1.readUnsignedByte();
			if (var7 < 0 || var7 >= PlayerAppearance.field2520[var6].length) {
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

		this.username = new Username(var1.readStringCp1252NullTerminated(), class60.loginType);
		this.clearIsFriend();
		this.clearIsInClanChat();
		if (this == class215.localPlayer) {
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

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(S)Z",
		garbageValue = "-6206"
	)
	@Export("isFriend")
	boolean isFriend() {
		if (this.isFriendTriBool == TriBool.TriBool_unknown) {
			this.checkIsFriend();
		}

		return this.isFriendTriBool == TriBool.TriBool_true;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "68"
	)
	@Export("clearIsFriend")
	void clearIsFriend() {
		this.isFriendTriBool = TriBool.TriBool_unknown;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-51176527"
	)
	@Export("checkIsFriend")
	void checkIsFriend() {
		this.isFriendTriBool = PacketWriter.friendSystem.isFriendAndHasWorld(this.username) ? TriBool.TriBool_true : TriBool.TriBool_false;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-184998769"
	)
	@Export("isClanMember")
	boolean isClanMember() {
		if (this.isInClanChat == TriBool.TriBool_unknown) {
			this.updateIsInClanChat();
		}

		return this.isInClanChat == TriBool.TriBool_true;
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1691080178"
	)
	@Export("clearIsInClanChat")
	void clearIsInClanChat() {
		this.isInClanChat = TriBool.TriBool_unknown;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(S)V",
		garbageValue = "1126"
	)
	@Export("updateIsInClanChat")
	void updateIsInClanChat() {
		this.isInClanChat = class4.clanChat != null && class4.clanChat.contains(this.username) ? TriBool.TriBool_true : TriBool.TriBool_false;
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(S)I",
		garbageValue = "11776"
	)
	@Export("transformedSize")
	int transformedSize() {
		return this.appearance != null && this.appearance.npcTransformId != -1 ? SecureRandomCallable.getNpcDefinition(this.appearance.npcTransformId).size : 1;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(B)Ldv;",
		garbageValue = "-40"
	)
	@Export("getModel")
	protected final Model getModel() {
		if (this.appearance == null) {
			return null;
		} else {
			SequenceDefinition var1 = super.sequence != -1 && super.sequenceDelay == 0 ? PlayerType.SequenceDefinition_get(super.sequence) : null;
			SequenceDefinition var2 = super.movementSequence == -1 || this.isUnanimated || super.movementSequence == super.readySequence && var1 != null ? null : PlayerType.SequenceDefinition_get(super.movementSequence);
			Model var3 = this.appearance.getModel(var1, super.sequenceFrame, var2, super.movementFrame);
			if (var3 == null) {
				return null;
			} else {
				var3.calculateBoundsCylinder();
				super.defaultHeight = var3.height;
				Model var4;
				Model[] var5;
				if (!this.isUnanimated && super.spotAnimation != -1 && super.spotAnimationFrame != -1) {
					var4 = MenuAction.SpotAnimationDefinition_get(super.spotAnimation).getModel(super.spotAnimationFrame);
					if (var4 != null) {
						var4.offsetBy(0, -super.field965, 0);
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
						var4.offsetBy(this.field620 * 4096 - super.x, this.tileHeight2 - this.tileHeight, this.field613 * 4096 - super.y);
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

						var4.offsetBy(super.x - this.field620 * 4096, this.tileHeight - this.tileHeight2, super.y - this.field613 * 4096);
					}
				}

				var3.isSingleTile = true;
				return var3;
			}
		}
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(IIBI)V",
		garbageValue = "-1935410968"
	)
	final void method1334(int var1, int var2, byte var3) {
		if (super.sequence != -1 && PlayerType.SequenceDefinition_get(super.sequence).field3513 == 1) {
			super.sequence = -1;
		}

		super.field934 = -1;
		if (var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
			if (super.pathX[0] >= 0 && super.pathX[0] < 104 && super.pathY[0] >= 0 && super.pathY[0] < 104) {
				if (var3 == 2) {
					Player var4 = this;
					int var5 = super.pathX[0];
					int var6 = super.pathY[0];
					int var7 = this.transformedSize();
					if (var5 >= var7 && var5 < 104 - var7 && var6 >= var7 && var6 < 104 - var7 && var1 >= var7 && var1 < 104 - var7 && var2 >= var7 && var2 < 104 - var7) {
						int var8 = Message.method1311(var5, var6, this.transformedSize(), WorldMapCacheName.method685(var1, var2), Client.collisionMaps[this.Client_plane], true, Client.field890, Client.field906);
						if (var8 >= 1) {
							for (int var9 = 0; var9 < var8 - 1; ++var9) {
								var4.method1352(Client.field890[var9], Client.field906[var9], (byte)2);
							}
						}
					}
				}

				this.method1352(var1, var2, var3);
			} else {
				this.resetPath(var1, var2);
			}
		} else {
			this.resetPath(var1, var2);
		}

	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "1427222618"
	)
	@Export("resetPath")
	void resetPath(int var1, int var2) {
		super.pathLength = 0;
		super.field983 = 0;
		super.field982 = 0;
		super.pathX[0] = var1;
		super.pathY[0] = var2;
		int var3 = this.transformedSize();
		super.x = super.pathX[0] * 128 + var3 * 64;
		super.y = super.pathY[0] * 128 + var3 * 64;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(IIBI)V",
		garbageValue = "-2040004615"
	)
	final void method1352(int var1, int var2, byte var3) {
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

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "-25"
	)
	@Export("isVisible")
	final boolean isVisible() {
		return this.appearance != null;
	}

	@ObfuscatedName("gi")
	@ObfuscatedSignature(
		signature = "(Lbj;ZI)V",
		garbageValue = "1425328760"
	)
	@Export("addPlayerToScene")
	static void addPlayerToScene(Player var0, boolean var1) {
		if (var0 != null && var0.isVisible() && !var0.isHidden) {
			var0.isUnanimated = false;
			if ((Client.isLowDetail && Players.Players_count > 50 || Players.Players_count > 200) && var1 && var0.readySequence == var0.movementSequence) {
				var0.isUnanimated = true;
			}

			int var2 = var0.x >> 7;
			int var3 = var0.y >> 7;
			if (var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
				long var4 = class160.calculateTag(0, 0, 0, false, var0.index);
				if (var0.model0 != null && Client.cycle >= var0.animationCycleStart && Client.cycle < var0.animationCycleEnd) {
					var0.isUnanimated = false;
					var0.tileHeight = GraphicsObject.getTileHeight(var0.x, var0.y, Client_plane);
					var0.playerCycle = Client.cycle;
					WorldMapArea.scene.addNullableObject(Client_plane, var0.x, var0.y, var0.tileHeight, 60, var0, var0.rotation, var4, var0.field595, var0.field611, var0.field612, var0.field604);
				} else {
					if ((var0.x & 127) == 64 && (var0.y & 127) == 64) {
						if (Client.tileLastDrawnActor[var2][var3] == Client.viewportDrawCount) {
							return;
						}

						Client.tileLastDrawnActor[var2][var3] = Client.viewportDrawCount;
					}

					var0.tileHeight = GraphicsObject.getTileHeight(var0.x, var0.y, Client_plane);
					var0.playerCycle = Client.cycle;
					WorldMapArea.scene.drawEntity(Client_plane, var0.x, var0.y, var0.tileHeight, 60, var0, var0.rotation, var4, var0.isWalking);
				}
			}
		}

	}
}
