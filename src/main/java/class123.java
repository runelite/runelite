import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dz")
public final class class123 {
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1450476401
   )
   int field2020;
   @ObfuscatedName("r")
   int[] field2023 = new int[256];
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 91224013
   )
   int field2025;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -2104230177
   )
   int field2026;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1770490115
   )
   int field2027;
   @ObfuscatedName("p")
   int[] field2029 = new int[256];

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-122"
   )
   final int method2893() {
      if(0 == --this.field2020 + 1) {
         this.method2895();
         this.field2020 = 255;
      }

      return this.field2023[this.field2020];
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1287187691"
   )
   final void method2895() {
      this.field2026 += ++this.field2027;

      for(int var1 = 0; var1 < 256; ++var1) {
         int var2 = this.field2029[var1];
         if((var1 & 2) == 0) {
            if((var1 & 1) == 0) {
               this.field2025 ^= this.field2025 << 13;
            } else {
               this.field2025 ^= this.field2025 >>> 6;
            }
         } else if((var1 & 1) == 0) {
            this.field2025 ^= this.field2025 << 2;
         } else {
            this.field2025 ^= this.field2025 >>> 16;
         }

         this.field2025 += this.field2029[var1 + 128 & 255];
         int var3;
         this.field2029[var1] = var3 = this.field2026 + this.field2029[(var2 & 1020) >> 2] + this.field2025;
         this.field2023[var1] = this.field2026 = var2 + this.field2029[(var3 >> 8 & 1020) >> 2];
      }

   }

   class123(int[] var1) {
      for(int var2 = 0; var2 < var1.length; ++var2) {
         this.field2023[var2] = var1[var2];
      }

      this.method2903();
   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-749221417"
   )
   static final void method2901() {
      int var3;
      int var4;
      int var5;
      int var29;
      int var30;
      int var31;
      if(252 == client.field394) {
         var29 = client.field441.method2613();
         var30 = (var29 >> 4 & 7) + class87.field1538;
         var31 = (var29 & 7) + class34.field785;
         var3 = client.field441.method2615();
         var4 = client.field441.method2613();
         var5 = client.field441.method2615();
         if(var30 >= 0 && var31 >= 0 && var30 < 104 && var31 < 104) {
            var30 = var30 * 128 + 64;
            var31 = 64 + var31 * 128;
            class29 var35 = new class29(var3, class42.field1002, var30, var31, class34.method816(var30, var31, class42.field1002) - var4, var5, client.field306);
            client.field428.method3900(var35);
         }

      } else {
         int var6;
         if(client.field394 == 136) {
            var29 = client.field441.method2613();
            var30 = class87.field1538 + (var29 >> 4 & 7);
            var31 = class34.field785 + (var29 & 7);
            var3 = client.field441.method2639();
            var4 = var3 >> 2;
            var5 = var3 & 3;
            var6 = client.field358[var4];
            if(var30 >= 0 && var31 >= 0 && var30 < 104 && var31 < 104) {
               class0.method1(class42.field1002, var30, var31, var6, -1, var4, var5, 0, -1);
            }

         } else {
            class28 var32;
            if(74 == client.field394) {
               var29 = client.field441.method2640();
               var30 = (var29 >> 4 & 7) + class87.field1538;
               var31 = (var29 & 7) + class34.field785;
               var3 = client.field441.method2597();
               if(var30 >= 0 && var31 >= 0 && var30 < 104 && var31 < 104) {
                  class199 var33 = client.field425[class42.field1002][var30][var31];
                  if(null != var33) {
                     for(var32 = (class28)var33.method3926(); var32 != null; var32 = (class28)var33.method3902()) {
                        if((var3 & 32767) == var32.field691) {
                           var32.method3998();
                           break;
                        }
                     }

                     if(var33.method3926() == null) {
                        client.field425[class42.field1002][var30][var31] = null;
                     }

                     class130.method2949(var30, var31);
                  }
               }

            } else if(73 == client.field394) {
               var29 = client.field441.method2613();
               var30 = class87.field1538 + (var29 >> 4 & 7);
               var31 = class34.field785 + (var29 & 7);
               var3 = client.field441.method2615();
               var4 = client.field441.method2615();
               var5 = client.field441.method2615();
               if(var30 >= 0 && var31 >= 0 && var30 < 104 && var31 < 104) {
                  class199 var34 = client.field425[class42.field1002][var30][var31];
                  if(null != var34) {
                     for(class28 var36 = (class28)var34.method3926(); var36 != null; var36 = (class28)var34.method3902()) {
                        if((var3 & 32767) == var36.field691 && var4 == var36.field689) {
                           var36.field689 = var5;
                           break;
                        }
                     }

                     class130.method2949(var30, var31);
                  }
               }

            } else {
               int var7;
               int var9;
               int var10;
               int var11;
               int var12;
               if(client.field394 == 65) {
                  byte var0 = client.field441.method2643();
                  byte var1 = client.field441.method2699();
                  byte var2 = client.field441.method2791();
                  var3 = client.field441.method2597();
                  var4 = client.field441.method2641();
                  var5 = (var4 >> 4 & 7) + class87.field1538;
                  var6 = class34.field785 + (var4 & 7);
                  var7 = client.field441.method2631();
                  byte var8 = client.field441.method2699();
                  var9 = client.field441.method2640();
                  var10 = var9 >> 2;
                  var11 = var9 & 3;
                  var12 = client.field358[var10];
                  int var13 = client.field441.method2597();
                  int var14 = client.field441.method2648();
                  class2 var15;
                  if(var3 == client.field457) {
                     var15 = class5.field93;
                  } else {
                     var15 = client.field550[var3];
                  }

                  if(null != var15) {
                     class40 var16 = class133.method2969(var7);
                     int var17;
                     int var18;
                     if(1 != var11 && 3 != var11) {
                        var17 = var16.field938;
                        var18 = var16.field939;
                     } else {
                        var17 = var16.field939;
                        var18 = var16.field938;
                     }

                     int var19 = var5 + (var17 >> 1);
                     int var20 = var5 + (var17 + 1 >> 1);
                     int var21 = var6 + (var18 >> 1);
                     int var22 = (var18 + 1 >> 1) + var6;
                     int[][] var23 = class5.field94[class42.field1002];
                     int var24 = var23[var19][var21] + var23[var20][var21] + var23[var19][var22] + var23[var20][var22] >> 2;
                     int var25 = (var17 << 6) + (var5 << 7);
                     int var26 = (var18 << 6) + (var6 << 7);
                     class105 var27 = var16.method896(var10, var11, var23, var25, var24, var26);
                     if(null != var27) {
                        class0.method1(class42.field1002, var5, var6, var12, -1, 0, 0, 1 + var13, var14 + 1);
                        var15.field35 = var13 + client.field306;
                        var15.field42 = client.field306 + var14;
                        var15.field46 = var27;
                        var15.field62 = var5 * 128 + var17 * 64;
                        var15.field45 = var18 * 64 + var6 * 128;
                        var15.field44 = var24;
                        byte var28;
                        if(var1 > var2) {
                           var28 = var1;
                           var1 = var2;
                           var2 = var28;
                        }

                        if(var8 > var0) {
                           var28 = var8;
                           var8 = var0;
                           var0 = var28;
                        }

                        var15.field47 = var5 + var1;
                        var15.field52 = var2 + var5;
                        var15.field48 = var8 + var6;
                        var15.field53 = var6 + var0;
                     }
                  }
               }

               int var37;
               if(client.field394 == 202) {
                  var29 = client.field441.method2613();
                  var30 = class87.field1538 + (var29 >> 4 & 7);
                  var31 = (var29 & 7) + class34.field785;
                  var3 = client.field441.method2615();
                  var4 = client.field441.method2613();
                  var5 = var4 >> 4 & 15;
                  var6 = var4 & 7;
                  var7 = client.field441.method2613();
                  if(var30 >= 0 && var31 >= 0 && var30 < 104 && var31 < 104) {
                     var37 = var5 + 1;
                     if(class5.field93.field871[0] >= var30 - var37 && class5.field93.field871[0] <= var30 + var37 && class5.field93.field835[0] >= var31 - var37 && class5.field93.field835[0] <= var31 + var37 && client.field514 != 0 && var6 > 0 && client.field536 < 50) {
                        client.field537[client.field536] = var3;
                        client.field334[client.field536] = var6;
                        client.field539[client.field536] = var7;
                        client.field541[client.field536] = null;
                        client.field540[client.field536] = (var30 << 16) + (var31 << 8) + var5;
                        ++client.field536;
                     }
                  }
               }

               if(214 == client.field394) {
                  var29 = client.field441.method2613();
                  var30 = class87.field1538 + (var29 >> 4 & 7);
                  var31 = (var29 & 7) + class34.field785;
                  var3 = var30 + client.field441.method2699();
                  var4 = var31 + client.field441.method2699();
                  var5 = client.field441.method2664();
                  var6 = client.field441.method2615();
                  var7 = client.field441.method2613() * 4;
                  var37 = client.field441.method2613() * 4;
                  var9 = client.field441.method2615();
                  var10 = client.field441.method2615();
                  var11 = client.field441.method2613();
                  var12 = client.field441.method2613();
                  if(var30 >= 0 && var31 >= 0 && var30 < 104 && var31 < 104 && var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104 && '\uffff' != var6) {
                     var30 = 128 * var30 + 64;
                     var31 = 128 * var31 + 64;
                     var3 = 64 + 128 * var3;
                     var4 = 64 + var4 * 128;
                     class6 var42 = new class6(var6, class42.field1002, var30, var31, class34.method816(var30, var31, class42.field1002) - var7, var9 + client.field306, var10 + client.field306, var11, var12, var5, var37);
                     var42.method134(var3, var4, class34.method816(var3, var4, class42.field1002) - var37, var9 + client.field306);
                     client.field449.method3900(var42);
                  }

               } else if(client.field394 == 81) {
                  var29 = client.field441.method2640();
                  var30 = (var29 >> 4 & 7) + class87.field1538;
                  var31 = class34.field785 + (var29 & 7);
                  var3 = client.field441.method2648();
                  var4 = client.field441.method2648();
                  if(var30 >= 0 && var31 >= 0 && var30 < 104 && var31 < 104) {
                     var32 = new class28();
                     var32.field691 = var4;
                     var32.field689 = var3;
                     if(null == client.field425[class42.field1002][var30][var31]) {
                        client.field425[class42.field1002][var30][var31] = new class199();
                     }

                     client.field425[class42.field1002][var30][var31].method3900(var32);
                     class130.method2949(var30, var31);
                  }

               } else if(228 != client.field394) {
                  if(185 == client.field394) {
                     var29 = client.field441.method2597();
                     var30 = client.field441.method2640();
                     var31 = var30 >> 2;
                     var3 = var30 & 3;
                     var4 = client.field358[var31];
                     var5 = client.field441.method2613();
                     var6 = class87.field1538 + (var5 >> 4 & 7);
                     var7 = (var5 & 7) + class34.field785;
                     if(var6 >= 0 && var7 >= 0 && var6 < 104 && var7 < 104) {
                        class0.method1(class42.field1002, var6, var7, var4, var29, var31, var3, 0, -1);
                     }

                  }
               } else {
                  var29 = client.field441.method2639();
                  var30 = (var29 >> 4 & 7) + class87.field1538;
                  var31 = (var29 & 7) + class34.field785;
                  var3 = client.field441.method2613();
                  var4 = var3 >> 2;
                  var5 = var3 & 3;
                  var6 = client.field358[var4];
                  var7 = client.field441.method2648();
                  if(var30 >= 0 && var31 >= 0 && var30 < 103 && var31 < 103) {
                     if(0 == var6) {
                        class87 var38 = class30.field717.method2030(class42.field1002, var30, var31);
                        if(null != var38) {
                           var9 = var38.field1534 >> 14 & 32767;
                           if(2 == var4) {
                              var38.field1530 = new class12(var9, 2, 4 + var5, class42.field1002, var30, var31, var7, false, var38.field1530);
                              var38.field1528 = new class12(var9, 2, 1 + var5 & 3, class42.field1002, var30, var31, var7, false, var38.field1528);
                           } else {
                              var38.field1530 = new class12(var9, var4, var5, class42.field1002, var30, var31, var7, false, var38.field1530);
                           }
                        }
                     }

                     if(var6 == 1) {
                        class94 var39 = class30.field717.method2064(class42.field1002, var30, var31);
                        if(null != var39) {
                           var9 = var39.field1615 >> 14 & 32767;
                           if(4 != var4 && 5 != var4) {
                              if(var4 == 6) {
                                 var39.field1613 = new class12(var9, 4, 4 + var5, class42.field1002, var30, var31, var7, false, var39.field1613);
                              } else if(var4 == 7) {
                                 var39.field1613 = new class12(var9, 4, 4 + (2 + var5 & 3), class42.field1002, var30, var31, var7, false, var39.field1613);
                              } else if(8 == var4) {
                                 var39.field1613 = new class12(var9, 4, 4 + var5, class42.field1002, var30, var31, var7, false, var39.field1613);
                                 var39.field1614 = new class12(var9, 4, 4 + (var5 + 2 & 3), class42.field1002, var30, var31, var7, false, var39.field1614);
                              }
                           } else {
                              var39.field1613 = new class12(var9, 4, var5, class42.field1002, var30, var31, var7, false, var39.field1613);
                           }
                        }
                     }

                     if(var6 == 2) {
                        class98 var40 = class30.field717.method2032(class42.field1002, var30, var31);
                        if(var4 == 11) {
                           var4 = 10;
                        }

                        if(var40 != null) {
                           var40.field1673 = new class12(var40.field1668 >> 14 & 32767, var4, var5, class42.field1002, var30, var31, var7, false, var40.field1673);
                        }
                     }

                     if(var6 == 3) {
                        class93 var41 = class30.field717.method2033(class42.field1002, var30, var31);
                        if(null != var41) {
                           var41.field1598 = new class12(var41.field1599 >> 14 & 32767, 22, var5, class42.field1002, var30, var31, var7, false, var41.field1598);
                        }
                     }
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-59"
   )
   final void method2903() {
      int var9 = -1640531527;
      int var8 = -1640531527;
      int var7 = -1640531527;
      int var6 = -1640531527;
      int var5 = -1640531527;
      int var4 = -1640531527;
      int var3 = -1640531527;
      int var2 = -1640531527;

      int var1;
      for(var1 = 0; var1 < 4; ++var1) {
         var2 ^= var3 << 11;
         var5 += var2;
         var3 += var4;
         var3 ^= var4 >>> 2;
         var6 += var3;
         var4 += var5;
         var4 ^= var5 << 8;
         var7 += var4;
         var5 += var6;
         var5 ^= var6 >>> 16;
         var8 += var5;
         var6 += var7;
         var6 ^= var7 << 10;
         var9 += var6;
         var7 += var8;
         var7 ^= var8 >>> 4;
         var2 += var7;
         var8 += var9;
         var8 ^= var9 << 8;
         var3 += var8;
         var9 += var2;
         var9 ^= var2 >>> 9;
         var4 += var9;
         var2 += var3;
      }

      for(var1 = 0; var1 < 256; var1 += 8) {
         var2 += this.field2023[var1];
         var3 += this.field2023[1 + var1];
         var4 += this.field2023[var1 + 2];
         var5 += this.field2023[var1 + 3];
         var6 += this.field2023[4 + var1];
         var7 += this.field2023[5 + var1];
         var8 += this.field2023[var1 + 6];
         var9 += this.field2023[var1 + 7];
         var2 ^= var3 << 11;
         var5 += var2;
         var3 += var4;
         var3 ^= var4 >>> 2;
         var6 += var3;
         var4 += var5;
         var4 ^= var5 << 8;
         var7 += var4;
         var5 += var6;
         var5 ^= var6 >>> 16;
         var8 += var5;
         var6 += var7;
         var6 ^= var7 << 10;
         var9 += var6;
         var7 += var8;
         var7 ^= var8 >>> 4;
         var2 += var7;
         var8 += var9;
         var8 ^= var9 << 8;
         var3 += var8;
         var9 += var2;
         var9 ^= var2 >>> 9;
         var4 += var9;
         var2 += var3;
         this.field2029[var1] = var2;
         this.field2029[1 + var1] = var3;
         this.field2029[2 + var1] = var4;
         this.field2029[var1 + 3] = var5;
         this.field2029[4 + var1] = var6;
         this.field2029[var1 + 5] = var7;
         this.field2029[6 + var1] = var8;
         this.field2029[var1 + 7] = var9;
      }

      for(var1 = 0; var1 < 256; var1 += 8) {
         var2 += this.field2029[var1];
         var3 += this.field2029[var1 + 1];
         var4 += this.field2029[var1 + 2];
         var5 += this.field2029[3 + var1];
         var6 += this.field2029[4 + var1];
         var7 += this.field2029[5 + var1];
         var8 += this.field2029[6 + var1];
         var9 += this.field2029[var1 + 7];
         var2 ^= var3 << 11;
         var5 += var2;
         var3 += var4;
         var3 ^= var4 >>> 2;
         var6 += var3;
         var4 += var5;
         var4 ^= var5 << 8;
         var7 += var4;
         var5 += var6;
         var5 ^= var6 >>> 16;
         var8 += var5;
         var6 += var7;
         var6 ^= var7 << 10;
         var9 += var6;
         var7 += var8;
         var7 ^= var8 >>> 4;
         var2 += var7;
         var8 += var9;
         var8 ^= var9 << 8;
         var3 += var8;
         var9 += var2;
         var9 ^= var2 >>> 9;
         var4 += var9;
         var2 += var3;
         this.field2029[var1] = var2;
         this.field2029[1 + var1] = var3;
         this.field2029[2 + var1] = var4;
         this.field2029[3 + var1] = var5;
         this.field2029[4 + var1] = var6;
         this.field2029[5 + var1] = var7;
         this.field2029[var1 + 6] = var8;
         this.field2029[7 + var1] = var9;
      }

      this.method2895();
      this.field2020 = 256;
   }
}
