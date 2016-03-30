import java.util.Random;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bs")
public class class71 {
   @ObfuscatedName("h")
   static int[] field1327;
   @ObfuscatedName("x")
   class57 field1328;
   @ObfuscatedName("u")
   int field1329 = 0;
   @ObfuscatedName("p")
   class57 field1330;
   @ObfuscatedName("e")
   class57 field1331;
   @ObfuscatedName("m")
   class57 field1333;
   @ObfuscatedName("n")
   static int[] field1334;
   @ObfuscatedName("v")
   int[] field1335 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("w")
   class57 field1336;
   @ObfuscatedName("z")
   int[] field1337 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("s")
   int field1338 = 0;
   @ObfuscatedName("j")
   int field1339 = 100;
   @ObfuscatedName("q")
   class63 field1340;
   @ObfuscatedName("a")
   class57 field1341;
   @ObfuscatedName("d")
   int field1342 = 500;
   @ObfuscatedName("t")
   class57 field1343;
   @ObfuscatedName("i")
   static int[] field1344;
   @ObfuscatedName("y")
   class57 field1345;
   @ObfuscatedName("g")
   static int[] field1346;
   @ObfuscatedName("l")
   int[] field1347 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("f")
   static int[] field1348;
   @ObfuscatedName("r")
   static int[] field1349;
   @ObfuscatedName("c")
   class57 field1350;
   @ObfuscatedName("o")
   static int[] field1351 = new int['耀'];
   @ObfuscatedName("b")
   static int[] field1352;

   @ObfuscatedName("t")
   final void method1567(class119 var1) {
      this.field1336 = new class57();
      this.field1336.method1242(var1);
      this.field1328 = new class57();
      this.field1328.method1242(var1);
      int var2 = var1.method2506();
      if(var2 != 0) {
         --var1.field2011;
         this.field1343 = new class57();
         this.field1343.method1242(var1);
         this.field1330 = new class57();
         this.field1330.method1242(var1);
      }

      var2 = var1.method2506();
      if(var2 != 0) {
         --var1.field2011;
         this.field1331 = new class57();
         this.field1331.method1242(var1);
         this.field1345 = new class57();
         this.field1345.method1242(var1);
      }

      var2 = var1.method2506();
      if(var2 != 0) {
         --var1.field2011;
         this.field1333 = new class57();
         this.field1333.method1242(var1);
         this.field1350 = new class57();
         this.field1350.method1242(var1);
      }

      for(int var3 = 0; var3 < 10; ++var3) {
         int var4 = var1.method2571();
         if(var4 == 0) {
            break;
         }

         this.field1335[var3] = var4;
         this.field1347[var3] = var1.method2518();
         this.field1337[var3] = var1.method2571();
      }

      this.field1338 = var1.method2571();
      this.field1339 = var1.method2571();
      this.field1342 = var1.method2508();
      this.field1329 = var1.method2508();
      this.field1340 = new class63();
      this.field1341 = new class57();
      this.field1340.method1307(var1, this.field1341);
   }

   @ObfuscatedName("w")
   final int[] method1568(int var1, int var2) {
      class120.method2707(field1344, 0, var1);
      if(var2 < 10) {
         return field1344;
      } else {
         double var3 = (double)var1 / ((double)var2 + 0.0D);
         this.field1336.method1244();
         this.field1328.method1244();
         int var5 = 0;
         int var6 = 0;
         int var7 = 0;
         if(this.field1343 != null) {
            this.field1343.method1244();
            this.field1330.method1244();
            var5 = (int)((double)(this.field1343.field1208 - this.field1343.field1207) * 32.768D / var3);
            var6 = (int)((double)this.field1343.field1207 * 32.768D / var3);
         }

         int var8 = 0;
         int var9 = 0;
         int var10 = 0;
         if(this.field1331 != null) {
            this.field1331.method1244();
            this.field1345.method1244();
            var8 = (int)((double)(this.field1331.field1208 - this.field1331.field1207) * 32.768D / var3);
            var9 = (int)((double)this.field1331.field1207 * 32.768D / var3);
         }

         int var11;
         for(var11 = 0; var11 < 5; ++var11) {
            if(this.field1335[var11] != 0) {
               field1348[var11] = 0;
               field1349[var11] = (int)((double)this.field1337[var11] * var3);
               field1334[var11] = (this.field1335[var11] << 14) / 100;
               field1346[var11] = (int)((double)(this.field1336.field1208 - this.field1336.field1207) * 32.768D * Math.pow(1.0057929410678534D, (double)this.field1347[var11]) / var3);
               field1352[var11] = (int)((double)this.field1336.field1207 * 32.768D / var3);
            }
         }

         int var12;
         int var13;
         int var14;
         int var15;
         for(var11 = 0; var11 < var1; ++var11) {
            var12 = this.field1336.method1246(var1);
            var13 = this.field1328.method1246(var1);
            if(this.field1343 != null) {
               var14 = this.field1343.method1246(var1);
               var15 = this.field1330.method1246(var1);
               var12 += this.method1569(var7, var15, this.field1343.field1209) >> 1;
               var7 += (var14 * var5 >> 16) + var6;
            }

            if(this.field1331 != null) {
               var14 = this.field1331.method1246(var1);
               var15 = this.field1345.method1246(var1);
               var13 = var13 * ((this.method1569(var10, var15, this.field1331.field1209) >> 1) + '耀') >> 15;
               var10 += (var14 * var8 >> 16) + var9;
            }

            for(var14 = 0; var14 < 5; ++var14) {
               if(this.field1335[var14] != 0) {
                  var15 = var11 + field1349[var14];
                  if(var15 < var1) {
                     field1344[var15] += this.method1569(field1348[var14], var13 * field1334[var14] >> 15, this.field1336.field1209);
                     field1348[var14] += (var12 * field1346[var14] >> 16) + field1352[var14];
                  }
               }
            }
         }

         int var16;
         if(this.field1333 != null) {
            this.field1333.method1244();
            this.field1350.method1244();
            var11 = 0;
            boolean var19 = false;
            boolean var20 = true;

            for(var14 = 0; var14 < var1; ++var14) {
               var15 = this.field1333.method1246(var1);
               var16 = this.field1350.method1246(var1);
               if(var20) {
                  var12 = this.field1333.field1207 + ((this.field1333.field1208 - this.field1333.field1207) * var15 >> 8);
               } else {
                  var12 = this.field1333.field1207 + ((this.field1333.field1208 - this.field1333.field1207) * var16 >> 8);
               }

               var11 += 256;
               if(var11 >= var12) {
                  var11 = 0;
                  var20 = !var20;
               }

               if(var20) {
                  field1344[var14] = 0;
               }
            }
         }

         if(this.field1338 > 0 && this.field1339 > 0) {
            var11 = (int)((double)this.field1338 * var3);

            for(var12 = var11; var12 < var1; ++var12) {
               field1344[var12] += field1344[var12 - var11] * this.field1339 / 100;
            }
         }

         if(this.field1340.field1242[0] > 0 || this.field1340.field1242[1] > 0) {
            this.field1341.method1244();
            var11 = this.field1341.method1246(var1 + 1);
            var12 = this.field1340.method1301(0, (float)var11 / 65536.0F);
            var13 = this.field1340.method1301(1, (float)var11 / 65536.0F);
            if(var1 >= var12 + var13) {
               var14 = 0;
               var15 = var13;
               if(var13 > var1 - var12) {
                  var15 = var1 - var12;
               }

               int var17;
               while(var14 < var15) {
                  var16 = (int)((long)field1344[var14 + var12] * (long)class63.field1249 >> 16);

                  for(var17 = 0; var17 < var12; ++var17) {
                     var16 += (int)((long)field1344[var14 + var12 - 1 - var17] * (long)class63.field1247[0][var17] >> 16);
                  }

                  for(var17 = 0; var17 < var14; ++var17) {
                     var16 -= (int)((long)field1344[var14 - 1 - var17] * (long)class63.field1247[1][var17] >> 16);
                  }

                  field1344[var14] = var16;
                  var11 = this.field1341.method1246(var1 + 1);
                  ++var14;
               }

               var15 = 128;

               while(true) {
                  if(var15 > var1 - var12) {
                     var15 = var1 - var12;
                  }

                  int var18;
                  while(var14 < var15) {
                     var17 = (int)((long)field1344[var14 + var12] * (long)class63.field1249 >> 16);

                     for(var18 = 0; var18 < var12; ++var18) {
                        var17 += (int)((long)field1344[var14 + var12 - 1 - var18] * (long)class63.field1247[0][var18] >> 16);
                     }

                     for(var18 = 0; var18 < var13; ++var18) {
                        var17 -= (int)((long)field1344[var14 - 1 - var18] * (long)class63.field1247[1][var18] >> 16);
                     }

                     field1344[var14] = var17;
                     var11 = this.field1341.method1246(var1 + 1);
                     ++var14;
                  }

                  if(var14 >= var1 - var12) {
                     while(var14 < var1) {
                        var17 = 0;

                        for(var18 = var14 + var12 - var1; var18 < var12; ++var18) {
                           var17 += (int)((long)field1344[var14 + var12 - 1 - var18] * (long)class63.field1247[0][var18] >> 16);
                        }

                        for(var18 = 0; var18 < var13; ++var18) {
                           var17 -= (int)((long)field1344[var14 - 1 - var18] * (long)class63.field1247[1][var18] >> 16);
                        }

                        field1344[var14] = var17;
                        this.field1341.method1246(var1 + 1);
                        ++var14;
                     }
                     break;
                  }

                  var12 = this.field1340.method1301(0, (float)var11 / 65536.0F);
                  var13 = this.field1340.method1301(1, (float)var11 / 65536.0F);
                  var15 += 128;
               }
            }
         }

         for(var11 = 0; var11 < var1; ++var11) {
            if(field1344[var11] < -32768) {
               field1344[var11] = -32768;
            }

            if(field1344[var11] > 32767) {
               field1344[var11] = 32767;
            }
         }

         return field1344;
      }
   }

   @ObfuscatedName("x")
   final int method1569(int var1, int var2, int var3) {
      return var3 == 1?((var1 & 32767) < 16384?var2:-var2):(var3 == 2?field1327[var1 & 32767] * var2 >> 14:(var3 == 3?((var1 & 32767) * var2 >> 14) - var2:(var3 == 4?field1351[var1 / 2607 & 32767] * var2:0)));
   }

   static {
      Random var0 = new Random(0L);

      int var1;
      for(var1 = 0; var1 < '耀'; ++var1) {
         field1351[var1] = (var0.nextInt() & 2) - 1;
      }

      field1327 = new int['耀'];

      for(var1 = 0; var1 < '耀'; ++var1) {
         field1327[var1] = (int)(Math.sin((double)var1 / 5215.1903D) * 16384.0D);
      }

      field1344 = new int[220500];
      field1348 = new int[5];
      field1349 = new int[5];
      field1334 = new int[5];
      field1346 = new int[5];
      field1352 = new int[5];
   }
}
