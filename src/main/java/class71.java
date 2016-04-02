import java.util.Random;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bc")
public class class71 {
   @ObfuscatedName("w")
   class57 field1294;
   @ObfuscatedName("f")
   class57 field1295;
   @ObfuscatedName("s")
   class57 field1296;
   @ObfuscatedName("p")
   class57 field1297;
   @ObfuscatedName("h")
   class57 field1298;
   @ObfuscatedName("g")
   class57 field1299;
   @ObfuscatedName("a")
   class57 field1300;
   @ObfuscatedName("r")
   int[] field1301 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("l")
   int field1302 = 500;
   @ObfuscatedName("y")
   int field1303 = 100;
   @ObfuscatedName("n")
   int field1304 = 0;
   @ObfuscatedName("i")
   class63 field1305;
   @ObfuscatedName("c")
   static int[] field1306;
   @ObfuscatedName("j")
   class57 field1307;
   @ObfuscatedName("e")
   class57 field1308;
   @ObfuscatedName("k")
   int[] field1309 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("m")
   int[] field1310 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("x")
   static int[] field1311 = new int['耀'];
   @ObfuscatedName("b")
   static int[] field1312;
   @ObfuscatedName("o")
   int field1313 = 0;
   @ObfuscatedName("u")
   static int[] field1314;
   @ObfuscatedName("t")
   static int[] field1315;
   @ObfuscatedName("d")
   static int[] field1316;
   @ObfuscatedName("z")
   static int[] field1317;
   @ObfuscatedName("v")
   static int[] field1318;

   @ObfuscatedName("w")
   final int method1567(int var1, int var2, int var3) {
      return var3 == 1?((var1 & 32767) < 16384?var2:-var2):(var3 == 2?field1312[var1 & 32767] * var2 >> 14:(var3 == 3?((var1 & 32767) * var2 >> 14) - var2:(var3 == 4?field1311[var1 / 2607 & 32767] * var2:0)));
   }

   @ObfuscatedName("f")
   final void method1568(class119 var1) {
      this.field1308 = new class57();
      this.field1308.method1234(var1);
      this.field1294 = new class57();
      this.field1294.method1234(var1);
      int var2 = var1.method2523();
      if(var2 != 0) {
         --var1.field1976;
         this.field1295 = new class57();
         this.field1295.method1234(var1);
         this.field1296 = new class57();
         this.field1296.method1234(var1);
      }

      var2 = var1.method2523();
      if(var2 != 0) {
         --var1.field1976;
         this.field1297 = new class57();
         this.field1297.method1234(var1);
         this.field1298 = new class57();
         this.field1298.method1234(var1);
      }

      var2 = var1.method2523();
      if(var2 != 0) {
         --var1.field1976;
         this.field1299 = new class57();
         this.field1299.method1234(var1);
         this.field1300 = new class57();
         this.field1300.method1234(var1);
      }

      for(int var3 = 0; var3 < 10; ++var3) {
         int var4 = var1.method2536();
         if(var4 == 0) {
            break;
         }

         this.field1301[var3] = var4;
         this.field1309[var3] = var1.method2535();
         this.field1310[var3] = var1.method2536();
      }

      this.field1304 = var1.method2536();
      this.field1303 = var1.method2536();
      this.field1302 = var1.method2700();
      this.field1313 = var1.method2700();
      this.field1305 = new class63();
      this.field1307 = new class57();
      this.field1305.method1285(var1, this.field1307);
   }

   @ObfuscatedName("e")
   final int[] method1569(int var1, int var2) {
      class120.method2724(field1306, 0, var1);
      if(var2 < 10) {
         return field1306;
      } else {
         double var3 = (double)var1 / ((double)var2 + 0.0D);
         this.field1308.method1230();
         this.field1294.method1230();
         int var5 = 0;
         int var6 = 0;
         int var7 = 0;
         if(this.field1295 != null) {
            this.field1295.method1230();
            this.field1296.method1230();
            var5 = (int)((double)(this.field1295.field1174 - this.field1295.field1179) * 32.768D / var3);
            var6 = (int)((double)this.field1295.field1179 * 32.768D / var3);
         }

         int var8 = 0;
         int var9 = 0;
         int var10 = 0;
         if(this.field1297 != null) {
            this.field1297.method1230();
            this.field1298.method1230();
            var8 = (int)((double)(this.field1297.field1174 - this.field1297.field1179) * 32.768D / var3);
            var9 = (int)((double)this.field1297.field1179 * 32.768D / var3);
         }

         int var11;
         for(var11 = 0; var11 < 5; ++var11) {
            if(this.field1301[var11] != 0) {
               field1314[var11] = 0;
               field1315[var11] = (int)((double)this.field1310[var11] * var3);
               field1316[var11] = (this.field1301[var11] << 14) / 100;
               field1317[var11] = (int)((double)(this.field1308.field1174 - this.field1308.field1179) * 32.768D * Math.pow(1.0057929410678534D, (double)this.field1309[var11]) / var3);
               field1318[var11] = (int)((double)this.field1308.field1179 * 32.768D / var3);
            }
         }

         int var12;
         int var13;
         int var14;
         int var15;
         for(var11 = 0; var11 < var1; ++var11) {
            var12 = this.field1308.method1231(var1);
            var13 = this.field1294.method1231(var1);
            if(this.field1295 != null) {
               var14 = this.field1295.method1231(var1);
               var15 = this.field1296.method1231(var1);
               var12 += this.method1567(var7, var15, this.field1295.field1175) >> 1;
               var7 += (var14 * var5 >> 16) + var6;
            }

            if(this.field1297 != null) {
               var14 = this.field1297.method1231(var1);
               var15 = this.field1298.method1231(var1);
               var13 = var13 * ((this.method1567(var10, var15, this.field1297.field1175) >> 1) + '耀') >> 15;
               var10 += (var14 * var8 >> 16) + var9;
            }

            for(var14 = 0; var14 < 5; ++var14) {
               if(this.field1301[var14] != 0) {
                  var15 = var11 + field1315[var14];
                  if(var15 < var1) {
                     field1306[var15] += this.method1567(field1314[var14], var13 * field1316[var14] >> 15, this.field1308.field1175);
                     field1314[var14] += (var12 * field1317[var14] >> 16) + field1318[var14];
                  }
               }
            }
         }

         int var16;
         if(this.field1299 != null) {
            this.field1299.method1230();
            this.field1300.method1230();
            var11 = 0;
            boolean var19 = false;
            boolean var20 = true;

            for(var14 = 0; var14 < var1; ++var14) {
               var15 = this.field1299.method1231(var1);
               var16 = this.field1300.method1231(var1);
               if(var20) {
                  var12 = this.field1299.field1179 + ((this.field1299.field1174 - this.field1299.field1179) * var15 >> 8);
               } else {
                  var12 = this.field1299.field1179 + ((this.field1299.field1174 - this.field1299.field1179) * var16 >> 8);
               }

               var11 += 256;
               if(var11 >= var12) {
                  var11 = 0;
                  var20 = !var20;
               }

               if(var20) {
                  field1306[var14] = 0;
               }
            }
         }

         if(this.field1304 > 0 && this.field1303 > 0) {
            var11 = (int)((double)this.field1304 * var3);

            for(var12 = var11; var12 < var1; ++var12) {
               field1306[var12] += field1306[var12 - var11] * this.field1303 / 100;
            }
         }

         if(this.field1305.field1214[0] > 0 || this.field1305.field1214[1] > 0) {
            this.field1307.method1230();
            var11 = this.field1307.method1231(var1 + 1);
            var12 = this.field1305.method1284(0, (float)var11 / 65536.0F);
            var13 = this.field1305.method1284(1, (float)var11 / 65536.0F);
            if(var1 >= var12 + var13) {
               var14 = 0;
               var15 = var13;
               if(var13 > var1 - var12) {
                  var15 = var1 - var12;
               }

               int var17;
               while(var14 < var15) {
                  var16 = (int)((long)field1306[var14 + var12] * (long)class63.field1215 >> 16);

                  for(var17 = 0; var17 < var12; ++var17) {
                     var16 += (int)((long)field1306[var14 + var12 - 1 - var17] * (long)class63.field1213[0][var17] >> 16);
                  }

                  for(var17 = 0; var17 < var14; ++var17) {
                     var16 -= (int)((long)field1306[var14 - 1 - var17] * (long)class63.field1213[1][var17] >> 16);
                  }

                  field1306[var14] = var16;
                  var11 = this.field1307.method1231(var1 + 1);
                  ++var14;
               }

               var15 = 128;

               while(true) {
                  if(var15 > var1 - var12) {
                     var15 = var1 - var12;
                  }

                  int var18;
                  while(var14 < var15) {
                     var17 = (int)((long)field1306[var14 + var12] * (long)class63.field1215 >> 16);

                     for(var18 = 0; var18 < var12; ++var18) {
                        var17 += (int)((long)field1306[var14 + var12 - 1 - var18] * (long)class63.field1213[0][var18] >> 16);
                     }

                     for(var18 = 0; var18 < var13; ++var18) {
                        var17 -= (int)((long)field1306[var14 - 1 - var18] * (long)class63.field1213[1][var18] >> 16);
                     }

                     field1306[var14] = var17;
                     var11 = this.field1307.method1231(var1 + 1);
                     ++var14;
                  }

                  if(var14 >= var1 - var12) {
                     while(var14 < var1) {
                        var17 = 0;

                        for(var18 = var14 + var12 - var1; var18 < var12; ++var18) {
                           var17 += (int)((long)field1306[var14 + var12 - 1 - var18] * (long)class63.field1213[0][var18] >> 16);
                        }

                        for(var18 = 0; var18 < var13; ++var18) {
                           var17 -= (int)((long)field1306[var14 - 1 - var18] * (long)class63.field1213[1][var18] >> 16);
                        }

                        field1306[var14] = var17;
                        this.field1307.method1231(var1 + 1);
                        ++var14;
                     }
                     break;
                  }

                  var12 = this.field1305.method1284(0, (float)var11 / 65536.0F);
                  var13 = this.field1305.method1284(1, (float)var11 / 65536.0F);
                  var15 += 128;
               }
            }
         }

         for(var11 = 0; var11 < var1; ++var11) {
            if(field1306[var11] < -32768) {
               field1306[var11] = -32768;
            }

            if(field1306[var11] > 32767) {
               field1306[var11] = 32767;
            }
         }

         return field1306;
      }
   }

   static {
      Random var0 = new Random(0L);

      int var1;
      for(var1 = 0; var1 < '耀'; ++var1) {
         field1311[var1] = (var0.nextInt() & 2) - 1;
      }

      field1312 = new int['耀'];

      for(var1 = 0; var1 < '耀'; ++var1) {
         field1312[var1] = (int)(Math.sin((double)var1 / 5215.1903D) * 16384.0D);
      }

      field1306 = new int[220500];
      field1314 = new int[5];
      field1315 = new int[5];
      field1316 = new int[5];
      field1317 = new int[5];
      field1318 = new int[5];
   }
}
