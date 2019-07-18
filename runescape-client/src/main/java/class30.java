import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("ad")
public class class30 {
	@ObfuscatedName("rj")
	@ObfuscatedGetter(
		intValue = -1360749952
	)
	static int field259;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lad;"
	)
	static final class30 field262;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lad;"
	)
	static final class30 field258;
	@ObfuscatedName("bs")
	@ObfuscatedSignature(
		signature = "Llx;"
	)
	static IndexedSprite field264;
	@ObfuscatedName("ks")
	@ObfuscatedGetter(
		intValue = 148643729
	)
	@Export("menuY")
	static int menuY;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -613032617
	)
	@Export("value")
	final int value;

	static {
		field262 = new class30(0);
		field258 = new class30(1);
	}

	class30(int var1) {
		this.value = var1;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(IS)Lek;",
		garbageValue = "-15133"
	)
	@Export("getFrames")
	static Frames getFrames(int var0) {
		Frames var1 = (Frames)SequenceDefinition.SequenceDefinition_cachedFrames.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			var1 = BoundaryObject.method3262(SequenceDefinition.SequenceDefinition_animationsArchive, SequenceDefinition.SequenceDefinition_skeletonsArchive, var0, false);
			if (var1 != null) {
				SequenceDefinition.SequenceDefinition_cachedFrames.put(var1, (long)var0);
			}

			return var1;
		}
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		signature = "(ILcx;ZB)I",
		garbageValue = "69"
	)
	static int method536(int var0, Script var1, boolean var2) {
		String var3;
		if (var0 == ScriptOpcodes.MES) {
			var3 = Interpreter.Interpreter_stringStack[--Skills.Interpreter_stringStackSize];
			ScriptEvent.addGameMessage(0, "", var3);
			return 1;
		} else if (var0 == ScriptOpcodes.ANIM) {
			HealthBarUpdate.Interpreter_intStackSize -= 2;
			MouseRecorder.performPlayerAnimation(Client.localPlayer, Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize], Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 1]);
			return 1;
		} else if (var0 == ScriptOpcodes.IF_CLOSE) {
			if (!Interpreter.field1105) {
				Interpreter.field1104 = true;
			}

			return 1;
		} else {
			int var10;
			if (var0 == ScriptOpcodes.RESUME_COUNTDIALOG) {
				var3 = Interpreter.Interpreter_stringStack[--Skills.Interpreter_stringStackSize];
				var10 = 0;
				if (class192.method3677(var3)) {
					var10 = class3.parseInt(var3);
				}

				PacketBufferNode var12 = Archive.method4265(ClientPacket.field2220, Client.packetWriter.isaacCipher);
				var12.packetBuffer.writeInt(var10);
				Client.packetWriter.method2219(var12);
				return 1;
			} else {
				PacketBufferNode var14;
				if (var0 == ScriptOpcodes.RESUME_NAMEDIALOG) {
					var3 = Interpreter.Interpreter_stringStack[--Skills.Interpreter_stringStackSize];
					var14 = Archive.method4265(ClientPacket.field2298, Client.packetWriter.isaacCipher);
					var14.packetBuffer.writeByte(var3.length() + 1);
					var14.packetBuffer.writeStringCp1252NullTerminated(var3);
					Client.packetWriter.method2219(var14);
					return 1;
				} else if (var0 == ScriptOpcodes.RESUME_STRINGDIALOG) {
					var3 = Interpreter.Interpreter_stringStack[--Skills.Interpreter_stringStackSize];
					var14 = Archive.method4265(ClientPacket.field2211, Client.packetWriter.isaacCipher);
					var14.packetBuffer.writeByte(var3.length() + 1);
					var14.packetBuffer.writeStringCp1252NullTerminated(var3);
					Client.packetWriter.method2219(var14);
					return 1;
				} else {
					String var7;
					int var15;
					if (var0 == ScriptOpcodes.OPPLAYER) {
						var15 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
						var7 = Interpreter.Interpreter_stringStack[--Skills.Interpreter_stringStackSize];
						class81.method1988(var15, var7);
						return 1;
					} else if (var0 == ScriptOpcodes.IF_DRAGPICKUP) {
						HealthBarUpdate.Interpreter_intStackSize -= 3;
						var15 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize];
						var10 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 1];
						int var9 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 2];
						Widget var13 = class80.getWidget(var9);
						class60.clickWidget(var13, var15, var10);
						return 1;
					} else if (var0 == ScriptOpcodes.CC_DRAGPICKUP) {
						HealthBarUpdate.Interpreter_intStackSize -= 2;
						var15 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize];
						var10 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 1];
						Widget var11 = var2 ? Interpreter.field1111 : Calendar.field2507;
						class60.clickWidget(var11, var15, var10);
						return 1;
					} else if (var0 == ScriptOpcodes.MOUSECAM) {
						DevicePcmPlayerProvider.mouseCam = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize] == 1;
						return 1;
					} else if (var0 == ScriptOpcodes.GETREMOVEROOFS) {
						Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = WorldMapLabelSize.clientPreferences.roofsHidden ? 1 : 0;
						return 1;
					} else if (var0 == ScriptOpcodes.SETREMOVEROOFS) {
						WorldMapLabelSize.clientPreferences.roofsHidden = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize] == 1;
						ReflectionCheck.savePreferences();
						return 1;
					} else if (var0 == ScriptOpcodes.OPENURL) {
						var3 = Interpreter.Interpreter_stringStack[--Skills.Interpreter_stringStackSize];
						boolean var4 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize] == 1;
						GrandExchangeOfferWorldComparator.openURL(var3, var4, false);
						return 1;
					} else if (var0 == ScriptOpcodes.RESUME_OBJDIALOG) {
						var15 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
						var14 = Archive.method4265(ClientPacket.field2245, Client.packetWriter.isaacCipher);
						var14.packetBuffer.writeShort(var15);
						Client.packetWriter.method2219(var14);
						return 1;
					} else if (var0 == ScriptOpcodes.BUG_REPORT) {
						var15 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
						Skills.Interpreter_stringStackSize -= 2;
						var7 = Interpreter.Interpreter_stringStack[Skills.Interpreter_stringStackSize];
						String var5 = Interpreter.Interpreter_stringStack[Skills.Interpreter_stringStackSize + 1];
						if (var7.length() > 500) {
							return 1;
						} else if (var5.length() > 500) {
							return 1;
						} else {
							PacketBufferNode var6 = Archive.method4265(ClientPacket.field2219, Client.packetWriter.isaacCipher);
							var6.packetBuffer.writeShort(1 + Huffman.stringCp1252NullTerminatedByteSize(var7) + Huffman.stringCp1252NullTerminatedByteSize(var5));
							var6.packetBuffer.writeStringCp1252NullTerminated(var7);
							var6.packetBuffer.writeByte(var15);
							var6.packetBuffer.writeStringCp1252NullTerminated(var5);
							Client.packetWriter.method2219(var6);
							return 1;
						}
					} else if (var0 == ScriptOpcodes.SETSHIFTCLICKDROP) {
						Client.shiftClickDrop = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize] == 1;
						return 1;
					} else if (var0 == ScriptOpcodes.SETSHOWMOUSEOVERTEXT) {
						Client.showMouseOverText = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize] == 1;
						return 1;
					} else if (var0 == ScriptOpcodes.RENDERSELF) {
						Client.renderSelf = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize] == 1;
						return 1;
					} else if (var0 == 3120) {
						if (Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize] == 1) {
							Client.field774 |= 1;
						} else {
							Client.field774 &= -2;
						}

						return 1;
					} else if (var0 == 3121) {
						if (Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize] == 1) {
							Client.field774 |= 2;
						} else {
							Client.field774 &= -3;
						}

						return 1;
					} else if (var0 == 3122) {
						if (Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize] == 1) {
							Client.field774 |= 4;
						} else {
							Client.field774 &= -5;
						}

						return 1;
					} else if (var0 == 3123) {
						if (Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize] == 1) {
							Client.field774 |= 8;
						} else {
							Client.field774 &= -9;
						}

						return 1;
					} else if (var0 == 3124) {
						Client.field774 = 0;
						return 1;
					} else if (var0 == ScriptOpcodes.SETSHOWMOUSECROSS) {
						Client.showMouseCross = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize] == 1;
						return 1;
					} else if (var0 == ScriptOpcodes.SETSHOWLOADINGMESSAGES) {
						Client.showLoadingMessages = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize] == 1;
						return 1;
					} else if (var0 == ScriptOpcodes.SETTAPTODROP) {
						UserComparator5.setTapToDrop(Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize] == 1);
						return 1;
					} else if (var0 == ScriptOpcodes.GETTAPTODROP) {
						Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = ScriptEvent.getTapToDrop() ? 1 : 0;
						return 1;
					} else if (var0 == ScriptOpcodes.SETOCULUSORBSPEED) {
						HealthBarUpdate.Interpreter_intStackSize -= 2;
						Client.oculusOrbNormalSpeed = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize];
						Client.oculusOrbSlowedSpeed = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 1];
						return 1;
					} else if (var0 == 3130) {
						HealthBarUpdate.Interpreter_intStackSize -= 2;
						return 1;
					} else if (var0 == 3131) {
						--HealthBarUpdate.Interpreter_intStackSize;
						return 1;
					} else if (var0 == ScriptOpcodes.GETCANVASSIZE) {
						Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = GrandExchangeEvent.canvasWidth;
						Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = ParamDefinition.canvasHeight;
						return 1;
					} else if (var0 == ScriptOpcodes.MOBILE_SETFPS) {
						--HealthBarUpdate.Interpreter_intStackSize;
						return 1;
					} else if (var0 == ScriptOpcodes.MOBILE_OPENSTORE) {
						return 1;
					} else if (var0 == ScriptOpcodes.MOBILE_OPENSTORECATEGORY) {
						HealthBarUpdate.Interpreter_intStackSize -= 2;
						return 1;
					} else if (var0 == 3136) {
						Client.field817 = 3;
						Client.field818 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
						return 1;
					} else if (var0 == 3137) {
						Client.field817 = 2;
						Client.field818 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
						return 1;
					} else if (var0 == 3138) {
						Client.field817 = 0;
						return 1;
					} else if (var0 == 3139) {
						Client.field817 = 1;
						return 1;
					} else if (var0 == 3140) {
						Client.field817 = 3;
						Client.field818 = var2 ? Interpreter.field1111.id : Calendar.field2507.id;
						return 1;
					} else {
						boolean var8;
						if (var0 == ScriptOpcodes.SETHIDEUSERNAME) {
							var8 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize] == 1;
							WorldMapLabelSize.clientPreferences.hideUsername = var8;
							ReflectionCheck.savePreferences();
							return 1;
						} else if (var0 == ScriptOpcodes.GETHIDEUSERNAME) {
							Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = WorldMapLabelSize.clientPreferences.hideUsername ? 1 : 0;
							return 1;
						} else if (var0 == ScriptOpcodes.SETREMEMBERUSERNAME) {
							var8 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize] == 1;
							Client.Login_isUsernameRemembered = var8;
							if (!var8) {
								WorldMapLabelSize.clientPreferences.rememberedUsername = "";
								ReflectionCheck.savePreferences();
							}

							return 1;
						} else if (var0 == ScriptOpcodes.GETREMEMBERUSERNAME) {
							Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = Client.Login_isUsernameRemembered ? 1 : 0;
							return 1;
						} else if (var0 == 3145) {
							return 1;
						} else if (var0 == ScriptOpcodes.SETTITLEMUSICENABLED) {
							var8 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize] == 1;
							if (var8 == WorldMapLabelSize.clientPreferences.titleMusicDisabled) {
								WorldMapLabelSize.clientPreferences.titleMusicDisabled = !var8;
								ReflectionCheck.savePreferences();
							}

							return 1;
						} else if (var0 == ScriptOpcodes.GETTITLEMUSICENABLED) {
							Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = WorldMapLabelSize.clientPreferences.titleMusicDisabled ? 0 : 1;
							return 1;
						} else if (var0 == 3148) {
							return 1;
						} else if (var0 == 3149) {
							Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3150) {
							Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3151) {
							Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3152) {
							Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3153) {
							Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = Login.Login_loadingPercent;
							return 1;
						} else if (var0 == 3154) {
							Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = Buddy.method5176();
							return 1;
						} else if (var0 == 3155) {
							HealthBarUpdate.Interpreter_intStackSize -= 2;
							return 1;
						} else {
							return var0 == 3156 ? 1 : 2;
						}
					}
				}
			}
		}
	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		signature = "(ILcx;ZI)I",
		garbageValue = "1145147367"
	)
	static int method535(int var0, Script var1, boolean var2) {
		if (var0 == ScriptOpcodes.FRIEND_COUNT) {
			if (ArchiveLoader.friendSystem.field1076 == 0) {
				Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = -2;
			} else if (ArchiveLoader.friendSystem.field1076 == 1) {
				Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = -1;
			} else {
				Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = ArchiveLoader.friendSystem.friendsList.getSize();
			}

			return 1;
		} else {
			int var3;
			if (var0 == ScriptOpcodes.FRIEND_GETNAME) {
				var3 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
				if (ArchiveLoader.friendSystem.method1791() && var3 >= 0 && var3 < ArchiveLoader.friendSystem.friendsList.getSize()) {
					Friend var8 = (Friend)ArchiveLoader.friendSystem.friendsList.get(var3);
					Interpreter.Interpreter_stringStack[++Skills.Interpreter_stringStackSize - 1] = var8.getName();
					Interpreter.Interpreter_stringStack[++Skills.Interpreter_stringStackSize - 1] = var8.getPreviousName();
				} else {
					Interpreter.Interpreter_stringStack[++Skills.Interpreter_stringStackSize - 1] = "";
					Interpreter.Interpreter_stringStack[++Skills.Interpreter_stringStackSize - 1] = "";
				}

				return 1;
			} else if (var0 == ScriptOpcodes.FRIEND_GETWORLD) {
				var3 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
				if (ArchiveLoader.friendSystem.method1791() && var3 >= 0 && var3 < ArchiveLoader.friendSystem.friendsList.getSize()) {
					Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = ((Buddy)ArchiveLoader.friendSystem.friendsList.get(var3)).world;
				} else {
					Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = 0;
				}

				return 1;
			} else if (var0 == ScriptOpcodes.FRIEND_GETRANK) {
				var3 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
				if (ArchiveLoader.friendSystem.method1791() && var3 >= 0 && var3 < ArchiveLoader.friendSystem.friendsList.getSize()) {
					Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = ((Buddy)ArchiveLoader.friendSystem.friendsList.get(var3)).rank;
				} else {
					Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = 0;
				}

				return 1;
			} else {
				String var5;
				if (var0 == ScriptOpcodes.FRIEND_SETRANK) {
					var5 = Interpreter.Interpreter_stringStack[--Skills.Interpreter_stringStackSize];
					int var6 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
					class14.method159(var5, var6);
					return 1;
				} else if (var0 == ScriptOpcodes.FRIEND_ADD) {
					var5 = Interpreter.Interpreter_stringStack[--Skills.Interpreter_stringStackSize];
					ArchiveLoader.friendSystem.addFriend(var5);
					return 1;
				} else if (var0 == ScriptOpcodes.FRIEND_DEL) {
					var5 = Interpreter.Interpreter_stringStack[--Skills.Interpreter_stringStackSize];
					ArchiveLoader.friendSystem.removeFriend(var5);
					return 1;
				} else if (var0 == ScriptOpcodes.IGNORE_ADD) {
					var5 = Interpreter.Interpreter_stringStack[--Skills.Interpreter_stringStackSize];
					ArchiveLoader.friendSystem.addIgnore(var5);
					return 1;
				} else if (var0 == ScriptOpcodes.IGNORE_DEL) {
					var5 = Interpreter.Interpreter_stringStack[--Skills.Interpreter_stringStackSize];
					ArchiveLoader.friendSystem.removeIgnore(var5);
					return 1;
				} else if (var0 == ScriptOpcodes.FRIEND_TEST) {
					var5 = Interpreter.Interpreter_stringStack[--Skills.Interpreter_stringStackSize];
					var5 = GrandExchangeOfferTotalQuantityComparator.removeImageTag(var5);
					Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = ArchiveLoader.friendSystem.isFriended(new Username(var5, class40.loginType), false) ? 1 : 0;
					return 1;
				} else if (var0 == ScriptOpcodes.CLAN_GETCHATDISPLAYNAME) {
					if (DevicePcmPlayerProvider.clanChat != null) {
						Interpreter.Interpreter_stringStack[++Skills.Interpreter_stringStackSize - 1] = DevicePcmPlayerProvider.clanChat.name;
					} else {
						Interpreter.Interpreter_stringStack[++Skills.Interpreter_stringStackSize - 1] = "";
					}

					return 1;
				} else if (var0 == ScriptOpcodes.CLAN_GETCHATCOUNT) {
					if (DevicePcmPlayerProvider.clanChat != null) {
						Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = DevicePcmPlayerProvider.clanChat.getSize();
					} else {
						Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else if (var0 == ScriptOpcodes.CLAN_GETCHATUSERNAME) {
					var3 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
					if (DevicePcmPlayerProvider.clanChat != null && var3 < DevicePcmPlayerProvider.clanChat.getSize()) {
						Interpreter.Interpreter_stringStack[++Skills.Interpreter_stringStackSize - 1] = DevicePcmPlayerProvider.clanChat.get(var3).getUsername().getName();
					} else {
						Interpreter.Interpreter_stringStack[++Skills.Interpreter_stringStackSize - 1] = "";
					}

					return 1;
				} else if (var0 == ScriptOpcodes.CLAN_GETCHATUSERWORLD) {
					var3 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
					if (DevicePcmPlayerProvider.clanChat != null && var3 < DevicePcmPlayerProvider.clanChat.getSize()) {
						Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = ((Buddy)DevicePcmPlayerProvider.clanChat.get(var3)).getWorld();
					} else {
						Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else if (var0 == ScriptOpcodes.CLAN_GETCHATUSERRANK) {
					var3 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
					if (DevicePcmPlayerProvider.clanChat != null && var3 < DevicePcmPlayerProvider.clanChat.getSize()) {
						Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = ((Buddy)DevicePcmPlayerProvider.clanChat.get(var3)).rank;
					} else {
						Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else if (var0 == ScriptOpcodes.CLAN_GETCHATMINKICK) {
					Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = DevicePcmPlayerProvider.clanChat != null ? DevicePcmPlayerProvider.clanChat.minKick : 0;
					return 1;
				} else if (var0 == ScriptOpcodes.CLAN_KICKUSER) {
					var5 = Interpreter.Interpreter_stringStack[--Skills.Interpreter_stringStackSize];
					Tile.clanKickUser(var5);
					return 1;
				} else if (var0 == ScriptOpcodes.CLAN_GETCHATRANK) {
					Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = DevicePcmPlayerProvider.clanChat != null ? DevicePcmPlayerProvider.clanChat.rank : 0;
					return 1;
				} else if (var0 == ScriptOpcodes.CLAN_JOINCHAT) {
					var5 = Interpreter.Interpreter_stringStack[--Skills.Interpreter_stringStackSize];
					class65.method1170(var5);
					return 1;
				} else if (var0 == ScriptOpcodes.CLAN_LEAVECHAT) {
					ScriptFrame.method1089();
					return 1;
				} else if (var0 == ScriptOpcodes.IGNORE_COUNT) {
					if (!ArchiveLoader.friendSystem.method1791()) {
						Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = -1;
					} else {
						Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = ArchiveLoader.friendSystem.ignoreList.getSize();
					}

					return 1;
				} else if (var0 == ScriptOpcodes.IGNORE_GETNAME) {
					var3 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
					if (ArchiveLoader.friendSystem.method1791() && var3 >= 0 && var3 < ArchiveLoader.friendSystem.ignoreList.getSize()) {
						Ignored var4 = (Ignored)ArchiveLoader.friendSystem.ignoreList.get(var3);
						Interpreter.Interpreter_stringStack[++Skills.Interpreter_stringStackSize - 1] = var4.getName();
						Interpreter.Interpreter_stringStack[++Skills.Interpreter_stringStackSize - 1] = var4.getPreviousName();
					} else {
						Interpreter.Interpreter_stringStack[++Skills.Interpreter_stringStackSize - 1] = "";
						Interpreter.Interpreter_stringStack[++Skills.Interpreter_stringStackSize - 1] = "";
					}

					return 1;
				} else if (var0 == ScriptOpcodes.IGNORE_TEST) {
					var5 = Interpreter.Interpreter_stringStack[--Skills.Interpreter_stringStackSize];
					var5 = GrandExchangeOfferTotalQuantityComparator.removeImageTag(var5);
					Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = ArchiveLoader.friendSystem.isIgnored(new Username(var5, class40.loginType)) ? 1 : 0;
					return 1;
				} else if (var0 == ScriptOpcodes.CLAN_ISSELF) {
					var3 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
					if (DevicePcmPlayerProvider.clanChat != null && var3 < DevicePcmPlayerProvider.clanChat.getSize() && DevicePcmPlayerProvider.clanChat.get(var3).getUsername().equals(Client.localPlayer.username)) {
						Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = 1;
					} else {
						Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else if (var0 == ScriptOpcodes.CLAN_GETCHATOWNERNAME) {
					if (DevicePcmPlayerProvider.clanChat != null && DevicePcmPlayerProvider.clanChat.owner != null) {
						Interpreter.Interpreter_stringStack[++Skills.Interpreter_stringStackSize - 1] = DevicePcmPlayerProvider.clanChat.owner;
					} else {
						Interpreter.Interpreter_stringStack[++Skills.Interpreter_stringStackSize - 1] = "";
					}

					return 1;
				} else if (var0 == ScriptOpcodes.CLAN_ISFRIEND) {
					var3 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
					if (DevicePcmPlayerProvider.clanChat != null && var3 < DevicePcmPlayerProvider.clanChat.getSize() && ((ClanMate)DevicePcmPlayerProvider.clanChat.get(var3)).isFriend()) {
						Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = 1;
					} else {
						Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else if (var0 != ScriptOpcodes.CLAN_ISIGNORE) {
					if (var0 == 3628) {
						ArchiveLoader.friendSystem.friendsList.removeComparator();
						return 1;
					} else {
						boolean var7;
						if (var0 == 3629) {
							var7 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize] == 1;
							ArchiveLoader.friendSystem.friendsList.addComparator(new UserComparator1(var7));
							return 1;
						} else if (var0 == 3630) {
							var7 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize] == 1;
							ArchiveLoader.friendSystem.friendsList.addComparator(new UserComparator2(var7));
							return 1;
						} else if (var0 == 3631) {
							var7 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize] == 1;
							ArchiveLoader.friendSystem.friendsList.addComparator(new UserComparator3(var7));
							return 1;
						} else if (var0 == 3632) {
							var7 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize] == 1;
							ArchiveLoader.friendSystem.friendsList.addComparator(new UserComparator4(var7));
							return 1;
						} else if (var0 == 3633) {
							var7 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize] == 1;
							ArchiveLoader.friendSystem.friendsList.addComparator(new UserComparator5(var7));
							return 1;
						} else if (var0 == 3634) {
							var7 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize] == 1;
							ArchiveLoader.friendSystem.friendsList.addComparator(new UserComparator6(var7));
							return 1;
						} else if (var0 == 3635) {
							var7 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize] == 1;
							ArchiveLoader.friendSystem.friendsList.addComparator(new UserComparator7(var7));
							return 1;
						} else if (var0 == 3636) {
							var7 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize] == 1;
							ArchiveLoader.friendSystem.friendsList.addComparator(new UserComparator8(var7));
							return 1;
						} else if (var0 == 3637) {
							var7 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize] == 1;
							ArchiveLoader.friendSystem.friendsList.addComparator(new UserComparator9(var7));
							return 1;
						} else if (var0 == 3638) {
							var7 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize] == 1;
							ArchiveLoader.friendSystem.friendsList.addComparator(new UserComparator10(var7));
							return 1;
						} else if (var0 == 3639) {
							ArchiveLoader.friendSystem.friendsList.sort();
							return 1;
						} else if (var0 == 3640) {
							ArchiveLoader.friendSystem.ignoreList.removeComparator();
							return 1;
						} else if (var0 == 3641) {
							var7 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize] == 1;
							ArchiveLoader.friendSystem.ignoreList.addComparator(new UserComparator1(var7));
							return 1;
						} else if (var0 == 3642) {
							var7 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize] == 1;
							ArchiveLoader.friendSystem.ignoreList.addComparator(new UserComparator2(var7));
							return 1;
						} else if (var0 == 3643) {
							ArchiveLoader.friendSystem.ignoreList.sort();
							return 1;
						} else if (var0 == 3644) {
							if (DevicePcmPlayerProvider.clanChat != null) {
								DevicePcmPlayerProvider.clanChat.removeComparator();
							}

							return 1;
						} else if (var0 == 3645) {
							var7 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize] == 1;
							if (DevicePcmPlayerProvider.clanChat != null) {
								DevicePcmPlayerProvider.clanChat.addComparator(new UserComparator1(var7));
							}

							return 1;
						} else if (var0 == 3646) {
							var7 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize] == 1;
							if (DevicePcmPlayerProvider.clanChat != null) {
								DevicePcmPlayerProvider.clanChat.addComparator(new UserComparator2(var7));
							}

							return 1;
						} else if (var0 == 3647) {
							var7 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize] == 1;
							if (DevicePcmPlayerProvider.clanChat != null) {
								DevicePcmPlayerProvider.clanChat.addComparator(new UserComparator3(var7));
							}

							return 1;
						} else if (var0 == 3648) {
							var7 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize] == 1;
							if (DevicePcmPlayerProvider.clanChat != null) {
								DevicePcmPlayerProvider.clanChat.addComparator(new UserComparator4(var7));
							}

							return 1;
						} else if (var0 == 3649) {
							var7 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize] == 1;
							if (DevicePcmPlayerProvider.clanChat != null) {
								DevicePcmPlayerProvider.clanChat.addComparator(new UserComparator5(var7));
							}

							return 1;
						} else if (var0 == 3650) {
							var7 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize] == 1;
							if (DevicePcmPlayerProvider.clanChat != null) {
								DevicePcmPlayerProvider.clanChat.addComparator(new UserComparator6(var7));
							}

							return 1;
						} else if (var0 == 3651) {
							var7 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize] == 1;
							if (DevicePcmPlayerProvider.clanChat != null) {
								DevicePcmPlayerProvider.clanChat.addComparator(new UserComparator7(var7));
							}

							return 1;
						} else if (var0 == 3652) {
							var7 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize] == 1;
							if (DevicePcmPlayerProvider.clanChat != null) {
								DevicePcmPlayerProvider.clanChat.addComparator(new UserComparator8(var7));
							}

							return 1;
						} else if (var0 == 3653) {
							var7 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize] == 1;
							if (DevicePcmPlayerProvider.clanChat != null) {
								DevicePcmPlayerProvider.clanChat.addComparator(new UserComparator9(var7));
							}

							return 1;
						} else if (var0 == 3654) {
							var7 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize] == 1;
							if (DevicePcmPlayerProvider.clanChat != null) {
								DevicePcmPlayerProvider.clanChat.addComparator(new UserComparator10(var7));
							}

							return 1;
						} else if (var0 == 3655) {
							if (DevicePcmPlayerProvider.clanChat != null) {
								DevicePcmPlayerProvider.clanChat.sort();
							}

							return 1;
						} else if (var0 == 3656) {
							var7 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize] == 1;
							ArchiveLoader.friendSystem.friendsList.addComparator(new BuddyRankComparator(var7));
							return 1;
						} else if (var0 == 3657) {
							var7 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize] == 1;
							if (DevicePcmPlayerProvider.clanChat != null) {
								DevicePcmPlayerProvider.clanChat.addComparator(new BuddyRankComparator(var7));
							}

							return 1;
						} else {
							return 2;
						}
					}
				} else {
					var3 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
					if (DevicePcmPlayerProvider.clanChat != null && var3 < DevicePcmPlayerProvider.clanChat.getSize() && ((ClanMate)DevicePcmPlayerProvider.clanChat.get(var3)).isIgnored()) {
						Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = 1;
					} else {
						Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				}
			}
		}
	}
}
