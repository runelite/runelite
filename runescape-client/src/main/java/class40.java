import java.io.IOException;
import java.net.Socket;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("ae")
public class class40 {
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = -359946727
	)
	@Export("pixelsPerTile")
	int pixelsPerTile;
	@ObfuscatedName("t")
	@Export("tileTemplates")
	byte[][][] tileTemplates;

	class40(int var1) {
		this.pixelsPerTile = var1;
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(IIIIIIIII)V",
		garbageValue = "519041522"
	)
	void method798(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
		if (var7 != 0 && this.pixelsPerTile != 0 && this.tileTemplates != null) {
			var8 = this.method799(var8, var7);
			var7 = this.method838(var7);
			Rasterizer2D.Rasterizer2D_drawGradientPixels(var1, var2, var5, var6, var3, var4, this.tileTemplates[var7 - 1][var8], this.pixelsPerTile);
		}
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "869171029"
	)
	int method799(int var1, int var2) {
		if (var2 == 9) {
			var1 = var1 + 1 & 3;
		}

		if (var2 == 10) {
			var1 = var1 + 3 & 3;
		}

		if (var2 == 11) {
			var1 = var1 + 3 & 3;
		}

		return var1;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "2011840456"
	)
	int method838(int var1) {
		if (var1 != 9 && var1 != 10) {
			return var1 == 11 ? 8 : var1;
		} else {
			return 1;
		}
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-73707874"
	)
	@Export("init")
	void init() {
		if (this.tileTemplates == null) {
			this.tileTemplates = new byte[8][4][];
			this.init0();
			this.init1();
			this.init2();
			this.init3();
			this.init4();
			this.init5();
			this.init6();
			this.init7();
		}
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-413581425"
	)
	@Export("init0")
	void init0() {
		byte[] var1 = new byte[this.pixelsPerTile * this.pixelsPerTile];
		int var2 = 0;

		int var3;
		int var4;
		for (var3 = 0; var3 < this.pixelsPerTile; ++var3) {
			for (var4 = 0; var4 < this.pixelsPerTile; ++var4) {
				if (var4 <= var3) {
					var1[var2] = -1;
				}

				++var2;
			}
		}

		this.tileTemplates[0][0] = var1;
		var1 = new byte[this.pixelsPerTile * this.pixelsPerTile];
		var2 = 0;

		for (var3 = this.pixelsPerTile - 1; var3 >= 0; --var3) {
			for (var4 = 0; var4 < this.pixelsPerTile; ++var4) {
				if (var4 <= var3) {
					var1[var2] = -1;
				}

				++var2;
			}
		}

		this.tileTemplates[0][1] = var1;
		var1 = new byte[this.pixelsPerTile * this.pixelsPerTile];
		var2 = 0;

		for (var3 = 0; var3 < this.pixelsPerTile; ++var3) {
			for (var4 = 0; var4 < this.pixelsPerTile; ++var4) {
				if (var4 >= var3) {
					var1[var2] = -1;
				}

				++var2;
			}
		}

		this.tileTemplates[0][2] = var1;
		var1 = new byte[this.pixelsPerTile * this.pixelsPerTile];
		var2 = 0;

		for (var3 = this.pixelsPerTile - 1; var3 >= 0; --var3) {
			for (var4 = 0; var4 < this.pixelsPerTile; ++var4) {
				if (var4 >= var3) {
					var1[var2] = -1;
				}

				++var2;
			}
		}

		this.tileTemplates[0][3] = var1;
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "2134890825"
	)
	@Export("init1")
	void init1() {
		byte[] var1 = new byte[this.pixelsPerTile * this.pixelsPerTile];
		int var2 = 0;

		int var3;
		int var4;
		for (var3 = this.pixelsPerTile - 1; var3 >= 0; --var3) {
			for (var4 = 0; var4 < this.pixelsPerTile; ++var4) {
				if (var4 <= var3 >> 1) {
					var1[var2] = -1;
				}

				++var2;
			}
		}

		this.tileTemplates[1][0] = var1;
		var1 = new byte[this.pixelsPerTile * this.pixelsPerTile];
		var2 = 0;

		for (var3 = 0; var3 < this.pixelsPerTile; ++var3) {
			for (var4 = 0; var4 < this.pixelsPerTile; ++var4) {
				if (var2 >= 0 && var2 < var1.length) {
					if (var4 >= var3 << 1) {
						var1[var2] = -1;
					}

					++var2;
				} else {
					++var2;
				}
			}
		}

		this.tileTemplates[1][1] = var1;
		var1 = new byte[this.pixelsPerTile * this.pixelsPerTile];
		var2 = 0;

		for (var3 = 0; var3 < this.pixelsPerTile; ++var3) {
			for (var4 = this.pixelsPerTile - 1; var4 >= 0; --var4) {
				if (var4 <= var3 >> 1) {
					var1[var2] = -1;
				}

				++var2;
			}
		}

		this.tileTemplates[1][2] = var1;
		var1 = new byte[this.pixelsPerTile * this.pixelsPerTile];
		var2 = 0;

		for (var3 = this.pixelsPerTile - 1; var3 >= 0; --var3) {
			for (var4 = this.pixelsPerTile - 1; var4 >= 0; --var4) {
				if (var4 >= var3 << 1) {
					var1[var2] = -1;
				}

				++var2;
			}
		}

		this.tileTemplates[1][3] = var1;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1327235203"
	)
	@Export("init2")
	void init2() {
		byte[] var1 = new byte[this.pixelsPerTile * this.pixelsPerTile];
		int var2 = 0;

		int var3;
		int var4;
		for (var3 = this.pixelsPerTile - 1; var3 >= 0; --var3) {
			for (var4 = this.pixelsPerTile - 1; var4 >= 0; --var4) {
				if (var4 <= var3 >> 1) {
					var1[var2] = -1;
				}

				++var2;
			}
		}

		this.tileTemplates[2][0] = var1;
		var1 = new byte[this.pixelsPerTile * this.pixelsPerTile];
		var2 = 0;

		for (var3 = this.pixelsPerTile - 1; var3 >= 0; --var3) {
			for (var4 = 0; var4 < this.pixelsPerTile; ++var4) {
				if (var4 >= var3 << 1) {
					var1[var2] = -1;
				}

				++var2;
			}
		}

		this.tileTemplates[2][1] = var1;
		var1 = new byte[this.pixelsPerTile * this.pixelsPerTile];
		var2 = 0;

		for (var3 = 0; var3 < this.pixelsPerTile; ++var3) {
			for (var4 = 0; var4 < this.pixelsPerTile; ++var4) {
				if (var4 <= var3 >> 1) {
					var1[var2] = -1;
				}

				++var2;
			}
		}

		this.tileTemplates[2][2] = var1;
		var1 = new byte[this.pixelsPerTile * this.pixelsPerTile];
		var2 = 0;

		for (var3 = 0; var3 < this.pixelsPerTile; ++var3) {
			for (var4 = this.pixelsPerTile - 1; var4 >= 0; --var4) {
				if (var4 >= var3 << 1) {
					var1[var2] = -1;
				}

				++var2;
			}
		}

		this.tileTemplates[2][3] = var1;
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1955000342"
	)
	@Export("init3")
	void init3() {
		byte[] var1 = new byte[this.pixelsPerTile * this.pixelsPerTile];
		int var2 = 0;

		int var3;
		int var4;
		for (var3 = this.pixelsPerTile - 1; var3 >= 0; --var3) {
			for (var4 = 0; var4 < this.pixelsPerTile; ++var4) {
				if (var4 >= var3 >> 1) {
					var1[var2] = -1;
				}

				++var2;
			}
		}

		this.tileTemplates[3][0] = var1;
		var1 = new byte[this.pixelsPerTile * this.pixelsPerTile];
		var2 = 0;

		for (var3 = 0; var3 < this.pixelsPerTile; ++var3) {
			for (var4 = 0; var4 < this.pixelsPerTile; ++var4) {
				if (var4 <= var3 << 1) {
					var1[var2] = -1;
				}

				++var2;
			}
		}

		this.tileTemplates[3][1] = var1;
		var1 = new byte[this.pixelsPerTile * this.pixelsPerTile];
		var2 = 0;

		for (var3 = 0; var3 < this.pixelsPerTile; ++var3) {
			for (var4 = this.pixelsPerTile - 1; var4 >= 0; --var4) {
				if (var4 >= var3 >> 1) {
					var1[var2] = -1;
				}

				++var2;
			}
		}

		this.tileTemplates[3][2] = var1;
		var1 = new byte[this.pixelsPerTile * this.pixelsPerTile];
		var2 = 0;

		for (var3 = this.pixelsPerTile - 1; var3 >= 0; --var3) {
			for (var4 = this.pixelsPerTile - 1; var4 >= 0; --var4) {
				if (var4 <= var3 << 1) {
					var1[var2] = -1;
				}

				++var2;
			}
		}

		this.tileTemplates[3][3] = var1;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "1"
	)
	@Export("init4")
	void init4() {
		byte[] var1 = new byte[this.pixelsPerTile * this.pixelsPerTile];
		int var2 = 0;

		int var3;
		int var4;
		for (var3 = this.pixelsPerTile - 1; var3 >= 0; --var3) {
			for (var4 = this.pixelsPerTile - 1; var4 >= 0; --var4) {
				if (var4 >= var3 >> 1) {
					var1[var2] = -1;
				}

				++var2;
			}
		}

		this.tileTemplates[4][0] = var1;
		var1 = new byte[this.pixelsPerTile * this.pixelsPerTile];
		var2 = 0;

		for (var3 = this.pixelsPerTile - 1; var3 >= 0; --var3) {
			for (var4 = 0; var4 < this.pixelsPerTile; ++var4) {
				if (var4 <= var3 << 1) {
					var1[var2] = -1;
				}

				++var2;
			}
		}

		this.tileTemplates[4][1] = var1;
		var1 = new byte[this.pixelsPerTile * this.pixelsPerTile];
		var2 = 0;

		for (var3 = 0; var3 < this.pixelsPerTile; ++var3) {
			for (var4 = 0; var4 < this.pixelsPerTile; ++var4) {
				if (var4 >= var3 >> 1) {
					var1[var2] = -1;
				}

				++var2;
			}
		}

		this.tileTemplates[4][2] = var1;
		var1 = new byte[this.pixelsPerTile * this.pixelsPerTile];
		var2 = 0;

		for (var3 = 0; var3 < this.pixelsPerTile; ++var3) {
			for (var4 = this.pixelsPerTile - 1; var4 >= 0; --var4) {
				if (var4 <= var3 << 1) {
					var1[var2] = -1;
				}

				++var2;
			}
		}

		this.tileTemplates[4][3] = var1;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1524084830"
	)
	@Export("init5")
	void init5() {
		byte[] var1 = new byte[this.pixelsPerTile * this.pixelsPerTile];
		boolean var2 = false;
		var1 = new byte[this.pixelsPerTile * this.pixelsPerTile];
		int var5 = 0;

		int var3;
		int var4;
		for (var3 = 0; var3 < this.pixelsPerTile; ++var3) {
			for (var4 = 0; var4 < this.pixelsPerTile; ++var4) {
				if (var4 <= this.pixelsPerTile / 2) {
					var1[var5] = -1;
				}

				++var5;
			}
		}

		this.tileTemplates[5][0] = var1;
		var1 = new byte[this.pixelsPerTile * this.pixelsPerTile];
		var5 = 0;

		for (var3 = 0; var3 < this.pixelsPerTile; ++var3) {
			for (var4 = 0; var4 < this.pixelsPerTile; ++var4) {
				if (var3 <= this.pixelsPerTile / 2) {
					var1[var5] = -1;
				}

				++var5;
			}
		}

		this.tileTemplates[5][1] = var1;
		var1 = new byte[this.pixelsPerTile * this.pixelsPerTile];
		var5 = 0;

		for (var3 = 0; var3 < this.pixelsPerTile; ++var3) {
			for (var4 = 0; var4 < this.pixelsPerTile; ++var4) {
				if (var4 >= this.pixelsPerTile / 2) {
					var1[var5] = -1;
				}

				++var5;
			}
		}

		this.tileTemplates[5][2] = var1;
		var1 = new byte[this.pixelsPerTile * this.pixelsPerTile];
		var5 = 0;

		for (var3 = 0; var3 < this.pixelsPerTile; ++var3) {
			for (var4 = 0; var4 < this.pixelsPerTile; ++var4) {
				if (var3 >= this.pixelsPerTile / 2) {
					var1[var5] = -1;
				}

				++var5;
			}
		}

		this.tileTemplates[5][3] = var1;
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "792481241"
	)
	@Export("init6")
	void init6() {
		byte[] var1 = new byte[this.pixelsPerTile * this.pixelsPerTile];
		boolean var2 = false;
		var1 = new byte[this.pixelsPerTile * this.pixelsPerTile];
		int var5 = 0;

		int var3;
		int var4;
		for (var3 = 0; var3 < this.pixelsPerTile; ++var3) {
			for (var4 = 0; var4 < this.pixelsPerTile; ++var4) {
				if (var4 <= var3 - this.pixelsPerTile / 2) {
					var1[var5] = -1;
				}

				++var5;
			}
		}

		this.tileTemplates[6][0] = var1;
		var1 = new byte[this.pixelsPerTile * this.pixelsPerTile];
		var5 = 0;

		for (var3 = this.pixelsPerTile - 1; var3 >= 0; --var3) {
			for (var4 = 0; var4 < this.pixelsPerTile; ++var4) {
				if (var4 <= var3 - this.pixelsPerTile / 2) {
					var1[var5] = -1;
				}

				++var5;
			}
		}

		this.tileTemplates[6][1] = var1;
		var1 = new byte[this.pixelsPerTile * this.pixelsPerTile];
		var5 = 0;

		for (var3 = this.pixelsPerTile - 1; var3 >= 0; --var3) {
			for (var4 = this.pixelsPerTile - 1; var4 >= 0; --var4) {
				if (var4 <= var3 - this.pixelsPerTile / 2) {
					var1[var5] = -1;
				}

				++var5;
			}
		}

		this.tileTemplates[6][2] = var1;
		var1 = new byte[this.pixelsPerTile * this.pixelsPerTile];
		var5 = 0;

		for (var3 = 0; var3 < this.pixelsPerTile; ++var3) {
			for (var4 = this.pixelsPerTile - 1; var4 >= 0; --var4) {
				if (var4 <= var3 - this.pixelsPerTile / 2) {
					var1[var5] = -1;
				}

				++var5;
			}
		}

		this.tileTemplates[6][3] = var1;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "401274730"
	)
	@Export("init7")
	void init7() {
		byte[] var1 = new byte[this.pixelsPerTile * this.pixelsPerTile];
		boolean var2 = false;
		var1 = new byte[this.pixelsPerTile * this.pixelsPerTile];
		int var5 = 0;

		int var3;
		int var4;
		for (var3 = 0; var3 < this.pixelsPerTile; ++var3) {
			for (var4 = 0; var4 < this.pixelsPerTile; ++var4) {
				if (var4 >= var3 - this.pixelsPerTile / 2) {
					var1[var5] = -1;
				}

				++var5;
			}
		}

		this.tileTemplates[7][0] = var1;
		var1 = new byte[this.pixelsPerTile * this.pixelsPerTile];
		var5 = 0;

		for (var3 = this.pixelsPerTile - 1; var3 >= 0; --var3) {
			for (var4 = 0; var4 < this.pixelsPerTile; ++var4) {
				if (var4 >= var3 - this.pixelsPerTile / 2) {
					var1[var5] = -1;
				}

				++var5;
			}
		}

		this.tileTemplates[7][1] = var1;
		var1 = new byte[this.pixelsPerTile * this.pixelsPerTile];
		var5 = 0;

		for (var3 = this.pixelsPerTile - 1; var3 >= 0; --var3) {
			for (var4 = this.pixelsPerTile - 1; var4 >= 0; --var4) {
				if (var4 >= var3 - this.pixelsPerTile / 2) {
					var1[var5] = -1;
				}

				++var5;
			}
		}

		this.tileTemplates[7][2] = var1;
		var1 = new byte[this.pixelsPerTile * this.pixelsPerTile];
		var5 = 0;

		for (var3 = 0; var3 < this.pixelsPerTile; ++var3) {
			for (var4 = this.pixelsPerTile - 1; var4 >= 0; --var4) {
				if (var4 >= var3 - this.pixelsPerTile / 2) {
					var1[var5] = -1;
				}

				++var5;
			}
		}

		this.tileTemplates[7][3] = var1;
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		signature = "(Ljava/net/Socket;III)Lku;",
		garbageValue = "477889440"
	)
	public static AbstractSocket method839(Socket var0, int var1, int var2) throws IOException {
		return new BufferedNetSocket(var0, var1, var2);
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		signature = "(ILcj;ZB)I",
		garbageValue = "-72"
	)
	static int method837(int var0, Script var1, boolean var2) {
		if (var0 == ScriptOpcodes.CHAT_GETFILTER_PUBLIC) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.publicChatMode;
			return 1;
		} else if (var0 == ScriptOpcodes.CHAT_SETFILTER) {
			Interpreter.Interpreter_intStackSize -= 3;
			Client.publicChatMode = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
			class3.privateChatMode = NPCDefinition.method4881(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]);
			if (class3.privateChatMode == null) {
				class3.privateChatMode = PrivateChatMode.field3779;
			}

			Client.tradeChatMode = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
			PacketBufferNode var18 = SoundSystem.getPacketBufferNode(ClientPacket.field2256, Client.packetWriter.isaacCipher);
			var18.packetBuffer.writeByte(Client.publicChatMode);
			var18.packetBuffer.writeByte(class3.privateChatMode.field3781);
			var18.packetBuffer.writeByte(Client.tradeChatMode);
			Client.packetWriter.addNode(var18);
			return 1;
		} else {
			String var3;
			int var4;
			if (var0 == ScriptOpcodes.CHAT_SENDABUSEREPORT) {
				var3 = Interpreter.Interpreter_stringStack[--WorldMapDecoration.Interpreter_stringStackSize];
				Interpreter.Interpreter_intStackSize -= 2;
				var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
				int var5 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
				PacketBufferNode var6 = SoundSystem.getPacketBufferNode(ClientPacket.field2204, Client.packetWriter.isaacCipher);
				var6.packetBuffer.writeByte(UserComparator6.stringCp1252NullTerminatedByteSize(var3) + 2);
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
					Message var15 = WallDecoration.Messages_getByChannelAndID(var10, var4);
					if (var15 != null) {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var15.count;
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var15.cycle;
						Interpreter.Interpreter_stringStack[++WorldMapDecoration.Interpreter_stringStackSize - 1] = var15.sender != null ? var15.sender : "";
						Interpreter.Interpreter_stringStack[++WorldMapDecoration.Interpreter_stringStackSize - 1] = var15.prefix != null ? var15.prefix : "";
						Interpreter.Interpreter_stringStack[++WorldMapDecoration.Interpreter_stringStackSize - 1] = var15.text != null ? var15.text : "";
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var15.isFromFriend() ? 1 : (var15.isFromIgnored() ? 2 : 0);
					} else {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
						Interpreter.Interpreter_stringStack[++WorldMapDecoration.Interpreter_stringStackSize - 1] = "";
						Interpreter.Interpreter_stringStack[++WorldMapDecoration.Interpreter_stringStackSize - 1] = "";
						Interpreter.Interpreter_stringStack[++WorldMapDecoration.Interpreter_stringStackSize - 1] = "";
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else if (var0 == ScriptOpcodes.CHAT_GETHISTORY_BYUID) {
					var10 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
					Message var16 = WorldMapIcon_1.Messages_getMessage(var10);
					if (var16 != null) {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var16.type;
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var16.cycle;
						Interpreter.Interpreter_stringStack[++WorldMapDecoration.Interpreter_stringStackSize - 1] = var16.sender != null ? var16.sender : "";
						Interpreter.Interpreter_stringStack[++WorldMapDecoration.Interpreter_stringStackSize - 1] = var16.prefix != null ? var16.prefix : "";
						Interpreter.Interpreter_stringStack[++WorldMapDecoration.Interpreter_stringStackSize - 1] = var16.text != null ? var16.text : "";
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var16.isFromFriend() ? 1 : (var16.isFromIgnored() ? 2 : 0);
					} else {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
						Interpreter.Interpreter_stringStack[++WorldMapDecoration.Interpreter_stringStackSize - 1] = "";
						Interpreter.Interpreter_stringStack[++WorldMapDecoration.Interpreter_stringStackSize - 1] = "";
						Interpreter.Interpreter_stringStack[++WorldMapDecoration.Interpreter_stringStackSize - 1] = "";
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else if (var0 == ScriptOpcodes.CHAT_GETFILTER_PRIVATE) {
					if (class3.privateChatMode == null) {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
					} else {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class3.privateChatMode.field3781;
					}

					return 1;
				} else if (var0 == ScriptOpcodes.CHAT_SENDPUBLIC) {
					var3 = Interpreter.Interpreter_stringStack[--WorldMapDecoration.Interpreter_stringStackSize];
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
					} else if (WorldMapSection1.clientLanguage != Language.Language_EN) {
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
					} else if (WorldMapSection1.clientLanguage != Language.Language_EN) {
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

					PacketBufferNode var8 = SoundSystem.getPacketBufferNode(ClientPacket.field2182, Client.packetWriter.isaacCipher);
					var8.packetBuffer.writeByte(0);
					int var9 = var8.packetBuffer.offset;
					var8.packetBuffer.writeByte(var4);
					var8.packetBuffer.writeByte(var17);
					var8.packetBuffer.writeByte(var7);
					SecureRandomCallable.method1229(var8.packetBuffer, var3);
					var8.packetBuffer.writeLengthByte(var8.packetBuffer.offset - var9);
					Client.packetWriter.addNode(var8);
					return 1;
				} else if (var0 == ScriptOpcodes.CHAT_SENDPRIVATE) {
					WorldMapDecoration.Interpreter_stringStackSize -= 2;
					var3 = Interpreter.Interpreter_stringStack[WorldMapDecoration.Interpreter_stringStackSize];
					String var12 = Interpreter.Interpreter_stringStack[WorldMapDecoration.Interpreter_stringStackSize + 1];
					PacketBufferNode var11 = SoundSystem.getPacketBufferNode(ClientPacket.field2207, Client.packetWriter.isaacCipher);
					var11.packetBuffer.writeShort(0);
					int var13 = var11.packetBuffer.offset;
					var11.packetBuffer.writeStringCp1252NullTerminated(var3);
					SecureRandomCallable.method1229(var11.packetBuffer, var12);
					var11.packetBuffer.writeLengthShort(var11.packetBuffer.offset - var13);
					Client.packetWriter.addNode(var11);
					return 1;
				} else if (var0 != ScriptOpcodes.CHAT_PLAYERNAME) {
					if (var0 == ScriptOpcodes.CHAT_GETFILTER_TRADE) {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.tradeChatMode;
						return 1;
					} else if (var0 == ScriptOpcodes.CHAT_GETHISTORYLENGTH) {
						var10 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = AttackOption.Messages_getHistorySize(var10);
						return 1;
					} else if (var0 == ScriptOpcodes.CHAT_GETNEXTUID) {
						var10 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class83.Messages_getNextChatID(var10);
						return 1;
					} else if (var0 == ScriptOpcodes.CHAT_GETPREVUID) {
						var10 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class65.Messages_getLastChatID(var10);
						return 1;
					} else if (var0 == ScriptOpcodes.DOCHEAT) {
						var3 = Interpreter.Interpreter_stringStack[--WorldMapDecoration.Interpreter_stringStackSize];
						MidiPcmStream.doCheat(var3);
						return 1;
					} else if (var0 == ScriptOpcodes.CHAT_SETMESSAGEFILTER) {
						Client.field849 = Interpreter.Interpreter_stringStack[--WorldMapDecoration.Interpreter_stringStackSize].toLowerCase().trim();
						return 1;
					} else if (var0 == ScriptOpcodes.CHAT_GETMESSAGEFILTER) {
						Interpreter.Interpreter_stringStack[++WorldMapDecoration.Interpreter_stringStackSize - 1] = Client.field849;
						return 1;
					} else if (var0 == ScriptOpcodes.DEBUGMES) {
						var3 = Interpreter.Interpreter_stringStack[--WorldMapDecoration.Interpreter_stringStackSize];
						System.out.println(var3);
						return 1;
					} else {
						return 2;
					}
				} else {
					if (class215.localPlayer != null && class215.localPlayer.username != null) {
						var3 = class215.localPlayer.username.getName();
					} else {
						var3 = "";
					}

					Interpreter.Interpreter_stringStack[++WorldMapDecoration.Interpreter_stringStackSize - 1] = var3;
					return 1;
				}
			}
		}
	}

	@ObfuscatedName("hg")
	@ObfuscatedSignature(
		signature = "(ZB)V",
		garbageValue = "-121"
	)
	@Export("addNpcsToScene")
	static final void addNpcsToScene(boolean var0) {
		for (int var1 = 0; var1 < Client.npcCount; ++var1) {
			NPC var2 = Client.npcs[Client.npcIndices[var1]];
			if (var2 != null && var2.isVisible() && var2.definition.isVisible == var0 && var2.definition.transformIsVisible()) {
				int var3 = var2.x >> 7;
				int var4 = var2.y >> 7;
				if (var3 >= 0 && var3 < 104 && var4 >= 0 && var4 < 104) {
					if (var2.field927 == 1 && (var2.x & 127) == 64 && (var2.y & 127) == 64) {
						if (Client.tileLastDrawnActor[var3][var4] == Client.viewportDrawCount) {
							continue;
						}

						Client.tileLastDrawnActor[var3][var4] = Client.viewportDrawCount;
					}

					long var5 = class160.calculateTag(0, 0, 1, !var2.definition.isInteractable, Client.npcIndices[var1]);
					var2.playerCycle = Client.cycle;
					WorldMapArea.scene.drawEntity(Player.Client_plane, var2.x, var2.y, GraphicsObject.getTileHeight(var2.field927 * 64 - 64 + var2.x, var2.field927 * 64 - 64 + var2.y, Player.Client_plane), var2.field927 * 64 - 64 + 60, var2, var2.rotation, var5, var2.isWalking);
				}
			}
		}

	}

	@ObfuscatedName("ia")
	@ObfuscatedSignature(
		signature = "(Lbj;IIII)V",
		garbageValue = "231016448"
	)
	@Export("addPlayerToMenu")
	static final void addPlayerToMenu(Player var0, int var1, int var2, int var3) {
		if (class215.localPlayer != var0) {
			if (Client.menuOptionsCount < 400) {
				String var4;
				if (var0.skillLevel == 0) {
					var4 = var0.actions[0] + var0.username + var0.actions[1] + GrandExchangeOffer.method159(var0.combatLevel, class215.localPlayer.combatLevel) + " " + " (" + "level-" + var0.combatLevel + ")" + var0.actions[2];
				} else {
					var4 = var0.actions[0] + var0.username + var0.actions[1] + " " + " (" + "skill-" + var0.skillLevel + ")" + var0.actions[2];
				}

				int var5;
				if (Client.isItemSelected == 1) {
					GameObject.insertMenuItemNoShift("Use", Client.selectedItemName + " " + "->" + " " + AbstractArchive.colorStartTag(16777215) + var4, 14, var1, var2, var3);
				} else if (Client.isSpellSelected) {
					if ((class81.selectedSpellFlags & 8) == 8) {
						GameObject.insertMenuItemNoShift(Client.selectedSpellActionName, Client.selectedSpellName + " " + "->" + " " + AbstractArchive.colorStartTag(16777215) + var4, 15, var1, var2, var3);
					}
				} else {
					for (var5 = 7; var5 >= 0; --var5) {
						if (Client.playerMenuActions[var5] != null) {
							short var6 = 0;
							if (Client.playerMenuActions[var5].equalsIgnoreCase("Attack")) {
								if (Client.playerAttackOption == AttackOption.AttackOption_hidden) {
									continue;
								}

								if (Client.playerAttackOption == AttackOption.AttackOption_alwaysRightClick || AttackOption.AttackOption_dependsOnCombatLevels == Client.playerAttackOption && var0.combatLevel > class215.localPlayer.combatLevel) {
									var6 = 2000;
								}

								if (class215.localPlayer.team != 0 && var0.team != 0) {
									if (var0.team == class215.localPlayer.team) {
										var6 = 2000;
									} else {
										var6 = 0;
									}
								}
							} else if (Client.playerOptionsPriorities[var5]) {
								var6 = 2000;
							}

							boolean var7 = false;
							int var8 = Client.playerMenuOpcodes[var5] + var6;
							GameObject.insertMenuItemNoShift(Client.playerMenuActions[var5], AbstractArchive.colorStartTag(16777215) + var4, var8, var1, var2, var3);
						}
					}
				}

				for (var5 = 0; var5 < Client.menuOptionsCount; ++var5) {
					if (Client.menuOpcodes[var5] == 23) {
						Client.menuTargets[var5] = AbstractArchive.colorStartTag(16777215) + var4;
						break;
					}
				}

			}
		}
	}
}
