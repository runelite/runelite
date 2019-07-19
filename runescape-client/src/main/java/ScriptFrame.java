import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bh")
@Implements("ScriptFrame")
public class ScriptFrame {
	@ObfuscatedName("rk")
	@ObfuscatedGetter(
		intValue = 1697937431
	)
	static int field526;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 1199234245
	)
	public static int field529;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 1541896355
	)
	static int field527;
	@ObfuscatedName("bx")
	@ObfuscatedSignature(
		signature = "Lgu;"
	)
	static class190 field528;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lcx;"
	)
	@Export("script")
	Script script;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 949224095
	)
	@Export("pc")
	int pc;
	@ObfuscatedName("e")
	@Export("intLocals")
	int[] intLocals;
	@ObfuscatedName("p")
	@Export("stringLocals")
	String[] stringLocals;

	ScriptFrame() {
		this.pc = -1;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "([BIIIIIII[Lfv;B)V",
		garbageValue = "66"
	)
	static final void method1088(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, CollisionMap[] var8) {
		int var10;
		for (int var9 = 0; var9 < 8; ++var9) {
			for (var10 = 0; var10 < 8; ++var10) {
				if (var9 + var2 > 0 && var9 + var2 < 103 && var3 + var10 > 0 && var3 + var10 < 103) {
					int[] var10000 = var8[var1].flags[var9 + var2];
					var10000[var3 + var10] &= -16777217;
				}
			}
		}

		Buffer var13 = new Buffer(var0);

		for (var10 = 0; var10 < 4; ++var10) {
			for (int var11 = 0; var11 < 64; ++var11) {
				for (int var12 = 0; var12 < 64; ++var12) {
					if (var10 == var4 && var11 >= var5 && var11 < var5 + 8 && var12 >= var6 && var12 < var6 + 8) {
						WorldMapLabel.loadTerrain(var13, var1, var2 + class197.method3702(var11 & 7, var12 & 7, var7), var3 + WorldMapManager.method625(var11 & 7, var12 & 7, var7), 0, 0, var7);
					} else {
						WorldMapLabel.loadTerrain(var13, 0, -1, -1, 0, 0, 0);
					}
				}
			}
		}

	}

	@ObfuscatedName("fi")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "204342367"
	)
	static final void method1090() {
		if (Client.field700 > 0) {
			RouteStrategy.method3593();
		} else {
			Client.timer.method4993();
			class96.updateGameState(40);
			class269.field3563 = Client.packetWriter.getSocket();
			Client.packetWriter.removeSocket();
		}
	}

	@ObfuscatedName("gx")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "975361183"
	)
	@Export("checkLocalPlayerDestination")
	static void checkLocalPlayerDestination() {
		if (Client.localPlayer.x >> 7 == Client.destinationX && Client.localPlayer.y >> 7 == Client.destinationY) {
			Client.destinationX = 0;
		}

	}

	@ObfuscatedName("gv")
	@ObfuscatedSignature(
		signature = "(ZLkx;I)V",
		garbageValue = "1426671502"
	)
	@Export("updateNpcs")
	static final void updateNpcs(boolean var0, PacketBuffer var1) {
		Client.field775 = 0;
		Client.field697 = 0;
		StructDefinition.method4530();

		int var2;
		NPC var4;
		int var5;
		int var6;
		int var7;
		int var8;
		int var9;
		while (var1.bitsRemaining(Client.packetWriter.serverPacketLength) >= 27) {
			var2 = var1.readBits(15);
			if (var2 == 32767) {
				break;
			}

			boolean var3 = false;
			if (Client.npcs[var2] == null) {
				Client.npcs[var2] = new NPC();
				var3 = true;
			}

			var4 = Client.npcs[var2];
			Client.npcIndices[++Client.npcCount - 1] = var2;
			var4.npcCycle = Client.cycle;
			if (var0) {
				var5 = var1.readBits(8);
				if (var5 > 127) {
					var5 -= 256;
				}
			} else {
				var5 = var1.readBits(5);
				if (var5 > 15) {
					var5 -= 32;
				}
			}

			var6 = var1.readBits(1);
			var7 = Client.field780[var1.readBits(3)];
			if (var3) {
				var4.orientation = var4.field950 = var7;
			}

			var8 = var1.readBits(1);
			if (var8 == 1) {
				Client.field859[++Client.field697 - 1] = var2;
			}

			if (var0) {
				var9 = var1.readBits(8);
				if (var9 > 127) {
					var9 -= 256;
				}
			} else {
				var9 = var1.readBits(5);
				if (var9 > 15) {
					var9 -= 32;
				}
			}

			var4.definition = GameShell.getNpcDefinition(var1.readBits(14));
			var4.size = var4.definition.size * 78073455;
			var4.field948 = var4.definition.field3492;
			if (var4.field948 == 0) {
				var4.field950 = 0;
			}

			var4.walkSequence = var4.definition.walkSequence;
			var4.walkBackSequence = var4.definition.walkBackSequence;
			var4.walkLeftSequence = var4.definition.walkLeftSequence;
			var4.walkRightSequence = var4.definition.walkRightSequence;
			var4.readySequence = var4.definition.readySequence;
			var4.turnLeftSequence = var4.definition.turnLeftSequence;
			var4.turnRightSequence = var4.definition.turnRightSequence;
			var4.method1963(Client.localPlayer.pathX[0] + var5, Client.localPlayer.pathY[0] + var9, var6 == 1);
		}

		var1.exportIndex();

		int var14;
		for (var2 = 0; var2 < Client.field697; ++var2) {
			var14 = Client.field859[var2];
			var4 = Client.npcs[var14];
			var5 = var1.readUnsignedByte();
			if ((var5 & 1) != 0) {
				var4.targetIndex = var1.method5532();
				if (var4.targetIndex == 65535) {
					var4.targetIndex = -1;
				}
			}

			if ((var5 & 64) != 0) {
				var6 = var1.method5534();
				var7 = var1.method5534();
				var8 = var4.x - (var6 - MusicPatchNode2.baseX * 64 - MusicPatchNode2.baseX * 64) * 64;
				var9 = var4.y - (var7 - class1.baseY * 64 - class1.baseY * 64) * 64;
				if (var8 != 0 || var9 != 0) {
					var4.field976 = (int)(Math.atan2((double)var8, (double)var9) * 325.949D) & 2047;
				}
			}

			if ((var5 & 32) != 0) {
				var6 = var1.readUnsignedShort();
				if (var6 == 65535) {
					var6 = -1;
				}

				var7 = var1.method5525();
				if (var6 == var4.sequence && var6 != -1) {
					var8 = GrandExchangeEvent.getSequenceDefinition(var6).field3529;
					if (var8 == 1) {
						var4.sequenceFrame = 0;
						var4.sequenceFrameCycle = 0;
						var4.sequenceDelay = var7;
						var4.field985 = 0;
					}

					if (var8 == 2) {
						var4.field985 = 0;
					}
				} else if (var6 == -1 || var4.sequence == -1 || GrandExchangeEvent.getSequenceDefinition(var6).field3533 >= GrandExchangeEvent.getSequenceDefinition(var4.sequence).field3533) {
					var4.sequence = var6;
					var4.sequenceFrame = 0;
					var4.sequenceFrameCycle = 0;
					var4.sequenceDelay = var7;
					var4.field985 = 0;
					var4.field1008 = var4.pathLength;
				}
			}

			if ((var5 & 4) != 0) {
				var4.definition = GameShell.getNpcDefinition(var1.readUnsignedShort());
				var4.size = var4.definition.size * 78073455;
				var4.field948 = var4.definition.field3492;
				var4.walkSequence = var4.definition.walkSequence;
				var4.walkBackSequence = var4.definition.walkBackSequence;
				var4.walkLeftSequence = var4.definition.walkLeftSequence;
				var4.walkRightSequence = var4.definition.walkRightSequence;
				var4.readySequence = var4.definition.readySequence;
				var4.turnLeftSequence = var4.definition.turnLeftSequence;
				var4.turnRightSequence = var4.definition.turnRightSequence;
			}

			if ((var5 & 16) != 0) {
				var6 = var1.readUnsignedByteNegate();
				int var10;
				int var11;
				int var12;
				if (var6 > 0) {
					for (var7 = 0; var7 < var6; ++var7) {
						var9 = -1;
						var10 = -1;
						var11 = -1;
						var8 = var1.readUShortSmart();
						if (var8 == 32767) {
							var8 = var1.readUShortSmart();
							var10 = var1.readUShortSmart();
							var9 = var1.readUShortSmart();
							var11 = var1.readUShortSmart();
						} else if (var8 != 32766) {
							var10 = var1.readUShortSmart();
						} else {
							var8 = -1;
						}

						var12 = var1.readUShortSmart();
						var4.addHitSplat(var8, var10, var9, var11, Client.cycle, var12);
					}
				}

				var7 = var1.method5722();
				if (var7 > 0) {
					for (var8 = 0; var8 < var7; ++var8) {
						var9 = var1.readUShortSmart();
						var10 = var1.readUShortSmart();
						if (var10 != 32767) {
							var11 = var1.readUShortSmart();
							var12 = var1.readUnsignedByte();
							int var13 = var10 > 0 ? var1.method5525() : var12;
							var4.addHealthBar(var9, Client.cycle, var10, var11, var12, var13);
						} else {
							var4.removeHealthBar(var9);
						}
					}
				}
			}

			if ((var5 & 8) != 0) {
				var4.spotAnimation = var1.method5532();
				var6 = var1.method5542();
				var4.heightOffset = var6 >> 16;
				var4.field989 = (var6 & 65535) + Client.cycle;
				var4.spotAnimationFrame = 0;
				var4.spotAnimationFrameCycle = 0;
				if (var4.field989 > Client.cycle) {
					var4.spotAnimationFrame = -1;
				}

				if (var4.spotAnimation == 65535) {
					var4.spotAnimation = -1;
				}
			}

			if ((var5 & 2) != 0) {
				var4.overheadText = var1.readStringCp1252NullTerminated();
				var4.overheadTextCyclesRemaining = 100;
			}
		}

		for (var2 = 0; var2 < Client.field775; ++var2) {
			var14 = Client.field776[var2];
			if (Client.npcs[var14].npcCycle != Client.cycle) {
				Client.npcs[var14].definition = null;
				Client.npcs[var14] = null;
			}
		}

		if (var1.offset != Client.packetWriter.serverPacketLength) {
			throw new RuntimeException(var1.offset + "," + Client.packetWriter.serverPacketLength);
		} else {
			for (var2 = 0; var2 < Client.npcCount; ++var2) {
				if (Client.npcs[Client.npcIndices[var2]] == null) {
					throw new RuntimeException(var2 + "," + Client.npcCount);
				}
			}

		}
	}

	@ObfuscatedName("hf")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "-881674814"
	)
	static void method1086(int var0, int var1) {
		PacketBufferNode var2 = Archive.method4265(ClientPacket.field2273, Client.packetWriter.isaacCipher);
		var2.packetBuffer.writeIntLE16(var0);
		var2.packetBuffer.method5530(var1);
		Client.packetWriter.method2219(var2);
	}

	@ObfuscatedName("js")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-73"
	)
	static final void method1089() {
		PacketBufferNode var0 = Archive.method4265(ClientPacket.field2286, Client.packetWriter.isaacCipher);
		var0.packetBuffer.writeByte(0);
		Client.packetWriter.method2219(var0);
	}
}
