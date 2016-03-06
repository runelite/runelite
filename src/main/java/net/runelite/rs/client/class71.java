package net.runelite.rs.client;
import java.util.Random;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("by")
public class class71 {
   @ObfuscatedName("k")
   int[] field1329 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("l")
   class57 field1330;
   @ObfuscatedName("u")
   class63 field1331;
   @ObfuscatedName("i")
   class57 field1332;
   @ObfuscatedName("f")
   class57 field1333;
   @ObfuscatedName("m")
   class57 field1334;
   @ObfuscatedName("x")
   static int[] field1335;
   @ObfuscatedName("h")
   class57 field1336;
   @ObfuscatedName("n")
   int[] field1337 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("a")
   class57 field1338;
   @ObfuscatedName("r")
   int[] field1339 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("b")
   int field1340 = 0;
   @ObfuscatedName("o")
   class57 field1341;
   @ObfuscatedName("p")
   static int[] field1342;
   @ObfuscatedName("t")
   static int[] field1343;
   @ObfuscatedName("y")
   int field1344 = 500;
   @ObfuscatedName("g")
   class57 field1345;
   @ObfuscatedName("d")
   static int[] field1346;
   @ObfuscatedName("z")
   static int[] field1347 = new int['耀'];
   @ObfuscatedName("j")
   class57 field1348;
   @ObfuscatedName("s")
   int field1350 = 0;
   @ObfuscatedName("c")
   static int[] field1351;
   @ObfuscatedName("v")
   static int[] field1352;
   @ObfuscatedName("e")
   static int[] field1353;
   @ObfuscatedName("q")
   int field1354 = 100;

   @ObfuscatedName("j")
   final int[] method1555(int var1, int var2) {
      class119.method2676(field1346, 0, var1);
      if(var2 < 10) {
         return field1346;
      } else {
         double var3 = (double)var1 / ((double)var2 + 0.0D);
         this.field1348.method1227();
         this.field1330.method1227();
         int var5 = 0;
         int var6 = 0;
         int var7 = 0;
         if(this.field1338 != null) {
            this.field1338.method1227();
            this.field1332.method1227();
            var5 = (int)((double)(this.field1338.field1209 - this.field1338.field1208) * 32.768D / var3);
            var6 = (int)((double)this.field1338.field1208 * 32.768D / var3);
         }

         int var8 = 0;
         int var9 = 0;
         int var10 = 0;
         if(this.field1333 != null) {
            this.field1333.method1227();
            this.field1334.method1227();
            var8 = (int)((double)(this.field1333.field1209 - this.field1333.field1208) * 32.768D / var3);
            var9 = (int)((double)this.field1333.field1208 * 32.768D / var3);
         }

         int var11;
         for(var11 = 0; var11 < 5; ++var11) {
            if(this.field1337[var11] != 0) {
               field1343[var11] = 0;
               field1351[var11] = (int)((double)this.field1339[var11] * var3);
               field1335[var11] = (this.field1337[var11] << 14) / 100;
               field1353[var11] = (int)((double)(this.field1348.field1209 - this.field1348.field1208) * 32.768D * Math.pow(1.0057929410678534D, (double)this.field1329[var11]) / var3);
               field1352[var11] = (int)((double)this.field1348.field1208 * 32.768D / var3);
            }
         }

         int var12;
         int var13;
         int var14;
         int var15;
         for(var11 = 0; var11 < var1; ++var11) {
            var12 = this.field1348.method1228(var1);
            var13 = this.field1330.method1228(var1);
            if(this.field1338 != null) {
               var14 = this.field1338.method1228(var1);
               var15 = this.field1332.method1228(var1);
               var12 += this.method1556(var7, var15, this.field1338.field1210) >> 1;
               var7 += (var14 * var5 >> 16) + var6;
            }

            if(this.field1333 != null) {
               var14 = this.field1333.method1228(var1);
               var15 = this.field1334.method1228(var1);
               var13 = var13 * ((this.method1556(var10, var15, this.field1333.field1210) >> 1) + '耀') >> 15;
               var10 += (var14 * var8 >> 16) + var9;
            }

            for(var14 = 0; var14 < 5; ++var14) {
               if(this.field1337[var14] != 0) {
                  var15 = var11 + field1351[var14];
                  if(var15 < var1) {
                     field1346[var15] += this.method1556(field1343[var14], var13 * field1335[var14] >> 15, this.field1348.field1210);
                     field1343[var14] += (var12 * field1353[var14] >> 16) + field1352[var14];
                  }
               }
            }
         }

         int var16;
         if(this.field1341 != null) {
            this.field1341.method1227();
            this.field1336.method1227();
            var11 = 0;
            boolean var19 = false;
            boolean var20 = true;

            for(var14 = 0; var14 < var1; ++var14) {
               var15 = this.field1341.method1228(var1);
               var16 = this.field1336.method1228(var1);
               if(var20) {
                  var12 = this.field1341.field1208 + ((this.field1341.field1209 - this.field1341.field1208) * var15 >> 8);
               } else {
                  var12 = this.field1341.field1208 + ((this.field1341.field1209 - this.field1341.field1208) * var16 >> 8);
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

         if(this.field1340 > 0 && this.field1354 > 0) {
            var11 = (int)((double)this.field1340 * var3);

            for(var12 = var11; var12 < var1; ++var12) {
               field1346[var12] += field1346[var12 - var11] * this.field1354 / 100;
            }
         }

         if(this.field1331.field1254[0] > 0 || this.field1331.field1254[1] > 0) {
            this.field1345.method1227();
            var11 = this.field1345.method1228(var1 + 1);
            var12 = this.field1331.method1290(0, (float)var11 / 65536.0F);
            var13 = this.field1331.method1290(1, (float)var11 / 65536.0F);
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
                  var11 = this.field1345.method1228(var1 + 1);
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
                     var11 = this.field1345.method1228(var1 + 1);
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
                        this.field1345.method1228(var1 + 1);
                        ++var14;
                     }
                     break;
                  }

                  var12 = this.field1331.method1290(0, (float)var11 / 65536.0F);
                  var13 = this.field1331.method1290(1, (float)var11 / 65536.0F);
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

   @ObfuscatedName("l")
   final int method1556(int var1, int var2, int var3) {
      return var3 == 1?((var1 & 32767) < 16384?var2:-var2):(var3 == 2?field1342[var1 & 32767] * var2 >> 14:(var3 == 3?((var1 & 32767) * var2 >> 14) - var2:(var3 == 4?field1347[var1 / 2607 & 32767] * var2:0)));
   }

   @ObfuscatedName("a")
   final void method1557(class118 var1) {
      this.field1348 = new class57();
      this.field1348.method1225(var1);
      this.field1330 = new class57();
      this.field1330.method1225(var1);
      int var2 = var1.method2453();
      if(var2 != 0) {
         --var1.field1998;
         this.field1338 = new class57();
         this.field1338.method1225(var1);
         this.field1332 = new class57();
         this.field1332.method1225(var1);
      }

      var2 = var1.method2453();
      if(var2 != 0) {
         --var1.field1998;
         this.field1333 = new class57();
         this.field1333.method1225(var1);
         this.field1334 = new class57();
         this.field1334.method1225(var1);
      }

      var2 = var1.method2453();
      if(var2 != 0) {
         --var1.field1998;
         this.field1341 = new class57();
         this.field1341.method1225(var1);
         this.field1336 = new class57();
         this.field1336.method1225(var1);
      }

      for(int var3 = 0; var3 < 10; ++var3) {
         int var4 = var1.method2466();
         if(var4 == 0) {
            break;
         }

         this.field1337[var3] = var4;
         this.field1329[var3] = var1.method2465();
         this.field1339[var3] = var1.method2466();
      }

      this.field1340 = var1.method2466();
      this.field1354 = var1.method2466();
      this.field1344 = var1.method2455();
      this.field1350 = var1.method2455();
      this.field1331 = new class63();
      this.field1345 = new class57();
      this.field1331.method1287(var1, this.field1345);
   }

   static {
      Random var0 = new Random(0L);

      int var1;
      for(var1 = 0; var1 < '耀'; ++var1) {
         field1347[var1] = (var0.nextInt() & 2) - 1;
      }

      field1342 = new int['耀'];

      for(var1 = 0; var1 < '耀'; ++var1) {
         field1342[var1] = (int)(Math.sin((double)var1 / 5215.1903D) * 16384.0D);
      }

      field1346 = new int[220500];
      field1343 = new int[5];
      field1351 = new int[5];
      field1335 = new int[5];
      field1353 = new int[5];
      field1352 = new int[5];
   }
}
