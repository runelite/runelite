import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bz")
public class class60 {
   @ObfuscatedName("x")
   int field1228 = class70.method1536(24);
   @ObfuscatedName("t")
   int field1229 = class70.method1536(24);
   @ObfuscatedName("m")
   int[] field1230;
   @ObfuscatedName("p")
   int field1231 = class70.method1536(24) + 1;
   @ObfuscatedName("e")
   int field1232 = class70.method1536(6) + 1;
   @ObfuscatedName("y")
   int field1233 = class70.method1536(8);
   @ObfuscatedName("w")
   int field1234 = class70.method1536(16);

   @ObfuscatedName("w")
   void method1282(float[] var1, int var2, boolean var3) {
      int var4;
      for(var4 = 0; var4 < var2; ++var4) {
         var1[var4] = 0.0F;
      }

      if(!var3) {
         var4 = class70.field1304[this.field1233].field1366;
         int var5 = this.field1229 - this.field1228;
         int var6 = var5 / this.field1231;
         int[] var7 = new int[var6];

         for(int var8 = 0; var8 < 8; ++var8) {
            int var9 = 0;

            while(var9 < var6) {
               int var10;
               int var11;
               if(var8 == 0) {
                  var10 = class70.field1304[this.field1233].method1578();

                  for(var11 = var4 - 1; var11 >= 0; --var11) {
                     if(var9 + var11 < var6) {
                        var7[var9 + var11] = var10 % this.field1232;
                     }

                     var10 /= this.field1232;
                  }
               }

               for(var10 = 0; var10 < var4; ++var10) {
                  var11 = var7[var9];
                  int var12 = this.field1230[var11 * 8 + var8];
                  if(var12 >= 0) {
                     int var13 = this.field1228 + var9 * this.field1231;
                     class73 var14 = class70.field1304[var12];
                     int var15;
                     if(this.field1234 == 0) {
                        var15 = this.field1231 / var14.field1366;

                        for(int var19 = 0; var19 < var15; ++var19) {
                           float[] var20 = var14.method1581();

                           for(int var18 = 0; var18 < var14.field1366; ++var18) {
                              var1[var13 + var19 + var18 * var15] += var20[var18];
                           }
                        }
                     } else {
                        var15 = 0;

                        while(var15 < this.field1231) {
                           float[] var16 = var14.method1581();

                           for(int var17 = 0; var17 < var14.field1366; ++var17) {
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
      int[] var1 = new int[this.field1232];

      int var2;
      for(var2 = 0; var2 < this.field1232; ++var2) {
         int var3 = 0;
         int var4 = class70.method1536(3);
         boolean var5 = class70.method1530() != 0;
         if(var5) {
            var3 = class70.method1536(5);
         }

         var1[var2] = var3 << 3 | var4;
      }

      this.field1230 = new int[this.field1232 * 8];

      for(var2 = 0; var2 < this.field1232 * 8; ++var2) {
         this.field1230[var2] = (var1[var2 >> 3] & 1 << (var2 & 7)) != 0?class70.method1536(8):-1;
      }

   }
}
