import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bj")
public class class64 {
   @ObfuscatedName("h")
   int field1088 = class54.method992(24) + 1;
   @ObfuscatedName("n")
   int field1089 = class54.method992(16);
   @ObfuscatedName("m")
   int field1090 = class54.method992(24);
   @ObfuscatedName("c")
   int[] field1091;
   @ObfuscatedName("d")
   int field1092 = class54.method992(24);
   @ObfuscatedName("r")
   int field1093 = class54.method992(8);
   @ObfuscatedName("w")
   int field1094 = class54.method992(6) + 1;

   @ObfuscatedName("n")
   void method1152(float[] var1, int var2, boolean var3) {
      int var4;
      for(var4 = 0; var4 < var2; ++var4) {
         var1[var4] = 0.0F;
      }

      if(!var3) {
         var4 = class54.field1010[this.field1093].field973;
         int var5 = this.field1090 - this.field1092;
         int var6 = var5 / this.field1088;
         int[] var7 = new int[var6];

         for(int var8 = 0; var8 < 8; ++var8) {
            int var9 = 0;

            while(var9 < var6) {
               int var10;
               int var11;
               if(var8 == 0) {
                  var10 = class54.field1010[this.field1093].method954();

                  for(var11 = var4 - 1; var11 >= 0; --var11) {
                     if(var9 + var11 < var6) {
                        var7[var9 + var11] = var10 % this.field1094;
                     }

                     var10 /= this.field1094;
                  }
               }

               for(var10 = 0; var10 < var4; ++var10) {
                  var11 = var7[var9];
                  int var12 = this.field1091[var11 * 8 + var8];
                  if(var12 >= 0) {
                     int var13 = this.field1092 + var9 * this.field1088;
                     class52 var14 = class54.field1010[var12];
                     int var15;
                     if(this.field1089 == 0) {
                        var15 = this.field1088 / var14.field973;

                        for(int var16 = 0; var16 < var15; ++var16) {
                           float[] var19 = var14.method953();

                           for(int var18 = 0; var18 < var14.field973; ++var18) {
                              var1[var13 + var16 + var18 * var15] += var19[var18];
                           }
                        }
                     } else {
                        var15 = 0;

                        while(var15 < this.field1088) {
                           float[] var20 = var14.method953();

                           for(int var17 = 0; var17 < var14.field973; ++var17) {
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

   class64() {
      int[] var1 = new int[this.field1094];

      int var2;
      for(var2 = 0; var2 < this.field1094; ++var2) {
         int var3 = 0;
         int var4 = class54.method992(3);
         boolean var5 = class54.method985() != 0;
         if(var5) {
            var3 = class54.method992(5);
         }

         var1[var2] = var3 << 3 | var4;
      }

      this.field1091 = new int[this.field1094 * 8];

      for(var2 = 0; var2 < this.field1094 * 8; ++var2) {
         this.field1091[var2] = (var1[var2 >> 3] & 1 << (var2 & 7)) != 0?class54.method992(8):-1;
      }

   }
}
