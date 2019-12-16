import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("bl")
@Implements("Tiles")
public final class Tiles {
	@ObfuscatedName("qd")
	@ObfuscatedSignature(
		signature = "Lcy;"
	)
	@Export("pcmStreamMixer")
	static PcmStreamMixer pcmStreamMixer;
	@ObfuscatedName("f")
	@Export("Tiles_heights")
	static int[][][] Tiles_heights;
	@ObfuscatedName("i")
	@Export("Tiles_renderFlags")
	static byte[][][] Tiles_renderFlags;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = 1383080381
	)
	@Export("Tiles_minPlane")
	static int Tiles_minPlane;
	@ObfuscatedName("p")
	static byte[][][] field498;
	@ObfuscatedName("b")
	static byte[][][] field494;
	@ObfuscatedName("e")
	static byte[][][] field493;
	@ObfuscatedName("x")
	static byte[][][] field496;
	@ObfuscatedName("v")
	@Export("Tiles_hueMultiplier")
	static int[] Tiles_hueMultiplier;
	@ObfuscatedName("s")
	static int[][][] field501;
	@ObfuscatedName("n")
	static final int[] field499;
	@ObfuscatedName("u")
	static final int[] field500;
	@ObfuscatedName("z")
	static final int[] field506;
	@ObfuscatedName("h")
	static final int[] field502;
	@ObfuscatedName("m")
	static final int[] field503;
	@ObfuscatedName("g")
	static final int[] field504;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = -550988809
	)
	static int field505;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -2113033627
	)
	static int field492;

	static {
		Tiles_heights = new int[4][105][105];
		Tiles_renderFlags = new byte[4][104][104];
		Tiles_minPlane = 99;
		field499 = new int[]{1, 2, 4, 8};
		field500 = new int[]{16, 32, 64, 128};
		field506 = new int[]{1, 0, -1, 0};
		field502 = new int[]{0, -1, 0, 1};
		field503 = new int[]{1, -1, -1, 1};
		field504 = new int[]{-1, -1, 1, 1};
		field505 = (int)(Math.random() * 17.0D) - 8;
		field492 = (int)(Math.random() * 33.0D) - 16;
	}

	@ObfuscatedName("f")
	public static final int method1121(double var0, double var2, double var4) {
		double var6 = var4;
		double var8 = var4;
		double var10 = var4;
		if (var2 != 0.0D) {
			double var12;
			if (var4 < 0.5D) {
				var12 = var4 * (var2 + 1.0D);
			} else {
				var12 = var2 + var4 - var2 * var4;
			}

			double var14 = var4 * 2.0D - var12;
			double var16 = 0.3333333333333333D + var0;
			if (var16 > 1.0D) {
				--var16;
			}

			double var20 = var0 - 0.3333333333333333D;
			if (var20 < 0.0D) {
				++var20;
			}

			if (6.0D * var16 < 1.0D) {
				var6 = var14 + var16 * (var12 - var14) * 6.0D;
			} else if (var16 * 2.0D < 1.0D) {
				var6 = var12;
			} else if (3.0D * var16 < 2.0D) {
				var6 = var14 + (0.6666666666666666D - var16) * (var12 - var14) * 6.0D;
			} else {
				var6 = var14;
			}

			if (var0 * 6.0D < 1.0D) {
				var8 = var14 + (var12 - var14) * 6.0D * var0;
			} else if (var0 * 2.0D < 1.0D) {
				var8 = var12;
			} else if (var0 * 3.0D < 2.0D) {
				var8 = var14 + (0.6666666666666666D - var0) * (var12 - var14) * 6.0D;
			} else {
				var8 = var14;
			}

			if (6.0D * var20 < 1.0D) {
				var10 = var14 + 6.0D * (var12 - var14) * var20;
			} else if (2.0D * var20 < 1.0D) {
				var10 = var12;
			} else if (3.0D * var20 < 2.0D) {
				var10 = var14 + 6.0D * (0.6666666666666666D - var20) * (var12 - var14);
			} else {
				var10 = var14;
			}
		}

		int var22 = (int)(256.0D * var6);
		int var13 = (int)(var8 * 256.0D);
		int var23 = (int)(256.0D * var10);
		int var15 = var23 + (var13 << 8) + (var22 << 16);
		return var15;
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "([BI)Lcu;",
		garbageValue = "398974566"
	)
	@Export("newScript")
	static Script newScript(byte[] var0) {
		Script var1 = new Script();
		Buffer var2 = new Buffer(var0);
		var2.offset = var2.array.length - 2;
		int var3 = var2.readUnsignedShort();
		int var4 = var2.array.length - 2 - var3 - 12;
		var2.offset = var4;
		int var5 = var2.readInt();
		var1.localIntCount = var2.readUnsignedShort();
		var1.localStringCount = var2.readUnsignedShort();
		var1.intArgumentCount = var2.readUnsignedShort();
		var1.stringArgumentCount = var2.readUnsignedShort();
		int var6 = var2.readUnsignedByte();
		int var7;
		int var8;
		if (var6 > 0) {
			var1.switches = var1.newIterableNodeHashTable(var6);

			for (var7 = 0; var7 < var6; ++var7) {
				var8 = var2.readUnsignedShort();
				int var9;
				int var11;
				if (var8 > 0) {
					var11 = var8 - 1;
					var11 |= var11 >>> 1;
					var11 |= var11 >>> 2;
					var11 |= var11 >>> 4;
					var11 |= var11 >>> 8;
					var11 |= var11 >>> 16;
					int var10 = var11 + 1;
					var9 = var10;
				} else {
					var9 = 1;
				}

				IterableNodeHashTable var13 = new IterableNodeHashTable(var9);
				var1.switches[var7] = var13;

				while (var8-- > 0) {
					var11 = var2.readInt();
					int var12 = var2.readInt();
					var13.put(new IntegerNode(var12), (long)var11);
				}
			}
		}

		var2.offset = 0;
		var2.readStringCp1252NullTerminatedOrNull();
		var1.opcodes = new int[var5];
		var1.intOperands = new int[var5];
		var1.stringOperands = new String[var5];

		for (var7 = 0; var2.offset < var4; var1.opcodes[var7++] = var8) {
			var8 = var2.readUnsignedShort();
			if (var8 == 3) {
				var1.stringOperands[var7] = var2.readStringCp1252NullTerminated();
			} else if (var8 < 100 && var8 != 21 && var8 != 38 && var8 != 39) {
				var1.intOperands[var7] = var2.readInt();
			} else {
				var1.intOperands[var7] = var2.readUnsignedByte();
			}
		}

		return var1;
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "-2042821190"
	)
	static final void method1143(String var0) {
		class83.addGameMessage(30, "", var0);
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		signature = "(ILcu;ZI)I",
		garbageValue = "-697994458"
	)
	static int method1144(int var0, Script var1, boolean var2) {
		if (var0 == ScriptOpcodes.CHAT_GETFILTER_PUBLIC) {
			Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = Client.publicChatMode;
			return 1;
		} else if (var0 == ScriptOpcodes.CHAT_SETFILTER) {
			class188.Interpreter_intStackSize -= 3;
			Client.publicChatMode = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize];
			Calendar.privateChatMode = class50.method893(Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 1]);
			if (Calendar.privateChatMode == null) {
				Calendar.privateChatMode = PrivateChatMode.field3791;
			}

			Client.tradeChatMode = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 2];
			PacketBufferNode var18 = class2.getPacketBufferNode(ClientPacket.field2175, Client.packetWriter.isaacCipher);
			var18.packetBuffer.writeByte(Client.publicChatMode);
			var18.packetBuffer.writeByte(Calendar.privateChatMode.field3793);
			var18.packetBuffer.writeByte(Client.tradeChatMode);
			Client.packetWriter.addNode(var18);
			return 1;
		} else {
			String var3;
			int var4;
			if (var0 == ScriptOpcodes.CHAT_SENDABUSEREPORT) {
				var3 = Interpreter.Interpreter_stringStack[--class65.Interpreter_stringStackSize];
				class188.Interpreter_intStackSize -= 2;
				var4 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize];
				int var5 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 1];
				PacketBufferNode var6 = class2.getPacketBufferNode(ClientPacket.field2221, Client.packetWriter.isaacCipher);
				var6.packetBuffer.writeByte(ViewportMouse.stringCp1252NullTerminatedByteSize(var3) + 2);
				var6.packetBuffer.writeStringCp1252NullTerminated(var3);
				var6.packetBuffer.writeByte(var4 - 1);
				var6.packetBuffer.writeByte(var5);
				Client.packetWriter.addNode(var6);
				return 1;
			} else {
				int var10;
				if (var0 == ScriptOpcodes.CHAT_GETHISTORY_BYTYPEANDLINE) {
					class188.Interpreter_intStackSize -= 2;
					var10 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize];
					var4 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 1];
					Message var15 = class210.Messages_getByChannelAndID(var10, var4);
					if (var15 != null) {
						Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var15.count;
						Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var15.cycle;
						Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = var15.sender != null ? var15.sender : "";
						Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = var15.prefix != null ? var15.prefix : "";
						Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = var15.text != null ? var15.text : "";
						Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var15.isFromFriend() ? 1 : (var15.isFromIgnored() ? 2 : 0);
					} else {
						Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = -1;
						Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = 0;
						Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = "";
						Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = "";
						Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = "";
						Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else if (var0 == ScriptOpcodes.CHAT_GETHISTORY_BYUID) {
					var10 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
					Message var16 = LoginPacket.Messages_getMessage(var10);
					if (var16 != null) {
						Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var16.type;
						Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var16.cycle;
						Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = var16.sender != null ? var16.sender : "";
						Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = var16.prefix != null ? var16.prefix : "";
						Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = var16.text != null ? var16.text : "";
						Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var16.isFromFriend() ? 1 : (var16.isFromIgnored() ? 2 : 0);
					} else {
						Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = -1;
						Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = 0;
						Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = "";
						Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = "";
						Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = "";
						Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else if (var0 == ScriptOpcodes.CHAT_GETFILTER_PRIVATE) {
					if (Calendar.privateChatMode == null) {
						Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = -1;
					} else {
						Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = Calendar.privateChatMode.field3793;
					}

					return 1;
				} else if (var0 == ScriptOpcodes.CHAT_SENDPUBLIC) {
					var3 = Interpreter.Interpreter_stringStack[--class65.Interpreter_stringStackSize];
					var4 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
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
					} else if (Varps.clientLanguage != Language.Language_EN) {
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
					} else if (Varps.clientLanguage != Language.Language_EN) {
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

					PacketBufferNode var8 = class2.getPacketBufferNode(ClientPacket.field2249, Client.packetWriter.isaacCipher);
					var8.packetBuffer.writeByte(0);
					int var9 = var8.packetBuffer.offset;
					var8.packetBuffer.writeByte(var4);
					var8.packetBuffer.writeByte(var17);
					var8.packetBuffer.writeByte(var7);
					GrandExchangeOfferUnitPriceComparator.method122(var8.packetBuffer, var3);
					var8.packetBuffer.writeLengthByte(var8.packetBuffer.offset - var9);
					Client.packetWriter.addNode(var8);
					return 1;
				} else if (var0 == ScriptOpcodes.CHAT_SENDPRIVATE) {
					class65.Interpreter_stringStackSize -= 2;
					var3 = Interpreter.Interpreter_stringStack[class65.Interpreter_stringStackSize];
					String var12 = Interpreter.Interpreter_stringStack[class65.Interpreter_stringStackSize + 1];
					PacketBufferNode var11 = class2.getPacketBufferNode(ClientPacket.field2177, Client.packetWriter.isaacCipher);
					var11.packetBuffer.writeShort(0);
					int var13 = var11.packetBuffer.offset;
					var11.packetBuffer.writeStringCp1252NullTerminated(var3);
					GrandExchangeOfferUnitPriceComparator.method122(var11.packetBuffer, var12);
					var11.packetBuffer.writeLengthShort(var11.packetBuffer.offset - var13);
					Client.packetWriter.addNode(var11);
					return 1;
				} else if (var0 != ScriptOpcodes.CHAT_PLAYERNAME) {
					if (var0 == ScriptOpcodes.CHAT_GETFILTER_TRADE) {
						Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = Client.tradeChatMode;
						return 1;
					} else if (var0 == ScriptOpcodes.CHAT_GETHISTORYLENGTH) {
						var10 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
						Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = MouseHandler.Messages_getHistorySize(var10);
						return 1;
					} else if (var0 == ScriptOpcodes.CHAT_GETNEXTUID) {
						var10 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
						Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = WorldMapSection0.Messages_getNextChatID(var10);
						return 1;
					} else if (var0 == ScriptOpcodes.CHAT_GETPREVUID) {
						var10 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
						Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = AttackOption.Messages_getLastChatID(var10);
						return 1;
					} else if (var0 == ScriptOpcodes.DOCHEAT) {
						var3 = Interpreter.Interpreter_stringStack[--class65.Interpreter_stringStackSize];
						TaskHandler.doCheat(var3);
						return 1;
					} else if (var0 == ScriptOpcodes.CHAT_SETMESSAGEFILTER) {
						Client.field846 = Interpreter.Interpreter_stringStack[--class65.Interpreter_stringStackSize].toLowerCase().trim();
						return 1;
					} else if (var0 == ScriptOpcodes.CHAT_GETMESSAGEFILTER) {
						Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = Client.field846;
						return 1;
					} else if (var0 == ScriptOpcodes.DEBUGMES) {
						var3 = Interpreter.Interpreter_stringStack[--class65.Interpreter_stringStackSize];
						System.out.println(var3);
						return 1;
					} else {
						return 2;
					}
				} else {
					if (Message.localPlayer != null && Message.localPlayer.username != null) {
						var3 = Message.localPlayer.username.getName();
					} else {
						var3 = "";
					}

					Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = var3;
					return 1;
				}
			}
		}
	}
}
