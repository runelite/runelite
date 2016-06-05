import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ba")
public class class60 {
   @ObfuscatedName("r")
   int field1226 = class70.method1487(8);
   @ObfuscatedName("i")
   int field1227 = class70.method1487(24);
   @ObfuscatedName("g")
   int field1228 = class70.method1487(24);
   @ObfuscatedName("h")
   int field1229 = class70.method1487(24) + 1;
   @ObfuscatedName("z")
   int field1230 = class70.method1487(6) + 1;
   @ObfuscatedName("f")
   int[] field1231;
   @ObfuscatedName("t")
   int field1232 = class70.method1487(16);

   class60() {
      int[] var1 = new int[this.field1230];

      int var2;
      for(var2 = 0; var2 < this.field1230; ++var2) {
         int var3 = 0;
         int var4 = class70.method1487(3);
         boolean var5 = class70.method1505() != 0;
         if(var5) {
            var3 = class70.method1487(5);
         }

         var1[var2] = var3 << 3 | var4;
      }

      this.field1231 = new int[this.field1230 * 8];

      for(var2 = 0; var2 < this.field1230 * 8; ++var2) {
         this.field1231[var2] = (var1[var2 >> 3] & 1 << (var2 & 7)) != 0?class70.method1487(8):-1;
      }

   }

   @ObfuscatedName("t")
   void method1229(float[] var1, int var2, boolean var3) {
      int var4;
      for(var4 = 0; var4 < var2; ++var4) {
         var1[var4] = 0.0F;
      }

      if(!var3) {
         var4 = class70.field1302[this.field1226].field1363;
         int var5 = this.field1228 - this.field1227;
         int var6 = var5 / this.field1229;
         int[] var7 = new int[var6];

         for(int var8 = 0; var8 < 8; ++var8) {
            int var9 = 0;

            while(var9 < var6) {
               int var10;
               int var11;
               if(var8 == 0) {
                  var10 = class70.field1302[this.field1226].method1533();

                  for(var11 = var4 - 1; var11 >= 0; --var11) {
                     if(var9 + var11 < var6) {
                        var7[var9 + var11] = var10 % this.field1230;
                     }

                     var10 /= this.field1230;
                  }
               }

               for(var10 = 0; var10 < var4; ++var10) {
                  var11 = var7[var9];
                  int var12 = this.field1231[var11 * 8 + var8];
                  if(var12 >= 0) {
                     int var13 = this.field1227 + var9 * this.field1229;
                     class73 var14 = class70.field1302[var12];
                     int var15;
                     if(this.field1232 == 0) {
                        var15 = this.field1229 / var14.field1363;

                        for(int var19 = 0; var19 < var15; ++var19) {
                           float[] var17 = var14.method1531();

                           for(int var18 = 0; var18 < var14.field1363; ++var18) {
                              var1[var13 + var19 + var18 * var15] += var17[var18];
                           }
                        }
                     } else {
                        var15 = 0;

                        while(var15 < this.field1229) {
                           float[] var16 = var14.method1531();

                           for(int var20 = 0; var20 < var14.field1363; ++var20) {
                              var1[var13 + var15] += var16[var20];
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
