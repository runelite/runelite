import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cl")
@Implements("DynamicObject")
public class DynamicObject extends Entity {
	@ObfuscatedName("at")
	static String field1268;
	@ObfuscatedName("ha")
	@ObfuscatedGetter(
		intValue = -775717141
	)
	@Export("oculusOrbFocalPointX")
	static int oculusOrbFocalPointX;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = -760390045
	)
	@Export("id")
	int id;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -980932459
	)
	@Export("type")
	int type;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -400059677
	)
	@Export("orientation")
	int orientation;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 1290123367
	)
	@Export("plane")
	int plane;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -508815789
	)
	@Export("x")
	int x;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -490638225
	)
	@Export("y")
	int y;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lij;"
	)
	@Export("sequenceDefinition")
	SequenceDefinition sequenceDefinition;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 156262843
	)
	@Export("frame")
	int frame;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 1843823299
	)
	@Export("cycleStart")
	int cycleStart;

	@ObfuscatedSignature(
		signature = "(IIIIIIIZLen;)V"
	)
	DynamicObject(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, Entity var9) {
		this.id = var1;
		this.type = var2;
		this.orientation = var3;
		this.plane = var4;
		this.x = var5;
		this.y = var6;
		if (var7 != -1) {
			this.sequenceDefinition = Widget.SequenceDefinition_get(var7);
			this.frame = 0;
			this.cycleStart = Client.cycle - 1;
			if (this.sequenceDefinition.field3492 == 0 && var9 != null && var9 instanceof DynamicObject) {
				DynamicObject var10 = (DynamicObject)var9;
				if (this.sequenceDefinition == var10.sequenceDefinition) {
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

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)Ldo;",
		garbageValue = "-419920513"
	)
	@Export("getModel")
	protected final Model getModel() {
		if (this.sequenceDefinition != null) {
			int var1 = Client.cycle - this.cycleStart;
			if (var1 > 100 && this.sequenceDefinition.frameCount > 0) {
				var1 = 100;
			}

			label55: {
				do {
					do {
						if (var1 <= this.sequenceDefinition.frameLengths[this.frame]) {
							break label55;
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

		ObjectDefinition var12 = class215.getObjectDefinition(this.id);
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
			int var9 = var8[var5][var6] + var8[var4][var6] + var8[var4][var7] + var8[var5][var7] >> 2;
			int var10 = (this.x << 7) + (var2 << 6);
			int var11 = (this.y << 7) + (var3 << 6);
			return var12.getModelDynamic(this.type, this.orientation, var8, var10, var9, var11, this.sequenceDefinition, this.frame);
		}
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(Lky;Lln;I)Lln;",
		garbageValue = "796089456"
	)
	@Export("readStringIntParameters")
	static final IterableNodeHashTable readStringIntParameters(Buffer var0, IterableNodeHashTable var1) {
		int var2 = var0.readUnsignedByte();
		int var3;
		if (var1 == null) {
			int var4 = var2 - 1;
			var4 |= var4 >>> 1;
			var4 |= var4 >>> 2;
			var4 |= var4 >>> 4;
			var4 |= var4 >>> 8;
			var4 |= var4 >>> 16;
			var3 = var4 + 1;
			var1 = new IterableNodeHashTable(var3);
		}

		for (var3 = 0; var3 < var2; ++var3) {
			boolean var7 = var0.readUnsignedByte() == 1;
			int var5 = var0.readMedium();
			Object var6;
			if (var7) {
				var6 = new ObjectNode(var0.readStringCp1252NullTerminated());
			} else {
				var6 = new IntegerNode(var0.readInt());
			}

			var1.put((Node)var6, (long)var5);
		}

		return var1;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-513328656"
	)
	static void method2153() {
		if (Login.field1146) {
			Login.titleboxSprite = null;
			Login.titlebuttonSprite = null;
			ItemDefinition.runesSprite = null;
			Login.leftTitleSprite = null;
			Login.rightTitleSprite = null;
			class51.logoSprite = null;
			BoundaryObject.title_muteSprite = null;
			Login.options_buttons_0Sprite = null;
			Login.options_buttons_2Sprite = null;
			SoundCache.worldSelectBackSprites = null;
			class1.worldSelectFlagSprites = null;
			Decimator.worldSelectArrows = null;
			NetFileRequest.worldSelectStars = null;
			class195.field2368 = null;
			Bounds.loginScreenRunesAnimation.method1731();
			DevicePcmPlayerProvider.method793(2);
			NPC.method1977(true);
			Login.field1146 = false;
		}
	}

	@ObfuscatedName("jz")
	@ObfuscatedSignature(
		signature = "(Lhp;Liu;IIZB)V",
		garbageValue = "41"
	)
	@Export("addWidgetItemMenuItem")
	static final void addWidgetItemMenuItem(Widget var0, ItemDefinition var1, int var2, int var3, boolean var4) {
		String[] var5 = var1.inventoryActions;
		byte var6 = -1;
		String var7 = null;
		if (var5 != null && var5[var3] != null) {
			if (var3 == 0) {
				var6 = 33;
			} else if (var3 == 1) {
				var6 = 34;
			} else if (var3 == 2) {
				var6 = 35;
			} else if (var3 == 3) {
				var6 = 36;
			} else {
				var6 = 37;
			}

			var7 = var5[var3];
		} else if (var3 == 4) {
			var6 = 37;
			var7 = "Drop";
		}

		if (var6 != -1 && var7 != null) {
			NetCache.insertMenuItem(var7, class16.colorStartTag(16748608) + var1.name, var6, var1.id, var2, var0.id, var4);
		}

	}
}
