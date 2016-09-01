import java.util.Random;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("by")
public class class74 {
   @ObfuscatedName("m")
   class60 field1365;
   @ObfuscatedName("b")
   class60 field1366;
   @ObfuscatedName("x")
   class60 field1367;
   @ObfuscatedName("z")
   class60 field1368;
   @ObfuscatedName("i")
   class60 field1369;
   @ObfuscatedName("v")
   int field1370 = 0;
   @ObfuscatedName("l")
   class60 field1371;
   @ObfuscatedName("p")
   int[] field1372 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("g")
   class60 field1373;
   @ObfuscatedName("f")
   int[] field1374 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("w")
   static int[] field1375;
   @ObfuscatedName("d")
   int[] field1376 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("q")
   int field1377 = 100;
   @ObfuscatedName("t")
   class66 field1378;
   @ObfuscatedName("j")
   class60 field1379;
   @ObfuscatedName("a")
   static int[] field1380 = new int['耀'];
   @ObfuscatedName("h")
   int field1381 = 0;
   @ObfuscatedName("u")
   static int[] field1382;
   @ObfuscatedName("r")
   class60 field1383;
   @ObfuscatedName("e")
   static int[] field1384;
   @ObfuscatedName("n")
   static int[] field1386;
   @ObfuscatedName("y")
   static int[] field1387;
   @ObfuscatedName("k")
   static int[] field1388;
   @ObfuscatedName("s")
   int field1389 = 500;
   @ObfuscatedName("o")
   static int[] field1390;

   @ObfuscatedName("x")
   final int[] method1594(int var1, int var2) {
      class123.method2786(field1382, 0, var1);
      if(var2 < 10) {
         return field1382;
      } else {
         double var3 = (double)var1 / ((double)var2 + 0.0D);
         this.field1367.method1282();
         this.field1383.method1282();
         int var5 = 0;
         int var6 = 0;
         int var7 = 0;
         if(this.field1379 != null) {
            this.field1379.method1282();
            this.field1368.method1282();
            var5 = (int)((double)(this.field1379.field1251 - this.field1379.field1247) * 32.768D / var3);
            var6 = (int)((double)this.field1379.field1247 * 32.768D / var3);
         }

         int var8 = 0;
         int var9 = 0;
         int var10 = 0;
         if(this.field1369 != null) {
            this.field1369.method1282();
            this.field1366.method1282();
            var8 = (int)((double)(this.field1369.field1251 - this.field1369.field1247) * 32.768D / var3);
            var9 = (int)((double)this.field1369.field1247 * 32.768D / var3);
         }

         int var11;
         for(var11 = 0; var11 < 5; ++var11) {
            if(this.field1372[var11] != 0) {
               field1386[var11] = 0;
               field1387[var11] = (int)((double)this.field1376[var11] * var3);
               field1388[var11] = (this.field1372[var11] << 14) / 100;
               field1375[var11] = (int)((double)(this.field1367.field1251 - this.field1367.field1247) * 32.768D * Math.pow(1.0057929410678534D, (double)this.field1374[var11]) / var3);
               field1390[var11] = (int)((double)this.field1367.field1247 * 32.768D / var3);
            }
         }

         int var12;
         int var13;
         int var14;
         int var15;
         for(var11 = 0; var11 < var1; ++var11) {
            var12 = this.field1367.method1283(var1);
            var13 = this.field1383.method1283(var1);
            if(this.field1379 != null) {
               var14 = this.field1379.method1283(var1);
               var15 = this.field1368.method1283(var1);
               var12 += this.method1599(var7, var15, this.field1379.field1249) >> 1;
               var7 += (var14 * var5 >> 16) + var6;
            }

            if(this.field1369 != null) {
               var14 = this.field1369.method1283(var1);
               var15 = this.field1366.method1283(var1);
               var13 = var13 * ((this.method1599(var10, var15, this.field1369.field1249) >> 1) + '耀') >> 15;
               var10 += (var14 * var8 >> 16) + var9;
            }

            for(var14 = 0; var14 < 5; ++var14) {
               if(this.field1372[var14] != 0) {
                  var15 = var11 + field1387[var14];
                  if(var15 < var1) {
                     field1382[var15] += this.method1599(field1386[var14], var13 * field1388[var14] >> 15, this.field1367.field1249);
                     field1386[var14] += (var12 * field1375[var14] >> 16) + field1390[var14];
                  }
               }
            }
         }

         int var16;
         if(this.field1371 != null) {
            this.field1371.method1282();
            this.field1365.method1282();
            var11 = 0;
            boolean var19 = false;
            boolean var20 = true;

            for(var14 = 0; var14 < var1; ++var14) {
               var15 = this.field1371.method1283(var1);
               var16 = this.field1365.method1283(var1);
               if(var20) {
                  var12 = this.field1371.field1247 + ((this.field1371.field1251 - this.field1371.field1247) * var15 >> 8);
               } else {
                  var12 = this.field1371.field1247 + ((this.field1371.field1251 - this.field1371.field1247) * var16 >> 8);
               }

               var11 += 256;
               if(var11 >= var12) {
                  var11 = 0;
                  var20 = !var20;
               }

               if(var20) {
                  field1382[var14] = 0;
               }
            }
         }

         if(this.field1370 > 0 && this.field1377 > 0) {
            var11 = (int)((double)this.field1370 * var3);

            for(var12 = var11; var12 < var1; ++var12) {
               field1382[var12] += field1382[var12 - var11] * this.field1377 / 100;
            }
         }

         if(this.field1378.field1286[0] > 0 || this.field1378.field1286[1] > 0) {
            this.field1373.method1282();
            var11 = this.field1373.method1283(var1 + 1);
            var12 = this.field1378.method1334(0, (float)var11 / 65536.0F);
            var13 = this.field1378.method1334(1, (float)var11 / 65536.0F);
            if(var1 >= var12 + var13) {
               var14 = 0;
               var15 = var13;
               if(var13 > var1 - var12) {
                  var15 = var1 - var12;
               }

               int var17;
               while(var14 < var15) {
                  var16 = (int)((long)field1382[var14 + var12] * (long)class66.field1287 >> 16);

                  for(var17 = 0; var17 < var12; ++var17) {
                     var16 += (int)((long)field1382[var14 + var12 - 1 - var17] * (long)class66.field1284[0][var17] >> 16);
                  }

                  for(var17 = 0; var17 < var14; ++var17) {
                     var16 -= (int)((long)field1382[var14 - 1 - var17] * (long)class66.field1284[1][var17] >> 16);
                  }

                  field1382[var14] = var16;
                  var11 = this.field1373.method1283(var1 + 1);
                  ++var14;
               }

               var15 = 128;

               while(true) {
                  if(var15 > var1 - var12) {
                     var15 = var1 - var12;
                  }

                  int var18;
                  while(var14 < var15) {
                     var17 = (int)((long)field1382[var14 + var12] * (long)class66.field1287 >> 16);

                     for(var18 = 0; var18 < var12; ++var18) {
                        var17 += (int)((long)field1382[var14 + var12 - 1 - var18] * (long)class66.field1284[0][var18] >> 16);
                     }

                     for(var18 = 0; var18 < var13; ++var18) {
                        var17 -= (int)((long)field1382[var14 - 1 - var18] * (long)class66.field1284[1][var18] >> 16);
                     }

                     field1382[var14] = var17;
                     var11 = this.field1373.method1283(var1 + 1);
                     ++var14;
                  }

                  if(var14 >= var1 - var12) {
                     while(var14 < var1) {
                        var17 = 0;

                        for(var18 = var14 + var12 - var1; var18 < var12; ++var18) {
                           var17 += (int)((long)field1382[var14 + var12 - 1 - var18] * (long)class66.field1284[0][var18] >> 16);
                        }

                        for(var18 = 0; var18 < var13; ++var18) {
                           var17 -= (int)((long)field1382[var14 - 1 - var18] * (long)class66.field1284[1][var18] >> 16);
                        }

                        field1382[var14] = var17;
                        this.field1373.method1283(var1 + 1);
                        ++var14;
                     }
                     break;
                  }

                  var12 = this.field1378.method1334(0, (float)var11 / 65536.0F);
                  var13 = this.field1378.method1334(1, (float)var11 / 65536.0F);
                  var15 += 128;
               }
            }
         }

         for(var11 = 0; var11 < var1; ++var11) {
            if(field1382[var11] < -32768) {
               field1382[var11] = -32768;
            }

            if(field1382[var11] > 32767) {
               field1382[var11] = 32767;
            }
         }

         return field1382;
      }
   }

   @ObfuscatedName("j")
   final void method1595(Buffer var1) {
      this.field1367 = new class60();
      this.field1367.method1289(var1);
      this.field1383 = new class60();
      this.field1383.method1289(var1);
      int var2 = var1.method2556();
      if(var2 != 0) {
         --var1.offset;
         this.field1379 = new class60();
         this.field1379.method1289(var1);
         this.field1368 = new class60();
         this.field1368.method1289(var1);
      }

      var2 = var1.method2556();
      if(var2 != 0) {
         --var1.offset;
         this.field1369 = new class60();
         this.field1369.method1289(var1);
         this.field1366 = new class60();
         this.field1366.method1289(var1);
      }

      var2 = var1.method2556();
      if(var2 != 0) {
         --var1.offset;
         this.field1371 = new class60();
         this.field1371.method1289(var1);
         this.field1365 = new class60();
         this.field1365.method1289(var1);
      }

      for(int var3 = 0; var3 < 10; ++var3) {
         int var4 = var1.method2569();
         if(var4 == 0) {
            break;
         }

         this.field1372[var3] = var4;
         this.field1374[var3] = var1.method2568();
         this.field1376[var3] = var1.method2569();
      }

      this.field1370 = var1.method2569();
      this.field1377 = var1.method2569();
      this.field1389 = var1.method2551();
      this.field1381 = var1.method2551();
      this.field1378 = new class66();
      this.field1373 = new class60();
      this.field1378.method1329(var1, this.field1373);
   }

   static {
      Random var0 = new Random(0L);

      int var1;
      for(var1 = 0; var1 < '耀'; ++var1) {
         field1380[var1] = (var0.nextInt() & 2) - 1;
      }

      field1384 = new int['耀'];

      for(var1 = 0; var1 < '耀'; ++var1) {
         field1384[var1] = (int)(Math.sin((double)var1 / 5215.1903D) * 16384.0D);
      }

      field1382 = new int[220500];
      field1386 = new int[5];
      field1387 = new int[5];
      field1388 = new int[5];
      field1375 = new int[5];
      field1390 = new int[5];
   }

   @ObfuscatedName("r")
   final int method1599(int var1, int var2, int var3) {
      return var3 == 1?((var1 & 32767) < 16384?var2:-var2):(var3 == 2?field1384[var1 & 32767] * var2 >> 14:(var3 == 3?((var1 & 32767) * var2 >> 14) - var2:(var3 == 4?field1380[var1 / 2607 & 32767] * var2:0)));
   }
}
