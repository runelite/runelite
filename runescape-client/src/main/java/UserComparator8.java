import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fo")
@Implements("UserComparator8")
public class UserComparator8 extends AbstractUserComparator {
	@ObfuscatedName("x")
	@Export("reversed")
	final boolean reversed;

	public UserComparator8(boolean var1) {
		this.reversed = var1;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Lke;Lke;I)I",
		garbageValue = "-956709758"
	)
	@Export("compareBuddy")
	int compareBuddy(Buddy var1, Buddy var2) {
		if (Client.worldId == var1.world) {
			if (var2.world != Client.worldId) {
				return this.reversed ? -1 : 1;
			}
		} else if (var2.world == Client.worldId) {
			return this.reversed ? 1 : -1;
		}

		return this.compareUser(var1, var2);
	}

	public int compare(Object var1, Object var2) {
		return this.compareBuddy((Buddy)var1, (Buddy)var2);
	}

	@ObfuscatedName("gk")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "87"
	)
	static final int method3503() {
		if (GrandExchangeOfferOwnWorldComparator.clientPreferences.roofsHidden) {
			return ScriptEvent.Client_plane;
		} else {
			int var0 = 3;
			if (class74.cameraPitch < 310) {
				int var1;
				int var2;
				if (Client.oculusOrbState == 1) {
					var1 = SoundSystem.oculusOrbFocalPointX >> 7;
					var2 = ServerPacket.oculusOrbFocalPointY >> 7;
				} else {
					var1 = ByteArrayPool.localPlayer.x >> 7;
					var2 = ByteArrayPool.localPlayer.y >> 7;
				}

				int var3 = WorldMapRectangle.cameraX >> 7;
				int var4 = class200.cameraZ >> 7;
				if (var3 < 0 || var4 < 0 || var3 >= 104 || var4 >= 104) {
					return ScriptEvent.Client_plane;
				}

				if (var1 < 0 || var2 < 0 || var1 >= 104 || var2 >= 104) {
					return ScriptEvent.Client_plane;
				}

				if ((Tiles.Tiles_renderFlags[ScriptEvent.Client_plane][var3][var4] & 4) != 0) {
					var0 = ScriptEvent.Client_plane;
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

						if ((Tiles.Tiles_renderFlags[ScriptEvent.Client_plane][var3][var4] & 4) != 0) {
							var0 = ScriptEvent.Client_plane;
						}

						var8 += var7;
						if (var8 >= 65536) {
							var8 -= 65536;
							if (var4 < var2) {
								++var4;
							} else if (var4 > var2) {
								--var4;
							}

							if ((Tiles.Tiles_renderFlags[ScriptEvent.Client_plane][var3][var4] & 4) != 0) {
								var0 = ScriptEvent.Client_plane;
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

						if ((Tiles.Tiles_renderFlags[ScriptEvent.Client_plane][var3][var4] & 4) != 0) {
							var0 = ScriptEvent.Client_plane;
						}

						var8 += var7;
						if (var8 >= 65536) {
							var8 -= 65536;
							if (var3 < var1) {
								++var3;
							} else if (var3 > var1) {
								--var3;
							}

							if ((Tiles.Tiles_renderFlags[ScriptEvent.Client_plane][var3][var4] & 4) != 0) {
								var0 = ScriptEvent.Client_plane;
							}
						}
					}
				}
			}

			if (ByteArrayPool.localPlayer.x >= 0 && ByteArrayPool.localPlayer.y >= 0 && ByteArrayPool.localPlayer.x < 13312 && ByteArrayPool.localPlayer.y < 13312) {
				if ((Tiles.Tiles_renderFlags[ScriptEvent.Client_plane][ByteArrayPool.localPlayer.x >> 7][ByteArrayPool.localPlayer.y >> 7] & 4) != 0) {
					var0 = ScriptEvent.Client_plane;
				}

				return var0;
			} else {
				return ScriptEvent.Client_plane;
			}
		}
	}
}
