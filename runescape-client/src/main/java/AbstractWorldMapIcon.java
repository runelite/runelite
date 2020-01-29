import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aq")
@Implements("AbstractWorldMapIcon")
public abstract class AbstractWorldMapIcon {
	@ObfuscatedName("qk")
	@ObfuscatedGetter(
		intValue = -1430527955
	)
	static int field306;
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Lhj;"
	)
	@Export("coord2")
	public final Coord coord2;
	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "Lhj;"
	)
	@Export("coord1")
	public final Coord coord1;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -503139537
	)
	@Export("screenX")
	int screenX;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 1934442125
	)
	@Export("screenY")
	int screenY;

	@ObfuscatedSignature(
		signature = "(Lhj;Lhj;)V"
	)
	AbstractWorldMapIcon(Coord var1, Coord var2) {
		this.coord1 = var1;
		this.coord2 = var2;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "1499764486"
	)
	@Export("getElement")
	public abstract int getElement();

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(B)Laz;",
		garbageValue = "124"
	)
	@Export("getLabel")
	abstract WorldMapLabel getLabel();

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(S)I",
		garbageValue = "-26101"
	)
	@Export("getSubWidth")
	abstract int getSubWidth();

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "1"
	)
	@Export("getSubHeight")
	abstract int getSubHeight();

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(III)Z",
		garbageValue = "-671812733"
	)
	@Export("fitsScreen")
	boolean fitsScreen(int var1, int var2) {
		if (this.elementFitsScreen(var1, var2)) {
			return true;
		} else {
			return this.labelFitsScreen(var1, var2);
		}
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "-18"
	)
	@Export("hasValidElement")
	boolean hasValidElement() {
		return this.getElement() >= 0;
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(III)Z",
		garbageValue = "1514075887"
	)
	@Export("elementFitsScreen")
	boolean elementFitsScreen(int var1, int var2) {
		if (!this.hasValidElement()) {
			return false;
		} else {
			WorldMapElement var3 = PacketBufferNode.WorldMapElement_get(this.getElement());
			int var4 = this.getSubWidth();
			int var5 = this.getSubHeight();
			switch(var3.horizontalAlignment.value) {
			case 0:
				if (var1 <= this.screenX - var4 || var1 > this.screenX) {
					return false;
				}
				break;
			case 1:
				if (var1 >= this.screenX - var4 / 2 && var1 <= var4 / 2 + this.screenX) {
					break;
				}

				return false;
			case 2:
				if (var1 < this.screenX || var1 >= var4 + this.screenX) {
					return false;
				}
			}

			switch(var3.verticalAlignment.value) {
			case 0:
				if (var2 >= this.screenY - var5 / 2 && var2 <= var5 / 2 + this.screenY) {
					break;
				}

				return false;
			case 1:
				if (var2 >= this.screenY && var2 < var5 + this.screenY) {
					break;
				}

				return false;
			case 2:
				if (var2 <= this.screenY - var5 || var2 > this.screenY) {
					return false;
				}
			}

			return true;
		}
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(III)Z",
		garbageValue = "-543519402"
	)
	@Export("labelFitsScreen")
	boolean labelFitsScreen(int var1, int var2) {
		WorldMapLabel var3 = this.getLabel();
		if (var3 == null) {
			return false;
		} else if (var1 >= this.screenX - var3.width / 2 && var1 <= var3.width / 2 + this.screenX) {
			return var2 >= this.screenY && var2 <= var3.height + this.screenY;
		} else {
			return false;
		}
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(Lks;ILba;IB)V",
		garbageValue = "91"
	)
	static final void method613(PacketBuffer var0, int var1, Player var2, int var3) {
		byte var4 = -1;
		if ((var3 & 1024) != 0) {
			var2.field981 = var0.method5618();
			var2.field957 = var0.method5780();
			var2.field961 = var0.method5618();
			var2.field991 = var0.readByte();
			var2.field985 = var0.method5762() + Client.cycle;
			var2.field986 = var0.method5762() + Client.cycle;
			var2.field987 = var0.method5740();
			if (var2.field621) {
				var2.field981 += var2.tileX;
				var2.field957 += var2.tileY;
				var2.field961 += var2.tileX;
				var2.field991 += var2.tileY;
				var2.pathLength = 0;
			} else {
				var2.field981 += var2.pathX[0];
				var2.field957 += var2.pathY[0];
				var2.field961 += var2.pathX[0];
				var2.field991 += var2.pathY[0];
				var2.pathLength = 1;
			}

			var2.field998 = 0;
		}

		int var5;
		if ((var3 & 4096) != 0) {
			var2.spotAnimation = var0.readUnsignedShort();
			var5 = var0.readInt();
			var2.field980 = var5 >> 16;
			var2.field979 = (var5 & 65535) + Client.cycle;
			var2.spotAnimationFrame = 0;
			var2.spotAnimationFrameCycle = 0;
			if (var2.field979 > Client.cycle) {
				var2.spotAnimationFrame = -1;
			}

			if (var2.spotAnimation == 65535) {
				var2.spotAnimation = -1;
			}
		}

		int var6;
		int var8;
		int var9;
		int var12;
		if ((var3 & 64) != 0) {
			var5 = var0.readUnsignedByte();
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

			var6 = var0.method5605();
			if (var6 > 0) {
				for (var7 = 0; var7 < var6; ++var7) {
					var8 = var0.readUShortSmart();
					var9 = var0.readUShortSmart();
					if (var9 != 32767) {
						var10 = var0.readUShortSmart();
						var11 = var0.method5771();
						var12 = var9 > 0 ? var0.method5771() : var11;
						var2.addHealthBar(var8, Client.cycle, var9, var10, var11, var12);
					} else {
						var2.removeHealthBar(var8);
					}
				}
			}
		}

		if ((var3 & 2048) != 0) {
			Players.field1237[var1] = var0.method5618();
		}

		if ((var3 & 32) != 0) {
			var5 = var0.method5614();
			PlayerType var13 = (PlayerType)WorldMapSection0.findEnumerated(SecureRandomFuture.PlayerType_values(), var0.method5771());
			boolean var17 = var0.readUnsignedByte() == 1;
			var8 = var0.method5605();
			var9 = var0.offset;
			if (var2.username != null && var2.appearance != null) {
				boolean var18 = false;
				if (var13.isUser && KeyHandler.friendSystem.isIgnored(var2.username)) {
					var18 = true;
				}

				if (!var18 && Client.field759 == 0 && !var2.isHidden) {
					Players.field1248.offset = 0;
					var0.readBytes(Players.field1248.array, 0, var8);
					Players.field1248.offset = 0;
					String var14 = AbstractFont.escapeBrackets(class40.method735(WallDecoration.method3356(Players.field1248)));
					var2.overheadText = var14.trim();
					var2.overheadTextColor = var5 >> 8;
					var2.overheadTextEffect = var5 & 255;
					var2.overheadTextCyclesRemaining = 150;
					var2.isAutoChatting = var17;
					var2.field954 = var2 != class192.localPlayer && var13.isUser && "" != Client.field780 && var14.toLowerCase().indexOf(Client.field780) == -1;
					if (var13.isPrivileged) {
						var12 = var17 ? 91 : 1;
					} else {
						var12 = var17 ? 90 : 2;
					}

					if (var13.modIcon != -1) {
						ClientPreferences.addGameMessage(var12, Language.method3728(var13.modIcon) + var2.username.getName(), var14);
					} else {
						ClientPreferences.addGameMessage(var12, var2.username.getName(), var14);
					}
				}
			}

			var0.offset = var8 + var9;
		}

		if ((var3 & 1) != 0) {
			var5 = var0.method5740();
			if (var5 == 65535) {
				var5 = -1;
			}

			var6 = var0.method5605();
			InterfaceParent.performPlayerAnimation(var2, var5, var6);
		}

		if ((var3 & 512) != 0) {
			var4 = var0.method5609();
		}

		if ((var3 & 2) != 0) {
			var2.targetIndex = var0.readUnsignedShort();
			if (var2.targetIndex == 65535) {
				var2.targetIndex = -1;
			}
		}

		if ((var3 & 8) != 0) {
			var5 = var0.method5771();
			byte[] var19 = new byte[var5];
			Buffer var15 = new Buffer(var19);
			var0.readBytes(var19, 0, var5);
			Players.field1235[var1] = var15;
			var2.read(var15);
		}

		if ((var3 & 256) != 0) {
			for (var5 = 0; var5 < 3; ++var5) {
				var2.actions[var5] = var0.readStringCp1252NullTerminated();
			}
		}

		if ((var3 & 16) != 0) {
			var2.overheadText = var0.readStringCp1252NullTerminated();
			if (var2.overheadText.charAt(0) == '~') {
				var2.overheadText = var2.overheadText.substring(1);
				ClientPreferences.addGameMessage(2, var2.username.getName(), var2.overheadText);
			} else if (var2 == class192.localPlayer) {
				ClientPreferences.addGameMessage(2, var2.username.getName(), var2.overheadText);
			}

			var2.isAutoChatting = false;
			var2.overheadTextColor = 0;
			var2.overheadTextEffect = 0;
			var2.overheadTextCyclesRemaining = 150;
		}

		if ((var3 & 128) != 0) {
			var2.field967 = var0.readUnsignedShort();
			if (var2.pathLength == 0) {
				var2.orientation = var2.field967;
				var2.field967 = -1;
			}
		}

		if (var2.field621) {
			if (var4 == 127) {
				var2.resetPath(var2.tileX, var2.tileY);
			} else {
				byte var16;
				if (var4 != -1) {
					var16 = var4;
				} else {
					var16 = Players.field1237[var1];
				}

				var2.method1266(var2.tileX, var2.tileY, var16);
			}
		}

	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		signature = "(Lff;III)Ldw;",
		garbageValue = "1204269673"
	)
	public static final PcmPlayer method627(TaskHandler var0, int var1, int var2) {
		if (PcmPlayer.field1398 == 0) {
			throw new IllegalStateException();
		} else if (var1 >= 0 && var1 < 2) {
			if (var2 < 256) {
				var2 = 256;
			}

			try {
				PcmPlayer var3 = PcmPlayer.pcmPlayerProvider.player();
				var3.samples = new int[(PcmPlayer.PcmPlayer_stereo ? 2 : 1) * 256];
				var3.field1401 = var2;
				var3.init();
				var3.capacity = (var2 & -1024) + 1024;
				if (var3.capacity > 16384) {
					var3.capacity = 16384;
				}

				var3.open(var3.capacity);
				if (GrandExchangeEvent.field45 > 0 && UserComparator2.soundSystem == null) {
					UserComparator2.soundSystem = new SoundSystem();
					Frames.soundSystemExecutor = Executors.newScheduledThreadPool(1);
					Frames.soundSystemExecutor.scheduleAtFixedRate(UserComparator2.soundSystem, 0L, 10L, TimeUnit.MILLISECONDS);
				}

				if (UserComparator2.soundSystem != null) {
					if (UserComparator2.soundSystem.players[var1] != null) {
						throw new IllegalArgumentException();
					}

					UserComparator2.soundSystem.players[var1] = var3;
				}

				return var3;
			} catch (Throwable var4) {
				return new PcmPlayer();
			}
		} else {
			throw new IllegalArgumentException();
		}
	}

	@ObfuscatedName("fa")
	@ObfuscatedSignature(
		signature = "(IIII)V",
		garbageValue = "926175900"
	)
	@Export("queueSoundEffect")
	static void queueSoundEffect(int var0, int var1, int var2) {
		if (Client.soundEffectVolume != 0 && var1 != 0 && Client.soundEffectCount < 50) {
			Client.soundEffectIds[Client.soundEffectCount] = var0;
			Client.queuedSoundEffectLoops[Client.soundEffectCount] = var1;
			Client.queuedSoundEffectDelays[Client.soundEffectCount] = var2;
			Client.soundEffects[Client.soundEffectCount] = null;
			Client.soundLocations[Client.soundEffectCount] = 0;
			++Client.soundEffectCount;
		}

	}

	@ObfuscatedName("kt")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "4"
	)
	static void method628(int var0) {
		for (IntegerNode var1 = (IntegerNode)Client.widgetClickMasks.first(); var1 != null; var1 = (IntegerNode)Client.widgetClickMasks.next()) {
			if ((long)var0 == (var1.key >> 48 & 65535L)) {
				var1.remove();
			}
		}

	}
}
