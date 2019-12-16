import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("bn")
@Implements("Player")
public final class Player extends Actor {
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Ljc;"
	)
	@Export("username")
	Username username;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lhh;"
	)
	@Export("appearance")
	PlayerAppearance appearance;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = 1331202431
	)
	@Export("headIconPk")
	int headIconPk;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -977239285
	)
	@Export("headIconPrayer")
	int headIconPrayer;
	@ObfuscatedName("b")
	@Export("actions")
	String[] actions;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 2063784201
	)
	@Export("combatLevel")
	int combatLevel;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 431369415
	)
	@Export("skillLevel")
	int skillLevel;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = 1361668867
	)
	@Export("tileHeight")
	int tileHeight;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 633706155
	)
	@Export("animationCycleStart")
	int animationCycleStart;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 477981213
	)
	@Export("animationCycleEnd")
	int animationCycleEnd;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = 771140369
	)
	int field601;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 762347849
	)
	@Export("tileHeight2")
	int tileHeight2;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 1786689969
	)
	int field603;
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "Ldw;"
	)
	@Export("model0")
	Model model0;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 1075037713
	)
	int field605;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 1536061617
	)
	int field606;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -103180295
	)
	int field607;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -1426578557
	)
	int field608;
	@ObfuscatedName("u")
	@Export("isUnanimated")
	boolean isUnanimated;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 897057987
	)
	@Export("team")
	int team;
	@ObfuscatedName("h")
	@Export("isHidden")
	boolean isHidden;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 617269877
	)
	@Export("plane")
	int plane;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 1252308221
	)
	@Export("index")
	int index;
	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "Ljf;"
	)
	@Export("isFriendTriBool")
	TriBool isFriendTriBool;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Ljf;"
	)
	@Export("isInClanChat")
	TriBool isInClanChat;
	@ObfuscatedName("aa")
	boolean field616;
	@ObfuscatedName("av")
	@ObfuscatedGetter(
		intValue = -1337085729
	)
	@Export("tileX")
	int tileX;
	@ObfuscatedName("aw")
	@ObfuscatedGetter(
		intValue = 469043067
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
		this.field616 = false;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(Lkq;B)V",
		garbageValue = "-42"
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
					int var8 = PacketBufferNode.ItemDefinition_get(var4[var5] - 512).team;
					if (var8 != 0) {
						this.team = var8;
					}
				}
			}
		}

		int[] var9 = new int[5];

		for (var6 = 0; var6 < 5; ++var6) {
			var7 = var1.readUnsignedByte();
			if (var7 < 0 || var7 >= WorldMapSection1.field269[var6].length) {
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

		this.username = new Username(var1.readStringCp1252NullTerminated(), class188.loginType);
		this.clearIsFriend();
		this.clearIsInClanChat();
		if (this == Message.localPlayer) {
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

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-2131627106"
	)
	@Export("isFriend")
	boolean isFriend() {
		if (this.isFriendTriBool == TriBool.TriBool_unknown) {
			this.checkIsFriend();
		}

		return this.isFriendTriBool == TriBool.TriBool_true;
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1114296910"
	)
	@Export("clearIsFriend")
	void clearIsFriend() {
		this.isFriendTriBool = TriBool.TriBool_unknown;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1782009211"
	)
	@Export("checkIsFriend")
	void checkIsFriend() {
		this.isFriendTriBool = Message.friendSystem.isFriendAndHasWorld(this.username) ? TriBool.TriBool_true : TriBool.TriBool_false;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "60"
	)
	@Export("isClanMember")
	boolean isClanMember() {
		if (this.isInClanChat == TriBool.TriBool_unknown) {
			this.updateIsInClanChat();
		}

		return this.isInClanChat == TriBool.TriBool_true;
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "66"
	)
	@Export("clearIsInClanChat")
	void clearIsInClanChat() {
		this.isInClanChat = TriBool.TriBool_unknown;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-188049254"
	)
	@Export("updateIsInClanChat")
	void updateIsInClanChat() {
		this.isInClanChat = Calendar.clanChat != null && Calendar.clanChat.contains(this.username) ? TriBool.TriBool_true : TriBool.TriBool_false;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-416425004"
	)
	@Export("transformedSize")
	int transformedSize() {
		return this.appearance != null && this.appearance.npcTransformId != -1 ? AbstractUserComparator.getNpcDefinition(this.appearance.npcTransformId).size : 1;
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(I)Ldw;",
		garbageValue = "822221372"
	)
	@Export("getModel")
	protected final Model getModel() {
		if (this.appearance == null) {
			return null;
		} else {
			SequenceDefinition var1 = super.sequence != -1 && super.sequenceDelay == 0 ? WorldMapSection0.SequenceDefinition_get(super.sequence) : null;
			SequenceDefinition var2 = super.movementSequence != -1 && !this.isUnanimated && (super.movementSequence != super.readySequence || var1 == null) ? WorldMapSection0.SequenceDefinition_get(super.movementSequence) : null;
			Model var3 = this.appearance.getModel(var1, super.sequenceFrame, var2, super.movementFrame);
			if (var3 == null) {
				return null;
			} else {
				var3.calculateBoundsCylinder();
				super.defaultHeight = var3.height;
				Model var4;
				Model[] var5;
				if (!this.isUnanimated && super.spotAnimation != -1 && super.spotAnimationFrame != -1) {
					var4 = ClientPacket.SpotAnimationDefinition_get(super.spotAnimation).getModel(super.spotAnimationFrame);
					if (var4 != null) {
						var4.offsetBy(0, -super.field963, 0);
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
						var4.offsetBy(this.field601 * 4096 - super.x, this.tileHeight2 - this.tileHeight, this.field603 * 4096 - super.y);
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

						var4.offsetBy(super.x - this.field601 * 4096, this.tileHeight - this.tileHeight2, super.y - this.field603 * 4096);
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
		garbageValue = "1025899356"
	)
	final void method1261(int var1, int var2, byte var3) {
		if (super.sequence != -1 && WorldMapSection0.SequenceDefinition_get(super.sequence).field3493 == 1) {
			super.sequence = -1;
		}

		super.field960 = -1;
		if (var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
			if (super.pathX[0] >= 0 && super.pathX[0] < 104 && super.pathY[0] >= 0 && super.pathY[0] < 104) {
				if (var3 == 2) {
					Player var4 = this;
					int var5 = super.pathX[0];
					int var6 = super.pathY[0];
					int var7 = this.transformedSize();
					if (var5 >= var7 && var5 < 104 - var7 && var6 >= var7 && var6 < 104 - var7 && var1 >= var7 && var1 < 104 - var7 && var2 >= var7 && var2 < 104 - var7) {
						int var9 = this.transformedSize();
						Client.field902.approxDestinationX = var1;
						Client.field902.approxDestinationY = var2;
						Client.field902.approxDestinationSizeX = 1;
						Client.field902.approxDestinationSizeY = 1;
						class65 var10 = Client.field902;
						class65 var11 = var10;
						CollisionMap var12 = Client.collisionMaps[this.plane];
						int[] var13 = Client.field903;
						int[] var14 = Client.field730;
						int var15 = 0;

						label733:
						while (true) {
							int var16;
							if (var15 >= 128) {
								int var17;
								int var18;
								byte var20;
								int var21;
								int var22;
								int var24;
								int var26;
								int var27;
								int var28;
								int var29;
								boolean var35;
								int var37;
								int var38;
								int var40;
								if (var9 == 1) {
									var35 = class14.method158(var5, var6, var10, var12);
								} else {
									byte var19;
									byte var23;
									int[][] var34;
									boolean var36;
									if (var9 == 2) {
										var17 = var5;
										var18 = var6;
										var19 = 64;
										var20 = 64;
										var21 = var5 - var19;
										var22 = var6 - var20;
										class173.directions[var19][var20] = 99;
										class173.distances[var19][var20] = 0;
										var23 = 0;
										var24 = 0;
										class173.bufferX[var23] = var5;
										var40 = var23 + 1;
										class173.bufferY[var23] = var6;
										var34 = var12.flags;

										while (true) {
											if (var24 == var40) {
												class268.field3524 = var17;
												class173.field2072 = var18;
												var36 = false;
												break;
											}

											var17 = class173.bufferX[var24];
											var18 = class173.bufferY[var24];
											var24 = var24 + 1 & 4095;
											var37 = var17 - var21;
											var38 = var18 - var22;
											var26 = var17 - var12.xInset;
											var27 = var18 - var12.yInset;
											if (var11.hasArrived(2, var17, var18, var12)) {
												class268.field3524 = var17;
												class173.field2072 = var18;
												var36 = true;
												break;
											}

											var28 = class173.distances[var37][var38] + 1;
											if (var37 > 0 && class173.directions[var37 - 1][var38] == 0 && (var34[var26 - 1][var27] & 19136782) == 0 && (var34[var26 - 1][var27 + 1] & 19136824) == 0) {
												class173.bufferX[var40] = var17 - 1;
												class173.bufferY[var40] = var18;
												var40 = var40 + 1 & 4095;
												class173.directions[var37 - 1][var38] = 2;
												class173.distances[var37 - 1][var38] = var28;
											}

											if (var37 < 126 && class173.directions[var37 + 1][var38] == 0 && (var34[var26 + 2][var27] & 19136899) == 0 && (var34[var26 + 2][var27 + 1] & 19136992) == 0) {
												class173.bufferX[var40] = var17 + 1;
												class173.bufferY[var40] = var18;
												var40 = var40 + 1 & 4095;
												class173.directions[var37 + 1][var38] = 8;
												class173.distances[var37 + 1][var38] = var28;
											}

											if (var38 > 0 && class173.directions[var37][var38 - 1] == 0 && (var34[var26][var27 - 1] & 19136782) == 0 && (var34[var26 + 1][var27 - 1] & 19136899) == 0) {
												class173.bufferX[var40] = var17;
												class173.bufferY[var40] = var18 - 1;
												var40 = var40 + 1 & 4095;
												class173.directions[var37][var38 - 1] = 1;
												class173.distances[var37][var38 - 1] = var28;
											}

											if (var38 < 126 && class173.directions[var37][var38 + 1] == 0 && (var34[var26][var27 + 2] & 19136824) == 0 && (var34[var26 + 1][var27 + 2] & 19136992) == 0) {
												class173.bufferX[var40] = var17;
												class173.bufferY[var40] = var18 + 1;
												var40 = var40 + 1 & 4095;
												class173.directions[var37][var38 + 1] = 4;
												class173.distances[var37][var38 + 1] = var28;
											}

											if (var37 > 0 && var38 > 0 && class173.directions[var37 - 1][var38 - 1] == 0 && (var34[var26 - 1][var27] & 19136830) == 0 && (var34[var26 - 1][var27 - 1] & 19136782) == 0 && (var34[var26][var27 - 1] & 19136911) == 0) {
												class173.bufferX[var40] = var17 - 1;
												class173.bufferY[var40] = var18 - 1;
												var40 = var40 + 1 & 4095;
												class173.directions[var37 - 1][var38 - 1] = 3;
												class173.distances[var37 - 1][var38 - 1] = var28;
											}

											if (var37 < 126 && var38 > 0 && class173.directions[var37 + 1][var38 - 1] == 0 && (var34[var26 + 1][var27 - 1] & 19136911) == 0 && (var34[var26 + 2][var27 - 1] & 19136899) == 0 && (var34[var26 + 2][var27] & 19136995) == 0) {
												class173.bufferX[var40] = var17 + 1;
												class173.bufferY[var40] = var18 - 1;
												var40 = var40 + 1 & 4095;
												class173.directions[var37 + 1][var38 - 1] = 9;
												class173.distances[var37 + 1][var38 - 1] = var28;
											}

											if (var37 > 0 && var38 < 126 && class173.directions[var37 - 1][var38 + 1] == 0 && (var34[var26 - 1][var27 + 1] & 19136830) == 0 && (var34[var26 - 1][var27 + 2] & 19136824) == 0 && (var34[var26][var27 + 2] & 19137016) == 0) {
												class173.bufferX[var40] = var17 - 1;
												class173.bufferY[var40] = var18 + 1;
												var40 = var40 + 1 & 4095;
												class173.directions[var37 - 1][var38 + 1] = 6;
												class173.distances[var37 - 1][var38 + 1] = var28;
											}

											if (var37 < 126 && var38 < 126 && class173.directions[var37 + 1][var38 + 1] == 0 && (var34[var26 + 1][var27 + 2] & 19137016) == 0 && (var34[var26 + 2][var27 + 2] & 19136992) == 0 && (var34[var26 + 2][var27 + 1] & 19136995) == 0) {
												class173.bufferX[var40] = var17 + 1;
												class173.bufferY[var40] = var18 + 1;
												var40 = var40 + 1 & 4095;
												class173.directions[var37 + 1][var38 + 1] = 12;
												class173.distances[var37 + 1][var38 + 1] = var28;
											}
										}

										var35 = var36;
									} else {
										var17 = var5;
										var18 = var6;
										var19 = 64;
										var20 = 64;
										var21 = var5 - var19;
										var22 = var6 - var20;
										class173.directions[var19][var20] = 99;
										class173.distances[var19][var20] = 0;
										var23 = 0;
										var24 = 0;
										class173.bufferX[var23] = var5;
										var40 = var23 + 1;
										class173.bufferY[var23] = var6;
										var34 = var12.flags;

										label711:
										while (true) {
											label709:
											while (true) {
												do {
													do {
														do {
															label686:
															do {
																if (var24 == var40) {
																	class268.field3524 = var17;
																	class173.field2072 = var18;
																	var36 = false;
																	break label711;
																}

																var17 = class173.bufferX[var24];
																var18 = class173.bufferY[var24];
																var24 = var24 + 1 & 4095;
																var37 = var17 - var21;
																var38 = var18 - var22;
																var26 = var17 - var12.xInset;
																var27 = var18 - var12.yInset;
																if (var11.hasArrived(var9, var17, var18, var12)) {
																	class268.field3524 = var17;
																	class173.field2072 = var18;
																	var36 = true;
																	break label711;
																}

																var28 = class173.distances[var37][var38] + 1;
																if (var37 > 0 && class173.directions[var37 - 1][var38] == 0 && (var34[var26 - 1][var27] & 19136782) == 0 && (var34[var26 - 1][var27 + var9 - 1] & 19136824) == 0) {
																	var29 = 1;

																	while (true) {
																		if (var29 >= var9 - 1) {
																			class173.bufferX[var40] = var17 - 1;
																			class173.bufferY[var40] = var18;
																			var40 = var40 + 1 & 4095;
																			class173.directions[var37 - 1][var38] = 2;
																			class173.distances[var37 - 1][var38] = var28;
																			break;
																		}

																		if ((var34[var26 - 1][var29 + var27] & 19136830) != 0) {
																			break;
																		}

																		++var29;
																	}
																}

																if (var37 < 128 - var9 && class173.directions[var37 + 1][var38] == 0 && (var34[var9 + var26][var27] & 19136899) == 0 && (var34[var9 + var26][var9 + var27 - 1] & 19136992) == 0) {
																	var29 = 1;

																	while (true) {
																		if (var29 >= var9 - 1) {
																			class173.bufferX[var40] = var17 + 1;
																			class173.bufferY[var40] = var18;
																			var40 = var40 + 1 & 4095;
																			class173.directions[var37 + 1][var38] = 8;
																			class173.distances[var37 + 1][var38] = var28;
																			break;
																		}

																		if ((var34[var9 + var26][var29 + var27] & 19136995) != 0) {
																			break;
																		}

																		++var29;
																	}
																}

																if (var38 > 0 && class173.directions[var37][var38 - 1] == 0 && (var34[var26][var27 - 1] & 19136782) == 0 && (var34[var26 + var9 - 1][var27 - 1] & 19136899) == 0) {
																	var29 = 1;

																	while (true) {
																		if (var29 >= var9 - 1) {
																			class173.bufferX[var40] = var17;
																			class173.bufferY[var40] = var18 - 1;
																			var40 = var40 + 1 & 4095;
																			class173.directions[var37][var38 - 1] = 1;
																			class173.distances[var37][var38 - 1] = var28;
																			break;
																		}

																		if ((var34[var29 + var26][var27 - 1] & 19136911) != 0) {
																			break;
																		}

																		++var29;
																	}
																}

																if (var38 < 128 - var9 && class173.directions[var37][var38 + 1] == 0 && (var34[var26][var9 + var27] & 19136824) == 0 && (var34[var9 + var26 - 1][var9 + var27] & 19136992) == 0) {
																	var29 = 1;

																	while (true) {
																		if (var29 >= var9 - 1) {
																			class173.bufferX[var40] = var17;
																			class173.bufferY[var40] = var18 + 1;
																			var40 = var40 + 1 & 4095;
																			class173.directions[var37][var38 + 1] = 4;
																			class173.distances[var37][var38 + 1] = var28;
																			break;
																		}

																		if ((var34[var26 + var29][var9 + var27] & 19137016) != 0) {
																			break;
																		}

																		++var29;
																	}
																}

																if (var37 > 0 && var38 > 0 && class173.directions[var37 - 1][var38 - 1] == 0 && (var34[var26 - 1][var27 - 1] & 19136782) == 0) {
																	var29 = 1;

																	while (true) {
																		if (var29 >= var9) {
																			class173.bufferX[var40] = var17 - 1;
																			class173.bufferY[var40] = var18 - 1;
																			var40 = var40 + 1 & 4095;
																			class173.directions[var37 - 1][var38 - 1] = 3;
																			class173.distances[var37 - 1][var38 - 1] = var28;
																			break;
																		}

																		if ((var34[var26 - 1][var29 + (var27 - 1)] & 19136830) != 0 || (var34[var29 + (var26 - 1)][var27 - 1] & 19136911) != 0) {
																			break;
																		}

																		++var29;
																	}
																}

																if (var37 < 128 - var9 && var38 > 0 && class173.directions[var37 + 1][var38 - 1] == 0 && (var34[var26 + var9][var27 - 1] & 19136899) == 0) {
																	var29 = 1;

																	while (true) {
																		if (var29 >= var9) {
																			class173.bufferX[var40] = var17 + 1;
																			class173.bufferY[var40] = var18 - 1;
																			var40 = var40 + 1 & 4095;
																			class173.directions[var37 + 1][var38 - 1] = 9;
																			class173.distances[var37 + 1][var38 - 1] = var28;
																			break;
																		}

																		if ((var34[var26 + var9][var29 + (var27 - 1)] & 19136995) != 0 || (var34[var29 + var26][var27 - 1] & 19136911) != 0) {
																			break;
																		}

																		++var29;
																	}
																}

																if (var37 > 0 && var38 < 128 - var9 && class173.directions[var37 - 1][var38 + 1] == 0 && (var34[var26 - 1][var9 + var27] & 19136824) == 0) {
																	for (var29 = 1; var29 < var9; ++var29) {
																		if ((var34[var26 - 1][var27 + var29] & 19136830) != 0 || (var34[var29 + (var26 - 1)][var27 + var9] & 19137016) != 0) {
																			continue label686;
																		}
																	}

																	class173.bufferX[var40] = var17 - 1;
																	class173.bufferY[var40] = var18 + 1;
																	var40 = var40 + 1 & 4095;
																	class173.directions[var37 - 1][var38 + 1] = 6;
																	class173.distances[var37 - 1][var38 + 1] = var28;
																}
															} while(var37 >= 128 - var9);
														} while(var38 >= 128 - var9);
													} while(class173.directions[var37 + 1][var38 + 1] != 0);
												} while((var34[var9 + var26][var9 + var27] & 19136992) != 0);

												for (var29 = 1; var29 < var9; ++var29) {
													if ((var34[var29 + var26][var9 + var27] & 19137016) != 0 || (var34[var26 + var9][var27 + var29] & 19136995) != 0) {
														continue label709;
													}
												}

												class173.bufferX[var40] = var17 + 1;
												class173.bufferY[var40] = var18 + 1;
												var40 = var40 + 1 & 4095;
												class173.directions[var37 + 1][var38 + 1] = 12;
												class173.distances[var37 + 1][var38 + 1] = var28;
											}
										}

										var35 = var36;
									}
								}

								int var8;
								label774: {
									var16 = var5 - 64;
									var17 = var6 - 64;
									var18 = class268.field3524;
									var37 = class173.field2072;
									if (!var35) {
										var38 = Integer.MAX_VALUE;
										var21 = Integer.MAX_VALUE;
										byte var39 = 10;
										var40 = var11.approxDestinationX;
										var24 = var11.approxDestinationY;
										int var25 = var11.approxDestinationSizeX;
										var26 = var11.approxDestinationSizeY;

										for (var27 = var40 - var39; var27 <= var39 + var40; ++var27) {
											for (var28 = var24 - var39; var28 <= var39 + var24; ++var28) {
												var29 = var27 - var16;
												int var30 = var28 - var17;
												if (var29 >= 0 && var30 >= 0 && var29 < 128 && var30 < 128 && class173.distances[var29][var30] < 100) {
													int var31 = 0;
													if (var27 < var40) {
														var31 = var40 - var27;
													} else if (var27 > var40 + var25 - 1) {
														var31 = var27 - (var25 + var40 - 1);
													}

													int var32 = 0;
													if (var28 < var24) {
														var32 = var24 - var28;
													} else if (var28 > var24 + var26 - 1) {
														var32 = var28 - (var26 + var24 - 1);
													}

													int var33 = var31 * var31 + var32 * var32;
													if (var33 < var38 || var38 == var33 && class173.distances[var29][var30] < var21) {
														var38 = var33;
														var21 = class173.distances[var29][var30];
														var18 = var27;
														var37 = var28;
													}
												}
											}
										}

										if (var38 == Integer.MAX_VALUE) {
											var8 = -1;
											break label774;
										}
									}

									if (var5 == var18 && var6 == var37) {
										var8 = 0;
									} else {
										var20 = 0;
										class173.bufferX[var20] = var18;
										var38 = var20 + 1;
										class173.bufferY[var20] = var37;

										for (var21 = var22 = class173.directions[var18 - var16][var37 - var17]; var5 != var18 || var6 != var37; var21 = class173.directions[var18 - var16][var37 - var17]) {
											if (var22 != var21) {
												var22 = var21;
												class173.bufferX[var38] = var18;
												class173.bufferY[var38++] = var37;
											}

											if ((var21 & 2) != 0) {
												++var18;
											} else if ((var21 & 8) != 0) {
												--var18;
											}

											if ((var21 & 1) != 0) {
												++var37;
											} else if ((var21 & 4) != 0) {
												--var37;
											}
										}

										var40 = 0;

										while (var38-- > 0) {
											var13[var40] = class173.bufferX[var38];
											var14[var40++] = class173.bufferY[var38];
											if (var40 >= var13.length) {
												break;
											}
										}

										var8 = var40;
									}
								}

								var15 = var8;
								if (var8 < 1) {
									break;
								}

								var16 = 0;

								while (true) {
									if (var16 >= var15 - 1) {
										break label733;
									}

									var4.method1246(Client.field903[var16], Client.field730[var16], (byte)2);
									++var16;
								}
							}

							for (var16 = 0; var16 < 128; ++var16) {
								class173.directions[var15][var16] = 0;
								class173.distances[var15][var16] = 99999999;
							}

							++var15;
						}
					}
				}

				this.method1246(var1, var2, var3);
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
		garbageValue = "16"
	)
	@Export("resetPath")
	void resetPath(int var1, int var2) {
		super.pathLength = 0;
		super.field926 = 0;
		super.field980 = 0;
		super.pathX[0] = var1;
		super.pathY[0] = var2;
		int var3 = this.transformedSize();
		super.x = var3 * 64 + super.pathX[0] * 128;
		super.y = var3 * 64 + super.pathY[0] * 128;
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(IIBI)V",
		garbageValue = "-1970800516"
	)
	final void method1246(int var1, int var2, byte var3) {
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

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(S)Z",
		garbageValue = "3163"
	)
	@Export("isVisible")
	final boolean isVisible() {
		return this.appearance != null;
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(IB)Z",
		garbageValue = "4"
	)
	public static boolean method1278(int var0) {
		return (var0 >> 20 & 1) != 0;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(IZIZB)V",
		garbageValue = "91"
	)
	@Export("sortWorldList")
	static void sortWorldList(int var0, boolean var1, int var2, boolean var3) {
		if (class162.World_worlds != null) {
			class269.doWorldSorting(0, class162.World_worlds.length - 1, var0, var1, var2, var3);
		}

	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(Lbe;Lbe;IZI)I",
		garbageValue = "261221289"
	)
	@Export("compareWorlds")
	static int compareWorlds(World var0, World var1, int var2, boolean var3) {
		if (var2 == 1) {
			int var4 = var0.population;
			int var5 = var1.population;
			if (!var3) {
				if (var4 == -1) {
					var4 = 2001;
				}

				if (var5 == -1) {
					var5 = 2001;
				}
			}

			return var4 - var5;
		} else if (var2 == 2) {
			return var0.location - var1.location;
		} else if (var2 == 3) {
			if (var0.activity.equals("-")) {
				if (var1.activity.equals("-")) {
					return 0;
				} else {
					return var3 ? -1 : 1;
				}
			} else if (var1.activity.equals("-")) {
				return var3 ? 1 : -1;
			} else {
				return var0.activity.compareTo(var1.activity);
			}
		} else if (var2 == 4) {
			return var0.method1780() ? (var1.method1780() ? 0 : 1) : (var1.method1780() ? -1 : 0);
		} else if (var2 == 5) {
			return var0.method1782() ? (var1.method1782() ? 0 : 1) : (var1.method1782() ? -1 : 0);
		} else if (var2 == 6) {
			return var0.isPvp() ? (var1.isPvp() ? 0 : 1) : (var1.isPvp() ? -1 : 0);
		} else if (var2 == 7) {
			return var0.isMembersOnly() ? (var1.isMembersOnly() ? 0 : 1) : (var1.isMembersOnly() ? -1 : 0);
		} else {
			return var0.id - var1.id;
		}
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		signature = "(ILcu;ZI)I",
		garbageValue = "400713711"
	)
	static int method1277(int var0, Script var1, boolean var2) {
		if (var0 == ScriptOpcodes.VIEWPORT_SETFOV) {
			class188.Interpreter_intStackSize -= 2;
			Client.field879 = (short)class40.method762(Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize]);
			if (Client.field879 <= 0) {
				Client.field879 = 256;
			}

			Client.field880 = (short)class40.method762(Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 1]);
			if (Client.field880 <= 0) {
				Client.field880 = 256;
			}

			return 1;
		} else if (var0 == ScriptOpcodes.VIEWPORT_SETZOOM) {
			class188.Interpreter_intStackSize -= 2;
			Client.zoomHeight = (short)Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize];
			if (Client.zoomHeight <= 0) {
				Client.zoomHeight = 256;
			}

			Client.zoomWidth = (short)Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 1];
			if (Client.zoomWidth <= 0) {
				Client.zoomWidth = 320;
			}

			return 1;
		} else if (var0 == ScriptOpcodes.VIEWPORT_CLAMPFOV) {
			class188.Interpreter_intStackSize -= 4;
			Client.field796 = (short)Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize];
			if (Client.field796 <= 0) {
				Client.field796 = 1;
			}

			Client.field884 = (short)Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 1];
			if (Client.field884 <= 0) {
				Client.field884 = 32767;
			} else if (Client.field884 < Client.field796) {
				Client.field884 = Client.field796;
			}

			Client.field804 = (short)Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 2];
			if (Client.field804 <= 0) {
				Client.field804 = 1;
			}

			Client.field886 = (short)Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 3];
			if (Client.field886 <= 0) {
				Client.field886 = 32767;
			} else if (Client.field886 < Client.field804) {
				Client.field886 = Client.field804;
			}

			return 1;
		} else if (var0 == ScriptOpcodes.VIEWPORT_GETEFFECTIVESIZE) {
			if (Client.viewportWidget != null) {
				Frames.setViewportShape(0, 0, Client.viewportWidget.width, Client.viewportWidget.height, false);
				Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = Client.viewportWidth;
				Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = Client.viewportHeight;
			} else {
				Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = -1;
				Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = -1;
			}

			return 1;
		} else if (var0 == ScriptOpcodes.VIEWPORT_GETZOOM) {
			Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = Client.zoomHeight;
			Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = Client.zoomWidth;
			return 1;
		} else if (var0 == ScriptOpcodes.VIEWPORT_GETFOV) {
			Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = Client.method1740(Client.field879);
			Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = Client.method1740(Client.field880);
			return 1;
		} else if (var0 == 6220) {
			Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = 0;
			return 1;
		} else if (var0 == 6221) {
			Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = 0;
			return 1;
		} else if (var0 == 6222) {
			Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = GrandExchangeOfferTotalQuantityComparator.canvasWidth;
			return 1;
		} else if (var0 == 6223) {
			Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = AttackOption.canvasHeight;
			return 1;
		} else {
			return 2;
		}
	}
}
