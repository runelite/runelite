import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bg")
@Implements("Player")
public final class Player extends Actor {
	@ObfuscatedName("fp")
	@ObfuscatedSignature(
		signature = "Lky;"
	)
	@Export("fontPlain12")
	static Font fontPlain12;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Ljb;"
	)
	@Export("username")
	Username username;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lhd;"
	)
	@Export("appearance")
	PlayerAppearance appearance;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = 668256771
	)
	@Export("headIconPk")
	int headIconPk;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 334440827
	)
	@Export("headIconPrayer")
	int headIconPrayer;
	@ObfuscatedName("p")
	@Export("actions")
	String[] actions;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = 274943013
	)
	@Export("combatLevel")
	int combatLevel;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = 1410660801
	)
	@Export("skillLevel")
	int skillLevel;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -1809943585
	)
	@Export("tileHeight")
	int tileHeight;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 59496057
	)
	@Export("animationCycleStart")
	int animationCycleStart;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -1958828963
	)
	@Export("animationCycleEnd")
	int animationCycleEnd;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -97527251
	)
	int field623;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = 452166125
	)
	@Export("tileHeight2")
	int tileHeight2;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -1739722177
	)
	int field617;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Ldf;"
	)
	@Export("model0")
	Model model0;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = -2105768533
	)
	int field618;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -845670421
	)
	int field620;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = -460372187
	)
	int field621;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 73836445
	)
	int field622;
	@ObfuscatedName("s")
	@Export("isUnanimated")
	boolean isUnanimated;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -1020180477
	)
	@Export("team")
	int team;
	@ObfuscatedName("m")
	@Export("isHidden")
	boolean isHidden;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -1146584027
	)
	@Export("plane")
	int plane;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 37577883
	)
	@Export("index")
	int index;
	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "Lja;"
	)
	@Export("isFriendTriBool")
	TriBool isFriendTriBool;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Lja;"
	)
	@Export("isInClanChat")
	TriBool isInClanChat;
	@ObfuscatedName("af")
	boolean field630;
	@ObfuscatedName("ad")
	@ObfuscatedGetter(
		intValue = -1213220739
	)
	@Export("tileX")
	int tileX;
	@ObfuscatedName("am")
	@ObfuscatedGetter(
		intValue = -516890813
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
		this.field630 = false;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Lkg;I)V",
		garbageValue = "-1611293437"
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
					int var8 = Interpreter.ItemDefinition_get(var4[var5] - 512).team;
					if (var8 != 0) {
						this.team = var8;
					}
				}
			}
		}

		int[] var9 = new int[5];

		for (var6 = 0; var6 < 5; ++var6) {
			var7 = var1.readUnsignedByte();
			if (var7 < 0 || var7 >= ArchiveLoader.field533[var6].length) {
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

		this.username = new Username(var1.readStringCp1252NullTerminated(), WorldMapLabelSize.loginType);
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

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "57"
	)
	@Export("isFriend")
	boolean isFriend() {
		if (this.isFriendTriBool == TriBool.TriBool_unknown) {
			this.checkIsFriend();
		}

		return this.isFriendTriBool == TriBool.TriBool_true;
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "1"
	)
	@Export("clearIsFriend")
	void clearIsFriend() {
		this.isFriendTriBool = TriBool.TriBool_unknown;
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1426797155"
	)
	@Export("checkIsFriend")
	void checkIsFriend() {
		this.isFriendTriBool = VertexNormal.friendSystem.isFriendAndHasWorld(this.username) ? TriBool.TriBool_true : TriBool.TriBool_false;
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "1498117074"
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
		garbageValue = "-1542877638"
	)
	@Export("clearIsInClanChat")
	void clearIsInClanChat() {
		this.isInClanChat = TriBool.TriBool_unknown;
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "14697600"
	)
	@Export("updateIsInClanChat")
	void updateIsInClanChat() {
		this.isInClanChat = InterfaceParent.clanChat != null && InterfaceParent.clanChat.contains(this.username) ? TriBool.TriBool_true : TriBool.TriBool_false;
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "86"
	)
	@Export("transformedSize")
	int transformedSize() {
		return this.appearance != null && this.appearance.npcTransformId != -1 ? VarcInt.getNpcDefinition(this.appearance.npcTransformId).size : 1;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(I)Ldf;",
		garbageValue = "-174129419"
	)
	@Export("getModel")
	protected final Model getModel() {
		if (this.appearance == null) {
			return null;
		} else {
			SequenceDefinition var1 = super.sequence != -1 && super.sequenceDelay == 0 ? GrandExchangeOfferAgeComparator.SequenceDefinition_get(super.sequence) : null;
			SequenceDefinition var2 = super.movementSequence == -1 || this.isUnanimated || super.readySequence == super.movementSequence && var1 != null ? null : GrandExchangeOfferAgeComparator.SequenceDefinition_get(super.movementSequence);
			Model var3 = this.appearance.getModel(var1, super.sequenceFrame, var2, super.movementFrame);
			if (var3 == null) {
				return null;
			} else {
				var3.calculateBoundsCylinder();
				super.defaultHeight = var3.height;
				Model var4;
				Model[] var5;
				if (!this.isUnanimated && super.spotAnimation != -1 && super.spotAnimationFrame != -1) {
					var4 = WorldMapRegion.SpotAnimationDefinition_get(super.spotAnimation).getModel(super.spotAnimationFrame);
					if (var4 != null) {
						var4.offsetBy(0, -super.field996, 0);
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
						var4.offsetBy(this.field623 * 4096 - super.x, this.tileHeight2 - this.tileHeight, this.field617 * 4096 - super.y);
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

						var4.offsetBy(super.x - this.field623 * 4096, this.tileHeight - this.tileHeight2, super.y - this.field617 * 4096);
					}
				}

				var3.isSingleTile = true;
				return var3;
			}
		}
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(IIBI)V",
		garbageValue = "968915391"
	)
	final void method1255(int var1, int var2, byte var3) {
		if (super.sequence != -1 && GrandExchangeOfferAgeComparator.SequenceDefinition_get(super.sequence).field3515 == 1) {
			super.sequence = -1;
		}

		super.field965 = -1;
		if (var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
			if (super.pathX[0] >= 0 && super.pathX[0] < 104 && super.pathY[0] >= 0 && super.pathY[0] < 104) {
				if (var3 == 2) {
					Player var4 = this;
					int var5 = super.pathX[0];
					int var6 = super.pathY[0];
					int var7 = this.transformedSize();
					if (var5 >= var7 && var5 < 104 - var7 && var6 >= var7 && var6 < 104 - var7 && var1 >= var7 && var1 < 104 - var7 && var2 >= var7 && var2 < 104 - var7) {
						int var8 = ParamDefinition.method4612(var5, var6, this.transformedSize(), WorldMapIcon_1.method321(var1, var2), Client.collisionMaps[this.plane], true, Client.field916, Client.field862);
						if (var8 >= 1) {
							for (int var9 = 0; var9 < var8 - 1; ++var9) {
								var4.method1250(Client.field916[var9], Client.field862[var9], (byte)2);
							}
						}
					}
				}

				this.method1250(var1, var2, var3);
			} else {
				this.resetPath(var1, var2);
			}
		} else {
			this.resetPath(var1, var2);
		}

	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "1311656261"
	)
	@Export("resetPath")
	void resetPath(int var1, int var2) {
		super.pathLength = 0;
		super.field994 = 0;
		super.field976 = 0;
		super.pathX[0] = var1;
		super.pathY[0] = var2;
		int var3 = this.transformedSize();
		super.x = var3 * 64 + super.pathX[0] * 128;
		super.y = super.pathY[0] * 128 + var3 * 64;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(IIBI)V",
		garbageValue = "2140265482"
	)
	final void method1250(int var1, int var2, byte var3) {
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
		signature = "(I)Z",
		garbageValue = "-968027489"
	)
	@Export("isVisible")
	final boolean isVisible() {
		return this.appearance != null;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Lhf;Lhf;I)V",
		garbageValue = "2087560410"
	)
	public static void method1285(AbstractArchive var0, AbstractArchive var1) {
		HealthBarDefinition.HealthBarDefinition_archive = var0;
		HealthBarDefinition.HitSplatDefinition_spritesArchive = var1;
	}
}
