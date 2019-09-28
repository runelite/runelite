import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ip")
@Implements("HealthBarDefinition")
public class HealthBarDefinition extends DualNode {
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Lhp;"
	)
	@Export("HealthBarDefinition_archive")
	public static AbstractArchive HealthBarDefinition_archive;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lhp;"
	)
	@Export("HitSplatDefinition_spritesArchive")
	static AbstractArchive HitSplatDefinition_spritesArchive;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lem;"
	)
	@Export("HealthBarDefinition_cached")
	public static EvictingDualNodeHashTable HealthBarDefinition_cached;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lem;"
	)
	@Export("HealthBarDefinition_cachedSprites")
	public static EvictingDualNodeHashTable HealthBarDefinition_cachedSprites;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = -2020710967
	)
	public int field3258;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 2073172143
	)
	@Export("int1")
	public int int1;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = 1672807375
	)
	@Export("int2")
	public int int2;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -1245763213
	)
	@Export("int3")
	public int int3;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 1160994935
	)
	@Export("int4")
	public int int4;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -2056406209
	)
	@Export("int5")
	public int int5;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = -1546985657
	)
	@Export("frontSpriteID")
	int frontSpriteID;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = -1484247529
	)
	@Export("backSpriteID")
	int backSpriteID;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 2061624127
	)
	@Export("width")
	public int width;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 1482399655
	)
	@Export("widthPadding")
	public int widthPadding;

	static {
		HealthBarDefinition_cached = new EvictingDualNodeHashTable(64);
		HealthBarDefinition_cachedSprites = new EvictingDualNodeHashTable(64);
	}

	public HealthBarDefinition() {
		this.int1 = 255;
		this.int2 = 255;
		this.int3 = -1;
		this.int4 = 1;
		this.int5 = 70;
		this.frontSpriteID = -1;
		this.backSpriteID = -1;
		this.width = 30;
		this.widthPadding = 0;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(Lkl;I)V",
		garbageValue = "-1504288957"
	)
	@Export("decode")
	public void decode(Buffer var1) {
		while (true) {
			int var2 = var1.readUnsignedByte();
			if (var2 == 0) {
				return;
			}

			this.decodeNext(var1, var2);
		}
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(Lkl;IB)V",
		garbageValue = "2"
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
			this.frontSpriteID = var1.method5453();
		} else if (var2 == 8) {
			this.backSpriteID = var1.method5453();
		} else if (var2 == 11) {
			this.int3 = var1.readUnsignedShort();
		} else if (var2 == 14) {
			this.width = var1.readUnsignedByte();
		} else if (var2 == 15) {
			this.widthPadding = var1.readUnsignedByte();
		}

	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(I)Llf;",
		garbageValue = "445043084"
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
				var1 = NPCDefinition.SpriteBuffer_getSprite(HitSplatDefinition_spritesArchive, this.frontSpriteID, 0);
				if (var1 != null) {
					HealthBarDefinition_cachedSprites.put(var1, (long)this.frontSpriteID);
				}

				return var1;
			}
		}
	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(B)Llf;",
		garbageValue = "-62"
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
				var1 = NPCDefinition.SpriteBuffer_getSprite(HitSplatDefinition_spritesArchive, this.backSpriteID, 0);
				if (var1 != null) {
					HealthBarDefinition_cachedSprites.put(var1, (long)this.backSpriteID);
				}

				return var1;
			}
		}
	}
}
