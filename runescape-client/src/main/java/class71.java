import java.util.Random;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bu")
public class class71 {
   @ObfuscatedName("r")
   class63 field1327;
   @ObfuscatedName("j")
   class57 field1328;
   @ObfuscatedName("p")
   class57 field1329;
   @ObfuscatedName("k")
   int[] field1330 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("b")
   class57 field1331;
   @ObfuscatedName("w")
   static int[] field1332;
   @ObfuscatedName("o")
   class57 field1333;
   @ObfuscatedName("c")
   int[] field1334 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("f")
   static int[] field1335;
   @ObfuscatedName("y")
   static int[] field1336;
   @ObfuscatedName("d")
   class57 field1337;
   @ObfuscatedName("u")
   class57 field1338;
   @ObfuscatedName("x")
   class57 field1339;
   @ObfuscatedName("i")
   int field1340 = 100;
   @ObfuscatedName("m")
   class57 field1341;
   @ObfuscatedName("e")
   int field1342 = 500;
   @ObfuscatedName("h")
   int field1343 = 0;
   @ObfuscatedName("z")
   static int[] field1344;
   @ObfuscatedName("a")
   static int[] field1345 = new int['耀'];
   @ObfuscatedName("l")
   int[] field1347 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("s")
   class57 field1348;
   @ObfuscatedName("t")
   int field1349 = 0;
   @ObfuscatedName("q")
   static int[] field1350;
   @ObfuscatedName("n")
   static int[] field1351;
   @ObfuscatedName("v")
   static int[] field1352;

   @ObfuscatedName("s")
   final int[] method1538(int var1, int var2) {
      class120.method2717(field1344, 0, var1);
      if(var2 < 10) {
         return field1344;
      } else {
         double var3 = (double)var1 / ((double)var2 + 0.0D);
         this.field1348.method1210();
         this.field1328.method1210();
         int var5 = 0;
         int var6 = 0;
         int var7 = 0;
         if(this.field1329 != null) {
            this.field1329.method1210();
            this.field1339.method1210();
            var5 = (int)((double)(this.field1329.field1209 - this.field1329.field1208) * 32.768D / var3);
            var6 = (int)((double)this.field1329.field1208 * 32.768D / var3);
         }

         int var8 = 0;
         int var9 = 0;
         int var10 = 0;
         if(this.field1337 != null) {
            this.field1337.method1210();
            this.field1338.method1210();
            var8 = (int)((double)(this.field1337.field1209 - this.field1337.field1208) * 32.768D / var3);
            var9 = (int)((double)this.field1337.field1208 * 32.768D / var3);
         }

         int var11;
         for(var11 = 0; var11 < 5; ++var11) {
            if(this.field1330[var11] != 0) {
               field1336[var11] = 0;
               field1335[var11] = (int)((double)this.field1347[var11] * var3);
               field1350[var11] = (this.field1330[var11] << 14) / 100;
               field1351[var11] = (int)((double)(this.field1348.field1209 - this.field1348.field1208) * 32.768D * Math.pow(1.0057929410678534D, (double)this.field1334[var11]) / var3);
               field1352[var11] = (int)((double)this.field1348.field1208 * 32.768D / var3);
            }
         }

         int var12;
         int var13;
         int var14;
         int var15;
         for(var11 = 0; var11 < var1; ++var11) {
            var12 = this.field1348.method1211(var1);
            var13 = this.field1328.method1211(var1);
            if(this.field1329 != null) {
               var14 = this.field1329.method1211(var1);
               var15 = this.field1339.method1211(var1);
               var12 += this.method1540(var7, var15, this.field1329.field1206) >> 1;
               var7 += (var14 * var5 >> 16) + var6;
            }

            if(this.field1337 != null) {
               var14 = this.field1337.method1211(var1);
               var15 = this.field1338.method1211(var1);
               var13 = var13 * ((this.method1540(var10, var15, this.field1337.field1206) >> 1) + '耀') >> 15;
               var10 += (var14 * var8 >> 16) + var9;
            }

            for(var14 = 0; var14 < 5; ++var14) {
               if(this.field1330[var14] != 0) {
                  var15 = var11 + field1335[var14];
                  if(var15 < var1) {
                     field1344[var15] += this.method1540(field1336[var14], var13 * field1350[var14] >> 15, this.field1348.field1206);
                     field1336[var14] += (var12 * field1351[var14] >> 16) + field1352[var14];
                  }
               }
            }
         }

         int var16;
         if(this.field1333 != null) {
            this.field1333.method1210();
            this.field1331.method1210();
            var11 = 0;
            boolean var19 = false;
            boolean var20 = true;

            for(var14 = 0; var14 < var1; ++var14) {
               var15 = this.field1333.method1211(var1);
               var16 = this.field1331.method1211(var1);
               if(var20) {
                  var12 = this.field1333.field1208 + ((this.field1333.field1209 - this.field1333.field1208) * var15 >> 8);
               } else {
                  var12 = this.field1333.field1208 + ((this.field1333.field1209 - this.field1333.field1208) * var16 >> 8);
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

         if(this.field1349 > 0 && this.field1340 > 0) {
            var11 = (int)((double)this.field1349 * var3);

            for(var12 = var11; var12 < var1; ++var12) {
               field1344[var12] += field1344[var12 - var11] * this.field1340 / 100;
            }
         }

         if(this.field1327.field1243[0] > 0 || this.field1327.field1243[1] > 0) {
            this.field1341.method1210();
            var11 = this.field1341.method1211(var1 + 1);
            var12 = this.field1327.method1261(0, (float)var11 / 65536.0F);
            var13 = this.field1327.method1261(1, (float)var11 / 65536.0F);
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
                  var11 = this.field1341.method1211(var1 + 1);
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
                     var11 = this.field1341.method1211(var1 + 1);
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
                        this.field1341.method1211(var1 + 1);
                        ++var14;
                     }
                     break;
                  }

                  var12 = this.field1327.method1261(0, (float)var11 / 65536.0F);
                  var13 = this.field1327.method1261(1, (float)var11 / 65536.0F);
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

   @ObfuscatedName("p")
   final void method1539(class119 var1) {
      this.field1348 = new class57();
      this.field1348.method1208(var1);
      this.field1328 = new class57();
      this.field1328.method1208(var1);
      int var2 = var1.method2492();
      if(var2 != 0) {
         --var1.field2005;
         this.field1329 = new class57();
         this.field1329.method1208(var1);
         this.field1339 = new class57();
         this.field1339.method1208(var1);
      }

      var2 = var1.method2492();
      if(var2 != 0) {
         --var1.field2005;
         this.field1337 = new class57();
         this.field1337.method1208(var1);
         this.field1338 = new class57();
         this.field1338.method1208(var1);
      }

      var2 = var1.method2492();
      if(var2 != 0) {
         --var1.field2005;
         this.field1333 = new class57();
         this.field1333.method1208(var1);
         this.field1331 = new class57();
         this.field1331.method1208(var1);
      }

      for(int var3 = 0; var3 < 10; ++var3) {
         int var4 = var1.method2505();
         if(var4 == 0) {
            break;
         }

         this.field1330[var3] = var4;
         this.field1334[var3] = var1.method2585();
         this.field1347[var3] = var1.method2505();
      }

      this.field1349 = var1.method2505();
      this.field1340 = var1.method2505();
      this.field1342 = var1.method2584();
      this.field1343 = var1.method2584();
      this.field1327 = new class63();
      this.field1341 = new class57();
      this.field1327.method1268(var1, this.field1341);
   }

   @ObfuscatedName("j")
   final int method1540(int var1, int var2, int var3) {
      return var3 == 1?((var1 & 32767) < 16384?var2:-var2):(var3 == 2?field1332[var1 & 32767] * var2 >> 14:(var3 == 3?((var1 & 32767) * var2 >> 14) - var2:(var3 == 4?field1345[var1 / 2607 & 32767] * var2:0)));
   }

   static {
      Random var0 = new Random(0L);

      int var1;
      for(var1 = 0; var1 < '耀'; ++var1) {
         field1345[var1] = (var0.nextInt() & 2) - 1;
      }

      field1332 = new int['耀'];

      for(var1 = 0; var1 < '耀'; ++var1) {
         field1332[var1] = (int)(Math.sin((double)var1 / 5215.1903D) * 16384.0D);
      }

      field1344 = new int[220500];
      field1336 = new int[5];
      field1335 = new int[5];
      field1350 = new int[5];
      field1351 = new int[5];
      field1352 = new int[5];
   }
}
