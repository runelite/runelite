import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("gr")
@Implements("MusicPatch")
public class MusicPatch extends Node {
	@ObfuscatedName("iz")
	@ObfuscatedGetter(
		intValue = -185966491
	)
	@Export("selectedItemId")
	static int selectedItemId;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -1990358497
	)
	int field2488;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "[Lcv;"
	)
	@Export("rawSounds")
	RawSound[] rawSounds;
	@ObfuscatedName("o")
	short[] field2483;
	@ObfuscatedName("e")
	byte[] field2486;
	@ObfuscatedName("i")
	byte[] field2482;
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "[Lgf;"
	)
	MusicPatchNode2[] field2487;
	@ObfuscatedName("d")
	byte[] field2485;
	@ObfuscatedName("l")
	int[] field2489;

	MusicPatch(byte[] var1) {
		this.rawSounds = new RawSound[128];
		this.field2483 = new short[128];
		this.field2486 = new byte[128];
		this.field2482 = new byte[128];
		this.field2487 = new MusicPatchNode2[128];
		this.field2485 = new byte[128];
		this.field2489 = new int[128];
		Buffer var2 = new Buffer(var1);

		int var3;
		for (var3 = 0; var2.array[var3 + var2.offset] != 0; ++var3) {
		}

		byte[] var4 = new byte[var3];

		int var5;
		for (var5 = 0; var5 < var3; ++var5) {
			var4[var5] = var2.readByte();
		}

		++var2.offset;
		++var3;
		var5 = var2.offset;
		var2.offset += var3;

		int var6;
		for (var6 = 0; var2.array[var6 + var2.offset] != 0; ++var6) {
		}

		byte[] var7 = new byte[var6];

		int var8;
		for (var8 = 0; var8 < var6; ++var8) {
			var7[var8] = var2.readByte();
		}

		++var2.offset;
		++var6;
		var8 = var2.offset;
		var2.offset += var6;

		int var9;
		for (var9 = 0; var2.array[var9 + var2.offset] != 0; ++var9) {
		}

		byte[] var10 = new byte[var9];

		for (int var11 = 0; var11 < var9; ++var11) {
			var10[var11] = var2.readByte();
		}

		++var2.offset;
		++var9;
		byte[] var36 = new byte[var9];
		int var12;
		int var14;
		if (var9 > 1) {
			var36[1] = 1;
			int var13 = 1;
			var12 = 2;

			for (var14 = 2; var14 < var9; ++var14) {
				int var15 = var2.readUnsignedByte();
				if (var15 == 0) {
					var13 = var12++;
				} else {
					if (var15 <= var13) {
						--var15;
					}

					var13 = var15;
				}

				var36[var14] = (byte)var13;
			}
		} else {
			var12 = var9;
		}

		MusicPatchNode2[] var37 = new MusicPatchNode2[var12];

		MusicPatchNode2 var38;
		for (var14 = 0; var14 < var37.length; ++var14) {
			var38 = var37[var14] = new MusicPatchNode2();
			int var16 = var2.readUnsignedByte();
			if (var16 > 0) {
				var38.field2402 = new byte[var16 * 2];
			}

			var16 = var2.readUnsignedByte();
			if (var16 > 0) {
				var38.field2399 = new byte[var16 * 2 + 2];
				var38.field2399[1] = 64;
			}
		}

		var14 = var2.readUnsignedByte();
		byte[] var45 = var14 > 0 ? new byte[var14 * 2] : null;
		var14 = var2.readUnsignedByte();
		byte[] var39 = var14 > 0 ? new byte[var14 * 2] : null;

		int var17;
		for (var17 = 0; var2.array[var17 + var2.offset] != 0; ++var17) {
		}

		byte[] var18 = new byte[var17];

		int var19;
		for (var19 = 0; var19 < var17; ++var19) {
			var18[var19] = var2.readByte();
		}

		++var2.offset;
		++var17;
		var19 = 0;

		int var20;
		for (var20 = 0; var20 < 128; ++var20) {
			var19 += var2.readUnsignedByte();
			this.field2483[var20] = (short)var19;
		}

		var19 = 0;

		short[] var48;
		for (var20 = 0; var20 < 128; ++var20) {
			var19 += var2.readUnsignedByte();
			var48 = this.field2483;
			var48[var20] = (short)(var48[var20] + (var19 << 8));
		}

		var20 = 0;
		int var21 = 0;
		int var22 = 0;

		int var23;
		for (var23 = 0; var23 < 128; ++var23) {
			if (var20 == 0) {
				if (var21 < var18.length) {
					var20 = var18[var21++];
				} else {
					var20 = -1;
				}

				var22 = var2.readVarInt();
			}

			var48 = this.field2483;
			var48[var23] = (short)(var48[var23] + ((var22 - 1 & 2) << 14));
			this.field2489[var23] = var22;
			--var20;
		}

		var20 = 0;
		var21 = 0;
		var23 = 0;

		int var24;
		for (var24 = 0; var24 < 128; ++var24) {
			if (this.field2489[var24] != 0) {
				if (var20 == 0) {
					if (var21 < var4.length) {
						var20 = var4[var21++];
					} else {
						var20 = -1;
					}

					var23 = var2.array[var5++] - 1;
				}

				this.field2485[var24] = (byte)var23;
				--var20;
			}
		}

		var20 = 0;
		var21 = 0;
		var24 = 0;

		for (int var25 = 0; var25 < 128; ++var25) {
			if (this.field2489[var25] != 0) {
				if (var20 == 0) {
					if (var21 < var7.length) {
						var20 = var7[var21++];
					} else {
						var20 = -1;
					}

					var24 = var2.array[var8++] + 16 << 2;
				}

				this.field2482[var25] = (byte)var24;
				--var20;
			}
		}

		var20 = 0;
		var21 = 0;
		MusicPatchNode2 var40 = null;

		int var26;
		for (var26 = 0; var26 < 128; ++var26) {
			if (this.field2489[var26] != 0) {
				if (var20 == 0) {
					var40 = var37[var36[var21]];
					if (var21 < var10.length) {
						var20 = var10[var21++];
					} else {
						var20 = -1;
					}
				}

				this.field2487[var26] = var40;
				--var20;
			}
		}

		var20 = 0;
		var21 = 0;
		var26 = 0;

		int var27;
		for (var27 = 0; var27 < 128; ++var27) {
			if (var20 == 0) {
				if (var21 < var18.length) {
					var20 = var18[var21++];
				} else {
					var20 = -1;
				}

				if (this.field2489[var27] > 0) {
					var26 = var2.readUnsignedByte() + 1;
				}
			}

			this.field2486[var27] = (byte)var26;
			--var20;
		}

		this.field2488 = var2.readUnsignedByte() + 1;

		MusicPatchNode2 var28;
		int var29;
		for (var27 = 0; var27 < var12; ++var27) {
			var28 = var37[var27];
			if (var28.field2402 != null) {
				for (var29 = 1; var29 < var28.field2402.length; var29 += 2) {
					var28.field2402[var29] = var2.readByte();
				}
			}

			if (var28.field2399 != null) {
				for (var29 = 3; var29 < var28.field2399.length - 2; var29 += 2) {
					var28.field2399[var29] = var2.readByte();
				}
			}
		}

		if (var45 != null) {
			for (var27 = 1; var27 < var45.length; var27 += 2) {
				var45[var27] = var2.readByte();
			}
		}

		if (var39 != null) {
			for (var27 = 1; var27 < var39.length; var27 += 2) {
				var39[var27] = var2.readByte();
			}
		}

		for (var27 = 0; var27 < var12; ++var27) {
			var28 = var37[var27];
			if (var28.field2399 != null) {
				var19 = 0;

				for (var29 = 2; var29 < var28.field2399.length; var29 += 2) {
					var19 = var19 + 1 + var2.readUnsignedByte();
					var28.field2399[var29] = (byte)var19;
				}
			}
		}

		for (var27 = 0; var27 < var12; ++var27) {
			var28 = var37[var27];
			if (var28.field2402 != null) {
				var19 = 0;

				for (var29 = 2; var29 < var28.field2402.length; var29 += 2) {
					var19 = var19 + 1 + var2.readUnsignedByte();
					var28.field2402[var29] = (byte)var19;
				}
			}
		}

		byte var30;
		int var32;
		int var33;
		int var34;
		int var42;
		byte var44;
		if (var45 != null) {
			var19 = var2.readUnsignedByte();
			var45[0] = (byte)var19;

			for (var27 = 2; var27 < var45.length; var27 += 2) {
				var19 = 1 + var19 + var2.readUnsignedByte();
				var45[var27] = (byte)var19;
			}

			var44 = var45[0];
			byte var41 = var45[1];

			for (var29 = 0; var29 < var44; ++var29) {
				this.field2486[var29] = (byte)(var41 * this.field2486[var29] + 32 >> 6);
			}

			for (var29 = 2; var29 < var45.length; var29 += 2) {
				var30 = var45[var29];
				byte var31 = var45[var29 + 1];
				var32 = var41 * (var30 - var44) + (var30 - var44) / 2;

				for (var33 = var44; var33 < var30; ++var33) {
					var34 = WorldMapLabel.method440(var32, var30 - var44);
					this.field2486[var33] = (byte)(var34 * this.field2486[var33] + 32 >> 6);
					var32 += var31 - var41;
				}

				var44 = var30;
				var41 = var31;
			}

			for (var42 = var44; var42 < 128; ++var42) {
				this.field2486[var42] = (byte)(var41 * this.field2486[var42] + 32 >> 6);
			}

			var38 = null;
		}

		if (var39 != null) {
			var19 = var2.readUnsignedByte();
			var39[0] = (byte)var19;

			for (var27 = 2; var27 < var39.length; var27 += 2) {
				var19 = var19 + 1 + var2.readUnsignedByte();
				var39[var27] = (byte)var19;
			}

			var44 = var39[0];
			int var47 = var39[1] << 1;

			for (var29 = 0; var29 < var44; ++var29) {
				var42 = var47 + (this.field2482[var29] & 255);
				if (var42 < 0) {
					var42 = 0;
				}

				if (var42 > 128) {
					var42 = 128;
				}

				this.field2482[var29] = (byte)var42;
			}

			int var43;
			for (var29 = 2; var29 < var39.length; var29 += 2) {
				var30 = var39[var29];
				var43 = var39[var29 + 1] << 1;
				var32 = var47 * (var30 - var44) + (var30 - var44) / 2;

				for (var33 = var44; var33 < var30; ++var33) {
					var34 = WorldMapLabel.method440(var32, var30 - var44);
					int var35 = var34 + (this.field2482[var33] & 255);
					if (var35 < 0) {
						var35 = 0;
					}

					if (var35 > 128) {
						var35 = 128;
					}

					this.field2482[var33] = (byte)var35;
					var32 += var43 - var47;
				}

				var44 = var30;
				var47 = var43;
			}

			for (var42 = var44; var42 < 128; ++var42) {
				var43 = var47 + (this.field2482[var42] & 255);
				if (var43 < 0) {
					var43 = 0;
				}

				if (var43 > 128) {
					var43 = 128;
				}

				this.field2482[var42] = (byte)var43;
			}

			Object var46 = null;
		}

		for (var27 = 0; var27 < var12; ++var27) {
			var37[var27].field2404 = var2.readUnsignedByte();
		}

		for (var27 = 0; var27 < var12; ++var27) {
			var28 = var37[var27];
			if (var28.field2402 != null) {
				var28.field2401 = var2.readUnsignedByte();
			}

			if (var28.field2399 != null) {
				var28.field2400 = var2.readUnsignedByte();
			}

			if (var28.field2404 > 0) {
				var28.field2403 = var2.readUnsignedByte();
			}
		}

		for (var27 = 0; var27 < var12; ++var27) {
			var37[var27].field2405 = var2.readUnsignedByte();
		}

		for (var27 = 0; var27 < var12; ++var27) {
			var28 = var37[var27];
			if (var28.field2405 > 0) {
				var28.field2398 = var2.readUnsignedByte();
			}
		}

		for (var27 = 0; var27 < var12; ++var27) {
			var28 = var37[var27];
			if (var28.field2398 > 0) {
				var28.field2406 = var2.readUnsignedByte();
			}
		}

	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Ldv;[B[IB)Z",
		garbageValue = "83"
	)
	boolean method3952(SoundCache var1, byte[] var2, int[] var3) {
		boolean var4 = true;
		int var5 = 0;
		RawSound var6 = null;

		for (int var7 = 0; var7 < 128; ++var7) {
			if (var2 == null || var2[var7] != 0) {
				int var8 = this.field2489[var7];
				if (var8 != 0) {
					if (var5 != var8) {
						var5 = var8--;
						if ((var8 & 1) == 0) {
							var6 = var1.getSoundEffect(var8 >> 2, var3);
						} else {
							var6 = var1.getMusicSample(var8 >> 2, var3);
						}

						if (var6 == null) {
							var4 = false;
						}
					}

					if (var6 != null) {
						this.rawSounds[var7] = var6;
						this.field2489[var7] = 0;
					}
				}
			}
		}

		return var4;
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-979915375"
	)
	@Export("clear")
	void clear() {
		this.field2489 = null;
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		signature = "(ILce;ZI)I",
		garbageValue = "-1621076022"
	)
	static int method3962(int var0, Script var1, boolean var2) {
		if (var0 == ScriptOpcodes.FRIEND_COUNT) {
			if (KeyHandler.friendSystem.field1063 == 0) {
				Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = -2;
			} else if (KeyHandler.friendSystem.field1063 == 1) {
				Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = -1;
			} else {
				Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = KeyHandler.friendSystem.friendsList.getSize();
			}

			return 1;
		} else {
			int var3;
			if (var0 == ScriptOpcodes.FRIEND_GETNAME) {
				var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
				if (KeyHandler.friendSystem.method1857() && var3 >= 0 && var3 < KeyHandler.friendSystem.friendsList.getSize()) {
					Friend var8 = (Friend)KeyHandler.friendSystem.friendsList.get(var3);
					Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = var8.getName();
					Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = var8.getPreviousName();
				} else {
					Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = "";
					Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = "";
				}

				return 1;
			} else if (var0 == ScriptOpcodes.FRIEND_GETWORLD) {
				var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
				if (KeyHandler.friendSystem.method1857() && var3 >= 0 && var3 < KeyHandler.friendSystem.friendsList.getSize()) {
					Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = ((Buddy)KeyHandler.friendSystem.friendsList.get(var3)).world;
				} else {
					Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 0;
				}

				return 1;
			} else if (var0 == ScriptOpcodes.FRIEND_GETRANK) {
				var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
				if (KeyHandler.friendSystem.method1857() && var3 >= 0 && var3 < KeyHandler.friendSystem.friendsList.getSize()) {
					Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = ((Buddy)KeyHandler.friendSystem.friendsList.get(var3)).rank;
				} else {
					Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 0;
				}

				return 1;
			} else {
				String var5;
				if (var0 == ScriptOpcodes.FRIEND_SETRANK) {
					var5 = Interpreter.Interpreter_stringStack[--Message.Interpreter_stringStackSize];
					int var6 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
					BZip2State.method5833(var5, var6);
					return 1;
				} else if (var0 == ScriptOpcodes.FRIEND_ADD) {
					var5 = Interpreter.Interpreter_stringStack[--Message.Interpreter_stringStackSize];
					KeyHandler.friendSystem.addFriend(var5);
					return 1;
				} else if (var0 == ScriptOpcodes.FRIEND_DEL) {
					var5 = Interpreter.Interpreter_stringStack[--Message.Interpreter_stringStackSize];
					KeyHandler.friendSystem.removeFriend(var5);
					return 1;
				} else if (var0 == ScriptOpcodes.IGNORE_ADD) {
					var5 = Interpreter.Interpreter_stringStack[--Message.Interpreter_stringStackSize];
					KeyHandler.friendSystem.addIgnore(var5);
					return 1;
				} else if (var0 == ScriptOpcodes.IGNORE_DEL) {
					var5 = Interpreter.Interpreter_stringStack[--Message.Interpreter_stringStackSize];
					KeyHandler.friendSystem.removeIgnore(var5);
					return 1;
				} else if (var0 == ScriptOpcodes.FRIEND_TEST) {
					var5 = Interpreter.Interpreter_stringStack[--Message.Interpreter_stringStackSize];
					var5 = MouseRecorder.method1207(var5);
					Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = KeyHandler.friendSystem.isFriended(new Username(var5, class192.loginType), false) ? 1 : 0;
					return 1;
				} else if (var0 == ScriptOpcodes.CLAN_GETCHATDISPLAYNAME) {
					if (InterfaceParent.clanChat != null) {
						Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = InterfaceParent.clanChat.name;
					} else {
						Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = "";
					}

					return 1;
				} else if (var0 == ScriptOpcodes.CLAN_GETCHATCOUNT) {
					if (InterfaceParent.clanChat != null) {
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = InterfaceParent.clanChat.getSize();
					} else {
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else if (var0 == ScriptOpcodes.CLAN_GETCHATUSERNAME) {
					var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
					if (InterfaceParent.clanChat != null && var3 < InterfaceParent.clanChat.getSize()) {
						Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = InterfaceParent.clanChat.get(var3).getUsername().getName();
					} else {
						Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = "";
					}

					return 1;
				} else if (var0 == ScriptOpcodes.CLAN_GETCHATUSERWORLD) {
					var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
					if (InterfaceParent.clanChat != null && var3 < InterfaceParent.clanChat.getSize()) {
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = ((Buddy)InterfaceParent.clanChat.get(var3)).getWorld();
					} else {
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else if (var0 == ScriptOpcodes.CLAN_GETCHATUSERRANK) {
					var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
					if (InterfaceParent.clanChat != null && var3 < InterfaceParent.clanChat.getSize()) {
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = ((Buddy)InterfaceParent.clanChat.get(var3)).rank;
					} else {
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else if (var0 == ScriptOpcodes.CLAN_GETCHATMINKICK) {
					Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = InterfaceParent.clanChat != null ? InterfaceParent.clanChat.minKick : 0;
					return 1;
				} else if (var0 == ScriptOpcodes.CLAN_KICKUSER) {
					var5 = Interpreter.Interpreter_stringStack[--Message.Interpreter_stringStackSize];
					WorldMapID.clanKickUser(var5);
					return 1;
				} else if (var0 == ScriptOpcodes.CLAN_GETCHATRANK) {
					Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = InterfaceParent.clanChat != null ? InterfaceParent.clanChat.rank : 0;
					return 1;
				} else if (var0 == ScriptOpcodes.CLAN_JOINCHAT) {
					var5 = Interpreter.Interpreter_stringStack[--Message.Interpreter_stringStackSize];
					GrandExchangeOfferAgeComparator.Clan_joinChat(var5);
					return 1;
				} else if (var0 == ScriptOpcodes.CLAN_LEAVECHAT) {
					MenuAction.Clan_leaveChat();
					return 1;
				} else if (var0 == ScriptOpcodes.IGNORE_COUNT) {
					if (!KeyHandler.friendSystem.method1857()) {
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = -1;
					} else {
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = KeyHandler.friendSystem.ignoreList.getSize();
					}

					return 1;
				} else if (var0 == ScriptOpcodes.IGNORE_GETNAME) {
					var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
					if (KeyHandler.friendSystem.method1857() && var3 >= 0 && var3 < KeyHandler.friendSystem.ignoreList.getSize()) {
						Ignored var4 = (Ignored)KeyHandler.friendSystem.ignoreList.get(var3);
						Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = var4.getName();
						Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = var4.getPreviousName();
					} else {
						Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = "";
						Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = "";
					}

					return 1;
				} else if (var0 == ScriptOpcodes.IGNORE_TEST) {
					var5 = Interpreter.Interpreter_stringStack[--Message.Interpreter_stringStackSize];
					var5 = MouseRecorder.method1207(var5);
					Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = KeyHandler.friendSystem.isIgnored(new Username(var5, class192.loginType)) ? 1 : 0;
					return 1;
				} else if (var0 == ScriptOpcodes.CLAN_ISSELF) {
					var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
					if (InterfaceParent.clanChat != null && var3 < InterfaceParent.clanChat.getSize() && InterfaceParent.clanChat.get(var3).getUsername().equals(class192.localPlayer.username)) {
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 1;
					} else {
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else if (var0 == ScriptOpcodes.CLAN_GETCHATOWNERNAME) {
					if (InterfaceParent.clanChat != null && InterfaceParent.clanChat.owner != null) {
						Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = InterfaceParent.clanChat.owner;
					} else {
						Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = "";
					}

					return 1;
				} else if (var0 == ScriptOpcodes.CLAN_ISFRIEND) {
					var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
					if (InterfaceParent.clanChat != null && var3 < InterfaceParent.clanChat.getSize() && ((ClanMate)InterfaceParent.clanChat.get(var3)).isFriend()) {
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 1;
					} else {
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else if (var0 != ScriptOpcodes.CLAN_ISIGNORE) {
					if (var0 == 3628) {
						KeyHandler.friendSystem.friendsList.removeComparator();
						return 1;
					} else {
						boolean var7;
						if (var0 == 3629) {
							var7 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
							KeyHandler.friendSystem.friendsList.addComparator(new UserComparator1(var7));
							return 1;
						} else if (var0 == 3630) {
							var7 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
							KeyHandler.friendSystem.friendsList.addComparator(new UserComparator2(var7));
							return 1;
						} else if (var0 == 3631) {
							var7 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
							KeyHandler.friendSystem.friendsList.addComparator(new UserComparator3(var7));
							return 1;
						} else if (var0 == 3632) {
							var7 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
							KeyHandler.friendSystem.friendsList.addComparator(new UserComparator4(var7));
							return 1;
						} else if (var0 == 3633) {
							var7 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
							KeyHandler.friendSystem.friendsList.addComparator(new UserComparator5(var7));
							return 1;
						} else if (var0 == 3634) {
							var7 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
							KeyHandler.friendSystem.friendsList.addComparator(new UserComparator6(var7));
							return 1;
						} else if (var0 == 3635) {
							var7 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
							KeyHandler.friendSystem.friendsList.addComparator(new UserComparator7(var7));
							return 1;
						} else if (var0 == 3636) {
							var7 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
							KeyHandler.friendSystem.friendsList.addComparator(new UserComparator8(var7));
							return 1;
						} else if (var0 == 3637) {
							var7 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
							KeyHandler.friendSystem.friendsList.addComparator(new UserComparator9(var7));
							return 1;
						} else if (var0 == 3638) {
							var7 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
							KeyHandler.friendSystem.friendsList.addComparator(new UserComparator10(var7));
							return 1;
						} else if (var0 == 3639) {
							KeyHandler.friendSystem.friendsList.sort();
							return 1;
						} else if (var0 == 3640) {
							KeyHandler.friendSystem.ignoreList.removeComparator();
							return 1;
						} else if (var0 == 3641) {
							var7 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
							KeyHandler.friendSystem.ignoreList.addComparator(new UserComparator1(var7));
							return 1;
						} else if (var0 == 3642) {
							var7 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
							KeyHandler.friendSystem.ignoreList.addComparator(new UserComparator2(var7));
							return 1;
						} else if (var0 == 3643) {
							KeyHandler.friendSystem.ignoreList.sort();
							return 1;
						} else if (var0 == 3644) {
							if (InterfaceParent.clanChat != null) {
								InterfaceParent.clanChat.removeComparator();
							}

							return 1;
						} else if (var0 == 3645) {
							var7 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
							if (InterfaceParent.clanChat != null) {
								InterfaceParent.clanChat.addComparator(new UserComparator1(var7));
							}

							return 1;
						} else if (var0 == 3646) {
							var7 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
							if (InterfaceParent.clanChat != null) {
								InterfaceParent.clanChat.addComparator(new UserComparator2(var7));
							}

							return 1;
						} else if (var0 == 3647) {
							var7 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
							if (InterfaceParent.clanChat != null) {
								InterfaceParent.clanChat.addComparator(new UserComparator3(var7));
							}

							return 1;
						} else if (var0 == 3648) {
							var7 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
							if (InterfaceParent.clanChat != null) {
								InterfaceParent.clanChat.addComparator(new UserComparator4(var7));
							}

							return 1;
						} else if (var0 == 3649) {
							var7 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
							if (InterfaceParent.clanChat != null) {
								InterfaceParent.clanChat.addComparator(new UserComparator5(var7));
							}

							return 1;
						} else if (var0 == 3650) {
							var7 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
							if (InterfaceParent.clanChat != null) {
								InterfaceParent.clanChat.addComparator(new UserComparator6(var7));
							}

							return 1;
						} else if (var0 == 3651) {
							var7 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
							if (InterfaceParent.clanChat != null) {
								InterfaceParent.clanChat.addComparator(new UserComparator7(var7));
							}

							return 1;
						} else if (var0 == 3652) {
							var7 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
							if (InterfaceParent.clanChat != null) {
								InterfaceParent.clanChat.addComparator(new UserComparator8(var7));
							}

							return 1;
						} else if (var0 == 3653) {
							var7 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
							if (InterfaceParent.clanChat != null) {
								InterfaceParent.clanChat.addComparator(new UserComparator9(var7));
							}

							return 1;
						} else if (var0 == 3654) {
							var7 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
							if (InterfaceParent.clanChat != null) {
								InterfaceParent.clanChat.addComparator(new UserComparator10(var7));
							}

							return 1;
						} else if (var0 == 3655) {
							if (InterfaceParent.clanChat != null) {
								InterfaceParent.clanChat.sort();
							}

							return 1;
						} else if (var0 == 3656) {
							var7 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
							KeyHandler.friendSystem.friendsList.addComparator(new BuddyRankComparator(var7));
							return 1;
						} else if (var0 == 3657) {
							var7 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
							if (InterfaceParent.clanChat != null) {
								InterfaceParent.clanChat.addComparator(new BuddyRankComparator(var7));
							}

							return 1;
						} else {
							return 2;
						}
					}
				} else {
					var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
					if (InterfaceParent.clanChat != null && var3 < InterfaceParent.clanChat.getSize() && ((ClanMate)InterfaceParent.clanChat.get(var3)).isIgnored()) {
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 1;
					} else {
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				}
			}
		}
	}
}
