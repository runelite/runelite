import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ip")
@Implements("HealthBarDefinition")
public class HealthBarDefinition extends DualNode {
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lhp;"
	)
	@Export("HealthBarDefinition_archive")
	public static AbstractArchive HealthBarDefinition_archive;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lhp;"
	)
	@Export("HealthBarDefinition_spritesArchive")
	public static AbstractArchive HealthBarDefinition_spritesArchive;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lel;"
	)
	@Export("HealthBarDefinition_cached")
	static EvictingDualNodeHashTable HealthBarDefinition_cached;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lel;"
	)
	@Export("HealthBarDefinition_cachedSprites")
	static EvictingDualNodeHashTable HealthBarDefinition_cachedSprites;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -1770918457
	)
	public int field3279;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 2068006773
	)
	@Export("int1")
	public int int1;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -63517075
	)
	@Export("int2")
	public int int2;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -177821987
	)
	@Export("int3")
	public int int3;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -1811876659
	)
	@Export("int4")
	public int int4;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 1986405241
	)
	@Export("int5")
	public int int5;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -1715225113
	)
	@Export("frontSpriteID")
	int frontSpriteID;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = 124716389
	)
	@Export("backSpriteID")
	int backSpriteID;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 502151103
	)
	@Export("width")
	public int width;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = 485619037
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
		this.int4 = 1;
		this.int5 = 70;
		this.frontSpriteID = -1;
		this.backSpriteID = -1;
		this.width = 30;
		this.widthPadding = 0;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(Lkf;B)V",
		garbageValue = "-11"
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

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(Lkf;IB)V",
		garbageValue = "-62"
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
			this.frontSpriteID = var1.method5511();
		} else if (var2 == 8) {
			this.backSpriteID = var1.method5511();
		} else if (var2 == 11) {
			this.int3 = var1.readUnsignedShort();
		} else if (var2 == 14) {
			this.width = var1.readUnsignedByte();
		} else if (var2 == 15) {
			this.widthPadding = var1.readUnsignedByte();
		}

	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(B)Lly;",
		garbageValue = "39"
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
				var1 = class65.loadSprite(HealthBarDefinition_spritesArchive, this.frontSpriteID, 0);
				if (var1 != null) {
					HealthBarDefinition_cachedSprites.put(var1, (long)this.frontSpriteID);
				}

				return var1;
			}
		}
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(I)Lly;",
		garbageValue = "879066493"
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
				var1 = class65.loadSprite(HealthBarDefinition_spritesArchive, this.backSpriteID, 0);
				if (var1 != null) {
					HealthBarDefinition_cachedSprites.put(var1, (long)this.backSpriteID);
				}

				return var1;
			}
		}
	}
}
