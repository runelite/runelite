import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bl")
public class class64 {
   @ObfuscatedName("h")
   int field1096 = class54.method959(6) + 1;
   @ObfuscatedName("m")
   int field1097 = class54.method959(24);
   @ObfuscatedName("b")
   int field1098 = class54.method959(24);
   @ObfuscatedName("g")
   int field1099 = class54.method959(24) + 1;
   @ObfuscatedName("l")
   int[] field1100;
   @ObfuscatedName("v")
   int field1101 = class54.method959(8);
   @ObfuscatedName("o")
   int field1102 = class54.method959(16);

   class64() {
      int[] var1 = new int[this.field1096];

      int var2;
      for(var2 = 0; var2 < this.field1096; ++var2) {
         int var3 = 0;
         int var4 = class54.method959(3);
         boolean var5 = class54.method958() != 0;
         if(var5) {
            var3 = class54.method959(5);
         }

         var1[var2] = var3 << 3 | var4;
      }

      this.field1100 = new int[this.field1096 * 8];

      for(var2 = 0; var2 < this.field1096 * 8; ++var2) {
         this.field1100[var2] = (var1[var2 >> 3] & 1 << (var2 & 7)) != 0?class54.method959(8):-1;
      }

   }

   @ObfuscatedName("o")
   void method1147(float[] var1, int var2, boolean var3) {
      int var4;
      for(var4 = 0; var4 < var2; ++var4) {
         var1[var4] = 0.0F;
      }

      if(!var3) {
         var4 = class54.field1009[this.field1101].field982;
         int var5 = this.field1098 - this.field1097;
         int var6 = var5 / this.field1099;
         int[] var7 = new int[var6];

         for(int var8 = 0; var8 < 8; ++var8) {
            int var9 = 0;

            while(var9 < var6) {
               int var10;
               int var11;
               if(var8 == 0) {
                  var10 = class54.field1009[this.field1101].method930();

                  for(var11 = var4 - 1; var11 >= 0; --var11) {
                     if(var9 + var11 < var6) {
                        var7[var9 + var11] = var10 % this.field1096;
                     }

                     var10 /= this.field1096;
                  }
               }

               for(var10 = 0; var10 < var4; ++var10) {
                  var11 = var7[var9];
                  int var12 = this.field1100[var11 * 8 + var8];
                  if(var12 >= 0) {
                     int var13 = this.field1097 + var9 * this.field1099;
                     class52 var14 = class54.field1009[var12];
                     int var15;
                     if(this.field1102 == 0) {
                        var15 = this.field1099 / var14.field982;

                        for(int var16 = 0; var16 < var15; ++var16) {
                           float[] var19 = var14.method933();

                           for(int var18 = 0; var18 < var14.field982; ++var18) {
                              var1[var13 + var16 + var18 * var15] += var19[var18];
                           }
                        }
                     } else {
                        var15 = 0;

                        while(var15 < this.field1099) {
                           float[] var20 = var14.method933();

                           for(int var17 = 0; var17 < var14.field982; ++var17) {
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
}
