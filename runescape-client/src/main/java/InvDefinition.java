import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iq")
@Implements("InvDefinition")
public class InvDefinition extends DualNode {
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Liy;"
	)
	@Export("InvDefinition_archive")
	static AbstractArchive InvDefinition_archive;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Leg;"
	)
	@Export("InvDefinition_cached")
	static EvictingDualNodeHashTable InvDefinition_cached;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -307651921
	)
	@Export("size")
	public int size;

	static {
		InvDefinition_cached = new EvictingDualNodeHashTable(64);
	}

	InvDefinition() {
		this.size = 0;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(Lkb;I)V",
		garbageValue = "117570412"
	)
	@Export("decode")
	void decode(Buffer var1) {
		while (true) {
			int var2 = var1.readUnsignedByte();
			if (var2 == 0) {
				return;
			}

			this.decodeNext(var1, var2);
		}
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(Lkb;II)V",
		garbageValue = "-72548916"
	)
	@Export("decodeNext")
	void decodeNext(Buffer var1, int var2) {
		if (var2 == 2) {
			this.size = var1.readUnsignedShort();
		}

	}

	@ObfuscatedName("fe")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "566997565"
	)
	static final void method4443() {
		if (ScriptEvent.Client_plane != Client.field695) {
			Client.field695 = ScriptEvent.Client_plane;
			int var0 = ScriptEvent.Client_plane;
			int[] var1 = ArchiveDisk.sceneMinimapSprite.pixels;
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
						GrandExchangeOfferWorldComparator.scene.drawTileMinimap(var1, var4, 512, var0, var5, var3);
					}

					if (var0 < 3 && (Tiles.Tiles_renderFlags[var0 + 1][var5][var3] & 8) != 0) {
						GrandExchangeOfferWorldComparator.scene.drawTileMinimap(var1, var4, 512, var0 + 1, var5, var3);
					}

					var4 += 4;
				}
			}

			var3 = (238 + (int)(Math.random() * 20.0D) - 10 << 16) + (238 + (int)(Math.random() * 20.0D) - 10 << 8) + (238 + (int)(Math.random() * 20.0D) - 10);
			var4 = 238 + (int)(Math.random() * 20.0D) - 10 << 16;
			ArchiveDisk.sceneMinimapSprite.setRaster();

			int var6;
			for (var5 = 1; var5 < 103; ++var5) {
				for (var6 = 1; var6 < 103; ++var6) {
					if ((Tiles.Tiles_renderFlags[var0][var6][var5] & 24) == 0) {
						ScriptFrame.drawObject(var0, var6, var5, var3, var4);
					}

					if (var0 < 3 && (Tiles.Tiles_renderFlags[var0 + 1][var6][var5] & 8) != 0) {
						ScriptFrame.drawObject(var0 + 1, var6, var5, var3, var4);
					}
				}
			}

			Client.mapIconCount = 0;

			for (var5 = 0; var5 < 104; ++var5) {
				for (var6 = 0; var6 < 104; ++var6) {
					long var7 = GrandExchangeOfferWorldComparator.scene.getFloorDecorationTag(ScriptEvent.Client_plane, var5, var6);
					if (0L != var7) {
						int var9 = WorldMapRectangle.Entity_unpackID(var7);
						int var10 = WorldMapSection2.getObjectDefinition(var9).mapIconId;
						if (var10 >= 0) {
							Client.mapIcons[Client.mapIconCount] = class25.WorldMapElement_get(var10).getSpriteBool(false);
							Client.mapIconXs[Client.mapIconCount] = var5;
							Client.mapIconYs[Client.mapIconCount] = var6;
							++Client.mapIconCount;
						}
					}
				}
			}

			class206.rasterProvider.apply();
		}

	}
}
