import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ix")
@Implements("HitSplatDefinition")
public class HitSplatDefinition extends DualNode {
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lhf;"
	)
	@Export("HitSplatDefinition_archive")
	public static AbstractArchive HitSplatDefinition_archive;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lhf;"
	)
	public static AbstractArchive field3328;
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Lhf;"
	)
	@Export("HitSplatDefinition_fontsArchive")
	public static AbstractArchive HitSplatDefinition_fontsArchive;
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Lef;"
	)
	@Export("HitSplatDefinition_cached")
	public static EvictingDualNodeHashTable HitSplatDefinition_cached;
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Lef;"
	)
	@Export("HitSplatDefinition_cachedSprites")
	public static EvictingDualNodeHashTable HitSplatDefinition_cachedSprites;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lef;"
	)
	@Export("HitSplatDefinition_cachedFonts")
	public static EvictingDualNodeHashTable HitSplatDefinition_cachedFonts;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 1295461739
	)
	@Export("fontId")
	int fontId;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = 963128035
	)
	@Export("textColor")
	public int textColor;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -1733975883
	)
	public int field3338;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 195481813
	)
	int field3351;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = -1766289865
	)
	int field3340;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -2096395153
	)
	int field3341;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = -994685313
	)
	int field3349;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 634586915
	)
	public int field3343;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = 139308797
	)
	public int field3327;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -1876635353
	)
	public int field3348;
	@ObfuscatedName("m")
	String field3346;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -779748361
	)
	public int field3347;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 1251989255
	)
	public int field3333;
	@ObfuscatedName("l")
	@Export("transforms")
	public int[] transforms;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -1418037543
	)
	@Export("transformVarbit")
	int transformVarbit;
	@ObfuscatedName("af")
	@ObfuscatedGetter(
		intValue = -1584841553
	)
	@Export("transformVarp")
	int transformVarp;

	static {
		HitSplatDefinition_cached = new EvictingDualNodeHashTable(64);
		HitSplatDefinition_cachedSprites = new EvictingDualNodeHashTable(64);
		HitSplatDefinition_cachedFonts = new EvictingDualNodeHashTable(20);
	}

	public HitSplatDefinition() {
		this.fontId = -1;
		this.textColor = 16777215;
		this.field3338 = 70;
		this.field3351 = -1;
		this.field3340 = -1;
		this.field3341 = -1;
		this.field3349 = -1;
		this.field3343 = 0;
		this.field3327 = 0;
		this.field3348 = -1;
		this.field3346 = "";
		this.field3347 = -1;
		this.field3333 = 0;
		this.transformVarbit = -1;
		this.transformVarp = -1;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(Lkg;B)V",
		garbageValue = "87"
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

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(Lkg;II)V",
		garbageValue = "1254085068"
	)
	@Export("decodeNext")
	void decodeNext(Buffer var1, int var2) {
		if (var2 == 1) {
			this.fontId = var1.method5618();
		} else if (var2 == 2) {
			this.textColor = var1.readMedium();
		} else if (var2 == 3) {
			this.field3351 = var1.method5618();
		} else if (var2 == 4) {
			this.field3341 = var1.method5618();
		} else if (var2 == 5) {
			this.field3340 = var1.method5618();
		} else if (var2 == 6) {
			this.field3349 = var1.method5618();
		} else if (var2 == 7) {
			this.field3343 = var1.readShort();
		} else if (var2 == 8) {
			this.field3346 = var1.readStringCp1252NullCircumfixed();
		} else if (var2 == 9) {
			this.field3338 = var1.readUnsignedShort();
		} else if (var2 == 10) {
			this.field3327 = var1.readShort();
		} else if (var2 == 11) {
			this.field3348 = 0;
		} else if (var2 == 12) {
			this.field3347 = var1.readUnsignedByte();
		} else if (var2 == 13) {
			this.field3333 = var1.readShort();
		} else if (var2 == 14) {
			this.field3348 = var1.readUnsignedShort();
		} else if (var2 == 17 || var2 == 18) {
			this.transformVarbit = var1.readUnsignedShort();
			if (this.transformVarbit == 65535) {
				this.transformVarbit = -1;
			}

			this.transformVarp = var1.readUnsignedShort();
			if (this.transformVarp == 65535) {
				this.transformVarp = -1;
			}

			int var3 = -1;
			if (var2 == 18) {
				var3 = var1.readUnsignedShort();
				if (var3 == 65535) {
					var3 = -1;
				}
			}

			int var4 = var1.readUnsignedByte();
			this.transforms = new int[var4 + 2];

			for (int var5 = 0; var5 <= var4; ++var5) {
				this.transforms[var5] = var1.readUnsignedShort();
				if (this.transforms[var5] == 65535) {
					this.transforms[var5] = -1;
				}
			}

			this.transforms[var4 + 1] = var3;
		}

	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(I)Lix;",
		garbageValue = "938920807"
	)
	@Export("transform")
	public final HitSplatDefinition transform() {
		int var1 = -1;
		if (this.transformVarbit != -1) {
			var1 = FileSystem.getVarbit(this.transformVarbit);
		} else if (this.transformVarp != -1) {
			var1 = Varps.Varps_main[this.transformVarp];
		}

		int var2;
		if (var1 >= 0 && var1 < this.transforms.length - 1) {
			var2 = this.transforms[var1];
		} else {
			var2 = this.transforms[this.transforms.length - 1];
		}

		if (var2 != -1) {
			HitSplatDefinition var4 = (HitSplatDefinition)HitSplatDefinition_cached.get((long)var2);
			HitSplatDefinition var3;
			if (var4 != null) {
				var3 = var4;
			} else {
				byte[] var5 = HitSplatDefinition_archive.takeFile(32, var2);
				var4 = new HitSplatDefinition();
				if (var5 != null) {
					var4.decode(new Buffer(var5));
				}

				HitSplatDefinition_cached.put(var4, (long)var2);
				var3 = var4;
			}

			return var3;
		} else {
			return null;
		}
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(II)Ljava/lang/String;",
		garbageValue = "-1476211586"
	)
	@Export("getString")
	public String getString(int var1) {
		String var2 = this.field3346;

		while (true) {
			int var3 = var2.indexOf("%1");
			if (var3 < 0) {
				return var2;
			}

			var2 = var2.substring(0, var3) + VarbitDefinition.intToString(var1, false) + var2.substring(var3 + 2);
		}
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(I)Lln;",
		garbageValue = "138954957"
	)
	public Sprite method4662() {
		if (this.field3351 < 0) {
			return null;
		} else {
			Sprite var1 = (Sprite)HitSplatDefinition_cachedSprites.get((long)this.field3351);
			if (var1 != null) {
				return var1;
			} else {
				var1 = class288.SpriteBuffer_getSprite(field3328, this.field3351, 0);
				if (var1 != null) {
					HitSplatDefinition_cachedSprites.put(var1, (long)this.field3351);
				}

				return var1;
			}
		}
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(I)Lln;",
		garbageValue = "-1751554235"
	)
	public Sprite method4663() {
		if (this.field3340 < 0) {
			return null;
		} else {
			Sprite var1 = (Sprite)HitSplatDefinition_cachedSprites.get((long)this.field3340);
			if (var1 != null) {
				return var1;
			} else {
				var1 = class288.SpriteBuffer_getSprite(field3328, this.field3340, 0);
				if (var1 != null) {
					HitSplatDefinition_cachedSprites.put(var1, (long)this.field3340);
				}

				return var1;
			}
		}
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(I)Lln;",
		garbageValue = "243869561"
	)
	public Sprite method4671() {
		if (this.field3341 < 0) {
			return null;
		} else {
			Sprite var1 = (Sprite)HitSplatDefinition_cachedSprites.get((long)this.field3341);
			if (var1 != null) {
				return var1;
			} else {
				var1 = class288.SpriteBuffer_getSprite(field3328, this.field3341, 0);
				if (var1 != null) {
					HitSplatDefinition_cachedSprites.put(var1, (long)this.field3341);
				}

				return var1;
			}
		}
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(B)Lln;",
		garbageValue = "20"
	)
	public Sprite method4657() {
		if (this.field3349 < 0) {
			return null;
		} else {
			Sprite var1 = (Sprite)HitSplatDefinition_cachedSprites.get((long)this.field3349);
			if (var1 != null) {
				return var1;
			} else {
				var1 = class288.SpriteBuffer_getSprite(field3328, this.field3349, 0);
				if (var1 != null) {
					HitSplatDefinition_cachedSprites.put(var1, (long)this.field3349);
				}

				return var1;
			}
		}
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(I)Lky;",
		garbageValue = "-816521399"
	)
	@Export("getFont")
	public Font getFont() {
		if (this.fontId == -1) {
			return null;
		} else {
			Font var1 = (Font)HitSplatDefinition_cachedFonts.get((long)this.fontId);
			if (var1 != null) {
				return var1;
			} else {
				var1 = class60.method1195(field3328, HitSplatDefinition_fontsArchive, this.fontId, 0);
				if (var1 != null) {
					HitSplatDefinition_cachedFonts.put(var1, (long)this.fontId);
				}

				return var1;
			}
		}
	}
}
