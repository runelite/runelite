import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ii")
@Implements("HitSplatDefinition")
public class HitSplatDefinition extends DualNode {
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "Lhq;"
	)
	@Export("HitSplatDefinition_archive")
	static AbstractArchive HitSplatDefinition_archive;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lhq;"
	)
	static AbstractArchive field3316;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Leb;"
	)
	@Export("HitSplatDefinition_cached")
	public static EvictingDualNodeHashTable HitSplatDefinition_cached;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Leb;"
	)
	@Export("HitSplatDefinition_cachedSprites")
	public static EvictingDualNodeHashTable HitSplatDefinition_cachedSprites;
	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "Leb;"
	)
	@Export("HitSplatDefinition_cachedFonts")
	public static EvictingDualNodeHashTable HitSplatDefinition_cachedFonts;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 941598511
	)
	@Export("fontId")
	int fontId;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = -697129173
	)
	@Export("textColor")
	public int textColor;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 2098099547
	)
	public int field3314;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 1587744329
	)
	int field3321;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -559813503
	)
	int field3320;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = 1664346501
	)
	int field3323;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -798419301
	)
	int field3325;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = 1377626099
	)
	public int field3329;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -1078350425
	)
	public int field3315;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -328060003
	)
	public int field3327;
	@ObfuscatedName("f")
	String field3328;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 1213073095
	)
	public int field3313;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 1353538745
	)
	public int field3330;
	@ObfuscatedName("u")
	@Export("transforms")
	public int[] transforms;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = 1124290535
	)
	@Export("transformVarbit")
	int transformVarbit;
	@ObfuscatedName("aa")
	@ObfuscatedGetter(
		intValue = 1541441781
	)
	@Export("transformVarp")
	int transformVarp;

	static {
		HitSplatDefinition_cached = new EvictingDualNodeHashTable(64);
		HitSplatDefinition_cachedSprites = new EvictingDualNodeHashTable(64);
		HitSplatDefinition_cachedFonts = new EvictingDualNodeHashTable(20);
	}

	HitSplatDefinition() {
		this.fontId = -1;
		this.textColor = 16777215;
		this.field3314 = 70;
		this.field3321 = -1;
		this.field3320 = -1;
		this.field3323 = -1;
		this.field3325 = -1;
		this.field3329 = 0;
		this.field3315 = 0;
		this.field3327 = -1;
		this.field3328 = "";
		this.field3313 = -1;
		this.field3330 = 0;
		this.transformVarbit = -1;
		this.transformVarp = -1;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(Lkc;I)V",
		garbageValue = "1697924004"
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

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Lkc;II)V",
		garbageValue = "149354669"
	)
	@Export("decodeNext")
	void decodeNext(Buffer var1, int var2) {
		if (var2 == 1) {
			this.fontId = var1.method5638();
		} else if (var2 == 2) {
			this.textColor = var1.readMedium();
		} else if (var2 == 3) {
			this.field3321 = var1.method5638();
		} else if (var2 == 4) {
			this.field3323 = var1.method5638();
		} else if (var2 == 5) {
			this.field3320 = var1.method5638();
		} else if (var2 == 6) {
			this.field3325 = var1.method5638();
		} else if (var2 == 7) {
			this.field3329 = var1.readShort();
		} else if (var2 == 8) {
			this.field3328 = var1.readStringCp1252NullCircumfixed();
		} else if (var2 == 9) {
			this.field3314 = var1.readUnsignedShort();
		} else if (var2 == 10) {
			this.field3315 = var1.readShort();
		} else if (var2 == 11) {
			this.field3327 = 0;
		} else if (var2 == 12) {
			this.field3313 = var1.readUnsignedByte();
		} else if (var2 == 13) {
			this.field3330 = var1.readShort();
		} else if (var2 == 14) {
			this.field3327 = var1.readUnsignedShort();
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

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(B)Lii;",
		garbageValue = "-47"
	)
	@Export("transform")
	public final HitSplatDefinition transform() {
		int var1 = -1;
		if (this.transformVarbit != -1) {
			var1 = UserComparator9.getVarbit(this.transformVarbit);
		} else if (this.transformVarp != -1) {
			var1 = Varps.Varps_main[this.transformVarp];
		}

		int var2;
		if (var1 >= 0 && var1 < this.transforms.length - 1) {
			var2 = this.transforms[var1];
		} else {
			var2 = this.transforms[this.transforms.length - 1];
		}

		return var2 != -1 ? NetFileRequest.method4298(var2) : null;
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(II)Ljava/lang/String;",
		garbageValue = "-121756337"
	)
	@Export("getString")
	public String getString(int var1) {
		String var2 = this.field3328;

		while (true) {
			int var3 = var2.indexOf("%1");
			if (var3 < 0) {
				return var2;
			}

			var2 = var2.substring(0, var3) + WorldMapData_0.intToString(var1, false) + var2.substring(var3 + 2);
		}
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)Llx;",
		garbageValue = "1012145117"
	)
	public Sprite method4719() {
		if (this.field3321 < 0) {
			return null;
		} else {
			Sprite var1 = (Sprite)HitSplatDefinition_cachedSprites.get((long)this.field3321);
			if (var1 != null) {
				return var1;
			} else {
				var1 = MenuAction.SpriteBuffer_getSprite(field3316, this.field3321, 0);
				if (var1 != null) {
					HitSplatDefinition_cachedSprites.put(var1, (long)this.field3321);
				}

				return var1;
			}
		}
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(B)Llx;",
		garbageValue = "-59"
	)
	public Sprite method4709() {
		if (this.field3320 < 0) {
			return null;
		} else {
			Sprite var1 = (Sprite)HitSplatDefinition_cachedSprites.get((long)this.field3320);
			if (var1 != null) {
				return var1;
			} else {
				var1 = MenuAction.SpriteBuffer_getSprite(field3316, this.field3320, 0);
				if (var1 != null) {
					HitSplatDefinition_cachedSprites.put(var1, (long)this.field3320);
				}

				return var1;
			}
		}
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(I)Llx;",
		garbageValue = "477012988"
	)
	public Sprite method4710() {
		if (this.field3323 < 0) {
			return null;
		} else {
			Sprite var1 = (Sprite)HitSplatDefinition_cachedSprites.get((long)this.field3323);
			if (var1 != null) {
				return var1;
			} else {
				var1 = MenuAction.SpriteBuffer_getSprite(field3316, this.field3323, 0);
				if (var1 != null) {
					HitSplatDefinition_cachedSprites.put(var1, (long)this.field3323);
				}

				return var1;
			}
		}
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(I)Llx;",
		garbageValue = "-1187157829"
	)
	public Sprite method4731() {
		if (this.field3325 < 0) {
			return null;
		} else {
			Sprite var1 = (Sprite)HitSplatDefinition_cachedSprites.get((long)this.field3325);
			if (var1 != null) {
				return var1;
			} else {
				var1 = MenuAction.SpriteBuffer_getSprite(field3316, this.field3325, 0);
				if (var1 != null) {
					HitSplatDefinition_cachedSprites.put(var1, (long)this.field3325);
				}

				return var1;
			}
		}
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(B)Lks;",
		garbageValue = "0"
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
				var1 = class269.method5114(field3316, class2.HitSplatDefinition_fontsArchive, this.fontId, 0);
				if (var1 != null) {
					HitSplatDefinition_cachedFonts.put(var1, (long)this.fontId);
				}

				return var1;
			}
		}
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "10408118"
	)
	@Export("savePreferences")
	static void savePreferences() {
		AccessFile var0 = null;

		try {
			var0 = CollisionMap.getPreferencesFile("", MouseHandler.field458.name, true);
			Buffer var1 = ScriptEvent.clientPreferences.toBuffer();
			var0.write(var1.array, 0, var1.offset);
		} catch (Exception var3) {
		}

		try {
			if (var0 != null) {
				var0.closeSync(true);
			}
		} catch (Exception var2) {
		}

	}

	@ObfuscatedName("gw")
	@ObfuscatedSignature(
		signature = "(Lbz;IB)V",
		garbageValue = "-26"
	)
	@Export("calculateActorPosition")
	static final void calculateActorPosition(Actor var0, int var1) {
		int var2;
		if (var0.field925 > Client.cycle) {
			WorldMapDecoration.method386(var0);
		} else if (var0.field971 >= Client.cycle) {
			if (var0.field971 == Client.cycle || var0.sequence == -1 || var0.sequenceDelay != 0 || var0.sequenceFrameCycle + 1 > PlayerType.SequenceDefinition_get(var0.sequence).frameLengths[var0.sequenceFrame]) {
				var2 = var0.field971 - var0.field925;
				int var3 = Client.cycle - var0.field925;
				int var4 = var0.field966 * 128 + var0.field927 * 64;
				int var5 = var0.field979 * 128 + var0.field927 * 64;
				int var6 = var0.field967 * 128 + var0.field927 * 64;
				int var7 = var0.field969 * 128 + var0.field927 * 64;
				var0.x = (var6 * var3 + var4 * (var2 - var3)) / var2;
				var0.y = (var3 * var7 + var5 * (var2 - var3)) / var2;
			}

			var0.field982 = 0;
			var0.orientation = var0.field972;
			var0.rotation = var0.orientation;
		} else {
			ModelData0.method3377(var0);
		}

		if (var0.x < 128 || var0.y < 128 || var0.x >= 13184 || var0.y >= 13184) {
			var0.sequence = -1;
			var0.spotAnimation = -1;
			var0.field925 = 0;
			var0.field971 = 0;
			var0.x = var0.pathX[0] * 128 + var0.field927 * 64;
			var0.y = var0.pathY[0] * 128 + var0.field927 * 64;
			var0.method1862();
		}

		if (class215.localPlayer == var0 && (var0.x < 1536 || var0.y < 1536 || var0.x >= 11776 || var0.y >= 11776)) {
			var0.sequence = -1;
			var0.spotAnimation = -1;
			var0.field925 = 0;
			var0.field971 = 0;
			var0.x = var0.pathX[0] * 128 + var0.field927 * 64;
			var0.y = var0.pathY[0] * 128 + var0.field927 * 64;
			var0.method1862();
		}

		Actor.method1873(var0);
		var0.isWalking = false;
		SequenceDefinition var8;
		if (var0.movementSequence != -1) {
			var8 = PlayerType.SequenceDefinition_get(var0.movementSequence);
			if (var8 != null && var8.frameIds != null) {
				++var0.movementFrameCycle;
				if (var0.movementFrame < var8.frameIds.length && var0.movementFrameCycle > var8.frameLengths[var0.movementFrame]) {
					var0.movementFrameCycle = 1;
					++var0.movementFrame;
					Tile.addSequenceSoundEffect(var8, var0.movementFrame, var0.x, var0.y);
				}

				if (var0.movementFrame >= var8.frameIds.length) {
					var0.movementFrameCycle = 0;
					var0.movementFrame = 0;
					Tile.addSequenceSoundEffect(var8, var0.movementFrame, var0.x, var0.y);
				}
			} else {
				var0.movementSequence = -1;
			}
		}

		if (var0.spotAnimation != -1 && Client.cycle >= var0.field973) {
			if (var0.spotAnimationFrame < 0) {
				var0.spotAnimationFrame = 0;
			}

			var2 = MenuAction.SpotAnimationDefinition_get(var0.spotAnimation).sequence;
			if (var2 != -1) {
				SequenceDefinition var9 = PlayerType.SequenceDefinition_get(var2);
				if (var9 != null && var9.frameIds != null) {
					++var0.spotAnimationFrameCycle;
					if (var0.spotAnimationFrame < var9.frameIds.length && var0.spotAnimationFrameCycle > var9.frameLengths[var0.spotAnimationFrame]) {
						var0.spotAnimationFrameCycle = 1;
						++var0.spotAnimationFrame;
						Tile.addSequenceSoundEffect(var9, var0.spotAnimationFrame, var0.x, var0.y);
					}

					if (var0.spotAnimationFrame >= var9.frameIds.length && (var0.spotAnimationFrame < 0 || var0.spotAnimationFrame >= var9.frameIds.length)) {
						var0.spotAnimation = -1;
					}
				} else {
					var0.spotAnimation = -1;
				}
			} else {
				var0.spotAnimation = -1;
			}
		}

		if (var0.sequence != -1 && var0.sequenceDelay <= 1) {
			var8 = PlayerType.SequenceDefinition_get(var0.sequence);
			if (var8.field3504 == 1 && var0.field983 > 0 && var0.field925 <= Client.cycle && var0.field971 < Client.cycle) {
				var0.sequenceDelay = 1;
				return;
			}
		}

		if (var0.sequence != -1 && var0.sequenceDelay == 0) {
			var8 = PlayerType.SequenceDefinition_get(var0.sequence);
			if (var8 != null && var8.frameIds != null) {
				++var0.sequenceFrameCycle;
				if (var0.sequenceFrame < var8.frameIds.length && var0.sequenceFrameCycle > var8.frameLengths[var0.sequenceFrame]) {
					var0.sequenceFrameCycle = 1;
					++var0.sequenceFrame;
					Tile.addSequenceSoundEffect(var8, var0.sequenceFrame, var0.x, var0.y);
				}

				if (var0.sequenceFrame >= var8.frameIds.length) {
					var0.sequenceFrame -= var8.frameCount;
					++var0.field960;
					if (var0.field960 >= var8.field3518) {
						var0.sequence = -1;
					} else if (var0.sequenceFrame >= 0 && var0.sequenceFrame < var8.frameIds.length) {
						Tile.addSequenceSoundEffect(var8, var0.sequenceFrame, var0.x, var0.y);
					} else {
						var0.sequence = -1;
					}
				}

				var0.isWalking = var8.field3514;
			} else {
				var0.sequence = -1;
			}
		}

		if (var0.sequenceDelay > 0) {
			--var0.sequenceDelay;
		}

	}
}
