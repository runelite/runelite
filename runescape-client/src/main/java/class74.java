import java.util.Random;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bo")
public class class74 {
   @ObfuscatedName("h")
   int[] field1380 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("q")
   class60 field1381;
   @ObfuscatedName("t")
   static int[] field1382;
   @ObfuscatedName("x")
   static int[] field1383;
   @ObfuscatedName("v")
   class60 field1384;
   @ObfuscatedName("j")
   class60 field1385;
   @ObfuscatedName("k")
   class60 field1386;
   @ObfuscatedName("d")
   static int[] field1387;
   @ObfuscatedName("u")
   int[] field1388 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("o")
   static int[] field1389;
   @ObfuscatedName("l")
   int[] field1390 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("r")
   static int[] field1391 = new int['耀'];
   @ObfuscatedName("c")
   class60 field1392;
   @ObfuscatedName("e")
   class66 field1393;
   @ObfuscatedName("s")
   int field1394 = 500;
   @ObfuscatedName("b")
   int field1395 = 0;
   @ObfuscatedName("w")
   int field1396 = 0;
   @ObfuscatedName("i")
   static int[] field1397;
   @ObfuscatedName("g")
   int field1398 = 100;
   @ObfuscatedName("a")
   static int[] field1399;
   @ObfuscatedName("z")
   static int[] field1401;
   @ObfuscatedName("f")
   class60 field1402;
   @ObfuscatedName("m")
   class60 field1403;
   @ObfuscatedName("y")
   class60 field1404;
   @ObfuscatedName("p")
   class60 field1405;

   @ObfuscatedName("k")
   final int[] method1621(int var1, int var2) {
      class123.method2780(field1397, 0, var1);
      if(var2 < 10) {
         return field1397;
      } else {
         double var3 = (double)var1 / ((double)var2 + 0.0D);
         this.field1386.method1274();
         this.field1381.method1274();
         int var5 = 0;
         int var6 = 0;
         int var7 = 0;
         if(this.field1402 != null) {
            this.field1402.method1274();
            this.field1392.method1274();
            var5 = (int)((double)(this.field1402.field1262 - this.field1402.field1261) * 32.768D / var3);
            var6 = (int)((double)this.field1402.field1261 * 32.768D / var3);
         }

         int var8 = 0;
         int var9 = 0;
         int var10 = 0;
         if(this.field1384 != null) {
            this.field1384.method1274();
            this.field1385.method1274();
            var8 = (int)((double)(this.field1384.field1262 - this.field1384.field1261) * 32.768D / var3);
            var9 = (int)((double)this.field1384.field1261 * 32.768D / var3);
         }

         int var11;
         for(var11 = 0; var11 < 5; ++var11) {
            if(this.field1388[var11] != 0) {
               field1401[var11] = 0;
               field1383[var11] = (int)((double)this.field1390[var11] * var3);
               field1387[var11] = (this.field1388[var11] << 14) / 100;
               field1382[var11] = (int)((double)(this.field1386.field1262 - this.field1386.field1261) * 32.768D * Math.pow(1.0057929410678534D, (double)this.field1380[var11]) / var3);
               field1389[var11] = (int)((double)this.field1386.field1261 * 32.768D / var3);
            }
         }

         int var12;
         int var13;
         int var14;
         int var15;
         for(var11 = 0; var11 < var1; ++var11) {
            var12 = this.field1386.method1275(var1);
            var13 = this.field1381.method1275(var1);
            if(this.field1402 != null) {
               var14 = this.field1402.method1275(var1);
               var15 = this.field1392.method1275(var1);
               var12 += this.method1629(var7, var15, this.field1402.field1263) >> 1;
               var7 += (var14 * var5 >> 16) + var6;
            }

            if(this.field1384 != null) {
               var14 = this.field1384.method1275(var1);
               var15 = this.field1385.method1275(var1);
               var13 = var13 * ((this.method1629(var10, var15, this.field1384.field1263) >> 1) + '耀') >> 15;
               var10 += (var14 * var8 >> 16) + var9;
            }

            for(var14 = 0; var14 < 5; ++var14) {
               if(this.field1388[var14] != 0) {
                  var15 = var11 + field1383[var14];
                  if(var15 < var1) {
                     field1397[var15] += this.method1629(field1401[var14], var13 * field1387[var14] >> 15, this.field1386.field1263);
                     field1401[var14] += (var12 * field1382[var14] >> 16) + field1389[var14];
                  }
               }
            }
         }

         int var16;
         if(this.field1403 != null) {
            this.field1403.method1274();
            this.field1404.method1274();
            var11 = 0;
            boolean var19 = false;
            boolean var20 = true;

            for(var14 = 0; var14 < var1; ++var14) {
               var15 = this.field1403.method1275(var1);
               var16 = this.field1404.method1275(var1);
               if(var20) {
                  var12 = this.field1403.field1261 + ((this.field1403.field1262 - this.field1403.field1261) * var15 >> 8);
               } else {
                  var12 = this.field1403.field1261 + ((this.field1403.field1262 - this.field1403.field1261) * var16 >> 8);
               }

               var11 += 256;
               if(var11 >= var12) {
                  var11 = 0;
                  var20 = !var20;
               }

               if(var20) {
                  field1397[var14] = 0;
               }
            }
         }

         if(this.field1395 > 0 && this.field1398 > 0) {
            var11 = (int)((double)this.field1395 * var3);

            for(var12 = var11; var12 < var1; ++var12) {
               field1397[var12] += field1397[var12 - var11] * this.field1398 / 100;
            }
         }

         if(this.field1393.field1303[0] > 0 || this.field1393.field1303[1] > 0) {
            this.field1405.method1274();
            var11 = this.field1405.method1275(var1 + 1);
            var12 = this.field1393.method1329(0, (float)var11 / 65536.0F);
            var13 = this.field1393.method1329(1, (float)var11 / 65536.0F);
            if(var1 >= var12 + var13) {
               var14 = 0;
               var15 = var13;
               if(var13 > var1 - var12) {
                  var15 = var1 - var12;
               }

               int var17;
               while(var14 < var15) {
                  var16 = (int)((long)field1397[var14 + var12] * (long)class66.field1302 >> 16);

                  for(var17 = 0; var17 < var12; ++var17) {
                     var16 += (int)((long)field1397[var14 + var12 - 1 - var17] * (long)class66.field1300[0][var17] >> 16);
                  }

                  for(var17 = 0; var17 < var14; ++var17) {
                     var16 -= (int)((long)field1397[var14 - 1 - var17] * (long)class66.field1300[1][var17] >> 16);
                  }

                  field1397[var14] = var16;
                  var11 = this.field1405.method1275(var1 + 1);
                  ++var14;
               }

               var15 = 128;

               while(true) {
                  if(var15 > var1 - var12) {
                     var15 = var1 - var12;
                  }

                  int var18;
                  while(var14 < var15) {
                     var17 = (int)((long)field1397[var14 + var12] * (long)class66.field1302 >> 16);

                     for(var18 = 0; var18 < var12; ++var18) {
                        var17 += (int)((long)field1397[var14 + var12 - 1 - var18] * (long)class66.field1300[0][var18] >> 16);
                     }

                     for(var18 = 0; var18 < var13; ++var18) {
                        var17 -= (int)((long)field1397[var14 - 1 - var18] * (long)class66.field1300[1][var18] >> 16);
                     }

                     field1397[var14] = var17;
                     var11 = this.field1405.method1275(var1 + 1);
                     ++var14;
                  }

                  if(var14 >= var1 - var12) {
                     while(var14 < var1) {
                        var17 = 0;

                        for(var18 = var14 + var12 - var1; var18 < var12; ++var18) {
                           var17 += (int)((long)field1397[var14 + var12 - 1 - var18] * (long)class66.field1300[0][var18] >> 16);
                        }

                        for(var18 = 0; var18 < var13; ++var18) {
                           var17 -= (int)((long)field1397[var14 - 1 - var18] * (long)class66.field1300[1][var18] >> 16);
                        }

                        field1397[var14] = var17;
                        this.field1405.method1275(var1 + 1);
                        ++var14;
                     }
                     break;
                  }

                  var12 = this.field1393.method1329(0, (float)var11 / 65536.0F);
                  var13 = this.field1393.method1329(1, (float)var11 / 65536.0F);
                  var15 += 128;
               }
            }
         }

         for(var11 = 0; var11 < var1; ++var11) {
            if(field1397[var11] < -32768) {
               field1397[var11] = -32768;
            }

            if(field1397[var11] > 32767) {
               field1397[var11] = 32767;
            }
         }

         return field1397;
      }
   }

   @ObfuscatedName("f")
   final void method1622(Buffer var1) {
      this.field1386 = new class60();
      this.field1386.method1276(var1);
      this.field1381 = new class60();
      this.field1381.method1276(var1);
      int var2 = var1.method2571();
      if(var2 != 0) {
         --var1.offset;
         this.field1402 = new class60();
         this.field1402.method1276(var1);
         this.field1392 = new class60();
         this.field1392.method1276(var1);
      }

      var2 = var1.method2571();
      if(var2 != 0) {
         --var1.offset;
         this.field1384 = new class60();
         this.field1384.method1276(var1);
         this.field1385 = new class60();
         this.field1385.method1276(var1);
      }

      var2 = var1.method2571();
      if(var2 != 0) {
         --var1.offset;
         this.field1403 = new class60();
         this.field1403.method1276(var1);
         this.field1404 = new class60();
         this.field1404.method1276(var1);
      }

      for(int var3 = 0; var3 < 10; ++var3) {
         int var4 = var1.method2554();
         if(var4 == 0) {
            break;
         }

         this.field1388[var3] = var4;
         this.field1380[var3] = var1.method2583();
         this.field1390[var3] = var1.method2554();
      }

      this.field1395 = var1.method2554();
      this.field1398 = var1.method2554();
      this.field1394 = var1.method2691();
      this.field1396 = var1.method2691();
      this.field1393 = new class66();
      this.field1405 = new class60();
      this.field1393.method1325(var1, this.field1405);
   }

   static {
      Random var0 = new Random(0L);

      int var1;
      for(var1 = 0; var1 < '耀'; ++var1) {
         field1391[var1] = (var0.nextInt() & 2) - 1;
      }

      field1399 = new int['耀'];

      for(var1 = 0; var1 < '耀'; ++var1) {
         field1399[var1] = (int)(Math.sin((double)var1 / 5215.1903D) * 16384.0D);
      }

      field1397 = new int[220500];
      field1401 = new int[5];
      field1383 = new int[5];
      field1387 = new int[5];
      field1382 = new int[5];
      field1389 = new int[5];
   }

   @ObfuscatedName("q")
   final int method1629(int var1, int var2, int var3) {
      return var3 == 1?((var1 & 32767) < 16384?var2:-var2):(var3 == 2?field1399[var1 & 32767] * var2 >> 14:(var3 == 3?((var1 & 32767) * var2 >> 14) - var2:(var3 == 4?field1391[var1 / 2607 & 32767] * var2:0)));
   }
}
