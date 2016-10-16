import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bb")
public class class63 {
   @ObfuscatedName("z")
   int field1264 = class73.method1540(24);
   @ObfuscatedName("m")
   int[] field1265;
   @ObfuscatedName("s")
   int field1266 = class73.method1540(16);
   @ObfuscatedName("t")
   int field1267 = class73.method1540(24);
   @ObfuscatedName("p")
   int field1268 = class73.method1540(6) + 1;
   @ObfuscatedName("g")
   int field1269 = class73.method1540(8);
   @ObfuscatedName("y")
   int field1270 = class73.method1540(24) + 1;

   class63() {
      int[] var1 = new int[this.field1268];

      int var2;
      for(var2 = 0; var2 < this.field1268; ++var2) {
         int var3 = 0;
         int var4 = class73.method1540(3);
         boolean var5 = class73.method1539() != 0;
         if(var5) {
            var3 = class73.method1540(5);
         }

         var1[var2] = var3 << 3 | var4;
      }

      this.field1265 = new int[this.field1268 * 8];

      for(var2 = 0; var2 < this.field1268 * 8; ++var2) {
         this.field1265[var2] = (var1[var2 >> 3] & 1 << (var2 & 7)) != 0?class73.method1540(8):-1;
      }

   }

   @ObfuscatedName("s")
   void method1280(float[] var1, int var2, boolean var3) {
      int var4;
      for(var4 = 0; var4 < var2; ++var4) {
         var1[var4] = 0.0F;
      }

      if(!var3) {
         var4 = class73.field1340[this.field1269].field1402;
         int var5 = this.field1267 - this.field1264;
         int var6 = var5 / this.field1270;
         int[] var7 = new int[var6];

         for(int var8 = 0; var8 < 8; ++var8) {
            int var9 = 0;

            while(var9 < var6) {
               int var10;
               int var11;
               if(var8 == 0) {
                  var10 = class73.field1340[this.field1269].method1594();

                  for(var11 = var4 - 1; var11 >= 0; --var11) {
                     if(var9 + var11 < var6) {
                        var7[var9 + var11] = var10 % this.field1268;
                     }

                     var10 /= this.field1268;
                  }
               }

               for(var10 = 0; var10 < var4; ++var10) {
                  var11 = var7[var9];
                  int var12 = this.field1265[var11 * 8 + var8];
                  if(var12 >= 0) {
                     int var13 = this.field1264 + var9 * this.field1270;
                     class76 var14 = class73.field1340[var12];
                     int var15;
                     if(this.field1266 == 0) {
                        var15 = this.field1270 / var14.field1402;

                        for(int var19 = 0; var19 < var15; ++var19) {
                           float[] var20 = var14.method1589();

                           for(int var18 = 0; var18 < var14.field1402; ++var18) {
                              var1[var13 + var19 + var18 * var15] += var20[var18];
                           }
                        }
                     } else {
                        var15 = 0;

                        while(var15 < this.field1270) {
                           float[] var16 = var14.method1589();

                           for(int var17 = 0; var17 < var14.field1402; ++var17) {
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
