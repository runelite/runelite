import java.util.Random;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bx")
public class class71 {
   @ObfuscatedName("z")
   class57 field1321;
   @ObfuscatedName("r")
   class57 field1322;
   @ObfuscatedName("n")
   int[] field1323 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("s")
   class57 field1324;
   @ObfuscatedName("y")
   class57 field1325;
   @ObfuscatedName("e")
   class57 field1326;
   @ObfuscatedName("g")
   class57 field1327;
   @ObfuscatedName("a")
   class57 field1328;
   @ObfuscatedName("j")
   int[] field1329 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("l")
   int[] field1331 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("h")
   int field1332 = 0;
   @ObfuscatedName("i")
   int field1333 = 100;
   @ObfuscatedName("v")
   class63 field1334;
   @ObfuscatedName("t")
   int field1335 = 0;
   @ObfuscatedName("u")
   int field1336 = 500;
   @ObfuscatedName("f")
   class57 field1337;
   @ObfuscatedName("b")
   static int[] field1338;
   @ObfuscatedName("c")
   static int[] field1339 = new int['耀'];
   @ObfuscatedName("x")
   static int[] field1340;
   @ObfuscatedName("o")
   static int[] field1341;
   @ObfuscatedName("p")
   static int[] field1342;
   @ObfuscatedName("q")
   static int[] field1343;
   @ObfuscatedName("w")
   static int[] field1344;
   @ObfuscatedName("k")
   static int[] field1345;
   @ObfuscatedName("m")
   class57 field1346;

   @ObfuscatedName("a")
   final int[] method1600(int var1, int var2) {
      class119.method2718(field1338, 0, var1);
      if(var2 < 10) {
         return field1338;
      } else {
         double var3 = (double)var1 / ((double)var2 + 0.0D);
         this.field1328.method1246();
         this.field1322.method1246();
         int var5 = 0;
         int var6 = 0;
         int var7 = 0;
         if(this.field1337 != null) {
            this.field1337.method1246();
            this.field1324.method1246();
            var5 = (int)((double)(this.field1337.field1200 - this.field1337.field1199) * 32.768D / var3);
            var6 = (int)((double)this.field1337.field1199 * 32.768D / var3);
         }

         int var8 = 0;
         int var9 = 0;
         int var10 = 0;
         if(this.field1325 != null) {
            this.field1325.method1246();
            this.field1326.method1246();
            var8 = (int)((double)(this.field1325.field1200 - this.field1325.field1199) * 32.768D / var3);
            var9 = (int)((double)this.field1325.field1199 * 32.768D / var3);
         }

         int var11;
         for(var11 = 0; var11 < 5; ++var11) {
            if(this.field1329[var11] != 0) {
               field1342[var11] = 0;
               field1343[var11] = (int)((double)this.field1331[var11] * var3);
               field1344[var11] = (this.field1329[var11] << 14) / 100;
               field1345[var11] = (int)((double)(this.field1328.field1200 - this.field1328.field1199) * 32.768D * Math.pow(1.0057929410678534D, (double)this.field1323[var11]) / var3);
               field1341[var11] = (int)((double)this.field1328.field1199 * 32.768D / var3);
            }
         }

         int var12;
         int var13;
         int var14;
         int var15;
         for(var11 = 0; var11 < var1; ++var11) {
            var12 = this.field1328.method1247(var1);
            var13 = this.field1322.method1247(var1);
            if(this.field1337 != null) {
               var14 = this.field1337.method1247(var1);
               var15 = this.field1324.method1247(var1);
               var12 += this.method1601(var7, var15, this.field1337.field1198) >> 1;
               var7 += (var14 * var5 >> 16) + var6;
            }

            if(this.field1325 != null) {
               var14 = this.field1325.method1247(var1);
               var15 = this.field1326.method1247(var1);
               var13 = var13 * ((this.method1601(var10, var15, this.field1325.field1198) >> 1) + '耀') >> 15;
               var10 += (var14 * var8 >> 16) + var9;
            }

            for(var14 = 0; var14 < 5; ++var14) {
               if(this.field1329[var14] != 0) {
                  var15 = var11 + field1343[var14];
                  if(var15 < var1) {
                     field1338[var15] += this.method1601(field1342[var14], var13 * field1344[var14] >> 15, this.field1328.field1198);
                     field1342[var14] += (var12 * field1345[var14] >> 16) + field1341[var14];
                  }
               }
            }
         }

         int var16;
         if(this.field1327 != null) {
            this.field1327.method1246();
            this.field1346.method1246();
            var11 = 0;
            boolean var19 = false;
            boolean var20 = true;

            for(var14 = 0; var14 < var1; ++var14) {
               var15 = this.field1327.method1247(var1);
               var16 = this.field1346.method1247(var1);
               if(var20) {
                  var12 = this.field1327.field1199 + ((this.field1327.field1200 - this.field1327.field1199) * var15 >> 8);
               } else {
                  var12 = this.field1327.field1199 + ((this.field1327.field1200 - this.field1327.field1199) * var16 >> 8);
               }

               var11 += 256;
               if(var11 >= var12) {
                  var11 = 0;
                  var20 = !var20;
               }

               if(var20) {
                  field1338[var14] = 0;
               }
            }
         }

         if(this.field1332 > 0 && this.field1333 > 0) {
            var11 = (int)((double)this.field1332 * var3);

            for(var12 = var11; var12 < var1; ++var12) {
               field1338[var12] += field1338[var12 - var11] * this.field1333 / 100;
            }
         }

         if(this.field1334.field1238[0] > 0 || this.field1334.field1238[1] > 0) {
            this.field1321.method1246();
            var11 = this.field1321.method1247(var1 + 1);
            var12 = this.field1334.method1310(0, (float)var11 / 65536.0F);
            var13 = this.field1334.method1310(1, (float)var11 / 65536.0F);
            if(var1 >= var12 + var13) {
               var14 = 0;
               var15 = var13;
               if(var13 > var1 - var12) {
                  var15 = var1 - var12;
               }

               int var17;
               while(var14 < var15) {
                  var16 = (int)((long)field1338[var14 + var12] * (long)class63.field1243 >> 16);

                  for(var17 = 0; var17 < var12; ++var17) {
                     var16 += (int)((long)field1338[var14 + var12 - 1 - var17] * (long)class63.field1241[0][var17] >> 16);
                  }

                  for(var17 = 0; var17 < var14; ++var17) {
                     var16 -= (int)((long)field1338[var14 - 1 - var17] * (long)class63.field1241[1][var17] >> 16);
                  }

                  field1338[var14] = var16;
                  var11 = this.field1321.method1247(var1 + 1);
                  ++var14;
               }

               var15 = 128;

               while(true) {
                  if(var15 > var1 - var12) {
                     var15 = var1 - var12;
                  }

                  int var18;
                  while(var14 < var15) {
                     var17 = (int)((long)field1338[var14 + var12] * (long)class63.field1243 >> 16);

                     for(var18 = 0; var18 < var12; ++var18) {
                        var17 += (int)((long)field1338[var14 + var12 - 1 - var18] * (long)class63.field1241[0][var18] >> 16);
                     }

                     for(var18 = 0; var18 < var13; ++var18) {
                        var17 -= (int)((long)field1338[var14 - 1 - var18] * (long)class63.field1241[1][var18] >> 16);
                     }

                     field1338[var14] = var17;
                     var11 = this.field1321.method1247(var1 + 1);
                     ++var14;
                  }

                  if(var14 >= var1 - var12) {
                     while(var14 < var1) {
                        var17 = 0;

                        for(var18 = var14 + var12 - var1; var18 < var12; ++var18) {
                           var17 += (int)((long)field1338[var14 + var12 - 1 - var18] * (long)class63.field1241[0][var18] >> 16);
                        }

                        for(var18 = 0; var18 < var13; ++var18) {
                           var17 -= (int)((long)field1338[var14 - 1 - var18] * (long)class63.field1241[1][var18] >> 16);
                        }

                        field1338[var14] = var17;
                        this.field1321.method1247(var1 + 1);
                        ++var14;
                     }
                     break;
                  }

                  var12 = this.field1334.method1310(0, (float)var11 / 65536.0F);
                  var13 = this.field1334.method1310(1, (float)var11 / 65536.0F);
                  var15 += 128;
               }
            }
         }

         for(var11 = 0; var11 < var1; ++var11) {
            if(field1338[var11] < -32768) {
               field1338[var11] = -32768;
            }

            if(field1338[var11] > 32767) {
               field1338[var11] = 32767;
            }
         }

         return field1338;
      }
   }

   @ObfuscatedName("r")
   final int method1601(int var1, int var2, int var3) {
      return var3 == 1?((var1 & 32767) < 16384?var2:-var2):(var3 == 2?field1340[var1 & 32767] * var2 >> 14:(var3 == 3?((var1 & 32767) * var2 >> 14) - var2:(var3 == 4?field1339[var1 / 2607 & 32767] * var2:0)));
   }

   static {
      Random var0 = new Random(0L);

      int var1;
      for(var1 = 0; var1 < '耀'; ++var1) {
         field1339[var1] = (var0.nextInt() & 2) - 1;
      }

      field1340 = new int['耀'];

      for(var1 = 0; var1 < '耀'; ++var1) {
         field1340[var1] = (int)(Math.sin((double)var1 / 5215.1903D) * 16384.0D);
      }

      field1338 = new int[220500];
      field1342 = new int[5];
      field1343 = new int[5];
      field1344 = new int[5];
      field1345 = new int[5];
      field1341 = new int[5];
   }

   @ObfuscatedName("f")
   final void method1606(class118 var1) {
      this.field1328 = new class57();
      this.field1328.method1256(var1);
      this.field1322 = new class57();
      this.field1322.method1256(var1);
      int var2 = var1.method2579();
      if(var2 != 0) {
         --var1.field1979;
         this.field1337 = new class57();
         this.field1337.method1256(var1);
         this.field1324 = new class57();
         this.field1324.method1256(var1);
      }

      var2 = var1.method2579();
      if(var2 != 0) {
         --var1.field1979;
         this.field1325 = new class57();
         this.field1325.method1256(var1);
         this.field1326 = new class57();
         this.field1326.method1256(var1);
      }

      var2 = var1.method2579();
      if(var2 != 0) {
         --var1.field1979;
         this.field1327 = new class57();
         this.field1327.method1256(var1);
         this.field1346 = new class57();
         this.field1346.method1256(var1);
      }

      for(int var3 = 0; var3 < 10; ++var3) {
         int var4 = var1.method2659();
         if(var4 == 0) {
            break;
         }

         this.field1329[var3] = var4;
         this.field1323[var3] = var1.method2524();
         this.field1331[var3] = var1.method2659();
      }

      this.field1332 = var1.method2659();
      this.field1333 = var1.method2659();
      this.field1336 = var1.method2514();
      this.field1335 = var1.method2514();
      this.field1334 = new class63();
      this.field1321 = new class57();
      this.field1334.method1319(var1, this.field1321);
   }
}
