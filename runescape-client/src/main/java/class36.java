import java.util.Calendar;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("az")
public class class36 {
   @ObfuscatedName("x")
   static int[] field799;
   @ObfuscatedName("k")
   static class173 field800;
   @ObfuscatedName("l")
   static int[] field801 = new int[5];
   @ObfuscatedName("n")
   static int[] field803 = new int[1000];
   @ObfuscatedName("m")
   @Export("chatboxSegments")
   static String[] field804 = new String[1000];
   @ObfuscatedName("d")
   static int[][] field805 = new int[5][5000];
   @ObfuscatedName("s")
   static class14[] field806 = new class14[50];
   @ObfuscatedName("o")
   static Calendar field807 = Calendar.getInstance();
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -62941659
   )
   static int field809 = 0;
   @ObfuscatedName("q")
   static final String[] field810 = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
   @ObfuscatedName("r")
   static class173 field813;
   @ObfuscatedName("ct")
   static class224 field814;
   @ObfuscatedName("b")
   static String[] field816;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -129541597
   )
   static int field817 = 0;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIIIIILclass86;Lclass108;I)V",
      garbageValue = "1261931380"
   )
   static final void method778(int var0, int var1, int var2, int var3, int var4, int var5, class86 var6, class108 var7) {
      if(!client.field296 || (class5.field82[0][var1][var2] & 2) != 0 || (class5.field82[var0][var1][var2] & 16) == 0) {
         if(var0 < class5.field83) {
            class5.field83 = var0;
         }

         class40 var8 = class150.method3166(var3);
         int var9;
         int var10;
         if(var4 != 1 && var4 != 3) {
            var9 = var8.field945;
            var10 = var8.field937;
         } else {
            var9 = var8.field937;
            var10 = var8.field945;
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
            var13 = (var10 >> 1) + var2;
            var14 = var2 + (1 + var10 >> 1);
         } else {
            var13 = var2;
            var14 = 1 + var2;
         }

         int[][] var15 = class5.field99[var0];
         int var16 = var15[var12][var14] + var15[var11][var14] + var15[var12][var13] + var15[var11][var13] >> 2;
         int var17 = (var9 << 6) + (var1 << 7);
         int var18 = (var2 << 7) + (var10 << 6);
         int var19 = var1 + (var2 << 7) + (var3 << 14) + 1073741824;
         if(var8.field955 == 0) {
            var19 -= Integer.MIN_VALUE;
         }

         int var20 = (var4 << 6) + var5;
         if(var8.field976 == 1) {
            var20 += 256;
         }

         int var22;
         int var23;
         if(var8.method851()) {
            class23 var21 = new class23();
            var21.field604 = var0;
            var21.field605 = var1 * 128;
            var21.field606 = var2 * 128;
            var22 = var8.field945;
            var23 = var8.field937;
            if(var4 == 1 || var4 == 3) {
               var22 = var8.field937;
               var23 = var8.field945;
            }

            var21.field615 = (var1 + var22) * 128;
            var21.field616 = (var23 + var2) * 128;
            var21.field610 = var8.field981;
            var21.field603 = var8.field935 * 128;
            var21.field612 = var8.field982;
            var21.field613 = var8.field983;
            var21.field614 = var8.field984;
            if(var8.field947 != null) {
               var21.field617 = var8;
               var21.method624();
            }

            class23.field608.method3877(var21);
            if(var21.field614 != null) {
               var21.field609 = var21.field612 + (int)(Math.random() * (double)(var21.field613 - var21.field612));
            }
         }

         Object var30;
         if(var5 == 22) {
            if(!client.field296 || var8.field955 != 0 || var8.field953 == 1 || var8.field977) {
               if(var8.field959 == -1 && null == var8.field947) {
                  var30 = var8.method869(22, var4, var15, var17, var16, var18);
               } else {
                  var30 = new class12(var3, 22, var4, var0, var1, var2, var8.field959, true, (class85)null);
               }

               var6.method1981(var0, var1, var2, var16, (class85)var30, var19, var20);
               if(var8.field953 == 1 && var7 != null) {
                  var7.method2434(var1, var2);
               }

            }
         } else if(var5 != 10 && var5 != 11) {
            if(var5 >= 12) {
               if(var8.field959 == -1 && var8.field947 == null) {
                  var30 = var8.method869(var5, var4, var15, var17, var16, var18);
               } else {
                  var30 = new class12(var3, var5, var4, var0, var1, var2, var8.field959, true, (class85)null);
               }

               var6.method2135(var0, var1, var2, var16, 1, 1, (class85)var30, 0, var19, var20);
               if(var5 >= 12 && var5 <= 17 && var5 != 13 && var0 > 0) {
                  class19.field286[var0][var1][var2] |= 2340;
               }

               if(var8.field953 != 0 && var7 != null) {
                  var7.method2462(var1, var2, var9, var10, var8.field954);
               }

            } else if(var5 == 0) {
               if(var8.field959 == -1 && null == var8.field947) {
                  var30 = var8.method869(0, var4, var15, var17, var16, var18);
               } else {
                  var30 = new class12(var3, 0, var4, var0, var1, var2, var8.field959, true, (class85)null);
               }

               var6.method2071(var0, var1, var2, var16, (class85)var30, (class85)null, class5.field91[var4], 0, var19, var20);
               if(var4 == 0) {
                  if(var8.field967) {
                     class216.field3159[var0][var1][var2] = 50;
                     class216.field3159[var0][var1][1 + var2] = 50;
                  }

                  if(var8.field958) {
                     class19.field286[var0][var1][var2] |= 585;
                  }
               } else if(var4 == 1) {
                  if(var8.field967) {
                     class216.field3159[var0][var1][var2 + 1] = 50;
                     class216.field3159[var0][1 + var1][var2 + 1] = 50;
                  }

                  if(var8.field958) {
                     class19.field286[var0][var1][var2 + 1] |= 1170;
                  }
               } else if(var4 == 2) {
                  if(var8.field967) {
                     class216.field3159[var0][1 + var1][var2] = 50;
                     class216.field3159[var0][var1 + 1][var2 + 1] = 50;
                  }

                  if(var8.field958) {
                     class19.field286[var0][var1 + 1][var2] |= 585;
                  }
               } else if(var4 == 3) {
                  if(var8.field967) {
                     class216.field3159[var0][var1][var2] = 50;
                     class216.field3159[var0][var1 + 1][var2] = 50;
                  }

                  if(var8.field958) {
                     class19.field286[var0][var1][var2] |= 1170;
                  }
               }

               if(var8.field953 != 0 && null != var7) {
                  var7.method2433(var1, var2, var5, var4, var8.field954);
               }

               if(var8.field960 != 16) {
                  var6.method2008(var0, var1, var2, var8.field960);
               }

            } else if(var5 == 1) {
               if(var8.field959 == -1 && null == var8.field947) {
                  var30 = var8.method869(1, var4, var15, var17, var16, var18);
               } else {
                  var30 = new class12(var3, 1, var4, var0, var1, var2, var8.field959, true, (class85)null);
               }

               var6.method2071(var0, var1, var2, var16, (class85)var30, (class85)null, class5.field92[var4], 0, var19, var20);
               if(var8.field967) {
                  if(var4 == 0) {
                     class216.field3159[var0][var1][1 + var2] = 50;
                  } else if(var4 == 1) {
                     class216.field3159[var0][var1 + 1][var2 + 1] = 50;
                  } else if(var4 == 2) {
                     class216.field3159[var0][var1 + 1][var2] = 50;
                  } else if(var4 == 3) {
                     class216.field3159[var0][var1][var2] = 50;
                  }
               }

               if(var8.field953 != 0 && var7 != null) {
                  var7.method2433(var1, var2, var5, var4, var8.field954);
               }

            } else {
               Object var26;
               int var27;
               if(var5 == 2) {
                  var27 = 1 + var4 & 3;
                  Object var29;
                  if(var8.field959 == -1 && null == var8.field947) {
                     var29 = var8.method869(2, 4 + var4, var15, var17, var16, var18);
                     var26 = var8.method869(2, var27, var15, var17, var16, var18);
                  } else {
                     var29 = new class12(var3, 2, 4 + var4, var0, var1, var2, var8.field959, true, (class85)null);
                     var26 = new class12(var3, 2, var27, var0, var1, var2, var8.field959, true, (class85)null);
                  }

                  var6.method2071(var0, var1, var2, var16, (class85)var29, (class85)var26, class5.field91[var4], class5.field91[var27], var19, var20);
                  if(var8.field958) {
                     if(var4 == 0) {
                        class19.field286[var0][var1][var2] |= 585;
                        class19.field286[var0][var1][var2 + 1] |= 1170;
                     } else if(var4 == 1) {
                        class19.field286[var0][var1][1 + var2] |= 1170;
                        class19.field286[var0][var1 + 1][var2] |= 585;
                     } else if(var4 == 2) {
                        class19.field286[var0][1 + var1][var2] |= 585;
                        class19.field286[var0][var1][var2] |= 1170;
                     } else if(var4 == 3) {
                        class19.field286[var0][var1][var2] |= 1170;
                        class19.field286[var0][var1][var2] |= 585;
                     }
                  }

                  if(var8.field953 != 0 && var7 != null) {
                     var7.method2433(var1, var2, var5, var4, var8.field954);
                  }

                  if(var8.field960 != 16) {
                     var6.method2008(var0, var1, var2, var8.field960);
                  }

               } else if(var5 == 3) {
                  if(var8.field959 == -1 && var8.field947 == null) {
                     var30 = var8.method869(3, var4, var15, var17, var16, var18);
                  } else {
                     var30 = new class12(var3, 3, var4, var0, var1, var2, var8.field959, true, (class85)null);
                  }

                  var6.method2071(var0, var1, var2, var16, (class85)var30, (class85)null, class5.field92[var4], 0, var19, var20);
                  if(var8.field967) {
                     if(var4 == 0) {
                        class216.field3159[var0][var1][1 + var2] = 50;
                     } else if(var4 == 1) {
                        class216.field3159[var0][1 + var1][1 + var2] = 50;
                     } else if(var4 == 2) {
                        class216.field3159[var0][var1 + 1][var2] = 50;
                     } else if(var4 == 3) {
                        class216.field3159[var0][var1][var2] = 50;
                     }
                  }

                  if(var8.field953 != 0 && null != var7) {
                     var7.method2433(var1, var2, var5, var4, var8.field954);
                  }

               } else if(var5 == 9) {
                  if(var8.field959 == -1 && null == var8.field947) {
                     var30 = var8.method869(var5, var4, var15, var17, var16, var18);
                  } else {
                     var30 = new class12(var3, var5, var4, var0, var1, var2, var8.field959, true, (class85)null);
                  }

                  var6.method2135(var0, var1, var2, var16, 1, 1, (class85)var30, 0, var19, var20);
                  if(var8.field953 != 0 && var7 != null) {
                     var7.method2462(var1, var2, var9, var10, var8.field954);
                  }

                  if(var8.field960 != 16) {
                     var6.method2008(var0, var1, var2, var8.field960);
                  }

               } else if(var5 == 4) {
                  if(var8.field959 == -1 && var8.field947 == null) {
                     var30 = var8.method869(4, var4, var15, var17, var16, var18);
                  } else {
                     var30 = new class12(var3, 4, var4, var0, var1, var2, var8.field959, true, (class85)null);
                  }

                  var6.method2075(var0, var1, var2, var16, (class85)var30, (class85)null, class5.field91[var4], 0, 0, 0, var19, var20);
               } else if(var5 == 5) {
                  var27 = 16;
                  var22 = var6.method2001(var0, var1, var2);
                  if(var22 != 0) {
                     var27 = class150.method3166(var22 >> 14 & 32767).field960;
                  }

                  if(var8.field959 == -1 && var8.field947 == null) {
                     var26 = var8.method869(4, var4, var15, var17, var16, var18);
                  } else {
                     var26 = new class12(var3, 4, var4, var0, var1, var2, var8.field959, true, (class85)null);
                  }

                  var6.method2075(var0, var1, var2, var16, (class85)var26, (class85)null, class5.field91[var4], 0, var27 * class5.field93[var4], var27 * class5.field94[var4], var19, var20);
               } else if(var5 == 6) {
                  var27 = 8;
                  var22 = var6.method2001(var0, var1, var2);
                  if(var22 != 0) {
                     var27 = class150.method3166(var22 >> 14 & 32767).field960 / 2;
                  }

                  if(var8.field959 == -1 && var8.field947 == null) {
                     var26 = var8.method869(4, 4 + var4, var15, var17, var16, var18);
                  } else {
                     var26 = new class12(var3, 4, 4 + var4, var0, var1, var2, var8.field959, true, (class85)null);
                  }

                  var6.method2075(var0, var1, var2, var16, (class85)var26, (class85)null, 256, var4, class5.field95[var4] * var27, var27 * class5.field102[var4], var19, var20);
               } else if(var5 == 7) {
                  var22 = 2 + var4 & 3;
                  if(var8.field959 == -1 && null == var8.field947) {
                     var30 = var8.method869(4, 4 + var22, var15, var17, var16, var18);
                  } else {
                     var30 = new class12(var3, 4, 4 + var22, var0, var1, var2, var8.field959, true, (class85)null);
                  }

                  var6.method2075(var0, var1, var2, var16, (class85)var30, (class85)null, 256, var22, 0, 0, var19, var20);
               } else if(var5 == 8) {
                  var27 = 8;
                  var22 = var6.method2001(var0, var1, var2);
                  if(var22 != 0) {
                     var27 = class150.method3166(var22 >> 14 & 32767).field960 / 2;
                  }

                  int var25 = 2 + var4 & 3;
                  Object var28;
                  if(var8.field959 == -1 && var8.field947 == null) {
                     var26 = var8.method869(4, var4 + 4, var15, var17, var16, var18);
                     var28 = var8.method869(4, var25 + 4, var15, var17, var16, var18);
                  } else {
                     var26 = new class12(var3, 4, var4 + 4, var0, var1, var2, var8.field959, true, (class85)null);
                     var28 = new class12(var3, 4, 4 + var25, var0, var1, var2, var8.field959, true, (class85)null);
                  }

                  var6.method2075(var0, var1, var2, var16, (class85)var26, (class85)var28, 256, var4, var27 * class5.field95[var4], class5.field102[var4] * var27, var19, var20);
               }
            }
         } else {
            if(var8.field959 == -1 && null == var8.field947) {
               var30 = var8.method869(10, var4, var15, var17, var16, var18);
            } else {
               var30 = new class12(var3, 10, var4, var0, var1, var2, var8.field959, true, (class85)null);
            }

            if(null != var30 && var6.method2135(var0, var1, var2, var16, var9, var10, (class85)var30, var5 == 11?256:0, var19, var20) && var8.field967) {
               var22 = 15;
               if(var30 instanceof class105) {
                  var22 = ((class105)var30).method2359() / 4;
                  if(var22 > 30) {
                     var22 = 30;
                  }
               }

               for(var23 = 0; var23 <= var9; ++var23) {
                  for(int var24 = 0; var24 <= var10; ++var24) {
                     if(var22 > class216.field3159[var0][var1 + var23][var2 + var24]) {
                        class216.field3159[var0][var23 + var1][var2 + var24] = (byte)var22;
                     }
                  }
               }
            }

            if(var8.field953 != 0 && null != var7) {
               var7.method2462(var1, var2, var9, var10, var8.field954);
            }

         }
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)Lclass47;",
      garbageValue = "141790303"
   )
   public static class47 method783(int var0) {
      class47 var1 = (class47)class47.field1081.method3797((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class47.field1078.method3286(14, var0);
         var1 = new class47();
         if(null != var2) {
            var1.method1037(new class119(var2));
         }

         class47.field1081.method3788(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "996871359"
   )
   static final void method784() {
      for(class16 var0 = (class16)client.field421.method3852(); var0 != null; var0 = (class16)client.field421.method3857()) {
         if(var0.field239 > 0) {
            --var0.field239;
         }

         boolean var1;
         int var2;
         int var3;
         class40 var4;
         if(var0.field239 == 0) {
            if(var0.field235 >= 0) {
               var2 = var0.field235;
               var3 = var0.field244;
               var4 = class150.method3166(var2);
               if(var3 == 11) {
                  var3 = 10;
               }

               if(var3 >= 5 && var3 <= 8) {
                  var3 = 4;
               }

               var1 = var4.method874(var3);
               if(!var1) {
                  continue;
               }
            }

            class87.method2137(var0.field241, var0.field242, var0.field233, var0.field231, var0.field235, var0.field236, var0.field244);
            var0.method3946();
         } else {
            if(var0.field232 > 0) {
               --var0.field232;
            }

            if(var0.field232 == 0 && var0.field233 >= 1 && var0.field231 >= 1 && var0.field233 <= 102 && var0.field231 <= 102) {
               if(var0.field238 >= 0) {
                  var2 = var0.field238;
                  var3 = var0.field240;
                  var4 = class150.method3166(var2);
                  if(var3 == 11) {
                     var3 = 10;
                  }

                  if(var3 >= 5 && var3 <= 8) {
                     var3 = 4;
                  }

                  var1 = var4.method874(var3);
                  if(!var1) {
                     continue;
                  }
               }

               class87.method2137(var0.field241, var0.field242, var0.field233, var0.field231, var0.field238, var0.field237, var0.field240);
               var0.field232 = -1;
               if(var0.field235 == var0.field238 && var0.field235 == -1) {
                  var0.method3946();
               } else if(var0.field235 == var0.field238 && var0.field236 == var0.field237 && var0.field240 == var0.field244) {
                  var0.method3946();
               }
            }
         }
      }

   }

   @ObfuscatedName("ce")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "1423383475"
   )
   static final void method785(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(class135.method2897(var0)) {
         class156.method3186(class173.field2770[var0], -1, var1, var2, var3, var4, var5, var6);
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "643926402"
   )
   public static boolean method786(char var0) {
      return var0 >= 48 && var0 <= 57;
   }
}
