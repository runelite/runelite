import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("bk")
@Implements("ClientPreferences")
public class ClientPreferences {
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -802793057
	)
	@Export("ClientPreferences_optionCount")
	static int ClientPreferences_optionCount;
	@ObfuscatedName("ef")
	@Export("worldHost")
	static String worldHost;
	@ObfuscatedName("e")
	@Export("roofsHidden")
	boolean roofsHidden;
	@ObfuscatedName("p")
	@Export("titleMusicDisabled")
	boolean titleMusicDisabled;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -1863029767
	)
	@Export("windowMode")
	int windowMode;
	@ObfuscatedName("l")
	@Export("rememberedUsername")
	String rememberedUsername;
	@ObfuscatedName("b")
	@Export("hideUsername")
	boolean hideUsername;
	@ObfuscatedName("i")
	@Export("parameters")
	LinkedHashMap parameters;

	static {
		ClientPreferences_optionCount = 6;
	}

	ClientPreferences() {
		this.windowMode = 1;
		this.rememberedUsername = null;
		this.hideUsername = false;
		this.parameters = new LinkedHashMap();
		this.method1749(true);
	}

	@ObfuscatedSignature(
		signature = "(Lkf;)V"
	)
	ClientPreferences(Buffer var1) {
		this.windowMode = 1;
		this.rememberedUsername = null;
		this.hideUsername = false;
		this.parameters = new LinkedHashMap();
		if (var1 != null && var1.array != null) {
			int var2 = var1.readUnsignedByte();
			if (var2 >= 0 && var2 <= ClientPreferences_optionCount) {
				if (var1.readUnsignedByte() == 1) {
					this.roofsHidden = true;
				}

				if (var2 > 1) {
					this.titleMusicDisabled = var1.readUnsignedByte() == 1;
				}

				if (var2 > 3) {
					this.windowMode = var1.readUnsignedByte();
				}

				if (var2 > 2) {
					int var3 = var1.readUnsignedByte();

					for (int var4 = 0; var4 < var3; ++var4) {
						int var5 = var1.readInt();
						int var6 = var1.readInt();
						this.parameters.put(var5, var6);
					}
				}

				if (var2 > 4) {
					this.rememberedUsername = var1.readStringCp1252NullTerminatedOrNull();
				}

				if (var2 > 5) {
					this.hideUsername = var1.readBoolean();
				}
			} else {
				this.method1749(true);
			}
		} else {
			this.method1749(true);
		}

	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(ZS)V",
		garbageValue = "-11262"
	)
	void method1749(boolean var1) {
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(I)Lkf;",
		garbageValue = "-2138331500"
	)
	@Export("toBuffer")
	Buffer toBuffer() {
		Buffer var1 = new Buffer(100);
		var1.writeByte(ClientPreferences_optionCount);
		var1.writeByte(this.roofsHidden ? 1 : 0);
		var1.writeByte(this.titleMusicDisabled ? 1 : 0);
		var1.writeByte(this.windowMode);
		var1.writeByte(this.parameters.size());
		Iterator var2 = this.parameters.entrySet().iterator();

		while (var2.hasNext()) {
			Entry var3 = (Entry)var2.next();
			var1.writeInt((Integer)var3.getKey());
			var1.writeInt((Integer)var3.getValue());
		}

		var1.writeStringCp1252NullTerminated(this.rememberedUsername != null ? this.rememberedUsername : "");
		var1.writeBoolean(this.hideUsername);
		return var1;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "([BIII)Ljava/lang/String;",
		garbageValue = "917330802"
	)
	public static String method1755(byte[] var0, int var1, int var2) {
		char[] var3 = new char[var2];
		int var4 = 0;
		int var5 = var1;

		int var8;
		for (int var6 = var2 + var1; var5 < var6; var3[var4++] = (char)var8) {
			int var7 = var0[var5++] & 255;
			if (var7 < 128) {
				if (var7 == 0) {
					var8 = 65533;
				} else {
					var8 = var7;
				}
			} else if (var7 < 192) {
				var8 = 65533;
			} else if (var7 < 224) {
				if (var5 < var6 && (var0[var5] & 192) == 128) {
					var8 = (var7 & 31) << 6 | var0[var5++] & 63;
					if (var8 < 128) {
						var8 = 65533;
					}
				} else {
					var8 = 65533;
				}
			} else if (var7 < 240) {
				if (var5 + 1 < var6 && (var0[var5] & 192) == 128 && (var0[var5 + 1] & 192) == 128) {
					var8 = (var7 & 15) << 12 | (var0[var5++] & 63) << 6 | var0[var5++] & 63;
					if (var8 < 2048) {
						var8 = 65533;
					}
				} else {
					var8 = 65533;
				}
			} else if (var7 < 248) {
				if (var5 + 2 < var6 && (var0[var5] & 192) == 128 && (var0[var5 + 1] & 192) == 128 && (var0[var5 + 2] & 192) == 128) {
					var8 = (var7 & 7) << 18 | (var0[var5++] & 63) << 12 | (var0[var5++] & 63) << 6 | var0[var5++] & 63;
					if (var8 >= 65536 && var8 <= 1114111) {
						var8 = 65533;
					} else {
						var8 = 65533;
					}
				} else {
					var8 = 65533;
				}
			} else {
				var8 = 65533;
			}
		}

		return new String(var3, 0, var4);
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(II)Ljava/lang/String;",
		garbageValue = "-844505624"
	)
	@Export("colorStartTag")
	static String colorStartTag(int var0) {
		return "<col=" + Integer.toHexString(var0) + ">";
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(IIB)I",
		garbageValue = "-46"
	)
	public static int method1757(int var0, int var1) {
		int var2;
		for (var2 = 0; var1 > 0; --var1) {
			var2 = var2 << 1 | var0 & 1;
			var0 >>>= 1;
		}

		return var2;
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		signature = "(ILcx;ZB)I",
		garbageValue = "-94"
	)
	static int method1753(int var0, Script var1, boolean var2) {
		if (var0 == ScriptOpcodes.CHAT_GETFILTER_PUBLIC) {
			Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = Client.publicChatMode;
			return 1;
		} else if (var0 == ScriptOpcodes.CHAT_SETFILTER) {
			HealthBarUpdate.Interpreter_intStackSize -= 3;
			Client.publicChatMode = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize];
			class226.field3072 = NetSocket.method3530(Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 1]);
			if (class226.field3072 == null) {
				class226.field3072 = class310.field3816;
			}

			Client.field872 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 2];
			PacketBufferNode var18 = Archive.method4265(ClientPacket.field2294, Client.packetWriter.isaacCipher);
			var18.packetBuffer.writeByte(Client.publicChatMode);
			var18.packetBuffer.writeByte(class226.field3072.field3815);
			var18.packetBuffer.writeByte(Client.field872);
			Client.packetWriter.method2219(var18);
			return 1;
		} else {
			String var3;
			int var4;
			if (var0 == ScriptOpcodes.CHAT_SENDABUSEREPORT) {
				var3 = Interpreter.Interpreter_stringStack[--Skills.Interpreter_stringStackSize];
				HealthBarUpdate.Interpreter_intStackSize -= 2;
				var4 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize];
				int var5 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 1];
				PacketBufferNode var6 = Archive.method4265(ClientPacket.field2205, Client.packetWriter.isaacCipher);
				var6.packetBuffer.writeByte(Huffman.stringCp1252NullTerminatedByteSize(var3) + 2);
				var6.packetBuffer.writeStringCp1252NullTerminated(var3);
				var6.packetBuffer.writeByte(var4 - 1);
				var6.packetBuffer.writeByte(var5);
				Client.packetWriter.method2219(var6);
				return 1;
			} else {
				int var10;
				if (var0 == ScriptOpcodes.CHAT_GETHISTORY_BYTYPEANDLINE) {
					HealthBarUpdate.Interpreter_intStackSize -= 2;
					var10 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize];
					var4 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 1];
					Message var15 = GroundItem.method2049(var10, var4);
					if (var15 != null) {
						Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var15.count;
						Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var15.cycle;
						Interpreter.Interpreter_stringStack[++Skills.Interpreter_stringStackSize - 1] = var15.sender != null ? var15.sender : "";
						Interpreter.Interpreter_stringStack[++Skills.Interpreter_stringStackSize - 1] = var15.prefix != null ? var15.prefix : "";
						Interpreter.Interpreter_stringStack[++Skills.Interpreter_stringStackSize - 1] = var15.text != null ? var15.text : "";
						Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var15.isFromFriend() ? 1 : (var15.isFromIgnored() ? 2 : 0);
					} else {
						Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = -1;
						Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = 0;
						Interpreter.Interpreter_stringStack[++Skills.Interpreter_stringStackSize - 1] = "";
						Interpreter.Interpreter_stringStack[++Skills.Interpreter_stringStackSize - 1] = "";
						Interpreter.Interpreter_stringStack[++Skills.Interpreter_stringStackSize - 1] = "";
						Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else if (var0 == ScriptOpcodes.CHAT_GETHISTORY_BYUID) {
					var10 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
					Message var16 = WorldMapIcon_1.method297(var10);
					if (var16 != null) {
						Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var16.type;
						Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var16.cycle;
						Interpreter.Interpreter_stringStack[++Skills.Interpreter_stringStackSize - 1] = var16.sender != null ? var16.sender : "";
						Interpreter.Interpreter_stringStack[++Skills.Interpreter_stringStackSize - 1] = var16.prefix != null ? var16.prefix : "";
						Interpreter.Interpreter_stringStack[++Skills.Interpreter_stringStackSize - 1] = var16.text != null ? var16.text : "";
						Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var16.isFromFriend() ? 1 : (var16.isFromIgnored() ? 2 : 0);
					} else {
						Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = -1;
						Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = 0;
						Interpreter.Interpreter_stringStack[++Skills.Interpreter_stringStackSize - 1] = "";
						Interpreter.Interpreter_stringStack[++Skills.Interpreter_stringStackSize - 1] = "";
						Interpreter.Interpreter_stringStack[++Skills.Interpreter_stringStackSize - 1] = "";
						Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else if (var0 == ScriptOpcodes.CHAT_GETFILTER_PRIVATE) {
					if (class226.field3072 == null) {
						Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = -1;
					} else {
						Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = class226.field3072.field3815;
					}

					return 1;
				} else if (var0 == ScriptOpcodes.CHAT_SENDPUBLIC) {
					var3 = Interpreter.Interpreter_stringStack[--Skills.Interpreter_stringStackSize];
					var4 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
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
					} else if (ScriptFrame.field528 != class190.field2348) {
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
					} else if (class190.field2348 != ScriptFrame.field528) {
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

					PacketBufferNode var8 = Archive.method4265(ClientPacket.field2258, Client.packetWriter.isaacCipher);
					var8.packetBuffer.writeByte(0);
					int var9 = var8.packetBuffer.offset;
					var8.packetBuffer.writeByte(var4);
					var8.packetBuffer.writeByte(var17);
					var8.packetBuffer.writeByte(var7);
					Skeleton.method3063(var8.packetBuffer, var3);
					var8.packetBuffer.writeLengthByte(var8.packetBuffer.offset - var9);
					Client.packetWriter.method2219(var8);
					return 1;
				} else if (var0 == ScriptOpcodes.CHAT_SENDPRIVATE) {
					Skills.Interpreter_stringStackSize -= 2;
					var3 = Interpreter.Interpreter_stringStack[Skills.Interpreter_stringStackSize];
					String var12 = Interpreter.Interpreter_stringStack[Skills.Interpreter_stringStackSize + 1];
					PacketBufferNode var11 = Archive.method4265(ClientPacket.field2228, Client.packetWriter.isaacCipher);
					var11.packetBuffer.writeShort(0);
					int var13 = var11.packetBuffer.offset;
					var11.packetBuffer.writeStringCp1252NullTerminated(var3);
					Skeleton.method3063(var11.packetBuffer, var12);
					var11.packetBuffer.writeLengthShort(var11.packetBuffer.offset - var13);
					Client.packetWriter.method2219(var11);
					return 1;
				} else if (var0 != ScriptOpcodes.CHAT_PLAYERNAME) {
					if (var0 == ScriptOpcodes.CHAT_GETFILTER_TRADE) {
						Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = Client.field872;
						return 1;
					} else if (var0 == ScriptOpcodes.CHAT_GETHISTORYLENGTH) {
						var10 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
						Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = LoginScreenAnimation.method1744(var10);
						return 1;
					} else if (var0 == ScriptOpcodes.CHAT_GETNEXTUID) {
						var10 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
						Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = MusicPatchNode2.method3686(var10);
						return 1;
					} else if (var0 == ScriptOpcodes.CHAT_GETPREVUID) {
						var10 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
						Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = class192.method3669(var10);
						return 1;
					} else if (var0 == ScriptOpcodes.DOCHEAT) {
						var3 = Interpreter.Interpreter_stringStack[--Skills.Interpreter_stringStackSize];
						UserComparator1.doCheat(var3);
						return 1;
					} else if (var0 == ScriptOpcodes.CHAT_SETMESSAGEFILTER) {
						Client.field762 = Interpreter.Interpreter_stringStack[--Skills.Interpreter_stringStackSize].toLowerCase().trim();
						return 1;
					} else if (var0 == ScriptOpcodes.CHAT_GETMESSAGEFILTER) {
						Interpreter.Interpreter_stringStack[++Skills.Interpreter_stringStackSize - 1] = Client.field762;
						return 1;
					} else if (var0 == 5023) {
						var3 = Interpreter.Interpreter_stringStack[--Skills.Interpreter_stringStackSize];
						System.out.println(var3);
						return 1;
					} else {
						return 2;
					}
				} else {
					if (Client.localPlayer != null && Client.localPlayer.username != null) {
						var3 = Client.localPlayer.username.getName();
					} else {
						var3 = "";
					}

					Interpreter.Interpreter_stringStack[++Skills.Interpreter_stringStackSize - 1] = var3;
					return 1;
				}
			}
		}
	}
}
