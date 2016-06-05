import java.util.Random;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("be")
public class class71 {
   @ObfuscatedName("u")
   static int[] field1325;
   @ObfuscatedName("r")
   class57 field1326;
   @ObfuscatedName("x")
   static int[] field1327;
   @ObfuscatedName("h")
   class57 field1328;
   @ObfuscatedName("z")
   class57 field1329;
   @ObfuscatedName("w")
   static int[] field1330;
   @ObfuscatedName("e")
   static int[] field1331;
   @ObfuscatedName("o")
   class63 field1332;
   @ObfuscatedName("i")
   class57 field1333;
   @ObfuscatedName("l")
   int[] field1334 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("y")
   int[] field1335 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("p")
   int field1336 = 0;
   @ObfuscatedName("k")
   int field1337 = 100;
   @ObfuscatedName("v")
   static int[] field1338;
   @ObfuscatedName("b")
   class57 field1339;
   @ObfuscatedName("j")
   int field1340 = 500;
   @ObfuscatedName("d")
   int[] field1341 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("a")
   int field1342 = 0;
   @ObfuscatedName("c")
   static int[] field1343 = new int['耀'];
   @ObfuscatedName("n")
   static int[] field1344;
   @ObfuscatedName("f")
   class57 field1346;
   @ObfuscatedName("t")
   class57 field1347;
   @ObfuscatedName("m")
   static int[] field1348;
   @ObfuscatedName("s")
   class57 field1349;
   @ObfuscatedName("g")
   class57 field1350;

   @ObfuscatedName("g")
   final void method1518(class119 var1) {
      this.field1347 = new class57();
      this.field1347.method1190(var1);
      this.field1333 = new class57();
      this.field1333.method1190(var1);
      int var2 = var1.method2494();
      if(var2 != 0) {
         --var1.field2000;
         this.field1350 = new class57();
         this.field1350.method1190(var1);
         this.field1328 = new class57();
         this.field1328.method1190(var1);
      }

      var2 = var1.method2494();
      if(var2 != 0) {
         --var1.field2000;
         this.field1329 = new class57();
         this.field1329.method1190(var1);
         this.field1326 = new class57();
         this.field1326.method1190(var1);
      }

      var2 = var1.method2494();
      if(var2 != 0) {
         --var1.field2000;
         this.field1346 = new class57();
         this.field1346.method1190(var1);
         this.field1349 = new class57();
         this.field1349.method1190(var1);
      }

      for(int var3 = 0; var3 < 10; ++var3) {
         int var4 = var1.method2481();
         if(var4 == 0) {
            break;
         }

         this.field1341[var3] = var4;
         this.field1334[var3] = var1.method2565();
         this.field1335[var3] = var1.method2481();
      }

      this.field1336 = var1.method2481();
      this.field1337 = var1.method2481();
      this.field1340 = var1.method2470();
      this.field1342 = var1.method2470();
      this.field1332 = new class63();
      this.field1339 = new class57();
      this.field1332.method1247(var1, this.field1339);
   }

   static {
      Random var0 = new Random(0L);

      int var1;
      for(var1 = 0; var1 < '耀'; ++var1) {
         field1343[var1] = (var0.nextInt() & 2) - 1;
      }

      field1344 = new int['耀'];

      for(var1 = 0; var1 < '耀'; ++var1) {
         field1344[var1] = (int)(Math.sin((double)var1 / 5215.1903D) * 16384.0D);
      }

      field1325 = new int[220500];
      field1327 = new int[5];
      field1338 = new int[5];
      field1348 = new int[5];
      field1330 = new int[5];
      field1331 = new int[5];
   }

   @ObfuscatedName("i")
   final int method1520(int var1, int var2, int var3) {
      return var3 == 1?((var1 & 32767) < 16384?var2:-var2):(var3 == 2?field1344[var1 & 32767] * var2 >> 14:(var3 == 3?((var1 & 32767) * var2 >> 14) - var2:(var3 == 4?field1343[var1 / 2607 & 32767] * var2:0)));
   }

   @ObfuscatedName("t")
   final int[] method1522(int var1, int var2) {
      class120.method2693(field1325, 0, var1);
      if(var2 < 10) {
         return field1325;
      } else {
         double var3 = (double)var1 / ((double)var2 + 0.0D);
         this.field1347.method1192();
         this.field1333.method1192();
         int var5 = 0;
         int var6 = 0;
         int var7 = 0;
         if(this.field1350 != null) {
            this.field1350.method1192();
            this.field1328.method1192();
            var5 = (int)((double)(this.field1350.field1209 - this.field1350.field1211) * 32.768D / var3);
            var6 = (int)((double)this.field1350.field1211 * 32.768D / var3);
         }

         int var8 = 0;
         int var9 = 0;
         int var10 = 0;
         if(this.field1329 != null) {
            this.field1329.method1192();
            this.field1326.method1192();
            var8 = (int)((double)(this.field1329.field1209 - this.field1329.field1211) * 32.768D / var3);
            var9 = (int)((double)this.field1329.field1211 * 32.768D / var3);
         }

         int var11;
         for(var11 = 0; var11 < 5; ++var11) {
            if(this.field1341[var11] != 0) {
               field1327[var11] = 0;
               field1338[var11] = (int)((double)this.field1335[var11] * var3);
               field1348[var11] = (this.field1341[var11] << 14) / 100;
               field1330[var11] = (int)((double)(this.field1347.field1209 - this.field1347.field1211) * 32.768D * Math.pow(1.0057929410678534D, (double)this.field1334[var11]) / var3);
               field1331[var11] = (int)((double)this.field1347.field1211 * 32.768D / var3);
            }
         }

         int var12;
         int var13;
         int var14;
         int var15;
         for(var11 = 0; var11 < var1; ++var11) {
            var12 = this.field1347.method1193(var1);
            var13 = this.field1333.method1193(var1);
            if(this.field1350 != null) {
               var14 = this.field1350.method1193(var1);
               var15 = this.field1328.method1193(var1);
               var12 += this.method1520(var7, var15, this.field1350.field1210) >> 1;
               var7 += (var14 * var5 >> 16) + var6;
            }

            if(this.field1329 != null) {
               var14 = this.field1329.method1193(var1);
               var15 = this.field1326.method1193(var1);
               var13 = var13 * ((this.method1520(var10, var15, this.field1329.field1210) >> 1) + '耀') >> 15;
               var10 += (var14 * var8 >> 16) + var9;
            }

            for(var14 = 0; var14 < 5; ++var14) {
               if(this.field1341[var14] != 0) {
                  var15 = var11 + field1338[var14];
                  if(var15 < var1) {
                     field1325[var15] += this.method1520(field1327[var14], var13 * field1348[var14] >> 15, this.field1347.field1210);
                     field1327[var14] += (var12 * field1330[var14] >> 16) + field1331[var14];
                  }
               }
            }
         }

         int var16;
         if(this.field1346 != null) {
            this.field1346.method1192();
            this.field1349.method1192();
            var11 = 0;
            boolean var19 = false;
            boolean var20 = true;

            for(var14 = 0; var14 < var1; ++var14) {
               var15 = this.field1346.method1193(var1);
               var16 = this.field1349.method1193(var1);
               if(var20) {
                  var12 = this.field1346.field1211 + ((this.field1346.field1209 - this.field1346.field1211) * var15 >> 8);
               } else {
                  var12 = this.field1346.field1211 + ((this.field1346.field1209 - this.field1346.field1211) * var16 >> 8);
               }

               var11 += 256;
               if(var11 >= var12) {
                  var11 = 0;
                  var20 = !var20;
               }

               if(var20) {
                  field1325[var14] = 0;
               }
            }
         }

         if(this.field1336 > 0 && this.field1337 > 0) {
            var11 = (int)((double)this.field1336 * var3);

            for(var12 = var11; var12 < var1; ++var12) {
               field1325[var12] += field1325[var12 - var11] * this.field1337 / 100;
            }
         }

         if(this.field1332.field1240[0] > 0 || this.field1332.field1240[1] > 0) {
            this.field1339.method1192();
            var11 = this.field1339.method1193(var1 + 1);
            var12 = this.field1332.method1246(0, (float)var11 / 65536.0F);
            var13 = this.field1332.method1246(1, (float)var11 / 65536.0F);
            if(var1 >= var12 + var13) {
               var14 = 0;
               var15 = var13;
               if(var13 > var1 - var12) {
                  var15 = var1 - var12;
               }

               int var17;
               while(var14 < var15) {
                  var16 = (int)((long)field1325[var14 + var12] * (long)class63.field1248 >> 16);

                  for(var17 = 0; var17 < var12; ++var17) {
                     var16 += (int)((long)field1325[var14 + var12 - 1 - var17] * (long)class63.field1245[0][var17] >> 16);
                  }

                  for(var17 = 0; var17 < var14; ++var17) {
                     var16 -= (int)((long)field1325[var14 - 1 - var17] * (long)class63.field1245[1][var17] >> 16);
                  }

                  field1325[var14] = var16;
                  var11 = this.field1339.method1193(var1 + 1);
                  ++var14;
               }

               var15 = 128;

               while(true) {
                  if(var15 > var1 - var12) {
                     var15 = var1 - var12;
                  }

                  int var18;
                  while(var14 < var15) {
                     var17 = (int)((long)field1325[var14 + var12] * (long)class63.field1248 >> 16);

                     for(var18 = 0; var18 < var12; ++var18) {
                        var17 += (int)((long)field1325[var14 + var12 - 1 - var18] * (long)class63.field1245[0][var18] >> 16);
                     }

                     for(var18 = 0; var18 < var13; ++var18) {
                        var17 -= (int)((long)field1325[var14 - 1 - var18] * (long)class63.field1245[1][var18] >> 16);
                     }

                     field1325[var14] = var17;
                     var11 = this.field1339.method1193(var1 + 1);
                     ++var14;
                  }

                  if(var14 >= var1 - var12) {
                     while(var14 < var1) {
                        var17 = 0;

                        for(var18 = var14 + var12 - var1; var18 < var12; ++var18) {
                           var17 += (int)((long)field1325[var14 + var12 - 1 - var18] * (long)class63.field1245[0][var18] >> 16);
                        }

                        for(var18 = 0; var18 < var13; ++var18) {
                           var17 -= (int)((long)field1325[var14 - 1 - var18] * (long)class63.field1245[1][var18] >> 16);
                        }

                        field1325[var14] = var17;
                        this.field1339.method1193(var1 + 1);
                        ++var14;
                     }
                     break;
                  }

                  var12 = this.field1332.method1246(0, (float)var11 / 65536.0F);
                  var13 = this.field1332.method1246(1, (float)var11 / 65536.0F);
                  var15 += 128;
               }
            }
         }

         for(var11 = 0; var11 < var1; ++var11) {
            if(field1325[var11] < -32768) {
               field1325[var11] = -32768;
            }

            if(field1325[var11] > 32767) {
               field1325[var11] = 32767;
            }
         }

         return field1325;
      }
   }
}
