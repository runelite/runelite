import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ca")
public class class96 {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Ljj;"
	)
	@Export("reflectionChecks")
	static IterableNodeDeque reflectionChecks;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "[Lbg;"
	)
	@Export("World_worlds")
	static World[] World_worlds;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -44296149
	)
	@Export("loginBoxCenter")
	static int loginBoxCenter;

	static {
		reflectionChecks = new IterableNodeDeque();
	}

	@ObfuscatedName("gr")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "512388995"
	)
	static final int method2346() {
		if (WorldMapSection2.clientPreferences.roofsHidden) {
			return Clock.Client_plane;
		} else {
			int var0 = 3;
			if (GrandExchangeOffer.cameraPitch < 310) {
				int var1;
				int var2;
				if (Client.oculusOrbState == 1) {
					var1 = PendingSpawn.oculusOrbFocalPointX >> 7;
					var2 = Skeleton.oculusOrbFocalPointY >> 7;
				} else {
					var1 = class192.localPlayer.x >> 7;
					var2 = class192.localPlayer.y >> 7;
				}

				int var3 = HitSplatDefinition.cameraX >> 7;
				int var4 = Actor.cameraZ >> 7;
				if (var3 < 0 || var4 < 0 || var3 >= 104 || var4 >= 104) {
					return Clock.Client_plane;
				}

				if (var1 < 0 || var2 < 0 || var1 >= 104 || var2 >= 104) {
					return Clock.Client_plane;
				}

				if ((Tiles.Tiles_renderFlags[Clock.Client_plane][var3][var4] & 4) != 0) {
					var0 = Clock.Client_plane;
				}

				int var5;
				if (var1 > var3) {
					var5 = var1 - var3;
				} else {
					var5 = var3 - var1;
				}

				int var6;
				if (var2 > var4) {
					var6 = var2 - var4;
				} else {
					var6 = var4 - var2;
				}

				int var7;
				int var8;
				if (var5 > var6) {
					var7 = var6 * 65536 / var5;
					var8 = 32768;

					while (var1 != var3) {
						if (var3 < var1) {
							++var3;
						} else if (var3 > var1) {
							--var3;
						}

						if ((Tiles.Tiles_renderFlags[Clock.Client_plane][var3][var4] & 4) != 0) {
							var0 = Clock.Client_plane;
						}

						var8 += var7;
						if (var8 >= 65536) {
							var8 -= 65536;
							if (var4 < var2) {
								++var4;
							} else if (var4 > var2) {
								--var4;
							}

							if ((Tiles.Tiles_renderFlags[Clock.Client_plane][var3][var4] & 4) != 0) {
								var0 = Clock.Client_plane;
							}
						}
					}
				} else if (var6 > 0) {
					var7 = var5 * 65536 / var6;
					var8 = 32768;

					while (var4 != var2) {
						if (var4 < var2) {
							++var4;
						} else if (var4 > var2) {
							--var4;
						}

						if ((Tiles.Tiles_renderFlags[Clock.Client_plane][var3][var4] & 4) != 0) {
							var0 = Clock.Client_plane;
						}

						var8 += var7;
						if (var8 >= 65536) {
							var8 -= 65536;
							if (var3 < var1) {
								++var3;
							} else if (var3 > var1) {
								--var3;
							}

							if ((Tiles.Tiles_renderFlags[Clock.Client_plane][var3][var4] & 4) != 0) {
								var0 = Clock.Client_plane;
							}
						}
					}
				}
			}

			if (class192.localPlayer.x >= 0 && class192.localPlayer.y >= 0 && class192.localPlayer.x < 13312 && class192.localPlayer.y < 13312) {
				if ((Tiles.Tiles_renderFlags[Clock.Client_plane][class192.localPlayer.x >> 7][class192.localPlayer.y >> 7] & 4) != 0) {
					var0 = Clock.Client_plane;
				}

				return var0;
			} else {
				return Clock.Client_plane;
			}
		}
	}

	@ObfuscatedName("hv")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-2092655823"
	)
	@Export("addCancelMenuEntry")
	static void addCancelMenuEntry() {
		Client.menuOptionsCount = 0;
		Client.isMenuOpen = false;
		Client.menuActions[0] = "Cancel";
		Client.menuTargets[0] = "";
		Client.menuOpcodes[0] = 1006;
		Client.menuShiftClick[0] = false;
		Client.menuOptionsCount = 1;
	}

	@ObfuscatedName("kq")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1882557485"
	)
	@Export("FriendSystem_invalidateIgnoreds")
	static final void FriendSystem_invalidateIgnoreds() {
		Iterator var0 = Messages.Messages_hashTable.iterator();

		while (var0.hasNext()) {
			Message var1 = (Message)var0.next();
			var1.clearIsFromIgnored();
		}

		if (InterfaceParent.clanChat != null) {
			InterfaceParent.clanChat.invalidateIgnoreds();
		}

	}
}
