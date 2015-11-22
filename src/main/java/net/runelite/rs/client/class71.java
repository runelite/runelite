package net.runelite.rs.client;

import java.util.Random;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bz")
public class class71 {
   @ObfuscatedName("v")
   static int[] field1309;
   @ObfuscatedName("m")
   class57 field1310;
   @ObfuscatedName("f")
   class57 field1311;
   @ObfuscatedName("s")
   int[] field1312 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("n")
   static int[] field1313;
   @ObfuscatedName("a")
   class57 field1314;
   @ObfuscatedName("h")
   class57 field1315;
   @ObfuscatedName("x")
   static int[] field1316;
   @ObfuscatedName("t")
   int[] field1317 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("k")
   int[] field1318 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("u")
   class57 field1319;
   @ObfuscatedName("w")
   int field1320 = 0;
   @ObfuscatedName("e")
   int field1321 = 100;
   @ObfuscatedName("l")
   class57 field1322;
   @ObfuscatedName("p")
   class57 field1323;
   @ObfuscatedName("r")
   int field1324 = 500;
   @ObfuscatedName("g")
   int field1325 = 0;
   @ObfuscatedName("j")
   class57 field1326;
   @ObfuscatedName("z")
   class63 field1327;
   @ObfuscatedName("i")
   class57 field1328;
   @ObfuscatedName("c")
   static int[] field1330;
   @ObfuscatedName("d")
   static int[] field1331;
   @ObfuscatedName("o")
   static int[] field1332;
   @ObfuscatedName("y")
   static int[] field1333 = new int['耀'];
   @ObfuscatedName("b")
   static int[] field1334;

   @ObfuscatedName("j")
   final int[] method1583(int var1, int var2) {
      class119.method2749(field1313, 0, var1);
      if(var2 < 10) {
         return field1313;
      } else {
         double var3 = (double)var1 / ((double)var2 + 0.0D);
         this.field1326.method1273();
         this.field1310.method1273();
         int var5 = 0;
         int var6 = 0;
         int var7 = 0;
         if(this.field1311 != null) {
            this.field1311.method1273();
            this.field1322.method1273();
            var5 = (int)((double)(this.field1311.field1184 - this.field1311.field1187) * 32.768D / var3);
            var6 = (int)((double)this.field1311.field1187 * 32.768D / var3);
         }

         int var8 = 0;
         int var9 = 0;
         int var10 = 0;
         if(this.field1319 != null) {
            this.field1319.method1273();
            this.field1314.method1273();
            var8 = (int)((double)(this.field1319.field1184 - this.field1319.field1187) * 32.768D / var3);
            var9 = (int)((double)this.field1319.field1187 * 32.768D / var3);
         }

         int var11;
         for(var11 = 0; var11 < 5; ++var11) {
            if(this.field1317[var11] != 0) {
               field1316[var11] = 0;
               field1331[var11] = (int)((double)this.field1312[var11] * var3);
               field1332[var11] = (this.field1317[var11] << 14) / 100;
               field1330[var11] = (int)((double)(this.field1326.field1184 - this.field1326.field1187) * 32.768D * Math.pow(1.0057929410678534D, (double)this.field1318[var11]) / var3);
               field1334[var11] = (int)((double)this.field1326.field1187 * 32.768D / var3);
            }
         }

         int var12;
         int var13;
         int var14;
         int var15;
         for(var11 = 0; var11 < var1; ++var11) {
            var12 = this.field1326.method1278(var1);
            var13 = this.field1310.method1278(var1);
            if(this.field1311 != null) {
               var14 = this.field1311.method1278(var1);
               var15 = this.field1322.method1278(var1);
               var12 += this.method1584(var7, var15, this.field1311.field1189) >> 1;
               var7 += (var14 * var5 >> 16) + var6;
            }

            if(this.field1319 != null) {
               var14 = this.field1319.method1278(var1);
               var15 = this.field1314.method1278(var1);
               var13 = var13 * ((this.method1584(var10, var15, this.field1319.field1189) >> 1) + '耀') >> 15;
               var10 += (var14 * var8 >> 16) + var9;
            }

            for(var14 = 0; var14 < 5; ++var14) {
               if(this.field1317[var14] != 0) {
                  var15 = var11 + field1331[var14];
                  if(var15 < var1) {
                     field1313[var15] += this.method1584(field1316[var14], var13 * field1332[var14] >> 15, this.field1326.field1189);
                     field1316[var14] += (var12 * field1330[var14] >> 16) + field1334[var14];
                  }
               }
            }
         }

         int var16;
         if(this.field1315 != null) {
            this.field1315.method1273();
            this.field1328.method1273();
            var11 = 0;
            boolean var19 = false;
            boolean var20 = true;

            for(var14 = 0; var14 < var1; ++var14) {
               var15 = this.field1315.method1278(var1);
               var16 = this.field1328.method1278(var1);
               if(var20) {
                  var12 = this.field1315.field1187 + ((this.field1315.field1184 - this.field1315.field1187) * var15 >> 8);
               } else {
                  var12 = this.field1315.field1187 + ((this.field1315.field1184 - this.field1315.field1187) * var16 >> 8);
               }

               var11 += 256;
               if(var11 >= var12) {
                  var11 = 0;
                  var20 = !var20;
               }

               if(var20) {
                  field1313[var14] = 0;
               }
            }
         }

         if(this.field1320 > 0 && this.field1321 > 0) {
            var11 = (int)((double)this.field1320 * var3);

            for(var12 = var11; var12 < var1; ++var12) {
               field1313[var12] += field1313[var12 - var11] * this.field1321 / 100;
            }
         }

         if(this.field1327.field1226[0] > 0 || this.field1327.field1226[1] > 0) {
            this.field1323.method1273();
            var11 = this.field1323.method1278(var1 + 1);
            var12 = this.field1327.method1335(0, (float)var11 / 65536.0F);
            var13 = this.field1327.method1335(1, (float)var11 / 65536.0F);
            if(var1 >= var12 + var13) {
               var14 = 0;
               var15 = var13;
               if(var13 > var1 - var12) {
                  var15 = var1 - var12;
               }

               int var17;
               while(var14 < var15) {
                  var16 = (int)((long)field1313[var14 + var12] * (long)class63.field1231 >> 16);

                  for(var17 = 0; var17 < var12; ++var17) {
                     var16 += (int)((long)field1313[var14 + var12 - 1 - var17] * (long)class63.field1233[0][var17] >> 16);
                  }

                  for(var17 = 0; var17 < var14; ++var17) {
                     var16 -= (int)((long)field1313[var14 - 1 - var17] * (long)class63.field1233[1][var17] >> 16);
                  }

                  field1313[var14] = var16;
                  var11 = this.field1323.method1278(var1 + 1);
                  ++var14;
               }

               var15 = 128;

               while(true) {
                  if(var15 > var1 - var12) {
                     var15 = var1 - var12;
                  }

                  int var18;
                  while(var14 < var15) {
                     var17 = (int)((long)field1313[var14 + var12] * (long)class63.field1231 >> 16);

                     for(var18 = 0; var18 < var12; ++var18) {
                        var17 += (int)((long)field1313[var14 + var12 - 1 - var18] * (long)class63.field1233[0][var18] >> 16);
                     }

                     for(var18 = 0; var18 < var13; ++var18) {
                        var17 -= (int)((long)field1313[var14 - 1 - var18] * (long)class63.field1233[1][var18] >> 16);
                     }

                     field1313[var14] = var17;
                     var11 = this.field1323.method1278(var1 + 1);
                     ++var14;
                  }

                  if(var14 >= var1 - var12) {
                     while(var14 < var1) {
                        var17 = 0;

                        for(var18 = var14 + var12 - var1; var18 < var12; ++var18) {
                           var17 += (int)((long)field1313[var14 + var12 - 1 - var18] * (long)class63.field1233[0][var18] >> 16);
                        }

                        for(var18 = 0; var18 < var13; ++var18) {
                           var17 -= (int)((long)field1313[var14 - 1 - var18] * (long)class63.field1233[1][var18] >> 16);
                        }

                        field1313[var14] = var17;
                        this.field1323.method1278(var1 + 1);
                        ++var14;
                     }
                     break;
                  }

                  var12 = this.field1327.method1335(0, (float)var11 / 65536.0F);
                  var13 = this.field1327.method1335(1, (float)var11 / 65536.0F);
                  var15 += 128;
               }
            }
         }

         for(var11 = 0; var11 < var1; ++var11) {
            if(field1313[var11] < -32768) {
               field1313[var11] = -32768;
            }

            if(field1313[var11] > 32767) {
               field1313[var11] = 32767;
            }
         }

         return field1313;
      }
   }

   @ObfuscatedName("m")
   final int method1584(int var1, int var2, int var3) {
      return var3 == 1?((var1 & 32767) < 16384?var2:-var2):(var3 == 2?field1309[var1 & 32767] * var2 >> 14:(var3 == 3?((var1 & 32767) * var2 >> 14) - var2:(var3 == 4?field1333[var1 / 2607 & 32767] * var2:0)));
   }

   static {
      Random var0 = new Random(0L);

      int var1;
      for(var1 = 0; var1 < '耀'; ++var1) {
         field1333[var1] = (var0.nextInt() & 2) - 1;
      }

      field1309 = new int['耀'];

      for(var1 = 0; var1 < '耀'; ++var1) {
         field1309[var1] = (int)(Math.sin((double)var1 / 5215.1903D) * 16384.0D);
      }

      field1313 = new int[220500];
      field1316 = new int[5];
      field1331 = new int[5];
      field1332 = new int[5];
      field1330 = new int[5];
      field1334 = new int[5];
   }

   @ObfuscatedName("f")
   final void method1588(class118 var1) {
      this.field1326 = new class57();
      this.field1326.method1271(var1);
      this.field1310 = new class57();
      this.field1310.method1271(var1);
      int var2 = var1.method2536();
      if(var2 != 0) {
         --var1.field1981;
         this.field1311 = new class57();
         this.field1311.method1271(var1);
         this.field1322 = new class57();
         this.field1322.method1271(var1);
      }

      var2 = var1.method2536();
      if(var2 != 0) {
         --var1.field1981;
         this.field1319 = new class57();
         this.field1319.method1271(var1);
         this.field1314 = new class57();
         this.field1314.method1271(var1);
      }

      var2 = var1.method2536();
      if(var2 != 0) {
         --var1.field1981;
         this.field1315 = new class57();
         this.field1315.method1271(var1);
         this.field1328 = new class57();
         this.field1328.method1271(var1);
      }

      for(int var3 = 0; var3 < 10; ++var3) {
         int var4 = var1.method2548();
         if(var4 == 0) {
            break;
         }

         this.field1317[var3] = var4;
         this.field1318[var3] = var1.method2666();
         this.field1312[var3] = var1.method2548();
      }

      this.field1320 = var1.method2548();
      this.field1321 = var1.method2548();
      this.field1324 = var1.method2538();
      this.field1325 = var1.method2538();
      this.field1327 = new class63();
      this.field1323 = new class57();
      this.field1327.method1326(var1, this.field1323);
   }
}
