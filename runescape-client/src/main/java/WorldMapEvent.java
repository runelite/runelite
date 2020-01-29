import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("al")
@Implements("WorldMapEvent")
public class WorldMapEvent {
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 937006651
	)
	@Export("mapElement")
	public int mapElement;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lhj;"
	)
	@Export("coord1")
	public Coord coord1;
	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "Lhj;"
	)
	@Export("coord2")
	public Coord coord2;

	@ObfuscatedSignature(
		signature = "(ILhj;Lhj;)V"
	)
	public WorldMapEvent(int var1, Coord var2, Coord var3) {
		this.mapElement = var1;
		this.coord1 = var2;
		this.coord2 = var3;
	}

	@ObfuscatedName("hm")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "560855047"
	)
	@Export("updateItemPile")
	static final void updateItemPile(int var0, int var1) {
		NodeDeque var2 = Client.groundItems[Clock.Client_plane][var0][var1];
		if (var2 == null) {
			ServerBuild.scene.removeGroundItemPile(Clock.Client_plane, var0, var1);
		} else {
			long var3 = -99999999L;
			TileItem var5 = null;

			TileItem var6;
			for (var6 = (TileItem)var2.last(); var6 != null; var6 = (TileItem)var2.previous()) {
				ItemDefinition var7 = HealthBarDefinition.ItemDefinition_get(var6.id);
				long var8 = (long)var7.price;
				if (var7.isStackable == 1) {
					var8 *= (long)(var6.quantity + 1);
				}

				if (var8 > var3) {
					var3 = var8;
					var5 = var6;
				}
			}

			if (var5 == null) {
				ServerBuild.scene.removeGroundItemPile(Clock.Client_plane, var0, var1);
			} else {
				var2.addLast(var5);
				TileItem var12 = null;
				TileItem var11 = null;

				for (var6 = (TileItem)var2.last(); var6 != null; var6 = (TileItem)var2.previous()) {
					if (var5.id != var6.id) {
						if (var12 == null) {
							var12 = var6;
						}

						if (var12.id != var6.id && var11 == null) {
							var11 = var6;
						}
					}
				}

				long var9 = GameShell.calculateTag(var0, var1, 3, false, 0);
				ServerBuild.scene.newGroundItemPile(Clock.Client_plane, var0, var1, WorldMapSectionType.getTileHeight(var0 * 128 + 64, var1 * 128 + 64, Clock.Client_plane), var5, var9, var12, var11);
			}
		}
	}

	@ObfuscatedName("jh")
	@ObfuscatedSignature(
		signature = "([Lhn;IB)V",
		garbageValue = "-29"
	)
	@Export("drawModelComponents")
	static final void drawModelComponents(Widget[] var0, int var1) {
		for (int var2 = 0; var2 < var0.length; ++var2) {
			Widget var3 = var0[var2];
			if (var3 != null && var3.parentId == var1 && (!var3.isIf3 || !VarcInt.isComponentHidden(var3))) {
				if (var3.type == 0) {
					if (!var3.isIf3 && VarcInt.isComponentHidden(var3) && var3 != GrandExchangeOfferUnitPriceComparator.mousedOverWidgetIf1) {
						continue;
					}

					drawModelComponents(var0, var3.id);
					if (var3.children != null) {
						drawModelComponents(var3.children, var3.id);
					}

					InterfaceParent var4 = (InterfaceParent)Client.interfaceParents.get((long)var3.id);
					if (var4 != null) {
						GrandExchangeOfferNameComparator.method150(var4.group);
					}
				}

				if (var3.type == 6) {
					int var5;
					if (var3.sequenceId != -1 || var3.sequenceId2 != -1) {
						boolean var7 = ScriptFrame.runCs1(var3);
						if (var7) {
							var5 = var3.sequenceId2;
						} else {
							var5 = var3.sequenceId;
						}

						if (var5 != -1) {
							SequenceDefinition var6 = GraphicsDefaults.SequenceDefinition_get(var5);

							for (var3.modelFrameCycle += Client.field707; var3.modelFrameCycle > var6.frameLengths[var3.modelFrame]; NPCDefinition.invalidateWidget(var3)) {
								var3.modelFrameCycle -= var6.frameLengths[var3.modelFrame];
								++var3.modelFrame;
								if (var3.modelFrame >= var6.frameIds.length) {
									var3.modelFrame -= var6.frameCount;
									if (var3.modelFrame < 0 || var3.modelFrame >= var6.frameIds.length) {
										var3.modelFrame = 0;
									}
								}
							}
						}
					}

					if (var3.field2696 != 0 && !var3.isIf3) {
						int var8 = var3.field2696 >> 16;
						var5 = var3.field2696 << 16 >> 16;
						var8 *= Client.field707;
						var5 *= Client.field707;
						var3.modelAngleX = var8 + var3.modelAngleX & 2047;
						var3.modelAngleY = var5 + var3.modelAngleY & 2047;
						NPCDefinition.invalidateWidget(var3);
					}
				}
			}
		}

	}
}
