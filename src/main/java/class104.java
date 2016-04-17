import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("di")
public final class class104 {
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 492602985
   )
   int field1774;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1341206667
   )
   int field1775;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1077969825
   )
   int field1776;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 258125845
   )
   int field1777;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 2127920837
   )
   int field1778;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1950668399
   )
   int field1779;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -596262733
   )
   int field1780;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -19788041
   )
   int field1781;
   @ObfuscatedName("jr")
   @ObfuscatedGetter(
      intValue = -1836674539
   )
   static int field1782;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 497261005
   )
   int field1783;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 2092006333
   )
   int field1784;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -124489891
   )
   int field1785;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1863131615
   )
   int field1786;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1521874799
   )
   int field1787;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 799890919
   )
   int field1788;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 31982369
   )
   int field1789;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1765812417
   )
   int field1790;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 230791855
   )
   int field1791;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1383860599
   )
   int field1792;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "-927451748"
   )
   public static int method2383(String var0) {
      return var0.length() + 1;
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(IIS)V",
      garbageValue = "-10367"
   )
   static final void method2384(int var0, int var1) {
      if(2 == client.field314) {
         class7.method140((client.field391 - class144.field2204 << 7) + client.field320, (client.field318 - class3.field67 << 7) + client.field321, client.field319 * 2);
         if(client.field400 > -1 && client.field306 % 20 < 10) {
            class127.field2044[0].method1798(client.field400 + var0 - 12, var1 + client.field293 - 28);
         }

      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1402629246"
   )
   public static void method2385() {
      try {
         class149.field2235.method4225();

         for(int var0 = 0; var0 < class149.field2232; ++var0) {
            class89.field1558[var0].method4225();
         }

         class149.field2236.method4225();
         class149.field2234.method4225();
      } catch (Exception var1) {
         ;
      }

   }

   @ObfuscatedName("ca")
   @ObfuscatedSignature(
      signature = "(Lclass173;III)V",
      garbageValue = "2031840053"
   )
   static final void method2386(class173 var0, int var1, int var2) {
      if(1 == var0.field2761) {
         class23.method671(var0.field2875, "", 24, 0, 0, var0.field2842);
      }

      String var3;
      if(var0.field2761 == 2 && !client.field447) {
         var3 = class96.method2276(var0);
         if(null != var3) {
            class23.method671(var3, class139.method3046('\uff00') + var0.field2874, 25, 0, -1, var0.field2842);
         }
      }

      if(3 == var0.field2761) {
         class23.method671("Close", "", 26, 0, 0, var0.field2842);
      }

      if(var0.field2761 == 4) {
         class23.method671(var0.field2875, "", 28, 0, 0, var0.field2842);
      }

      if(5 == var0.field2761) {
         class23.method671(var0.field2875, "", 29, 0, 0, var0.field2842);
      }

      if(6 == var0.field2761 && client.field526 == null) {
         class23.method671(var0.field2875, "", 30, 0, -1, var0.field2842);
      }

      int var4;
      int var5;
      int var16;
      if(var0.field2824 == 2) {
         var16 = 0;

         for(var4 = 0; var4 < var0.field2774; ++var4) {
            for(var5 = 0; var5 < var0.field2773; ++var5) {
               int var6 = var5 * (32 + var0.field2758);
               int var7 = (var0.field2825 + 32) * var4;
               if(var16 < 20) {
                  var6 += var0.field2826[var16];
                  var7 += var0.field2750[var16];
               }

               if(var1 >= var6 && var2 >= var7 && var1 < 32 + var6 && var2 < var7 + 32) {
                  client.field411 = var16;
                  class140.field2150 = var0;
                  if(var0.field2876[var16] > 0) {
                     label364: {
                        class51 var8 = class11.method178(var0.field2876[var16] - 1);
                        boolean var9;
                        int var10;
                        if(1 == client.field448) {
                           var10 = class31.method776(var0);
                           var9 = (var10 >> 30 & 1) != 0;
                           if(var9) {
                              if(class40.field931 != var0.field2842 || var16 != class11.field187) {
                                 class23.method671("Use", client.field378 + " " + "->" + " " + class139.method3046(16748608) + var8.field1125, 31, var8.field1123, var16, var0.field2842);
                              }
                              break label364;
                           }
                        }

                        if(client.field447) {
                           var10 = class31.method776(var0);
                           var9 = 0 != (var10 >> 30 & 1);
                           if(var9) {
                              if(16 == (class161.field2636 & 16)) {
                                 class23.method671(client.field297, client.field534 + " " + "->" + " " + class139.method3046(16748608) + var8.field1125, 32, var8.field1123, var16, var0.field2842);
                              }
                              break label364;
                           }
                        }

                        String[] var20 = var8.field1140;
                        if(client.field463) {
                           var20 = class89.method2163(var20);
                        }

                        int var11 = class31.method776(var0);
                        boolean var21 = (var11 >> 30 & 1) != 0;
                        if(var21) {
                           for(int var12 = 4; var12 >= 3; --var12) {
                              if(null != var20 && var20[var12] != null) {
                                 byte var13;
                                 if(3 == var12) {
                                    var13 = 36;
                                 } else {
                                    var13 = 37;
                                 }

                                 class23.method671(var20[var12], class139.method3046(16748608) + var8.field1125, var13, var8.field1123, var16, var0.field2842);
                              } else if(4 == var12) {
                                 class23.method671("Drop", class139.method3046(16748608) + var8.field1125, 37, var8.field1123, var16, var0.field2842);
                              }
                           }
                        }

                        class178 var10000 = (class178)null;
                        if(class121.method2861(class31.method776(var0))) {
                           class23.method671("Use", class139.method3046(16748608) + var8.field1125, 38, var8.field1123, var16, var0.field2842);
                        }

                        int var23 = class31.method776(var0);
                        boolean var22 = 0 != (var23 >> 30 & 1);
                        int var14;
                        byte var15;
                        if(var22 && var20 != null) {
                           for(var14 = 2; var14 >= 0; --var14) {
                              if(null != var20[var14]) {
                                 var15 = 0;
                                 if(var14 == 0) {
                                    var15 = 33;
                                 }

                                 if(var14 == 1) {
                                    var15 = 34;
                                 }

                                 if(2 == var14) {
                                    var15 = 35;
                                 }

                                 class23.method671(var20[var14], class139.method3046(16748608) + var8.field1125, var15, var8.field1123, var16, var0.field2842);
                              }
                           }
                        }

                        var20 = var0.field2829;
                        if(client.field463) {
                           var20 = class89.method2163(var20);
                        }

                        if(var20 != null) {
                           for(var14 = 4; var14 >= 0; --var14) {
                              if(null != var20[var14]) {
                                 var15 = 0;
                                 if(var14 == 0) {
                                    var15 = 39;
                                 }

                                 if(var14 == 1) {
                                    var15 = 40;
                                 }

                                 if(var14 == 2) {
                                    var15 = 41;
                                 }

                                 if(var14 == 3) {
                                    var15 = 42;
                                 }

                                 if(4 == var14) {
                                    var15 = 43;
                                 }

                                 class23.method671(var20[var14], class139.method3046(16748608) + var8.field1125, var15, var8.field1123, var16, var0.field2842);
                              }
                           }
                        }

                        class23.method671("Examine", class139.method3046(16748608) + var8.field1125, 1005, var8.field1123, var16, var0.field2842);
                     }
                  }
               }

               ++var16;
            }
         }
      }

      if(var0.field2757) {
         if(client.field447) {
            if(class107.method2483(class31.method776(var0)) && 32 == (class161.field2636 & 32)) {
               class23.method671(client.field297, client.field534 + " " + "->" + " " + var0.field2831, 58, 0, var0.field2759, var0.field2842);
            }
         } else {
            for(var16 = 9; var16 >= 5; --var16) {
               String var17 = class34.method805(var0, var16);
               if(var17 != null) {
                  class23.method671(var17, var0.field2831, 1007, 1 + var16, var0.field2759, var0.field2842);
               }
            }

            var3 = class96.method2276(var0);
            if(null != var3) {
               class23.method671(var3, var0.field2831, 25, 0, var0.field2759, var0.field2842);
            }

            for(var4 = 4; var4 >= 0; --var4) {
               String var19 = class34.method805(var0, var4);
               if(var19 != null) {
                  class23.method671(var19, var0.field2831, 57, var4 + 1, var0.field2759, var0.field2842);
               }
            }

            var5 = class31.method776(var0);
            boolean var18 = 0 != (var5 & 1);
            if(var18) {
               class23.method671("Continue", "", 30, 0, var0.field2759, var0.field2842);
            }
         }
      }

   }
}
