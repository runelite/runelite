import java.util.Random;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bm")
public class class71 {
   @ObfuscatedName("e")
   static int[] field1289;
   @ObfuscatedName("g")
   class57 field1290;
   @ObfuscatedName("a")
   static int[] field1291;
   @ObfuscatedName("l")
   int[] field1292 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("x")
   class57 field1293;
   @ObfuscatedName("y")
   class57 field1294;
   @ObfuscatedName("r")
   class57 field1295;
   @ObfuscatedName("c")
   class57 field1296;
   @ObfuscatedName("j")
   class57 field1297;
   @ObfuscatedName("u")
   int[] field1298 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("p")
   int[] field1299 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("b")
   class57 field1300;
   @ObfuscatedName("w")
   int field1301 = 100;
   @ObfuscatedName("z")
   class63 field1302;
   @ObfuscatedName("v")
   static int[] field1303 = new int['耀'];
   @ObfuscatedName("q")
   static int[] field1304;
   @ObfuscatedName("h")
   static int[] field1306;
   @ObfuscatedName("o")
   int field1307 = 500;
   @ObfuscatedName("n")
   int field1308 = 0;
   @ObfuscatedName("d")
   class57 field1309;
   @ObfuscatedName("t")
   int field1310 = 0;
   @ObfuscatedName("m")
   static int[] field1311;
   @ObfuscatedName("s")
   static int[] field1312;
   @ObfuscatedName("i")
   static int[] field1313;
   @ObfuscatedName("k")
   class57 field1314;

   @ObfuscatedName("b")
   final int[] method1586(int var1, int var2) {
      class120.method2768(field1306, 0, var1);
      if(var2 < 10) {
         return field1306;
      } else {
         double var3 = (double)var1 / ((double)var2 + 0.0D);
         this.field1300.method1235();
         this.field1290.method1235();
         int var5 = 0;
         int var6 = 0;
         int var7 = 0;
         if(this.field1297 != null) {
            this.field1297.method1235();
            this.field1309.method1235();
            var5 = (int)((double)(this.field1297.field1173 - this.field1297.field1172) * 32.768D / var3);
            var6 = (int)((double)this.field1297.field1172 * 32.768D / var3);
         }

         int var8 = 0;
         int var9 = 0;
         int var10 = 0;
         if(this.field1293 != null) {
            this.field1293.method1235();
            this.field1294.method1235();
            var8 = (int)((double)(this.field1293.field1173 - this.field1293.field1172) * 32.768D / var3);
            var9 = (int)((double)this.field1293.field1172 * 32.768D / var3);
         }

         int var11;
         for(var11 = 0; var11 < 5; ++var11) {
            if(this.field1292[var11] != 0) {
               field1304[var11] = 0;
               field1311[var11] = (int)((double)this.field1299[var11] * var3);
               field1312[var11] = (this.field1292[var11] << 14) / 100;
               field1313[var11] = (int)((double)(this.field1300.field1173 - this.field1300.field1172) * 32.768D * Math.pow(1.0057929410678534D, (double)this.field1298[var11]) / var3);
               field1289[var11] = (int)((double)this.field1300.field1172 * 32.768D / var3);
            }
         }

         int var12;
         int var13;
         int var14;
         int var15;
         for(var11 = 0; var11 < var1; ++var11) {
            var12 = this.field1300.method1236(var1);
            var13 = this.field1290.method1236(var1);
            if(this.field1297 != null) {
               var14 = this.field1297.method1236(var1);
               var15 = this.field1309.method1236(var1);
               var12 += this.method1587(var7, var15, this.field1297.field1178) >> 1;
               var7 += (var14 * var5 >> 16) + var6;
            }

            if(this.field1293 != null) {
               var14 = this.field1293.method1236(var1);
               var15 = this.field1294.method1236(var1);
               var13 = var13 * ((this.method1587(var10, var15, this.field1293.field1178) >> 1) + '耀') >> 15;
               var10 += (var14 * var8 >> 16) + var9;
            }

            for(var14 = 0; var14 < 5; ++var14) {
               if(this.field1292[var14] != 0) {
                  var15 = var11 + field1311[var14];
                  if(var15 < var1) {
                     field1306[var15] += this.method1587(field1304[var14], var13 * field1312[var14] >> 15, this.field1300.field1178);
                     field1304[var14] += (var12 * field1313[var14] >> 16) + field1289[var14];
                  }
               }
            }
         }

         int var16;
         if(this.field1295 != null) {
            this.field1295.method1235();
            this.field1296.method1235();
            var11 = 0;
            boolean var19 = false;
            boolean var20 = true;

            for(var14 = 0; var14 < var1; ++var14) {
               var15 = this.field1295.method1236(var1);
               var16 = this.field1296.method1236(var1);
               if(var20) {
                  var12 = this.field1295.field1172 + ((this.field1295.field1173 - this.field1295.field1172) * var15 >> 8);
               } else {
                  var12 = this.field1295.field1172 + ((this.field1295.field1173 - this.field1295.field1172) * var16 >> 8);
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

         if(this.field1308 > 0 && this.field1301 > 0) {
            var11 = (int)((double)this.field1308 * var3);

            for(var12 = var11; var12 < var1; ++var12) {
               field1306[var12] += field1306[var12 - var11] * this.field1301 / 100;
            }
         }

         if(this.field1302.field1204[0] > 0 || this.field1302.field1204[1] > 0) {
            this.field1314.method1235();
            var11 = this.field1314.method1236(var1 + 1);
            var12 = this.field1302.method1293(0, (float)var11 / 65536.0F);
            var13 = this.field1302.method1293(1, (float)var11 / 65536.0F);
            if(var1 >= var12 + var13) {
               var14 = 0;
               var15 = var13;
               if(var13 > var1 - var12) {
                  var15 = var1 - var12;
               }

               int var17;
               while(var14 < var15) {
                  var16 = (int)((long)field1306[var14 + var12] * (long)class63.field1211 >> 16);

                  for(var17 = 0; var17 < var12; ++var17) {
                     var16 += (int)((long)field1306[var14 + var12 - 1 - var17] * (long)class63.field1209[0][var17] >> 16);
                  }

                  for(var17 = 0; var17 < var14; ++var17) {
                     var16 -= (int)((long)field1306[var14 - 1 - var17] * (long)class63.field1209[1][var17] >> 16);
                  }

                  field1306[var14] = var16;
                  var11 = this.field1314.method1236(var1 + 1);
                  ++var14;
               }

               var15 = 128;

               while(true) {
                  if(var15 > var1 - var12) {
                     var15 = var1 - var12;
                  }

                  int var18;
                  while(var14 < var15) {
                     var17 = (int)((long)field1306[var14 + var12] * (long)class63.field1211 >> 16);

                     for(var18 = 0; var18 < var12; ++var18) {
                        var17 += (int)((long)field1306[var14 + var12 - 1 - var18] * (long)class63.field1209[0][var18] >> 16);
                     }

                     for(var18 = 0; var18 < var13; ++var18) {
                        var17 -= (int)((long)field1306[var14 - 1 - var18] * (long)class63.field1209[1][var18] >> 16);
                     }

                     field1306[var14] = var17;
                     var11 = this.field1314.method1236(var1 + 1);
                     ++var14;
                  }

                  if(var14 >= var1 - var12) {
                     while(var14 < var1) {
                        var17 = 0;

                        for(var18 = var14 + var12 - var1; var18 < var12; ++var18) {
                           var17 += (int)((long)field1306[var14 + var12 - 1 - var18] * (long)class63.field1209[0][var18] >> 16);
                        }

                        for(var18 = 0; var18 < var13; ++var18) {
                           var17 -= (int)((long)field1306[var14 - 1 - var18] * (long)class63.field1209[1][var18] >> 16);
                        }

                        field1306[var14] = var17;
                        this.field1314.method1236(var1 + 1);
                        ++var14;
                     }
                     break;
                  }

                  var12 = this.field1302.method1293(0, (float)var11 / 65536.0F);
                  var13 = this.field1302.method1293(1, (float)var11 / 65536.0F);
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

   @ObfuscatedName("g")
   final int method1587(int var1, int var2, int var3) {
      return var3 == 1?((var1 & 32767) < 16384?var2:-var2):(var3 == 2?field1291[var1 & 32767] * var2 >> 14:(var3 == 3?((var1 & 32767) * var2 >> 14) - var2:(var3 == 4?field1303[var1 / 2607 & 32767] * var2:0)));
   }

   static {
      Random var0 = new Random(0L);

      int var1;
      for(var1 = 0; var1 < '耀'; ++var1) {
         field1303[var1] = (var0.nextInt() & 2) - 1;
      }

      field1291 = new int['耀'];

      for(var1 = 0; var1 < '耀'; ++var1) {
         field1291[var1] = (int)(Math.sin((double)var1 / 5215.1903D) * 16384.0D);
      }

      field1306 = new int[220500];
      field1304 = new int[5];
      field1311 = new int[5];
      field1312 = new int[5];
      field1313 = new int[5];
      field1289 = new int[5];
   }

   @ObfuscatedName("j")
   final void method1592(class119 var1) {
      this.field1300 = new class57();
      this.field1300.method1234(var1);
      this.field1290 = new class57();
      this.field1290.method1234(var1);
      int var2 = var1.method2514();
      if(var2 != 0) {
         --var1.field1976;
         this.field1297 = new class57();
         this.field1297.method1234(var1);
         this.field1309 = new class57();
         this.field1309.method1234(var1);
      }

      var2 = var1.method2514();
      if(var2 != 0) {
         --var1.field1976;
         this.field1293 = new class57();
         this.field1293.method1234(var1);
         this.field1294 = new class57();
         this.field1294.method1234(var1);
      }

      var2 = var1.method2514();
      if(var2 != 0) {
         --var1.field1976;
         this.field1295 = new class57();
         this.field1295.method1234(var1);
         this.field1296 = new class57();
         this.field1296.method1234(var1);
      }

      for(int var3 = 0; var3 < 10; ++var3) {
         int var4 = var1.method2642();
         if(var4 == 0) {
            break;
         }

         this.field1292[var3] = var4;
         this.field1298[var3] = var1.method2689();
         this.field1299[var3] = var1.method2642();
      }

      this.field1308 = var1.method2642();
      this.field1301 = var1.method2642();
      this.field1307 = var1.method2516();
      this.field1310 = var1.method2516();
      this.field1302 = new class63();
      this.field1314 = new class57();
      this.field1302.method1294(var1, this.field1314);
   }
}
