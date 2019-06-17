import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("du")
@Implements("Model")
public class Model extends Entity {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Ldu;"
   )
   @Export("Model_sharedSequenceModel")
   static Model Model_sharedSequenceModel;
   @ObfuscatedName("f")
   @Export("Model_sharedSequenceModelFaceAlphas")
   static byte[] Model_sharedSequenceModelFaceAlphas;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Ldu;"
   )
   @Export("Model_sharedSpotAnimationModel")
   static Model Model_sharedSpotAnimationModel;
   @ObfuscatedName("w")
   @Export("Model_sharedSpotAnimationModelFaceAlphas")
   static byte[] Model_sharedSpotAnimationModelFaceAlphas;
   @ObfuscatedName("at")
   @Export("__du_at")
   static boolean[] __du_at;
   @ObfuscatedName("ad")
   @Export("__du_ad")
   static boolean[] __du_ad;
   @ObfuscatedName("ap")
   @Export("modelViewportXs")
   static int[] modelViewportXs;
   @ObfuscatedName("as")
   @Export("modelViewportYs")
   static int[] modelViewportYs;
   @ObfuscatedName("am")
   @Export("__du_am")
   static int[] __du_am;
   @ObfuscatedName("an")
   @Export("__du_an")
   static int[] __du_an;
   @ObfuscatedName("az")
   @Export("__du_az")
   static int[] __du_az;
   @ObfuscatedName("au")
   @Export("__du_au")
   static int[] __du_au;
   @ObfuscatedName("aa")
   @Export("__du_aa")
   static int[] __du_aa;
   @ObfuscatedName("ax")
   @Export("__du_ax")
   static int[][] __du_ax;
   @ObfuscatedName("af")
   @Export("__du_af")
   static int[] __du_af;
   @ObfuscatedName("ai")
   @Export("__du_ai")
   static int[][] __du_ai;
   @ObfuscatedName("ba")
   @Export("__du_ba")
   static int[] __du_ba;
   @ObfuscatedName("bb")
   @Export("__du_bb")
   static int[] __du_bb;
   @ObfuscatedName("bs")
   @Export("__du_bs")
   static int[] __du_bs;
   @ObfuscatedName("bq")
   @Export("__du_bq")
   static int[] __du_bq;
   @ObfuscatedName("bn")
   @Export("__du_bn")
   static int[] __du_bn;
   @ObfuscatedName("bk")
   @Export("__du_bk")
   static int[] __du_bk;
   @ObfuscatedName("bd")
   @Export("Model_transformTempX")
   static int Model_transformTempX;
   @ObfuscatedName("bc")
   @Export("Model_transformTempY")
   static int Model_transformTempY;
   @ObfuscatedName("bo")
   @Export("Model_transformTempZ")
   static int Model_transformTempZ;
   @ObfuscatedName("bx")
   @Export("__du_bx")
   static boolean __du_bx;
   @ObfuscatedName("bm")
   @Export("Model_sine")
   static int[] Model_sine;
   @ObfuscatedName("bl")
   @Export("Model_cosine")
   static int[] Model_cosine;
   @ObfuscatedName("br")
   @Export("__du_br")
   static int[] __du_br;
   @ObfuscatedName("bj")
   @Export("__du_bj")
   static int[] __du_bj;
   @ObfuscatedName("o")
   @Export("verticesCount")
   int verticesCount;
   @ObfuscatedName("u")
   @Export("verticesX")
   int[] verticesX;
   @ObfuscatedName("g")
   @Export("verticesY")
   int[] verticesY;
   @ObfuscatedName("l")
   @Export("verticesZ")
   int[] verticesZ;
   @ObfuscatedName("e")
   @Export("indicesCount")
   int indicesCount;
   @ObfuscatedName("x")
   @Export("indices1")
   int[] indices1;
   @ObfuscatedName("d")
   @Export("indices2")
   int[] indices2;
   @ObfuscatedName("k")
   @Export("indices3")
   int[] indices3;
   @ObfuscatedName("n")
   @Export("faceColors1")
   int[] faceColors1;
   @ObfuscatedName("i")
   @Export("faceColors2")
   int[] faceColors2;
   @ObfuscatedName("a")
   @Export("faceColors3")
   int[] faceColors3;
   @ObfuscatedName("z")
   @Export("faceRenderPriorities")
   byte[] faceRenderPriorities;
   @ObfuscatedName("j")
   @Export("faceAlphas")
   byte[] faceAlphas;
   @ObfuscatedName("s")
   @Export("__s")
   byte[] __s;
   @ObfuscatedName("t")
   @Export("faceTextures")
   short[] faceTextures;
   @ObfuscatedName("y")
   @Export("__y")
   byte __y;
   @ObfuscatedName("h")
   @Export("__h")
   int __h;
   @ObfuscatedName("b")
   @Export("__b")
   int[] __b;
   @ObfuscatedName("c")
   @Export("__c")
   int[] __c;
   @ObfuscatedName("r")
   @Export("__r")
   int[] __r;
   @ObfuscatedName("p")
   @Export("vertexLabels")
   int[][] vertexLabels;
   @ObfuscatedName("v")
   @Export("faceLabelsAlpha")
   int[][] faceLabelsAlpha;
   @ObfuscatedName("ag")
   @Export("isSingleTile")
   public boolean isSingleTile;
   @ObfuscatedName("aq")
   @Export("boundsType")
   int boundsType;
   @ObfuscatedName("aj")
   @Export("bottomY")
   int bottomY;
   @ObfuscatedName("av")
   @Export("xzRadius")
   int xzRadius;
   @ObfuscatedName("ar")
   @Export("diameter")
   int diameter;
   @ObfuscatedName("ac")
   @Export("radius")
   int radius;
   @ObfuscatedName("ay")
   @Export("xMid")
   int xMid;
   @ObfuscatedName("ah")
   @Export("yMid")
   int yMid;
   @ObfuscatedName("ak")
   @Export("zMid")
   int zMid;
   @ObfuscatedName("aw")
   @Export("xMidOffset")
   int xMidOffset;
   @ObfuscatedName("al")
   @Export("yMidOffset")
   int yMidOffset;
   @ObfuscatedName("ab")
   @Export("zMidOffset")
   int zMidOffset;

   Model() {
      this.verticesCount = 0;
      this.indicesCount = 0;
      this.__y = 0;
      this.__h = 0;
      this.isSingleTile = false;
      this.xMidOffset = -1;
      this.yMidOffset = -1;
      this.zMidOffset = -1;
   }

   @ObfuscatedSignature(
      signature = "([Ldu;I)V"
   )
   public Model(Model[] var1, int var2) {
      this.verticesCount = 0;
      this.indicesCount = 0;
      this.__y = 0;
      this.__h = 0;
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
      this.__h = 0;
      this.__y = -1;

      int var7;
      Model var8;
      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            this.verticesCount += var8.verticesCount;
            this.indicesCount += var8.indicesCount;
            this.__h += var8.__h;
            if(var8.faceRenderPriorities != null) {
               var3 = true;
            } else {
               if(this.__y == -1) {
                  this.__y = var8.__y;
               }

               if(this.__y != var8.__y) {
                  var3 = true;
               }
            }

            var4 |= var8.faceAlphas != null;
            var5 |= var8.faceTextures != null;
            var6 |= var8.__s != null;
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
      if(var3) {
         this.faceRenderPriorities = new byte[this.indicesCount];
      }

      if(var4) {
         this.faceAlphas = new byte[this.indicesCount];
      }

      if(var5) {
         this.faceTextures = new short[this.indicesCount];
      }

      if(var6) {
         this.__s = new byte[this.indicesCount];
      }

      if(this.__h > 0) {
         this.__b = new int[this.__h];
         this.__c = new int[this.__h];
         this.__r = new int[this.__h];
      }

      this.verticesCount = 0;
      this.indicesCount = 0;
      this.__h = 0;

      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            int var9;
            for(var9 = 0; var9 < var8.indicesCount; ++var9) {
               this.indices1[this.indicesCount] = this.verticesCount + var8.indices1[var9];
               this.indices2[this.indicesCount] = this.verticesCount + var8.indices2[var9];
               this.indices3[this.indicesCount] = this.verticesCount + var8.indices3[var9];
               this.faceColors1[this.indicesCount] = var8.faceColors1[var9];
               this.faceColors2[this.indicesCount] = var8.faceColors2[var9];
               this.faceColors3[this.indicesCount] = var8.faceColors3[var9];
               if(var3) {
                  if(var8.faceRenderPriorities != null) {
                     this.faceRenderPriorities[this.indicesCount] = var8.faceRenderPriorities[var9];
                  } else {
                     this.faceRenderPriorities[this.indicesCount] = var8.__y;
                  }
               }

               if(var4 && var8.faceAlphas != null) {
                  this.faceAlphas[this.indicesCount] = var8.faceAlphas[var9];
               }

               if(var5) {
                  if(var8.faceTextures != null) {
                     this.faceTextures[this.indicesCount] = var8.faceTextures[var9];
                  } else {
                     this.faceTextures[this.indicesCount] = -1;
                  }
               }

               if(var6) {
                  if(var8.__s != null && var8.__s[var9] != -1) {
                     this.__s[this.indicesCount] = (byte)(this.__h + var8.__s[var9]);
                  } else {
                     this.__s[this.indicesCount] = -1;
                  }
               }

               ++this.indicesCount;
            }

            for(var9 = 0; var9 < var8.__h; ++var9) {
               this.__b[this.__h] = this.verticesCount + var8.__b[var9];
               this.__c[this.__h] = this.verticesCount + var8.__c[var9];
               this.__r[this.__h] = this.verticesCount + var8.__r[var9];
               ++this.__h;
            }

            for(var9 = 0; var9 < var8.verticesCount; ++var9) {
               this.verticesX[this.verticesCount] = var8.verticesX[var9];
               this.verticesY[this.verticesCount] = var8.verticesY[var9];
               this.verticesZ[this.verticesCount] = var8.verticesZ[var9];
               ++this.verticesCount;
            }
         }
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([[IIIIZI)Ldu;"
   )
   @Export("contourGround")
   public Model contourGround(int[][] var1, int var2, int var3, int var4, boolean var5, int var6) {
      this.calculateBoundsCylinder();
      int var7 = var2 - this.xzRadius;
      int var8 = var2 + this.xzRadius;
      int var9 = var4 - this.xzRadius;
      int var10 = var4 + this.xzRadius;
      if(var7 >= 0 && var8 + 128 >> 7 < var1.length && var9 >= 0 && var10 + 128 >> 7 < var1[0].length) {
         var7 >>= 7;
         var8 = var8 + 127 >> 7;
         var9 >>= 7;
         var10 = var10 + 127 >> 7;
         if(var3 == var1[var7][var9] && var3 == var1[var8][var9] && var3 == var1[var7][var10] && var3 == var1[var8][var10]) {
            return this;
         } else {
            Model var11;
            if(var5) {
               var11 = new Model();
               var11.verticesCount = this.verticesCount;
               var11.indicesCount = this.indicesCount;
               var11.__h = this.__h;
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
               var11.__s = this.__s;
               var11.faceTextures = this.faceTextures;
               var11.__y = this.__y;
               var11.__b = this.__b;
               var11.__c = this.__c;
               var11.__r = this.__r;
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
            if(var6 == 0) {
               for(var12 = 0; var12 < var11.verticesCount; ++var12) {
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
               for(var12 = 0; var12 < var11.verticesCount; ++var12) {
                  var13 = (-this.verticesY[var12] << 16) / super.height;
                  if(var13 < var6) {
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

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Z)Ldu;"
   )
   @Export("toSharedSequenceModel")
   public Model toSharedSequenceModel(boolean var1) {
      if(!var1 && Model_sharedSequenceModelFaceAlphas.length < this.indicesCount) {
         Model_sharedSequenceModelFaceAlphas = new byte[this.indicesCount + 100];
      }

      return this.buildSharedModel(var1, Model_sharedSequenceModel, Model_sharedSequenceModelFaceAlphas);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Z)Ldu;"
   )
   @Export("toSharedSpotAnimationModel")
   public Model toSharedSpotAnimationModel(boolean var1) {
      if(!var1 && Model_sharedSpotAnimationModelFaceAlphas.length < this.indicesCount) {
         Model_sharedSpotAnimationModelFaceAlphas = new byte[this.indicesCount + 100];
      }

      return this.buildSharedModel(var1, Model_sharedSpotAnimationModel, Model_sharedSpotAnimationModelFaceAlphas);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(ZLdu;[B)Ldu;"
   )
   @Export("buildSharedModel")
   Model buildSharedModel(boolean var1, Model var2, byte[] var3) {
      var2.verticesCount = this.verticesCount;
      var2.indicesCount = this.indicesCount;
      var2.__h = this.__h;
      if(var2.verticesX == null || var2.verticesX.length < this.verticesCount) {
         var2.verticesX = new int[this.verticesCount + 100];
         var2.verticesY = new int[this.verticesCount + 100];
         var2.verticesZ = new int[this.verticesCount + 100];
      }

      int var4;
      for(var4 = 0; var4 < this.verticesCount; ++var4) {
         var2.verticesX[var4] = this.verticesX[var4];
         var2.verticesY[var4] = this.verticesY[var4];
         var2.verticesZ[var4] = this.verticesZ[var4];
      }

      if(var1) {
         var2.faceAlphas = this.faceAlphas;
      } else {
         var2.faceAlphas = var3;
         if(this.faceAlphas == null) {
            for(var4 = 0; var4 < this.indicesCount; ++var4) {
               var2.faceAlphas[var4] = 0;
            }
         } else {
            for(var4 = 0; var4 < this.indicesCount; ++var4) {
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
      var2.__s = this.__s;
      var2.faceTextures = this.faceTextures;
      var2.__y = this.__y;
      var2.__b = this.__b;
      var2.__c = this.__c;
      var2.__r = this.__r;
      var2.vertexLabels = this.vertexLabels;
      var2.faceLabelsAlpha = this.faceLabelsAlpha;
      var2.isSingleTile = this.isSingleTile;
      var2.resetBounds();
      return var2;
   }

   @ObfuscatedName("o")
   @Export("calculateBoundingBox")
   void calculateBoundingBox(int var1) {
      if(this.xMidOffset == -1) {
         int var2 = 0;
         int var3 = 0;
         int var4 = 0;
         int var5 = 0;
         int var6 = 0;
         int var7 = 0;
         int var8 = Model_cosine[var1];
         int var9 = Model_sine[var1];

         for(int var10 = 0; var10 < this.verticesCount; ++var10) {
            int var11 = Rasterizer3D.method3039(this.verticesX[var10], this.verticesZ[var10], var8, var9);
            int var12 = this.verticesY[var10];
            int var13 = Rasterizer3D.method3004(this.verticesX[var10], this.verticesZ[var10], var8, var9);
            if(var11 < var2) {
               var2 = var11;
            }

            if(var11 > var5) {
               var5 = var11;
            }

            if(var12 < var3) {
               var3 = var12;
            }

            if(var12 > var6) {
               var6 = var12;
            }

            if(var13 < var4) {
               var4 = var13;
            }

            if(var13 > var7) {
               var7 = var13;
            }
         }

         this.xMid = (var5 + var2) / 2;
         this.yMid = (var6 + var3) / 2;
         this.zMid = (var7 + var4) / 2;
         this.xMidOffset = (var5 - var2 + 1) / 2;
         this.yMidOffset = (var6 - var3 + 1) / 2;
         this.zMidOffset = (var7 - var4 + 1) / 2;
         if(this.xMidOffset < 32) {
            this.xMidOffset = 32;
         }

         if(this.zMidOffset < 32) {
            this.zMidOffset = 32;
         }

         if(this.isSingleTile) {
            this.xMidOffset += 8;
            this.zMidOffset += 8;
         }
      }

   }

   @ObfuscatedName("u")
   @Export("calculateBoundsCylinder")
   public void calculateBoundsCylinder() {
      if(this.boundsType != 1) {
         this.boundsType = 1;
         super.height = 0;
         this.bottomY = 0;
         this.xzRadius = 0;

         for(int var1 = 0; var1 < this.verticesCount; ++var1) {
            int var2 = this.verticesX[var1];
            int var3 = this.verticesY[var1];
            int var4 = this.verticesZ[var1];
            if(-var3 > super.height) {
               super.height = -var3;
            }

            if(var3 > this.bottomY) {
               this.bottomY = var3;
            }

            int var5 = var2 * var2 + var4 * var4;
            if(var5 > this.xzRadius) {
               this.xzRadius = var5;
            }
         }

         this.xzRadius = (int)(Math.sqrt((double)this.xzRadius) + 0.99D);
         this.radius = (int)(Math.sqrt((double)(this.xzRadius * this.xzRadius + super.height * super.height)) + 0.99D);
         this.diameter = this.radius + (int)(Math.sqrt((double)(this.xzRadius * this.xzRadius + this.bottomY * this.bottomY)) + 0.99D);
      }

   }

   @ObfuscatedName("g")
   @Export("__g_232")
   void __g_232() {
      if(this.boundsType != 2) {
         this.boundsType = 2;
         this.xzRadius = 0;

         for(int var1 = 0; var1 < this.verticesCount; ++var1) {
            int var2 = this.verticesX[var1];
            int var3 = this.verticesY[var1];
            int var4 = this.verticesZ[var1];
            int var5 = var2 * var2 + var4 * var4 + var3 * var3;
            if(var5 > this.xzRadius) {
               this.xzRadius = var5;
            }
         }

         this.xzRadius = (int)(Math.sqrt((double)this.xzRadius) + 0.99D);
         this.radius = this.xzRadius;
         this.diameter = this.xzRadius + this.xzRadius;
      }

   }

   @ObfuscatedName("l")
   @Export("__l_233")
   public int __l_233() {
      this.calculateBoundsCylinder();
      return this.xzRadius;
   }

   @ObfuscatedName("x")
   @Export("resetBounds")
   void resetBounds() {
      this.boundsType = 0;
      this.xMidOffset = -1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Len;I)V"
   )
   @Export("animate")
   public void animate(Frames var1, int var2) {
      if(this.vertexLabels != null && var2 != -1) {
         Animation var3 = var1.frames[var2];
         Skeleton var4 = var3.skeleton;
         Model_transformTempX = 0;
         Model_transformTempY = 0;
         Model_transformTempZ = 0;

         for(int var5 = 0; var5 < var3.transformCount; ++var5) {
            int var6 = var3.transformSkeletonLabels[var5];
            this.transform(var4.transformTypes[var6], var4.labels[var6], var3.transformXs[var5], var3.transformYs[var5], var3.transformZs[var5]);
         }

         this.resetBounds();
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Len;ILen;I[I)V"
   )
   @Export("animate2")
   public void animate2(Frames var1, int var2, Frames var3, int var4, int[] var5) {
      if(var2 != -1) {
         if(var5 != null && var4 != -1) {
            Animation var6 = var1.frames[var2];
            Animation var7 = var3.frames[var4];
            Skeleton var8 = var6.skeleton;
            Model_transformTempX = 0;
            Model_transformTempY = 0;
            Model_transformTempZ = 0;
            byte var9 = 0;
            int var10 = var9 + 1;
            int var11 = var5[var9];

            int var12;
            int var13;
            for(var12 = 0; var12 < var6.transformCount; ++var12) {
               for(var13 = var6.transformSkeletonLabels[var12]; var13 > var11; var11 = var5[var10++]) {
                  ;
               }

               if(var13 != var11 || var8.transformTypes[var13] == 0) {
                  this.transform(var8.transformTypes[var13], var8.labels[var13], var6.transformXs[var12], var6.transformYs[var12], var6.transformZs[var12]);
               }
            }

            Model_transformTempX = 0;
            Model_transformTempY = 0;
            Model_transformTempZ = 0;
            var9 = 0;
            var10 = var9 + 1;
            var11 = var5[var9];

            for(var12 = 0; var12 < var7.transformCount; ++var12) {
               for(var13 = var7.transformSkeletonLabels[var12]; var13 > var11; var11 = var5[var10++]) {
                  ;
               }

               if(var13 == var11 || var8.transformTypes[var13] == 0) {
                  this.transform(var8.transformTypes[var13], var8.labels[var13], var7.transformXs[var12], var7.transformYs[var12], var7.transformZs[var12]);
               }
            }

            this.resetBounds();
         } else {
            this.animate(var1, var2);
         }
      }

   }

   @ObfuscatedName("z")
   @Export("transform")
   void transform(int var1, int[] var2, int var3, int var4, int var5) {
      int var6 = var2.length;
      int var7;
      int var8;
      int var9;
      int var10;
      if(var1 == 0) {
         var7 = 0;
         Model_transformTempX = 0;
         Model_transformTempY = 0;
         Model_transformTempZ = 0;

         for(var8 = 0; var8 < var6; ++var8) {
            int var11 = var2[var8];
            if(var11 < this.vertexLabels.length) {
               int[] var12 = this.vertexLabels[var11];

               for(var9 = 0; var9 < var12.length; ++var9) {
                  var10 = var12[var9];
                  Model_transformTempX += this.verticesX[var10];
                  Model_transformTempY += this.verticesY[var10];
                  Model_transformTempZ += this.verticesZ[var10];
                  ++var7;
               }
            }
         }

         if(var7 > 0) {
            Model_transformTempX = var3 + Model_transformTempX / var7;
            Model_transformTempY = var4 + Model_transformTempY / var7;
            Model_transformTempZ = var5 + Model_transformTempZ / var7;
         } else {
            Model_transformTempX = var3;
            Model_transformTempY = var4;
            Model_transformTempZ = var5;
         }
      } else {
         int[] var18;
         int var19;
         if(var1 == 1) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.vertexLabels.length) {
                  var18 = this.vertexLabels[var8];

                  for(var19 = 0; var19 < var18.length; ++var19) {
                     var9 = var18[var19];
                     this.verticesX[var9] += var3;
                     this.verticesY[var9] += var4;
                     this.verticesZ[var9] += var5;
                  }
               }
            }
         } else if(var1 == 2) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.vertexLabels.length) {
                  var18 = this.vertexLabels[var8];

                  for(var19 = 0; var19 < var18.length; ++var19) {
                     var9 = var18[var19];
                     this.verticesX[var9] -= Model_transformTempX;
                     this.verticesY[var9] -= Model_transformTempY;
                     this.verticesZ[var9] -= Model_transformTempZ;
                     var10 = (var3 & 255) * 8;
                     int var13 = (var4 & 255) * 8;
                     int var14 = (var5 & 255) * 8;
                     int var15;
                     int var16;
                     int var17;
                     if(var14 != 0) {
                        var15 = Model_sine[var14];
                        var16 = Model_cosine[var14];
                        var17 = var15 * this.verticesY[var9] + var16 * this.verticesX[var9] >> 16;
                        this.verticesY[var9] = var16 * this.verticesY[var9] - var15 * this.verticesX[var9] >> 16;
                        this.verticesX[var9] = var17;
                     }

                     if(var10 != 0) {
                        var15 = Model_sine[var10];
                        var16 = Model_cosine[var10];
                        var17 = var16 * this.verticesY[var9] - var15 * this.verticesZ[var9] >> 16;
                        this.verticesZ[var9] = var15 * this.verticesY[var9] + var16 * this.verticesZ[var9] >> 16;
                        this.verticesY[var9] = var17;
                     }

                     if(var13 != 0) {
                        var15 = Model_sine[var13];
                        var16 = Model_cosine[var13];
                        var17 = var15 * this.verticesZ[var9] + var16 * this.verticesX[var9] >> 16;
                        this.verticesZ[var9] = var16 * this.verticesZ[var9] - var15 * this.verticesX[var9] >> 16;
                        this.verticesX[var9] = var17;
                     }

                     this.verticesX[var9] += Model_transformTempX;
                     this.verticesY[var9] += Model_transformTempY;
                     this.verticesZ[var9] += Model_transformTempZ;
                  }
               }
            }
         } else if(var1 == 3) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.vertexLabels.length) {
                  var18 = this.vertexLabels[var8];

                  for(var19 = 0; var19 < var18.length; ++var19) {
                     var9 = var18[var19];
                     this.verticesX[var9] -= Model_transformTempX;
                     this.verticesY[var9] -= Model_transformTempY;
                     this.verticesZ[var9] -= Model_transformTempZ;
                     this.verticesX[var9] = var3 * this.verticesX[var9] / 128;
                     this.verticesY[var9] = var4 * this.verticesY[var9] / 128;
                     this.verticesZ[var9] = var5 * this.verticesZ[var9] / 128;
                     this.verticesX[var9] += Model_transformTempX;
                     this.verticesY[var9] += Model_transformTempY;
                     this.verticesZ[var9] += Model_transformTempZ;
                  }
               }
            }
         } else if(var1 == 5 && this.faceLabelsAlpha != null && this.faceAlphas != null) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.faceLabelsAlpha.length) {
                  var18 = this.faceLabelsAlpha[var8];

                  for(var19 = 0; var19 < var18.length; ++var19) {
                     var9 = var18[var19];
                     var10 = (this.faceAlphas[var9] & 255) + var3 * 8;
                     if(var10 < 0) {
                        var10 = 0;
                     } else if(var10 > 255) {
                        var10 = 255;
                     }

                     this.faceAlphas[var9] = (byte)var10;
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("j")
   @Export("rotateY90Ccw")
   public void rotateY90Ccw() {
      for(int var1 = 0; var1 < this.verticesCount; ++var1) {
         int var2 = this.verticesX[var1];
         this.verticesX[var1] = this.verticesZ[var1];
         this.verticesZ[var1] = -var2;
      }

      this.resetBounds();
   }

   @ObfuscatedName("s")
   @Export("rotateY180")
   public void rotateY180() {
      for(int var1 = 0; var1 < this.verticesCount; ++var1) {
         this.verticesX[var1] = -this.verticesX[var1];
         this.verticesZ[var1] = -this.verticesZ[var1];
      }

      this.resetBounds();
   }

   @ObfuscatedName("t")
   @Export("rotateY270Ccw")
   public void rotateY270Ccw() {
      for(int var1 = 0; var1 < this.verticesCount; ++var1) {
         int var2 = this.verticesZ[var1];
         this.verticesZ[var1] = this.verticesX[var1];
         this.verticesX[var1] = -var2;
      }

      this.resetBounds();
   }

   @ObfuscatedName("y")
   @Export("rotateZ")
   public void rotateZ(int var1) {
      int var2 = Model_sine[var1];
      int var3 = Model_cosine[var1];

      for(int var4 = 0; var4 < this.verticesCount; ++var4) {
         int var5 = var3 * this.verticesY[var4] - var2 * this.verticesZ[var4] >> 16;
         this.verticesZ[var4] = var2 * this.verticesY[var4] + var3 * this.verticesZ[var4] >> 16;
         this.verticesY[var4] = var5;
      }

      this.resetBounds();
   }

   @ObfuscatedName("h")
   @Export("offsetBy")
   public void offsetBy(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.verticesCount; ++var4) {
         this.verticesX[var4] += var1;
         this.verticesY[var4] += var2;
         this.verticesZ[var4] += var3;
      }

      this.resetBounds();
   }

   @ObfuscatedName("b")
   @Export("scale")
   public void scale(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.verticesCount; ++var4) {
         this.verticesX[var4] = this.verticesX[var4] * var1 / 128;
         this.verticesY[var4] = var2 * this.verticesY[var4] / 128;
         this.verticesZ[var4] = var3 * this.verticesZ[var4] / 128;
      }

      this.resetBounds();
   }

   @ObfuscatedName("c")
   @Export("__c_234")
   public final void __c_234(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      __du_aa[0] = -1;
      if(this.boundsType != 2 && this.boundsType != 1) {
         this.__g_232();
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

      for(int var19 = 0; var19 < this.verticesCount; ++var19) {
         int var20 = this.verticesX[var19];
         int var21 = this.verticesY[var19];
         int var22 = this.verticesZ[var19];
         int var23;
         if(var3 != 0) {
            var23 = var21 * var14 + var20 * var15 >> 16;
            var21 = var21 * var15 - var20 * var14 >> 16;
            var20 = var23;
         }

         if(var1 != 0) {
            var23 = var21 * var11 - var22 * var10 >> 16;
            var22 = var21 * var10 + var22 * var11 >> 16;
            var21 = var23;
         }

         if(var2 != 0) {
            var23 = var22 * var12 + var20 * var13 >> 16;
            var22 = var22 * var13 - var20 * var12 >> 16;
            var20 = var23;
         }

         var20 += var5;
         var21 += var6;
         var22 += var7;
         var23 = var21 * var17 - var22 * var16 >> 16;
         var22 = var21 * var16 + var22 * var17 >> 16;
         __du_am[var19] = var22 - var18;
         modelViewportXs[var19] = var20 * Rasterizer3D.Rasterizer3D_zoom / var22 + var8;
         modelViewportYs[var19] = var23 * Rasterizer3D.Rasterizer3D_zoom / var22 + var9;
         if(this.__h > 0) {
            __du_an[var19] = var20;
            __du_az[var19] = var23;
            __du_au[var19] = var22;
         }
      }

      try {
         this.draw0(false, false, false, 0L);
      } catch (Exception var24) {
         ;
      }

   }

   @ObfuscatedName("p")
   @Export("__p_235")
   public final void __p_235(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      __du_aa[0] = -1;
      if(this.boundsType != 2 && this.boundsType != 1) {
         this.__g_232();
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

      for(int var20 = 0; var20 < this.verticesCount; ++var20) {
         int var21 = this.verticesX[var20];
         int var22 = this.verticesY[var20];
         int var23 = this.verticesZ[var20];
         int var24;
         if(var3 != 0) {
            var24 = var22 * var15 + var21 * var16 >> 16;
            var22 = var22 * var16 - var21 * var15 >> 16;
            var21 = var24;
         }

         if(var1 != 0) {
            var24 = var22 * var12 - var23 * var11 >> 16;
            var23 = var22 * var11 + var23 * var12 >> 16;
            var22 = var24;
         }

         if(var2 != 0) {
            var24 = var23 * var13 + var21 * var14 >> 16;
            var23 = var23 * var14 - var21 * var13 >> 16;
            var21 = var24;
         }

         var21 += var5;
         var22 += var6;
         var23 += var7;
         var24 = var22 * var18 - var23 * var17 >> 16;
         var23 = var22 * var17 + var23 * var18 >> 16;
         __du_am[var20] = var23 - var19;
         modelViewportXs[var20] = var9 + var21 * Rasterizer3D.Rasterizer3D_zoom / var8;
         modelViewportYs[var20] = var10 + var24 * Rasterizer3D.Rasterizer3D_zoom / var8;
         if(this.__h > 0) {
            __du_an[var20] = var21;
            __du_az[var20] = var24;
            __du_au[var20] = var23;
         }
      }

      try {
         this.draw0(false, false, false, 0L);
      } catch (Exception var25) {
         ;
      }

   }

   @ObfuscatedName("v")
   @Export("draw0")
   final void draw0(boolean var1, boolean var2, boolean var3, long var4) {
      if(this.diameter < 1600) {
         int var6;
         for(var6 = 0; var6 < this.diameter; ++var6) {
            __du_aa[var6] = 0;
         }

         var6 = var3?20:5;

         int var7;
         int var8;
         int var9;
         int var10;
         int var11;
         int var12;
         int var13;
         int var14;
         int var15;
         int var16;
         for(var7 = 0; var7 < this.indicesCount; ++var7) {
            if(this.faceColors3[var7] != -2) {
               var8 = this.indices1[var7];
               var16 = this.indices2[var7];
               var9 = this.indices3[var7];
               var10 = modelViewportXs[var8];
               var11 = modelViewportXs[var16];
               var12 = modelViewportXs[var9];
               int var17;
               if(!var1 || var10 != -5000 && var11 != -5000 && var12 != -5000) {
                  if(var2 && NPCDefinition.method5164(modelViewportYs[var8], modelViewportYs[var16], modelViewportYs[var9], var10, var11, var12, var6)) {
                     Projectile.method2081(var4);
                     var2 = false;
                  }

                  if((var10 - var11) * (modelViewportYs[var9] - modelViewportYs[var16]) - (var12 - var11) * (modelViewportYs[var8] - modelViewportYs[var16]) > 0) {
                     __du_ad[var7] = false;
                     if(var10 >= 0 && var11 >= 0 && var12 >= 0 && var10 <= Rasterizer3D.Rasterizer3D_clipWidth && var11 <= Rasterizer3D.Rasterizer3D_clipWidth && var12 <= Rasterizer3D.Rasterizer3D_clipWidth) {
                        __du_at[var7] = false;
                     } else {
                        __du_at[var7] = true;
                     }

                     var17 = (__du_am[var8] + __du_am[var16] + __du_am[var9]) / 3 + this.radius;
                     __du_ax[var17][__du_aa[var17]++] = var7;
                  }
               } else {
                  var17 = __du_an[var8];
                  var13 = __du_an[var16];
                  var14 = __du_an[var9];
                  int var18 = __du_az[var8];
                  var15 = __du_az[var16];
                  int var19 = __du_az[var9];
                  int var20 = __du_au[var8];
                  int var21 = __du_au[var16];
                  int var22 = __du_au[var9];
                  var17 -= var13;
                  var14 -= var13;
                  var18 -= var15;
                  var19 -= var15;
                  var20 -= var21;
                  var22 -= var21;
                  int var23 = var18 * var22 - var20 * var19;
                  int var24 = var20 * var14 - var17 * var22;
                  int var25 = var17 * var19 - var18 * var14;
                  if(var13 * var23 + var15 * var24 + var21 * var25 > 0) {
                     __du_ad[var7] = true;
                     int var26 = (__du_am[var8] + __du_am[var16] + __du_am[var9]) / 3 + this.radius;
                     __du_ax[var26][__du_aa[var26]++] = var7;
                  }
               }
            }
         }

         int[] var27;
         if(this.faceRenderPriorities == null) {
            for(var7 = this.diameter - 1; var7 >= 0; --var7) {
               var8 = __du_aa[var7];
               if(var8 > 0) {
                  var27 = __du_ax[var7];

                  for(var9 = 0; var9 < var8; ++var9) {
                     this.__ag_236(var27[var9]);
                  }
               }
            }
         } else {
            for(var7 = 0; var7 < 12; ++var7) {
               __du_af[var7] = 0;
               __du_bs[var7] = 0;
            }

            for(var7 = this.diameter - 1; var7 >= 0; --var7) {
               var8 = __du_aa[var7];
               if(var8 > 0) {
                  var27 = __du_ax[var7];

                  for(var9 = 0; var9 < var8; ++var9) {
                     var10 = var27[var9];
                     byte var28 = this.faceRenderPriorities[var10];
                     var12 = __du_af[var28]++;
                     __du_ai[var28][var12] = var10;
                     if(var28 < 10) {
                        __du_bs[var28] += var7;
                     } else if(var28 == 10) {
                        __du_ba[var12] = var7;
                     } else {
                        __du_bb[var12] = var7;
                     }
                  }
               }
            }

            var7 = 0;
            if(__du_af[1] > 0 || __du_af[2] > 0) {
               var7 = (__du_bs[1] + __du_bs[2]) / (__du_af[1] + __du_af[2]);
            }

            var8 = 0;
            if(__du_af[3] > 0 || __du_af[4] > 0) {
               var8 = (__du_bs[3] + __du_bs[4]) / (__du_af[3] + __du_af[4]);
            }

            var16 = 0;
            if(__du_af[6] > 0 || __du_af[8] > 0) {
               var16 = (__du_bs[8] + __du_bs[6]) / (__du_af[8] + __du_af[6]);
            }

            var10 = 0;
            var11 = __du_af[10];
            int[] var29 = __du_ai[10];
            int[] var30 = __du_ba;
            if(var10 == var11) {
               var10 = 0;
               var11 = __du_af[11];
               var29 = __du_ai[11];
               var30 = __du_bb;
            }

            if(var10 < var11) {
               var9 = var30[var10];
            } else {
               var9 = -1000;
            }

            for(var13 = 0; var13 < 10; ++var13) {
               while(var13 == 0 && var9 > var7) {
                  this.__ag_236(var29[var10++]);
                  if(var10 == var11 && var29 != __du_ai[11]) {
                     var10 = 0;
                     var11 = __du_af[11];
                     var29 = __du_ai[11];
                     var30 = __du_bb;
                  }

                  if(var10 < var11) {
                     var9 = var30[var10];
                  } else {
                     var9 = -1000;
                  }
               }

               while(var13 == 3 && var9 > var8) {
                  this.__ag_236(var29[var10++]);
                  if(var10 == var11 && var29 != __du_ai[11]) {
                     var10 = 0;
                     var11 = __du_af[11];
                     var29 = __du_ai[11];
                     var30 = __du_bb;
                  }

                  if(var10 < var11) {
                     var9 = var30[var10];
                  } else {
                     var9 = -1000;
                  }
               }

               while(var13 == 5 && var9 > var16) {
                  this.__ag_236(var29[var10++]);
                  if(var10 == var11 && var29 != __du_ai[11]) {
                     var10 = 0;
                     var11 = __du_af[11];
                     var29 = __du_ai[11];
                     var30 = __du_bb;
                  }

                  if(var10 < var11) {
                     var9 = var30[var10];
                  } else {
                     var9 = -1000;
                  }
               }

               var14 = __du_af[var13];
               int[] var31 = __du_ai[var13];

               for(var15 = 0; var15 < var14; ++var15) {
                  this.__ag_236(var31[var15]);
               }
            }

            while(var9 != -1000) {
               this.__ag_236(var29[var10++]);
               if(var10 == var11 && var29 != __du_ai[11]) {
                  var10 = 0;
                  var29 = __du_ai[11];
                  var11 = __du_af[11];
                  var30 = __du_bb;
               }

               if(var10 < var11) {
                  var9 = var30[var10];
               } else {
                  var9 = -1000;
               }
            }
         }
      }

   }

   @ObfuscatedName("ag")
   @Export("__ag_236")
   final void __ag_236(int var1) {
      if(__du_ad[var1]) {
         this.__aq_237(var1);
      } else {
         int var2 = this.indices1[var1];
         int var3 = this.indices2[var1];
         int var4 = this.indices3[var1];
         Rasterizer3D.__et_m = __du_at[var1];
         if(this.faceAlphas == null) {
            Rasterizer3D.Rasterizer3D_alpha = 0;
         } else {
            Rasterizer3D.Rasterizer3D_alpha = this.faceAlphas[var1] & 255;
         }

         if(this.faceTextures != null && this.faceTextures[var1] != -1) {
            int var5;
            int var6;
            int var7;
            if(this.__s != null && this.__s[var1] != -1) {
               int var8 = this.__s[var1] & 255;
               var5 = this.__b[var8];
               var6 = this.__c[var8];
               var7 = this.__r[var8];
            } else {
               var5 = var2;
               var6 = var3;
               var7 = var4;
            }

            if(this.faceColors3[var1] == -1) {
               Rasterizer3D.method2986(modelViewportYs[var2], modelViewportYs[var3], modelViewportYs[var4], modelViewportXs[var2], modelViewportXs[var3], modelViewportXs[var4], this.faceColors1[var1], this.faceColors1[var1], this.faceColors1[var1], __du_an[var5], __du_an[var6], __du_an[var7], __du_az[var5], __du_az[var6], __du_az[var7], __du_au[var5], __du_au[var6], __du_au[var7], this.faceTextures[var1]);
            } else {
               Rasterizer3D.method2986(modelViewportYs[var2], modelViewportYs[var3], modelViewportYs[var4], modelViewportXs[var2], modelViewportXs[var3], modelViewportXs[var4], this.faceColors1[var1], this.faceColors2[var1], this.faceColors3[var1], __du_an[var5], __du_an[var6], __du_an[var7], __du_az[var5], __du_az[var6], __du_az[var7], __du_au[var5], __du_au[var6], __du_au[var7], this.faceTextures[var1]);
            }
         } else if(this.faceColors3[var1] == -1) {
            Rasterizer3D.method3020(modelViewportYs[var2], modelViewportYs[var3], modelViewportYs[var4], modelViewportXs[var2], modelViewportXs[var3], modelViewportXs[var4], __du_br[this.faceColors1[var1]]);
         } else {
            Rasterizer3D.method3037(modelViewportYs[var2], modelViewportYs[var3], modelViewportYs[var4], modelViewportXs[var2], modelViewportXs[var3], modelViewportXs[var4], this.faceColors1[var1], this.faceColors2[var1], this.faceColors3[var1]);
         }
      }

   }

   @ObfuscatedName("aq")
   @Export("__aq_237")
   final void __aq_237(int var1) {
      int var2 = Rasterizer3D.Rasterizer3D_clipMidX;
      int var3 = Rasterizer3D.Rasterizer3D_clipMidY;
      int var4 = 0;
      int var5 = this.indices1[var1];
      int var6 = this.indices2[var1];
      int var7 = this.indices3[var1];
      int var8 = __du_au[var5];
      int var9 = __du_au[var6];
      int var10 = __du_au[var7];
      if(this.faceAlphas == null) {
         Rasterizer3D.Rasterizer3D_alpha = 0;
      } else {
         Rasterizer3D.Rasterizer3D_alpha = this.faceAlphas[var1] & 255;
      }

      int var11;
      int var12;
      int var13;
      int var14;
      if(var8 >= 50) {
         __du_bq[var4] = modelViewportXs[var5];
         __du_bn[var4] = modelViewportYs[var5];
         __du_bk[var4++] = this.faceColors1[var1];
      } else {
         var11 = __du_an[var5];
         var12 = __du_az[var5];
         var13 = this.faceColors1[var1];
         if(var10 >= 50) {
            var14 = __du_bj[var10 - var8] * (50 - var8);
            __du_bq[var4] = var2 + Rasterizer3D.Rasterizer3D_zoom * (var11 + ((__du_an[var7] - var11) * var14 >> 16)) / 50;
            __du_bn[var4] = var3 + Rasterizer3D.Rasterizer3D_zoom * (var12 + ((__du_az[var7] - var12) * var14 >> 16)) / 50;
            __du_bk[var4++] = var13 + ((this.faceColors3[var1] - var13) * var14 >> 16);
         }

         if(var9 >= 50) {
            var14 = __du_bj[var9 - var8] * (50 - var8);
            __du_bq[var4] = var2 + Rasterizer3D.Rasterizer3D_zoom * (var11 + ((__du_an[var6] - var11) * var14 >> 16)) / 50;
            __du_bn[var4] = var3 + Rasterizer3D.Rasterizer3D_zoom * (var12 + ((__du_az[var6] - var12) * var14 >> 16)) / 50;
            __du_bk[var4++] = var13 + ((this.faceColors2[var1] - var13) * var14 >> 16);
         }
      }

      if(var9 >= 50) {
         __du_bq[var4] = modelViewportXs[var6];
         __du_bn[var4] = modelViewportYs[var6];
         __du_bk[var4++] = this.faceColors2[var1];
      } else {
         var11 = __du_an[var6];
         var12 = __du_az[var6];
         var13 = this.faceColors2[var1];
         if(var8 >= 50) {
            var14 = __du_bj[var8 - var9] * (50 - var9);
            __du_bq[var4] = var2 + Rasterizer3D.Rasterizer3D_zoom * (var11 + ((__du_an[var5] - var11) * var14 >> 16)) / 50;
            __du_bn[var4] = var3 + Rasterizer3D.Rasterizer3D_zoom * (var12 + ((__du_az[var5] - var12) * var14 >> 16)) / 50;
            __du_bk[var4++] = var13 + ((this.faceColors1[var1] - var13) * var14 >> 16);
         }

         if(var10 >= 50) {
            var14 = __du_bj[var10 - var9] * (50 - var9);
            __du_bq[var4] = var2 + Rasterizer3D.Rasterizer3D_zoom * (var11 + ((__du_an[var7] - var11) * var14 >> 16)) / 50;
            __du_bn[var4] = var3 + Rasterizer3D.Rasterizer3D_zoom * (var12 + ((__du_az[var7] - var12) * var14 >> 16)) / 50;
            __du_bk[var4++] = var13 + ((this.faceColors3[var1] - var13) * var14 >> 16);
         }
      }

      if(var10 >= 50) {
         __du_bq[var4] = modelViewportXs[var7];
         __du_bn[var4] = modelViewportYs[var7];
         __du_bk[var4++] = this.faceColors3[var1];
      } else {
         var11 = __du_an[var7];
         var12 = __du_az[var7];
         var13 = this.faceColors3[var1];
         if(var9 >= 50) {
            var14 = __du_bj[var9 - var10] * (50 - var10);
            __du_bq[var4] = var2 + Rasterizer3D.Rasterizer3D_zoom * (var11 + ((__du_an[var6] - var11) * var14 >> 16)) / 50;
            __du_bn[var4] = var3 + Rasterizer3D.Rasterizer3D_zoom * (var12 + ((__du_az[var6] - var12) * var14 >> 16)) / 50;
            __du_bk[var4++] = var13 + ((this.faceColors2[var1] - var13) * var14 >> 16);
         }

         if(var8 >= 50) {
            var14 = __du_bj[var8 - var10] * (50 - var10);
            __du_bq[var4] = var2 + Rasterizer3D.Rasterizer3D_zoom * (var11 + ((__du_an[var5] - var11) * var14 >> 16)) / 50;
            __du_bn[var4] = var3 + Rasterizer3D.Rasterizer3D_zoom * (var12 + ((__du_az[var5] - var12) * var14 >> 16)) / 50;
            __du_bk[var4++] = var13 + ((this.faceColors1[var1] - var13) * var14 >> 16);
         }
      }

      var11 = __du_bq[0];
      var12 = __du_bq[1];
      var13 = __du_bq[2];
      var14 = __du_bn[0];
      int var15 = __du_bn[1];
      int var16 = __du_bn[2];
      Rasterizer3D.__et_m = false;
      int var17;
      int var18;
      int var19;
      int var20;
      if(var4 == 3) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > Rasterizer3D.Rasterizer3D_clipWidth || var12 > Rasterizer3D.Rasterizer3D_clipWidth || var13 > Rasterizer3D.Rasterizer3D_clipWidth) {
            Rasterizer3D.__et_m = true;
         }

         if(this.faceTextures != null && this.faceTextures[var1] != -1) {
            if(this.__s != null && this.__s[var1] != -1) {
               var20 = this.__s[var1] & 255;
               var17 = this.__b[var20];
               var18 = this.__c[var20];
               var19 = this.__r[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            if(this.faceColors3[var1] == -1) {
               Rasterizer3D.method2986(var14, var15, var16, var11, var12, var13, this.faceColors1[var1], this.faceColors1[var1], this.faceColors1[var1], __du_an[var17], __du_an[var18], __du_an[var19], __du_az[var17], __du_az[var18], __du_az[var19], __du_au[var17], __du_au[var18], __du_au[var19], this.faceTextures[var1]);
            } else {
               Rasterizer3D.method2986(var14, var15, var16, var11, var12, var13, __du_bk[0], __du_bk[1], __du_bk[2], __du_an[var17], __du_an[var18], __du_an[var19], __du_az[var17], __du_az[var18], __du_az[var19], __du_au[var17], __du_au[var18], __du_au[var19], this.faceTextures[var1]);
            }
         } else if(this.faceColors3[var1] == -1) {
            Rasterizer3D.method3020(var14, var15, var16, var11, var12, var13, __du_br[this.faceColors1[var1]]);
         } else {
            Rasterizer3D.method3037(var14, var15, var16, var11, var12, var13, __du_bk[0], __du_bk[1], __du_bk[2]);
         }
      }

      if(var4 == 4) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > Rasterizer3D.Rasterizer3D_clipWidth || var12 > Rasterizer3D.Rasterizer3D_clipWidth || var13 > Rasterizer3D.Rasterizer3D_clipWidth || __du_bq[3] < 0 || __du_bq[3] > Rasterizer3D.Rasterizer3D_clipWidth) {
            Rasterizer3D.__et_m = true;
         }

         if(this.faceTextures != null && this.faceTextures[var1] != -1) {
            if(this.__s != null && this.__s[var1] != -1) {
               var20 = this.__s[var1] & 255;
               var17 = this.__b[var20];
               var18 = this.__c[var20];
               var19 = this.__r[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            short var21 = this.faceTextures[var1];
            if(this.faceColors3[var1] == -1) {
               Rasterizer3D.method2986(var14, var15, var16, var11, var12, var13, this.faceColors1[var1], this.faceColors1[var1], this.faceColors1[var1], __du_an[var17], __du_an[var18], __du_an[var19], __du_az[var17], __du_az[var18], __du_az[var19], __du_au[var17], __du_au[var18], __du_au[var19], var21);
               Rasterizer3D.method2986(var14, var16, __du_bn[3], var11, var13, __du_bq[3], this.faceColors1[var1], this.faceColors1[var1], this.faceColors1[var1], __du_an[var17], __du_an[var18], __du_an[var19], __du_az[var17], __du_az[var18], __du_az[var19], __du_au[var17], __du_au[var18], __du_au[var19], var21);
            } else {
               Rasterizer3D.method2986(var14, var15, var16, var11, var12, var13, __du_bk[0], __du_bk[1], __du_bk[2], __du_an[var17], __du_an[var18], __du_an[var19], __du_az[var17], __du_az[var18], __du_az[var19], __du_au[var17], __du_au[var18], __du_au[var19], var21);
               Rasterizer3D.method2986(var14, var16, __du_bn[3], var11, var13, __du_bq[3], __du_bk[0], __du_bk[2], __du_bk[3], __du_an[var17], __du_an[var18], __du_an[var19], __du_az[var17], __du_az[var18], __du_az[var19], __du_au[var17], __du_au[var18], __du_au[var19], var21);
            }
         } else if(this.faceColors3[var1] == -1) {
            var17 = __du_br[this.faceColors1[var1]];
            Rasterizer3D.method3020(var14, var15, var16, var11, var12, var13, var17);
            Rasterizer3D.method3020(var14, var16, __du_bn[3], var11, var13, __du_bq[3], var17);
         } else {
            Rasterizer3D.method3037(var14, var15, var16, var11, var12, var13, __du_bk[0], __du_bk[1], __du_bk[2]);
            Rasterizer3D.method3037(var14, var16, __du_bn[3], var11, var13, __du_bq[3], __du_bk[0], __du_bk[2], __du_bk[3]);
         }
      }

   }

   @ObfuscatedName("cy")
   void renderDraw(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, long var9) {
      __du_aa[0] = -1;
      if(this.boundsType != 1) {
         this.calculateBoundsCylinder();
      }

      this.calculateBoundingBox(var1);
      int var11 = var5 * var8 - var4 * var6 >> 16;
      int var12 = var2 * var7 + var3 * var11 >> 16;
      int var13 = var3 * this.xzRadius >> 16;
      int var14 = var12 + var13;
      if(var14 > 50 && var12 < 3500) {
         int var15 = var8 * var4 + var5 * var6 >> 16;
         int var16 = (var15 - this.xzRadius) * Rasterizer3D.Rasterizer3D_zoom;
         if(var16 / var14 < Rasterizer3D.Rasterizer3D_clipMidX2) {
            int var17 = (var15 + this.xzRadius) * Rasterizer3D.Rasterizer3D_zoom;
            if(var17 / var14 > Rasterizer3D.Rasterizer3D_clipNegativeMidX) {
               int var18 = var3 * var7 - var11 * var2 >> 16;
               int var19 = var2 * this.xzRadius >> 16;
               int var20 = (var18 + var19) * Rasterizer3D.Rasterizer3D_zoom;
               if(var20 / var14 > Rasterizer3D.Rasterizer3D_clipNegativeMidY) {
                  int var21 = (var3 * super.height >> 16) + var19;
                  int var22 = (var18 - var21) * Rasterizer3D.Rasterizer3D_zoom;
                  if(var22 / var14 < Rasterizer3D.Rasterizer3D_clipMidY2) {
                     int var23 = var13 + (var2 * super.height >> 16);
                     boolean var24 = false;
                     boolean var25 = false;
                     if(var12 - var23 <= 50) {
                        var25 = true;
                     }

                     boolean var26 = var25 || this.__h > 0;
                     int var27 = ViewportMouse.ViewportMouse_x;
                     int var28 = ViewportMouse.ViewportMouse_y;
                     boolean var29 = ViewportMouse.ViewportMouse_isInViewport;
                     boolean var30 = 0L != var9;
                     boolean var31;
                     if(var30) {
                        var31 = (int)(var9 >>> 16 & 1L) == 1;
                        var30 = !var31;
                     }

                     var31 = false;
                     int var32;
                     int var33;
                     int var34;
                     if(var30 && var29) {
                        boolean var35 = false;
                        if(__du_bx) {
                           var35 = Decimator.method2491(this, var6, var7, var8);
                        } else {
                           var32 = var12 - var13;
                           if(var32 <= 50) {
                              var32 = 50;
                           }

                           if(var15 > 0) {
                              var16 /= var14;
                              var17 /= var32;
                           } else {
                              var17 /= var14;
                              var16 /= var32;
                           }

                           if(var18 > 0) {
                              var22 /= var14;
                              var20 /= var32;
                           } else {
                              var20 /= var14;
                              var22 /= var32;
                           }

                           var33 = var27 - Rasterizer3D.Rasterizer3D_clipMidX;
                           var34 = var28 - Rasterizer3D.Rasterizer3D_clipMidY;
                           if(var33 > var16 && var33 < var17 && var34 > var22 && var34 < var20) {
                              var35 = true;
                           }
                        }

                        if(var35) {
                           if(this.isSingleTile) {
                              Projectile.method2081(var9);
                           } else {
                              var31 = true;
                           }
                        }
                     }

                     int var42 = Rasterizer3D.Rasterizer3D_clipMidX;
                     var32 = Rasterizer3D.Rasterizer3D_clipMidY;
                     var33 = 0;
                     var34 = 0;
                     if(var1 != 0) {
                        var33 = Model_sine[var1];
                        var34 = Model_cosine[var1];
                     }

                     for(int var36 = 0; var36 < this.verticesCount; ++var36) {
                        int var37 = this.verticesX[var36];
                        int var38 = this.verticesY[var36];
                        int var39 = this.verticesZ[var36];
                        int var40;
                        if(var1 != 0) {
                           var40 = var39 * var33 + var37 * var34 >> 16;
                           var39 = var39 * var34 - var37 * var33 >> 16;
                           var37 = var40;
                        }

                        var37 += var6;
                        var38 += var7;
                        var39 += var8;
                        var40 = var39 * var4 + var5 * var37 >> 16;
                        var39 = var5 * var39 - var37 * var4 >> 16;
                        var37 = var40;
                        var40 = var3 * var38 - var39 * var2 >> 16;
                        var39 = var38 * var2 + var3 * var39 >> 16;
                        __du_am[var36] = var39 - var12;
                        if(var39 >= 50) {
                           modelViewportXs[var36] = var37 * Rasterizer3D.Rasterizer3D_zoom / var39 + var42;
                           modelViewportYs[var36] = var40 * Rasterizer3D.Rasterizer3D_zoom / var39 + var32;
                        } else {
                           modelViewportXs[var36] = -5000;
                           var24 = true;
                        }

                        if(var26) {
                           __du_an[var36] = var37;
                           __du_az[var36] = var40;
                           __du_au[var36] = var39;
                        }
                     }

                     try {
                        this.draw0(var24, var31, this.isSingleTile, var9);
                     } catch (Exception var41) {
                        ;
                     }
                  }
               }
            }
         }
      }

   }

   static {
      Model_sharedSequenceModel = new Model();
      Model_sharedSequenceModelFaceAlphas = new byte[1];
      Model_sharedSpotAnimationModel = new Model();
      Model_sharedSpotAnimationModelFaceAlphas = new byte[1];
      __du_at = new boolean[4700];
      __du_ad = new boolean[4700];
      modelViewportXs = new int[4700];
      modelViewportYs = new int[4700];
      __du_am = new int[4700];
      __du_an = new int[4700];
      __du_az = new int[4700];
      __du_au = new int[4700];
      __du_aa = new int[1600];
      __du_ax = new int[1600][512];
      __du_af = new int[12];
      __du_ai = new int[12][2000];
      __du_ba = new int[2000];
      __du_bb = new int[2000];
      __du_bs = new int[12];
      __du_bq = new int[10];
      __du_bn = new int[10];
      __du_bk = new int[10];
      __du_bx = true;
      Model_sine = Rasterizer3D.Rasterizer3D_sine;
      Model_cosine = Rasterizer3D.Rasterizer3D_cosine;
      __du_br = Rasterizer3D.Rasterizer3D_colorPalette;
      __du_bj = Rasterizer3D.__et_p;
   }
}
