import java.util.HashMap;
import java.util.Map;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("p")
public class class11 {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1118211269
   )
   static int field172 = 0;
   @ObfuscatedName("g")
   static final class200 field174 = new class200();
   @ObfuscatedName("t")
   @Export("chatLineMap")
   static final Map field175 = new HashMap();
   @ObfuscatedName("gc")
   static class173 field177;
   @ObfuscatedName("i")
   static final class198 field180 = new class198(1024);

   @ObfuscatedName("du")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-2097679765"
   )
   static final void method124(String var0) {
      if(null != var0) {
         if((client.field418 < 200 || client.field451 == 1) && client.field418 < 400) {
            String var1 = class36.method723(var0, class96.field1641);
            if(null != var1) {
               int var2;
               String var4;
               String var5;
               for(var2 = 0; var2 < client.field418; ++var2) {
                  class17 var3 = client.field551[var2];
                  var4 = class36.method723(var3.field239, class96.field1641);
                  if(null != var4 && var4.equals(var1)) {
                     class33.method702(30, "", var0 + " is already on your friend list");
                     return;
                  }

                  if(null != var3.field238) {
                     var5 = class36.method723(var3.field238, class96.field1641);
                     if(null != var5 && var5.equals(var1)) {
                        class33.method702(30, "", var0 + " is already on your friend list");
                        return;
                     }
                  }
               }

               for(var2 = 0; var2 < client.field553; ++var2) {
                  class7 var6 = client.field400[var2];
                  var4 = class36.method723(var6.field135, class96.field1641);
                  if(null != var4 && var4.equals(var1)) {
                     class33.method702(30, "", "Please remove " + var0 + " from your ignore list first");
                     return;
                  }

                  if(var6.field134 != null) {
                     var5 = class36.method723(var6.field134, class96.field1641);
                     if(null != var5 && var5.equals(var1)) {
                        class33.method702(30, "", "Please remove " + var0 + " from your ignore list first");
                        return;
                     }
                  }
               }

               if(class36.method723(class152.field2301.field39, class96.field1641).equals(var1)) {
                  class33.method702(30, "", "You can\'t add yourself to your own friend list");
               } else {
                  client.field325.method2733(94);
                  client.field325.method2453(class102.method2237(var0));
                  client.field325.method2586(var0);
               }
            }
         } else {
            class33.method702(30, "", "Your friend list is full. Max of 200 for free users, and 400 for members");
         }
      }
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(Lclass33;B)V",
      garbageValue = "0"
   )
   static final void method125(class33 var0) {
      if(client.field545 == class152.field2301.field809 >> 7 && client.field517 == class152.field2301.field804 >> 7) {
         client.field545 = 0;
      }

      int var1 = class32.field741;
      int[] var2 = class32.field742;
      int var3 = var1;
      if(var0 == class33.field766 || class33.field758 == var0) {
         var3 = 1;
      }

      for(int var4 = 0; var4 < var3; ++var4) {
         class2 var5;
         int var6;
         if(class33.field766 == var0) {
            var5 = class152.field2301;
            var6 = class152.field2301.field58 << 14;
         } else if(class33.field758 == var0) {
            var5 = client.field405[client.field484];
            var6 = client.field484 << 14;
         } else {
            var5 = client.field405[var2[var4]];
            var6 = var2[var4] << 14;
            if(class33.field760 == var0 && var2[var4] == client.field484) {
               continue;
            }
         }

         if(null != var5 && var5.vmethod735() && !var5.field56) {
            var5.field51 = false;
            if((client.field287 && var1 > 50 || var1 > 200) && var0 != class33.field766 && var5.field827 == var5.field808) {
               var5.field51 = true;
            }

            int var7 = var5.field809 >> 7;
            int var8 = var5.field804 >> 7;
            if(var7 >= 0 && var7 < 104 && var8 >= 0 && var8 < 104) {
               if(null != var5.field35 && client.field332 >= var5.field53 && client.field332 < var5.field45) {
                  var5.field51 = false;
                  var5.field43 = class14.method147(var5.field809, var5.field804, class32.field754);
                  class214.field3161.method1978(class32.field754, var5.field809, var5.field804, var5.field43, 60, var5, var5.field805, var6, var5.field60, var5.field49, var5.field36, var5.field50);
               } else {
                  if((var5.field809 & 127) == 64 && (var5.field804 & 127) == 64) {
                     if(client.field387[var7][var8] == client.field388) {
                        continue;
                     }

                     client.field387[var7][var8] = client.field388;
                  }

                  var5.field43 = class14.method147(var5.field809, var5.field804, class32.field754);
                  class214.field3161.method1903(class32.field754, var5.field809, var5.field804, var5.field43, 60, var5, var5.field805, var6, var5.field806);
               }
            }
         }
      }

   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(Lclass37;I)V",
      garbageValue = "-357288133"
   )
   static final void method127(class37 var0) {
      var0.field806 = false;
      class42 var1;
      if(var0.field827 != -1) {
         var1 = class18.method177(var0.field827);
         if(null != var1 && var1.field985 != null) {
            ++var0.field833;
            if(var0.field832 < var1.field985.length && var0.field833 > var1.field987[var0.field832]) {
               var0.field833 = 1;
               ++var0.field832;
               class110.method2386(var1, var0.field832, var0.field809, var0.field804);
            }

            if(var0.field832 >= var1.field985.length) {
               var0.field833 = 0;
               var0.field832 = 0;
               class110.method2386(var1, var0.field832, var0.field809, var0.field804);
            }
         } else {
            var0.field827 = -1;
         }
      }

      if(var0.field836 != -1 && client.field332 >= var0.field843) {
         if(var0.field840 < 0) {
            var0.field840 = 0;
         }

         int var3 = class16.method162(var0.field836).field1014;
         if(var3 != -1) {
            class42 var2 = class18.method177(var3);
            if(null != var2 && null != var2.field985) {
               ++var0.field841;
               if(var0.field840 < var2.field985.length && var0.field841 > var2.field987[var0.field840]) {
                  var0.field841 = 1;
                  ++var0.field840;
                  class110.method2386(var2, var0.field840, var0.field809, var0.field804);
               }

               if(var0.field840 >= var2.field985.length && (var0.field840 < 0 || var0.field840 >= var2.field985.length)) {
                  var0.field836 = -1;
               }
            } else {
               var0.field836 = -1;
            }
         } else {
            var0.field836 = -1;
         }
      }

      if(var0.field834 != -1 && var0.field824 <= 1) {
         var1 = class18.method177(var0.field834);
         if(var1.field989 == 1 && var0.field861 > 0 && var0.field848 <= client.field332 && var0.field849 < client.field332) {
            var0.field824 = 1;
            return;
         }
      }

      if(var0.field834 != -1 && var0.field824 == 0) {
         var1 = class18.method177(var0.field834);
         if(var1 != null && var1.field985 != null) {
            ++var0.field818;
            if(var0.field819 < var1.field985.length && var0.field818 > var1.field987[var0.field819]) {
               var0.field818 = 1;
               ++var0.field819;
               class110.method2386(var1, var0.field819, var0.field809, var0.field804);
            }

            if(var0.field819 >= var1.field985.length) {
               var0.field819 -= var1.field981;
               ++var0.field838;
               if(var0.field838 >= var1.field995) {
                  var0.field834 = -1;
               } else if(var0.field819 >= 0 && var0.field819 < var1.field985.length) {
                  class110.method2386(var1, var0.field819, var0.field809, var0.field804);
               } else {
                  var0.field834 = -1;
               }
            }

            var0.field806 = var1.field991;
         } else {
            var0.field834 = -1;
         }
      }

      if(var0.field824 > 0) {
         --var0.field824;
      }

   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(Lclass37;IIIIIS)V",
      garbageValue = "-5141"
   )
   static final void method128(class37 var0, int var1, int var2, int var3, int var4, int var5) {
      if(var0 != null && var0.vmethod735()) {
         if(var0 instanceof class34) {
            class39 var6 = ((class34)var0).field772;
            if(null != var6.field907) {
               var6 = var6.method752();
            }

            if(null == var6) {
               return;
            }
         }

         int var12 = class32.field741;
         int[] var7 = class32.field742;
         int var8;
         int var10;
         int var13;
         if(var1 < var12) {
            var8 = 30;
            class2 var9 = (class2)var0;
            if(var9.field56) {
               return;
            }

            if(var9.field37 != -1 || var9.field38 != -1) {
               var10 = 15 + var0.field852;
               class31.method677(var0.field809, var0.field804, var10);
               if(client.field389 > -1) {
                  if(var9.field37 != -1) {
                     class14.field214[var9.field37].method1667(var2 + client.field389 - 12, var3 + client.field365 - var8);
                     var8 += 25;
                  }

                  if(var9.field38 != -1) {
                     class10.field171[var9.field38].method1667(var2 + client.field389 - 12, var3 + client.field365 - var8);
                     var8 += 25;
                  }
               }
            }

            if(var1 >= 0 && client.field301 == 10 && client.field506 == var7[var1]) {
               var10 = var0.field852 + 15;
               class31.method677(var0.field809, var0.field804, var10);
               if(client.field389 > -1) {
                  class149.field2266[1].method1667(var2 + client.field389 - 12, client.field365 + var3 - var8);
               }
            }
         } else {
            class39 var11 = ((class34)var0).field772;
            if(null != var11.field907) {
               var11 = var11.method752();
            }

            if(var11.field891 >= 0 && var11.field891 < class10.field171.length) {
               var13 = 15 + var0.field852;
               class31.method677(var0.field809, var0.field804, var13);
               if(client.field389 > -1) {
                  class10.field171[var11.field891].method1667(var2 + client.field389 - 12, var3 + client.field365 - 30);
               }
            }

            if(client.field301 == 1 && client.field322[var1 - var12] == client.field406 && client.field332 % 20 < 10) {
               var13 = 15 + var0.field852;
               class31.method677(var0.field809, var0.field804, var13);
               if(client.field389 > -1) {
                  class149.field2266[0].method1667(client.field389 + var2 - 12, client.field365 + var3 - 28);
               }
            }
         }

         if(null != var0.field816 && (var1 >= var12 || !var0.field835 && (client.field500 == 4 || !var0.field817 && (client.field500 == 0 || client.field500 == 3 || client.field500 == 1 && class47.method962(((class2)var0).field39, false))))) {
            var8 = var0.field852;
            class31.method677(var0.field809, var0.field804, var8);
            if(client.field389 > -1 && client.field377 < client.field378) {
               client.field430[client.field377] = class4.field79.method3963(var0.field816) / 2;
               client.field381[client.field377] = class4.field79.field3193;
               client.field554[client.field377] = client.field389;
               client.field380[client.field377] = client.field365;
               client.field550[client.field377] = var0.field820;
               client.field368[client.field377] = var0.field821;
               client.field385[client.field377] = var0.field842;
               client.field447[client.field377] = var0.field816;
               ++client.field377;
            }
         }

         if(var0.field858 > client.field332) {
            var8 = 15 + var0.field852;
            class31.method677(var0.field809, var0.field804, var8);
            if(client.field389 > -1) {
               if(var1 < var12) {
                  var13 = 30;
               } else {
                  class39 var14 = ((class34)var0).field772;
                  var13 = var14.field913;
               }

               var10 = var13 * var0.field826 / var0.field844;
               if(var10 > var13) {
                  var10 = var13;
               } else if(var10 == 0 && var0.field826 > 0) {
                  var10 = 1;
               }

               class79.method1785(var2 + client.field389 - var13 / 2, client.field365 + var3 - 3, var10, 5, '\uff00');
               class79.method1785(var10 + (client.field389 + var2 - var13 / 2), var3 + client.field365 - 3, var13 - var10, 5, 16711680);
            }
         }

         for(var8 = 0; var8 < 4; ++var8) {
            if(var0.field853[var8] > client.field332) {
               var13 = var0.field852 / 2;
               class31.method677(var0.field809, var0.field804, var13);
               if(client.field389 > -1) {
                  if(var8 == 1) {
                     client.field365 -= 20;
                  }

                  if(var8 == 2) {
                     client.field389 -= 15;
                     client.field365 -= 10;
                  }

                  if(var8 == 3) {
                     client.field389 += 15;
                     client.field365 -= 10;
                  }

                  class24.field618[var0.field851[var8]].method1667(var2 + client.field389 - 12, var3 + client.field365 - 12);
                  class1.field26.method3970(Integer.toString(var0.field822[var8]), client.field389 + var2 - 1, client.field365 + var3 + 3, 16777215, 0);
               }
            }
         }

      }
   }

   @ObfuscatedName("cb")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;I)V",
      garbageValue = "245486774"
   )
   static void method129(int var0, int var1, int var2, int var3, String var4) {
      class173 var5 = class74.method1561(var1, var2);
      if(var5 != null) {
         if(null != var5.field2847) {
            class0 var6 = new class0();
            var6.field2 = var5;
            var6.field12 = var0;
            var6.field9 = var4;
            var6.field5 = var5.field2847;
            class171.method3363(var6);
         }

         boolean var10 = true;
         if(var5.field2780 > 0) {
            var10 = class101.method2234(var5);
         }

         if(var10) {
            int var8 = class138.method2906(var5);
            int var9 = var0 - 1;
            boolean var7 = (var8 >> var9 + 1 & 1) != 0;
            if(var7) {
               if(var0 == 1) {
                  client.field325.method2733(116);
                  client.field325.method2456(var1);
                  client.field325.method2454(var2);
                  client.field325.method2454(var3);
               }

               if(var0 == 2) {
                  client.field325.method2733(73);
                  client.field325.method2456(var1);
                  client.field325.method2454(var2);
                  client.field325.method2454(var3);
               }

               if(var0 == 3) {
                  client.field325.method2733(124);
                  client.field325.method2456(var1);
                  client.field325.method2454(var2);
                  client.field325.method2454(var3);
               }

               if(var0 == 4) {
                  client.field325.method2733(229);
                  client.field325.method2456(var1);
                  client.field325.method2454(var2);
                  client.field325.method2454(var3);
               }

               if(var0 == 5) {
                  client.field325.method2733(60);
                  client.field325.method2456(var1);
                  client.field325.method2454(var2);
                  client.field325.method2454(var3);
               }

               if(var0 == 6) {
                  client.field325.method2733(226);
                  client.field325.method2456(var1);
                  client.field325.method2454(var2);
                  client.field325.method2454(var3);
               }

               if(var0 == 7) {
                  client.field325.method2733(109);
                  client.field325.method2456(var1);
                  client.field325.method2454(var2);
                  client.field325.method2454(var3);
               }

               if(var0 == 8) {
                  client.field325.method2733(250);
                  client.field325.method2456(var1);
                  client.field325.method2454(var2);
                  client.field325.method2454(var3);
               }

               if(var0 == 9) {
                  client.field325.method2733(103);
                  client.field325.method2456(var1);
                  client.field325.method2454(var2);
                  client.field325.method2454(var3);
               }

               if(var0 == 10) {
                  client.field325.method2733(240);
                  client.field325.method2456(var1);
                  client.field325.method2454(var2);
                  client.field325.method2454(var3);
               }

            }
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIILclass107;Lclass108;B)Z",
      garbageValue = "-15"
   )
   static final boolean method130(int var0, int var1, int var2, class107 var3, class108 var4) {
      int var5 = var0;
      int var6 = var1;
      byte var7 = 64;
      byte var8 = 64;
      int var9 = var0 - var7;
      int var10 = var1 - var8;
      class106.field1873[var7][var8] = 99;
      class106.field1877[var7][var8] = 0;
      byte var11 = 0;
      int var12 = 0;
      class106.field1881[var11] = var0;
      int var20 = var11 + 1;
      class106.field1876[var11] = var1;
      int[][] var13 = var4.field1906;

      while(true) {
         label359:
         while(true) {
            int var14;
            int var15;
            int var16;
            int var17;
            int var18;
            int var19;
            do {
               do {
                  do {
                     label336:
                     do {
                        if(var12 == var20) {
                           class10.field163 = var5;
                           class106.field1875 = var6;
                           return false;
                        }

                        var5 = class106.field1881[var12];
                        var6 = class106.field1876[var12];
                        var12 = 1 + var12 & 4095;
                        var18 = var5 - var9;
                        var19 = var6 - var10;
                        var14 = var5 - var4.field1907;
                        var15 = var6 - var4.field1903;
                        if(var3.vmethod2345(var2, var5, var6, var4)) {
                           class10.field163 = var5;
                           class106.field1875 = var6;
                           return true;
                        }

                        var16 = class106.field1877[var18][var19] + 1;
                        if(var18 > 0 && class106.field1873[var18 - 1][var19] == 0 && (var13[var14 - 1][var15] & 19136782) == 0 && (var13[var14 - 1][var15 + var2 - 1] & 19136824) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class106.field1881[var20] = var5 - 1;
                                 class106.field1876[var20] = var6;
                                 var20 = 1 + var20 & 4095;
                                 class106.field1873[var18 - 1][var19] = 2;
                                 class106.field1877[var18 - 1][var19] = var16;
                                 break;
                              }

                              if((var13[var14 - 1][var17 + var15] & 19136830) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 < 128 - var2 && class106.field1873[var18 + 1][var19] == 0 && (var13[var2 + var14][var15] & 19136899) == 0 && (var13[var2 + var14][var2 + var15 - 1] & 19136992) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class106.field1881[var20] = 1 + var5;
                                 class106.field1876[var20] = var6;
                                 var20 = var20 + 1 & 4095;
                                 class106.field1873[1 + var18][var19] = 8;
                                 class106.field1877[var18 + 1][var19] = var16;
                                 break;
                              }

                              if((var13[var14 + var2][var17 + var15] & 19136995) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var19 > 0 && class106.field1873[var18][var19 - 1] == 0 && (var13[var14][var15 - 1] & 19136782) == 0 && (var13[var14 + var2 - 1][var15 - 1] & 19136899) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class106.field1881[var20] = var5;
                                 class106.field1876[var20] = var6 - 1;
                                 var20 = 1 + var20 & 4095;
                                 class106.field1873[var18][var19 - 1] = 1;
                                 class106.field1877[var18][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var17 + var14][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var19 < 128 - var2 && class106.field1873[var18][1 + var19] == 0 && (var13[var14][var2 + var15] & 19136824) == 0 && (var13[var14 + var2 - 1][var15 + var2] & 19136992) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class106.field1881[var20] = var5;
                                 class106.field1876[var20] = 1 + var6;
                                 var20 = 1 + var20 & 4095;
                                 class106.field1873[var18][var19 + 1] = 4;
                                 class106.field1877[var18][var19 + 1] = var16;
                                 break;
                              }

                              if((var13[var14 + var17][var15 + var2] & 19137016) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 > 0 && var19 > 0 && class106.field1873[var18 - 1][var19 - 1] == 0 && (var13[var14 - 1][var15 - 1] & 19136782) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2) {
                                 class106.field1881[var20] = var5 - 1;
                                 class106.field1876[var20] = var6 - 1;
                                 var20 = 1 + var20 & 4095;
                                 class106.field1873[var18 - 1][var19 - 1] = 3;
                                 class106.field1877[var18 - 1][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var14 - 1][var15 - 1 + var17] & 19136830) != 0 || (var13[var17 + (var14 - 1)][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 < 128 - var2 && var19 > 0 && class106.field1873[1 + var18][var19 - 1] == 0 && (var13[var14 + var2][var15 - 1] & 19136899) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2) {
                                 class106.field1881[var20] = var5 + 1;
                                 class106.field1876[var20] = var6 - 1;
                                 var20 = 1 + var20 & 4095;
                                 class106.field1873[var18 + 1][var19 - 1] = 9;
                                 class106.field1877[1 + var18][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var2 + var14][var15 - 1 + var17] & 19136995) != 0 || (var13[var14 + var17][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 > 0 && var19 < 128 - var2 && class106.field1873[var18 - 1][1 + var19] == 0 && (var13[var14 - 1][var2 + var15] & 19136824) == 0) {
                           for(var17 = 1; var17 < var2; ++var17) {
                              if((var13[var14 - 1][var15 + var17] & 19136830) != 0 || (var13[var17 + (var14 - 1)][var2 + var15] & 19137016) != 0) {
                                 continue label336;
                              }
                           }

                           class106.field1881[var20] = var5 - 1;
                           class106.field1876[var20] = 1 + var6;
                           var20 = var20 + 1 & 4095;
                           class106.field1873[var18 - 1][1 + var19] = 6;
                           class106.field1877[var18 - 1][var19 + 1] = var16;
                        }
                     } while(var18 >= 128 - var2);
                  } while(var19 >= 128 - var2);
               } while(class106.field1873[var18 + 1][var19 + 1] != 0);
            } while((var13[var14 + var2][var2 + var15] & 19136992) != 0);

            for(var17 = 1; var17 < var2; ++var17) {
               if((var13[var17 + var14][var2 + var15] & 19137016) != 0 || (var13[var2 + var14][var17 + var15] & 19136995) != 0) {
                  continue label359;
               }
            }

            class106.field1881[var20] = 1 + var5;
            class106.field1876[var20] = 1 + var6;
            var20 = var20 + 1 & 4095;
            class106.field1873[1 + var18][var19 + 1] = 12;
            class106.field1877[var18 + 1][1 + var19] = var16;
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "-2091782353"
   )
   static final int method131(int var0, int var1, int var2) {
      int var3 = 256 - var2;
      return (var3 * (var0 & 16711935) + var2 * (var1 & 16711935) & -16711936) + (var2 * (var1 & '\uff00') + (var0 & '\uff00') * var3 & 16711680) >> 8;
   }
}
