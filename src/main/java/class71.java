import java.util.Random;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bl")
public class class71 {
   @ObfuscatedName("n")
   int[] field1304 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("h")
   class57 field1305;
   @ObfuscatedName("m")
   class57 field1306;
   @ObfuscatedName("y")
   static int[] field1307 = new int['耀'];
   @ObfuscatedName("x")
   class57 field1308;
   @ObfuscatedName("c")
   class57 field1309;
   @ObfuscatedName("i")
   class57 field1310;
   @ObfuscatedName("p")
   class57 field1311;
   @ObfuscatedName("t")
   static int[] field1312;
   @ObfuscatedName("l")
   int[] field1313 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("u")
   int[] field1314 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("r")
   int field1315 = 0;
   @ObfuscatedName("a")
   int field1316 = 100;
   @ObfuscatedName("d")
   class63 field1317;
   @ObfuscatedName("s")
   static int[] field1319;
   @ObfuscatedName("b")
   int field1320 = 0;
   @ObfuscatedName("w")
   static int[] field1321;
   @ObfuscatedName("o")
   static int[] field1322;
   @ObfuscatedName("q")
   int field1323 = 500;
   @ObfuscatedName("z")
   class57 field1324;
   @ObfuscatedName("e")
   class57 field1325;
   @ObfuscatedName("k")
   static int[] field1326;
   @ObfuscatedName("j")
   class57 field1327;
   @ObfuscatedName("v")
   static int[] field1328;
   @ObfuscatedName("f")
   static int[] field1329;

   @ObfuscatedName("j")
   final int[] method1557(int var1, int var2) {
      class120.method2722(field1312, 0, var1);
      if(var2 < 10) {
         return field1312;
      } else {
         double var3 = (double)var1 / ((double)var2 + 0.0D);
         this.field1327.method1228();
         this.field1305.method1228();
         int var5 = 0;
         int var6 = 0;
         int var7 = 0;
         if(this.field1306 != null) {
            this.field1306.method1228();
            this.field1324.method1228();
            var5 = (int)((double)(this.field1306.field1186 - this.field1306.field1184) * 32.768D / var3);
            var6 = (int)((double)this.field1306.field1184 * 32.768D / var3);
         }

         int var8 = 0;
         int var9 = 0;
         int var10 = 0;
         if(this.field1308 != null) {
            this.field1308.method1228();
            this.field1325.method1228();
            var8 = (int)((double)(this.field1308.field1186 - this.field1308.field1184) * 32.768D / var3);
            var9 = (int)((double)this.field1308.field1184 * 32.768D / var3);
         }

         int var11;
         for(var11 = 0; var11 < 5; ++var11) {
            if(this.field1304[var11] != 0) {
               field1319[var11] = 0;
               field1326[var11] = (int)((double)this.field1314[var11] * var3);
               field1322[var11] = (this.field1304[var11] << 14) / 100;
               field1328[var11] = (int)((double)(this.field1327.field1186 - this.field1327.field1184) * 32.768D * Math.pow(1.0057929410678534D, (double)this.field1313[var11]) / var3);
               field1329[var11] = (int)((double)this.field1327.field1184 * 32.768D / var3);
            }
         }

         int var12;
         int var13;
         int var14;
         int var15;
         for(var11 = 0; var11 < var1; ++var11) {
            var12 = this.field1327.method1226(var1);
            var13 = this.field1305.method1226(var1);
            if(this.field1306 != null) {
               var14 = this.field1306.method1226(var1);
               var15 = this.field1324.method1226(var1);
               var12 += this.method1558(var7, var15, this.field1306.field1187) >> 1;
               var7 += (var14 * var5 >> 16) + var6;
            }

            if(this.field1308 != null) {
               var14 = this.field1308.method1226(var1);
               var15 = this.field1325.method1226(var1);
               var13 = var13 * ((this.method1558(var10, var15, this.field1308.field1187) >> 1) + '耀') >> 15;
               var10 += (var14 * var8 >> 16) + var9;
            }

            for(var14 = 0; var14 < 5; ++var14) {
               if(this.field1304[var14] != 0) {
                  var15 = var11 + field1326[var14];
                  if(var15 < var1) {
                     field1312[var15] += this.method1558(field1319[var14], var13 * field1322[var14] >> 15, this.field1327.field1187);
                     field1319[var14] += (var12 * field1328[var14] >> 16) + field1329[var14];
                  }
               }
            }
         }

         int var16;
         if(this.field1310 != null) {
            this.field1310.method1228();
            this.field1309.method1228();
            var11 = 0;
            boolean var19 = false;
            boolean var20 = true;

            for(var14 = 0; var14 < var1; ++var14) {
               var15 = this.field1310.method1226(var1);
               var16 = this.field1309.method1226(var1);
               if(var20) {
                  var12 = this.field1310.field1184 + ((this.field1310.field1186 - this.field1310.field1184) * var15 >> 8);
               } else {
                  var12 = this.field1310.field1184 + ((this.field1310.field1186 - this.field1310.field1184) * var16 >> 8);
               }

               var11 += 256;
               if(var11 >= var12) {
                  var11 = 0;
                  var20 = !var20;
               }

               if(var20) {
                  field1312[var14] = 0;
               }
            }
         }

         if(this.field1315 > 0 && this.field1316 > 0) {
            var11 = (int)((double)this.field1315 * var3);

            for(var12 = var11; var12 < var1; ++var12) {
               field1312[var12] += field1312[var12 - var11] * this.field1316 / 100;
            }
         }

         if(this.field1317.field1220[0] > 0 || this.field1317.field1220[1] > 0) {
            this.field1311.method1228();
            var11 = this.field1311.method1226(var1 + 1);
            var12 = this.field1317.method1283(0, (float)var11 / 65536.0F);
            var13 = this.field1317.method1283(1, (float)var11 / 65536.0F);
            if(var1 >= var12 + var13) {
               var14 = 0;
               var15 = var13;
               if(var13 > var1 - var12) {
                  var15 = var1 - var12;
               }

               int var17;
               while(var14 < var15) {
                  var16 = (int)((long)field1312[var14 + var12] * (long)class63.field1229 >> 16);

                  for(var17 = 0; var17 < var12; ++var17) {
                     var16 += (int)((long)field1312[var14 + var12 - 1 - var17] * (long)class63.field1224[0][var17] >> 16);
                  }

                  for(var17 = 0; var17 < var14; ++var17) {
                     var16 -= (int)((long)field1312[var14 - 1 - var17] * (long)class63.field1224[1][var17] >> 16);
                  }

                  field1312[var14] = var16;
                  var11 = this.field1311.method1226(var1 + 1);
                  ++var14;
               }

               var15 = 128;

               while(true) {
                  if(var15 > var1 - var12) {
                     var15 = var1 - var12;
                  }

                  int var18;
                  while(var14 < var15) {
                     var17 = (int)((long)field1312[var14 + var12] * (long)class63.field1229 >> 16);

                     for(var18 = 0; var18 < var12; ++var18) {
                        var17 += (int)((long)field1312[var14 + var12 - 1 - var18] * (long)class63.field1224[0][var18] >> 16);
                     }

                     for(var18 = 0; var18 < var13; ++var18) {
                        var17 -= (int)((long)field1312[var14 - 1 - var18] * (long)class63.field1224[1][var18] >> 16);
                     }

                     field1312[var14] = var17;
                     var11 = this.field1311.method1226(var1 + 1);
                     ++var14;
                  }

                  if(var14 >= var1 - var12) {
                     while(var14 < var1) {
                        var17 = 0;

                        for(var18 = var14 + var12 - var1; var18 < var12; ++var18) {
                           var17 += (int)((long)field1312[var14 + var12 - 1 - var18] * (long)class63.field1224[0][var18] >> 16);
                        }

                        for(var18 = 0; var18 < var13; ++var18) {
                           var17 -= (int)((long)field1312[var14 - 1 - var18] * (long)class63.field1224[1][var18] >> 16);
                        }

                        field1312[var14] = var17;
                        this.field1311.method1226(var1 + 1);
                        ++var14;
                     }
                     break;
                  }

                  var12 = this.field1317.method1283(0, (float)var11 / 65536.0F);
                  var13 = this.field1317.method1283(1, (float)var11 / 65536.0F);
                  var15 += 128;
               }
            }
         }

         for(var11 = 0; var11 < var1; ++var11) {
            if(field1312[var11] < -32768) {
               field1312[var11] = -32768;
            }

            if(field1312[var11] > 32767) {
               field1312[var11] = 32767;
            }
         }

         return field1312;
      }
   }

   @ObfuscatedName("h")
   final int method1558(int var1, int var2, int var3) {
      return var3 == 1?((var1 & 32767) < 16384?var2:-var2):(var3 == 2?field1321[var1 & 32767] * var2 >> 14:(var3 == 3?((var1 & 32767) * var2 >> 14) - var2:(var3 == 4?field1307[var1 / 2607 & 32767] * var2:0)));
   }

   @ObfuscatedName("m")
   final void method1559(class119 var1) {
      this.field1327 = new class57();
      this.field1327.method1224(var1);
      this.field1305 = new class57();
      this.field1305.method1224(var1);
      int var2 = var1.method2500();
      if(var2 != 0) {
         --var1.field1971;
         this.field1306 = new class57();
         this.field1306.method1224(var1);
         this.field1324 = new class57();
         this.field1324.method1224(var1);
      }

      var2 = var1.method2500();
      if(var2 != 0) {
         --var1.field1971;
         this.field1308 = new class57();
         this.field1308.method1224(var1);
         this.field1325 = new class57();
         this.field1325.method1224(var1);
      }

      var2 = var1.method2500();
      if(var2 != 0) {
         --var1.field1971;
         this.field1310 = new class57();
         this.field1310.method1224(var1);
         this.field1309 = new class57();
         this.field1309.method1224(var1);
      }

      for(int var3 = 0; var3 < 10; ++var3) {
         int var4 = var1.method2512();
         if(var4 == 0) {
            break;
         }

         this.field1304[var3] = var4;
         this.field1313[var3] = var1.method2610();
         this.field1314[var3] = var1.method2512();
      }

      this.field1315 = var1.method2512();
      this.field1316 = var1.method2512();
      this.field1323 = var1.method2502();
      this.field1320 = var1.method2502();
      this.field1317 = new class63();
      this.field1311 = new class57();
      this.field1317.method1284(var1, this.field1311);
   }

   static {
      Random var0 = new Random(0L);

      int var1;
      for(var1 = 0; var1 < '耀'; ++var1) {
         field1307[var1] = (var0.nextInt() & 2) - 1;
      }

      field1321 = new int['耀'];

      for(var1 = 0; var1 < '耀'; ++var1) {
         field1321[var1] = (int)(Math.sin((double)var1 / 5215.1903D) * 16384.0D);
      }

      field1312 = new int[220500];
      field1319 = new int[5];
      field1326 = new int[5];
      field1322 = new int[5];
      field1328 = new int[5];
      field1329 = new int[5];
   }
}
