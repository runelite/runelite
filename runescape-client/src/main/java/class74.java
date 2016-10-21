import java.util.Random;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bl")
public class class74 {
   @ObfuscatedName("n")
   class60 field1368;
   @ObfuscatedName("t")
   class60 field1369;
   @ObfuscatedName("u")
   class66 field1370;
   @ObfuscatedName("d")
   int field1371 = 500;
   @ObfuscatedName("k")
   class60 field1372;
   @ObfuscatedName("b")
   class60 field1373;
   @ObfuscatedName("m")
   class60 field1374;
   @ObfuscatedName("w")
   int[] field1375 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("c")
   int[] field1376 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("v")
   class60 field1377;
   @ObfuscatedName("l")
   int[] field1378 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("e")
   class60 field1379;
   @ObfuscatedName("i")
   int field1380 = 100;
   @ObfuscatedName("x")
   class60 field1381;
   @ObfuscatedName("g")
   static int[] field1382;
   @ObfuscatedName("f")
   class60 field1383;
   @ObfuscatedName("o")
   int field1384 = 0;
   @ObfuscatedName("j")
   static int[] field1385;
   @ObfuscatedName("q")
   static int[] field1386 = new int['耀'];
   @ObfuscatedName("h")
   int field1387 = 0;
   @ObfuscatedName("z")
   static int[] field1389;
   @ObfuscatedName("p")
   static int[] field1390;
   @ObfuscatedName("y")
   static int[] field1391;
   @ObfuscatedName("s")
   static int[] field1392;
   @ObfuscatedName("r")
   static int[] field1393;

   @ObfuscatedName("f")
   final int[] method1616(int var1, int var2) {
      class123.method2741(field1385, 0, var1);
      if(var2 < 10) {
         return field1385;
      } else {
         double var3 = (double)var1 / ((double)var2 + 0.0D);
         this.field1383.method1278();
         this.field1379.method1278();
         int var5 = 0;
         int var6 = 0;
         int var7 = 0;
         if(this.field1368 != null) {
            this.field1368.method1278();
            this.field1369.method1278();
            var5 = (int)((double)(this.field1368.field1248 - this.field1368.field1247) * 32.768D / var3);
            var6 = (int)((double)this.field1368.field1247 * 32.768D / var3);
         }

         int var8 = 0;
         int var9 = 0;
         int var10 = 0;
         if(this.field1377 != null) {
            this.field1377.method1278();
            this.field1373.method1278();
            var8 = (int)((double)(this.field1377.field1248 - this.field1377.field1247) * 32.768D / var3);
            var9 = (int)((double)this.field1377.field1247 * 32.768D / var3);
         }

         int var11;
         for(var11 = 0; var11 < 5; ++var11) {
            if(this.field1376[var11] != 0) {
               field1389[var11] = 0;
               field1390[var11] = (int)((double)this.field1378[var11] * var3);
               field1391[var11] = (this.field1376[var11] << 14) / 100;
               field1392[var11] = (int)((double)(this.field1383.field1248 - this.field1383.field1247) * 32.768D * Math.pow(1.0057929410678534D, (double)this.field1375[var11]) / var3);
               field1382[var11] = (int)((double)this.field1383.field1247 * 32.768D / var3);
            }
         }

         int var12;
         int var13;
         int var14;
         int var15;
         for(var11 = 0; var11 < var1; ++var11) {
            var12 = this.field1383.method1279(var1);
            var13 = this.field1379.method1279(var1);
            if(this.field1368 != null) {
               var14 = this.field1368.method1279(var1);
               var15 = this.field1369.method1279(var1);
               var12 += this.method1617(var7, var15, this.field1368.field1251) >> 1;
               var7 += (var14 * var5 >> 16) + var6;
            }

            if(this.field1377 != null) {
               var14 = this.field1377.method1279(var1);
               var15 = this.field1373.method1279(var1);
               var13 = var13 * ((this.method1617(var10, var15, this.field1377.field1251) >> 1) + '耀') >> 15;
               var10 += (var14 * var8 >> 16) + var9;
            }

            for(var14 = 0; var14 < 5; ++var14) {
               if(this.field1376[var14] != 0) {
                  var15 = var11 + field1390[var14];
                  if(var15 < var1) {
                     field1385[var15] += this.method1617(field1389[var14], var13 * field1391[var14] >> 15, this.field1383.field1251);
                     field1389[var14] += (var12 * field1392[var14] >> 16) + field1382[var14];
                  }
               }
            }
         }

         int var16;
         if(this.field1374 != null) {
            this.field1374.method1278();
            this.field1372.method1278();
            var11 = 0;
            boolean var19 = false;
            boolean var20 = true;

            for(var14 = 0; var14 < var1; ++var14) {
               var15 = this.field1374.method1279(var1);
               var16 = this.field1372.method1279(var1);
               if(var20) {
                  var12 = this.field1374.field1247 + ((this.field1374.field1248 - this.field1374.field1247) * var15 >> 8);
               } else {
                  var12 = this.field1374.field1247 + ((this.field1374.field1248 - this.field1374.field1247) * var16 >> 8);
               }

               var11 += 256;
               if(var11 >= var12) {
                  var11 = 0;
                  var20 = !var20;
               }

               if(var20) {
                  field1385[var14] = 0;
               }
            }
         }

         if(this.field1387 > 0 && this.field1380 > 0) {
            var11 = (int)((double)this.field1387 * var3);

            for(var12 = var11; var12 < var1; ++var12) {
               field1385[var12] += field1385[var12 - var11] * this.field1380 / 100;
            }
         }

         if(this.field1370.field1288[0] > 0 || this.field1370.field1288[1] > 0) {
            this.field1381.method1278();
            var11 = this.field1381.method1279(var1 + 1);
            var12 = this.field1370.method1338(0, (float)var11 / 65536.0F);
            var13 = this.field1370.method1338(1, (float)var11 / 65536.0F);
            if(var1 >= var12 + var13) {
               var14 = 0;
               var15 = var13;
               if(var13 > var1 - var12) {
                  var15 = var1 - var12;
               }

               int var17;
               while(var14 < var15) {
                  var16 = (int)((long)field1385[var14 + var12] * (long)class66.field1290 >> 16);

                  for(var17 = 0; var17 < var12; ++var17) {
                     var16 += (int)((long)field1385[var14 + var12 - 1 - var17] * (long)class66.field1284[0][var17] >> 16);
                  }

                  for(var17 = 0; var17 < var14; ++var17) {
                     var16 -= (int)((long)field1385[var14 - 1 - var17] * (long)class66.field1284[1][var17] >> 16);
                  }

                  field1385[var14] = var16;
                  var11 = this.field1381.method1279(var1 + 1);
                  ++var14;
               }

               var15 = 128;

               while(true) {
                  if(var15 > var1 - var12) {
                     var15 = var1 - var12;
                  }

                  int var18;
                  while(var14 < var15) {
                     var17 = (int)((long)field1385[var14 + var12] * (long)class66.field1290 >> 16);

                     for(var18 = 0; var18 < var12; ++var18) {
                        var17 += (int)((long)field1385[var14 + var12 - 1 - var18] * (long)class66.field1284[0][var18] >> 16);
                     }

                     for(var18 = 0; var18 < var13; ++var18) {
                        var17 -= (int)((long)field1385[var14 - 1 - var18] * (long)class66.field1284[1][var18] >> 16);
                     }

                     field1385[var14] = var17;
                     var11 = this.field1381.method1279(var1 + 1);
                     ++var14;
                  }

                  if(var14 >= var1 - var12) {
                     while(var14 < var1) {
                        var17 = 0;

                        for(var18 = var14 + var12 - var1; var18 < var12; ++var18) {
                           var17 += (int)((long)field1385[var14 + var12 - 1 - var18] * (long)class66.field1284[0][var18] >> 16);
                        }

                        for(var18 = 0; var18 < var13; ++var18) {
                           var17 -= (int)((long)field1385[var14 - 1 - var18] * (long)class66.field1284[1][var18] >> 16);
                        }

                        field1385[var14] = var17;
                        this.field1381.method1279(var1 + 1);
                        ++var14;
                     }
                     break;
                  }

                  var12 = this.field1370.method1338(0, (float)var11 / 65536.0F);
                  var13 = this.field1370.method1338(1, (float)var11 / 65536.0F);
                  var15 += 128;
               }
            }
         }

         for(var11 = 0; var11 < var1; ++var11) {
            if(field1385[var11] < -32768) {
               field1385[var11] = -32768;
            }

            if(field1385[var11] > 32767) {
               field1385[var11] = 32767;
            }
         }

         return field1385;
      }
   }

   static {
      Random var0 = new Random(0L);

      int var1;
      for(var1 = 0; var1 < '耀'; ++var1) {
         field1386[var1] = (var0.nextInt() & 2) - 1;
      }

      field1393 = new int['耀'];

      for(var1 = 0; var1 < '耀'; ++var1) {
         field1393[var1] = (int)(Math.sin((double)var1 / 5215.1903D) * 16384.0D);
      }

      field1385 = new int[220500];
      field1389 = new int[5];
      field1390 = new int[5];
      field1391 = new int[5];
      field1392 = new int[5];
      field1382 = new int[5];
   }

   @ObfuscatedName("e")
   final int method1617(int var1, int var2, int var3) {
      return var3 == 1?((var1 & 32767) < 16384?var2:-var2):(var3 == 2?field1393[var1 & 32767] * var2 >> 14:(var3 == 3?((var1 & 32767) * var2 >> 14) - var2:(var3 == 4?field1386[var1 / 2607 & 32767] * var2:0)));
   }

   @ObfuscatedName("n")
   final void method1618(Buffer var1) {
      this.field1383 = new class60();
      this.field1383.method1284(var1);
      this.field1379 = new class60();
      this.field1379.method1284(var1);
      int var2 = var1.method2656();
      if(var2 != 0) {
         --var1.offset;
         this.field1368 = new class60();
         this.field1368.method1284(var1);
         this.field1369 = new class60();
         this.field1369.method1284(var1);
      }

      var2 = var1.method2656();
      if(var2 != 0) {
         --var1.offset;
         this.field1377 = new class60();
         this.field1377.method1284(var1);
         this.field1373 = new class60();
         this.field1373.method1284(var1);
      }

      var2 = var1.method2656();
      if(var2 != 0) {
         --var1.offset;
         this.field1374 = new class60();
         this.field1374.method1284(var1);
         this.field1372 = new class60();
         this.field1372.method1284(var1);
      }

      for(int var3 = 0; var3 < 10; ++var3) {
         int var4 = var1.method2546();
         if(var4 == 0) {
            break;
         }

         this.field1376[var3] = var4;
         this.field1375[var3] = var1.method2549();
         this.field1378[var3] = var1.method2546();
      }

      this.field1387 = var1.method2546();
      this.field1380 = var1.method2546();
      this.field1371 = var1.method2535();
      this.field1384 = var1.method2535();
      this.field1370 = new class66();
      this.field1381 = new class60();
      this.field1370.method1339(var1, this.field1381);
   }
}
