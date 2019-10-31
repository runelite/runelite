import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("bt")
@Implements("Message")
public class Message extends DualNode {
	@ObfuscatedName("sb")
	@ObfuscatedGetter(
		longValue = -680699599489496797L
	)
	static long field584;
	@ObfuscatedName("be")
	@ObfuscatedSignature(
		signature = "Llw;"
	)
	static IndexedSprite field587;
	@ObfuscatedName("fi")
	@ObfuscatedGetter(
		longValue = 9196175446999067947L
	)
	static long field577;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = 911828469
	)
	@Export("count")
	int count;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -1904084765
	)
	@Export("cycle")
	int cycle;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 1353192455
	)
	@Export("type")
	int type;
	@ObfuscatedName("q")
	@Export("sender")
	String sender;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lju;"
	)
	@Export("senderUsername")
	Username senderUsername;
	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "Ljs;"
	)
	@Export("isFromFriend0")
	TriBool isFromFriend0;
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Ljs;"
	)
	@Export("isFromIgnored0")
	TriBool isFromIgnored0;
	@ObfuscatedName("o")
	@Export("prefix")
	String prefix;
	@ObfuscatedName("i")
	@Export("text")
	String text;

	Message(int var1, String var2, String var3, String var4) {
		this.isFromFriend0 = TriBool.TriBool_unknown;
		this.isFromIgnored0 = TriBool.TriBool_unknown;
		this.set(var1, var2, var3, var4);
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;S)V",
		garbageValue = "-16257"
	)
	@Export("set")
	void set(int var1, String var2, String var3, String var4) {
		int var5 = ++Messages.Messages_count - 1;
		this.count = var5;
		this.cycle = Client.cycle;
		this.type = var1;
		this.sender = var2;
		this.fillSenderUsername();
		this.prefix = var3;
		this.text = var4;
		this.clearIsFromFriend();
		this.clearIsFromIgnored();
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "2091066977"
	)
	@Export("clearIsFromFriend")
	void clearIsFromFriend() {
		this.isFromFriend0 = TriBool.TriBool_unknown;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "-112"
	)
	@Export("isFromFriend")
	final boolean isFromFriend() {
		if (this.isFromFriend0 == TriBool.TriBool_unknown) {
			this.fillIsFromFriend();
		}

		return this.isFromFriend0 == TriBool.TriBool_true;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-327157913"
	)
	@Export("fillIsFromFriend")
	void fillIsFromFriend() {
		this.isFromFriend0 = PacketWriter.friendSystem.friendsList.contains(this.senderUsername) ? TriBool.TriBool_true : TriBool.TriBool_false;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "63"
	)
	@Export("clearIsFromIgnored")
	void clearIsFromIgnored() {
		this.isFromIgnored0 = TriBool.TriBool_unknown;
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "694631904"
	)
	@Export("isFromIgnored")
	final boolean isFromIgnored() {
		if (this.isFromIgnored0 == TriBool.TriBool_unknown) {
			this.fillIsFromIgnored();
		}

		return this.isFromIgnored0 == TriBool.TriBool_true;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1904334547"
	)
	@Export("fillIsFromIgnored")
	void fillIsFromIgnored() {
		this.isFromIgnored0 = PacketWriter.friendSystem.ignoreList.contains(this.senderUsername) ? TriBool.TriBool_true : TriBool.TriBool_false;
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-452155961"
	)
	@Export("fillSenderUsername")
	final void fillSenderUsername() {
		if (this.sender != null) {
			this.senderUsername = new Username(class186.method3776(this.sender), class60.loginType);
		} else {
			this.senderUsername = null;
		}

	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(IIILfc;Lfm;Z[I[IB)I",
		garbageValue = "-128"
	)
	public static int method1311(int var0, int var1, int var2, RouteStrategy var3, CollisionMap var4, boolean var5, int[] var6, int[] var7) {
		int var9;
		for (int var8 = 0; var8 < 128; ++var8) {
			for (var9 = 0; var9 < 128; ++var9) {
				class173.directions[var8][var9] = 0;
				class173.distances[var8][var9] = 99999999;
			}
		}

		int var10;
		int var11;
		byte var13;
		int var14;
		int var15;
		int var17;
		int var19;
		int var20;
		int var21;
		boolean var28;
		int var30;
		int var31;
		int var33;
		if (var2 == 1) {
			var10 = var0;
			var11 = var1;
			byte var12 = 64;
			var13 = 64;
			var14 = var0 - var12;
			var15 = var1 - var13;
			class173.directions[var12][var13] = 99;
			class173.distances[var12][var13] = 0;
			byte var16 = 0;
			var17 = 0;
			class173.bufferX[var16] = var0;
			var33 = var16 + 1;
			class173.bufferY[var16] = var1;
			int[][] var18 = var4.flags;

			boolean var29;
			while (true) {
				if (var33 == var17) {
					class173.field2070 = var10;
					LoginScreenAnimation.field1029 = var11;
					var29 = false;
					break;
				}

				var10 = class173.bufferX[var17];
				var11 = class173.bufferY[var17];
				var17 = var17 + 1 & 4095;
				var30 = var10 - var14;
				var31 = var11 - var15;
				var19 = var10 - var4.xInset;
				var20 = var11 - var4.yInset;
				if (var3.hasArrived(1, var10, var11, var4)) {
					class173.field2070 = var10;
					LoginScreenAnimation.field1029 = var11;
					var29 = true;
					break;
				}

				var21 = class173.distances[var30][var31] + 1;
				if (var30 > 0 && class173.directions[var30 - 1][var31] == 0 && (var18[var19 - 1][var20] & 19136776) == 0) {
					class173.bufferX[var33] = var10 - 1;
					class173.bufferY[var33] = var11;
					var33 = var33 + 1 & 4095;
					class173.directions[var30 - 1][var31] = 2;
					class173.distances[var30 - 1][var31] = var21;
				}

				if (var30 < 127 && class173.directions[var30 + 1][var31] == 0 && (var18[var19 + 1][var20] & 19136896) == 0) {
					class173.bufferX[var33] = var10 + 1;
					class173.bufferY[var33] = var11;
					var33 = var33 + 1 & 4095;
					class173.directions[var30 + 1][var31] = 8;
					class173.distances[var30 + 1][var31] = var21;
				}

				if (var31 > 0 && class173.directions[var30][var31 - 1] == 0 && (var18[var19][var20 - 1] & 19136770) == 0) {
					class173.bufferX[var33] = var10;
					class173.bufferY[var33] = var11 - 1;
					var33 = var33 + 1 & 4095;
					class173.directions[var30][var31 - 1] = 1;
					class173.distances[var30][var31 - 1] = var21;
				}

				if (var31 < 127 && class173.directions[var30][var31 + 1] == 0 && (var18[var19][var20 + 1] & 19136800) == 0) {
					class173.bufferX[var33] = var10;
					class173.bufferY[var33] = var11 + 1;
					var33 = var33 + 1 & 4095;
					class173.directions[var30][var31 + 1] = 4;
					class173.distances[var30][var31 + 1] = var21;
				}

				if (var30 > 0 && var31 > 0 && class173.directions[var30 - 1][var31 - 1] == 0 && (var18[var19 - 1][var20 - 1] & 19136782) == 0 && (var18[var19 - 1][var20] & 19136776) == 0 && (var18[var19][var20 - 1] & 19136770) == 0) {
					class173.bufferX[var33] = var10 - 1;
					class173.bufferY[var33] = var11 - 1;
					var33 = var33 + 1 & 4095;
					class173.directions[var30 - 1][var31 - 1] = 3;
					class173.distances[var30 - 1][var31 - 1] = var21;
				}

				if (var30 < 127 && var31 > 0 && class173.directions[var30 + 1][var31 - 1] == 0 && (var18[var19 + 1][var20 - 1] & 19136899) == 0 && (var18[var19 + 1][var20] & 19136896) == 0 && (var18[var19][var20 - 1] & 19136770) == 0) {
					class173.bufferX[var33] = var10 + 1;
					class173.bufferY[var33] = var11 - 1;
					var33 = var33 + 1 & 4095;
					class173.directions[var30 + 1][var31 - 1] = 9;
					class173.distances[var30 + 1][var31 - 1] = var21;
				}

				if (var30 > 0 && var31 < 127 && class173.directions[var30 - 1][var31 + 1] == 0 && (var18[var19 - 1][var20 + 1] & 19136824) == 0 && (var18[var19 - 1][var20] & 19136776) == 0 && (var18[var19][var20 + 1] & 19136800) == 0) {
					class173.bufferX[var33] = var10 - 1;
					class173.bufferY[var33] = var11 + 1;
					var33 = var33 + 1 & 4095;
					class173.directions[var30 - 1][var31 + 1] = 6;
					class173.distances[var30 - 1][var31 + 1] = var21;
				}

				if (var30 < 127 && var31 < 127 && class173.directions[var30 + 1][var31 + 1] == 0 && (var18[var19 + 1][var20 + 1] & 19136992) == 0 && (var18[var19 + 1][var20] & 19136896) == 0 && (var18[var19][var20 + 1] & 19136800) == 0) {
					class173.bufferX[var33] = var10 + 1;
					class173.bufferY[var33] = var11 + 1;
					var33 = var33 + 1 & 4095;
					class173.directions[var30 + 1][var31 + 1] = 12;
					class173.distances[var30 + 1][var31 + 1] = var21;
				}
			}

			var28 = var29;
		} else if (var2 == 2) {
			var28 = InterfaceParent.method1262(var0, var1, var3, var4);
		} else {
			var28 = WorldMapLabelSize.method236(var0, var1, var2, var3, var4);
		}

		var9 = var0 - 64;
		var10 = var1 - 64;
		var11 = class173.field2070;
		var30 = LoginScreenAnimation.field1029;
		if (!var28) {
			var31 = Integer.MAX_VALUE;
			var14 = Integer.MAX_VALUE;
			byte var32 = 10;
			var33 = var3.approxDestinationX;
			var17 = var3.approxDestinationY;
			int var27 = var3.approxDestinationSizeX;
			var19 = var3.approxDestinationSizeY;

			for (var20 = var33 - var32; var20 <= var32 + var33; ++var20) {
				for (var21 = var17 - var32; var21 <= var17 + var32; ++var21) {
					int var22 = var20 - var9;
					int var23 = var21 - var10;
					if (var22 >= 0 && var23 >= 0 && var22 < 128 && var23 < 128 && class173.distances[var22][var23] < 100) {
						int var24 = 0;
						if (var20 < var33) {
							var24 = var33 - var20;
						} else if (var20 > var33 + var27 - 1) {
							var24 = var20 - (var33 + var27 - 1);
						}

						int var25 = 0;
						if (var21 < var17) {
							var25 = var17 - var21;
						} else if (var21 > var17 + var19 - 1) {
							var25 = var21 - (var17 + var19 - 1);
						}

						int var26 = var24 * var24 + var25 * var25;
						if (var26 < var31 || var31 == var26 && class173.distances[var22][var23] < var14) {
							var31 = var26;
							var14 = class173.distances[var22][var23];
							var11 = var20;
							var30 = var21;
						}
					}
				}
			}

			if (var31 == Integer.MAX_VALUE) {
				return -1;
			}
		}

		if (var0 == var11 && var30 == var1) {
			return 0;
		} else {
			var13 = 0;
			class173.bufferX[var13] = var11;
			var31 = var13 + 1;
			class173.bufferY[var13] = var30;

			for (var14 = var15 = class173.directions[var11 - var9][var30 - var10]; var0 != var11 || var30 != var1; var14 = class173.directions[var11 - var9][var30 - var10]) {
				if (var15 != var14) {
					var15 = var14;
					class173.bufferX[var31] = var11;
					class173.bufferY[var31++] = var30;
				}

				if ((var14 & 2) != 0) {
					++var11;
				} else if ((var14 & 8) != 0) {
					--var11;
				}

				if ((var14 & 1) != 0) {
					++var30;
				} else if ((var14 & 4) != 0) {
					--var30;
				}
			}

			var33 = 0;

			while (var31-- > 0) {
				var6[var33] = class173.bufferX[var31];
				var7[var33++] = class173.bufferY[var31];
				if (var33 >= var6.length) {
					break;
				}
			}

			return var33;
		}
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(IIB)V",
		garbageValue = "18"
	)
	public static void method1299(int var0, int var1) {
		VarbitDefinition var3 = (VarbitDefinition)VarbitDefinition.VarbitDefinition_cached.get((long)var0);
		VarbitDefinition var2;
		if (var3 != null) {
			var2 = var3;
		} else {
			byte[] var8 = VarbitDefinition.VarbitDefinition_archive.takeFile(14, var0);
			var3 = new VarbitDefinition();
			if (var8 != null) {
				var3.decode(new Buffer(var8));
			}

			VarbitDefinition.VarbitDefinition_cached.put(var3, (long)var0);
			var2 = var3;
		}

		int var4 = var2.baseVar;
		int var5 = var2.startBit;
		int var6 = var2.endBit;
		int var7 = Varps.Varps_masks[var6 - var5];
		if (var1 < 0 || var1 > var7) {
			var1 = 0;
		}

		var7 <<= var5;
		Varps.Varps_main[var4] = Varps.Varps_main[var4] & ~var7 | var1 << var5 & var7;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "([BI)[B",
		garbageValue = "-2141353592"
	)
	static byte[] method1312(byte[] var0) {
		int var1 = var0.length;
		byte[] var2 = new byte[var1];
		System.arraycopy(var0, 0, var2, 0, var1);
		return var2;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "([BI)V",
		garbageValue = "1623096265"
	)
	@Export("SpriteBuffer_decode")
	static void SpriteBuffer_decode(byte[] var0) {
		Buffer var1 = new Buffer(var0);
		var1.offset = var0.length - 2;
		class325.SpriteBuffer_spriteCount = var1.readUnsignedShort();
		SecureRandomFuture.SpriteBuffer_xOffsets = new int[class325.SpriteBuffer_spriteCount];
		HealthBar.SpriteBuffer_yOffsets = new int[class325.SpriteBuffer_spriteCount];
		SecureRandomCallable.SpriteBuffer_spriteWidths = new int[class325.SpriteBuffer_spriteCount];
		AttackOption.SpriteBuffer_spriteHeights = new int[class325.SpriteBuffer_spriteCount];
		class325.SpriteBuffer_pixels = new byte[class325.SpriteBuffer_spriteCount][];
		var1.offset = var0.length - 7 - class325.SpriteBuffer_spriteCount * 8;
		class325.SpriteBuffer_spriteWidth = var1.readUnsignedShort();
		class325.SpriteBuffer_spriteHeight = var1.readUnsignedShort();
		int var2 = (var1.readUnsignedByte() & 255) + 1;

		int var3;
		for (var3 = 0; var3 < class325.SpriteBuffer_spriteCount; ++var3) {
			SecureRandomFuture.SpriteBuffer_xOffsets[var3] = var1.readUnsignedShort();
		}

		for (var3 = 0; var3 < class325.SpriteBuffer_spriteCount; ++var3) {
			HealthBar.SpriteBuffer_yOffsets[var3] = var1.readUnsignedShort();
		}

		for (var3 = 0; var3 < class325.SpriteBuffer_spriteCount; ++var3) {
			SecureRandomCallable.SpriteBuffer_spriteWidths[var3] = var1.readUnsignedShort();
		}

		for (var3 = 0; var3 < class325.SpriteBuffer_spriteCount; ++var3) {
			AttackOption.SpriteBuffer_spriteHeights[var3] = var1.readUnsignedShort();
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
			int var4 = SecureRandomCallable.SpriteBuffer_spriteWidths[var3];
			int var5 = AttackOption.SpriteBuffer_spriteHeights[var3];
			int var6 = var4 * var5;
			byte[] var7 = new byte[var6];
			class325.SpriteBuffer_pixels[var3] = var7;
			int var8 = var1.readUnsignedByte();
			int var9;
			if (var8 == 0) {
				for (var9 = 0; var9 < var6; ++var9) {
					var7[var9] = var1.readByte();
				}
			} else if (var8 == 1) {
				for (var9 = 0; var9 < var4; ++var9) {
					for (int var10 = 0; var10 < var5; ++var10) {
						var7[var9 + var4 * var10] = var1.readByte();
					}
				}
			}
		}

	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		signature = "(ILcj;ZI)I",
		garbageValue = "-1500417983"
	)
	static int method1310(int var0, Script var1, boolean var2) {
		int var3;
		int var4;
		int var6;
		if (var0 == ScriptOpcodes.ENUM_STRING) {
			Interpreter.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
			EnumDefinition var5 = Coord.getEnum(var3);
			if (var5.outputType != 's') {
			}

			for (var6 = 0; var6 < var5.outputCount; ++var6) {
				if (var4 == var5.keys[var6]) {
					Interpreter.Interpreter_stringStack[++WorldMapDecoration.Interpreter_stringStackSize - 1] = var5.strVals[var6];
					var5 = null;
					break;
				}
			}

			if (var5 != null) {
				Interpreter.Interpreter_stringStack[++WorldMapDecoration.Interpreter_stringStackSize - 1] = var5.defaultStr;
			}

			return 1;
		} else if (var0 != ScriptOpcodes.ENUM) {
			if (var0 == ScriptOpcodes.ENUM_GETOUTPUTCOUNT) {
				var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				EnumDefinition var10 = Coord.getEnum(var3);
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var10.size();
				return 1;
			} else {
				return 2;
			}
		} else {
			Interpreter.Interpreter_intStackSize -= 4;
			var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
			int var9 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
			var6 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 3];
			EnumDefinition var7 = Coord.getEnum(var9);
			if (var3 == var7.inputType && var4 == var7.outputType) {
				for (int var8 = 0; var8 < var7.outputCount; ++var8) {
					if (var6 == var7.keys[var8]) {
						if (var4 == 115) {
							Interpreter.Interpreter_stringStack[++WorldMapDecoration.Interpreter_stringStackSize - 1] = var7.strVals[var8];
						} else {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var7.intVals[var8];
						}

						var7 = null;
						break;
					}
				}

				if (var7 != null) {
					if (var4 == 115) {
						Interpreter.Interpreter_stringStack[++WorldMapDecoration.Interpreter_stringStackSize - 1] = var7.defaultStr;
					} else {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var7.defaultInt;
					}
				}

				return 1;
			} else {
				if (var4 == 115) {
					Interpreter.Interpreter_stringStack[++WorldMapDecoration.Interpreter_stringStackSize - 1] = "null";
				} else {
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
				}

				return 1;
			}
		}
	}

	@ObfuscatedName("jz")
	@ObfuscatedSignature(
		signature = "([Lhi;IIIZI)V",
		garbageValue = "-548793337"
	)
	@Export("resizeInterface")
	static void resizeInterface(Widget[] var0, int var1, int var2, int var3, boolean var4) {
		for (int var5 = 0; var5 < var0.length; ++var5) {
			Widget var6 = var0[var5];
			if (var6 != null && var6.parentId == var1) {
				TriBool.alignWidgetSize(var6, var2, var3, var4);
				ObjectDefinition.alignWidgetPosition(var6, var2, var3);
				if (var6.scrollX > var6.scrollWidth - var6.width) {
					var6.scrollX = var6.scrollWidth - var6.width;
				}

				if (var6.scrollX < 0) {
					var6.scrollX = 0;
				}

				if (var6.scrollY > var6.scrollHeight - var6.height) {
					var6.scrollY = var6.scrollHeight - var6.height;
				}

				if (var6.scrollY < 0) {
					var6.scrollY = 0;
				}

				if (var6.type == 0) {
					class43.revalidateWidgetScroll(var0, var6, var4);
				}
			}
		}

	}

	@ObfuscatedName("ji")
	@ObfuscatedSignature(
		signature = "(Lhi;Liw;IIZS)V",
		garbageValue = "4095"
	)
	@Export("addWidgetItemMenuItem")
	static final void addWidgetItemMenuItem(Widget var0, ItemDefinition var1, int var2, int var3, boolean var4) {
		String[] var5 = var1.inventoryActions;
		byte var6 = -1;
		String var7 = null;
		if (var5 != null && var5[var3] != null) {
			if (var3 == 0) {
				var6 = 33;
			} else if (var3 == 1) {
				var6 = 34;
			} else if (var3 == 2) {
				var6 = 35;
			} else if (var3 == 3) {
				var6 = 36;
			} else {
				var6 = 37;
			}

			var7 = var5[var3];
		} else if (var3 == 4) {
			var6 = 37;
			var7 = "Drop";
		}

		if (var6 != -1 && var7 != null) {
			ArchiveDiskAction.insertMenuItem(var7, AbstractArchive.colorStartTag(16748608) + var1.name, var6, var1.id, var2, var0.id, var4);
		}

	}

	@ObfuscatedName("kn")
	@ObfuscatedSignature(
		signature = "(IIIILlx;Lhn;B)V",
		garbageValue = "40"
	)
	@Export("drawSpriteOnMinimap")
	static final void drawSpriteOnMinimap(int var0, int var1, int var2, int var3, Sprite var4, SpriteMask var5) {
		if (var4 != null) {
			int var6 = Client.camAngleY & 2047;
			int var7 = var3 * var3 + var2 * var2;
			if (var7 <= 6400) {
				int var8 = Rasterizer3D.Rasterizer3D_sine[var6];
				int var9 = Rasterizer3D.Rasterizer3D_cosine[var6];
				int var10 = var9 * var2 + var3 * var8 >> 16;
				int var11 = var3 * var9 - var8 * var2 >> 16;
				if (var7 > 2500) {
					var4.method6263(var10 + var5.width / 2 - var4.width / 2, var5.height / 2 - var11 - var4.height / 2, var0, var1, var5.width, var5.height, var5.xStarts, var5.xWidths);
				} else {
					var4.drawTransBgAt(var0 + var10 + var5.width / 2 - var4.width / 2, var5.height / 2 + var1 - var11 - var4.height / 2);
				}

			}
		}
	}
}
