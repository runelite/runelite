import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bo")
public class class60 {
   @ObfuscatedName("f")
   int field1222 = class70.method1568(24);
   @ObfuscatedName("a")
   int field1223 = class70.method1568(16);
   @ObfuscatedName("s")
   int field1224 = class70.method1568(24) + 1;
   @ObfuscatedName("y")
   int field1225 = class70.method1568(6) + 1;
   @ObfuscatedName("r")
   int field1226 = class70.method1568(24);
   @ObfuscatedName("e")
   int field1227 = class70.method1568(8);
   @ObfuscatedName("g")
   int[] field1228;

   class60() {
      int[] var1 = new int[this.field1225];

      int var2;
      for(var2 = 0; var2 < this.field1225; ++var2) {
         int var3 = 0;
         int var4 = class70.method1568(3);
         boolean var5 = class70.method1567() != 0;
         if(var5) {
            var3 = class70.method1568(5);
         }

         var1[var2] = var3 << 3 | var4;
      }

      this.field1228 = new int[this.field1225 * 8];

      for(var2 = 0; var2 < this.field1225 * 8; ++var2) {
         this.field1228[var2] = (var1[var2 >> 3] & 1 << (var2 & 7)) != 0?class70.method1568(8):-1;
      }

   }

   @ObfuscatedName("a")
   void method1293(float[] var1, int var2, boolean var3) {
      int var4;
      for(var4 = 0; var4 < var2; ++var4) {
         var1[var4] = 0.0F;
      }

      if(!var3) {
         var4 = class70.field1298[this.field1227].field1358;
         int var5 = this.field1222 - this.field1226;
         int var6 = var5 / this.field1224;
         int[] var7 = new int[var6];

         for(int var8 = 0; var8 < 8; ++var8) {
            int var9 = 0;

            while(var9 < var6) {
               int var10;
               int var11;
               if(var8 == 0) {
                  var10 = class70.field1298[this.field1227].method1625();

                  for(var11 = var4 - 1; var11 >= 0; --var11) {
                     if(var9 + var11 < var6) {
                        var7[var9 + var11] = var10 % this.field1225;
                     }

                     var10 /= this.field1225;
                  }
               }

               for(var10 = 0; var10 < var4; ++var10) {
                  var11 = var7[var9];
                  int var12 = this.field1228[var11 * 8 + var8];
                  if(var12 >= 0) {
                     int var13 = this.field1226 + var9 * this.field1224;
                     class73 var14 = class70.field1298[var12];
                     int var15;
                     if(this.field1223 == 0) {
                        var15 = this.field1224 / var14.field1358;

                        for(int var19 = 0; var19 < var15; ++var19) {
                           float[] var20 = var14.method1617();

                           for(int var18 = 0; var18 < var14.field1358; ++var18) {
                              var1[var13 + var19 + var18 * var15] += var20[var18];
                           }
                        }
                     } else {
                        var15 = 0;

                        while(var15 < this.field1224) {
                           float[] var16 = var14.method1617();

                           for(int var17 = 0; var17 < var14.field1358; ++var17) {
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
