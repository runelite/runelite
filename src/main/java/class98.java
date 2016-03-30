import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cg")
@Implements("GameObject")
public final class class98 {
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -610602791
   )
   @Export("orientation")
   int field1672;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1048519731
   )
   @Export("height")
   int field1673;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1373455709
   )
   int field1674;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 919652661
   )
   @Export("y")
   int field1675;
   @ObfuscatedName("e")
   @Export("renderable")
   public class85 field1676;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -758674561
   )
   @Export("relativeY")
   int field1677;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -340592427
   )
   @Export("hash")
   public int field1678 = 0;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1100241117
   )
   @Export("offsetX")
   int field1679;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 968985653
   )
   @Export("plane")
   int field1680;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 105324149
   )
   @Export("offsetY")
   int field1681;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1013090005
   )
   @Export("flags")
   int field1682 = 0;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -517575469
   )
   int field1683;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -465950357
   )
   @Export("x")
   int field1684;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -505849877
   )
   @Export("relativeX")
   int field1685;

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "-905806299"
   )
   static final void method2189(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(var2 >= 1 && var3 >= 1 && var2 <= 102 && var3 <= 102) {
         if(client.field413 && var0 != class82.field1437) {
            return;
         }

         int var7 = 0;
         boolean var8 = true;
         boolean var9 = false;
         boolean var10 = false;
         if(0 == var1) {
            var7 = class3.field75.method1927(var0, var2, var3);
         }

         if(var1 == 1) {
            var7 = class3.field75.method1935(var0, var2, var3);
         }

         if(2 == var1) {
            var7 = class3.field75.method1936(var0, var2, var3);
         }

         if(3 == var1) {
            var7 = class3.field75.method1978(var0, var2, var3);
         }

         int var11;
         if(0 != var7) {
            var11 = class3.field75.method1938(var0, var2, var3, var7);
            int var32 = var7 >> 14 & 32767;
            int var33 = var11 & 31;
            int var34 = var11 >> 6 & 3;
            class40 var12;
            if(var1 == 0) {
               class3.field75.method1925(var0, var2, var3);
               var12 = class22.method592(var32);
               if(0 != var12.field931) {
                  client.field372[var0].method2423(var2, var3, var33, var34, var12.field977);
               }
            }

            if(var1 == 1) {
               class3.field75.method1926(var0, var2, var3);
            }

            if(var1 == 2) {
               class3.field75.method2064(var0, var2, var3);
               var12 = class22.method592(var32);
               if(var2 + var12.field979 > 103 || var3 + var12.field979 > 103 || var12.field942 + var2 > 103 || var3 + var12.field942 > 103) {
                  return;
               }

               if(0 != var12.field931) {
                  client.field372[var0].method2399(var2, var3, var12.field979, var12.field942, var34, var12.field977);
               }
            }

            if(var1 == 3) {
               class3.field75.method1990(var0, var2, var3);
               var12 = class22.method592(var32);
               if(var12.field931 == 1) {
                  client.field372[var0].method2401(var2, var3);
               }
            }
         }

         if(var4 >= 0) {
            var11 = var0;
            if(var0 < 3 && (class5.field109[1][var2][var3] & 2) == 2) {
               var11 = var0 + 1;
            }

            class86 var35 = class3.field75;
            class108 var13 = client.field372[var0];
            class40 var14 = class22.method592(var4);
            int var15;
            int var16;
            if(var5 != 1 && 3 != var5) {
               var15 = var14.field979;
               var16 = var14.field942;
            } else {
               var15 = var14.field942;
               var16 = var14.field979;
            }

            int var17;
            int var18;
            if(var2 + var15 <= 104) {
               var17 = var2 + (var15 >> 1);
               var18 = var2 + (1 + var15 >> 1);
            } else {
               var17 = var2;
               var18 = var2 + 1;
            }

            int var19;
            int var20;
            if(var3 + var16 <= 104) {
               var19 = (var16 >> 1) + var3;
               var20 = (1 + var16 >> 1) + var3;
            } else {
               var19 = var3;
               var20 = 1 + var3;
            }

            int[][] var21 = class5.field96[var11];
            int var22 = var21[var18][var20] + var21[var17][var19] + var21[var18][var19] + var21[var17][var20] >> 2;
            int var23 = (var2 << 7) + (var15 << 6);
            int var24 = (var16 << 6) + (var3 << 7);
            int var25 = (var4 << 14) + var2 + (var3 << 7) + 1073741824;
            if(0 == var14.field975) {
               var25 -= Integer.MIN_VALUE;
            }

            int var26 = var6 + (var5 << 6);
            if(1 == var14.field966) {
               var26 += 256;
            }

            Object var27;
            if(22 == var6) {
               if(-1 == var14.field949 && null == var14.field943) {
                  var27 = var14.method870(22, var5, var21, var23, var22, var24);
               } else {
                  var27 = new class12(var4, 22, var5, var11, var2, var3, var14.field949, true, (class85)null);
               }

               var35.method1914(var0, var2, var3, var22, (class85)var27, var25, var26);
               if(1 == var14.field931) {
                  var13.method2396(var2, var3);
               }
            } else if(var6 != 10 && 11 != var6) {
               if(var6 >= 12) {
                  if(-1 == var14.field949 && var14.field943 == null) {
                     var27 = var14.method870(var6, var5, var21, var23, var22, var24);
                  } else {
                     var27 = new class12(var4, var6, var5, var11, var2, var3, var14.field949, true, (class85)null);
                  }

                  var35.method1918(var0, var2, var3, var22, 1, 1, (class85)var27, 0, var25, var26);
                  if(var14.field931 != 0) {
                     var13.method2408(var2, var3, var15, var16, var14.field977);
                  }
               } else if(var6 == 0) {
                  if(-1 == var14.field949 && null == var14.field943) {
                     var27 = var14.method870(0, var5, var21, var23, var22, var24);
                  } else {
                     var27 = new class12(var4, 0, var5, var11, var2, var3, var14.field949, true, (class85)null);
                  }

                  var35.method1916(var0, var2, var3, var22, (class85)var27, (class85)null, class5.field100[var5], 0, var25, var26);
                  if(0 != var14.field931) {
                     var13.method2421(var2, var3, var6, var5, var14.field977);
                  }
               } else if(var6 == 1) {
                  if(-1 == var14.field949 && null == var14.field943) {
                     var27 = var14.method870(1, var5, var21, var23, var22, var24);
                  } else {
                     var27 = new class12(var4, 1, var5, var11, var2, var3, var14.field949, true, (class85)null);
                  }

                  var35.method1916(var0, var2, var3, var22, (class85)var27, (class85)null, class5.field101[var5], 0, var25, var26);
                  if(var14.field931 != 0) {
                     var13.method2421(var2, var3, var6, var5, var14.field977);
                  }
               } else {
                  Object var29;
                  int var37;
                  if(var6 == 2) {
                     var37 = 1 + var5 & 3;
                     Object var28;
                     if(var14.field949 == -1 && var14.field943 == null) {
                        var28 = var14.method870(2, 4 + var5, var21, var23, var22, var24);
                        var29 = var14.method870(2, var37, var21, var23, var22, var24);
                     } else {
                        var28 = new class12(var4, 2, 4 + var5, var11, var2, var3, var14.field949, true, (class85)null);
                        var29 = new class12(var4, 2, var37, var11, var2, var3, var14.field949, true, (class85)null);
                     }

                     var35.method1916(var0, var2, var3, var22, (class85)var28, (class85)var29, class5.field100[var5], class5.field100[var37], var25, var26);
                     if(var14.field931 != 0) {
                        var13.method2421(var2, var3, var6, var5, var14.field977);
                     }
                  } else if(var6 == 3) {
                     if(-1 == var14.field949 && var14.field943 == null) {
                        var27 = var14.method870(3, var5, var21, var23, var22, var24);
                     } else {
                        var27 = new class12(var4, 3, var5, var11, var2, var3, var14.field949, true, (class85)null);
                     }

                     var35.method1916(var0, var2, var3, var22, (class85)var27, (class85)null, class5.field101[var5], 0, var25, var26);
                     if(var14.field931 != 0) {
                        var13.method2421(var2, var3, var6, var5, var14.field977);
                     }
                  } else if(9 == var6) {
                     if(-1 == var14.field949 && var14.field943 == null) {
                        var27 = var14.method870(var6, var5, var21, var23, var22, var24);
                     } else {
                        var27 = new class12(var4, var6, var5, var11, var2, var3, var14.field949, true, (class85)null);
                     }

                     var35.method1918(var0, var2, var3, var22, 1, 1, (class85)var27, 0, var25, var26);
                     if(0 != var14.field931) {
                        var13.method2408(var2, var3, var15, var16, var14.field977);
                     }
                  } else if(var6 == 4) {
                     if(var14.field949 == -1 && var14.field943 == null) {
                        var27 = var14.method870(4, var5, var21, var23, var22, var24);
                     } else {
                        var27 = new class12(var4, 4, var5, var11, var2, var3, var14.field949, true, (class85)null);
                     }

                     var35.method1917(var0, var2, var3, var22, (class85)var27, (class85)null, class5.field100[var5], 0, 0, 0, var25, var26);
                  } else {
                     int var36;
                     if(var6 == 5) {
                        var37 = 16;
                        var36 = var35.method1927(var0, var2, var3);
                        if(var36 != 0) {
                           var37 = class22.method592(var36 >> 14 & 32767).field950;
                        }

                        if(-1 == var14.field949 && var14.field943 == null) {
                           var29 = var14.method870(4, var5, var21, var23, var22, var24);
                        } else {
                           var29 = new class12(var4, 4, var5, var11, var2, var3, var14.field949, true, (class85)null);
                        }

                        var35.method1917(var0, var2, var3, var22, (class85)var29, (class85)null, class5.field100[var5], 0, var37 * class5.field102[var5], class5.field103[var5] * var37, var25, var26);
                     } else if(6 == var6) {
                        var37 = 8;
                        var36 = var35.method1927(var0, var2, var3);
                        if(0 != var36) {
                           var37 = class22.method592(var36 >> 14 & 32767).field950 / 2;
                        }

                        if(-1 == var14.field949 && null == var14.field943) {
                           var29 = var14.method870(4, 4 + var5, var21, var23, var22, var24);
                        } else {
                           var29 = new class12(var4, 4, var5 + 4, var11, var2, var3, var14.field949, true, (class85)null);
                        }

                        var35.method1917(var0, var2, var3, var22, (class85)var29, (class85)null, 256, var5, class5.field98[var5] * var37, class5.field105[var5] * var37, var25, var26);
                     } else if(7 == var6) {
                        var36 = 2 + var5 & 3;
                        if(-1 == var14.field949 && var14.field943 == null) {
                           var27 = var14.method870(4, var36 + 4, var21, var23, var22, var24);
                        } else {
                           var27 = new class12(var4, 4, var36 + 4, var11, var2, var3, var14.field949, true, (class85)null);
                        }

                        var35.method1917(var0, var2, var3, var22, (class85)var27, (class85)null, 256, var36, 0, 0, var25, var26);
                     } else if(var6 == 8) {
                        var37 = 8;
                        var36 = var35.method1927(var0, var2, var3);
                        if(0 != var36) {
                           var37 = class22.method592(var36 >> 14 & 32767).field950 / 2;
                        }

                        int var31 = var5 + 2 & 3;
                        Object var30;
                        if(var14.field949 == -1 && var14.field943 == null) {
                           var29 = var14.method870(4, var5 + 4, var21, var23, var22, var24);
                           var30 = var14.method870(4, var31 + 4, var21, var23, var22, var24);
                        } else {
                           var29 = new class12(var4, 4, var5 + 4, var11, var2, var3, var14.field949, true, (class85)null);
                           var30 = new class12(var4, 4, 4 + var31, var11, var2, var3, var14.field949, true, (class85)null);
                        }

                        var35.method1917(var0, var2, var3, var22, (class85)var29, (class85)var30, 256, var5, var37 * class5.field98[var5], var37 * class5.field105[var5], var25, var26);
                     }
                  }
               }
            } else {
               if(var14.field949 == -1 && var14.field943 == null) {
                  var27 = var14.method870(10, var5, var21, var23, var22, var24);
               } else {
                  var27 = new class12(var4, 10, var5, var11, var2, var3, var14.field949, true, (class85)null);
               }

               if(var27 != null) {
                  var35.method1918(var0, var2, var3, var22, var15, var16, (class85)var27, 11 == var6?256:0, var25, var26);
               }

               if(var14.field931 != 0) {
                  var13.method2408(var2, var3, var15, var16, var14.field977);
               }
            }
         }
      }

   }
}
