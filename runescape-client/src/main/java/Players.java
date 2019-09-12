import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cn")
@Implements("Players")
public class Players {
	@ObfuscatedName("t")
	static byte[] field1217;
	@ObfuscatedName("g")
	static byte[] field1220;
	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "[Lkz;"
	)
	static Buffer[] field1221;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 207480583
	)
	@Export("Players_count")
	static int Players_count;
	@ObfuscatedName("j")
	@Export("Players_indices")
	static int[] Players_indices;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 205698167
	)
	@Export("Players_emptyIdxCount")
	static int Players_emptyIdxCount;
	@ObfuscatedName("d")
	@Export("Players_emptyIndices")
	static int[] Players_emptyIndices;
	@ObfuscatedName("z")
	@Export("Players_regions")
	static int[] Players_regions;
	@ObfuscatedName("n")
	@Export("Players_orientations")
	static int[] Players_orientations;
	@ObfuscatedName("h")
	@Export("Players_targetIndices")
	static int[] Players_targetIndices;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = 707214243
	)
	@Export("Players_pendingUpdateCount")
	static int Players_pendingUpdateCount;
	@ObfuscatedName("s")
	@Export("Players_pendingUpdateIndices")
	static int[] Players_pendingUpdateIndices;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lkz;"
	)
	static Buffer field1231;

	static {
		field1217 = new byte[2048];
		field1220 = new byte[2048];
		field1221 = new Buffer[2048];
		Players_count = 0;
		Players_indices = new int[2048];
		Players_emptyIdxCount = 0;
		Players_emptyIndices = new int[2048];
		Players_regions = new int[2048];
		Players_orientations = new int[2048];
		Players_targetIndices = new int[2048];
		Players_pendingUpdateCount = 0;
		Players_pendingUpdateIndices = new int[2048];
		field1231 = new Buffer(new byte[5000]);
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(II)Lik;",
		garbageValue = "-1920916137"
	)
	@Export("getInvDefinition")
	public static InvDefinition getInvDefinition(int var0) {
		InvDefinition var1 = (InvDefinition)InvDefinition.InvDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = InvDefinition.InvDefinition_archive.takeFile(5, var0);
			var1 = new InvDefinition();
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			InvDefinition.InvDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("jl")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "1427769398"
	)
	static final void method2123(int var0) {
		WorldMapRectangle.method257();
		WorldMapData_0.method157();
		int var1 = class30.method518(var0).type;
		if (var1 != 0) {
			int var2 = Varps.Varps_main[var0];
			if (var1 == 1) {
				if (var2 == 1) {
					Rasterizer3D.Rasterizer3D_setBrightness(0.9D);
					((TextureProvider)Rasterizer3D.Rasterizer3D_textureLoader).setBrightness(0.9D);
				}

				if (var2 == 2) {
					Rasterizer3D.Rasterizer3D_setBrightness(0.8D);
					((TextureProvider)Rasterizer3D.Rasterizer3D_textureLoader).setBrightness(0.8D);
				}

				if (var2 == 3) {
					Rasterizer3D.Rasterizer3D_setBrightness(0.7D);
					((TextureProvider)Rasterizer3D.Rasterizer3D_textureLoader).setBrightness(0.7D);
				}

				if (var2 == 4) {
					Rasterizer3D.Rasterizer3D_setBrightness(0.6D);
					((TextureProvider)Rasterizer3D.Rasterizer3D_textureLoader).setBrightness(0.6D);
				}

				ItemDefinition.ItemDefinition_cachedSprites.clear();
			}

			if (var1 == 3) {
				short var3 = 0;
				if (var2 == 0) {
					var3 = 255;
				}

				if (var2 == 1) {
					var3 = 192;
				}

				if (var2 == 2) {
					var3 = 128;
				}

				if (var2 == 3) {
					var3 = 64;
				}

				if (var2 == 4) {
					var3 = 0;
				}

				if (var3 != Client.field638) {
					if (Client.field638 == 0 && Client.field857 != -1) {
						class49.method826(WorldMapDecoration.archive6, Client.field857, 0, var3, false);
						Client.field746 = false;
					} else if (var3 == 0) {
						class226.method4108();
						Client.field746 = false;
					} else {
						Decimator.method2499(var3);
					}

					Client.field638 = var3;
				}
			}

			if (var1 == 4) {
				if (var2 == 0) {
					Client.soundEffectVolume = 127;
				}

				if (var2 == 1) {
					Client.soundEffectVolume = 96;
				}

				if (var2 == 2) {
					Client.soundEffectVolume = 64;
				}

				if (var2 == 3) {
					Client.soundEffectVolume = 32;
				}

				if (var2 == 4) {
					Client.soundEffectVolume = 0;
				}
			}

			if (var1 == 5) {
				Client.leftClickOpensMenu = var2;
			}

			if (var1 == 6) {
				Client.chatEffects = var2;
			}

			if (var1 == 9) {
				Client.field787 = var2;
			}

			if (var1 == 10) {
				if (var2 == 0) {
					Client.field860 = 127;
				}

				if (var2 == 1) {
					Client.field860 = 96;
				}

				if (var2 == 2) {
					Client.field860 = 64;
				}

				if (var2 == 3) {
					Client.field860 = 32;
				}

				if (var2 == 4) {
					Client.field860 = 0;
				}
			}

			if (var1 == 17) {
				Client.followerIndex = var2 & 65535;
			}

			if (var1 == 18) {
				Client.playerAttackOption = (AttackOption)ServerPacket.findEnumerated(Coord.method3981(), var2);
				if (Client.playerAttackOption == null) {
					Client.playerAttackOption = AttackOption.AttackOption_dependsOnCombatLevels;
				}
			}

			if (var1 == 19) {
				if (var2 == -1) {
					Client.combatTargetPlayerIndex = -1;
				} else {
					Client.combatTargetPlayerIndex = var2 & 2047;
				}
			}

			if (var1 == 22) {
				Client.npcAttackOption = (AttackOption)ServerPacket.findEnumerated(Coord.method3981(), var2);
				if (Client.npcAttackOption == null) {
					Client.npcAttackOption = AttackOption.AttackOption_dependsOnCombatLevels;
				}
			}

		}
	}
}
