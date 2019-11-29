import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bk")
@Implements("GraphicsObject")
public final class GraphicsObject extends Entity {
	@ObfuscatedName("by")
	@ObfuscatedSignature(
		signature = "[Llm;"
	)
	@Export("worldSelectStars")
	static IndexedSprite[] worldSelectStars;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 816767025
	)
	@Export("id")
	int id;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -1764619827
	)
	@Export("cycleStart")
	int cycleStart;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -356819999
	)
	@Export("plane")
	int plane;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -200533199
	)
	@Export("x")
	int x;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 528585543
	)
	@Export("height")
	int height;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 1230154279
	)
	@Export("y")
	int y;
	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "Liy;"
	)
	@Export("sequenceDefinition")
	SequenceDefinition sequenceDefinition;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = 1295103123
	)
	@Export("frame")
	int frame;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 1745958933
	)
	@Export("frameCycle")
	int frameCycle;
	@ObfuscatedName("i")
	@Export("isFinished")
	boolean isFinished;

	GraphicsObject(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
		this.frame = 0;
		this.frameCycle = 0;
		this.isFinished = false;
		this.id = var1;
		this.plane = var2;
		this.x = var3;
		this.y = var4;
		this.height = var5;
		this.cycleStart = var7 + var6;
		int var8 = WorldMapRegion.SpotAnimationDefinition_get(this.id).sequence;
		if (var8 != -1) {
			this.isFinished = false;
			this.sequenceDefinition = GrandExchangeOfferAgeComparator.SequenceDefinition_get(var8);
		} else {
			this.isFinished = true;
		}

	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "-93"
	)
	@Export("advance")
	final void advance(int var1) {
		if (!this.isFinished) {
			this.frameCycle += var1;

			while (this.frameCycle > this.sequenceDefinition.frameLengths[this.frame]) {
				this.frameCycle -= this.sequenceDefinition.frameLengths[this.frame];
				++this.frame;
				if (this.frame >= this.sequenceDefinition.frameIds.length) {
					this.isFinished = true;
					break;
				}
			}

		}
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(I)Ldf;",
		garbageValue = "-174129419"
	)
	@Export("getModel")
	protected final Model getModel() {
		SpotAnimationDefinition var1 = WorldMapRegion.SpotAnimationDefinition_get(this.id);
		Model var2;
		if (!this.isFinished) {
			var2 = var1.getModel(this.frame);
		} else {
			var2 = var1.getModel(-1);
		}

		return var2 == null ? null : var2;
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(Lkj;I)V",
		garbageValue = "-219604871"
	)
	static final void method2041(PacketBuffer var0) {
		int var1 = 0;
		var0.importIndex();

		byte[] var10000;
		int var2;
		int var3;
		int var4;
		for (var2 = 0; var2 < Players.Players_count; ++var2) {
			var3 = Players.Players_indices[var2];
			if ((Players.field1246[var3] & 1) == 0) {
				if (var1 > 0) {
					--var1;
					var10000 = Players.field1246;
					var10000[var3] = (byte)(var10000[var3] | 2);
				} else {
					var4 = var0.readBits(1);
					if (var4 == 0) {
						var1 = Login.method2124(var0);
						var10000 = Players.field1246;
						var10000[var3] = (byte)(var10000[var3] | 2);
					} else {
						GrandExchangeOfferNameComparator.readPlayerUpdate(var0, var3);
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
				if ((Players.field1246[var3] & 1) != 0) {
					if (var1 > 0) {
						--var1;
						var10000 = Players.field1246;
						var10000[var3] = (byte)(var10000[var3] | 2);
					} else {
						var4 = var0.readBits(1);
						if (var4 == 0) {
							var1 = Login.method2124(var0);
							var10000 = Players.field1246;
							var10000[var3] = (byte)(var10000[var3] | 2);
						} else {
							GrandExchangeOfferNameComparator.readPlayerUpdate(var0, var3);
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
					if ((Players.field1246[var3] & 1) != 0) {
						if (var1 > 0) {
							--var1;
							var10000 = Players.field1246;
							var10000[var3] = (byte)(var10000[var3] | 2);
						} else {
							var4 = var0.readBits(1);
							if (var4 == 0) {
								var1 = Login.method2124(var0);
								var10000 = Players.field1246;
								var10000[var3] = (byte)(var10000[var3] | 2);
							} else if (Client.updateExternalPlayer(var0, var3)) {
								var10000 = Players.field1246;
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
						if ((Players.field1246[var3] & 1) == 0) {
							if (var1 > 0) {
								--var1;
								var10000 = Players.field1246;
								var10000[var3] = (byte)(var10000[var3] | 2);
							} else {
								var4 = var0.readBits(1);
								if (var4 == 0) {
									var1 = Login.method2124(var0);
									var10000 = Players.field1246;
									var10000[var3] = (byte)(var10000[var3] | 2);
								} else if (Client.updateExternalPlayer(var0, var3)) {
									var10000 = Players.field1246;
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
							var10000 = Players.field1246;
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

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;II)Z",
		garbageValue = "1506076524"
	)
	static boolean method2040(String var0, int var1) {
		return class237.method4422(var0, var1, "openjs");
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Lhf;IIB)Z",
		garbageValue = "19"
	)
	public static boolean method2030(AbstractArchive var0, int var1, int var2) {
		byte[] var3 = var0.takeFile(var1, var2);
		if (var3 == null) {
			return false;
		} else {
			Buffer.SpriteBuffer_decode(var3);
			return true;
		}
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1587719078"
	)
	public static void method2039() {
		ObjectDefinition.ObjectDefinition_cached.clear();
		ObjectDefinition.ObjectDefinition_cachedModelData.clear();
		ObjectDefinition.ObjectDefinition_cachedEntities.clear();
		ObjectDefinition.ObjectDefinition_cachedModels.clear();
	}

	@ObfuscatedName("in")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Lhl;S)Ljava/lang/String;",
		garbageValue = "128"
	)
	static String method2036(String var0, Widget var1) {
		if (var0.indexOf("%") != -1) {
			for (int var2 = 1; var2 <= 5; ++var2) {
				while (true) {
					int var3 = var0.indexOf("%" + var2);
					if (var3 == -1) {
						break;
					}

					String var4 = var0.substring(0, var3);
					int var6 = Language.method3719(var1, var2 - 1);
					String var5;
					if (var6 < 999999999) {
						var5 = Integer.toString(var6);
					} else {
						var5 = "*";
					}

					var0 = var4 + var5 + var0.substring(var3 + 2);
				}
			}
		}

		return var0;
	}
}
