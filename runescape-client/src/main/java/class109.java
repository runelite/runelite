import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("da")
public class class109 {
   @ObfuscatedName("m")
   int field1409;
   @ObfuscatedName("f")
   int field1406;
   @ObfuscatedName("q")
   int field1407;
   @ObfuscatedName("w")
   int field1408;
   @ObfuscatedName("o")
   int field1405;
   @ObfuscatedName("u")
   int field1411;
   @ObfuscatedName("g")
   int[] field1410;

   class109() {
      this.field1409 = MusicSample.method2352(16);
      this.field1406 = MusicSample.method2352(24);
      this.field1407 = MusicSample.method2352(24);
      this.field1408 = MusicSample.method2352(24) + 1;
      this.field1405 = MusicSample.method2352(6) + 1;
      this.field1411 = MusicSample.method2352(8);
      int[] var1 = new int[this.field1405];

      int var2;
      for(var2 = 0; var2 < this.field1405; ++var2) {
         int var3 = 0;
         int var4 = MusicSample.method2352(3);
         boolean var5 = MusicSample.method2338() != 0;
         if(var5) {
            var3 = MusicSample.method2352(5);
         }

         var1[var2] = var3 << 3 | var4;
      }

      this.field1410 = new int[this.field1405 * 8];

      for(var2 = 0; var2 < this.field1405 * 8; ++var2) {
         this.field1410[var2] = (var1[var2 >> 3] & 1 << (var2 & 7)) != 0?MusicSample.method2352(8):-1;
      }

   }

   @ObfuscatedName("m")
   void method2473(float[] var1, int var2, boolean var3) {
      int var4;
      for(var4 = 0; var4 < var2; ++var4) {
         var1[var4] = 0.0F;
      }

      if(!var3) {
         var4 = MusicSample.field1323[this.field1411].field1306;
         int var5 = this.field1407 - this.field1406;
         int var6 = var5 / this.field1408;
         int[] var7 = new int[var6];

         for(int var8 = 0; var8 < 8; ++var8) {
            int var9 = 0;

            while(var9 < var6) {
               int var10;
               int var11;
               if(var8 == 0) {
                  var10 = MusicSample.field1323[this.field1411].method2306();

                  for(var11 = var4 - 1; var11 >= 0; --var11) {
                     if(var9 + var11 < var6) {
                        var7[var9 + var11] = var10 % this.field1405;
                     }

                     var10 /= this.field1405;
                  }
               }

               for(var10 = 0; var10 < var4; ++var10) {
                  var11 = var7[var9];
                  int var12 = this.field1410[var8 + var11 * 8];
                  if(var12 >= 0) {
                     int var13 = var9 * this.field1408 + this.field1406;
                     class98 var14 = MusicSample.field1323[var12];
                     int var15;
                     if(this.field1409 == 0) {
                        var15 = this.field1408 / var14.field1306;

                        for(int var19 = 0; var19 < var15; ++var19) {
                           float[] var20 = var14.method2307();

                           for(int var18 = 0; var18 < var14.field1306; ++var18) {
                              var1[var13 + var19 + var18 * var15] += var20[var18];
                           }
                        }
                     } else {
                        var15 = 0;

                        while(var15 < this.field1408) {
                           float[] var16 = var14.method2307();

                           for(int var17 = 0; var17 < var14.field1306; ++var17) {
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
