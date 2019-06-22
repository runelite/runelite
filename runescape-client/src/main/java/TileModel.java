import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dv")
@Implements("TileModel")
public final class TileModel {
   @ObfuscatedName("z")
   @Export("__dv_z")
   static int[] __dv_z;
   @ObfuscatedName("j")
   @Export("__dv_j")
   static int[] __dv_j;
   @ObfuscatedName("s")
   @Export("__dv_s")
   static int[] __dv_s;
   @ObfuscatedName("t")
   @Export("__dv_t")
   static int[] __dv_t;
   @ObfuscatedName("y")
   @Export("__dv_y")
   static int[] __dv_y;
   @ObfuscatedName("h")
   @Export("__dv_h")
   static final int[][] __dv_h;
   @ObfuscatedName("b")
   @Export("__dv_b")
   static final int[][] __dv_b;
   @ObfuscatedName("m")
   @Export("vertexX")
   int[] vertexX;
   @ObfuscatedName("f")
   @Export("vertexY")
   int[] vertexY;
   @ObfuscatedName("q")
   @Export("vertexZ")
   int[] vertexZ;
   @ObfuscatedName("w")
   @Export("triangleColorA")
   int[] triangleColorA;
   @ObfuscatedName("o")
   @Export("triangleColorB")
   int[] triangleColorB;
   @ObfuscatedName("u")
   @Export("triangleColorC")
   int[] triangleColorC;
   @ObfuscatedName("g")
   @Export("faceX")
   int[] faceX;
   @ObfuscatedName("l")
   @Export("faceY")
   int[] faceY;
   @ObfuscatedName("e")
   @Export("faceZ")
   int[] faceZ;
   @ObfuscatedName("x")
   @Export("triangleTextureId")
   int[] triangleTextureId;
   @ObfuscatedName("d")
   @Export("isFlat")
   boolean isFlat;
   @ObfuscatedName("k")
   @Export("shape")
   int shape;
   @ObfuscatedName("n")
   @Export("rotation")
   int rotation;
   @ObfuscatedName("i")
   @Export("underlayRgb")
   int underlayRgb;
   @ObfuscatedName("a")
   @Export("overlayRgb")
   int overlayRgb;

   TileModel(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, int var13, int var14, int var15, int var16, int var17, int var18, int var19) {
      this.isFlat = true;
      if(var7 != var6 || var8 != var6 || var9 != var6) {
         this.isFlat = false;
      }

      this.shape = var1;
      this.rotation = var2;
      this.underlayRgb = var18;
      this.overlayRgb = var19;
      short var20 = 128;
      int var21 = var20 / 2;
      int var22 = var20 / 4;
      int var23 = var20 * 3 / 4;
      int[] var24 = __dv_h[var1];
      int var25 = var24.length;
      this.vertexX = new int[var25];
      this.vertexY = new int[var25];
      this.vertexZ = new int[var25];
      int[] var26 = new int[var25];
      int[] var27 = new int[var25];
      int var28 = var20 * var4;
      int var29 = var5 * var20;

      int var30;
      int var31;
      int var32;
      int var33;
      int var34;
      int var35;
      for(int var36 = 0; var36 < var25; ++var36) {
         var30 = var24[var36];
         if((var30 & 1) == 0 && var30 <= 8) {
            var30 = (var30 - var2 - var2 - 1 & 7) + 1;
         }

         if(var30 > 8 && var30 <= 12) {
            var30 = (var30 - 9 - var2 & 3) + 9;
         }

         if(var30 > 12 && var30 <= 16) {
            var30 = (var30 - 13 - var2 & 3) + 13;
         }

         if(var30 == 1) {
            var31 = var28;
            var32 = var29;
            var33 = var6;
            var34 = var10;
            var35 = var14;
         } else if(var30 == 2) {
            var31 = var28 + var21;
            var32 = var29;
            var33 = var7 + var6 >> 1;
            var34 = var11 + var10 >> 1;
            var35 = var15 + var14 >> 1;
         } else if(var30 == 3) {
            var31 = var28 + var20;
            var32 = var29;
            var33 = var7;
            var34 = var11;
            var35 = var15;
         } else if(var30 == 4) {
            var31 = var28 + var20;
            var32 = var29 + var21;
            var33 = var8 + var7 >> 1;
            var34 = var11 + var12 >> 1;
            var35 = var15 + var16 >> 1;
         } else if(var30 == 5) {
            var31 = var28 + var20;
            var32 = var29 + var20;
            var33 = var8;
            var34 = var12;
            var35 = var16;
         } else if(var30 == 6) {
            var31 = var28 + var21;
            var32 = var29 + var20;
            var33 = var8 + var9 >> 1;
            var34 = var13 + var12 >> 1;
            var35 = var17 + var16 >> 1;
         } else if(var30 == 7) {
            var31 = var28;
            var32 = var29 + var20;
            var33 = var9;
            var34 = var13;
            var35 = var17;
         } else if(var30 == 8) {
            var31 = var28;
            var32 = var29 + var21;
            var33 = var9 + var6 >> 1;
            var34 = var13 + var10 >> 1;
            var35 = var17 + var14 >> 1;
         } else if(var30 == 9) {
            var31 = var28 + var21;
            var32 = var29 + var22;
            var33 = var7 + var6 >> 1;
            var34 = var11 + var10 >> 1;
            var35 = var15 + var14 >> 1;
         } else if(var30 == 10) {
            var31 = var28 + var23;
            var32 = var29 + var21;
            var33 = var8 + var7 >> 1;
            var34 = var11 + var12 >> 1;
            var35 = var15 + var16 >> 1;
         } else if(var30 == 11) {
            var31 = var28 + var21;
            var32 = var29 + var23;
            var33 = var8 + var9 >> 1;
            var34 = var13 + var12 >> 1;
            var35 = var17 + var16 >> 1;
         } else if(var30 == 12) {
            var31 = var28 + var22;
            var32 = var29 + var21;
            var33 = var9 + var6 >> 1;
            var34 = var13 + var10 >> 1;
            var35 = var17 + var14 >> 1;
         } else if(var30 == 13) {
            var31 = var28 + var22;
            var32 = var29 + var22;
            var33 = var6;
            var34 = var10;
            var35 = var14;
         } else if(var30 == 14) {
            var31 = var28 + var23;
            var32 = var29 + var22;
            var33 = var7;
            var34 = var11;
            var35 = var15;
         } else if(var30 == 15) {
            var31 = var28 + var23;
            var32 = var29 + var23;
            var33 = var8;
            var34 = var12;
            var35 = var16;
         } else {
            var31 = var28 + var22;
            var32 = var29 + var23;
            var33 = var9;
            var34 = var13;
            var35 = var17;
         }

         this.vertexX[var36] = var31;
         this.vertexY[var36] = var33;
         this.vertexZ[var36] = var32;
         var26[var36] = var34;
         var27[var36] = var35;
      }

      int[] var38 = __dv_b[var1];
      var30 = var38.length / 4;
      this.faceX = new int[var30];
      this.faceY = new int[var30];
      this.faceZ = new int[var30];
      this.triangleColorA = new int[var30];
      this.triangleColorB = new int[var30];
      this.triangleColorC = new int[var30];
      if(var3 != -1) {
         this.triangleTextureId = new int[var30];
      }

      var31 = 0;

      for(var32 = 0; var32 < var30; ++var32) {
         var33 = var38[var31];
         var34 = var38[var31 + 1];
         var35 = var38[var31 + 2];
         int var37 = var38[var31 + 3];
         var31 += 4;
         if(var34 < 4) {
            var34 = var34 - var2 & 3;
         }

         if(var35 < 4) {
            var35 = var35 - var2 & 3;
         }

         if(var37 < 4) {
            var37 = var37 - var2 & 3;
         }

         this.faceX[var32] = var34;
         this.faceY[var32] = var35;
         this.faceZ[var32] = var37;
         if(var33 == 0) {
            this.triangleColorA[var32] = var26[var34];
            this.triangleColorB[var32] = var26[var35];
            this.triangleColorC[var32] = var26[var37];
            if(this.triangleTextureId != null) {
               this.triangleTextureId[var32] = -1;
            }
         } else {
            this.triangleColorA[var32] = var27[var34];
            this.triangleColorB[var32] = var27[var35];
            this.triangleColorC[var32] = var27[var37];
            if(this.triangleTextureId != null) {
               this.triangleTextureId[var32] = var3;
            }
         }
      }

      var32 = var6;
      var33 = var7;
      if(var7 < var6) {
         var32 = var7;
      }

      if(var7 > var7) {
         var33 = var7;
      }

      if(var8 < var32) {
         var32 = var8;
      }

      if(var8 > var33) {
         var33 = var8;
      }

      if(var9 < var32) {
         var32 = var9;
      }

      if(var9 > var33) {
         var33 = var9;
      }

      var32 /= 14;
      var33 /= 14;
   }

   static {
      __dv_z = new int[6];
      __dv_j = new int[6];
      __dv_s = new int[6];
      __dv_t = new int[6];
      __dv_y = new int[6];
      __dv_h = new int[][]{{1, 3, 5, 7}, {1, 3, 5, 7}, {1, 3, 5, 7}, {1, 3, 5, 7, 6}, {1, 3, 5, 7, 6}, {1, 3, 5, 7, 6}, {1, 3, 5, 7, 6}, {1, 3, 5, 7, 2, 6}, {1, 3, 5, 7, 2, 8}, {1, 3, 5, 7, 2, 8}, {1, 3, 5, 7, 11, 12}, {1, 3, 5, 7, 11, 12}, {1, 3, 5, 7, 13, 14}};
      __dv_b = new int[][]{{0, 1, 2, 3, 0, 0, 1, 3}, {1, 1, 2, 3, 1, 0, 1, 3}, {0, 1, 2, 3, 1, 0, 1, 3}, {0, 0, 1, 2, 0, 0, 2, 4, 1, 0, 4, 3}, {0, 0, 1, 4, 0, 0, 4, 3, 1, 1, 2, 4}, {0, 0, 4, 3, 1, 0, 1, 2, 1, 0, 2, 4}, {0, 1, 2, 4, 1, 0, 1, 4, 1, 0, 4, 3}, {0, 4, 1, 2, 0, 4, 2, 5, 1, 0, 4, 5, 1, 0, 5, 3}, {0, 4, 1, 2, 0, 4, 2, 3, 0, 4, 3, 5, 1, 0, 4, 5}, {0, 0, 4, 5, 1, 4, 1, 2, 1, 4, 2, 3, 1, 4, 3, 5}, {0, 0, 1, 5, 0, 1, 4, 5, 0, 1, 2, 4, 1, 0, 5, 3, 1, 5, 4, 3, 1, 4, 2, 3}, {1, 0, 1, 5, 1, 1, 4, 5, 1, 1, 2, 4, 0, 0, 5, 3, 0, 5, 4, 3, 0, 4, 2, 3}, {1, 0, 5, 4, 1, 0, 1, 5, 0, 0, 4, 3, 0, 4, 5, 3, 0, 5, 2, 3, 0, 1, 2, 5}};
   }
}
