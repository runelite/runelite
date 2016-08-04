import java.util.Random;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bf")
public class class74 {
   @ObfuscatedName("w")
   class66 field1392;
   @ObfuscatedName("s")
   class60 field1393;
   @ObfuscatedName("l")
   class60 field1394;
   @ObfuscatedName("e")
   class60 field1395;
   @ObfuscatedName("u")
   class60 field1396;
   @ObfuscatedName("g")
   class60 field1397;
   @ObfuscatedName("k")
   class60 field1398;
   @ObfuscatedName("n")
   int[] field1399 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("m")
   int[] field1400 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("b")
   int[] field1401 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("p")
   int field1402 = 100;
   @ObfuscatedName("q")
   int field1403 = 0;
   @ObfuscatedName("a")
   static int[] field1404;
   @ObfuscatedName("r")
   class60 field1405;
   @ObfuscatedName("o")
   class60 field1406;
   @ObfuscatedName("d")
   int field1407 = 500;
   @ObfuscatedName("f")
   int field1408 = 0;
   @ObfuscatedName("z")
   static int[] field1409;
   @ObfuscatedName("i")
   static int[] field1410 = new int['耀'];
   @ObfuscatedName("v")
   static int[] field1411;
   @ObfuscatedName("x")
   static int[] field1413;
   @ObfuscatedName("t")
   static int[] field1414;
   @ObfuscatedName("y")
   static int[] field1415;
   @ObfuscatedName("h")
   class60 field1416;
   @ObfuscatedName("c")
   static int[] field1417;

   @ObfuscatedName("g")
   final int method1675(int var1, int var2, int var3) {
      return var3 == 1?((var1 & 32767) < 16384?var2:-var2):(var3 == 2?field1411[var1 & 32767] * var2 >> 14:(var3 == 3?((var1 & 32767) * var2 >> 14) - var2:(var3 == 4?field1410[var1 / 2607 & 32767] * var2:0)));
   }

   @ObfuscatedName("r")
   final void method1676(class122 var1) {
      this.field1394 = new class60();
      this.field1394.method1361(var1);
      this.field1397 = new class60();
      this.field1397.method1361(var1);
      int var2 = var1.method2633();
      if(var2 != 0) {
         --var1.field2050;
         this.field1405 = new class60();
         this.field1405.method1361(var1);
         this.field1395 = new class60();
         this.field1395.method1361(var1);
      }

      var2 = var1.method2633();
      if(var2 != 0) {
         --var1.field2050;
         this.field1416 = new class60();
         this.field1416.method1361(var1);
         this.field1393 = new class60();
         this.field1393.method1361(var1);
      }

      var2 = var1.method2633();
      if(var2 != 0) {
         --var1.field2050;
         this.field1398 = new class60();
         this.field1398.method1361(var1);
         this.field1396 = new class60();
         this.field1396.method1361(var1);
      }

      for(int var3 = 0; var3 < 10; ++var3) {
         int var4 = var1.method2646();
         if(var4 == 0) {
            break;
         }

         this.field1399[var3] = var4;
         this.field1401[var3] = var1.method2645();
         this.field1400[var3] = var1.method2646();
      }

      this.field1403 = var1.method2646();
      this.field1402 = var1.method2646();
      this.field1407 = var1.method2635();
      this.field1408 = var1.method2635();
      this.field1392 = new class66();
      this.field1406 = new class60();
      this.field1392.method1416(var1, this.field1406);
   }

   static {
      Random var0 = new Random(0L);

      int var1;
      for(var1 = 0; var1 < '耀'; ++var1) {
         field1410[var1] = (var0.nextInt() & 2) - 1;
      }

      field1411 = new int['耀'];

      for(var1 = 0; var1 < '耀'; ++var1) {
         field1411[var1] = (int)(Math.sin((double)var1 / 5215.1903D) * 16384.0D);
      }

      field1409 = new int[220500];
      field1413 = new int[5];
      field1414 = new int[5];
      field1415 = new int[5];
      field1404 = new int[5];
      field1417 = new int[5];
   }

   @ObfuscatedName("l")
   final int[] method1680(int var1, int var2) {
      class123.method2862(field1409, 0, var1);
      if(var2 < 10) {
         return field1409;
      } else {
         double var3 = (double)var1 / ((double)var2 + 0.0D);
         this.field1394.method1357();
         this.field1397.method1357();
         int var5 = 0;
         int var6 = 0;
         int var7 = 0;
         if(this.field1405 != null) {
            this.field1405.method1357();
            this.field1395.method1357();
            var5 = (int)((double)(this.field1405.field1273 - this.field1405.field1272) * 32.768D / var3);
            var6 = (int)((double)this.field1405.field1272 * 32.768D / var3);
         }

         int var8 = 0;
         int var9 = 0;
         int var10 = 0;
         if(this.field1416 != null) {
            this.field1416.method1357();
            this.field1393.method1357();
            var8 = (int)((double)(this.field1416.field1273 - this.field1416.field1272) * 32.768D / var3);
            var9 = (int)((double)this.field1416.field1272 * 32.768D / var3);
         }

         int var11;
         for(var11 = 0; var11 < 5; ++var11) {
            if(this.field1399[var11] != 0) {
               field1413[var11] = 0;
               field1414[var11] = (int)((double)this.field1400[var11] * var3);
               field1415[var11] = (this.field1399[var11] << 14) / 100;
               field1404[var11] = (int)((double)(this.field1394.field1273 - this.field1394.field1272) * 32.768D * Math.pow(1.0057929410678534D, (double)this.field1401[var11]) / var3);
               field1417[var11] = (int)((double)this.field1394.field1272 * 32.768D / var3);
            }
         }

         int var12;
         int var13;
         int var14;
         int var15;
         for(var11 = 0; var11 < var1; ++var11) {
            var12 = this.field1394.method1358(var1);
            var13 = this.field1397.method1358(var1);
            if(this.field1405 != null) {
               var14 = this.field1405.method1358(var1);
               var15 = this.field1395.method1358(var1);
               var12 += this.method1675(var7, var15, this.field1405.field1274) >> 1;
               var7 += (var14 * var5 >> 16) + var6;
            }

            if(this.field1416 != null) {
               var14 = this.field1416.method1358(var1);
               var15 = this.field1393.method1358(var1);
               var13 = var13 * ((this.method1675(var10, var15, this.field1416.field1274) >> 1) + '耀') >> 15;
               var10 += (var14 * var8 >> 16) + var9;
            }

            for(var14 = 0; var14 < 5; ++var14) {
               if(this.field1399[var14] != 0) {
                  var15 = var11 + field1414[var14];
                  if(var15 < var1) {
                     field1409[var15] += this.method1675(field1413[var14], var13 * field1415[var14] >> 15, this.field1394.field1274);
                     field1413[var14] += (var12 * field1404[var14] >> 16) + field1417[var14];
                  }
               }
            }
         }

         int var16;
         if(this.field1398 != null) {
            this.field1398.method1357();
            this.field1396.method1357();
            var11 = 0;
            boolean var19 = false;
            boolean var20 = true;

            for(var14 = 0; var14 < var1; ++var14) {
               var15 = this.field1398.method1358(var1);
               var16 = this.field1396.method1358(var1);
               if(var20) {
                  var12 = this.field1398.field1272 + ((this.field1398.field1273 - this.field1398.field1272) * var15 >> 8);
               } else {
                  var12 = this.field1398.field1272 + ((this.field1398.field1273 - this.field1398.field1272) * var16 >> 8);
               }

               var11 += 256;
               if(var11 >= var12) {
                  var11 = 0;
                  var20 = !var20;
               }

               if(var20) {
                  field1409[var14] = 0;
               }
            }
         }

         if(this.field1403 > 0 && this.field1402 > 0) {
            var11 = (int)((double)this.field1403 * var3);

            for(var12 = var11; var12 < var1; ++var12) {
               field1409[var12] += field1409[var12 - var11] * this.field1402 / 100;
            }
         }

         if(this.field1392.field1313[0] > 0 || this.field1392.field1313[1] > 0) {
            this.field1406.method1357();
            var11 = this.field1406.method1358(var1 + 1);
            var12 = this.field1392.method1411(0, (float)var11 / 65536.0F);
            var13 = this.field1392.method1411(1, (float)var11 / 65536.0F);
            if(var1 >= var12 + var13) {
               var14 = 0;
               var15 = var13;
               if(var13 > var1 - var12) {
                  var15 = var1 - var12;
               }

               int var17;
               while(var14 < var15) {
                  var16 = (int)((long)field1409[var14 + var12] * (long)class66.field1314 >> 16);

                  for(var17 = 0; var17 < var12; ++var17) {
                     var16 += (int)((long)field1409[var14 + var12 - 1 - var17] * (long)class66.field1315[0][var17] >> 16);
                  }

                  for(var17 = 0; var17 < var14; ++var17) {
                     var16 -= (int)((long)field1409[var14 - 1 - var17] * (long)class66.field1315[1][var17] >> 16);
                  }

                  field1409[var14] = var16;
                  var11 = this.field1406.method1358(var1 + 1);
                  ++var14;
               }

               var15 = 128;

               while(true) {
                  if(var15 > var1 - var12) {
                     var15 = var1 - var12;
                  }

                  int var18;
                  while(var14 < var15) {
                     var17 = (int)((long)field1409[var14 + var12] * (long)class66.field1314 >> 16);

                     for(var18 = 0; var18 < var12; ++var18) {
                        var17 += (int)((long)field1409[var14 + var12 - 1 - var18] * (long)class66.field1315[0][var18] >> 16);
                     }

                     for(var18 = 0; var18 < var13; ++var18) {
                        var17 -= (int)((long)field1409[var14 - 1 - var18] * (long)class66.field1315[1][var18] >> 16);
                     }

                     field1409[var14] = var17;
                     var11 = this.field1406.method1358(var1 + 1);
                     ++var14;
                  }

                  if(var14 >= var1 - var12) {
                     while(var14 < var1) {
                        var17 = 0;

                        for(var18 = var14 + var12 - var1; var18 < var12; ++var18) {
                           var17 += (int)((long)field1409[var14 + var12 - 1 - var18] * (long)class66.field1315[0][var18] >> 16);
                        }

                        for(var18 = 0; var18 < var13; ++var18) {
                           var17 -= (int)((long)field1409[var14 - 1 - var18] * (long)class66.field1315[1][var18] >> 16);
                        }

                        field1409[var14] = var17;
                        this.field1406.method1358(var1 + 1);
                        ++var14;
                     }
                     break;
                  }

                  var12 = this.field1392.method1411(0, (float)var11 / 65536.0F);
                  var13 = this.field1392.method1411(1, (float)var11 / 65536.0F);
                  var15 += 128;
               }
            }
         }

         for(var11 = 0; var11 < var1; ++var11) {
            if(field1409[var11] < -32768) {
               field1409[var11] = -32768;
            }

            if(field1409[var11] > 32767) {
               field1409[var11] = 32767;
            }
         }

         return field1409;
      }
   }
}
