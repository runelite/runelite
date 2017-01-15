import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bg")
public final class class77 {
   @ObfuscatedName("m")
   int field1265;
   @ObfuscatedName("x")
   int[] field1266;
   @ObfuscatedName("i")
   int[] field1267;
   @ObfuscatedName("a")
   int[] field1268;
   @ObfuscatedName("f")
   int[] field1269;
   @ObfuscatedName("c")
   int[] field1270;
   @ObfuscatedName("d")
   int[] field1271;
   @ObfuscatedName("k")
   static int[] field1272 = new int[6];
   @ObfuscatedName("q")
   int field1273;
   @ObfuscatedName("z")
   int[] field1274;
   @ObfuscatedName("g")
   int[] field1275;
   @ObfuscatedName("l")
   int[] field1276;
   @ObfuscatedName("p")
   static int[] field1277 = new int[6];
   @ObfuscatedName("e")
   int field1278;
   @ObfuscatedName("v")
   int field1279;
   @ObfuscatedName("t")
   boolean field1280 = true;
   @ObfuscatedName("u")
   int[] field1281;
   @ObfuscatedName("j")
   static int[] field1282 = new int[6];
   @ObfuscatedName("r")
   static int[] field1283 = new int[6];
   @ObfuscatedName("y")
   static int[] field1284 = new int[6];
   @ObfuscatedName("h")
   static final int[][] field1285 = new int[][]{{1, 3, 5, 7}, {1, 3, 5, 7}, {1, 3, 5, 7}, {1, 3, 5, 7, 6}, {1, 3, 5, 7, 6}, {1, 3, 5, 7, 6}, {1, 3, 5, 7, 6}, {1, 3, 5, 7, 2, 6}, {1, 3, 5, 7, 2, 8}, {1, 3, 5, 7, 2, 8}, {1, 3, 5, 7, 11, 12}, {1, 3, 5, 7, 11, 12}, {1, 3, 5, 7, 13, 14}};
   @ObfuscatedName("s")
   static final int[][] field1286 = new int[][]{{0, 1, 2, 3, 0, 0, 1, 3}, {1, 1, 2, 3, 1, 0, 1, 3}, {0, 1, 2, 3, 1, 0, 1, 3}, {0, 0, 1, 2, 0, 0, 2, 4, 1, 0, 4, 3}, {0, 0, 1, 4, 0, 0, 4, 3, 1, 1, 2, 4}, {0, 0, 4, 3, 1, 0, 1, 2, 1, 0, 2, 4}, {0, 1, 2, 4, 1, 0, 1, 4, 1, 0, 4, 3}, {0, 4, 1, 2, 0, 4, 2, 5, 1, 0, 4, 5, 1, 0, 5, 3}, {0, 4, 1, 2, 0, 4, 2, 3, 0, 4, 3, 5, 1, 0, 4, 5}, {0, 0, 4, 5, 1, 4, 1, 2, 1, 4, 2, 3, 1, 4, 3, 5}, {0, 0, 1, 5, 0, 1, 4, 5, 0, 1, 2, 4, 1, 0, 5, 3, 1, 5, 4, 3, 1, 4, 2, 3}, {1, 0, 1, 5, 1, 1, 4, 5, 1, 1, 2, 4, 0, 0, 5, 3, 0, 5, 4, 3, 0, 4, 2, 3}, {1, 0, 5, 4, 1, 0, 1, 5, 0, 0, 4, 3, 0, 4, 5, 3, 0, 5, 2, 3, 0, 1, 2, 5}};

   class77(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, int var13, int var14, int var15, int var16, int var17, int var18, int var19) {
      if(var6 != var7 || var6 != var8 || var6 != var9) {
         this.field1280 = false;
      }

      this.field1265 = var1;
      this.field1273 = var2;
      this.field1278 = var18;
      this.field1279 = var19;
      short var20 = 128;
      int var21 = var20 / 2;
      int var22 = var20 / 4;
      int var23 = var20 * 3 / 4;
      int[] var24 = field1285[var1];
      int var25 = var24.length;
      this.field1281 = new int[var25];
      this.field1266 = new int[var25];
      this.field1267 = new int[var25];
      int[] var26 = new int[var25];
      int[] var27 = new int[var25];
      int var28 = var4 * var20;
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
            var33 = var6 + var7 >> 1;
            var34 = var10 + var11 >> 1;
            var35 = var14 + var15 >> 1;
         } else if(var30 == 3) {
            var31 = var28 + var20;
            var32 = var29;
            var33 = var7;
            var34 = var11;
            var35 = var15;
         } else if(var30 == 4) {
            var31 = var28 + var20;
            var32 = var29 + var21;
            var33 = var7 + var8 >> 1;
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
            var34 = var12 + var13 >> 1;
            var35 = var16 + var17 >> 1;
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
            var33 = var6 + var7 >> 1;
            var34 = var10 + var11 >> 1;
            var35 = var14 + var15 >> 1;
         } else if(var30 == 10) {
            var31 = var28 + var23;
            var32 = var29 + var21;
            var33 = var7 + var8 >> 1;
            var34 = var11 + var12 >> 1;
            var35 = var15 + var16 >> 1;
         } else if(var30 == 11) {
            var31 = var28 + var21;
            var32 = var29 + var23;
            var33 = var8 + var9 >> 1;
            var34 = var12 + var13 >> 1;
            var35 = var16 + var17 >> 1;
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

         this.field1281[var36] = var31;
         this.field1266[var36] = var33;
         this.field1267[var36] = var32;
         var26[var36] = var34;
         var27[var36] = var35;
      }

      int[] var38 = field1286[var1];
      var30 = var38.length / 4;
      this.field1271 = new int[var30];
      this.field1276 = new int[var30];
      this.field1275 = new int[var30];
      this.field1268 = new int[var30];
      this.field1269 = new int[var30];
      this.field1270 = new int[var30];
      if(var3 != -1) {
         this.field1274 = new int[var30];
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

         this.field1271[var32] = var34;
         this.field1276[var32] = var35;
         this.field1275[var32] = var37;
         if(var33 == 0) {
            this.field1268[var32] = var26[var34];
            this.field1269[var32] = var26[var35];
            this.field1270[var32] = var26[var37];
            if(this.field1274 != null) {
               this.field1274[var32] = -1;
            }
         } else {
            this.field1268[var32] = var27[var34];
            this.field1269[var32] = var27[var35];
            this.field1270[var32] = var27[var37];
            if(this.field1274 != null) {
               this.field1274[var32] = var3;
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
}
