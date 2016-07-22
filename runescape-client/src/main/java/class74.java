import java.util.Random;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bk")
public class class74 {
   @ObfuscatedName("m")
   class60 field1395;
   @ObfuscatedName("w")
   class60 field1396;
   @ObfuscatedName("r")
   class60 field1397;
   @ObfuscatedName("t")
   static int[] field1398;
   @ObfuscatedName("g")
   class60 field1399;
   @ObfuscatedName("l")
   class60 field1400;
   @ObfuscatedName("p")
   class60 field1401;
   @ObfuscatedName("e")
   class60 field1402;
   @ObfuscatedName("x")
   int[] field1403 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("k")
   int[] field1404 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("v")
   int[] field1405 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("j")
   class60 field1406;
   @ObfuscatedName("o")
   class60 field1407;
   @ObfuscatedName("u")
   int field1408 = 100;
   @ObfuscatedName("y")
   class66 field1409;
   @ObfuscatedName("s")
   int field1410 = 500;
   @ObfuscatedName("f")
   int field1411 = 0;
   @ObfuscatedName("i")
   static int[] field1412;
   @ObfuscatedName("d")
   static int[] field1413 = new int['耀'];
   @ObfuscatedName("h")
   int field1414 = 0;
   @ObfuscatedName("z")
   static int[] field1416;
   @ObfuscatedName("n")
   static int[] field1417;
   @ObfuscatedName("q")
   static int[] field1418;
   @ObfuscatedName("a")
   static int[] field1419;
   @ObfuscatedName("b")
   static int[] field1420;

   @ObfuscatedName("m")
   final int[] method1654(int var1, int var2) {
      class123.method2764(field1412, 0, var1);
      if(var2 < 10) {
         return field1412;
      } else {
         double var3 = (double)var1 / ((double)var2 + 0.0D);
         this.field1395.method1315();
         this.field1396.method1315();
         int var5 = 0;
         int var6 = 0;
         int var7 = 0;
         if(this.field1402 != null) {
            this.field1402.method1315();
            this.field1407.method1315();
            var5 = (int)((double)(this.field1402.field1274 - this.field1402.field1273) * 32.768D / var3);
            var6 = (int)((double)this.field1402.field1273 * 32.768D / var3);
         }

         int var8 = 0;
         int var9 = 0;
         int var10 = 0;
         if(this.field1399 != null) {
            this.field1399.method1315();
            this.field1400.method1315();
            var8 = (int)((double)(this.field1399.field1274 - this.field1399.field1273) * 32.768D / var3);
            var9 = (int)((double)this.field1399.field1273 * 32.768D / var3);
         }

         int var11;
         for(var11 = 0; var11 < 5; ++var11) {
            if(this.field1403[var11] != 0) {
               field1416[var11] = 0;
               field1417[var11] = (int)((double)this.field1405[var11] * var3);
               field1418[var11] = (this.field1403[var11] << 14) / 100;
               field1419[var11] = (int)((double)(this.field1395.field1274 - this.field1395.field1273) * 32.768D * Math.pow(1.0057929410678534D, (double)this.field1404[var11]) / var3);
               field1420[var11] = (int)((double)this.field1395.field1273 * 32.768D / var3);
            }
         }

         int var12;
         int var13;
         int var14;
         int var15;
         for(var11 = 0; var11 < var1; ++var11) {
            var12 = this.field1395.method1308(var1);
            var13 = this.field1396.method1308(var1);
            if(this.field1402 != null) {
               var14 = this.field1402.method1308(var1);
               var15 = this.field1407.method1308(var1);
               var12 += this.method1657(var7, var15, this.field1402.field1270) >> 1;
               var7 += (var14 * var5 >> 16) + var6;
            }

            if(this.field1399 != null) {
               var14 = this.field1399.method1308(var1);
               var15 = this.field1400.method1308(var1);
               var13 = var13 * ((this.method1657(var10, var15, this.field1399.field1270) >> 1) + '耀') >> 15;
               var10 += (var14 * var8 >> 16) + var9;
            }

            for(var14 = 0; var14 < 5; ++var14) {
               if(this.field1403[var14] != 0) {
                  var15 = var11 + field1417[var14];
                  if(var15 < var1) {
                     field1412[var15] += this.method1657(field1416[var14], var13 * field1418[var14] >> 15, this.field1395.field1270);
                     field1416[var14] += (var12 * field1419[var14] >> 16) + field1420[var14];
                  }
               }
            }
         }

         int var16;
         if(this.field1406 != null) {
            this.field1406.method1315();
            this.field1397.method1315();
            var11 = 0;
            boolean var19 = false;
            boolean var20 = true;

            for(var14 = 0; var14 < var1; ++var14) {
               var15 = this.field1406.method1308(var1);
               var16 = this.field1397.method1308(var1);
               if(var20) {
                  var12 = this.field1406.field1273 + ((this.field1406.field1274 - this.field1406.field1273) * var15 >> 8);
               } else {
                  var12 = this.field1406.field1273 + ((this.field1406.field1274 - this.field1406.field1273) * var16 >> 8);
               }

               var11 += 256;
               if(var11 >= var12) {
                  var11 = 0;
                  var20 = !var20;
               }

               if(var20) {
                  field1412[var14] = 0;
               }
            }
         }

         if(this.field1414 > 0 && this.field1408 > 0) {
            var11 = (int)((double)this.field1414 * var3);

            for(var12 = var11; var12 < var1; ++var12) {
               field1412[var12] += field1412[var12 - var11] * this.field1408 / 100;
            }
         }

         if(this.field1409.field1309[0] > 0 || this.field1409.field1309[1] > 0) {
            this.field1401.method1315();
            var11 = this.field1401.method1308(var1 + 1);
            var12 = this.field1409.method1371(0, (float)var11 / 65536.0F);
            var13 = this.field1409.method1371(1, (float)var11 / 65536.0F);
            if(var1 >= var12 + var13) {
               var14 = 0;
               var15 = var13;
               if(var13 > var1 - var12) {
                  var15 = var1 - var12;
               }

               int var17;
               while(var14 < var15) {
                  var16 = (int)((long)field1412[var14 + var12] * (long)class66.field1317 >> 16);

                  for(var17 = 0; var17 < var12; ++var17) {
                     var16 += (int)((long)field1412[var14 + var12 - 1 - var17] * (long)class66.field1315[0][var17] >> 16);
                  }

                  for(var17 = 0; var17 < var14; ++var17) {
                     var16 -= (int)((long)field1412[var14 - 1 - var17] * (long)class66.field1315[1][var17] >> 16);
                  }

                  field1412[var14] = var16;
                  var11 = this.field1401.method1308(var1 + 1);
                  ++var14;
               }

               var15 = 128;

               while(true) {
                  if(var15 > var1 - var12) {
                     var15 = var1 - var12;
                  }

                  int var18;
                  while(var14 < var15) {
                     var17 = (int)((long)field1412[var14 + var12] * (long)class66.field1317 >> 16);

                     for(var18 = 0; var18 < var12; ++var18) {
                        var17 += (int)((long)field1412[var14 + var12 - 1 - var18] * (long)class66.field1315[0][var18] >> 16);
                     }

                     for(var18 = 0; var18 < var13; ++var18) {
                        var17 -= (int)((long)field1412[var14 - 1 - var18] * (long)class66.field1315[1][var18] >> 16);
                     }

                     field1412[var14] = var17;
                     var11 = this.field1401.method1308(var1 + 1);
                     ++var14;
                  }

                  if(var14 >= var1 - var12) {
                     while(var14 < var1) {
                        var17 = 0;

                        for(var18 = var14 + var12 - var1; var18 < var12; ++var18) {
                           var17 += (int)((long)field1412[var14 + var12 - 1 - var18] * (long)class66.field1315[0][var18] >> 16);
                        }

                        for(var18 = 0; var18 < var13; ++var18) {
                           var17 -= (int)((long)field1412[var14 - 1 - var18] * (long)class66.field1315[1][var18] >> 16);
                        }

                        field1412[var14] = var17;
                        this.field1401.method1308(var1 + 1);
                        ++var14;
                     }
                     break;
                  }

                  var12 = this.field1409.method1371(0, (float)var11 / 65536.0F);
                  var13 = this.field1409.method1371(1, (float)var11 / 65536.0F);
                  var15 += 128;
               }
            }
         }

         for(var11 = 0; var11 < var1; ++var11) {
            if(field1412[var11] < -32768) {
               field1412[var11] = -32768;
            }

            if(field1412[var11] > 32767) {
               field1412[var11] = 32767;
            }
         }

         return field1412;
      }
   }

   @ObfuscatedName("e")
   final void method1655(class122 var1) {
      this.field1395 = new class60();
      this.field1395.method1307(var1);
      this.field1396 = new class60();
      this.field1396.method1307(var1);
      int var2 = var1.method2556();
      if(var2 != 0) {
         --var1.field2045;
         this.field1402 = new class60();
         this.field1402.method1307(var1);
         this.field1407 = new class60();
         this.field1407.method1307(var1);
      }

      var2 = var1.method2556();
      if(var2 != 0) {
         --var1.field2045;
         this.field1399 = new class60();
         this.field1399.method1307(var1);
         this.field1400 = new class60();
         this.field1400.method1307(var1);
      }

      var2 = var1.method2556();
      if(var2 != 0) {
         --var1.field2045;
         this.field1406 = new class60();
         this.field1406.method1307(var1);
         this.field1397 = new class60();
         this.field1397.method1307(var1);
      }

      for(int var3 = 0; var3 < 10; ++var3) {
         int var4 = var1.method2585();
         if(var4 == 0) {
            break;
         }

         this.field1403[var3] = var4;
         this.field1404[var3] = var1.method2584();
         this.field1405[var3] = var1.method2585();
      }

      this.field1414 = var1.method2585();
      this.field1408 = var1.method2585();
      this.field1410 = var1.method2706();
      this.field1411 = var1.method2706();
      this.field1409 = new class66();
      this.field1401 = new class60();
      this.field1409.method1372(var1, this.field1401);
   }

   static {
      Random var0 = new Random(0L);

      int var1;
      for(var1 = 0; var1 < '耀'; ++var1) {
         field1413[var1] = (var0.nextInt() & 2) - 1;
      }

      field1398 = new int['耀'];

      for(var1 = 0; var1 < '耀'; ++var1) {
         field1398[var1] = (int)(Math.sin((double)var1 / 5215.1903D) * 16384.0D);
      }

      field1412 = new int[220500];
      field1416 = new int[5];
      field1417 = new int[5];
      field1418 = new int[5];
      field1419 = new int[5];
      field1420 = new int[5];
   }

   @ObfuscatedName("w")
   final int method1657(int var1, int var2, int var3) {
      return var3 == 1?((var1 & 32767) < 16384?var2:-var2):(var3 == 2?field1398[var1 & 32767] * var2 >> 14:(var3 == 3?((var1 & 32767) * var2 >> 14) - var2:(var3 == 4?field1413[var1 / 2607 & 32767] * var2:0)));
   }
}
