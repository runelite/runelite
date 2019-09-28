import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bk")
@Implements("InterfaceParent")
public class InterfaceParent extends Node {
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -2031871231
	)
	@Export("group")
	int group;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -1707637965
	)
	@Export("type")
	int type;
	@ObfuscatedName("v")
	boolean field552;

	InterfaceParent() {
		this.field552 = false;
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(II)Lik;",
		garbageValue = "2088846570"
	)
	@Export("SpotAnimationDefinition_get")
	public static SpotAnimationDefinition SpotAnimationDefinition_get(int var0) {
		SpotAnimationDefinition var1 = (SpotAnimationDefinition)SpotAnimationDefinition.SpotAnimationDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = class14.SpotAnimationDefinition_archive.takeFile(13, var0);
			var1 = new SpotAnimationDefinition();
			var1.id = var0;
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			SpotAnimationDefinition.SpotAnimationDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Lgy;Llg;I)Lgn;",
		garbageValue = "1885960341"
	)
	@Export("getPacketBufferNode")
	public static PacketBufferNode getPacketBufferNode(ClientPacket var0, IsaacCipher var1) {
		PacketBufferNode var2;
		if (PacketBufferNode.PacketBufferNode_packetBufferNodeCount == 0) {
			var2 = new PacketBufferNode();
		} else {
			var2 = PacketBufferNode.PacketBufferNode_packetBufferNodes[--PacketBufferNode.PacketBufferNode_packetBufferNodeCount];
		}

		var2.clientPacket = var0;
		var2.clientPacketLength = var0.length;
		if (var2.clientPacketLength == -1) {
			var2.packetBuffer = new PacketBuffer(260);
		} else if (var2.clientPacketLength == -2) {
			var2.packetBuffer = new PacketBuffer(10000);
		} else if (var2.clientPacketLength <= 18) {
			var2.packetBuffer = new PacketBuffer(20);
		} else if (var2.clientPacketLength <= 98) {
			var2.packetBuffer = new PacketBuffer(100);
		} else {
			var2.packetBuffer = new PacketBuffer(260);
		}

		var2.packetBuffer.setIsaacCipher(var1);
		var2.packetBuffer.writeByteIsaac(var2.clientPacket.id);
		var2.index = 0;
		return var2;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1288717828"
	)
	static void method1197() {
		if (Login.Login_username == null || Login.Login_username.length() <= 0) {
			if (AbstractArchive.clientPreferences.rememberedUsername != null) {
				Login.Login_username = AbstractArchive.clientPreferences.rememberedUsername;
				Client.Login_isUsernameRemembered = true;
			} else {
				Client.Login_isUsernameRemembered = false;
			}

		}
	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "4"
	)
	public static void method1192(int var0) {
		if (var0 != -1) {
			if (ViewportMouse.Widget_loadedInterfaces[var0]) {
				Widget.Widget_archive.clearFilesGroup(var0);
				if (UserComparator5.Widget_interfaceComponents[var0] != null) {
					boolean var1 = true;

					for (int var2 = 0; var2 < UserComparator5.Widget_interfaceComponents[var0].length; ++var2) {
						if (UserComparator5.Widget_interfaceComponents[var0][var2] != null) {
							if (UserComparator5.Widget_interfaceComponents[var0][var2].type != 2) {
								UserComparator5.Widget_interfaceComponents[var0][var2] = null;
							} else {
								var1 = false;
							}
						}
					}

					if (var1) {
						UserComparator5.Widget_interfaceComponents[var0] = null;
					}

					ViewportMouse.Widget_loadedInterfaces[var0] = false;
				}
			}
		}
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "746031427"
	)
	public static void method1193() {
		ItemDefinition.ItemDefinition_cached.clear();
		ItemDefinition.ItemDefinition_cachedModels.clear();
		ItemDefinition.ItemDefinition_cachedSprites.clear();
	}

	@ObfuscatedName("hk")
	@ObfuscatedSignature(
		signature = "(ZLkf;B)V",
		garbageValue = "-96"
	)
	@Export("updateNpcs")
	static final void updateNpcs(boolean var0, PacketBuffer var1) {
		Client.field640 = 0;
		Client.field633 = 0;
		Decimator.method2496();

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

			if (var0) {
				var6 = var1.readBits(8);
				if (var6 > 127) {
					var6 -= 256;
				}
			} else {
				var6 = var1.readBits(5);
				if (var6 > 15) {
					var6 -= 32;
				}
			}

			var7 = Client.defaultRotations[var1.readBits(3)];
			if (var3) {
				var4.orientation = var4.rotation = var7;
			}

			var8 = var1.readBits(1);
			if (var8 == 1) {
				Client.field681[++Client.field633 - 1] = var2;
			}

			var9 = var1.readBits(1);
			var4.definition = PacketBufferNode.getNpcDefinition(var1.readBits(14));
			var4.field932 = var4.definition.size * 772175475;
			var4.field982 = var4.definition.rotation;
			if (var4.field982 == 0) {
				var4.rotation = 0;
			}

			var4.walkSequence = var4.definition.walkSequence;
			var4.walkBackSequence = var4.definition.walkBackSequence;
			var4.walkLeftSequence = var4.definition.walkLeftSequence;
			var4.walkRightSequence = var4.definition.walkRightSequence;
			var4.readySequence = var4.definition.readySequence;
			var4.turnLeftSequence = var4.definition.turnLeftSequence;
			var4.turnRightSequence = var4.definition.turnRightSequence;
			var4.method2038(class223.localPlayer.pathX[0] + var5, class223.localPlayer.pathY[0] + var6, var9 == 1);
		}

		var1.exportIndex();

		int var14;
		for (var2 = 0; var2 < Client.field633; ++var2) {
			var14 = Client.field681[var2];
			var4 = Client.npcs[var14];
			var5 = var1.readUnsignedByte();
			if ((var5 & 16) != 0) {
				var6 = var1.readUnsignedShort();
				if (var6 == 65535) {
					var6 = -1;
				}

				var7 = var1.method5496();
				if (var6 == var4.sequence && var6 != -1) {
					var8 = GrandExchangeOfferUnitPriceComparator.SequenceDefinition_get(var6).field3517;
					if (var8 == 1) {
						var4.sequenceFrame = 0;
						var4.sequenceFrameCycle = 0;
						var4.sequenceDelay = var7;
						var4.field965 = 0;
					}

					if (var8 == 2) {
						var4.field965 = 0;
					}
				} else if (var6 == -1 || var4.sequence == -1 || GrandExchangeOfferUnitPriceComparator.SequenceDefinition_get(var6).field3511 >= GrandExchangeOfferUnitPriceComparator.SequenceDefinition_get(var4.sequence).field3511) {
					var4.sequence = var6;
					var4.sequenceFrame = 0;
					var4.sequenceFrameCycle = 0;
					var4.sequenceDelay = var7;
					var4.field965 = 0;
					var4.field988 = var4.pathLength;
				}
			}

			if ((var5 & 1) != 0) {
				var6 = var1.method5456();
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

				var7 = var1.method5496();
				if (var7 > 0) {
					for (var8 = 0; var8 < var7; ++var8) {
						var9 = var1.readUShortSmart();
						var10 = var1.readUShortSmart();
						if (var10 != 32767) {
							var11 = var1.readUShortSmart();
							var12 = var1.method5456();
							int var13 = var10 > 0 ? var1.method5456() : var12;
							var4.addHealthBar(var9, Client.cycle, var10, var11, var12, var13);
						} else {
							var4.removeHealthBar(var9);
						}
					}
				}
			}

			if ((var5 & 2) != 0) {
				var4.targetIndex = var1.method5465();
				if (var4.targetIndex == 65535) {
					var4.targetIndex = -1;
				}
			}

			if ((var5 & 32) != 0) {
				var4.definition = PacketBufferNode.getNpcDefinition(var1.method5632());
				var4.field932 = var4.definition.size * 772175475;
				var4.field982 = var4.definition.rotation;
				var4.walkSequence = var4.definition.walkSequence;
				var4.walkBackSequence = var4.definition.walkBackSequence;
				var4.walkLeftSequence = var4.definition.walkLeftSequence;
				var4.walkRightSequence = var4.definition.walkRightSequence;
				var4.readySequence = var4.definition.readySequence;
				var4.turnLeftSequence = var4.definition.turnLeftSequence;
				var4.turnRightSequence = var4.definition.turnRightSequence;
			}

			if ((var5 & 4) != 0) {
				var6 = var1.method5465();
				var7 = var1.method5632();
				var8 = var4.x - (var6 - class223.baseX * 64 - class223.baseX * 64) * 64;
				var9 = var4.y * 682054857 - (var7 - class286.baseY * 64 - class286.baseY * 64) * 64;
				if (var8 != 0 || var9 != 0) {
					var4.field957 = (int)(Math.atan2((double)var8, (double)var9) * 325.949D) & 2047;
				}
			}

			if ((var5 & 8) != 0) {
				var4.spotAnimation = var1.method5632();
				var6 = var1.method5546();
				var4.heightOffset = var6 >> 16;
				var4.field969 = (var6 & 65535) + Client.cycle;
				var4.spotAnimationFrame = 0;
				var4.spotAnimationFrameCycle = 0;
				if (var4.field969 > Client.cycle) {
					var4.spotAnimationFrame = -1;
				}

				if (var4.spotAnimation == 65535) {
					var4.spotAnimation = -1;
				}
			}

			if ((var5 & 64) != 0) {
				var4.overheadText = var1.readStringCp1252NullTerminated();
				var4.overheadTextCyclesRemaining = 100;
			}
		}

		for (var2 = 0; var2 < Client.field640; ++var2) {
			var14 = Client.field758[var2];
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
}
