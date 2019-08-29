import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("d")
@Implements("GrandExchangeOffer")
public class GrandExchangeOffer {
	@ObfuscatedName("st")
	@ObfuscatedGetter(
		intValue = 549974423
	)
	@Export("foundItemIndex")
	static int foundItemIndex;
	@ObfuscatedName("se")
	@ObfuscatedSignature(
		signature = "Lbx;"
	)
	@Export("clientPreferences")
	static ClientPreferences clientPreferences;
	@ObfuscatedName("s")
	@Export("state")
	byte state;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = 416922963
	)
	@Export("id")
	public int id;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 1858157699
	)
	@Export("unitPrice")
	public int unitPrice;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -214524093
	)
	@Export("totalQuantity")
	public int totalQuantity;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 280180281
	)
	@Export("currentQuantity")
	public int currentQuantity;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 24514895
	)
	@Export("currentPrice")
	public int currentPrice;

	public GrandExchangeOffer() {
	}

	@ObfuscatedSignature(
		signature = "(Lky;Z)V",
		garbageValue = "0"
	)
	public GrandExchangeOffer(Buffer var1, boolean var2) {
		this.state = var1.readByte();
		this.id = var1.readUnsignedShort();
		this.unitPrice = var1.readInt();
		this.totalQuantity = var1.readInt();
		this.currentQuantity = var1.readInt();
		this.currentPrice = var1.readInt();
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1032509365"
	)
	@Export("status")
	public int status() {
		return this.state & 7;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-636010194"
	)
	@Export("type")
	public int type() {
		return (this.state & 8) == 8 ? 1 : 0;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "1701823469"
	)
	void method108(int var1) {
		this.state &= -8;
		this.state = (byte)(this.state | var1 & 7);
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-184114003"
	)
	void method124(int var1) {
		this.state &= -9;
		if (var1 == 1) {
			this.state = (byte)(this.state | 8);
		}

	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;II)Z",
		garbageValue = "-1475643333"
	)
	static boolean method109(String var0, int var1) {
		return WorldMapSection0.method232(var0, var1, "openjs");
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(ILcr;ZB)I",
		garbageValue = "5"
	)
	static int method123(int var0, Script var1, boolean var2) {
		Widget var3;
		if (var0 >= 2000) {
			var0 -= 1000;
			var3 = WorldMapElement.getWidget(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
		} else {
			var3 = var2 ? class286.field3623 : class297.field3693;
		}

		FriendSystem.invalidateWidget(var3);
		if (var0 != ScriptOpcodes.CC_SETOBJECT && var0 != ScriptOpcodes.CC_SETOBJECT_NONUM && var0 != ScriptOpcodes.CC_SETOBJECT_ALWAYS_NUM) {
			if (var0 == ScriptOpcodes.CC_SETNPCHEAD) {
				var3.modelType = 2;
				var3.modelId = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETPLAYERHEAD_SELF) {
				var3.modelType = 3;
				var3.modelId = WorldMapIcon_1.localPlayer.appearance.getChatHeadId();
				return 1;
			} else {
				return 2;
			}
		} else {
			Interpreter.Interpreter_intStackSize -= 2;
			int var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
			int var5 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
			var3.itemId = var4;
			var3.itemQuantity = var5;
			ItemDefinition var6 = WorldMapData_0.ItemDefinition_get(var4);
			var3.modelAngleX = var6.xan2d;
			var3.modelAngleY = var6.yan2d;
			var3.modelAngleZ = var6.zan2d;
			var3.modelOffsetX = var6.offsetX2d;
			var3.modelOffsetY = var6.offsetY2d;
			var3.modelZoom = var6.zoom2d;
			if (var0 == ScriptOpcodes.CC_SETOBJECT_NONUM) {
				var3.itemQuantityMode = 0;
			} else if (var0 == ScriptOpcodes.CC_SETOBJECT_ALWAYS_NUM | 1 == var6.isStackable) {
				var3.itemQuantityMode = 1;
			} else {
				var3.itemQuantityMode = 2;
			}

			if (var3.field2638 > 0) {
				var3.modelZoom = var3.modelZoom * 32 / var3.field2638;
			} else if (var3.rawWidth > 0) {
				var3.modelZoom = var3.modelZoom * 32 / var3.rawWidth;
			}

			return 1;
		}
	}

	@ObfuscatedName("hs")
	@ObfuscatedSignature(
		signature = "(ZLkx;B)V",
		garbageValue = "104"
	)
	@Export("updateNpcs")
	static final void updateNpcs(boolean var0, PacketBuffer var1) {
		Client.field899 = 0;
		Client.field861 = 0;
		GrandExchangeOfferUnitPriceComparator.readNpcUpdates();
		BoundaryObject.method3216(var0, var1);
		method112(var1);

		int var2;
		for (var2 = 0; var2 < Client.field899; ++var2) {
			int var3 = Client.field655[var2];
			if (Client.npcs[var3].npcCycle != Client.cycle) {
				Client.npcs[var3].definition = null;
				Client.npcs[var3] = null;
			}
		}

		if (var1.offset != Client.packetWriter.serverPacketLength) {
			throw new RuntimeException(var1.offset + "," + Client.packetWriter.serverPacketLength);
		} else {
			for (var2 = 0; var2 < Client.npcCount; ++var2) {
				if (Client.npcs[Client.npcIndices[var2]] == null) {
					throw new RuntimeException(var2 + "," + Client.npcCount);
				}
			}

		}
	}

	@ObfuscatedName("hj")
	@ObfuscatedSignature(
		signature = "(Lkx;I)V",
		garbageValue = "494584381"
	)
	static final void method112(PacketBuffer var0) {
		for (int var1 = 0; var1 < Client.field861; ++var1) {
			int var2 = Client.field669[var1];
			NPC var3 = Client.npcs[var2];
			int var4 = var0.readUnsignedByte();
			if ((var4 & 1) != 0) {
				var3.targetIndex = var0.method5445();
				if (var3.targetIndex == 65535) {
					var3.targetIndex = -1;
				}
			}

			int var5;
			int var6;
			int var7;
			int var8;
			if ((var4 & 64) != 0) {
				var5 = var0.method5447();
				var6 = var0.method5447();
				var7 = var3.x - (var5 - PacketWriter.baseX * 64 - PacketWriter.baseX * 64) * 64;
				var8 = var3.y - (var6 - RouteStrategy.baseY * 64 - RouteStrategy.baseY * 64) * 64;
				if (var7 != 0 || var8 != 0) {
					var3.field946 = (int)(Math.atan2((double)var7, (double)var8) * 325.949D) & 2047;
				}
			}

			if ((var4 & 32) != 0) {
				var5 = var0.readUnsignedShort();
				if (var5 == 65535) {
					var5 = -1;
				}

				var6 = var0.method5438();
				if (var5 == var3.sequence && var5 != -1) {
					var7 = Widget.SequenceDefinition_get(var5).field3492;
					if (var7 == 1) {
						var3.sequenceFrame = 0;
						var3.sequenceFrameCycle = 0;
						var3.sequenceDelay = var6;
						var3.field964 = 0;
					}

					if (var7 == 2) {
						var3.field964 = 0;
					}
				} else if (var5 == -1 || var3.sequence == -1 || Widget.SequenceDefinition_get(var5).field3508 >= Widget.SequenceDefinition_get(var3.sequence).field3508) {
					var3.sequence = var5;
					var3.sequenceFrame = 0;
					var3.sequenceFrameCycle = 0;
					var3.sequenceDelay = var6;
					var3.field964 = 0;
					var3.field947 = var3.pathLength;
				}
			}

			if ((var4 & 4) != 0) {
				var3.definition = ViewportMouse.getNpcDefinition(var0.readUnsignedShort());
				var3.size = var3.definition.size * 64;
				var3.field971 = var3.definition.rotation;
				var3.walkSequence = var3.definition.walkSequence;
				var3.walkBackSequence = var3.definition.walkBackSequence;
				var3.walkLeftSequence = var3.definition.walkLeftSequence;
				var3.walkRightSequence = var3.definition.walkRightSequence;
				var3.readySequence = var3.definition.readySequence;
				var3.turnLeftSequence = var3.definition.turnLeftSequence;
				var3.turnRightSequence = var3.definition.turnRightSequence;
			}

			if ((var4 & 16) != 0) {
				var5 = var0.readUnsignedByteNegate();
				int var9;
				int var10;
				int var11;
				if (var5 > 0) {
					for (var6 = 0; var6 < var5; ++var6) {
						var8 = -1;
						var9 = -1;
						var10 = -1;
						var7 = var0.readUShortSmart();
						if (var7 == 32767) {
							var7 = var0.readUShortSmart();
							var9 = var0.readUShortSmart();
							var8 = var0.readUShortSmart();
							var10 = var0.readUShortSmart();
						} else if (var7 != 32766) {
							var9 = var0.readUShortSmart();
						} else {
							var7 = -1;
						}

						var11 = var0.readUShortSmart();
						var3.addHitSplat(var7, var9, var8, var10, Client.cycle, var11);
					}
				}

				var6 = var0.method5436();
				if (var6 > 0) {
					for (var7 = 0; var7 < var6; ++var7) {
						var8 = var0.readUShortSmart();
						var9 = var0.readUShortSmart();
						if (var9 != 32767) {
							var10 = var0.readUShortSmart();
							var11 = var0.readUnsignedByte();
							int var12 = var9 > 0 ? var0.method5438() : var11;
							var3.addHealthBar(var8, Client.cycle, var9, var10, var11, var12);
						} else {
							var3.removeHealthBar(var8);
						}
					}
				}
			}

			if ((var4 & 8) != 0) {
				var3.spotAnimation = var0.method5445();
				var5 = var0.method5455();
				var3.heightOffset = var5 >> 16;
				var3.field958 = (var5 & 65535) + Client.cycle;
				var3.spotAnimationFrame = 0;
				var3.spotAnimationFrameCycle = 0;
				if (var3.field958 > Client.cycle) {
					var3.spotAnimationFrame = -1;
				}

				if (var3.spotAnimation == 65535) {
					var3.spotAnimation = -1;
				}
			}

			if ((var4 & 2) != 0) {
				var3.overheadText = var0.readStringCp1252NullTerminated();
				var3.overheadTextCyclesRemaining = 100;
			}
		}

	}

	@ObfuscatedName("li")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "869899201"
	)
	static void method122() {
		if (Client.field706 && WorldMapIcon_1.localPlayer != null) {
			int var0 = WorldMapIcon_1.localPlayer.pathX[0];
			int var1 = WorldMapIcon_1.localPlayer.pathY[0];
			if (var0 < 0 || var1 < 0 || var0 >= 104 || var1 >= 104) {
				return;
			}

			DynamicObject.oculusOrbFocalPointX = WorldMapIcon_1.localPlayer.x;
			int var2 = GrandExchangeOfferTotalQuantityComparator.getTileHeight(WorldMapIcon_1.localPlayer.x, WorldMapIcon_1.localPlayer.y, ItemContainer.plane) - Client.camFollowHeight;
			if (var2 < ScriptEvent.field559) {
				ScriptEvent.field559 = var2;
			}

			FriendSystem.oculusOrbFocalPointY = WorldMapIcon_1.localPlayer.y;
			Client.field706 = false;
		}

	}
}
