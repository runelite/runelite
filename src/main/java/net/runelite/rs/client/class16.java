package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("g")
public final class class16 extends class207 {
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 2135629839
   )
   int field222 = 0;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1653725111
   )
   int field223;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1577517243
   )
   int field224;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1725931777
   )
   int field225;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1787601127
   )
   int field226;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 2008387653
   )
   int field227;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1965592391
   )
   int field228;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1321133751
   )
   int field229;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 916422901
   )
   int field230;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1794221867
   )
   int field231;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1721090027
   )
   int field232;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1480991299
   )
   int field233 = -1;
   @ObfuscatedName("nb")
   static class55 field235;

   @ObfuscatedName("m")
   public static int method209(int var0) {
      return var0 >> 17 & 7;
   }

   @ObfuscatedName("bc")
   static final void method210(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(var2 >= 1 && var3 >= 1 && var2 <= 102 && var3 <= 102) {
         if(client.field527 && class8.field134 != var0) {
            return;
         }

         int var7 = 0;
         boolean var8 = true;
         boolean var9 = false;
         boolean var10 = false;
         if(0 == var1) {
            var7 = class24.field610.method1958(var0, var2, var3);
         }

         if(1 == var1) {
            var7 = class24.field610.method1959(var0, var2, var3);
         }

         if(2 == var1) {
            var7 = class24.field610.method2046(var0, var2, var3);
         }

         if(3 == var1) {
            var7 = class24.field610.method2082(var0, var2, var3);
         }

         int var11;
         if(var7 != 0) {
            var11 = class24.field610.method1962(var0, var2, var3, var7);
            int var32 = var7 >> 14 & 32767;
            int var33 = var11 & 31;
            int var34 = var11 >> 6 & 3;
            class40 var12;
            if(var1 == 0) {
               class24.field610.method1949(var0, var2, var3);
               var12 = class33.method755(var32);
               if(var12.field921 != 0) {
                  client.field335[var0].method2427(var2, var3, var33, var34, var12.field922);
               }
            }

            if(1 == var1) {
               class24.field610.method2064(var0, var2, var3);
            }

            if(2 == var1) {
               class24.field610.method1931(var0, var2, var3);
               var12 = class33.method755(var32);
               if(var12.field919 + var2 > 103 || var12.field919 + var3 > 103 || var2 + var12.field920 > 103 || var12.field920 + var3 > 103) {
                  return;
               }

               if(0 != var12.field921) {
                  client.field335[var0].method2443(var2, var3, var12.field919, var12.field920, var34, var12.field922);
               }
            }

            if(var1 == 3) {
               class24.field610.method1952(var0, var2, var3);
               var12 = class33.method755(var32);
               if(1 == var12.field921) {
                  client.field335[var0].method2429(var2, var3);
               }
            }
         }

         if(var4 >= 0) {
            var11 = var0;
            if(var0 < 3 && 2 == (class5.field86[1][var2][var3] & 2)) {
               var11 = var0 + 1;
            }

            class85 var35 = class24.field610;
            class107 var13 = client.field335[var0];
            class40 var14 = class33.method755(var4);
            int var15;
            int var16;
            if(1 != var5 && var5 != 3) {
               var15 = var14.field919;
               var16 = var14.field920;
            } else {
               var15 = var14.field920;
               var16 = var14.field919;
            }

            int var17;
            int var18;
            if(var2 + var15 <= 104) {
               var17 = var2 + (var15 >> 1);
               var18 = var2 + (1 + var15 >> 1);
            } else {
               var17 = var2;
               var18 = 1 + var2;
            }

            int var19;
            int var20;
            if(var16 + var3 <= 104) {
               var19 = (var16 >> 1) + var3;
               var20 = var3 + (var16 + 1 >> 1);
            } else {
               var19 = var3;
               var20 = 1 + var3;
            }

            int[][] var21 = class5.field79[var11];
            int var22 = var21[var18][var19] + var21[var17][var19] + var21[var17][var20] + var21[var18][var20] >> 2;
            int var23 = (var2 << 7) + (var15 << 6);
            int var24 = (var3 << 7) + (var16 << 6);
            int var25 = (var4 << 14) + var2 + (var3 << 7) + 1073741824;
            if(0 == var14.field937) {
               var25 -= Integer.MIN_VALUE;
            }

            int var26 = var6 + (var5 << 6);
            if(1 == var14.field944) {
               var26 += 256;
            }

            Object var27;
            if(var6 == 22) {
               if(var14.field925 == -1 && var14.field945 == null) {
                  var27 = var14.method851(22, var5, var21, var23, var22, var24);
               } else {
                  var27 = new class12(var4, 22, var5, var11, var2, var3, var14.field925, true, (class84)null);
               }

               var35.method1938(var0, var2, var3, var22, (class84)var27, var25, var26);
               if(var14.field921 == 1) {
                  var13.method2444(var2, var3);
               }
            } else if(var6 != 10 && 11 != var6) {
               if(var6 >= 12) {
                  if(var14.field925 == -1 && null == var14.field945) {
                     var27 = var14.method851(var6, var5, var21, var23, var22, var24);
                  } else {
                     var27 = new class12(var4, var6, var5, var11, var2, var3, var14.field925, true, (class84)null);
                  }

                  var35.method1942(var0, var2, var3, var22, 1, 1, (class84)var27, 0, var25, var26);
                  if(var14.field921 != 0) {
                     var13.method2423(var2, var3, var15, var16, var14.field922);
                  }
               } else if(0 == var6) {
                  if(var14.field925 == -1 && var14.field945 == null) {
                     var27 = var14.method851(0, var5, var21, var23, var22, var24);
                  } else {
                     var27 = new class12(var4, 0, var5, var11, var2, var3, var14.field925, true, (class84)null);
                  }

                  var35.method1979(var0, var2, var3, var22, (class84)var27, (class84)null, class5.field82[var5], 0, var25, var26);
                  if(0 != var14.field921) {
                     var13.method2447(var2, var3, var6, var5, var14.field922);
                  }
               } else if(1 == var6) {
                  if(var14.field925 == -1 && null == var14.field945) {
                     var27 = var14.method851(1, var5, var21, var23, var22, var24);
                  } else {
                     var27 = new class12(var4, 1, var5, var11, var2, var3, var14.field925, true, (class84)null);
                  }

                  var35.method1979(var0, var2, var3, var22, (class84)var27, (class84)null, class5.field83[var5], 0, var25, var26);
                  if(var14.field921 != 0) {
                     var13.method2447(var2, var3, var6, var5, var14.field922);
                  }
               } else {
                  Object var29;
                  int var37;
                  if(2 == var6) {
                     var37 = var5 + 1 & 3;
                     Object var28;
                     if(var14.field925 == -1 && null == var14.field945) {
                        var28 = var14.method851(2, 4 + var5, var21, var23, var22, var24);
                        var29 = var14.method851(2, var37, var21, var23, var22, var24);
                     } else {
                        var28 = new class12(var4, 2, var5 + 4, var11, var2, var3, var14.field925, true, (class84)null);
                        var29 = new class12(var4, 2, var37, var11, var2, var3, var14.field925, true, (class84)null);
                     }

                     var35.method1979(var0, var2, var3, var22, (class84)var28, (class84)var29, class5.field82[var5], class5.field82[var37], var25, var26);
                     if(var14.field921 != 0) {
                        var13.method2447(var2, var3, var6, var5, var14.field922);
                     }
                  } else if(3 == var6) {
                     if(var14.field925 == -1 && var14.field945 == null) {
                        var27 = var14.method851(3, var5, var21, var23, var22, var24);
                     } else {
                        var27 = new class12(var4, 3, var5, var11, var2, var3, var14.field925, true, (class84)null);
                     }

                     var35.method1979(var0, var2, var3, var22, (class84)var27, (class84)null, class5.field83[var5], 0, var25, var26);
                     if(0 != var14.field921) {
                        var13.method2447(var2, var3, var6, var5, var14.field922);
                     }
                  } else if(9 == var6) {
                     if(-1 == var14.field925 && null == var14.field945) {
                        var27 = var14.method851(var6, var5, var21, var23, var22, var24);
                     } else {
                        var27 = new class12(var4, var6, var5, var11, var2, var3, var14.field925, true, (class84)null);
                     }

                     var35.method1942(var0, var2, var3, var22, 1, 1, (class84)var27, 0, var25, var26);
                     if(0 != var14.field921) {
                        var13.method2423(var2, var3, var15, var16, var14.field922);
                     }
                  } else if(var6 == 4) {
                     if(-1 == var14.field925 && null == var14.field945) {
                        var27 = var14.method851(4, var5, var21, var23, var22, var24);
                     } else {
                        var27 = new class12(var4, 4, var5, var11, var2, var3, var14.field925, true, (class84)null);
                     }

                     var35.method2081(var0, var2, var3, var22, (class84)var27, (class84)null, class5.field82[var5], 0, 0, 0, var25, var26);
                  } else {
                     int var36;
                     if(5 == var6) {
                        var37 = 16;
                        var36 = var35.method1958(var0, var2, var3);
                        if(var36 != 0) {
                           var37 = class33.method755(var36 >> 14 & 32767).field928;
                        }

                        if(var14.field925 == -1 && var14.field945 == null) {
                           var29 = var14.method851(4, var5, var21, var23, var22, var24);
                        } else {
                           var29 = new class12(var4, 4, var5, var11, var2, var3, var14.field925, true, (class84)null);
                        }

                        var35.method2081(var0, var2, var3, var22, (class84)var29, (class84)null, class5.field82[var5], 0, var37 * class5.field78[var5], class5.field87[var5] * var37, var25, var26);
                     } else if(6 == var6) {
                        var37 = 8;
                        var36 = var35.method1958(var0, var2, var3);
                        if(var36 != 0) {
                           var37 = class33.method755(var36 >> 14 & 32767).field928 / 2;
                        }

                        if(var14.field925 == -1 && var14.field945 == null) {
                           var29 = var14.method851(4, var5 + 4, var21, var23, var22, var24);
                        } else {
                           var29 = new class12(var4, 4, var5 + 4, var11, var2, var3, var14.field925, true, (class84)null);
                        }

                        var35.method2081(var0, var2, var3, var22, (class84)var29, (class84)null, 256, var5, class5.field72[var5] * var37, class5.field84[var5] * var37, var25, var26);
                     } else if(7 == var6) {
                        var36 = 2 + var5 & 3;
                        if(var14.field925 == -1 && var14.field945 == null) {
                           var27 = var14.method851(4, var36 + 4, var21, var23, var22, var24);
                        } else {
                           var27 = new class12(var4, 4, 4 + var36, var11, var2, var3, var14.field925, true, (class84)null);
                        }

                        var35.method2081(var0, var2, var3, var22, (class84)var27, (class84)null, 256, var36, 0, 0, var25, var26);
                     } else if(8 == var6) {
                        var37 = 8;
                        var36 = var35.method1958(var0, var2, var3);
                        if(var36 != 0) {
                           var37 = class33.method755(var36 >> 14 & 32767).field928 / 2;
                        }

                        int var31 = 2 + var5 & 3;
                        Object var30;
                        if(var14.field925 == -1 && null == var14.field945) {
                           var29 = var14.method851(4, var5 + 4, var21, var23, var22, var24);
                           var30 = var14.method851(4, 4 + var31, var21, var23, var22, var24);
                        } else {
                           var29 = new class12(var4, 4, var5 + 4, var11, var2, var3, var14.field925, true, (class84)null);
                           var30 = new class12(var4, 4, var31 + 4, var11, var2, var3, var14.field925, true, (class84)null);
                        }

                        var35.method2081(var0, var2, var3, var22, (class84)var29, (class84)var30, 256, var5, var37 * class5.field72[var5], var37 * class5.field84[var5], var25, var26);
                     }
                  }
               }
            } else {
               if(-1 == var14.field925 && null == var14.field945) {
                  var27 = var14.method851(10, var5, var21, var23, var22, var24);
               } else {
                  var27 = new class12(var4, 10, var5, var11, var2, var3, var14.field925, true, (class84)null);
               }

               if(var27 != null) {
                  var35.method1942(var0, var2, var3, var22, var15, var16, (class84)var27, var6 == 11?256:0, var25, var26);
               }

               if(0 != var14.field921) {
                  var13.method2423(var2, var3, var15, var16, var14.field922);
               }
            }
         }
      }

   }

   @ObfuscatedName("f")
   public static String method211(long var0) {
      if(var0 > 0L && var0 < 6582952005840035281L) {
         if(0L == var0 % 37L) {
            return null;
         } else {
            int var2 = 0;

            for(long var3 = var0; 0L != var3; var3 /= 37L) {
               ++var2;
            }

            StringBuilder var5;
            char var8;
            for(var5 = new StringBuilder(var2); var0 != 0L; var5.append(var8)) {
               long var6 = var0;
               var0 /= 37L;
               var8 = class161.field2628[(int)(var6 - 37L * var0)];
               if(95 == var8) {
                  int var9 = var5.length() - 1;
                  var5.setCharAt(var9, Character.toUpperCase(var5.charAt(var9)));
                  var8 = 160;
               }
            }

            var5.reverse();
            var5.setCharAt(0, Character.toUpperCase(var5.charAt(0)));
            return var5.toString();
         }
      } else {
         return null;
      }
   }
}
