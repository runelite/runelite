import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hj")
@Implements("PlayerType")
public enum PlayerType implements Enumerated {
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Lhj;"
	)
	@Export("PlayerType_normal")
	PlayerType_normal(0, -1, true, false, true),
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lhj;"
	)
	@Export("PlayerType_playerModerator")
	PlayerType_playerModerator(1, 0, true, true, true),
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lhj;"
	)
	@Export("PlayerType_jagexModerator")
	PlayerType_jagexModerator(2, 1, true, true, false),
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lhj;"
	)
	@Export("PlayerType_ironman")
	PlayerType_ironman(3, 2, false, false, true),
	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "Lhj;"
	)
	@Export("PlayerType_ultimateIronman")
	PlayerType_ultimateIronman(4, 3, false, false, true),
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lhj;"
	)
	@Export("PlayerType_hardcoreIronman")
	PlayerType_hardcoreIronman(5, 10, false, false, true);

	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -1844030563
	)
	@Export("id")
	final int id;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -1331495779
	)
	@Export("modIcon")
	public final int modIcon;
	@ObfuscatedName("y")
	@Export("isPrivileged")
	public final boolean isPrivileged;
	@ObfuscatedName("i")
	@Export("isUser")
	public final boolean isUser;

	PlayerType(int var3, int var4, boolean var5, boolean var6, boolean var7) {
		this.id = var3;
		this.modIcon = var4;
		this.isPrivileged = var6;
		this.isUser = var7;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(S)I",
		garbageValue = "221"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
		garbageValue = "-1550321441"
	)
	@Export("setLoginResponseString")
	static void setLoginResponseString(String var0, String var1, String var2) {
		Login.Login_response1 = var0;
		Login.Login_response2 = var1;
		Login.Login_response3 = var2;
	}

	@ObfuscatedName("fe")
	@ObfuscatedSignature(
		signature = "(ZI)V",
		garbageValue = "297483019"
	)
	static final void method4104(boolean var0) {
		if (var0) {
			Client.field672 = Login.field1183 ? class160.field1976 : class160.field1977;
		} else {
			Client.field672 = AbstractArchive.clientPreferences.parameters.containsKey(class288.method5224(Login.Login_username)) ? class160.field1979 : class160.field1985;
		}

	}

	@ObfuscatedName("gb")
	@ObfuscatedSignature(
		signature = "(ZLkf;I)V",
		garbageValue = "-100712701"
	)
	@Export("loadRegions")
	static final void loadRegions(boolean var0, PacketBuffer var1) {
		Client.isInInstance = var0;
		int var2;
		int var4;
		int var5;
		int var6;
		int var7;
		int var8;
		if (!Client.isInInstance) {
			var2 = var1.method5647();
			int var3 = var1.method5479();
			var4 = var1.readUnsignedShort();
			class296.xteaKeys = new int[var4][4];

			for (var5 = 0; var5 < var4; ++var5) {
				for (var6 = 0; var6 < 4; ++var6) {
					class296.xteaKeys[var5][var6] = var1.readInt();
				}
			}

			MouseHandler.regions = new int[var4];
			class197.regionMapArchiveIds = new int[var4];
			class60.regionLandArchiveIds = new int[var4];
			WorldMapIcon_1.regionLandArchives = new byte[var4][];
			ArchiveLoader.regionMapArchives = new byte[var4][];
			boolean var16 = false;
			if ((var2 / 8 == 48 || var2 / 8 == 49) && var3 / 8 == 48) {
				var16 = true;
			}

			if (var2 / 8 == 48 && var3 / 8 == 148) {
				var16 = true;
			}

			var4 = 0;

			for (var6 = (var2 - 6) / 8; var6 <= (var2 + 6) / 8; ++var6) {
				for (var7 = (var3 - 6) / 8; var7 <= (var3 + 6) / 8; ++var7) {
					var8 = var7 + (var6 << 8);
					if (!var16 || var7 != 49 && var7 != 149 && var7 != 147 && var6 != 50 && (var6 != 49 || var7 != 47)) {
						MouseHandler.regions[var4] = var8;
						class197.regionMapArchiveIds[var4] = class3.archive5.getGroupId("m" + var6 + "_" + var7);
						class60.regionLandArchiveIds[var4] = class3.archive5.getGroupId("l" + var6 + "_" + var7);
						++var4;
					}
				}
			}

			class289.method5228(var2, var3, true);
		} else {
			var2 = var1.readUnsignedShort();
			boolean var15 = var1.method5511() == 1;
			var4 = var1.method5647();
			var5 = var1.readUnsignedShort();
			var1.importIndex();

			int var9;
			for (var6 = 0; var6 < 4; ++var6) {
				for (var7 = 0; var7 < 13; ++var7) {
					for (var8 = 0; var8 < 13; ++var8) {
						var9 = var1.readBits(1);
						if (var9 == 1) {
							Client.instanceChunkTemplates[var6][var7][var8] = var1.readBits(26);
						} else {
							Client.instanceChunkTemplates[var6][var7][var8] = -1;
						}
					}
				}
			}

			var1.exportIndex();
			class296.xteaKeys = new int[var5][4];

			for (var6 = 0; var6 < var5; ++var6) {
				for (var7 = 0; var7 < 4; ++var7) {
					class296.xteaKeys[var6][var7] = var1.readInt();
				}
			}

			MouseHandler.regions = new int[var5];
			class197.regionMapArchiveIds = new int[var5];
			class60.regionLandArchiveIds = new int[var5];
			WorldMapIcon_1.regionLandArchives = new byte[var5][];
			ArchiveLoader.regionMapArchives = new byte[var5][];
			var5 = 0;

			for (var6 = 0; var6 < 4; ++var6) {
				for (var7 = 0; var7 < 13; ++var7) {
					for (var8 = 0; var8 < 13; ++var8) {
						var9 = Client.instanceChunkTemplates[var6][var7][var8];
						if (var9 != -1) {
							int var10 = var9 >> 14 & 1023;
							int var11 = var9 >> 3 & 2047;
							int var12 = (var10 / 8 << 8) + var11 / 8;

							int var13;
							for (var13 = 0; var13 < var5; ++var13) {
								if (MouseHandler.regions[var13] == var12) {
									var12 = -1;
									break;
								}
							}

							if (var12 != -1) {
								MouseHandler.regions[var5] = var12;
								var13 = var12 >> 8 & 255;
								int var14 = var12 & 255;
								class197.regionMapArchiveIds[var5] = class3.archive5.getGroupId("m" + var13 + "_" + var14);
								class60.regionLandArchiveIds[var5] = class3.archive5.getGroupId("l" + var13 + "_" + var14);
								++var5;
							}
						}
					}
				}
			}

			class289.method5228(var4, var2, !var15);
		}

	}
}
