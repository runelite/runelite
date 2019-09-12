import java.util.HashMap;
import java.util.Map;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("cw")
@Implements("Messages")
public class Messages {
	@ObfuscatedName("c")
	@Export("Messages_channels")
	static final Map Messages_channels;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Llj;"
	)
	@Export("Messages_hashTable")
	static final IterableNodeHashTable Messages_hashTable;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Ljn;"
	)
	@Export("Messages_queue")
	static final IterableDualNodeQueue Messages_queue;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -1338946421
	)
	@Export("Messages_count")
	static int Messages_count;

	static {
		Messages_channels = new HashMap();
		Messages_hashTable = new IterableNodeHashTable(1024);
		Messages_queue = new IterableDualNodeQueue();
		Messages_count = 0;
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(ILcu;ZI)I",
		garbageValue = "-1499618076"
	)
	static int method2194(int var0, Script var1, boolean var2) {
		String var3;
		if (var0 == ScriptOpcodes.MES) {
			var3 = Interpreter.Interpreter_stringStack[--TextureProvider.Interpreter_stringStackSize];
			WorldMapCacheName.addGameMessage(0, "", var3);
			return 1;
		} else if (var0 == ScriptOpcodes.ANIM) {
			class160.Interpreter_intStackSize -= 2;
			FloorUnderlayDefinition.performPlayerAnimation(Varps.localPlayer, Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize], Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 1]);
			return 1;
		} else if (var0 == ScriptOpcodes.IF_CLOSE) {
			if (!Interpreter.field1068) {
				Interpreter.field1067 = true;
			}

			return 1;
		} else {
			int var10;
			if (var0 == ScriptOpcodes.RESUME_COUNTDIALOG) {
				var3 = Interpreter.Interpreter_stringStack[--TextureProvider.Interpreter_stringStackSize];
				var10 = 0;
				if (DynamicObject.isNumber(var3)) {
					var10 = IgnoreList.parseInt(var3);
				}

				PacketBufferNode var12 = MenuAction.getPacketBufferNode(ClientPacket.field2239, Client.packetWriter.isaacCipher);
				var12.packetBuffer.writeInt(var10);
				Client.packetWriter.addNode(var12);
				return 1;
			} else {
				PacketBufferNode var14;
				if (var0 == ScriptOpcodes.RESUME_NAMEDIALOG) {
					var3 = Interpreter.Interpreter_stringStack[--TextureProvider.Interpreter_stringStackSize];
					var14 = MenuAction.getPacketBufferNode(ClientPacket.field2201, Client.packetWriter.isaacCipher);
					var14.packetBuffer.writeByte(var3.length() + 1);
					var14.packetBuffer.writeStringCp1252NullTerminated(var3);
					Client.packetWriter.addNode(var14);
					return 1;
				} else if (var0 == ScriptOpcodes.RESUME_STRINGDIALOG) {
					var3 = Interpreter.Interpreter_stringStack[--TextureProvider.Interpreter_stringStackSize];
					var14 = MenuAction.getPacketBufferNode(ClientPacket.field2257, Client.packetWriter.isaacCipher);
					var14.packetBuffer.writeByte(var3.length() + 1);
					var14.packetBuffer.writeStringCp1252NullTerminated(var3);
					Client.packetWriter.addNode(var14);
					return 1;
				} else {
					String var7;
					int var15;
					if (var0 == ScriptOpcodes.OPPLAYER) {
						var15 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
						var7 = Interpreter.Interpreter_stringStack[--TextureProvider.Interpreter_stringStackSize];
						class60.method1122(var15, var7);
						return 1;
					} else if (var0 == ScriptOpcodes.IF_DRAGPICKUP) {
						class160.Interpreter_intStackSize -= 3;
						var15 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize];
						var10 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 1];
						int var9 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 2];
						Widget var13 = Player.getWidget(var9);
						class83.clickWidget(var13, var15, var10);
						return 1;
					} else if (var0 == ScriptOpcodes.CC_DRAGPICKUP) {
						class160.Interpreter_intStackSize -= 2;
						var15 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize];
						var10 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 1];
						Widget var11 = var2 ? UserComparator9.field1941 : MidiPcmStream.field2410;
						class83.clickWidget(var11, var15, var10);
						return 1;
					} else if (var0 == ScriptOpcodes.MOUSECAM) {
						WorldMapSection1.mouseCam = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize] == 1;
						return 1;
					} else if (var0 == ScriptOpcodes.GETREMOVEROOFS) {
						Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = Actor.clientPreferences.roofsHidden ? 1 : 0;
						return 1;
					} else if (var0 == ScriptOpcodes.SETREMOVEROOFS) {
						Actor.clientPreferences.roofsHidden = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize] == 1;
						class296.savePreferences();
						return 1;
					} else if (var0 == ScriptOpcodes.OPENURL) {
						var3 = Interpreter.Interpreter_stringStack[--TextureProvider.Interpreter_stringStackSize];
						boolean var4 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize] == 1;
						WorldMapIcon_0.openURL(var3, var4, false);
						return 1;
					} else if (var0 == ScriptOpcodes.RESUME_OBJDIALOG) {
						var15 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
						var14 = MenuAction.getPacketBufferNode(ClientPacket.field2222, Client.packetWriter.isaacCipher);
						var14.packetBuffer.writeShort(var15);
						Client.packetWriter.addNode(var14);
						return 1;
					} else if (var0 == ScriptOpcodes.BUG_REPORT) {
						var15 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
						TextureProvider.Interpreter_stringStackSize -= 2;
						var7 = Interpreter.Interpreter_stringStack[TextureProvider.Interpreter_stringStackSize];
						String var5 = Interpreter.Interpreter_stringStack[TextureProvider.Interpreter_stringStackSize + 1];
						if (var7.length() > 500) {
							return 1;
						} else if (var5.length() > 500) {
							return 1;
						} else {
							PacketBufferNode var6 = MenuAction.getPacketBufferNode(ClientPacket.field2236, Client.packetWriter.isaacCipher);
							var6.packetBuffer.writeShort(1 + Varcs.stringCp1252NullTerminatedByteSize(var7) + Varcs.stringCp1252NullTerminatedByteSize(var5));
							var6.packetBuffer.writeStringCp1252NullTerminated(var7);
							var6.packetBuffer.method5491(var15);
							var6.packetBuffer.writeStringCp1252NullTerminated(var5);
							Client.packetWriter.addNode(var6);
							return 1;
						}
					} else if (var0 == ScriptOpcodes.SETSHIFTCLICKDROP) {
						Client.shiftClickDrop = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize] == 1;
						return 1;
					} else if (var0 == ScriptOpcodes.SETSHOWMOUSEOVERTEXT) {
						Client.showMouseOverText = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize] == 1;
						return 1;
					} else if (var0 == ScriptOpcodes.RENDERSELF) {
						Client.renderSelf = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize] == 1;
						return 1;
					} else if (var0 == 3120) {
						if (Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize] == 1) {
							Client.drawPlayerNames |= 1;
						} else {
							Client.drawPlayerNames &= -2;
						}

						return 1;
					} else if (var0 == 3121) {
						if (Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize] == 1) {
							Client.drawPlayerNames |= 2;
						} else {
							Client.drawPlayerNames &= -3;
						}

						return 1;
					} else if (var0 == 3122) {
						if (Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize] == 1) {
							Client.drawPlayerNames |= 4;
						} else {
							Client.drawPlayerNames &= -5;
						}

						return 1;
					} else if (var0 == 3123) {
						if (Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize] == 1) {
							Client.drawPlayerNames |= 8;
						} else {
							Client.drawPlayerNames &= -9;
						}

						return 1;
					} else if (var0 == 3124) {
						Client.drawPlayerNames = 0;
						return 1;
					} else if (var0 == ScriptOpcodes.SETSHOWMOUSECROSS) {
						Client.showMouseCross = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize] == 1;
						return 1;
					} else if (var0 == ScriptOpcodes.SETSHOWLOADINGMESSAGES) {
						Client.showLoadingMessages = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize] == 1;
						return 1;
					} else if (var0 == ScriptOpcodes.SETTAPTODROP) {
						FriendSystem.setTapToDrop(Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize] == 1);
						return 1;
					} else if (var0 == ScriptOpcodes.GETTAPTODROP) {
						Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = ItemContainer.getTapToDrop() ? 1 : 0;
						return 1;
					} else if (var0 == ScriptOpcodes.SETOCULUSORBSPEED) {
						class160.Interpreter_intStackSize -= 2;
						Client.oculusOrbNormalSpeed = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize];
						Client.oculusOrbSlowedSpeed = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 1];
						return 1;
					} else if (var0 == 3130) {
						class160.Interpreter_intStackSize -= 2;
						return 1;
					} else if (var0 == 3131) {
						--class160.Interpreter_intStackSize;
						return 1;
					} else if (var0 == ScriptOpcodes.GETCANVASSIZE) {
						Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = GraphicsDefaults.canvasWidth;
						Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = GameShell.canvasHeight;
						return 1;
					} else if (var0 == ScriptOpcodes.MOBILE_SETFPS) {
						--class160.Interpreter_intStackSize;
						return 1;
					} else if (var0 == ScriptOpcodes.MOBILE_OPENSTORE) {
						return 1;
					} else if (var0 == ScriptOpcodes.MOBILE_OPENSTORECATEGORY) {
						class160.Interpreter_intStackSize -= 2;
						return 1;
					} else if (var0 == 3136) {
						Client.field784 = 3;
						Client.field785 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
						return 1;
					} else if (var0 == 3137) {
						Client.field784 = 2;
						Client.field785 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
						return 1;
					} else if (var0 == 3138) {
						Client.field784 = 0;
						return 1;
					} else if (var0 == 3139) {
						Client.field784 = 1;
						return 1;
					} else if (var0 == 3140) {
						Client.field784 = 3;
						Client.field785 = var2 ? UserComparator9.field1941.id : MidiPcmStream.field2410.id;
						return 1;
					} else {
						boolean var8;
						if (var0 == ScriptOpcodes.SETHIDEUSERNAME) {
							var8 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize] == 1;
							Actor.clientPreferences.hideUsername = var8;
							class296.savePreferences();
							return 1;
						} else if (var0 == ScriptOpcodes.GETHIDEUSERNAME) {
							Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = Actor.clientPreferences.hideUsername ? 1 : 0;
							return 1;
						} else if (var0 == ScriptOpcodes.SETREMEMBERUSERNAME) {
							var8 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize] == 1;
							Client.Login_isUsernameRemembered = var8;
							if (!var8) {
								Actor.clientPreferences.rememberedUsername = "";
								class296.savePreferences();
							}

							return 1;
						} else if (var0 == ScriptOpcodes.GETREMEMBERUSERNAME) {
							Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = Client.Login_isUsernameRemembered ? 1 : 0;
							return 1;
						} else if (var0 == 3145) {
							return 1;
						} else if (var0 == ScriptOpcodes.SETTITLEMUSICENABLED) {
							var8 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize] == 1;
							if (var8 == Actor.clientPreferences.titleMusicDisabled) {
								Actor.clientPreferences.titleMusicDisabled = !var8;
								class296.savePreferences();
							}

							return 1;
						} else if (var0 == ScriptOpcodes.GETTITLEMUSICENABLED) {
							Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = Actor.clientPreferences.titleMusicDisabled ? 0 : 1;
							return 1;
						} else if (var0 == 3148) {
							return 1;
						} else if (var0 == 3149) {
							Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3150) {
							Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3151) {
							Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3152) {
							Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3153) {
							Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = Login.Login_loadingPercent;
							return 1;
						} else if (var0 == 3154) {
							Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = class189.method3626();
							return 1;
						} else if (var0 == 3155) {
							--TextureProvider.Interpreter_stringStackSize;
							return 1;
						} else if (var0 == 3156) {
							return 1;
						} else if (var0 == 3157) {
							class160.Interpreter_intStackSize -= 2;
							return 1;
						} else if (var0 == 3158) {
							Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3159) {
							Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3160) {
							Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3161) {
							--class160.Interpreter_intStackSize;
							Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3162) {
							--class160.Interpreter_intStackSize;
							Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3163) {
							--TextureProvider.Interpreter_stringStackSize;
							Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3164) {
							--class160.Interpreter_intStackSize;
							Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = "";
							return 1;
						} else if (var0 == 3165) {
							--class160.Interpreter_intStackSize;
							Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3166) {
							class160.Interpreter_intStackSize -= 2;
							Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3167) {
							class160.Interpreter_intStackSize -= 2;
							Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3168) {
							class160.Interpreter_intStackSize -= 2;
							Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = "";
							return 1;
						} else if (var0 == 3169) {
							return 1;
						} else if (var0 == 3170) {
							Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3171) {
							Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3172) {
							--class160.Interpreter_intStackSize;
							return 1;
						} else if (var0 == 3173) {
							--class160.Interpreter_intStackSize;
							Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3174) {
							--class160.Interpreter_intStackSize;
							return 1;
						} else if (var0 == 3175) {
							Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else {
							return var0 == 3176 ? 1 : 2;
						}
					}
				}
			}
		}
	}
}
