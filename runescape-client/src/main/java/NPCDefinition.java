import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("il")
@Implements("NPCDefinition")
public class NPCDefinition extends DualNode {
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Lhp;"
	)
	@Export("NpcDefinition_archive")
	public static AbstractArchive NpcDefinition_archive;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lhp;"
	)
	@Export("NpcDefinition_modelArchive")
	public static AbstractArchive NpcDefinition_modelArchive;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lem;"
	)
	@Export("NpcDefinition_cached")
	public static EvictingDualNodeHashTable NpcDefinition_cached;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lem;"
	)
	@Export("NpcDefinition_cachedModels")
	public static EvictingDualNodeHashTable NpcDefinition_cachedModels;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = 795033679
	)
	@Export("id")
	public int id;
	@ObfuscatedName("p")
	@Export("name")
	public String name;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -441203939
	)
	@Export("size")
	public int size;
	@ObfuscatedName("m")
	@Export("models")
	int[] models;
	@ObfuscatedName("y")
	int[] field3448;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -182220755
	)
	@Export("readySequence")
	public int readySequence;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -1669190657
	)
	@Export("turnLeftSequence")
	public int turnLeftSequence;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -394985883
	)
	@Export("turnRightSequence")
	public int turnRightSequence;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = 1951589919
	)
	@Export("walkSequence")
	public int walkSequence;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = 1113665339
	)
	@Export("walkBackSequence")
	public int walkBackSequence;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -1204590857
	)
	@Export("walkLeftSequence")
	public int walkLeftSequence;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -2041030831
	)
	@Export("walkRightSequence")
	public int walkRightSequence;
	@ObfuscatedName("t")
	@Export("recolorFrom")
	short[] recolorFrom;
	@ObfuscatedName("g")
	@Export("recolorTo")
	short[] recolorTo;
	@ObfuscatedName("x")
	@Export("retextureFrom")
	short[] retextureFrom;
	@ObfuscatedName("h")
	@Export("retextureTo")
	short[] retextureTo;
	@ObfuscatedName("s")
	@Export("actions")
	public String[] actions;
	@ObfuscatedName("f")
	@Export("drawMapDot")
	public boolean drawMapDot;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = 1360683279
	)
	@Export("combatLevel")
	public int combatLevel;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 758770497
	)
	@Export("widthScale")
	int widthScale;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -1757828027
	)
	@Export("heightScale")
	int heightScale;
	@ObfuscatedName("k")
	@Export("isVisible")
	public boolean isVisible;
	@ObfuscatedName("ac")
	@ObfuscatedGetter(
		intValue = 1963706097
	)
	@Export("ambient")
	int ambient;
	@ObfuscatedName("az")
	@ObfuscatedGetter(
		intValue = -1216133169
	)
	@Export("contrast")
	int contrast;
	@ObfuscatedName("aw")
	@ObfuscatedGetter(
		intValue = 246799047
	)
	@Export("headIconPrayer")
	public int headIconPrayer;
	@ObfuscatedName("aa")
	@ObfuscatedGetter(
		intValue = 950956241
	)
	@Export("rotation")
	public int rotation;
	@ObfuscatedName("ap")
	@Export("transforms")
	public int[] transforms;
	@ObfuscatedName("ar")
	@ObfuscatedGetter(
		intValue = 1759904707
	)
	@Export("transformVarbit")
	int transformVarbit;
	@ObfuscatedName("ab")
	@ObfuscatedGetter(
		intValue = -313433817
	)
	@Export("transformVarp")
	int transformVarp;
	@ObfuscatedName("ax")
	@Export("isInteractable")
	public boolean isInteractable;
	@ObfuscatedName("as")
	@Export("isClickable")
	public boolean isClickable;
	@ObfuscatedName("ao")
	@Export("isFollower")
	public boolean isFollower;
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		signature = "Llb;"
	)
	@Export("params")
	IterableNodeHashTable params;

	static {
		NpcDefinition_cached = new EvictingDualNodeHashTable(64);
		NpcDefinition_cachedModels = new EvictingDualNodeHashTable(50);
	}

	NPCDefinition() {
		this.name = "null";
		this.size = 1;
		this.readySequence = -1;
		this.turnLeftSequence = -1;
		this.turnRightSequence = -1;
		this.walkSequence = -1;
		this.walkBackSequence = -1;
		this.walkLeftSequence = -1;
		this.walkRightSequence = -1;
		this.actions = new String[5];
		this.drawMapDot = true;
		this.combatLevel = -1;
		this.widthScale = 128;
		this.heightScale = 128;
		this.isVisible = false;
		this.ambient = 0;
		this.contrast = 0;
		this.headIconPrayer = -1;
		this.rotation = 32;
		this.transformVarbit = -1;
		this.transformVarp = -1;
		this.isInteractable = true;
		this.isClickable = true;
		this.isFollower = false;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-117"
	)
	@Export("postDecode")
	void postDecode() {
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(Lkl;B)V",
		garbageValue = "-41"
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

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Lkl;II)V",
		garbageValue = "-1943278683"
	)
	@Export("decodeNext")
	void decodeNext(Buffer var1, int var2) {
		int var3;
		int var4;
		if (var2 == 1) {
			var3 = var1.readUnsignedByte();
			this.models = new int[var3];

			for (var4 = 0; var4 < var3; ++var4) {
				this.models[var4] = var1.readUnsignedShort();
			}
		} else if (var2 == 2) {
			this.name = var1.readStringCp1252NullTerminated();
		} else if (var2 == 12) {
			this.size = var1.readUnsignedByte();
		} else if (var2 == 13) {
			this.readySequence = var1.readUnsignedShort();
		} else if (var2 == 14) {
			this.walkSequence = var1.readUnsignedShort();
		} else if (var2 == 15) {
			this.turnLeftSequence = var1.readUnsignedShort();
		} else if (var2 == 16) {
			this.turnRightSequence = var1.readUnsignedShort();
		} else if (var2 == 17) {
			this.walkSequence = var1.readUnsignedShort();
			this.walkBackSequence = var1.readUnsignedShort();
			this.walkLeftSequence = var1.readUnsignedShort();
			this.walkRightSequence = var1.readUnsignedShort();
		} else if (var2 >= 30 && var2 < 35) {
			this.actions[var2 - 30] = var1.readStringCp1252NullTerminated();
			if (this.actions[var2 - 30].equalsIgnoreCase("Hidden")) {
				this.actions[var2 - 30] = null;
			}
		} else if (var2 == 40) {
			var3 = var1.readUnsignedByte();
			this.recolorFrom = new short[var3];
			this.recolorTo = new short[var3];

			for (var4 = 0; var4 < var3; ++var4) {
				this.recolorFrom[var4] = (short)var1.readUnsignedShort();
				this.recolorTo[var4] = (short)var1.readUnsignedShort();
			}
		} else if (var2 == 41) {
			var3 = var1.readUnsignedByte();
			this.retextureFrom = new short[var3];
			this.retextureTo = new short[var3];

			for (var4 = 0; var4 < var3; ++var4) {
				this.retextureFrom[var4] = (short)var1.readUnsignedShort();
				this.retextureTo[var4] = (short)var1.readUnsignedShort();
			}
		} else if (var2 == 60) {
			var3 = var1.readUnsignedByte();
			this.field3448 = new int[var3];

			for (var4 = 0; var4 < var3; ++var4) {
				this.field3448[var4] = var1.readUnsignedShort();
			}
		} else if (var2 == 93) {
			this.drawMapDot = false;
		} else if (var2 == 95) {
			this.combatLevel = var1.readUnsignedShort();
		} else if (var2 == 97) {
			this.widthScale = var1.readUnsignedShort();
		} else if (var2 == 98) {
			this.heightScale = var1.readUnsignedShort();
		} else if (var2 == 99) {
			this.isVisible = true;
		} else if (var2 == 100) {
			this.ambient = var1.readByte();
		} else if (var2 == 101) {
			this.contrast = var1.readByte() * 5;
		} else if (var2 == 102) {
			this.headIconPrayer = var1.readUnsignedShort();
		} else if (var2 == 103) {
			this.rotation = var1.readUnsignedShort();
		} else if (var2 != 106 && var2 != 118) {
			if (var2 == 107) {
				this.isInteractable = false;
			} else if (var2 == 109) {
				this.isClickable = false;
			} else if (var2 == 111) {
				this.isFollower = true;
			} else if (var2 == 249) {
				this.params = UserComparator5.readStringIntParameters(var1, this.params);
			}
		} else {
			this.transformVarbit = var1.readUnsignedShort();
			if (this.transformVarbit == 65535) {
				this.transformVarbit = -1;
			}

			this.transformVarp = var1.readUnsignedShort();
			if (this.transformVarp == 65535) {
				this.transformVarp = -1;
			}

			var3 = -1;
			if (var2 == 118) {
				var3 = var1.readUnsignedShort();
				if (var3 == 65535) {
					var3 = -1;
				}
			}

			var4 = var1.readUnsignedByte();
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

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(Lix;ILix;IS)Ldh;",
		garbageValue = "-24084"
	)
	@Export("getModel")
	public final Model getModel(SequenceDefinition var1, int var2, SequenceDefinition var3, int var4) {
		if (this.transforms != null) {
			NPCDefinition var12 = this.transform();
			return var12 == null ? null : var12.getModel(var1, var2, var3, var4);
		} else {
			Model var5 = (Model)NpcDefinition_cachedModels.get((long)this.id);
			if (var5 == null) {
				boolean var6 = false;

				for (int var7 = 0; var7 < this.models.length; ++var7) {
					if (!NpcDefinition_modelArchive.tryLoadFile(this.models[var7], 0)) {
						var6 = true;
					}
				}

				if (var6) {
					return null;
				}

				ModelData[] var8 = new ModelData[this.models.length];

				int var9;
				for (var9 = 0; var9 < this.models.length; ++var9) {
					var8[var9] = ModelData.ModelData_get(NpcDefinition_modelArchive, this.models[var9], 0);
				}

				ModelData var11;
				if (var8.length == 1) {
					var11 = var8[0];
				} else {
					var11 = new ModelData(var8, var8.length);
				}

				if (this.recolorFrom != null) {
					for (var9 = 0; var9 < this.recolorFrom.length; ++var9) {
						var11.recolor(this.recolorFrom[var9], this.recolorTo[var9]);
					}
				}

				if (this.retextureFrom != null) {
					for (var9 = 0; var9 < this.retextureFrom.length; ++var9) {
						var11.retexture(this.retextureFrom[var9], this.retextureTo[var9]);
					}
				}

				var5 = var11.toModel(this.ambient + 64, this.contrast + 850, -30, -50, -30);
				NpcDefinition_cachedModels.put(var5, (long)this.id);
			}

			Model var10;
			if (var1 != null && var3 != null) {
				var10 = var1.applyTransformations(var5, var2, var3, var4);
			} else if (var1 != null) {
				var10 = var1.transformActorModel(var5, var2);
			} else if (var3 != null) {
				var10 = var3.transformActorModel(var5, var4);
			} else {
				var10 = var5.toSharedSequenceModel(true);
			}

			if (this.widthScale != 128 || this.heightScale != 128) {
				var10.scale(this.widthScale, this.heightScale, this.widthScale);
			}

			return var10;
		}
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(B)Ldw;",
		garbageValue = "58"
	)
	@Export("getModelData")
	public final ModelData getModelData() {
		if (this.transforms != null) {
			NPCDefinition var1 = this.transform();
			return var1 == null ? null : var1.getModelData();
		} else if (this.field3448 == null) {
			return null;
		} else {
			boolean var5 = false;

			for (int var2 = 0; var2 < this.field3448.length; ++var2) {
				if (!NpcDefinition_modelArchive.tryLoadFile(this.field3448[var2], 0)) {
					var5 = true;
				}
			}

			if (var5) {
				return null;
			} else {
				ModelData[] var6 = new ModelData[this.field3448.length];

				for (int var3 = 0; var3 < this.field3448.length; ++var3) {
					var6[var3] = ModelData.ModelData_get(NpcDefinition_modelArchive, this.field3448[var3], 0);
				}

				ModelData var7;
				if (var6.length == 1) {
					var7 = var6[0];
				} else {
					var7 = new ModelData(var6, var6.length);
				}

				int var4;
				if (this.recolorFrom != null) {
					for (var4 = 0; var4 < this.recolorFrom.length; ++var4) {
						var7.recolor(this.recolorFrom[var4], this.recolorTo[var4]);
					}
				}

				if (this.retextureFrom != null) {
					for (var4 = 0; var4 < this.retextureFrom.length; ++var4) {
						var7.retexture(this.retextureFrom[var4], this.retextureTo[var4]);
					}
				}

				return var7;
			}
		}
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)Lil;",
		garbageValue = "1423511184"
	)
	@Export("transform")
	public final NPCDefinition transform() {
		int var1 = -1;
		if (this.transformVarbit != -1) {
			var1 = WorldMapSprite.getVarbit(this.transformVarbit);
		} else if (this.transformVarp != -1) {
			var1 = Varps.Varps_main[this.transformVarp];
		}

		int var2;
		if (var1 >= 0 && var1 < this.transforms.length - 1) {
			var2 = this.transforms[var1];
		} else {
			var2 = this.transforms[this.transforms.length - 1];
		}

		return var2 != -1 ? PacketBufferNode.getNpcDefinition(var2) : null;
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "-43"
	)
	@Export("transformIsVisible")
	public boolean transformIsVisible() {
		if (this.transforms == null) {
			return true;
		} else {
			int var1 = -1;
			if (this.transformVarbit != -1) {
				var1 = WorldMapSprite.getVarbit(this.transformVarbit);
			} else if (this.transformVarp != -1) {
				var1 = Varps.Varps_main[this.transformVarp];
			}

			if (var1 >= 0 && var1 < this.transforms.length) {
				return this.transforms[var1] != -1;
			} else {
				return this.transforms[this.transforms.length - 1] != -1;
			}
		}
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "-1804168798"
	)
	@Export("getIntParam")
	public int getIntParam(int var1, int var2) {
		return HealthBar.method2034(this.params, var1, var2);
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;I)Ljava/lang/String;",
		garbageValue = "-1270482233"
	)
	@Export("getStringParam")
	public String getStringParam(int var1, String var2) {
		return class96.method2263(this.params, var1, var2);
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(Lhp;III)Llf;",
		garbageValue = "-1092680498"
	)
	@Export("SpriteBuffer_getSprite")
	public static Sprite SpriteBuffer_getSprite(AbstractArchive var0, int var1, int var2) {
		return !VertexNormal.method2962(var0, var1, var2) ? null : FillMode.method6030();
	}

	@ObfuscatedName("gr")
	@ObfuscatedSignature(
		signature = "(IIIIIIII)V",
		garbageValue = "474931921"
	)
	static final void method4677(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
		int var8 = var6 - 334;
		if (var8 < 0) {
			var8 = 0;
		} else if (var8 > 100) {
			var8 = 100;
		}

		int var9 = (Client.zoomWidth - Client.zoomHeight) * var8 / 100 + Client.zoomHeight;
		int var7 = var5 * var9 / 256;
		var8 = 2048 - var3 & 2047;
		var9 = 2048 - var4 & 2047;
		int var10 = 0;
		int var11 = 0;
		int var12 = var7;
		int var13;
		int var14;
		int var15;
		if (var8 != 0) {
			var13 = Rasterizer3D.Rasterizer3D_sine[var8];
			var14 = Rasterizer3D.Rasterizer3D_cosine[var8];
			var15 = var11 * var14 - var7 * var13 >> 16;
			var12 = var14 * var7 + var13 * var11 >> 16;
			var11 = var15;
		}

		if (var9 != 0) {
			var13 = Rasterizer3D.Rasterizer3D_sine[var9];
			var14 = Rasterizer3D.Rasterizer3D_cosine[var9];
			var15 = var10 * var14 + var13 * var12 >> 16;
			var12 = var12 * var14 - var10 * var13 >> 16;
			var10 = var15;
		}

		GrandExchangeOfferOwnWorldComparator.cameraX = var0 - var10;
		Varcs.cameraY = var1 - var11;
		WorldMapIcon_1.cameraZ = var2 - var12;
		IgnoreList.cameraPitch = var3;
		WorldMapSection2.cameraYaw = var4;
		if (Client.oculusOrbState == 1 && Client.staffModLevel >= 2 && Client.cycle % 50 == 0 && (ObjectSound.oculusOrbFocalPointX >> 7 != class223.localPlayer.x >> 7 || class14.oculusOrbFocalPointY >> 7 != class223.localPlayer.y >> 7)) {
			var13 = class223.localPlayer.plane;
			var14 = class223.baseX * 64 + (ObjectSound.oculusOrbFocalPointX >> 7);
			var15 = class286.baseY * 64 + (class14.oculusOrbFocalPointY >> 7);
			class287.method5220(var14, var15, var13, true);
		}

	}
}
