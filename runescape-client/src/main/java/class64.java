import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bw")
public class class64 {
   @ObfuscatedName("h")
   int field1123 = class54.method1021(24) + 1;
   @ObfuscatedName("i")
   int field1124 = class54.method1021(24);
   @ObfuscatedName("u")
   int field1125 = class54.method1021(24);
   @ObfuscatedName("l")
   int[] field1126;
   @ObfuscatedName("f")
   int field1127 = class54.method1021(16);
   @ObfuscatedName("o")
   int field1128 = class54.method1021(8);
   @ObfuscatedName("r")
   int field1129 = class54.method1021(6) + 1;

   @ObfuscatedName("f")
   void method1190(float[] var1, int var2, boolean var3) {
      int var4;
      for(var4 = 0; var4 < var2; ++var4) {
         var1[var4] = 0.0F;
      }

      if(!var3) {
         var4 = class54.field1021[this.field1128].field1003;
         int var5 = this.field1125 - this.field1124;
         int var6 = var5 / this.field1123;
         int[] var7 = new int[var6];

         for(int var8 = 0; var8 < 8; ++var8) {
            int var9 = 0;

            while(var9 < var6) {
               int var10;
               int var11;
               if(var8 == 0) {
                  var10 = class54.field1021[this.field1128].method988();

                  for(var11 = var4 - 1; var11 >= 0; --var11) {
                     if(var9 + var11 < var6) {
                        var7[var9 + var11] = var10 % this.field1129;
                     }

                     var10 /= this.field1129;
                  }
               }

               for(var10 = 0; var10 < var4; ++var10) {
                  var11 = var7[var9];
                  int var12 = this.field1126[var11 * 8 + var8];
                  if(var12 >= 0) {
                     int var13 = this.field1124 + var9 * this.field1123;
                     class52 var14 = class54.field1021[var12];
                     int var15;
                     if(this.field1127 == 0) {
                        var15 = this.field1123 / var14.field1003;

                        for(int var19 = 0; var19 < var15; ++var19) {
                           float[] var20 = var14.method997();

                           for(int var18 = 0; var18 < var14.field1003; ++var18) {
                              var1[var13 + var19 + var18 * var15] += var20[var18];
                           }
                        }
                     } else {
                        var15 = 0;

                        while(var15 < this.field1123) {
                           float[] var16 = var14.method997();

                           for(int var17 = 0; var17 < var14.field1003; ++var17) {
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
      int[] var1 = new int[this.field1129];

      int var2;
      for(var2 = 0; var2 < this.field1129; ++var2) {
         int var3 = 0;
         int var4 = class54.method1021(3);
         boolean var5 = class54.method1020() != 0;
         if(var5) {
            var3 = class54.method1021(5);
         }

         var1[var2] = var3 << 3 | var4;
      }

      this.field1126 = new int[this.field1129 * 8];

      for(var2 = 0; var2 < this.field1129 * 8; ++var2) {
         this.field1126[var2] = (var1[var2 >> 3] & 1 << (var2 & 7)) != 0?class54.method1021(8):-1;
      }

   }
}
