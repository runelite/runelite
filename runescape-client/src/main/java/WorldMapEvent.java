import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("ag")
@Implements("WorldMapEvent")
public class WorldMapEvent {
	@ObfuscatedName("sr")
	@Export("foundItemIds")
	static short[] foundItemIds;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 46773257
	)
	@Export("mapElement")
	public int mapElement;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Lhj;"
	)
	@Export("coord1")
	public Coord coord1;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lhj;"
	)
	@Export("coord2")
	public Coord coord2;

	@ObfuscatedSignature(
		signature = "(ILhj;Lhj;)V"
	)
	public WorldMapEvent(int var1, Coord var2, Coord var3) {
		this.mapElement = var1;
		this.coord1 = var2;
		this.coord2 = var3;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(II)J",
		garbageValue = "984846325"
	)
	public static long method868(int var0) {
		return ViewportMouse.ViewportMouse_entityTags[var0];
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-5"
	)
	static void method864() {
		Login.Login_username = Login.Login_username.trim();
		if (Login.Login_username.length() == 0) {
			HealthBarUpdate.setLoginResponseString("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
		} else {
			long var1;
			try {
				URL var3 = new URL(class41.method654("services", false) + "m=accountappeal/login.ws");
				URLConnection var4 = var3.openConnection();
				var4.setRequestProperty("connection", "close");
				var4.setDoInput(true);
				var4.setDoOutput(true);
				var4.setConnectTimeout(5000);
				OutputStreamWriter var5 = new OutputStreamWriter(var4.getOutputStream());
				var5.write("data1=req");
				var5.flush();
				InputStream var6 = var4.getInputStream();
				Buffer var7 = new Buffer(new byte[1000]);

				while (true) {
					int var8 = var6.read(var7.array, var7.offset, 1000 - var7.offset);
					if (var8 == -1) {
						var7.offset = 0;
						long var22 = var7.readLong();
						var1 = var22;
						break;
					}

					var7.offset += var8;
					if (var7.offset >= 1000) {
						var1 = 0L;
						break;
					}
				}
			} catch (Exception var32) {
				var1 = 0L;
			}

			byte var0;
			if (0L == var1) {
				var0 = 5;
			} else {
				String var33 = Login.Login_username;
				Random var34 = new Random();
				Buffer var26 = new Buffer(128);
				Buffer var9 = new Buffer(128);
				int[] var10 = new int[]{var34.nextInt(), var34.nextInt(), (int)(var1 >> 32), (int)var1};
				var26.writeByte(10);

				int var11;
				for (var11 = 0; var11 < 4; ++var11) {
					var26.writeInt(var34.nextInt());
				}

				var26.writeInt(var10[0]);
				var26.writeInt(var10[1]);
				var26.writeLong(var1);
				var26.writeLong(0L);

				for (var11 = 0; var11 < 4; ++var11) {
					var26.writeInt(var34.nextInt());
				}

				var26.encryptRsa(class89.field1158, class89.field1155);
				var9.writeByte(10);

				for (var11 = 0; var11 < 3; ++var11) {
					var9.writeInt(var34.nextInt());
				}

				var9.writeLong(var34.nextLong());
				var9.writeLongMedium(var34.nextLong());
				if (Client.randomDatData != null) {
					var9.writeBytes(Client.randomDatData, 0, Client.randomDatData.length);
				} else {
					byte[] var27 = GraphicsObject.method2120();
					var9.writeBytes(var27, 0, var27.length);
				}

				var9.writeLong(var34.nextLong());
				var9.encryptRsa(class89.field1158, class89.field1155);
				var11 = class234.stringCp1252NullTerminatedByteSize(var33);
				if (var11 % 8 != 0) {
					var11 += 8 - var11 % 8;
				}

				Buffer var12 = new Buffer(var11);
				var12.writeStringCp1252NullTerminated(var33);
				var12.offset = var11;
				var12.xteaEncryptAll(var10);
				Buffer var13 = new Buffer(var12.offset + var26.offset + var9.offset + 5);
				var13.writeByte(2);
				var13.writeByte(var26.offset);
				var13.writeBytes(var26.array, 0, var26.offset);
				var13.writeByte(var9.offset);
				var13.writeBytes(var9.array, 0, var9.offset);
				var13.writeShort(var12.offset);
				var13.writeBytes(var12.array, 0, var12.offset);
				String var14 = StudioGame.method4242(var13.array);

				byte var28;
				try {
					URL var15 = new URL(class41.method654("services", false) + "m=accountappeal/login.ws");
					URLConnection var16 = var15.openConnection();
					var16.setDoInput(true);
					var16.setDoOutput(true);
					var16.setConnectTimeout(5000);
					OutputStreamWriter var17 = new OutputStreamWriter(var16.getOutputStream());
					var17.write("data2=" + MouseHandler.method1187(var14) + "&dest=" + MouseHandler.method1187("passwordchoice.ws"));
					var17.flush();
					InputStream var18 = var16.getInputStream();
					var13 = new Buffer(new byte[1000]);

					while (true) {
						int var19 = var18.read(var13.array, var13.offset, 1000 - var13.offset);
						if (var19 == -1) {
							var17.close();
							var18.close();
							String var29 = new String(var13.array);
							if (var29.startsWith("OFFLINE")) {
								var28 = 4;
							} else if (var29.startsWith("WRONG")) {
								var28 = 7;
							} else if (var29.startsWith("RELOAD")) {
								var28 = 3;
							} else if (var29.startsWith("Not permitted for social network accounts.")) {
								var28 = 6;
							} else {
								var13.xteaDecryptAll(var10);

								while (var13.offset > 0 && var13.array[var13.offset - 1] == 0) {
									--var13.offset;
								}

								var29 = new String(var13.array, 0, var13.offset);
								boolean var20;
								if (var29 == null) {
									var20 = false;
								} else {
									label120: {
										try {
											new URL(var29);
										} catch (MalformedURLException var30) {
											var20 = false;
											break label120;
										}

										var20 = true;
									}
								}

								if (var20) {
									Script.openURL(var29, true, false);
									var28 = 2;
								} else {
									var28 = 5;
								}
							}
							break;
						}

						var13.offset += var19;
						if (var13.offset >= 1000) {
							var28 = 5;
							break;
						}
					}
				} catch (Throwable var31) {
					var31.printStackTrace();
					var28 = 5;
				}

				var0 = var28;
			}

			switch(var0) {
			case 2:
				HealthBarUpdate.setLoginResponseString(Strings.field3026, Strings.field2898, Strings.field2807);
				Login.loginIndex = 6;
				break;
			case 3:
				HealthBarUpdate.setLoginResponseString("", "Error connecting to server.", "");
				break;
			case 4:
				HealthBarUpdate.setLoginResponseString("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
				break;
			case 5:
				HealthBarUpdate.setLoginResponseString("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
				break;
			case 6:
				HealthBarUpdate.setLoginResponseString("", "Error connecting to server.", "");
				break;
			case 7:
				HealthBarUpdate.setLoginResponseString("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
			}

		}
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(ILce;ZI)I",
		garbageValue = "-1379247234"
	)
	static int method866(int var0, Script var1, boolean var2) {
		Widget var3;
		if (var0 >= 2000) {
			var0 -= 1000;
			var3 = MusicPatchNode.getWidget(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
		} else {
			var3 = var2 ? GrandExchangeOfferNameComparator.field115 : Interpreter.field1130;
		}

		String var4 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
		int[] var5 = null;
		if (var4.length() > 0 && var4.charAt(var4.length() - 1) == 'Y') {
			int var6 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			if (var6 > 0) {
				for (var5 = new int[var6]; var6-- > 0; var5[var6] = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]) {
				}
			}

			var4 = var4.substring(0, var4.length() - 1);
		}

		Object[] var8 = new Object[var4.length() + 1];

		int var7;
		for (var7 = var8.length - 1; var7 >= 1; --var7) {
			if (var4.charAt(var7 - 1) == 's') {
				var8[var7] = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
			} else {
				var8[var7] = new Integer(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
			}
		}

		var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
		if (var7 != -1) {
			var8[0] = new Integer(var7);
		} else {
			var8 = null;
		}

		if (var0 == ScriptOpcodes.CC_SETONCLICK) {
			var3.onClick = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONHOLD) {
			var3.onHold = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONRELEASE) {
			var3.onRelease = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONMOUSEOVER) {
			var3.onMouseOver = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONMOUSELEAVE) {
			var3.onMouseLeave = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONDRAG) {
			var3.onDrag = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONTARGETLEAVE) {
			var3.onTargetLeave = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONVARTRANSMIT) {
			var3.onVarTransmit = var8;
			var3.varTransmitTriggers = var5;
		} else if (var0 == ScriptOpcodes.CC_SETONTIMER) {
			var3.onTimer = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONOP) {
			var3.onOp = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONDRAGCOMPLETE) {
			var3.onDragComplete = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONCLICKREPEAT) {
			var3.onClickRepeat = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONMOUSEREPEAT) {
			var3.onMouseRepeat = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONINVTRANSMIT) {
			var3.onInvTransmit = var8;
			var3.invTransmitTriggers = var5;
		} else if (var0 == ScriptOpcodes.CC_SETONSTATTRANSMIT) {
			var3.onStatTransmit = var8;
			var3.statTransmitTriggers = var5;
		} else if (var0 == ScriptOpcodes.CC_SETONTARGETENTER) {
			var3.onTargetEnter = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONSCROLLWHEEL) {
			var3.onScroll = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONCHATTRANSMIT) {
			var3.onChatTransmit = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONKEY) {
			var3.onKey = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONFRIENDTRANSMIT) {
			var3.onFriendTransmit = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONCLANTRANSMIT) {
			var3.onClanTransmit = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONMISCTRANSMIT) {
			var3.onMiscTransmit = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONDIALOGABORT) {
			var3.onDialogAbort = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONSUBCHANGE) {
			var3.onSubChange = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONSTOCKTRANSMIT) {
			var3.onStockTransmit = var8;
		} else if (var0 == 1426) {
			var3.field2691 = var8;
		} else {
			if (var0 != ScriptOpcodes.CC_SETONRESIZE) {
				return 2;
			}

			var3.onResize = var8;
		}

		var3.hasListener = true;
		return 1;
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		signature = "(IZII)V",
		garbageValue = "826643868"
	)
	public static final void method867(int var0, boolean var1, int var2) {
		if (var0 >= 8000 && var0 <= 48000) {
			PcmPlayer.field1421 = var0;
			PcmPlayer.PcmPlayer_stereo = var1;
			PcmPlayer.field1423 = var2;
		} else {
			throw new IllegalArgumentException();
		}
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		signature = "(ILce;ZI)I",
		garbageValue = "1831250087"
	)
	static int method865(int var0, Script var1, boolean var2) {
		if (var0 == ScriptOpcodes.GETWINDOWMODE) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class74.getWindowedMode();
			return 1;
		} else {
			int var3;
			if (var0 == ScriptOpcodes.SETWINDOWMODE) {
				var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				if (var3 == 1 || var3 == 2) {
					WorldMapIcon_1.setWindowedMode(var3);
				}

				return 1;
			} else if (var0 == ScriptOpcodes.GETDEFAULTWINDOWMODE) {
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = GrandExchangeOfferOwnWorldComparator.clientPreferences.windowMode;
				return 1;
			} else if (var0 != ScriptOpcodes.SETDEFAULTWINDOWMODE) {
				if (var0 == 5310) {
					--Interpreter.Interpreter_intStackSize;
					return 1;
				} else {
					return 2;
				}
			} else {
				var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				if (var3 == 1 || var3 == 2) {
					GrandExchangeOfferOwnWorldComparator.clientPreferences.windowMode = var3;
					WorldMapArea.savePreferences();
				}

				return 1;
			}
		}
	}
}
