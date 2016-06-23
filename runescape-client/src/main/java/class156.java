import java.awt.Graphics;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fe")
public class class156 {
   @ObfuscatedName("eu")
   static class78[] field2305;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Z",
      garbageValue = "-815818150"
   )
   public static boolean method3184(CharSequence var0) {
      boolean var2 = false;
      boolean var3 = false;
      int var4 = 0;
      int var5 = var0.length();
      int var6 = 0;

      boolean var1;
      while(true) {
         if(var6 >= var5) {
            var1 = var3;
            break;
         }

         label90: {
            char var7 = var0.charAt(var6);
            if(var6 == 0) {
               if(var7 == 45) {
                  var2 = true;
                  break label90;
               }

               if(var7 == 43) {
                  break label90;
               }
            }

            int var9;
            if(var7 >= 48 && var7 <= 57) {
               var9 = var7 - 48;
            } else if(var7 >= 65 && var7 <= 90) {
               var9 = var7 - 55;
            } else {
               if(var7 < 97 || var7 > 122) {
                  var1 = false;
                  break;
               }

               var9 = var7 - 87;
            }

            if(var9 >= 10) {
               var1 = false;
               break;
            }

            if(var2) {
               var9 = -var9;
            }

            int var8 = var9 + var4 * 10;
            if(var4 != var8 / 10) {
               var1 = false;
               break;
            }

            var4 = var8;
            var3 = true;
         }

         ++var6;
      }

      return var1;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1071080853"
   )
   static void method3185(int var0) {
      if(var0 != -1) {
         if(class135.method2897(var0)) {
            class173[] var1 = class173.field2770[var0];

            for(int var2 = 0; var2 < var1.length; ++var2) {
               class173 var3 = var1[var2];
               if(var3.field2835 != null) {
                  class0 var4 = new class0();
                  var4.field1 = var3;
                  var4.field0 = var3.field2835;
                  class31.method737(var4, 2000000);
               }
            }

         }
      }
   }

   @ObfuscatedName("dh")
   @ObfuscatedSignature(
      signature = "([Lclass173;IIIIIIII)V",
      garbageValue = "-2034511834"
   )
   static final void method3186(class173[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      for(int var8 = 0; var8 < var0.length; ++var8) {
         class173 var9 = var0[var8];
         if(var9 != null && (!var9.field2860 || var9.field2798 == 0 || var9.field2834 || class18.method205(var9) != 0 || client.field298 == var9 || var9.field2758 == 1338) && var1 == var9.field2773 && (!var9.field2860 || !class6.method107(var9))) {
            int var10 = var6 + var9.field2873;
            int var11 = var7 + var9.field2807;
            int var12;
            int var13;
            int var14;
            int var15;
            int var16;
            int var17;
            if(var9.field2798 == 2) {
               var12 = var2;
               var13 = var3;
               var14 = var4;
               var15 = var5;
            } else if(var9.field2798 == 9) {
               var16 = var10;
               var17 = var11;
               int var18 = var10 + var9.field2769;
               int var19 = var9.field2888 + var11;
               if(var18 < var10) {
                  var16 = var18;
                  var18 = var10;
               }

               if(var19 < var11) {
                  var17 = var19;
                  var19 = var11;
               }

               ++var18;
               ++var19;
               var12 = var16 > var2?var16:var2;
               var13 = var17 > var3?var17:var3;
               var14 = var18 < var4?var18:var4;
               var15 = var19 < var5?var19:var5;
            } else {
               var16 = var10 + var9.field2769;
               var17 = var9.field2888 + var11;
               var12 = var10 > var2?var10:var2;
               var13 = var11 > var3?var11:var3;
               var14 = var16 < var4?var16:var4;
               var15 = var17 < var5?var17:var5;
            }

            if(client.field428 == var9) {
               client.field468 = true;
               client.field469 = var10;
               client.field295 = var11;
            }

            if(!var9.field2860 || var12 < var14 && var13 < var15) {
               var16 = class140.field2146;
               var17 = class140.field2151;
               if(class140.field2156 != 0) {
                  var16 = class140.field2161;
                  var17 = class140.field2158;
               }

               if(var9.field2758 == 1337) {
                  if(!client.field300 && !client.field310 && var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15) {
                     class10.method139(var16, var17, var12, var13);
                  }
               } else if(var9.field2758 == 1338) {
                  class46.method1019(var9, var10, var11);
               } else {
                  if(!client.field310 && var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15) {
                     class45.method1002(var9, var16 - var10, var17 - var11);
                  }

                  if(var9.field2798 == 0) {
                     if(!var9.field2860 && class6.method107(var9) && class59.field1234 != var9) {
                        continue;
                     }

                     method3186(var0, var9.field2869, var12, var13, var14, var15, var10 - var9.field2878, var11 - var9.field2776);
                     if(null != var9.field2767) {
                        method3186(var9.field2767, var9.field2869, var12, var13, var14, var15, var10 - var9.field2878, var11 - var9.field2776);
                     }

                     class3 var25 = (class3)client.field448.method3822((long)var9.field2869);
                     if(var25 != null) {
                        if(var25.field62 == 0 && class140.field2146 >= var12 && class140.field2151 >= var13 && class140.field2146 < var14 && class140.field2151 < var15 && !client.field310 && !client.field534) {
                           for(class0 var28 = (class0)client.field486.method3852(); null != var28; var28 = (class0)client.field486.method3857()) {
                              if(var28.field6) {
                                 var28.method3946();
                                 var28.field1.field2879 = false;
                              }
                           }

                           if(class72.field1367 == 0) {
                              client.field428 = null;
                              client.field298 = null;
                           }

                           if(!client.field310) {
                              client.field459[0] = "Cancel";
                              client.field435[0] = "";
                              client.field329[0] = 1006;
                              client.field429 = 1;
                           }
                        }

                        class36.method785(var25.field64, var12, var13, var14, var15, var10, var11);
                     }
                  }

                  if(var9.field2860) {
                     class0 var31;
                     if(!var9.field2887) {
                        if(var9.field2849 && class140.field2146 >= var12 && class140.field2151 >= var13 && class140.field2146 < var14 && class140.field2151 < var15) {
                           for(var31 = (class0)client.field486.method3852(); var31 != null; var31 = (class0)client.field486.method3857()) {
                              if(var31.field6 && var31.field1.field2855 == var31.field0) {
                                 var31.method3946();
                              }
                           }
                        }
                     } else if(class140.field2146 >= var12 && class140.field2151 >= var13 && class140.field2146 < var14 && class140.field2151 < var15) {
                        for(var31 = (class0)client.field486.method3852(); var31 != null; var31 = (class0)client.field486.method3857()) {
                           if(var31.field6) {
                              var31.method3946();
                              var31.field1.field2879 = false;
                           }
                        }

                        if(class72.field1367 == 0) {
                           client.field428 = null;
                           client.field298 = null;
                        }

                        if(!client.field310) {
                           client.field459[0] = "Cancel";
                           client.field435[0] = "";
                           client.field329[0] = 1006;
                           client.field429 = 1;
                        }
                     }

                     boolean var29;
                     if(class140.field2146 >= var12 && class140.field2151 >= var13 && class140.field2146 < var14 && class140.field2151 < var15) {
                        var29 = true;
                     } else {
                        var29 = false;
                     }

                     boolean var30 = false;
                     if((class140.field2144 == 1 || !class148.field2224 && class140.field2144 == 4) && var29) {
                        var30 = true;
                     }

                     boolean var20 = false;
                     if((class140.field2156 == 1 || !class148.field2224 && class140.field2156 == 4) && class140.field2161 >= var12 && class140.field2158 >= var13 && class140.field2161 < var14 && class140.field2158 < var15) {
                        var20 = true;
                     }

                     if(var20) {
                        class18.method202(var9, class140.field2161 - var10, class140.field2158 - var11);
                     }

                     if(client.field428 != null && client.field428 != var9 && var29 && class134.method2893(class18.method205(var9))) {
                        client.field399 = var9;
                     }

                     if(var9 == client.field298) {
                        client.field465 = true;
                        client.field466 = var10;
                        client.field467 = var11;
                     }

                     if(var9.field2834) {
                        class0 var21;
                        if(var29 && client.field485 != 0 && var9.field2855 != null) {
                           var21 = new class0();
                           var21.field6 = true;
                           var21.field1 = var9;
                           var21.field4 = client.field485;
                           var21.field0 = var9.field2855;
                           client.field486.method3877(var21);
                        }

                        if(null != client.field428 || class167.field2675 != null || client.field310) {
                           var20 = false;
                           var30 = false;
                           var29 = false;
                        }

                        if(!var9.field2880 && var20) {
                           var9.field2880 = true;
                           if(var9.field2836 != null) {
                              var21 = new class0();
                              var21.field6 = true;
                              var21.field1 = var9;
                              var21.field3 = class140.field2161 - var10;
                              var21.field4 = class140.field2158 - var11;
                              var21.field0 = var9.field2836;
                              client.field486.method3877(var21);
                           }
                        }

                        if(var9.field2880 && var30 && null != var9.field2872) {
                           var21 = new class0();
                           var21.field6 = true;
                           var21.field1 = var9;
                           var21.field3 = class140.field2146 - var10;
                           var21.field4 = class140.field2151 - var11;
                           var21.field0 = var9.field2872;
                           client.field486.method3877(var21);
                        }

                        if(var9.field2880 && !var30) {
                           var9.field2880 = false;
                           if(var9.field2772 != null) {
                              var21 = new class0();
                              var21.field6 = true;
                              var21.field1 = var9;
                              var21.field3 = class140.field2146 - var10;
                              var21.field4 = class140.field2151 - var11;
                              var21.field0 = var9.field2772;
                              client.field488.method3877(var21);
                           }
                        }

                        if(var30 && null != var9.field2881) {
                           var21 = new class0();
                           var21.field6 = true;
                           var21.field1 = var9;
                           var21.field3 = class140.field2146 - var10;
                           var21.field4 = class140.field2151 - var11;
                           var21.field0 = var9.field2881;
                           client.field486.method3877(var21);
                        }

                        if(!var9.field2879 && var29) {
                           var9.field2879 = true;
                           if(var9.field2840 != null) {
                              var21 = new class0();
                              var21.field6 = true;
                              var21.field1 = var9;
                              var21.field3 = class140.field2146 - var10;
                              var21.field4 = class140.field2151 - var11;
                              var21.field0 = var9.field2840;
                              client.field486.method3877(var21);
                           }
                        }

                        if(var9.field2879 && var29 && var9.field2765 != null) {
                           var21 = new class0();
                           var21.field6 = true;
                           var21.field1 = var9;
                           var21.field3 = class140.field2146 - var10;
                           var21.field4 = class140.field2151 - var11;
                           var21.field0 = var9.field2765;
                           client.field486.method3877(var21);
                        }

                        if(var9.field2879 && !var29) {
                           var9.field2879 = false;
                           if(null != var9.field2875) {
                              var21 = new class0();
                              var21.field6 = true;
                              var21.field1 = var9;
                              var21.field3 = class140.field2146 - var10;
                              var21.field4 = class140.field2151 - var11;
                              var21.field0 = var9.field2875;
                              client.field488.method3877(var21);
                           }
                        }

                        if(var9.field2853 != null) {
                           var21 = new class0();
                           var21.field1 = var9;
                           var21.field0 = var9.field2853;
                           client.field393.method3877(var21);
                        }

                        int var23;
                        class0 var24;
                        int var26;
                        int var27;
                        if(var9.field2847 != null && client.field290 > var9.field2786) {
                           if(null != var9.field2848 && client.field290 - var9.field2786 <= 32) {
                              label751:
                              for(var26 = var9.field2786; var26 < client.field290; ++var26) {
                                 var27 = client.field408[var26 & 31];

                                 for(var23 = 0; var23 < var9.field2848.length; ++var23) {
                                    if(var27 == var9.field2848[var23]) {
                                       var24 = new class0();
                                       var24.field1 = var9;
                                       var24.field0 = var9.field2847;
                                       client.field486.method3877(var24);
                                       break label751;
                                    }
                                 }
                              }
                           } else {
                              var21 = new class0();
                              var21.field1 = var9;
                              var21.field0 = var9.field2847;
                              client.field486.method3877(var21);
                           }

                           var9.field2786 = client.field290;
                        }

                        if(var9.field2865 != null && client.field476 > var9.field2883) {
                           if(var9.field2850 != null && client.field476 - var9.field2883 <= 32) {
                              label727:
                              for(var26 = var9.field2883; var26 < client.field476; ++var26) {
                                 var27 = client.field475[var26 & 31];

                                 for(var23 = 0; var23 < var9.field2850.length; ++var23) {
                                    if(var9.field2850[var23] == var27) {
                                       var24 = new class0();
                                       var24.field1 = var9;
                                       var24.field0 = var9.field2865;
                                       client.field486.method3877(var24);
                                       break label727;
                                    }
                                 }
                              }
                           } else {
                              var21 = new class0();
                              var21.field1 = var9;
                              var21.field0 = var9.field2865;
                              client.field486.method3877(var21);
                           }

                           var9.field2883 = client.field476;
                        }

                        if(null != var9.field2851 && client.field478 > var9.field2884) {
                           if(var9.field2852 != null && client.field478 - var9.field2884 <= 32) {
                              label703:
                              for(var26 = var9.field2884; var26 < client.field478; ++var26) {
                                 var27 = client.field477[var26 & 31];

                                 for(var23 = 0; var23 < var9.field2852.length; ++var23) {
                                    if(var27 == var9.field2852[var23]) {
                                       var24 = new class0();
                                       var24.field1 = var9;
                                       var24.field0 = var9.field2851;
                                       client.field486.method3877(var24);
                                       break label703;
                                    }
                                 }
                              }
                           } else {
                              var21 = new class0();
                              var21.field1 = var9;
                              var21.field0 = var9.field2851;
                              client.field486.method3877(var21);
                           }

                           var9.field2884 = client.field478;
                        }

                        if(client.field481 > var9.field2808 && null != var9.field2766) {
                           var21 = new class0();
                           var21.field1 = var9;
                           var21.field0 = var9.field2766;
                           client.field486.method3877(var21);
                        }

                        if(client.field480 > var9.field2808 && null != var9.field2745) {
                           var21 = new class0();
                           var21.field1 = var9;
                           var21.field0 = var9.field2745;
                           client.field486.method3877(var21);
                        }

                        if(client.field542 > var9.field2808 && var9.field2838 != null) {
                           var21 = new class0();
                           var21.field1 = var9;
                           var21.field0 = var9.field2838;
                           client.field486.method3877(var21);
                        }

                        if(client.field562 > var9.field2808 && null != var9.field2864) {
                           var21 = new class0();
                           var21.field1 = var9;
                           var21.field0 = var9.field2864;
                           client.field486.method3877(var21);
                        }

                        if(client.field535 > var9.field2808 && var9.field2791 != null) {
                           var21 = new class0();
                           var21.field1 = var9;
                           var21.field0 = var9.field2791;
                           client.field486.method3877(var21);
                        }

                        if(client.field527 > var9.field2808 && var9.field2751 != null) {
                           var21 = new class0();
                           var21.field1 = var9;
                           var21.field0 = var9.field2751;
                           client.field486.method3877(var21);
                        }

                        var9.field2808 = client.field563;
                        if(null != var9.field2857) {
                           for(var26 = 0; var26 < client.field510; ++var26) {
                              class0 var22 = new class0();
                              var22.field1 = var9;
                              var22.field7 = client.field512[var26];
                              var22.field8 = client.field430[var26];
                              var22.field0 = var9.field2857;
                              client.field486.method3877(var22);
                           }
                        }
                     }
                  }

                  if(!var9.field2860 && client.field428 == null && class167.field2675 == null && !client.field310) {
                     if((var9.field2827 >= 0 || var9.field2781 != 0) && class140.field2146 >= var12 && class140.field2151 >= var13 && class140.field2146 < var14 && class140.field2151 < var15) {
                        if(var9.field2827 >= 0) {
                           class59.field1234 = var0[var9.field2827];
                        } else {
                           class59.field1234 = var9;
                        }
                     }

                     if(var9.field2798 == 8 && class140.field2146 >= var12 && class140.field2151 >= var13 && class140.field2146 < var14 && class140.field2151 < var15) {
                        class42.field1002 = var9;
                     }

                     if(var9.field2778 > var9.field2888) {
                        class149.method3163(var9, var10 + var9.field2769, var11, var9.field2888, var9.field2778, class140.field2146, class140.field2151);
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass224;Lclass224;Lclass224;ZI)V",
      garbageValue = "-1618010456"
   )
   static void method3187(class224 var0, class224 var1, class224 var2, boolean var3) {
      if(var3) {
         class31.field725 = (class30.field708 - client.field502) / 2;
         class31.field731 = 202 + class31.field725;
      }

      if(class31.field722) {
         class152.method3174(var0, var1);
      } else {
         if(var3) {
            class31.field717.method1761(class31.field725, 0);
            class172.field2738.method1761(382 + class31.field725, 0);
            class159.field2605.method1916(class31.field725 + 382 - class159.field2605.field1428 / 2, 18);
         }

         int var5;
         if(client.field299 == 0 || client.field299 == 5) {
            byte var4 = 20;
            var0.method4073("RuneScape is loading - please wait...", class31.field731 + 180, 245 - var4, 16777215, -1);
            var5 = 253 - var4;
            class79.method1860(class31.field731 + 180 - 152, var5, 304, 34, 9179409);
            class79.method1860(class31.field731 + 180 - 151, 1 + var5, 302, 32, 0);
            class79.method1854(180 + class31.field731 - 150, 2 + var5, class31.field728 * 3, 30, 9179409);
            class79.method1854(class31.field728 * 3 + (class31.field731 + 180 - 150), var5 + 2, 300 - class31.field728 * 3, 30, 0);
            var0.method4073(class31.field740, class31.field731 + 180, 276 - var4, 16777215, -1);
         }

         String var6;
         int var12;
         short var24;
         int var25;
         short var26;
         if(client.field299 == 20) {
            class31.field713.method1916(class31.field731 + 180 - class31.field713.field1428 / 2, 271 - class31.field713.field1429 / 2);
            var24 = 211;
            var0.method4073(class31.field730, 180 + class31.field731, var24, 16776960, 0);
            var25 = var24 + 15;
            var0.method4073(class31.field733, class31.field731 + 180, var25, 16776960, 0);
            var25 += 15;
            var0.method4073(class31.field734, 180 + class31.field731, var25, 16776960, 0);
            var25 += 15;
            var25 += 10;
            if(class31.field724 != 4) {
               var0.method4066("Login: ", 180 + class31.field731 - 110, var25, 16777215, 0);
               var26 = 200;

               for(var6 = class31.field729; var0.method4043(var6) > var26; var6 = var6.substring(0, var6.length() - 1)) {
                  ;
               }

               var0.method4066(class223.method4069(var6), 180 + class31.field731 - 70, var25, 16777215, 0);
               var25 += 15;
               String var8 = "Password: ";
               String var10 = class31.field736;
               var12 = var10.length();
               char[] var13 = new char[var12];

               for(int var14 = 0; var14 < var12; ++var14) {
                  var13[var14] = 42;
               }

               String var11 = new String(var13);
               var0.method4066(var8 + var11, class31.field731 + 180 - 108, var25, 16777215, 0);
               var25 += 15;
            }
         }

         int var16;
         int var27;
         int var28;
         if(client.field299 == 10 || client.field299 == 11) {
            class31.field713.method1916(class31.field731, 171);
            short var15;
            if(class31.field724 == 0) {
               var24 = 251;
               var0.method4073("Welcome to RuneScape", class31.field731 + 180, var24, 16776960, 0);
               var25 = var24 + 30;
               var5 = 180 + class31.field731 - 80;
               var15 = 291;
               class31.field716.method1916(var5 - 73, var15 - 20);
               var0.method4051("New User", var5 - 73, var15 - 20, 144, 40, 16777215, 0, 1, 1, 0);
               var5 = 180 + class31.field731 + 80;
               class31.field716.method1916(var5 - 73, var15 - 20);
               var0.method4051("Existing User", var5 - 73, var15 - 20, 144, 40, 16777215, 0, 1, 1, 0);
            } else if(class31.field724 == 1) {
               var0.method4073(class31.field720, 180 + class31.field731, 211, 16776960, 0);
               var24 = 236;
               var0.method4073(class31.field730, 180 + class31.field731, var24, 16777215, 0);
               var25 = var24 + 15;
               var0.method4073(class31.field733, 180 + class31.field731, var25, 16777215, 0);
               var25 += 15;
               var0.method4073(class31.field734, 180 + class31.field731, var25, 16777215, 0);
               var25 += 15;
               var5 = class31.field731 + 180 - 80;
               var15 = 321;
               class31.field716.method1916(var5 - 73, var15 - 20);
               var0.method4073("Continue", var5, var15 + 5, 16777215, 0);
               var5 = class31.field731 + 180 + 80;
               class31.field716.method1916(var5 - 73, var15 - 20);
               var0.method4073("Cancel", var5, var15 + 5, 16777215, 0);
            } else {
               short var17;
               if(class31.field724 == 2) {
                  var24 = 211;
                  var0.method4073(class31.field730, 180 + class31.field731, var24, 16776960, 0);
                  var25 = var24 + 15;
                  var0.method4073(class31.field733, class31.field731 + 180, var25, 16776960, 0);
                  var25 += 15;
                  var0.method4073(class31.field734, class31.field731 + 180, var25, 16776960, 0);
                  var25 += 15;
                  var25 += 10;
                  var0.method4066("Login: ", 180 + class31.field731 - 110, var25, 16777215, 0);
                  var26 = 200;

                  for(var6 = class31.field729; var0.method4043(var6) > var26; var6 = var6.substring(1)) {
                     ;
                  }

                  var0.method4066(class223.method4069(var6) + (class31.field739 == 0 & client.field301 % 40 < 20?class164.method3251(16776960) + "|":""), 180 + class31.field731 - 70, var25, 16777215, 0);
                  var25 += 15;
                  var0.method4066("Password: " + class124.method2807(class31.field736) + (class31.field739 == 1 & client.field301 % 40 < 20?class164.method3251(16776960) + "|":""), 180 + class31.field731 - 108, var25, 16777215, 0);
                  var25 += 15;
                  var16 = 180 + class31.field731 - 80;
                  var17 = 321;
                  class31.field716.method1916(var16 - 73, var17 - 20);
                  var0.method4073("Login", var16, var17 + 5, 16777215, 0);
                  var16 = 80 + 180 + class31.field731;
                  class31.field716.method1916(var16 - 73, var17 - 20);
                  var0.method4073("Cancel", var16, var17 + 5, 16777215, 0);
                  var24 = 357;
                  var1.method4073("Forgotten your password? <col=ffffff>Click here.", 180 + class31.field731, var24, 16776960, 0);
               } else if(class31.field724 == 3) {
                  var24 = 201;
                  var0.method4073("Invalid username or password.", class31.field731 + 180, var24, 16776960, 0);
                  var25 = var24 + 20;
                  var1.method4073("For accounts created after 24th November 2010, please use your", class31.field731 + 180, var25, 16776960, 0);
                  var25 += 15;
                  var1.method4073("email address to login. Otherwise please login with your username.", class31.field731 + 180, var25, 16776960, 0);
                  var25 += 15;
                  var5 = 180 + class31.field731;
                  var15 = 276;
                  class31.field716.method1916(var5 - 73, var15 - 20);
                  var2.method4073("Try again", var5, 5 + var15, 16777215, 0);
                  var5 = 180 + class31.field731;
                  var15 = 326;
                  class31.field716.method1916(var5 - 73, var15 - 20);
                  var2.method4073("Forgotten password?", var5, var15 + 5, 16777215, 0);
               } else if(class31.field724 == 4) {
                  var0.method4073("Authenticator", class31.field731 + 180, 211, 16776960, 0);
                  var24 = 236;
                  var0.method4073(class31.field730, class31.field731 + 180, var24, 16777215, 0);
                  var25 = var24 + 15;
                  var0.method4073(class31.field733, class31.field731 + 180, var25, 16777215, 0);
                  var25 += 15;
                  var0.method4073(class31.field734, class31.field731 + 180, var25, 16777215, 0);
                  var25 += 15;
                  var0.method4066("PIN: " + class124.method2807(class104.field1797) + (client.field301 % 40 < 20?class164.method3251(16776960) + "|":""), 180 + class31.field731 - 108, var25, 16777215, 0);
                  var25 -= 8;
                  var0.method4066("Trust this computer", 180 + class31.field731 - 9, var25, 16776960, 0);
                  var25 += 15;
                  var0.method4066("for 30 days: ", class31.field731 + 180 - 9, var25, 16776960, 0);
                  var5 = class31.field731 + 180 - 9 + var0.method4043("for 30 days: ") + 15;
                  var27 = var25 - var0.field3188;
                  class80 var7;
                  if(class31.field738) {
                     var7 = class31.field719;
                  } else {
                     var7 = class31.field718;
                  }

                  var7.method1916(var5, var27);
                  var25 += 15;
                  var28 = 180 + class31.field731 - 80;
                  short var18 = 321;
                  class31.field716.method1916(var28 - 73, var18 - 20);
                  var0.method4073("Continue", var28, 5 + var18, 16777215, 0);
                  var28 = 180 + class31.field731 + 80;
                  class31.field716.method1916(var28 - 73, var18 - 20);
                  var0.method4073("Cancel", var28, 5 + var18, 16777215, 0);
                  var1.method4073("<u=ff>Can\'t Log In?</u>", 180 + class31.field731, var18 + 36, 255, 0);
               } else if(class31.field724 == 5) {
                  var0.method4073("Forgotten your password?", 180 + class31.field731, 201, 16776960, 0);
                  var24 = 221;
                  var2.method4073(class31.field730, 180 + class31.field731, var24, 16776960, 0);
                  var25 = var24 + 15;
                  var2.method4073(class31.field733, 180 + class31.field731, var25, 16776960, 0);
                  var25 += 15;
                  var2.method4073(class31.field734, 180 + class31.field731, var25, 16776960, 0);
                  var25 += 15;
                  var25 += 14;
                  var0.method4066("Username/email: ", 180 + class31.field731 - 145, var25, 16777215, 0);
                  var26 = 174;

                  for(var6 = class31.field729; var0.method4043(var6) > var26; var6 = var6.substring(1)) {
                     ;
                  }

                  var0.method4066(class223.method4069(var6) + (client.field301 % 40 < 20?class164.method3251(16776960) + "|":""), class31.field731 + 180 - 34, var25, 16777215, 0);
                  var25 += 15;
                  var16 = 180 + class31.field731 - 80;
                  var17 = 321;
                  class31.field716.method1916(var16 - 73, var17 - 20);
                  var0.method4073("Recover", var16, 5 + var17, 16777215, 0);
                  var16 = class31.field731 + 180 + 80;
                  class31.field716.method1916(var16 - 73, var17 - 20);
                  var0.method4073("Back", var16, 5 + var17, 16777215, 0);
               } else if(class31.field724 == 6) {
                  var24 = 211;
                  var0.method4073(class31.field730, 180 + class31.field731, var24, 16776960, 0);
                  var25 = var24 + 15;
                  var0.method4073(class31.field733, 180 + class31.field731, var25, 16776960, 0);
                  var25 += 15;
                  var0.method4073(class31.field734, class31.field731 + 180, var25, 16776960, 0);
                  var25 += 15;
                  var5 = class31.field731 + 180;
                  var15 = 321;
                  class31.field716.method1916(var5 - 73, var15 - 20);
                  var0.method4073("Back", var5, 5 + var15, 16777215, 0);
               }
            }
         }

         if(class31.field726 > 0) {
            var25 = class31.field726;
            var26 = 256;
            class31.field735 += 128 * var25;
            if(class31.field735 > class114.field1974.length) {
               class31.field735 -= class114.field1974.length;
               var27 = (int)(Math.random() * 12.0D);
               class25.method666(class28.field684[var27]);
            }

            var27 = 0;
            var16 = 128 * var25;
            var28 = 128 * (var26 - var25);

            int var19;
            int var31;
            for(var31 = 0; var31 < var28; ++var31) {
               var19 = class18.field270[var27 + var16] - var25 * class114.field1974[class31.field735 + var27 & class114.field1974.length - 1] / 6;
               if(var19 < 0) {
                  var19 = 0;
               }

               class18.field270[var27++] = var19;
            }

            int var20;
            for(var31 = var26 - var25; var31 < var26; ++var31) {
               var19 = 128 * var31;

               for(var20 = 0; var20 < 128; ++var20) {
                  var12 = (int)(Math.random() * 100.0D);
                  if(var12 < 50 && var20 > 10 && var20 < 118) {
                     class18.field270[var19 + var20] = 255;
                  } else {
                     class18.field270[var20 + var19] = 0;
                  }
               }
            }

            if(class31.field714 > 0) {
               class31.field714 -= var25 * 4;
            }

            if(class31.field723 > 0) {
               class31.field723 -= var25 * 4;
            }

            if(class31.field714 == 0 && class31.field723 == 0) {
               var31 = (int)(Math.random() * (double)(2000 / var25));
               if(var31 == 0) {
                  class31.field714 = 1024;
               }

               if(var31 == 1) {
                  class31.field723 = 1024;
               }
            }

            for(var31 = 0; var31 < var26 - var25; ++var31) {
               class31.field721[var31] = class31.field721[var25 + var31];
            }

            for(var31 = var26 - var25; var31 < var26; ++var31) {
               class31.field721[var31] = (int)(Math.sin((double)class31.field742 / 14.0D) * 16.0D + Math.sin((double)class31.field742 / 15.0D) * 14.0D + Math.sin((double)class31.field742 / 16.0D) * 12.0D);
               ++class31.field742;
            }

            class31.field747 += var25;
            var31 = (var25 + (client.field301 & 1)) / 2;
            if(var31 > 0) {
               for(var19 = 0; var19 < class31.field747 * 100; ++var19) {
                  var20 = (int)(Math.random() * 124.0D) + 2;
                  var12 = (int)(Math.random() * 128.0D) + 128;
                  class18.field270[var20 + (var12 << 7)] = 192;
               }

               class31.field747 = 0;
               var19 = 0;

               label281:
               while(true) {
                  int var21;
                  if(var19 >= var26) {
                     var19 = 0;

                     while(true) {
                        if(var19 >= 128) {
                           break label281;
                        }

                        var20 = 0;

                        for(var12 = -var31; var12 < var26; ++var12) {
                           var21 = var12 * 128;
                           if(var31 + var12 < var26) {
                              var20 += class25.field642[var21 + var19 + var31 * 128];
                           }

                           if(var12 - (var31 + 1) >= 0) {
                              var20 -= class25.field642[var21 + var19 - (1 + var31) * 128];
                           }

                           if(var12 >= 0) {
                              class18.field270[var21 + var19] = var20 / (2 * var31 + 1);
                           }
                        }

                        ++var19;
                     }
                  }

                  var20 = 0;
                  var12 = 128 * var19;

                  for(var21 = -var31; var21 < 128; ++var21) {
                     if(var21 + var31 < 128) {
                        var20 += class18.field270[var31 + var21 + var12];
                     }

                     if(var21 - (var31 + 1) >= 0) {
                        var20 -= class18.field270[var21 + var12 - (1 + var31)];
                     }

                     if(var21 >= 0) {
                        class25.field642[var12 + var21] = var20 / (var31 * 2 + 1);
                     }
                  }

                  ++var19;
               }
            }

            class31.field726 = 0;
         }

         class121.method2769();
         class176.field2906[class20.field580.field141?1:0].method1916(class31.field725 + 765 - 40, 463);
         if(client.field299 > 5 && client.field297 == 0) {
            if(class52.field1171 != null) {
               var25 = 5 + class31.field725;
               var26 = 463;
               byte var30 = 100;
               byte var29 = 35;
               class52.field1171.method1916(var25, var26);
               var0.method4073("World" + " " + client.field386, var30 / 2 + var25, var29 / 2 + var26 - 2, 16777215, 0);
               if(class189.field3050 != null) {
                  var1.method4073("Loading...", var30 / 2 + var25, 12 + var26 + var29 / 2, 16777215, 0);
               } else {
                  var1.method4073("Click to switch", var30 / 2 + var25, var29 / 2 + var26 + 12, 16777215, 0);
               }
            } else {
               class52.field1171 = class150.method3164(class108.field1909, "sl_button", "");
            }
         }

         try {
            Graphics var22 = class89.field1567.getGraphics();
            class12.field196.vmethod1939(var22, 0, 0);
         } catch (Exception var23) {
            class89.field1567.repaint();
         }

      }
   }
}
