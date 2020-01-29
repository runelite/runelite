import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iy")
@Implements("HealthBarDefinition")
public class HealthBarDefinition extends DualNode {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lii;"
	)
	@Export("HealthBarDefinition_archive")
	public static AbstractArchive HealthBarDefinition_archive;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lii;"
	)
	@Export("HitSplatDefinition_spritesArchive")
	public static AbstractArchive HitSplatDefinition_spritesArchive;
	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "Leh;"
	)
	@Export("HealthBarDefinition_cached")
	public static EvictingDualNodeHashTable HealthBarDefinition_cached;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Leh;"
	)
	@Export("HealthBarDefinition_cachedSprites")
	public static EvictingDualNodeHashTable HealthBarDefinition_cachedSprites;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -1117339079
	)
	public int field3275;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 1485041687
	)
	@Export("int1")
	public int int1;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -1134400629
	)
	@Export("int2")
	public int int2;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 1866957287
	)
	@Export("int3")
	public int int3;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -1867870977
	)
	public int field3283;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = -1689196735
	)
	@Export("int5")
	public int int5;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -69680089
	)
	@Export("frontSpriteID")
	int frontSpriteID;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 2086615621
	)
	@Export("backSpriteID")
	int backSpriteID;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 111327577
	)
	@Export("width")
	public int width;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 1970632159
	)
	@Export("widthPadding")
	public int widthPadding;

	static {
		HealthBarDefinition_cached = new EvictingDualNodeHashTable(64);
		HealthBarDefinition_cachedSprites = new EvictingDualNodeHashTable(64);
	}

	HealthBarDefinition() {
		this.int1 = 255;
		this.int2 = 255;
		this.int3 = -1;
		this.field3283 = 1;
		this.int5 = 70;
		this.frontSpriteID = -1;
		this.backSpriteID = -1;
		this.width = 30;
		this.widthPadding = 0;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Lkp;I)V",
		garbageValue = "-2130379460"
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

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(Lkp;II)V",
		garbageValue = "-1944435606"
	)
	@Export("decodeNext")
	void decodeNext(Buffer var1, int var2) {
		if (var2 == 1) {
			var1.readUnsignedShort();
		} else if (var2 == 2) {
			this.int1 = var1.readUnsignedByte();
		} else if (var2 == 3) {
			this.int2 = var1.readUnsignedByte();
		} else if (var2 == 4) {
			this.int3 = 0;
		} else if (var2 == 5) {
			this.int5 = var1.readUnsignedShort();
		} else if (var2 == 6) {
			var1.readUnsignedByte();
		} else if (var2 == 7) {
			this.frontSpriteID = var1.method5593();
		} else if (var2 == 8) {
			this.backSpriteID = var1.method5593();
		} else if (var2 == 11) {
			this.int3 = var1.readUnsignedShort();
		} else if (var2 == 14) {
			this.width = var1.readUnsignedByte();
		} else if (var2 == 15) {
			this.widthPadding = var1.readUnsignedByte();
		}

	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(B)Llt;",
		garbageValue = "87"
	)
	@Export("getFrontSprite")
	public Sprite getFrontSprite() {
		if (this.frontSpriteID < 0) {
			return null;
		} else {
			Sprite var1 = (Sprite)HealthBarDefinition_cachedSprites.get((long)this.frontSpriteID);
			if (var1 != null) {
				return var1;
			} else {
				var1 = WorldMapSection1.SpriteBuffer_getSprite(HitSplatDefinition_spritesArchive, this.frontSpriteID, 0);
				if (var1 != null) {
					HealthBarDefinition_cachedSprites.put(var1, (long)this.frontSpriteID);
				}

				return var1;
			}
		}
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(B)Llt;",
		garbageValue = "19"
	)
	@Export("getBackSprite")
	public Sprite getBackSprite() {
		if (this.backSpriteID < 0) {
			return null;
		} else {
			Sprite var1 = (Sprite)HealthBarDefinition_cachedSprites.get((long)this.backSpriteID);
			if (var1 != null) {
				return var1;
			} else {
				var1 = WorldMapSection1.SpriteBuffer_getSprite(HitSplatDefinition_spritesArchive, this.backSpriteID, 0);
				if (var1 != null) {
					HealthBarDefinition_cachedSprites.put(var1, (long)this.backSpriteID);
				}

				return var1;
			}
		}
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(IB)Lif;",
		garbageValue = "89"
	)
	@Export("ItemDefinition_get")
	public static ItemDefinition ItemDefinition_get(int var0) {
		ItemDefinition var1 = (ItemDefinition)ItemDefinition.ItemDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = ItemDefinition.ItemDefinition_archive.takeFile(10, var0);
			var1 = new ItemDefinition();
			var1.id = var0;
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			var1.post();
			if (var1.noteTemplate != -1) {
				var1.genCert(ItemDefinition_get(var1.noteTemplate), ItemDefinition_get(var1.note));
			}

			if (var1.notedId != -1) {
				var1.genBought(ItemDefinition_get(var1.notedId), ItemDefinition_get(var1.unnotedId));
			}

			if (var1.placeholderTemplate != -1) {
				var1.genPlaceholder(ItemDefinition_get(var1.placeholderTemplate), ItemDefinition_get(var1.placeholder));
			}

			if (!class298.ItemDefinition_inMembersWorld && var1.isMembersOnly) {
				var1.name = "Members object";
				var1.isTradable = false;
				var1.groundActions = null;
				var1.inventoryActions = null;
				var1.shiftClickIndex = -1;
				var1.team = 0;
				if (var1.params != null) {
					boolean var3 = false;

					for (Node var4 = var1.params.first(); var4 != null; var4 = var1.params.next()) {
						ParamDefinition var5 = PacketBufferNode.getParamDefinition((int)var4.key);
						if (var5.autoDisable) {
							var4.remove();
						} else {
							var3 = true;
						}
					}

					if (!var3) {
						var1.params = null;
					}
				}
			}

			ItemDefinition.ItemDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}
}
