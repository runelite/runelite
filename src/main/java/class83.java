import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cn")
public class class83 {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1702472455
   )
   int field1453;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1021015527
   )
   int field1454;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -2112486563
   )
   int field1455;
   @ObfuscatedName("ju")
   @ObfuscatedGetter(
      intValue = -1210850693
   )
   static int field1458;

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;Ljava/lang/String;IIB)V",
      garbageValue = "88"
   )
   static final void method1863(int var0, int var1, int var2, int var3, String var4, int var5, int var6) {
      if(var2 >= 2000) {
         var2 -= 2000;
      }

      if(var2 == 37) {
         client.field329.method2686(54);
         client.field329.method2541(var0);
         client.field329.method2636(var1);
         client.field329.method2564(var3);
         client.field338 = 0;
         class8.field141 = class31.method698(var1);
         client.field402 = var0;
      }

      if(var2 == 35) {
         client.field329.method2686(227);
         client.field329.method2441(var1);
         client.field329.method2541(var3);
         client.field329.method2440(var0);
         client.field338 = 0;
         class8.field141 = class31.method698(var1);
         client.field402 = var0;
      }

      if(22 == var2) {
         client.field397 = var5;
         client.field479 = var6;
         client.field400 = 2;
         client.field305 = 0;
         client.field296 = var0;
         client.field319 = var1;
         client.field329.method2686(188);
         client.field329.method2622(class136.field2121[82]?1:0);
         client.field329.method2564(var1 + class92.field1598);
         client.field329.method2440(var3);
         client.field329.method2541(class98.field1683 + var0);
      }

      if(4 == var2) {
         client.field397 = var5;
         client.field479 = var6;
         client.field400 = 2;
         client.field305 = 0;
         client.field296 = var0;
         client.field319 = var1;
         client.field329.method2686(4);
         client.field329.method2541(class98.field1683 + var0);
         client.field329.method2440(var3 >> 14 & 32767);
         client.field329.method2477(class136.field2121[82]?1:0);
         client.field329.method2541(class92.field1598 + var1);
      }

      class2 var7;
      if(var2 == 46) {
         var7 = client.field410[var3];
         if(null != var7) {
            client.field397 = var5;
            client.field479 = var6;
            client.field400 = 2;
            client.field305 = 0;
            client.field296 = var0;
            client.field319 = var1;
            client.field329.method2686(255);
            client.field329.method2564(var3);
            client.field329.method2438(class136.field2121[82]?1:0);
         }
      }

      if(26 == var2) {
         method1868();
      }

      class34 var12;
      if(13 == var2) {
         var12 = client.field324[var3];
         if(null != var12) {
            client.field397 = var5;
            client.field479 = var6;
            client.field400 = 2;
            client.field305 = 0;
            client.field296 = var0;
            client.field319 = var1;
            client.field329.method2686(240);
            client.field329.method2440(var3);
            client.field329.method2622(class136.field2121[82]?1:0);
         }
      }

      if(18 == var2) {
         client.field397 = var5;
         client.field479 = var6;
         client.field400 = 2;
         client.field305 = 0;
         client.field296 = var0;
         client.field319 = var1;
         client.field329.method2686(164);
         client.field329.method2564(var3);
         client.field329.method2438(class136.field2121[82]?1:0);
         client.field329.method2440(var1 + class92.field1598);
         client.field329.method2541(class98.field1683 + var0);
      }

      if(var2 == 1003) {
         client.field397 = var5;
         client.field479 = var6;
         client.field400 = 2;
         client.field305 = 0;
         var12 = client.field324[var3];
         if(var12 != null) {
            class39 var8 = var12.field779;
            if(null != var8.field909) {
               var8 = var8.method789();
            }

            if(var8 != null) {
               client.field329.method2686(105);
               client.field329.method2484(var8.field896);
            }
         }
      }

      class172 var13;
      if(38 == var2) {
         class12.method152();
         var13 = class31.method698(var1);
         client.field301 = 1;
         class164.field2672 = var0;
         class47.field1074 = var1;
         class19.field282 = var3;
         class114.method2400(var13);
         client.field442 = class24.method592(16748608) + class22.method581(var3).field1121 + class24.method592(16777215);
         if(client.field442 == null) {
            client.field442 = "null";
         }

      } else {
         if(1 == var2) {
            client.field397 = var5;
            client.field479 = var6;
            client.field400 = 2;
            client.field305 = 0;
            client.field296 = var0;
            client.field319 = var1;
            client.field329.method2686(185);
            client.field329.method2440(var0 + class98.field1683);
            client.field329.method2564(class19.field282);
            client.field329.method2477(class136.field2121[82]?1:0);
            client.field329.method2441(class47.field1074);
            client.field329.method2440(var3 >> 14 & 32767);
            client.field329.method2541(class164.field2672);
            client.field329.method2541(var1 + class92.field1598);
         }

         if(var2 == 7) {
            var12 = client.field324[var3];
            if(var12 != null) {
               client.field397 = var5;
               client.field479 = var6;
               client.field400 = 2;
               client.field305 = 0;
               client.field296 = var0;
               client.field319 = var1;
               client.field329.method2686(141);
               client.field329.method2564(class19.field282);
               client.field329.method2541(var3);
               client.field329.method2438(class136.field2121[82]?1:0);
               client.field329.method2541(class164.field2672);
               client.field329.method2636(class47.field1074);
            }
         }

         if(44 == var2) {
            var7 = client.field410[var3];
            if(var7 != null) {
               client.field397 = var5;
               client.field479 = var6;
               client.field400 = 2;
               client.field305 = 0;
               client.field296 = var0;
               client.field319 = var1;
               client.field329.method2686(28);
               client.field329.method2622(class136.field2121[82]?1:0);
               client.field329.method2484(var3);
            }
         }

         if(12 == var2) {
            var12 = client.field324[var3];
            if(null != var12) {
               client.field397 = var5;
               client.field479 = var6;
               client.field400 = 2;
               client.field305 = 0;
               client.field296 = var0;
               client.field319 = var1;
               client.field329.method2686(62);
               client.field329.method2438(class136.field2121[82]?1:0);
               client.field329.method2564(var3);
            }
         }

         if(var2 == 32) {
            client.field329.method2686(12);
            client.field329.method2541(var0);
            client.field329.method2440(client.field444);
            client.field329.method2607(var1);
            client.field329.method2636(class137.field2144);
            client.field329.method2440(var3);
            client.field338 = 0;
            class8.field141 = class31.method698(var1);
            client.field402 = var0;
         }

         int var14;
         if(29 == var2) {
            client.field329.method2686(201);
            client.field329.method2441(var1);
            var13 = class31.method698(var1);
            if(null != var13.field2869 && var13.field2869[0][0] == 5) {
               var14 = var13.field2869[0][1];
               if(class175.field2906[var14] != var13.field2871[0]) {
                  class175.field2906[var14] = var13.field2871[0];
                  class129.method2758(var14);
               }
            }
         }

         if(57 == var2 || var2 == 1007) {
            var13 = class142.method2954(var1, var0);
            if(var13 != null) {
               var14 = var13.field2877;
               class172 var9 = class142.method2954(var1, var0);
               if(var9 != null) {
                  if(var9.field2891 != null) {
                     class0 var10 = new class0();
                     var10.field2 = var9;
                     var10.field14 = var3;
                     var10.field9 = var4;
                     var10.field5 = var9.field2891;
                     class126.method2751(var10, 200000);
                  }

                  boolean var17 = true;
                  if(var9.field2763 > 0) {
                     var17 = class9.method121(var9);
                  }

                  if(var17 && class41.method839(class42.method898(var9), var3 - 1)) {
                     if(1 == var3) {
                        client.field329.method2686(175);
                        client.field329.method2441(var1);
                        client.field329.method2541(var0);
                        client.field329.method2541(var14);
                     }

                     if(2 == var3) {
                        client.field329.method2686(85);
                        client.field329.method2441(var1);
                        client.field329.method2541(var0);
                        client.field329.method2541(var14);
                     }

                     if(var3 == 3) {
                        client.field329.method2686(222);
                        client.field329.method2441(var1);
                        client.field329.method2541(var0);
                        client.field329.method2541(var14);
                     }

                     if(4 == var3) {
                        client.field329.method2686(73);
                        client.field329.method2441(var1);
                        client.field329.method2541(var0);
                        client.field329.method2541(var14);
                     }

                     if(5 == var3) {
                        client.field329.method2686(61);
                        client.field329.method2441(var1);
                        client.field329.method2541(var0);
                        client.field329.method2541(var14);
                     }

                     if(var3 == 6) {
                        client.field329.method2686(173);
                        client.field329.method2441(var1);
                        client.field329.method2541(var0);
                        client.field329.method2541(var14);
                     }

                     if(var3 == 7) {
                        client.field329.method2686(183);
                        client.field329.method2441(var1);
                        client.field329.method2541(var0);
                        client.field329.method2541(var14);
                     }

                     if(var3 == 8) {
                        client.field329.method2686(194);
                        client.field329.method2441(var1);
                        client.field329.method2541(var0);
                        client.field329.method2541(var14);
                     }

                     if(var3 == 9) {
                        client.field329.method2686(120);
                        client.field329.method2441(var1);
                        client.field329.method2541(var0);
                        client.field329.method2541(var14);
                     }

                     if(10 == var3) {
                        client.field329.method2686(198);
                        client.field329.method2441(var1);
                        client.field329.method2541(var0);
                        client.field329.method2541(var14);
                     }
                  }
               }
            }
         }

         if(var2 == 23) {
            class107.field1906.method1985(class75.field1386, var0, var1);
         }

         if(var2 == 24) {
            var13 = class31.method698(var1);
            boolean var16 = true;
            if(var13.field2763 > 0) {
               var16 = class9.method121(var13);
            }

            if(var16) {
               client.field329.method2686(201);
               client.field329.method2441(var1);
            }
         }

         if(41 == var2) {
            client.field329.method2686(104);
            client.field329.method2607(var1);
            client.field329.method2440(var0);
            client.field329.method2484(var3);
            client.field338 = 0;
            class8.field141 = class31.method698(var1);
            client.field402 = var0;
         }

         if(6 == var2) {
            client.field397 = var5;
            client.field479 = var6;
            client.field400 = 2;
            client.field305 = 0;
            client.field296 = var0;
            client.field319 = var1;
            client.field329.method2686(228);
            client.field329.method2440(class92.field1598 + var1);
            client.field329.method2476(class136.field2121[82]?1:0);
            client.field329.method2564(var3 >> 14 & 32767);
            client.field329.method2541(class98.field1683 + var0);
         }

         if(var2 == 5) {
            client.field397 = var5;
            client.field479 = var6;
            client.field400 = 2;
            client.field305 = 0;
            client.field296 = var0;
            client.field319 = var1;
            client.field329.method2686(182);
            client.field329.method2564(var3 >> 14 & 32767);
            client.field329.method2438(class136.field2121[82]?1:0);
            client.field329.method2440(var0 + class98.field1683);
            client.field329.method2541(class92.field1598 + var1);
         }

         if(30 == var2 && null == client.field452) {
            client.field329.method2686(13);
            client.field329.method2440(var0);
            client.field329.method2494(var1);
            client.field452 = class142.method2954(var1, var0);
            class114.method2400(client.field452);
         }

         if(1001 == var2) {
            client.field397 = var5;
            client.field479 = var6;
            client.field400 = 2;
            client.field305 = 0;
            client.field296 = var0;
            client.field319 = var1;
            client.field329.method2686(88);
            client.field329.method2541(var3 >> 14 & 32767);
            client.field329.method2440(var0 + class98.field1683);
            client.field329.method2440(class92.field1598 + var1);
            client.field329.method2622(class136.field2121[82]?1:0);
         }

         if(20 == var2) {
            client.field397 = var5;
            client.field479 = var6;
            client.field400 = 2;
            client.field305 = 0;
            client.field296 = var0;
            client.field319 = var1;
            client.field329.method2686(131);
            client.field329.method2541(var0 + class98.field1683);
            client.field329.method2477(class136.field2121[82]?1:0);
            client.field329.method2440(var1 + class92.field1598);
            client.field329.method2440(var3);
         }

         if(28 == var2) {
            client.field329.method2686(201);
            client.field329.method2441(var1);
            var13 = class31.method698(var1);
            if(var13.field2869 != null && 5 == var13.field2869[0][0]) {
               var14 = var13.field2869[0][1];
               class175.field2906[var14] = 1 - class175.field2906[var14];
               class129.method2758(var14);
            }
         }

         if(8 == var2) {
            var12 = client.field324[var3];
            if(null != var12) {
               client.field397 = var5;
               client.field479 = var6;
               client.field400 = 2;
               client.field305 = 0;
               client.field296 = var0;
               client.field319 = var1;
               client.field329.method2686(136);
               client.field329.method2438(class136.field2121[82]?1:0);
               client.field329.method2440(client.field444);
               client.field329.method2441(class137.field2144);
               client.field329.method2541(var3);
            }
         }

         if(33 == var2) {
            client.field329.method2686(152);
            client.field329.method2541(var0);
            client.field329.method2636(var1);
            client.field329.method2564(var3);
            client.field338 = 0;
            class8.field141 = class31.method698(var1);
            client.field402 = var0;
         }

         if(45 == var2) {
            var7 = client.field410[var3];
            if(var7 != null) {
               client.field397 = var5;
               client.field479 = var6;
               client.field400 = 2;
               client.field305 = 0;
               client.field296 = var0;
               client.field319 = var1;
               client.field329.method2686(214);
               client.field329.method2440(var3);
               client.field329.method2438(class136.field2121[82]?1:0);
            }
         }

         if(var2 == 58) {
            var13 = class142.method2954(var1, var0);
            if(null != var13) {
               client.field329.method2686(207);
               client.field329.method2564(var13.field2877);
               client.field329.method2541(var0);
               client.field329.method2440(client.field444);
               client.field329.method2564(client.field511);
               client.field329.method2494(class137.field2144);
               client.field329.method2607(var1);
            }
         }

         if(43 == var2) {
            client.field329.method2686(133);
            client.field329.method2541(var0);
            client.field329.method2541(var3);
            client.field329.method2441(var1);
            client.field338 = 0;
            class8.field141 = class31.method698(var1);
            client.field402 = var0;
         }

         if(var2 == 31) {
            client.field329.method2686(129);
            client.field329.method2607(class47.field1074);
            client.field329.method2541(class19.field282);
            client.field329.method2564(var0);
            client.field329.method2541(class164.field2672);
            client.field329.method2494(var1);
            client.field329.method2440(var3);
            client.field338 = 0;
            class8.field141 = class31.method698(var1);
            client.field402 = var0;
         }

         if(25 == var2) {
            var13 = class142.method2954(var1, var0);
            if(var13 != null) {
               class12.method152();
               var14 = class156.method3118(class42.method898(var13));
               int var15 = var13.field2877;
               class172 var18 = class142.method2954(var1, var0);
               if(var18 != null && null != var18.field2792) {
                  class0 var11 = new class0();
                  var11.field2 = var18;
                  var11.field5 = var18.field2792;
                  class126.method2751(var11, 200000);
               }

               client.field511 = var15;
               client.field408 = true;
               class137.field2144 = var1;
               client.field444 = var0;
               client.field573 = var14;
               class114.method2400(var18);
               client.field301 = 0;
               String var19;
               if(class156.method3118(class42.method898(var13)) == 0) {
                  var19 = null;
               } else if(var13.field2806 != null && var13.field2806.trim().length() != 0) {
                  var19 = var13.field2806;
               } else {
                  var19 = null;
               }

               client.field446 = var19;
               if(client.field446 == null) {
                  client.field446 = "Null";
               }

               if(var13.field2758) {
                  client.field447 = var13.field2830 + class24.method592(16777215);
               } else {
                  client.field447 = class24.method592('\uff00') + var13.field2832 + class24.method592(16777215);
               }
            }

         } else {
            if(var2 == 9) {
               var12 = client.field324[var3];
               if(null != var12) {
                  client.field397 = var5;
                  client.field479 = var6;
                  client.field400 = 2;
                  client.field305 = 0;
                  client.field296 = var0;
                  client.field319 = var1;
                  client.field329.method2686(31);
                  client.field329.method2622(class136.field2121[82]?1:0);
                  client.field329.method2541(var3);
               }
            }

            if(47 == var2) {
               var7 = client.field410[var3];
               if(null != var7) {
                  client.field397 = var5;
                  client.field479 = var6;
                  client.field400 = 2;
                  client.field305 = 0;
                  client.field296 = var0;
                  client.field319 = var1;
                  client.field329.method2686(144);
                  client.field329.method2484(var3);
                  client.field329.method2477(class136.field2121[82]?1:0);
               }
            }

            if(var2 == 34) {
               client.field329.method2686(168);
               client.field329.method2494(var1);
               client.field329.method2564(var3);
               client.field329.method2440(var0);
               client.field338 = 0;
               class8.field141 = class31.method698(var1);
               client.field402 = var0;
            }

            if(var2 == 40) {
               client.field329.method2686(235);
               client.field329.method2541(var3);
               client.field329.method2440(var0);
               client.field329.method2636(var1);
               client.field338 = 0;
               class8.field141 = class31.method698(var1);
               client.field402 = var0;
            }

            if(var2 == 1002) {
               client.field397 = var5;
               client.field479 = var6;
               client.field400 = 2;
               client.field305 = 0;
               client.field329.method2686(186);
               client.field329.method2440(var3 >> 14 & 32767);
            }

            if(var2 == 21) {
               client.field397 = var5;
               client.field479 = var6;
               client.field400 = 2;
               client.field305 = 0;
               client.field296 = var0;
               client.field319 = var1;
               client.field329.method2686(124);
               client.field329.method2541(class98.field1683 + var0);
               client.field329.method2438(class136.field2121[82]?1:0);
               client.field329.method2564(var1 + class92.field1598);
               client.field329.method2440(var3);
            }

            if(17 == var2) {
               client.field397 = var5;
               client.field479 = var6;
               client.field400 = 2;
               client.field305 = 0;
               client.field296 = var0;
               client.field319 = var1;
               client.field329.method2686(170);
               client.field329.method2438(class136.field2121[82]?1:0);
               client.field329.method2541(class92.field1598 + var1);
               client.field329.method2564(var0 + class98.field1683);
               client.field329.method2607(class137.field2144);
               client.field329.method2564(var3);
               client.field329.method2564(client.field444);
            }

            if(16 == var2) {
               client.field397 = var5;
               client.field479 = var6;
               client.field400 = 2;
               client.field305 = 0;
               client.field296 = var0;
               client.field319 = var1;
               client.field329.method2686(225);
               client.field329.method2477(class136.field2121[82]?1:0);
               client.field329.method2607(class47.field1074);
               client.field329.method2484(class92.field1598 + var1);
               client.field329.method2541(class19.field282);
               client.field329.method2484(class98.field1683 + var0);
               client.field329.method2541(var3);
               client.field329.method2541(class164.field2672);
            }

            if(1004 == var2) {
               client.field397 = var5;
               client.field479 = var6;
               client.field400 = 2;
               client.field305 = 0;
               client.field329.method2686(142);
               client.field329.method2440(var3);
            }

            if(48 == var2) {
               var7 = client.field410[var3];
               if(null != var7) {
                  client.field397 = var5;
                  client.field479 = var6;
                  client.field400 = 2;
                  client.field305 = 0;
                  client.field296 = var0;
                  client.field319 = var1;
                  client.field329.method2686(206);
                  client.field329.method2476(class136.field2121[82]?1:0);
                  client.field329.method2564(var3);
               }
            }

            if(36 == var2) {
               client.field329.method2686(84);
               client.field329.method2607(var1);
               client.field329.method2484(var0);
               client.field329.method2484(var3);
               client.field338 = 0;
               class8.field141 = class31.method698(var1);
               client.field402 = var0;
            }

            if(var2 == 2) {
               client.field397 = var5;
               client.field479 = var6;
               client.field400 = 2;
               client.field305 = 0;
               client.field296 = var0;
               client.field319 = var1;
               client.field329.method2686(197);
               client.field329.method2484(client.field444);
               client.field329.method2441(class137.field2144);
               client.field329.method2438(class136.field2121[82]?1:0);
               client.field329.method2440(var0 + class98.field1683);
               client.field329.method2440(class92.field1598 + var1);
               client.field329.method2564(var3 >> 14 & 32767);
            }

            if(49 == var2) {
               var7 = client.field410[var3];
               if(var7 != null) {
                  client.field397 = var5;
                  client.field479 = var6;
                  client.field400 = 2;
                  client.field305 = 0;
                  client.field296 = var0;
                  client.field319 = var1;
                  client.field329.method2686(158);
                  client.field329.method2440(var3);
                  client.field329.method2476(class136.field2121[82]?1:0);
               }
            }

            if(50 == var2) {
               var7 = client.field410[var3];
               if(var7 != null) {
                  client.field397 = var5;
                  client.field479 = var6;
                  client.field400 = 2;
                  client.field305 = 0;
                  client.field296 = var0;
                  client.field319 = var1;
                  client.field329.method2686(9);
                  client.field329.method2476(class136.field2121[82]?1:0);
                  client.field329.method2564(var3);
               }
            }

            if(14 == var2) {
               var7 = client.field410[var3];
               if(null != var7) {
                  client.field397 = var5;
                  client.field479 = var6;
                  client.field400 = 2;
                  client.field305 = 0;
                  client.field296 = var0;
                  client.field319 = var1;
                  client.field329.method2686(226);
                  client.field329.method2564(class164.field2672);
                  client.field329.method2541(class19.field282);
                  client.field329.method2438(class136.field2121[82]?1:0);
                  client.field329.method2494(class47.field1074);
                  client.field329.method2440(var3);
               }
            }

            if(51 == var2) {
               var7 = client.field410[var3];
               if(null != var7) {
                  client.field397 = var5;
                  client.field479 = var6;
                  client.field400 = 2;
                  client.field305 = 0;
                  client.field296 = var0;
                  client.field319 = var1;
                  client.field329.method2686(67);
                  client.field329.method2564(var3);
                  client.field329.method2438(class136.field2121[82]?1:0);
               }
            }

            if(11 == var2) {
               var12 = client.field324[var3];
               if(null != var12) {
                  client.field397 = var5;
                  client.field479 = var6;
                  client.field400 = 2;
                  client.field305 = 0;
                  client.field296 = var0;
                  client.field319 = var1;
                  client.field329.method2686(0);
                  client.field329.method2484(var3);
                  client.field329.method2477(class136.field2121[82]?1:0);
               }
            }

            if(var2 == 39) {
               client.field329.method2686(21);
               client.field329.method2636(var1);
               client.field329.method2564(var0);
               client.field329.method2440(var3);
               client.field338 = 0;
               class8.field141 = class31.method698(var1);
               client.field402 = var0;
            }

            if(var2 == 1005) {
               var13 = class31.method698(var1);
               if(null != var13 && var13.field2876[var0] >= 100000) {
                  class16.method186(27, "", var13.field2876[var0] + " x " + class22.method581(var3).field1121);
               } else {
                  client.field329.method2686(142);
                  client.field329.method2440(var3);
               }

               client.field338 = 0;
               class8.field141 = class31.method698(var1);
               client.field402 = var0;
            }

            if(15 == var2) {
               var7 = client.field410[var3];
               if(null != var7) {
                  client.field397 = var5;
                  client.field479 = var6;
                  client.field400 = 2;
                  client.field305 = 0;
                  client.field296 = var0;
                  client.field319 = var1;
                  client.field329.method2686(42);
                  client.field329.method2494(class137.field2144);
                  client.field329.method2541(var3);
                  client.field329.method2541(client.field444);
                  client.field329.method2477(class136.field2121[82]?1:0);
               }
            }

            if(42 == var2) {
               client.field329.method2686(6);
               client.field329.method2494(var1);
               client.field329.method2440(var3);
               client.field329.method2564(var0);
               client.field338 = 0;
               class8.field141 = class31.method698(var1);
               client.field402 = var0;
            }

            if(var2 == 19) {
               client.field397 = var5;
               client.field479 = var6;
               client.field400 = 2;
               client.field305 = 0;
               client.field296 = var0;
               client.field319 = var1;
               client.field329.method2686(78);
               client.field329.method2438(class136.field2121[82]?1:0);
               client.field329.method2440(var0 + class98.field1683);
               client.field329.method2484(class92.field1598 + var1);
               client.field329.method2564(var3);
            }

            if(var2 == 3) {
               client.field397 = var5;
               client.field479 = var6;
               client.field400 = 2;
               client.field305 = 0;
               client.field296 = var0;
               client.field319 = var1;
               client.field329.method2686(106);
               client.field329.method2440(var3 >> 14 & 32767);
               client.field329.method2564(class98.field1683 + var0);
               client.field329.method2477(class136.field2121[82]?1:0);
               client.field329.method2564(class92.field1598 + var1);
            }

            if(10 == var2) {
               var12 = client.field324[var3];
               if(var12 != null) {
                  client.field397 = var5;
                  client.field479 = var6;
                  client.field400 = 2;
                  client.field305 = 0;
                  client.field296 = var0;
                  client.field319 = var1;
                  client.field329.method2686(202);
                  client.field329.method2476(class136.field2121[82]?1:0);
                  client.field329.method2440(var3);
               }
            }

            if(client.field301 != 0) {
               client.field301 = 0;
               class114.method2400(class31.method698(class47.field1074));
            }

            if(client.field408) {
               class12.method152();
            }

            if(null != class8.field141 && 0 == client.field338) {
               class114.method2400(class8.field141);
            }

         }
      }
   }

   @ObfuscatedName("cb")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-77"
   )
   static void method1864() {
      for(class3 var0 = (class3)client.field449.method3748(); var0 != null; var0 = (class3)client.field449.method3747()) {
         int var1 = var0.field66;
         if(class149.method3102(var1)) {
            boolean var2 = true;
            class172[] var3 = class172.field2757[var1];

            int var4;
            for(var4 = 0; var4 < var3.length; ++var4) {
               if(var3[var4] != null) {
                  var2 = var3[var4].field2758;
                  break;
               }
            }

            if(!var2) {
               var4 = (int)var0.field3112;
               class172 var5 = class31.method698(var4);
               if(null != var5) {
                  class114.method2400(var5);
               }
            }
         }
      }

   }

   @ObfuscatedName("dc")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1558849917"
   )
   static final void method1865(String var0) {
      if(null != var0) {
         String var1 = class134.method2803(var0, client.field473);
         if(var1 != null) {
            for(int var2 = 0; var2 < client.field559; ++var2) {
               class7 var3 = client.field560[var2];
               String var4 = var3.field139;
               String var5 = class134.method2803(var4, client.field473);
               boolean var6;
               if(null != var0 && var4 != null) {
                  if(!var0.startsWith("#") && !var4.startsWith("#")) {
                     var6 = var1.equals(var5);
                  } else {
                     var6 = var0.equals(var4);
                  }
               } else {
                  var6 = false;
               }

               if(var6) {
                  --client.field559;

                  for(int var7 = var2; var7 < client.field559; ++var7) {
                     client.field560[var7] = client.field560[1 + var7];
                  }

                  client.field481 = client.field392;
                  client.field329.method2686(223);
                  client.field329.method2438(class36.method742(var0));
                  client.field329.method2444(var0);
                  break;
               }
            }

         }
      }
   }

   @ObfuscatedName("i")
   public static boolean method1866(int var0) {
      return (var0 >> 29 & 1) != 0;
   }

   @ObfuscatedName("h")
   static class25 method1867() {
      return class25.field634 < class25.field633?class25.field632[++class25.field634 - 1]:null;
   }

   @ObfuscatedName("dv")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "532347191"
   )
   static final void method1868() {
      client.field329.method2686(166);

      for(class3 var0 = (class3)client.field449.method3748(); var0 != null; var0 = (class3)client.field449.method3747()) {
         if(var0.field61 == 0 || var0.field61 == 3) {
            class4.method39(var0, true);
         }
      }

      if(null != client.field452) {
         class114.method2400(client.field452);
         client.field452 = null;
      }

   }
}
