import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bl")
public class class64 {
   @ObfuscatedName("h")
   int field1112 = class54.method1051(24);
   @ObfuscatedName("p")
   int field1113 = class54.method1051(24) + 1;
   @ObfuscatedName("r")
   int[] field1114;
   @ObfuscatedName("q")
   int field1115 = class54.method1051(16);
   @ObfuscatedName("j")
   int field1116 = class54.method1051(6) + 1;
   @ObfuscatedName("n")
   int field1117 = class54.method1051(8);
   @ObfuscatedName("d")
   int field1118 = class54.method1051(24);

   class64() {
      int[] var1 = new int[this.field1116];

      int var2;
      for(var2 = 0; var2 < this.field1116; ++var2) {
         int var3 = 0;
         int var4 = class54.method1051(3);
         boolean var5 = class54.method1050() != 0;
         if(var5) {
            var3 = class54.method1051(5);
         }

         var1[var2] = var3 << 3 | var4;
      }

      this.field1114 = new int[this.field1116 * 8];

      for(var2 = 0; var2 < this.field1116 * 8; ++var2) {
         this.field1114[var2] = (var1[var2 >> 3] & 1 << (var2 & 7)) != 0?class54.method1051(8):-1;
      }

   }

   @ObfuscatedName("q")
   void method1217(float[] var1, int var2, boolean var3) {
      int var4;
      for(var4 = 0; var4 < var2; ++var4) {
         var1[var4] = 0.0F;
      }

      if(!var3) {
         var4 = class54.field1020[this.field1117].field1001;
         int var5 = this.field1112 - this.field1118;
         int var6 = var5 / this.field1113;
         int[] var7 = new int[var6];

         for(int var8 = 0; var8 < 8; ++var8) {
            int var9 = 0;

            while(var9 < var6) {
               int var10;
               int var11;
               if(var8 == 0) {
                  var10 = class54.field1020[this.field1117].method1027();

                  for(var11 = var4 - 1; var11 >= 0; --var11) {
                     if(var9 + var11 < var6) {
                        var7[var9 + var11] = var10 % this.field1116;
                     }

                     var10 /= this.field1116;
                  }
               }

               for(var10 = 0; var10 < var4; ++var10) {
                  var11 = var7[var9];
                  int var12 = this.field1114[var11 * 8 + var8];
                  if(var12 >= 0) {
                     int var13 = this.field1118 + var9 * this.field1113;
                     class52 var14 = class54.field1020[var12];
                     int var15;
                     if(this.field1115 == 0) {
                        var15 = this.field1113 / var14.field1001;

                        for(int var16 = 0; var16 < var15; ++var16) {
                           float[] var20 = var14.method1032();

                           for(int var18 = 0; var18 < var14.field1001; ++var18) {
                              var1[var13 + var16 + var18 * var15] += var20[var18];
                           }
                        }
                     } else {
                        var15 = 0;

                        while(var15 < this.field1113) {
                           float[] var19 = var14.method1032();

                           for(int var17 = 0; var17 < var14.field1001; ++var17) {
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
}
