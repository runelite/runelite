import java.util.Random;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bs")
public class class74 {
   @ObfuscatedName("i")
   int[] field1391 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("l")
   class60 field1392;
   @ObfuscatedName("z")
   static int[] field1393 = new int['耀'];
   @ObfuscatedName("h")
   class60 field1394;
   @ObfuscatedName("j")
   class66 field1395;
   @ObfuscatedName("a")
   class60 field1396;
   @ObfuscatedName("b")
   class60 field1397;
   @ObfuscatedName("p")
   int[] field1398 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("o")
   int[] field1399 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("t")
   static int[] field1400;
   @ObfuscatedName("r")
   class60 field1401;
   @ObfuscatedName("q")
   int field1402 = 0;
   @ObfuscatedName("g")
   int field1403 = 100;
   @ObfuscatedName("u")
   class60 field1404;
   @ObfuscatedName("w")
   class60 field1405;
   @ObfuscatedName("e")
   class60 field1406;
   @ObfuscatedName("f")
   int field1407 = 0;
   @ObfuscatedName("s")
   static int[] field1408;
   @ObfuscatedName("x")
   int field1409 = 500;
   @ObfuscatedName("y")
   static int[] field1410;
   @ObfuscatedName("v")
   static int[] field1412;
   @ObfuscatedName("k")
   static int[] field1413;
   @ObfuscatedName("n")
   static int[] field1414;
   @ObfuscatedName("d")
   static int[] field1415;
   @ObfuscatedName("c")
   class60 field1416;

   @ObfuscatedName("e")
   final int[] method1652(int var1, int var2) {
      class123.method2829(field1400, 0, var1);
      if(var2 < 10) {
         return field1400;
      } else {
         double var3 = (double)var1 / ((double)var2 + 0.0D);
         this.field1406.method1330();
         this.field1392.method1330();
         int var5 = 0;
         int var6 = 0;
         int var7 = 0;
         if(this.field1416 != null) {
            this.field1416.method1330();
            this.field1394.method1330();
            var5 = (int)((double)(this.field1416.field1269 - this.field1416.field1273) * 32.768D / var3);
            var6 = (int)((double)this.field1416.field1273 * 32.768D / var3);
         }

         int var8 = 0;
         int var9 = 0;
         int var10 = 0;
         if(this.field1401 != null) {
            this.field1401.method1330();
            this.field1396.method1330();
            var8 = (int)((double)(this.field1401.field1269 - this.field1401.field1273) * 32.768D / var3);
            var9 = (int)((double)this.field1401.field1273 * 32.768D / var3);
         }

         int var11;
         for(var11 = 0; var11 < 5; ++var11) {
            if(this.field1399[var11] != 0) {
               field1412[var11] = 0;
               field1413[var11] = (int)((double)this.field1391[var11] * var3);
               field1414[var11] = (this.field1399[var11] << 14) / 100;
               field1415[var11] = (int)((double)(this.field1406.field1269 - this.field1406.field1273) * 32.768D * Math.pow(1.0057929410678534D, (double)this.field1398[var11]) / var3);
               field1408[var11] = (int)((double)this.field1406.field1273 * 32.768D / var3);
            }
         }

         int var12;
         int var13;
         int var14;
         int var15;
         for(var11 = 0; var11 < var1; ++var11) {
            var12 = this.field1406.method1336(var1);
            var13 = this.field1392.method1336(var1);
            if(this.field1416 != null) {
               var14 = this.field1416.method1336(var1);
               var15 = this.field1394.method1336(var1);
               var12 += this.method1660(var7, var15, this.field1416.field1270) >> 1;
               var7 += (var14 * var5 >> 16) + var6;
            }

            if(this.field1401 != null) {
               var14 = this.field1401.method1336(var1);
               var15 = this.field1396.method1336(var1);
               var13 = var13 * ((this.method1660(var10, var15, this.field1401.field1270) >> 1) + '耀') >> 15;
               var10 += (var14 * var8 >> 16) + var9;
            }

            for(var14 = 0; var14 < 5; ++var14) {
               if(this.field1399[var14] != 0) {
                  var15 = var11 + field1413[var14];
                  if(var15 < var1) {
                     field1400[var15] += this.method1660(field1412[var14], var13 * field1414[var14] >> 15, this.field1406.field1270);
                     field1412[var14] += (var12 * field1415[var14] >> 16) + field1408[var14];
                  }
               }
            }
         }

         int var16;
         if(this.field1397 != null) {
            this.field1397.method1330();
            this.field1404.method1330();
            var11 = 0;
            boolean var19 = false;
            boolean var20 = true;

            for(var14 = 0; var14 < var1; ++var14) {
               var15 = this.field1397.method1336(var1);
               var16 = this.field1404.method1336(var1);
               if(var20) {
                  var12 = this.field1397.field1273 + ((this.field1397.field1269 - this.field1397.field1273) * var15 >> 8);
               } else {
                  var12 = this.field1397.field1273 + ((this.field1397.field1269 - this.field1397.field1273) * var16 >> 8);
               }

               var11 += 256;
               if(var11 >= var12) {
                  var11 = 0;
                  var20 = !var20;
               }

               if(var20) {
                  field1400[var14] = 0;
               }
            }
         }

         if(this.field1402 > 0 && this.field1403 > 0) {
            var11 = (int)((double)this.field1402 * var3);

            for(var12 = var11; var12 < var1; ++var12) {
               field1400[var12] += field1400[var12 - var11] * this.field1403 / 100;
            }
         }

         if(this.field1395.field1316[0] > 0 || this.field1395.field1316[1] > 0) {
            this.field1405.method1330();
            var11 = this.field1405.method1336(var1 + 1);
            var12 = this.field1395.method1388(0, (float)var11 / 65536.0F);
            var13 = this.field1395.method1388(1, (float)var11 / 65536.0F);
            if(var1 >= var12 + var13) {
               var14 = 0;
               var15 = var13;
               if(var13 > var1 - var12) {
                  var15 = var1 - var12;
               }

               int var17;
               while(var14 < var15) {
                  var16 = (int)((long)field1400[var14 + var12] * (long)class66.field1313 >> 16);

                  for(var17 = 0; var17 < var12; ++var17) {
                     var16 += (int)((long)field1400[var14 + var12 - 1 - var17] * (long)class66.field1311[0][var17] >> 16);
                  }

                  for(var17 = 0; var17 < var14; ++var17) {
                     var16 -= (int)((long)field1400[var14 - 1 - var17] * (long)class66.field1311[1][var17] >> 16);
                  }

                  field1400[var14] = var16;
                  var11 = this.field1405.method1336(var1 + 1);
                  ++var14;
               }

               var15 = 128;

               while(true) {
                  if(var15 > var1 - var12) {
                     var15 = var1 - var12;
                  }

                  int var18;
                  while(var14 < var15) {
                     var17 = (int)((long)field1400[var14 + var12] * (long)class66.field1313 >> 16);

                     for(var18 = 0; var18 < var12; ++var18) {
                        var17 += (int)((long)field1400[var14 + var12 - 1 - var18] * (long)class66.field1311[0][var18] >> 16);
                     }

                     for(var18 = 0; var18 < var13; ++var18) {
                        var17 -= (int)((long)field1400[var14 - 1 - var18] * (long)class66.field1311[1][var18] >> 16);
                     }

                     field1400[var14] = var17;
                     var11 = this.field1405.method1336(var1 + 1);
                     ++var14;
                  }

                  if(var14 >= var1 - var12) {
                     while(var14 < var1) {
                        var17 = 0;

                        for(var18 = var14 + var12 - var1; var18 < var12; ++var18) {
                           var17 += (int)((long)field1400[var14 + var12 - 1 - var18] * (long)class66.field1311[0][var18] >> 16);
                        }

                        for(var18 = 0; var18 < var13; ++var18) {
                           var17 -= (int)((long)field1400[var14 - 1 - var18] * (long)class66.field1311[1][var18] >> 16);
                        }

                        field1400[var14] = var17;
                        this.field1405.method1336(var1 + 1);
                        ++var14;
                     }
                     break;
                  }

                  var12 = this.field1395.method1388(0, (float)var11 / 65536.0F);
                  var13 = this.field1395.method1388(1, (float)var11 / 65536.0F);
                  var15 += 128;
               }
            }
         }

         for(var11 = 0; var11 < var1; ++var11) {
            if(field1400[var11] < -32768) {
               field1400[var11] = -32768;
            }

            if(field1400[var11] > 32767) {
               field1400[var11] = 32767;
            }
         }

         return field1400;
      }
   }

   static {
      Random var0 = new Random(0L);

      int var1;
      for(var1 = 0; var1 < '耀'; ++var1) {
         field1393[var1] = (var0.nextInt() & 2) - 1;
      }

      field1410 = new int['耀'];

      for(var1 = 0; var1 < '耀'; ++var1) {
         field1410[var1] = (int)(Math.sin((double)var1 / 5215.1903D) * 16384.0D);
      }

      field1400 = new int[220500];
      field1412 = new int[5];
      field1413 = new int[5];
      field1414 = new int[5];
      field1415 = new int[5];
      field1408 = new int[5];
   }

   @ObfuscatedName("c")
   final void method1658(class122 var1) {
      this.field1406 = new class60();
      this.field1406.method1328(var1);
      this.field1392 = new class60();
      this.field1392.method1328(var1);
      int var2 = var1.method2610();
      if(var2 != 0) {
         --var1.field2061;
         this.field1416 = new class60();
         this.field1416.method1328(var1);
         this.field1394 = new class60();
         this.field1394.method1328(var1);
      }

      var2 = var1.method2610();
      if(var2 != 0) {
         --var1.field2061;
         this.field1401 = new class60();
         this.field1401.method1328(var1);
         this.field1396 = new class60();
         this.field1396.method1328(var1);
      }

      var2 = var1.method2610();
      if(var2 != 0) {
         --var1.field2061;
         this.field1397 = new class60();
         this.field1397.method1328(var1);
         this.field1404 = new class60();
         this.field1404.method1328(var1);
      }

      for(int var3 = 0; var3 < 10; ++var3) {
         int var4 = var1.method2672();
         if(var4 == 0) {
            break;
         }

         this.field1399[var3] = var4;
         this.field1398[var3] = var1.method2702();
         this.field1391[var3] = var1.method2672();
      }

      this.field1402 = var1.method2672();
      this.field1403 = var1.method2672();
      this.field1409 = var1.method2612();
      this.field1407 = var1.method2612();
      this.field1395 = new class66();
      this.field1405 = new class60();
      this.field1395.method1389(var1, this.field1405);
   }

   @ObfuscatedName("l")
   final int method1660(int var1, int var2, int var3) {
      return var3 == 1?((var1 & 32767) < 16384?var2:-var2):(var3 == 2?field1410[var1 & 32767] * var2 >> 14:(var3 == 3?((var1 & 32767) * var2 >> 14) - var2:(var3 == 4?field1393[var1 / 2607 & 32767] * var2:0)));
   }
}
