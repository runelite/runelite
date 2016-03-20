import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("t")
public final class class16 extends class207 {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1815533953
   )
   int field227;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1083753451
   )
   int field228;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -300495749
   )
   int field229;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1489749899
   )
   int field232;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 935190917
   )
   int field233;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1026292499
   )
   int field234;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -898973085
   )
   int field235;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1533828955
   )
   int field236;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -858607461
   )
   int field237 = 0;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -972635857
   )
   int field238 = -1;
   @ObfuscatedName("i")
   static int[] field240;
   @ObfuscatedName("dy")
   static int[][] field241;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 796026963
   )
   int field242;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 559124531
   )
   int field244;

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1777096375"
   )
   static final void method199() {
      int var1;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      int var9;
      int var10;
      int var11;
      int var12;
      if(client.field488 == 108) {
         byte var0 = client.field472.method2539();
         var1 = client.field472.method2546();
         byte var2 = client.field472.method2542();
         byte var3 = client.field472.method2539();
         var4 = client.field472.method2514();
         var5 = client.field472.method2538();
         var6 = (var5 >> 4 & 7) + class4.field66;
         var7 = (var5 & 7) + class6.field124;
         var8 = client.field472.method2546();
         var9 = client.field472.method2690();
         var10 = client.field472.method2538();
         var11 = var10 >> 2;
         var12 = var10 & 3;
         int var13 = client.field397[var11];
         byte var14 = client.field472.method2542();
         class2 var15;
         if(client.field416 == var9) {
            var15 = class151.field2253;
         } else {
            var15 = client.field415[var9];
         }

         if(null != var15) {
            class40 var16 = class156.method3176(var8);
            int var17;
            int var18;
            if(1 != var12 && 3 != var12) {
               var17 = var16.field938;
               var18 = var16.field939;
            } else {
               var17 = var16.field939;
               var18 = var16.field938;
            }

            int var19 = var6 + (var17 >> 1);
            int var20 = (1 + var17 >> 1) + var6;
            int var21 = (var18 >> 1) + var7;
            int var22 = (var18 + 1 >> 1) + var7;
            int[][] var23 = class5.field86[class48.field1078];
            int var24 = var23[var19][var21] + var23[var20][var21] + var23[var19][var22] + var23[var20][var22] >> 2;
            int var25 = (var6 << 7) + (var17 << 6);
            int var26 = (var18 << 6) + (var7 << 7);
            class104 var27 = var16.method812(var11, var12, var23, var25, var24, var26);
            if(null != var27) {
               class180.method3547(class48.field1078, var6, var7, var13, -1, 0, 0, 1 + var4, var1 + 1);
               var15.field34 = client.field303 + var4;
               var15.field35 = client.field303 + var1;
               var15.field39 = var27;
               var15.field46 = 64 * var17 + 128 * var6;
               var15.field42 = var7 * 128 + 64 * var18;
               var15.field37 = var24;
               byte var28;
               if(var14 > var2) {
                  var28 = var14;
                  var14 = var2;
                  var2 = var28;
               }

               if(var3 > var0) {
                  var28 = var3;
                  var3 = var0;
                  var0 = var28;
               }

               var15.field25 = var6 + var14;
               var15.field51 = var6 + var2;
               var15.field41 = var7 + var3;
               var15.field50 = var7 + var0;
            }
         }
      }

      int var29;
      int var30;
      int var31;
      if(client.field488 == 244) {
         var29 = client.field472.method2579();
         var1 = (var29 >> 4 & 7) + class4.field66;
         var30 = class6.field124 + (var29 & 7);
         var31 = client.field472.method2514();
         var4 = client.field472.method2514();
         var5 = client.field472.method2514();
         if(var1 >= 0 && var30 >= 0 && var1 < 104 && var30 < 104) {
            class198 var35 = client.field419[class48.field1078][var1][var30];
            if(null != var35) {
               for(class28 var36 = (class28)var35.method3860(); null != var36; var36 = (class28)var35.method3861()) {
                  if(var36.field681 == (var31 & 32767) && var36.field677 == var4) {
                     var36.field677 = var5;
                     break;
                  }
               }

               class166.method3355(var1, var30);
            }
         }

      } else if(client.field488 == 200) {
         var29 = client.field472.method2540();
         var1 = var29 >> 2;
         var30 = var29 & 3;
         var31 = client.field397[var1];
         var4 = client.field472.method2642();
         var5 = class4.field66 + (var4 >> 4 & 7);
         var6 = (var4 & 7) + class6.field124;
         if(var5 >= 0 && var6 >= 0 && var5 < 104 && var6 < 104) {
            class180.method3547(class48.field1078, var5, var6, var31, -1, var1, var30, 0, -1);
         }

      } else {
         if(client.field488 == 184) {
            var29 = client.field472.method2579();
            var1 = class4.field66 + (var29 >> 4 & 7);
            var30 = class6.field124 + (var29 & 7);
            var31 = client.field472.method2514();
            var4 = client.field472.method2579();
            var5 = var4 >> 4 & 15;
            var6 = var4 & 7;
            var7 = client.field472.method2579();
            if(var1 >= 0 && var30 >= 0 && var1 < 104 && var30 < 104) {
               var8 = var5 + 1;
               if(class151.field2253.field866[0] >= var1 - var8 && class151.field2253.field866[0] <= var8 + var1 && class151.field2253.field867[0] >= var30 - var8 && class151.field2253.field867[0] <= var8 + var30 && client.field535 != 0 && var6 > 0 && client.field536 < 50) {
                  client.field326[client.field536] = var31;
                  client.field538[client.field536] = var6;
                  client.field539[client.field536] = var7;
                  client.field541[client.field536] = null;
                  client.field503[client.field536] = var5 + (var30 << 8) + (var1 << 16);
                  ++client.field536;
               }
            }
         }

         class28 var33;
         if(240 == client.field488) {
            var29 = client.field472.method2579();
            var1 = (var29 >> 4 & 7) + class4.field66;
            var30 = (var29 & 7) + class6.field124;
            var31 = client.field472.method2690();
            if(var1 >= 0 && var30 >= 0 && var1 < 104 && var30 < 104) {
               class198 var32 = client.field419[class48.field1078][var1][var30];
               if(var32 != null) {
                  for(var33 = (class28)var32.method3860(); var33 != null; var33 = (class28)var32.method3861()) {
                     if(var33.field681 == (var31 & 32767)) {
                        var33.method3946();
                        break;
                     }
                  }

                  if(var32.method3860() == null) {
                     client.field419[class48.field1078][var1][var30] = null;
                  }

                  class166.method3355(var1, var30);
               }
            }

         } else if(215 == client.field488) {
            var29 = client.field472.method2579();
            var1 = var29 >> 2;
            var30 = var29 & 3;
            var31 = client.field397[var1];
            var4 = client.field472.method2547();
            var5 = client.field472.method2579();
            var6 = class4.field66 + (var5 >> 4 & 7);
            var7 = class6.field124 + (var5 & 7);
            if(var6 >= 0 && var7 >= 0 && var6 < 104 && var7 < 104) {
               class180.method3547(class48.field1078, var6, var7, var31, var4, var1, var30, 0, -1);
            }

         } else if(client.field488 == 112) {
            var29 = client.field472.method2579();
            var1 = class4.field66 + (var29 >> 4 & 7);
            var30 = (var29 & 7) + class6.field124;
            var31 = client.field472.method2514();
            var4 = client.field472.method2579();
            var5 = client.field472.method2514();
            if(var1 >= 0 && var30 >= 0 && var1 < 104 && var30 < 104) {
               var1 = 64 + var1 * 128;
               var30 = 64 + 128 * var30;
               class29 var34 = new class29(var31, class48.field1078, var1, var30, class4.method52(var1, var30, class48.field1078) - var4, var5, client.field303);
               client.field429.method3855(var34);
            }

         } else if(client.field488 == 100) {
            var29 = client.field472.method2690();
            var1 = client.field472.method2514();
            var30 = client.field472.method2540();
            var31 = class4.field66 + (var30 >> 4 & 7);
            var4 = class6.field124 + (var30 & 7);
            if(var31 >= 0 && var4 >= 0 && var31 < 104 && var4 < 104) {
               var33 = new class28();
               var33.field681 = var1;
               var33.field677 = var29;
               if(null == client.field419[class48.field1078][var31][var4]) {
                  client.field419[class48.field1078][var31][var4] = new class198();
               }

               client.field419[class48.field1078][var31][var4].method3855(var33);
               class166.method3355(var31, var4);
            }

         } else if(117 != client.field488) {
            if(96 == client.field488) {
               var29 = client.field472.method2579();
               var1 = class4.field66 + (var29 >> 4 & 7);
               var30 = class6.field124 + (var29 & 7);
               var31 = var1 + client.field472.method2707();
               var4 = var30 + client.field472.method2707();
               var5 = client.field472.method2515();
               var6 = client.field472.method2514();
               var7 = client.field472.method2579() * 4;
               var8 = client.field472.method2579() * 4;
               var9 = client.field472.method2514();
               var10 = client.field472.method2514();
               var11 = client.field472.method2579();
               var12 = client.field472.method2579();
               if(var1 >= 0 && var30 >= 0 && var1 < 104 && var30 < 104 && var31 >= 0 && var4 >= 0 && var31 < 104 && var4 < 104 && var6 != '\uffff') {
                  var1 = 64 + var1 * 128;
                  var30 = 128 * var30 + 64;
                  var31 = var31 * 128 + 64;
                  var4 = 128 * var4 + 64;
                  class6 var41 = new class6(var6, class48.field1078, var1, var30, class4.method52(var1, var30, class48.field1078) - var7, client.field303 + var9, var10 + client.field303, var11, var12, var5, var8);
                  var41.method103(var31, var4, class4.method52(var31, var4, class48.field1078) - var8, var9 + client.field303);
                  client.field385.method3855(var41);
               }

            }
         } else {
            var29 = client.field472.method2690();
            var1 = client.field472.method2540();
            var30 = (var1 >> 4 & 7) + class4.field66;
            var31 = (var1 & 7) + class6.field124;
            var4 = client.field472.method2538();
            var5 = var4 >> 2;
            var6 = var4 & 3;
            var7 = client.field397[var5];
            if(var30 >= 0 && var31 >= 0 && var30 < 103 && var31 < 103) {
               if(0 == var7) {
                  class86 var37 = class77.field1396.method2090(class48.field1078, var30, var31);
                  if(var37 != null) {
                     var9 = var37.field1513 >> 14 & 32767;
                     if(2 == var5) {
                        var37.field1516 = new class12(var9, 2, var6 + 4, class48.field1078, var30, var31, var29, false, var37.field1516);
                        var37.field1517 = new class12(var9, 2, 1 + var6 & 3, class48.field1078, var30, var31, var29, false, var37.field1517);
                     } else {
                        var37.field1516 = new class12(var9, var5, var6, class48.field1078, var30, var31, var29, false, var37.field1516);
                     }
                  }
               }

               if(1 == var7) {
                  class93 var38 = class77.field1396.method1992(class48.field1078, var30, var31);
                  if(null != var38) {
                     var9 = var38.field1598 >> 14 & 32767;
                     if(var5 != 4 && var5 != 5) {
                        if(6 == var5) {
                           var38.field1596 = new class12(var9, 4, var6 + 4, class48.field1078, var30, var31, var29, false, var38.field1596);
                        } else if(var5 == 7) {
                           var38.field1596 = new class12(var9, 4, (2 + var6 & 3) + 4, class48.field1078, var30, var31, var29, false, var38.field1596);
                        } else if(var5 == 8) {
                           var38.field1596 = new class12(var9, 4, var6 + 4, class48.field1078, var30, var31, var29, false, var38.field1596);
                           var38.field1597 = new class12(var9, 4, 4 + (2 + var6 & 3), class48.field1078, var30, var31, var29, false, var38.field1597);
                        }
                     } else {
                        var38.field1596 = new class12(var9, 4, var6, class48.field1078, var30, var31, var29, false, var38.field1596);
                     }
                  }
               }

               if(2 == var7) {
                  class97 var39 = class77.field1396.method1946(class48.field1078, var30, var31);
                  if(var5 == 11) {
                     var5 = 10;
                  }

                  if(null != var39) {
                     var39.field1654 = new class12(var39.field1653 >> 14 & 32767, var5, var6, class48.field1078, var30, var31, var29, false, var39.field1654);
                  }
               }

               if(3 == var7) {
                  class92 var40 = class77.field1396.method1947(class48.field1078, var30, var31);
                  if(null != var40) {
                     var40.field1582 = new class12(var40.field1583 >> 14 & 32767, 22, var6, class48.field1078, var30, var31, var29, false, var40.field1582);
                  }
               }
            }

         }
      }
   }

   @ObfuscatedName("l")
   static final int method200(int var0, int var1, int var2) {
      int var3 = var0 / var2;
      int var4 = var0 & var2 - 1;
      int var5 = var1 / var2;
      int var6 = var1 & var2 - 1;
      int var7 = class122.method2779(var3, var5);
      int var8 = class122.method2779(1 + var3, var5);
      int var9 = class122.method2779(var3, var5 + 1);
      int var10 = class122.method2779(1 + var3, var5 + 1);
      int var11 = class1.method15(var7, var8, var4, var2);
      int var12 = class1.method15(var9, var10, var4, var2);
      return class1.method15(var11, var12, var6, var2);
   }

   @ObfuscatedName("j")
   public static class78 method201() {
      class78 var0 = new class78();
      var0.field1402 = class76.field1379;
      var0.field1403 = class76.field1381;
      var0.field1400 = class76.field1386[0];
      var0.field1405 = class76.field1382[0];
      var0.field1399 = class102.field1764[0];
      var0.field1401 = class76.field1383[0];
      int var1 = var0.field1401 * var0.field1399;
      byte[] var2 = class30.field708[0];
      var0.field1397 = new int[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         var0.field1397[var3] = class115.field1968[var2[var3] & 255];
      }

      class1.method7();
      return var0;
   }

   @ObfuscatedName("r")
   static final boolean method202(int var0, int var1, class106 var2, class107 var3) {
      int var4 = var0;
      int var5 = var1;
      byte var6 = 64;
      byte var7 = 64;
      int var8 = var0 - var6;
      int var9 = var1 - var7;
      class105.field1854[var6][var7] = 99;
      class105.field1856[var6][var7] = 0;
      byte var10 = 0;
      int var11 = 0;
      class105.field1852[var10] = var0;
      byte var10001 = var10;
      int var18 = var10 + 1;
      class105.field1860[var10001] = var1;
      int[][] var12 = var3.field1888;

      while(var18 != var11) {
         var4 = class105.field1852[var11];
         var5 = class105.field1860[var11];
         var11 = var11 + 1 & 4095;
         int var16 = var4 - var8;
         int var17 = var5 - var9;
         int var13 = var4 - var3.field1884;
         int var14 = var5 - var3.field1885;
         if(var2.vmethod2388(var4, var5)) {
            class105.field1857 = var4;
            class105.field1855 = var5;
            return true;
         }

         int var15 = 1 + class105.field1856[var16][var17];
         if(var16 > 0 && 0 == class105.field1854[var16 - 1][var17] && 0 == (var12[var13 - 1][var14] & 19136782) && (var12[var13 - 1][1 + var14] & 19136824) == 0) {
            class105.field1852[var18] = var4 - 1;
            class105.field1860[var18] = var5;
            var18 = 1 + var18 & 4095;
            class105.field1854[var16 - 1][var17] = 2;
            class105.field1856[var16 - 1][var17] = var15;
         }

         if(var16 < 126 && 0 == class105.field1854[1 + var16][var17] && (var12[var13 + 2][var14] & 19136899) == 0 && (var12[2 + var13][var14 + 1] & 19136992) == 0) {
            class105.field1852[var18] = var4 + 1;
            class105.field1860[var18] = var5;
            var18 = 1 + var18 & 4095;
            class105.field1854[var16 + 1][var17] = 8;
            class105.field1856[var16 + 1][var17] = var15;
         }

         if(var17 > 0 && 0 == class105.field1854[var16][var17 - 1] && 0 == (var12[var13][var14 - 1] & 19136782) && 0 == (var12[1 + var13][var14 - 1] & 19136899)) {
            class105.field1852[var18] = var4;
            class105.field1860[var18] = var5 - 1;
            var18 = 1 + var18 & 4095;
            class105.field1854[var16][var17 - 1] = 1;
            class105.field1856[var16][var17 - 1] = var15;
         }

         if(var17 < 126 && 0 == class105.field1854[var16][1 + var17] && (var12[var13][2 + var14] & 19136824) == 0 && (var12[1 + var13][2 + var14] & 19136992) == 0) {
            class105.field1852[var18] = var4;
            class105.field1860[var18] = var5 + 1;
            var18 = 1 + var18 & 4095;
            class105.field1854[var16][1 + var17] = 4;
            class105.field1856[var16][var17 + 1] = var15;
         }

         if(var16 > 0 && var17 > 0 && class105.field1854[var16 - 1][var17 - 1] == 0 && (var12[var13 - 1][var14] & 19136830) == 0 && (var12[var13 - 1][var14 - 1] & 19136782) == 0 && (var12[var13][var14 - 1] & 19136911) == 0) {
            class105.field1852[var18] = var4 - 1;
            class105.field1860[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class105.field1854[var16 - 1][var17 - 1] = 3;
            class105.field1856[var16 - 1][var17 - 1] = var15;
         }

         if(var16 < 126 && var17 > 0 && class105.field1854[var16 + 1][var17 - 1] == 0 && (var12[1 + var13][var14 - 1] & 19136911) == 0 && (var12[var13 + 2][var14 - 1] & 19136899) == 0 && 0 == (var12[2 + var13][var14] & 19136995)) {
            class105.field1852[var18] = var4 + 1;
            class105.field1860[var18] = var5 - 1;
            var18 = 1 + var18 & 4095;
            class105.field1854[1 + var16][var17 - 1] = 9;
            class105.field1856[1 + var16][var17 - 1] = var15;
         }

         if(var16 > 0 && var17 < 126 && class105.field1854[var16 - 1][var17 + 1] == 0 && 0 == (var12[var13 - 1][var14 + 1] & 19136830) && (var12[var13 - 1][2 + var14] & 19136824) == 0 && 0 == (var12[var13][2 + var14] & 19137016)) {
            class105.field1852[var18] = var4 - 1;
            class105.field1860[var18] = var5 + 1;
            var18 = 1 + var18 & 4095;
            class105.field1854[var16 - 1][1 + var17] = 6;
            class105.field1856[var16 - 1][var17 + 1] = var15;
         }

         if(var16 < 126 && var17 < 126 && class105.field1854[var16 + 1][var17 + 1] == 0 && 0 == (var12[var13 + 1][var14 + 2] & 19137016) && 0 == (var12[var13 + 2][var14 + 2] & 19136992) && (var12[var13 + 2][var14 + 1] & 19136995) == 0) {
            class105.field1852[var18] = 1 + var4;
            class105.field1860[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class105.field1854[var16 + 1][var17 + 1] = 12;
            class105.field1856[var16 + 1][1 + var17] = var15;
         }
      }

      class105.field1857 = var4;
      class105.field1855 = var5;
      return false;
   }

   @ObfuscatedName("p")
   static final void method203() {
      for(int var0 = 0; var0 < client.field536; ++var0) {
         --client.field539[var0];
         if(client.field539[var0] >= -10) {
            class58 var9 = client.field541[var0];
            if(var9 == null) {
               class58 var10000 = (class58)null;
               var9 = class58.method1272(class12.field181, client.field326[var0], 0);
               if(null == var9) {
                  continue;
               }

               client.field539[var0] += var9.method1265();
               client.field541[var0] = var9;
            }

            if(client.field539[var0] < 0) {
               int var2;
               if(0 != client.field503[var0]) {
                  int var3 = (client.field503[var0] & 255) * 128;
                  int var4 = client.field503[var0] >> 16 & 255;
                  int var5 = 64 + var4 * 128 - class151.field2253.field870;
                  if(var5 < 0) {
                     var5 = -var5;
                  }

                  int var6 = client.field503[var0] >> 8 & 255;
                  int var7 = 128 * var6 + 64 - class151.field2253.field813;
                  if(var7 < 0) {
                     var7 = -var7;
                  }

                  int var8 = var5 + var7 - 128;
                  if(var8 > var3) {
                     client.field539[var0] = -100;
                     continue;
                  }

                  if(var8 < 0) {
                     var8 = 0;
                  }

                  var2 = client.field535 * (var3 - var8) / var3;
               } else {
                  var2 = client.field534;
               }

               if(var2 > 0) {
                  class62 var10 = var9.method1270().method1305(class9.field150);
                  class64 var11 = class64.method1432(var10, 100, var2);
                  var11.method1329(client.field538[var0] - 1);
                  class40.field973.method1152(var11);
               }

               client.field539[var0] = -100;
            }
         } else {
            --client.field536;

            for(int var1 = var0; var1 < client.field536; ++var1) {
               client.field326[var1] = client.field326[var1 + 1];
               client.field541[var1] = client.field541[1 + var1];
               client.field538[var1] = client.field538[1 + var1];
               client.field539[var1] = client.field539[1 + var1];
               client.field503[var1] = client.field503[var1 + 1];
            }

            --var0;
         }
      }

      if(client.field533 && !class42.method905()) {
         if(client.field531 != 0 && -1 != client.field532) {
            class86.method2097(class129.field2054, client.field532, 0, client.field531, false);
         }

         client.field533 = false;
      }

   }

   @ObfuscatedName("r")
   public static int method204(int var0, int var1) {
      int var2;
      if(var1 > var0) {
         var2 = var0;
         var0 = var1;
         var1 = var2;
      }

      while(0 != var1) {
         var2 = var0 % var1;
         var0 = var1;
         var1 = var2;
      }

      return var0;
   }
}
