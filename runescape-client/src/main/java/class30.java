import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("az")
public class class30 {
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "Laz;"
	)
	static final class30 field251;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Laz;"
	)
	static final class30 field250;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -2137893013
	)
	@Export("canvasHeight")
	public static int canvasHeight;
	@ObfuscatedName("fj")
	@ObfuscatedSignature(
		signature = "Lkb;"
	)
	@Export("fontPlain11")
	static Font fontPlain11;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -1891025063
	)
	@Export("value")
	final int value;

	static {
		field251 = new class30(0);
		field250 = new class30(1);
	}

	class30(int var1) {
		this.value = var1;
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(IIII)Lcr;",
		garbageValue = "-1455468639"
	)
	@Export("getWorldMapScript")
	static Script getWorldMapScript(int var0, int var1, int var2) {
		int var3 = ReflectionCheck.method2212(var1, var0);
		Script var5 = (Script)Script.Script_cached.get((long)(var3 << 16));
		Script var4;
		if (var5 != null) {
			var4 = var5;
		} else {
			String var6 = String.valueOf(var3);
			int var7 = GameShell.archive12.getGroupId(var6);
			if (var7 == -1) {
				var4 = null;
			} else {
				label55: {
					byte[] var8 = GameShell.archive12.takeFileFlat(var7);
					if (var8 != null) {
						if (var8.length <= 1) {
							var4 = null;
							break label55;
						}

						var5 = DesktopPlatformInfoProvider.newScript(var8);
						if (var5 != null) {
							Script.Script_cached.put(var5, (long)(var3 << 16));
							var4 = var5;
							break label55;
						}
					}

					var4 = null;
				}
			}
		}

		if (var4 != null) {
			return var4;
		} else {
			int var12 = (var2 + 40000 << 8) + var0;
			Script var14 = (Script)Script.Script_cached.get((long)(var12 << 16));
			Script var13;
			if (var14 != null) {
				var13 = var14;
			} else {
				String var9 = String.valueOf(var12);
				int var10 = GameShell.archive12.getGroupId(var9);
				if (var10 == -1) {
					var13 = null;
				} else {
					byte[] var11 = GameShell.archive12.takeFileFlat(var10);
					if (var11 != null) {
						if (var11.length <= 1) {
							var13 = null;
							return var13 != null ? var13 : null;
						}

						var14 = DesktopPlatformInfoProvider.newScript(var11);
						if (var14 != null) {
							Script.Script_cached.put(var14, (long)(var12 << 16));
							var13 = var14;
							return var13 != null ? var13 : null;
						}
					}

					var13 = null;
				}
			}

			return var13 != null ? var13 : null;
		}
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(Lkx;II)V",
		garbageValue = "1722384398"
	)
	@Export("updatePlayers")
	static final void updatePlayers(PacketBuffer var0, int var1) {
		int var2 = var0.offset;
		Players.Players_pendingUpdateCount = 0;
		class189.method3594(var0);

		for (int var3 = 0; var3 < Players.Players_pendingUpdateCount; ++var3) {
			int var4 = Players.Players_pendingUpdateIndices[var3];
			Player var5 = Client.players[var4];
			int var6 = var0.readUnsignedByte();
			if ((var6 & 8) != 0) {
				var6 += var0.readUnsignedByte() << 8;
			}

			byte var7 = -1;
			int var8;
			int var9;
			int var11;
			int var12;
			int var15;
			if ((var6 & 64) != 0) {
				var8 = var0.method5436();
				int var10;
				int var13;
				int var14;
				if (var8 > 0) {
					for (var9 = 0; var9 < var8; ++var9) {
						var11 = -1;
						var12 = -1;
						var13 = -1;
						var10 = var0.readUShortSmart();
						if (var10 == 32767) {
							var10 = var0.readUShortSmart();
							var12 = var0.readUShortSmart();
							var11 = var0.readUShortSmart();
							var13 = var0.readUShortSmart();
						} else if (var10 != 32766) {
							var12 = var0.readUShortSmart();
						} else {
							var10 = -1;
						}

						var14 = var0.readUShortSmart();
						var5.addHitSplat(var10, var12, var11, var13, Client.cycle, var14);
					}
				}

				var9 = var0.readUnsignedByteNegate();
				if (var9 > 0) {
					for (var10 = 0; var10 < var9; ++var10) {
						var11 = var0.readUShortSmart();
						var12 = var0.readUShortSmart();
						if (var12 != 32767) {
							var13 = var0.readUShortSmart();
							var14 = var0.method5436();
							var15 = var12 > 0 ? var0.readUnsignedByte() : var14;
							var5.addHealthBar(var11, Client.cycle, var12, var13, var14, var15);
						} else {
							var5.removeHealthBar(var11);
						}
					}
				}
			}

			if ((var6 & 512) != 0) {
				var5.spotAnimation = var0.method5447();
				var8 = var0.method5455();
				var5.heightOffset = var8 >> 16;
				var5.field958 = (var8 & 65535) + Client.cycle;
				var5.spotAnimationFrame = 0;
				var5.spotAnimationFrameCycle = 0;
				if (var5.field958 > Client.cycle) {
					var5.spotAnimationFrame = -1;
				}

				if (var5.spotAnimation == 65535) {
					var5.spotAnimation = -1;
				}
			}

			if ((var6 & 4096) != 0) {
				var7 = var0.method5616();
			}

			if ((var6 & 1024) != 0) {
				var5.field960 = var0.method5441();
				var5.field954 = var0.method5616();
				var5.field961 = var0.method5616();
				var5.field963 = var0.method5441();
				var5.field941 = var0.method5446() + Client.cycle;
				var5.field965 = var0.method5445() + Client.cycle;
				var5.field966 = var0.readUnsignedShort();
				if (var5.field614) {
					var5.field960 += var5.tileX;
					var5.field954 += var5.tileY;
					var5.field961 += var5.tileX;
					var5.field963 += var5.tileY;
					var5.pathLength = 0;
				} else {
					var5.field960 += var5.pathX[0];
					var5.field954 += var5.pathY[0];
					var5.field961 += var5.pathX[0];
					var5.field963 += var5.pathY[0];
					var5.pathLength = 1;
				}

				var5.field947 = 0;
			}

			if ((var6 & 32) != 0) {
				var5.overheadText = var0.readStringCp1252NullTerminated();
				if (var5.overheadText.charAt(0) == '~') {
					var5.overheadText = var5.overheadText.substring(1);
					DirectByteArrayCopier.addGameMessage(2, var5.username.getName(), var5.overheadText);
				} else if (var5 == WorldMapIcon_1.localPlayer) {
					DirectByteArrayCopier.addGameMessage(2, var5.username.getName(), var5.overheadText);
				}

				var5.isAutoChatting = false;
				var5.overheadTextColor = 0;
				var5.overheadTextEffect = 0;
				var5.overheadTextCyclesRemaining = 150;
			}

			if ((var6 & 4) != 0) {
				var5.field946 = var0.method5445();
				if (var5.pathLength == 0) {
					var5.orientation = var5.field946;
					var5.field946 = -1;
				}
			}

			if ((var6 & 1) != 0) {
				var8 = var0.method5438();
				byte[] var16 = new byte[var8];
				Buffer var17 = new Buffer(var16);
				var0.method5457(var16, 0, var8);
				Players.field1219[var4] = var17;
				var5.read(var17);
			}

			if ((var6 & 2) != 0) {
				var5.targetIndex = var0.method5446();
				if (var5.targetIndex == 65535) {
					var5.targetIndex = -1;
				}
			}

			if ((var6 & 2048) != 0) {
				Players.field1230[var4] = var0.method5616();
			}

			if ((var6 & 16) != 0) {
				var8 = var0.method5446();
				PlayerType var22 = (PlayerType)FriendSystem.findEnumerated(class191.PlayerType_values(), var0.readUnsignedByte());
				boolean var20 = var0.readUnsignedByteNegate() == 1;
				var11 = var0.readUnsignedByte();
				var12 = var0.offset;
				if (var5.username != null && var5.appearance != null) {
					boolean var21 = false;
					if (var22.isUser && class32.friendSystem.isIgnored(var5.username)) {
						var21 = true;
					}

					if (!var21 && Client.field737 == 0 && !var5.isHidden) {
						Players.field1233.offset = 0;
						var0.readBytes(Players.field1233.array, 0, var11);
						Players.field1233.offset = 0;
						String var18 = AbstractFont.escapeBrackets(class189.method3596(class51.method845(Players.field1233)));
						var5.overheadText = var18.trim();
						var5.overheadTextColor = var8 >> 8;
						var5.overheadTextEffect = var8 & 255;
						var5.overheadTextCyclesRemaining = 150;
						var5.isAutoChatting = var20;
						var5.field926 = var5 != WorldMapIcon_1.localPlayer && var22.isUser && "" != Client.field668 && var18.toLowerCase().indexOf(Client.field668) == -1;
						if (var22.isPrivileged) {
							var15 = var20 ? 91 : 1;
						} else {
							var15 = var20 ? 90 : 2;
						}

						if (var22.modIcon * 714577229 != -1) {
							DirectByteArrayCopier.addGameMessage(var15, AbstractWorldMapData.method278(var22.modIcon * 714577229) + var5.username.getName(), var18);
						} else {
							DirectByteArrayCopier.addGameMessage(var15, var5.username.getName(), var18);
						}
					}
				}

				var0.offset = var12 + var11;
			}

			if ((var6 & 256) != 0) {
				for (var8 = 0; var8 < 3; ++var8) {
					var5.actions[var8] = var0.readStringCp1252NullTerminated();
				}
			}

			if ((var6 & 128) != 0) {
				var8 = var0.readUnsignedShort();
				if (var8 == 65535) {
					var8 = -1;
				}

				var9 = var0.readUnsignedByte();
				FriendsList.performPlayerAnimation(var5, var8, var9);
			}

			if (var5.field614) {
				if (var7 == 127) {
					var5.resetPath(var5.tileX, var5.tileY);
				} else {
					byte var19;
					if (var7 != -1) {
						var19 = var7;
					} else {
						var19 = Players.field1230[var4];
					}

					var5.method1190(var5.tileX, var5.tileY, var19);
				}
			}
		}

		if (var0.offset - var2 != var1) {
			throw new RuntimeException(var0.offset - var2 + " " + var1);
		}
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(Lky;IIIIIII)V",
		garbageValue = "-260324496"
	)
	@Export("loadTerrain")
	static final void loadTerrain(Buffer var0, int var1, int var2, int var3, int var4, int var5, int var6) {
		int var7;
		if (var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
			Tiles.Tiles_renderFlags[var1][var2][var3] = 0;

			while (true) {
				var7 = var0.readUnsignedByte();
				if (var7 == 0) {
					if (var1 == 0) {
						Tiles.Tiles_heights[0][var2][var3] = -GrandExchangeOfferTotalQuantityComparator.method101(var2 + 932731 + var4, 556238 + var3 + var5) * 8;
					} else {
						Tiles.Tiles_heights[var1][var2][var3] = Tiles.Tiles_heights[var1 - 1][var2][var3] - 240;
					}
					break;
				}

				if (var7 == 1) {
					int var8 = var0.readUnsignedByte();
					if (var8 == 1) {
						var8 = 0;
					}

					if (var1 == 0) {
						Tiles.Tiles_heights[0][var2][var3] = -var8 * 8;
					} else {
						Tiles.Tiles_heights[var1][var2][var3] = Tiles.Tiles_heights[var1 - 1][var2][var3] - var8 * 8;
					}
					break;
				}

				if (var7 <= 49) {
					AccessFile.field4061[var1][var2][var3] = var0.readByte();
					class210.field2492[var1][var2][var3] = (byte)((var7 - 2) / 4);
					Tiles.field475[var1][var2][var3] = (byte)(var7 - 2 + var6 & 3);
				} else if (var7 <= 81) {
					Tiles.Tiles_renderFlags[var1][var2][var3] = (byte)(var7 - 49);
				} else {
					Tiles.field485[var1][var2][var3] = (byte)(var7 - 81);
				}
			}
		} else {
			while (true) {
				var7 = var0.readUnsignedByte();
				if (var7 == 0) {
					break;
				}

				if (var7 == 1) {
					var0.readUnsignedByte();
					break;
				}

				if (var7 <= 49) {
					var0.readUnsignedByte();
				}
			}
		}

	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(Lhz;Ljava/lang/String;Ljava/lang/String;B)[Lls;",
		garbageValue = "0"
	)
	public static Sprite[] method535(AbstractArchive var0, String var1, String var2) {
		int var3 = var0.getGroupId(var1);
		int var4 = var0.getFileId(var3, var2);
		return WorldMapID.SpriteBuffer_getSpriteArray(var0, var3, var4);
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(Lhp;II)V",
		garbageValue = "543273081"
	)
	@Export("Widget_setKeyIgnoreHeld")
	static final void Widget_setKeyIgnoreHeld(Widget var0, int var1) {
		if (var0.field2631 == null) {
			throw new RuntimeException();
		} else {
			if (var0.field2685 == null) {
				var0.field2685 = new int[var0.field2631.length];
			}

			var0.field2685[var1] = Integer.MAX_VALUE;
		}
	}

	@ObfuscatedName("hb")
	@ObfuscatedSignature(
		signature = "(III)Lfq;",
		garbageValue = "1874659122"
	)
	static RouteStrategy method536(int var0, int var1) {
		Client.field684.approxDestinationX = var0;
		Client.field684.approxDestinationY = var1;
		Client.field684.approxDestinationSizeX = 1;
		Client.field684.approxDestinationSizeY = 1;
		return Client.field684;
	}
}
