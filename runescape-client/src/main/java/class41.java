import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ak")
public class class41 {
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		signature = "Lld;"
	)
	static Bounds field315;
	@ObfuscatedName("df")
	@ObfuscatedSignature(
		signature = "Lih;"
	)
	@Export("archive12")
	static Archive archive12;
	@ObfuscatedName("jd")
	@ObfuscatedSignature(
		signature = "Ldi;"
	)
	@Export("textureProvider")
	static TextureProvider textureProvider;

	@ObfuscatedName("gx")
	@ObfuscatedSignature(
		signature = "(Lcw;II)V",
		garbageValue = "1452661344"
	)
	@Export("updateActorSequence")
	static final void updateActorSequence(Actor var0, int var1) {
		int var2;
		int var3;
		int var4;
		if (var0.field1019 >= Client.cycle) {
			var2 = Math.max(1, var0.field1019 - Client.cycle);
			var3 = var0.field976 * 64 + var0.field990 * 128;
			var4 = var0.field976 * 64 + var0.field1017 * 128;
			var0.x += (var3 - var0.x) / var2;
			var0.y += (var4 - var0.y) / var2;
			var0.field1031 = 0;
			var0.orientation = var0.field1021;
		} else if (var0.field1020 >= Client.cycle) {
			if (var0.field1020 == Client.cycle || var0.sequence == -1 || var0.sequenceDelay != 0 || var0.sequenceFrameCycle + 1 > SpotAnimationDefinition.SequenceDefinition_get(var0.sequence).frameLengths[var0.sequenceFrame]) {
				var2 = var0.field1020 - var0.field1019;
				var3 = Client.cycle - var0.field1019;
				var4 = var0.field976 * 64 + var0.field990 * 128;
				int var5 = var0.field976 * 64 + var0.field1017 * 128;
				int var6 = var0.field976 * 64 + var0.field972 * 128;
				int var7 = var0.field976 * 64 + var0.field1018 * 128;
				var0.x = (var3 * var6 + var4 * (var2 - var3)) / var2;
				var0.y = (var7 * var3 + var5 * (var2 - var3)) / var2;
			}

			var0.field1031 = 0;
			var0.orientation = var0.field1021;
			var0.rotation = var0.orientation;
		} else {
			ClientPacket.method3686(var0);
		}

		if (var0.x < 128 || var0.y < 128 || var0.x >= 13184 || var0.y >= 13184) {
			var0.sequence = -1;
			var0.spotAnimation = -1;
			var0.field1019 = 0;
			var0.field1020 = 0;
			var0.x = var0.field976 * 64 + var0.pathX[0] * 128;
			var0.y = var0.field976 * 64 + var0.pathY[0] * 128;
			var0.method1842();
		}

		if (ByteArrayPool.localPlayer == var0 && (var0.x < 1536 || var0.y < 1536 || var0.x >= 11776 || var0.y >= 11776)) {
			var0.sequence = -1;
			var0.spotAnimation = -1;
			var0.field1019 = 0;
			var0.field1020 = 0;
			var0.x = var0.pathX[0] * 128 + var0.field976 * 64;
			var0.y = var0.pathY[0] * 128 + var0.field976 * 64;
			var0.method1842();
		}

		if (var0.field1026 != 0) {
			if (var0.targetIndex != -1) {
				Object var8 = null;
				if (var0.targetIndex < 32768) {
					var8 = Client.npcs[var0.targetIndex];
				} else if (var0.targetIndex >= 32768) {
					var8 = Client.players[var0.targetIndex - 32768];
				}

				if (var8 != null) {
					var3 = var0.x - ((Actor)var8).x;
					var4 = var0.y - ((Actor)var8).y;
					if (var3 != 0 || var4 != 0) {
						var0.orientation = (int)(Math.atan2((double)var3, (double)var4) * 325.949D) & 2047;
					}
				} else if (var0.false0) {
					var0.targetIndex = -1;
					var0.false0 = false;
				}
			}

			if (var0.field1015 != -1 && (var0.pathLength == 0 || var0.field1031 > 0)) {
				var0.orientation = var0.field1015;
				var0.field1015 = -1;
			}

			var2 = var0.orientation - var0.rotation & 2047;
			if (var2 == 0 && var0.false0) {
				var0.targetIndex = -1;
				var0.false0 = false;
			}

			if (var2 != 0) {
				++var0.field1025;
				boolean var10;
				if (var2 > 1024) {
					var0.rotation -= var0.field1026;
					var10 = true;
					if (var2 < var0.field1026 || var2 > 2048 - var0.field1026) {
						var0.rotation = var0.orientation;
						var10 = false;
					}

					if (var0.movementSequence == var0.readySequence && (var0.field1025 > 25 || var10)) {
						if (var0.turnLeftSequence != -1) {
							var0.movementSequence = var0.turnLeftSequence;
						} else {
							var0.movementSequence = var0.walkSequence;
						}
					}
				} else {
					var0.rotation += var0.field1026;
					var10 = true;
					if (var2 < var0.field1026 || var2 > 2048 - var0.field1026) {
						var0.rotation = var0.orientation;
						var10 = false;
					}

					if (var0.movementSequence == var0.readySequence && (var0.field1025 > 25 || var10)) {
						if (var0.turnRightSequence != -1) {
							var0.movementSequence = var0.turnRightSequence;
						} else {
							var0.movementSequence = var0.walkSequence;
						}
					}
				}

				var0.rotation &= 2047;
			} else {
				var0.field1025 = 0;
			}
		}

		var0.isWalking = false;
		SequenceDefinition var11;
		if (var0.movementSequence != -1) {
			var11 = SpotAnimationDefinition.SequenceDefinition_get(var0.movementSequence);
			if (var11 != null && var11.frameIds != null) {
				++var0.movementFrameCycle;
				if (var0.movementFrame < var11.frameIds.length && var0.movementFrameCycle > var11.frameLengths[var0.movementFrame]) {
					var0.movementFrameCycle = 1;
					++var0.movementFrame;
					PacketWriter.addSequenceSoundEffect(var11, var0.movementFrame, var0.x, var0.y);
				}

				if (var0.movementFrame >= var11.frameIds.length) {
					var0.movementFrameCycle = 0;
					var0.movementFrame = 0;
					PacketWriter.addSequenceSoundEffect(var11, var0.movementFrame, var0.x, var0.y);
				}
			} else {
				var0.movementSequence = -1;
			}
		}

		if (var0.spotAnimation != -1 && Client.cycle >= var0.field1013) {
			if (var0.spotAnimationFrame < 0) {
				var0.spotAnimationFrame = 0;
			}

			var2 = MouseHandler.SpotAnimationDefinition_get(var0.spotAnimation).sequence;
			if (var2 != -1) {
				SequenceDefinition var9 = SpotAnimationDefinition.SequenceDefinition_get(var2);
				if (var9 != null && var9.frameIds != null) {
					++var0.spotAnimationFrameCycle;
					if (var0.spotAnimationFrame < var9.frameIds.length && var0.spotAnimationFrameCycle > var9.frameLengths[var0.spotAnimationFrame]) {
						var0.spotAnimationFrameCycle = 1;
						++var0.spotAnimationFrame;
						PacketWriter.addSequenceSoundEffect(var9, var0.spotAnimationFrame, var0.x, var0.y);
					}

					if (var0.spotAnimationFrame >= var9.frameIds.length && (var0.spotAnimationFrame < 0 || var0.spotAnimationFrame >= var9.frameIds.length)) {
						var0.spotAnimation = -1;
					}
				} else {
					var0.spotAnimation = -1;
				}
			} else {
				var0.spotAnimation = -1;
			}
		}

		if (var0.sequence != -1 && var0.sequenceDelay <= 1) {
			var11 = SpotAnimationDefinition.SequenceDefinition_get(var0.sequence);
			if (var11.field3520 == 1 && var0.field1032 > 0 && var0.field1019 <= Client.cycle && var0.field1020 < Client.cycle) {
				var0.sequenceDelay = 1;
				return;
			}
		}

		if (var0.sequence != -1 && var0.sequenceDelay == 0) {
			var11 = SpotAnimationDefinition.SequenceDefinition_get(var0.sequence);
			if (var11 != null && var11.frameIds != null) {
				++var0.sequenceFrameCycle;
				if (var0.sequenceFrame < var11.frameIds.length && var0.sequenceFrameCycle > var11.frameLengths[var0.sequenceFrame]) {
					var0.sequenceFrameCycle = 1;
					++var0.sequenceFrame;
					PacketWriter.addSequenceSoundEffect(var11, var0.sequenceFrame, var0.x, var0.y);
				}

				if (var0.sequenceFrame >= var11.frameIds.length) {
					var0.sequenceFrame -= var11.frameCount;
					++var0.field1011;
					if (var0.field1011 >= var11.field3522) {
						var0.sequence = -1;
					} else if (var0.sequenceFrame >= 0 && var0.sequenceFrame < var11.frameIds.length) {
						PacketWriter.addSequenceSoundEffect(var11, var0.sequenceFrame, var0.x, var0.y);
					} else {
						var0.sequence = -1;
					}
				}

				var0.isWalking = var11.field3518;
			} else {
				var0.sequence = -1;
			}
		}

		if (var0.sequenceDelay > 0) {
			--var0.sequenceDelay;
		}

	}

	@ObfuscatedName("jb")
	@ObfuscatedSignature(
		signature = "(Lbm;ZI)V",
		garbageValue = "-750063376"
	)
	@Export("closeInterface")
	static final void closeInterface(InterfaceParent var0, boolean var1) {
		int var2 = var0.group;
		int var3 = (int)var0.key;
		var0.remove();
		if (var1) {
			EnumDefinition.method4614(var2);
		}

		LoginScreenAnimation.method1938(var2);
		Widget var4 = MusicPatchNode.getWidget(var3);
		if (var4 != null) {
			ItemContainer.invalidateWidget(var4);
		}

		ChatChannel.method2354();
		if (Client.rootInterface != -1) {
			class198.runIntfCloseListeners(Client.rootInterface, 1);
		}

	}

	@ObfuscatedName("kh")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;ZI)Ljava/lang/String;",
		garbageValue = "961112618"
	)
	static String method654(String var0, boolean var1) {
		String var2 = var1 ? "https://" : "http://";
		if (Client.gameBuild == 1) {
			var0 = var0 + "-wtrc";
		} else if (Client.gameBuild == 2) {
			var0 = var0 + "-wtqa";
		} else if (Client.gameBuild == 3) {
			var0 = var0 + "-wtwip";
		} else if (Client.gameBuild == 5) {
			var0 = var0 + "-wti";
		} else if (Client.gameBuild == 4) {
			var0 = "local";
		}

		String var3 = "";
		if (WorldMapData_0.field137 != null) {
			var3 = "/p=" + WorldMapData_0.field137;
		}

		String var4 = "runescape.com";
		return var2 + var0 + "." + var4 + "/l=" + IgnoreList.clientLanguage + "/a=" + KitDefinition.field3271 + var3 + "/";
	}
}
