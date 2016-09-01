import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("be")
public class class63 {
   @ObfuscatedName("z")
   int field1266 = class73.method1560(24) + 1;
   @ObfuscatedName("r")
   int field1267 = class73.method1560(24);
   @ObfuscatedName("j")
   int field1268 = class73.method1560(24);
   @ObfuscatedName("x")
   int field1269 = class73.method1560(16);
   @ObfuscatedName("i")
   int field1270 = class73.method1560(6) + 1;
   @ObfuscatedName("b")
   int field1271 = class73.method1560(8);
   @ObfuscatedName("l")
   int[] field1272;

   @ObfuscatedName("x")
   void method1314(float[] var1, int var2, boolean var3) {
      int var4;
      for(var4 = 0; var4 < var2; ++var4) {
         var1[var4] = 0.0F;
      }

      if(!var3) {
         var4 = class73.field1335[this.field1271].field1397;
         int var5 = this.field1268 - this.field1267;
         int var6 = var5 / this.field1266;
         int[] var7 = new int[var6];

         for(int var8 = 0; var8 < 8; ++var8) {
            int var9 = 0;

            while(var9 < var6) {
               int var10;
               int var11;
               if(var8 == 0) {
                  var10 = class73.field1335[this.field1271].method1609();

                  for(var11 = var4 - 1; var11 >= 0; --var11) {
                     if(var9 + var11 < var6) {
                        var7[var9 + var11] = var10 % this.field1270;
                     }

                     var10 /= this.field1270;
                  }
               }

               for(var10 = 0; var10 < var4; ++var10) {
                  var11 = var7[var9];
                  int var12 = this.field1272[var11 * 8 + var8];
                  if(var12 >= 0) {
                     int var13 = this.field1267 + var9 * this.field1266;
                     class76 var14 = class73.field1335[var12];
                     int var15;
                     if(this.field1269 == 0) {
                        var15 = this.field1266 / var14.field1397;

                        for(int var16 = 0; var16 < var15; ++var16) {
                           float[] var20 = var14.method1611();

                           for(int var18 = 0; var18 < var14.field1397; ++var18) {
                              var1[var13 + var16 + var18 * var15] += var20[var18];
                           }
                        }
                     } else {
                        var15 = 0;

                        while(var15 < this.field1266) {
                           float[] var19 = var14.method1611();

                           for(int var17 = 0; var17 < var14.field1397; ++var17) {
                              var1[var13 + var15] += var19[var17];
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
      int[] var1 = new int[this.field1270];

      int var2;
      for(var2 = 0; var2 < this.field1270; ++var2) {
         int var3 = 0;
         int var4 = class73.method1560(3);
         boolean var5 = class73.method1558() != 0;
         if(var5) {
            var3 = class73.method1560(5);
         }

         var1[var2] = var3 << 3 | var4;
      }

      this.field1272 = new int[this.field1270 * 8];

      for(var2 = 0; var2 < this.field1270 * 8; ++var2) {
         this.field1272[var2] = (var1[var2 >> 3] & 1 << (var2 & 7)) != 0?class73.method1560(8):-1;
      }

   }
}
