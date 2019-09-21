import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("by")
@Implements("Player")
public final class Player extends Actor {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Ljt;"
	)
	@Export("username")
	Username username;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lhl;"
	)
	@Export("appearance")
	PlayerAppearance appearance;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 864337607
	)
	@Export("headIconPk")
	int headIconPk;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -643204403
	)
	@Export("headIconPrayer")
	int headIconPrayer;
	@ObfuscatedName("u")
	@Export("actions")
	String[] actions;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -2062997853
	)
	@Export("combatLevel")
	int combatLevel;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -948355921
	)
	@Export("skillLevel")
	int skillLevel;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 327287567
	)
	@Export("tileHeight")
	int tileHeight;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 1224273453
	)
	@Export("animationCycleStart")
	int animationCycleStart;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 1646595601
	)
	@Export("animationCycleEnd")
	int animationCycleEnd;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = 775651165
	)
	int field597;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = 1969492201
	)
	@Export("tileHeight2")
	int tileHeight2;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = 986726149
	)
	int field599;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Ldr;"
	)
	@Export("model0")
	Model model0;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -1689358093
	)
	int field601;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -245110959
	)
	int field602;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -1431482225
	)
	int field609;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = 1697291055
	)
	int field604;
	@ObfuscatedName("r")
	@Export("isUnanimated")
	boolean isUnanimated;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 1073558355
	)
	@Export("team")
	int team;
	@ObfuscatedName("w")
	@Export("isHidden")
	boolean isHidden;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 1849078909
	)
	@Export("plane")
	int plane;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = -385215651
	)
	@Export("index")
	int index;
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "Ljb;"
	)
	@Export("isFriendTriBool")
	TriBool isFriendTriBool;
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Ljb;"
	)
	@Export("isInClanChat")
	TriBool isInClanChat;
	@ObfuscatedName("ag")
	boolean field607;
	@ObfuscatedName("at")
	@ObfuscatedGetter(
		intValue = -327661855
	)
	@Export("tileX")
	int tileX;
	@ObfuscatedName("ao")
	@ObfuscatedGetter(
		intValue = 1356455245
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
		this.field607 = false;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Lkz;I)V",
		garbageValue = "-2019720231"
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
					int var8 = ItemDefinition_get(var4[var5] - 512).team;
					if (var8 != 0) {
						this.team = var8;
					}
				}
			}
		}

		int[] var9 = new int[5];

		for (var6 = 0; var6 < 5; ++var6) {
			var7 = var1.readUnsignedByte();
			if (var7 < 0 || var7 >= PlayerAppearance.field2508[var6].length) {
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

		this.username = new Username(var1.readStringCp1252NullTerminated(), class4.loginType);
		this.clearIsFriend();
		this.clearIsInClanChat();
		if (this == Varps.localPlayer) {
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

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-992327182"
	)
	@Export("isFriend")
	boolean isFriend() {
		if (this.isFriendTriBool == TriBool.TriBool_unknown) {
			this.checkIsFriend();
		}

		return this.isFriendTriBool == TriBool.TriBool_true;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-93486639"
	)
	@Export("clearIsFriend")
	void clearIsFriend() {
		this.isFriendTriBool = TriBool.TriBool_unknown;
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1481363625"
	)
	@Export("checkIsFriend")
	void checkIsFriend() {
		this.isFriendTriBool = class218.friendSystem.isFriendAndHasWorld(this.username) ? TriBool.TriBool_true : TriBool.TriBool_false;
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-1549480529"
	)
	@Export("isClanMember")
	boolean isClanMember() {
		if (this.isInClanChat == TriBool.TriBool_unknown) {
			this.updateIsInClanChat();
		}

		return this.isInClanChat == TriBool.TriBool_true;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1297005928"
	)
	@Export("clearIsInClanChat")
	void clearIsInClanChat() {
		this.isInClanChat = TriBool.TriBool_unknown;
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1288266652"
	)
	@Export("updateIsInClanChat")
	void updateIsInClanChat() {
		this.isInClanChat = GrandExchangeOfferUnitPriceComparator.clanChat != null && GrandExchangeOfferUnitPriceComparator.clanChat.contains(this.username) ? TriBool.TriBool_true : TriBool.TriBool_false;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "2132604057"
	)
	@Export("transformedSize")
	int transformedSize() {
		return this.appearance != null && this.appearance.npcTransformId != -1 ? FontName.getNpcDefinition(this.appearance.npcTransformId).size : 1;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(B)Ldr;",
		garbageValue = "-35"
	)
	@Export("getModel")
	protected final Model getModel() {
		if (this.appearance == null) {
			return null;
		} else {
			SequenceDefinition var1 = super.sequence != -1 && super.sequenceDelay == 0 ? class83.SequenceDefinition_get(super.sequence) : null;
			SequenceDefinition var2 = super.movementSequence != -1 && !this.isUnanimated && (super.readySequence != super.movementSequence || var1 == null) ? class83.SequenceDefinition_get(super.movementSequence) : null;
			Model var3 = this.appearance.getModel(var1, super.sequenceFrame, var2, super.movementFrame);
			if (var3 == null) {
				return null;
			} else {
				var3.calculateBoundsCylinder();
				super.defaultHeight = var3.height;
				Model var4;
				Model[] var5;
				if (!this.isUnanimated && super.spotAnimation != -1 && super.spotAnimationFrame != -1) {
					var4 = NetCache.SpotAnimationDefinition_get(super.spotAnimation).getModel(super.spotAnimationFrame);
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
						var4.offsetBy(this.field597 * 4096 - super.x * -78439701, this.tileHeight2 - this.tileHeight, this.field599 * 4096 - super.y);
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

						var4.offsetBy(super.x * -78439701 - this.field597 * 4096, this.tileHeight - this.tileHeight2, super.y - this.field599 * 4096);
					}
				}

				var3.isSingleTile = true;
				return var3;
			}
		}
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(IIBI)V",
		garbageValue = "170644869"
	)
	final void method1189(int var1, int var2, byte var3) {
		if (super.sequence != -1 && class83.SequenceDefinition_get(super.sequence).field3501 == 1) {
			super.sequence = -1;
		}

		super.field945 = -1;
		if (var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
			if (super.pathX[0] >= 0 && super.pathX[0] < 104 && super.pathY[0] >= 0 && super.pathY[0] < 104) {
				if (var3 == 2) {
					Player var4 = this;
					int var5 = super.pathX[0];
					int var6 = super.pathY[0];
					int var7 = this.transformedSize();
					if (var5 >= var7 && var5 < 104 - var7 && var6 >= var7 && var6 < 104 - var7 && var1 >= var7 && var1 < 104 - var7 && var2 >= var7 && var2 < 104 - var7) {
						int var10 = this.transformedSize();
						Client.field896.approxDestinationX = var1;
						Client.field896.approxDestinationY = var2;
						Client.field896.approxDestinationSizeX = 1;
						Client.field896.approxDestinationSizeY = 1;
						class65 var11 = Client.field896;
						int var12 = WorldMapIcon_0.method194(var5, var6, var10, var11, Client.collisionMaps[this.plane], true, Client.field897, Client.field622);
						if (var12 >= 1) {
							for (int var13 = 0; var13 < var12 - 1; ++var13) {
								var4.method1191(Client.field897[var13], Client.field622[var13], (byte)2);
							}
						}
					}
				}

				this.method1191(var1, var2, var3);
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
		garbageValue = "317983942"
	)
	@Export("resetPath")
	void resetPath(int var1, int var2) {
		super.pathLength = 0;
		super.field969 = 0;
		super.field975 = 0;
		super.pathX[0] = var1;
		super.pathY[0] = var2;
		int var3 = this.transformedSize();
		super.x = var3 * -294686528 + super.pathX[0] * -589373056;
		super.y = super.pathY[0] * 128 + var3 * 64;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(IIBI)V",
		garbageValue = "-1285551700"
	)
	final void method1191(int var1, int var2, byte var3) {
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

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "93"
	)
	@Export("isVisible")
	final boolean isVisible() {
		return this.appearance != null;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Lhz;I)V",
		garbageValue = "-1030066810"
	)
	public static void method1228(AbstractArchive var0) {
		FloorOverlayDefinition.FloorOverlayDefinition_archive = var0;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(IB)Lid;",
		garbageValue = "-59"
	)
	@Export("ItemDefinition_get")
	public static ItemDefinition ItemDefinition_get(int var0) {
		ItemDefinition var1 = (ItemDefinition)ItemDefinition.ItemDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = class65.ItemDefinition_archive.takeFile(10, var0);
			var1 = new ItemDefinition();
			var1.id = var0;
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			var1.post();
			if (var1.noteTemplate != -1) {
				var1.genCert(ItemDefinition_get(var1.noteTemplate), ItemDefinition_get(var1.note));
			}

			if (var1.notedId != -1) {
				var1.genBought(ItemDefinition_get(var1.notedId), ItemDefinition_get(var1.unnotedId));
			}

			if (var1.placeholderTemplate != -1) {
				var1.genPlaceholder(ItemDefinition_get(var1.placeholderTemplate), ItemDefinition_get(var1.placeholder));
			}

			if (!ItemDefinition.ItemDefinition_inMembersWorld && var1.isMembersOnly) {
				var1.name = "Members object";
				var1.isTradable = false;
				var1.groundActions = null;
				var1.inventoryActions = null;
				var1.shiftClickIndex = -1;
				var1.team = 0;
				if (var1.params != null) {
					boolean var3 = false;

					for (Node var4 = var1.params.first(); var4 != null; var4 = var1.params.next()) {
						ParamDefinition var5 = GrandExchangeOfferTotalQuantityComparator.getParamDefinition((int)var4.key);
						if (var5.autoDisable) {
							var4.remove();
						} else {
							var3 = true;
						}
					}

					if (!var3) {
						var1.params = null;
					}
				}
			}

			ItemDefinition.ItemDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(II)Lhy;",
		garbageValue = "-43524032"
	)
	@Export("getWidget")
	public static Widget getWidget(int var0) {
		int var1 = var0 >> 16;
		int var2 = var0 & 65535;
		if (class289.Widget_interfaceComponents[var1] == null || class289.Widget_interfaceComponents[var1][var2] == null) {
			boolean var3 = TaskHandler.loadInterface(var1);
			if (!var3) {
				return null;
			}
		}

		return class289.Widget_interfaceComponents[var1][var2];
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(IIIIIZI)Lli;",
		garbageValue = "1247065479"
	)
	@Export("getItemSprite")
	public static final Sprite getItemSprite(int var0, int var1, int var2, int var3, int var4, boolean var5) {
		if (var1 == -1) {
			var4 = 0;
		} else if (var4 == 2 && var1 != 1) {
			var4 = 1;
		}

		long var6 = (long)var0 + ((long)var1 << 16) + ((long)var2 << 38) + ((long)var4 << 40) + ((long)var3 << 42);
		Sprite var8;
		if (!var5) {
			var8 = (Sprite)ItemDefinition.ItemDefinition_cachedSprites.get(var6);
			if (var8 != null) {
				return var8;
			}
		}

		ItemDefinition var9 = ItemDefinition_get(var0);
		if (var1 > 1 && var9.countobj != null) {
			int var10 = -1;

			for (int var11 = 0; var11 < 10; ++var11) {
				if (var1 >= var9.countco[var11] && var9.countco[var11] != 0) {
					var10 = var9.countobj[var11];
				}
			}

			if (var10 != -1) {
				var9 = ItemDefinition_get(var10);
			}
		}

		Model var19 = var9.getModel(1);
		if (var19 == null) {
			return null;
		} else {
			Sprite var20 = null;
			if (var9.noteTemplate != -1) {
				var20 = getItemSprite(var9.note, 10, 1, 0, 0, true);
				if (var20 == null) {
					return null;
				}
			} else if (var9.notedId != -1) {
				var20 = getItemSprite(var9.unnotedId, var1, var2, var3, 0, false);
				if (var20 == null) {
					return null;
				}
			} else if (var9.placeholderTemplate != -1) {
				var20 = getItemSprite(var9.placeholder, var1, 0, 0, 0, false);
				if (var20 == null) {
					return null;
				}
			}

			int[] var12 = Rasterizer2D.Rasterizer2D_pixels;
			int var13 = Rasterizer2D.Rasterizer2D_width;
			int var14 = Rasterizer2D.Rasterizer2D_height;
			int[] var15 = new int[4];
			Rasterizer2D.Rasterizer2D_getClipArray(var15);
			var8 = new Sprite(36, 32);
			Rasterizer2D.Rasterizer2D_replace(var8.pixels, 36, 32);
			Rasterizer2D.Rasterizer2D_clear();
			Rasterizer3D.Rasterizer3D_setClipFromRasterizer2D();
			Rasterizer3D.method3033(16, 16);
			Rasterizer3D.field1729 = false;
			if (var9.placeholderTemplate != -1) {
				var20.drawTransBgAt(0, 0);
			}

			int var16 = var9.zoom2d;
			if (var5) {
				var16 = (int)((double)var16 * 1.5D);
			} else if (var2 == 2) {
				var16 = (int)(1.04D * (double)var16);
			}

			int var17 = var16 * Rasterizer3D.Rasterizer3D_sine[var9.xan2d] >> 16;
			int var18 = var16 * Rasterizer3D.Rasterizer3D_cosine[var9.xan2d] >> 16;
			var19.calculateBoundsCylinder();
			var19.method2854(0, var9.yan2d, var9.zan2d, var9.xan2d, var9.offsetX2d, var19.height / 2 + var17 + var9.offsetY2d, var18 + var9.offsetY2d);
			if (var9.notedId != -1) {
				var20.drawTransBgAt(0, 0);
			}

			if (var2 >= 1) {
				var8.outline(1);
			}

			if (var2 >= 2) {
				var8.outline(16777215);
			}

			if (var3 != 0) {
				var8.shadow(var3);
			}

			Rasterizer2D.Rasterizer2D_replace(var8.pixels, 36, 32);
			if (var9.noteTemplate != -1) {
				var20.drawTransBgAt(0, 0);
			}

			if (var4 == 1 || var4 == 2 && var9.isStackable == 1) {
				class215.ItemDefinition_fontPlain11.draw(BoundaryObject.method3230(var1), 0, 9, 16776960, 1);
			}

			if (!var5) {
				ItemDefinition.ItemDefinition_cachedSprites.put(var8, var6);
			}

			Rasterizer2D.Rasterizer2D_replace(var12, var13, var14);
			Rasterizer2D.Rasterizer2D_setClipArray(var15);
			Rasterizer3D.Rasterizer3D_setClipFromRasterizer2D();
			Rasterizer3D.field1729 = true;
			return var8;
		}
	}

	@ObfuscatedName("hn")
	@ObfuscatedSignature(
		signature = "(IIIII)V",
		garbageValue = "16777215"
	)
	@Export("selectSpell")
	static void selectSpell(int widgetId, int childId, int clickMaskId, int id) {
		Widget var4 = class49.getWidgetChild(widgetId, childId);
		if (var4 != null && var4.onTargetEnter != null) {
			ScriptEvent var5 = new ScriptEvent();
			var5.widget = var4;
			var5.args = var4.onTargetEnter;
			SecureRandomFuture.runScriptEvent(var5);
		}

		Client.field648 = id;
		Client.isSpellSelected = true;
		class83.selectedSpellWidget = widgetId;
		Client.selectedSpellChildIndex = childId;
		BuddyRankComparator.selectedSpellFlags = clickMaskId;
		WorldMapID.invalidateWidget(var4);
	}
}
