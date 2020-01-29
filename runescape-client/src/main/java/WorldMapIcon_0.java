import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("z")
@Implements("WorldMapIcon_0")
public class WorldMapIcon_0 extends AbstractWorldMapIcon {
	@ObfuscatedName("nl")
	@ObfuscatedGetter(
		intValue = 801956047
	)
	static int field142;
	@ObfuscatedName("sn")
	@ObfuscatedSignature(
		signature = "Lly;"
	)
	@Export("worldMap")
	static WorldMap worldMap;
	@ObfuscatedName("dv")
	@ObfuscatedSignature(
		signature = "Lkr;"
	)
	@Export("js5Socket")
	static AbstractSocket js5Socket;
	@ObfuscatedName("eg")
	@ObfuscatedGetter(
		intValue = -201961779
	)
	static int field148;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -204680949
	)
	@Export("element")
	final int element;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Laz;"
	)
	@Export("label")
	final WorldMapLabel label;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = 844262399
	)
	@Export("subWidth")
	final int subWidth;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 1735837545
	)
	@Export("subHeight")
	final int subHeight;

	@ObfuscatedSignature(
		signature = "(Lhj;Lhj;ILaz;)V"
	)
	WorldMapIcon_0(Coord var1, Coord var2, int var3, WorldMapLabel var4) {
		super(var1, var2);
		this.element = var3;
		this.label = var4;
		WorldMapElement var5 = PacketBufferNode.WorldMapElement_get(this.getElement());
		Sprite var6 = var5.getSpriteBool(false);
		if (var6 != null) {
			this.subWidth = var6.subWidth;
			this.subHeight = var6.subHeight;
		} else {
			this.subWidth = 0;
			this.subHeight = 0;
		}

	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "1499764486"
	)
	@Export("getElement")
	public int getElement() {
		return this.element;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(B)Laz;",
		garbageValue = "124"
	)
	@Export("getLabel")
	WorldMapLabel getLabel() {
		return this.label;
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(S)I",
		garbageValue = "-26101"
	)
	@Export("getSubWidth")
	int getSubWidth() {
		return this.subWidth;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "1"
	)
	@Export("getSubHeight")
	int getSubHeight() {
		return this.subHeight;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(B)J",
		garbageValue = "74"
	)
	@Export("currentTimeMillis")
	public static final synchronized long currentTimeMillis() {
		long var0 = System.currentTimeMillis();
		if (var0 < VertexNormal.field1752) {
			SpotAnimationDefinition.field3250 += VertexNormal.field1752 - var0;
		}

		VertexNormal.field1752 = var0;
		return SpotAnimationDefinition.field3250 + var0;
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(Lks;I)V",
		garbageValue = "-2023034499"
	)
	static final void method206(PacketBuffer var0) {
		int var1 = 0;
		var0.importIndex();

		byte[] var10000;
		int var2;
		int var3;
		int var4;
		for (var2 = 0; var2 < Players.Players_count; ++var2) {
			var3 = Players.Players_indices[var2];
			if ((Players.field1236[var3] & 1) == 0) {
				if (var1 > 0) {
					--var1;
					var10000 = Players.field1236;
					var10000[var3] = (byte)(var10000[var3] | 2);
				} else {
					var4 = var0.readBits(1);
					if (var4 == 0) {
						var1 = class80.method2094(var0);
						var10000 = Players.field1236;
						var10000[var3] = (byte)(var10000[var3] | 2);
					} else {
						class208.readPlayerUpdate(var0, var3);
					}
				}
			}
		}

		var0.exportIndex();
		if (var1 != 0) {
			throw new RuntimeException();
		} else {
			var0.importIndex();

			for (var2 = 0; var2 < Players.Players_count; ++var2) {
				var3 = Players.Players_indices[var2];
				if ((Players.field1236[var3] & 1) != 0) {
					if (var1 > 0) {
						--var1;
						var10000 = Players.field1236;
						var10000[var3] = (byte)(var10000[var3] | 2);
					} else {
						var4 = var0.readBits(1);
						if (var4 == 0) {
							var1 = class80.method2094(var0);
							var10000 = Players.field1236;
							var10000[var3] = (byte)(var10000[var3] | 2);
						} else {
							class208.readPlayerUpdate(var0, var3);
						}
					}
				}
			}

			var0.exportIndex();
			if (var1 != 0) {
				throw new RuntimeException();
			} else {
				var0.importIndex();

				for (var2 = 0; var2 < Players.Players_emptyIdxCount; ++var2) {
					var3 = Players.Players_emptyIndices[var2];
					if ((Players.field1236[var3] & 1) != 0) {
						if (var1 > 0) {
							--var1;
							var10000 = Players.field1236;
							var10000[var3] = (byte)(var10000[var3] | 2);
						} else {
							var4 = var0.readBits(1);
							if (var4 == 0) {
								var1 = class80.method2094(var0);
								var10000 = Players.field1236;
								var10000[var3] = (byte)(var10000[var3] | 2);
							} else if (class40.updateExternalPlayer(var0, var3)) {
								var10000 = Players.field1236;
								var10000[var3] = (byte)(var10000[var3] | 2);
							}
						}
					}
				}

				var0.exportIndex();
				if (var1 != 0) {
					throw new RuntimeException();
				} else {
					var0.importIndex();

					for (var2 = 0; var2 < Players.Players_emptyIdxCount; ++var2) {
						var3 = Players.Players_emptyIndices[var2];
						if ((Players.field1236[var3] & 1) == 0) {
							if (var1 > 0) {
								--var1;
								var10000 = Players.field1236;
								var10000[var3] = (byte)(var10000[var3] | 2);
							} else {
								var4 = var0.readBits(1);
								if (var4 == 0) {
									var1 = class80.method2094(var0);
									var10000 = Players.field1236;
									var10000[var3] = (byte)(var10000[var3] | 2);
								} else if (class40.updateExternalPlayer(var0, var3)) {
									var10000 = Players.field1236;
									var10000[var3] = (byte)(var10000[var3] | 2);
								}
							}
						}
					}

					var0.exportIndex();
					if (var1 != 0) {
						throw new RuntimeException();
					} else {
						Players.Players_count = 0;
						Players.Players_emptyIdxCount = 0;

						for (var2 = 1; var2 < 2048; ++var2) {
							var10000 = Players.field1236;
							var10000[var2] = (byte)(var10000[var2] >> 1);
							Player var5 = Client.players[var2];
							if (var5 != null) {
								Players.Players_indices[++Players.Players_count - 1] = var2;
							} else {
								Players.Players_emptyIndices[++Players.Players_emptyIdxCount - 1] = var2;
							}
						}

					}
				}
			}
		}
	}

	@ObfuscatedName("ks")
	@ObfuscatedSignature(
		signature = "(Lhn;I)I",
		garbageValue = "2118498909"
	)
	@Export("getWidgetClickMask")
	static int getWidgetClickMask(Widget var0) {
		IntegerNode var1 = (IntegerNode)Client.widgetClickMasks.get((long)var0.childIndex + ((long)var0.id << 32));
		return var1 != null ? var1.integer : var0.clickMask;
	}
}
