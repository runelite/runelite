import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bx")
public class class64 {
   @ObfuscatedName("n")
   int field1076 = class54.method1004(24);
   @ObfuscatedName("c")
   int field1077 = class54.method1004(24);
   @ObfuscatedName("u")
   int[] field1078;
   @ObfuscatedName("q")
   int field1079 = class54.method1004(24) + 1;
   @ObfuscatedName("t")
   int field1080 = class54.method1004(6) + 1;
   @ObfuscatedName("p")
   int field1081 = class54.method1004(8);
   @ObfuscatedName("d")
   int field1082 = class54.method1004(16);

   @ObfuscatedName("d")
   void method1181(float[] var1, int var2, boolean var3) {
      int var4;
      for(var4 = 0; var4 < var2; ++var4) {
         var1[var4] = 0.0F;
      }

      if(!var3) {
         var4 = class54.field988[this.field1081].field972;
         int var5 = this.field1076 - this.field1077;
         int var6 = var5 / this.field1079;
         int[] var7 = new int[var6];

         for(int var8 = 0; var8 < 8; ++var8) {
            int var9 = 0;

            while(var9 < var6) {
               int var10;
               int var11;
               if(var8 == 0) {
                  var10 = class54.field988[this.field1081].method977();

                  for(var11 = var4 - 1; var11 >= 0; --var11) {
                     if(var9 + var11 < var6) {
                        var7[var9 + var11] = var10 % this.field1080;
                     }

                     var10 /= this.field1080;
                  }
               }

               for(var10 = 0; var10 < var4; ++var10) {
                  var11 = var7[var9];
                  int var12 = this.field1078[var11 * 8 + var8];
                  if(var12 >= 0) {
                     int var13 = this.field1077 + var9 * this.field1079;
                     class52 var14 = class54.field988[var12];
                     int var15;
                     if(this.field1082 == 0) {
                        var15 = this.field1079 / var14.field972;

                        for(int var19 = 0; var19 < var15; ++var19) {
                           float[] var20 = var14.method980();

                           for(int var18 = 0; var18 < var14.field972; ++var18) {
                              var1[var13 + var19 + var18 * var15] += var20[var18];
                           }
                        }
                     } else {
                        var15 = 0;

                        while(var15 < this.field1079) {
                           float[] var16 = var14.method980();

                           for(int var17 = 0; var17 < var14.field972; ++var17) {
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

   class64() {
      int[] var1 = new int[this.field1080];

      int var2;
      for(var2 = 0; var2 < this.field1080; ++var2) {
         int var3 = 0;
         int var4 = class54.method1004(3);
         boolean var5 = class54.method1005() != 0;
         if(var5) {
            var3 = class54.method1004(5);
         }

         var1[var2] = var3 << 3 | var4;
      }

      this.field1078 = new int[this.field1080 * 8];

      for(var2 = 0; var2 < this.field1080 * 8; ++var2) {
         this.field1078[var2] = (var1[var2 >> 3] & 1 << (var2 & 7)) != 0?class54.method1004(8):-1;
      }

   }
}
