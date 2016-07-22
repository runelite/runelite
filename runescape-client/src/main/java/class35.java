import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("av")
public class class35 {
   @ObfuscatedName("w")
   static final class35 field789 = new class35();
   @ObfuscatedName("e")
   static final class35 field791 = new class35();
   @ObfuscatedName("o")
   static final class35 field792 = new class35();
   @ObfuscatedName("m")
   static final class35 field793 = new class35();
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1685330863
   )
   static int field796;

   @ObfuscatedName("cc")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;Ljava/lang/String;III)V",
      garbageValue = "605307535"
   )
   @Export("menuAction")
   static final void method729(int var0, int var1, int var2, int var3, String var4, String var5, int var6, int var7) {
      if(var2 >= 2000) {
         var2 -= 2000;
      }

      class176 var8;
      int var9;
      if(var2 == 29) {
         client.field313.method2797(20);
         client.field313.method2560(var1);
         var8 = class34.method720(var1);
         if(var8.field2907 != null && var8.field2907[0][0] == 5) {
            var9 = var8.field2907[0][1];
            if(class179.field2949[var9] != var8.field2861[0]) {
               class179.field2949[var9] = var8.field2861[0];
               class3.method36(var9);
            }
         }
      }

      class36 var16;
      if(var2 == 10) {
         var16 = client.field308[var3];
         if(var16 != null) {
            client.field380 = var6;
            client.field351 = var7;
            client.field383 = 2;
            client.field423 = 0;
            client.field504 = var0;
            client.field464 = var1;
            client.field313.method2797(41);
            client.field313.method2595(class140.field2186[82]?1:0);
            client.field313.method2558(var3);
         }
      }

      if(var2 == 42) {
         client.field313.method2797(250);
         client.field313.method2560(var1);
         client.field313.method2558(var0);
         client.field313.method2558(var3);
         client.field488 = 0;
         class97.field1673 = class34.method720(var1);
         client.field385 = var0;
      }

      class2 var17;
      if(var2 == 46) {
         var17 = client.field393[var3];
         if(var17 != null) {
            client.field380 = var6;
            client.field351 = var7;
            client.field383 = 2;
            client.field423 = 0;
            client.field504 = var0;
            client.field464 = var1;
            client.field313.method2797(153);
            client.field313.method2603(var3);
            client.field313.method2595(class140.field2186[82]?1:0);
         }
      }

      if(var2 == 9) {
         var16 = client.field308[var3];
         if(var16 != null) {
            client.field380 = var6;
            client.field351 = var7;
            client.field383 = 2;
            client.field423 = 0;
            client.field504 = var0;
            client.field464 = var1;
            client.field313.method2797(93);
            client.field313.method2605(var3);
            client.field313.method2557(class140.field2186[82]?1:0);
         }
      }

      if(var2 == 20) {
         client.field380 = var6;
         client.field351 = var7;
         client.field383 = 2;
         client.field423 = 0;
         client.field504 = var0;
         client.field464 = var1;
         client.field313.method2797(35);
         client.field313.method2603(var3);
         client.field313.method2605(var0 + class39.field838);
         client.field313.method2595(class140.field2186[82]?1:0);
         client.field313.method2603(var1 + class13.field184);
      }

      if(var2 == 57 || var2 == 1007) {
         var8 = class158.method3212(var1, var0);
         if(var8 != null) {
            var9 = var8.field2834;
            class176 var10 = class158.method3212(var1, var0);
            if(null != var10) {
               if(null != var10.field2895) {
                  class0 var11 = new class0();
                  var11.field3 = var10;
                  var11.field9 = var3;
                  var11.field13 = var5;
                  var11.field1 = var10.field2895;
                  class43.method884(var11, 200000);
               }

               boolean var14 = true;
               if(var10.field2799 > 0) {
                  var14 = class104.method2357(var10);
               }

               if(var14 && class151.method3170(class12.method151(var10), var3 - 1)) {
                  if(var3 == 1) {
                     client.field313.method2797(194);
                     client.field313.method2560(var1);
                     client.field313.method2558(var0);
                     client.field313.method2558(var9);
                  }

                  if(var3 == 2) {
                     client.field313.method2797(4);
                     client.field313.method2560(var1);
                     client.field313.method2558(var0);
                     client.field313.method2558(var9);
                  }

                  if(var3 == 3) {
                     client.field313.method2797(240);
                     client.field313.method2560(var1);
                     client.field313.method2558(var0);
                     client.field313.method2558(var9);
                  }

                  if(var3 == 4) {
                     client.field313.method2797(150);
                     client.field313.method2560(var1);
                     client.field313.method2558(var0);
                     client.field313.method2558(var9);
                  }

                  if(var3 == 5) {
                     client.field313.method2797(22);
                     client.field313.method2560(var1);
                     client.field313.method2558(var0);
                     client.field313.method2558(var9);
                  }

                  if(var3 == 6) {
                     client.field313.method2797(25);
                     client.field313.method2560(var1);
                     client.field313.method2558(var0);
                     client.field313.method2558(var9);
                  }

                  if(var3 == 7) {
                     client.field313.method2797(13);
                     client.field313.method2560(var1);
                     client.field313.method2558(var0);
                     client.field313.method2558(var9);
                  }

                  if(var3 == 8) {
                     client.field313.method2797(3);
                     client.field313.method2560(var1);
                     client.field313.method2558(var0);
                     client.field313.method2558(var9);
                  }

                  if(var3 == 9) {
                     client.field313.method2797(91);
                     client.field313.method2560(var1);
                     client.field313.method2558(var0);
                     client.field313.method2558(var9);
                  }

                  if(var3 == 10) {
                     client.field313.method2797(176);
                     client.field313.method2560(var1);
                     client.field313.method2558(var0);
                     client.field313.method2558(var9);
                  }
               }
            }
         }
      }

      if(var2 == 36) {
         client.field313.method2797(109);
         client.field313.method2605(var3);
         client.field313.method2605(var0);
         client.field313.method2560(var1);
         client.field488 = 0;
         class97.field1673 = class34.method720(var1);
         client.field385 = var0;
      }

      if(var2 == 21) {
         client.field380 = var6;
         client.field351 = var7;
         client.field383 = 2;
         client.field423 = 0;
         client.field504 = var0;
         client.field464 = var1;
         client.field313.method2797(140);
         client.field313.method2567(var0 + class39.field838);
         client.field313.method2558(var3);
         client.field313.method2558(var1 + class13.field184);
         client.field313.method2595(class140.field2186[82]?1:0);
      }

      if(var2 == 40) {
         client.field313.method2797(149);
         client.field313.method2558(var0);
         client.field313.method2567(var3);
         client.field313.method2560(var1);
         client.field488 = 0;
         class97.field1673 = class34.method720(var1);
         client.field385 = var0;
      }

      if(var2 == 38) {
         class118.method2512();
         var8 = class34.method720(var1);
         client.field531 = 1;
         class24.field620 = var0;
         class162.field2664 = var1;
         class181.field2960 = var3;
         class92.method2164(var8);
         client.field424 = class51.method1096(16748608) + class4.method42(var3).field1183 + class51.method1096(16777215);
         if(client.field424 == null) {
            client.field424 = "null";
         }

      } else {
         if(var2 == 50) {
            var17 = client.field393[var3];
            if(null != var17) {
               client.field380 = var6;
               client.field351 = var7;
               client.field383 = 2;
               client.field423 = 0;
               client.field504 = var0;
               client.field464 = var1;
               client.field313.method2797(95);
               client.field313.method2567(var3);
               client.field313.method2595(class140.field2186[82]?1:0);
            }
         }

         if(var2 == 4) {
            client.field380 = var6;
            client.field351 = var7;
            client.field383 = 2;
            client.field423 = 0;
            client.field504 = var0;
            client.field464 = var1;
            client.field313.method2797(24);
            client.field313.method2603(var1 + class13.field184);
            client.field313.method2603(var3 >> 14 & 32767);
            client.field313.method2595(class140.field2186[82]?1:0);
            client.field313.method2567(class39.field838 + var0);
         }

         if(var2 == 1001) {
            client.field380 = var6;
            client.field351 = var7;
            client.field383 = 2;
            client.field423 = 0;
            client.field504 = var0;
            client.field464 = var1;
            client.field313.method2797(216);
            client.field313.method2603(var0 + class39.field838);
            client.field313.method2558(var1 + class13.field184);
            client.field313.method2558(var3 >> 14 & 32767);
            client.field313.method2596(class140.field2186[82]?1:0);
         }

         if(var2 == 41) {
            client.field313.method2797(77);
            client.field313.method2605(var0);
            client.field313.method2560(var1);
            client.field313.method2605(var3);
            client.field488 = 0;
            class97.field1673 = class34.method720(var1);
            client.field385 = var0;
         }

         if(var2 == 22) {
            client.field380 = var6;
            client.field351 = var7;
            client.field383 = 2;
            client.field423 = 0;
            client.field504 = var0;
            client.field464 = var1;
            client.field313.method2797(10);
            client.field313.method2557(class140.field2186[82]?1:0);
            client.field313.method2558(var1 + class13.field184);
            client.field313.method2567(var0 + class39.field838);
            client.field313.method2558(var3);
         }

         if(var2 == 51) {
            var17 = client.field393[var3];
            if(var17 != null) {
               client.field380 = var6;
               client.field351 = var7;
               client.field383 = 2;
               client.field423 = 0;
               client.field504 = var0;
               client.field464 = var1;
               client.field313.method2797(198);
               client.field313.method2558(var3);
               client.field313.method2597(class140.field2186[82]?1:0);
            }
         }

         if(var2 == 30 && client.field402 == null) {
            client.field313.method2797(65);
            client.field313.method2605(var0);
            client.field313.method2729(var1);
            client.field402 = class158.method3212(var1, var0);
            class92.method2164(client.field402);
         }

         if(var2 == 15) {
            var17 = client.field393[var3];
            if(var17 != null) {
               client.field380 = var6;
               client.field351 = var7;
               client.field383 = 2;
               client.field423 = 0;
               client.field504 = var0;
               client.field464 = var1;
               client.field313.method2797(94);
               client.field313.method2558(var3);
               client.field313.method2567(client.field426);
               client.field313.method2729(class96.field1669);
               client.field313.method2596(class140.field2186[82]?1:0);
            }
         }

         if(var2 == 43) {
            client.field313.method2797(78);
            client.field313.method2619(var1);
            client.field313.method2558(var3);
            client.field313.method2605(var0);
            client.field488 = 0;
            class97.field1673 = class34.method720(var1);
            client.field385 = var0;
         }

         if(var2 == 26) {
            class7.method98();
         }

         if(var2 == 34) {
            client.field313.method2797(241);
            client.field313.method2560(var1);
            client.field313.method2558(var3);
            client.field313.method2558(var0);
            client.field488 = 0;
            class97.field1673 = class34.method720(var1);
            client.field385 = var0;
         }

         if(var2 == 1005) {
            var8 = class34.method720(var1);
            if(var8 != null && var8.field2830[var0] >= 100000) {
               class59.method1304(27, "", var8.field2830[var0] + " x " + class4.method42(var3).field1183);
            } else {
               client.field313.method2797(244);
               client.field313.method2558(var3);
            }

            client.field488 = 0;
            class97.field1673 = class34.method720(var1);
            client.field385 = var0;
         }

         if(var2 == 1003) {
            client.field380 = var6;
            client.field351 = var7;
            client.field383 = 2;
            client.field423 = 0;
            var16 = client.field308[var3];
            if(var16 != null) {
               class41 var13 = var16.field802;
               if(null != var13.field934) {
                  var13 = var13.method797();
               }

               if(var13 != null) {
                  client.field313.method2797(100);
                  client.field313.method2605(var13.field908);
               }
            }
         }

         if(var2 == 5) {
            client.field380 = var6;
            client.field351 = var7;
            client.field383 = 2;
            client.field423 = 0;
            client.field504 = var0;
            client.field464 = var1;
            client.field313.method2797(66);
            client.field313.method2605(var1 + class13.field184);
            client.field313.method2603(var3 >> 14 & 32767);
            client.field313.method2567(var0 + class39.field838);
            client.field313.method2596(class140.field2186[82]?1:0);
         }

         if(var2 == 23) {
            class5.field91.method2046(class51.field1119, var0, var1);
         }

         if(var2 == 1002) {
            client.field380 = var6;
            client.field351 = var7;
            client.field383 = 2;
            client.field423 = 0;
            client.field313.method2797(38);
            client.field313.method2603(var3 >> 14 & 32767);
         }

         if(var2 == 1004) {
            client.field380 = var6;
            client.field351 = var7;
            client.field383 = 2;
            client.field423 = 0;
            client.field313.method2797(244);
            client.field313.method2558(var3);
         }

         if(var2 == 28) {
            client.field313.method2797(20);
            client.field313.method2560(var1);
            var8 = class34.method720(var1);
            if(null != var8.field2907 && var8.field2907[0][0] == 5) {
               var9 = var8.field2907[0][1];
               class179.field2949[var9] = 1 - class179.field2949[var9];
               class3.method36(var9);
            }
         }

         if(var2 == 18) {
            client.field380 = var6;
            client.field351 = var7;
            client.field383 = 2;
            client.field423 = 0;
            client.field504 = var0;
            client.field464 = var1;
            client.field313.method2797(28);
            client.field313.method2596(class140.field2186[82]?1:0);
            client.field313.method2603(var3);
            client.field313.method2567(var0 + class39.field838);
            client.field313.method2605(class13.field184 + var1);
         }

         if(var2 == 7) {
            var16 = client.field308[var3];
            if(var16 != null) {
               client.field380 = var6;
               client.field351 = var7;
               client.field383 = 2;
               client.field423 = 0;
               client.field504 = var0;
               client.field464 = var1;
               client.field313.method2797(60);
               client.field313.method2605(class181.field2960);
               client.field313.method2597(class140.field2186[82]?1:0);
               client.field313.method2567(var3);
               client.field313.method2558(class24.field620);
               client.field313.method2560(class162.field2664);
            }
         }

         if(var2 == 35) {
            client.field313.method2797(171);
            client.field313.method2567(var3);
            client.field313.method2558(var0);
            client.field313.method2723(var1);
            client.field488 = 0;
            class97.field1673 = class34.method720(var1);
            client.field385 = var0;
         }

         if(var2 == 19) {
            client.field380 = var6;
            client.field351 = var7;
            client.field383 = 2;
            client.field423 = 0;
            client.field504 = var0;
            client.field464 = var1;
            client.field313.method2797(224);
            client.field313.method2595(class140.field2186[82]?1:0);
            client.field313.method2605(var3);
            client.field313.method2558(class13.field184 + var1);
            client.field313.method2603(class39.field838 + var0);
         }

         if(var2 == 31) {
            client.field313.method2797(48);
            client.field313.method2558(class181.field2960);
            client.field313.method2605(var3);
            client.field313.method2603(class24.field620);
            client.field313.method2619(var1);
            client.field313.method2560(class162.field2664);
            client.field313.method2603(var0);
            client.field488 = 0;
            class97.field1673 = class34.method720(var1);
            client.field385 = var0;
         }

         if(var2 == 47) {
            var17 = client.field393[var3];
            if(var17 != null) {
               client.field380 = var6;
               client.field351 = var7;
               client.field383 = 2;
               client.field423 = 0;
               client.field504 = var0;
               client.field464 = var1;
               client.field313.method2797(220);
               client.field313.method2567(var3);
               client.field313.method2595(class140.field2186[82]?1:0);
            }
         }

         if(var2 == 6) {
            client.field380 = var6;
            client.field351 = var7;
            client.field383 = 2;
            client.field423 = 0;
            client.field504 = var0;
            client.field464 = var1;
            client.field313.method2797(243);
            client.field313.method2558(var3 >> 14 & 32767);
            client.field313.method2603(var0 + class39.field838);
            client.field313.method2597(class140.field2186[82]?1:0);
            client.field313.method2567(var1 + class13.field184);
         }

         if(var2 == 39) {
            client.field313.method2797(67);
            client.field313.method2560(var1);
            client.field313.method2567(var0);
            client.field313.method2567(var3);
            client.field488 = 0;
            class97.field1673 = class34.method720(var1);
            client.field385 = var0;
         }

         if(var2 == 3) {
            client.field380 = var6;
            client.field351 = var7;
            client.field383 = 2;
            client.field423 = 0;
            client.field504 = var0;
            client.field464 = var1;
            client.field313.method2797(197);
            client.field313.method2603(class13.field184 + var1);
            client.field313.method2596(class140.field2186[82]?1:0);
            client.field313.method2558(var3 >> 14 & 32767);
            client.field313.method2567(var0 + class39.field838);
         }

         if(var2 == 37) {
            client.field313.method2797(157);
            client.field313.method2723(var1);
            client.field313.method2603(var3);
            client.field313.method2603(var0);
            client.field488 = 0;
            class97.field1673 = class34.method720(var1);
            client.field385 = var0;
         }

         if(var2 == 49) {
            var17 = client.field393[var3];
            if(null != var17) {
               client.field380 = var6;
               client.field351 = var7;
               client.field383 = 2;
               client.field423 = 0;
               client.field504 = var0;
               client.field464 = var1;
               client.field313.method2797(11);
               client.field313.method2597(class140.field2186[82]?1:0);
               client.field313.method2567(var3);
            }
         }

         if(var2 == 11) {
            var16 = client.field308[var3];
            if(null != var16) {
               client.field380 = var6;
               client.field351 = var7;
               client.field383 = 2;
               client.field423 = 0;
               client.field504 = var0;
               client.field464 = var1;
               client.field313.method2797(142);
               client.field313.method2596(class140.field2186[82]?1:0);
               client.field313.method2567(var3);
            }
         }

         if(var2 == 1) {
            client.field380 = var6;
            client.field351 = var7;
            client.field383 = 2;
            client.field423 = 0;
            client.field504 = var0;
            client.field464 = var1;
            client.field313.method2797(175);
            client.field313.method2605(class24.field620);
            client.field313.method2567(class181.field2960);
            client.field313.method2729(class162.field2664);
            client.field313.method2596(class140.field2186[82]?1:0);
            client.field313.method2603(var1 + class13.field184);
            client.field313.method2605(var3 >> 14 & 32767);
            client.field313.method2605(var0 + class39.field838);
         }

         if(var2 == 48) {
            var17 = client.field393[var3];
            if(var17 != null) {
               client.field380 = var6;
               client.field351 = var7;
               client.field383 = 2;
               client.field423 = 0;
               client.field504 = var0;
               client.field464 = var1;
               client.field313.method2797(29);
               client.field313.method2567(var3);
               client.field313.method2595(class140.field2186[82]?1:0);
            }
         }

         if(var2 == 16) {
            client.field380 = var6;
            client.field351 = var7;
            client.field383 = 2;
            client.field423 = 0;
            client.field504 = var0;
            client.field464 = var1;
            client.field313.method2797(69);
            client.field313.method2603(class13.field184 + var1);
            client.field313.method2605(class24.field620);
            client.field313.method2567(var0 + class39.field838);
            client.field313.method2605(var3);
            client.field313.method2605(class181.field2960);
            client.field313.method2729(class162.field2664);
            client.field313.method2597(class140.field2186[82]?1:0);
         }

         if(var2 == 24) {
            var8 = class34.method720(var1);
            boolean var18 = true;
            if(var8.field2799 > 0) {
               var18 = class104.method2357(var8);
            }

            if(var18) {
               client.field313.method2797(20);
               client.field313.method2560(var1);
            }
         }

         if(var2 == 33) {
            client.field313.method2797(121);
            client.field313.method2558(var0);
            client.field313.method2619(var1);
            client.field313.method2567(var3);
            client.field488 = 0;
            class97.field1673 = class34.method720(var1);
            client.field385 = var0;
         }

         if(var2 == 12) {
            var16 = client.field308[var3];
            if(var16 != null) {
               client.field380 = var6;
               client.field351 = var7;
               client.field383 = 2;
               client.field423 = 0;
               client.field504 = var0;
               client.field464 = var1;
               client.field313.method2797(217);
               client.field313.method2567(var3);
               client.field313.method2595(class140.field2186[82]?1:0);
            }
         }

         if(var2 == 8) {
            var16 = client.field308[var3];
            if(null != var16) {
               client.field380 = var6;
               client.field351 = var7;
               client.field383 = 2;
               client.field423 = 0;
               client.field504 = var0;
               client.field464 = var1;
               client.field313.method2797(168);
               client.field313.method2558(var3);
               client.field313.method2557(class140.field2186[82]?1:0);
               client.field313.method2567(client.field426);
               client.field313.method2619(class96.field1669);
            }
         }

         if(var2 == 13) {
            var16 = client.field308[var3];
            if(null != var16) {
               client.field380 = var6;
               client.field351 = var7;
               client.field383 = 2;
               client.field423 = 0;
               client.field504 = var0;
               client.field464 = var1;
               client.field313.method2797(105);
               client.field313.method2603(var3);
               client.field313.method2596(class140.field2186[82]?1:0);
            }
         }

         if(var2 == 58) {
            var8 = class158.method3212(var1, var0);
            if(null != var8) {
               client.field313.method2797(177);
               client.field313.method2567(client.field427);
               client.field313.method2729(class96.field1669);
               client.field313.method2603(client.field426);
               client.field313.method2558(var8.field2834);
               client.field313.method2729(var1);
               client.field313.method2603(var0);
            }
         }

         if(var2 == 32) {
            client.field313.method2797(47);
            client.field313.method2567(client.field426);
            client.field313.method2558(var0);
            client.field313.method2619(var1);
            client.field313.method2558(var3);
            client.field313.method2619(class96.field1669);
            client.field488 = 0;
            class97.field1673 = class34.method720(var1);
            client.field385 = var0;
         }

         if(var2 == 25) {
            var8 = class158.method3212(var1, var0);
            if(null != var8) {
               class118.method2512();
               var9 = class25.method599(class12.method151(var8));
               int var15 = var8.field2834;
               class176 var19 = class158.method3212(var1, var0);
               if(null != var19 && null != var19.field2905) {
                  class0 var12 = new class0();
                  var12.field3 = var19;
                  var12.field1 = var19.field2905;
                  class43.method884(var12, 200000);
               }

               client.field427 = var15;
               client.field444 = true;
               class96.field1669 = var1;
               client.field426 = var0;
               class116.field2016 = var9;
               class92.method2164(var19);
               client.field531 = 0;
               client.field428 = class170.method3381(var8);
               if(client.field428 == null) {
                  client.field428 = "Null";
               }

               if(var8.field2794) {
                  client.field438 = var8.field2868 + class51.method1096(16777215);
               } else {
                  client.field438 = class51.method1096('\uff00') + var8.field2792 + class51.method1096(16777215);
               }
            }

         } else {
            if(var2 == 44) {
               var17 = client.field393[var3];
               if(null != var17) {
                  client.field380 = var6;
                  client.field351 = var7;
                  client.field383 = 2;
                  client.field423 = 0;
                  client.field504 = var0;
                  client.field464 = var1;
                  client.field313.method2797(242);
                  client.field313.method2596(class140.field2186[82]?1:0);
                  client.field313.method2567(var3);
               }
            }

            if(var2 == 17) {
               client.field380 = var6;
               client.field351 = var7;
               client.field383 = 2;
               client.field423 = 0;
               client.field504 = var0;
               client.field464 = var1;
               client.field313.method2797(70);
               client.field313.method2567(class39.field838 + var0);
               client.field313.method2603(var1 + class13.field184);
               client.field313.method2560(class96.field1669);
               client.field313.method2557(class140.field2186[82]?1:0);
               client.field313.method2603(client.field426);
               client.field313.method2558(var3);
            }

            if(var2 == 45) {
               var17 = client.field393[var3];
               if(null != var17) {
                  client.field380 = var6;
                  client.field351 = var7;
                  client.field383 = 2;
                  client.field423 = 0;
                  client.field504 = var0;
                  client.field464 = var1;
                  client.field313.method2797(123);
                  client.field313.method2603(var3);
                  client.field313.method2595(class140.field2186[82]?1:0);
               }
            }

            if(var2 == 14) {
               var17 = client.field393[var3];
               if(null != var17) {
                  client.field380 = var6;
                  client.field351 = var7;
                  client.field383 = 2;
                  client.field423 = 0;
                  client.field504 = var0;
                  client.field464 = var1;
                  client.field313.method2797(118);
                  client.field313.method2619(class162.field2664);
                  client.field313.method2603(var3);
                  client.field313.method2558(class181.field2960);
                  client.field313.method2567(class24.field620);
                  client.field313.method2557(class140.field2186[82]?1:0);
               }
            }

            if(var2 == 2) {
               client.field380 = var6;
               client.field351 = var7;
               client.field383 = 2;
               client.field423 = 0;
               client.field504 = var0;
               client.field464 = var1;
               client.field313.method2797(161);
               client.field313.method2605(client.field426);
               client.field313.method2603(var1 + class13.field184);
               client.field313.method2603(class39.field838 + var0);
               client.field313.method2603(var3 >> 14 & 32767);
               client.field313.method2560(class96.field1669);
               client.field313.method2597(class140.field2186[82]?1:0);
            }

            if(client.field531 != 0) {
               client.field531 = 0;
               class92.method2164(class34.method720(class162.field2664));
            }

            if(client.field444) {
               class118.method2512();
            }

            if(null != class97.field1673 && client.field488 == 0) {
               class92.method2164(class97.field1673);
            }

         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-846411579"
   )
   static int method730(int var0) {
      class37 var1 = (class37)class11.field157.method3864((long)var0);
      return var1 == null?-1:(class11.field158.field3151 == var1.field3156?-1:((class37)var1.field3156).field809);
   }
}
