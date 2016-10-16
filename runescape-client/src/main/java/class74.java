import java.util.Random;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bz")
public class class74 {
   @ObfuscatedName("a")
   int field1363 = 500;
   @ObfuscatedName("z")
   class60 field1364;
   @ObfuscatedName("j")
   static int[] field1365;
   @ObfuscatedName("y")
   class60 field1366;
   @ObfuscatedName("p")
   class60 field1367;
   @ObfuscatedName("g")
   class60 field1368;
   @ObfuscatedName("m")
   class60 field1369;
   @ObfuscatedName("e")
   static int[] field1370;
   @ObfuscatedName("k")
   int[] field1371 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("f")
   class60 field1372;
   @ObfuscatedName("r")
   int[] field1373 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("w")
   int field1374 = 0;
   @ObfuscatedName("s")
   class60 field1375;
   @ObfuscatedName("q")
   static int[] field1376;
   @ObfuscatedName("d")
   class60 field1377;
   @ObfuscatedName("h")
   int[] field1378 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("b")
   int field1379 = 0;
   @ObfuscatedName("t")
   class60 field1380;
   @ObfuscatedName("o")
   static int[] field1381 = new int['耀'];
   @ObfuscatedName("c")
   static int[] field1382;
   @ObfuscatedName("x")
   static int[] field1384;
   @ObfuscatedName("v")
   static int[] field1385;
   @ObfuscatedName("l")
   static int[] field1386;
   @ObfuscatedName("u")
   int field1387 = 100;
   @ObfuscatedName("n")
   class66 field1388;

   @ObfuscatedName("s")
   final int[] method1572(int var1, int var2) {
      class123.method2697(field1376, 0, var1);
      if(var2 < 10) {
         return field1376;
      } else {
         double var3 = (double)var1 / ((double)var2 + 0.0D);
         this.field1375.method1243();
         this.field1364.method1243();
         int var5 = 0;
         int var6 = 0;
         int var7 = 0;
         if(this.field1380 != null) {
            this.field1380.method1243();
            this.field1366.method1243();
            var5 = (int)((double)(this.field1380.field1252 - this.field1380.field1245) * 32.768D / var3);
            var6 = (int)((double)this.field1380.field1245 * 32.768D / var3);
         }

         int var8 = 0;
         int var9 = 0;
         int var10 = 0;
         if(this.field1367 != null) {
            this.field1367.method1243();
            this.field1368.method1243();
            var8 = (int)((double)(this.field1367.field1252 - this.field1367.field1245) * 32.768D / var3);
            var9 = (int)((double)this.field1367.field1245 * 32.768D / var3);
         }

         int var11;
         for(var11 = 0; var11 < 5; ++var11) {
            if(this.field1371[var11] != 0) {
               field1384[var11] = 0;
               field1385[var11] = (int)((double)this.field1373[var11] * var3);
               field1386[var11] = (this.field1371[var11] << 14) / 100;
               field1370[var11] = (int)((double)(this.field1375.field1252 - this.field1375.field1245) * 32.768D * Math.pow(1.0057929410678534D, (double)this.field1378[var11]) / var3);
               field1365[var11] = (int)((double)this.field1375.field1245 * 32.768D / var3);
            }
         }

         int var12;
         int var13;
         int var14;
         int var15;
         for(var11 = 0; var11 < var1; ++var11) {
            var12 = this.field1375.method1241(var1);
            var13 = this.field1364.method1241(var1);
            if(this.field1380 != null) {
               var14 = this.field1380.method1241(var1);
               var15 = this.field1366.method1241(var1);
               var12 += this.method1573(var7, var15, this.field1380.field1242) >> 1;
               var7 += (var14 * var5 >> 16) + var6;
            }

            if(this.field1367 != null) {
               var14 = this.field1367.method1241(var1);
               var15 = this.field1368.method1241(var1);
               var13 = var13 * ((this.method1573(var10, var15, this.field1367.field1242) >> 1) + '耀') >> 15;
               var10 += (var14 * var8 >> 16) + var9;
            }

            for(var14 = 0; var14 < 5; ++var14) {
               if(this.field1371[var14] != 0) {
                  var15 = var11 + field1385[var14];
                  if(var15 < var1) {
                     field1376[var15] += this.method1573(field1384[var14], var13 * field1386[var14] >> 15, this.field1375.field1242);
                     field1384[var14] += (var12 * field1370[var14] >> 16) + field1365[var14];
                  }
               }
            }
         }

         int var16;
         if(this.field1369 != null) {
            this.field1369.method1243();
            this.field1372.method1243();
            var11 = 0;
            boolean var19 = false;
            boolean var20 = true;

            for(var14 = 0; var14 < var1; ++var14) {
               var15 = this.field1369.method1241(var1);
               var16 = this.field1372.method1241(var1);
               if(var20) {
                  var12 = this.field1369.field1245 + ((this.field1369.field1252 - this.field1369.field1245) * var15 >> 8);
               } else {
                  var12 = this.field1369.field1245 + ((this.field1369.field1252 - this.field1369.field1245) * var16 >> 8);
               }

               var11 += 256;
               if(var11 >= var12) {
                  var11 = 0;
                  var20 = !var20;
               }

               if(var20) {
                  field1376[var14] = 0;
               }
            }
         }

         if(this.field1374 > 0 && this.field1387 > 0) {
            var11 = (int)((double)this.field1374 * var3);

            for(var12 = var11; var12 < var1; ++var12) {
               field1376[var12] += field1376[var12 - var11] * this.field1387 / 100;
            }
         }

         if(this.field1388.field1282[0] > 0 || this.field1388.field1282[1] > 0) {
            this.field1377.method1243();
            var11 = this.field1377.method1241(var1 + 1);
            var12 = this.field1388.method1295(0, (float)var11 / 65536.0F);
            var13 = this.field1388.method1295(1, (float)var11 / 65536.0F);
            if(var1 >= var12 + var13) {
               var14 = 0;
               var15 = var13;
               if(var13 > var1 - var12) {
                  var15 = var1 - var12;
               }

               int var17;
               while(var14 < var15) {
                  var16 = (int)((long)field1376[var14 + var12] * (long)class66.field1285 >> 16);

                  for(var17 = 0; var17 < var12; ++var17) {
                     var16 += (int)((long)field1376[var14 + var12 - 1 - var17] * (long)class66.field1283[0][var17] >> 16);
                  }

                  for(var17 = 0; var17 < var14; ++var17) {
                     var16 -= (int)((long)field1376[var14 - 1 - var17] * (long)class66.field1283[1][var17] >> 16);
                  }

                  field1376[var14] = var16;
                  var11 = this.field1377.method1241(var1 + 1);
                  ++var14;
               }

               var15 = 128;

               while(true) {
                  if(var15 > var1 - var12) {
                     var15 = var1 - var12;
                  }

                  int var18;
                  while(var14 < var15) {
                     var17 = (int)((long)field1376[var14 + var12] * (long)class66.field1285 >> 16);

                     for(var18 = 0; var18 < var12; ++var18) {
                        var17 += (int)((long)field1376[var14 + var12 - 1 - var18] * (long)class66.field1283[0][var18] >> 16);
                     }

                     for(var18 = 0; var18 < var13; ++var18) {
                        var17 -= (int)((long)field1376[var14 - 1 - var18] * (long)class66.field1283[1][var18] >> 16);
                     }

                     field1376[var14] = var17;
                     var11 = this.field1377.method1241(var1 + 1);
                     ++var14;
                  }

                  if(var14 >= var1 - var12) {
                     while(var14 < var1) {
                        var17 = 0;

                        for(var18 = var14 + var12 - var1; var18 < var12; ++var18) {
                           var17 += (int)((long)field1376[var14 + var12 - 1 - var18] * (long)class66.field1283[0][var18] >> 16);
                        }

                        for(var18 = 0; var18 < var13; ++var18) {
                           var17 -= (int)((long)field1376[var14 - 1 - var18] * (long)class66.field1283[1][var18] >> 16);
                        }

                        field1376[var14] = var17;
                        this.field1377.method1241(var1 + 1);
                        ++var14;
                     }
                     break;
                  }

                  var12 = this.field1388.method1295(0, (float)var11 / 65536.0F);
                  var13 = this.field1388.method1295(1, (float)var11 / 65536.0F);
                  var15 += 128;
               }
            }
         }

         for(var11 = 0; var11 < var1; ++var11) {
            if(field1376[var11] < -32768) {
               field1376[var11] = -32768;
            }

            if(field1376[var11] > 32767) {
               field1376[var11] = 32767;
            }
         }

         return field1376;
      }
   }

   @ObfuscatedName("z")
   final int method1573(int var1, int var2, int var3) {
      return var3 == 1?((var1 & 32767) < 16384?var2:-var2):(var3 == 2?field1382[var1 & 32767] * var2 >> 14:(var3 == 3?((var1 & 32767) * var2 >> 14) - var2:(var3 == 4?field1381[var1 / 2607 & 32767] * var2:0)));
   }

   @ObfuscatedName("t")
   final void method1574(Buffer var1) {
      this.field1375 = new class60();
      this.field1375.method1231(var1);
      this.field1364 = new class60();
      this.field1364.method1231(var1);
      int var2 = var1.method2481();
      if(var2 != 0) {
         --var1.offset;
         this.field1380 = new class60();
         this.field1380.method1231(var1);
         this.field1366 = new class60();
         this.field1366.method1231(var1);
      }

      var2 = var1.method2481();
      if(var2 != 0) {
         --var1.offset;
         this.field1367 = new class60();
         this.field1367.method1231(var1);
         this.field1368 = new class60();
         this.field1368.method1231(var1);
      }

      var2 = var1.method2481();
      if(var2 != 0) {
         --var1.offset;
         this.field1369 = new class60();
         this.field1369.method1231(var1);
         this.field1372 = new class60();
         this.field1372.method1231(var1);
      }

      for(int var3 = 0; var3 < 10; ++var3) {
         int var4 = var1.method2654();
         if(var4 == 0) {
            break;
         }

         this.field1371[var3] = var4;
         this.field1378[var3] = var1.method2670();
         this.field1373[var3] = var1.method2654();
      }

      this.field1374 = var1.method2654();
      this.field1387 = var1.method2654();
      this.field1363 = var1.method2668();
      this.field1379 = var1.method2668();
      this.field1388 = new class66();
      this.field1377 = new class60();
      this.field1388.method1298(var1, this.field1377);
   }

   static {
      Random var0 = new Random(0L);

      int var1;
      for(var1 = 0; var1 < '耀'; ++var1) {
         field1381[var1] = (var0.nextInt() & 2) - 1;
      }

      field1382 = new int['耀'];

      for(var1 = 0; var1 < '耀'; ++var1) {
         field1382[var1] = (int)(Math.sin((double)var1 / 5215.1903D) * 16384.0D);
      }

      field1376 = new int[220500];
      field1384 = new int[5];
      field1385 = new int[5];
      field1386 = new int[5];
      field1370 = new int[5];
      field1365 = new int[5];
   }
}
