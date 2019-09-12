import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ic")
@Implements("HitSplatDefinition")
public class HitSplatDefinition extends DualNode {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lhz;"
	)
	@Export("HitSplatDefinition_archive")
	static AbstractArchive HitSplatDefinition_archive;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lhz;"
	)
	static AbstractArchive field3300;
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Let;"
	)
	@Export("HitSplatDefinition_cached")
	static EvictingDualNodeHashTable HitSplatDefinition_cached;
	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "Let;"
	)
	@Export("HitSplatDefinition_cachedSprites")
	static EvictingDualNodeHashTable HitSplatDefinition_cachedSprites;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Let;"
	)
	@Export("HitSplatDefinition_cachedFonts")
	static EvictingDualNodeHashTable HitSplatDefinition_cachedFonts;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = -357420585
	)
	@Export("fontId")
	int fontId;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = 327492087
	)
	@Export("textColor")
	public int textColor;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = -687651927
	)
	public int field3306;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 1048362973
	)
	int field3314;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -224285899
	)
	int field3308;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 163479341
	)
	int field3312;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 295694895
	)
	int field3313;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = -1371594611
	)
	public int field3311;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = -1444212513
	)
	public int field3310;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -1563267253
	)
	public int field3307;
	@ObfuscatedName("w")
	String field3309;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 1065378437
	)
	public int field3315;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = -267578869
	)
	public int field3316;
	@ObfuscatedName("a")
	@Export("transforms")
	public int[] transforms;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -222601541
	)
	@Export("transformVarbit")
	int transformVarbit;
	@ObfuscatedName("ag")
	@ObfuscatedGetter(
		intValue = 158583145
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
		this.field3306 = 70;
		this.field3314 = -1;
		this.field3308 = -1;
		this.field3312 = -1;
		this.field3313 = -1;
		this.field3311 = 0;
		this.field3310 = 0;
		this.field3307 = -1;
		this.field3309 = "";
		this.field3315 = -1;
		this.field3316 = 0;
		this.transformVarbit = -1;
		this.transformVarp = -1;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Lkz;I)V",
		garbageValue = "1961600783"
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

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(Lkz;II)V",
		garbageValue = "138973037"
	)
	@Export("decodeNext")
	void decodeNext(Buffer var1, int var2) {
		if (var2 == 1) {
			this.fontId = var1.method5623();
		} else if (var2 == 2) {
			this.textColor = var1.readMedium();
		} else if (var2 == 3) {
			this.field3314 = var1.method5623();
		} else if (var2 == 4) {
			this.field3312 = var1.method5623();
		} else if (var2 == 5) {
			this.field3308 = var1.method5623();
		} else if (var2 == 6) {
			this.field3313 = var1.method5623();
		} else if (var2 == 7) {
			this.field3311 = var1.readShort();
		} else if (var2 == 8) {
			this.field3309 = var1.readStringCp1252NullCircumfixed();
		} else if (var2 == 9) {
			this.field3306 = var1.readUnsignedShort();
		} else if (var2 == 10) {
			this.field3310 = var1.readShort();
		} else if (var2 == 11) {
			this.field3307 = 0;
		} else if (var2 == 12) {
			this.field3315 = var1.readUnsignedByte();
		} else if (var2 == 13) {
			this.field3316 = var1.readShort();
		} else if (var2 == 14) {
			this.field3307 = var1.readUnsignedShort();
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

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(I)Lic;",
		garbageValue = "-2043410275"
	)
	@Export("transform")
	public final HitSplatDefinition transform() {
		int var1 = -1;
		if (this.transformVarbit != -1) {
			var1 = WorldMapCacheName.getVarbit(this.transformVarbit);
		} else if (this.transformVarp != -1) {
			var1 = Varps.Varps_main[this.transformVarp];
		}

		int var2;
		if (var1 >= 0 && var1 < this.transforms.length - 1) {
			var2 = this.transforms[var1];
		} else {
			var2 = this.transforms[this.transforms.length - 1];
		}

		return var2 != -1 ? Interpreter.HitSplatDefinition_get(var2) : null;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(IB)Ljava/lang/String;",
		garbageValue = "-7"
	)
	@Export("getString")
	public String getString(int var1) {
		String var2 = this.field3309;

		while (true) {
			int var3 = var2.indexOf("%1");
			if (var3 < 0) {
				return var2;
			}

			var2 = var2.substring(0, var3) + Skeleton.intToString(var1, false) + var2.substring(var3 + 2);
		}
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(I)Lli;",
		garbageValue = "-1669943283"
	)
	public Sprite method4568() {
		if (this.field3314 < 0) {
			return null;
		} else {
			Sprite var1 = (Sprite)HitSplatDefinition_cachedSprites.get((long)this.field3314);
			if (var1 != null) {
				return var1;
			} else {
				var1 = FillMode.SpriteBuffer_getSprite(field3300, this.field3314, 0);
				if (var1 != null) {
					HitSplatDefinition_cachedSprites.put(var1, (long)this.field3314);
				}

				return var1;
			}
		}
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(I)Lli;",
		garbageValue = "-675719915"
	)
	public Sprite method4581() {
		if (this.field3308 < 0) {
			return null;
		} else {
			Sprite var1 = (Sprite)HitSplatDefinition_cachedSprites.get((long)this.field3308);
			if (var1 != null) {
				return var1;
			} else {
				var1 = FillMode.SpriteBuffer_getSprite(field3300, this.field3308, 0);
				if (var1 != null) {
					HitSplatDefinition_cachedSprites.put(var1, (long)this.field3308);
				}

				return var1;
			}
		}
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(I)Lli;",
		garbageValue = "-1399773302"
	)
	public Sprite method4570() {
		if (this.field3312 < 0) {
			return null;
		} else {
			Sprite var1 = (Sprite)HitSplatDefinition_cachedSprites.get((long)this.field3312);
			if (var1 != null) {
				return var1;
			} else {
				var1 = FillMode.SpriteBuffer_getSprite(field3300, this.field3312, 0);
				if (var1 != null) {
					HitSplatDefinition_cachedSprites.put(var1, (long)this.field3312);
				}

				return var1;
			}
		}
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(S)Lli;",
		garbageValue = "-24882"
	)
	public Sprite method4561() {
		if (this.field3313 < 0) {
			return null;
		} else {
			Sprite var1 = (Sprite)HitSplatDefinition_cachedSprites.get((long)this.field3313);
			if (var1 != null) {
				return var1;
			} else {
				var1 = FillMode.SpriteBuffer_getSprite(field3300, this.field3313, 0);
				if (var1 != null) {
					HitSplatDefinition_cachedSprites.put(var1, (long)this.field3313);
				}

				return var1;
			}
		}
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(B)Lkf;",
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
				AbstractArchive var3 = field3300;
				AbstractArchive var4 = class189.HitSplatDefinition_fontsArchive;
				int var5 = this.fontId;
				byte[] var7 = var3.takeFile(var5, 0);
				boolean var6;
				if (var7 == null) {
					var6 = false;
				} else {
					GrandExchangeOfferWorldComparator.SpriteBuffer_decode(var7);
					var6 = true;
				}

				Font var2;
				if (!var6) {
					var2 = null;
				} else {
					byte[] var8 = var4.takeFile(var5, 0);
					Font var10;
					if (var8 == null) {
						var10 = null;
					} else {
						Font var9 = new Font(var8, class325.SpriteBuffer_xOffsets, SecureRandomCallable.SpriteBuffer_yOffsets, class325.SpriteBuffer_spriteWidths, SoundSystem.SpriteBuffer_spriteHeights, class325.SpriteBuffer_spritePalette, InvDefinition.SpriteBuffer_pixels);
						class192.SpriteBuffer_clear();
						var10 = var9;
					}

					var2 = var10;
				}

				if (var2 != null) {
					HitSplatDefinition_cachedFonts.put(var2, (long)this.fontId);
				}

				return var2;
			}
		}
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "([BIII)Z",
		garbageValue = "-240401517"
	)
	static final boolean method4589(byte[] var0, int var1, int var2) {
		boolean var3 = true;
		Buffer var4 = new Buffer(var0);
		int var5 = -1;

		label67:
		while (true) {
			int var6 = var4.method5480();
			if (var6 == 0) {
				return var3;
			}

			var5 += var6;
			int var7 = 0;
			boolean var8 = false;

			while (true) {
				int var9;
				while (!var8) {
					var9 = var4.readUShortSmart();
					if (var9 == 0) {
						continue label67;
					}

					var7 += var9 - 1;
					int var10 = var7 & 63;
					int var11 = var7 >> 6 & 63;
					int var12 = var4.readUnsignedByte() >> 2;
					int var13 = var11 + var1;
					int var14 = var10 + var2;
					if (var13 > 0 && var14 > 0 && var13 < 103 && var14 < 103) {
						ObjectDefinition var15 = WallDecoration.getObjectDefinition(var5);
						if (var12 != 22 || !Client.isLowDetail || var15.int1 != 0 || var15.interactType == 1 || var15.boolean2) {
							if (!var15.needsModelFiles()) {
								++Client.field676;
								var3 = false;
							}

							var8 = true;
						}
					}
				}

				var9 = var4.readUShortSmart();
				if (var9 == 0) {
					break;
				}

				var4.readUnsignedByte();
			}
		}
	}

	@ObfuscatedName("fp")
	@ObfuscatedSignature(
		signature = "(Lbe;B)V",
		garbageValue = "0"
	)
	static final void method4558(Actor var0) {
		var0.isWalking = false;
		SequenceDefinition var1;
		if (var0.movementSequence != -1) {
			var1 = class83.SequenceDefinition_get(var0.movementSequence);
			if (var1 != null && var1.frameIds != null) {
				++var0.movementFrameCycle;
				if (var0.movementFrame < var1.frameIds.length && var0.movementFrameCycle > var1.frameLengths[var0.movementFrame]) {
					var0.movementFrameCycle = 1;
					++var0.movementFrame;
					WorldMapSectionType.addSequenceSoundEffect(var1, var0.movementFrame, var0.x * -78439701, var0.y);
				}

				if (var0.movementFrame >= var1.frameIds.length) {
					var0.movementFrameCycle = 0;
					var0.movementFrame = 0;
					WorldMapSectionType.addSequenceSoundEffect(var1, var0.movementFrame, var0.x * -78439701, var0.y);
				}
			} else {
				var0.movementSequence = -1;
			}
		}

		if (var0.spotAnimation != -1 && Client.cycle >= var0.field957) {
			if (var0.spotAnimationFrame < 0) {
				var0.spotAnimationFrame = 0;
			}

			int var3 = NetCache.SpotAnimationDefinition_get(var0.spotAnimation).sequence;
			if (var3 != -1) {
				SequenceDefinition var2 = class83.SequenceDefinition_get(var3);
				if (var2 != null && var2.frameIds != null) {
					++var0.spotAnimationFrameCycle;
					if (var0.spotAnimationFrame < var2.frameIds.length && var0.spotAnimationFrameCycle > var2.frameLengths[var0.spotAnimationFrame]) {
						var0.spotAnimationFrameCycle = 1;
						++var0.spotAnimationFrame;
						WorldMapSectionType.addSequenceSoundEffect(var2, var0.spotAnimationFrame, var0.x * -78439701, var0.y);
					}

					if (var0.spotAnimationFrame >= var2.frameIds.length && (var0.spotAnimationFrame < 0 || var0.spotAnimationFrame >= var2.frameIds.length)) {
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
			var1 = class83.SequenceDefinition_get(var0.sequence);
			if (var1.field3496 == 1 && var0.field969 > 0 && var0.field963 <= Client.cycle && var0.field964 < Client.cycle) {
				var0.sequenceDelay = 1;
				return;
			}
		}

		if (var0.sequence != -1 && var0.sequenceDelay == 0) {
			var1 = class83.SequenceDefinition_get(var0.sequence);
			if (var1 != null && var1.frameIds != null) {
				++var0.sequenceFrameCycle;
				if (var0.sequenceFrame < var1.frameIds.length && var0.sequenceFrameCycle > var1.frameLengths[var0.sequenceFrame]) {
					var0.sequenceFrameCycle = 1;
					++var0.sequenceFrame;
					WorldMapSectionType.addSequenceSoundEffect(var1, var0.sequenceFrame, var0.x * -78439701, var0.y);
				}

				if (var0.sequenceFrame >= var1.frameIds.length) {
					var0.sequenceFrame -= var1.frameCount;
					++var0.field924;
					if (var0.field924 >= var1.field3492) {
						var0.sequence = -1;
					} else if (var0.sequenceFrame >= 0 && var0.sequenceFrame < var1.frameIds.length) {
						WorldMapSectionType.addSequenceSoundEffect(var1, var0.sequenceFrame, var0.x * -78439701, var0.y);
					} else {
						var0.sequence = -1;
					}
				}

				var0.isWalking = var1.field3495;
			} else {
				var0.sequence = -1;
			}
		}

		if (var0.sequenceDelay > 0) {
			--var0.sequenceDelay;
		}

	}
}
