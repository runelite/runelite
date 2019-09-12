import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ct")
@Implements("NPC")
public final class NPC extends Actor {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lia;"
	)
	@Export("definition")
	NPCDefinition definition;

	NPC() {
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(IBI)V",
		garbageValue = "-267690393"
	)
	final void method2010(int var1, byte var2) {
		int var3 = super.pathX[0];
		int var4 = super.pathY[0];
		if (var1 == 0) {
			--var3;
			++var4;
		}

		if (var1 == 1) {
			++var4;
		}

		if (var1 == 2) {
			++var3;
			++var4;
		}

		if (var1 == 3) {
			--var3;
		}

		if (var1 == 4) {
			++var3;
		}

		if (var1 == 5) {
			--var3;
			--var4;
		}

		if (var1 == 6) {
			--var4;
		}

		if (var1 == 7) {
			++var3;
			--var4;
		}

		if (super.sequence != -1 && class83.SequenceDefinition_get(super.sequence).field3501 == 1) {
			super.sequence = -1;
		}

		if (super.pathLength < 9) {
			++super.pathLength;
		}

		for (int var5 = super.pathLength; var5 > 0; --var5) {
			super.pathX[var5] = super.pathX[var5 - 1];
			super.pathY[var5] = super.pathY[var5 - 1];
			super.pathTraversed[var5] = super.pathTraversed[var5 - 1];
		}

		super.pathX[0] = var3;
		super.pathY[0] = var4;
		super.pathTraversed[0] = var2;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(IIZB)V",
		garbageValue = "14"
	)
	final void method2011(int var1, int var2, boolean var3) {
		if (super.sequence != -1 && class83.SequenceDefinition_get(super.sequence).field3501 == 1) {
			super.sequence = -1;
		}

		if (!var3) {
			int var4 = var1 - super.pathX[0];
			int var5 = var2 - super.pathY[0];
			if (var4 >= -8 && var4 <= 8 && var5 >= -8 && var5 <= 8) {
				if (super.pathLength < 9) {
					++super.pathLength;
				}

				for (int var6 = super.pathLength; var6 > 0; --var6) {
					super.pathX[var6] = super.pathX[var6 - 1];
					super.pathY[var6] = super.pathY[var6 - 1];
					super.pathTraversed[var6] = super.pathTraversed[var6 - 1];
				}

				super.pathX[0] = var1;
				super.pathY[0] = var2;
				super.pathTraversed[0] = 1;
				return;
			}
		}

		super.pathLength = 0;
		super.field969 = 0;
		super.field975 = 0;
		super.pathX[0] = var1;
		super.pathY[0] = var2;
		super.x = super.size * -294686528 + super.pathX[0] * -589373056;
		super.y = super.size * 64 + super.pathY[0] * 128;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(B)Ldr;",
		garbageValue = "-35"
	)
	@Export("getModel")
	protected final Model getModel() {
		if (this.definition == null) {
			return null;
		} else {
			SequenceDefinition var1 = super.sequence != -1 && super.sequenceDelay == 0 ? class83.SequenceDefinition_get(super.sequence) : null;
			SequenceDefinition var2 = super.movementSequence != -1 && (super.movementSequence != super.readySequence || var1 == null) ? class83.SequenceDefinition_get(super.movementSequence) : null;
			Model var3 = this.definition.getModel(var1, super.sequenceFrame, var2, super.movementFrame);
			if (var3 == null) {
				return null;
			} else {
				var3.calculateBoundsCylinder();
				super.defaultHeight = var3.height;
				if (super.spotAnimation != -1 && super.spotAnimationFrame != -1) {
					Model var4 = NetCache.SpotAnimationDefinition_get(super.spotAnimation).getModel(super.spotAnimationFrame);
					if (var4 != null) {
						var4.offsetBy(0, -super.heightOffset, 0);
						Model[] var5 = new Model[]{var3, var4};
						var3 = new Model(var5, 2);
					}
				}

				if (this.definition.size == 1) {
					var3.isSingleTile = true;
				}

				return var3;
			}
		}
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "93"
	)
	@Export("isVisible")
	final boolean isVisible() {
		return this.definition != null;
	}

	@ObfuscatedName("gv")
	@ObfuscatedSignature(
		signature = "(IIIB)V",
		garbageValue = "116"
	)
	@Export("worldToScreen")
	static final void worldToScreen(int var0, int var1, int var2) {
		if (var0 >= 128 && var1 >= 128 && var0 <= 13056 && var1 <= 13056) {
			int var3 = WorldMapAreaData.getTileHeight(var0, var1, MouseRecorder.plane) - var2;
			var0 -= ScriptFrame.cameraX;
			var3 -= GrandExchangeOfferTotalQuantityComparator.cameraY;
			var1 -= class14.cameraZ;
			int var4 = Rasterizer3D.Rasterizer3D_sine[class319.cameraPitch];
			int var5 = Rasterizer3D.Rasterizer3D_cosine[class319.cameraPitch];
			int var6 = Rasterizer3D.Rasterizer3D_sine[Tile.cameraYaw];
			int var7 = Rasterizer3D.Rasterizer3D_cosine[Tile.cameraYaw];
			int var8 = var6 * var1 + var0 * var7 >> 16;
			var1 = var7 * var1 - var0 * var6 >> 16;
			var0 = var8;
			var8 = var3 * var5 - var4 * var1 >> 16;
			var1 = var5 * var1 + var4 * var3 >> 16;
			if (var1 >= 50) {
				Client.viewportTempX = var0 * Client.viewportZoom / var1 + Client.viewportWidth / 2;
				Client.viewportTempY = var8 * Client.viewportZoom / var1 + Client.viewportHeight / 2;
			} else {
				Client.viewportTempX = -1;
				Client.viewportTempY = -1;
			}

		} else {
			Client.viewportTempX = -1;
			Client.viewportTempY = -1;
		}
	}
}
