import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("cq")
@Implements("MenuAction")
public class MenuAction {
	@ObfuscatedName("c")
	@Export("Tiles_saturation")
	static int[] Tiles_saturation;
	@ObfuscatedName("ap")
	@ObfuscatedGetter(
		intValue = 1017693045
	)
	static int field1133;
	@ObfuscatedName("fv")
	@ObfuscatedSignature(
		signature = "Lfu;"
	)
	@Export("socketTask")
	static Task socketTask;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = 1602431119
	)
	@Export("param0")
	int param0;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 2095911709
	)
	@Export("param1")
	int param1;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = -1872419161
	)
	@Export("opcode")
	int opcode;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -445186717
	)
	@Export("identifier")
	int identifier;
	@ObfuscatedName("p")
	@Export("action")
	String action;

	MenuAction() {
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(I)[B",
		garbageValue = "-369177149"
	)
	public static byte[] method2068() {
		byte[] var0 = new byte[24];

		try {
			JagexCache.JagexCache_randomDat.seek(0L);
			JagexCache.JagexCache_randomDat.readFully(var0);

			int var1;
			for (var1 = 0; var1 < 24 && var0[var1] == 0; ++var1) {
			}

			if (var1 >= 24) {
				throw new IOException();
			}
		} catch (Exception var4) {
			for (int var2 = 0; var2 < 24; ++var2) {
				var0[var2] = -1;
			}
		}

		return var0;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		signature = "(ILcu;ZI)I",
		garbageValue = "-1293771000"
	)
	static int method2069(int var0, Script var1, boolean var2) {
		if (var0 == ScriptOpcodes.FRIEND_COUNT) {
			if (Message.friendSystem.field1045 == 0) {
				Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = -2;
			} else if (Message.friendSystem.field1045 == 1) {
				Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = -1;
			} else {
				Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = Message.friendSystem.friendsList.getSize();
			}

			return 1;
		} else {
			int var3;
			if (var0 == ScriptOpcodes.FRIEND_GETNAME) {
				var3 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
				if (Message.friendSystem.method1844() && var3 >= 0 && var3 < Message.friendSystem.friendsList.getSize()) {
					Friend var8 = (Friend)Message.friendSystem.friendsList.get(var3);
					Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = var8.getName();
					Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = var8.getPreviousName();
				} else {
					Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = "";
					Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = "";
				}

				return 1;
			} else if (var0 == ScriptOpcodes.FRIEND_GETWORLD) {
				var3 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
				if (Message.friendSystem.method1844() && var3 >= 0 && var3 < Message.friendSystem.friendsList.getSize()) {
					Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = ((Buddy)Message.friendSystem.friendsList.get(var3)).world;
				} else {
					Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = 0;
				}

				return 1;
			} else if (var0 == ScriptOpcodes.FRIEND_GETRANK) {
				var3 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
				if (Message.friendSystem.method1844() && var3 >= 0 && var3 < Message.friendSystem.friendsList.getSize()) {
					Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = ((Buddy)Message.friendSystem.friendsList.get(var3)).rank;
				} else {
					Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = 0;
				}

				return 1;
			} else {
				String var5;
				if (var0 == ScriptOpcodes.FRIEND_SETRANK) {
					var5 = Interpreter.Interpreter_stringStack[--class65.Interpreter_stringStackSize];
					int var6 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
					BoundaryObject.method3274(var5, var6);
					return 1;
				} else if (var0 == ScriptOpcodes.FRIEND_ADD) {
					var5 = Interpreter.Interpreter_stringStack[--class65.Interpreter_stringStackSize];
					Message.friendSystem.addFriend(var5);
					return 1;
				} else if (var0 == ScriptOpcodes.FRIEND_DEL) {
					var5 = Interpreter.Interpreter_stringStack[--class65.Interpreter_stringStackSize];
					Message.friendSystem.removeFriend(var5);
					return 1;
				} else if (var0 == ScriptOpcodes.IGNORE_ADD) {
					var5 = Interpreter.Interpreter_stringStack[--class65.Interpreter_stringStackSize];
					Message.friendSystem.addIgnore(var5);
					return 1;
				} else if (var0 == ScriptOpcodes.IGNORE_DEL) {
					var5 = Interpreter.Interpreter_stringStack[--class65.Interpreter_stringStackSize];
					Message.friendSystem.removeIgnore(var5);
					return 1;
				} else if (var0 == ScriptOpcodes.FRIEND_TEST) {
					var5 = Interpreter.Interpreter_stringStack[--class65.Interpreter_stringStackSize];
					var5 = WorldMapManager.method662(var5);
					Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = Message.friendSystem.isFriended(new Username(var5, class188.loginType), false) ? 1 : 0;
					return 1;
				} else if (var0 == ScriptOpcodes.CLAN_GETCHATDISPLAYNAME) {
					if (Calendar.clanChat != null) {
						Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = Calendar.clanChat.name;
					} else {
						Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = "";
					}

					return 1;
				} else if (var0 == ScriptOpcodes.CLAN_GETCHATCOUNT) {
					if (Calendar.clanChat != null) {
						Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = Calendar.clanChat.getSize();
					} else {
						Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else if (var0 == ScriptOpcodes.CLAN_GETCHATUSERNAME) {
					var3 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
					if (Calendar.clanChat != null && var3 < Calendar.clanChat.getSize()) {
						Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = Calendar.clanChat.get(var3).getUsername().getName();
					} else {
						Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = "";
					}

					return 1;
				} else if (var0 == ScriptOpcodes.CLAN_GETCHATUSERWORLD) {
					var3 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
					if (Calendar.clanChat != null && var3 < Calendar.clanChat.getSize()) {
						Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = ((Buddy)Calendar.clanChat.get(var3)).getWorld();
					} else {
						Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else if (var0 == ScriptOpcodes.CLAN_GETCHATUSERRANK) {
					var3 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
					if (Calendar.clanChat != null && var3 < Calendar.clanChat.getSize()) {
						Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = ((Buddy)Calendar.clanChat.get(var3)).rank;
					} else {
						Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else if (var0 == ScriptOpcodes.CLAN_GETCHATMINKICK) {
					Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = Calendar.clanChat != null ? Calendar.clanChat.minKick : 0;
					return 1;
				} else if (var0 == ScriptOpcodes.CLAN_KICKUSER) {
					var5 = Interpreter.Interpreter_stringStack[--class65.Interpreter_stringStackSize];
					WorldMapIcon_1.clanKickUser(var5);
					return 1;
				} else if (var0 == ScriptOpcodes.CLAN_GETCHATRANK) {
					Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = Calendar.clanChat != null ? Calendar.clanChat.rank : 0;
					return 1;
				} else if (var0 == ScriptOpcodes.CLAN_JOINCHAT) {
					var5 = Interpreter.Interpreter_stringStack[--class65.Interpreter_stringStackSize];
					WorldMapSection2.Clan_joinChat(var5);
					return 1;
				} else if (var0 == ScriptOpcodes.CLAN_LEAVECHAT) {
					class3.Clan_leaveChat();
					return 1;
				} else if (var0 == ScriptOpcodes.IGNORE_COUNT) {
					if (!Message.friendSystem.method1844()) {
						Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = -1;
					} else {
						Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = Message.friendSystem.ignoreList.getSize();
					}

					return 1;
				} else if (var0 == ScriptOpcodes.IGNORE_GETNAME) {
					var3 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
					if (Message.friendSystem.method1844() && var3 >= 0 && var3 < Message.friendSystem.ignoreList.getSize()) {
						Ignored var4 = (Ignored)Message.friendSystem.ignoreList.get(var3);
						Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = var4.getName();
						Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = var4.getPreviousName();
					} else {
						Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = "";
						Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = "";
					}

					return 1;
				} else if (var0 == ScriptOpcodes.IGNORE_TEST) {
					var5 = Interpreter.Interpreter_stringStack[--class65.Interpreter_stringStackSize];
					var5 = WorldMapManager.method662(var5);
					Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = Message.friendSystem.isIgnored(new Username(var5, class188.loginType)) ? 1 : 0;
					return 1;
				} else if (var0 == ScriptOpcodes.CLAN_ISSELF) {
					var3 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
					if (Calendar.clanChat != null && var3 < Calendar.clanChat.getSize() && Calendar.clanChat.get(var3).getUsername().equals(Message.localPlayer.username)) {
						Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = 1;
					} else {
						Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else if (var0 == ScriptOpcodes.CLAN_GETCHATOWNERNAME) {
					if (Calendar.clanChat != null && Calendar.clanChat.owner != null) {
						Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = Calendar.clanChat.owner;
					} else {
						Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = "";
					}

					return 1;
				} else if (var0 == ScriptOpcodes.CLAN_ISFRIEND) {
					var3 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
					if (Calendar.clanChat != null && var3 < Calendar.clanChat.getSize() && ((ClanMate)Calendar.clanChat.get(var3)).isFriend()) {
						Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = 1;
					} else {
						Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else if (var0 != ScriptOpcodes.CLAN_ISIGNORE) {
					if (var0 == 3628) {
						Message.friendSystem.friendsList.removeComparator();
						return 1;
					} else {
						boolean var7;
						if (var0 == 3629) {
							var7 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize] == 1;
							Message.friendSystem.friendsList.addComparator(new UserComparator1(var7));
							return 1;
						} else if (var0 == 3630) {
							var7 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize] == 1;
							Message.friendSystem.friendsList.addComparator(new UserComparator2(var7));
							return 1;
						} else if (var0 == 3631) {
							var7 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize] == 1;
							Message.friendSystem.friendsList.addComparator(new UserComparator3(var7));
							return 1;
						} else if (var0 == 3632) {
							var7 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize] == 1;
							Message.friendSystem.friendsList.addComparator(new UserComparator4(var7));
							return 1;
						} else if (var0 == 3633) {
							var7 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize] == 1;
							Message.friendSystem.friendsList.addComparator(new UserComparator5(var7));
							return 1;
						} else if (var0 == 3634) {
							var7 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize] == 1;
							Message.friendSystem.friendsList.addComparator(new UserComparator6(var7));
							return 1;
						} else if (var0 == 3635) {
							var7 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize] == 1;
							Message.friendSystem.friendsList.addComparator(new UserComparator7(var7));
							return 1;
						} else if (var0 == 3636) {
							var7 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize] == 1;
							Message.friendSystem.friendsList.addComparator(new UserComparator8(var7));
							return 1;
						} else if (var0 == 3637) {
							var7 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize] == 1;
							Message.friendSystem.friendsList.addComparator(new UserComparator9(var7));
							return 1;
						} else if (var0 == 3638) {
							var7 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize] == 1;
							Message.friendSystem.friendsList.addComparator(new UserComparator10(var7));
							return 1;
						} else if (var0 == 3639) {
							Message.friendSystem.friendsList.sort();
							return 1;
						} else if (var0 == 3640) {
							Message.friendSystem.ignoreList.removeComparator();
							return 1;
						} else if (var0 == 3641) {
							var7 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize] == 1;
							Message.friendSystem.ignoreList.addComparator(new UserComparator1(var7));
							return 1;
						} else if (var0 == 3642) {
							var7 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize] == 1;
							Message.friendSystem.ignoreList.addComparator(new UserComparator2(var7));
							return 1;
						} else if (var0 == 3643) {
							Message.friendSystem.ignoreList.sort();
							return 1;
						} else if (var0 == 3644) {
							if (Calendar.clanChat != null) {
								Calendar.clanChat.removeComparator();
							}

							return 1;
						} else if (var0 == 3645) {
							var7 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize] == 1;
							if (Calendar.clanChat != null) {
								Calendar.clanChat.addComparator(new UserComparator1(var7));
							}

							return 1;
						} else if (var0 == 3646) {
							var7 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize] == 1;
							if (Calendar.clanChat != null) {
								Calendar.clanChat.addComparator(new UserComparator2(var7));
							}

							return 1;
						} else if (var0 == 3647) {
							var7 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize] == 1;
							if (Calendar.clanChat != null) {
								Calendar.clanChat.addComparator(new UserComparator3(var7));
							}

							return 1;
						} else if (var0 == 3648) {
							var7 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize] == 1;
							if (Calendar.clanChat != null) {
								Calendar.clanChat.addComparator(new UserComparator4(var7));
							}

							return 1;
						} else if (var0 == 3649) {
							var7 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize] == 1;
							if (Calendar.clanChat != null) {
								Calendar.clanChat.addComparator(new UserComparator5(var7));
							}

							return 1;
						} else if (var0 == 3650) {
							var7 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize] == 1;
							if (Calendar.clanChat != null) {
								Calendar.clanChat.addComparator(new UserComparator6(var7));
							}

							return 1;
						} else if (var0 == 3651) {
							var7 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize] == 1;
							if (Calendar.clanChat != null) {
								Calendar.clanChat.addComparator(new UserComparator7(var7));
							}

							return 1;
						} else if (var0 == 3652) {
							var7 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize] == 1;
							if (Calendar.clanChat != null) {
								Calendar.clanChat.addComparator(new UserComparator8(var7));
							}

							return 1;
						} else if (var0 == 3653) {
							var7 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize] == 1;
							if (Calendar.clanChat != null) {
								Calendar.clanChat.addComparator(new UserComparator9(var7));
							}

							return 1;
						} else if (var0 == 3654) {
							var7 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize] == 1;
							if (Calendar.clanChat != null) {
								Calendar.clanChat.addComparator(new UserComparator10(var7));
							}

							return 1;
						} else if (var0 == 3655) {
							if (Calendar.clanChat != null) {
								Calendar.clanChat.sort();
							}

							return 1;
						} else if (var0 == 3656) {
							var7 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize] == 1;
							Message.friendSystem.friendsList.addComparator(new BuddyRankComparator(var7));
							return 1;
						} else if (var0 == 3657) {
							var7 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize] == 1;
							if (Calendar.clanChat != null) {
								Calendar.clanChat.addComparator(new BuddyRankComparator(var7));
							}

							return 1;
						} else {
							return 2;
						}
					}
				} else {
					var3 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
					if (Calendar.clanChat != null && var3 < Calendar.clanChat.getSize() && ((ClanMate)Calendar.clanChat.get(var3)).isIgnored()) {
						Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = 1;
					} else {
						Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				}
			}
		}
	}
}
