import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cf")
@Implements("NPC")
public final class NPC extends Actor {
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lly;"
	)
	@Export("rightTitleSprite")
	static Sprite rightTitleSprite;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lij;"
	)
	@Export("definition")
	NPCDefinition definition;

	NPC() {
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(IBI)V",
		garbageValue = "1156693210"
	)
	final void method1974(int var1, byte var2) {
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

		if (super.sequence != -1 && GrandExchangeEvent.getSequenceDefinition(super.sequence).field3532 == 1) {
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

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(IIZS)V",
		garbageValue = "128"
	)
	final void method1963(int var1, int var2, boolean var3) {
		if (super.sequence != -1 && GrandExchangeEvent.getSequenceDefinition(super.sequence).field3532 == 1) {
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
		super.field1008 = 0;
		super.field1007 = 0;
		super.pathX[0] = var1;
		super.pathY[0] = var2;
		super.x = super.size * -1342954560 + super.pathX[0] * 128;
		super.y = super.pathY[0] * 128 + super.size * -1342954560;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)Ldm;",
		garbageValue = "759381421"
	)
	@Export("getModel")
	protected final Model getModel() {
		if (this.definition == null) {
			return null;
		} else {
			SequenceDefinition var1 = super.sequence != -1 && super.sequenceDelay == 0 ? GrandExchangeEvent.getSequenceDefinition(super.sequence) : null;
			SequenceDefinition var2 = super.movementSequence != -1 && (super.readySequence != super.movementSequence || var1 == null) ? GrandExchangeEvent.getSequenceDefinition(super.movementSequence) : null;
			Model var3 = this.definition.getModel(var1, super.sequenceFrame, var2, super.movementFrame);
			if (var3 == null) {
				return null;
			} else {
				var3.calculateBoundsCylinder();
				super.defaultHeight = var3.height;
				if (super.spotAnimation != -1 && super.spotAnimationFrame != -1) {
					Model var4 = MusicPatch.getSpotAnimationDefinition(super.spotAnimation).getModel(super.spotAnimationFrame);
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

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-1461786701"
	)
	@Export("isVisible")
	final boolean isVisible() {
		return this.definition != null;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(ILcx;ZI)I",
		garbageValue = "-1435183788"
	)
	static int method1977(int var0, Script var1, boolean var2) {
		if (var0 < 1000) {
			return Skeleton.method3064(var0, var1, var2);
		} else if (var0 < 1100) {
			return ModelData0.method3250(var0, var1, var2);
		} else if (var0 < 1200) {
			return class83.method1994(var0, var1, var2);
		} else if (var0 < 1300) {
			return WorldMapDecoration.method324(var0, var1, var2);
		} else if (var0 < 1400) {
			return UserComparator9.method3389(var0, var1, var2);
		} else if (var0 < 1500) {
			return GraphicsObject.method1943(var0, var1, var2);
		} else if (var0 < 1600) {
			return GrandExchangeOfferAgeComparator.method147(var0, var1, var2);
		} else if (var0 < 1700) {
			return MenuAction.method1992(var0, var1, var2);
		} else if (var0 < 1800) {
			return class169.method3501(var0, var1, var2);
		} else if (var0 < 1900) {
			return StudioGame.method4137(var0, var1, var2);
		} else if (var0 < 2000) {
			return ArchiveLoader.method1100(var0, var1, var2);
		} else if (var0 < 2100) {
			return ModelData0.method3250(var0, var1, var2);
		} else if (var0 < 2200) {
			return class83.method1994(var0, var1, var2);
		} else if (var0 < 2300) {
			return WorldMapDecoration.method324(var0, var1, var2);
		} else if (var0 < 2400) {
			return UserComparator9.method3389(var0, var1, var2);
		} else if (var0 < 2500) {
			return GraphicsObject.method1943(var0, var1, var2);
		} else if (var0 < 2600) {
			return ScriptEvent.method1127(var0, var1, var2);
		} else if (var0 < 2700) {
			return TextureProvider.method2743(var0, var1, var2);
		} else if (var0 < 2800) {
			return UrlRequester.method3306(var0, var1, var2);
		} else if (var0 < 2900) {
			return FloorUnderlayDefinition.method4433(var0, var1, var2);
		} else if (var0 < 3000) {
			return ArchiveLoader.method1100(var0, var1, var2);
		} else if (var0 < 3200) {
			return class30.method536(var0, var1, var2);
		} else if (var0 < 3300) {
			return AbstractArchive.method4172(var0, var1, var2);
		} else if (var0 < 3400) {
			return WorldMapID.method540(var0, var1, var2);
		} else if (var0 < 3500) {
			return class65.method1175(var0, var1, var2);
		} else if (var0 < 3700) {
			return class30.method535(var0, var1, var2);
		} else if (var0 < 4000) {
			return FriendSystem.method1817(var0, var1, var2);
		} else if (var0 < 4100) {
			return EnumDefinition.method4532(var0, var1, var2);
		} else if (var0 < 4200) {
			return class208.method3941(var0, var1, var2);
		} else if (var0 < 4300) {
			return FontName.method5316(var0, var1, var2);
		} else if (var0 < 5100) {
			return ClientPreferences.method1753(var0, var1, var2);
		} else if (var0 < 5400) {
			return UserComparator6.method3436(var0, var1, var2);
		} else if (var0 < 5600) {
			return WorldMapSectionType.method239(var0, var1, var2);
		} else if (var0 < 5700) {
			return WorldMapData_1.method696(var0, var1, var2);
		} else if (var0 < 6300) {
			return WorldMapSectionType.method242(var0, var1, var2);
		} else if (var0 < 6600) {
			return class197.method3703(var0, var1, var2);
		} else {
			return var0 < 6700 ? GrandExchangeOffer.method114(var0, var1, var2) : 2;
		}
	}
}
