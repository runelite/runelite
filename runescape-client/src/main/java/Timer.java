import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("jl")
@Implements("Timer")
public class Timer {
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		longValue = -6240024942986878869L
	)
	long field3584;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		longValue = 5318083601212368839L
	)
	long field3580;
	@ObfuscatedName("b")
	public boolean field3581;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		longValue = 2061112075128540571L
	)
	long field3582;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		longValue = 2026371982134208439L
	)
	long field3583;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		longValue = 689838132485395985L
	)
	long field3579;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = 84967575
	)
	int field3585;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = 1608958001
	)
	int field3586;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -1078604545
	)
	int field3588;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 1631657249
	)
	int field3587;

	public Timer() {
		this.field3584 = -1L;
		this.field3580 = -1L;
		this.field3581 = false;
		this.field3582 = 0L;
		this.field3583 = 0L;
		this.field3579 = 0L;
		this.field3585 = 0;
		this.field3586 = 0;
		this.field3588 = 0;
		this.field3587 = 0;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "233565560"
	)
	public void method5071() {
		this.field3584 = TaskHandler.currentTimeMillis();
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "2022402966"
	)
	public void method5072() {
		if (-1L != this.field3584) {
			this.field3583 = TaskHandler.currentTimeMillis() - this.field3584;
			this.field3584 = -1L;
		}

	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-290587074"
	)
	public void method5073(int var1) {
		this.field3580 = TaskHandler.currentTimeMillis();
		this.field3585 = var1;
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1294932031"
	)
	public void method5079() {
		if (this.field3580 != -1L) {
			this.field3582 = TaskHandler.currentTimeMillis() - this.field3580;
			this.field3580 = -1L;
		}

		++this.field3588;
		this.field3581 = true;
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "65408"
	)
	public void method5075() {
		this.field3581 = false;
		this.field3586 = 0;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1988962701"
	)
	public void method5076() {
		this.method5079();
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(Lkg;I)V",
		garbageValue = "817324338"
	)
	@Export("write")
	public void write(Buffer var1) {
		VertexNormal.method3019(var1, this.field3583);
		VertexNormal.method3019(var1, this.field3582);
		VertexNormal.method3019(var1, this.field3579);
		var1.writeShort(this.field3585);
		var1.writeShort(this.field3586);
		var1.writeShort(this.field3588);
		var1.writeShort(this.field3587);
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(ILci;ZI)I",
		garbageValue = "1563555840"
	)
	static int method5098(int var0, Script var1, boolean var2) {
		String var3;
		if (var0 == ScriptOpcodes.MES) {
			var3 = Interpreter.Interpreter_stringStack[--class43.Interpreter_stringStackSize];
			GrandExchangeOfferAgeComparator.addGameMessage(0, "", var3);
			return 1;
		} else if (var0 == ScriptOpcodes.ANIM) {
			GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize -= 2;
			WorldMapRectangle.performPlayerAnimation(class215.localPlayer, Interpreter.Interpreter_intStack[GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize], Interpreter.Interpreter_intStack[GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize + 1]);
			return 1;
		} else if (var0 == ScriptOpcodes.IF_CLOSE) {
			if (!Interpreter.field1087) {
				Interpreter.field1093 = true;
			}

			return 1;
		} else {
			int var10;
			if (var0 == ScriptOpcodes.RESUME_COUNTDIALOG) {
				var3 = Interpreter.Interpreter_stringStack[--class43.Interpreter_stringStackSize];
				var10 = 0;
				if (Interpreter.isNumber(var3)) {
					var10 = SoundCache.parseInt(var3);
				}

				PacketBufferNode var12 = ModelData0.getPacketBufferNode(ClientPacket.field2230, Client.packetWriter.isaacCipher);
				var12.packetBuffer.writeInt(var10);
				Client.packetWriter.addNode(var12);
				return 1;
			} else {
				PacketBufferNode var14;
				if (var0 == ScriptOpcodes.RESUME_NAMEDIALOG) {
					var3 = Interpreter.Interpreter_stringStack[--class43.Interpreter_stringStackSize];
					var14 = ModelData0.getPacketBufferNode(ClientPacket.field2277, Client.packetWriter.isaacCipher);
					var14.packetBuffer.writeByte(var3.length() + 1);
					var14.packetBuffer.writeStringCp1252NullTerminated(var3);
					Client.packetWriter.addNode(var14);
					return 1;
				} else if (var0 == ScriptOpcodes.RESUME_STRINGDIALOG) {
					var3 = Interpreter.Interpreter_stringStack[--class43.Interpreter_stringStackSize];
					var14 = ModelData0.getPacketBufferNode(ClientPacket.field2256, Client.packetWriter.isaacCipher);
					var14.packetBuffer.writeByte(var3.length() + 1);
					var14.packetBuffer.writeStringCp1252NullTerminated(var3);
					Client.packetWriter.addNode(var14);
					return 1;
				} else {
					String var7;
					int var15;
					if (var0 == ScriptOpcodes.OPPLAYER) {
						var15 = Interpreter.Interpreter_intStack[--GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize];
						var7 = Interpreter.Interpreter_stringStack[--class43.Interpreter_stringStackSize];
						UserComparator5.method3466(var15, var7);
						return 1;
					} else if (var0 == ScriptOpcodes.IF_DRAGPICKUP) {
						GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize -= 3;
						var15 = Interpreter.Interpreter_intStack[GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize];
						var10 = Interpreter.Interpreter_intStack[GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize + 1];
						int var9 = Interpreter.Interpreter_intStack[GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize + 2];
						Widget var13 = Language.getWidget(var9);
						UserComparator3.clickWidget(var13, var15, var10);
						return 1;
					} else if (var0 == ScriptOpcodes.CC_DRAGPICKUP) {
						GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize -= 2;
						var15 = Interpreter.Interpreter_intStack[GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize];
						var10 = Interpreter.Interpreter_intStack[GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize + 1];
						Widget var11 = var2 ? Interpreter.field1090 : class188.field2352;
						UserComparator3.clickWidget(var11, var15, var10);
						return 1;
					} else if (var0 == ScriptOpcodes.MOUSECAM) {
						JagexCache.mouseCam = Interpreter.Interpreter_intStack[--GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize] == 1;
						return 1;
					} else if (var0 == ScriptOpcodes.GETREMOVEROOFS) {
						Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = UserComparator10.clientPreferences.roofsHidden ? 1 : 0;
						return 1;
					} else if (var0 == ScriptOpcodes.SETREMOVEROOFS) {
						UserComparator10.clientPreferences.roofsHidden = Interpreter.Interpreter_intStack[--GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize] == 1;
						class40.savePreferences();
						return 1;
					} else if (var0 == ScriptOpcodes.OPENURL) {
						var3 = Interpreter.Interpreter_stringStack[--class43.Interpreter_stringStackSize];
						boolean var4 = Interpreter.Interpreter_intStack[--GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize] == 1;
						WorldMapAreaData.openURL(var3, var4, false);
						return 1;
					} else if (var0 == ScriptOpcodes.RESUME_OBJDIALOG) {
						var15 = Interpreter.Interpreter_intStack[--GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize];
						var14 = ModelData0.getPacketBufferNode(ClientPacket.field2258, Client.packetWriter.isaacCipher);
						var14.packetBuffer.writeShort(var15);
						Client.packetWriter.addNode(var14);
						return 1;
					} else if (var0 == ScriptOpcodes.BUG_REPORT) {
						var15 = Interpreter.Interpreter_intStack[--GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize];
						class43.Interpreter_stringStackSize -= 2;
						var7 = Interpreter.Interpreter_stringStack[class43.Interpreter_stringStackSize];
						String var5 = Interpreter.Interpreter_stringStack[class43.Interpreter_stringStackSize + 1];
						if (var7.length() > 500) {
							return 1;
						} else if (var5.length() > 500) {
							return 1;
						} else {
							PacketBufferNode var6 = ModelData0.getPacketBufferNode(ClientPacket.field2290, Client.packetWriter.isaacCipher);
							var6.packetBuffer.writeShort(1 + class173.stringCp1252NullTerminatedByteSize(var7) + class173.stringCp1252NullTerminatedByteSize(var5));
							var6.packetBuffer.writeStringCp1252NullTerminated(var5);
							var6.packetBuffer.writeByte(var15);
							var6.packetBuffer.writeStringCp1252NullTerminated(var7);
							Client.packetWriter.addNode(var6);
							return 1;
						}
					} else if (var0 == ScriptOpcodes.SETSHIFTCLICKDROP) {
						Client.shiftClickDrop = Interpreter.Interpreter_intStack[--GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize] == 1;
						return 1;
					} else if (var0 == ScriptOpcodes.SETSHOWMOUSEOVERTEXT) {
						Client.showMouseOverText = Interpreter.Interpreter_intStack[--GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize] == 1;
						return 1;
					} else if (var0 == ScriptOpcodes.RENDERSELF) {
						Client.renderSelf = Interpreter.Interpreter_intStack[--GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize] == 1;
						return 1;
					} else if (var0 == 3120) {
						if (Interpreter.Interpreter_intStack[--GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize] == 1) {
							Client.drawPlayerNames |= 1;
						} else {
							Client.drawPlayerNames &= -2;
						}

						return 1;
					} else if (var0 == 3121) {
						if (Interpreter.Interpreter_intStack[--GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize] == 1) {
							Client.drawPlayerNames |= 2;
						} else {
							Client.drawPlayerNames &= -3;
						}

						return 1;
					} else if (var0 == 3122) {
						if (Interpreter.Interpreter_intStack[--GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize] == 1) {
							Client.drawPlayerNames |= 4;
						} else {
							Client.drawPlayerNames &= -5;
						}

						return 1;
					} else if (var0 == 3123) {
						if (Interpreter.Interpreter_intStack[--GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize] == 1) {
							Client.drawPlayerNames |= 8;
						} else {
							Client.drawPlayerNames &= -9;
						}

						return 1;
					} else if (var0 == 3124) {
						Client.drawPlayerNames = 0;
						return 1;
					} else if (var0 == ScriptOpcodes.SETSHOWMOUSECROSS) {
						Client.showMouseCross = Interpreter.Interpreter_intStack[--GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize] == 1;
						return 1;
					} else if (var0 == ScriptOpcodes.SETSHOWLOADINGMESSAGES) {
						Client.showLoadingMessages = Interpreter.Interpreter_intStack[--GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize] == 1;
						return 1;
					} else if (var0 == ScriptOpcodes.SETTAPTODROP) {
						Friend.setTapToDrop(Interpreter.Interpreter_intStack[--GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize] == 1);
						return 1;
					} else if (var0 == ScriptOpcodes.GETTAPTODROP) {
						Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = MouseRecorder.getTapToDrop() ? 1 : 0;
						return 1;
					} else if (var0 == ScriptOpcodes.SETOCULUSORBSPEED) {
						GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize -= 2;
						Client.oculusOrbNormalSpeed = Interpreter.Interpreter_intStack[GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize];
						Client.oculusOrbSlowedSpeed = Interpreter.Interpreter_intStack[GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize + 1];
						return 1;
					} else if (var0 == 3130) {
						GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize -= 2;
						return 1;
					} else if (var0 == 3131) {
						--GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize;
						return 1;
					} else if (var0 == ScriptOpcodes.GETCANVASSIZE) {
						Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = BoundaryObject.canvasWidth;
						Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = WorldMapCacheName.canvasHeight;
						return 1;
					} else if (var0 == ScriptOpcodes.MOBILE_SETFPS) {
						--GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize;
						return 1;
					} else if (var0 == ScriptOpcodes.MOBILE_OPENSTORE) {
						return 1;
					} else if (var0 == ScriptOpcodes.MOBILE_OPENSTORECATEGORY) {
						GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize -= 2;
						return 1;
					} else if (var0 == 3136) {
						Client.field804 = 3;
						Client.field805 = Interpreter.Interpreter_intStack[--GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize];
						return 1;
					} else if (var0 == 3137) {
						Client.field804 = 2;
						Client.field805 = Interpreter.Interpreter_intStack[--GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize];
						return 1;
					} else if (var0 == 3138) {
						Client.field804 = 0;
						return 1;
					} else if (var0 == 3139) {
						Client.field804 = 1;
						return 1;
					} else if (var0 == 3140) {
						Client.field804 = 3;
						Client.field805 = var2 ? Interpreter.field1090.id : class188.field2352.id;
						return 1;
					} else {
						boolean var8;
						if (var0 == ScriptOpcodes.SETHIDEUSERNAME) {
							var8 = Interpreter.Interpreter_intStack[--GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize] == 1;
							UserComparator10.clientPreferences.hideUsername = var8;
							class40.savePreferences();
							return 1;
						} else if (var0 == ScriptOpcodes.GETHIDEUSERNAME) {
							Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = UserComparator10.clientPreferences.hideUsername ? 1 : 0;
							return 1;
						} else if (var0 == ScriptOpcodes.SETREMEMBERUSERNAME) {
							var8 = Interpreter.Interpreter_intStack[--GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize] == 1;
							Client.Login_isUsernameRemembered = var8;
							if (!var8) {
								UserComparator10.clientPreferences.rememberedUsername = "";
								class40.savePreferences();
							}

							return 1;
						} else if (var0 == ScriptOpcodes.GETREMEMBERUSERNAME) {
							Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = Client.Login_isUsernameRemembered ? 1 : 0;
							return 1;
						} else if (var0 == 3145) {
							return 1;
						} else if (var0 == ScriptOpcodes.SETTITLEMUSICENABLED) {
							var8 = Interpreter.Interpreter_intStack[--GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize] == 1;
							if (var8 == UserComparator10.clientPreferences.titleMusicDisabled) {
								UserComparator10.clientPreferences.titleMusicDisabled = !var8;
								class40.savePreferences();
							}

							return 1;
						} else if (var0 == ScriptOpcodes.GETTITLEMUSICENABLED) {
							Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = UserComparator10.clientPreferences.titleMusicDisabled ? 0 : 1;
							return 1;
						} else if (var0 == 3148) {
							return 1;
						} else if (var0 == 3149) {
							Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3150) {
							Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3151) {
							Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3152) {
							Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3153) {
							Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = Login.Login_loadingPercent;
							return 1;
						} else if (var0 == 3154) {
							Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = SpotAnimationDefinition.method4509();
							return 1;
						} else if (var0 == 3155) {
							--class43.Interpreter_stringStackSize;
							return 1;
						} else if (var0 == 3156) {
							return 1;
						} else if (var0 == 3157) {
							GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize -= 2;
							return 1;
						} else if (var0 == 3158) {
							Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3159) {
							Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3160) {
							Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3161) {
							--GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize;
							Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3162) {
							--GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize;
							Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3163) {
							--class43.Interpreter_stringStackSize;
							Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3164) {
							--GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize;
							Interpreter.Interpreter_stringStack[++class43.Interpreter_stringStackSize - 1] = "";
							return 1;
						} else if (var0 == 3165) {
							--GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize;
							Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3166) {
							GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize -= 2;
							Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3167) {
							GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize -= 2;
							Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3168) {
							GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize -= 2;
							Interpreter.Interpreter_stringStack[++class43.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++class43.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++class43.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++class43.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++class43.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++class43.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++class43.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++class43.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++class43.Interpreter_stringStackSize - 1] = "";
							return 1;
						} else if (var0 == 3169) {
							return 1;
						} else if (var0 == 3170) {
							Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3171) {
							Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3172) {
							--GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize;
							return 1;
						} else if (var0 == 3173) {
							--GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize;
							Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3174) {
							--GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize;
							return 1;
						} else if (var0 == 3175) {
							Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3176) {
							return 1;
						} else if (var0 == 3177) {
							return 1;
						} else if (var0 == 3178) {
							--class43.Interpreter_stringStackSize;
							return 1;
						} else if (var0 == 3179) {
							return 1;
						} else if (var0 == 3180) {
							--class43.Interpreter_stringStackSize;
							return 1;
						} else {
							return 2;
						}
					}
				}
			}
		}
	}
}
