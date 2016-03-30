import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ff")
public final class class163 {
   @ObfuscatedName("t")
   static void method3262(class168 var0, int var1) {
      if(null != class10.field181) {
         class10.field181.field2011 = 5 + var1 * 8;
         int var2 = class10.field181.method2511();
         int var3 = class10.field181.method2511();
         var0.method3364(var2, var3);
      } else {
         class162.method3223((class168)null, 255, 255, 0, (byte)0, true);
         class171.field2747[var1] = var0;
      }
   }

   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;Ljava/lang/String;III)V",
      garbageValue = "634034174"
   )
   static final void method3263(int var0, int var1, int var2, int var3, String var4, int var5, int var6) {
      if(var2 >= 2000) {
         var2 -= 2000;
      }

      class173 var7;
      int var8;
      if(var2 == 25) {
         var7 = class157.method3195(var1, var0);
         if(null != var7) {
            class188.method3761();
            int var17 = class169.method3395(var7);
            var8 = var17 >> 11 & 63;
            int var20 = var7.field2883;
            class173 var21 = class157.method3195(var1, var0);
            if(null != var21 && null != var21.field2858) {
               class0 var22 = new class0();
               var22.field2 = var21;
               var22.field7 = var21.field2858;
               class3.method48(var22);
            }

            client.field451 = var20;
            client.field573 = true;
            client.field449 = var1;
            client.field442 = var0;
            class1.field20 = var8;
            class134.method2877(var21);
            client.field381 = 0;
            client.field315 = class10.method134(var7);
            if(client.field315 == null) {
               client.field315 = "Null";
            }

            if(var7.field2766) {
               client.field453 = var7.field2870 + class72.method1574(16777215);
            } else {
               client.field453 = class72.method1574('\uff00') + var7.field2818 + class72.method1574(16777215);
            }
         }

      } else {
         if(16 == var2) {
            client.field402 = var5;
            client.field403 = var6;
            client.field405 = 2;
            client.field438 = 0;
            client.field533 = var0;
            client.field529 = var1;
            client.field318.method2757(210);
            client.field318.method2540(class2.field37 + var1);
            client.field318.method2492(class6.field137);
            client.field318.method2538(var3);
            client.field318.method2538(class59.field1224);
            client.field318.method2618(class137.field2135[82]?1:0);
            client.field318.method2620(class41.field980);
            client.field318.method2538(class41.field990 + var0);
         }

         if(var2 == 57 || 1007 == var2) {
            var7 = class157.method3195(var1, var0);
            if(null != var7) {
               var8 = var7.field2883;
               class173 var9 = class157.method3195(var1, var0);
               if(var9 != null) {
                  if(var9.field2867 != null) {
                     class0 var10 = new class0();
                     var10.field2 = var9;
                     var10.field5 = var3;
                     var10.field9 = var4;
                     var10.field7 = var9.field2867;
                     class3.method48(var10);
                  }

                  boolean var19 = true;
                  if(var9.field2890 > 0) {
                     var19 = class124.method2788(var9);
                  }

                  if(var19) {
                     int var12 = class169.method3395(var9);
                     int var13 = var3 - 1;
                     boolean var11 = (var12 >> 1 + var13 & 1) != 0;
                     if(var11) {
                        if(1 == var3) {
                           client.field318.method2757(181);
                           client.field318.method2494(var1);
                           client.field318.method2492(var0);
                           client.field318.method2492(var8);
                        }

                        if(2 == var3) {
                           client.field318.method2757(175);
                           client.field318.method2494(var1);
                           client.field318.method2492(var0);
                           client.field318.method2492(var8);
                        }

                        if(var3 == 3) {
                           client.field318.method2757(103);
                           client.field318.method2494(var1);
                           client.field318.method2492(var0);
                           client.field318.method2492(var8);
                        }

                        if(var3 == 4) {
                           client.field318.method2757(105);
                           client.field318.method2494(var1);
                           client.field318.method2492(var0);
                           client.field318.method2492(var8);
                        }

                        if(var3 == 5) {
                           client.field318.method2757(12);
                           client.field318.method2494(var1);
                           client.field318.method2492(var0);
                           client.field318.method2492(var8);
                        }

                        if(var3 == 6) {
                           client.field318.method2757(28);
                           client.field318.method2494(var1);
                           client.field318.method2492(var0);
                           client.field318.method2492(var8);
                        }

                        if(7 == var3) {
                           client.field318.method2757(42);
                           client.field318.method2494(var1);
                           client.field318.method2492(var0);
                           client.field318.method2492(var8);
                        }

                        if(8 == var3) {
                           client.field318.method2757(137);
                           client.field318.method2494(var1);
                           client.field318.method2492(var0);
                           client.field318.method2492(var8);
                        }

                        if(var3 == 9) {
                           client.field318.method2757(62);
                           client.field318.method2494(var1);
                           client.field318.method2492(var0);
                           client.field318.method2492(var8);
                        }

                        if(10 == var3) {
                           client.field318.method2757(120);
                           client.field318.method2494(var1);
                           client.field318.method2492(var0);
                           client.field318.method2492(var8);
                        }
                     }
                  }
               }
            }
         }

         if(2 == var2) {
            client.field402 = var5;
            client.field403 = var6;
            client.field405 = 2;
            client.field438 = 0;
            client.field533 = var0;
            client.field529 = var1;
            client.field318.method2757(168);
            client.field318.method2540(var0 + class41.field990);
            client.field318.method2538(var3 >> 14 & 32767);
            client.field318.method2494(client.field449);
            client.field318.method2540(class2.field37 + var1);
            client.field318.method2540(client.field442);
            client.field318.method2618(class137.field2135[82]?1:0);
         }

         if(var2 == 33) {
            client.field318.method2757(70);
            client.field318.method2538(var0);
            client.field318.method2539(var3);
            client.field318.method2610(var1);
            client.field494 = 0;
            class52.field1167 = class52.method1115(var1);
            client.field407 = var0;
         }

         if(var2 == 43) {
            client.field318.method2757(88);
            client.field318.method2610(var1);
            client.field318.method2540(var3);
            client.field318.method2492(var0);
            client.field494 = 0;
            class52.field1167 = class52.method1115(var1);
            client.field407 = var0;
         }

         if(29 == var2) {
            client.field318.method2757(118);
            client.field318.method2494(var1);
            var7 = class52.method1115(var1);
            if(null != var7.field2879 && var7.field2879[0][0] == 5) {
               var8 = var7.field2879[0][1];
               if(class176.field2916[var8] != var7.field2881[0]) {
                  class176.field2916[var8] = var7.field2881[0];
                  class95.method2184(var8);
               }
            }
         }

         class34 var14;
         if(var2 == 10) {
            var14 = client.field331[var3];
            if(var14 != null) {
               client.field402 = var5;
               client.field403 = var6;
               client.field405 = 2;
               client.field438 = 0;
               client.field533 = var0;
               client.field529 = var1;
               client.field318.method2757(188);
               client.field318.method2540(var3);
               client.field318.method2618(class137.field2135[82]?1:0);
            }
         }

         if(19 == var2) {
            client.field402 = var5;
            client.field403 = var6;
            client.field405 = 2;
            client.field438 = 0;
            client.field533 = var0;
            client.field529 = var1;
            client.field318.method2757(145);
            client.field318.method2492(var1 + class2.field37);
            client.field318.method2530(class137.field2135[82]?1:0);
            client.field318.method2492(var3);
            client.field318.method2492(var0 + class41.field990);
         }

         if(1002 == var2) {
            client.field402 = var5;
            client.field403 = var6;
            client.field405 = 2;
            client.field438 = 0;
            client.field318.method2757(20);
            client.field318.method2540(var3 >> 14 & 32767);
         }

         if(var2 == 58) {
            var7 = class157.method3195(var1, var0);
            if(var7 != null) {
               client.field318.method2757(198);
               client.field318.method2549(client.field449);
               client.field318.method2538(var7.field2883);
               client.field318.method2620(var1);
               client.field318.method2539(var0);
               client.field318.method2492(client.field451);
               client.field318.method2540(client.field442);
            }
         }

         if(42 == var2) {
            client.field318.method2757(178);
            client.field318.method2492(var3);
            client.field318.method2539(var0);
            client.field318.method2494(var1);
            client.field494 = 0;
            class52.field1167 = class52.method1115(var1);
            client.field407 = var0;
         }

         class2 var15;
         if(48 == var2) {
            var15 = client.field415[var3];
            if(null != var15) {
               client.field402 = var5;
               client.field403 = var6;
               client.field405 = 2;
               client.field438 = 0;
               client.field533 = var0;
               client.field529 = var1;
               client.field318.method2757(187);
               client.field318.method2530(class137.field2135[82]?1:0);
               client.field318.method2538(var3);
            }
         }

         if(var2 == 32) {
            client.field318.method2757(107);
            client.field318.method2494(client.field449);
            client.field318.method2540(client.field442);
            client.field318.method2610(var1);
            client.field318.method2540(var3);
            client.field318.method2540(var0);
            client.field494 = 0;
            class52.field1167 = class52.method1115(var1);
            client.field407 = var0;
         }

         if(1003 == var2) {
            client.field402 = var5;
            client.field403 = var6;
            client.field405 = 2;
            client.field438 = 0;
            var14 = client.field331[var3];
            if(null != var14) {
               class39 var16 = var14.field781;
               if(var16.field915 != null) {
                  var16 = var16.method793();
               }

               if(var16 != null) {
                  client.field318.method2757(172);
                  client.field318.method2492(var16.field889);
               }
            }
         }

         if(1004 == var2) {
            client.field402 = var5;
            client.field403 = var6;
            client.field405 = 2;
            client.field438 = 0;
            client.field318.method2757(86);
            client.field318.method2492(var3);
         }

         if(var2 == 7) {
            var14 = client.field331[var3];
            if(null != var14) {
               client.field402 = var5;
               client.field403 = var6;
               client.field405 = 2;
               client.field438 = 0;
               client.field533 = var0;
               client.field529 = var1;
               client.field318.method2757(109);
               client.field318.method2539(var3);
               client.field318.method2539(class59.field1224);
               client.field318.method2573(class137.field2135[82]?1:0);
               client.field318.method2539(class6.field137);
               client.field318.method2549(class41.field980);
            }
         }

         if(11 == var2) {
            var14 = client.field331[var3];
            if(null != var14) {
               client.field402 = var5;
               client.field403 = var6;
               client.field405 = 2;
               client.field438 = 0;
               client.field533 = var0;
               client.field529 = var1;
               client.field318.method2757(128);
               client.field318.method2529(class137.field2135[82]?1:0);
               client.field318.method2539(var3);
            }
         }

         if(39 == var2) {
            client.field318.method2757(165);
            client.field318.method2610(var1);
            client.field318.method2540(var0);
            client.field318.method2492(var3);
            client.field494 = 0;
            class52.field1167 = class52.method1115(var1);
            client.field407 = var0;
         }

         if(47 == var2) {
            var15 = client.field415[var3];
            if(null != var15) {
               client.field402 = var5;
               client.field403 = var6;
               client.field405 = 2;
               client.field438 = 0;
               client.field533 = var0;
               client.field529 = var1;
               client.field318.method2757(36);
               client.field318.method2538(var3);
               client.field318.method2573(class137.field2135[82]?1:0);
            }
         }

         if(50 == var2) {
            var15 = client.field415[var3];
            if(null != var15) {
               client.field402 = var5;
               client.field403 = var6;
               client.field405 = 2;
               client.field438 = 0;
               client.field533 = var0;
               client.field529 = var1;
               client.field318.method2757(119);
               client.field318.method2573(class137.field2135[82]?1:0);
               client.field318.method2492(var3);
            }
         }

         if(var2 == 44) {
            var15 = client.field415[var3];
            if(var15 != null) {
               client.field402 = var5;
               client.field403 = var6;
               client.field405 = 2;
               client.field438 = 0;
               client.field533 = var0;
               client.field529 = var1;
               client.field318.method2757(77);
               client.field318.method2573(class137.field2135[82]?1:0);
               client.field318.method2492(var3);
            }
         }

         if(var2 == 37) {
            client.field318.method2757(56);
            client.field318.method2549(var1);
            client.field318.method2492(var3);
            client.field318.method2539(var0);
            client.field494 = 0;
            class52.field1167 = class52.method1115(var1);
            client.field407 = var0;
         }

         if(49 == var2) {
            var15 = client.field415[var3];
            if(null != var15) {
               client.field402 = var5;
               client.field403 = var6;
               client.field405 = 2;
               client.field438 = 0;
               client.field533 = var0;
               client.field529 = var1;
               client.field318.method2757(236);
               client.field318.method2618(class137.field2135[82]?1:0);
               client.field318.method2492(var3);
            }
         }

         if(var2 == 5) {
            client.field402 = var5;
            client.field403 = var6;
            client.field405 = 2;
            client.field438 = 0;
            client.field533 = var0;
            client.field529 = var1;
            client.field318.method2757(73);
            client.field318.method2538(class2.field37 + var1);
            client.field318.method2540(var3 >> 14 & 32767);
            client.field318.method2539(var0 + class41.field990);
            client.field318.method2573(class137.field2135[82]?1:0);
         }

         if(var2 == 20) {
            client.field402 = var5;
            client.field403 = var6;
            client.field405 = 2;
            client.field438 = 0;
            client.field533 = var0;
            client.field529 = var1;
            client.field318.method2757(63);
            client.field318.method2492(var0 + class41.field990);
            client.field318.method2529(class137.field2135[82]?1:0);
            client.field318.method2492(var3);
            client.field318.method2538(class2.field37 + var1);
         }

         if(8 == var2) {
            var14 = client.field331[var3];
            if(null != var14) {
               client.field402 = var5;
               client.field403 = var6;
               client.field405 = 2;
               client.field438 = 0;
               client.field533 = var0;
               client.field529 = var1;
               client.field318.method2757(191);
               client.field318.method2494(client.field449);
               client.field318.method2539(var3);
               client.field318.method2492(client.field442);
               client.field318.method2530(class137.field2135[82]?1:0);
            }
         }

         if(21 == var2) {
            client.field402 = var5;
            client.field403 = var6;
            client.field405 = 2;
            client.field438 = 0;
            client.field533 = var0;
            client.field529 = var1;
            client.field318.method2757(21);
            client.field318.method2618(class137.field2135[82]?1:0);
            client.field318.method2540(var1 + class2.field37);
            client.field318.method2539(var0 + class41.field990);
            client.field318.method2540(var3);
         }

         if(24 == var2) {
            var7 = class52.method1115(var1);
            boolean var18 = true;
            if(var7.field2890 > 0) {
               var18 = class124.method2788(var7);
            }

            if(var18) {
               client.field318.method2757(118);
               client.field318.method2494(var1);
            }
         }

         if(45 == var2) {
            var15 = client.field415[var3];
            if(null != var15) {
               client.field402 = var5;
               client.field403 = var6;
               client.field405 = 2;
               client.field438 = 0;
               client.field533 = var0;
               client.field529 = var1;
               client.field318.method2757(129);
               client.field318.method2618(class137.field2135[82]?1:0);
               client.field318.method2540(var3);
            }
         }

         if(var2 == 22) {
            client.field402 = var5;
            client.field403 = var6;
            client.field405 = 2;
            client.field438 = 0;
            client.field533 = var0;
            client.field529 = var1;
            client.field318.method2757(65);
            client.field318.method2540(var3);
            client.field318.method2492(class2.field37 + var1);
            client.field318.method2492(class41.field990 + var0);
            client.field318.method2530(class137.field2135[82]?1:0);
         }

         if(var2 == 15) {
            var15 = client.field415[var3];
            if(var15 != null) {
               client.field402 = var5;
               client.field403 = var6;
               client.field405 = 2;
               client.field438 = 0;
               client.field533 = var0;
               client.field529 = var1;
               client.field318.method2757(155);
               client.field318.method2540(var3);
               client.field318.method2620(client.field449);
               client.field318.method2530(class137.field2135[82]?1:0);
               client.field318.method2539(client.field442);
            }
         }

         if(var2 == 17) {
            client.field402 = var5;
            client.field403 = var6;
            client.field405 = 2;
            client.field438 = 0;
            client.field533 = var0;
            client.field529 = var1;
            client.field318.method2757(222);
            client.field318.method2530(class137.field2135[82]?1:0);
            client.field318.method2539(class41.field990 + var0);
            client.field318.method2538(var3);
            client.field318.method2540(client.field442);
            client.field318.method2610(client.field449);
            client.field318.method2538(var1 + class2.field37);
         }

         if(var2 == 28) {
            client.field318.method2757(118);
            client.field318.method2494(var1);
            var7 = class52.method1115(var1);
            if(var7.field2879 != null && 5 == var7.field2879[0][0]) {
               var8 = var7.field2879[0][1];
               class176.field2916[var8] = 1 - class176.field2916[var8];
               class95.method2184(var8);
            }
         }

         if(var2 == 18) {
            client.field402 = var5;
            client.field403 = var6;
            client.field405 = 2;
            client.field438 = 0;
            client.field533 = var0;
            client.field529 = var1;
            client.field318.method2757(215);
            client.field318.method2538(var0 + class41.field990);
            client.field318.method2539(class2.field37 + var1);
            client.field318.method2618(class137.field2135[82]?1:0);
            client.field318.method2492(var3);
         }

         if(1 == var2) {
            client.field402 = var5;
            client.field403 = var6;
            client.field405 = 2;
            client.field438 = 0;
            client.field533 = var0;
            client.field529 = var1;
            client.field318.method2757(247);
            client.field318.method2539(var3 >> 14 & 32767);
            client.field318.method2538(var1 + class2.field37);
            client.field318.method2539(class6.field137);
            client.field318.method2538(class41.field990 + var0);
            client.field318.method2539(class59.field1224);
            client.field318.method2618(class137.field2135[82]?1:0);
            client.field318.method2610(class41.field980);
         }

         if(41 == var2) {
            client.field318.method2757(92);
            client.field318.method2549(var1);
            client.field318.method2492(var3);
            client.field318.method2540(var0);
            client.field494 = 0;
            class52.field1167 = class52.method1115(var1);
            client.field407 = var0;
         }

         if(51 == var2) {
            var15 = client.field415[var3];
            if(var15 != null) {
               client.field402 = var5;
               client.field403 = var6;
               client.field405 = 2;
               client.field438 = 0;
               client.field533 = var0;
               client.field529 = var1;
               client.field318.method2757(126);
               client.field318.method2492(var3);
               client.field318.method2530(class137.field2135[82]?1:0);
            }
         }

         if(34 == var2) {
            client.field318.method2757(253);
            client.field318.method2610(var1);
            client.field318.method2492(var0);
            client.field318.method2540(var3);
            client.field494 = 0;
            class52.field1167 = class52.method1115(var1);
            client.field407 = var0;
         }

         if(var2 == 46) {
            var15 = client.field415[var3];
            if(null != var15) {
               client.field402 = var5;
               client.field403 = var6;
               client.field405 = 2;
               client.field438 = 0;
               client.field533 = var0;
               client.field529 = var1;
               client.field318.method2757(149);
               client.field318.method2573(class137.field2135[82]?1:0);
               client.field318.method2539(var3);
            }
         }

         if(38 == var2) {
            class188.method3761();
            var7 = class52.method1115(var1);
            client.field381 = 1;
            class59.field1224 = var0;
            class41.field980 = var1;
            class6.field137 = var3;
            class134.method2877(var7);
            client.field366 = class72.method1574(16748608) + class50.method1055(var3).field1122 + class72.method1574(16777215);
            if(null == client.field366) {
               client.field366 = "null";
            }

         } else {
            if(9 == var2) {
               var14 = client.field331[var3];
               if(var14 != null) {
                  client.field402 = var5;
                  client.field403 = var6;
                  client.field405 = 2;
                  client.field438 = 0;
                  client.field533 = var0;
                  client.field529 = var1;
                  client.field318.method2757(47);
                  client.field318.method2538(var3);
                  client.field318.method2618(class137.field2135[82]?1:0);
               }
            }

            if(35 == var2) {
               client.field318.method2757(179);
               client.field318.method2540(var3);
               client.field318.method2610(var1);
               client.field318.method2539(var0);
               client.field494 = 0;
               class52.field1167 = class52.method1115(var1);
               client.field407 = var0;
            }

            if(var2 == 30 && client.field458 == null) {
               client.field318.method2757(138);
               client.field318.method2549(var1);
               client.field318.method2540(var0);
               client.field458 = class157.method3195(var1, var0);
               class134.method2877(client.field458);
            }

            if(1005 == var2) {
               var7 = class52.method1115(var1);
               if(null != var7 && var7.field2886[var0] >= 100000) {
                  class103.method2289(27, "", var7.field2886[var0] + " x " + class50.method1055(var3).field1122);
               } else {
                  client.field318.method2757(86);
                  client.field318.method2492(var3);
               }

               client.field494 = 0;
               class52.field1167 = class52.method1115(var1);
               client.field407 = var0;
            }

            if(var2 == 13) {
               var14 = client.field331[var3];
               if(null != var14) {
                  client.field402 = var5;
                  client.field403 = var6;
                  client.field405 = 2;
                  client.field438 = 0;
                  client.field533 = var0;
                  client.field529 = var1;
                  client.field318.method2757(170);
                  client.field318.method2492(var3);
                  client.field318.method2573(class137.field2135[82]?1:0);
               }
            }

            if(var2 == 1001) {
               client.field402 = var5;
               client.field403 = var6;
               client.field405 = 2;
               client.field438 = 0;
               client.field533 = var0;
               client.field529 = var1;
               client.field318.method2757(80);
               client.field318.method2538(class2.field37 + var1);
               client.field318.method2539(class41.field990 + var0);
               client.field318.method2492(var3 >> 14 & 32767);
               client.field318.method2529(class137.field2135[82]?1:0);
            }

            if(var2 == 3) {
               client.field402 = var5;
               client.field403 = var6;
               client.field405 = 2;
               client.field438 = 0;
               client.field533 = var0;
               client.field529 = var1;
               client.field318.method2757(154);
               client.field318.method2492(var3 >> 14 & 32767);
               client.field318.method2540(class41.field990 + var0);
               client.field318.method2492(class2.field37 + var1);
               client.field318.method2573(class137.field2135[82]?1:0);
            }

            if(var2 == 14) {
               var15 = client.field415[var3];
               if(null != var15) {
                  client.field402 = var5;
                  client.field403 = var6;
                  client.field405 = 2;
                  client.field438 = 0;
                  client.field533 = var0;
                  client.field529 = var1;
                  client.field318.method2757(44);
                  client.field318.method2492(class59.field1224);
                  client.field318.method2610(class41.field980);
                  client.field318.method2540(var3);
                  client.field318.method2492(class6.field137);
                  client.field318.method2529(class137.field2135[82]?1:0);
               }
            }

            if(6 == var2) {
               client.field402 = var5;
               client.field403 = var6;
               client.field405 = 2;
               client.field438 = 0;
               client.field533 = var0;
               client.field529 = var1;
               client.field318.method2757(19);
               client.field318.method2530(class137.field2135[82]?1:0);
               client.field318.method2492(var3 >> 14 & 32767);
               client.field318.method2492(var0 + class41.field990);
               client.field318.method2538(class2.field37 + var1);
            }

            if(var2 == 26) {
               client.field318.method2757(243);

               for(class3 var23 = (class3)client.field455.method3805(); null != var23; var23 = (class3)client.field455.method3809()) {
                  if(0 == var23.field79 || var23.field79 == 3) {
                     class5.method93(var23, true);
                  }
               }

               if(null != client.field458) {
                  class134.method2877(client.field458);
                  client.field458 = null;
               }
            }

            if(var2 == 12) {
               var14 = client.field331[var3];
               if(null != var14) {
                  client.field402 = var5;
                  client.field403 = var6;
                  client.field405 = 2;
                  client.field438 = 0;
                  client.field533 = var0;
                  client.field529 = var1;
                  client.field318.method2757(251);
                  client.field318.method2530(class137.field2135[82]?1:0);
                  client.field318.method2540(var3);
               }
            }

            if(var2 == 40) {
               client.field318.method2757(241);
               client.field318.method2540(var0);
               client.field318.method2540(var3);
               client.field318.method2549(var1);
               client.field494 = 0;
               class52.field1167 = class52.method1115(var1);
               client.field407 = var0;
            }

            if(31 == var2) {
               client.field318.method2757(66);
               client.field318.method2620(var1);
               client.field318.method2538(var0);
               client.field318.method2539(var3);
               client.field318.method2492(class6.field137);
               client.field318.method2620(class41.field980);
               client.field318.method2538(class59.field1224);
               client.field494 = 0;
               class52.field1167 = class52.method1115(var1);
               client.field407 = var0;
            }

            if(var2 == 23) {
               class3.field75.method1945(class82.field1437, var0, var1);
            }

            if(4 == var2) {
               client.field402 = var5;
               client.field403 = var6;
               client.field405 = 2;
               client.field438 = 0;
               client.field533 = var0;
               client.field529 = var1;
               client.field318.method2757(231);
               client.field318.method2539(var0 + class41.field990);
               client.field318.method2492(var3 >> 14 & 32767);
               client.field318.method2618(class137.field2135[82]?1:0);
               client.field318.method2492(class2.field37 + var1);
            }

            if(36 == var2) {
               client.field318.method2757(125);
               client.field318.method2620(var1);
               client.field318.method2492(var0);
               client.field318.method2539(var3);
               client.field494 = 0;
               class52.field1167 = class52.method1115(var1);
               client.field407 = var0;
            }

            if(0 != client.field381) {
               client.field381 = 0;
               class134.method2877(class52.method1115(class41.field980));
            }

            if(client.field573) {
               class188.method3761();
            }

            if(class52.field1167 != null && 0 == client.field494) {
               class134.method2877(class52.field1167);
            }

         }
      }
   }
}
