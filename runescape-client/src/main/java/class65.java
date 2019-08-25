import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("bl")
public class class65 extends RouteStrategy {
	class65() {
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(IIILfv;I)Z",
		garbageValue = "-1217489379"
	)
	@Export("hasArrived")
	public boolean hasArrived(int size, int x, int y, CollisionMap var4) {
		return x == super.approxDestinationX && y == super.approxDestinationY;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)Ljava/io/File;",
		garbageValue = "-46052492"
	)
	@Export("getFile")
	static File getFile(String var0) {
		if (!FileSystem.FileSystem_hasPermissions) {
			throw new RuntimeException("");
		}
		File var1 = (File) FileSystem.FileSystem_cacheFiles.get(var0);
		if (var1 != null) {
			return var1;
		}
		File var2 = new File(FileSystem.FileSystem_cacheDir, var0);
		RandomAccessFile var3 = null;

		try {
			File var4 = new File(var2.getParent());
			if (!var4.exists()) {
				throw new RuntimeException("");
			}
			var3 = new RandomAccessFile(var2, "rw");
			int var5 = var3.read();
			var3.seek(0L);
			var3.write(var5);
			var3.seek(0L);
			var3.close();
			FileSystem.FileSystem_cacheFiles.put(var0, var2);
			return var2;
		} catch (Exception var8) {
			try {
				if (var3 != null) {
					var3.close();
					var3 = null;
				}
			} catch (Exception var7) {
			}

			throw new RuntimeException();
		}
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(Lhp;III)Lly;",
		garbageValue = "300652258"
	)
	@Export("SpriteBuffer_getSprite")
	public static Sprite SpriteBuffer_getSprite(AbstractArchive var0, int var1, int var2) {
		if (!Friend.SpriteBuffer_bufferFile(var0, var1, var2)) {
			return null;
		}
		Sprite var4 = new Sprite();
		var4.width = SpriteBuffer.SpriteBuffer_spriteWidth;
		var4.height = SpriteBuffer.SpriteBuffer_spriteHeight;
		var4.xOffset = Varps.SpriteBuffer_xOffsets[0];
		var4.yOffset = SpriteBuffer.SpriteBuffer_yOffsets[0];
		var4.subWidth = SpriteBuffer.SpriteBuffer_spriteWidths[0];
		var4.subHeight = class216.SpriteBuffer_spriteHeights[0];
		int var5 = var4.subHeight * var4.subWidth;
		byte[] var6 = SpriteBuffer.SpriteBuffer_pixels[0];
		var4.pixels = new int[var5];

		for (int var7 = 0; var7 < var5; ++var7) {
			var4.pixels[var7] = Frames.SpriteBuffer_spritePalette[var6[var7] & 255];
		}

		class16.SpriteBuffer_clear();
		return var4;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		signature = "(ILcx;ZI)I",
		garbageValue = "-953201371"
	)
	static int method1175(int var0, Script var1, boolean var2) {
		int var3;
		int var4;
		int var6;
		if (var0 == ScriptOpcodes.ENUM_STRING) {
			HealthBarUpdate.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 1];
			EnumDefinition var5 = BoundaryObject.getEnum(var3);
			if (var5.outputType != 's') {
			}

			for (var6 = 0; var6 < var5.outputCount; ++var6) {
				if (var4 == var5.keys[var6]) {
					Interpreter.Interpreter_stringStack[++Skills.Interpreter_stringStackSize - 1] = var5.strVals[var6];
					var5 = null;
					break;
				}
			}

			if (var5 != null) {
				Interpreter.Interpreter_stringStack[++Skills.Interpreter_stringStackSize - 1] = var5.defaultStr;
			}

			return 1;
		}
		if (var0 == ScriptOpcodes.ENUM) {
			HealthBarUpdate.Interpreter_intStackSize -= 4;
			var3 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 1];
			int var9 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 2];
			var6 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 3];
			EnumDefinition var7 = BoundaryObject.getEnum(var9);
			if (var3 != var7.inputType || var4 != var7.outputType) {
				if (var4 == 115) {
					Interpreter.Interpreter_stringStack[++Skills.Interpreter_stringStackSize - 1] = "null";
				} else {
					Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = 0;
				}

				return 1;
			}

			for (int var8 = 0; var8 < var7.outputCount; ++var8) {
				if (var6 == var7.keys[var8]) {
					if (var4 == 115) {
						Interpreter.Interpreter_stringStack[++Skills.Interpreter_stringStackSize - 1] = var7.strVals[var8];
					} else {
						Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var7.intVals[var8];
					}

					var7 = null;
					break;
				}
			}

			if (var7 == null) {
				return 1;
			}
			if (var4 == 115) {
				Interpreter.Interpreter_stringStack[++Skills.Interpreter_stringStackSize - 1] = var7.defaultStr;
			} else {
				Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var7.defaultInt;
			}

			return 1;
		}
		if (var0 == ScriptOpcodes.ENUM_GETOUTPUTCOUNT) {
			var3 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
			EnumDefinition var10 = BoundaryObject.getEnum(var3);
			Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var10.size();
			return 1;
		}
		return 2;
	}

	@ObfuscatedName("ee")
	@ObfuscatedSignature(
		signature = "(IZZZB)Liu;",
		garbageValue = "6"
	)
	@Export("newArchive")
	static Archive newArchive(int var0, boolean var1, boolean var2, boolean var3) {
		ArchiveDisk var4 = null;
		if (JagexCache.JagexCache_dat2File != null) {
			var4 = new ArchiveDisk(var0, JagexCache.JagexCache_dat2File, JagexCache.JagexCache_idxFiles[var0], 1000000);
		}

		return new Archive(var4, ScriptEvent.masterDisk, var0, var1, var2, var3);
	}

	@ObfuscatedName("hq")
	@ObfuscatedSignature(
		signature = "(IIIII)V",
		garbageValue = "-1548212436"
	)
	@Export("addSceneMenuOptions")
	static final void addSceneMenuOptions(int mouseX, int mouseY, int xOffset, int yOffset) {
		if (Client.isItemSelected == 0 && !Client.isSpellSelected) {
			class188.insertMenuItemNoShift("Walk here", "", 23, 0, mouseX - xOffset, mouseY - yOffset);
		}

		long var4 = -1L;
		long var6 = -1L;
		for (int var8 = 0, var10 = ViewportMouse.ViewportMouse_entityCount; var8 < var10; var8++) {
			long var25 = ViewportMouse.ViewportMouse_entityTags[var8];
			if (var6 == var25) {
				continue;
			}
			var6 = var25;
			int var15 = Buddy.ViewportMouse_unpackX(var8);
			int var16 = Messages.ViewportMouse_unpackY(var8);
			int var17 = class3.ViewportMouse_unpackType(var8);
			int var18 = FriendSystem.ViewportMouse_unpackID(var8);
			if (var17 == 2 && GrandExchangeOfferWorldComparator.scene.getObjectFlags(class42.plane, var15, var16, var25) >= 0) {
				ObjectDefinition var19 = ViewportMouse.getObjectDefinition(var18);
				if (var19.transforms != null) {
					var19 = var19.transform();
				}

				if (var19 == null) {
					continue;
				}

				if (Client.isItemSelected == 1) {
					class188.insertMenuItemNoShift("Use", Client.selectedItemName + " " + "->" + " " + ClientPreferences.colorStartTag(0xffff) + var19.name, 1, var18, var15, var16);
				} else if (Client.isSpellSelected) {
					if ((WorldMapCacheName.selectedSpellFlags & 4) == 4) {
						class188.insertMenuItemNoShift(Client.selectedSpellActionName, Client.selectedSpellName + " " + "->" + " " + ClientPreferences.colorStartTag(0xffff) + var19.name, 2, var18, var15, var16);
					}
				} else {
					String[] var27 = var19.actions;
					if (var27 != null) {
						for (int var30 = 4; var30 >= 0; --var30) {
							if (var27[var30] == null) {
								continue;
							}
							short var22 = 0;
							if (var30 == 0) {
								var22 = 3;
							} else if (var30 == 1) {
								var22 = 4;
							} else if (var30 == 2) {
								var22 = 5;
							} else if (var30 == 3) {
								var22 = 6;
							} else if (var30 == 4) {
								var22 = 1001;
							}

							class188.insertMenuItemNoShift(var27[var30], ClientPreferences.colorStartTag(0xffff) + var19.name, var22, var18, var15, var16);
						}
					}

					class188.insertMenuItemNoShift("Examine", ClientPreferences.colorStartTag(0xffff) + var19.name, 1002, var19.id, var15, var16);
				}
			}

			int var20;
			NPC var21;
			Player var23;
			int[] var34;
			int var36;
			if (var17 == 1) {
				NPC var31 = Client.npcs[var18];
				if (var31 == null) {
					continue;
				}

				if (var31.definition.size == 1 && (var31.x & 127) == 64 && (var31.y & 127) == 64) {
					for (var20 = 0; var20 < Client.npcCount; ++var20) {
						var21 = Client.npcs[Client.npcIndices[var20]];
						if (var21 != null && var21 != var31 && var21.definition.size == 1 && var31.x == var21.x && var31.y == var21.y) {
							AbstractWorldMapData.addNpcToMenu(var21.definition, Client.npcIndices[var20], var15, var16);
						}
					}

					var20 = Players.Players_count;
					var34 = Players.Players_indices;

					for (var36 = 0; var36 < var20; ++var36) {
						var23 = Client.players[var34[var36]];
						if (var23 != null && var31.x == var23.x && var23.y == var31.y) {
							WorldMapManager.addPlayerToMenu(var23, var34[var36], var15, var16);
						}
					}
				}

				AbstractWorldMapData.addNpcToMenu(var31.definition, var18, var15, var16);
			}

			if (var17 == 0) {
				Player var32 = Client.players[var18];
				if (var32 == null) {
					continue;
				}

				if ((var32.x & 127) == 64 && (var32.y & 127) == 64) {
					for (var20 = 0; var20 < Client.npcCount; ++var20) {
						var21 = Client.npcs[Client.npcIndices[var20]];
						if (var21 != null && var21.definition.size == 1 && var32.x == var21.x && var21.y == var32.y) {
							AbstractWorldMapData.addNpcToMenu(var21.definition, Client.npcIndices[var20], var15, var16);
						}
					}

					var20 = Players.Players_count;
					var34 = Players.Players_indices;

					for (var36 = 0; var36 < var20; ++var36) {
						var23 = Client.players[var34[var36]];
						if (var23 != null && var32 != var23 && var23.x == var32.x && var32.y == var23.y) {
							WorldMapManager.addPlayerToMenu(var23, var34[var36], var15, var16);
						}
					}
				}

				if (var18 != Client.combatTargetPlayerIndex) {
					WorldMapManager.addPlayerToMenu(var32, var18, var15, var16);
				} else {
					var4 = var25;
				}
			}

			if (var17 != 3) {
				continue;
			}
			NodeDeque var33 = Client.groundItems[class42.plane][var15][var16];
			if (var33 == null) {
				continue;
			}
			for (TileItem var37 = (TileItem) var33.first(); var37 != null; var37 = (TileItem) var33.next()) {
				ItemDefinition var35 = WorldMapArea.ItemDefinition_get(var37.id);
				if (Client.isItemSelected == 1) {
					class188.insertMenuItemNoShift("Use", Client.selectedItemName + " " + "->" + " " + ClientPreferences.colorStartTag(0xff9040) + var35.name, 16, var37.id, var15, var16);
					continue;
				}
				if (Client.isSpellSelected) {
					if ((WorldMapCacheName.selectedSpellFlags & 1) == 1) {
						class188.insertMenuItemNoShift(Client.selectedSpellActionName, Client.selectedSpellName + " " + "->" + " " + ClientPreferences.colorStartTag(0xff9040) + var35.name, 17, var37.id, var15, var16);
					}
					continue;
				}
				String[] var28 = var35.groundActions;

				for (int var29 = 4; var29 >= 0; --var29) {
					if (var28 == null || var28[var29] == null) {
						if (var29 == 2) {
							class188.insertMenuItemNoShift("Take", ClientPreferences.colorStartTag(0xff9040) + var35.name, 20, var37.id, var15, var16);
						}
						continue;
					}
					byte var24 = 0;
					if (var29 == 0) {
						var24 = 18;
					} else if (var29 == 1) {
						var24 = 19;
					} else if (var29 == 2) {
						var24 = 20;
					} else if (var29 == 3) {
						var24 = 21;
					} else if (var29 == 4) {
						var24 = 22;
					}

					class188.insertMenuItemNoShift(var28[var29], ClientPreferences.colorStartTag(0xff9040) + var35.name, var24, var37.id, var15, var16);
				}

				class188.insertMenuItemNoShift("Examine", ClientPreferences.colorStartTag(0xff9040) + var35.name, 1004, var37.id, var15, var16);
			}
		}

		if (-1L != var4) {
			int var8 = (int) (var4 >>> 0 & 127L);
			int var10 = (int) (var4 >>> 7 & 127L);
			Player var12 = Client.players[Client.combatTargetPlayerIndex];
			WorldMapManager.addPlayerToMenu(var12, Client.combatTargetPlayerIndex, var8, var10);
		}
	}

	@ObfuscatedName("jq")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "65"
	)
	static void method1176() {
		for (InterfaceParent var0 = (InterfaceParent)Client.interfaceParents.first(); var0 != null; var0 = (InterfaceParent)Client.interfaceParents.next()) {
			int var1 = var0.group;
			if (!class162.loadInterface(var1)) {
				continue;
			}
			boolean var2 = true;
			Widget[] var3 = Widget.Widget_interfaceComponents[var1];

			int var4;
			for (var4 = 0; var4 < var3.length; ++var4) {
				if (var3[var4] != null) {
					var2 = var3[var4].isIf3;
					break;
				}
			}

			if (var2) {
				continue;
			}
			var4 = (int)var0.key;
			Widget var5 = class80.getWidget(var4);
			if (var5 != null) {
				Strings.invalidateWidget(var5);
			}
		}

	}

	@ObfuscatedName("jv")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "-1765839836"
	)
	@Export("Clan_joinChat")
	static final void Clan_joinChat(String var0) {
		if (var0.equals("")) {
			return;
		}
		PacketBufferNode var1 = Archive.getPacketBufferNode(ClientPacket.field2286, Client.packetWriter.isaacCipher);
		var1.packetBuffer.writeByte(Huffman.stringCp1252NullTerminatedByteSize(var0));
		var1.packetBuffer.writeStringCp1252NullTerminated(var0);
		Client.packetWriter.addNode(var1);
	}
}
