import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("bz")
@Implements("LoginScreenAnimation")
public class LoginScreenAnimation {
	@ObfuscatedName("bq")
	@Export("otp")
	static String otp;
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "[Lli;"
	)
	@Export("sprites")
	IndexedSprite[] sprites;
	@ObfuscatedName("d")
	int[] field1025;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -630386699
	)
	int field1031;
	@ObfuscatedName("j")
	int[] field1027;
	@ObfuscatedName("m")
	int[] field1028;
	@ObfuscatedName("p")
	int[] field1033;
	@ObfuscatedName("h")
	int[] field1029;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -598170965
	)
	int field1021;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -1894077161
	)
	int field1032;
	@ObfuscatedName("x")
	int[] field1040;
	@ObfuscatedName("w")
	int[] field1034;
	@ObfuscatedName("k")
	int[] field1035;
	@ObfuscatedName("q")
	int[] field1030;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 1981807145
	)
	int field1037;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = 1837953616
	)
	int field1038;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -1636512933
	)
	int field1039;

	@ObfuscatedSignature(
		signature = "([Lli;)V"
	)
	LoginScreenAnimation(IndexedSprite[] var1) {
		this.field1025 = new int[256];
		this.field1031 = 0;
		this.field1021 = 0;
		this.field1032 = 0;
		this.field1037 = 0;
		this.field1038 = 0;
		this.field1039 = 0;
		this.sprites = var1;
		this.initColors();
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "956561052"
	)
	@Export("initColors")
	void initColors() {
		this.field1028 = new int[256];

		int var1;
		for (var1 = 0; var1 < 64; ++var1) {
			this.field1028[var1] = var1 * 262144;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1028[var1 + 64] = var1 * 1024 + 16711680;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1028[var1 + 128] = var1 * 4 + 16776960;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1028[var1 + 192] = 16777215;
		}

		this.field1033 = new int[256];

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1033[var1] = var1 * 1024;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1033[var1 + 64] = var1 * 4 + 65280;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1033[var1 + 128] = var1 * 262144 + 65535;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1033[var1 + 192] = 16777215;
		}

		this.field1029 = new int[256];

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1029[var1] = var1 * 4;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1029[var1 + 64] = var1 * 262144 + 255;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1029[var1 + 128] = var1 * 1024 + 16711935;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1029[var1 + 192] = 16777215;
		}

		this.field1027 = new int[256];
		this.field1037 = 0;
		this.field1035 = new int[32768];
		this.field1030 = new int[32768];
		this.method1811((IndexedSprite)null);
		this.field1040 = new int[32768];
		this.field1034 = new int[32768];
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1696836035"
	)
	void method1834() {
		this.field1028 = null;
		this.field1033 = null;
		this.field1029 = null;
		this.field1027 = null;
		this.field1035 = null;
		this.field1030 = null;
		this.field1040 = null;
		this.field1034 = null;
		this.field1037 = 0;
		this.field1038 = 0;
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "-321629645"
	)
	@Export("draw")
	void draw(int var1, int var2) {
		if (this.field1040 == null) {
			this.initColors();
		}

		if (this.field1039 == 0) {
			this.field1039 = var2;
		}

		int var3 = var2 - this.field1039;
		if (var3 >= 256) {
			var3 = 0;
		}

		this.field1039 = var2;
		if (var3 > 0) {
			this.method1806(var3);
		}

		this.method1838(var1);
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "1"
	)
	final void method1806(int var1) {
		this.field1037 += var1 * 128;
		int var2;
		if (this.field1037 > this.field1035.length) {
			this.field1037 -= this.field1035.length;
			var2 = (int)(Math.random() * 12.0D);
			this.method1811(this.sprites[var2]);
		}

		var2 = 0;
		int var3 = var1 * 128;
		int var4 = (256 - var1) * 128;

		int var6;
		for (int var5 = 0; var5 < var4; ++var5) {
			var6 = this.field1040[var3 + var2] - this.field1035[var2 + this.field1037 & this.field1035.length - 1] * var1 / 6;
			if (var6 < 0) {
				var6 = 0;
			}

			this.field1040[var2++] = var6;
		}

		byte var15 = 10;
		var6 = 128 - var15;

		int var7;
		int var10;
		for (var7 = 256 - var1; var7 < 256; ++var7) {
			int var8 = var7 * 128;

			for (int var9 = 0; var9 < 128; ++var9) {
				var10 = (int)(Math.random() * 100.0D);
				if (var10 < 50 && var9 > var15 && var9 < var6) {
					this.field1040[var8 + var9] = 255;
				} else {
					this.field1040[var9 + var8] = 0;
				}
			}
		}

		if (this.field1021 * 16 > 0) {
			this.field1021 = this.field1021 * 16 - var1 * 4;
		}

		if (this.field1032 * 16 > 0) {
			this.field1032 = this.field1032 * 16 - var1 * 4;
		}

		if (this.field1021 * 16 == 0 && this.field1032 * 16 == 0) {
			var7 = (int)(Math.random() * (double)(2000 / var1));
			if (var7 == 0) {
				this.field1021 = 1024;
			}

			if (var7 == 1) {
				this.field1032 = 1024;
			}
		}

		for (var7 = 0; var7 < 256 - var1; ++var7) {
			this.field1025[var7] = this.field1025[var7 + var1];
		}

		for (var7 = 256 - var1; var7 < 256; ++var7) {
			this.field1025[var7] = (int)(Math.sin((double)this.field1031 / 14.0D) * 16.0D + Math.sin((double)this.field1031 / 15.0D) * 14.0D + Math.sin((double)this.field1031 / 16.0D) * 12.0D);
			++this.field1031;
		}

		this.field1038 = this.field1038 * 10000 + 10000 * var1;
		var7 = ((Client.cycle & 1) + var1) / 2;
		if (var7 > 0) {
			short var16 = 128;
			byte var17 = 2;
			var10 = 128 - var17 - var17;

			int var11;
			int var12;
			int var13;
			for (var11 = 0; var11 < this.field1038 * 100; ++var11) {
				var12 = (int)(Math.random() * (double)var10) + var17;
				var13 = (int)(Math.random() * (double)var16) + var16;
				this.field1040[var12 + (var13 << 7)] = 192;
			}

			this.field1038 = 0;

			int var14;
			for (var11 = 0; var11 < 256; ++var11) {
				var12 = 0;
				var13 = var11 * 128;

				for (var14 = -var7; var14 < 128; ++var14) {
					if (var14 + var7 < 128) {
						var12 += this.field1040[var7 + var13 + var14];
					}

					if (var14 - (var7 + 1) >= 0) {
						var12 -= this.field1040[var13 + var14 - (var7 + 1)];
					}

					if (var14 >= 0) {
						this.field1034[var14 + var13] = var12 / (var7 * 2 + 1);
					}
				}
			}

			for (var11 = 0; var11 < 128; ++var11) {
				var12 = 0;

				for (var13 = -var7; var13 < 256; ++var13) {
					var14 = var13 * 128;
					if (var13 + var7 < 256) {
						var12 += this.field1034[var14 + var11 + var7 * 128];
					}

					if (var13 - (var7 + 1) >= 0) {
						var12 -= this.field1034[var14 + var11 - (var7 + 1) * 128];
					}

					if (var13 >= 0) {
						this.field1040[var14 + var11] = var12 / (var7 * 2 + 1);
					}
				}
			}
		}

	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(IIII)I",
		garbageValue = "-2098157242"
	)
	final int method1807(int var1, int var2, int var3) {
		int var4 = 256 - var3;
		return (var4 * (var1 & 16711935) + var3 * (var2 & 16711935) & -16711936) + (var3 * (var2 & 65280) + var4 * (var1 & 65280) & 16711680) >> 8;
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "124"
	)
	final void method1838(int var1) {
		int var2 = this.field1027.length;
		if (this.field1021 * 16 > 0) {
			this.method1809(this.field1021 * 16, this.field1033);
		} else if (this.field1032 * 16 > 0) {
			this.method1809(this.field1032 * 16, this.field1029);
		} else {
			for (int var3 = 0; var3 < var2; ++var3) {
				this.field1027[var3] = this.field1028[var3];
			}
		}

		this.method1816(var1);
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(I[II)V",
		garbageValue = "1172962335"
	)
	final void method1809(int var1, int[] var2) {
		int var3 = this.field1027.length;

		for (int var4 = 0; var4 < var3; ++var4) {
			if (var1 > 768) {
				this.field1027[var4] = this.method1807(this.field1028[var4], var2[var4], 1024 - var1);
			} else if (var1 > 256) {
				this.field1027[var4] = var2[var4];
			} else {
				this.field1027[var4] = this.method1807(var2[var4], this.field1028[var4], 256 - var1);
			}
		}

	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "910695492"
	)
	final void method1816(int var1) {
		int var2 = 0;

		for (int var3 = 1; var3 < 255; ++var3) {
			int var4 = (256 - var3) * this.field1025[var3] / 256;
			int var5 = var4 + var1;
			int var6 = 0;
			int var7 = 128;
			if (var5 < 0) {
				var6 = -var5;
				var5 = 0;
			}

			if (var5 + 128 >= DevicePcmPlayerProvider.rasterProvider.width) {
				var7 = DevicePcmPlayerProvider.rasterProvider.width - var5;
			}

			int var8 = var5 + (var3 + 8) * DevicePcmPlayerProvider.rasterProvider.width;
			var2 += var6;

			for (int var9 = var6; var9 < var7; ++var9) {
				int var10 = this.field1040[var2++];
				int var11 = var8 % Rasterizer2D.Rasterizer2D_width;
				if (var10 != 0 && var11 >= Rasterizer2D.Rasterizer2D_xClipStart && var11 < Rasterizer2D.Rasterizer2D_xClipEnd) {
					int var12 = var10;
					int var13 = 256 - var10;
					var10 = this.field1027[var10];
					int var14 = DevicePcmPlayerProvider.rasterProvider.pixels[var8];
					DevicePcmPlayerProvider.rasterProvider.pixels[var8++] = -16777216 | (var12 * (var10 & 65280) + var13 * (var14 & 65280) & 16711680) + ((var10 & 16711935) * var12 + (var14 & 16711935) * var13 & -16711936) >> 8;
				} else {
					++var8;
				}
			}

			var2 += 128 - var7;
		}

	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(Lli;I)V",
		garbageValue = "16711935"
	)
	final void method1811(IndexedSprite var1) {
		int var2;
		for (var2 = 0; var2 < this.field1035.length; ++var2) {
			this.field1035[var2] = 0;
		}

		int var3;
		for (var2 = 0; var2 < 5000; ++var2) {
			var3 = (int)(Math.random() * 128.0D * 256.0D);
			this.field1035[var3] = (int)(Math.random() * 256.0D);
		}

		int var4;
		int var5;
		for (var2 = 0; var2 < 20; ++var2) {
			for (var3 = 1; var3 < 255; ++var3) {
				for (var4 = 1; var4 < 127; ++var4) {
					var5 = var4 + (var3 << 7);
					this.field1030[var5] = (this.field1035[var5 + 1] + this.field1035[var5 - 128] + this.field1035[var5 + 128] + this.field1035[var5 - 1]) / 4;
				}
			}

			int[] var8 = this.field1035;
			this.field1035 = this.field1030;
			this.field1030 = var8;
		}

		if (var1 != null) {
			var2 = 0;

			for (var3 = 0; var3 < var1.subHeight; ++var3) {
				for (var4 = 0; var4 < var1.subWidth; ++var4) {
					if (var1.pixels[var2++] != 0) {
						var5 = var4 + var1.xOffset + 16;
						int var6 = var3 + var1.yOffset + 16;
						int var7 = var5 + (var6 << 7);
						this.field1035[var7] = 0;
					}
				}
			}
		}

	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(ILce;ZI)I",
		garbageValue = "1539324178"
	)
	static int method1835(int var0, Script var1, boolean var2) {
		if (var0 < 1000) {
			return WorldMapAreaData.method706(var0, var1, var2);
		} else if (var0 < 1100) {
			return MenuAction.method2106(var0, var1, var2);
		} else if (var0 < 1200) {
			return class2.method34(var0, var1, var2);
		} else if (var0 < 1300) {
			return Players.method2203(var0, var1, var2);
		} else if (var0 < 1400) {
			return JagexCache.method3566(var0, var1, var2);
		} else if (var0 < 1500) {
			return Player.method1300(var0, var1, var2);
		} else if (var0 < 1600) {
			return PacketBufferNode.method3697(var0, var1, var2);
		} else if (var0 < 1700) {
			return UserList.method5212(var0, var1, var2);
		} else if (var0 < 1800) {
			return NPCDefinition.method4818(var0, var1, var2);
		} else if (var0 < 1900) {
			return WorldMapData_0.method175(var0, var1, var2);
		} else if (var0 < 2000) {
			return class42.method810(var0, var1, var2);
		} else if (var0 < 2100) {
			return MenuAction.method2106(var0, var1, var2);
		} else if (var0 < 2200) {
			return class2.method34(var0, var1, var2);
		} else if (var0 < 2300) {
			return Players.method2203(var0, var1, var2);
		} else if (var0 < 2400) {
			return JagexCache.method3566(var0, var1, var2);
		} else if (var0 < 2500) {
			return Player.method1300(var0, var1, var2);
		} else if (var0 < 2600) {
			return NetSocket.method3608(var0, var1, var2);
		} else if (var0 < 2700) {
			return ViewportMouse.method3037(var0, var1, var2);
		} else if (var0 < 2800) {
			return InterfaceParent.method1191(var0, var1, var2);
		} else if (var0 < 2900) {
			return Players.method2200(var0, var1, var2);
		} else if (var0 < 3000) {
			return class42.method810(var0, var1, var2);
		} else if (var0 < 3200) {
			return UserComparator5.method3491(var0, var1, var2);
		} else if (var0 < 3300) {
			return WallDecoration.method3357(var0, var1, var2);
		} else if (var0 < 3400) {
			return SecureRandomFuture.method2169(var0, var1, var2);
		} else if (var0 < 3500) {
			return class223.method4193(var0, var1, var2);
		} else if (var0 < 3700) {
			return MusicPatch.method3962(var0, var1, var2);
		} else if (var0 < 4000) {
			return StructDefinition.method4627(var0, var1, var2);
		} else if (var0 < 4100) {
			return TileItemPile.method2834(var0, var1, var2);
		} else if (var0 < 4200) {
			return GraphicsDefaults.method5955(var0, var1, var2);
		} else if (var0 < 4300) {
			return class215.method4100(var0, var1, var2);
		} else if (var0 < 5100) {
			return method1808(var0, var1, var2);
		} else if (var0 < 5400) {
			return HealthBarUpdate.method1759(var0, var1, var2);
		} else if (var0 < 5600) {
			return FriendSystem.method1920(var0, var1, var2);
		} else if (var0 < 5700) {
			return WorldMapSectionType.method245(var0, var1, var2);
		} else if (var0 < 6300) {
			return ReflectionCheck.method2348(var0, var1, var2);
		} else if (var0 < 6600) {
			return WorldMapCacheName.method633(var0, var1, var2);
		} else {
			return var0 < 6700 ? UrlRequest.method3382(var0, var1, var2) : 2;
		}
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "-2014430142"
	)
	static final void method1837(String var0) {
		class60.method1188(var0 + " is already on your friend list");
	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		signature = "(ILce;ZI)I",
		garbageValue = "580848394"
	)
	static int method1808(int var0, Script var1, boolean var2) {
		if (var0 == ScriptOpcodes.CHAT_GETFILTER_PUBLIC) {
			Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = Client.publicChatMode;
			return 1;
		} else if (var0 == ScriptOpcodes.CHAT_SETFILTER) {
			class320.Interpreter_intStackSize -= 3;
			Client.publicChatMode = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize];
			WorldMapSectionType.privateChatMode = UserComparator9.method3461(Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1]);
			if (WorldMapSectionType.privateChatMode == null) {
				WorldMapSectionType.privateChatMode = PrivateChatMode.field3790;
			}

			Client.tradeChatMode = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 2];
			PacketBufferNode var18 = TilePaint.getPacketBufferNode(ClientPacket.field2283, Client.packetWriter.isaacCipher);
			var18.packetBuffer.writeByte(Client.publicChatMode);
			var18.packetBuffer.writeByte(WorldMapSectionType.privateChatMode.field3787);
			var18.packetBuffer.writeByte(Client.tradeChatMode);
			Client.packetWriter.addNode(var18);
			return 1;
		} else {
			String var3;
			int var4;
			if (var0 == ScriptOpcodes.CHAT_SENDABUSEREPORT) {
				var3 = Interpreter.Interpreter_stringStack[--Message.Interpreter_stringStackSize];
				class320.Interpreter_intStackSize -= 2;
				var4 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize];
				int var5 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1];
				PacketBufferNode var6 = TilePaint.getPacketBufferNode(ClientPacket.field2271, Client.packetWriter.isaacCipher);
				var6.packetBuffer.writeByte(Buddy.stringCp1252NullTerminatedByteSize(var3) + 2);
				var6.packetBuffer.writeStringCp1252NullTerminated(var3);
				var6.packetBuffer.writeByte(var4 - 1);
				var6.packetBuffer.writeByte(var5);
				Client.packetWriter.addNode(var6);
				return 1;
			} else {
				int var10;
				if (var0 == ScriptOpcodes.CHAT_GETHISTORY_BYTYPEANDLINE) {
					class320.Interpreter_intStackSize -= 2;
					var10 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize];
					var4 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1];
					Message var15 = WorldMapRectangle.Messages_getByChannelAndID(var10, var4);
					if (var15 != null) {
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var15.count;
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var15.cycle;
						Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = var15.sender != null ? var15.sender : "";
						Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = var15.prefix != null ? var15.prefix : "";
						Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = var15.text != null ? var15.text : "";
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var15.isFromFriend() ? 1 : (var15.isFromIgnored() ? 2 : 0);
					} else {
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = -1;
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 0;
						Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = "";
						Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = "";
						Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = "";
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else if (var0 == ScriptOpcodes.CHAT_GETHISTORY_BYUID) {
					var10 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
					Message var16 = class43.Messages_getMessage(var10);
					if (var16 != null) {
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var16.type;
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var16.cycle;
						Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = var16.sender != null ? var16.sender : "";
						Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = var16.prefix != null ? var16.prefix : "";
						Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = var16.text != null ? var16.text : "";
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var16.isFromFriend() ? 1 : (var16.isFromIgnored() ? 2 : 0);
					} else {
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = -1;
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 0;
						Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = "";
						Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = "";
						Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = "";
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else if (var0 == ScriptOpcodes.CHAT_GETFILTER_PRIVATE) {
					if (WorldMapSectionType.privateChatMode == null) {
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = -1;
					} else {
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = WorldMapSectionType.privateChatMode.field3787;
					}

					return 1;
				} else if (var0 == ScriptOpcodes.CHAT_SENDPUBLIC) {
					var3 = Interpreter.Interpreter_stringStack[--Message.Interpreter_stringStackSize];
					var4 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
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
					} else if (FriendLoginUpdate.clientLanguage != Language.Language_EN) {
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
					} else if (FriendLoginUpdate.clientLanguage != Language.Language_EN) {
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

					PacketBufferNode var8 = TilePaint.getPacketBufferNode(ClientPacket.field2263, Client.packetWriter.isaacCipher);
					var8.packetBuffer.writeByte(0);
					int var9 = var8.packetBuffer.offset;
					var8.packetBuffer.writeByte(var4);
					var8.packetBuffer.writeByte(var17);
					var8.packetBuffer.writeByte(var7);
					GrandExchangeOfferTotalQuantityComparator.method104(var8.packetBuffer, var3);
					var8.packetBuffer.writeLengthByte(var8.packetBuffer.offset - var9);
					Client.packetWriter.addNode(var8);
					return 1;
				} else if (var0 == ScriptOpcodes.CHAT_SENDPRIVATE) {
					Message.Interpreter_stringStackSize -= 2;
					var3 = Interpreter.Interpreter_stringStack[Message.Interpreter_stringStackSize];
					String var12 = Interpreter.Interpreter_stringStack[Message.Interpreter_stringStackSize + 1];
					PacketBufferNode var11 = TilePaint.getPacketBufferNode(ClientPacket.field2241, Client.packetWriter.isaacCipher);
					var11.packetBuffer.writeShort(0);
					int var13 = var11.packetBuffer.offset;
					var11.packetBuffer.writeStringCp1252NullTerminated(var3);
					GrandExchangeOfferTotalQuantityComparator.method104(var11.packetBuffer, var12);
					var11.packetBuffer.writeLengthShort(var11.packetBuffer.offset - var13);
					Client.packetWriter.addNode(var11);
					return 1;
				} else if (var0 != ScriptOpcodes.CHAT_PLAYERNAME) {
					if (var0 == ScriptOpcodes.CHAT_GETFILTER_TRADE) {
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = Client.tradeChatMode;
						return 1;
					} else if (var0 == ScriptOpcodes.CHAT_GETHISTORYLENGTH) {
						var10 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = class51.Messages_getHistorySize(var10);
						return 1;
					} else if (var0 == ScriptOpcodes.CHAT_GETNEXTUID) {
						var10 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = class13.Messages_getNextChatID(var10);
						return 1;
					} else if (var0 == ScriptOpcodes.CHAT_GETPREVUID) {
						var10 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = ItemDefinition.Messages_getLastChatID(var10);
						return 1;
					} else if (var0 == ScriptOpcodes.DOCHEAT) {
						var3 = Interpreter.Interpreter_stringStack[--Message.Interpreter_stringStackSize];
						NetCache.doCheat(var3);
						return 1;
					} else if (var0 == ScriptOpcodes.CHAT_SETMESSAGEFILTER) {
						Client.field780 = Interpreter.Interpreter_stringStack[--Message.Interpreter_stringStackSize].toLowerCase().trim();
						return 1;
					} else if (var0 == ScriptOpcodes.CHAT_GETMESSAGEFILTER) {
						Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = Client.field780;
						return 1;
					} else if (var0 == ScriptOpcodes.DEBUGMES) {
						var3 = Interpreter.Interpreter_stringStack[--Message.Interpreter_stringStackSize];
						System.out.println(var3);
						return 1;
					} else {
						return 2;
					}
				} else {
					if (class192.localPlayer != null && class192.localPlayer.username != null) {
						var3 = class192.localPlayer.username.getName();
					} else {
						var3 = "";
					}

					Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = var3;
					return 1;
				}
			}
		}
	}

	@ObfuscatedName("gk")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "115582492"
	)
	static boolean method1819() {
		return (Client.drawPlayerNames & 1) != 0;
	}
}
