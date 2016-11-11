import java.util.Random;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bk")
public class class74 {
   @ObfuscatedName("h")
   class60 field1375;
   @ObfuscatedName("i")
   class60 field1376;
   @ObfuscatedName("b")
   static int[] field1377;
   @ObfuscatedName("n")
   class60 field1378;
   @ObfuscatedName("a")
   static int[] field1379;
   @ObfuscatedName("u")
   class60 field1380;
   @ObfuscatedName("d")
   class60 field1381;
   @ObfuscatedName("l")
   class60 field1382;
   @ObfuscatedName("m")
   int[] field1383 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("j")
   int[] field1384 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("y")
   int[] field1385 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("s")
   int field1386 = 0;
   @ObfuscatedName("p")
   int field1387 = 100;
   @ObfuscatedName("v")
   class66 field1388;
   @ObfuscatedName("k")
   static int[] field1389 = new int['耀'];
   @ObfuscatedName("c")
   int field1390 = 500;
   @ObfuscatedName("w")
   int field1391 = 0;
   @ObfuscatedName("x")
   static int[] field1392;
   @ObfuscatedName("r")
   class60 field1393;
   @ObfuscatedName("z")
   static int[] field1394;
   @ObfuscatedName("o")
   static int[] field1396;
   @ObfuscatedName("e")
   class60 field1397;
   @ObfuscatedName("f")
   static int[] field1398;
   @ObfuscatedName("t")
   static int[] field1399;
   @ObfuscatedName("g")
   class60 field1400;

   @ObfuscatedName("i")
   final int[] method1598(int var1, int var2) {
      class123.method2754(field1392, 0, var1);
      if(var2 < 10) {
         return field1392;
      } else {
         double var3 = (double)var1 / ((double)var2 + 0.0D);
         this.field1376.method1271();
         this.field1375.method1271();
         int var5 = 0;
         int var6 = 0;
         int var7 = 0;
         if(this.field1397 != null) {
            this.field1397.method1271();
            this.field1400.method1271();
            var5 = (int)((double)(this.field1397.field1252 - this.field1397.field1255) * 32.768D / var3);
            var6 = (int)((double)this.field1397.field1255 * 32.768D / var3);
         }

         int var8 = 0;
         int var9 = 0;
         int var10 = 0;
         if(this.field1378 != null) {
            this.field1378.method1271();
            this.field1380.method1271();
            var8 = (int)((double)(this.field1378.field1252 - this.field1378.field1255) * 32.768D / var3);
            var9 = (int)((double)this.field1378.field1255 * 32.768D / var3);
         }

         int var11;
         for(var11 = 0; var11 < 5; ++var11) {
            if(this.field1383[var11] != 0) {
               field1396[var11] = 0;
               field1398[var11] = (int)((double)this.field1385[var11] * var3);
               field1377[var11] = (this.field1383[var11] << 14) / 100;
               field1399[var11] = (int)((double)(this.field1376.field1252 - this.field1376.field1255) * 32.768D * Math.pow(1.0057929410678534D, (double)this.field1384[var11]) / var3);
               field1379[var11] = (int)((double)this.field1376.field1255 * 32.768D / var3);
            }
         }

         int var12;
         int var13;
         int var14;
         int var15;
         for(var11 = 0; var11 < var1; ++var11) {
            var12 = this.field1376.method1275(var1);
            var13 = this.field1375.method1275(var1);
            if(this.field1397 != null) {
               var14 = this.field1397.method1275(var1);
               var15 = this.field1400.method1275(var1);
               var12 += this.method1600(var7, var15, this.field1397.field1256) >> 1;
               var7 += (var14 * var5 >> 16) + var6;
            }

            if(this.field1378 != null) {
               var14 = this.field1378.method1275(var1);
               var15 = this.field1380.method1275(var1);
               var13 = var13 * ((this.method1600(var10, var15, this.field1378.field1256) >> 1) + '耀') >> 15;
               var10 += (var14 * var8 >> 16) + var9;
            }

            for(var14 = 0; var14 < 5; ++var14) {
               if(this.field1383[var14] != 0) {
                  var15 = var11 + field1398[var14];
                  if(var15 < var1) {
                     field1392[var15] += this.method1600(field1396[var14], var13 * field1377[var14] >> 15, this.field1376.field1256);
                     field1396[var14] += (var12 * field1399[var14] >> 16) + field1379[var14];
                  }
               }
            }
         }

         int var16;
         if(this.field1381 != null) {
            this.field1381.method1271();
            this.field1382.method1271();
            var11 = 0;
            boolean var19 = false;
            boolean var20 = true;

            for(var14 = 0; var14 < var1; ++var14) {
               var15 = this.field1381.method1275(var1);
               var16 = this.field1382.method1275(var1);
               if(var20) {
                  var12 = this.field1381.field1255 + ((this.field1381.field1252 - this.field1381.field1255) * var15 >> 8);
               } else {
                  var12 = this.field1381.field1255 + ((this.field1381.field1252 - this.field1381.field1255) * var16 >> 8);
               }

               var11 += 256;
               if(var11 >= var12) {
                  var11 = 0;
                  var20 = !var20;
               }

               if(var20) {
                  field1392[var14] = 0;
               }
            }
         }

         if(this.field1386 > 0 && this.field1387 > 0) {
            var11 = (int)((double)this.field1386 * var3);

            for(var12 = var11; var12 < var1; ++var12) {
               field1392[var12] += field1392[var12 - var11] * this.field1387 / 100;
            }
         }

         if(this.field1388.field1300[0] > 0 || this.field1388.field1300[1] > 0) {
            this.field1393.method1271();
            var11 = this.field1393.method1275(var1 + 1);
            var12 = this.field1388.method1340(0, (float)var11 / 65536.0F);
            var13 = this.field1388.method1340(1, (float)var11 / 65536.0F);
            if(var1 >= var12 + var13) {
               var14 = 0;
               var15 = var13;
               if(var13 > var1 - var12) {
                  var15 = var1 - var12;
               }

               int var17;
               while(var14 < var15) {
                  var16 = (int)((long)field1392[var14 + var12] * (long)class66.field1297 >> 16);

                  for(var17 = 0; var17 < var12; ++var17) {
                     var16 += (int)((long)field1392[var14 + var12 - 1 - var17] * (long)class66.field1295[0][var17] >> 16);
                  }

                  for(var17 = 0; var17 < var14; ++var17) {
                     var16 -= (int)((long)field1392[var14 - 1 - var17] * (long)class66.field1295[1][var17] >> 16);
                  }

                  field1392[var14] = var16;
                  var11 = this.field1393.method1275(var1 + 1);
                  ++var14;
               }

               var15 = 128;

               while(true) {
                  if(var15 > var1 - var12) {
                     var15 = var1 - var12;
                  }

                  int var18;
                  while(var14 < var15) {
                     var17 = (int)((long)field1392[var14 + var12] * (long)class66.field1297 >> 16);

                     for(var18 = 0; var18 < var12; ++var18) {
                        var17 += (int)((long)field1392[var14 + var12 - 1 - var18] * (long)class66.field1295[0][var18] >> 16);
                     }

                     for(var18 = 0; var18 < var13; ++var18) {
                        var17 -= (int)((long)field1392[var14 - 1 - var18] * (long)class66.field1295[1][var18] >> 16);
                     }

                     field1392[var14] = var17;
                     var11 = this.field1393.method1275(var1 + 1);
                     ++var14;
                  }

                  if(var14 >= var1 - var12) {
                     while(var14 < var1) {
                        var17 = 0;

                        for(var18 = var14 + var12 - var1; var18 < var12; ++var18) {
                           var17 += (int)((long)field1392[var14 + var12 - 1 - var18] * (long)class66.field1295[0][var18] >> 16);
                        }

                        for(var18 = 0; var18 < var13; ++var18) {
                           var17 -= (int)((long)field1392[var14 - 1 - var18] * (long)class66.field1295[1][var18] >> 16);
                        }

                        field1392[var14] = var17;
                        this.field1393.method1275(var1 + 1);
                        ++var14;
                     }
                     break;
                  }

                  var12 = this.field1388.method1340(0, (float)var11 / 65536.0F);
                  var13 = this.field1388.method1340(1, (float)var11 / 65536.0F);
                  var15 += 128;
               }
            }
         }

         for(var11 = 0; var11 < var1; ++var11) {
            if(field1392[var11] < -32768) {
               field1392[var11] = -32768;
            }

            if(field1392[var11] > 32767) {
               field1392[var11] = 32767;
            }
         }

         return field1392;
      }
   }

   @ObfuscatedName("h")
   final int method1600(int var1, int var2, int var3) {
      return var3 == 1?((var1 & 32767) < 16384?var2:-var2):(var3 == 2?field1394[var1 & 32767] * var2 >> 14:(var3 == 3?((var1 & 32767) * var2 >> 14) - var2:(var3 == 4?field1389[var1 / 2607 & 32767] * var2:0)));
   }

   @ObfuscatedName("e")
   final void method1601(Buffer var1) {
      this.field1376 = new class60();
      this.field1376.method1269(var1);
      this.field1375 = new class60();
      this.field1375.method1269(var1);
      int var2 = var1.method2544();
      if(var2 != 0) {
         --var1.offset;
         this.field1397 = new class60();
         this.field1397.method1269(var1);
         this.field1400 = new class60();
         this.field1400.method1269(var1);
      }

      var2 = var1.method2544();
      if(var2 != 0) {
         --var1.offset;
         this.field1378 = new class60();
         this.field1378.method1269(var1);
         this.field1380 = new class60();
         this.field1380.method1269(var1);
      }

      var2 = var1.method2544();
      if(var2 != 0) {
         --var1.offset;
         this.field1381 = new class60();
         this.field1381.method1269(var1);
         this.field1382 = new class60();
         this.field1382.method1269(var1);
      }

      for(int var3 = 0; var3 < 10; ++var3) {
         int var4 = var1.method2573();
         if(var4 == 0) {
            break;
         }

         this.field1383[var3] = var4;
         this.field1384[var3] = var1.method2556();
         this.field1385[var3] = var1.method2573();
      }

      this.field1386 = var1.method2573();
      this.field1387 = var1.method2573();
      this.field1390 = var1.method2546();
      this.field1391 = var1.method2546();
      this.field1388 = new class66();
      this.field1393 = new class60();
      this.field1388.method1326(var1, this.field1393);
   }

   static {
      Random var0 = new Random(0L);

      int var1;
      for(var1 = 0; var1 < '耀'; ++var1) {
         field1389[var1] = (var0.nextInt() & 2) - 1;
      }

      field1394 = new int['耀'];

      for(var1 = 0; var1 < '耀'; ++var1) {
         field1394[var1] = (int)(Math.sin((double)var1 / 5215.1903D) * 16384.0D);
      }

      field1392 = new int[220500];
      field1396 = new int[5];
      field1398 = new int[5];
      field1377 = new int[5];
      field1399 = new int[5];
      field1379 = new int[5];
   }
}
