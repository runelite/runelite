package net.runelite.rs.client;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.Socket;
import java.util.Iterator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("eu")
public final class class136 implements KeyListener, FocusListener {
   @ObfuscatedName("pt")
   @ObfuscatedGetter(
      intValue = -508910727
   )
   static int field2109;
   @ObfuscatedName("j")
   public static class136 field2113 = new class136();
   @ObfuscatedName("ha")
   @ObfuscatedGetter(
      intValue = -886181513
   )
   static int field2114;
   @ObfuscatedName("cv")
   public static boolean[] field2121 = new boolean[112];
   @ObfuscatedName("cu")
   @ObfuscatedGetter(
      intValue = -564358783
   )
   static int field2123 = 0;
   @ObfuscatedName("cl")
   @ObfuscatedGetter(
      intValue = 109604483
   )
   static int field2124 = 0;
   @ObfuscatedName("ct")
   static char[] field2125 = new char[128];
   @ObfuscatedName("cj")
   static int[] field2126 = new int[128];
   @ObfuscatedName("cy")
   public static int[] field2127 = new int[128];
   @ObfuscatedName("ci")
   @ObfuscatedGetter(
      intValue = -715764567
   )
   public static int field2128 = 0;
   @ObfuscatedName("ca")
   @ObfuscatedGetter(
      intValue = -1697013015
   )
   static int field2129 = 0;
   @ObfuscatedName("cz")
   @ObfuscatedGetter(
      intValue = -732304231
   )
   static int field2130 = 0;
   @ObfuscatedName("cf")
   @ObfuscatedGetter(
      intValue = -2060365197
   )
   static int field2131 = 0;
   @ObfuscatedName("cb")
   @ObfuscatedGetter(
      intValue = -431246817
   )
   public static volatile int field2132 = 0;
   @ObfuscatedName("ck")
   static int[] field2133 = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, 85, 80, 84, -1, 91, -1, -1, -1, 81, 82, 86, -1, -1, -1, -1, -1, -1, -1, -1, 13, -1, -1, -1, -1, 83, 104, 105, 103, 102, 96, 98, 97, 99, -1, -1, -1, -1, -1, -1, -1, 25, 16, 17, 18, 19, 20, 21, 22, 23, 24, -1, -1, -1, -1, -1, -1, -1, 48, 68, 66, 50, 34, 51, 52, 53, 39, 54, 55, 56, 70, 69, 40, 41, 32, 35, 49, 36, 38, 67, 33, 65, 37, 64, -1, -1, -1, -1, -1, 228, 231, 227, 233, 224, 219, 225, 230, 226, 232, 89, 87, -1, 88, 229, 90, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, -1, -1, -1, 101, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
   @ObfuscatedName("cd")
   static int[] field2134 = new int[128];

   public final synchronized void keyPressed(KeyEvent var1) {
      if(null != field2113) {
         field2132 = 0;
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field2133.length) {
            var2 = field2133[var2];
            if((var2 & 128) != 0) {
               var2 = -1;
            }
         } else {
            var2 = -1;
         }

         if(field2124 >= 0 && var2 >= 0) {
            field2134[field2124] = var2;
            field2124 = 1 + field2124 & 127;
            if(field2124 == field2123) {
               field2124 = -1;
            }
         }

         int var3;
         if(var2 >= 0) {
            var3 = field2130 + 1 & 127;
            if(var3 != field2129) {
               field2126[field2130] = var2;
               field2125[field2130] = 0;
               field2130 = var3;
            }
         }

         var3 = var1.getModifiers();
         if(0 != (var3 & 10) || 85 == var2 || var2 == 10) {
            var1.consume();
         }
      }

   }

   public final synchronized void keyReleased(KeyEvent var1) {
      if(field2113 != null) {
         field2132 = 0;
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field2133.length) {
            var2 = field2133[var2] & -129;
         } else {
            var2 = -1;
         }

         if(field2124 >= 0 && var2 >= 0) {
            field2134[field2124] = ~var2;
            field2124 = 1 + field2124 & 127;
            if(field2124 == field2123) {
               field2124 = -1;
            }
         }
      }

      var1.consume();
   }

   public final void keyTyped(KeyEvent var1) {
      if(null != field2113) {
         char var2 = var1.getKeyChar();
         if(0 != var2 && '\uffff' != var2 && class49.method1008(var2)) {
            int var3 = field2130 + 1 & 127;
            if(field2129 != var3) {
               field2126[field2130] = -1;
               field2125[field2130] = var2;
               field2130 = var3;
            }
         }
      }

      var1.consume();
   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(field2113 != null) {
         field2124 = -1;
      }

   }

   public final void focusGained(FocusEvent var1) {
   }

   @ObfuscatedName("i")
   static int method2856(class121 var0) {
      int var1 = var0.method2689(2);
      int var2;
      if(0 == var1) {
         var2 = 0;
      } else if(var1 == 1) {
         var2 = var0.method2689(5);
      } else if(2 == var1) {
         var2 = var0.method2689(8);
      } else {
         var2 = var0.method2689(11);
      }

      return var2;
   }

   @ObfuscatedName("i")
   static void method2869(class167 var0, int var1) {
      if(class15.field228 != null) {
         class15.field228.field1998 = 5 + var1 * 8;
         int var2 = class15.field228.method2458();
         int var3 = class15.field228.method2458();
         var0.method3294(var2, var3);
      } else {
         class108.method2378((class167)null, 255, 255, 0, (byte)0, true);
         class170.field2721[var1] = var0;
      }
   }

   @ObfuscatedName("s")
   static final void method2870() {
      try {
         if(client.field320 == 0) {
            if(class209.field3115 != null) {
               class209.field3115.method2948();
               class209.field3115 = null;
            }

            class150.field2262 = null;
            client.field304 = false;
            client.field570 = 0;
            client.field320 = 1;
         }

         if(client.field320 == 1) {
            if(null == class150.field2262) {
               class150.field2262 = class26.field648.method2811(class141.field2179, client.field572);
            }

            if(class150.field2262.field2222 == 2) {
               throw new IOException();
            }

            if(1 == class150.field2262.field2222) {
               class209.field3115 = new class142((Socket)class150.field2262.field2223, class26.field648);
               class150.field2262 = null;
               client.field320 = 2;
            }
         }

         if(client.field320 == 2) {
            client.field329.field1998 = 0;
            client.field329.method2438(14);
            class209.field3115.method2932(client.field329.field1995, 0, 1);
            client.field293.field1998 = 0;
            client.field320 = 3;
         }

         int var0;
         if(3 == client.field320) {
            if(class47.field1070 != null) {
               class47.field1070.method1199();
            }

            if(null != class77.field1403) {
               class77.field1403.method1199();
            }

            var0 = class209.field3115.method2929();
            if(class47.field1070 != null) {
               class47.field1070.method1199();
            }

            if(class77.field1403 != null) {
               class77.field1403.method1199();
            }

            if(0 != var0) {
               class18.method196(var0);
               return;
            }

            client.field293.field1998 = 0;
            client.field320 = 5;
         }

         int var1;
         int var2;
         if(5 == client.field320) {
            int[] var11 = new int[]{(int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D)};
            client.field329.field1998 = 0;
            client.field329.method2438(1);
            client.field329.method2438(class31.field733.vmethod3121());
            client.field329.method2441(var11[0]);
            client.field329.method2441(var11[1]);
            client.field329.method2441(var11[2]);
            client.field329.method2441(var11[3]);
            switch(class31.field733.field2606) {
            case 0:
            case 2:
               client.field329.method2457(class1.field21);
               client.field329.field1998 += 5;
               break;
            case 1:
               client.field329.method2441(((Integer)class10.field169.field145.get(Integer.valueOf(class15.method179(class31.field731)))).intValue());
               client.field329.field1998 += 4;
               break;
            case 3:
               client.field329.field1998 += 8;
            }

            client.field329.method2444(class31.field718);
            client.field329.method2624(class4.field73, class4.field76);
            client.field330.field1998 = 0;
            if(40 == client.field295) {
               client.field330.method2438(18);
            } else {
               client.field330.method2438(16);
            }

            client.field330.method2541(0);
            var1 = client.field330.field1998;
            client.field330.method2441(108);
            client.field330.method2447(client.field329.field1995, 0, client.field329.field1998);
            var2 = client.field330.field1998;
            client.field330.method2444(class31.field731);
            client.field330.method2438((client.field382?1:0) << 1 | (client.field457?1:0));
            client.field330.method2541(class142.field2190);
            client.field330.method2541(class89.field1566);
            class121 var3 = client.field330;
            byte[] var4 = new byte[24];

            int var5;
            try {
               class148.field2241.method4084(0L);
               class148.field2241.method4108(var4);

               for(var5 = 0; var5 < 24 && 0 == var4[var5]; ++var5) {
                  ;
               }

               if(var5 >= 24) {
                  throw new IOException();
               }
            } catch (Exception var9) {
               for(int var6 = 0; var6 < 24; ++var6) {
                  var4[var6] = -1;
               }
            }

            var3.method2447(var4, 0, 24);
            client.field330.method2444(class95.field1639);
            client.field330.method2441(class24.field624);
            class118 var19 = new class118(class98.field1693.method3129());
            class98.field1693.method3128(var19);
            client.field330.method2447(var19.field1995, 0, var19.field1995.length);
            client.field330.method2438(class164.field2669);
            client.field330.method2441(class10.field168.field2688);
            client.field330.method2441(class46.field1062.field2688);
            client.field330.method2441(class115.field1978.field2688);
            client.field330.method2441(class76.field1396.field2688);
            client.field330.method2441(class31.field740.field2688);
            client.field330.method2441(class24.field623.field2688);
            client.field330.method2441(class137.field2139.field2688);
            client.field330.method2441(class32.field757.field2688);
            client.field330.method2441(class157.field2595.field2688);
            client.field330.method2441(class108.field1915.field2688);
            client.field330.method2441(class95.field1640.field2688);
            client.field330.method2441(class97.field1669.field2688);
            client.field330.method2441(class160.field2649.field2688);
            client.field330.method2441(class182.field2958.field2688);
            client.field330.method2441(class161.field2652.field2688);
            client.field330.method2441(class0.field13.field2688);
            client.field330.method2445(var11, var2, client.field330.field1998);
            client.field330.method2514(client.field330.field1998 - var1);
            class209.field3115.method2932(client.field330.field1995, 0, client.field330.field1998);
            client.field329.method2685(var11);

            for(var5 = 0; var5 < 4; ++var5) {
               var11[var5] += 50;
            }

            client.field293.method2685(var11);
            client.field320 = 6;
         }

         if(client.field320 == 6 && class209.field3115.method2940() > 0) {
            var0 = class209.field3115.method2929();
            if(21 == var0 && client.field295 == 20) {
               client.field320 = 7;
            } else if(2 == var0) {
               client.field320 = 9;
            } else if(var0 == 15 && client.field295 == 40) {
               client.field332 = -1;
               client.field320 = 13;
            } else if(23 == var0 && client.field322 < 1) {
               ++client.field322;
               client.field320 = 0;
            } else {
               if(29 != var0) {
                  class18.method196(var0);
                  return;
               }

               client.field320 = 11;
            }
         }

         if(client.field320 == 7 && class209.field3115.method2940() > 0) {
            client.field323 = (class209.field3115.method2929() + 3) * 60;
            client.field320 = 8;
         }

         if(8 == client.field320) {
            client.field570 = 0;
            class3.method32("You have only just left another world.", "Your profile will be transferred in:", client.field323 / 60 + " seconds.");
            if(--client.field323 <= 0) {
               client.field320 = 0;
            }

         } else {
            if(client.field320 == 9 && class209.field3115.method2940() >= 13) {
               boolean var12 = class209.field3115.method2929() == 1;
               class209.field3115.method2931(client.field293.field1995, 0, 4);
               client.field293.field1998 = 0;
               boolean var13 = false;
               if(var12) {
                  var1 = client.field293.method2687() << 24;
                  var1 |= client.field293.method2687() << 16;
                  var1 |= client.field293.method2687() << 8;
                  var1 |= client.field293.method2687();
                  var2 = class15.method179(class31.field731);
                  if(class10.field169.field145.size() >= 10 && !class10.field169.field145.containsKey(Integer.valueOf(var2))) {
                     Iterator var18 = class10.field169.field145.entrySet().iterator();
                     var18.next();
                     var18.remove();
                  }

                  class10.field169.field145.put(Integer.valueOf(var2), Integer.valueOf(var1));
                  class3.method35();
               }

               client.field455 = class209.field3115.method2929();
               client.field520 = class209.field3115.method2929() == 1;
               client.field477 = class209.field3115.method2929();
               client.field477 <<= 8;
               client.field477 += class209.field3115.method2929();
               client.field412 = class209.field3115.method2929();
               class209.field3115.method2931(client.field293.field1995, 0, 1);
               client.field293.field1998 = 0;
               client.field333 = client.field293.method2687();
               class209.field3115.method2931(client.field293.field1995, 0, 2);
               client.field293.field1998 = 0;
               client.field332 = client.field293.method2455();
               if(client.field412 == 1) {
                  try {
                     class131.method2776(client.field284, "zap");
                  } catch (Throwable var8) {
                     ;
                  }
               } else {
                  try {
                     class131.method2776(client.field284, "unzap");
                  } catch (Throwable var7) {
                     ;
                  }
               }

               client.field320 = 10;
            }

            if(10 == client.field320) {
               if(class209.field3115.method2940() >= client.field332) {
                  client.field293.field1998 = 0;
                  class209.field3115.method2931(client.field293.field1995, 0, client.field332);
                  client.field298 = 1L;
                  client.field445 = -1;
                  class177.field2912.field205 = 0;
                  class50.field1106 = true;
                  client.field302 = true;
                  client.field514 = -1L;
                  class143.method2979();
                  client.field329.field1998 = 0;
                  client.field293.field1998 = 0;
                  client.field333 = -1;
                  client.field336 = 1;
                  client.field546 = -1;
                  client.field554 = -1;
                  client.field334 = 0;
                  client.field290 = 0;
                  client.field339 = 0;
                  client.field351 = 0;
                  client.field430 = 0;
                  client.field308 = false;
                  class139.field2170 = 0;
                  class11.field174.clear();
                  class11.field172.method3764();
                  class11.field173.method3798();
                  class11.field176 = 0;
                  client.field301 = 0;
                  client.field408 = false;
                  client.field530 = 0;
                  client.field283 = (int)(Math.random() * 100.0D) - 50;
                  client.field352 = (int)(Math.random() * 110.0D) - 55;
                  client.field354 = (int)(Math.random() * 80.0D) - 40;
                  client.field522 = (int)(Math.random() * 120.0D) - 60;
                  client.field359 = (int)(Math.random() * 30.0D) - 20;
                  client.field374 = (int)(Math.random() * 20.0D) - 10 & 2047;
                  client.field524 = 0;
                  client.field517 = 1;
                  client.field296 = 0;
                  client.field319 = 0;
                  client.field313 = class20.field579;
                  client.field357 = class20.field579;
                  client.field561 = 0;
                  class95.method2164();

                  for(var0 = 0; var0 < 2048; ++var0) {
                     client.field410[var0] = null;
                  }

                  for(var0 = 0; var0 < '耀'; ++var0) {
                     client.field324[var0] = null;
                  }

                  client.field419 = -1;
                  client.field422.method3767();
                  client.field423.method3767();

                  for(var0 = 0; var0 < 4; ++var0) {
                     for(var1 = 0; var1 < 104; ++var1) {
                        for(var2 = 0; var2 < 104; ++var2) {
                           client.field420[var0][var1][var2] = null;
                        }
                     }
                  }

                  client.field409 = new class198();
                  client.field386 = 0;
                  client.field421 = 0;
                  client.field559 = 0;

                  for(var0 = 0; var0 < class52.field1166; ++var0) {
                     class52 var21 = class7.method97(var0);
                     if(null != var21) {
                        class175.field2904[var0] = 0;
                        class175.field2906[var0] = 0;
                     }
                  }

                  class3.field63.method208();
                  client.field450 = -1;
                  if(-1 != client.field448) {
                     class4.method40(client.field448);
                  }

                  for(class3 var20 = (class3)client.field449.method3748(); null != var20; var20 = (class3)client.field449.method3747()) {
                     class4.method39(var20, true);
                  }

                  client.field448 = -1;
                  client.field449 = new class195(8);
                  client.field452 = null;
                  client.field308 = false;
                  client.field430 = 0;
                  client.field475.method3433((int[])null, new int[]{0, 0, 0, 0, 0}, false, -1);

                  for(var0 = 0; var0 < 8; ++var0) {
                     client.field416[var0] = null;
                     client.field348[var0] = false;
                  }

                  class113.method2397();
                  client.field316 = true;

                  for(var0 = 0; var0 < 100; ++var0) {
                     client.field493[var0] = true;
                  }

                  client.field329.method2686(179);
                  client.field329.method2438(class97.method2167());
                  client.field329.method2541(class142.field2190);
                  client.field329.method2541(class89.field1566);
                  client.field515 = null;
                  class10.field163 = 0;
                  class135.field2103 = null;

                  for(var0 = 0; var0 < 8; ++var0) {
                     client.field564[var0] = new class219();
                  }

                  class32.field760 = null;
                  class11.method145(client.field293);
                  class130.field2065 = -1;
                  class167.method3305(false);
                  client.field333 = -1;
               }

            } else {
               if(client.field320 == 11 && class209.field3115.method2940() >= 2) {
                  client.field293.field1998 = 0;
                  class209.field3115.method2931(client.field293.field1995, 0, 2);
                  client.field293.field1998 = 0;
                  class125.field2040 = client.field293.method2455();
                  client.field320 = 12;
               }

               if(client.field320 == 12 && class209.field3115.method2940() >= class125.field2040) {
                  client.field293.field1998 = 0;
                  class209.field3115.method2931(client.field293.field1995, 0, class125.field2040);
                  client.field293.field1998 = 0;
                  String var14 = client.field293.method2461();
                  String var16 = client.field293.method2461();
                  String var15 = client.field293.method2461();
                  class3.method32(var14, var16, var15);
                  client.method556(10);
               }

               if(client.field320 != 13) {
                  ++client.field570;
                  if(client.field570 > 2000) {
                     if(client.field322 < 1) {
                        if(client.field572 == class215.field3152) {
                           client.field572 = class6.field111;
                        } else {
                           client.field572 = class215.field3152;
                        }

                        ++client.field322;
                        client.field320 = 0;
                     } else {
                        class18.method196(-3);
                     }
                  }
               } else {
                  if(-1 == client.field332) {
                     if(class209.field3115.method2940() < 2) {
                        return;
                     }

                     class209.field3115.method2931(client.field293.field1995, 0, 2);
                     client.field293.field1998 = 0;
                     client.field332 = client.field293.method2455();
                  }

                  if(class209.field3115.method2940() >= client.field332) {
                     class209.field3115.method2931(client.field293.field1995, 0, client.field332);
                     client.field293.field1998 = 0;
                     var0 = client.field332;
                     client.field329.field1998 = 0;
                     client.field293.field1998 = 0;
                     client.field333 = -1;
                     client.field336 = 1;
                     client.field546 = -1;
                     client.field554 = -1;
                     client.field332 = 0;
                     client.field334 = 0;
                     client.field290 = 0;
                     client.field430 = 0;
                     client.field308 = false;
                     client.field524 = 0;
                     client.field296 = 0;

                     for(var1 = 0; var1 < 2048; ++var1) {
                        client.field410[var1] = null;
                     }

                     class148.field2249 = null;

                     for(var1 = 0; var1 < client.field324.length; ++var1) {
                        class34 var17 = client.field324[var1];
                        if(var17 != null) {
                           var17.field835 = -1;
                           var17.field836 = false;
                        }
                     }

                     class15.field225 = new class195(32);
                     client.method556(30);

                     for(var1 = 0; var1 < 100; ++var1) {
                        client.field493[var1] = true;
                     }

                     client.field329.method2686(179);
                     client.field329.method2438(class97.method2167());
                     client.field329.method2541(class142.field2190);
                     client.field329.method2541(class89.field1566);
                     class11.method145(client.field293);
                     if(var0 != client.field293.field1998) {
                        throw new RuntimeException();
                     }
                  }
               }
            }
         }
      } catch (IOException var10) {
         if(client.field322 < 1) {
            if(class215.field3152 == client.field572) {
               client.field572 = class6.field111;
            } else {
               client.field572 = class215.field3152;
            }

            ++client.field322;
            client.field320 = 0;
         } else {
            class18.method196(-2);
         }
      }
   }
}
