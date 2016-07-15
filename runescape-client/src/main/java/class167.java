import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fk")
public class class167 {
   @ObfuscatedName("c")
   static final char[] field2692 = new char[]{' ', ' ', '_', '-', 'à', 'á', 'â', 'ä', 'ã', 'À', 'Á', 'Â', 'Ä', 'Ã', 'è', 'é', 'ê', 'ë', 'È', 'É', 'Ê', 'Ë', 'í', 'î', 'ï', 'Í', 'Î', 'Ï', 'ò', 'ó', 'ô', 'ö', 'õ', 'Ò', 'Ó', 'Ô', 'Ö', 'Õ', 'ù', 'ú', 'û', 'ü', 'Ù', 'Ú', 'Û', 'Ü', 'ç', 'Ç', 'ÿ', 'Ÿ', 'ñ', 'Ñ', 'ß'};
   @ObfuscatedName("h")
   static final char[] field2695 = new char[]{'[', ']', '#'};

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIIIIILclass89;Lclass111;I)V",
      garbageValue = "-869242224"
   )
   static final void method3323(int var0, int var1, int var2, int var3, int var4, int var5, class89 var6, class111 var7) {
      if(!client.field298 || (class5.field89[0][var1][var2] & 2) != 0 || (class5.field89[var0][var1][var2] & 16) == 0) {
         if(var0 < class5.field79) {
            class5.field79 = var0;
         }

         class42 var8 = class146.method3102(var3);
         int var9;
         int var10;
         if(var4 != 1 && var4 != 3) {
            var9 = var8.field959;
            var10 = var8.field1000;
         } else {
            var9 = var8.field1000;
            var10 = var8.field959;
         }

         int var11;
         int var12;
         if(var1 + var9 <= 104) {
            var11 = var1 + (var9 >> 1);
            var12 = (1 + var9 >> 1) + var1;
         } else {
            var11 = var1;
            var12 = 1 + var1;
         }

         int var13;
         int var14;
         if(var2 + var10 <= 104) {
            var13 = var2 + (var10 >> 1);
            var14 = var2 + (var10 + 1 >> 1);
         } else {
            var13 = var2;
            var14 = 1 + var2;
         }

         int[][] var15 = class5.field78[var0];
         int var16 = var15[var12][var14] + var15[var11][var14] + var15[var11][var13] + var15[var12][var13] >> 2;
         int var17 = (var9 << 6) + (var1 << 7);
         int var18 = (var10 << 6) + (var2 << 7);
         int var19 = (var2 << 7) + var1 + (var3 << 14) + 1073741824;
         if(var8.field971 == 0) {
            var19 -= Integer.MIN_VALUE;
         }

         int var20 = var5 + (var4 << 6);
         if(var8.field999 == 1) {
            var20 += 256;
         }

         if(var8.method848()) {
            class44.method959(var0, var1, var2, var8, var4);
         }

         Object var26;
         if(var5 == 22) {
            if(!client.field298 || var8.field971 != 0 || var8.field976 == 1 || var8.field997) {
               if(var8.field982 == -1 && var8.field969 == null) {
                  var26 = var8.method843(22, var4, var15, var17, var16, var18);
               } else {
                  var26 = new class12(var3, 22, var4, var0, var1, var2, var8.field982, true, (class88)null);
               }

               var6.method2015(var0, var1, var2, var16, (class88)var26, var19, var20);
               if(var8.field976 == 1 && null != var7) {
                  var7.method2475(var1, var2);
               }

            }
         } else {
            int var22;
            if(var5 != 10 && var5 != 11) {
               if(var5 >= 12) {
                  if(var8.field982 == -1 && var8.field969 == null) {
                     var26 = var8.method843(var5, var4, var15, var17, var16, var18);
                  } else {
                     var26 = new class12(var3, var5, var4, var0, var1, var2, var8.field982, true, (class88)null);
                  }

                  var6.method2019(var0, var1, var2, var16, 1, 1, (class88)var26, 0, var19, var20);
                  if(var5 >= 12 && var5 <= 17 && var5 != 13 && var0 > 0) {
                     class133.field2117[var0][var1][var2] |= 2340;
                  }

                  if(var8.field976 != 0 && null != var7) {
                     var7.method2501(var1, var2, var9, var10, var8.field977);
                  }

               } else if(var5 == 0) {
                  if(var8.field982 == -1 && null == var8.field969) {
                     var26 = var8.method843(0, var4, var15, var17, var16, var18);
                  } else {
                     var26 = new class12(var3, 0, var4, var0, var1, var2, var8.field982, true, (class88)null);
                  }

                  var6.method2017(var0, var1, var2, var16, (class88)var26, (class88)null, class5.field87[var4], 0, var19, var20);
                  if(var4 == 0) {
                     if(var8.field995) {
                        class5.field83[var0][var1][var2] = 50;
                        class5.field83[var0][var1][1 + var2] = 50;
                     }

                     if(var8.field981) {
                        class133.field2117[var0][var1][var2] |= 585;
                     }
                  } else if(var4 == 1) {
                     if(var8.field995) {
                        class5.field83[var0][var1][1 + var2] = 50;
                        class5.field83[var0][var1 + 1][var2 + 1] = 50;
                     }

                     if(var8.field981) {
                        class133.field2117[var0][var1][var2 + 1] |= 1170;
                     }
                  } else if(var4 == 2) {
                     if(var8.field995) {
                        class5.field83[var0][var1 + 1][var2] = 50;
                        class5.field83[var0][1 + var1][1 + var2] = 50;
                     }

                     if(var8.field981) {
                        class133.field2117[var0][1 + var1][var2] |= 585;
                     }
                  } else if(var4 == 3) {
                     if(var8.field995) {
                        class5.field83[var0][var1][var2] = 50;
                        class5.field83[var0][var1 + 1][var2] = 50;
                     }

                     if(var8.field981) {
                        class133.field2117[var0][var1][var2] |= 1170;
                     }
                  }

                  if(var8.field976 != 0 && null != var7) {
                     var7.method2474(var1, var2, var5, var4, var8.field977);
                  }

                  if(var8.field960 != 16) {
                     var6.method2025(var0, var1, var2, var8.field960);
                  }

               } else if(var5 == 1) {
                  if(var8.field982 == -1 && var8.field969 == null) {
                     var26 = var8.method843(1, var4, var15, var17, var16, var18);
                  } else {
                     var26 = new class12(var3, 1, var4, var0, var1, var2, var8.field982, true, (class88)null);
                  }

                  var6.method2017(var0, var1, var2, var16, (class88)var26, (class88)null, class5.field77[var4], 0, var19, var20);
                  if(var8.field995) {
                     if(var4 == 0) {
                        class5.field83[var0][var1][var2 + 1] = 50;
                     } else if(var4 == 1) {
                        class5.field83[var0][1 + var1][1 + var2] = 50;
                     } else if(var4 == 2) {
                        class5.field83[var0][var1 + 1][var2] = 50;
                     } else if(var4 == 3) {
                        class5.field83[var0][var1][var2] = 50;
                     }
                  }

                  if(var8.field976 != 0 && var7 != null) {
                     var7.method2474(var1, var2, var5, var4, var8.field977);
                  }

               } else {
                  int var21;
                  Object var23;
                  if(var5 == 2) {
                     var21 = var4 + 1 & 3;
                     Object var28;
                     if(var8.field982 == -1 && null == var8.field969) {
                        var28 = var8.method843(2, var4 + 4, var15, var17, var16, var18);
                        var23 = var8.method843(2, var21, var15, var17, var16, var18);
                     } else {
                        var28 = new class12(var3, 2, 4 + var4, var0, var1, var2, var8.field982, true, (class88)null);
                        var23 = new class12(var3, 2, var21, var0, var1, var2, var8.field982, true, (class88)null);
                     }

                     var6.method2017(var0, var1, var2, var16, (class88)var28, (class88)var23, class5.field87[var4], class5.field87[var21], var19, var20);
                     if(var8.field981) {
                        if(var4 == 0) {
                           class133.field2117[var0][var1][var2] |= 585;
                           class133.field2117[var0][var1][var2 + 1] |= 1170;
                        } else if(var4 == 1) {
                           class133.field2117[var0][var1][1 + var2] |= 1170;
                           class133.field2117[var0][var1 + 1][var2] |= 585;
                        } else if(var4 == 2) {
                           class133.field2117[var0][var1 + 1][var2] |= 585;
                           class133.field2117[var0][var1][var2] |= 1170;
                        } else if(var4 == 3) {
                           class133.field2117[var0][var1][var2] |= 1170;
                           class133.field2117[var0][var1][var2] |= 585;
                        }
                     }

                     if(var8.field976 != 0 && null != var7) {
                        var7.method2474(var1, var2, var5, var4, var8.field977);
                     }

                     if(var8.field960 != 16) {
                        var6.method2025(var0, var1, var2, var8.field960);
                     }

                  } else if(var5 == 3) {
                     if(var8.field982 == -1 && null == var8.field969) {
                        var26 = var8.method843(3, var4, var15, var17, var16, var18);
                     } else {
                        var26 = new class12(var3, 3, var4, var0, var1, var2, var8.field982, true, (class88)null);
                     }

                     var6.method2017(var0, var1, var2, var16, (class88)var26, (class88)null, class5.field77[var4], 0, var19, var20);
                     if(var8.field995) {
                        if(var4 == 0) {
                           class5.field83[var0][var1][var2 + 1] = 50;
                        } else if(var4 == 1) {
                           class5.field83[var0][var1 + 1][1 + var2] = 50;
                        } else if(var4 == 2) {
                           class5.field83[var0][1 + var1][var2] = 50;
                        } else if(var4 == 3) {
                           class5.field83[var0][var1][var2] = 50;
                        }
                     }

                     if(var8.field976 != 0 && var7 != null) {
                        var7.method2474(var1, var2, var5, var4, var8.field977);
                     }

                  } else if(var5 == 9) {
                     if(var8.field982 == -1 && null == var8.field969) {
                        var26 = var8.method843(var5, var4, var15, var17, var16, var18);
                     } else {
                        var26 = new class12(var3, var5, var4, var0, var1, var2, var8.field982, true, (class88)null);
                     }

                     var6.method2019(var0, var1, var2, var16, 1, 1, (class88)var26, 0, var19, var20);
                     if(var8.field976 != 0 && null != var7) {
                        var7.method2501(var1, var2, var9, var10, var8.field977);
                     }

                     if(var8.field960 != 16) {
                        var6.method2025(var0, var1, var2, var8.field960);
                     }

                  } else if(var5 == 4) {
                     if(var8.field982 == -1 && var8.field969 == null) {
                        var26 = var8.method843(4, var4, var15, var17, var16, var18);
                     } else {
                        var26 = new class12(var3, 4, var4, var0, var1, var2, var8.field982, true, (class88)null);
                     }

                     var6.method2133(var0, var1, var2, var16, (class88)var26, (class88)null, class5.field87[var4], 0, 0, 0, var19, var20);
                  } else if(var5 == 5) {
                     var21 = 16;
                     var22 = var6.method2029(var0, var1, var2);
                     if(var22 != 0) {
                        var21 = class146.method3102(var22 >> 14 & 32767).field960;
                     }

                     if(var8.field982 == -1 && null == var8.field969) {
                        var23 = var8.method843(4, var4, var15, var17, var16, var18);
                     } else {
                        var23 = new class12(var3, 4, var4, var0, var1, var2, var8.field982, true, (class88)null);
                     }

                     var6.method2133(var0, var1, var2, var16, (class88)var23, (class88)null, class5.field87[var4], 0, class5.field88[var4] * var21, var21 * class5.field90[var4], var19, var20);
                  } else if(var5 == 6) {
                     var21 = 8;
                     var22 = var6.method2029(var0, var1, var2);
                     if(var22 != 0) {
                        var21 = class146.method3102(var22 >> 14 & 32767).field960 / 2;
                     }

                     if(var8.field982 == -1 && null == var8.field969) {
                        var23 = var8.method843(4, 4 + var4, var15, var17, var16, var18);
                     } else {
                        var23 = new class12(var3, 4, var4 + 4, var0, var1, var2, var8.field982, true, (class88)null);
                     }

                     var6.method2133(var0, var1, var2, var16, (class88)var23, (class88)null, 256, var4, var21 * class5.field82[var4], class5.field92[var4] * var21, var19, var20);
                  } else if(var5 == 7) {
                     var22 = 2 + var4 & 3;
                     if(var8.field982 == -1 && null == var8.field969) {
                        var26 = var8.method843(4, 4 + var22, var15, var17, var16, var18);
                     } else {
                        var26 = new class12(var3, 4, var22 + 4, var0, var1, var2, var8.field982, true, (class88)null);
                     }

                     var6.method2133(var0, var1, var2, var16, (class88)var26, (class88)null, 256, var22, 0, 0, var19, var20);
                  } else if(var5 == 8) {
                     var21 = 8;
                     var22 = var6.method2029(var0, var1, var2);
                     if(var22 != 0) {
                        var21 = class146.method3102(var22 >> 14 & 32767).field960 / 2;
                     }

                     int var25 = var4 + 2 & 3;
                     Object var29;
                     if(var8.field982 == -1 && null == var8.field969) {
                        var23 = var8.method843(4, var4 + 4, var15, var17, var16, var18);
                        var29 = var8.method843(4, 4 + var25, var15, var17, var16, var18);
                     } else {
                        var23 = new class12(var3, 4, 4 + var4, var0, var1, var2, var8.field982, true, (class88)null);
                        var29 = new class12(var3, 4, 4 + var25, var0, var1, var2, var8.field982, true, (class88)null);
                     }

                     var6.method2133(var0, var1, var2, var16, (class88)var23, (class88)var29, 256, var4, class5.field82[var4] * var21, class5.field92[var4] * var21, var19, var20);
                  }
               }
            } else {
               if(var8.field982 == -1 && var8.field969 == null) {
                  var26 = var8.method843(10, var4, var15, var17, var16, var18);
               } else {
                  var26 = new class12(var3, 10, var4, var0, var1, var2, var8.field982, true, (class88)null);
               }

               if(null != var26 && var6.method2019(var0, var1, var2, var16, var9, var10, (class88)var26, var5 == 11?256:0, var19, var20) && var8.field995) {
                  var22 = 15;
                  if(var26 instanceof class108) {
                     var22 = ((class108)var26).method2376() / 4;
                     if(var22 > 30) {
                        var22 = 30;
                     }
                  }

                  for(int var27 = 0; var27 <= var9; ++var27) {
                     for(int var24 = 0; var24 <= var10; ++var24) {
                        if(var22 > class5.field83[var0][var1 + var27][var2 + var24]) {
                           class5.field83[var0][var27 + var1][var24 + var2] = (byte)var22;
                        }
                     }
                  }
               }

               if(var8.field976 != 0 && var7 != null) {
                  var7.method2501(var1, var2, var9, var10, var8.field977);
               }

            }
         }
      }
   }
}
