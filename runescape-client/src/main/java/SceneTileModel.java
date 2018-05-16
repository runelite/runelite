import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("de")
@Implements("SceneTileModel")
public final class SceneTileModel {
   @ObfuscatedName("y")
   @Export("tmpScreenX")
   static int[] tmpScreenX;
   @ObfuscatedName("c")
   @Export("tmpScreenY")
   static int[] tmpScreenY;
   @ObfuscatedName("e")
   @Export("vertexSceneX")
   static int[] vertexSceneX;
   @ObfuscatedName("t")
   @Export("vertexSceneY")
   static int[] vertexSceneY;
   @ObfuscatedName("u")
   @Export("vertexSceneZ")
   static int[] vertexSceneZ;
   @ObfuscatedName("i")
   static final int[][] field1548;
   @ObfuscatedName("z")
   static final int[][] field1549;
   @ObfuscatedName("w")
   @Export("vertexX")
   int[] vertexX;
   @ObfuscatedName("m")
   @Export("vertexY")
   int[] vertexY;
   @ObfuscatedName("q")
   @Export("vertexZ")
   int[] vertexZ;
   @ObfuscatedName("b")
   @Export("triangleColorA")
   int[] triangleColorA;
   @ObfuscatedName("f")
   @Export("triangleColorB")
   int[] triangleColorB;
   @ObfuscatedName("n")
   @Export("triangleColorC")
   int[] triangleColorC;
   @ObfuscatedName("h")
   int[] field1534;
   @ObfuscatedName("x")
   int[] field1535;
   @ObfuscatedName("j")
   int[] field1536;
   @ObfuscatedName("a")
   @Export("triangleTextureId")
   int[] triangleTextureId;
   @ObfuscatedName("l")
   @Export("flatShade")
   boolean flatShade;
   @ObfuscatedName("d")
   @Export("shape")
   int shape;
   @ObfuscatedName("s")
   @Export("rotation")
   int rotation;
   @ObfuscatedName("p")
   @Export("underlay")
   int underlay;
   @ObfuscatedName("g")
   @Export("overlay")
   int overlay;

   static {
      tmpScreenX = new int[6];
      tmpScreenY = new int[6];
      vertexSceneX = new int[6];
      vertexSceneY = new int[6];
      vertexSceneZ = new int[6];
      field1548 = new int[][]{{1, 3, 5, 7}, {1, 3, 5, 7}, {1, 3, 5, 7}, {1, 3, 5, 7, 6}, {1, 3, 5, 7, 6}, {1, 3, 5, 7, 6}, {1, 3, 5, 7, 6}, {1, 3, 5, 7, 2, 6}, {1, 3, 5, 7, 2, 8}, {1, 3, 5, 7, 2, 8}, {1, 3, 5, 7, 11, 12}, {1, 3, 5, 7, 11, 12}, {1, 3, 5, 7, 13, 14}};
      field1549 = new int[][]{{0, 1, 2, 3, 0, 0, 1, 3}, {1, 1, 2, 3, 1, 0, 1, 3}, {0, 1, 2, 3, 1, 0, 1, 3}, {0, 0, 1, 2, 0, 0, 2, 4, 1, 0, 4, 3}, {0, 0, 1, 4, 0, 0, 4, 3, 1, 1, 2, 4}, {0, 0, 4, 3, 1, 0, 1, 2, 1, 0, 2, 4}, {0, 1, 2, 4, 1, 0, 1, 4, 1, 0, 4, 3}, {0, 4, 1, 2, 0, 4, 2, 5, 1, 0, 4, 5, 1, 0, 5, 3}, {0, 4, 1, 2, 0, 4, 2, 3, 0, 4, 3, 5, 1, 0, 4, 5}, {0, 0, 4, 5, 1, 4, 1, 2, 1, 4, 2, 3, 1, 4, 3, 5}, {0, 0, 1, 5, 0, 1, 4, 5, 0, 1, 2, 4, 1, 0, 5, 3, 1, 5, 4, 3, 1, 4, 2, 3}, {1, 0, 1, 5, 1, 1, 4, 5, 1, 1, 2, 4, 0, 0, 5, 3, 0, 5, 4, 3, 0, 4, 2, 3}, {1, 0, 5, 4, 1, 0, 1, 5, 0, 0, 4, 3, 0, 4, 5, 3, 0, 5, 2, 3, 0, 1, 2, 5}};
   }

   SceneTileModel(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, int var13, int var14, int var15, int var16, int var17, int var18, int var19) {
      this.flatShade = true;
      if(var7 != var6 || var8 != var6 || var9 != var6) {
         this.flatShade = false;
      }

      this.shape = var1;
      this.rotation = var2;
      this.underlay = var18;
      this.overlay = var19;
      short var20 = 128;
      int var21 = var20 / 2;
      int var22 = var20 / 4;
      int var23 = var20 * 3 / 4;
      int[] var24 = field1548[var1];
      int var25 = var24.length;
      this.vertexX = new int[var25];
      this.vertexY = new int[var25];
      this.vertexZ = new int[var25];
      int[] var26 = new int[var25];
      int[] var27 = new int[var25];
      int var28 = var20 * var4;
      int var29 = var5 * var20;

      int var31;
      int var32;
      int var33;
      int var34;
      int var35;
      int var36;
      for(int var30 = 0; var30 < var25; ++var30) {
         var31 = var24[var30];
         if((var31 & 1) == 0 && var31 <= 8) {
            var31 = (var31 - var2 - var2 - 1 & 7) + 1;
         }

         if(var31 > 8 && var31 <= 12) {
            var31 = (var31 - 9 - var2 & 3) + 9;
         }

         if(var31 > 12 && var31 <= 16) {
            var31 = (var31 - 13 - var2 & 3) + 13;
         }

         if(var31 == 1) {
            var32 = var28;
            var33 = var29;
            var34 = var6;
            var35 = var10;
            var36 = var14;
         } else if(var31 == 2) {
            var32 = var28 + var21;
            var33 = var29;
            var34 = var7 + var6 >> 1;
            var35 = var11 + var10 >> 1;
            var36 = var15 + var14 >> 1;
         } else if(var31 == 3) {
            var32 = var28 + var20;
            var33 = var29;
            var34 = var7;
            var35 = var11;
            var36 = var15;
         } else if(var31 == 4) {
            var32 = var28 + var20;
            var33 = var29 + var21;
            var34 = var8 + var7 >> 1;
            var35 = var11 + var12 >> 1;
            var36 = var15 + var16 >> 1;
         } else if(var31 == 5) {
            var32 = var28 + var20;
            var33 = var29 + var20;
            var34 = var8;
            var35 = var12;
            var36 = var16;
         } else if(var31 == 6) {
            var32 = var28 + var21;
            var33 = var29 + var20;
            var34 = var8 + var9 >> 1;
            var35 = var13 + var12 >> 1;
            var36 = var17 + var16 >> 1;
         } else if(var31 == 7) {
            var32 = var28;
            var33 = var29 + var20;
            var34 = var9;
            var35 = var13;
            var36 = var17;
         } else if(var31 == 8) {
            var32 = var28;
            var33 = var29 + var21;
            var34 = var9 + var6 >> 1;
            var35 = var13 + var10 >> 1;
            var36 = var17 + var14 >> 1;
         } else if(var31 == 9) {
            var32 = var28 + var21;
            var33 = var29 + var22;
            var34 = var7 + var6 >> 1;
            var35 = var11 + var10 >> 1;
            var36 = var15 + var14 >> 1;
         } else if(var31 == 10) {
            var32 = var28 + var23;
            var33 = var29 + var21;
            var34 = var8 + var7 >> 1;
            var35 = var11 + var12 >> 1;
            var36 = var15 + var16 >> 1;
         } else if(var31 == 11) {
            var32 = var28 + var21;
            var33 = var29 + var23;
            var34 = var8 + var9 >> 1;
            var35 = var13 + var12 >> 1;
            var36 = var17 + var16 >> 1;
         } else if(var31 == 12) {
            var32 = var28 + var22;
            var33 = var29 + var21;
            var34 = var9 + var6 >> 1;
            var35 = var13 + var10 >> 1;
            var36 = var17 + var14 >> 1;
         } else if(var31 == 13) {
            var32 = var28 + var22;
            var33 = var29 + var22;
            var34 = var6;
            var35 = var10;
            var36 = var14;
         } else if(var31 == 14) {
            var32 = var28 + var23;
            var33 = var29 + var22;
            var34 = var7;
            var35 = var11;
            var36 = var15;
         } else if(var31 == 15) {
            var32 = var28 + var23;
            var33 = var29 + var23;
            var34 = var8;
            var35 = var12;
            var36 = var16;
         } else {
            var32 = var28 + var22;
            var33 = var29 + var23;
            var34 = var9;
            var35 = var13;
            var36 = var17;
         }

         this.vertexX[var30] = var32;
         this.vertexY[var30] = var34;
         this.vertexZ[var30] = var33;
         var26[var30] = var35;
         var27[var30] = var36;
      }

      int[] var38 = field1549[var1];
      var31 = var38.length / 4;
      this.field1534 = new int[var31];
      this.field1535 = new int[var31];
      this.field1536 = new int[var31];
      this.triangleColorA = new int[var31];
      this.triangleColorB = new int[var31];
      this.triangleColorC = new int[var31];
      if(var3 != -1) {
         this.triangleTextureId = new int[var31];
      }

      var32 = 0;

      for(var33 = 0; var33 < var31; ++var33) {
         var34 = var38[var32];
         var35 = var38[var32 + 1];
         var36 = var38[var32 + 2];
         int var37 = var38[var32 + 3];
         var32 += 4;
         if(var35 < 4) {
            var35 = var35 - var2 & 3;
         }

         if(var36 < 4) {
            var36 = var36 - var2 & 3;
         }

         if(var37 < 4) {
            var37 = var37 - var2 & 3;
         }

         this.field1534[var33] = var35;
         this.field1535[var33] = var36;
         this.field1536[var33] = var37;
         if(var34 == 0) {
            this.triangleColorA[var33] = var26[var35];
            this.triangleColorB[var33] = var26[var36];
            this.triangleColorC[var33] = var26[var37];
            if(this.triangleTextureId != null) {
               this.triangleTextureId[var33] = -1;
            }
         } else {
            this.triangleColorA[var33] = var27[var35];
            this.triangleColorB[var33] = var27[var36];
            this.triangleColorC[var33] = var27[var37];
            if(this.triangleTextureId != null) {
               this.triangleTextureId[var33] = var3;
            }
         }
      }

      var33 = var6;
      var34 = var7;
      if(var7 < var6) {
         var33 = var7;
      }

      if(var7 > var7) {
         var34 = var7;
      }

      if(var8 < var33) {
         var33 = var8;
      }

      if(var8 > var34) {
         var34 = var8;
      }

      if(var9 < var33) {
         var33 = var9;
      }

      if(var9 > var34) {
         var34 = var9;
      }

      var33 /= 14;
      var34 /= 14;
   }
}
