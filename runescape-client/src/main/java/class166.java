import java.io.IOException;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fa")
public final class class166 {
   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-2060996572"
   )
   static final boolean method3350() {
      if(null == class40.field904) {
         return false;
      } else {
         int var2;
         String var18;
         try {
            int var0 = class40.field904.method3141();
            if(var0 == 0) {
               return false;
            }

            if(client.field341 == -1) {
               class40.field904.method3132(client.field339.field2051, 0, 1);
               client.field339.field2050 = 0;
               client.field341 = client.field339.method2898();
               client.field340 = class191.field3098[client.field341];
               --var0;
            }

            if(client.field340 == -1) {
               if(var0 <= 0) {
                  return false;
               }

               class40.field904.method3132(client.field339.field2051, 0, 1);
               client.field340 = client.field339.field2051[0] & 255;
               --var0;
            }

            if(client.field340 == -2) {
               if(var0 <= 1) {
                  return false;
               }

               class40.field904.method3132(client.field339.field2051, 0, 2);
               client.field339.field2050 = 0;
               client.field340 = client.field339.method2635();
               var0 -= 2;
            }

            if(var0 < client.field340) {
               return false;
            }

            client.field339.field2050 = 0;
            class40.field904.method3132(client.field339.field2051, 0, client.field340);
            client.field378 = 0;
            client.field311 = client.field345;
            client.field345 = client.field344 * -1;
            client.field344 = client.field341 * -1;
            int var1;
            if(client.field341 == 192) {
               class46.field1064 = client.field339.method2837();
               class4.field72 = client.field339.method2837();

               for(var1 = class4.field72; var1 < 8 + class4.field72; ++var1) {
                  for(var2 = class46.field1064; var2 < 8 + class46.field1064; ++var2) {
                     if(null != client.field426[class99.field1701][var1][var2]) {
                        client.field426[class99.field1701][var1][var2] = null;
                        class144.method3120(var1, var2);
                     }
                  }
               }

               for(class16 var73 = (class16)client.field427.method3980(); null != var73; var73 = (class16)client.field427.method3970()) {
                  if(var73.field238 >= class4.field72 && var73.field238 < class4.field72 + 8 && var73.field231 >= class46.field1064 && var73.field231 < 8 + class46.field1064 && class99.field1701 == var73.field239) {
                     var73.field237 = 0;
                  }
               }

               client.field341 = -1;
               return true;
            }

            if(client.field341 == 141) {
               client.field312 = client.field339.method2749() * 30;
               client.field490 = client.field478;
               client.field341 = -1;
               return true;
            }

            int var39;
            class176 var68;
            if(client.field341 == 71) {
               var1 = client.field339.method2678();
               var68 = class134.method2983(var1);

               for(var39 = 0; var39 < var68.field2905.length; ++var39) {
                  var68.field2905[var39] = -1;
                  var68.field2905[var39] = 0;
               }

               class79.method1777(var68);
               client.field341 = -1;
               return true;
            }

            int var4;
            class176 var42;
            if(client.field341 == 128) {
               var1 = client.field339.method2803();
               var2 = client.field339.method2803();
               var39 = client.field339.method2680();
               var4 = client.field339.method2803();
               var42 = class134.method2983(var39);
               if(var42.field2927 != var2 || var1 != var42.field2859 || var4 != var42.field2933) {
                  var42.field2927 = var2;
                  var42.field2859 = var1;
                  var42.field2933 = var4;
                  class79.method1777(var42);
               }

               client.field341 = -1;
               return true;
            }

            String var62;
            if(client.field341 == 52) {
               var1 = client.field339.method2837();
               var62 = client.field339.method2663();
               var39 = client.field339.method2662();
               if(var1 >= 1 && var1 <= 8) {
                  if(var62.equalsIgnoreCase("null")) {
                     var62 = null;
                  }

                  client.field422[var1 - 1] = var62;
                  client.field423[var1 - 1] = var39 == 0;
               }

               client.field341 = -1;
               return true;
            }

            if(client.field341 == 119) {
               client.field562 = 1;
               client.field385 = client.field478;
               client.field341 = -1;
               return true;
            }

            if(client.field341 == 105 || client.field341 == 15 || client.field341 == 38 || client.field341 == 205 || client.field341 == 199 || client.field341 == 249 || client.field341 == 152 || client.field341 == 24 || client.field341 == 33 || client.field341 == 19) {
               class6.method104();
               client.field341 = -1;
               return true;
            }

            if(client.field341 == 59) {
               class9.method125();
               var1 = client.field339.method2620();
               var2 = client.field339.method2662();
               var39 = client.field339.method2837();
               client.field432[var2] = var1;
               client.field430[var2] = var39;
               client.field431[var2] = 1;

               for(var4 = 0; var4 < 98; ++var4) {
                  if(var1 >= class158.field2358[var4]) {
                     client.field431[var2] = var4 + 2;
                  }
               }

               client.field483[++client.field328 - 1 & 31] = var2;
               client.field341 = -1;
               return true;
            }

            class176 var67;
            if(client.field341 == 64) {
               var1 = client.field339.method2674();
               var2 = client.field339.method2680();
               var39 = client.field339.method2636();
               var67 = class134.method2983(var2);
               if(var39 != var67.field2816 || var67.field2941 != var1 || var67.field2812 != 0 || var67.field2925 != 0) {
                  var67.field2816 = var39;
                  var67.field2941 = var1;
                  var67.field2812 = 0;
                  var67.field2925 = 0;
                  class79.method1777(var67);
                  class8.method117(var67);
                  if(var67.field2910 == 0) {
                     class53.method1145(class176.field2836[var2 >> 16], var67, false);
                  }
               }

               client.field341 = -1;
               return true;
            }

            if(client.field341 == 121) {
               client.field542 = true;
               class3.field63 = client.field339.method2633();
               class102.field1756 = client.field339.method2633();
               class77.field1443 = client.field339.method2635();
               class165.field2706 = client.field339.method2633();
               class152.field2303 = client.field339.method2633();
               if(class152.field2303 >= 100) {
                  class151.field2282 = class3.field63 * 128 + 64;
                  class96.field1670 = 64 + class102.field1756 * 128;
                  class8.field149 = class127.method2936(class151.field2282, class96.field1670, class99.field1701) - class77.field1443;
               }

               client.field341 = -1;
               return true;
            }

            if(client.field341 == 227) {
               method3366(true);
               client.field341 = -1;
               return true;
            }

            int var7;
            Object var10000;
            int var22;
            int var47;
            class176 var70;
            if(client.field341 == 130) {
               var1 = client.field339.method2620();
               var2 = client.field339.method2635();
               if(var1 < -70000) {
                  var2 += '耀';
               }

               if(var1 >= 0) {
                  var70 = class134.method2983(var1);
               } else {
                  var70 = null;
               }

               var10000 = null;
               class134.method2977(var2);
               var4 = client.field339.method2635();

               for(var22 = 0; var22 < var4; ++var22) {
                  var47 = client.field339.method2635();
                  var7 = client.field339.method2633();
                  if(var7 == 255) {
                     var7 = client.field339.method2620();
                  }

                  if(var70 != null && var22 < var70.field2905.length) {
                     var70.field2905[var22] = var47;
                     var70.field2926[var22] = var7;
                  }

                  class34.method754(var2, var22, var47 - 1, var7);
               }

               if(var70 != null) {
                  class79.method1777(var70);
               }

               class9.method125();
               client.field481[++client.field482 - 1 & 31] = var2 & 32767;
               client.field341 = -1;
               return true;
            }

            if(client.field341 == 43) {
               var1 = client.field339.method2620();
               var68 = class134.method2983(var1);
               var68.field2800 = 3;
               var68.field2851 = class3.field65.field31.method3642();
               class79.method1777(var68);
               client.field341 = -1;
               return true;
            }

            int var54;
            long var58;
            class3 var69;
            if(client.field341 == 44) {
               var1 = client.field339.field2050 + client.field340;
               var2 = client.field339.method2635();
               var39 = client.field339.method2635();
               if(client.field495 != var2) {
                  client.field495 = var2;
                  var4 = client.field495;
                  var22 = class189.field3056;
                  var47 = class39.field892;
                  if(class14.method179(var4)) {
                     class0.method2(class176.field2836[var4], -1, var22, var47, false);
                  }

                  class3.method43(client.field495);
                  class102.method2291(client.field495);

                  for(var4 = 0; var4 < 100; ++var4) {
                     client.field498[var4] = true;
                  }
               }

               class3 var80;
               for(; var39-- > 0; var80.field61 = true) {
                  var4 = client.field339.method2620();
                  var22 = client.field339.method2635();
                  var47 = client.field339.method2633();
                  var80 = (class3)client.field475.method3936((long)var4);
                  if(null != var80 && var80.field70 != var22) {
                     class145.method3130(var80, true);
                     var80 = null;
                  }

                  if(null == var80) {
                     var80 = class3.method42(var4, var22, var47);
                  }
               }

               for(var69 = (class3)client.field475.method3939(); null != var69; var69 = (class3)client.field475.method3935()) {
                  if(var69.field61) {
                     var69.field61 = false;
                  } else {
                     class145.method3130(var69, true);
                  }
               }

               client.field435 = new class199(512);

               while(client.field339.field2050 < var1) {
                  var4 = client.field339.method2620();
                  var22 = client.field339.method2635();
                  var47 = client.field339.method2635();
                  var7 = client.field339.method2620();

                  for(var54 = var22; var54 <= var47; ++var54) {
                     var58 = (long)var54 + ((long)var4 << 32);
                     client.field435.method3940(new class204(var7), var58);
                  }
               }

               client.field341 = -1;
               return true;
            }

            if(client.field341 == 138) {
               class9.method125();
               client.field458 = client.field339.method2633();
               client.field490 = client.field478;
               client.field341 = -1;
               return true;
            }

            if(client.field341 == 80) {
               class176.method3561(client.field339, client.field340);
               client.field341 = -1;
               return true;
            }

            if(client.field341 == 161) {
               var1 = client.field339.method2635();
               var2 = client.field339.method2633();
               var39 = client.field339.method2635();
               if(client.field403 != 0 && var2 != 0 && client.field536 < 50) {
                  client.field319[client.field536] = var1;
                  client.field538[client.field536] = var2;
                  client.field539[client.field536] = var39;
                  client.field541[client.field536] = null;
                  client.field528[client.field536] = 0;
                  ++client.field536;
               }

               client.field341 = -1;
               return true;
            }

            if(client.field341 == 158) {
               client.field313 = client.field339.method2633();
               if(client.field313 == 1) {
                  client.field314 = client.field339.method2635();
               }

               if(client.field313 >= 2 && client.field313 <= 6) {
                  if(client.field313 == 2) {
                     client.field375 = 64;
                     client.field384 = 64;
                  }

                  if(client.field313 == 3) {
                     client.field375 = 0;
                     client.field384 = 64;
                  }

                  if(client.field313 == 4) {
                     client.field375 = 128;
                     client.field384 = 64;
                  }

                  if(client.field313 == 5) {
                     client.field375 = 64;
                     client.field384 = 0;
                  }

                  if(client.field313 == 6) {
                     client.field375 = 64;
                     client.field384 = 128;
                  }

                  client.field313 = 2;
                  client.field316 = client.field339.method2635();
                  client.field317 = client.field339.method2635();
                  client.field517 = client.field339.method2633();
               }

               if(client.field313 == 10) {
                  client.field315 = client.field339.method2635();
               }

               client.field341 = -1;
               return true;
            }

            if(client.field341 == 6) {
               var18 = client.field339.method2663();
               var2 = client.field339.method2680();
               var70 = class134.method2983(var2);
               if(!var18.equals(var70.field2867)) {
                  var70.field2867 = var18;
                  class79.method1777(var70);
               }

               client.field341 = -1;
               return true;
            }

            if(client.field341 == 34) {
               class2.method33(false);
               client.field339.method2898();
               var1 = client.field339.method2635();
               class176.method3561(client.field339, var1);
               client.field341 = -1;
               return true;
            }

            if(client.field341 == 104) {
               client.field542 = false;

               for(var1 = 0; var1 < 5; ++var1) {
                  client.field331[var1] = false;
               }

               client.field341 = -1;
               return true;
            }

            Iterator var21;
            boolean var43;
            String var71;
            String var75;
            if(client.field341 == 222) {
               for(; client.field339.field2050 < client.field340; var10000 = null) {
                  var1 = client.field339.method2633();
                  var43 = (var1 & 1) == 1;
                  var75 = client.field339.method2663();
                  var71 = client.field339.method2663();
                  client.field339.method2663();

                  for(var22 = 0; var22 < client.field565; ++var22) {
                     class7 var87 = client.field566[var22];
                     if(var43) {
                        if(var71.equals(var87.field132)) {
                           var87.field132 = var75;
                           var87.field131 = var71;
                           var21 = null;
                           break;
                        }
                     } else if(var75.equals(var87.field132)) {
                        var87.field132 = var75;
                        var87.field131 = var71;
                        var21 = null;
                        break;
                     }
                  }
               }

               client.field385 = client.field478;
               client.field341 = -1;
               return true;
            }

            if(client.field341 == 183) {
               var18 = client.field339.method2663();
               Object[] var66 = new Object[var18.length() + 1];

               for(var39 = var18.length() - 1; var39 >= 0; --var39) {
                  if(var18.charAt(var39) == 115) {
                     var66[1 + var39] = client.field339.method2663();
                  } else {
                     var66[1 + var39] = new Integer(client.field339.method2620());
                  }
               }

               var66[0] = new Integer(client.field339.method2620());
               class0 var88 = new class0();
               var88.field8 = var66;
               class16.method203(var88);
               client.field341 = -1;
               return true;
            }

            if(client.field341 == 39) {
               method3366(false);
               client.field341 = -1;
               return true;
            }

            if(client.field341 == 77) {
               var1 = client.field339.method2670();
               class7.method111(var1);
               client.field481[++client.field482 - 1 & 31] = var1 & 32767;
               client.field341 = -1;
               return true;
            }

            if(client.field341 == 174) {
               var1 = client.field339.method2620();
               var2 = client.field339.method2635();
               var70 = class134.method2983(var1);
               if(null != var70 && var70.field2910 == 0) {
                  if(var2 > var70.field2831 - var70.field2823) {
                     var2 = var70.field2831 - var70.field2823;
                  }

                  if(var2 < 0) {
                     var2 = 0;
                  }

                  if(var2 != var70.field2850) {
                     var70.field2850 = var2;
                     class79.method1777(var70);
                  }
               }

               client.field341 = -1;
               return true;
            }

            boolean var57;
            if(client.field341 == 241) {
               var57 = client.field339.method2633() == 1;
               if(var57) {
                  class27.field677 = class56.method1249() - client.field339.method2649();
                  class162.field2659 = new class224(client.field339, true);
               } else {
                  class162.field2659 = null;
               }

               client.field416 = client.field478;
               client.field341 = -1;
               return true;
            }

            if(client.field341 == 118) {
               if(client.field495 != -1) {
                  var1 = client.field495;
                  if(class14.method179(var1)) {
                     class9.method134(class176.field2836[var1], 0);
                  }
               }

               client.field341 = -1;
               return true;
            }

            boolean var44;
            if(client.field341 == 17) {
               var1 = client.field339.method2646();
               var43 = client.field339.method2633() == 1;
               var75 = "";
               var44 = false;
               if(var43) {
                  var75 = client.field339.method2663();
                  if(class107.method2395(var75)) {
                     var44 = true;
                  }
               }

               String var48 = client.field339.method2663();
               if(!var44) {
                  class78.method1721(var1, var75, var48);
               }

               client.field341 = -1;
               return true;
            }

            if(client.field341 == 31) {
               var1 = client.field339.method2633();
               if(client.field339.method2633() == 0) {
                  client.field570[var1] = new class223();
                  client.field339.field2050 += 18;
               } else {
                  --client.field339.field2050;
                  client.field570[var1] = new class223(client.field339, false);
               }

               client.field488 = client.field478;
               client.field341 = -1;
               return true;
            }

            boolean var83;
            if(client.field341 == 123) {
               var18 = client.field339.method2663();
               var2 = client.field339.method2635();
               byte var51 = client.field339.method2634();
               var44 = false;
               if(var51 == -128) {
                  var44 = true;
               }

               if(var44) {
                  if(client.field522 == 0) {
                     client.field341 = -1;
                     return true;
                  }

                  var83 = false;

                  for(var22 = 0; var22 < client.field522 && (!class4.field74[var22].field645.equals(var18) || class4.field74[var22].field640 != var2); ++var22) {
                     ;
                  }

                  if(var22 < client.field522) {
                     while(var22 < client.field522 - 1) {
                        class4.field74[var22] = class4.field74[var22 + 1];
                        ++var22;
                     }

                     --client.field522;
                     class4.field74[client.field522] = null;
                  }
               } else {
                  client.field339.method2663();
                  class25 var46 = new class25();
                  var46.field645 = var18;
                  var46.field639 = class156.method3300(var46.field645, client.field518);
                  var46.field640 = var2;
                  var46.field641 = var51;

                  for(var47 = client.field522 - 1; var47 >= 0; --var47) {
                     var7 = class4.field74[var47].field639.compareTo(var46.field639);
                     if(var7 == 0) {
                        class4.field74[var47].field640 = var2;
                        class4.field74[var47].field641 = var51;
                        if(var18.equals(class3.field65.field58)) {
                           class30.field710 = var51;
                        }

                        client.field487 = client.field478;
                        client.field341 = -1;
                        return true;
                     }

                     if(var7 < 0) {
                        break;
                     }
                  }

                  if(client.field522 >= class4.field74.length) {
                     client.field341 = -1;
                     return true;
                  }

                  for(var7 = client.field522 - 1; var7 > var47; --var7) {
                     class4.field74[1 + var7] = class4.field74[var7];
                  }

                  if(client.field522 == 0) {
                     class4.field74 = new class25[100];
                  }

                  class4.field74[1 + var47] = var46;
                  ++client.field522;
                  if(var18.equals(class3.field65.field58)) {
                     class30.field710 = var51;
                  }
               }

               client.field487 = client.field478;
               client.field341 = -1;
               return true;
            }

            if(client.field341 == 48) {
               var1 = client.field339.method2620();
               var2 = client.field339.method2635();
               if(var1 < -70000) {
                  var2 += '耀';
               }

               if(var1 >= 0) {
                  var70 = class134.method2983(var1);
               } else {
                  var70 = null;
               }

               for(; client.field339.field2050 < client.field340; class34.method754(var2, var4, var22 - 1, var47)) {
                  var4 = client.field339.method2646();
                  var22 = client.field339.method2635();
                  var47 = 0;
                  if(var22 != 0) {
                     var47 = client.field339.method2633();
                     if(var47 == 255) {
                        var47 = client.field339.method2620();
                     }
                  }

                  if(var70 != null && var4 >= 0 && var4 < var70.field2905.length) {
                     var70.field2905[var4] = var22;
                     var70.field2926[var4] = var47;
                  }
               }

               if(var70 != null) {
                  class79.method1777(var70);
               }

               class9.method125();
               client.field481[++client.field482 - 1 & 31] = var2 & 32767;
               client.field341 = -1;
               return true;
            }

            if(client.field341 == 21) {
               class4.field72 = client.field339.method2837();
               class46.field1064 = client.field339.method2837();

               while(client.field339.field2050 < client.field340) {
                  client.field341 = client.field339.method2633();
                  class6.method104();
               }

               client.field341 = -1;
               return true;
            }

            if(client.field341 == 29) {
               var1 = client.field339.method2636();
               var2 = client.field339.method2620();
               var70 = class134.method2983(var2);
               if(var1 != var70.field2854 || var1 == -1) {
                  var70.field2854 = var1;
                  var70.field2929 = 0;
                  var70.field2930 = 0;
                  class79.method1777(var70);
               }

               client.field341 = -1;
               return true;
            }

            if(client.field341 == 86) {
               class129.method2964();
               client.field341 = -1;
               return false;
            }

            if(client.field341 == 76) {
               var1 = client.field339.method2749();
               var2 = client.field339.method2799();
               var70 = class134.method2983(var2);
               if(var70.field2800 != 2 || var70.field2851 != var1) {
                  var70.field2800 = 2;
                  var70.field2851 = var1;
                  class79.method1777(var70);
               }

               client.field341 = -1;
               return true;
            }

            if(client.field341 == 57) {
               var2 = client.field339.method2633();
               class133[] var76 = new class133[]{class133.field2110, class133.field2108, class133.field2107};
               class133[] var77 = var76;
               var22 = 0;

               class133 var64;
               while(true) {
                  if(var22 >= var77.length) {
                     var64 = null;
                     break;
                  }

                  class133 var85 = var77[var22];
                  if(var2 == var85.field2109) {
                     var64 = var85;
                     break;
                  }

                  ++var22;
               }

               class29.field706 = var64;
               client.field341 = -1;
               return true;
            }

            if(client.field341 == 106) {
               var1 = client.field339.method2635();
               client.field495 = var1;
               var2 = client.field495;
               var39 = class189.field3056;
               var4 = class39.field892;
               if(class14.method179(var2)) {
                  class0.method2(class176.field2836[var2], -1, var39, var4, false);
               }

               class3.method43(var1);
               class102.method2291(client.field495);

               for(var2 = 0; var2 < 100; ++var2) {
                  client.field498[var2] = true;
               }

               client.field341 = -1;
               return true;
            }

            if(client.field341 == 233) {
               class27 var63 = new class27();
               var63.field670 = client.field339.method2663();
               var63.field667 = client.field339.method2635();
               var2 = client.field339.method2620();
               var63.field668 = var2;
               class138.method3024(45);
               class40.field904.method3131();
               class40.field904 = null;
               class157.method3303(var63);
               client.field341 = -1;
               return false;
            }

            long var6;
            boolean var11;
            long var41;
            long var50;
            if(client.field341 == 14) {
               var18 = client.field339.method2663();
               var50 = client.field339.method2649();
               var41 = (long)client.field339.method2635();
               var6 = (long)client.field339.method2637();
               class155 var86 = (class155)class85.method1971(class128.method2954(), client.field339.method2633());
               var58 = var6 + (var41 << 32);
               var11 = false;

               for(int var12 = 0; var12 < 100; ++var12) {
                  if(client.field514[var12] == var58) {
                     var11 = true;
                     break;
                  }
               }

               if(var86.field2330 && class107.method2395(var18)) {
                  var11 = true;
               }

               if(!var11 && client.field564 == 0) {
                  client.field514[client.field515] = var58;
                  client.field515 = (client.field515 + 1) % 100;
                  class125 var13 = client.field339;

                  String var59;
                  try {
                     int var15 = var13.method2646();
                     if(var15 > 32767) {
                        var15 = 32767;
                     }

                     byte[] var16 = new byte[var15];
                     var13.field2050 += class225.field3227.method2558(var13.field2051, var13.field2050, var16, 0, var15);
                     String var17 = class36.method763(var16, 0, var15);
                     var59 = var17;
                  } catch (Exception var35) {
                     var59 = "Cabbage";
                  }

                  var59 = class226.method4169(class43.method906(var59));
                  if(var86.field2325 != -1) {
                     class6.method105(9, class25.method615(var86.field2325) + var18, var59, class33.method701(var50));
                  } else {
                     class6.method105(9, var18, var59, class33.method701(var50));
                  }
               }

               client.field341 = -1;
               return true;
            }

            if(client.field341 == 194) {
               var1 = client.field339.method2803();
               var2 = client.field339.method2620();
               var39 = var1 >> 10 & 31;
               var4 = var1 >> 5 & 31;
               var22 = var1 & 31;
               var47 = (var22 << 3) + (var4 << 11) + (var39 << 19);
               class176 var79 = class134.method2983(var2);
               if(var47 != var79.field2832) {
                  var79.field2832 = var47;
                  class79.method1777(var79);
               }

               client.field341 = -1;
               return true;
            }

            if(client.field341 == 25) {
               var1 = client.field339.method2620();
               class105.field1834 = class125.field2070.method3046(var1);
               client.field341 = -1;
               return true;
            }

            if(client.field341 == 155) {
               class141.method3076(client.field339.method2663());
               client.field341 = -1;
               return true;
            }

            class56 var19;
            if(client.field341 == 242) {
               while(client.field339.field2050 < client.field340) {
                  var57 = client.field339.method2633() == 1;
                  var62 = client.field339.method2663();
                  var75 = client.field339.method2663();
                  var4 = client.field339.method2635();
                  var22 = client.field339.method2633();
                  var47 = client.field339.method2633();
                  boolean var53 = (var47 & 2) != 0;
                  boolean var55 = (var47 & 1) != 0;
                  if(var4 > 0) {
                     client.field339.method2663();
                     client.field339.method2633();
                     client.field339.method2620();
                  }

                  client.field339.method2663();

                  for(int var56 = 0; var56 < client.field391; ++var56) {
                     class17 var10 = client.field456[var56];
                     if(!var57) {
                        if(var62.equals(var10.field250)) {
                           if(var4 != var10.field247) {
                              var11 = true;

                              for(class40 var89 = (class40)client.field351.method3928(); null != var89; var89 = (class40)client.field351.method3933()) {
                                 if(var89.field895.equals(var62)) {
                                    if(var4 != 0 && var89.field896 == 0) {
                                       var89.method4063();
                                       var11 = false;
                                    } else if(var4 == 0 && var89.field896 != 0) {
                                       var89.method4063();
                                       var11 = false;
                                    }
                                 }
                              }

                              if(var11) {
                                 client.field351.method3926(new class40(var62, var4));
                              }

                              var10.field247 = var4;
                           }

                           var10.field246 = var75;
                           var10.field248 = var22;
                           var10.field249 = var53;
                           var10.field252 = var55;
                           var19 = null;
                           break;
                        }
                     } else if(var75.equals(var10.field250)) {
                        var10.field250 = var62;
                        var10.field246 = var75;
                        var19 = null;
                        break;
                     }
                  }
               }

               client.field562 = 2;
               client.field385 = client.field478;
               var57 = false;
               var2 = client.field391;

               while(var2 > 0) {
                  var57 = true;
                  --var2;

                  for(var39 = 0; var39 < var2; ++var39) {
                     var44 = false;
                     class17 var45 = client.field456[var39];
                     class17 var84 = client.field456[var39 + 1];
                     if(var45.field247 != client.field407 && var84.field247 == client.field407) {
                        var44 = true;
                     }

                     if(!var44 && var45.field247 == 0 && var84.field247 != 0) {
                        var44 = true;
                     }

                     if(!var44 && !var45.field249 && var84.field249) {
                        var44 = true;
                     }

                     if(!var44 && !var45.field252 && var84.field252) {
                        var44 = true;
                     }

                     if(var44) {
                        class17 var78 = client.field456[var39];
                        client.field456[var39] = client.field456[1 + var39];
                        client.field456[var39 + 1] = var78;
                        var57 = false;
                     }
                  }

                  if(var57) {
                     break;
                  }
               }

               client.field341 = -1;
               return true;
            }

            if(client.field341 == 10) {
               var1 = client.field339.method2799();
               var2 = client.field339.method2799();
               class3 var74 = (class3)client.field475.method3936((long)var1);
               var69 = (class3)client.field475.method3936((long)var2);
               if(null != var69) {
                  class145.method3130(var69, null == var74 || var69.field70 != var74.field70);
               }

               if(null != var74) {
                  var74.method4067();
                  client.field475.method3940(var74, (long)var2);
               }

               var42 = class134.method2983(var1);
               if(null != var42) {
                  class79.method1777(var42);
               }

               var42 = class134.method2983(var2);
               if(var42 != null) {
                  class79.method1777(var42);
                  class53.method1145(class176.field2836[var42.field2807 >>> 16], var42, true);
               }

               if(client.field495 != -1) {
                  var47 = client.field495;
                  if(class14.method179(var47)) {
                     class9.method134(class176.field2836[var47], 1);
                  }
               }

               client.field341 = -1;
               return true;
            }

            if(client.field341 == 193) {
               var1 = client.field339.method2633();
               var2 = client.field339.method2633();
               var39 = client.field339.method2633();
               var4 = client.field339.method2633();
               client.field331[var1] = true;
               client.field544[var1] = var2;
               client.field393[var1] = var39;
               client.field546[var1] = var4;
               client.field547[var1] = 0;
               client.field341 = -1;
               return true;
            }

            if(client.field341 == 136) {
               var18 = client.field339.method2663();
               class125 var72 = client.field339;

               try {
                  var22 = var72.method2646();
                  if(var22 > 32767) {
                     var22 = 32767;
                  }

                  byte[] var82 = new byte[var22];
                  var72.field2050 += class225.field3227.method2558(var72.field2051, var72.field2050, var82, 0, var22);
                  String var23 = class36.method763(var82, 0, var22);
                  var71 = var23;
               } catch (Exception var34) {
                  var71 = "Cabbage";
               }

               var71 = class226.method4169(class43.method906(var71));
               class78.method1721(6, var18, var71);
               client.field341 = -1;
               return true;
            }

            if(client.field341 == 202) {
               var1 = client.field339.method2749();
               var2 = client.field339.method2678();
               var39 = client.field339.method2749();
               var67 = class134.method2983(var2);
               var67.field2863 = (var39 << 16) + var1;
               client.field341 = -1;
               return true;
            }

            if(client.field341 == 145) {
               class6.method97();

               for(var1 = 0; var1 < 2048; ++var1) {
                  client.field302[var1] = null;
               }

               class30.method685(client.field339);
               client.field341 = -1;
               return true;
            }

            if(client.field341 == 66) {
               for(var1 = 0; var1 < client.field302.length; ++var1) {
                  if(null != client.field302[var1]) {
                     client.field302[var1].field863 = -1;
                  }
               }

               for(var1 = 0; var1 < client.field332.length; ++var1) {
                  if(client.field332[var1] != null) {
                     client.field332[var1].field863 = -1;
                  }
               }

               client.field341 = -1;
               return true;
            }

            if(client.field341 == 98) {
               client.field530 = client.field339.method2633();
               client.field341 = -1;
               return true;
            }

            if(client.field341 == 3) {
               var18 = client.field339.method2663();
               var50 = (long)client.field339.method2635();
               var41 = (long)client.field339.method2637();
               class155 var81 = (class155)class85.method1971(class128.method2954(), client.field339.method2633());
               long var52 = var41 + (var50 << 32);
               boolean var9 = false;

               for(int var90 = 0; var90 < 100; ++var90) {
                  if(var52 == client.field514[var90]) {
                     var9 = true;
                     break;
                  }
               }

               if(class107.method2395(var18)) {
                  var9 = true;
               }

               if(!var9 && client.field564 == 0) {
                  client.field514[client.field515] = var52;
                  client.field515 = (client.field515 + 1) % 100;
                  class125 var29 = client.field339;

                  String var27;
                  try {
                     int var30 = var29.method2646();
                     if(var30 > 32767) {
                        var30 = 32767;
                     }

                     byte[] var14 = new byte[var30];
                     var29.field2050 += class225.field3227.method2558(var29.field2051, var29.field2050, var14, 0, var30);
                     String var26 = class36.method763(var14, 0, var30);
                     var27 = var26;
                  } catch (Exception var33) {
                     var27 = "Cabbage";
                  }

                  var27 = class226.method4169(class43.method906(var27));
                  byte var91;
                  if(var81.field2329) {
                     var91 = 7;
                  } else {
                     var91 = 3;
                  }

                  if(var81.field2325 != -1) {
                     class78.method1721(var91, class25.method615(var81.field2325) + var18, var27);
                  } else {
                     class78.method1721(var91, var18, var27);
                  }
               }

               client.field341 = -1;
               return true;
            }

            if(client.field341 == 162) {
               client.field371 = client.field339.method2633();
               if(client.field371 == 255) {
                  client.field371 = 0;
               }

               client.field529 = client.field339.method2633();
               if(client.field529 == 255) {
                  client.field529 = 0;
               }

               client.field341 = -1;
               return true;
            }

            if(client.field341 == 244) {
               var1 = client.field339.method2803();
               var2 = client.field339.method2799();
               var70 = class134.method2983(var2);
               if(var70.field2800 != 1 || var1 != var70.field2851) {
                  var70.field2800 = 1;
                  var70.field2851 = var1;
                  class79.method1777(var70);
               }

               client.field341 = -1;
               return true;
            }

            if(client.field341 == 143) {
               var1 = client.field339.method2670();
               byte var49 = client.field339.method2634();
               class179.field2957[var1] = var49;
               if(var49 != class179.field2958[var1]) {
                  class179.field2958[var1] = var49;
               }

               class213.method4080(var1);
               client.field479[++client.field366 - 1 & 31] = var1;
               client.field341 = -1;
               return true;
            }

            if(client.field341 == 28) {
               for(var1 = 0; var1 < class179.field2958.length; ++var1) {
                  if(class179.field2957[var1] != class179.field2958[var1]) {
                     class179.field2958[var1] = class179.field2957[var1];
                     class213.method4080(var1);
                     client.field479[++client.field366 - 1 & 31] = var1;
                  }
               }

               client.field341 = -1;
               return true;
            }

            if(client.field341 == 75) {
               var1 = client.field339.method2633();
               var2 = client.field339.method2678();
               var39 = client.field339.method2749();
               var69 = (class3)client.field475.method3936((long)var2);
               if(null != var69) {
                  class145.method3130(var69, var69.field70 != var39);
               }

               class3.method42(var2, var39, var1);
               client.field341 = -1;
               return true;
            }

            if(client.field341 == 211) {
               var1 = client.field339.method2678();
               var2 = client.field339.method2680();
               var39 = client.field339.method2803();
               if(var39 == '\uffff') {
                  var39 = -1;
               }

               var67 = class134.method2983(var2);
               class55 var5;
               if(!var67.field2855) {
                  if(var39 == -1) {
                     var67.field2800 = 0;
                     client.field341 = -1;
                     return true;
                  }

                  var5 = class1.method14(var39);
                  var67.field2800 = 4;
                  var67.field2851 = var39;
                  var67.field2927 = var5.field1188;
                  var67.field2859 = var5.field1193;
                  var67.field2933 = var5.field1191 * 100 / var1;
                  class79.method1777(var67);
               } else {
                  var67.field2879 = var39;
                  var67.field2808 = var1;
                  var5 = class1.method14(var39);
                  var67.field2927 = var5.field1188;
                  var67.field2859 = var5.field1193;
                  var67.field2860 = var5.field1194;
                  var67.field2856 = var5.field1179;
                  var67.field2857 = var5.field1196;
                  var67.field2933 = var5.field1191;
                  if(var5.field1197 == 1) {
                     var67.field2865 = 1;
                  } else {
                     var67.field2865 = 2;
                  }

                  if(var67.field2862 > 0) {
                     var67.field2933 = var67.field2933 * 32 / var67.field2862;
                  } else if(var67.field2818 > 0) {
                     var67.field2933 = var67.field2933 * 32 / var67.field2818;
                  }

                  class79.method1777(var67);
               }

               client.field341 = -1;
               return true;
            }

            if(client.field341 == 68) {
               class9.method125();
               client.field545 = client.field339.method2636();
               client.field490 = client.field478;
               client.field341 = -1;
               return true;
            }

            if(client.field341 == 180) {
               var1 = client.field339.method2670();
               var2 = client.field339.method2620();
               class179.field2957[var1] = var2;
               if(class179.field2958[var1] != var2) {
                  class179.field2958[var1] = var2;
               }

               class213.method4080(var1);
               client.field479[++client.field366 - 1 & 31] = var1;
               client.field341 = -1;
               return true;
            }

            if(client.field341 == 13) {
               var1 = client.field339.method2620();
               class3 var61 = (class3)client.field475.method3936((long)var1);
               if(null != var61) {
                  class145.method3130(var61, true);
               }

               if(null != client.field376) {
                  class79.method1777(client.field376);
                  client.field376 = null;
               }

               client.field341 = -1;
               return true;
            }

            if(client.field341 == 41) {
               client.field487 = client.field478;
               if(client.field340 == 0) {
                  client.field363 = null;
                  client.field521 = null;
                  client.field522 = 0;
                  class4.field74 = null;
                  client.field341 = -1;
                  return true;
               }

               client.field521 = client.field339.method2663();
               long var40 = client.field339.method2649();
               client.field363 = class132.method2974(var40);
               class178.field2952 = client.field339.method2634();
               var39 = client.field339.method2633();
               if(var39 == 255) {
                  client.field341 = -1;
                  return true;
               }

               client.field522 = var39;
               class25[] var65 = new class25[100];

               for(var22 = 0; var22 < client.field522; ++var22) {
                  var65[var22] = new class25();
                  var65[var22].field645 = client.field339.method2663();
                  var65[var22].field639 = class156.method3300(var65[var22].field645, client.field518);
                  var65[var22].field640 = client.field339.method2635();
                  var65[var22].field641 = client.field339.method2634();
                  client.field339.method2663();
                  if(var65[var22].field645.equals(class3.field65.field58)) {
                     class30.field710 = var65[var22].field641;
                  }
               }

               var83 = false;
               var7 = client.field522;

               while(var7 > 0) {
                  var83 = true;
                  --var7;

                  for(var54 = 0; var54 < var7; ++var54) {
                     if(var65[var54].field639.compareTo(var65[1 + var54].field639) > 0) {
                        class25 var24 = var65[var54];
                        var65[var54] = var65[var54 + 1];
                        var65[1 + var54] = var24;
                        var83 = false;
                     }
                  }

                  if(var83) {
                     break;
                  }
               }

               class4.field74 = var65;
               client.field341 = -1;
               return true;
            }

            if(client.field341 == 135) {
               client.field511 = client.field339.method2633();
               client.field379 = client.field339.method2633();
               client.field341 = -1;
               return true;
            }

            if(client.field341 == 234) {
               var1 = client.field339.method2620();
               var43 = client.field339.method2633() == 1;
               var70 = class134.method2983(var1);
               if(var43 != var70.field2804) {
                  var70.field2804 = var43;
                  class79.method1777(var70);
               }

               client.field341 = -1;
               return true;
            }

            if(client.field341 == 243) {
               class151.method3273(client.field339, client.field340);
               client.field341 = -1;
               return true;
            }

            if(client.field341 == 115) {
               client.field542 = true;
               class33.field751 = client.field339.method2633();
               class85.field1514 = client.field339.method2633();
               class133.field2106 = client.field339.method2635();
               class97.field1687 = client.field339.method2633();
               class19.field275 = client.field339.method2633();
               if(class19.field275 >= 100) {
                  var1 = 64 + class33.field751 * 128;
                  var2 = 64 + class85.field1514 * 128;
                  var39 = class127.method2936(var1, var2, class99.field1701) - class133.field2106;
                  var4 = var1 - class151.field2282;
                  var22 = var39 - class8.field149;
                  var47 = var2 - class96.field1670;
                  var7 = (int)Math.sqrt((double)(var47 * var47 + var4 * var4));
                  class102.field1759 = (int)(Math.atan2((double)var22, (double)var7) * 325.949D) & 2047;
                  class59.field1255 = (int)(Math.atan2((double)var4, (double)var47) * -325.949D) & 2047;
                  if(class102.field1759 < 128) {
                     class102.field1759 = 128;
                  }

                  if(class102.field1759 > 383) {
                     class102.field1759 = 383;
                  }
               }

               client.field341 = -1;
               return true;
            }

            if(client.field341 == 109) {
               class4.field72 = client.field339.method2633();
               class46.field1064 = client.field339.method2837();
               client.field341 = -1;
               return true;
            }

            if(client.field341 == 177) {
               var1 = client.field339.method2799();
               var2 = client.field339.method2670();
               if(var2 == '\uffff') {
                  var2 = -1;
               }

               var39 = client.field339.method2680();
               var4 = client.field339.method2635();
               if(var4 == '\uffff') {
                  var4 = -1;
               }

               for(var22 = var4; var22 <= var2; ++var22) {
                  var6 = (long)var22 + ((long)var39 << 32);
                  class211 var25 = client.field435.method3936(var6);
                  if(null != var25) {
                     var25.method4067();
                  }

                  client.field435.method3940(new class204(var1), var6);
               }

               client.field341 = -1;
               return true;
            }

            if(client.field341 == 209) {
               class2.method33(true);
               client.field339.method2898();
               var1 = client.field339.method2635();
               class176.method3561(client.field339, var1);
               client.field341 = -1;
               return true;
            }

            if(client.field341 == 53) {
               client.field339.field2050 += 28;
               if(client.field339.method2656()) {
                  class125 var60 = client.field339;
                  var2 = client.field339.field2050 - 28;
                  if(class152.field2301 != null) {
                     try {
                        class152.field2301.method4293(0L);
                        class152.field2301.method4298(var60.field2051, var2, 24);
                     } catch (Exception var32) {
                        ;
                     }
                  }
               }

               client.field341 = -1;
               return true;
            }

            if(client.field341 == 56) {
               for(var1 = 0; var1 < class56.field1233; ++var1) {
                  var19 = class147.method3242(var1);
                  if(null != var19) {
                     class179.field2957[var1] = 0;
                     class179.field2958[var1] = 0;
                  }
               }

               class9.method125();
               client.field366 += 32;
               client.field341 = -1;
               return true;
            }

            if(client.field341 == 30) {
               var1 = client.field339.method2620();
               var2 = client.field339.method2620();
               if(class107.field1853 == null || !class107.field1853.isValid()) {
                  try {
                     var21 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

                     while(var21.hasNext()) {
                        GarbageCollectorMXBean var20 = (GarbageCollectorMXBean)var21.next();
                        if(var20.isValid()) {
                           class107.field1853 = var20;
                           client.field572 = -1L;
                           client.field571 = -1L;
                        }
                     }
                  } catch (Throwable var36) {
                     ;
                  }
               }

               long var3 = class56.method1249();
               var22 = -1;
               if(class107.field1853 != null) {
                  var6 = class107.field1853.getCollectionTime();
                  if(-1L != client.field571) {
                     long var8 = var6 - client.field571;
                     long var28 = var3 - client.field572;
                     if(0L != var28) {
                        var22 = (int)(100L * var8 / var28);
                     }
                  }

                  client.field571 = var6;
                  client.field572 = var3;
               }

               client.field337.method2903(40);
               client.field337.method2728(var1);
               client.field337.method2675(var2);
               client.field337.method2657(var22);
               client.field337.method2783(class147.field2264);
               client.field341 = -1;
               return true;
            }

            if(client.field341 == 219) {
               var1 = client.field339.method2749();
               if(var1 == '\uffff') {
                  var1 = -1;
               }

               if(var1 == -1 && !client.field533) {
                  class49.method1056();
               } else if(var1 != -1 && client.field457 != var1 && client.field294 != 0 && !client.field533) {
                  class167.method3374(2, class188.field3051, var1, 0, client.field294, false);
               }

               client.field457 = var1;
               client.field341 = -1;
               return true;
            }

            if(client.field341 == 12) {
               var1 = client.field339.method2834();
               var2 = client.field339.method2803();
               if(var2 == '\uffff') {
                  var2 = -1;
               }

               if(client.field294 != 0 && var2 != -1) {
                  class180.method3615(class0.field12, var2, 0, client.field294, false);
                  client.field533 = true;
               }

               client.field341 = -1;
               return true;
            }

            class13.method176("" + client.field341 + "," + client.field345 + "," + client.field311 + "," + client.field340, (Throwable)null);
            class129.method2964();
         } catch (IOException var37) {
            class102.method2289();
         } catch (Exception var38) {
            var18 = "" + client.field341 + "," + client.field345 + "," + client.field311 + "," + client.field340 + "," + (class3.field65.field886[0] + class0.field11) + "," + (class21.field592 + class3.field65.field887[0]) + ",";

            for(var2 = 0; var2 < client.field340 && var2 < 50; ++var2) {
               var18 = var18 + client.field339.field2051[var2] + ",";
            }

            class13.method176(var18, var38);
            class129.method2964();
         }

         return true;
      }
   }

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "484254733"
   )
   static final void method3366(boolean var0) {
      client.field419 = 0;
      client.field454 = 0;
      class142.method3079();

      int var1;
      while(client.field339.method2895(client.field340) >= 27) {
         var1 = client.field339.method2907(15);
         if(var1 == 32767) {
            break;
         }

         boolean var2 = false;
         if(client.field332[var1] == null) {
            client.field332[var1] = new class36();
            var2 = true;
         }

         class36 var3 = client.field332[var1];
         client.field334[++client.field486 - 1] = var1;
         var3.field880 = client.field305;
         int var4 = client.field339.method2907(1);
         if(var4 == 1) {
            client.field336[++client.field454 - 1] = var1;
         }

         int var5 = client.field358[client.field339.method2907(3)];
         if(var2) {
            var3.field882 = var3.field857 = var5;
         }

         int var6 = client.field339.method2907(1);
         var3.field803 = class16.method202(client.field339.method2907(14));
         int var7;
         if(var0) {
            var7 = client.field339.method2907(8);
            if(var7 > 127) {
               var7 -= 256;
            }
         } else {
            var7 = client.field339.method2907(5);
            if(var7 > 15) {
               var7 -= 32;
            }
         }

         int var8;
         if(var0) {
            var8 = client.field339.method2907(8);
            if(var8 > 127) {
               var8 -= 256;
            }
         } else {
            var8 = client.field339.method2907(5);
            if(var8 > 15) {
               var8 -= 32;
            }
         }

         var3.field877 = var3.field803.field913;
         var3.field846 = var3.field803.field936;
         if(var3.field846 == 0) {
            var3.field857 = 0;
         }

         var3.field879 = var3.field803.field919;
         var3.field840 = var3.field803.field917;
         var3.field841 = var3.field803.field932;
         var3.field831 = var3.field803.field922;
         var3.field838 = var3.field803.field931;
         var3.field866 = var3.field803.field928;
         var3.field853 = var3.field803.field923;
         var3.method770(class3.field65.field886[0] + var8, class3.field65.field887[0] + var7, var6 == 1);
      }

      client.field339.method2900();
      class32.method700();

      for(var1 = 0; var1 < client.field419; ++var1) {
         int var9 = client.field388[var1];
         if(client.field305 != client.field332[var9].field880) {
            client.field332[var9].field803 = null;
            client.field332[var9] = null;
         }
      }

      if(client.field340 != client.field339.field2050) {
         throw new RuntimeException(client.field339.field2050 + "," + client.field340);
      } else {
         for(var1 = 0; var1 < client.field486; ++var1) {
            if(client.field332[client.field334[var1]] == null) {
               throw new RuntimeException(var1 + "," + client.field486);
            }
         }

      }
   }
}
