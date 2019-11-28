import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cu")
@Implements("DynamicObject")
public class DynamicObject extends Entity {
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lbv;"
	)
	@Export("loginScreenRunesAnimation")
	static LoginScreenAnimation loginScreenRunesAnimation;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -679887147
	)
	@Export("id")
	int id;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = 431933847
	)
	@Export("type")
	int type;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -68495843
	)
	@Export("orientation")
	int orientation;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -1644974197
	)
	@Export("plane")
	int plane;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 707207003
	)
	@Export("x")
	int x;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -1196896887
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
		intValue = 672363513
	)
	@Export("frame")
	int frame;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 1683729561
	)
	@Export("cycleStart")
	int cycleStart;

	@ObfuscatedSignature(
		signature = "(IIIIIIIZLee;)V"
	)
	DynamicObject(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, Entity var9) {
		this.id = var1;
		this.type = var2;
		this.orientation = var3;
		this.plane = var4;
		this.x = var5;
		this.y = var6;
		if (var7 != -1) {
			this.sequenceDefinition = GrandExchangeOfferAgeComparator.SequenceDefinition_get(var7);
			this.frame = 0;
			this.cycleStart = Client.cycle - 1;
			if (this.sequenceDefinition.field3533 == 0 && var9 != null && var9 instanceof DynamicObject) {
				DynamicObject var10 = (DynamicObject)var9;
				if (var10.sequenceDefinition == this.sequenceDefinition) {
					this.frame = var10.frame;
					this.cycleStart = var10.cycleStart;
					return;
				}
			}

			if (var8 && this.sequenceDefinition.frameCount != -1) {
				this.frame = (int)(Math.random() * (double)this.sequenceDefinition.frameIds.length);
				this.cycleStart -= (int)(Math.random() * (double)this.sequenceDefinition.frameLengths[this.frame]);
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
		if (this.sequenceDefinition != null) {
			int var1 = Client.cycle - this.cycleStart;
			if (var1 > 100 && this.sequenceDefinition.frameCount > 0) {
				var1 = 100;
			}

			label56: {
				do {
					do {
						if (var1 <= this.sequenceDefinition.frameLengths[this.frame]) {
							break label56;
						}

						var1 -= this.sequenceDefinition.frameLengths[this.frame];
						++this.frame;
					} while(this.frame < this.sequenceDefinition.frameIds.length);

					this.frame -= this.sequenceDefinition.frameCount;
				} while(this.frame >= 0 && this.frame < this.sequenceDefinition.frameIds.length);

				this.sequenceDefinition = null;
			}

			this.cycleStart = Client.cycle - var1;
		}

		ObjectDefinition var12 = Occluder.getObjectDefinition(this.id);
		if (var12.transforms != null) {
			var12 = var12.transform();
		}

		if (var12 == null) {
			return null;
		} else {
			int var2;
			int var3;
			if (this.orientation != 1 && this.orientation != 3) {
				var2 = var12.sizeX;
				var3 = var12.sizeY;
			} else {
				var2 = var12.sizeY;
				var3 = var12.sizeX;
			}

			int var4 = (var2 >> 1) + this.x;
			int var5 = (var2 + 1 >> 1) + this.x;
			int var6 = (var3 >> 1) + this.y;
			int var7 = (var3 + 1 >> 1) + this.y;
			int[][] var8 = Tiles.Tiles_heights[this.plane];
			int var9 = var8[var5][var7] + var8[var5][var6] + var8[var4][var6] + var8[var4][var7] >> 2;
			int var10 = (this.x << 7) + (var2 << 6);
			int var11 = (this.y << 7) + (var3 << 6);
			return var12.getModelDynamic(this.type, this.orientation, var8, var10, var9, var11, this.sequenceDefinition, this.frame);
		}
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "1357680514"
	)
	public static void method2263(int var0) {
		if (var0 != -1) {
			if (Widget.Widget_loadedInterfaces[var0]) {
				InvDefinition.Widget_archive.clearFilesGroup(var0);
				if (FloorDecoration.Widget_interfaceComponents[var0] != null) {
					boolean var1 = true;

					for (int var2 = 0; var2 < FloorDecoration.Widget_interfaceComponents[var0].length; ++var2) {
						if (FloorDecoration.Widget_interfaceComponents[var0][var2] != null) {
							if (FloorDecoration.Widget_interfaceComponents[var0][var2].type != 2) {
								FloorDecoration.Widget_interfaceComponents[var0][var2] = null;
							} else {
								var1 = false;
							}
						}
					}

					if (var1) {
						FloorDecoration.Widget_interfaceComponents[var0] = null;
					}

					Widget.Widget_loadedInterfaces[var0] = false;
				}
			}
		}
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "514266465"
	)
	public static void method2259() {
		KitDefinition.KitDefinition_cached.clear();
	}

	@ObfuscatedName("hw")
	@ObfuscatedSignature(
		signature = "(ZLkj;B)V",
		garbageValue = "4"
	)
	static final void method2262(boolean var0, PacketBuffer var1) {
		while (true) {
			if (var1.bitsRemaining(Client.packetWriter.serverPacketLength) >= 27) {
				int var2 = var1.readBits(15);
				if (var2 != 32767) {
					boolean var3 = false;
					if (Client.npcs[var2] == null) {
						Client.npcs[var2] = new NPC();
						var3 = true;
					}

					NPC var4 = Client.npcs[var2];
					Client.npcIndices[++Client.npcCount - 1] = var2;
					var4.npcCycle = Client.cycle;
					int var5 = Client.defaultRotations[var1.readBits(3)];
					if (var3) {
						var4.orientation = var4.rotation = var5;
					}

					int var6 = var1.readBits(1);
					var4.definition = VarcInt.getNpcDefinition(var1.readBits(14));
					int var7;
					if (var0) {
						var7 = var1.readBits(8);
						if (var7 > 127) {
							var7 -= 256;
						}
					} else {
						var7 = var1.readBits(5);
						if (var7 > 15) {
							var7 -= 32;
						}
					}

					int var8;
					if (var0) {
						var8 = var1.readBits(8);
						if (var8 > 127) {
							var8 -= 256;
						}
					} else {
						var8 = var1.readBits(5);
						if (var8 > 15) {
							var8 -= 32;
						}
					}

					int var9 = var1.readBits(1);
					if (var9 == 1) {
						Client.field688[++Client.field687 - 1] = var2;
					}

					var4.field938 = var4.definition.size;
					var4.field988 = var4.definition.rotation;
					if (var4.field988 == 0) {
						var4.rotation = 0;
					}

					var4.walkSequence = var4.definition.walkSequence;
					var4.walkBackSequence = var4.definition.walkBackSequence;
					var4.walkLeftSequence = var4.definition.walkLeftSequence;
					var4.walkRightSequence = var4.definition.walkRightSequence;
					var4.readySequence = var4.definition.readySequence;
					var4.turnLeftSequence = var4.definition.turnLeftSequence;
					var4.turnRightSequence = var4.definition.turnRightSequence;
					var4.method2059(class215.localPlayer.pathX[0] + var7, class215.localPlayer.pathY[0] + var8, var6 == 1);
					continue;
				}
			}

			var1.exportIndex();
			return;
		}
	}
}
