import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("o")
final class class2 implements class0 {
	@ObfuscatedName("ql")
	@ObfuscatedSignature(
		signature = "Lch;"
	)
	@Export("pcmStreamMixer")
	static PcmStreamMixer pcmStreamMixer;

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/Object;Lkp;B)V",
		garbageValue = "95"
	)
	public void vmethod55(Object var1, Buffer var2) {
		this.method21((Long)var1, var2);
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Lkp;I)Ljava/lang/Object;",
		garbageValue = "1665636232"
	)
	public Object vmethod53(Buffer var1) {
		return var1.readLong();
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/Long;Lkp;I)V",
		garbageValue = "-301024958"
	)
	void method21(Long var1, Buffer var2) {
		var2.writeLong(var1);
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(II)Lhq;",
		garbageValue = "-1693813120"
	)
	public static ServerBuild method31(int var0) {
		ServerBuild[] var1 = WorldMapID.method572();

		for (int var2 = 0; var2 < var1.length; ++var2) {
			ServerBuild var3 = var1[var2];
			if (var0 == var3.field3108) {
				return var3;
			}
		}

		return null;
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(ILce;ZB)I",
		garbageValue = "-115"
	)
	static int method34(int var0, Script var1, boolean var2) {
		int var4 = -1;
		Widget var3;
		if (var0 >= 2000) {
			var0 -= 1000;
			var4 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
			var3 = Varps.getWidget(var4);
		} else {
			var3 = var2 ? class186.field2331 : MidiPcmStream.field2444;
		}

		if (var0 == ScriptOpcodes.CC_SETSCROLLPOS) {
			class320.Interpreter_intStackSize -= 2;
			var3.scrollX = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize];
			if (var3.scrollX > var3.scrollWidth - var3.width) {
				var3.scrollX = var3.scrollWidth - var3.width;
			}

			if (var3.scrollX < 0) {
				var3.scrollX = 0;
			}

			var3.scrollY = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1];
			if (var3.scrollY > var3.scrollHeight - var3.height) {
				var3.scrollY = var3.scrollHeight - var3.height;
			}

			if (var3.scrollY < 0) {
				var3.scrollY = 0;
			}

			NPCDefinition.invalidateWidget(var3);
			return 1;
		} else if (var0 == ScriptOpcodes.CC_SETCOLOUR) {
			var3.color = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
			NPCDefinition.invalidateWidget(var3);
			return 1;
		} else if (var0 == ScriptOpcodes.CC_SETFILL) {
			var3.fill = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
			NPCDefinition.invalidateWidget(var3);
			return 1;
		} else if (var0 == ScriptOpcodes.CC_SETTRANS) {
			var3.transparencyTop = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
			NPCDefinition.invalidateWidget(var3);
			return 1;
		} else if (var0 == ScriptOpcodes.CC_SETLINEWID) {
			var3.lineWid = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
			NPCDefinition.invalidateWidget(var3);
			return 1;
		} else if (var0 == ScriptOpcodes.CC_SETGRAPHIC) {
			var3.spriteId2 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
			NPCDefinition.invalidateWidget(var3);
			return 1;
		} else if (var0 == ScriptOpcodes.CC_SET2DANGLE) {
			var3.spriteAngle = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
			NPCDefinition.invalidateWidget(var3);
			return 1;
		} else if (var0 == ScriptOpcodes.CC_SETTILING) {
			var3.spriteTiling = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
			NPCDefinition.invalidateWidget(var3);
			return 1;
		} else if (var0 == ScriptOpcodes.CC_SETMODEL) {
			var3.modelType = 1;
			var3.modelId = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
			NPCDefinition.invalidateWidget(var3);
			return 1;
		} else if (var0 == ScriptOpcodes.CC_SETMODELANGLE) {
			class320.Interpreter_intStackSize -= 6;
			var3.modelOffsetX = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize];
			var3.modelOffsetY = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1];
			var3.modelAngleX = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 2];
			var3.modelAngleY = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 3];
			var3.modelAngleZ = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 4];
			var3.modelZoom = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 5];
			NPCDefinition.invalidateWidget(var3);
			return 1;
		} else {
			int var8;
			if (var0 == ScriptOpcodes.CC_SETMODELANIM) {
				var8 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
				if (var8 != var3.sequenceId) {
					var3.sequenceId = var8;
					var3.modelFrame = 0;
					var3.modelFrameCycle = 0;
					NPCDefinition.invalidateWidget(var3);
				}

				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETMODELORTHOG) {
				var3.modelOrthog = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
				NPCDefinition.invalidateWidget(var3);
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETTEXT) {
				String var7 = Interpreter.Interpreter_stringStack[--Message.Interpreter_stringStackSize];
				if (!var7.equals(var3.text)) {
					var3.text = var7;
					NPCDefinition.invalidateWidget(var3);
				}

				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETTEXTFONT) {
				var3.fontId = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
				NPCDefinition.invalidateWidget(var3);
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETTEXTALIGN) {
				class320.Interpreter_intStackSize -= 3;
				var3.textXAlignment = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize];
				var3.textYAlignment = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1];
				var3.textLineHeight = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 2];
				NPCDefinition.invalidateWidget(var3);
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETTEXTSHADOW) {
				var3.textShadowed = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
				NPCDefinition.invalidateWidget(var3);
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETOUTLINE) {
				var3.outline = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
				NPCDefinition.invalidateWidget(var3);
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETGRAPHICSHADOW) {
				var3.spriteShadow = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
				NPCDefinition.invalidateWidget(var3);
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETVFLIP) {
				var3.spriteFlipV = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
				NPCDefinition.invalidateWidget(var3);
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETHFLIP) {
				var3.spriteFlipH = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
				NPCDefinition.invalidateWidget(var3);
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETSCROLLSIZE) {
				class320.Interpreter_intStackSize -= 2;
				var3.scrollWidth = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize];
				var3.scrollHeight = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1];
				NPCDefinition.invalidateWidget(var3);
				if (var4 != -1 && var3.type == 0) {
					WorldMapIcon_1.revalidateWidgetScroll(WorldMapLabel.Widget_interfaceComponents[var4 >> 16], var3, false);
				}

				return 1;
			} else if (var0 == ScriptOpcodes.CC_RESUME_PAUSEBUTTON) {
				WorldMapAreaData.resumePauseWidget(var3.id, var3.childIndex);
				Client.meslayerContinueWidget = var3;
				NPCDefinition.invalidateWidget(var3);
				return 1;
			} else if (var0 == 1122) {
				var3.spriteId = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
				NPCDefinition.invalidateWidget(var3);
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETFILLCOLOUR) {
				var3.color2 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
				NPCDefinition.invalidateWidget(var3);
				return 1;
			} else if (var0 == 1124) {
				var3.transparencyBot = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
				NPCDefinition.invalidateWidget(var3);
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETFILLMODE) {
				var8 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
				FillMode var6 = (FillMode)WorldMapSection0.findEnumerated(ClientPreferences.FillMode_values(), var8);
				if (var6 != null) {
					var3.fillMode = var6;
					NPCDefinition.invalidateWidget(var3);
				}

				return 1;
			} else {
				boolean var5;
				if (var0 == ScriptOpcodes.CC_SETLINEDIRECTION) {
					var5 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
					var3.field2606 = var5;
					return 1;
				} else if (var0 == ScriptOpcodes.CC_SETMODELTRANSPARENT) {
					var5 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
					var3.modelTransparency = var5;
					return 1;
				} else {
					return 2;
				}
			}
		}
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		signature = "([BB)[B",
		garbageValue = "-84"
	)
	@Export("decompressBytes")
	static final byte[] decompressBytes(byte[] var0) {
		Buffer var1 = new Buffer(var0);
		int var2 = var1.readUnsignedByte();
		int var3 = var1.readInt();
		if (var3 < 0 || AbstractArchive.field3148 != 0 && var3 > AbstractArchive.field3148) {
			throw new RuntimeException();
		} else if (var2 == 0) {
			byte[] var4 = new byte[var3];
			var1.readBytes(var4, 0, var3);
			return var4;
		} else {
			int var6 = var1.readInt();
			if (var6 >= 0 && (AbstractArchive.field3148 == 0 || var6 <= AbstractArchive.field3148)) {
				byte[] var5 = new byte[var6];
				if (var2 == 1) {
					BZip2Decompressor.BZip2Decompressor_decompress(var5, var6, var0, var3, 9);
				} else {
					AbstractArchive.gzipDecompressor.decompress(var1, var5);
				}

				return var5;
			} else {
				throw new RuntimeException();
			}
		}
	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "26"
	)
	protected static final void method24() {
		GameShell.clock.mark();

		int var0;
		for (var0 = 0; var0 < 32; ++var0) {
			GameShell.graphicsTickTimes[var0] = 0L;
		}

		for (var0 = 0; var0 < 32; ++var0) {
			GameShell.clientTickTimes[var0] = 0L;
		}

		Fonts.gameCyclesToDo = 0;
	}

	@ObfuscatedName("fj")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-917024322"
	)
	static void method32() {
		Client.mouseLastLastPressedTimeMillis = -1L;
		class16.mouseRecorder.index = 0;
		GrandExchangeOfferTotalQuantityComparator.hasFocus = true;
		Client.hadFocus = true;
		Client.field702 = -1L;
		GrandExchangeOfferAgeComparator.method162();
		Client.packetWriter.clearBuffer();
		Client.packetWriter.packetBuffer.offset = 0;
		Client.packetWriter.serverPacket = null;
		Client.packetWriter.field1309 = null;
		Client.packetWriter.field1305 = null;
		Client.packetWriter.field1307 = null;
		Client.packetWriter.serverPacketLength = 0;
		Client.packetWriter.field1299 = 0;
		Client.rebootTimer = 0;
		Client.logoutTimer = 0;
		Client.hintArrowType = 0;
		Client.menuOptionsCount = 0;
		Client.isMenuOpen = false;
		MouseHandler.MouseHandler_idleCycles = 0;
		SoundSystem.method2563();
		Client.isItemSelected = 0;
		Client.isSpellSelected = false;
		Client.soundEffectCount = 0;
		Client.camAngleY = 0;
		Client.oculusOrbState = 0;
		class218.field2716 = null;
		Client.minimapState = 0;
		Client.field704 = -1;
		Client.destinationX = 0;
		Client.destinationY = 0;
		Client.playerAttackOption = AttackOption.AttackOption_hidden;
		Client.npcAttackOption = AttackOption.AttackOption_hidden;
		Client.npcCount = 0;
		GrandExchangeOfferOwnWorldComparator.method1308();

		int var0;
		for (var0 = 0; var0 < 2048; ++var0) {
			Client.players[var0] = null;
		}

		for (var0 = 0; var0 < 32768; ++var0) {
			Client.npcs[var0] = null;
		}

		Client.combatTargetPlayerIndex = -1;
		Client.projectiles.clear();
		Client.graphicsObjects.clear();

		for (var0 = 0; var0 < 4; ++var0) {
			for (int var1 = 0; var1 < 104; ++var1) {
				for (int var2 = 0; var2 < 104; ++var2) {
					Client.groundItems[var0][var1][var2] = null;
				}
			}
		}

		Client.pendingSpawns = new NodeDeque();
		KeyHandler.friendSystem.clear();

		for (var0 = 0; var0 < VarpDefinition.VarpDefinition_fileCount; ++var0) {
			VarpDefinition var3 = Messages.VarpDefinition_get(var0);
			if (var3 != null) {
				Varps.Varps_temp[var0] = 0;
				Varps.Varps_main[var0] = 0;
			}
		}

		class197.varcs.clearTransient();
		Client.followerIndex = -1;
		if (Client.rootInterface != -1) {
			ObjectSound.method1933(Client.rootInterface);
		}

		for (InterfaceParent var4 = (InterfaceParent)Client.interfaceParents.first(); var4 != null; var4 = (InterfaceParent)Client.interfaceParents.next()) {
			class185.closeInterface(var4, true);
		}

		Client.rootInterface = -1;
		Client.interfaceParents = new NodeHashTable(8);
		Client.meslayerContinueWidget = null;
		Client.menuOptionsCount = 0;
		Client.isMenuOpen = false;
		Client.playerAppearance.update((int[])null, new int[]{0, 0, 0, 0, 0}, false, -1);

		for (var0 = 0; var0 < 8; ++var0) {
			Client.playerMenuActions[var0] = null;
			Client.playerOptionsPriorities[var0] = false;
		}

		WorldMapLabelSize.method198();
		Client.isLoading = true;

		for (var0 = 0; var0 < 100; ++var0) {
			Client.field851[var0] = true;
		}

		class238.method4415();
		InterfaceParent.clanChat = null;

		for (var0 = 0; var0 < 8; ++var0) {
			Client.grandExchangeOffers[var0] = new GrandExchangeOffer();
		}

		PendingSpawn.grandExchangeEvents = null;
	}
}
