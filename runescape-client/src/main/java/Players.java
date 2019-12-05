import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cn")
@Implements("Players")
public class Players {
	@ObfuscatedName("b")
	static byte[] field1246;
	@ObfuscatedName("g")
	static byte[] field1247;
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "[Lkg;"
	)
	static Buffer[] field1248;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 695859649
	)
	@Export("Players_count")
	static int Players_count;
	@ObfuscatedName("h")
	@Export("Players_indices")
	static int[] Players_indices;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = -1613986531
	)
	@Export("Players_emptyIdxCount")
	static int Players_emptyIdxCount;
	@ObfuscatedName("w")
	@Export("Players_emptyIndices")
	static int[] Players_emptyIndices;
	@ObfuscatedName("i")
	@Export("Players_regions")
	static int[] Players_regions;
	@ObfuscatedName("k")
	@Export("Players_orientations")
	static int[] Players_orientations;
	@ObfuscatedName("x")
	@Export("Players_targetIndices")
	static int[] Players_targetIndices;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = 1909363063
	)
	@Export("Players_pendingUpdateCount")
	static int Players_pendingUpdateCount;
	@ObfuscatedName("e")
	@Export("Players_pendingUpdateIndices")
	static int[] Players_pendingUpdateIndices;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lkg;"
	)
	static Buffer field1252;
	@ObfuscatedName("ac")
	@Export("null_string")
	protected static String null_string;

	static {
		field1246 = new byte[2048];
		field1247 = new byte[2048];
		field1248 = new Buffer[2048];
		Players_count = 0;
		Players_indices = new int[2048];
		Players_emptyIdxCount = 0;
		Players_emptyIndices = new int[2048];
		Players_regions = new int[2048];
		Players_orientations = new int[2048];
		Players_targetIndices = new int[2048];
		Players_pendingUpdateCount = 0;
		Players_pendingUpdateIndices = new int[2048];
		field1252 = new Buffer(new byte[5000]);
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(II)Lie;",
		garbageValue = "2117062492"
	)
	@Export("KitDefinition_get")
	public static KitDefinition KitDefinition_get(int var0) {
		KitDefinition var1 = (KitDefinition)KitDefinition.KitDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = class14.KitDefinition_archive.takeFile(3, var0);
			var1 = new KitDefinition();
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			KitDefinition.KitDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(Lkj;ILbg;II)V",
		garbageValue = "237761948"
	)
	static final void method2167(PacketBuffer var0, int var1, Player var2, int var3) {
		byte var4 = -1;
		if ((var3 & 512) != 0) {
			var2.field946 = var0.method5633();
			var2.field979 = var0.method5772();
			var2.field978 = var0.method5633();
			var2.field980 = var0.method5637();
			var2.field934 = var0.method5719() + Client.cycle;
			var2.field982 = var0.method5640() + Client.cycle;
			var2.field983 = var0.method5719();
			if (var2.field630) {
				var2.field946 += var2.tileX;
				var2.field979 += var2.tileY;
				var2.field978 += var2.tileX;
				var2.field980 += var2.tileY;
				var2.pathLength = 0;
			} else {
				var2.field946 += var2.pathX[0];
				var2.field979 += var2.pathY[0];
				var2.field978 += var2.pathX[0];
				var2.field980 += var2.pathY[0];
				var2.pathLength = 1;
			}

			var2.field994 = 0;
		}

		int var5;
		if ((var3 & 2048) != 0) {
			var2.spotAnimation = var0.method5719();
			var5 = var0.method5649();
			var2.field996 = var5 >> 16;
			var2.field975 = (var5 & 65535) + Client.cycle;
			var2.spotAnimationFrame = 0;
			var2.spotAnimationFrameCycle = 0;
			if (var2.field975 > Client.cycle) {
				var2.spotAnimationFrame = -1;
			}

			if (var2.spotAnimation == 65535) {
				var2.spotAnimation = -1;
			}
		}

		if ((var3 & 1024) != 0) {
			var4 = var0.readByte();
		}

		if ((var3 & 4096) != 0) {
			field1247[var1] = var0.method5633();
		}

		if ((var3 & 128) != 0) {
			var5 = var0.method5728();
			byte[] var6 = new byte[var5];
			Buffer var7 = new Buffer(var6);
			var0.readBytes(var6, 0, var5);
			field1248[var1] = var7;
			var2.read(var7);
		}

		if ((var3 & 256) != 0) {
			for (var5 = 0; var5 < 3; ++var5) {
				var2.actions[var5] = var0.readStringCp1252NullTerminated();
			}
		}

		if ((var3 & 2) != 0) {
			var2.overheadText = var0.readStringCp1252NullTerminated();
			if (var2.overheadText.charAt(0) == '~') {
				var2.overheadText = var2.overheadText.substring(1);
				GrandExchangeOfferAgeComparator.addGameMessage(2, var2.username.getName(), var2.overheadText);
			} else if (var2 == class215.localPlayer) {
				GrandExchangeOfferAgeComparator.addGameMessage(2, var2.username.getName(), var2.overheadText);
			}

			var2.isAutoChatting = false;
			var2.overheadTextColor = 0;
			var2.overheadTextEffect = 0;
			var2.overheadTextCyclesRemaining = 150;
		}

		if ((var3 & 1) != 0) {
			var2.targetIndex = var0.method5719();
			if (var2.targetIndex == 65535) {
				var2.targetIndex = -1;
			}
		}

		if ((var3 & 32) != 0) {
			var2.field965 = var0.method5640();
			if (var2.pathLength == 0) {
				var2.orientation = var2.field965;
				var2.field965 = -1;
			}
		}

		int var13;
		if ((var3 & 16) != 0) {
			var5 = var0.method5719();
			if (var5 == 65535) {
				var5 = -1;
			}

			var13 = var0.method5689();
			WorldMapRectangle.performPlayerAnimation(var2, var5, var13);
		}

		int var8;
		int var9;
		int var12;
		if ((var3 & 8) != 0) {
			var5 = var0.readUnsignedByte();
			int var10;
			int var11;
			int var14;
			if (var5 > 0) {
				for (var13 = 0; var13 < var5; ++var13) {
					var8 = -1;
					var9 = -1;
					var10 = -1;
					var14 = var0.readUShortSmart();
					if (var14 == 32767) {
						var14 = var0.readUShortSmart();
						var9 = var0.readUShortSmart();
						var8 = var0.readUShortSmart();
						var10 = var0.readUShortSmart();
					} else if (var14 != 32766) {
						var9 = var0.readUShortSmart();
					} else {
						var14 = -1;
					}

					var11 = var0.readUShortSmart();
					var2.addHitSplat(var14, var9, var8, var10, Client.cycle, var11);
				}
			}

			var13 = var0.method5631();
			if (var13 > 0) {
				for (var14 = 0; var14 < var13; ++var14) {
					var8 = var0.readUShortSmart();
					var9 = var0.readUShortSmart();
					if (var9 != 32767) {
						var10 = var0.readUShortSmart();
						var11 = var0.method5631();
						var12 = var9 > 0 ? var0.method5728() : var11;
						var2.addHealthBar(var8, Client.cycle, var9, var10, var11, var12);
					} else {
						var2.removeHealthBar(var8);
					}
				}
			}
		}

		if ((var3 & 64) != 0) {
			var5 = var0.method5719();
			PlayerType var16 = (PlayerType)CollisionMap.findEnumerated(class2.PlayerType_values(), var0.method5728());
			boolean var19 = var0.method5631() == 1;
			var8 = var0.readUnsignedByte();
			var9 = var0.offset;
			if (var2.username != null && var2.appearance != null) {
				boolean var18 = false;
				if (var16.isUser && VertexNormal.friendSystem.isIgnored(var2.username)) {
					var18 = true;
				}

				if (!var18 && Client.field756 == 0 && !var2.isHidden) {
					field1252.offset = 0;
					var0.readBytes(field1252.array, 0, var8);
					field1252.offset = 0;
					String var15 = AbstractFont.escapeBrackets(class191.method3720(GrandExchangeOfferUnitPriceComparator.method142(field1252)));
					var2.overheadText = var15.trim();
					var2.overheadTextColor = var5 >> 8;
					var2.overheadTextEffect = var5 & 255;
					var2.overheadTextCyclesRemaining = 150;
					var2.isAutoChatting = var19;
					var2.field950 = var2 != class215.localPlayer && var16.isUser && "" != Client.field860 && var15.toLowerCase().indexOf(Client.field860) == -1;
					if (var16.isPrivileged) {
						var12 = var19 ? 91 : 1;
					} else {
						var12 = var19 ? 90 : 2;
					}

					if (var16.modIcon != -1) {
						GrandExchangeOfferAgeComparator.addGameMessage(var12, Client.method1749(var16.modIcon) + var2.username.getName(), var15);
					} else {
						GrandExchangeOfferAgeComparator.addGameMessage(var12, var2.username.getName(), var15);
					}
				}
			}

			var0.offset = var9 + var8;
		}

		if (var2.field630) {
			if (var4 == 127) {
				var2.resetPath(var2.tileX, var2.tileY);
			} else {
				byte var17;
				if (var4 != -1) {
					var17 = var4;
				} else {
					var17 = field1247[var1];
				}

				var2.method1255(var2.tileX, var2.tileY, var17);
			}
		}

	}
}
