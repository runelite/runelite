import java.util.Random;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bj")
public class class71 {
   @ObfuscatedName("j")
   static int[] field1329 = new int['耀'];
   @ObfuscatedName("w")
   class57 field1330;
   @ObfuscatedName("d")
   class57 field1331;
   @ObfuscatedName("c")
   class57 field1332;
   @ObfuscatedName("u")
   int field1333 = 0;
   @ObfuscatedName("n")
   int field1334 = 500;
   @ObfuscatedName("f")
   static int[] field1335;
   @ObfuscatedName("a")
   class57 field1336;
   @ObfuscatedName("q")
   int[] field1337 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("m")
   int[] field1338 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("e")
   int[] field1339 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("z")
   int field1341 = 100;
   @ObfuscatedName("i")
   class63 field1342;
   @ObfuscatedName("t")
   class57 field1343;
   @ObfuscatedName("r")
   class57 field1344;
   @ObfuscatedName("k")
   class57 field1345;
   @ObfuscatedName("g")
   static int[] field1346;
   @ObfuscatedName("p")
   class57 field1347;
   @ObfuscatedName("h")
   static int[] field1348;
   @ObfuscatedName("x")
   int field1349 = 0;
   @ObfuscatedName("y")
   class57 field1350;
   @ObfuscatedName("b")
   static int[] field1351;
   @ObfuscatedName("l")
   static int[] field1352;
   @ObfuscatedName("o")
   static int[] field1353;
   @ObfuscatedName("v")
   static int[] field1354;

   @ObfuscatedName("d")
   final void method1664(class119 var1) {
      this.field1336 = new class57();
      this.field1336.method1321(var1);
      this.field1330 = new class57();
      this.field1330.method1321(var1);
      int var2 = var1.method2613();
      if(var2 != 0) {
         --var1.field1992;
         this.field1331 = new class57();
         this.field1331.method1321(var1);
         this.field1332 = new class57();
         this.field1332.method1321(var1);
      }

      var2 = var1.method2613();
      if(var2 != 0) {
         --var1.field1992;
         this.field1350 = new class57();
         this.field1350.method1321(var1);
         this.field1345 = new class57();
         this.field1345.method1321(var1);
      }

      var2 = var1.method2613();
      if(var2 != 0) {
         --var1.field1992;
         this.field1344 = new class57();
         this.field1344.method1321(var1);
         this.field1347 = new class57();
         this.field1347.method1321(var1);
      }

      for(int var3 = 0; var3 < 10; ++var3) {
         int var4 = var1.method2812();
         if(var4 == 0) {
            break;
         }

         this.field1337[var3] = var4;
         this.field1338[var3] = var1.method2642();
         this.field1339[var3] = var1.method2812();
      }

      this.field1349 = var1.method2812();
      this.field1341 = var1.method2812();
      this.field1334 = var1.method2615();
      this.field1333 = var1.method2615();
      this.field1342 = new class63();
      this.field1343 = new class57();
      this.field1342.method1377(var1, this.field1343);
   }

   static {
      Random var0 = new Random(0L);

      int var1;
      for(var1 = 0; var1 < '耀'; ++var1) {
         field1329[var1] = (var0.nextInt() & 2) - 1;
      }

      field1348 = new int['耀'];

      for(var1 = 0; var1 < '耀'; ++var1) {
         field1348[var1] = (int)(Math.sin((double)var1 / 5215.1903D) * 16384.0D);
      }

      field1346 = new int[220500];
      field1335 = new int[5];
      field1351 = new int[5];
      field1352 = new int[5];
      field1353 = new int[5];
      field1354 = new int[5];
   }

   @ObfuscatedName("w")
   final int method1665(int var1, int var2, int var3) {
      return var3 == 1?((var1 & 32767) < 16384?var2:-var2):(var3 == 2?field1348[var1 & 32767] * var2 >> 14:(var3 == 3?((var1 & 32767) * var2 >> 14) - var2:(var3 == 4?field1329[var1 / 2607 & 32767] * var2:0)));
   }

   @ObfuscatedName("a")
   final int[] method1669(int var1, int var2) {
      class120.method2856(field1346, 0, var1);
      if(var2 < 10) {
         return field1346;
      } else {
         double var3 = (double)var1 / ((double)var2 + 0.0D);
         this.field1336.method1325();
         this.field1330.method1325();
         int var5 = 0;
         int var6 = 0;
         int var7 = 0;
         if(this.field1331 != null) {
            this.field1331.method1325();
            this.field1332.method1325();
            var5 = (int)((double)(this.field1331.field1210 - this.field1331.field1209) * 32.768D / var3);
            var6 = (int)((double)this.field1331.field1209 * 32.768D / var3);
         }

         int var8 = 0;
         int var9 = 0;
         int var10 = 0;
         if(this.field1350 != null) {
            this.field1350.method1325();
            this.field1345.method1325();
            var8 = (int)((double)(this.field1350.field1210 - this.field1350.field1209) * 32.768D / var3);
            var9 = (int)((double)this.field1350.field1209 * 32.768D / var3);
         }

         int var11;
         for(var11 = 0; var11 < 5; ++var11) {
            if(this.field1337[var11] != 0) {
               field1335[var11] = 0;
               field1351[var11] = (int)((double)this.field1339[var11] * var3);
               field1352[var11] = (this.field1337[var11] << 14) / 100;
               field1353[var11] = (int)((double)(this.field1336.field1210 - this.field1336.field1209) * 32.768D * Math.pow(1.0057929410678534D, (double)this.field1338[var11]) / var3);
               field1354[var11] = (int)((double)this.field1336.field1209 * 32.768D / var3);
            }
         }

         int var12;
         int var13;
         int var14;
         int var15;
         for(var11 = 0; var11 < var1; ++var11) {
            var12 = this.field1336.method1323(var1);
            var13 = this.field1330.method1323(var1);
            if(this.field1331 != null) {
               var14 = this.field1331.method1323(var1);
               var15 = this.field1332.method1323(var1);
               var12 += this.method1665(var7, var15, this.field1331.field1211) >> 1;
               var7 += (var14 * var5 >> 16) + var6;
            }

            if(this.field1350 != null) {
               var14 = this.field1350.method1323(var1);
               var15 = this.field1345.method1323(var1);
               var13 = var13 * ((this.method1665(var10, var15, this.field1350.field1211) >> 1) + '耀') >> 15;
               var10 += (var14 * var8 >> 16) + var9;
            }

            for(var14 = 0; var14 < 5; ++var14) {
               if(this.field1337[var14] != 0) {
                  var15 = var11 + field1351[var14];
                  if(var15 < var1) {
                     field1346[var15] += this.method1665(field1335[var14], var13 * field1352[var14] >> 15, this.field1336.field1211);
                     field1335[var14] += (var12 * field1353[var14] >> 16) + field1354[var14];
                  }
               }
            }
         }

         int var16;
         if(this.field1344 != null) {
            this.field1344.method1325();
            this.field1347.method1325();
            var11 = 0;
            boolean var19 = false;
            boolean var20 = true;

            for(var14 = 0; var14 < var1; ++var14) {
               var15 = this.field1344.method1323(var1);
               var16 = this.field1347.method1323(var1);
               if(var20) {
                  var12 = this.field1344.field1209 + ((this.field1344.field1210 - this.field1344.field1209) * var15 >> 8);
               } else {
                  var12 = this.field1344.field1209 + ((this.field1344.field1210 - this.field1344.field1209) * var16 >> 8);
               }

               var11 += 256;
               if(var11 >= var12) {
                  var11 = 0;
                  var20 = !var20;
               }

               if(var20) {
                  field1346[var14] = 0;
               }
            }
         }

         if(this.field1349 > 0 && this.field1341 > 0) {
            var11 = (int)((double)this.field1349 * var3);

            for(var12 = var11; var12 < var1; ++var12) {
               field1346[var12] += field1346[var12 - var11] * this.field1341 / 100;
            }
         }

         if(this.field1342.field1252[0] > 0 || this.field1342.field1252[1] > 0) {
            this.field1343.method1325();
            var11 = this.field1343.method1323(var1 + 1);
            var12 = this.field1342.method1375(0, (float)var11 / 65536.0F);
            var13 = this.field1342.method1375(1, (float)var11 / 65536.0F);
            if(var1 >= var12 + var13) {
               var14 = 0;
               var15 = var13;
               if(var13 > var1 - var12) {
                  var15 = var1 - var12;
               }

               int var17;
               while(var14 < var15) {
                  var16 = (int)((long)field1346[var14 + var12] * (long)class63.field1251 >> 16);

                  for(var17 = 0; var17 < var12; ++var17) {
                     var16 += (int)((long)field1346[var14 + var12 - 1 - var17] * (long)class63.field1249[0][var17] >> 16);
                  }

                  for(var17 = 0; var17 < var14; ++var17) {
                     var16 -= (int)((long)field1346[var14 - 1 - var17] * (long)class63.field1249[1][var17] >> 16);
                  }

                  field1346[var14] = var16;
                  var11 = this.field1343.method1323(var1 + 1);
                  ++var14;
               }

               var15 = 128;

               while(true) {
                  if(var15 > var1 - var12) {
                     var15 = var1 - var12;
                  }

                  int var18;
                  while(var14 < var15) {
                     var17 = (int)((long)field1346[var14 + var12] * (long)class63.field1251 >> 16);

                     for(var18 = 0; var18 < var12; ++var18) {
                        var17 += (int)((long)field1346[var14 + var12 - 1 - var18] * (long)class63.field1249[0][var18] >> 16);
                     }

                     for(var18 = 0; var18 < var13; ++var18) {
                        var17 -= (int)((long)field1346[var14 - 1 - var18] * (long)class63.field1249[1][var18] >> 16);
                     }

                     field1346[var14] = var17;
                     var11 = this.field1343.method1323(var1 + 1);
                     ++var14;
                  }

                  if(var14 >= var1 - var12) {
                     while(var14 < var1) {
                        var17 = 0;

                        for(var18 = var14 + var12 - var1; var18 < var12; ++var18) {
                           var17 += (int)((long)field1346[var14 + var12 - 1 - var18] * (long)class63.field1249[0][var18] >> 16);
                        }

                        for(var18 = 0; var18 < var13; ++var18) {
                           var17 -= (int)((long)field1346[var14 - 1 - var18] * (long)class63.field1249[1][var18] >> 16);
                        }

                        field1346[var14] = var17;
                        this.field1343.method1323(var1 + 1);
                        ++var14;
                     }
                     break;
                  }

                  var12 = this.field1342.method1375(0, (float)var11 / 65536.0F);
                  var13 = this.field1342.method1375(1, (float)var11 / 65536.0F);
                  var15 += 128;
               }
            }
         }

         for(var11 = 0; var11 < var1; ++var11) {
            if(field1346[var11] < -32768) {
               field1346[var11] = -32768;
            }

            if(field1346[var11] > 32767) {
               field1346[var11] = 32767;
            }
         }

         return field1346;
      }
   }
}
