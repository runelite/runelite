import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ig")
@Implements("HealthBarDefinition")
public class HealthBarDefinition extends DualNode {
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "Lhz;"
	)
	@Export("HealthBarDefinition_archive")
	public static AbstractArchive HealthBarDefinition_archive;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Lhz;"
	)
	@Export("HealthBarDefinition_spritesArchive")
	public static AbstractArchive HealthBarDefinition_spritesArchive;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lep;"
	)
	@Export("HealthBarDefinition_cached")
	static EvictingDualNodeHashTable HealthBarDefinition_cached;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lep;"
	)
	@Export("HealthBarDefinition_cachedSprites")
	static EvictingDualNodeHashTable HealthBarDefinition_cachedSprites;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -1504637567
	)
	public int field3264;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -1807788243
	)
	@Export("int1")
	public int int1;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 1909708279
	)
	@Export("int2")
	public int int2;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -1885853349
	)
	@Export("int3")
	public int int3;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -563818397
	)
	@Export("int4")
	public int int4;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -74768593
	)
	@Export("int5")
	public int int5;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = -1506111747
	)
	@Export("frontSpriteID")
	int frontSpriteID;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = -1208608669
	)
	@Export("backSpriteID")
	int backSpriteID;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -567354113
	)
	@Export("width")
	public int width;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = 1929001923
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

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(Lky;I)V",
		garbageValue = "-2108312426"
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

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(Lky;II)V",
		garbageValue = "1232956083"
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
			this.frontSpriteID = var1.method5602();
		} else if (var2 == 8) {
			this.backSpriteID = var1.method5602();
		} else if (var2 == 11) {
			this.int3 = var1.readUnsignedShort();
		} else if (var2 == 14) {
			this.width = var1.readUnsignedByte();
		} else if (var2 == 15) {
			this.widthPadding = var1.readUnsignedByte();
		}

	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(I)Lls;",
		garbageValue = "32246110"
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
				var1 = TilePaint.SpriteBuffer_getSprite(HealthBarDefinition_spritesArchive, this.frontSpriteID, 0);
				if (var1 != null) {
					HealthBarDefinition_cachedSprites.put(var1, (long)this.frontSpriteID);
				}

				return var1;
			}
		}
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(I)Lls;",
		garbageValue = "2113280722"
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
				var1 = TilePaint.SpriteBuffer_getSprite(HealthBarDefinition_spritesArchive, this.backSpriteID, 0);
				if (var1 != null) {
					HealthBarDefinition_cachedSprites.put(var1, (long)this.backSpriteID);
				}

				return var1;
			}
		}
	}
}
