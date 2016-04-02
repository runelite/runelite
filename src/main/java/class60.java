import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bn")
public class class60 {
   @ObfuscatedName("p")
   int field1194 = class70.method1555(6) + 1;
   @ObfuscatedName("w")
   int field1195 = class70.method1555(24);
   @ObfuscatedName("e")
   int field1196 = class70.method1555(16);
   @ObfuscatedName("s")
   int field1197 = class70.method1555(24) + 1;
   @ObfuscatedName("h")
   int field1198 = class70.method1555(8);
   @ObfuscatedName("g")
   int[] field1199;
   @ObfuscatedName("f")
   int field1200 = class70.method1555(24);

   @ObfuscatedName("e")
   void method1267(float[] var1, int var2, boolean var3) {
      int var4;
      for(var4 = 0; var4 < var2; ++var4) {
         var1[var4] = 0.0F;
      }

      if(!var3) {
         var4 = class70.field1279[this.field1198].field1329;
         int var5 = this.field1200 - this.field1195;
         int var6 = var5 / this.field1197;
         int[] var7 = new int[var6];

         for(int var8 = 0; var8 < 8; ++var8) {
            int var9 = 0;

            while(var9 < var6) {
               int var10;
               int var11;
               if(var8 == 0) {
                  var10 = class70.field1279[this.field1198].method1583();

                  for(var11 = var4 - 1; var11 >= 0; --var11) {
                     if(var9 + var11 < var6) {
                        var7[var9 + var11] = var10 % this.field1194;
                     }

                     var10 /= this.field1194;
                  }
               }

               for(var10 = 0; var10 < var4; ++var10) {
                  var11 = var7[var9];
                  int var12 = this.field1199[var11 * 8 + var8];
                  if(var12 >= 0) {
                     int var13 = this.field1195 + var9 * this.field1197;
                     class73 var14 = class70.field1279[var12];
                     int var15;
                     if(this.field1196 == 0) {
                        var15 = this.field1197 / var14.field1329;

                        for(int var19 = 0; var19 < var15; ++var19) {
                           float[] var20 = var14.method1589();

                           for(int var18 = 0; var18 < var14.field1329; ++var18) {
                              var1[var13 + var19 + var18 * var15] += var20[var18];
                           }
                        }
                     } else {
                        var15 = 0;

                        while(var15 < this.field1197) {
                           float[] var16 = var14.method1589();

                           for(int var17 = 0; var17 < var14.field1329; ++var17) {
                              var1[var13 + var15] += var16[var17];
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

   class60() {
      int[] var1 = new int[this.field1194];

      int var2;
      for(var2 = 0; var2 < this.field1194; ++var2) {
         int var3 = 0;
         int var4 = class70.method1555(3);
         boolean var5 = class70.method1559() != 0;
         if(var5) {
            var3 = class70.method1555(5);
         }

         var1[var2] = var3 << 3 | var4;
      }

      this.field1199 = new int[this.field1194 * 8];

      for(var2 = 0; var2 < this.field1194 * 8; ++var2) {
         this.field1199[var2] = (var1[var2 >> 3] & 1 << (var2 & 7)) != 0?class70.method1555(8):-1;
      }

   }
}
