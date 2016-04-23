import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("h")
public class class1 {
   @ObfuscatedName("u")
   static class80 field21;
   @ObfuscatedName("dr")
   @ObfuscatedGetter(
      intValue = 130000359
   )
   static int field30;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "56086450"
   )
   public static boolean method6(char var0) {
      return var0 >= 65 && var0 <= 90 || var0 >= 97 && var0 <= 122;
   }

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;Ljava/lang/String;IIB)V",
      garbageValue = "-82"
   )
   static final void method7(int var0, int var1, int var2, int var3, String var4, String var5, int var6, int var7) {
      if(var2 >= 2000) {
         var2 -= 2000;
      }

      class173 var8;
      int var9;
      if(var2 == 29) {
         client.field318.method2735(57);
         client.field318.method2488(var1);
         var8 = class141.method2959(var1);
         if(var8.field2856 != null && 5 == var8.field2856[0][0]) {
            var9 = var8.field2856[0][1];
            if(var8.field2869[0] != class176.field2900[var9]) {
               class176.field2900[var9] = var8.field2869[0];
               class48.method989(var9);
            }
         }
      }

      class34 var15;
      if(8 == var2) {
         var15 = client.field517[var3];
         if(null != var15) {
            client.field383 = var6;
            client.field384 = var7;
            client.field386 = 2;
            client.field542 = 0;
            client.field507 = var0;
            client.field508 = var1;
            client.field318.method2735(160);
            client.field318.method2533(var3);
            client.field318.method2642(client.field429);
            client.field318.method2503(class137.field2095[82]?1:0);
            client.field318.method2488(class10.field167);
         }
      }

      if(1005 == var2) {
         var8 = class141.method2959(var1);
         if(var8 != null && var8.field2863[var0] >= 100000) {
            class8.method109(27, "", var8.field2863[var0] + " x " + class89.method2081(var3).field1095);
         } else {
            client.field318.method2735(232);
            client.field318.method2486(var3);
         }

         client.field387 = 0;
         class15.field217 = class141.method2959(var1);
         client.field388 = var0;
      }

      if(var2 == 24) {
         var8 = class141.method2959(var1);
         boolean var16 = true;
         if(var8.field2748 > 0) {
            var16 = class11.method155(var8);
         }

         if(var16) {
            client.field318.method2735(57);
            client.field318.method2488(var1);
         }
      }

      if(var2 == 57 || var2 == 1007) {
         var8 = class46.method972(var1, var0);
         if(var8 != null) {
            var9 = var8.field2773;
            class173 var10 = class46.method972(var1, var0);
            if(var10 != null) {
               if(var10.field2844 != null) {
                  class0 var11 = new class0();
                  var11.field18 = var10;
                  var11.field5 = var3;
                  var11.field10 = var5;
                  var11.field16 = var10.field2844;
                  class37.method749(var11);
               }

               boolean var20 = true;
               if(var10.field2748 > 0) {
                  var20 = class11.method155(var10);
               }

               if(var20) {
                  int var13 = class144.method3075(var10);
                  int var14 = var3 - 1;
                  boolean var12 = 0 != (var13 >> 1 + var14 & 1);
                  if(var12) {
                     if(1 == var3) {
                        client.field318.method2735(36);
                        client.field318.method2488(var1);
                        client.field318.method2486(var0);
                        client.field318.method2486(var9);
                     }

                     if(var3 == 2) {
                        client.field318.method2735(41);
                        client.field318.method2488(var1);
                        client.field318.method2486(var0);
                        client.field318.method2486(var9);
                     }

                     if(var3 == 3) {
                        client.field318.method2735(44);
                        client.field318.method2488(var1);
                        client.field318.method2486(var0);
                        client.field318.method2486(var9);
                     }

                     if(var3 == 4) {
                        client.field318.method2735(190);
                        client.field318.method2488(var1);
                        client.field318.method2486(var0);
                        client.field318.method2486(var9);
                     }

                     if(5 == var3) {
                        client.field318.method2735(92);
                        client.field318.method2488(var1);
                        client.field318.method2486(var0);
                        client.field318.method2486(var9);
                     }

                     if(var3 == 6) {
                        client.field318.method2735(161);
                        client.field318.method2488(var1);
                        client.field318.method2486(var0);
                        client.field318.method2486(var9);
                     }

                     if(7 == var3) {
                        client.field318.method2735(60);
                        client.field318.method2488(var1);
                        client.field318.method2486(var0);
                        client.field318.method2486(var9);
                     }

                     if(var3 == 8) {
                        client.field318.method2735(66);
                        client.field318.method2488(var1);
                        client.field318.method2486(var0);
                        client.field318.method2486(var9);
                     }

                     if(var3 == 9) {
                        client.field318.method2735(154);
                        client.field318.method2488(var1);
                        client.field318.method2486(var0);
                        client.field318.method2486(var9);
                     }

                     if(10 == var3) {
                        client.field318.method2735(55);
                        client.field318.method2488(var1);
                        client.field318.method2486(var0);
                        client.field318.method2486(var9);
                     }
                  }
               }
            }
         }
      }

      class2 var17;
      if(var2 == 49) {
         var17 = client.field396[var3];
         if(var17 != null) {
            client.field383 = var6;
            client.field384 = var7;
            client.field386 = 2;
            client.field542 = 0;
            client.field507 = var0;
            client.field508 = var1;
            client.field318.method2735(19);
            client.field318.method2533(var3);
            client.field318.method2523(class137.field2095[82]?1:0);
         }
      }

      if(var2 == 47) {
         var17 = client.field396[var3];
         if(null != var17) {
            client.field383 = var6;
            client.field384 = var7;
            client.field386 = 2;
            client.field542 = 0;
            client.field507 = var0;
            client.field508 = var1;
            client.field318.method2735(80);
            client.field318.method2486(var3);
            client.field318.method2597(class137.field2095[82]?1:0);
         }
      }

      if(58 == var2) {
         var8 = class46.method972(var1, var0);
         if(null != var8) {
            client.field318.method2735(224);
            client.field318.method2488(class10.field167);
            client.field318.method2642(client.field430);
            client.field318.method2642(var0);
            client.field318.method2642(client.field429);
            client.field318.method2533(var8.field2773);
            client.field318.method2541(var1);
         }
      }

      if(var2 == 36) {
         client.field318.method2735(173);
         client.field318.method2542(var1);
         client.field318.method2603(var3);
         client.field318.method2603(var0);
         client.field387 = 0;
         class15.field217 = class141.method2959(var1);
         client.field388 = var0;
      }

      if(var2 == 20) {
         client.field383 = var6;
         client.field384 = var7;
         client.field386 = 2;
         client.field542 = 0;
         client.field507 = var0;
         client.field508 = var1;
         client.field318.method2735(94);
         client.field318.method2603(class0.field12 + var1);
         client.field318.method2533(class187.field3014 + var0);
         client.field318.method2603(var3);
         client.field318.method2503(class137.field2095[82]?1:0);
      }

      if(var2 == 1004) {
         client.field383 = var6;
         client.field384 = var7;
         client.field386 = 2;
         client.field542 = 0;
         client.field318.method2735(232);
         client.field318.method2486(var3);
      }

      if(var2 == 10) {
         var15 = client.field517[var3];
         if(null != var15) {
            client.field383 = var6;
            client.field384 = var7;
            client.field386 = 2;
            client.field542 = 0;
            client.field507 = var0;
            client.field508 = var1;
            client.field318.method2735(237);
            client.field318.method2486(var3);
            client.field318.method2597(class137.field2095[82]?1:0);
         }
      }

      if(9 == var2) {
         var15 = client.field517[var3];
         if(null != var15) {
            client.field383 = var6;
            client.field384 = var7;
            client.field386 = 2;
            client.field542 = 0;
            client.field507 = var0;
            client.field508 = var1;
            client.field318.method2735(205);
            client.field318.method2601(class137.field2095[82]?1:0);
            client.field318.method2603(var3);
         }
      }

      if(46 == var2) {
         var17 = client.field396[var3];
         if(null != var17) {
            client.field383 = var6;
            client.field384 = var7;
            client.field386 = 2;
            client.field542 = 0;
            client.field507 = var0;
            client.field508 = var1;
            client.field318.method2735(96);
            client.field318.method2486(var3);
            client.field318.method2601(class137.field2095[82]?1:0);
         }
      }

      if(var2 == 13) {
         var15 = client.field517[var3];
         if(null != var15) {
            client.field383 = var6;
            client.field384 = var7;
            client.field386 = 2;
            client.field542 = 0;
            client.field507 = var0;
            client.field508 = var1;
            client.field318.method2735(145);
            client.field318.method2533(var3);
            client.field318.method2597(class137.field2095[82]?1:0);
         }
      }

      if(25 != var2) {
         if(var2 == 41) {
            client.field318.method2735(99);
            client.field318.method2541(var1);
            client.field318.method2533(var3);
            client.field318.method2642(var0);
            client.field387 = 0;
            class15.field217 = class141.method2959(var1);
            client.field388 = var0;
         }

         if(var2 == 30 && null == client.field437) {
            class19.method238(var1, var0);
            client.field437 = class46.method972(var1, var0);
            class2.method28(client.field437);
         }

         if(5 == var2) {
            client.field383 = var6;
            client.field384 = var7;
            client.field386 = 2;
            client.field542 = 0;
            client.field507 = var0;
            client.field508 = var1;
            client.field318.method2735(91);
            client.field318.method2603(var3 >> 14 & 32767);
            client.field318.method2503(class137.field2095[82]?1:0);
            client.field318.method2603(var1 + class0.field12);
            client.field318.method2533(var0 + class187.field3014);
         }

         if(50 == var2) {
            var17 = client.field396[var3];
            if(var17 != null) {
               client.field383 = var6;
               client.field384 = var7;
               client.field386 = 2;
               client.field542 = 0;
               client.field507 = var0;
               client.field508 = var1;
               client.field318.method2735(3);
               client.field318.method2601(class137.field2095[82]?1:0);
               client.field318.method2486(var3);
            }
         }

         if(var2 == 22) {
            client.field383 = var6;
            client.field384 = var7;
            client.field386 = 2;
            client.field542 = 0;
            client.field507 = var0;
            client.field508 = var1;
            client.field318.method2735(124);
            client.field318.method2533(class0.field12 + var1);
            client.field318.method2523(class137.field2095[82]?1:0);
            client.field318.method2486(var3);
            client.field318.method2533(class187.field3014 + var0);
         }

         if(var2 == 1003) {
            client.field383 = var6;
            client.field384 = var7;
            client.field386 = 2;
            client.field542 = 0;
            var15 = client.field517[var3];
            if(var15 != null) {
               class39 var19 = var15.field761;
               if(null != var19.field892) {
                  var19 = var19.method759();
               }

               if(var19 != null) {
                  client.field318.method2735(221);
                  client.field318.method2533(var19.field898);
               }
            }
         }

         if(var2 == 43) {
            client.field318.method2735(157);
            client.field318.method2533(var0);
            client.field318.method2533(var3);
            client.field318.method2542(var1);
            client.field387 = 0;
            class15.field217 = class141.method2959(var1);
            client.field388 = var0;
         }

         if(31 == var2) {
            client.field318.method2735(199);
            client.field318.method2642(class77.field1375);
            client.field318.method2642(class15.field214);
            client.field318.method2542(class109.field1894);
            client.field318.method2541(var1);
            client.field318.method2603(var3);
            client.field318.method2603(var0);
            client.field387 = 0;
            class15.field217 = class141.method2959(var1);
            client.field388 = var0;
         }

         if(var2 == 18) {
            client.field383 = var6;
            client.field384 = var7;
            client.field386 = 2;
            client.field542 = 0;
            client.field507 = var0;
            client.field508 = var1;
            client.field318.method2735(118);
            client.field318.method2533(var3);
            client.field318.method2533(var0 + class187.field3014);
            client.field318.method2603(class0.field12 + var1);
            client.field318.method2597(class137.field2095[82]?1:0);
         }

         if(var2 == 7) {
            var15 = client.field517[var3];
            if(null != var15) {
               client.field383 = var6;
               client.field384 = var7;
               client.field386 = 2;
               client.field542 = 0;
               client.field507 = var0;
               client.field508 = var1;
               client.field318.method2735(165);
               client.field318.method2533(class15.field214);
               client.field318.method2523(class137.field2095[82]?1:0);
               client.field318.method2533(class77.field1375);
               client.field318.method2603(var3);
               client.field318.method2541(class109.field1894);
            }
         }

         if(39 == var2) {
            client.field318.method2735(134);
            client.field318.method2486(var0);
            client.field318.method2540(var1);
            client.field318.method2486(var3);
            client.field387 = 0;
            class15.field217 = class141.method2959(var1);
            client.field388 = var0;
         }

         if(var2 == 34) {
            client.field318.method2735(47);
            client.field318.method2642(var3);
            client.field318.method2603(var0);
            client.field318.method2541(var1);
            client.field387 = 0;
            class15.field217 = class141.method2959(var1);
            client.field388 = var0;
         }

         if(var2 == 45) {
            var17 = client.field396[var3];
            if(null != var17) {
               client.field383 = var6;
               client.field384 = var7;
               client.field386 = 2;
               client.field542 = 0;
               client.field507 = var0;
               client.field508 = var1;
               client.field318.method2735(49);
               client.field318.method2523(class137.field2095[82]?1:0);
               client.field318.method2533(var3);
            }
         }

         if(var2 == 44) {
            var17 = client.field396[var3];
            if(var17 != null) {
               client.field383 = var6;
               client.field384 = var7;
               client.field386 = 2;
               client.field542 = 0;
               client.field507 = var0;
               client.field508 = var1;
               client.field318.method2735(202);
               client.field318.method2642(var3);
               client.field318.method2601(class137.field2095[82]?1:0);
            }
         }

         if(15 == var2) {
            var17 = client.field396[var3];
            if(null != var17) {
               client.field383 = var6;
               client.field384 = var7;
               client.field386 = 2;
               client.field542 = 0;
               client.field507 = var0;
               client.field508 = var1;
               client.field318.method2735(73);
               client.field318.method2503(class137.field2095[82]?1:0);
               client.field318.method2603(var3);
               client.field318.method2486(client.field429);
               client.field318.method2488(class10.field167);
            }
         }

         if(6 == var2) {
            client.field383 = var6;
            client.field384 = var7;
            client.field386 = 2;
            client.field542 = 0;
            client.field507 = var0;
            client.field508 = var1;
            client.field318.method2735(148);
            client.field318.method2603(var3 >> 14 & 32767);
            client.field318.method2523(class137.field2095[82]?1:0);
            client.field318.method2533(class0.field12 + var1);
            client.field318.method2642(var0 + class187.field3014);
         }

         if(26 == var2) {
            class136.method2873();
         }

         if(17 == var2) {
            client.field383 = var6;
            client.field384 = var7;
            client.field386 = 2;
            client.field542 = 0;
            client.field507 = var0;
            client.field508 = var1;
            client.field318.method2735(226);
            client.field318.method2642(class187.field3014 + var0);
            client.field318.method2486(var3);
            client.field318.method2486(var1 + class0.field12);
            client.field318.method2523(class137.field2095[82]?1:0);
            client.field318.method2486(client.field429);
            client.field318.method2540(class10.field167);
         }

         if(var2 == 32) {
            client.field318.method2735(174);
            client.field318.method2603(var3);
            client.field318.method2533(var0);
            client.field318.method2542(class10.field167);
            client.field318.method2533(client.field429);
            client.field318.method2541(var1);
            client.field387 = 0;
            class15.field217 = class141.method2959(var1);
            client.field388 = var0;
         }

         if(var2 == 11) {
            var15 = client.field517[var3];
            if(var15 != null) {
               client.field383 = var6;
               client.field384 = var7;
               client.field386 = 2;
               client.field542 = 0;
               client.field507 = var0;
               client.field508 = var1;
               client.field318.method2735(146);
               client.field318.method2486(var3);
               client.field318.method2503(class137.field2095[82]?1:0);
            }
         }

         if(3 == var2) {
            client.field383 = var6;
            client.field384 = var7;
            client.field386 = 2;
            client.field542 = 0;
            client.field507 = var0;
            client.field508 = var1;
            client.field318.method2735(207);
            client.field318.method2597(class137.field2095[82]?1:0);
            client.field318.method2642(class0.field12 + var1);
            client.field318.method2642(var3 >> 14 & 32767);
            client.field318.method2486(var0 + class187.field3014);
         }

         if(28 == var2) {
            client.field318.method2735(57);
            client.field318.method2488(var1);
            var8 = class141.method2959(var1);
            if(null != var8.field2856 && var8.field2856[0][0] == 5) {
               var9 = var8.field2856[0][1];
               class176.field2900[var9] = 1 - class176.field2900[var9];
               class48.method989(var9);
            }
         }

         if(var2 == 1002) {
            client.field383 = var6;
            client.field384 = var7;
            client.field386 = 2;
            client.field542 = 0;
            client.field318.method2735(176);
            client.field318.method2486(var3 >> 14 & 32767);
         }

         if(21 == var2) {
            client.field383 = var6;
            client.field384 = var7;
            client.field386 = 2;
            client.field542 = 0;
            client.field507 = var0;
            client.field508 = var1;
            client.field318.method2735(110);
            client.field318.method2533(class0.field12 + var1);
            client.field318.method2523(class137.field2095[82]?1:0);
            client.field318.method2642(var3);
            client.field318.method2603(class187.field3014 + var0);
         }

         if(1001 == var2) {
            client.field383 = var6;
            client.field384 = var7;
            client.field386 = 2;
            client.field542 = 0;
            client.field507 = var0;
            client.field508 = var1;
            client.field318.method2735(86);
            client.field318.method2486(var3 >> 14 & 32767);
            client.field318.method2486(class187.field3014 + var0);
            client.field318.method2486(class0.field12 + var1);
            client.field318.method2523(class137.field2095[82]?1:0);
         }

         if(var2 == 2) {
            client.field383 = var6;
            client.field384 = var7;
            client.field386 = 2;
            client.field542 = 0;
            client.field507 = var0;
            client.field508 = var1;
            client.field318.method2735(50);
            client.field318.method2533(client.field429);
            client.field318.method2503(class137.field2095[82]?1:0);
            client.field318.method2486(class187.field3014 + var0);
            client.field318.method2486(class0.field12 + var1);
            client.field318.method2540(class10.field167);
            client.field318.method2642(var3 >> 14 & 32767);
         }

         if(var2 == 33) {
            client.field318.method2735(251);
            client.field318.method2488(var1);
            client.field318.method2533(var0);
            client.field318.method2486(var3);
            client.field387 = 0;
            class15.field217 = class141.method2959(var1);
            client.field388 = var0;
         }

         if(1 == var2) {
            client.field383 = var6;
            client.field384 = var7;
            client.field386 = 2;
            client.field542 = 0;
            client.field507 = var0;
            client.field508 = var1;
            client.field318.method2735(34);
            client.field318.method2603(var1 + class0.field12);
            client.field318.method2642(class187.field3014 + var0);
            client.field318.method2541(class109.field1894);
            client.field318.method2603(var3 >> 14 & 32767);
            client.field318.method2486(class77.field1375);
            client.field318.method2503(class137.field2095[82]?1:0);
            client.field318.method2642(class15.field214);
         }

         if(51 == var2) {
            var17 = client.field396[var3];
            if(null != var17) {
               client.field383 = var6;
               client.field384 = var7;
               client.field386 = 2;
               client.field542 = 0;
               client.field507 = var0;
               client.field508 = var1;
               client.field318.method2735(68);
               client.field318.method2601(class137.field2095[82]?1:0);
               client.field318.method2642(var3);
            }
         }

         if(23 == var2) {
            class35.field771.method1942(class28.field655, var0, var1);
         }

         if(var2 == 16) {
            client.field383 = var6;
            client.field384 = var7;
            client.field386 = 2;
            client.field542 = 0;
            client.field507 = var0;
            client.field508 = var1;
            client.field318.method2735(107);
            client.field318.method2642(class187.field3014 + var0);
            client.field318.method2603(class77.field1375);
            client.field318.method2542(class109.field1894);
            client.field318.method2533(var1 + class0.field12);
            client.field318.method2533(var3);
            client.field318.method2597(class137.field2095[82]?1:0);
            client.field318.method2533(class15.field214);
         }

         if(42 == var2) {
            client.field318.method2735(13);
            client.field318.method2540(var1);
            client.field318.method2486(var3);
            client.field318.method2642(var0);
            client.field387 = 0;
            class15.field217 = class141.method2959(var1);
            client.field388 = var0;
         }

         if(var2 == 4) {
            client.field383 = var6;
            client.field384 = var7;
            client.field386 = 2;
            client.field542 = 0;
            client.field507 = var0;
            client.field508 = var1;
            client.field318.method2735(188);
            client.field318.method2486(var3 >> 14 & 32767);
            client.field318.method2533(class187.field3014 + var0);
            client.field318.method2601(class137.field2095[82]?1:0);
            client.field318.method2486(var1 + class0.field12);
         }

         if(37 == var2) {
            client.field318.method2735(140);
            client.field318.method2533(var0);
            client.field318.method2541(var1);
            client.field318.method2642(var3);
            client.field387 = 0;
            class15.field217 = class141.method2959(var1);
            client.field388 = var0;
         }

         if(var2 == 14) {
            var17 = client.field396[var3];
            if(var17 != null) {
               client.field383 = var6;
               client.field384 = var7;
               client.field386 = 2;
               client.field542 = 0;
               client.field507 = var0;
               client.field508 = var1;
               client.field318.method2735(233);
               client.field318.method2533(var3);
               client.field318.method2642(class15.field214);
               client.field318.method2542(class109.field1894);
               client.field318.method2503(class137.field2095[82]?1:0);
               client.field318.method2603(class77.field1375);
            }
         }

         if(12 == var2) {
            var15 = client.field517[var3];
            if(var15 != null) {
               client.field383 = var6;
               client.field384 = var7;
               client.field386 = 2;
               client.field542 = 0;
               client.field507 = var0;
               client.field508 = var1;
               client.field318.method2735(141);
               client.field318.method2533(var3);
               client.field318.method2597(class137.field2095[82]?1:0);
            }
         }

         if(48 == var2) {
            var17 = client.field396[var3];
            if(var17 != null) {
               client.field383 = var6;
               client.field384 = var7;
               client.field386 = 2;
               client.field542 = 0;
               client.field507 = var0;
               client.field508 = var1;
               client.field318.method2735(117);
               client.field318.method2597(class137.field2095[82]?1:0);
               client.field318.method2642(var3);
            }
         }

         if(var2 == 40) {
            client.field318.method2735(180);
            client.field318.method2542(var1);
            client.field318.method2486(var0);
            client.field318.method2603(var3);
            client.field387 = 0;
            class15.field217 = class141.method2959(var1);
            client.field388 = var0;
         }

         if(var2 == 35) {
            client.field318.method2735(149);
            client.field318.method2540(var1);
            client.field318.method2533(var0);
            client.field318.method2533(var3);
            client.field387 = 0;
            class15.field217 = class141.method2959(var1);
            client.field388 = var0;
         }

         if(var2 == 38) {
            class121.method2732();
            var8 = class141.method2959(var1);
            client.field280 = 1;
            class15.field214 = var0;
            class109.field1894 = var1;
            class77.field1375 = var3;
            class2.method28(var8);
            client.field427 = class219.method3968(16748608) + class89.method2081(var3).field1095 + class219.method3968(16777215);
            if(client.field427 == null) {
               client.field427 = "null";
            }

         } else {
            if(19 == var2) {
               client.field383 = var6;
               client.field384 = var7;
               client.field386 = 2;
               client.field542 = 0;
               client.field507 = var0;
               client.field508 = var1;
               client.field318.method2735(54);
               client.field318.method2523(class137.field2095[82]?1:0);
               client.field318.method2642(var1 + class0.field12);
               client.field318.method2486(var3);
               client.field318.method2486(class187.field3014 + var0);
            }

            if(client.field280 != 0) {
               client.field280 = 0;
               class2.method28(class141.method2959(class109.field1894));
            }

            if(client.field511) {
               class121.method2732();
            }

            if(null != class15.field217 && 0 == client.field387) {
               class2.method28(class15.field217);
            }

         }
      } else {
         var8 = class46.method972(var1, var0);
         if(null != var8) {
            class121.method2732();
            var9 = class159.method3139(class144.method3075(var8));
            int var18 = var8.field2773;
            class173 var21 = class46.method972(var1, var0);
            if(null != var21 && var21.field2865 != null) {
               class0 var22 = new class0();
               var22.field18 = var21;
               var22.field16 = var21.field2865;
               class37.method749(var22);
            }

            client.field430 = var18;
            client.field511 = true;
            class10.field167 = var1;
            client.field429 = var0;
            class11.field174 = var9;
            class2.method28(var21);
            client.field280 = 0;
            String var23;
            if(class159.method3139(class144.method3075(var8)) == 0) {
               var23 = null;
            } else if(null != var8.field2823 && var8.field2823.trim().length() != 0) {
               var23 = var8.field2823;
            } else {
               var23 = null;
            }

            client.field362 = var23;
            if(null == client.field362) {
               client.field362 = "Null";
            }

            if(var8.field2768) {
               client.field313 = var8.field2817 + class219.method3968(16777215);
            } else {
               client.field313 = class219.method3968('\uff00') + var8.field2860 + class219.method3968(16777215);
            }
         }

      }
   }
}
