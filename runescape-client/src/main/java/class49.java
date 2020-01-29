import javax.imageio.ImageIO;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ab")
public class class49 {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lii;"
	)
	@Export("HitSplatDefinition_archive")
	public static AbstractArchive HitSplatDefinition_archive;

	static {
		ImageIO.setUseCache(false);
	}

	@ObfuscatedName("fd")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "-624446357"
	)
	@Export("playSoundJingle")
	static void playSoundJingle(int var0, int var1) {
		if (Client.musicVolume != 0 && var0 != -1) {
			Archive var2 = GrandExchangeOffer.archive11;
			int var3 = Client.musicVolume;
			class197.field2414 = 1;
			UserComparator5.musicTrackArchive = var2;
			class197.musicTrackGroupId = var0;
			class83.musicTrackFileId = 0;
			AttackOption.musicTrackVolume = var3;
			KeyHandler.musicTrackBoolean = false;
			class197.field2412 = 10000;
			Client.field881 = true;
		}

	}

	@ObfuscatedName("hk")
	@ObfuscatedSignature(
		signature = "(Lks;I)V",
		garbageValue = "-815942128"
	)
	static final void method866(PacketBuffer var0) {
		for (int var1 = 0; var1 < Client.field690; ++var1) {
			int var2 = Client.field867[var1];
			NPC var3 = Client.npcs[var2];
			int var4 = var0.readUnsignedByte();
			if ((var4 & 4) != 0) {
				var3.targetIndex = var0.readUnsignedShort();
				if (var3.targetIndex == 65535) {
					var3.targetIndex = -1;
				}
			}

			int var5;
			if ((var4 & 2) != 0) {
				var3.spotAnimation = var0.method5762();
				var5 = var0.method5626();
				var3.field980 = var5 >> 16;
				var3.field979 = (var5 & 65535) + Client.cycle;
				var3.spotAnimationFrame = 0;
				var3.spotAnimationFrameCycle = 0;
				if (var3.field979 > Client.cycle) {
					var3.spotAnimationFrame = -1;
				}

				if (var3.spotAnimation == 65535) {
					var3.spotAnimation = -1;
				}
			}

			if ((var4 & 32) != 0) {
				var3.overheadText = var0.readStringCp1252NullTerminated();
				var3.overheadTextCyclesRemaining = 100;
			}

			int var6;
			int var7;
			int var8;
			if ((var4 & 1) != 0) {
				var5 = var0.method5606();
				int var9;
				int var10;
				int var11;
				if (var5 > 0) {
					for (var6 = 0; var6 < var5; ++var6) {
						var8 = -1;
						var9 = -1;
						var10 = -1;
						var7 = var0.readUShortSmart();
						if (var7 == 32767) {
							var7 = var0.readUShortSmart();
							var9 = var0.readUShortSmart();
							var8 = var0.readUShortSmart();
							var10 = var0.readUShortSmart();
						} else if (var7 != 32766) {
							var9 = var0.readUShortSmart();
						} else {
							var7 = -1;
						}

						var11 = var0.readUShortSmart();
						var3.addHitSplat(var7, var9, var8, var10, Client.cycle, var11);
					}
				}

				var6 = var0.readUnsignedByte();
				if (var6 > 0) {
					for (var7 = 0; var7 < var6; ++var7) {
						var8 = var0.readUShortSmart();
						var9 = var0.readUShortSmart();
						if (var9 != 32767) {
							var10 = var0.readUShortSmart();
							var11 = var0.readUnsignedByte();
							int var12 = var9 > 0 ? var0.method5606() : var11;
							var3.addHealthBar(var8, Client.cycle, var9, var10, var11, var12);
						} else {
							var3.removeHealthBar(var8);
						}
					}
				}
			}

			if ((var4 & 64) != 0) {
				var3.field981 = var0.method5618();
				var3.field957 = var0.method5618();
				var3.field961 = var0.method5618();
				var3.field991 = var0.readByte();
				var3.field985 = var0.method5614() + Client.cycle;
				var3.field986 = var0.method5614() + Client.cycle;
				var3.field987 = var0.method5762();
				var3.pathLength = 1;
				var3.field998 = 0;
				var3.field981 += var3.pathX[0];
				var3.field957 += var3.pathY[0];
				var3.field961 += var3.pathX[0];
				var3.field991 += var3.pathY[0];
			}

			if ((var4 & 8) != 0) {
				var5 = var0.method5614();
				if (var5 == 65535) {
					var5 = -1;
				}

				var6 = var0.readUnsignedByte();
				if (var5 == var3.sequence && var5 != -1) {
					var7 = GraphicsDefaults.SequenceDefinition_get(var5).field3516;
					if (var7 == 1) {
						var3.sequenceFrame = 0;
						var3.sequenceFrameCycle = 0;
						var3.sequenceDelay = var6;
						var3.field983 = 0;
					}

					if (var7 == 2) {
						var3.field983 = 0;
					}
				} else if (var5 == -1 || var3.sequence == -1 || GraphicsDefaults.SequenceDefinition_get(var5).field3508 >= GraphicsDefaults.SequenceDefinition_get(var3.sequence).field3508) {
					var3.sequence = var5;
					var3.sequenceFrame = 0;
					var3.sequenceFrameCycle = 0;
					var3.sequenceDelay = var6;
					var3.field983 = 0;
					var3.field998 = var3.pathLength;
				}
			}

			if ((var4 & 16) != 0) {
				var3.definition = NetCache.getNpcDefinition(var0.method5762());
				var3.field942 = var3.definition.size * 64;
				var3.field975 = var3.definition.rotation;
				var3.walkSequence = var3.definition.walkSequence;
				var3.walkBackSequence = var3.definition.walkBackSequence;
				var3.walkLeftSequence = var3.definition.walkLeftSequence;
				var3.walkRightSequence = var3.definition.walkRightSequence;
				var3.readySequence = var3.definition.readySequence;
				var3.turnLeftSequence = var3.definition.turnLeftSequence;
				var3.turnRightSequence = var3.definition.turnRightSequence;
			}

			if ((var4 & 128) != 0) {
				var5 = var0.method5762();
				var6 = var0.method5614();
				var7 = var3.x - (var5 - Messages.baseX * 64 - Messages.baseX * 64) * 64;
				var8 = var3.y - (var6 - Language.baseY * 64 - Language.baseY * 64) * 64;
				if (var7 != 0 || var8 != 0) {
					var3.field967 = (int)(Math.atan2((double)var7, (double)var8) * 325.949D) & 2047;
				}
			}
		}

	}
}
