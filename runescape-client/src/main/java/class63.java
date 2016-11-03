import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bw")
public class class63 {
   @ObfuscatedName("q")
   int field1281 = class73.method1588(24);
   @ObfuscatedName("k")
   int field1282 = class73.method1588(16);
   @ObfuscatedName("f")
   int field1283 = class73.method1588(24);
   @ObfuscatedName("c")
   int field1284 = class73.method1588(24) + 1;
   @ObfuscatedName("v")
   int field1285 = class73.method1588(6) + 1;
   @ObfuscatedName("j")
   int field1286 = class73.method1588(8);
   @ObfuscatedName("m")
   int[] field1287;

   @ObfuscatedName("k")
   void method1310(float[] var1, int var2, boolean var3) {
      int var4;
      for(var4 = 0; var4 < var2; ++var4) {
         var1[var4] = 0.0F;
      }

      if(!var3) {
         var4 = class73.field1357[this.field1286].field1414;
         int var5 = this.field1283 - this.field1281;
         int var6 = var5 / this.field1284;
         int[] var7 = new int[var6];

         for(int var8 = 0; var8 < 8; ++var8) {
            int var9 = 0;

            while(var9 < var6) {
               int var10;
               int var11;
               if(var8 == 0) {
                  var10 = class73.field1357[this.field1286].method1636();

                  for(var11 = var4 - 1; var11 >= 0; --var11) {
                     if(var9 + var11 < var6) {
                        var7[var9 + var11] = var10 % this.field1285;
                     }

                     var10 /= this.field1285;
                  }
               }

               for(var10 = 0; var10 < var4; ++var10) {
                  var11 = var7[var9];
                  int var12 = this.field1287[var11 * 8 + var8];
                  if(var12 >= 0) {
                     int var13 = this.field1281 + var9 * this.field1284;
                     class76 var14 = class73.field1357[var12];
                     int var15;
                     if(this.field1282 == 0) {
                        var15 = this.field1284 / var14.field1414;

                        for(int var16 = 0; var16 < var15; ++var16) {
                           float[] var19 = var14.method1642();

                           for(int var18 = 0; var18 < var14.field1414; ++var18) {
                              var1[var13 + var16 + var18 * var15] += var19[var18];
                           }
                        }
                     } else {
                        var15 = 0;

                        while(var15 < this.field1284) {
                           float[] var20 = var14.method1642();

                           for(int var17 = 0; var17 < var14.field1414; ++var17) {
                              var1[var13 + var15] += var20[var17];
                              ++var15;
                           }
                        }
                     }
                  }

                  ++var9;
                  if(var9 >= var6) {
                     break;
                  }
               }
            }
         }

      }
   }

   class63() {
      int[] var1 = new int[this.field1285];

      int var2;
      for(var2 = 0; var2 < this.field1285; ++var2) {
         int var3 = 0;
         int var4 = class73.method1588(3);
         boolean var5 = class73.method1606() != 0;
         if(var5) {
            var3 = class73.method1588(5);
         }

         var1[var2] = var3 << 3 | var4;
      }

      this.field1287 = new int[this.field1285 * 8];

      for(var2 = 0; var2 < this.field1285 * 8; ++var2) {
         this.field1287[var2] = (var1[var2 >> 3] & 1 << (var2 & 7)) != 0?class73.method1588(8):-1;
      }

   }
}
