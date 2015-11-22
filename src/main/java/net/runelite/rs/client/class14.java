package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("p")
public class class14 {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1574173083
   )
   int field203 = -1;
   @ObfuscatedName("f")
   int[] field204;
   @ObfuscatedName("l")
   String[] field205;
   @ObfuscatedName("co")
   public static char field208;
   @ObfuscatedName("g")
   public static String[] field209;
   @ObfuscatedName("j")
   class22 field211;

   @ObfuscatedName("t")
   static final void method193(int var0, int var1, int var2, int var3, int var4, int var5, class85 var6, class107 var7) {
      if(!client.field527 || 0 != (class5.field86[0][var1][var2] & 2) || (class5.field86[var0][var1][var2] & 16) == 0) {
         if(var0 < class5.field74) {
            class5.field74 = var0;
         }

         class40 var8 = class33.method755(var3);
         int var9;
         int var10;
         if(1 != var4 && 3 != var4) {
            var9 = var8.field919;
            var10 = var8.field920;
         } else {
            var9 = var8.field920;
            var10 = var8.field919;
         }

         int var11;
         int var12;
         if(var1 + var9 <= 104) {
            var11 = var1 + (var9 >> 1);
            var12 = var1 + (1 + var9 >> 1);
         } else {
            var11 = var1;
            var12 = 1 + var1;
         }

         int var13;
         int var14;
         if(var10 + var2 <= 104) {
            var13 = var2 + (var10 >> 1);
            var14 = var2 + (var10 + 1 >> 1);
         } else {
            var13 = var2;
            var14 = var2 + 1;
         }

         int[][] var15 = class5.field79[var0];
         int var16 = var15[var12][var14] + var15[var11][var14] + var15[var11][var13] + var15[var12][var13] >> 2;
         int var17 = (var1 << 7) + (var9 << 6);
         int var18 = (var2 << 7) + (var10 << 6);
         int var19 = 1073741824 + (var3 << 14) + (var2 << 7) + var1;
         if(var8.field937 == 0) {
            var19 -= Integer.MIN_VALUE;
         }

         int var20 = (var4 << 6) + var5;
         if(var8.field944 == 1) {
            var20 += 256;
         }

         if(var8.method855()) {
            class4.method48(var0, var1, var2, var8, var4);
         }

         Object var21;
         if(var5 == 22) {
            if(!client.field527 || 0 != var8.field937 || 1 == var8.field921 || var8.field905) {
               if(-1 == var8.field925 && null == var8.field945) {
                  var21 = var8.method850(22, var4, var15, var17, var16, var18);
               } else {
                  var21 = new class12(var3, 22, var4, var0, var1, var2, var8.field925, true, (class84)null);
               }

               var6.method1938(var0, var1, var2, var16, (class84)var21, var19, var20);
               if(1 == var8.field921 && var7 != null) {
                  var7.method2444(var1, var2);
               }

            }
         } else {
            int var22;
            if(10 != var5 && 11 != var5) {
               if(var5 >= 12) {
                  if(-1 == var8.field925 && null == var8.field945) {
                     var21 = var8.method850(var5, var4, var15, var17, var16, var18);
                  } else {
                     var21 = new class12(var3, var5, var4, var0, var1, var2, var8.field925, true, (class84)null);
                  }

                  var6.method1942(var0, var1, var2, var16, 1, 1, (class84)var21, 0, var19, var20);
                  if(var5 >= 12 && var5 <= 17 && 13 != var5 && var0 > 0) {
                     class29.field677[var0][var1][var2] |= 2340;
                  }

                  if(0 != var8.field921 && var7 != null) {
                     var7.method2423(var1, var2, var9, var10, var8.field922);
                  }

               } else if(var5 == 0) {
                  if(var8.field925 == -1 && var8.field945 == null) {
                     var21 = var8.method850(0, var4, var15, var17, var16, var18);
                  } else {
                     var21 = new class12(var3, 0, var4, var0, var1, var2, var8.field925, true, (class84)null);
                  }

                  var6.method1979(var0, var1, var2, var16, (class84)var21, (class84)null, class5.field82[var4], 0, var19, var20);
                  if(var4 == 0) {
                     if(var8.field911) {
                        class150.field2239[var0][var1][var2] = 50;
                        class150.field2239[var0][var1][var2 + 1] = 50;
                     }

                     if(var8.field926) {
                        class29.field677[var0][var1][var2] |= 585;
                     }
                  } else if(var4 == 1) {
                     if(var8.field911) {
                        class150.field2239[var0][var1][var2 + 1] = 50;
                        class150.field2239[var0][var1 + 1][1 + var2] = 50;
                     }

                     if(var8.field926) {
                        class29.field677[var0][var1][var2 + 1] |= 1170;
                     }
                  } else if(2 == var4) {
                     if(var8.field911) {
                        class150.field2239[var0][var1 + 1][var2] = 50;
                        class150.field2239[var0][1 + var1][1 + var2] = 50;
                     }

                     if(var8.field926) {
                        class29.field677[var0][1 + var1][var2] |= 585;
                     }
                  } else if(3 == var4) {
                     if(var8.field911) {
                        class150.field2239[var0][var1][var2] = 50;
                        class150.field2239[var0][1 + var1][var2] = 50;
                     }

                     if(var8.field926) {
                        class29.field677[var0][var1][var2] |= 1170;
                     }
                  }

                  if(var8.field921 != 0 && null != var7) {
                     var7.method2447(var1, var2, var5, var4, var8.field922);
                  }

                  if(16 != var8.field928) {
                     var6.method1937(var0, var1, var2, var8.field928);
                  }

               } else if(1 == var5) {
                  if(-1 == var8.field925 && null == var8.field945) {
                     var21 = var8.method850(1, var4, var15, var17, var16, var18);
                  } else {
                     var21 = new class12(var3, 1, var4, var0, var1, var2, var8.field925, true, (class84)null);
                  }

                  var6.method1979(var0, var1, var2, var16, (class84)var21, (class84)null, class5.field83[var4], 0, var19, var20);
                  if(var8.field911) {
                     if(var4 == 0) {
                        class150.field2239[var0][var1][var2 + 1] = 50;
                     } else if(1 == var4) {
                        class150.field2239[var0][var1 + 1][var2 + 1] = 50;
                     } else if(2 == var4) {
                        class150.field2239[var0][1 + var1][var2] = 50;
                     } else if(3 == var4) {
                        class150.field2239[var0][var1][var2] = 50;
                     }
                  }

                  if(var8.field921 != 0 && var7 != null) {
                     var7.method2447(var1, var2, var5, var4, var8.field922);
                  }

               } else {
                  int var26;
                  Object var27;
                  if(2 == var5) {
                     var26 = var4 + 1 & 3;
                     Object var28;
                     if(-1 == var8.field925 && null == var8.field945) {
                        var28 = var8.method850(2, var4 + 4, var15, var17, var16, var18);
                        var27 = var8.method850(2, var26, var15, var17, var16, var18);
                     } else {
                        var28 = new class12(var3, 2, 4 + var4, var0, var1, var2, var8.field925, true, (class84)null);
                        var27 = new class12(var3, 2, var26, var0, var1, var2, var8.field925, true, (class84)null);
                     }

                     var6.method1979(var0, var1, var2, var16, (class84)var28, (class84)var27, class5.field82[var4], class5.field82[var26], var19, var20);
                     if(var8.field926) {
                        if(0 == var4) {
                           class29.field677[var0][var1][var2] |= 585;
                           class29.field677[var0][var1][1 + var2] |= 1170;
                        } else if(1 == var4) {
                           class29.field677[var0][var1][1 + var2] |= 1170;
                           class29.field677[var0][1 + var1][var2] |= 585;
                        } else if(2 == var4) {
                           class29.field677[var0][1 + var1][var2] |= 585;
                           class29.field677[var0][var1][var2] |= 1170;
                        } else if(var4 == 3) {
                           class29.field677[var0][var1][var2] |= 1170;
                           class29.field677[var0][var1][var2] |= 585;
                        }
                     }

                     if(var8.field921 != 0 && var7 != null) {
                        var7.method2447(var1, var2, var5, var4, var8.field922);
                     }

                     if(var8.field928 != 16) {
                        var6.method1937(var0, var1, var2, var8.field928);
                     }

                  } else if(var5 == 3) {
                     if(var8.field925 == -1 && null == var8.field945) {
                        var21 = var8.method850(3, var4, var15, var17, var16, var18);
                     } else {
                        var21 = new class12(var3, 3, var4, var0, var1, var2, var8.field925, true, (class84)null);
                     }

                     var6.method1979(var0, var1, var2, var16, (class84)var21, (class84)null, class5.field83[var4], 0, var19, var20);
                     if(var8.field911) {
                        if(0 == var4) {
                           class150.field2239[var0][var1][1 + var2] = 50;
                        } else if(1 == var4) {
                           class150.field2239[var0][1 + var1][1 + var2] = 50;
                        } else if(var4 == 2) {
                           class150.field2239[var0][var1 + 1][var2] = 50;
                        } else if(3 == var4) {
                           class150.field2239[var0][var1][var2] = 50;
                        }
                     }

                     if(var8.field921 != 0 && null != var7) {
                        var7.method2447(var1, var2, var5, var4, var8.field922);
                     }

                  } else if(var5 == 9) {
                     if(-1 == var8.field925 && var8.field945 == null) {
                        var21 = var8.method850(var5, var4, var15, var17, var16, var18);
                     } else {
                        var21 = new class12(var3, var5, var4, var0, var1, var2, var8.field925, true, (class84)null);
                     }

                     var6.method1942(var0, var1, var2, var16, 1, 1, (class84)var21, 0, var19, var20);
                     if(var8.field921 != 0 && var7 != null) {
                        var7.method2423(var1, var2, var9, var10, var8.field922);
                     }

                     if(var8.field928 != 16) {
                        var6.method1937(var0, var1, var2, var8.field928);
                     }

                  } else if(var5 == 4) {
                     if(var8.field925 == -1 && null == var8.field945) {
                        var21 = var8.method850(4, var4, var15, var17, var16, var18);
                     } else {
                        var21 = new class12(var3, 4, var4, var0, var1, var2, var8.field925, true, (class84)null);
                     }

                     var6.method2081(var0, var1, var2, var16, (class84)var21, (class84)null, class5.field82[var4], 0, 0, 0, var19, var20);
                  } else if(var5 == 5) {
                     var26 = 16;
                     var22 = var6.method1958(var0, var1, var2);
                     if(0 != var22) {
                        var26 = class33.method755(var22 >> 14 & 32767).field928;
                     }

                     if(var8.field925 == -1 && var8.field945 == null) {
                        var27 = var8.method850(4, var4, var15, var17, var16, var18);
                     } else {
                        var27 = new class12(var3, 4, var4, var0, var1, var2, var8.field925, true, (class84)null);
                     }

                     var6.method2081(var0, var1, var2, var16, (class84)var27, (class84)null, class5.field82[var4], 0, var26 * class5.field78[var4], class5.field87[var4] * var26, var19, var20);
                  } else if(6 == var5) {
                     var26 = 8;
                     var22 = var6.method1958(var0, var1, var2);
                     if(0 != var22) {
                        var26 = class33.method755(var22 >> 14 & 32767).field928 / 2;
                     }

                     if(-1 == var8.field925 && var8.field945 == null) {
                        var27 = var8.method850(4, 4 + var4, var15, var17, var16, var18);
                     } else {
                        var27 = new class12(var3, 4, var4 + 4, var0, var1, var2, var8.field925, true, (class84)null);
                     }

                     var6.method2081(var0, var1, var2, var16, (class84)var27, (class84)null, 256, var4, var26 * class5.field72[var4], class5.field84[var4] * var26, var19, var20);
                  } else if(var5 == 7) {
                     var22 = var4 + 2 & 3;
                     if(-1 == var8.field925 && var8.field945 == null) {
                        var21 = var8.method850(4, var22 + 4, var15, var17, var16, var18);
                     } else {
                        var21 = new class12(var3, 4, var22 + 4, var0, var1, var2, var8.field925, true, (class84)null);
                     }

                     var6.method2081(var0, var1, var2, var16, (class84)var21, (class84)null, 256, var22, 0, 0, var19, var20);
                  } else if(8 == var5) {
                     var26 = 8;
                     var22 = var6.method1958(var0, var1, var2);
                     if(0 != var22) {
                        var26 = class33.method755(var22 >> 14 & 32767).field928 / 2;
                     }

                     int var25 = var4 + 2 & 3;
                     Object var29;
                     if(-1 == var8.field925 && null == var8.field945) {
                        var27 = var8.method850(4, 4 + var4, var15, var17, var16, var18);
                        var29 = var8.method850(4, 4 + var25, var15, var17, var16, var18);
                     } else {
                        var27 = new class12(var3, 4, var4 + 4, var0, var1, var2, var8.field925, true, (class84)null);
                        var29 = new class12(var3, 4, 4 + var25, var0, var1, var2, var8.field925, true, (class84)null);
                     }

                     var6.method2081(var0, var1, var2, var16, (class84)var27, (class84)var29, 256, var4, var26 * class5.field72[var4], var26 * class5.field84[var4], var19, var20);
                  }
               }
            } else {
               if(-1 == var8.field925 && null == var8.field945) {
                  var21 = var8.method850(10, var4, var15, var17, var16, var18);
               } else {
                  var21 = new class12(var3, 10, var4, var0, var1, var2, var8.field925, true, (class84)null);
               }

               if(null != var21 && var6.method1942(var0, var1, var2, var16, var9, var10, (class84)var21, 11 == var5?256:0, var19, var20) && var8.field911) {
                  var22 = 15;
                  if(var21 instanceof class104) {
                     var22 = ((class104)var21).method2336() / 4;
                     if(var22 > 30) {
                        var22 = 30;
                     }
                  }

                  for(int var23 = 0; var23 <= var9; ++var23) {
                     for(int var24 = 0; var24 <= var10; ++var24) {
                        if(var22 > class150.field2239[var0][var23 + var1][var24 + var2]) {
                           class150.field2239[var0][var23 + var1][var24 + var2] = (byte)var22;
                        }
                     }
                  }
               }

               if(var8.field921 != 0 && null != var7) {
                  var7.method2423(var1, var2, var9, var10, var8.field922);
               }

            }
         }
      }
   }
}
