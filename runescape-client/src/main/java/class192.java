import java.util.HashSet;
import java.util.Set;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("gm")
public enum class192 implements Enumerated {
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "Lgm;"
	)
	field2360("", 0, new class191[]{class191.field2346}),
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Lgm;"
	)
	field2350("", 1, new class191[]{class191.field2345, class191.field2346}),
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lgm;"
	)
	field2363("", 2, new class191[]{class191.field2345, class191.field2347, class191.field2346}),
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lgm;"
	)
	field2361("", 3, new class191[]{class191.field2345}),
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lgm;"
	)
	field2367("", 4),
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lgm;"
	)
	field2351("", 5, new class191[]{class191.field2345, class191.field2346}),
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lgm;"
	)
	field2355("", 6, new class191[]{class191.field2346}),
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lgm;"
	)
	field2356("", 8, new class191[]{class191.field2345, class191.field2346}),
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lgm;"
	)
	field2357("", 9, new class191[]{class191.field2345, class191.field2347}),
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Lgm;"
	)
	field2358("", 10, new class191[]{class191.field2345}),
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lgm;"
	)
	field2359("", 11, new class191[]{class191.field2345}),
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lgm;"
	)
	field2354("", 12, new class191[]{class191.field2345, class191.field2346}),
	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "Lgm;"
	)
	field2366("", 13, new class191[]{class191.field2345});

	@ObfuscatedName("es")
	static int[] field2365;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = 100373977
	)
	@Export("id")
	final int id;
	@ObfuscatedName("p")
	final Set field2352;

	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I[Lgr;)V"
	)
	class192(String var3, int var4, class191[] var5) {
		this.field2352 = new HashSet();
		this.id = var4;
		class191[] var6 = var5;

		for (int var7 = 0; var7 < var6.length; ++var7) {
			class191 var8 = var6[var7];
			this.field2352.add(var8);
		}

	}

	class192(String var3, int var4) {
		this.field2352 = new HashSet();
		this.id = var4;
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "-32"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(Lhz;I)V",
		garbageValue = "-2116157785"
	)
	public static void method3614(AbstractArchive var0) {
		VarbitDefinition.VarbitDefinition_archive = var0;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-140231108"
	)
	public static void method3617() {
		synchronized(MouseHandler.MouseHandler_instance) {
			MouseHandler.MouseHandler_currentButton = MouseHandler.MouseHandler_currentButtonVolatile;
			MouseHandler.MouseHandler_x = MouseHandler.MouseHandler_xVolatile;
			MouseHandler.MouseHandler_y = MouseHandler.MouseHandler_yVolatile;
			MouseHandler.MouseHandler_millis = MouseHandler.MouseHandler_lastMovedVolatile;
			MouseHandler.MouseHandler_lastButton = MouseHandler.MouseHandler_lastButtonVolatile;
			MouseHandler.MouseHandler_lastPressedX = MouseHandler.MouseHandler_lastPressedXVolatile;
			MouseHandler.MouseHandler_lastPressedY = MouseHandler.MouseHandler_lastPressedYVolatile;
			MouseHandler.MouseHandler_lastPressedTimeMillis = MouseHandler.MouseHandler_lastPressedTimeMillisVolatile;
			MouseHandler.MouseHandler_lastButtonVolatile = 0;
		}
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		signature = "(ILcr;ZI)I",
		garbageValue = "-2145329463"
	)
	static int method3616(int var0, Script var1, boolean var2) {
		if (var0 == ScriptOpcodes.FRIEND_COUNT) {
			if (class32.friendSystem.field1045 == 0) {
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -2;
			} else if (class32.friendSystem.field1045 == 1) {
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
			} else {
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class32.friendSystem.friendsList.getSize();
			}

			return 1;
		} else {
			int var3;
			if (var0 == ScriptOpcodes.FRIEND_GETNAME) {
				var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				if (class32.friendSystem.method1773() && var3 >= 0 && var3 < class32.friendSystem.friendsList.getSize()) {
					Friend var8 = (Friend)class32.friendSystem.friendsList.get(var3);
					Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var8.getName();
					Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var8.getPreviousName();
				} else {
					Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
					Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
				}

				return 1;
			} else if (var0 == ScriptOpcodes.FRIEND_GETWORLD) {
				var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				if (class32.friendSystem.method1773() && var3 >= 0 && var3 < class32.friendSystem.friendsList.getSize()) {
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = ((Buddy)class32.friendSystem.friendsList.get(var3)).world;
				} else {
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
				}

				return 1;
			} else if (var0 == ScriptOpcodes.FRIEND_GETRANK) {
				var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				if (class32.friendSystem.method1773() && var3 >= 0 && var3 < class32.friendSystem.friendsList.getSize()) {
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = ((Buddy)class32.friendSystem.friendsList.get(var3)).rank;
				} else {
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
				}

				return 1;
			} else {
				String var5;
				if (var0 == ScriptOpcodes.FRIEND_SETRANK) {
					var5 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
					int var6 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
					WorldMapRectangle.method281(var5, var6);
					return 1;
				} else if (var0 == ScriptOpcodes.FRIEND_ADD) {
					var5 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
					class32.friendSystem.addFriend(var5);
					return 1;
				} else if (var0 == ScriptOpcodes.FRIEND_DEL) {
					var5 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
					class32.friendSystem.removeFriend(var5);
					return 1;
				} else if (var0 == ScriptOpcodes.IGNORE_ADD) {
					var5 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
					class32.friendSystem.addIgnore(var5);
					return 1;
				} else if (var0 == ScriptOpcodes.IGNORE_DEL) {
					var5 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
					class32.friendSystem.removeIgnore(var5);
					return 1;
				} else if (var0 == ScriptOpcodes.FRIEND_TEST) {
					var5 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
					var5 = NetSocket.method3489(var5);
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class32.friendSystem.isFriended(new Username(var5, FontName.loginType), false) ? 1 : 0;
					return 1;
				} else if (var0 == ScriptOpcodes.CLAN_GETCHATDISPLAYNAME) {
					if (Client.clanChat != null) {
						Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = Client.clanChat.name;
					} else {
						Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
					}

					return 1;
				} else if (var0 == ScriptOpcodes.CLAN_GETCHATCOUNT) {
					if (Client.clanChat != null) {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.clanChat.getSize();
					} else {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else if (var0 == ScriptOpcodes.CLAN_GETCHATUSERNAME) {
					var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
					if (Client.clanChat != null && var3 < Client.clanChat.getSize()) {
						Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = Client.clanChat.get(var3).getUsername().getName();
					} else {
						Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
					}

					return 1;
				} else if (var0 == ScriptOpcodes.CLAN_GETCHATUSERWORLD) {
					var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
					if (Client.clanChat != null && var3 < Client.clanChat.getSize()) {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = ((Buddy)Client.clanChat.get(var3)).getWorld();
					} else {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else if (var0 == ScriptOpcodes.CLAN_GETCHATUSERRANK) {
					var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
					if (Client.clanChat != null && var3 < Client.clanChat.getSize()) {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = ((Buddy)Client.clanChat.get(var3)).rank;
					} else {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else if (var0 == ScriptOpcodes.CLAN_GETCHATMINKICK) {
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.clanChat != null ? Client.clanChat.minKick : 0;
					return 1;
				} else if (var0 == ScriptOpcodes.CLAN_KICKUSER) {
					var5 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
					WorldMapCacheName.clanKickUser(var5);
					return 1;
				} else if (var0 == ScriptOpcodes.CLAN_GETCHATRANK) {
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.clanChat != null ? Client.clanChat.rank : 0;
					return 1;
				} else if (var0 == ScriptOpcodes.CLAN_JOINCHAT) {
					var5 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
					class227.Clan_joinChat(var5);
					return 1;
				} else if (var0 == ScriptOpcodes.CLAN_LEAVECHAT) {
					Tiles.Clan_leaveChat();
					return 1;
				} else if (var0 == ScriptOpcodes.IGNORE_COUNT) {
					if (!class32.friendSystem.method1773()) {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
					} else {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class32.friendSystem.ignoreList.getSize();
					}

					return 1;
				} else if (var0 == ScriptOpcodes.IGNORE_GETNAME) {
					var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
					if (class32.friendSystem.method1773() && var3 >= 0 && var3 < class32.friendSystem.ignoreList.getSize()) {
						Ignored var4 = (Ignored)class32.friendSystem.ignoreList.get(var3);
						Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var4.getName();
						Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var4.getPreviousName();
					} else {
						Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
						Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
					}

					return 1;
				} else if (var0 == ScriptOpcodes.IGNORE_TEST) {
					var5 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
					var5 = NetSocket.method3489(var5);
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class32.friendSystem.isIgnored(new Username(var5, FontName.loginType)) ? 1 : 0;
					return 1;
				} else if (var0 == ScriptOpcodes.CLAN_ISSELF) {
					var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
					if (Client.clanChat != null && var3 < Client.clanChat.getSize() && Client.clanChat.get(var3).getUsername().equals(WorldMapIcon_1.localPlayer.username)) {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 1;
					} else {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else if (var0 == ScriptOpcodes.CLAN_GETCHATOWNERNAME) {
					if (Client.clanChat != null && Client.clanChat.owner != null) {
						Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = Client.clanChat.owner;
					} else {
						Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
					}

					return 1;
				} else if (var0 == ScriptOpcodes.CLAN_ISFRIEND) {
					var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
					if (Client.clanChat != null && var3 < Client.clanChat.getSize() && ((ClanMate)Client.clanChat.get(var3)).isFriend()) {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 1;
					} else {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else if (var0 != ScriptOpcodes.CLAN_ISIGNORE) {
					if (var0 == 3628) {
						class32.friendSystem.friendsList.removeComparator();
						return 1;
					} else {
						boolean var7;
						if (var0 == 3629) {
							var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
							class32.friendSystem.friendsList.addComparator(new UserComparator1(var7));
							return 1;
						} else if (var0 == 3630) {
							var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
							class32.friendSystem.friendsList.addComparator(new UserComparator2(var7));
							return 1;
						} else if (var0 == 3631) {
							var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
							class32.friendSystem.friendsList.addComparator(new UserComparator3(var7));
							return 1;
						} else if (var0 == 3632) {
							var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
							class32.friendSystem.friendsList.addComparator(new UserComparator4(var7));
							return 1;
						} else if (var0 == 3633) {
							var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
							class32.friendSystem.friendsList.addComparator(new UserComparator5(var7));
							return 1;
						} else if (var0 == 3634) {
							var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
							class32.friendSystem.friendsList.addComparator(new UserComparator6(var7));
							return 1;
						} else if (var0 == 3635) {
							var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
							class32.friendSystem.friendsList.addComparator(new UserComparator7(var7));
							return 1;
						} else if (var0 == 3636) {
							var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
							class32.friendSystem.friendsList.addComparator(new UserComparator8(var7));
							return 1;
						} else if (var0 == 3637) {
							var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
							class32.friendSystem.friendsList.addComparator(new UserComparator9(var7));
							return 1;
						} else if (var0 == 3638) {
							var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
							class32.friendSystem.friendsList.addComparator(new UserComparator10(var7));
							return 1;
						} else if (var0 == 3639) {
							class32.friendSystem.friendsList.sort();
							return 1;
						} else if (var0 == 3640) {
							class32.friendSystem.ignoreList.removeComparator();
							return 1;
						} else if (var0 == 3641) {
							var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
							class32.friendSystem.ignoreList.addComparator(new UserComparator1(var7));
							return 1;
						} else if (var0 == 3642) {
							var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
							class32.friendSystem.ignoreList.addComparator(new UserComparator2(var7));
							return 1;
						} else if (var0 == 3643) {
							class32.friendSystem.ignoreList.sort();
							return 1;
						} else if (var0 == 3644) {
							if (Client.clanChat != null) {
								Client.clanChat.removeComparator();
							}

							return 1;
						} else if (var0 == 3645) {
							var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
							if (Client.clanChat != null) {
								Client.clanChat.addComparator(new UserComparator1(var7));
							}

							return 1;
						} else if (var0 == 3646) {
							var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
							if (Client.clanChat != null) {
								Client.clanChat.addComparator(new UserComparator2(var7));
							}

							return 1;
						} else if (var0 == 3647) {
							var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
							if (Client.clanChat != null) {
								Client.clanChat.addComparator(new UserComparator3(var7));
							}

							return 1;
						} else if (var0 == 3648) {
							var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
							if (Client.clanChat != null) {
								Client.clanChat.addComparator(new UserComparator4(var7));
							}

							return 1;
						} else if (var0 == 3649) {
							var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
							if (Client.clanChat != null) {
								Client.clanChat.addComparator(new UserComparator5(var7));
							}

							return 1;
						} else if (var0 == 3650) {
							var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
							if (Client.clanChat != null) {
								Client.clanChat.addComparator(new UserComparator6(var7));
							}

							return 1;
						} else if (var0 == 3651) {
							var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
							if (Client.clanChat != null) {
								Client.clanChat.addComparator(new UserComparator7(var7));
							}

							return 1;
						} else if (var0 == 3652) {
							var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
							if (Client.clanChat != null) {
								Client.clanChat.addComparator(new UserComparator8(var7));
							}

							return 1;
						} else if (var0 == 3653) {
							var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
							if (Client.clanChat != null) {
								Client.clanChat.addComparator(new UserComparator9(var7));
							}

							return 1;
						} else if (var0 == 3654) {
							var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
							if (Client.clanChat != null) {
								Client.clanChat.addComparator(new UserComparator10(var7));
							}

							return 1;
						} else if (var0 == 3655) {
							if (Client.clanChat != null) {
								Client.clanChat.sort();
							}

							return 1;
						} else if (var0 == 3656) {
							var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
							class32.friendSystem.friendsList.addComparator(new BuddyRankComparator(var7));
							return 1;
						} else if (var0 == 3657) {
							var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
							if (Client.clanChat != null) {
								Client.clanChat.addComparator(new BuddyRankComparator(var7));
							}

							return 1;
						} else {
							return 2;
						}
					}
				} else {
					var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
					if (Client.clanChat != null && var3 < Client.clanChat.getSize() && ((ClanMate)Client.clanChat.get(var3)).isIgnored()) {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 1;
					} else {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				}
			}
		}
	}
}
