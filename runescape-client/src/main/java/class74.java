import java.util.Random;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bb")
public class class74 {
   @ObfuscatedName("x")
   int field1393 = 0;
   @ObfuscatedName("d")
   class60 field1394;
   @ObfuscatedName("v")
   class60 field1395;
   @ObfuscatedName("y")
   static int[] field1396;
   @ObfuscatedName("z")
   class60 field1397;
   @ObfuscatedName("g")
   int[] field1398 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("n")
   class60 field1399;
   @ObfuscatedName("i")
   class60 field1400;
   @ObfuscatedName("q")
   class60 field1401;
   @ObfuscatedName("m")
   int[] field1402 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("k")
   int[] field1403 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("a")
   class60 field1404;
   @ObfuscatedName("t")
   class60 field1405;
   @ObfuscatedName("j")
   class66 field1406;
   @ObfuscatedName("u")
   int field1407 = 100;
   @ObfuscatedName("w")
   int field1408 = 500;
   @ObfuscatedName("b")
   int field1409 = 0;
   @ObfuscatedName("p")
   static int[] field1410;
   @ObfuscatedName("o")
   static int[] field1411 = new int['耀'];
   @ObfuscatedName("e")
   static int[] field1412;
   @ObfuscatedName("r")
   class60 field1414;
   @ObfuscatedName("h")
   static int[] field1415;
   @ObfuscatedName("l")
   static int[] field1416;
   @ObfuscatedName("c")
   static int[] field1417;
   @ObfuscatedName("f")
   static int[] field1418;

   @ObfuscatedName("v")
   final void method1613(Buffer var1) {
      this.field1404 = new class60();
      this.field1404.method1286(var1);
      this.field1394 = new class60();
      this.field1394.method1286(var1);
      int var2 = var1.method2528();
      if(var2 != 0) {
         --var1.offset;
         this.field1395 = new class60();
         this.field1395.method1286(var1);
         this.field1414 = new class60();
         this.field1414.method1286(var1);
      }

      var2 = var1.method2528();
      if(var2 != 0) {
         --var1.offset;
         this.field1397 = new class60();
         this.field1397.method1286(var1);
         this.field1405 = new class60();
         this.field1405.method1286(var1);
      }

      var2 = var1.method2528();
      if(var2 != 0) {
         --var1.offset;
         this.field1399 = new class60();
         this.field1399.method1286(var1);
         this.field1400 = new class60();
         this.field1400.method1286(var1);
      }

      for(int var3 = 0; var3 < 10; ++var3) {
         int var4 = var1.method2710();
         if(var4 == 0) {
            break;
         }

         this.field1398[var3] = var4;
         this.field1402[var3] = var1.method2540();
         this.field1403[var3] = var1.method2710();
      }

      this.field1393 = var1.method2710();
      this.field1407 = var1.method2710();
      this.field1408 = var1.method2717();
      this.field1409 = var1.method2717();
      this.field1406 = new class66();
      this.field1401 = new class60();
      this.field1406.method1337(var1, this.field1401);
   }

   @ObfuscatedName("a")
   final int[] method1614(int var1, int var2) {
      class123.method2760(field1410, 0, var1);
      if(var2 < 10) {
         return field1410;
      } else {
         double var3 = (double)var1 / ((double)var2 + 0.0D);
         this.field1404.method1293();
         this.field1394.method1293();
         int var5 = 0;
         int var6 = 0;
         int var7 = 0;
         if(this.field1395 != null) {
            this.field1395.method1293();
            this.field1414.method1293();
            var5 = (int)((double)(this.field1395.field1280 - this.field1395.field1273) * 32.768D / var3);
            var6 = (int)((double)this.field1395.field1273 * 32.768D / var3);
         }

         int var8 = 0;
         int var9 = 0;
         int var10 = 0;
         if(this.field1397 != null) {
            this.field1397.method1293();
            this.field1405.method1293();
            var8 = (int)((double)(this.field1397.field1280 - this.field1397.field1273) * 32.768D / var3);
            var9 = (int)((double)this.field1397.field1273 * 32.768D / var3);
         }

         int var11;
         for(var11 = 0; var11 < 5; ++var11) {
            if(this.field1398[var11] != 0) {
               field1412[var11] = 0;
               field1415[var11] = (int)((double)this.field1403[var11] * var3);
               field1416[var11] = (this.field1398[var11] << 14) / 100;
               field1417[var11] = (int)((double)(this.field1404.field1280 - this.field1404.field1273) * 32.768D * Math.pow(1.0057929410678534D, (double)this.field1402[var11]) / var3);
               field1418[var11] = (int)((double)this.field1404.field1273 * 32.768D / var3);
            }
         }

         int var12;
         int var13;
         int var14;
         int var15;
         for(var11 = 0; var11 < var1; ++var11) {
            var12 = this.field1404.method1288(var1);
            var13 = this.field1394.method1288(var1);
            if(this.field1395 != null) {
               var14 = this.field1395.method1288(var1);
               var15 = this.field1414.method1288(var1);
               var12 += this.method1615(var7, var15, this.field1395.field1275) >> 1;
               var7 += (var14 * var5 >> 16) + var6;
            }

            if(this.field1397 != null) {
               var14 = this.field1397.method1288(var1);
               var15 = this.field1405.method1288(var1);
               var13 = var13 * ((this.method1615(var10, var15, this.field1397.field1275) >> 1) + '耀') >> 15;
               var10 += (var14 * var8 >> 16) + var9;
            }

            for(var14 = 0; var14 < 5; ++var14) {
               if(this.field1398[var14] != 0) {
                  var15 = var11 + field1415[var14];
                  if(var15 < var1) {
                     field1410[var15] += this.method1615(field1412[var14], var13 * field1416[var14] >> 15, this.field1404.field1275);
                     field1412[var14] += (var12 * field1417[var14] >> 16) + field1418[var14];
                  }
               }
            }
         }

         int var16;
         if(this.field1399 != null) {
            this.field1399.method1293();
            this.field1400.method1293();
            var11 = 0;
            boolean var19 = false;
            boolean var20 = true;

            for(var14 = 0; var14 < var1; ++var14) {
               var15 = this.field1399.method1288(var1);
               var16 = this.field1400.method1288(var1);
               if(var20) {
                  var12 = this.field1399.field1273 + ((this.field1399.field1280 - this.field1399.field1273) * var15 >> 8);
               } else {
                  var12 = this.field1399.field1273 + ((this.field1399.field1280 - this.field1399.field1273) * var16 >> 8);
               }

               var11 += 256;
               if(var11 >= var12) {
                  var11 = 0;
                  var20 = !var20;
               }

               if(var20) {
                  field1410[var14] = 0;
               }
            }
         }

         if(this.field1393 > 0 && this.field1407 > 0) {
            var11 = (int)((double)this.field1393 * var3);

            for(var12 = var11; var12 < var1; ++var12) {
               field1410[var12] += field1410[var12 - var11] * this.field1407 / 100;
            }
         }

         if(this.field1406.field1314[0] > 0 || this.field1406.field1314[1] > 0) {
            this.field1401.method1293();
            var11 = this.field1401.method1288(var1 + 1);
            var12 = this.field1406.method1338(0, (float)var11 / 65536.0F);
            var13 = this.field1406.method1338(1, (float)var11 / 65536.0F);
            if(var1 >= var12 + var13) {
               var14 = 0;
               var15 = var13;
               if(var13 > var1 - var12) {
                  var15 = var1 - var12;
               }

               int var17;
               while(var14 < var15) {
                  var16 = (int)((long)field1410[var14 + var12] * (long)class66.field1315 >> 16);

                  for(var17 = 0; var17 < var12; ++var17) {
                     var16 += (int)((long)field1410[var14 + var12 - 1 - var17] * (long)class66.field1313[0][var17] >> 16);
                  }

                  for(var17 = 0; var17 < var14; ++var17) {
                     var16 -= (int)((long)field1410[var14 - 1 - var17] * (long)class66.field1313[1][var17] >> 16);
                  }

                  field1410[var14] = var16;
                  var11 = this.field1401.method1288(var1 + 1);
                  ++var14;
               }

               var15 = 128;

               while(true) {
                  if(var15 > var1 - var12) {
                     var15 = var1 - var12;
                  }

                  int var18;
                  while(var14 < var15) {
                     var17 = (int)((long)field1410[var14 + var12] * (long)class66.field1315 >> 16);

                     for(var18 = 0; var18 < var12; ++var18) {
                        var17 += (int)((long)field1410[var14 + var12 - 1 - var18] * (long)class66.field1313[0][var18] >> 16);
                     }

                     for(var18 = 0; var18 < var13; ++var18) {
                        var17 -= (int)((long)field1410[var14 - 1 - var18] * (long)class66.field1313[1][var18] >> 16);
                     }

                     field1410[var14] = var17;
                     var11 = this.field1401.method1288(var1 + 1);
                     ++var14;
                  }

                  if(var14 >= var1 - var12) {
                     while(var14 < var1) {
                        var17 = 0;

                        for(var18 = var14 + var12 - var1; var18 < var12; ++var18) {
                           var17 += (int)((long)field1410[var14 + var12 - 1 - var18] * (long)class66.field1313[0][var18] >> 16);
                        }

                        for(var18 = 0; var18 < var13; ++var18) {
                           var17 -= (int)((long)field1410[var14 - 1 - var18] * (long)class66.field1313[1][var18] >> 16);
                        }

                        field1410[var14] = var17;
                        this.field1401.method1288(var1 + 1);
                        ++var14;
                     }
                     break;
                  }

                  var12 = this.field1406.method1338(0, (float)var11 / 65536.0F);
                  var13 = this.field1406.method1338(1, (float)var11 / 65536.0F);
                  var15 += 128;
               }
            }
         }

         for(var11 = 0; var11 < var1; ++var11) {
            if(field1410[var11] < -32768) {
               field1410[var11] = -32768;
            }

            if(field1410[var11] > 32767) {
               field1410[var11] = 32767;
            }
         }

         return field1410;
      }
   }

   @ObfuscatedName("d")
   final int method1615(int var1, int var2, int var3) {
      return var3 == 1?((var1 & 32767) < 16384?var2:-var2):(var3 == 2?field1396[var1 & 32767] * var2 >> 14:(var3 == 3?((var1 & 32767) * var2 >> 14) - var2:(var3 == 4?field1411[var1 / 2607 & 32767] * var2:0)));
   }

   static {
      Random var0 = new Random(0L);

      int var1;
      for(var1 = 0; var1 < '耀'; ++var1) {
         field1411[var1] = (var0.nextInt() & 2) - 1;
      }

      field1396 = new int['耀'];

      for(var1 = 0; var1 < '耀'; ++var1) {
         field1396[var1] = (int)(Math.sin((double)var1 / 5215.1903D) * 16384.0D);
      }

      field1410 = new int[220500];
      field1412 = new int[5];
      field1415 = new int[5];
      field1416 = new int[5];
      field1417 = new int[5];
      field1418 = new int[5];
   }
}
