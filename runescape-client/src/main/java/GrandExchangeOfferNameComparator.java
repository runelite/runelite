import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("c")
@Implements("GrandExchangeOfferNameComparator")
final class GrandExchangeOfferNameComparator implements Comparator {
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(Lq;Lq;B)I",
		garbageValue = "68"
	)
	@Export("compare_bridged")
	int compare_bridged(GrandExchangeEvent var1, GrandExchangeEvent var2) {
		return var1.getOfferName().compareTo(var2.getOfferName());
	}

	public int compare(Object var1, Object var2) {
		return this.compare_bridged((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
	}

	public boolean equals(Object var1) {
		return super.equals(var1);
	}

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		signature = "(ILcr;ZB)I",
		garbageValue = "68"
	)
	static int method150(int var0, Script var1, boolean var2) {
		if (var0 == ScriptOpcodes.CHAT_GETFILTER_PUBLIC) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.publicChatMode;
			return 1;
		} else if (var0 == ScriptOpcodes.CHAT_SETFILTER) {
			Interpreter.Interpreter_intStackSize -= 3;
			Client.publicChatMode = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
			WorldMapIcon_0.privateChatMode = class270.method4895(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]);
			if (WorldMapIcon_0.privateChatMode == null) {
				WorldMapIcon_0.privateChatMode = PrivateChatMode.field3788;
			}

			Client.tradeChatMode = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
			PacketBufferNode var18 = MenuAction.getPacketBufferNode(ClientPacket.field2200, Client.packetWriter.isaacCipher);
			var18.packetBuffer.writeByte(Client.publicChatMode);
			var18.packetBuffer.writeByte(WorldMapIcon_0.privateChatMode.field3791);
			var18.packetBuffer.writeByte(Client.tradeChatMode);
			Client.packetWriter.addNode(var18);
			return 1;
		} else {
			String var3;
			int var4;
			if (var0 == ScriptOpcodes.CHAT_SENDABUSEREPORT) {
				var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
				Interpreter.Interpreter_intStackSize -= 2;
				var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
				int var5 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
				PacketBufferNode var6 = MenuAction.getPacketBufferNode(ClientPacket.field2223, Client.packetWriter.isaacCipher);
				var6.packetBuffer.writeByte(Buddy.stringCp1252NullTerminatedByteSize(var3) + 2);
				var6.packetBuffer.writeStringCp1252NullTerminated(var3);
				var6.packetBuffer.writeByte(var4 - 1);
				var6.packetBuffer.writeByte(var5);
				Client.packetWriter.addNode(var6);
				return 1;
			} else {
				int var10;
				if (var0 == ScriptOpcodes.CHAT_GETHISTORY_BYTYPEANDLINE) {
					Interpreter.Interpreter_intStackSize -= 2;
					var10 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
					var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
					Message var15 = FileSystem.Messages_getByChannelAndID(var10, var4);
					if (var15 != null) {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var15.count;
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var15.cycle;
						Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var15.sender != null ? var15.sender : "";
						Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var15.prefix != null ? var15.prefix : "";
						Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var15.text != null ? var15.text : "";
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var15.isFromFriend() ? 1 : (var15.isFromIgnored() ? 2 : 0);
					} else {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
						Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
						Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
						Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else if (var0 == ScriptOpcodes.CHAT_GETHISTORY_BYUID) {
					var10 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
					Message var16 = class227.Messages_getMessage(var10);
					if (var16 != null) {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var16.type;
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var16.cycle;
						Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var16.sender != null ? var16.sender : "";
						Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var16.prefix != null ? var16.prefix : "";
						Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var16.text != null ? var16.text : "";
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var16.isFromFriend() ? 1 : (var16.isFromIgnored() ? 2 : 0);
					} else {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
						Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
						Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
						Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else if (var0 == ScriptOpcodes.CHAT_GETFILTER_PRIVATE) {
					if (WorldMapIcon_0.privateChatMode == null) {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
					} else {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = WorldMapIcon_0.privateChatMode.field3791;
					}

					return 1;
				} else if (var0 == ScriptOpcodes.CHAT_SENDPUBLIC) {
					var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
					var4 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
					String var14 = var3.toLowerCase();
					byte var17 = 0;
					if (var14.startsWith("yellow:")) {
						var17 = 0;
						var3 = var3.substring("yellow:".length());
					} else if (var14.startsWith("red:")) {
						var17 = 1;
						var3 = var3.substring("red:".length());
					} else if (var14.startsWith("green:")) {
						var17 = 2;
						var3 = var3.substring("green:".length());
					} else if (var14.startsWith("cyan:")) {
						var17 = 3;
						var3 = var3.substring("cyan:".length());
					} else if (var14.startsWith("purple:")) {
						var17 = 4;
						var3 = var3.substring("purple:".length());
					} else if (var14.startsWith("white:")) {
						var17 = 5;
						var3 = var3.substring("white:".length());
					} else if (var14.startsWith("flash1:")) {
						var17 = 6;
						var3 = var3.substring("flash1:".length());
					} else if (var14.startsWith("flash2:")) {
						var17 = 7;
						var3 = var3.substring("flash2:".length());
					} else if (var14.startsWith("flash3:")) {
						var17 = 8;
						var3 = var3.substring("flash3:".length());
					} else if (var14.startsWith("glow1:")) {
						var17 = 9;
						var3 = var3.substring("glow1:".length());
					} else if (var14.startsWith("glow2:")) {
						var17 = 10;
						var3 = var3.substring("glow2:".length());
					} else if (var14.startsWith("glow3:")) {
						var17 = 11;
						var3 = var3.substring("glow3:".length());
					} else if (class60.clientLanguage != Language.Language_EN) {
						if (var14.startsWith("yellow:")) {
							var17 = 0;
							var3 = var3.substring("yellow:".length());
						} else if (var14.startsWith("red:")) {
							var17 = 1;
							var3 = var3.substring("red:".length());
						} else if (var14.startsWith("green:")) {
							var17 = 2;
							var3 = var3.substring("green:".length());
						} else if (var14.startsWith("cyan:")) {
							var17 = 3;
							var3 = var3.substring("cyan:".length());
						} else if (var14.startsWith("purple:")) {
							var17 = 4;
							var3 = var3.substring("purple:".length());
						} else if (var14.startsWith("white:")) {
							var17 = 5;
							var3 = var3.substring("white:".length());
						} else if (var14.startsWith("flash1:")) {
							var17 = 6;
							var3 = var3.substring("flash1:".length());
						} else if (var14.startsWith("flash2:")) {
							var17 = 7;
							var3 = var3.substring("flash2:".length());
						} else if (var14.startsWith("flash3:")) {
							var17 = 8;
							var3 = var3.substring("flash3:".length());
						} else if (var14.startsWith("glow1:")) {
							var17 = 9;
							var3 = var3.substring("glow1:".length());
						} else if (var14.startsWith("glow2:")) {
							var17 = 10;
							var3 = var3.substring("glow2:".length());
						} else if (var14.startsWith("glow3:")) {
							var17 = 11;
							var3 = var3.substring("glow3:".length());
						}
					}

					var14 = var3.toLowerCase();
					byte var7 = 0;
					if (var14.startsWith("wave:")) {
						var7 = 1;
						var3 = var3.substring("wave:".length());
					} else if (var14.startsWith("wave2:")) {
						var7 = 2;
						var3 = var3.substring("wave2:".length());
					} else if (var14.startsWith("shake:")) {
						var7 = 3;
						var3 = var3.substring("shake:".length());
					} else if (var14.startsWith("scroll:")) {
						var7 = 4;
						var3 = var3.substring("scroll:".length());
					} else if (var14.startsWith("slide:")) {
						var7 = 5;
						var3 = var3.substring("slide:".length());
					} else if (Language.Language_EN != class60.clientLanguage) {
						if (var14.startsWith("wave:")) {
							var7 = 1;
							var3 = var3.substring("wave:".length());
						} else if (var14.startsWith("wave2:")) {
							var7 = 2;
							var3 = var3.substring("wave2:".length());
						} else if (var14.startsWith("shake:")) {
							var7 = 3;
							var3 = var3.substring("shake:".length());
						} else if (var14.startsWith("scroll:")) {
							var7 = 4;
							var3 = var3.substring("scroll:".length());
						} else if (var14.startsWith("slide:")) {
							var7 = 5;
							var3 = var3.substring("slide:".length());
						}
					}

					PacketBufferNode var8 = MenuAction.getPacketBufferNode(ClientPacket.field2282, Client.packetWriter.isaacCipher);
					var8.packetBuffer.writeByte(0);
					int var9 = var8.packetBuffer.offset;
					var8.packetBuffer.writeByte(var4);
					var8.packetBuffer.writeByte(var17);
					var8.packetBuffer.writeByte(var7);
					SpotAnimationDefinition.method4334(var8.packetBuffer, var3);
					var8.packetBuffer.writeLengthByte(var8.packetBuffer.offset - var9);
					Client.packetWriter.addNode(var8);
					return 1;
				} else if (var0 == ScriptOpcodes.CHAT_SENDPRIVATE) {
					Interpreter.Interpreter_stringStackSize -= 2;
					var3 = Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize];
					String var12 = Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize + 1];
					PacketBufferNode var11 = MenuAction.getPacketBufferNode(ClientPacket.field2210, Client.packetWriter.isaacCipher);
					var11.packetBuffer.writeShort(0);
					int var13 = var11.packetBuffer.offset;
					var11.packetBuffer.writeStringCp1252NullTerminated(var3);
					SpotAnimationDefinition.method4334(var11.packetBuffer, var12);
					var11.packetBuffer.writeLengthShort(var11.packetBuffer.offset - var13);
					Client.packetWriter.addNode(var11);
					return 1;
				} else if (var0 != ScriptOpcodes.CHAT_PLAYERNAME) {
					if (var0 == ScriptOpcodes.CHAT_GETFILTER_TRADE) {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.tradeChatMode;
						return 1;
					} else if (var0 == ScriptOpcodes.CHAT_GETHISTORYLENGTH) {
						var10 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = BoundaryObject.Messages_getHistorySize(var10);
						return 1;
					} else if (var0 == ScriptOpcodes.CHAT_GETNEXTUID) {
						var10 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = FaceNormal.Messages_getNextChatID(var10);
						return 1;
					} else if (var0 == ScriptOpcodes.CHAT_GETPREVUID) {
						var10 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Language.Messages_getLastChatID(var10);
						return 1;
					} else if (var0 == ScriptOpcodes.DOCHEAT) {
						var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
						BuddyRankComparator.doCheat(var3);
						return 1;
					} else if (var0 == ScriptOpcodes.CHAT_SETMESSAGEFILTER) {
						Client.field668 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize].toLowerCase().trim();
						return 1;
					} else if (var0 == ScriptOpcodes.CHAT_GETMESSAGEFILTER) {
						Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = Client.field668;
						return 1;
					} else if (var0 == 5023) {
						var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
						System.out.println(var3);
						return 1;
					} else {
						return 2;
					}
				} else {
					if (WorldMapIcon_1.localPlayer != null && WorldMapIcon_1.localPlayer.username != null) {
						var3 = WorldMapIcon_1.localPlayer.username.getName();
					} else {
						var3 = "";
					}

					Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3;
					return 1;
				}
			}
		}
	}

	@ObfuscatedName("fl")
	@ObfuscatedSignature(
		signature = "(Lbu;S)V",
		garbageValue = "134"
	)
	static final void method149(Actor var0) {
		var0.isWalking = false;
		SequenceDefinition var1;
		if (var0.movementSequence != -1) {
			var1 = Widget.SequenceDefinition_get(var0.movementSequence);
			if (var1 != null && var1.frameIds != null) {
				++var0.movementFrameCycle;
				if (var0.movementFrame < var1.frameIds.length && var0.movementFrameCycle > var1.frameLengths[var0.movementFrame]) {
					var0.movementFrameCycle = 1;
					++var0.movementFrame;
					class325.addSequenceSoundEffect(var1, var0.movementFrame, var0.x, var0.y);
				}

				if (var0.movementFrame >= var1.frameIds.length) {
					var0.movementFrameCycle = 0;
					var0.movementFrame = 0;
					class325.addSequenceSoundEffect(var1, var0.movementFrame, var0.x, var0.y);
				}
			} else {
				var0.movementSequence = -1;
			}
		}

		if (var0.spotAnimation != -1 && Client.cycle >= var0.field958) {
			if (var0.spotAnimationFrame < 0) {
				var0.spotAnimationFrame = 0;
			}

			int var3 = HealthBarUpdate.SpotAnimationDefinition_get(var0.spotAnimation).sequence;
			if (var3 != -1) {
				SequenceDefinition var2 = Widget.SequenceDefinition_get(var3);
				if (var2 != null && var2.frameIds != null) {
					++var0.spotAnimationFrameCycle;
					if (var0.spotAnimationFrame < var2.frameIds.length && var0.spotAnimationFrameCycle > var2.frameLengths[var0.spotAnimationFrame]) {
						var0.spotAnimationFrameCycle = 1;
						++var0.spotAnimationFrame;
						class325.addSequenceSoundEffect(var2, var0.spotAnimationFrame, var0.x, var0.y);
					}

					if (var0.spotAnimationFrame >= var2.frameIds.length && (var0.spotAnimationFrame < 0 || var0.spotAnimationFrame >= var2.frameIds.length)) {
						var0.spotAnimation = -1;
					}
				} else {
					var0.spotAnimation = -1;
				}
			} else {
				var0.spotAnimation = -1;
			}
		}

		if (var0.sequence != -1 && var0.sequenceDelay <= 1) {
			var1 = Widget.SequenceDefinition_get(var0.sequence);
			if (var1.field3506 == 1 && var0.field947 > 0 && var0.field941 <= Client.cycle && var0.field965 < Client.cycle) {
				var0.sequenceDelay = 1;
				return;
			}
		}

		if (var0.sequence != -1 && var0.sequenceDelay == 0) {
			var1 = Widget.SequenceDefinition_get(var0.sequence);
			if (var1 != null && var1.frameIds != null) {
				++var0.sequenceFrameCycle;
				if (var0.sequenceFrame < var1.frameIds.length && var0.sequenceFrameCycle > var1.frameLengths[var0.sequenceFrame]) {
					var0.sequenceFrameCycle = 1;
					++var0.sequenceFrame;
					class325.addSequenceSoundEffect(var1, var0.sequenceFrame, var0.x, var0.y);
				}

				if (var0.sequenceFrame >= var1.frameIds.length) {
					var0.sequenceFrame -= var1.frameCount;
					++var0.field964;
					if (var0.field964 >= var1.field3502) {
						var0.sequence = -1;
					} else if (var0.sequenceFrame >= 0 && var0.sequenceFrame < var1.frameIds.length) {
						class325.addSequenceSoundEffect(var1, var0.sequenceFrame, var0.x, var0.y);
					} else {
						var0.sequence = -1;
					}
				}

				var0.isWalking = var1.field3501;
			} else {
				var0.sequence = -1;
			}
		}

		if (var0.sequenceDelay > 0) {
			--var0.sequenceDelay;
		}

	}

	@ObfuscatedName("hh")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1895114197"
	)
	@Export("calculateMenuBounds")
	static void calculateMenuBounds() {
		WorldMapData_1.calculateMenuBounds(World.menuWidth / 2 + MilliClock.menuX, class96.menuY);
	}

	@ObfuscatedName("iu")
	@ObfuscatedSignature(
		signature = "(IIIZI)V",
		garbageValue = "1199898430"
	)
	@Export("resizeComponents")
	static final void resizeComponents(int var0, int var1, int var2, boolean var3) {
		if (Projectile.loadInterface(var0)) {
			ItemContainer.resizeInterface(Widget.Widget_interfaceComponents[var0], -1, var1, var2, var3);
		}
	}

	@ObfuscatedName("kc")
	@ObfuscatedSignature(
		signature = "(IIIILls;Lhg;I)V",
		garbageValue = "1652604393"
	)
	@Export("worldToMinimap")
	static final void worldToMinimap(int var0, int var1, int var2, int var3, Sprite var4, SpriteMask var5) {
		int var6 = var3 * var3 + var2 * var2;
		if (var6 > 4225 && var6 < 90000) {
			int var7 = Client.camAngleY & 2047;
			int var8 = Rasterizer3D.Rasterizer3D_sine[var7];
			int var9 = Rasterizer3D.Rasterizer3D_cosine[var7];
			int var10 = var9 * var2 + var3 * var8 >> 16;
			int var11 = var3 * var9 - var8 * var2 >> 16;
			double var12 = Math.atan2((double)var10, (double)var11);
			int var14 = var5.width / 2 - 25;
			int var15 = (int)(Math.sin(var12) * (double)var14);
			int var16 = (int)(Math.cos(var12) * (double)var14);
			byte var17 = 20;
			UserComparator3.redHintArrowSprite.method6022(var15 + (var0 + var5.width / 2 - var17 / 2), var5.height / 2 + var1 - var17 / 2 - var16 - 10, var17, var17, 15, 15, var12, 256);
		} else {
			class191.drawSpriteOnMinimap(var0, var1, var2, var3, var4, var5);
		}

	}
}
