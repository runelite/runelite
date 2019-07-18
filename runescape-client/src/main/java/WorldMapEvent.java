import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aq")
@Implements("WorldMapEvent")
public class WorldMapEvent {
	@ObfuscatedName("lr")
	@ObfuscatedGetter(
		intValue = 272938977
	)
	static int field359;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 303553599
	)
	@Export("mapElement")
	public int mapElement;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lhv;"
	)
	@Export("coord1")
	public Coord coord1;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lhv;"
	)
	@Export("coord2")
	public Coord coord2;

	@ObfuscatedSignature(
		signature = "(ILhv;Lhv;)V"
	)
	public WorldMapEvent(int var1, Coord var2, Coord var3) {
		this.mapElement = var1;
		this.coord1 = var2;
		this.coord2 = var3;
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(Lkx;ILbd;II)V",
		garbageValue = "158563963"
	)
	static final void method736(PacketBuffer var0, int var1, Player var2, int var3) {
		byte var4 = -1;
		int var5;
		int var6;
		int var8;
		int var9;
		int var12;
		if ((var3 & 64) != 0) {
			var5 = var0.method5722();
			int var7;
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
					var2.addHitSplat(var7, var9, var8, var10, Client.cycle, var11);
				}
			}

			var6 = var0.readUnsignedByteNegate();
			if (var6 > 0) {
				for (var7 = 0; var7 < var6; ++var7) {
					var8 = var0.readUShortSmart();
					var9 = var0.readUShortSmart();
					if (var9 != 32767) {
						var10 = var0.readUShortSmart();
						var11 = var0.method5722();
						var12 = var9 > 0 ? var0.readUnsignedByte() : var11;
						var2.addHealthBar(var8, Client.cycle, var9, var10, var11, var12);
					} else {
						var2.removeHealthBar(var8);
					}
				}
			}
		}

		if ((var3 & 512) != 0) {
			var2.spotAnimation = var0.method5534();
			var5 = var0.method5542();
			var2.heightOffset = var5 >> 16;
			var2.field989 = (var5 & 65535) + Client.cycle;
			var2.spotAnimationFrame = 0;
			var2.spotAnimationFrameCycle = 0;
			if (var2.field989 > Client.cycle) {
				var2.spotAnimationFrame = -1;
			}

			if (var2.spotAnimation == 65535) {
				var2.spotAnimation = -1;
			}
		}

		if ((var3 & 4096) != 0) {
			var4 = var0.method5694();
		}

		if ((var3 & 1024) != 0) {
			var2.field991 = var0.method5528();
			var2.field993 = var0.method5694();
			var2.field992 = var0.method5694();
			var2.field983 = var0.method5528();
			var2.field995 = var0.method5518() + Client.cycle;
			var2.field996 = var0.method5532() + Client.cycle;
			var2.field997 = var0.readUnsignedShort();
			if (var2.field638) {
				var2.field991 += var2.tileX;
				var2.field993 += var2.tileY;
				var2.field992 += var2.tileX;
				var2.field983 += var2.tileY;
				var2.pathLength = 0;
			} else {
				var2.field991 += var2.pathX[0];
				var2.field993 += var2.pathY[0];
				var2.field992 += var2.pathX[0];
				var2.field983 += var2.pathY[0];
				var2.pathLength = 1;
			}

			var2.field1008 = 0;
		}

		if ((var3 & 32) != 0) {
			var2.overheadText = var0.readStringCp1252NullTerminated();
			if (var2.overheadText.charAt(0) == '~') {
				var2.overheadText = var2.overheadText.substring(1);
				ScriptEvent.addGameMessage(2, var2.username.getName(), var2.overheadText);
			} else if (var2 == Client.localPlayer) {
				ScriptEvent.addGameMessage(2, var2.username.getName(), var2.overheadText);
			}

			var2.isAutoChatting = false;
			var2.overheadTextColor = 0;
			var2.overheadTextEffect = 0;
			var2.overheadTextCyclesRemaining = 150;
		}

		if ((var3 & 4) != 0) {
			var2.field976 = var0.method5532();
			if (var2.pathLength == 0) {
				var2.orientation = var2.field976;
				var2.field976 = -1;
			}
		}

		if ((var3 & 1) != 0) {
			var5 = var0.method5525();
			byte[] var13 = new byte[var5];
			Buffer var14 = new Buffer(var13);
			var0.method5544(var13, 0, var5);
			Players.field1254[var1] = var14;
			var2.read(var14);
		}

		if ((var3 & 2) != 0) {
			var2.targetIndex = var0.method5518();
			if (var2.targetIndex == 65535) {
				var2.targetIndex = -1;
			}
		}

		if ((var3 & 2048) != 0) {
			Players.field1250[var1] = var0.method5694();
		}

		if ((var3 & 16) != 0) {
			var5 = var0.method5518();
			PlayerType var19 = (PlayerType)SoundSystem.findEnumerated(UserComparator5.PlayerType_values(), var0.readUnsignedByte());
			boolean var17 = var0.readUnsignedByteNegate() == 1;
			var8 = var0.readUnsignedByte();
			var9 = var0.offset;
			if (var2.username != null && var2.appearance != null) {
				boolean var18 = false;
				if (var19.isUser && ArchiveLoader.friendSystem.isIgnored(var2.username)) {
					var18 = true;
				}

				if (!var18 && Client.field767 == 0 && !var2.isHidden) {
					Players.field1264.offset = 0;
					var0.readBytes(Players.field1264.array, 0, var8);
					Players.field1264.offset = 0;
					String var15 = AbstractFont.escapeBrackets(class1.method17(DefaultsGroup.method5898(Players.field1264)));
					var2.overheadText = var15.trim();
					var2.overheadTextColor = var5 >> 8;
					var2.overheadTextEffect = var5 & 255;
					var2.overheadTextCyclesRemaining = 150;
					var2.isAutoChatting = var17;
					var2.field998 = var2 != Client.localPlayer && var19.isUser && "" != Client.field762 && var15.toLowerCase().indexOf(Client.field762) == -1;
					if (var19.isPrivileged) {
						var12 = var17 ? 91 : 1;
					} else {
						var12 = var17 ? 90 : 2;
					}

					if (var19.modIcon != -1) {
						ScriptEvent.addGameMessage(var12, WorldMapSection1.getModIconString(var19.modIcon) + var2.username.getName(), var15);
					} else {
						ScriptEvent.addGameMessage(var12, var2.username.getName(), var15);
					}
				}
			}

			var0.offset = var9 + var8;
		}

		if ((var3 & 256) != 0) {
			for (var5 = 0; var5 < 3; ++var5) {
				var2.actions[var5] = var0.readStringCp1252NullTerminated();
			}
		}

		if ((var3 & 128) != 0) {
			var5 = var0.readUnsignedShort();
			if (var5 == 65535) {
				var5 = -1;
			}

			var6 = var0.readUnsignedByte();
			MouseRecorder.performPlayerAnimation(var2, var5, var6);
		}

		if (var2.field638) {
			if (var4 == 127) {
				var2.resetPath(var2.tileX, var2.tileY);
			} else {
				byte var16;
				if (var4 != -1) {
					var16 = var4;
				} else {
					var16 = Players.field1250[var1];
				}

				var2.method1189(var2.tileX, var2.tileY, var16);
			}
		}

	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1659690111"
	)
	static final void method737() {
		Object var10000 = null;
		String var0 = "You can't add yourself to your own ignore list";
		ScriptEvent.addGameMessage(30, "", var0);
	}
}
