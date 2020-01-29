import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("fl")
@Implements("UserComparator5")
public class UserComparator5 extends AbstractUserComparator {
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Lii;"
	)
	@Export("musicTrackArchive")
	public static AbstractArchive musicTrackArchive;
	@ObfuscatedName("c")
	@Export("reversed")
	final boolean reversed;

	public UserComparator5(boolean var1) {
		this.reversed = var1;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Lje;Lje;I)I",
		garbageValue = "-1009483697"
	)
	@Export("compareBuddy")
	int compareBuddy(Buddy var1, Buddy var2) {
		if (var1.world != 0) {
			if (var2.world == 0) {
				return this.reversed ? -1 : 1;
			}
		} else if (var2.world != 0) {
			return this.reversed ? 1 : -1;
		}

		return this.compareUser(var1, var2);
	}

	public int compare(Object var1, Object var2) {
		return this.compareBuddy((Buddy)var1, (Buddy)var2);
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)Lgs;",
		garbageValue = "-2093549834"
	)
	public static PacketBufferNode method3488() {
		return PacketBufferNode.PacketBufferNode_packetBufferNodeCount == 0 ? new PacketBufferNode() : PacketBufferNode.PacketBufferNode_packetBufferNodes[--PacketBufferNode.PacketBufferNode_packetBufferNodeCount];
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(ILce;ZB)I",
		garbageValue = "0"
	)
	static int method3491(int var0, Script var1, boolean var2) {
		String var3;
		if (var0 == ScriptOpcodes.MES) {
			var3 = Interpreter.Interpreter_stringStack[--Message.Interpreter_stringStackSize];
			ClientPreferences.addGameMessage(0, "", var3);
			return 1;
		} else if (var0 == ScriptOpcodes.ANIM) {
			class320.Interpreter_intStackSize -= 2;
			InterfaceParent.performPlayerAnimation(class192.localPlayer, Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize], Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1]);
			return 1;
		} else if (var0 == ScriptOpcodes.IF_CLOSE) {
			if (!Interpreter.field1095) {
				Interpreter.field1094 = true;
			}

			return 1;
		} else {
			int var10;
			if (var0 == ScriptOpcodes.RESUME_COUNTDIALOG) {
				var3 = Interpreter.Interpreter_stringStack[--Message.Interpreter_stringStackSize];
				var10 = 0;
				if (class248.isNumber(var3)) {
					var10 = VerticalAlignment.parseInt(var3);
				}

				PacketBufferNode var12 = TilePaint.getPacketBufferNode(ClientPacket.field2251, Client.packetWriter.isaacCipher);
				var12.packetBuffer.writeInt(var10);
				Client.packetWriter.addNode(var12);
				return 1;
			} else {
				PacketBufferNode var14;
				if (var0 == ScriptOpcodes.RESUME_NAMEDIALOG) {
					var3 = Interpreter.Interpreter_stringStack[--Message.Interpreter_stringStackSize];
					var14 = TilePaint.getPacketBufferNode(ClientPacket.field2280, Client.packetWriter.isaacCipher);
					var14.packetBuffer.writeByte(var3.length() + 1);
					var14.packetBuffer.writeStringCp1252NullTerminated(var3);
					Client.packetWriter.addNode(var14);
					return 1;
				} else if (var0 == ScriptOpcodes.RESUME_STRINGDIALOG) {
					var3 = Interpreter.Interpreter_stringStack[--Message.Interpreter_stringStackSize];
					var14 = TilePaint.getPacketBufferNode(ClientPacket.field2203, Client.packetWriter.isaacCipher);
					var14.packetBuffer.writeByte(var3.length() + 1);
					var14.packetBuffer.writeStringCp1252NullTerminated(var3);
					Client.packetWriter.addNode(var14);
					return 1;
				} else {
					String var7;
					int var15;
					if (var0 == ScriptOpcodes.OPPLAYER) {
						var15 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
						var7 = Interpreter.Interpreter_stringStack[--Message.Interpreter_stringStackSize];
						ScriptEvent.method1203(var15, var7);
						return 1;
					} else if (var0 == ScriptOpcodes.IF_DRAGPICKUP) {
						class320.Interpreter_intStackSize -= 3;
						var15 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize];
						var10 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1];
						int var9 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 2];
						Widget var13 = Varps.getWidget(var9);
						Strings.clickWidget(var13, var15, var10);
						return 1;
					} else if (var0 == ScriptOpcodes.CC_DRAGPICKUP) {
						class320.Interpreter_intStackSize -= 2;
						var15 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize];
						var10 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1];
						Widget var11 = var2 ? class186.field2331 : MidiPcmStream.field2444;
						Strings.clickWidget(var11, var15, var10);
						return 1;
					} else if (var0 == ScriptOpcodes.MOUSECAM) {
						ArchiveLoader.mouseCam = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
						return 1;
					} else if (var0 == ScriptOpcodes.GETREMOVEROOFS) {
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = WorldMapSection2.clientPreferences.roofsHidden ? 1 : 0;
						return 1;
					} else if (var0 == ScriptOpcodes.SETREMOVEROOFS) {
						WorldMapSection2.clientPreferences.roofsHidden = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
						WorldMapData_1.savePreferences();
						return 1;
					} else if (var0 == ScriptOpcodes.OPENURL) {
						var3 = Interpreter.Interpreter_stringStack[--Message.Interpreter_stringStackSize];
						boolean var4 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
						class215.openURL(var3, var4, false);
						return 1;
					} else if (var0 == ScriptOpcodes.RESUME_OBJDIALOG) {
						var15 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
						var14 = TilePaint.getPacketBufferNode(ClientPacket.field2277, Client.packetWriter.isaacCipher);
						var14.packetBuffer.writeShort(var15);
						Client.packetWriter.addNode(var14);
						return 1;
					} else if (var0 == ScriptOpcodes.BUG_REPORT) {
						var15 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
						Message.Interpreter_stringStackSize -= 2;
						var7 = Interpreter.Interpreter_stringStack[Message.Interpreter_stringStackSize];
						String var5 = Interpreter.Interpreter_stringStack[Message.Interpreter_stringStackSize + 1];
						if (var7.length() > 500) {
							return 1;
						} else if (var5.length() > 500) {
							return 1;
						} else {
							PacketBufferNode var6 = TilePaint.getPacketBufferNode(ClientPacket.field2233, Client.packetWriter.isaacCipher);
							var6.packetBuffer.writeShort(1 + Buddy.stringCp1252NullTerminatedByteSize(var7) + Buddy.stringCp1252NullTerminatedByteSize(var5));
							var6.packetBuffer.writeStringCp1252NullTerminated(var7);
							var6.packetBuffer.method5602(var15);
							var6.packetBuffer.writeStringCp1252NullTerminated(var5);
							Client.packetWriter.addNode(var6);
							return 1;
						}
					} else if (var0 == ScriptOpcodes.SETSHIFTCLICKDROP) {
						Client.shiftClickDrop = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
						return 1;
					} else if (var0 == ScriptOpcodes.SETSHOWMOUSEOVERTEXT) {
						Client.showMouseOverText = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
						return 1;
					} else if (var0 == ScriptOpcodes.RENDERSELF) {
						Client.renderSelf = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
						return 1;
					} else if (var0 == 3120) {
						if (Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1) {
							Client.drawPlayerNames |= 1;
						} else {
							Client.drawPlayerNames &= -2;
						}

						return 1;
					} else if (var0 == 3121) {
						if (Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1) {
							Client.drawPlayerNames |= 2;
						} else {
							Client.drawPlayerNames &= -3;
						}

						return 1;
					} else if (var0 == 3122) {
						if (Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1) {
							Client.drawPlayerNames |= 4;
						} else {
							Client.drawPlayerNames &= -5;
						}

						return 1;
					} else if (var0 == 3123) {
						if (Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1) {
							Client.drawPlayerNames |= 8;
						} else {
							Client.drawPlayerNames &= -9;
						}

						return 1;
					} else if (var0 == 3124) {
						Client.drawPlayerNames = 0;
						return 1;
					} else if (var0 == ScriptOpcodes.SETSHOWMOUSECROSS) {
						Client.showMouseCross = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
						return 1;
					} else if (var0 == ScriptOpcodes.SETSHOWLOADINGMESSAGES) {
						Client.showLoadingMessages = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
						return 1;
					} else if (var0 == ScriptOpcodes.SETTAPTODROP) {
						ObjectSound.setTapToDrop(Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1);
						return 1;
					} else if (var0 == ScriptOpcodes.GETTAPTODROP) {
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = Message.getTapToDrop() ? 1 : 0;
						return 1;
					} else if (var0 == ScriptOpcodes.SETOCULUSORBSPEED) {
						class320.Interpreter_intStackSize -= 2;
						Client.oculusOrbNormalSpeed = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize];
						Client.oculusOrbSlowedSpeed = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1];
						return 1;
					} else if (var0 == 3130) {
						class320.Interpreter_intStackSize -= 2;
						return 1;
					} else if (var0 == 3131) {
						--class320.Interpreter_intStackSize;
						return 1;
					} else if (var0 == ScriptOpcodes.GETCANVASSIZE) {
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = Username.canvasWidth;
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = WorldMapData_1.canvasHeight;
						return 1;
					} else if (var0 == ScriptOpcodes.MOBILE_SETFPS) {
						--class320.Interpreter_intStackSize;
						return 1;
					} else if (var0 == ScriptOpcodes.MOBILE_OPENSTORE) {
						return 1;
					} else if (var0 == ScriptOpcodes.MOBILE_OPENSTORECATEGORY) {
						class320.Interpreter_intStackSize -= 2;
						return 1;
					} else if (var0 == 3136) {
						Client.field808 = 3;
						Client.field664 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
						return 1;
					} else if (var0 == 3137) {
						Client.field808 = 2;
						Client.field664 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
						return 1;
					} else if (var0 == 3138) {
						Client.field808 = 0;
						return 1;
					} else if (var0 == 3139) {
						Client.field808 = 1;
						return 1;
					} else if (var0 == 3140) {
						Client.field808 = 3;
						Client.field664 = var2 ? class186.field2331.id : MidiPcmStream.field2444.id;
						return 1;
					} else {
						boolean var8;
						if (var0 == ScriptOpcodes.SETHIDEUSERNAME) {
							var8 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
							WorldMapSection2.clientPreferences.hideUsername = var8;
							WorldMapData_1.savePreferences();
							return 1;
						} else if (var0 == ScriptOpcodes.GETHIDEUSERNAME) {
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = WorldMapSection2.clientPreferences.hideUsername ? 1 : 0;
							return 1;
						} else if (var0 == ScriptOpcodes.SETREMEMBERUSERNAME) {
							var8 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
							Client.Login_isUsernameRemembered = var8;
							if (!var8) {
								WorldMapSection2.clientPreferences.rememberedUsername = "";
								WorldMapData_1.savePreferences();
							}

							return 1;
						} else if (var0 == ScriptOpcodes.GETREMEMBERUSERNAME) {
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = Client.Login_isUsernameRemembered ? 1 : 0;
							return 1;
						} else if (var0 == 3145) {
							return 1;
						} else if (var0 == ScriptOpcodes.SETTITLEMUSICENABLED) {
							var8 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
							if (var8 == WorldMapSection2.clientPreferences.titleMusicDisabled) {
								WorldMapSection2.clientPreferences.titleMusicDisabled = !var8;
								WorldMapData_1.savePreferences();
							}

							return 1;
						} else if (var0 == ScriptOpcodes.GETTITLEMUSICENABLED) {
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = WorldMapSection2.clientPreferences.titleMusicDisabled ? 0 : 1;
							return 1;
						} else if (var0 == 3148) {
							return 1;
						} else if (var0 == 3149) {
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3150) {
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3151) {
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3152) {
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3153) {
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = Login.Login_loadingPercent;
							return 1;
						} else if (var0 == 3154) {
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = class14.method170();
							return 1;
						} else if (var0 == 3155) {
							--Message.Interpreter_stringStackSize;
							return 1;
						} else if (var0 == 3156) {
							return 1;
						} else if (var0 == 3157) {
							class320.Interpreter_intStackSize -= 2;
							return 1;
						} else if (var0 == 3158) {
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3159) {
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3160) {
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3161) {
							--class320.Interpreter_intStackSize;
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3162) {
							--class320.Interpreter_intStackSize;
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3163) {
							--Message.Interpreter_stringStackSize;
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3164) {
							--class320.Interpreter_intStackSize;
							Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = "";
							return 1;
						} else if (var0 == 3165) {
							--class320.Interpreter_intStackSize;
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3166) {
							class320.Interpreter_intStackSize -= 2;
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3167) {
							class320.Interpreter_intStackSize -= 2;
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3168) {
							class320.Interpreter_intStackSize -= 2;
							Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = "";
							return 1;
						} else if (var0 == 3169) {
							return 1;
						} else if (var0 == 3170) {
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3171) {
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3172) {
							--class320.Interpreter_intStackSize;
							return 1;
						} else if (var0 == 3173) {
							--class320.Interpreter_intStackSize;
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3174) {
							--class320.Interpreter_intStackSize;
							return 1;
						} else if (var0 == 3175) {
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3176) {
							return 1;
						} else if (var0 == 3177) {
							return 1;
						} else if (var0 == 3178) {
							--Message.Interpreter_stringStackSize;
							return 1;
						} else if (var0 == 3179) {
							return 1;
						} else if (var0 == 3180) {
							--Message.Interpreter_stringStackSize;
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
