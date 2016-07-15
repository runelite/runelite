import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fa")
public class class169 {
   @ObfuscatedName("b")
   public static int[] field2703;
   @ObfuscatedName("di")
   @ObfuscatedGetter(
      intValue = 721493941
   )
   static int field2706;

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "-1254263667"
   )
   static final void method3334(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(var2 >= 1 && var3 >= 1 && var2 <= 102 && var3 <= 102) {
         if(client.field298 && class50.field1119 != var0) {
            return;
         }

         int var7 = 0;
         boolean var8 = true;
         boolean var9 = false;
         boolean var10 = false;
         if(var1 == 0) {
            var7 = class79.field1453.method2029(var0, var2, var3);
         }

         if(var1 == 1) {
            var7 = class79.field1453.method2050(var0, var2, var3);
         }

         if(var1 == 2) {
            var7 = class79.field1453.method2152(var0, var2, var3);
         }

         if(var1 == 3) {
            var7 = class79.field1453.method2165(var0, var2, var3);
         }

         int var11;
         if(var7 != 0) {
            var11 = class79.field1453.method2039(var0, var2, var3, var7);
            int var34 = var7 >> 14 & 32767;
            int var35 = var11 & 31;
            int var36 = var11 >> 6 & 3;
            class42 var12;
            if(var1 == 0) {
               class79.field1453.method2026(var0, var2, var3);
               var12 = class146.method3102(var34);
               if(var12.field976 != 0) {
                  client.field407[var0].method2472(var2, var3, var35, var36, var12.field977);
               }
            }

            if(var1 == 1) {
               class79.field1453.method2027(var0, var2, var3);
            }

            if(var1 == 2) {
               class79.field1453.method2028(var0, var2, var3);
               var12 = class146.method3102(var34);
               if(var2 + var12.field959 > 103 || var3 + var12.field959 > 103 || var12.field1000 + var2 > 103 || var3 + var12.field1000 > 103) {
                  return;
               }

               if(var12.field976 != 0) {
                  client.field407[var0].method2478(var2, var3, var12.field959, var12.field1000, var36, var12.field977);
               }
            }

            if(var1 == 3) {
               class79.field1453.method2032(var0, var2, var3);
               var12 = class146.method3102(var34);
               if(var12.field976 == 1) {
                  client.field407[var0].method2480(var2, var3);
               }
            }
         }

         if(var4 >= 0) {
            var11 = var0;
            if(var0 < 3 && (class5.field89[1][var2][var3] & 2) == 2) {
               var11 = var0 + 1;
            }

            class89 var37 = class79.field1453;
            class111 var13 = client.field407[var0];
            class42 var14 = class146.method3102(var4);
            int var15;
            int var16;
            if(var5 != 1 && var5 != 3) {
               var15 = var14.field959;
               var16 = var14.field1000;
            } else {
               var15 = var14.field1000;
               var16 = var14.field959;
            }

            int var17;
            int var18;
            if(var15 + var2 <= 104) {
               var17 = (var15 >> 1) + var2;
               var18 = (1 + var15 >> 1) + var2;
            } else {
               var17 = var2;
               var18 = 1 + var2;
            }

            int var19;
            int var20;
            if(var16 + var3 <= 104) {
               var19 = var3 + (var16 >> 1);
               var20 = (1 + var16 >> 1) + var3;
            } else {
               var19 = var3;
               var20 = 1 + var3;
            }

            int[][] var21 = class5.field78[var11];
            int var22 = var21[var18][var20] + var21[var18][var19] + var21[var17][var19] + var21[var17][var20] >> 2;
            int var23 = (var15 << 6) + (var2 << 7);
            int var24 = (var16 << 6) + (var3 << 7);
            int var25 = (var4 << 14) + var2 + (var3 << 7) + 1073741824;
            if(var14.field971 == 0) {
               var25 -= Integer.MIN_VALUE;
            }

            int var26 = (var5 << 6) + var6;
            if(var14.field999 == 1) {
               var26 += 256;
            }

            Object var27;
            if(var6 == 22) {
               if(var14.field982 == -1 && var14.field969 == null) {
                  var27 = var14.method844(22, var5, var21, var23, var22, var24);
               } else {
                  var27 = new class12(var4, 22, var5, var11, var2, var3, var14.field982, true, (class88)null);
               }

               var37.method2015(var0, var2, var3, var22, (class88)var27, var25, var26);
               if(var14.field976 == 1) {
                  var13.method2475(var2, var3);
               }
            } else if(var6 != 10 && var6 != 11) {
               if(var6 >= 12) {
                  if(var14.field982 == -1 && var14.field969 == null) {
                     var27 = var14.method844(var6, var5, var21, var23, var22, var24);
                  } else {
                     var27 = new class12(var4, var6, var5, var11, var2, var3, var14.field982, true, (class88)null);
                  }

                  var37.method2019(var0, var2, var3, var22, 1, 1, (class88)var27, 0, var25, var26);
                  if(var14.field976 != 0) {
                     var13.method2501(var2, var3, var15, var16, var14.field977);
                  }
               } else if(var6 == 0) {
                  if(var14.field982 == -1 && var14.field969 == null) {
                     var27 = var14.method844(0, var5, var21, var23, var22, var24);
                  } else {
                     var27 = new class12(var4, 0, var5, var11, var2, var3, var14.field982, true, (class88)null);
                  }

                  var37.method2017(var0, var2, var3, var22, (class88)var27, (class88)null, class5.field87[var5], 0, var25, var26);
                  if(var14.field976 != 0) {
                     var13.method2474(var2, var3, var6, var5, var14.field977);
                  }
               } else if(var6 == 1) {
                  if(var14.field982 == -1 && var14.field969 == null) {
                     var27 = var14.method844(1, var5, var21, var23, var22, var24);
                  } else {
                     var27 = new class12(var4, 1, var5, var11, var2, var3, var14.field982, true, (class88)null);
                  }

                  var37.method2017(var0, var2, var3, var22, (class88)var27, (class88)null, class5.field77[var5], 0, var25, var26);
                  if(var14.field976 != 0) {
                     var13.method2474(var2, var3, var6, var5, var14.field977);
                  }
               } else {
                  Object var29;
                  int var33;
                  if(var6 == 2) {
                     var33 = var5 + 1 & 3;
                     Object var28;
                     if(var14.field982 == -1 && var14.field969 == null) {
                        var28 = var14.method844(2, var5 + 4, var21, var23, var22, var24);
                        var29 = var14.method844(2, var33, var21, var23, var22, var24);
                     } else {
                        var28 = new class12(var4, 2, 4 + var5, var11, var2, var3, var14.field982, true, (class88)null);
                        var29 = new class12(var4, 2, var33, var11, var2, var3, var14.field982, true, (class88)null);
                     }

                     var37.method2017(var0, var2, var3, var22, (class88)var28, (class88)var29, class5.field87[var5], class5.field87[var33], var25, var26);
                     if(var14.field976 != 0) {
                        var13.method2474(var2, var3, var6, var5, var14.field977);
                     }
                  } else if(var6 == 3) {
                     if(var14.field982 == -1 && var14.field969 == null) {
                        var27 = var14.method844(3, var5, var21, var23, var22, var24);
                     } else {
                        var27 = new class12(var4, 3, var5, var11, var2, var3, var14.field982, true, (class88)null);
                     }

                     var37.method2017(var0, var2, var3, var22, (class88)var27, (class88)null, class5.field77[var5], 0, var25, var26);
                     if(var14.field976 != 0) {
                        var13.method2474(var2, var3, var6, var5, var14.field977);
                     }
                  } else if(var6 == 9) {
                     if(var14.field982 == -1 && null == var14.field969) {
                        var27 = var14.method844(var6, var5, var21, var23, var22, var24);
                     } else {
                        var27 = new class12(var4, var6, var5, var11, var2, var3, var14.field982, true, (class88)null);
                     }

                     var37.method2019(var0, var2, var3, var22, 1, 1, (class88)var27, 0, var25, var26);
                     if(var14.field976 != 0) {
                        var13.method2501(var2, var3, var15, var16, var14.field977);
                     }
                  } else if(var6 == 4) {
                     if(var14.field982 == -1 && var14.field969 == null) {
                        var27 = var14.method844(4, var5, var21, var23, var22, var24);
                     } else {
                        var27 = new class12(var4, 4, var5, var11, var2, var3, var14.field982, true, (class88)null);
                     }

                     var37.method2133(var0, var2, var3, var22, (class88)var27, (class88)null, class5.field87[var5], 0, 0, 0, var25, var26);
                  } else {
                     int var32;
                     if(var6 == 5) {
                        var33 = 16;
                        var32 = var37.method2029(var0, var2, var3);
                        if(var32 != 0) {
                           var33 = class146.method3102(var32 >> 14 & 32767).field960;
                        }

                        if(var14.field982 == -1 && var14.field969 == null) {
                           var29 = var14.method844(4, var5, var21, var23, var22, var24);
                        } else {
                           var29 = new class12(var4, 4, var5, var11, var2, var3, var14.field982, true, (class88)null);
                        }

                        var37.method2133(var0, var2, var3, var22, (class88)var29, (class88)null, class5.field87[var5], 0, class5.field88[var5] * var33, var33 * class5.field90[var5], var25, var26);
                     } else if(var6 == 6) {
                        var33 = 8;
                        var32 = var37.method2029(var0, var2, var3);
                        if(var32 != 0) {
                           var33 = class146.method3102(var32 >> 14 & 32767).field960 / 2;
                        }

                        if(var14.field982 == -1 && var14.field969 == null) {
                           var29 = var14.method844(4, 4 + var5, var21, var23, var22, var24);
                        } else {
                           var29 = new class12(var4, 4, 4 + var5, var11, var2, var3, var14.field982, true, (class88)null);
                        }

                        var37.method2133(var0, var2, var3, var22, (class88)var29, (class88)null, 256, var5, var33 * class5.field82[var5], class5.field92[var5] * var33, var25, var26);
                     } else if(var6 == 7) {
                        var32 = 2 + var5 & 3;
                        if(var14.field982 == -1 && var14.field969 == null) {
                           var27 = var14.method844(4, 4 + var32, var21, var23, var22, var24);
                        } else {
                           var27 = new class12(var4, 4, var32 + 4, var11, var2, var3, var14.field982, true, (class88)null);
                        }

                        var37.method2133(var0, var2, var3, var22, (class88)var27, (class88)null, 256, var32, 0, 0, var25, var26);
                     } else if(var6 == 8) {
                        var33 = 8;
                        var32 = var37.method2029(var0, var2, var3);
                        if(var32 != 0) {
                           var33 = class146.method3102(var32 >> 14 & 32767).field960 / 2;
                        }

                        int var31 = 2 + var5 & 3;
                        Object var30;
                        if(var14.field982 == -1 && null == var14.field969) {
                           var29 = var14.method844(4, 4 + var5, var21, var23, var22, var24);
                           var30 = var14.method844(4, 4 + var31, var21, var23, var22, var24);
                        } else {
                           var29 = new class12(var4, 4, var5 + 4, var11, var2, var3, var14.field982, true, (class88)null);
                           var30 = new class12(var4, 4, 4 + var31, var11, var2, var3, var14.field982, true, (class88)null);
                        }

                        var37.method2133(var0, var2, var3, var22, (class88)var29, (class88)var30, 256, var5, var33 * class5.field82[var5], class5.field92[var5] * var33, var25, var26);
                     }
                  }
               }
            } else {
               if(var14.field982 == -1 && null == var14.field969) {
                  var27 = var14.method844(10, var5, var21, var23, var22, var24);
               } else {
                  var27 = new class12(var4, 10, var5, var11, var2, var3, var14.field982, true, (class88)null);
               }

               if(var27 != null) {
                  var37.method2019(var0, var2, var3, var22, var15, var16, (class88)var27, var6 == 11?256:0, var25, var26);
               }

               if(var14.field976 != 0) {
                  var13.method2501(var2, var3, var15, var16, var14.field977);
               }
            }
         }
      }

   }
}
