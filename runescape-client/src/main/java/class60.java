import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bk")
public class class60 {
   @ObfuscatedName("f")
   int field1238 = class70.method1596(16);
   @ObfuscatedName("d")
   int field1239 = class70.method1596(8);
   @ObfuscatedName("x")
   int field1240 = class70.method1596(24);
   @ObfuscatedName("b")
   int field1241 = class70.method1596(24) + 1;
   @ObfuscatedName("l")
   int field1242 = class70.method1596(6) + 1;
   @ObfuscatedName("u")
   int field1243 = class70.method1596(24);
   @ObfuscatedName("n")
   int[] field1244;

   @ObfuscatedName("f")
   void method1332(float[] var1, int var2, boolean var3) {
      int var4;
      for(var4 = 0; var4 < var2; ++var4) {
         var1[var4] = 0.0F;
      }

      if(!var3) {
         var4 = class70.field1331[this.field1239].field1372;
         int var5 = this.field1240 - this.field1243;
         int var6 = var5 / this.field1241;
         int[] var7 = new int[var6];

         for(int var8 = 0; var8 < 8; ++var8) {
            int var9 = 0;

            while(var9 < var6) {
               int var10;
               int var11;
               if(var8 == 0) {
                  var10 = class70.field1331[this.field1239].method1637();

                  for(var11 = var4 - 1; var11 >= 0; --var11) {
                     if(var9 + var11 < var6) {
                        var7[var9 + var11] = var10 % this.field1242;
                     }

                     var10 /= this.field1242;
                  }
               }

               for(var10 = 0; var10 < var4; ++var10) {
                  var11 = var7[var9];
                  int var12 = this.field1244[var11 * 8 + var8];
                  if(var12 >= 0) {
                     int var13 = this.field1243 + var9 * this.field1241;
                     class73 var14 = class70.field1331[var12];
                     int var15;
                     if(this.field1238 == 0) {
                        var15 = this.field1241 / var14.field1372;

                        for(int var16 = 0; var16 < var15; ++var16) {
                           float[] var19 = var14.method1642();

                           for(int var18 = 0; var18 < var14.field1372; ++var18) {
                              var1[var13 + var16 + var18 * var15] += var19[var18];
                           }
                        }
                     } else {
                        var15 = 0;

                        while(var15 < this.field1241) {
                           float[] var20 = var14.method1642();

                           for(int var17 = 0; var17 < var14.field1372; ++var17) {
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

   class60() {
      int[] var1 = new int[this.field1242];

      int var2;
      for(var2 = 0; var2 < this.field1242; ++var2) {
         int var3 = 0;
         int var4 = class70.method1596(3);
         boolean var5 = class70.method1588() != 0;
         if(var5) {
            var3 = class70.method1596(5);
         }

         var1[var2] = var3 << 3 | var4;
      }

      this.field1244 = new int[this.field1242 * 8];

      for(var2 = 0; var2 < this.field1242 * 8; ++var2) {
         this.field1244[var2] = (var1[var2 >> 3] & 1 << (var2 & 7)) != 0?class70.method1596(8):-1;
      }

   }
}
