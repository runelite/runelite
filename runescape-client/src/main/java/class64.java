import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bo")
public class class64 {
   @ObfuscatedName("u")
   int field1091 = class54.method962(16);
   @ObfuscatedName("a")
   int field1092 = class54.method962(24) + 1;
   @ObfuscatedName("i")
   int field1093 = class54.method962(24);
   @ObfuscatedName("f")
   int field1094 = class54.method962(6) + 1;
   @ObfuscatedName("x")
   int field1095 = class54.method962(24);
   @ObfuscatedName("c")
   int field1096 = class54.method962(8);
   @ObfuscatedName("d")
   int[] field1097;

   class64() {
      int[] var1 = new int[this.field1094];

      int var2;
      for(var2 = 0; var2 < this.field1094; ++var2) {
         int var3 = 0;
         int var4 = class54.method962(3);
         boolean var5 = class54.method961() != 0;
         if(var5) {
            var3 = class54.method962(5);
         }

         var1[var2] = var3 << 3 | var4;
      }

      this.field1097 = new int[this.field1094 * 8];

      for(var2 = 0; var2 < this.field1094 * 8; ++var2) {
         this.field1097[var2] = (var1[var2 >> 3] & 1 << (var2 & 7)) != 0?class54.method962(8):-1;
      }

   }

   @ObfuscatedName("u")
   void method1111(float[] var1, int var2, boolean var3) {
      int var4;
      for(var4 = 0; var4 < var2; ++var4) {
         var1[var4] = 0.0F;
      }

      if(!var3) {
         var4 = class54.field991[this.field1096].field971;
         int var5 = this.field1093 - this.field1095;
         int var6 = var5 / this.field1092;
         int[] var7 = new int[var6];

         for(int var8 = 0; var8 < 8; ++var8) {
            int var9 = 0;

            while(var9 < var6) {
               int var10;
               int var11;
               if(var8 == 0) {
                  var10 = class54.field991[this.field1096].method935();

                  for(var11 = var4 - 1; var11 >= 0; --var11) {
                     if(var9 + var11 < var6) {
                        var7[var9 + var11] = var10 % this.field1094;
                     }

                     var10 /= this.field1094;
                  }
               }

               for(var10 = 0; var10 < var4; ++var10) {
                  var11 = var7[var9];
                  int var12 = this.field1097[var11 * 8 + var8];
                  if(var12 >= 0) {
                     int var13 = this.field1095 + var9 * this.field1092;
                     class52 var14 = class54.field991[var12];
                     int var15;
                     if(this.field1091 == 0) {
                        var15 = this.field1092 / var14.field971;

                        for(int var19 = 0; var19 < var15; ++var19) {
                           float[] var20 = var14.method934();

                           for(int var18 = 0; var18 < var14.field971; ++var18) {
                              var1[var13 + var19 + var18 * var15] += var20[var18];
                           }
                        }
                     } else {
                        var15 = 0;

                        while(var15 < this.field1092) {
                           float[] var16 = var14.method934();

                           for(int var17 = 0; var17 < var14.field971; ++var17) {
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
}
