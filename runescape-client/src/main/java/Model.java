import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("do")
@Implements("Model")
public class Model extends Entity {
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "Ldo;"
	)
	@Export("Model_sharedSequenceModel")
	static Model Model_sharedSequenceModel;
	@ObfuscatedName("j")
	@Export("Model_sharedSequenceModelFaceAlphas")
	static byte[] Model_sharedSequenceModelFaceAlphas;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Ldo;"
	)
	@Export("Model_sharedSpotAnimationModel")
	static Model Model_sharedSpotAnimationModel;
	@ObfuscatedName("k")
	@Export("Model_sharedSpotAnimationModelFaceAlphas")
	static byte[] Model_sharedSpotAnimationModelFaceAlphas;
	@ObfuscatedName("au")
	static boolean[] field1670;
	@ObfuscatedName("ax")
	static boolean[] field1689;
	@ObfuscatedName("ag")
	@Export("modelViewportXs")
	static int[] modelViewportXs;
	@ObfuscatedName("aa")
	@Export("modelViewportYs")
	static int[] modelViewportYs;
	@ObfuscatedName("ap")
	static int[] field1692;
	@ObfuscatedName("aq")
	static int[] field1708;
	@ObfuscatedName("ay")
	static int[] field1663;
	@ObfuscatedName("ad")
	static int[] field1695;
	@ObfuscatedName("ah")
	static int[] field1696;
	@ObfuscatedName("ab")
	static int[][] field1698;
	@ObfuscatedName("aw")
	static int[] field1669;
	@ObfuscatedName("ae")
	static int[][] field1700;
	@ObfuscatedName("bk")
	static int[] field1701;
	@ObfuscatedName("bw")
	static int[] field1660;
	@ObfuscatedName("bo")
	static int[] field1703;
	@ObfuscatedName("bn")
	static int[] field1704;
	@ObfuscatedName("bp")
	static int[] field1705;
	@ObfuscatedName("bz")
	static int[] field1706;
	@ObfuscatedName("bh")
	@Export("Model_transformTempX")
	static int Model_transformTempX;
	@ObfuscatedName("bv")
	@Export("Model_transformTempY")
	static int Model_transformTempY;
	@ObfuscatedName("bj")
	@Export("Model_transformTempZ")
	static int Model_transformTempZ;
	@ObfuscatedName("bq")
	static boolean field1710;
	@ObfuscatedName("bi")
	@Export("Model_sine")
	static int[] Model_sine;
	@ObfuscatedName("bf")
	@Export("Model_cosine")
	static int[] Model_cosine;
	@ObfuscatedName("bd")
	static int[] field1715;
	@ObfuscatedName("br")
	static int[] field1716;
	@ObfuscatedName("u")
	@Export("verticesCount")
	int verticesCount;
	@ObfuscatedName("n")
	@Export("verticesX")
	int[] verticesX;
	@ObfuscatedName("t")
	@Export("verticesY")
	int[] verticesY;
	@ObfuscatedName("q")
	@Export("verticesZ")
	int[] verticesZ;
	@ObfuscatedName("x")
	@Export("indicesCount")
	int indicesCount;
	@ObfuscatedName("d")
	@Export("indices1")
	int[] indices1;
	@ObfuscatedName("f")
	@Export("indices2")
	int[] indices2;
	@ObfuscatedName("c")
	@Export("indices3")
	int[] indices3;
	@ObfuscatedName("r")
	@Export("faceColors1")
	int[] faceColors1;
	@ObfuscatedName("y")
	@Export("faceColors2")
	int[] faceColors2;
	@ObfuscatedName("p")
	@Export("faceColors3")
	int[] faceColors3;
	@ObfuscatedName("b")
	@Export("faceRenderPriorities")
	byte[] faceRenderPriorities;
	@ObfuscatedName("g")
	@Export("faceAlphas")
	byte[] faceAlphas;
	@ObfuscatedName("e")
	byte[] field1666;
	@ObfuscatedName("z")
	@Export("faceTextures")
	short[] faceTextures;
	@ObfuscatedName("a")
	byte field1690;
	@ObfuscatedName("w")
	int field1699;
	@ObfuscatedName("l")
	int[] field1691;
	@ObfuscatedName("h")
	int[] field1671;
	@ObfuscatedName("v")
	int[] field1672;
	@ObfuscatedName("m")
	@Export("vertexLabels")
	int[][] vertexLabels;
	@ObfuscatedName("o")
	@Export("faceLabelsAlpha")
	int[][] faceLabelsAlpha;
	@ObfuscatedName("av")
	@Export("isSingleTile")
	public boolean isSingleTile;
	@ObfuscatedName("am")
	@Export("boundsType")
	int boundsType;
	@ObfuscatedName("ai")
	@Export("bottomY")
	int bottomY;
	@ObfuscatedName("af")
	@Export("xzRadius")
	int xzRadius;
	@ObfuscatedName("az")
	@Export("diameter")
	int diameter;
	@ObfuscatedName("aj")
	@Export("radius")
	int radius;
	@ObfuscatedName("an")
	@Export("xMid")
	int xMid;
	@ObfuscatedName("at")
	@Export("yMid")
	int yMid;
	@ObfuscatedName("as")
	@Export("zMid")
	int zMid;
	@ObfuscatedName("ak")
	@Export("xMidOffset")
	int xMidOffset;
	@ObfuscatedName("ao")
	@Export("yMidOffset")
	int yMidOffset;
	@ObfuscatedName("ac")
	@Export("zMidOffset")
	int zMidOffset;

	static {
		Model_sharedSequenceModel = new Model();
		Model_sharedSequenceModelFaceAlphas = new byte[1];
		Model_sharedSpotAnimationModel = new Model();
		Model_sharedSpotAnimationModelFaceAlphas = new byte[1];
		field1670 = new boolean[4700];
		field1689 = new boolean[4700];
		modelViewportXs = new int[4700];
		modelViewportYs = new int[4700];
		field1692 = new int[4700];
		field1708 = new int[4700];
		field1663 = new int[4700];
		field1695 = new int[4700];
		field1696 = new int[1600];
		field1698 = new int[1600][512];
		field1669 = new int[12];
		field1700 = new int[12][2000];
		field1701 = new int[2000];
		field1660 = new int[2000];
		field1703 = new int[12];
		field1704 = new int[10];
		field1705 = new int[10];
		field1706 = new int[10];
		field1710 = true;
		Model_sine = Rasterizer3D.Rasterizer3D_sine;
		Model_cosine = Rasterizer3D.Rasterizer3D_cosine;
		field1715 = Rasterizer3D.Rasterizer3D_colorPalette;
		field1716 = Rasterizer3D.field1765;
	}

	Model() {
		this.verticesCount = 0;
		this.indicesCount = 0;
		this.field1690 = 0;
		this.field1699 = 0;
		this.isSingleTile = false;
		this.xMidOffset = -1;
		this.yMidOffset = -1;
		this.zMidOffset = -1;
	}

	@ObfuscatedSignature(
		signature = "([Ldo;I)V"
	)
	public Model(Model[] var1, int var2) {
		this.verticesCount = 0;
		this.indicesCount = 0;
		this.field1690 = 0;
		this.field1699 = 0;
		this.isSingleTile = false;
		this.xMidOffset = -1;
		this.yMidOffset = -1;
		this.zMidOffset = -1;
		boolean var3 = false;
		boolean var4 = false;
		boolean var5 = false;
		boolean var6 = false;
		this.verticesCount = 0;
		this.indicesCount = 0;
		this.field1699 = 0;
		this.field1690 = -1;

		int var7;
		Model var8;
		for (var7 = 0; var7 < var2; ++var7) {
			var8 = var1[var7];
			if (var8 != null) {
				this.verticesCount += var8.verticesCount;
				this.indicesCount += var8.indicesCount;
				this.field1699 += var8.field1699;
				if (var8.faceRenderPriorities != null) {
					var3 = true;
				} else {
					if (this.field1690 == -1) {
						this.field1690 = var8.field1690;
					}

					if (this.field1690 != var8.field1690) {
						var3 = true;
					}
				}

				var4 |= var8.faceAlphas != null;
				var5 |= var8.faceTextures != null;
				var6 |= var8.field1666 != null;
			}
		}

		this.verticesX = new int[this.verticesCount];
		this.verticesY = new int[this.verticesCount];
		this.verticesZ = new int[this.verticesCount];
		this.indices1 = new int[this.indicesCount];
		this.indices2 = new int[this.indicesCount];
		this.indices3 = new int[this.indicesCount];
		this.faceColors1 = new int[this.indicesCount];
		this.faceColors2 = new int[this.indicesCount];
		this.faceColors3 = new int[this.indicesCount];
		if (var3) {
			this.faceRenderPriorities = new byte[this.indicesCount];
		}

		if (var4) {
			this.faceAlphas = new byte[this.indicesCount];
		}

		if (var5) {
			this.faceTextures = new short[this.indicesCount];
		}

		if (var6) {
			this.field1666 = new byte[this.indicesCount];
		}

		if (this.field1699 > 0) {
			this.field1691 = new int[this.field1699];
			this.field1671 = new int[this.field1699];
			this.field1672 = new int[this.field1699];
		}

		this.verticesCount = 0;
		this.indicesCount = 0;
		this.field1699 = 0;

		for (var7 = 0; var7 < var2; ++var7) {
			var8 = var1[var7];
			if (var8 != null) {
				int var9;
				for (var9 = 0; var9 < var8.indicesCount; ++var9) {
					this.indices1[this.indicesCount] = this.verticesCount + var8.indices1[var9];
					this.indices2[this.indicesCount] = this.verticesCount + var8.indices2[var9];
					this.indices3[this.indicesCount] = this.verticesCount + var8.indices3[var9];
					this.faceColors1[this.indicesCount] = var8.faceColors1[var9];
					this.faceColors2[this.indicesCount] = var8.faceColors2[var9];
					this.faceColors3[this.indicesCount] = var8.faceColors3[var9];
					if (var3) {
						if (var8.faceRenderPriorities != null) {
							this.faceRenderPriorities[this.indicesCount] = var8.faceRenderPriorities[var9];
						} else {
							this.faceRenderPriorities[this.indicesCount] = var8.field1690;
						}
					}

					if (var4 && var8.faceAlphas != null) {
						this.faceAlphas[this.indicesCount] = var8.faceAlphas[var9];
					}

					if (var5) {
						if (var8.faceTextures != null) {
							this.faceTextures[this.indicesCount] = var8.faceTextures[var9];
						} else {
							this.faceTextures[this.indicesCount] = -1;
						}
					}

					if (var6) {
						if (var8.field1666 != null && var8.field1666[var9] != -1) {
							this.field1666[this.indicesCount] = (byte)(this.field1699 + var8.field1666[var9]);
						} else {
							this.field1666[this.indicesCount] = -1;
						}
					}

					++this.indicesCount;
				}

				for (var9 = 0; var9 < var8.field1699; ++var9) {
					this.field1691[this.field1699] = this.verticesCount + var8.field1691[var9];
					this.field1671[this.field1699] = this.verticesCount + var8.field1671[var9];
					this.field1672[this.field1699] = this.verticesCount + var8.field1672[var9];
					++this.field1699;
				}

				for (var9 = 0; var9 < var8.verticesCount; ++var9) {
					this.verticesX[this.verticesCount] = var8.verticesX[var9];
					this.verticesY[this.verticesCount] = var8.verticesY[var9];
					this.verticesZ[this.verticesCount] = var8.verticesZ[var9];
					++this.verticesCount;
				}
			}
		}

	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "([[IIIIZI)Ldo;"
	)
	@Export("contourGround")
	public Model contourGround(int[][] var1, int var2, int var3, int var4, boolean var5, int var6) {
		this.calculateBoundsCylinder();
		int var7 = var2 - this.xzRadius;
		int var8 = var2 + this.xzRadius;
		int var9 = var4 - this.xzRadius;
		int var10 = var4 + this.xzRadius;
		if (var7 >= 0 && var8 + 128 >> 7 < var1.length && var9 >= 0 && var10 + 128 >> 7 < var1[0].length) {
			var7 >>= 7;
			var8 = var8 + 127 >> 7;
			var9 >>= 7;
			var10 = var10 + 127 >> 7;
			if (var3 == var1[var7][var9] && var3 == var1[var8][var9] && var3 == var1[var7][var10] && var3 == var1[var8][var10]) {
				return this;
			} else {
				Model var11;
				if (var5) {
					var11 = new Model();
					var11.verticesCount = this.verticesCount;
					var11.indicesCount = this.indicesCount;
					var11.field1699 = this.field1699;
					var11.verticesX = this.verticesX;
					var11.verticesZ = this.verticesZ;
					var11.indices1 = this.indices1;
					var11.indices2 = this.indices2;
					var11.indices3 = this.indices3;
					var11.faceColors1 = this.faceColors1;
					var11.faceColors2 = this.faceColors2;
					var11.faceColors3 = this.faceColors3;
					var11.faceRenderPriorities = this.faceRenderPriorities;
					var11.faceAlphas = this.faceAlphas;
					var11.field1666 = this.field1666;
					var11.faceTextures = this.faceTextures;
					var11.field1690 = this.field1690;
					var11.field1691 = this.field1691;
					var11.field1671 = this.field1671;
					var11.field1672 = this.field1672;
					var11.vertexLabels = this.vertexLabels;
					var11.faceLabelsAlpha = this.faceLabelsAlpha;
					var11.isSingleTile = this.isSingleTile;
					var11.verticesY = new int[var11.verticesCount];
				} else {
					var11 = this;
				}

				int var12;
				int var13;
				int var14;
				int var15;
				int var16;
				int var17;
				int var18;
				int var19;
				int var20;
				int var21;
				if (var6 == 0) {
					for (var12 = 0; var12 < var11.verticesCount; ++var12) {
						var13 = var2 + this.verticesX[var12];
						var14 = var4 + this.verticesZ[var12];
						var15 = var13 & 127;
						var16 = var14 & 127;
						var17 = var13 >> 7;
						var18 = var14 >> 7;
						var19 = var1[var17][var18] * (128 - var15) + var1[var17 + 1][var18] * var15 >> 7;
						var20 = var1[var17][var18 + 1] * (128 - var15) + var15 * var1[var17 + 1][var18 + 1] >> 7;
						var21 = var19 * (128 - var16) + var20 * var16 >> 7;
						var11.verticesY[var12] = var21 + this.verticesY[var12] - var3;
					}
				} else {
					for (var12 = 0; var12 < var11.verticesCount; ++var12) {
						var13 = (-this.verticesY[var12] << 16) / super.height;
						if (var13 < var6) {
							var14 = var2 + this.verticesX[var12];
							var15 = var4 + this.verticesZ[var12];
							var16 = var14 & 127;
							var17 = var15 & 127;
							var18 = var14 >> 7;
							var19 = var15 >> 7;
							var20 = var1[var18][var19] * (128 - var16) + var1[var18 + 1][var19] * var16 >> 7;
							var21 = var1[var18][var19 + 1] * (128 - var16) + var16 * var1[var18 + 1][var19 + 1] >> 7;
							int var22 = var20 * (128 - var17) + var21 * var17 >> 7;
							var11.verticesY[var12] = (var6 - var13) * (var22 - var3) / var6 + this.verticesY[var12];
						}
					}
				}

				var11.resetBounds();
				return var11;
			}
		} else {
			return this;
		}
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(Z)Ldo;"
	)
	@Export("toSharedSequenceModel")
	public Model toSharedSequenceModel(boolean var1) {
		if (!var1 && Model_sharedSequenceModelFaceAlphas.length < this.indicesCount) {
			Model_sharedSequenceModelFaceAlphas = new byte[this.indicesCount + 100];
		}

		return this.buildSharedModel(var1, Model_sharedSequenceModel, Model_sharedSequenceModelFaceAlphas);
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(Z)Ldo;"
	)
	@Export("toSharedSpotAnimationModel")
	public Model toSharedSpotAnimationModel(boolean var1) {
		if (!var1 && Model_sharedSpotAnimationModelFaceAlphas.length < this.indicesCount) {
			Model_sharedSpotAnimationModelFaceAlphas = new byte[this.indicesCount + 100];
		}

		return this.buildSharedModel(var1, Model_sharedSpotAnimationModel, Model_sharedSpotAnimationModelFaceAlphas);
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(ZLdo;[B)Ldo;"
	)
	@Export("buildSharedModel")
	Model buildSharedModel(boolean var1, Model var2, byte[] var3) {
		var2.verticesCount = this.verticesCount;
		var2.indicesCount = this.indicesCount;
		var2.field1699 = this.field1699;
		if (var2.verticesX == null || var2.verticesX.length < this.verticesCount) {
			var2.verticesX = new int[this.verticesCount + 100];
			var2.verticesY = new int[this.verticesCount + 100];
			var2.verticesZ = new int[this.verticesCount + 100];
		}

		int var4;
		for (var4 = 0; var4 < this.verticesCount; ++var4) {
			var2.verticesX[var4] = this.verticesX[var4];
			var2.verticesY[var4] = this.verticesY[var4];
			var2.verticesZ[var4] = this.verticesZ[var4];
		}

		if (var1) {
			var2.faceAlphas = this.faceAlphas;
		} else {
			var2.faceAlphas = var3;
			if (this.faceAlphas == null) {
				for (var4 = 0; var4 < this.indicesCount; ++var4) {
					var2.faceAlphas[var4] = 0;
				}
			} else {
				for (var4 = 0; var4 < this.indicesCount; ++var4) {
					var2.faceAlphas[var4] = this.faceAlphas[var4];
				}
			}
		}

		var2.indices1 = this.indices1;
		var2.indices2 = this.indices2;
		var2.indices3 = this.indices3;
		var2.faceColors1 = this.faceColors1;
		var2.faceColors2 = this.faceColors2;
		var2.faceColors3 = this.faceColors3;
		var2.faceRenderPriorities = this.faceRenderPriorities;
		var2.field1666 = this.field1666;
		var2.faceTextures = this.faceTextures;
		var2.field1690 = this.field1690;
		var2.field1691 = this.field1691;
		var2.field1671 = this.field1671;
		var2.field1672 = this.field1672;
		var2.vertexLabels = this.vertexLabels;
		var2.faceLabelsAlpha = this.faceLabelsAlpha;
		var2.isSingleTile = this.isSingleTile;
		var2.resetBounds();
		return var2;
	}

	@ObfuscatedName("u")
	@Export("calculateBoundingBox")
	void calculateBoundingBox(int var1) {
		if (this.xMidOffset == -1) {
			int var2 = 0;
			int var3 = 0;
			int var4 = 0;
			int var5 = 0;
			int var6 = 0;
			int var7 = 0;
			int var8 = Model_cosine[var1];
			int var9 = Model_sine[var1];

			for (int var10 = 0; var10 < this.verticesCount; ++var10) {
				int var11 = Rasterizer3D.method2943(this.verticesX[var10], this.verticesZ[var10], var8, var9);
				int var12 = this.verticesY[var10];
				int var13 = Rasterizer3D.method2944(this.verticesX[var10], this.verticesZ[var10], var8, var9);
				if (var11 < var2) {
					var2 = var11;
				}

				if (var11 > var5) {
					var5 = var11;
				}

				if (var12 < var3) {
					var3 = var12;
				}

				if (var12 > var6) {
					var6 = var12;
				}

				if (var13 < var4) {
					var4 = var13;
				}

				if (var13 > var7) {
					var7 = var13;
				}
			}

			this.xMid = (var5 + var2) / 2;
			this.yMid = (var6 + var3) / 2;
			this.zMid = (var7 + var4) / 2;
			this.xMidOffset = (var5 - var2 + 1) / 2;
			this.yMidOffset = (var6 - var3 + 1) / 2;
			this.zMidOffset = (var7 - var4 + 1) / 2;
			if (this.xMidOffset < 32) {
				this.xMidOffset = 32;
			}

			if (this.zMidOffset < 32) {
				this.zMidOffset = 32;
			}

			if (this.isSingleTile) {
				this.xMidOffset += 8;
				this.zMidOffset += 8;
			}

		}
	}

	@ObfuscatedName("n")
	@Export("calculateBoundsCylinder")
	public void calculateBoundsCylinder() {
		if (this.boundsType != 1) {
			this.boundsType = 1;
			super.height = 0;
			this.bottomY = 0;
			this.xzRadius = 0;

			for (int var1 = 0; var1 < this.verticesCount; ++var1) {
				int var2 = this.verticesX[var1];
				int var3 = this.verticesY[var1];
				int var4 = this.verticesZ[var1];
				if (-var3 > super.height) {
					super.height = -var3;
				}

				if (var3 > this.bottomY) {
					this.bottomY = var3;
				}

				int var5 = var2 * var2 + var4 * var4;
				if (var5 > this.xzRadius) {
					this.xzRadius = var5;
				}
			}

			this.xzRadius = (int)(Math.sqrt((double)this.xzRadius) + 0.99D);
			this.radius = (int)(Math.sqrt((double)(this.xzRadius * this.xzRadius + super.height * super.height)) + 0.99D);
			this.diameter = this.radius + (int)(Math.sqrt((double)(this.xzRadius * this.xzRadius + this.bottomY * this.bottomY)) + 0.99D);
		}
	}

	@ObfuscatedName("t")
	void method2887() {
		if (this.boundsType != 2) {
			this.boundsType = 2;
			this.xzRadius = 0;

			for (int var1 = 0; var1 < this.verticesCount; ++var1) {
				int var2 = this.verticesX[var1];
				int var3 = this.verticesY[var1];
				int var4 = this.verticesZ[var1];
				int var5 = var2 * var2 + var4 * var4 + var3 * var3;
				if (var5 > this.xzRadius) {
					this.xzRadius = var5;
				}
			}

			this.xzRadius = (int)(Math.sqrt((double)this.xzRadius) + 0.99D);
			this.radius = this.xzRadius;
			this.diameter = this.xzRadius + this.xzRadius;
		}
	}

	@ObfuscatedName("q")
	public int method2839() {
		this.calculateBoundsCylinder();
		return this.xzRadius;
	}

	@ObfuscatedName("d")
	@Export("resetBounds")
	void resetBounds() {
		this.boundsType = 0;
		this.xMidOffset = -1;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(Lee;I)V"
	)
	@Export("animate")
	public void animate(Frames var1, int var2) {
		if (this.vertexLabels != null) {
			if (var2 != -1) {
				Animation var3 = var1.frames[var2];
				Skeleton var4 = var3.skeleton;
				Model_transformTempX = 0;
				Model_transformTempY = 0;
				Model_transformTempZ = 0;

				for (int var5 = 0; var5 < var3.transformCount; ++var5) {
					int var6 = var3.transformSkeletonLabels[var5];
					this.transform(var4.transformTypes[var6], var4.labels[var6], var3.transformXs[var5], var3.transformYs[var5], var3.transformZs[var5]);
				}

				this.resetBounds();
			}
		}
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Lee;ILee;I[I)V"
	)
	@Export("animate2")
	public void animate2(Frames var1, int var2, Frames var3, int var4, int[] var5) {
		if (var2 != -1) {
			if (var5 != null && var4 != -1) {
				Animation var6 = var1.frames[var2];
				Animation var7 = var3.frames[var4];
				Skeleton var8 = var6.skeleton;
				Model_transformTempX = 0;
				Model_transformTempY = 0;
				Model_transformTempZ = 0;
				byte var9 = 0;
				int var13 = var9 + 1;
				int var10 = var5[var9];

				int var11;
				int var12;
				for (var11 = 0; var11 < var6.transformCount; ++var11) {
					for (var12 = var6.transformSkeletonLabels[var11]; var12 > var10; var10 = var5[var13++]) {
					}

					if (var12 != var10 || var8.transformTypes[var12] == 0) {
						this.transform(var8.transformTypes[var12], var8.labels[var12], var6.transformXs[var11], var6.transformYs[var11], var6.transformZs[var11]);
					}
				}

				Model_transformTempX = 0;
				Model_transformTempY = 0;
				Model_transformTempZ = 0;
				var9 = 0;
				var13 = var9 + 1;
				var10 = var5[var9];

				for (var11 = 0; var11 < var7.transformCount; ++var11) {
					for (var12 = var7.transformSkeletonLabels[var11]; var12 > var10; var10 = var5[var13++]) {
					}

					if (var12 == var10 || var8.transformTypes[var12] == 0) {
						this.transform(var8.transformTypes[var12], var8.labels[var12], var7.transformXs[var11], var7.transformYs[var11], var7.transformZs[var11]);
					}
				}

				this.resetBounds();
			} else {
				this.animate(var1, var2);
			}
		}
	}

	@ObfuscatedName("r")
	@Export("transform")
	void transform(int var1, int[] var2, int var3, int var4, int var5) {
		int var6 = var2.length;
		int var7;
		int var8;
		int var11;
		int var12;
		if (var1 == 0) {
			var7 = 0;
			Model_transformTempX = 0;
			Model_transformTempY = 0;
			Model_transformTempZ = 0;

			for (var8 = 0; var8 < var6; ++var8) {
				int var9 = var2[var8];
				if (var9 < this.vertexLabels.length) {
					int[] var10 = this.vertexLabels[var9];

					for (var11 = 0; var11 < var10.length; ++var11) {
						var12 = var10[var11];
						Model_transformTempX += this.verticesX[var12];
						Model_transformTempY += this.verticesY[var12];
						Model_transformTempZ += this.verticesZ[var12];
						++var7;
					}
				}
			}

			if (var7 > 0) {
				Model_transformTempX = var3 + Model_transformTempX / var7;
				Model_transformTempY = var4 + Model_transformTempY / var7;
				Model_transformTempZ = var5 + Model_transformTempZ / var7;
			} else {
				Model_transformTempX = var3;
				Model_transformTempY = var4;
				Model_transformTempZ = var5;
			}

		} else {
			int[] var10000;
			int[] var18;
			int var19;
			if (var1 == 1) {
				for (var7 = 0; var7 < var6; ++var7) {
					var8 = var2[var7];
					if (var8 < this.vertexLabels.length) {
						var18 = this.vertexLabels[var8];

						for (var19 = 0; var19 < var18.length; ++var19) {
							var11 = var18[var19];
							var10000 = this.verticesX;
							var10000[var11] += var3;
							var10000 = this.verticesY;
							var10000[var11] += var4;
							var10000 = this.verticesZ;
							var10000[var11] += var5;
						}
					}
				}

			} else if (var1 == 2) {
				for (var7 = 0; var7 < var6; ++var7) {
					var8 = var2[var7];
					if (var8 < this.vertexLabels.length) {
						var18 = this.vertexLabels[var8];

						for (var19 = 0; var19 < var18.length; ++var19) {
							var11 = var18[var19];
							var10000 = this.verticesX;
							var10000[var11] -= Model_transformTempX;
							var10000 = this.verticesY;
							var10000[var11] -= Model_transformTempY;
							var10000 = this.verticesZ;
							var10000[var11] -= Model_transformTempZ;
							var12 = (var3 & 255) * 8;
							int var13 = (var4 & 255) * 8;
							int var14 = (var5 & 255) * 8;
							int var15;
							int var16;
							int var17;
							if (var14 != 0) {
								var15 = Model_sine[var14];
								var16 = Model_cosine[var14];
								var17 = var15 * this.verticesY[var11] + var16 * this.verticesX[var11] >> 16;
								this.verticesY[var11] = var16 * this.verticesY[var11] - var15 * this.verticesX[var11] >> 16;
								this.verticesX[var11] = var17;
							}

							if (var12 != 0) {
								var15 = Model_sine[var12];
								var16 = Model_cosine[var12];
								var17 = var16 * this.verticesY[var11] - var15 * this.verticesZ[var11] >> 16;
								this.verticesZ[var11] = var15 * this.verticesY[var11] + var16 * this.verticesZ[var11] >> 16;
								this.verticesY[var11] = var17;
							}

							if (var13 != 0) {
								var15 = Model_sine[var13];
								var16 = Model_cosine[var13];
								var17 = var15 * this.verticesZ[var11] + var16 * this.verticesX[var11] >> 16;
								this.verticesZ[var11] = var16 * this.verticesZ[var11] - var15 * this.verticesX[var11] >> 16;
								this.verticesX[var11] = var17;
							}

							var10000 = this.verticesX;
							var10000[var11] += Model_transformTempX;
							var10000 = this.verticesY;
							var10000[var11] += Model_transformTempY;
							var10000 = this.verticesZ;
							var10000[var11] += Model_transformTempZ;
						}
					}
				}

			} else if (var1 == 3) {
				for (var7 = 0; var7 < var6; ++var7) {
					var8 = var2[var7];
					if (var8 < this.vertexLabels.length) {
						var18 = this.vertexLabels[var8];

						for (var19 = 0; var19 < var18.length; ++var19) {
							var11 = var18[var19];
							var10000 = this.verticesX;
							var10000[var11] -= Model_transformTempX;
							var10000 = this.verticesY;
							var10000[var11] -= Model_transformTempY;
							var10000 = this.verticesZ;
							var10000[var11] -= Model_transformTempZ;
							this.verticesX[var11] = var3 * this.verticesX[var11] / 128;
							this.verticesY[var11] = var4 * this.verticesY[var11] / 128;
							this.verticesZ[var11] = var5 * this.verticesZ[var11] / 128;
							var10000 = this.verticesX;
							var10000[var11] += Model_transformTempX;
							var10000 = this.verticesY;
							var10000[var11] += Model_transformTempY;
							var10000 = this.verticesZ;
							var10000[var11] += Model_transformTempZ;
						}
					}
				}

			} else if (var1 == 5) {
				if (this.faceLabelsAlpha != null && this.faceAlphas != null) {
					for (var7 = 0; var7 < var6; ++var7) {
						var8 = var2[var7];
						if (var8 < this.faceLabelsAlpha.length) {
							var18 = this.faceLabelsAlpha[var8];

							for (var19 = 0; var19 < var18.length; ++var19) {
								var11 = var18[var19];
								var12 = (this.faceAlphas[var11] & 255) + var3 * 8;
								if (var12 < 0) {
									var12 = 0;
								} else if (var12 > 255) {
									var12 = 255;
								}

								this.faceAlphas[var11] = (byte)var12;
							}
						}
					}
				}

			}
		}
	}

	@ObfuscatedName("y")
	@Export("rotateY90Ccw")
	public void rotateY90Ccw() {
		for (int var1 = 0; var1 < this.verticesCount; ++var1) {
			int var2 = this.verticesX[var1];
			this.verticesX[var1] = this.verticesZ[var1];
			this.verticesZ[var1] = -var2;
		}

		this.resetBounds();
	}

	@ObfuscatedName("p")
	@Export("rotateY180")
	public void rotateY180() {
		for (int var1 = 0; var1 < this.verticesCount; ++var1) {
			this.verticesX[var1] = -this.verticesX[var1];
			this.verticesZ[var1] = -this.verticesZ[var1];
		}

		this.resetBounds();
	}

	@ObfuscatedName("g")
	@Export("rotateY270Ccw")
	public void rotateY270Ccw() {
		for (int var1 = 0; var1 < this.verticesCount; ++var1) {
			int var2 = this.verticesZ[var1];
			this.verticesZ[var1] = this.verticesX[var1];
			this.verticesX[var1] = -var2;
		}

		this.resetBounds();
	}

	@ObfuscatedName("e")
	@Export("rotateZ")
	public void rotateZ(int var1) {
		int var2 = Model_sine[var1];
		int var3 = Model_cosine[var1];

		for (int var4 = 0; var4 < this.verticesCount; ++var4) {
			int var5 = var3 * this.verticesY[var4] - var2 * this.verticesZ[var4] >> 16;
			this.verticesZ[var4] = var2 * this.verticesY[var4] + var3 * this.verticesZ[var4] >> 16;
			this.verticesY[var4] = var5;
		}

		this.resetBounds();
	}

	@ObfuscatedName("z")
	@Export("offsetBy")
	public void offsetBy(int var1, int var2, int var3) {
		for (int var4 = 0; var4 < this.verticesCount; ++var4) {
			int[] var10000 = this.verticesX;
			var10000[var4] += var1;
			var10000 = this.verticesY;
			var10000[var4] += var2;
			var10000 = this.verticesZ;
			var10000[var4] += var3;
		}

		this.resetBounds();
	}

	@ObfuscatedName("w")
	@Export("scale")
	public void scale(int var1, int var2, int var3) {
		for (int var4 = 0; var4 < this.verticesCount; ++var4) {
			this.verticesX[var4] = this.verticesX[var4] * var1 / 128;
			this.verticesY[var4] = var2 * this.verticesY[var4] / 128;
			this.verticesZ[var4] = var3 * this.verticesZ[var4] / 128;
		}

		this.resetBounds();
	}

	@ObfuscatedName("l")
	public final void method2874(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
		field1696[0] = -1;
		if (this.boundsType != 2 && this.boundsType != 1) {
			this.method2887();
		}

		int var8 = Rasterizer3D.Rasterizer3D_clipMidX;
		int var9 = Rasterizer3D.Rasterizer3D_clipMidY;
		int var10 = Model_sine[var1];
		int var11 = Model_cosine[var1];
		int var12 = Model_sine[var2];
		int var13 = Model_cosine[var2];
		int var14 = Model_sine[var3];
		int var15 = Model_cosine[var3];
		int var16 = Model_sine[var4];
		int var17 = Model_cosine[var4];
		int var18 = var16 * var6 + var17 * var7 >> 16;

		for (int var19 = 0; var19 < this.verticesCount; ++var19) {
			int var20 = this.verticesX[var19];
			int var21 = this.verticesY[var19];
			int var22 = this.verticesZ[var19];
			int var23;
			if (var3 != 0) {
				var23 = var21 * var14 + var20 * var15 >> 16;
				var21 = var21 * var15 - var20 * var14 >> 16;
				var20 = var23;
			}

			if (var1 != 0) {
				var23 = var21 * var11 - var22 * var10 >> 16;
				var22 = var21 * var10 + var22 * var11 >> 16;
				var21 = var23;
			}

			if (var2 != 0) {
				var23 = var22 * var12 + var20 * var13 >> 16;
				var22 = var22 * var13 - var20 * var12 >> 16;
				var20 = var23;
			}

			var20 += var5;
			var21 += var6;
			var22 += var7;
			var23 = var21 * var17 - var22 * var16 >> 16;
			var22 = var21 * var16 + var22 * var17 >> 16;
			field1692[var19] = var22 - var18;
			modelViewportXs[var19] = var20 * Rasterizer3D.Rasterizer3D_zoom / var22 + var8;
			modelViewportYs[var19] = var23 * Rasterizer3D.Rasterizer3D_zoom / var22 + var9;
			if (this.field1699 > 0) {
				field1708[var19] = var20;
				field1663[var19] = var23;
				field1695[var19] = var22;
			}
		}

		try {
			this.draw0(false, false, false, 0L);
		} catch (Exception var25) {
		}

	}

	@ObfuscatedName("h")
	public final void method2810(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
		field1696[0] = -1;
		if (this.boundsType != 2 && this.boundsType != 1) {
			this.method2887();
		}

		int var9 = Rasterizer3D.Rasterizer3D_clipMidX;
		int var10 = Rasterizer3D.Rasterizer3D_clipMidY;
		int var11 = Model_sine[var1];
		int var12 = Model_cosine[var1];
		int var13 = Model_sine[var2];
		int var14 = Model_cosine[var2];
		int var15 = Model_sine[var3];
		int var16 = Model_cosine[var3];
		int var17 = Model_sine[var4];
		int var18 = Model_cosine[var4];
		int var19 = var17 * var6 + var18 * var7 >> 16;

		for (int var20 = 0; var20 < this.verticesCount; ++var20) {
			int var21 = this.verticesX[var20];
			int var22 = this.verticesY[var20];
			int var23 = this.verticesZ[var20];
			int var24;
			if (var3 != 0) {
				var24 = var22 * var15 + var21 * var16 >> 16;
				var22 = var22 * var16 - var21 * var15 >> 16;
				var21 = var24;
			}

			if (var1 != 0) {
				var24 = var22 * var12 - var23 * var11 >> 16;
				var23 = var22 * var11 + var23 * var12 >> 16;
				var22 = var24;
			}

			if (var2 != 0) {
				var24 = var23 * var13 + var21 * var14 >> 16;
				var23 = var23 * var14 - var21 * var13 >> 16;
				var21 = var24;
			}

			var21 += var5;
			var22 += var6;
			var23 += var7;
			var24 = var22 * var18 - var23 * var17 >> 16;
			var23 = var22 * var17 + var23 * var18 >> 16;
			field1692[var20] = var23 - var19;
			modelViewportXs[var20] = var9 + var21 * Rasterizer3D.Rasterizer3D_zoom / var8;
			modelViewportYs[var20] = var10 + var24 * Rasterizer3D.Rasterizer3D_zoom / var8;
			if (this.field1699 > 0) {
				field1708[var20] = var21;
				field1663[var20] = var24;
				field1695[var20] = var23;
			}
		}

		try {
			this.draw0(false, false, false, 0L);
		} catch (Exception var26) {
		}

	}

	@ObfuscatedName("v")
	@Export("draw0")
	final void draw0(boolean var1, boolean var2, boolean var3, long var4) {
		if (this.diameter < 1600) {
			int var6;
			for (var6 = 0; var6 < this.diameter; ++var6) {
				field1696[var6] = 0;
			}

			var6 = var3 ? 20 : 5;

			int var7;
			int var8;
			int var10;
			int var11;
			int var12;
			int var13;
			int var15;
			int var16;
			int var18;
			int var27;
			for (var7 = 0; var7 < this.indicesCount; ++var7) {
				if (this.faceColors3[var7] != -2) {
					var8 = this.indices1[var7];
					var27 = this.indices2[var7];
					var10 = this.indices3[var7];
					var11 = modelViewportXs[var8];
					var12 = modelViewportXs[var27];
					var13 = modelViewportXs[var10];
					int var14;
					int var17;
					if (!var1 || var11 != -5000 && var12 != -5000 && var13 != -5000) {
						if (var2) {
							var15 = modelViewportYs[var8];
							var16 = modelViewportYs[var27];
							var17 = modelViewportYs[var10];
							var18 = var6 + ViewportMouse.ViewportMouse_y;
							boolean var32;
							if (var18 < var15 && var18 < var16 && var18 < var17) {
								var32 = false;
							} else {
								var18 = ViewportMouse.ViewportMouse_y - var6;
								if (var18 > var15 && var18 > var16 && var18 > var17) {
									var32 = false;
								} else {
									var18 = var6 + ViewportMouse.ViewportMouse_x;
									if (var18 < var11 && var18 < var12 && var18 < var13) {
										var32 = false;
									} else {
										var18 = ViewportMouse.ViewportMouse_x - var6;
										if (var18 > var11 && var18 > var12 && var18 > var13) {
											var32 = false;
										} else {
											var32 = true;
										}
									}
								}
							}

							if (var32) {
								class42.method752(var4);
								var2 = false;
							}
						}

						if ((var11 - var12) * (modelViewportYs[var10] - modelViewportYs[var27]) - (var13 - var12) * (modelViewportYs[var8] - modelViewportYs[var27]) > 0) {
							field1689[var7] = false;
							if (var11 >= 0 && var12 >= 0 && var13 >= 0 && var11 <= Rasterizer3D.Rasterizer3D_clipWidth && var12 <= Rasterizer3D.Rasterizer3D_clipWidth && var13 <= Rasterizer3D.Rasterizer3D_clipWidth) {
								field1670[var7] = false;
							} else {
								field1670[var7] = true;
							}

							var14 = (field1692[var8] + field1692[var27] + field1692[var10]) / 3 + this.radius;
							field1698[var14][field1696[var14]++] = var7;
						}
					} else {
						var14 = field1708[var8];
						var15 = field1708[var27];
						var16 = field1708[var10];
						var17 = field1663[var8];
						var18 = field1663[var27];
						int var19 = field1663[var10];
						int var20 = field1695[var8];
						int var21 = field1695[var27];
						int var22 = field1695[var10];
						var14 -= var15;
						var16 -= var15;
						var17 -= var18;
						var19 -= var18;
						var20 -= var21;
						var22 -= var21;
						int var23 = var17 * var22 - var20 * var19;
						int var24 = var20 * var16 - var14 * var22;
						int var25 = var14 * var19 - var17 * var16;
						if (var15 * var23 + var18 * var24 + var21 * var25 > 0) {
							field1689[var7] = true;
							int var26 = (field1692[var8] + field1692[var27] + field1692[var10]) / 3 + this.radius;
							field1698[var26][field1696[var26]++] = var7;
						}
					}
				}
			}

			int[] var9;
			if (this.faceRenderPriorities == null) {
				for (var7 = this.diameter - 1; var7 >= 0; --var7) {
					var8 = field1696[var7];
					if (var8 > 0) {
						var9 = field1698[var7];

						for (var10 = 0; var10 < var8; ++var10) {
							this.method2830(var9[var10]);
						}
					}
				}

			} else {
				for (var7 = 0; var7 < 12; ++var7) {
					field1669[var7] = 0;
					field1703[var7] = 0;
				}

				for (var7 = this.diameter - 1; var7 >= 0; --var7) {
					var8 = field1696[var7];
					if (var8 > 0) {
						var9 = field1698[var7];

						for (var10 = 0; var10 < var8; ++var10) {
							var11 = var9[var10];
							byte var31 = this.faceRenderPriorities[var11];
							var13 = field1669[var31]++;
							field1700[var31][var13] = var11;
							if (var31 < 10) {
								int[] var10000 = field1703;
								var10000[var31] += var7;
							} else if (var31 == 10) {
								field1701[var13] = var7;
							} else {
								field1660[var13] = var7;
							}
						}
					}
				}

				var7 = 0;
				if (field1669[1] > 0 || field1669[2] > 0) {
					var7 = (field1703[1] + field1703[2]) / (field1669[1] + field1669[2]);
				}

				var8 = 0;
				if (field1669[3] > 0 || field1669[4] > 0) {
					var8 = (field1703[3] + field1703[4]) / (field1669[3] + field1669[4]);
				}

				var27 = 0;
				if (field1669[6] > 0 || field1669[8] > 0) {
					var27 = (field1703[8] + field1703[6]) / (field1669[8] + field1669[6]);
				}

				var11 = 0;
				var12 = field1669[10];
				int[] var28 = field1700[10];
				int[] var29 = field1701;
				if (var11 == var12) {
					var11 = 0;
					var12 = field1669[11];
					var28 = field1700[11];
					var29 = field1660;
				}

				if (var11 < var12) {
					var10 = var29[var11];
				} else {
					var10 = -1000;
				}

				for (var15 = 0; var15 < 10; ++var15) {
					while (var15 == 0 && var10 > var7) {
						this.method2830(var28[var11++]);
						if (var11 == var12 && var28 != field1700[11]) {
							var11 = 0;
							var12 = field1669[11];
							var28 = field1700[11];
							var29 = field1660;
						}

						if (var11 < var12) {
							var10 = var29[var11];
						} else {
							var10 = -1000;
						}
					}

					while (var15 == 3 && var10 > var8) {
						this.method2830(var28[var11++]);
						if (var11 == var12 && var28 != field1700[11]) {
							var11 = 0;
							var12 = field1669[11];
							var28 = field1700[11];
							var29 = field1660;
						}

						if (var11 < var12) {
							var10 = var29[var11];
						} else {
							var10 = -1000;
						}
					}

					while (var15 == 5 && var10 > var27) {
						this.method2830(var28[var11++]);
						if (var11 == var12 && var28 != field1700[11]) {
							var11 = 0;
							var12 = field1669[11];
							var28 = field1700[11];
							var29 = field1660;
						}

						if (var11 < var12) {
							var10 = var29[var11];
						} else {
							var10 = -1000;
						}
					}

					var16 = field1669[var15];
					int[] var30 = field1700[var15];

					for (var18 = 0; var18 < var16; ++var18) {
						this.method2830(var30[var18]);
					}
				}

				while (var10 != -1000) {
					this.method2830(var28[var11++]);
					if (var11 == var12 && var28 != field1700[11]) {
						var11 = 0;
						var28 = field1700[11];
						var12 = field1669[11];
						var29 = field1660;
					}

					if (var11 < var12) {
						var10 = var29[var11];
					} else {
						var10 = -1000;
					}
				}

			}
		}
	}

	@ObfuscatedName("m")
	final void method2830(int var1) {
		if (field1689[var1]) {
			this.method2829(var1);
		} else {
			int var2 = this.indices1[var1];
			int var3 = this.indices2[var1];
			int var4 = this.indices3[var1];
			Rasterizer3D.field1760 = field1670[var1];
			if (this.faceAlphas == null) {
				Rasterizer3D.Rasterizer3D_alpha = 0;
			} else {
				Rasterizer3D.Rasterizer3D_alpha = this.faceAlphas[var1] & 255;
			}

			if (this.faceTextures != null && this.faceTextures[var1] != -1) {
				int var5;
				int var6;
				int var7;
				if (this.field1666 != null && this.field1666[var1] != -1) {
					int var8 = this.field1666[var1] & 255;
					var5 = this.field1691[var8];
					var6 = this.field1671[var8];
					var7 = this.field1672[var8];
				} else {
					var5 = var2;
					var6 = var3;
					var7 = var4;
				}

				if (this.faceColors3[var1] == -1) {
					Rasterizer3D.method2938(modelViewportYs[var2], modelViewportYs[var3], modelViewportYs[var4], modelViewportXs[var2], modelViewportXs[var3], modelViewportXs[var4], this.faceColors1[var1], this.faceColors1[var1], this.faceColors1[var1], field1708[var5], field1708[var6], field1708[var7], field1663[var5], field1663[var6], field1663[var7], field1695[var5], field1695[var6], field1695[var7], this.faceTextures[var1]);
				} else {
					Rasterizer3D.method2938(modelViewportYs[var2], modelViewportYs[var3], modelViewportYs[var4], modelViewportXs[var2], modelViewportXs[var3], modelViewportXs[var4], this.faceColors1[var1], this.faceColors2[var1], this.faceColors3[var1], field1708[var5], field1708[var6], field1708[var7], field1663[var5], field1663[var6], field1663[var7], field1695[var5], field1695[var6], field1695[var7], this.faceTextures[var1]);
				}
			} else if (this.faceColors3[var1] == -1) {
				Rasterizer3D.method2936(modelViewportYs[var2], modelViewportYs[var3], modelViewportYs[var4], modelViewportXs[var2], modelViewportXs[var3], modelViewportXs[var4], field1715[this.faceColors1[var1]]);
			} else {
				Rasterizer3D.method2934(modelViewportYs[var2], modelViewportYs[var3], modelViewportYs[var4], modelViewportXs[var2], modelViewportXs[var3], modelViewportXs[var4], this.faceColors1[var1], this.faceColors2[var1], this.faceColors3[var1]);
			}

		}
	}

	@ObfuscatedName("o")
	final void method2829(int var1) {
		int var2 = Rasterizer3D.Rasterizer3D_clipMidX;
		int var3 = Rasterizer3D.Rasterizer3D_clipMidY;
		int var4 = 0;
		int var5 = this.indices1[var1];
		int var6 = this.indices2[var1];
		int var7 = this.indices3[var1];
		int var8 = field1695[var5];
		int var9 = field1695[var6];
		int var10 = field1695[var7];
		if (this.faceAlphas == null) {
			Rasterizer3D.Rasterizer3D_alpha = 0;
		} else {
			Rasterizer3D.Rasterizer3D_alpha = this.faceAlphas[var1] & 255;
		}

		int var11;
		int var12;
		int var13;
		int var14;
		if (var8 >= 50) {
			field1704[var4] = modelViewportXs[var5];
			field1705[var4] = modelViewportYs[var5];
			field1706[var4++] = this.faceColors1[var1];
		} else {
			var11 = field1708[var5];
			var12 = field1663[var5];
			var13 = this.faceColors1[var1];
			if (var10 >= 50) {
				var14 = field1716[var10 - var8] * (50 - var8);
				field1704[var4] = var2 + Rasterizer3D.Rasterizer3D_zoom * (var11 + ((field1708[var7] - var11) * var14 >> 16)) / 50;
				field1705[var4] = var3 + Rasterizer3D.Rasterizer3D_zoom * (var12 + ((field1663[var7] - var12) * var14 >> 16)) / 50;
				field1706[var4++] = var13 + ((this.faceColors3[var1] - var13) * var14 >> 16);
			}

			if (var9 >= 50) {
				var14 = field1716[var9 - var8] * (50 - var8);
				field1704[var4] = var2 + Rasterizer3D.Rasterizer3D_zoom * (var11 + ((field1708[var6] - var11) * var14 >> 16)) / 50;
				field1705[var4] = var3 + Rasterizer3D.Rasterizer3D_zoom * (var12 + ((field1663[var6] - var12) * var14 >> 16)) / 50;
				field1706[var4++] = var13 + ((this.faceColors2[var1] - var13) * var14 >> 16);
			}
		}

		if (var9 >= 50) {
			field1704[var4] = modelViewportXs[var6];
			field1705[var4] = modelViewportYs[var6];
			field1706[var4++] = this.faceColors2[var1];
		} else {
			var11 = field1708[var6];
			var12 = field1663[var6];
			var13 = this.faceColors2[var1];
			if (var8 >= 50) {
				var14 = field1716[var8 - var9] * (50 - var9);
				field1704[var4] = var2 + Rasterizer3D.Rasterizer3D_zoom * (var11 + ((field1708[var5] - var11) * var14 >> 16)) / 50;
				field1705[var4] = var3 + Rasterizer3D.Rasterizer3D_zoom * (var12 + ((field1663[var5] - var12) * var14 >> 16)) / 50;
				field1706[var4++] = var13 + ((this.faceColors1[var1] - var13) * var14 >> 16);
			}

			if (var10 >= 50) {
				var14 = field1716[var10 - var9] * (50 - var9);
				field1704[var4] = var2 + Rasterizer3D.Rasterizer3D_zoom * (var11 + ((field1708[var7] - var11) * var14 >> 16)) / 50;
				field1705[var4] = var3 + Rasterizer3D.Rasterizer3D_zoom * (var12 + ((field1663[var7] - var12) * var14 >> 16)) / 50;
				field1706[var4++] = var13 + ((this.faceColors3[var1] - var13) * var14 >> 16);
			}
		}

		if (var10 >= 50) {
			field1704[var4] = modelViewportXs[var7];
			field1705[var4] = modelViewportYs[var7];
			field1706[var4++] = this.faceColors3[var1];
		} else {
			var11 = field1708[var7];
			var12 = field1663[var7];
			var13 = this.faceColors3[var1];
			if (var9 >= 50) {
				var14 = field1716[var9 - var10] * (50 - var10);
				field1704[var4] = var2 + Rasterizer3D.Rasterizer3D_zoom * (var11 + ((field1708[var6] - var11) * var14 >> 16)) / 50;
				field1705[var4] = var3 + Rasterizer3D.Rasterizer3D_zoom * (var12 + ((field1663[var6] - var12) * var14 >> 16)) / 50;
				field1706[var4++] = var13 + ((this.faceColors2[var1] - var13) * var14 >> 16);
			}

			if (var8 >= 50) {
				var14 = field1716[var8 - var10] * (50 - var10);
				field1704[var4] = var2 + Rasterizer3D.Rasterizer3D_zoom * (var11 + ((field1708[var5] - var11) * var14 >> 16)) / 50;
				field1705[var4] = var3 + Rasterizer3D.Rasterizer3D_zoom * (var12 + ((field1663[var5] - var12) * var14 >> 16)) / 50;
				field1706[var4++] = var13 + ((this.faceColors1[var1] - var13) * var14 >> 16);
			}
		}

		var11 = field1704[0];
		var12 = field1704[1];
		var13 = field1704[2];
		var14 = field1705[0];
		int var15 = field1705[1];
		int var16 = field1705[2];
		Rasterizer3D.field1760 = false;
		int var17;
		int var18;
		int var19;
		int var20;
		if (var4 == 3) {
			if (var11 < 0 || var12 < 0 || var13 < 0 || var11 > Rasterizer3D.Rasterizer3D_clipWidth || var12 > Rasterizer3D.Rasterizer3D_clipWidth || var13 > Rasterizer3D.Rasterizer3D_clipWidth) {
				Rasterizer3D.field1760 = true;
			}

			if (this.faceTextures != null && this.faceTextures[var1] != -1) {
				if (this.field1666 != null && this.field1666[var1] != -1) {
					var20 = this.field1666[var1] & 255;
					var17 = this.field1691[var20];
					var18 = this.field1671[var20];
					var19 = this.field1672[var20];
				} else {
					var17 = var5;
					var18 = var6;
					var19 = var7;
				}

				if (this.faceColors3[var1] == -1) {
					Rasterizer3D.method2938(var14, var15, var16, var11, var12, var13, this.faceColors1[var1], this.faceColors1[var1], this.faceColors1[var1], field1708[var17], field1708[var18], field1708[var19], field1663[var17], field1663[var18], field1663[var19], field1695[var17], field1695[var18], field1695[var19], this.faceTextures[var1]);
				} else {
					Rasterizer3D.method2938(var14, var15, var16, var11, var12, var13, field1706[0], field1706[1], field1706[2], field1708[var17], field1708[var18], field1708[var19], field1663[var17], field1663[var18], field1663[var19], field1695[var17], field1695[var18], field1695[var19], this.faceTextures[var1]);
				}
			} else if (this.faceColors3[var1] == -1) {
				Rasterizer3D.method2936(var14, var15, var16, var11, var12, var13, field1715[this.faceColors1[var1]]);
			} else {
				Rasterizer3D.method2934(var14, var15, var16, var11, var12, var13, field1706[0], field1706[1], field1706[2]);
			}
		}

		if (var4 == 4) {
			if (var11 < 0 || var12 < 0 || var13 < 0 || var11 > Rasterizer3D.Rasterizer3D_clipWidth || var12 > Rasterizer3D.Rasterizer3D_clipWidth || var13 > Rasterizer3D.Rasterizer3D_clipWidth || field1704[3] < 0 || field1704[3] > Rasterizer3D.Rasterizer3D_clipWidth) {
				Rasterizer3D.field1760 = true;
			}

			if (this.faceTextures != null && this.faceTextures[var1] != -1) {
				if (this.field1666 != null && this.field1666[var1] != -1) {
					var20 = this.field1666[var1] & 255;
					var17 = this.field1691[var20];
					var18 = this.field1671[var20];
					var19 = this.field1672[var20];
				} else {
					var17 = var5;
					var18 = var6;
					var19 = var7;
				}

				short var21 = this.faceTextures[var1];
				if (this.faceColors3[var1] == -1) {
					Rasterizer3D.method2938(var14, var15, var16, var11, var12, var13, this.faceColors1[var1], this.faceColors1[var1], this.faceColors1[var1], field1708[var17], field1708[var18], field1708[var19], field1663[var17], field1663[var18], field1663[var19], field1695[var17], field1695[var18], field1695[var19], var21);
					Rasterizer3D.method2938(var14, var16, field1705[3], var11, var13, field1704[3], this.faceColors1[var1], this.faceColors1[var1], this.faceColors1[var1], field1708[var17], field1708[var18], field1708[var19], field1663[var17], field1663[var18], field1663[var19], field1695[var17], field1695[var18], field1695[var19], var21);
				} else {
					Rasterizer3D.method2938(var14, var15, var16, var11, var12, var13, field1706[0], field1706[1], field1706[2], field1708[var17], field1708[var18], field1708[var19], field1663[var17], field1663[var18], field1663[var19], field1695[var17], field1695[var18], field1695[var19], var21);
					Rasterizer3D.method2938(var14, var16, field1705[3], var11, var13, field1704[3], field1706[0], field1706[2], field1706[3], field1708[var17], field1708[var18], field1708[var19], field1663[var17], field1663[var18], field1663[var19], field1695[var17], field1695[var18], field1695[var19], var21);
				}
			} else if (this.faceColors3[var1] == -1) {
				var17 = field1715[this.faceColors1[var1]];
				Rasterizer3D.method2936(var14, var15, var16, var11, var12, var13, var17);
				Rasterizer3D.method2936(var14, var16, field1705[3], var11, var13, field1704[3], var17);
			} else {
				Rasterizer3D.method2934(var14, var15, var16, var11, var12, var13, field1706[0], field1706[1], field1706[2]);
				Rasterizer3D.method2934(var14, var16, field1705[3], var11, var13, field1704[3], field1706[0], field1706[2], field1706[3]);
			}
		}

	}

	@ObfuscatedName("cm")
	@Export("draw")
	void draw(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, long var9) {
		field1696[0] = -1;
		if (this.boundsType != 1) {
			this.calculateBoundsCylinder();
		}

		this.calculateBoundingBox(var1);
		int var11 = var5 * var8 - var4 * var6 >> 16;
		int var12 = var2 * var7 + var3 * var11 >> 16;
		int var13 = var3 * this.xzRadius >> 16;
		int var14 = var12 + var13;
		if (var14 > 50 && var12 < 3500) {
			int var15 = var8 * var4 + var5 * var6 >> 16;
			int var16 = (var15 - this.xzRadius) * Rasterizer3D.Rasterizer3D_zoom;
			if (var16 / var14 < Rasterizer3D.Rasterizer3D_clipMidX2) {
				int var17 = (var15 + this.xzRadius) * Rasterizer3D.Rasterizer3D_zoom;
				if (var17 / var14 > Rasterizer3D.Rasterizer3D_clipNegativeMidX) {
					int var18 = var3 * var7 - var11 * var2 >> 16;
					int var19 = var2 * this.xzRadius >> 16;
					int var20 = (var18 + var19) * Rasterizer3D.Rasterizer3D_zoom;
					if (var20 / var14 > Rasterizer3D.Rasterizer3D_clipNegativeMidY) {
						int var21 = (var3 * super.height >> 16) + var19;
						int var22 = (var18 - var21) * Rasterizer3D.Rasterizer3D_zoom;
						if (var22 / var14 < Rasterizer3D.Rasterizer3D_clipMidY2) {
							int var23 = var13 + (var2 * super.height >> 16);
							boolean var24 = false;
							boolean var25 = false;
							if (var12 - var23 <= 50) {
								var25 = true;
							}

							boolean var26 = var25 || this.field1699 > 0;
							int var27 = class65.method1180();
							int var28 = ViewportMouse.ViewportMouse_y;
							boolean var30 = class188.method3588();
							boolean var31 = SpotAnimationDefinition.method4333(var9);
							boolean var32 = false;
							int var36;
							int var37;
							int var38;
							int var39;
							int var47;
							int var51;
							int var52;
							int var53;
							if (var31 && var30) {
								boolean var33 = false;
								if (field1710) {
									boolean var34;
									if (!class188.method3588()) {
										var34 = false;
									} else {
										int var42;
										int var43;
										int var44;
										if (!ViewportMouse.ViewportMouse_false0) {
											var36 = Scene.Scene_cameraPitchSine;
											var37 = Scene.Scene_cameraPitchCosine;
											var38 = Scene.Scene_cameraYawSine;
											var39 = Scene.Scene_cameraYawCosine;
											byte var40 = 50;
											short var41 = 3500;
											var42 = (ViewportMouse.ViewportMouse_x - Rasterizer3D.Rasterizer3D_clipMidX) * var40 / Rasterizer3D.Rasterizer3D_zoom;
											var43 = (ViewportMouse.ViewportMouse_y - Rasterizer3D.Rasterizer3D_clipMidY) * var40 / Rasterizer3D.Rasterizer3D_zoom;
											var44 = (ViewportMouse.ViewportMouse_x - Rasterizer3D.Rasterizer3D_clipMidX) * var41 / Rasterizer3D.Rasterizer3D_zoom;
											int var45 = (ViewportMouse.ViewportMouse_y - Rasterizer3D.Rasterizer3D_clipMidY) * var41 / Rasterizer3D.Rasterizer3D_zoom;
											int var46 = Rasterizer3D.method2947(var43, var40, var37, var36);
											var52 = Rasterizer3D.method2946(var43, var40, var37, var36);
											var43 = var46;
											var46 = Rasterizer3D.method2947(var45, var41, var37, var36);
											var53 = Rasterizer3D.method2946(var45, var41, var37, var36);
											var45 = var46;
											var46 = Rasterizer3D.method2945(var42, var52, var39, var38);
											var52 = Rasterizer3D.method2963(var42, var52, var39, var38);
											var42 = var46;
											var46 = Rasterizer3D.method2945(var44, var53, var39, var38);
											var53 = Rasterizer3D.method2963(var44, var53, var39, var38);
											ViewportMouse.field1723 = (var46 + var42) / 2;
											ViewportMouse.field1724 = (var45 + var43) / 2;
											class189.field2328 = (var52 + var53) / 2;
											ViewportMouse.field1725 = (var46 - var42) / 2;
											ViewportMouse.field1726 = (var45 - var43) / 2;
											GrandExchangeEvent.field50 = (var53 - var52) / 2;
											SoundCache.field1424 = Math.abs(ViewportMouse.field1725);
											Canvas.field389 = Math.abs(ViewportMouse.field1726);
											ViewportMouse.field1727 = Math.abs(GrandExchangeEvent.field50);
										}

										var36 = this.xMid + var6;
										var37 = var7 + this.yMid;
										var38 = var8 + this.zMid;
										var39 = this.xMidOffset;
										var52 = this.yMidOffset;
										var53 = this.zMidOffset;
										var42 = ViewportMouse.field1723 - var36;
										var43 = ViewportMouse.field1724 - var37;
										var44 = class189.field2328 - var38;
										if (Math.abs(var42) > var39 + SoundCache.field1424) {
											var34 = false;
										} else if (Math.abs(var43) > var52 + Canvas.field389) {
											var34 = false;
										} else if (Math.abs(var44) > var53 + ViewportMouse.field1727) {
											var34 = false;
										} else if (Math.abs(var44 * ViewportMouse.field1726 - var43 * GrandExchangeEvent.field50) > var53 * Canvas.field389 + var52 * ViewportMouse.field1727) {
											var34 = false;
										} else if (Math.abs(var42 * GrandExchangeEvent.field50 - var44 * ViewportMouse.field1725) > var39 * ViewportMouse.field1727 + var53 * SoundCache.field1424) {
											var34 = false;
										} else if (Math.abs(var43 * ViewportMouse.field1725 - var42 * ViewportMouse.field1726) > var52 * SoundCache.field1424 + var39 * Canvas.field389) {
											var34 = false;
										} else {
											var34 = true;
										}
									}

									var33 = var34;
								} else {
									var51 = var12 - var13;
									if (var51 <= 50) {
										var51 = 50;
									}

									if (var15 > 0) {
										var16 /= var14;
										var17 /= var51;
									} else {
										var17 /= var14;
										var16 /= var51;
									}

									if (var18 > 0) {
										var22 /= var14;
										var20 /= var51;
									} else {
										var20 /= var14;
										var22 /= var51;
									}

									var47 = var27 - Rasterizer3D.Rasterizer3D_clipMidX;
									var36 = var28 - Rasterizer3D.Rasterizer3D_clipMidY;
									if (var47 > var16 && var47 < var17 && var36 > var22 && var36 < var20) {
										var33 = true;
									}
								}

								if (var33) {
									if (this.isSingleTile) {
										class42.method752(var9);
									} else {
										var32 = true;
									}
								}
							}

							int var50 = Rasterizer3D.Rasterizer3D_clipMidX;
							var51 = Rasterizer3D.Rasterizer3D_clipMidY;
							var47 = 0;
							var36 = 0;
							if (var1 != 0) {
								var47 = Model_sine[var1];
								var36 = Model_cosine[var1];
							}

							for (var37 = 0; var37 < this.verticesCount; ++var37) {
								var38 = this.verticesX[var37];
								var39 = this.verticesY[var37];
								var52 = this.verticesZ[var37];
								if (var1 != 0) {
									var53 = var52 * var47 + var38 * var36 >> 16;
									var52 = var52 * var36 - var38 * var47 >> 16;
									var38 = var53;
								}

								var38 += var6;
								var39 += var7;
								var52 += var8;
								var53 = var52 * var4 + var5 * var38 >> 16;
								var52 = var5 * var52 - var38 * var4 >> 16;
								var38 = var53;
								var53 = var3 * var39 - var52 * var2 >> 16;
								var52 = var39 * var2 + var3 * var52 >> 16;
								field1692[var37] = var52 - var12;
								if (var52 >= 50) {
									modelViewportXs[var37] = var38 * Rasterizer3D.Rasterizer3D_zoom / var52 + var50;
									modelViewportYs[var37] = var53 * Rasterizer3D.Rasterizer3D_zoom / var52 + var51;
								} else {
									modelViewportXs[var37] = -5000;
									var24 = true;
								}

								if (var26) {
									field1708[var37] = var38;
									field1663[var37] = var53;
									field1695[var37] = var52;
								}
							}

							try {
								this.draw0(var24, var32, this.isSingleTile, var9);
							} catch (Exception var49) {
							}

						}
					}
				}
			}
		}
	}
}
