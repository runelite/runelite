import java.applet.Applet;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("bd")
@Implements("Player")
public final class Player extends Actor {
	@ObfuscatedName("rm")
	@ObfuscatedGetter(
		intValue = -1071324325
	)
	static int field605;
	@ObfuscatedName("gk")
	@ObfuscatedSignature(
		signature = "Lea;"
	)
	@Export("scene")
	static Scene scene;
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "Ljx;"
	)
	@Export("username")
	Username username;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Lhy;"
	)
	@Export("appearance")
	PlayerAppearance appearance;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 1192279175
	)
	@Export("headIconPk")
	int headIconPk;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 467804137
	)
	@Export("headIconPrayer")
	int headIconPrayer;
	@ObfuscatedName("n")
	@Export("actions")
	String[] actions;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 1678004971
	)
	@Export("combatLevel")
	int combatLevel;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -111404567
	)
	@Export("skillLevel")
	int skillLevel;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 339695519
	)
	@Export("tileHeight")
	int tileHeight;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 1030156263
	)
	@Export("animationCycleStart")
	int animationCycleStart;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = 1574000409
	)
	@Export("animationCycleEnd")
	int animationCycleEnd;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 1214691187
	)
	int field599;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = -880216621
	)
	@Export("tileHeight2")
	int tileHeight2;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = -1144569719
	)
	int field601;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Ldo;"
	)
	@Export("model0")
	Model model0;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = 368063167
	)
	int field603;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 163934537
	)
	int field604;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -548421503
	)
	int field616;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -1361539533
	)
	int field606;
	@ObfuscatedName("a")
	@Export("isUnanimated")
	boolean isUnanimated;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -670761469
	)
	@Export("team")
	int team;
	@ObfuscatedName("l")
	@Export("isHidden")
	boolean isHidden;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = -58712163
	)
	@Export("plane")
	int plane;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 722380261
	)
	@Export("index")
	int index;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Ljj;"
	)
	@Export("isFriendTriBool")
	TriBool isFriendTriBool;
	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "Ljj;"
	)
	@Export("isInClanChat")
	TriBool isInClanChat;
	@ObfuscatedName("av")
	boolean field614;
	@ObfuscatedName("am")
	@ObfuscatedGetter(
		intValue = 147350869
	)
	@Export("tileX")
	int tileX;
	@ObfuscatedName("ai")
	@ObfuscatedGetter(
		intValue = 1655455797
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
		this.field614 = false;
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(Lky;B)V",
		garbageValue = "15"
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
					int var8 = WorldMapData_0.ItemDefinition_get(var4[var5] - 512).team;
					if (var8 != 0) {
						this.team = var8;
					}
				}
			}
		}

		int[] var9 = new int[5];

		for (var6 = 0; var6 < 5; ++var6) {
			var7 = var1.readUnsignedByte();
			if (var7 < 0 || var7 >= FontName.field3651[var6].length) {
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

		this.username = new Username(var1.readStringCp1252NullTerminated(), FontName.loginType);
		this.clearIsFriend();
		this.clearIsInClanChat();
		if (this == WorldMapIcon_1.localPlayer) {
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

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "-83"
	)
	@Export("isFriend")
	boolean isFriend() {
		if (this.isFriendTriBool == TriBool.TriBool_unknown) {
			this.checkIsFriend();
		}

		return this.isFriendTriBool == TriBool.TriBool_true;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1921612164"
	)
	@Export("clearIsFriend")
	void clearIsFriend() {
		this.isFriendTriBool = TriBool.TriBool_unknown;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1245343177"
	)
	@Export("checkIsFriend")
	void checkIsFriend() {
		this.isFriendTriBool = class32.friendSystem.isFriendAndHasWorld(this.username) ? TriBool.TriBool_true : TriBool.TriBool_false;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "91374353"
	)
	@Export("isClanMember")
	boolean isClanMember() {
		if (this.isInClanChat == TriBool.TriBool_unknown) {
			this.updateIsInClanChat();
		}

		return this.isInClanChat == TriBool.TriBool_true;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1756216558"
	)
	@Export("clearIsInClanChat")
	void clearIsInClanChat() {
		this.isInClanChat = TriBool.TriBool_unknown;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "923060512"
	)
	@Export("updateIsInClanChat")
	void updateIsInClanChat() {
		this.isInClanChat = Client.clanChat != null && Client.clanChat.contains(this.username) ? TriBool.TriBool_true : TriBool.TriBool_false;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "910894704"
	)
	@Export("transformedSize")
	int transformedSize() {
		return this.appearance != null && this.appearance.npcTransformId != -1 ? ViewportMouse.getNpcDefinition(this.appearance.npcTransformId).size : 1;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)Ldo;",
		garbageValue = "-419920513"
	)
	@Export("getModel")
	protected final Model getModel() {
		if (this.appearance == null) {
			return null;
		} else {
			SequenceDefinition var1 = super.sequence != -1 && super.sequenceDelay == 0 ? Widget.SequenceDefinition_get(super.sequence) : null;
			SequenceDefinition var2 = super.movementSequence != -1 && !this.isUnanimated && (super.readySequence != super.movementSequence || var1 == null) ? Widget.SequenceDefinition_get(super.movementSequence) : null;
			Model var3 = this.appearance.getModel(var1, super.sequenceFrame, var2, super.movementFrame);
			if (var3 == null) {
				return null;
			} else {
				var3.calculateBoundsCylinder();
				super.defaultHeight = var3.height;
				Model var4;
				Model[] var5;
				if (!this.isUnanimated && super.spotAnimation != -1 && super.spotAnimationFrame != -1) {
					var4 = HealthBarUpdate.SpotAnimationDefinition_get(super.spotAnimation).getModel(super.spotAnimationFrame);
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
						var4.offsetBy(this.field599 * 4096 - super.x, this.tileHeight2 - this.tileHeight, this.field601 * 4096 - super.y);
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

						var4.offsetBy(super.x - this.field599 * 4096, this.tileHeight - this.tileHeight2, super.y - this.field601 * 4096);
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
		garbageValue = "-77453000"
	)
	final void method1190(int var1, int var2, byte var3) {
		if (super.sequence != -1 && Widget.SequenceDefinition_get(super.sequence).field3505 == 1) {
			super.sequence = -1;
		}

		super.field946 = -1;
		if (var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
			if (super.pathX[0] >= 0 && super.pathX[0] < 104 && super.pathY[0] >= 0 && super.pathY[0] < 104) {
				if (var3 == 2) {
					Player var4 = this;
					int var5 = super.pathX[0];
					int var6 = super.pathY[0];
					int var7 = this.transformedSize();
					if (var5 >= var7 && var5 < 104 - var7 && var6 >= var7 && var6 < 104 - var7 && var1 >= var7 && var1 < 104 - var7 && var2 >= var7 && var2 < 104 - var7) {
						int var9 = this.transformedSize();
						RouteStrategy var10 = class30.method536(var1, var2);
						CollisionMap var11 = Client.collisionMaps[this.plane];
						int[] var12 = Client.field697;
						int[] var13 = Client.field898;
						int var14 = 0;

						label970:
						while (true) {
							int var15;
							if (var14 >= 128) {
								int var16;
								int var17;
								byte var18;
								byte var19;
								int var20;
								int var21;
								byte var22;
								int var23;
								int[][] var24;
								int var25;
								int var26;
								int var27;
								int var28;
								boolean var34;
								boolean var35;
								int var36;
								int var37;
								int var39;
								if (var9 == 1) {
									var16 = var5;
									var17 = var6;
									var18 = 64;
									var19 = 64;
									var20 = var5 - var18;
									var21 = var6 - var19;
									class173.directions[var18][var19] = 99;
									class173.distances[var18][var19] = 0;
									var22 = 0;
									var23 = 0;
									class173.bufferX[var22] = var5;
									var39 = var22 + 1;
									class173.bufferY[var22] = var6;
									var24 = var11.flags;

									while (true) {
										if (var39 == var23) {
											class173.field2073 = var16;
											class173.field2070 = var17;
											var35 = false;
											break;
										}

										var16 = class173.bufferX[var23];
										var17 = class173.bufferY[var23];
										var23 = var23 + 1 & 4095;
										var36 = var16 - var20;
										var37 = var17 - var21;
										var25 = var16 - var11.xInset;
										var26 = var17 - var11.yInset;
										if (var10.hasArrived(1, var16, var17, var11)) {
											class173.field2073 = var16;
											class173.field2070 = var17;
											var35 = true;
											break;
										}

										var27 = class173.distances[var36][var37] + 1;
										if (var36 > 0 && class173.directions[var36 - 1][var37] == 0 && (var24[var25 - 1][var26] & 19136776) == 0) {
											class173.bufferX[var39] = var16 - 1;
											class173.bufferY[var39] = var17;
											var39 = var39 + 1 & 4095;
											class173.directions[var36 - 1][var37] = 2;
											class173.distances[var36 - 1][var37] = var27;
										}

										if (var36 < 127 && class173.directions[var36 + 1][var37] == 0 && (var24[var25 + 1][var26] & 19136896) == 0) {
											class173.bufferX[var39] = var16 + 1;
											class173.bufferY[var39] = var17;
											var39 = var39 + 1 & 4095;
											class173.directions[var36 + 1][var37] = 8;
											class173.distances[var36 + 1][var37] = var27;
										}

										if (var37 > 0 && class173.directions[var36][var37 - 1] == 0 && (var24[var25][var26 - 1] & 19136770) == 0) {
											class173.bufferX[var39] = var16;
											class173.bufferY[var39] = var17 - 1;
											var39 = var39 + 1 & 4095;
											class173.directions[var36][var37 - 1] = 1;
											class173.distances[var36][var37 - 1] = var27;
										}

										if (var37 < 127 && class173.directions[var36][var37 + 1] == 0 && (var24[var25][var26 + 1] & 19136800) == 0) {
											class173.bufferX[var39] = var16;
											class173.bufferY[var39] = var17 + 1;
											var39 = var39 + 1 & 4095;
											class173.directions[var36][var37 + 1] = 4;
											class173.distances[var36][var37 + 1] = var27;
										}

										if (var36 > 0 && var37 > 0 && class173.directions[var36 - 1][var37 - 1] == 0 && (var24[var25 - 1][var26 - 1] & 19136782) == 0 && (var24[var25 - 1][var26] & 19136776) == 0 && (var24[var25][var26 - 1] & 19136770) == 0) {
											class173.bufferX[var39] = var16 - 1;
											class173.bufferY[var39] = var17 - 1;
											var39 = var39 + 1 & 4095;
											class173.directions[var36 - 1][var37 - 1] = 3;
											class173.distances[var36 - 1][var37 - 1] = var27;
										}

										if (var36 < 127 && var37 > 0 && class173.directions[var36 + 1][var37 - 1] == 0 && (var24[var25 + 1][var26 - 1] & 19136899) == 0 && (var24[var25 + 1][var26] & 19136896) == 0 && (var24[var25][var26 - 1] & 19136770) == 0) {
											class173.bufferX[var39] = var16 + 1;
											class173.bufferY[var39] = var17 - 1;
											var39 = var39 + 1 & 4095;
											class173.directions[var36 + 1][var37 - 1] = 9;
											class173.distances[var36 + 1][var37 - 1] = var27;
										}

										if (var36 > 0 && var37 < 127 && class173.directions[var36 - 1][var37 + 1] == 0 && (var24[var25 - 1][var26 + 1] & 19136824) == 0 && (var24[var25 - 1][var26] & 19136776) == 0 && (var24[var25][var26 + 1] & 19136800) == 0) {
											class173.bufferX[var39] = var16 - 1;
											class173.bufferY[var39] = var17 + 1;
											var39 = var39 + 1 & 4095;
											class173.directions[var36 - 1][var37 + 1] = 6;
											class173.distances[var36 - 1][var37 + 1] = var27;
										}

										if (var36 < 127 && var37 < 127 && class173.directions[var36 + 1][var37 + 1] == 0 && (var24[var25 + 1][var26 + 1] & 19136992) == 0 && (var24[var25 + 1][var26] & 19136896) == 0 && (var24[var25][var26 + 1] & 19136800) == 0) {
											class173.bufferX[var39] = var16 + 1;
											class173.bufferY[var39] = var17 + 1;
											var39 = var39 + 1 & 4095;
											class173.directions[var36 + 1][var37 + 1] = 12;
											class173.distances[var36 + 1][var37 + 1] = var27;
										}
									}

									var34 = var35;
								} else if (var9 == 2) {
									var16 = var5;
									var17 = var6;
									var18 = 64;
									var19 = 64;
									var20 = var5 - var18;
									var21 = var6 - var19;
									class173.directions[var18][var19] = 99;
									class173.distances[var18][var19] = 0;
									var22 = 0;
									var23 = 0;
									class173.bufferX[var22] = var5;
									var39 = var22 + 1;
									class173.bufferY[var22] = var6;
									var24 = var11.flags;

									while (true) {
										if (var39 == var23) {
											class173.field2073 = var16;
											class173.field2070 = var17;
											var35 = false;
											break;
										}

										var16 = class173.bufferX[var23];
										var17 = class173.bufferY[var23];
										var23 = var23 + 1 & 4095;
										var36 = var16 - var20;
										var37 = var17 - var21;
										var25 = var16 - var11.xInset;
										var26 = var17 - var11.yInset;
										if (var10.hasArrived(2, var16, var17, var11)) {
											class173.field2073 = var16;
											class173.field2070 = var17;
											var35 = true;
											break;
										}

										var27 = class173.distances[var36][var37] + 1;
										if (var36 > 0 && class173.directions[var36 - 1][var37] == 0 && (var24[var25 - 1][var26] & 19136782) == 0 && (var24[var25 - 1][var26 + 1] & 19136824) == 0) {
											class173.bufferX[var39] = var16 - 1;
											class173.bufferY[var39] = var17;
											var39 = var39 + 1 & 4095;
											class173.directions[var36 - 1][var37] = 2;
											class173.distances[var36 - 1][var37] = var27;
										}

										if (var36 < 126 && class173.directions[var36 + 1][var37] == 0 && (var24[var25 + 2][var26] & 19136899) == 0 && (var24[var25 + 2][var26 + 1] & 19136992) == 0) {
											class173.bufferX[var39] = var16 + 1;
											class173.bufferY[var39] = var17;
											var39 = var39 + 1 & 4095;
											class173.directions[var36 + 1][var37] = 8;
											class173.distances[var36 + 1][var37] = var27;
										}

										if (var37 > 0 && class173.directions[var36][var37 - 1] == 0 && (var24[var25][var26 - 1] & 19136782) == 0 && (var24[var25 + 1][var26 - 1] & 19136899) == 0) {
											class173.bufferX[var39] = var16;
											class173.bufferY[var39] = var17 - 1;
											var39 = var39 + 1 & 4095;
											class173.directions[var36][var37 - 1] = 1;
											class173.distances[var36][var37 - 1] = var27;
										}

										if (var37 < 126 && class173.directions[var36][var37 + 1] == 0 && (var24[var25][var26 + 2] & 19136824) == 0 && (var24[var25 + 1][var26 + 2] & 19136992) == 0) {
											class173.bufferX[var39] = var16;
											class173.bufferY[var39] = var17 + 1;
											var39 = var39 + 1 & 4095;
											class173.directions[var36][var37 + 1] = 4;
											class173.distances[var36][var37 + 1] = var27;
										}

										if (var36 > 0 && var37 > 0 && class173.directions[var36 - 1][var37 - 1] == 0 && (var24[var25 - 1][var26] & 19136830) == 0 && (var24[var25 - 1][var26 - 1] & 19136782) == 0 && (var24[var25][var26 - 1] & 19136911) == 0) {
											class173.bufferX[var39] = var16 - 1;
											class173.bufferY[var39] = var17 - 1;
											var39 = var39 + 1 & 4095;
											class173.directions[var36 - 1][var37 - 1] = 3;
											class173.distances[var36 - 1][var37 - 1] = var27;
										}

										if (var36 < 126 && var37 > 0 && class173.directions[var36 + 1][var37 - 1] == 0 && (var24[var25 + 1][var26 - 1] & 19136911) == 0 && (var24[var25 + 2][var26 - 1] & 19136899) == 0 && (var24[var25 + 2][var26] & 19136995) == 0) {
											class173.bufferX[var39] = var16 + 1;
											class173.bufferY[var39] = var17 - 1;
											var39 = var39 + 1 & 4095;
											class173.directions[var36 + 1][var37 - 1] = 9;
											class173.distances[var36 + 1][var37 - 1] = var27;
										}

										if (var36 > 0 && var37 < 126 && class173.directions[var36 - 1][var37 + 1] == 0 && (var24[var25 - 1][var26 + 1] & 19136830) == 0 && (var24[var25 - 1][var26 + 2] & 19136824) == 0 && (var24[var25][var26 + 2] & 19137016) == 0) {
											class173.bufferX[var39] = var16 - 1;
											class173.bufferY[var39] = var17 + 1;
											var39 = var39 + 1 & 4095;
											class173.directions[var36 - 1][var37 + 1] = 6;
											class173.distances[var36 - 1][var37 + 1] = var27;
										}

										if (var36 < 126 && var37 < 126 && class173.directions[var36 + 1][var37 + 1] == 0 && (var24[var25 + 1][var26 + 2] & 19137016) == 0 && (var24[var25 + 2][var26 + 2] & 19136992) == 0 && (var24[var25 + 2][var26 + 1] & 19136995) == 0) {
											class173.bufferX[var39] = var16 + 1;
											class173.bufferY[var39] = var17 + 1;
											var39 = var39 + 1 & 4095;
											class173.directions[var36 + 1][var37 + 1] = 12;
											class173.distances[var36 + 1][var37 + 1] = var27;
										}
									}

									var34 = var35;
								} else {
									var16 = var5;
									var17 = var6;
									var18 = 64;
									var19 = 64;
									var20 = var5 - var18;
									var21 = var6 - var19;
									class173.directions[var18][var19] = 99;
									class173.distances[var18][var19] = 0;
									var22 = 0;
									var23 = 0;
									class173.bufferX[var22] = var5;
									var39 = var22 + 1;
									class173.bufferY[var22] = var6;
									var24 = var11.flags;

									label940:
									while (true) {
										label938:
										while (true) {
											do {
												do {
													do {
														label915:
														do {
															if (var39 == var23) {
																class173.field2073 = var16;
																class173.field2070 = var17;
																var35 = false;
																break label940;
															}

															var16 = class173.bufferX[var23];
															var17 = class173.bufferY[var23];
															var23 = var23 + 1 & 4095;
															var36 = var16 - var20;
															var37 = var17 - var21;
															var25 = var16 - var11.xInset;
															var26 = var17 - var11.yInset;
															if (var10.hasArrived(var9, var16, var17, var11)) {
																class173.field2073 = var16;
																class173.field2070 = var17;
																var35 = true;
																break label940;
															}

															var27 = class173.distances[var36][var37] + 1;
															if (var36 > 0 && class173.directions[var36 - 1][var37] == 0 && (var24[var25 - 1][var26] & 19136782) == 0 && (var24[var25 - 1][var9 + var26 - 1] & 19136824) == 0) {
																var28 = 1;

																while (true) {
																	if (var28 >= var9 - 1) {
																		class173.bufferX[var39] = var16 - 1;
																		class173.bufferY[var39] = var17;
																		var39 = var39 + 1 & 4095;
																		class173.directions[var36 - 1][var37] = 2;
																		class173.distances[var36 - 1][var37] = var27;
																		break;
																	}

																	if ((var24[var25 - 1][var26 + var28] & 19136830) != 0) {
																		break;
																	}

																	++var28;
																}
															}

															if (var36 < 128 - var9 && class173.directions[var36 + 1][var37] == 0 && (var24[var9 + var25][var26] & 19136899) == 0 && (var24[var9 + var25][var9 + var26 - 1] & 19136992) == 0) {
																var28 = 1;

																while (true) {
																	if (var28 >= var9 - 1) {
																		class173.bufferX[var39] = var16 + 1;
																		class173.bufferY[var39] = var17;
																		var39 = var39 + 1 & 4095;
																		class173.directions[var36 + 1][var37] = 8;
																		class173.distances[var36 + 1][var37] = var27;
																		break;
																	}

																	if ((var24[var9 + var25][var28 + var26] & 19136995) != 0) {
																		break;
																	}

																	++var28;
																}
															}

															if (var37 > 0 && class173.directions[var36][var37 - 1] == 0 && (var24[var25][var26 - 1] & 19136782) == 0 && (var24[var25 + var9 - 1][var26 - 1] & 19136899) == 0) {
																var28 = 1;

																while (true) {
																	if (var28 >= var9 - 1) {
																		class173.bufferX[var39] = var16;
																		class173.bufferY[var39] = var17 - 1;
																		var39 = var39 + 1 & 4095;
																		class173.directions[var36][var37 - 1] = 1;
																		class173.distances[var36][var37 - 1] = var27;
																		break;
																	}

																	if ((var24[var25 + var28][var26 - 1] & 19136911) != 0) {
																		break;
																	}

																	++var28;
																}
															}

															if (var37 < 128 - var9 && class173.directions[var36][var37 + 1] == 0 && (var24[var25][var9 + var26] & 19136824) == 0 && (var24[var25 + var9 - 1][var9 + var26] & 19136992) == 0) {
																var28 = 1;

																while (true) {
																	if (var28 >= var9 - 1) {
																		class173.bufferX[var39] = var16;
																		class173.bufferY[var39] = var17 + 1;
																		var39 = var39 + 1 & 4095;
																		class173.directions[var36][var37 + 1] = 4;
																		class173.distances[var36][var37 + 1] = var27;
																		break;
																	}

																	if ((var24[var28 + var25][var9 + var26] & 19137016) != 0) {
																		break;
																	}

																	++var28;
																}
															}

															if (var36 > 0 && var37 > 0 && class173.directions[var36 - 1][var37 - 1] == 0 && (var24[var25 - 1][var26 - 1] & 19136782) == 0) {
																var28 = 1;

																while (true) {
																	if (var28 >= var9) {
																		class173.bufferX[var39] = var16 - 1;
																		class173.bufferY[var39] = var17 - 1;
																		var39 = var39 + 1 & 4095;
																		class173.directions[var36 - 1][var37 - 1] = 3;
																		class173.distances[var36 - 1][var37 - 1] = var27;
																		break;
																	}

																	if ((var24[var25 - 1][var28 + (var26 - 1)] & 19136830) != 0 || (var24[var28 + (var25 - 1)][var26 - 1] & 19136911) != 0) {
																		break;
																	}

																	++var28;
																}
															}

															if (var36 < 128 - var9 && var37 > 0 && class173.directions[var36 + 1][var37 - 1] == 0 && (var24[var25 + var9][var26 - 1] & 19136899) == 0) {
																var28 = 1;

																while (true) {
																	if (var28 >= var9) {
																		class173.bufferX[var39] = var16 + 1;
																		class173.bufferY[var39] = var17 - 1;
																		var39 = var39 + 1 & 4095;
																		class173.directions[var36 + 1][var37 - 1] = 9;
																		class173.distances[var36 + 1][var37 - 1] = var27;
																		break;
																	}

																	if ((var24[var9 + var25][var28 + (var26 - 1)] & 19136995) != 0 || (var24[var25 + var28][var26 - 1] & 19136911) != 0) {
																		break;
																	}

																	++var28;
																}
															}

															if (var36 > 0 && var37 < 128 - var9 && class173.directions[var36 - 1][var37 + 1] == 0 && (var24[var25 - 1][var26 + var9] & 19136824) == 0) {
																for (var28 = 1; var28 < var9; ++var28) {
																	if ((var24[var25 - 1][var28 + var26] & 19136830) != 0 || (var24[var28 + (var25 - 1)][var26 + var9] & 19137016) != 0) {
																		continue label915;
																	}
																}

																class173.bufferX[var39] = var16 - 1;
																class173.bufferY[var39] = var17 + 1;
																var39 = var39 + 1 & 4095;
																class173.directions[var36 - 1][var37 + 1] = 6;
																class173.distances[var36 - 1][var37 + 1] = var27;
															}
														} while(var36 >= 128 - var9);
													} while(var37 >= 128 - var9);
												} while(class173.directions[var36 + 1][var37 + 1] != 0);
											} while((var24[var9 + var25][var9 + var26] & 19136992) != 0);

											for (var28 = 1; var28 < var9; ++var28) {
												if ((var24[var25 + var28][var26 + var9] & 19137016) != 0 || (var24[var25 + var9][var26 + var28] & 19136995) != 0) {
													continue label938;
												}
											}

											class173.bufferX[var39] = var16 + 1;
											class173.bufferY[var39] = var17 + 1;
											var39 = var39 + 1 & 4095;
											class173.directions[var36 + 1][var37 + 1] = 12;
											class173.distances[var36 + 1][var37 + 1] = var27;
										}
									}

									var34 = var35;
								}

								int var8;
								label1013: {
									var15 = var5 - 64;
									var16 = var6 - 64;
									var17 = class173.field2073;
									var36 = class173.field2070;
									if (!var34) {
										var37 = Integer.MAX_VALUE;
										var20 = Integer.MAX_VALUE;
										byte var38 = 10;
										var39 = var10.approxDestinationX;
										var23 = var10.approxDestinationY;
										int var33 = var10.approxDestinationSizeX;
										var25 = var10.approxDestinationSizeY;

										for (var26 = var39 - var38; var26 <= var39 + var38; ++var26) {
											for (var27 = var23 - var38; var27 <= var38 + var23; ++var27) {
												var28 = var26 - var15;
												int var29 = var27 - var16;
												if (var28 >= 0 && var29 >= 0 && var28 < 128 && var29 < 128 && class173.distances[var28][var29] < 100) {
													int var30 = 0;
													if (var26 < var39) {
														var30 = var39 - var26;
													} else if (var26 > var33 + var39 - 1) {
														var30 = var26 - (var39 + var33 - 1);
													}

													int var31 = 0;
													if (var27 < var23) {
														var31 = var23 - var27;
													} else if (var27 > var23 + var25 - 1) {
														var31 = var27 - (var25 + var23 - 1);
													}

													int var32 = var30 * var30 + var31 * var31;
													if (var32 < var37 || var32 == var37 && class173.distances[var28][var29] < var20) {
														var37 = var32;
														var20 = class173.distances[var28][var29];
														var17 = var26;
														var36 = var27;
													}
												}
											}
										}

										if (var37 == Integer.MAX_VALUE) {
											var8 = -1;
											break label1013;
										}
									}

									if (var17 == var5 && var36 == var6) {
										var8 = 0;
									} else {
										var19 = 0;
										class173.bufferX[var19] = var17;
										var37 = var19 + 1;
										class173.bufferY[var19] = var36;

										for (var20 = var21 = class173.directions[var17 - var15][var36 - var16]; var5 != var17 || var6 != var36; var20 = class173.directions[var17 - var15][var36 - var16]) {
											if (var21 != var20) {
												var21 = var20;
												class173.bufferX[var37] = var17;
												class173.bufferY[var37++] = var36;
											}

											if ((var20 & 2) != 0) {
												++var17;
											} else if ((var20 & 8) != 0) {
												--var17;
											}

											if ((var20 & 1) != 0) {
												++var36;
											} else if ((var20 & 4) != 0) {
												--var36;
											}
										}

										var39 = 0;

										while (var37-- > 0) {
											var12[var39] = class173.bufferX[var37];
											var13[var39++] = class173.bufferY[var37];
											if (var39 >= var12.length) {
												break;
											}
										}

										var8 = var39;
									}
								}

								var14 = var8;
								if (var8 < 1) {
									break;
								}

								var15 = 0;

								while (true) {
									if (var15 >= var14 - 1) {
										break label970;
									}

									var4.method1195(Client.field697[var15], Client.field898[var15], (byte)2);
									++var15;
								}
							}

							for (var15 = 0; var15 < 128; ++var15) {
								class173.directions[var14][var15] = 0;
								class173.distances[var14][var15] = 99999999;
							}

							++var14;
						}
					}
				}

				this.method1195(var1, var2, var3);
			} else {
				this.resetPath(var1, var2);
			}
		} else {
			this.resetPath(var1, var2);
		}

	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "-1849067298"
	)
	@Export("resetPath")
	void resetPath(int var1, int var2) {
		super.pathLength = 0;
		super.field947 = 0;
		super.field976 = 0;
		super.pathX[0] = var1;
		super.pathY[0] = var2;
		int var3 = this.transformedSize();
		super.x = super.pathX[0] * 128 + var3 * 64;
		super.y = super.pathY[0] * 128 + var3 * 64;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(IIBB)V",
		garbageValue = "1"
	)
	final void method1195(int var1, int var2, byte var3) {
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

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "-110"
	)
	@Export("isVisible")
	final boolean isVisible() {
		return this.appearance != null;
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(Ljava/applet/Applet;Ljava/lang/String;I)V",
		garbageValue = "-1361577662"
	)
	public static void method1223(Applet var0, String var1) {
		class51.applet = var0;
		if (var1 != null) {
			class51.field404 = var1;
		}

	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "([BS)V",
		garbageValue = "-23424"
	)
	@Export("SpriteBuffer_decode")
	static void SpriteBuffer_decode(byte[] var0) {
		Buffer var1 = new Buffer(var0);
		var1.offset = var0.length - 2;
		class325.SpriteBuffer_spriteCount = var1.readUnsignedShort();
		class325.SpriteBuffer_xOffsets = new int[class325.SpriteBuffer_spriteCount];
		class325.SpriteBuffer_yOffsets = new int[class325.SpriteBuffer_spriteCount];
		class325.SpriteBuffer_spriteWidths = new int[class325.SpriteBuffer_spriteCount];
		class225.SpriteBuffer_spriteHeights = new int[class325.SpriteBuffer_spriteCount];
		WorldMapSection1.SpriteBuffer_pixels = new byte[class325.SpriteBuffer_spriteCount][];
		var1.offset = var0.length - 7 - class325.SpriteBuffer_spriteCount * 8;
		GrandExchangeOfferUnitPriceComparator.SpriteBuffer_spriteWidth = var1.readUnsignedShort();
		class325.SpriteBuffer_spriteHeight = var1.readUnsignedShort();
		int var2 = (var1.readUnsignedByte() & 255) + 1;

		int var3;
		for (var3 = 0; var3 < class325.SpriteBuffer_spriteCount; ++var3) {
			class325.SpriteBuffer_xOffsets[var3] = var1.readUnsignedShort();
		}

		for (var3 = 0; var3 < class325.SpriteBuffer_spriteCount; ++var3) {
			class325.SpriteBuffer_yOffsets[var3] = var1.readUnsignedShort();
		}

		for (var3 = 0; var3 < class325.SpriteBuffer_spriteCount; ++var3) {
			class325.SpriteBuffer_spriteWidths[var3] = var1.readUnsignedShort();
		}

		for (var3 = 0; var3 < class325.SpriteBuffer_spriteCount; ++var3) {
			class225.SpriteBuffer_spriteHeights[var3] = var1.readUnsignedShort();
		}

		var1.offset = var0.length - 7 - class325.SpriteBuffer_spriteCount * 8 - (var2 - 1) * 3;
		class325.SpriteBuffer_spritePalette = new int[var2];

		for (var3 = 1; var3 < var2; ++var3) {
			class325.SpriteBuffer_spritePalette[var3] = var1.readMedium();
			if (class325.SpriteBuffer_spritePalette[var3] == 0) {
				class325.SpriteBuffer_spritePalette[var3] = 1;
			}
		}

		var1.offset = 0;

		for (var3 = 0; var3 < class325.SpriteBuffer_spriteCount; ++var3) {
			int var4 = class325.SpriteBuffer_spriteWidths[var3];
			int var5 = class225.SpriteBuffer_spriteHeights[var3];
			int var6 = var5 * var4;
			byte[] var7 = new byte[var6];
			WorldMapSection1.SpriteBuffer_pixels[var3] = var7;
			int var8 = var1.readUnsignedByte();
			int var9;
			if (var8 == 0) {
				for (var9 = 0; var9 < var6; ++var9) {
					var7[var9] = var1.readByte();
				}
			} else if (var8 == 1) {
				for (var9 = 0; var9 < var4; ++var9) {
					for (int var10 = 0; var10 < var5; ++var10) {
						var7[var9 + var10 * var4] = var1.readByte();
					}
				}
			}
		}

	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		signature = "([BB)[B",
		garbageValue = "-68"
	)
	@Export("decompressBytes")
	static final byte[] decompressBytes(byte[] var0) {
		Buffer var1 = new Buffer(var0);
		int var2 = var1.readUnsignedByte();
		int var3 = var1.readInt();
		if (var3 < 0 || AbstractArchive.field3120 != 0 && var3 > AbstractArchive.field3120) {
			throw new RuntimeException();
		} else if (var2 == 0) {
			byte[] var4 = new byte[var3];
			var1.readBytes(var4, 0, var3);
			return var4;
		} else {
			int var6 = var1.readInt();
			if (var6 >= 0 && (AbstractArchive.field3120 == 0 || var6 <= AbstractArchive.field3120)) {
				byte[] var5 = new byte[var6];
				if (var2 == 1) {
					BZip2Decompressor.BZip2Decompressor_decompress(var5, var6, var0, var3, 9);
				} else {
					AbstractArchive.gzipDecompressor.decompress(var1, var5);
				}

				return var5;
			} else {
				throw new RuntimeException();
			}
		}
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		signature = "(ILcr;ZI)I",
		garbageValue = "-1511089704"
	)
	static int method1224(int var0, Script var1, boolean var2) {
		if (var0 == ScriptOpcodes.GETWINDOWMODE) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = UserComparator7.getWindowedMode();
			return 1;
		} else {
			int var3;
			if (var0 == ScriptOpcodes.SETWINDOWMODE) {
				var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				if (var3 == 1 || var3 == 2) {
					StudioGame.setWindowedMode(var3);
				}

				return 1;
			} else if (var0 == ScriptOpcodes.GETDEFAULTWINDOWMODE) {
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = GrandExchangeOffer.clientPreferences.windowMode;
				return 1;
			} else if (var0 != ScriptOpcodes.SETDEFAULTWINDOWMODE) {
				if (var0 == 5310) {
					--Interpreter.Interpreter_intStackSize;
					return 1;
				} else {
					return 2;
				}
			} else {
				var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				if (var3 == 1 || var3 == 2) {
					GrandExchangeOffer.clientPreferences.windowMode = var3;
					GrandExchangeOfferAgeComparator.savePreferences();
				}

				return 1;
			}
		}
	}

	@ObfuscatedName("in")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "43"
	)
	@Export("getNewestMenuIdx")
	static final int getNewestMenuIdx() {
		return Client.menuOptionsCount - 1;
	}
}
