import java.util.Date;
import javax.imageio.ImageIO;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("am")
public class class49 {
	@ObfuscatedName("dt")
	@ObfuscatedSignature(
		signature = "Lio;"
	)
	@Export("archive7")
	static Archive archive7;
	@ObfuscatedName("ec")
	@ObfuscatedSignature(
		signature = "Lio;"
	)
	@Export("archive17")
	static Archive archive17;

	static {
		ImageIO.setUseCache(false);
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Lhz;IIIZI)V",
		garbageValue = "-120471549"
	)
	public static void method826(AbstractArchive var0, int var1, int var2, int var3, boolean var4) {
		class197.field2376 = 1;
		class197.musicTrackArchive = var0;
		class197.musicTrackGroupId = var1;
		class197.musicTrackFileId = var2;
		Canvas.field395 = var3;
		MouseRecorder.musicTrackBoolean = var4;
		ModelData0.field1833 = 10000;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(IIB)Lhy;",
		garbageValue = "8"
	)
	@Export("getWidgetChild")
	public static Widget getWidgetChild(int var0, int var1) {
		Widget var2 = Player.getWidget(var0);
		if (var1 == -1) {
			return var2;
		} else {
			return var2 != null && var2.children != null && var1 < var2.children.length ? var2.children[var1] : null;
		}
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Lkz;IB)V",
		garbageValue = "-1"
	)
	public static void method828(Buffer var0, int var1) {
		if (JagexCache.JagexCache_randomDat != null) {
			try {
				JagexCache.JagexCache_randomDat.seek(0L);
				JagexCache.JagexCache_randomDat.write(var0.array, var1, 24);
			} catch (Exception var3) {
			}
		}

	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		signature = "(ILcu;ZI)I",
		garbageValue = "-164032917"
	)
	static int method829(int var0, Script var1, boolean var2) {
		String var3;
		int var4;
		if (var0 == ScriptOpcodes.APPEND_NUM) {
			var3 = Interpreter.Interpreter_stringStack[--TextureProvider.Interpreter_stringStackSize];
			var4 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
			Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = var3 + var4;
			return 1;
		} else {
			String var9;
			if (var0 == ScriptOpcodes.APPEND) {
				TextureProvider.Interpreter_stringStackSize -= 2;
				var3 = Interpreter.Interpreter_stringStack[TextureProvider.Interpreter_stringStackSize];
				var9 = Interpreter.Interpreter_stringStack[TextureProvider.Interpreter_stringStackSize + 1];
				Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = var3 + var9;
				return 1;
			} else if (var0 == ScriptOpcodes.APPEND_SIGNNUM) {
				var3 = Interpreter.Interpreter_stringStack[--TextureProvider.Interpreter_stringStackSize];
				var4 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
				Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = var3 + Skeleton.intToString(var4, true);
				return 1;
			} else if (var0 == ScriptOpcodes.LOWERCASE) {
				var3 = Interpreter.Interpreter_stringStack[--TextureProvider.Interpreter_stringStackSize];
				Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = var3.toLowerCase();
				return 1;
			} else {
				int var6;
				int var10;
				if (var0 == ScriptOpcodes.FROMDATE) {
					var10 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
					long var11 = (11745L + (long)var10) * 86400000L;
					Interpreter.Interpreter_calendar.setTime(new Date(var11));
					var6 = Interpreter.Interpreter_calendar.get(5);
					int var16 = Interpreter.Interpreter_calendar.get(2);
					int var8 = Interpreter.Interpreter_calendar.get(1);
					Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = var6 + "-" + Interpreter.Interpreter_MONTHS[var16] + "-" + var8;
					return 1;
				} else if (var0 != ScriptOpcodes.TEXT_GENDER) {
					if (var0 == ScriptOpcodes.TOSTRING) {
						var10 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
						Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = Integer.toString(var10);
						return 1;
					} else if (var0 == ScriptOpcodes.COMPARE) {
						TextureProvider.Interpreter_stringStackSize -= 2;
						Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = GameShell.method951(MenuAction.compareStrings(Interpreter.Interpreter_stringStack[TextureProvider.Interpreter_stringStackSize], Interpreter.Interpreter_stringStack[TextureProvider.Interpreter_stringStackSize + 1], class43.clientLanguage));
						return 1;
					} else {
						int var5;
						byte[] var13;
						Font var14;
						if (var0 == ScriptOpcodes.PARAHEIGHT) {
							var3 = Interpreter.Interpreter_stringStack[--TextureProvider.Interpreter_stringStackSize];
							class160.Interpreter_intStackSize -= 2;
							var4 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize];
							var5 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 1];
							var13 = TextureProvider.archive13.takeFile(var5, 0);
							var14 = new Font(var13);
							Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var14.lineCount(var3, var4);
							return 1;
						} else if (var0 == ScriptOpcodes.PARAWIDTH) {
							var3 = Interpreter.Interpreter_stringStack[--TextureProvider.Interpreter_stringStackSize];
							class160.Interpreter_intStackSize -= 2;
							var4 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize];
							var5 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 1];
							var13 = TextureProvider.archive13.takeFile(var5, 0);
							var14 = new Font(var13);
							Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var14.lineWidth(var3, var4);
							return 1;
						} else if (var0 == ScriptOpcodes.TEXT_SWITCH) {
							TextureProvider.Interpreter_stringStackSize -= 2;
							var3 = Interpreter.Interpreter_stringStack[TextureProvider.Interpreter_stringStackSize];
							var9 = Interpreter.Interpreter_stringStack[TextureProvider.Interpreter_stringStackSize + 1];
							if (Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize] == 1) {
								Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = var3;
							} else {
								Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = var9;
							}

							return 1;
						} else if (var0 == ScriptOpcodes.ESCAPE) {
							var3 = Interpreter.Interpreter_stringStack[--TextureProvider.Interpreter_stringStackSize];
							Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = AbstractFont.escapeBrackets(var3);
							return 1;
						} else if (var0 == ScriptOpcodes.APPEND_CHAR) {
							var3 = Interpreter.Interpreter_stringStack[--TextureProvider.Interpreter_stringStackSize];
							var4 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
							Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = var3 + (char)var4;
							return 1;
						} else if (var0 == ScriptOpcodes.CHAR_ISPRINTABLE) {
							var10 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
							Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = MusicPatchNode2.isCharPrintable((char)var10) ? 1 : 0;
							return 1;
						} else if (var0 == ScriptOpcodes.CHAR_ISALPHANUMERIC) {
							var10 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
							Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = HealthBar.isAlphaNumeric((char)var10) ? 1 : 0;
							return 1;
						} else if (var0 == ScriptOpcodes.CHAR_ISALPHA) {
							var10 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
							Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = Client.isCharAlphabetic((char)var10) ? 1 : 0;
							return 1;
						} else if (var0 == ScriptOpcodes.CHAR_ISNUMERIC) {
							var10 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
							Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = Actor.isDigit((char)var10) ? 1 : 0;
							return 1;
						} else if (var0 == ScriptOpcodes.STRING_LENGTH) {
							var3 = Interpreter.Interpreter_stringStack[--TextureProvider.Interpreter_stringStackSize];
							if (var3 != null) {
								Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var3.length();
							} else {
								Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = 0;
							}

							return 1;
						} else if (var0 == ScriptOpcodes.SUBSTRING) {
							var3 = Interpreter.Interpreter_stringStack[--TextureProvider.Interpreter_stringStackSize];
							class160.Interpreter_intStackSize -= 2;
							var4 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize];
							var5 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 1];
							Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = var3.substring(var4, var5);
							return 1;
						} else if (var0 == ScriptOpcodes.REMOVETAGS) {
							var3 = Interpreter.Interpreter_stringStack[--TextureProvider.Interpreter_stringStackSize];
							StringBuilder var17 = new StringBuilder(var3.length());
							boolean var15 = false;

							for (var6 = 0; var6 < var3.length(); ++var6) {
								char var7 = var3.charAt(var6);
								if (var7 == '<') {
									var15 = true;
								} else if (var7 == '>') {
									var15 = false;
								} else if (!var15) {
									var17.append(var7);
								}
							}

							Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = var17.toString();
							return 1;
						} else if (var0 == ScriptOpcodes.STRING_INDEXOF_CHAR) {
							var3 = Interpreter.Interpreter_stringStack[--TextureProvider.Interpreter_stringStackSize];
							var4 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
							Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var3.indexOf(var4);
							return 1;
						} else if (var0 == ScriptOpcodes.STRING_INDEXOF_STRING) {
							TextureProvider.Interpreter_stringStackSize -= 2;
							var3 = Interpreter.Interpreter_stringStack[TextureProvider.Interpreter_stringStackSize];
							var9 = Interpreter.Interpreter_stringStack[TextureProvider.Interpreter_stringStackSize + 1];
							var5 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
							Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var3.indexOf(var9, var5);
							return 1;
						} else if (var0 == ScriptOpcodes.UPPERCASE) {
							var3 = Interpreter.Interpreter_stringStack[--TextureProvider.Interpreter_stringStackSize];
							Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = var3.toUpperCase();
							return 1;
						} else {
							return 2;
						}
					}
				} else {
					TextureProvider.Interpreter_stringStackSize -= 2;
					var3 = Interpreter.Interpreter_stringStack[TextureProvider.Interpreter_stringStackSize];
					var9 = Interpreter.Interpreter_stringStack[TextureProvider.Interpreter_stringStackSize + 1];
					if (Varps.localPlayer.appearance != null && Varps.localPlayer.appearance.isFemale) {
						Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = var9;
					} else {
						Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = var3;
					}

					return 1;
				}
			}
		}
	}

	@ObfuscatedName("ja")
	@ObfuscatedSignature(
		signature = "(Lhy;S)Z",
		garbageValue = "1376"
	)
	static final boolean method825(Widget var0) {
		int var1 = var0.contentType;
		if (var1 == 205) {
			Client.logoutTimer = 250;
			return true;
		} else {
			int var2;
			int var3;
			if (var1 >= 300 && var1 <= 313) {
				var2 = (var1 - 300) / 2;
				var3 = var1 & 1;
				Client.playerAppearance.changeAppearance(var2, var3 == 1);
			}

			if (var1 >= 314 && var1 <= 323) {
				var2 = (var1 - 314) / 2;
				var3 = var1 & 1;
				Client.playerAppearance.method3983(var2, var3 == 1);
			}

			if (var1 == 324) {
				Client.playerAppearance.changeSex(false);
			}

			if (var1 == 325) {
				Client.playerAppearance.changeSex(true);
			}

			if (var1 == 326) {
				PacketBufferNode var4 = MenuAction.getPacketBufferNode(ClientPacket.field2263, Client.packetWriter.isaacCipher);
				Client.playerAppearance.write(var4.packetBuffer);
				Client.packetWriter.addNode(var4);
				return true;
			} else {
				return false;
			}
		}
	}
}
