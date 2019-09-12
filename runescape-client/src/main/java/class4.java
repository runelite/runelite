import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("l")
final class class4 implements class0 {
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -142539597
	)
	static int field20;
	@ObfuscatedName("az")
	@ObfuscatedGetter(
		intValue = -587969877
	)
	static int field17;
	@ObfuscatedName("bi")
	@ObfuscatedSignature(
		signature = "Lll;"
	)
	@Export("loginType")
	static LoginType loginType;
	@ObfuscatedName("fv")
	@ObfuscatedGetter(
		intValue = 583721997
	)
	@Export("baseX")
	static int baseX;
	@ObfuscatedName("jr")
	@ObfuscatedSignature(
		signature = "Lhy;"
	)
	@Export("dragInventoryWidget")
	static Widget dragInventoryWidget;

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/Object;Lkz;B)V",
		garbageValue = "1"
	)
	public void vmethod42(Object var1, Buffer var2) {
		this.method44((String)var1, var2);
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Lkz;S)Ljava/lang/Object;",
		garbageValue = "31810"
	)
	public Object vmethod41(Buffer var1) {
		return var1.readStringCp1252NullTerminated();
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Lkz;I)V",
		garbageValue = "442520806"
	)
	void method44(String var1, Buffer var2) {
		var2.writeStringCp1252NullTerminated(var1);
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Lhz;II)Lgc;",
		garbageValue = "531775240"
	)
	static MusicPatch method47(AbstractArchive var0, int var1) {
		byte[] var2 = var0.takeFileFlat(var1);
		return var2 == null ? null : new MusicPatch(var2);
	}

	@ObfuscatedName("gd")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "2058959697"
	)
	static final void method48(int var0) {
		int[] var1 = class60.sceneMinimapSprite.pixels;
		int var2 = var1.length;

		int var3;
		for (var3 = 0; var3 < var2; ++var3) {
			var1[var3] = 0;
		}

		int var4;
		int var5;
		for (var3 = 1; var3 < 103; ++var3) {
			var4 = (103 - var3) * 2048 + 24628;

			for (var5 = 1; var5 < 103; ++var5) {
				if ((Tiles.Tiles_renderFlags[var0][var5][var3] & 24) == 0) {
					WorldMapIcon_1.scene.drawTileMinimap(var1, var4, 512, var0, var5, var3);
				}

				if (var0 < 3 && (Tiles.Tiles_renderFlags[var0 + 1][var5][var3] & 8) != 0) {
					WorldMapIcon_1.scene.drawTileMinimap(var1, var4, 512, var0 + 1, var5, var3);
				}

				var4 += 4;
			}
		}

		var3 = (238 + (int)(Math.random() * 20.0D) - 10 << 16) + (238 + (int)(Math.random() * 20.0D) - 10 << 8) + (238 + (int)(Math.random() * 20.0D) - 10);
		var4 = 238 + (int)(Math.random() * 20.0D) - 10 << 16;
		class60.sceneMinimapSprite.setRaster();

		int var6;
		for (var5 = 1; var5 < 103; ++var5) {
			for (var6 = 1; var6 < 103; ++var6) {
				if ((Tiles.Tiles_renderFlags[var0][var6][var5] & 24) == 0) {
					EnumDefinition.drawObject(var0, var6, var5, var3, var4);
				}

				if (var0 < 3 && (Tiles.Tiles_renderFlags[var0 + 1][var6][var5] & 8) != 0) {
					EnumDefinition.drawObject(var0 + 1, var6, var5, var3, var4);
				}
			}
		}

		Client.mapIconCount = 0;

		for (var5 = 0; var5 < 104; ++var5) {
			for (var6 = 0; var6 < 104; ++var6) {
				long var7 = WorldMapIcon_1.scene.getFloorDecorationTag(MouseRecorder.plane, var5, var6);
				if (var7 != 0L) {
					int var9 = SecureRandomFuture.Entity_unpackID(var7);
					int var10 = WallDecoration.getObjectDefinition(var9).mapIconId;
					if (var10 >= 0) {
						Client.mapIcons[Client.mapIconCount] = WorldMapSection1.WorldMapElement_get(var10).getSpriteBool(false);
						Client.mapIconXs[Client.mapIconCount] = var5;
						Client.mapIconYs[Client.mapIconCount] = var6;
						++Client.mapIconCount;
					}
				}
			}
		}

		DevicePcmPlayerProvider.rasterProvider.apply();
	}
}
