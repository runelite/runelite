package net.runelite.rs.client;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ei")
public final class class136 implements KeyListener, FocusListener {
   @ObfuscatedName("cl")
   static int[] field2091 = new int[128];
   @ObfuscatedName("cy")
   @ObfuscatedGetter(
      intValue = 923389805
   )
   public static volatile int field2094 = 0;
   @ObfuscatedName("cf")
   @ObfuscatedGetter(
      intValue = 170343485
   )
   public static int field2095;
   @ObfuscatedName("cu")
   static int[] field2098 = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, 85, 80, 84, -1, 91, -1, -1, -1, 81, 82, 86, -1, -1, -1, -1, -1, -1, -1, -1, 13, -1, -1, -1, -1, 83, 104, 105, 103, 102, 96, 98, 97, 99, -1, -1, -1, -1, -1, -1, -1, 25, 16, 17, 18, 19, 20, 21, 22, 23, 24, -1, -1, -1, -1, -1, -1, -1, 48, 68, 66, 50, 34, 51, 52, 53, 39, 54, 55, 56, 70, 69, 40, 41, 32, 35, 49, 36, 38, 67, 33, 65, 37, 64, -1, -1, -1, -1, -1, 228, 231, 227, 233, 224, 219, 225, 230, 226, 232, 89, 87, -1, 88, 229, 90, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, -1, -1, -1, 101, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
   @ObfuscatedName("j")
   public static class136 field2100 = new class136();
   @ObfuscatedName("qu")
   @ObfuscatedGetter(
      intValue = -1466720869
   )
   protected static int field2101;
   @ObfuscatedName("cr")
   @ObfuscatedGetter(
      intValue = -550937001
   )
   static int field2103 = 0;
   @ObfuscatedName("cj")
   @ObfuscatedGetter(
      intValue = -1068521109
   )
   public static int field2104 = 0;
   @ObfuscatedName("cg")
   static int[] field2105 = new int[128];
   @ObfuscatedName("ce")
   public static int[] field2107 = new int[128];
   @ObfuscatedName("ct")
   @ObfuscatedGetter(
      intValue = -1600310743
   )
   public static int field2108 = 0;
   @ObfuscatedName("cc")
   @ObfuscatedGetter(
      intValue = 563339815
   )
   static int field2109 = 0;
   @ObfuscatedName("ck")
   @ObfuscatedGetter(
      intValue = 869043655
   )
   static int field2110 = 0;
   @ObfuscatedName("cn")
   @ObfuscatedGetter(
      intValue = -272023037
   )
   static int field2111 = 0;
   @ObfuscatedName("cd")
   static char[] field2113 = new char[128];
   @ObfuscatedName("cx")
   public static boolean[] field2114 = new boolean[112];

   public final synchronized void keyReleased(KeyEvent var1) {
      if(field2100 != null) {
         field2094 = 0;
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field2098.length) {
            var2 = field2098[var2] & -129;
         } else {
            var2 = -1;
         }

         if(field2104 >= 0 && var2 >= 0) {
            field2105[field2104] = ~var2;
            field2104 = field2104 + 1 & 127;
            if(field2104 == field2103) {
               field2104 = -1;
            }
         }
      }

      var1.consume();
   }

   public final void focusGained(FocusEvent var1) {
   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(null != field2100) {
         field2104 = -1;
      }

   }

   public final synchronized void keyPressed(KeyEvent var1) {
      if(null != field2100) {
         field2094 = 0;
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field2098.length) {
            var2 = field2098[var2];
            if((var2 & 128) != 0) {
               var2 = -1;
            }
         } else {
            var2 = -1;
         }

         if(field2104 >= 0 && var2 >= 0) {
            field2105[field2104] = var2;
            field2104 = field2104 + 1 & 127;
            if(field2104 == field2103) {
               field2104 = -1;
            }
         }

         int var3;
         if(var2 >= 0) {
            var3 = 1 + field2110 & 127;
            if(field2109 != var3) {
               field2091[field2110] = var2;
               field2113[field2110] = 0;
               field2110 = var3;
            }
         }

         var3 = var1.getModifiers();
         if(0 != (var3 & 10) || var2 == 85 || 10 == var2) {
            var1.consume();
         }
      }

   }

   public final void keyTyped(KeyEvent var1) {
      if(field2100 != null) {
         char var2 = var1.getKeyChar();
         if(var2 != 0 && var2 != '\uffff' && class25.method669(var2)) {
            int var3 = 1 + field2110 & 127;
            if(field2109 != var3) {
               field2091[field2110] = -1;
               field2113[field2110] = var2;
               field2110 = var3;
            }
         }
      }

      var1.consume();
   }

   @ObfuscatedName("bh")
   static final void method2961(int var0, int var1, int var2, int var3, String var4, int var5, int var6) {
      if(var2 >= 2000) {
         var2 -= 2000;
      }

      if(var2 == 16) {
         client.field520 = var5;
         client.field399 = var6;
         client.field387 = 2;
         client.field361 = 0;
         client.field537 = var0;
         client.field294 = var1;
         client.field318.method2785(84);
         client.field318.method2578(class98.field1660);
         client.field318.method2730(class161.field2629 + var1);
         client.field318.method2730(var3);
         client.field318.method2521(field2114[82]?1:0);
         client.field318.method2730(class74.field1357);
         client.field318.method2567(class47.field1053 + var0);
         client.field318.method2522(class219.field3155);
      }

      class2 var7;
      if(var2 == 49) {
         var7 = client.field397[var3];
         if(var7 != null) {
            client.field520 = var5;
            client.field399 = var6;
            client.field387 = 2;
            client.field361 = 0;
            client.field537 = var0;
            client.field294 = var1;
            client.field318.method2785(62);
            client.field318.method2522(var3);
            client.field318.method2521(field2114[82]?1:0);
         }
      }

      class172 var15;
      if(58 == var2) {
         var15 = class214.method4009(var1, var0);
         if(var15 != null) {
            client.field318.method2785(36);
            client.field318.method2522(var0);
            client.field318.method2524(var1);
            client.field318.method2522(client.field379);
            client.field318.method2567(var15.field2852);
            client.field318.method2522(client.field355);
            client.field318.method2629(class77.field1386);
         }
      }

      if(36 == var2) {
         client.field318.method2785(247);
         client.field318.method2629(var1);
         client.field318.method2567(var3);
         client.field318.method2547(var0);
         client.field306 = 0;
         class10.field156 = class48.method1036(var1);
         client.field389 = var0;
      }

      class34 var16;
      if(var2 == 11) {
         var16 = client.field313[var3];
         if(var16 != null) {
            client.field520 = var5;
            client.field399 = var6;
            client.field387 = 2;
            client.field361 = 0;
            client.field537 = var0;
            client.field294 = var1;
            client.field318.method2785(51);
            client.field318.method2730(var3);
            client.field318.method2558(field2114[82]?1:0);
         }
      }

      int var8;
      if(29 == var2) {
         client.field318.method2785(90);
         client.field318.method2524(var1);
         var15 = class48.method1036(var1);
         if(var15.field2844 != null && var15.field2844[0][0] == 5) {
            var8 = var15.field2844[0][1];
            if(class175.field2884[var8] != var15.field2758[0]) {
               class175.field2884[var8] = var15.field2758[0];
               class132.method2896(var8);
            }
         }
      }

      if(var2 == 32) {
         client.field318.method2785(245);
         client.field318.method2629(var1);
         client.field318.method2577(class77.field1386);
         client.field318.method2567(var0);
         client.field318.method2547(var3);
         client.field318.method2730(client.field355);
         client.field306 = 0;
         class10.field156 = class48.method1036(var1);
         client.field389 = var0;
      }

      if(41 == var2) {
         client.field318.method2785(82);
         client.field318.method2730(var3);
         client.field318.method2567(var0);
         client.field318.method2578(var1);
         client.field306 = 0;
         class10.field156 = class48.method1036(var1);
         client.field389 = var0;
      }

      if(12 == var2) {
         var16 = client.field313[var3];
         if(null != var16) {
            client.field520 = var5;
            client.field399 = var6;
            client.field387 = 2;
            client.field361 = 0;
            client.field537 = var0;
            client.field294 = var1;
            client.field318.method2785(83);
            client.field318.method2632(field2114[82]?1:0);
            client.field318.method2730(var3);
         }
      }

      if(13 == var2) {
         var16 = client.field313[var3];
         if(var16 != null) {
            client.field520 = var5;
            client.field399 = var6;
            client.field387 = 2;
            client.field361 = 0;
            client.field537 = var0;
            client.field294 = var1;
            client.field318.method2785(233);
            client.field318.method2558(field2114[82]?1:0);
            client.field318.method2522(var3);
         }
      }

      if(8 == var2) {
         var16 = client.field313[var3];
         if(var16 != null) {
            client.field520 = var5;
            client.field399 = var6;
            client.field387 = 2;
            client.field361 = 0;
            client.field537 = var0;
            client.field294 = var1;
            client.field318.method2785(108);
            client.field318.method2629(class77.field1386);
            client.field318.method2522(client.field355);
            client.field318.method2558(field2114[82]?1:0);
            client.field318.method2730(var3);
         }
      }

      if(20 == var2) {
         client.field520 = var5;
         client.field399 = var6;
         client.field387 = 2;
         client.field361 = 0;
         client.field537 = var0;
         client.field294 = var1;
         client.field318.method2785(206);
         client.field318.method2547(class47.field1053 + var0);
         client.field318.method2522(class161.field2629 + var1);
         client.field318.method2632(field2114[82]?1:0);
         client.field318.method2730(var3);
      }

      if(var2 == 1004) {
         client.field520 = var5;
         client.field399 = var6;
         client.field387 = 2;
         client.field361 = 0;
         client.field318.method2785(104);
         client.field318.method2567(var3);
      }

      if(var2 == 21) {
         client.field520 = var5;
         client.field399 = var6;
         client.field387 = 2;
         client.field361 = 0;
         client.field537 = var0;
         client.field294 = var1;
         client.field318.method2785(253);
         client.field318.method2730(var1 + class161.field2629);
         client.field318.method2567(var3);
         client.field318.method2632(field2114[82]?1:0);
         client.field318.method2730(class47.field1053 + var0);
      }

      if(var2 == 30 && client.field545 == null) {
         class97.method2214(var1, var0);
         client.field545 = class214.method4009(var1, var0);
         class42.method942(client.field545);
      }

      if(var2 == 9) {
         var16 = client.field313[var3];
         if(var16 != null) {
            client.field520 = var5;
            client.field399 = var6;
            client.field387 = 2;
            client.field361 = 0;
            client.field537 = var0;
            client.field294 = var1;
            client.field318.method2785(95);
            client.field318.method2730(var3);
            client.field318.method2632(field2114[82]?1:0);
         }
      }

      if(26 == var2) {
         class20.method596();
      }

      if(var2 == 1002) {
         client.field520 = var5;
         client.field399 = var6;
         client.field387 = 2;
         client.field361 = 0;
         client.field318.method2785(157);
         client.field318.method2730(var3 >> 14 & 32767);
      }

      int var13;
      if(var2 == 57 || var2 == 1007) {
         var15 = class214.method4009(var1, var0);
         if(null != var15) {
            var8 = var15.field2852;
            class172 var9 = class214.method4009(var1, var0);
            if(null != var9) {
               if(var9.field2766 != null) {
                  class0 var10 = new class0();
                  var10.field2 = var9;
                  var10.field16 = var3;
                  var10.field6 = var4;
                  var10.field10 = var9.field2766;
                  class171.method3458(var10);
               }

               boolean var19 = true;
               if(var9.field2738 > 0) {
                  var19 = class148.method3181(var9);
               }

               if(var19) {
                  int var12 = class7.method126(var9);
                  var13 = var3 - 1;
                  boolean var11 = 0 != (var12 >> var13 + 1 & 1);
                  if(var11) {
                     if(var3 == 1) {
                        client.field318.method2785(65);
                        client.field318.method2524(var1);
                        client.field318.method2522(var0);
                        client.field318.method2522(var8);
                     }

                     if(2 == var3) {
                        client.field318.method2785(238);
                        client.field318.method2524(var1);
                        client.field318.method2522(var0);
                        client.field318.method2522(var8);
                     }

                     if(var3 == 3) {
                        client.field318.method2785(222);
                        client.field318.method2524(var1);
                        client.field318.method2522(var0);
                        client.field318.method2522(var8);
                     }

                     if(4 == var3) {
                        client.field318.method2785(165);
                        client.field318.method2524(var1);
                        client.field318.method2522(var0);
                        client.field318.method2522(var8);
                     }

                     if(var3 == 5) {
                        client.field318.method2785(185);
                        client.field318.method2524(var1);
                        client.field318.method2522(var0);
                        client.field318.method2522(var8);
                     }

                     if(var3 == 6) {
                        client.field318.method2785(224);
                        client.field318.method2524(var1);
                        client.field318.method2522(var0);
                        client.field318.method2522(var8);
                     }

                     if(var3 == 7) {
                        client.field318.method2785(252);
                        client.field318.method2524(var1);
                        client.field318.method2522(var0);
                        client.field318.method2522(var8);
                     }

                     if(8 == var3) {
                        client.field318.method2785(159);
                        client.field318.method2524(var1);
                        client.field318.method2522(var0);
                        client.field318.method2522(var8);
                     }

                     if(var3 == 9) {
                        client.field318.method2785(47);
                        client.field318.method2524(var1);
                        client.field318.method2522(var0);
                        client.field318.method2522(var8);
                     }

                     if(10 == var3) {
                        client.field318.method2785(111);
                        client.field318.method2524(var1);
                        client.field318.method2522(var0);
                        client.field318.method2522(var8);
                     }
                  }
               }
            }
         }
      }

      if(38 == var2) {
         class23.method637();
         var15 = class48.method1036(var1);
         client.field398 = 1;
         class219.field3155 = var0;
         class98.field1660 = var1;
         class74.field1357 = var3;
         class42.method942(var15);
         client.field428 = class74.method1617(16748608) + class10.method158(var3).field1099 + class74.method1617(16777215);
         if(client.field428 == null) {
            client.field428 = "null";
         }

      } else {
         if(48 == var2) {
            var7 = client.field397[var3];
            if(null != var7) {
               client.field520 = var5;
               client.field399 = var6;
               client.field387 = 2;
               client.field361 = 0;
               client.field537 = var0;
               client.field294 = var1;
               client.field318.method2785(109);
               client.field318.method2667(field2114[82]?1:0);
               client.field318.method2567(var3);
            }
         }

         if(var2 == 46) {
            var7 = client.field397[var3];
            if(var7 != null) {
               client.field520 = var5;
               client.field399 = var6;
               client.field387 = 2;
               client.field361 = 0;
               client.field537 = var0;
               client.field294 = var1;
               client.field318.method2785(85);
               client.field318.method2558(field2114[82]?1:0);
               client.field318.method2547(var3);
            }
         }

         if(50 == var2) {
            var7 = client.field397[var3];
            if(null != var7) {
               client.field520 = var5;
               client.field399 = var6;
               client.field387 = 2;
               client.field361 = 0;
               client.field537 = var0;
               client.field294 = var1;
               client.field318.method2785(55);
               client.field318.method2558(field2114[82]?1:0);
               client.field318.method2567(var3);
            }
         }

         if(var2 == 5) {
            client.field520 = var5;
            client.field399 = var6;
            client.field387 = 2;
            client.field361 = 0;
            client.field537 = var0;
            client.field294 = var1;
            client.field318.method2785(188);
            client.field318.method2567(var3 >> 14 & 32767);
            client.field318.method2567(var0 + class47.field1053);
            client.field318.method2632(field2114[82]?1:0);
            client.field318.method2547(var1 + class161.field2629);
         }

         if(var2 == 3) {
            client.field520 = var5;
            client.field399 = var6;
            client.field387 = 2;
            client.field361 = 0;
            client.field537 = var0;
            client.field294 = var1;
            client.field318.method2785(219);
            client.field318.method2567(class161.field2629 + var1);
            client.field318.method2730(var0 + class47.field1053);
            client.field318.method2558(field2114[82]?1:0);
            client.field318.method2522(var3 >> 14 & 32767);
         }

         if(34 == var2) {
            client.field318.method2785(53);
            client.field318.method2730(var0);
            client.field318.method2629(var1);
            client.field318.method2547(var3);
            client.field306 = 0;
            class10.field156 = class48.method1036(var1);
            client.field389 = var0;
         }

         if(19 == var2) {
            client.field520 = var5;
            client.field399 = var6;
            client.field387 = 2;
            client.field361 = 0;
            client.field537 = var0;
            client.field294 = var1;
            client.field318.method2785(105);
            client.field318.method2547(var3);
            client.field318.method2522(class47.field1053 + var0);
            client.field318.method2567(var1 + class161.field2629);
            client.field318.method2558(field2114[82]?1:0);
         }

         if(37 == var2) {
            client.field318.method2785(7);
            client.field318.method2547(var3);
            client.field318.method2730(var0);
            client.field318.method2524(var1);
            client.field306 = 0;
            class10.field156 = class48.method1036(var1);
            client.field389 = var0;
         }

         if(var2 == 18) {
            client.field520 = var5;
            client.field399 = var6;
            client.field387 = 2;
            client.field361 = 0;
            client.field537 = var0;
            client.field294 = var1;
            client.field318.method2785(195);
            client.field318.method2667(field2114[82]?1:0);
            client.field318.method2522(class161.field2629 + var1);
            client.field318.method2547(class47.field1053 + var0);
            client.field318.method2547(var3);
         }

         if(var2 == 15) {
            var7 = client.field397[var3];
            if(var7 != null) {
               client.field520 = var5;
               client.field399 = var6;
               client.field387 = 2;
               client.field361 = 0;
               client.field537 = var0;
               client.field294 = var1;
               client.field318.method2785(243);
               client.field318.method2522(client.field355);
               client.field318.method2522(var3);
               client.field318.method2521(field2114[82]?1:0);
               client.field318.method2578(class77.field1386);
            }
         }

         if(var2 == 22) {
            client.field520 = var5;
            client.field399 = var6;
            client.field387 = 2;
            client.field361 = 0;
            client.field537 = var0;
            client.field294 = var1;
            client.field318.method2785(194);
            client.field318.method2522(class47.field1053 + var0);
            client.field318.method2522(var3);
            client.field318.method2567(var1 + class161.field2629);
            client.field318.method2632(field2114[82]?1:0);
         }

         if(42 == var2) {
            client.field318.method2785(173);
            client.field318.method2567(var3);
            client.field318.method2547(var0);
            client.field318.method2578(var1);
            client.field306 = 0;
            class10.field156 = class48.method1036(var1);
            client.field389 = var0;
         }

         if(47 == var2) {
            var7 = client.field397[var3];
            if(null != var7) {
               client.field520 = var5;
               client.field399 = var6;
               client.field387 = 2;
               client.field361 = 0;
               client.field537 = var0;
               client.field294 = var1;
               client.field318.method2785(67);
               client.field318.method2632(field2114[82]?1:0);
               client.field318.method2567(var3);
            }
         }

         if(14 == var2) {
            var7 = client.field397[var3];
            if(var7 != null) {
               client.field520 = var5;
               client.field399 = var6;
               client.field387 = 2;
               client.field361 = 0;
               client.field537 = var0;
               client.field294 = var1;
               client.field318.method2785(220);
               client.field318.method2547(class219.field3155);
               client.field318.method2524(class98.field1660);
               client.field318.method2730(var3);
               client.field318.method2558(field2114[82]?1:0);
               client.field318.method2567(class74.field1357);
            }
         }

         if(var2 == 10) {
            var16 = client.field313[var3];
            if(null != var16) {
               client.field520 = var5;
               client.field399 = var6;
               client.field387 = 2;
               client.field361 = 0;
               client.field537 = var0;
               client.field294 = var1;
               client.field318.method2785(200);
               client.field318.method2667(field2114[82]?1:0);
               client.field318.method2547(var3);
            }
         }

         if(39 == var2) {
            client.field318.method2785(56);
            client.field318.method2730(var3);
            client.field318.method2522(var0);
            client.field318.method2629(var1);
            client.field306 = 0;
            class10.field156 = class48.method1036(var1);
            client.field389 = var0;
         }

         if(var2 == 51) {
            var7 = client.field397[var3];
            if(var7 != null) {
               client.field520 = var5;
               client.field399 = var6;
               client.field387 = 2;
               client.field361 = 0;
               client.field537 = var0;
               client.field294 = var1;
               client.field318.method2785(73);
               client.field318.method2521(field2114[82]?1:0);
               client.field318.method2730(var3);
            }
         }

         if(var2 == 6) {
            client.field520 = var5;
            client.field399 = var6;
            client.field387 = 2;
            client.field361 = 0;
            client.field537 = var0;
            client.field294 = var1;
            client.field318.method2785(41);
            client.field318.method2521(field2114[82]?1:0);
            client.field318.method2522(var3 >> 14 & 32767);
            client.field318.method2547(var0 + class47.field1053);
            client.field318.method2730(class161.field2629 + var1);
         }

         if(var2 == 1) {
            client.field520 = var5;
            client.field399 = var6;
            client.field387 = 2;
            client.field361 = 0;
            client.field537 = var0;
            client.field294 = var1;
            client.field318.method2785(204);
            client.field318.method2522(var3 >> 14 & 32767);
            client.field318.method2547(var1 + class161.field2629);
            client.field318.method2522(var0 + class47.field1053);
            client.field318.method2522(class74.field1357);
            client.field318.method2730(class219.field3155);
            client.field318.method2632(field2114[82]?1:0);
            client.field318.method2577(class98.field1660);
         }

         if(23 == var2) {
            class24.field610.method1969(class8.field134, var0, var1);
         }

         if(var2 == 40) {
            client.field318.method2785(5);
            client.field318.method2567(var0);
            client.field318.method2577(var1);
            client.field318.method2730(var3);
            client.field306 = 0;
            class10.field156 = class48.method1036(var1);
            client.field389 = var0;
         }

         if(var2 == 45) {
            var7 = client.field397[var3];
            if(null != var7) {
               client.field520 = var5;
               client.field399 = var6;
               client.field387 = 2;
               client.field361 = 0;
               client.field537 = var0;
               client.field294 = var1;
               client.field318.method2785(153);
               client.field318.method2547(var3);
               client.field318.method2632(field2114[82]?1:0);
            }
         }

         if(var2 == 31) {
            client.field318.method2785(70);
            client.field318.method2730(class74.field1357);
            client.field318.method2524(class98.field1660);
            client.field318.method2567(class219.field3155);
            client.field318.method2567(var3);
            client.field318.method2547(var0);
            client.field318.method2524(var1);
            client.field306 = 0;
            class10.field156 = class48.method1036(var1);
            client.field389 = var0;
         }

         if(17 == var2) {
            client.field520 = var5;
            client.field399 = var6;
            client.field387 = 2;
            client.field361 = 0;
            client.field537 = var0;
            client.field294 = var1;
            client.field318.method2785(234);
            client.field318.method2730(var3);
            client.field318.method2667(field2114[82]?1:0);
            client.field318.method2629(class77.field1386);
            client.field318.method2730(client.field355);
            client.field318.method2522(var0 + class47.field1053);
            client.field318.method2730(var1 + class161.field2629);
         }

         if(var2 == 28) {
            client.field318.method2785(90);
            client.field318.method2524(var1);
            var15 = class48.method1036(var1);
            if(null != var15.field2844 && 5 == var15.field2844[0][0]) {
               var8 = var15.field2844[0][1];
               class175.field2884[var8] = 1 - class175.field2884[var8];
               class132.method2896(var8);
            }
         }

         if(33 == var2) {
            client.field318.method2785(133);
            client.field318.method2547(var0);
            client.field318.method2547(var3);
            client.field318.method2578(var1);
            client.field306 = 0;
            class10.field156 = class48.method1036(var1);
            client.field389 = var0;
         }

         if(var2 == 4) {
            client.field520 = var5;
            client.field399 = var6;
            client.field387 = 2;
            client.field361 = 0;
            client.field537 = var0;
            client.field294 = var1;
            client.field318.method2785(178);
            client.field318.method2632(field2114[82]?1:0);
            client.field318.method2730(class47.field1053 + var0);
            client.field318.method2547(var1 + class161.field2629);
            client.field318.method2547(var3 >> 14 & 32767);
         }

         if(var2 == 1005) {
            var15 = class48.method1036(var1);
            if(var15 != null && var15.field2851[var0] >= 100000) {
               class50.method1063(27, "", var15.field2851[var0] + " x " + class10.method158(var3).field1099);
            } else {
               client.field318.method2785(104);
               client.field318.method2567(var3);
            }

            client.field306 = 0;
            class10.field156 = class48.method1036(var1);
            client.field389 = var0;
         }

         if(7 == var2) {
            var16 = client.field313[var3];
            if(var16 != null) {
               client.field520 = var5;
               client.field399 = var6;
               client.field387 = 2;
               client.field361 = 0;
               client.field537 = var0;
               client.field294 = var1;
               client.field318.method2785(156);
               client.field318.method2730(class219.field3155);
               client.field318.method2667(field2114[82]?1:0);
               client.field318.method2547(var3);
               client.field318.method2547(class74.field1357);
               client.field318.method2578(class98.field1660);
            }
         }

         if(1001 == var2) {
            client.field520 = var5;
            client.field399 = var6;
            client.field387 = 2;
            client.field361 = 0;
            client.field537 = var0;
            client.field294 = var1;
            client.field318.method2785(126);
            client.field318.method2667(field2114[82]?1:0);
            client.field318.method2567(class161.field2629 + var1);
            client.field318.method2547(var3 >> 14 & 32767);
            client.field318.method2547(class47.field1053 + var0);
         }

         if(44 == var2) {
            var7 = client.field397[var3];
            if(null != var7) {
               client.field520 = var5;
               client.field399 = var6;
               client.field387 = 2;
               client.field361 = 0;
               client.field537 = var0;
               client.field294 = var1;
               client.field318.method2785(91);
               client.field318.method2558(field2114[82]?1:0);
               client.field318.method2567(var3);
            }
         }

         if(var2 == 2) {
            client.field520 = var5;
            client.field399 = var6;
            client.field387 = 2;
            client.field361 = 0;
            client.field537 = var0;
            client.field294 = var1;
            client.field318.method2785(182);
            client.field318.method2521(field2114[82]?1:0);
            client.field318.method2522(var1 + class161.field2629);
            client.field318.method2522(var3 >> 14 & 32767);
            client.field318.method2522(client.field355);
            client.field318.method2578(class77.field1386);
            client.field318.method2522(class47.field1053 + var0);
         }

         if(43 == var2) {
            client.field318.method2785(237);
            client.field318.method2730(var0);
            client.field318.method2629(var1);
            client.field318.method2547(var3);
            client.field306 = 0;
            class10.field156 = class48.method1036(var1);
            client.field389 = var0;
         }

         if(var2 == 24) {
            var15 = class48.method1036(var1);
            boolean var17 = true;
            if(var15.field2738 > 0) {
               var17 = class148.method3181(var15);
            }

            if(var17) {
               client.field318.method2785(90);
               client.field318.method2524(var1);
            }
         }

         if(var2 == 35) {
            client.field318.method2785(148);
            client.field318.method2629(var1);
            client.field318.method2547(var3);
            client.field318.method2730(var0);
            client.field306 = 0;
            class10.field156 = class48.method1036(var1);
            client.field389 = var0;
         }

         if(25 != var2) {
            if(1003 == var2) {
               client.field520 = var5;
               client.field399 = var6;
               client.field387 = 2;
               client.field361 = 0;
               var16 = client.field313[var3];
               if(null != var16) {
                  class39 var18 = var16.field761;
                  if(var18.field895 != null) {
                     var18 = var18.method813();
                  }

                  if(var18 != null) {
                     client.field318.method2785(117);
                     client.field318.method2730(var18.field869);
                  }
               }
            }

            if(client.field398 != 0) {
               client.field398 = 0;
               class42.method942(class48.method1036(class98.field1660));
            }

            if(client.field546) {
               class23.method637();
            }

            if(null != class10.field156 && client.field306 == 0) {
               class42.method942(class10.field156);
            }

         } else {
            var15 = class214.method4009(var1, var0);
            if(var15 != null) {
               class23.method637();
               int var20 = class7.method126(var15);
               int var21 = var20 >> 11 & 63;
               class17.method212(var1, var0, var21, var15.field2852);
               client.field398 = 0;
               int var14 = class7.method126(var15);
               var13 = var14 >> 11 & 63;
               String var22;
               if(var13 == 0) {
                  var22 = null;
               } else if(var15.field2811 != null && var15.field2811.trim().length() != 0) {
                  var22 = var15.field2811;
               } else {
                  var22 = null;
               }

               client.field432 = var22;
               if(client.field432 == null) {
                  client.field432 = "Null";
               }

               if(var15.field2733) {
                  client.field433 = var15.field2805 + class74.method1617(16777215);
               } else {
                  client.field433 = class74.method1617('\uff00') + var15.field2848 + class74.method1617(16777215);
               }
            }

         }
      }
   }
}
